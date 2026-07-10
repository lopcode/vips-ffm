package vipsffm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReplaceVipsLoader {

    public static void main(String[] args) throws IOException {
        var vipsRawPath = Path.of("core/src/main/java/app/photofox/vipsffm/jextract/VipsRaw.java");

        var content = Files.readString(vipsRawPath)
            .replace(
                "SymbolLookup.libraryLookup(System.mapLibraryName(\"vips\"), LIBRARY_ARENA)",
                "VipsLibLookup.buildSymbolLoader(LIBRARY_ARENA)"
            )
            .replace(
                "package app.photofox.vipsffm.jextract;\n\n",
                "package app.photofox.vipsffm.jextract;\nimport app.photofox.vipsffm.VipsLibLookup;\n\n"
            );
        Files.writeString(vipsRawPath, content);
    }
}
