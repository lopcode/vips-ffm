package app.photofox.vipsffm;

import java.lang.foreign.Arena;
import java.lang.foreign.SymbolLookup;
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
        var abiNumber = Optional.ofNullable(System.getProperty("vipsffm.abinumber.vips.override"))
                .orElse("42");
        var names = List.of(
            "vips", // default unix-like
            "vips." + abiNumber, // some linux systems don't symlink and need abi number
            "libvips-" + abiNumber // windows needs everything
        );
        for (var name : names) {
            var attempt = attemptLibraryLookup(name, arena);
            if (attempt.isPresent()) {
                return attempt.get();
            }
        }
        return null;
    }

    private static SymbolLookup findGlibLoader(Arena arena) {
        var abiNumber = Optional.ofNullable(System.getProperty("vipsffm.abinumber.glib.override"))
                .orElse("0");
        var names = List.of(
                "glib-2.0", // default unix-like
                "glib-2.0." + abiNumber, // some linux systems don't symlink and need abi number
                "libglib-2.0-" + abiNumber // windows needs everything
        );
        for (var name : names) {
            var attempt = attemptLibraryLookup(name, arena);
            if (attempt.isPresent()) {
                return attempt.get();
            }
        }
        return null;
    }

    private static SymbolLookup findGObjectLoader(Arena arena) {
        var abiNumber = Optional.ofNullable(System.getProperty("vipsffm.abinumber.gobject.override"))
                .orElse("0");
        var names = List.of(
                "gobject-2.0", // default unix-like
                "gobject-2.0." + abiNumber, // some linux systems don't symlink and need abi number
                "libgobject-2.0-" + abiNumber // windows needs everything
        );
        for (var name : names) {
            var attempt = attemptLibraryLookup(name, arena);
            if (attempt.isPresent()) {
                return attempt.get();
            }
        }
        return null;
    }

    static Optional<SymbolLookup> attemptLibraryLookup(String name, Arena arena) {
        try {
            return Optional.of(
                SymbolLookup.libraryLookup(System.mapLibraryName(name), arena)
            );
        } catch (IllegalArgumentException _) {
            return Optional.empty();
        }
    }
}
