package app.photofox.vipsffm;

import java.lang.foreign.Arena;

@FunctionalInterface
public interface VipsRunnable {

    void run(Arena arena);
}
