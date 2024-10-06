package app.photofox.vipsffm;

import app.photofox.vipsffm.jextract.VipsRaw;

import java.lang.foreign.MemorySegment;

public class VipsValidation {

    public static boolean isValidPointer(MemorySegment memorySegment) {
        if (memorySegment == null) {
            return false;
        }
        return memorySegment != MemorySegment.NULL && memorySegment.address() != 0;
    }

    public static boolean isValidResult(int result) {
        return result == 0;
    }

    public static void throwVipsError(String commandName) throws VipsError {
        var errorBuffer = VipsRaw.vips_error_buffer();
        if (!isValidPointer(errorBuffer)) {
            throw new VipsError("failed to run vips command " + commandName);
        }

        var errorString = errorBuffer.getString(0);
        throw new VipsError("failed to run vips command " + commandName + ": " + errorString);
    }

    public static void throwInvalidInputError(String commandName, String argName) throws VipsError {
        throw new VipsError("invalid input provided to command " + commandName + " argument " + argName);
    }

    public static void throwInvalidOutputError(String commandName, String argName) throws VipsError {
        var errorBuffer = VipsRaw.vips_error_buffer();
        if (!isValidPointer(errorBuffer)) {
            throw new VipsError("failed to run vips command " + commandName);
        }

        var errorString = errorBuffer.getString(0);
        throw new VipsError("invalid output pointer from command " + commandName + " argument " + argName + ": " + errorString);
    }
}