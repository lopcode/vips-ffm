package imffm

import java.lang.foreign.Arena
import java.nio.file.Path

interface RunnableSample {

    val name: String
    fun run(arena: Arena, workingDirectory: Path)
    fun validate(workingDirectory: Path): Result<Unit>
}
