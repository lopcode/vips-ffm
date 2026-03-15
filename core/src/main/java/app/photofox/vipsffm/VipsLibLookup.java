package app.photofox.vipsffm;

import java.lang.foreign.Arena;
import java.lang.foreign.SymbolLookup;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class VipsLibLookup {

    public static SymbolLookup buildSymbolLoader(Arena arena) {
        var vipsLoader = findVipsLoader(arena);
        if (vipsLoader == null) {
            throw new UnsatisfiedLinkError("could not make loader for libvips");
        }
        var glibLoader = findGlibLoader(arena);
        if (glibLoader == null) {
            throw new UnsatisfiedLinkError("could not make loader for glib");
        }
        var gobjectLoader = findGObjectLoader(arena);
        if (gobjectLoader == null) {
            throw new UnsatisfiedLinkError("could not make loader for gobject");
        }

        return vipsLoader.or(glibLoader).or(gobjectLoader);
    }

    private static SymbolLookup findVipsLoader(Arena arena) {
        var overrideLookup = makeOptionalLibraryLookup("vips", arena);
        if (overrideLookup.isPresent()) {
            return overrideLookup.get();
        }
        var abiNumber = Optional.ofNullable(System.getProperty("vipsffm.abinumber.vips.override"))
            .orElse("42");
        var names = List.of(
            new SymbolLookupSpec("vips", true), // default unix-like
            new SymbolLookupSpec("vips." + abiNumber, true), // some linux systems don't symlink and need abi number
            new SymbolLookupSpec("libvips.so." + abiNumber, false), // some linux runtime libs use the lib.so.abiNumber format
            new SymbolLookupSpec("libvips-" + abiNumber, true) // windows needs everything
        );
        return findFirstSymbolLookup(arena, names);
    }

    private static SymbolLookup findGlibLoader(Arena arena) {
        var overrideLookup = makeOptionalLibraryLookup("glib", arena);
        if (overrideLookup.isPresent()) {
            return overrideLookup.get();
        }
        var abiNumber = Optional.ofNullable(System.getProperty("vipsffm.abinumber.glib.override"))
            .orElse("0");
        var names = List.of(
            new SymbolLookupSpec("glib-2.0", true), // default unix-like
            new SymbolLookupSpec("glib-2.0." + abiNumber, true), // some linux systems don't symlink and need abi number
            new SymbolLookupSpec("libglib-2.0.so." + abiNumber, false), // some linux runtime libs use the lib.so.abiNumber format
            new SymbolLookupSpec("libglib-2.0-" + abiNumber, true) // windows needs everything
        );
        return findFirstSymbolLookup(arena, names);
    }

    private static SymbolLookup findGObjectLoader(Arena arena) {
        var overrideLookup = makeOptionalLibraryLookup("gobject", arena);
        if (overrideLookup.isPresent()) {
            return overrideLookup.get();
        }
        var abiNumber = Optional.ofNullable(System.getProperty("vipsffm.abinumber.gobject.override"))
            .orElse("0");
        var names = List.of(
            new SymbolLookupSpec("gobject-2.0", true), // default unix-like
            new SymbolLookupSpec("gobject-2.0." + abiNumber, true), // some linux systems don't symlink and need abi number
            new SymbolLookupSpec("libgobject-2.0.so." + abiNumber, false), // some linux runtime libs use the lib.so.abiNumber format
            new SymbolLookupSpec("libgobject-2.0-" + abiNumber, true) // windows needs everything
        );
        return findFirstSymbolLookup(arena, names);
    }

    private record SymbolLookupSpec(
        String name,
        boolean mapToSystemName
    ) {}

    private static SymbolLookup findFirstSymbolLookup(
        Arena arena,
        List<SymbolLookupSpec> specs
    ) {
        for (var spec : specs) {
            var attempt = attemptLibraryLookup(spec.name, arena, spec.mapToSystemName);
            if (attempt.isPresent()) {
                return attempt.get();
            }
        }
        return null;
    }

    static Optional<SymbolLookup> attemptLibraryLookup(String name, Arena arena, boolean useSystemNaming) {
        var libraryName = name;
        if (useSystemNaming) {
            libraryName = System.mapLibraryName(libraryName);
        }
        try {
            return Optional.of(
                SymbolLookup.libraryLookup(libraryName, arena)
            );
        } catch (IllegalArgumentException _) {
            return Optional.empty();
        }
    }

    private static Optional<SymbolLookup> makeOptionalLibraryLookup(String libraryName, Arena arena) {
        var propertyPath = "vipsffm.libpath.%s.override".formatted(libraryName);
        var overridePath = Optional.ofNullable(System.getProperty(propertyPath));
        return overridePath.map(path -> {
            SymbolLookup symbolLookup;
            try {
                symbolLookup = SymbolLookup.libraryLookup(Path.of(path), arena);
            } catch (IllegalArgumentException exception) {
                throw makeLibraryAtPathNotValidException(libraryName, path, exception);
            }
            return symbolLookup;
        });
    }

    private static IllegalArgumentException makeLibraryAtPathNotValidException(
        String libraryName,
        String overridePath,
        Throwable cause
    ) {
        var message = "path override requested for %s, but library not valid at path: %s".formatted(libraryName, overridePath);
        return new IllegalArgumentException(message, cause);
    }
}
