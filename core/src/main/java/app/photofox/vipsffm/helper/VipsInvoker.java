package app.photofox.vipsffm.helper;

import app.photofox.vipsffm.generated.VipsRaw;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VipsInvoker {

    public static MemorySegment makeCharStarArray(Arena arena, List<String> strings) {
        var stringArray = MemoryLayout.sequenceLayout(strings.size(), ValueLayout.ADDRESS);
        var cStrings = strings.stream().map(arena::allocateFrom).toList();
        var stringArrayPointer = arena.allocate(stringArray);
        for (int i = 0; i < strings.size(); i++) {
            stringArrayPointer.set(ValueLayout.ADDRESS, i, cStrings.get(i));
        }
        return stringArrayPointer;
    }

    public static MemoryLayout[] makeInvokerVarargLayouts(VipsOption... args) {
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

    public static Object[] makeInvokerVarargObjects(Arena arena, VipsOption... args) {
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
}
