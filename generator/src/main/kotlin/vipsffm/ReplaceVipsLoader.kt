package vipsffm

import java.nio.file.Files
import java.nio.file.Path

object ReplaceVipsLoader {

    @JvmStatic fun main(args: Array<String>) {
        val vipsRawPath = Path.of("core/src/main/java/app/photofox/vipsffm/jextract/VipsRaw.java")

        val content = String(Files.readAllBytes(vipsRawPath), Charsets.UTF_8)
            .replace(
                "SymbolLookup.libraryLookup(System.mapLibraryName(\"vips\"), LIBRARY_ARENA)",
                "VipsLibLookup.buildSymbolLoader(LIBRARY_ARENA)"
            )
            .replace(
                "package app.photofox.vipsffm.jextract;\n\n",
                "package app.photofox.vipsffm.jextract;\nimport app.photofox.vipsffm.VipsLibLookup;\n\n",
            )
        Files.write(vipsRawPath, content.toByteArray(Charsets.UTF_8))
    }
}