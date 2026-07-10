package vipsffm;

import java.lang.foreign.Arena;
import java.nio.file.Path;

public interface RunnableSample {

    void run(Arena arena, Path workingDirectory) throws Exception;
}
