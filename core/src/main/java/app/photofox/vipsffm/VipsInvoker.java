package app.photofox.vipsffm;

import app.photofox.vipsffm.jextract.GValue;
import app.photofox.vipsffm.jextract.VipsRaw;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static app.photofox.vipsffm.jextract.VipsRaw.*;

public class VipsInvoker {

    public static void invokeOperation(Arena arena, String nickname, List<? extends VipsOption> args) throws VipsError {
        // https://www.libvips.org/API/current/binding.html
        var rawOperation = VipsRaw.vips_operation_new(arena.allocateFrom(nickname));
        if (!VipsValidation.isValidPointer(rawOperation)) {
            VipsValidation.throwVipsError(String.format("failed to create operation for %s", nickname));
        }
        final var operation = rawOperation.reinterpret(arena, VipsRaw::g_object_unref);

        args.stream()
            .filter(VipsOption::hasValue)
            .forEach((option -> {
                var optionKey = option.key();
                var keyCString = arena.allocateFrom(optionKey);
                var gvaluePointer = GValue.allocate(arena).reinterpret(arena, VipsRaw::g_value_unset);
                switch (option) {
                    case VipsOption.Int o -> {
                        var value = o.valueOrThrow();
                        VipsRaw.g_value_init(gvaluePointer, G_TYPE_INT());
                        VipsRaw.g_value_set_int(gvaluePointer, value);
                    }
                    case VipsOption.Double o -> {
                        var value = o.valueOrThrow();
                        VipsRaw.g_value_init(gvaluePointer, G_TYPE_DOUBLE());
                        VipsRaw.g_value_set_double(gvaluePointer, value);
                    }
                    case VipsOption.Long o -> {
                        var value = o.valueOrThrow();
                        VipsRaw.g_value_init(gvaluePointer, G_TYPE_LONG());
                        VipsRaw.g_value_set_long(gvaluePointer, value);
                    }
                    case VipsOption.Boolean o -> {
                        var value = o.valueOrThrow();
                        VipsRaw.g_value_init(gvaluePointer, G_TYPE_BOOLEAN());
                        VipsRaw.g_value_set_boolean(gvaluePointer, value ? 1 : 0);
                    }
                    case VipsOption.String o -> {
                        var value = o.valueOrThrow();
                        VipsRaw.g_value_init(gvaluePointer, G_TYPE_STRING());
                        VipsRaw.g_value_set_string(gvaluePointer, arena.allocateFrom(value));
                    }
                    case VipsOption.Image o -> {
                        var value = o.valueOrThrow();
                        VipsRaw.g_value_init(gvaluePointer, vips_image_get_type());
                        VipsRaw.g_value_set_object(gvaluePointer, value.address);
                    }
                    case VipsOption.Source o -> {
                        var value = o.valueOrThrow();
                        VipsRaw.g_value_init(gvaluePointer, vips_source_get_type());
                        VipsRaw.g_value_set_object(gvaluePointer, value.address);
                    }
                    case VipsOption.Target o -> {
                        var value = o.valueOrThrow();
                        VipsRaw.g_value_init(gvaluePointer, vips_target_get_type());
                        VipsRaw.g_value_set_object(gvaluePointer, value.address);
                    }
                    case VipsOption.Blob o -> {
                        var value = o.valueOrThrow();
                        VipsRaw.g_value_init(gvaluePointer, vips_blob_get_type());
                        VipsRaw.g_value_set_object(gvaluePointer, value.address);
                    }
                    case VipsOption.ArrayDouble o -> {
                        var value = o.valueOrThrow();
                        var valueSize = value.size();
                        VipsRaw.g_value_init(gvaluePointer, vips_array_double_get_type());
                        var arrayPointer = arena.allocate(C_DOUBLE, valueSize);
                        for (int i = 0; i < valueSize; i++) {
                            arrayPointer.setAtIndex(C_DOUBLE, i, value.get(i));
                        }
                        VipsRaw.vips_value_set_array_double(gvaluePointer, arrayPointer, valueSize);
                    }
                    case VipsOption.ArrayInt o -> {
                        var value = o.valueOrThrow();
                        var valueSize = value.size();
                        VipsRaw.g_value_init(gvaluePointer, vips_array_int_get_type());
                        var arrayPointer = arena.allocate(C_INT, valueSize);
                        for (int i = 0; i < valueSize; i++) {
                            arrayPointer.setAtIndex(C_INT, i, value.get(i));
                        }
                        VipsRaw.vips_value_set_array_int(gvaluePointer, arrayPointer, valueSize);
                    }
                    case VipsOption.ArrayImage o -> {
                        var value = o.valueOrThrow();
                        var valueSize = value.size();
                        VipsRaw.g_value_init(gvaluePointer, vips_array_image_get_type());
                        var arrayPointer = arena.allocate(C_POINTER, valueSize);
                        for (int i = 0; i < valueSize; i++) {
                            var imageAddress = value.get(i).address.reinterpret(arena, VipsRaw::g_object_unref);
                            VipsRaw.g_object_ref(imageAddress);
                            arrayPointer.setAtIndex(C_POINTER, i, imageAddress);
                        }
                        VipsRaw.vips_value_set_array_image(gvaluePointer, valueSize);
                        var vipsArrayPointer = VipsRaw.vips_value_get_array_image(gvaluePointer, MemorySegment.NULL);
                        vipsArrayPointer.set(C_POINTER, 0, arrayPointer);
                    }
                    case VipsOption.Interpolate o -> {
                        var value = o.valueOrThrow();
                        VipsRaw.g_value_init(gvaluePointer, vips_source_get_type());
                        VipsRaw.g_value_set_object(gvaluePointer, value.address);
                    }
                    case VipsOption.Enum o -> {
                        var value = o.valueOrThrow();
                        VipsRaw.g_value_init(gvaluePointer, G_TYPE_INT());
                        VipsRaw.g_value_set_int(gvaluePointer, value.getRawValue());
                    }
                }
                VipsRaw.g_object_set_property(operation, keyCString, gvaluePointer);
            }));

        var operationResult = VipsRaw.vips_cache_operation_build(operation);
        if (!VipsValidation.isValidPointer(operationResult)) {
            VipsValidation.throwVipsError(String.format("failed to create cached operation for %s", nickname));
        }
        operationResult.reinterpret(arena, (it) -> {
            VipsHelper.object_unref_outputs(it);
            VipsRaw.g_object_unref(it);
        });

        args.stream()
            .filter((option) -> !option.hasValue())
            .forEach((option -> {
                var optionKey = option.key();
                var keyCString = arena.allocateFrom(optionKey);
                var gvaluePointer = GValue.allocate(arena).reinterpret(arena, VipsRaw::g_value_unset);
                switch (option) {
                    case VipsOption.Int o -> {
                        VipsRaw.g_value_init(gvaluePointer, G_TYPE_INT());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var value = VipsRaw.g_value_get_int(gvaluePointer);
                        o.setValue(value);
                    }
                    case VipsOption.Double o -> {
                        VipsRaw.g_value_init(gvaluePointer, G_TYPE_DOUBLE());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var value = VipsRaw.g_value_get_double(gvaluePointer);
                        o.setValue(value);
                    }
                    case VipsOption.Long o -> {
                        VipsRaw.g_value_init(gvaluePointer, G_TYPE_LONG());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var value = VipsRaw.g_value_get_long(gvaluePointer);
                        o.setValue(value);
                    }
                    case VipsOption.Boolean o -> {
                        VipsRaw.g_value_init(gvaluePointer, G_TYPE_BOOLEAN());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var value = VipsRaw.g_value_get_boolean(gvaluePointer);
                        o.setValue(value == 1);
                    }
                    case VipsOption.String o -> {
                        VipsRaw.g_value_init(gvaluePointer, G_TYPE_STRING());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var value = g_value_get_string(gvaluePointer).getString(0);
                        o.setValue(value);
                    }
                    case VipsOption.Image o -> {
                        VipsRaw.g_value_init(gvaluePointer, vips_image_get_type());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var vipsPointer = g_value_get_object(gvaluePointer);
                        VipsRaw.g_object_ref(vipsPointer);
                        vipsPointer = vipsPointer.reinterpret(arena, VipsRaw::g_object_unref);
                        var vipsObject = new VImage(arena, vipsPointer);
                        o.setValue(vipsObject);
                    }
                    case VipsOption.Source o -> {
                        VipsRaw.g_value_init(gvaluePointer, vips_source_get_type());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var vipsPointer = g_value_get_object(gvaluePointer);
                        VipsRaw.g_object_ref(vipsPointer);
                        vipsPointer = vipsPointer.reinterpret(arena, VipsRaw::g_object_unref);
                        var vipsObject = new VSource(vipsPointer);
                        o.setValue(vipsObject);
                    }
                    case VipsOption.Target o -> {
                        VipsRaw.g_value_init(gvaluePointer, vips_target_get_type());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var vipsPointer = g_value_get_object(gvaluePointer);
                        VipsRaw.g_object_ref(vipsPointer);
                        vipsPointer = vipsPointer.reinterpret(arena, VipsRaw::g_object_unref);
                        var vipsObject = new VTarget(vipsPointer);
                        o.setValue(vipsObject);
                    }
                    case VipsOption.Blob o -> {
                        VipsRaw.g_value_init(gvaluePointer, vips_blob_get_type());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var vipsPointer = g_value_get_object(gvaluePointer);
                        VipsRaw.g_object_ref(vipsPointer);
                        vipsPointer = vipsPointer.reinterpret(arena, VipsRaw::g_object_unref);
                        var vipsObject = new VBlob(vipsPointer);
                        o.setValue(vipsObject);
                    }
                    case VipsOption.ArrayInt o -> {
                        VipsRaw.g_value_init(gvaluePointer, vips_array_int_get_type());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var numberOfValuesPointer = arena.allocate(C_INT);
                        var valuesPointer = VipsRaw.vips_value_get_array_int(gvaluePointer, numberOfValuesPointer);
                        var numberOfElements = numberOfValuesPointer.get(C_INT, 0);
                        var list = new ArrayList<Integer>();
                        for (int i = 0; i < numberOfElements; i++) {
                            var value = valuesPointer.get(C_INT, i);
                            list.add(value);
                        }
                        o.setValue(list);
                    }
                    case VipsOption.ArrayDouble o -> {
                        VipsRaw.g_value_init(gvaluePointer, vips_array_double_get_type());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var numberOfValuesPointer = arena.allocate(C_INT);
                        var valuesPointer = VipsRaw.vips_value_get_array_double(gvaluePointer, numberOfValuesPointer);
                        var numberOfElements = numberOfValuesPointer.get(C_INT, 0);
                        var list = new ArrayList<Double>();
                        for (int i = 0; i < numberOfElements; i++) {
                            var value = valuesPointer.get(C_DOUBLE, i);
                            list.add(value);
                        }
                        o.setValue(list);
                    }
                    case VipsOption.ArrayImage o -> {
                        VipsRaw.g_value_init(gvaluePointer, vips_array_image_get_type());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var numberOfValuesPointer = arena.allocate(C_INT);
                        var valuesPointer = VipsRaw.vips_value_get_array_double(gvaluePointer, numberOfValuesPointer);
                        var numberOfElements = numberOfValuesPointer.get(C_INT, 0);
                        var list = new ArrayList<VImage>();
                        for (int i = 0; i < numberOfElements; i++) {
                            var pointer = valuesPointer.get(C_POINTER, i);
                            var value = new VImage(arena, pointer);
                            list.add(value);
                        }
                        o.setValue(list);
                    }
                    case VipsOption.Interpolate o -> {
                        VipsRaw.g_value_init(gvaluePointer, vips_interpolate_get_type());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var vipsPointer = g_value_get_object(gvaluePointer);
                        VipsRaw.g_object_ref(vipsPointer);
                        vipsPointer = vipsPointer.reinterpret(arena, VipsRaw::g_object_unref);
                        var vipsObject = new VInterpolate(vipsPointer);
                        o.setValue(vipsObject);
                    }
                    case VipsOption.Enum o -> {
                        VipsRaw.g_value_init(gvaluePointer, G_TYPE_INT());
                        VipsRaw.g_object_get_property(operation, keyCString, gvaluePointer);
                        var value = VipsRaw.g_value_get_int(gvaluePointer);
                        o.setValue(new VEnum.Raw(value));
                    }
                }
            }));
    }

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
                case VipsOption.Int _ -> layouts.add(VipsRaw.C_INT);
                case VipsOption.Boolean _ -> layouts.add(VipsRaw.C_BOOL);
                case VipsOption.String _ -> layouts.add(VipsRaw.C_POINTER);
                case VipsOption.Image _ -> layouts.add(VipsRaw.C_POINTER);
                case VipsOption.Double _ -> layouts.add(C_DOUBLE);
                case VipsOption.Long _ -> layouts.add(C_LONG);
                case VipsOption.ArrayDouble _ -> layouts.add(VipsRaw.C_POINTER);
                case VipsOption.ArrayImage _ -> layouts.add(VipsRaw.C_POINTER);
                case VipsOption.ArrayInt _ -> layouts.add(VipsRaw.C_POINTER);
                case VipsOption.Blob _ -> layouts.add(VipsRaw.C_POINTER);
                case VipsOption.Source _ -> layouts.add(VipsRaw.C_POINTER);
                case VipsOption.Target _ -> layouts.add(VipsRaw.C_POINTER);
                case VipsOption.Interpolate _ -> layouts.add(VipsRaw.C_POINTER);
                case VipsOption.Enum _ -> layouts.add(VipsRaw.C_INT);
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
                case VipsOption.Int intOption -> {
                    invokeArgs.add(intOption.valueOrThrow());
                }
                case VipsOption.Boolean boolOption -> {
                    var value = boolOption.valueOrThrow();
                    invokeArgs.add(value ? 1 : 0);
                }
                case VipsOption.String stringOption -> {
                    var valueCString = arena.allocateFrom(stringOption.valueOrThrow());
                    invokeArgs.add(valueCString);
                }
                case VipsOption.Image imageOption -> {
                    invokeArgs.add(imageOption.valueOrThrow().address);
                }
                case VipsOption.Double o -> {
                    invokeArgs.add(o.valueOrThrow());
                }
                case VipsOption.Long o -> {
                    invokeArgs.add(o.valueOrThrow());
                }
                case VipsOption.ArrayDouble o -> {
                    var values = o.valueOrThrow();
                    var cValues = arena.allocate(C_DOUBLE, values.size());
                    for (int i = 0; i < values.size(); i++) {
                        cValues.set(C_DOUBLE, i, values.get(i));
                    }
                    invokeArgs.add(cValues);
                }
                case VipsOption.ArrayInt o -> {
                    var values = o.valueOrThrow();
                    var cValues = arena.allocate(C_INT, values.size());
                    for (int i = 0; i < values.size(); i++) {
                        cValues.set(C_INT, i, values.get(i));
                    }
                    invokeArgs.add(cValues);
                }
                case VipsOption.ArrayImage o -> {
                    var values = o.valueOrThrow();
                    var cValues = arena.allocate(C_POINTER, values.size());
                    for (int i = 0; i < values.size(); i++) {
                        cValues.set(C_POINTER, i, values.get(i).address);
                    }
                    invokeArgs.add(cValues);
                }
                case VipsOption.Blob o -> {
                    invokeArgs.add(o.valueOrThrow().address);
                }
                case VipsOption.Source o -> {
                    invokeArgs.add(o.valueOrThrow().address);
                }
                case VipsOption.Target o -> {
                    invokeArgs.add(o.valueOrThrow().address);
                }
                case VipsOption.Interpolate o -> {
                    invokeArgs.add(o.valueOrThrow().address);
                }
                case VipsOption.Enum o -> {
                    invokeArgs.add(o.valueOrThrow().getRawValue());
                }
            }
        });
        invokeArgs.add(MemorySegment.NULL);
        return invokeArgs.toArray(Object[]::new);
    }
}
