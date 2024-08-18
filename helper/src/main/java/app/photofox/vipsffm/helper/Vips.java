package app.photofox.vipsffm.helper;

import app.photofox.vipsffm.generated.VipsImage;
import app.photofox.vipsffm.generated.VipsRaw;
import app.photofox.vipsffm.generated.VipsRaw_1;

import java.lang.foreign.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vips {

    private final Arena arena;

    public Vips(Arena arena) {
        this.arena = arena;
    }

    public void init(String argv0) throws VipsError {
        var nameCString = arena.allocateFrom(argv0);
        var result = VipsRaw.vips_init(nameCString);
        if (!isValidResult(result)) {
            throwVipsError("vips_init");
        }
    }

    public MemorySegment imageNewFromFile(String name, VipsOption... args) throws VipsError {
        var layouts = makeInvokerVarargLayouts(args);
        var invoker = VipsRaw.vips_image_new_from_file.makeInvoker(layouts);
        var invokerArgs = makeInvokerVarargObjects(args);
        var nameCString = arena.allocateFrom(name);
        var loadResult = invoker.apply(nameCString, invokerArgs);
        if (!isValidPointer(loadResult)) {
            throwVipsError("vips_new_image_from_file");
        }
        return VipsImage.reinterpret(loadResult, arena, VipsRaw::g_object_unref);
    }

    public void imageWriteToFile(MemorySegment image, String name, VipsOption... args) throws VipsError {
        if (!isValidPointer(image)) {
            throw new VipsError("attempted to operate on invalid image pointer");
        }
        var layouts = makeInvokerVarargLayouts(args);
        var invoker = VipsRaw_1.vips_image_write_to_file.makeInvoker(layouts);
        var invokerArgs = makeInvokerVarargObjects(args);
        var nameCString = arena.allocateFrom(name);
        var result = invoker.apply(image, nameCString, invokerArgs);
        if (!isValidResult(result)) {
            throwVipsError("vips_image_write_to_file");
        }
    }

    public MemorySegment thumbnail(String filename, int width, VipsOption... args) throws VipsError {
        var out = arena.allocate(ValueLayout.ADDRESS);
        var layouts = makeInvokerVarargLayouts(args);
        var invoker = VipsRaw.vips_thumbnail.makeInvoker(layouts);
        var invokerArgs = makeInvokerVarargObjects(args);
        var filenameCString = arena.allocateFrom(filename);
        var result = invoker.apply(filenameCString, out, width, invokerArgs);
        if (!isValidResult(result)) {
            throwVipsError("vips_thumbnail");
        }
        var resultingPointer = out.get(VipsRaw.C_POINTER, 0);
        return VipsImage.reinterpret(resultingPointer, arena, VipsRaw::g_object_unref);
    }

    private MemoryLayout[] makeInvokerVarargLayouts(VipsOption... args) {
        List<ValueLayout> layouts = new ArrayList<>();
        var listArgs = Arrays.stream(args).toList();
        listArgs.forEach((arg) -> {
            layouts.add(VipsRaw.C_POINTER);
            switch (arg) {
                case VipsStringOption _ -> layouts.add(VipsRaw.C_POINTER);
                case VipsIntOption _ -> layouts.add(VipsRaw.C_INT);
            }
        });
        layouts.add(VipsRaw.C_POINTER);
        return layouts.toArray(MemoryLayout[]::new);
    }

    private Object[] makeInvokerVarargObjects(VipsOption... args) {
        var invokeArgs = new ArrayList<>();
        var listArgs = Arrays.stream(args).toList();
        listArgs.forEach((arg) -> {
            var keyCString = arena.allocateFrom(arg.key());
            invokeArgs.add(keyCString);
            switch (arg) {
                case VipsStringOption stringOption -> {
                    var valueCString = arena.allocateFrom(stringOption.value());
                    invokeArgs.add(valueCString);
                }
                case VipsIntOption intOption -> {
                    invokeArgs.add(intOption.value());
                }
            }
        });
        invokeArgs.add(MemorySegment.NULL);
        return invokeArgs.toArray(Object[]::new);
    }

    private boolean isValidPointer(MemorySegment memorySegment) {
        return memorySegment != MemorySegment.NULL && memorySegment.address() != 0;
    }

    private boolean isValidResult(int result) {
        return result == 0;
    }

    private void throwVipsError(String commandName) throws VipsError {
        var errorBuffer = VipsRaw.vips_error_buffer();
        if (!isValidPointer(errorBuffer)) {
            throw new VipsError("failed to run vips command " + commandName);
        }

        var errorString = errorBuffer.getString(0);
        throw new VipsError("failed to run vips command " + commandName + ": " + errorString);
    }
}