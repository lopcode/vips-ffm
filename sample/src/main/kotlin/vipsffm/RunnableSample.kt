package vipsffm

import java.lang.foreign.Arena
import java.nio.file.Path

interface RunnableSample {

    fun run(arena: Arena, workingDirectory: Path): Result<Unit>
}
