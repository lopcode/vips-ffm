package app.photofox.vipsffm;

import app.photofox.vipsffm.jextract.VipsRaw;
import java.lang.String;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.List;

/**
 * Generated helpers to wrap {@link VipsRaw} JExtract definitions
 * Validation of input pointers is performed, but prefer usage of {@link VImage} and friends which do not expose raw pointers
 */
public final class VipsHelper {
  public static void init(Arena arena, boolean allowUntrusted) {
    var nameCString = arena.allocateFrom("vips-ffm");
    var result = VipsRaw.vips_init(nameCString);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_init");
    }
    VipsRaw.vips_block_untrusted_set(allowUntrusted ? 0 : 1);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_enum_string(GType enm, int value)
   * }
   */
  public static String enum_string(long enm, int value) throws VipsError {
    var result = VipsRaw.vips_enum_string(enm, value);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_enum_string", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_enum_nick(GType enm, int value)
   * }
   */
  public static String enum_nick(long enm, int value) throws VipsError {
    var result = VipsRaw.vips_enum_nick(enm, value);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_enum_nick", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_enum_from_nick(const char *domain, GType type, const char *str)
   * }
   */
  public static int enum_from_nick(Arena arena, String domainString, long type, String strString)
      throws VipsError {
    var domain = arena.allocateFrom(domainString);
    var str = arena.allocateFrom(strString);
    var result = VipsRaw.vips_enum_from_nick(domain, type, str);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_filename_suffix_match(const char *path, const char *suffixes[])
   * }
   */
  public static int filename_suffix_match(Arena arena, String pathString,
      List<String> suffixesStringArray) throws VipsError {
    var path = arena.allocateFrom(pathString);
    var suffixes = VipsInvoker.makeCharStarArray(arena, suffixesStringArray);
    var result = VipsRaw.vips_filename_suffix_match(path, suffixes);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_get_args(VipsObject *object, const char ***names, int **flags, int *n_args)
   * }
   */
  public static int object_get_args(MemorySegment object, MemorySegment names, MemorySegment flags,
      MemorySegment n_args) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_get_args", "object");
    }
    if(!VipsValidation.isValidPointer(names)) {
      VipsValidation.throwInvalidInputError("vips_object_get_args", "names");
    }
    if(!VipsValidation.isValidPointer(flags)) {
      VipsValidation.throwInvalidInputError("vips_object_get_args", "flags");
    }
    if(!VipsValidation.isValidPointer(n_args)) {
      VipsValidation.throwInvalidInputError("vips_object_get_args", "n_args");
    }
    var result = VipsRaw.vips_object_get_args(object, names, flags, n_args);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_get_argument(VipsObject *object, const char *name, GParamSpec **pspec, VipsArgumentClass **argument_class, VipsArgumentInstance **argument_instance)
   * }
   */
  public static int object_get_argument(Arena arena, MemorySegment object, String nameString,
      MemorySegment pspec, MemorySegment argument_class, MemorySegment argument_instance) throws
      VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_get_argument", "object");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(pspec)) {
      VipsValidation.throwInvalidInputError("vips_object_get_argument", "pspec");
    }
    if(!VipsValidation.isValidPointer(argument_class)) {
      VipsValidation.throwInvalidInputError("vips_object_get_argument", "argument_class");
    }
    if(!VipsValidation.isValidPointer(argument_instance)) {
      VipsValidation.throwInvalidInputError("vips_object_get_argument", "argument_instance");
    }
    var result = VipsRaw.vips_object_get_argument(object, name, pspec, argument_class, argument_instance);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArgumentFlags vips_object_get_argument_flags(VipsObject *object, const char *name)
   * }
   */
  public static int object_get_argument_flags(Arena arena, MemorySegment object, String nameString)
      throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_get_argument_flags", "object");
    }
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw.vips_object_get_argument_flags(object, name);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_get_argument_priority(VipsObject *object, const char *name)
   * }
   */
  public static int object_get_argument_priority(Arena arena, MemorySegment object,
      String nameString) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_get_argument_priority", "object");
    }
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw.vips_object_get_argument_priority(object, name);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_value_is_null(GParamSpec *psoec, const GValue *value)
   * }
   */
  public static boolean value_is_null(MemorySegment psoec, MemorySegment value) throws VipsError {
    if(!VipsValidation.isValidPointer(psoec)) {
      VipsValidation.throwInvalidInputError("vips_value_is_null", "psoec");
    }
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_is_null", "value");
    }
    var result = VipsRaw.vips_value_is_null(psoec, value);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_get_argument_to_string(VipsObject *object, const char *name, const char *arg)
   * }
   */
  public static int object_get_argument_to_string(Arena arena, MemorySegment object,
      String nameString, String argString) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_get_argument_to_string", "object");
    }
    var name = arena.allocateFrom(nameString);
    var arg = arena.allocateFrom(argString);
    var result = VipsRaw.vips_object_get_argument_to_string(object, name, arg);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_set_from_string(VipsObject *object, const char *string)
   * }
   */
  public static int object_set_from_string(Arena arena, MemorySegment object, String stringString)
      throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_set_from_string", "object");
    }
    var string = arena.allocateFrom(stringString);
    var result = VipsRaw.vips_object_set_from_string(object, string);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_type_map(GType base, VipsTypeMap2Fn fn, void *a, void *b)
   * }
   */
  public static MemorySegment type_map(Arena arena, long base, MemorySegment fn, MemorySegment a,
      MemorySegment b) throws VipsError {
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_type_map", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_type_map", "b");
    }
    var result = VipsRaw.vips_type_map(base, fn, a, b);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_type_map", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_type_map_all(GType base, VipsTypeMapFn fn, void *a)
   * }
   */
  public static MemorySegment type_map_all(Arena arena, long base, MemorySegment fn,
      MemorySegment a) throws VipsError {
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_type_map_all", "a");
    }
    var result = VipsRaw.vips_type_map_all(base, fn, a);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_type_map_all", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_type_depth(GType type)
   * }
   */
  public static int type_depth(long type) throws VipsError {
    var result = VipsRaw.vips_type_depth(type);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_type_find(const char *basename, const char *nickname)
   * }
   */
  public static long type_find(Arena arena, String basenameString, String nicknameString) throws
      VipsError {
    var basename = arena.allocateFrom(basenameString);
    var nickname = arena.allocateFrom(nicknameString);
    var result = VipsRaw.vips_type_find(basename, nickname);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_nickname_find(GType type)
   * }
   */
  public static String nickname_find(long type) throws VipsError {
    var result = VipsRaw.vips_nickname_find(type);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_nickname_find", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_unref_outputs(VipsObject *object)
   * }
   */
  public static void object_unref_outputs(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_unref_outputs", "object");
    }
    VipsRaw.vips_object_unref_outputs(object);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_object_get_description(VipsObject *object)
   * }
   */
  public static String object_get_description(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_get_description", "object");
    }
    var result = VipsRaw.vips_object_get_description(object);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_object_get_description", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArea *vips_area_copy(VipsArea *area)
   * }
   */
  public static MemorySegment area_copy(Arena arena, MemorySegment area) throws VipsError {
    if(!VipsValidation.isValidPointer(area)) {
      VipsValidation.throwInvalidInputError("vips_area_copy", "area");
    }
    var result = VipsRaw.vips_area_copy(area);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_area_copy", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_area_unref(VipsArea *area)
   * }
   */
  public static void area_unref(MemorySegment area) throws VipsError {
    if(!VipsValidation.isValidPointer(area)) {
      VipsValidation.throwInvalidInputError("vips_area_unref", "area");
    }
    VipsRaw.vips_area_unref(area);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_area_get_data(VipsArea *area, size_t *length, int *n, GType *type, size_t *sizeof_type)
   * }
   */
  public static MemorySegment area_get_data(Arena arena, MemorySegment area, MemorySegment length,
      MemorySegment n, MemorySegment type, MemorySegment sizeof_type) throws VipsError {
    if(!VipsValidation.isValidPointer(area)) {
      VipsValidation.throwInvalidInputError("vips_area_get_data", "area");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_area_get_data", "length");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_area_get_data", "n");
    }
    if(!VipsValidation.isValidPointer(type)) {
      VipsValidation.throwInvalidInputError("vips_area_get_data", "type");
    }
    if(!VipsValidation.isValidPointer(sizeof_type)) {
      VipsValidation.throwInvalidInputError("vips_area_get_data", "sizeof_type");
    }
    var result = VipsRaw.vips_area_get_data(area, length, n, type, sizeof_type);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_area_get_data", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_area_get_type()
   * }
   */
  public static long area_get_type() throws VipsError {
    var result = VipsRaw.vips_area_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsBlob *vips_blob_new(VipsCallbackFn free_fn, const void *data, size_t length)
   * }
   */
  public static MemorySegment blob_new(Arena arena, MemorySegment free_fn, MemorySegment data,
      long length) throws VipsError {
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_blob_new", "data");
    }
    var result = VipsRaw.vips_blob_new(free_fn, data, length);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_blob_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsBlob *vips_blob_copy(const void *data, size_t length)
   * }
   */
  public static MemorySegment blob_copy(Arena arena, MemorySegment data, long length) throws
      VipsError {
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_blob_copy", "data");
    }
    var result = VipsRaw.vips_blob_copy(data, length);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_blob_copy", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const void *vips_blob_get(VipsBlob *blob, size_t *length)
   * }
   */
  public static MemorySegment blob_get(Arena arena, MemorySegment blob, MemorySegment length) throws
      VipsError {
    if(!VipsValidation.isValidPointer(blob)) {
      VipsValidation.throwInvalidInputError("vips_blob_get", "blob");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_blob_get", "length");
    }
    var result = VipsRaw.vips_blob_get(blob, length);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_blob_get", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_blob_set(VipsBlob *blob, VipsCallbackFn free_fn, const void *data, size_t length)
   * }
   */
  public static void blob_set(MemorySegment blob, MemorySegment free_fn, MemorySegment data,
      long length) throws VipsError {
    if(!VipsValidation.isValidPointer(blob)) {
      VipsValidation.throwInvalidInputError("vips_blob_set", "blob");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_blob_set", "data");
    }
    VipsRaw.vips_blob_set(blob, free_fn, data, length);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_blob_get_type()
   * }
   */
  public static long blob_get_type() throws VipsError {
    var result = VipsRaw.vips_blob_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_array_double_get_type()
   * }
   */
  public static long array_double_get_type() throws VipsError {
    var result = VipsRaw.vips_array_double_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_array_int_get_type()
   * }
   */
  public static long array_int_get_type() throws VipsError {
    var result = VipsRaw.vips_array_int_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_array_image_get_type()
   * }
   */
  public static long array_image_get_type() throws VipsError {
    var result = VipsRaw.vips_array_image_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_area(GValue *value, VipsCallbackFn free_fn, void *data)
   * }
   */
  public static void value_set_area(MemorySegment value, MemorySegment free_fn, MemorySegment data)
      throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_area", "value");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_value_set_area", "data");
    }
    VipsRaw.vips_value_set_area(value, free_fn, data);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_value_get_area(const GValue *value, size_t *length)
   * }
   */
  public static MemorySegment value_get_area(Arena arena, MemorySegment value, MemorySegment length)
      throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_area", "value");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_value_get_area", "length");
    }
    var result = VipsRaw.vips_value_get_area(value, length);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_value_get_area", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_value_get_save_string(const GValue *value)
   * }
   */
  public static String value_get_save_string(MemorySegment value) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_save_string", "value");
    }
    var result = VipsRaw.vips_value_get_save_string(value);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_value_get_save_string", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_save_string(GValue *value, const char *str)
   * }
   */
  public static void value_set_save_string(Arena arena, MemorySegment value, String strString)
      throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_save_string", "value");
    }
    var str = arena.allocateFrom(strString);
    VipsRaw.vips_value_set_save_string(value, str);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_value_get_ref_string(const GValue *value, size_t *length)
   * }
   */
  public static String value_get_ref_string(MemorySegment value, MemorySegment length) throws
      VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_ref_string", "value");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_value_get_ref_string", "length");
    }
    var result = VipsRaw.vips_value_get_ref_string(value, length);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_value_get_ref_string", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_ref_string(GValue *value, const char *str)
   * }
   */
  public static void value_set_ref_string(Arena arena, MemorySegment value, String strString) throws
      VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_ref_string", "value");
    }
    var str = arena.allocateFrom(strString);
    VipsRaw.vips_value_set_ref_string(value, str);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_value_get_blob(const GValue *value, size_t *length)
   * }
   */
  public static MemorySegment value_get_blob(Arena arena, MemorySegment value, MemorySegment length)
      throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_blob", "value");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_value_get_blob", "length");
    }
    var result = VipsRaw.vips_value_get_blob(value, length);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_value_get_blob", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_blob(GValue *value, VipsCallbackFn free_fn, const void *data, size_t length)
   * }
   */
  public static void value_set_blob(MemorySegment value, MemorySegment free_fn, MemorySegment data,
      long length) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_blob", "value");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_value_set_blob", "data");
    }
    VipsRaw.vips_value_set_blob(value, free_fn, data, length);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_blob_free(GValue *value, void *data, size_t length)
   * }
   */
  public static void value_set_blob_free(MemorySegment value, MemorySegment data, long length)
      throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_blob_free", "value");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_value_set_blob_free", "data");
    }
    VipsRaw.vips_value_set_blob_free(value, data, length);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_array(GValue *value, int n, GType type, size_t sizeof_type)
   * }
   */
  public static void value_set_array(MemorySegment value, int n, long type, long sizeof_type) throws
      VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array", "value");
    }
    VipsRaw.vips_value_set_array(value, n, type, sizeof_type);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_value_get_array(const GValue *value, int *n, GType *type, size_t *sizeof_type)
   * }
   */
  public static MemorySegment value_get_array(Arena arena, MemorySegment value, MemorySegment n,
      MemorySegment type, MemorySegment sizeof_type) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array", "value");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array", "n");
    }
    if(!VipsValidation.isValidPointer(type)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array", "type");
    }
    if(!VipsValidation.isValidPointer(sizeof_type)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array", "sizeof_type");
    }
    var result = VipsRaw.vips_value_get_array(value, n, type, sizeof_type);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_value_get_array", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * double *vips_value_get_array_double(const GValue *value, int *n)
   * }
   */
  public static MemorySegment value_get_array_double(Arena arena, MemorySegment value,
      MemorySegment n) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_double", "value");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_double", "n");
    }
    var result = VipsRaw.vips_value_get_array_double(value, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_value_get_array_double", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_array_double(GValue *value, const double *array, int n)
   * }
   */
  public static void value_set_array_double(MemorySegment value, MemorySegment array, int n) throws
      VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array_double", "value");
    }
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array_double", "array");
    }
    VipsRaw.vips_value_set_array_double(value, array, n);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int *vips_value_get_array_int(const GValue *value, int *n)
   * }
   */
  public static MemorySegment value_get_array_int(Arena arena, MemorySegment value, MemorySegment n)
      throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_int", "value");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_int", "n");
    }
    var result = VipsRaw.vips_value_get_array_int(value, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_value_get_array_int", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_array_int(GValue *value, const int *array, int n)
   * }
   */
  public static void value_set_array_int(MemorySegment value, MemorySegment array, int n) throws
      VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array_int", "value");
    }
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array_int", "array");
    }
    VipsRaw.vips_value_set_array_int(value, array, n);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GObject **vips_value_get_array_object(const GValue *value, int *n)
   * }
   */
  public static MemorySegment value_get_array_object(MemorySegment value, MemorySegment n) throws
      VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_object", "value");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_object", "n");
    }
    var result = VipsRaw.vips_value_get_array_object(value, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_value_get_array_object", "result");
    }
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_array_object(GValue *value, int n)
   * }
   */
  public static void value_set_array_object(MemorySegment value, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array_object", "value");
    }
    VipsRaw.vips_value_set_array_object(value, n);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_source_get_type()
   * }
   */
  public static long source_get_type() throws VipsError {
    var result = VipsRaw.vips_source_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsSource *vips_source_new_from_descriptor(int descriptor)
   * }
   */
  public static MemorySegment source_new_from_descriptor(Arena arena, int descriptor) throws
      VipsError {
    var result = VipsRaw.vips_source_new_from_descriptor(descriptor);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_source_new_from_descriptor", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsSource *vips_source_new_from_file(const char *filename)
   * }
   */
  public static MemorySegment source_new_from_file(Arena arena, String filenameString) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw.vips_source_new_from_file(filename);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_source_new_from_file", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsSource *vips_source_new_from_blob(VipsBlob *blob)
   * }
   */
  public static MemorySegment source_new_from_blob(Arena arena, MemorySegment blob) throws
      VipsError {
    if(!VipsValidation.isValidPointer(blob)) {
      VipsValidation.throwInvalidInputError("vips_source_new_from_blob", "blob");
    }
    var result = VipsRaw.vips_source_new_from_blob(blob);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_source_new_from_blob", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsSource *vips_source_new_from_target(VipsTarget *target)
   * }
   */
  public static MemorySegment source_new_from_target(Arena arena, MemorySegment target) throws
      VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_source_new_from_target", "target");
    }
    var result = VipsRaw.vips_source_new_from_target(target);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_source_new_from_target", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsSource *vips_source_new_from_memory(const void *data, size_t size)
   * }
   */
  public static MemorySegment source_new_from_memory(Arena arena, MemorySegment data, long size)
      throws VipsError {
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_source_new_from_memory", "data");
    }
    var result = VipsRaw.vips_source_new_from_memory(data, size);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_source_new_from_memory", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsSource *vips_source_new_from_options(const char *options)
   * }
   */
  public static MemorySegment source_new_from_options(Arena arena, String optionsString) throws
      VipsError {
    var options = arena.allocateFrom(optionsString);
    var result = VipsRaw.vips_source_new_from_options(options);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_source_new_from_options", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_target_get_type()
   * }
   */
  public static long target_get_type() throws VipsError {
    var result = VipsRaw.vips_target_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsTarget *vips_target_new_to_descriptor(int descriptor)
   * }
   */
  public static MemorySegment target_new_to_descriptor(Arena arena, int descriptor) throws
      VipsError {
    var result = VipsRaw.vips_target_new_to_descriptor(descriptor);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_target_new_to_descriptor", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsTarget *vips_target_new_to_file(const char *filename)
   * }
   */
  public static MemorySegment target_new_to_file(Arena arena, String filenameString) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw.vips_target_new_to_file(filename);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_target_new_to_file", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsTarget *vips_target_new_to_memory()
   * }
   */
  public static MemorySegment target_new_to_memory(Arena arena) throws VipsError {
    var result = VipsRaw.vips_target_new_to_memory();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_target_new_to_memory", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsTarget *vips_target_new_temp(VipsTarget *target)
   * }
   */
  public static MemorySegment target_new_temp(Arena arena, MemorySegment target) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_new_temp", "target");
    }
    var result = VipsRaw.vips_target_new_temp(target);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_target_new_temp", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_image_get_type()
   * }
   */
  public static long image_get_type() throws VipsError {
    var result = VipsRaw.vips_image_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * char *vips_filename_get_filename(const char *vips_filename)
   * }
   */
  public static String filename_get_filename(Arena arena, String vips_filenameString) throws
      VipsError {
    var vips_filename = arena.allocateFrom(vips_filenameString);
    var result = VipsRaw.vips_filename_get_filename(vips_filename);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_filename_get_filename", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * char *vips_filename_get_options(const char *vips_filename)
   * }
   */
  public static String filename_get_options(Arena arena, String vips_filenameString) throws
      VipsError {
    var vips_filename = arena.allocateFrom(vips_filenameString);
    var result = VipsRaw.vips_filename_get_options(vips_filename);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_filename_get_options", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new()
   * }
   */
  public static MemorySegment image_new(Arena arena) throws VipsError {
    var result = VipsRaw.vips_image_new();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_memory()
   * }
   */
  public static MemorySegment image_new_memory(Arena arena) throws VipsError {
    var result = VipsRaw.vips_image_new_memory();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_memory", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_file_RW(const char *filename)
   * }
   */
  public static MemorySegment image_new_from_file_RW(Arena arena, String filenameString) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw.vips_image_new_from_file_RW(filename);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_from_file_RW", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_file_raw(const char *filename, int xsize, int ysize, int bands, guint64 offset)
   * }
   */
  public static MemorySegment image_new_from_file_raw(Arena arena, String filenameString, int xsize,
      int ysize, int bands, long offset) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw.vips_image_new_from_file_raw(filename, xsize, ysize, bands, offset);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_from_file_raw", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_memory(const void *data, size_t size, int width, int height, int bands, VipsBandFormat format)
   * }
   */
  public static MemorySegment image_new_from_memory(Arena arena, MemorySegment data, long size,
      int width, int height, int bands, int format) throws VipsError {
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_memory", "data");
    }
    var result = VipsRaw.vips_image_new_from_memory(data, size, width, height, bands, format);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_from_memory", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_memory_copy(const void *data, size_t size, int width, int height, int bands, VipsBandFormat format)
   * }
   */
  public static MemorySegment image_new_from_memory_copy(Arena arena, MemorySegment data, long size,
      int width, int height, int bands, int format) throws VipsError {
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_memory_copy", "data");
    }
    var result = VipsRaw.vips_image_new_from_memory_copy(data, size, width, height, bands, format);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_from_memory_copy", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_matrix(int width, int height)
   * }
   */
  public static MemorySegment image_new_matrix(Arena arena, int width, int height) throws
      VipsError {
    var result = VipsRaw.vips_image_new_matrix(width, height);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_matrix", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_matrix_from_array(int width, int height, const double *array, int size)
   * }
   */
  public static MemorySegment image_new_matrix_from_array(Arena arena, int width, int height,
      MemorySegment array, int size) throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_image_new_matrix_from_array", "array");
    }
    var result = VipsRaw.vips_image_new_matrix_from_array(width, height, array, size);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_matrix_from_array", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_image(VipsImage *image, const double *c, int n)
   * }
   */
  public static MemorySegment image_new_from_image(Arena arena, MemorySegment image,
      MemorySegment c, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_image", "image");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_image", "c");
    }
    var result = VipsRaw.vips_image_new_from_image(image, c, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_from_image", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_image1(VipsImage *image, double c)
   * }
   */
  public static MemorySegment image_new_from_image1(Arena arena, MemorySegment image, double c)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_image1", "image");
    }
    var result = VipsRaw.vips_image_new_from_image1(image, c);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_from_image1", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_temp_file(const char *format)
   * }
   */
  public static MemorySegment image_new_temp_file(Arena arena, String formatString) throws
      VipsError {
    var format = arena.allocateFrom(formatString);
    var result = VipsRaw.vips_image_new_temp_file(format);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_temp_file", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_write(VipsImage *image, VipsImage *out)
   * }
   */
  public static int image_write(MemorySegment image, MemorySegment out) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_write", "image");
    }
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_image_write", "out");
    }
    var result = VipsRaw.vips_image_write(image, out);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_image_write_to_memory(VipsImage *in, size_t *size)
   * }
   */
  public static MemorySegment image_write_to_memory(Arena arena, MemorySegment in,
      MemorySegment size) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_memory", "in");
    }
    if(!VipsValidation.isValidPointer(size)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_memory", "size");
    }
    var result = VipsRaw.vips_image_write_to_memory(in, size);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_write_to_memory", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_hasalpha(VipsImage *image)
   * }
   */
  public static boolean image_hasalpha(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_hasalpha", "image");
    }
    var result = VipsRaw.vips_image_hasalpha(image);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_write_prepare(VipsImage *image)
   * }
   */
  public static int image_write_prepare(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_write_prepare", "image");
    }
    var result = VipsRaw.vips_image_write_prepare(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_write_line(VipsImage *image, int ypos, VipsPel *linebuffer)
   * }
   */
  public static int image_write_line(MemorySegment image, int ypos, MemorySegment linebuffer) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_write_line", "image");
    }
    if(!VipsValidation.isValidPointer(linebuffer)) {
      VipsValidation.throwInvalidInputError("vips_image_write_line", "linebuffer");
    }
    var result = VipsRaw.vips_image_write_line(image, ypos, linebuffer);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage **vips_value_get_array_image(const GValue *value, int *n)
   * }
   */
  public static MemorySegment value_get_array_image(MemorySegment value, MemorySegment n) throws
      VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_image", "value");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_image", "n");
    }
    var result = VipsRaw.vips_value_get_array_image(value, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_value_get_array_image", "result");
    }
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_array_image(GValue *value, int n)
   * }
   */
  public static void value_set_array_image(MemorySegment value, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array_image", "value");
    }
    VipsRaw.vips_value_set_array_image(value, n);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_error_buffer()
   * }
   */
  public static String error_buffer() throws VipsError {
    var result = VipsRaw.vips_error_buffer();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_error_buffer", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * char *vips_error_buffer_copy()
   * }
   */
  public static String error_buffer_copy() throws VipsError {
    var result = VipsRaw.vips_error_buffer_copy();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_error_buffer_copy", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_error_clear()
   * }
   */
  public static void error_clear() throws VipsError {
    VipsRaw.vips_error_clear();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_error_freeze()
   * }
   */
  public static void error_freeze() throws VipsError {
    VipsRaw.vips_error_freeze();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_error_thaw()
   * }
   */
  public static void error_thaw() throws VipsError {
    VipsRaw.vips_error_thaw();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_error_g(GError **error)
   * }
   */
  public static void error_g(MemorySegment error) throws VipsError {
    if(!VipsValidation.isValidPointer(error)) {
      VipsValidation.throwInvalidInputError("vips_error_g", "error");
    }
    VipsRaw.vips_error_g(error);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_interpolate_get_type()
   * }
   */
  public static long interpolate_get_type() throws VipsError {
    var result = VipsRaw.vips_interpolate_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_interpolate(VipsInterpolate *interpolate, void *out, VipsRegion *in, double x, double y)
   * }
   */
  public static void interpolate(MemorySegment interpolate, MemorySegment out, MemorySegment in,
      double x, double y) throws VipsError {
    if(!VipsValidation.isValidPointer(interpolate)) {
      VipsValidation.throwInvalidInputError("vips_interpolate", "interpolate");
    }
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_interpolate", "out");
    }
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_interpolate", "in");
    }
    VipsRaw.vips_interpolate(interpolate, out, in, x, y);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsInterpolateMethod vips_interpolate_get_method(VipsInterpolate *interpolate)
   * }
   */
  public static MemorySegment interpolate_get_method(MemorySegment interpolate) throws VipsError {
    if(!VipsValidation.isValidPointer(interpolate)) {
      VipsValidation.throwInvalidInputError("vips_interpolate_get_method", "interpolate");
    }
    var result = VipsRaw.vips_interpolate_get_method(interpolate);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_interpolate_get_method", "result");
    }
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_interpolate_get_window_size(VipsInterpolate *interpolate)
   * }
   */
  public static int interpolate_get_window_size(MemorySegment interpolate) throws VipsError {
    if(!VipsValidation.isValidPointer(interpolate)) {
      VipsValidation.throwInvalidInputError("vips_interpolate_get_window_size", "interpolate");
    }
    var result = VipsRaw.vips_interpolate_get_window_size(interpolate);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_interpolate_get_window_offset(VipsInterpolate *interpolate)
   * }
   */
  public static int interpolate_get_window_offset(MemorySegment interpolate) throws VipsError {
    if(!VipsValidation.isValidPointer(interpolate)) {
      VipsValidation.throwInvalidInputError("vips_interpolate_get_window_offset", "interpolate");
    }
    var result = VipsRaw.vips_interpolate_get_window_offset(interpolate);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsInterpolate *vips_interpolate_nearest_static()
   * }
   */
  public static MemorySegment interpolate_nearest_static(Arena arena) throws VipsError {
    var result = VipsRaw.vips_interpolate_nearest_static();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_interpolate_nearest_static", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsInterpolate *vips_interpolate_bilinear_static()
   * }
   */
  public static MemorySegment interpolate_bilinear_static(Arena arena) throws VipsError {
    var result = VipsRaw.vips_interpolate_bilinear_static();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_interpolate_bilinear_static", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsInterpolate *vips_interpolate_new(const char *nickname)
   * }
   */
  public static MemorySegment interpolate_new(Arena arena, String nicknameString) throws VipsError {
    var nickname = arena.allocateFrom(nicknameString);
    var result = VipsRaw.vips_interpolate_new(nickname);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_interpolate_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_width(const VipsImage *image)
   * }
   */
  public static int image_get_width(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_width", "image");
    }
    var result = VipsRaw.vips_image_get_width(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_height(const VipsImage *image)
   * }
   */
  public static int image_get_height(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_height", "image");
    }
    var result = VipsRaw.vips_image_get_height(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_image_get_typeof(const VipsImage *image, const char *name)
   * }
   */
  public static long image_get_typeof(Arena arena, MemorySegment image, String nameString) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_typeof", "image");
    }
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw.vips_image_get_typeof(image, name);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsOperationFlags vips_operation_get_flags(VipsOperation *operation)
   * }
   */
  public static int operation_get_flags(MemorySegment operation) throws VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_operation_get_flags", "operation");
    }
    var result = VipsRaw.vips_operation_get_flags(operation);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsOperation *vips_operation_new(const char *name)
   * }
   */
  public static MemorySegment operation_new(Arena arena, String nameString) throws VipsError {
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw.vips_operation_new(name);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_operation_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cache_operation_buildp(VipsOperation **operation)
   * }
   */
  public static int cache_operation_buildp(MemorySegment operation) throws VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_cache_operation_buildp", "operation");
    }
    var result = VipsRaw.vips_cache_operation_buildp(operation);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsOperation *vips_cache_operation_build(VipsOperation *operation)
   * }
   */
  public static MemorySegment cache_operation_build(Arena arena, MemorySegment operation) throws
      VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_cache_operation_build", "operation");
    }
    var result = VipsRaw.vips_cache_operation_build(operation);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_cache_operation_build", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_cache_set_max(int max)
   * }
   */
  public static void cache_set_max(int max) throws VipsError {
    VipsRaw.vips_cache_set_max(max);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_cache_set_max_mem(size_t max_mem)
   * }
   */
  public static void cache_set_max_mem(long max_mem) throws VipsError {
    VipsRaw.vips_cache_set_max_mem(max_mem);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_cache_set_max_files(int max_files)
   * }
   */
  public static void cache_set_max_files(int max_files) throws VipsError {
    VipsRaw.vips_cache_set_max_files(max_files);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_cache_set_dump(gboolean dump)
   * }
   */
  public static void cache_set_dump(boolean dumpBoolean) throws VipsError {
    var dump = dumpBoolean ? 1 : 0;
    VipsRaw.vips_cache_set_dump(dump);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_cache_set_trace(gboolean trace)
   * }
   */
  public static void cache_set_trace(boolean traceBoolean) throws VipsError {
    var trace = traceBoolean ? 1 : 0;
    VipsRaw.vips_cache_set_trace(trace);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_foreign_find_load(const char *filename)
   * }
   */
  public static String foreign_find_load(Arena arena, String filenameString) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw.vips_foreign_find_load(filename);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_foreign_find_load", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_foreign_find_load_buffer(const void *data, size_t size)
   * }
   */
  public static String foreign_find_load_buffer(MemorySegment data, long size) throws VipsError {
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_foreign_find_load_buffer", "data");
    }
    var result = VipsRaw.vips_foreign_find_load_buffer(data, size);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_foreign_find_load_buffer", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_foreign_find_load_source(VipsSource *source)
   * }
   */
  public static String foreign_find_load_source(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_foreign_find_load_source", "source");
    }
    var result = VipsRaw.vips_foreign_find_load_source(source);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_foreign_find_load_source", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_foreign_find_save(const char *filename)
   * }
   */
  public static String foreign_find_save(Arena arena, String filenameString) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw.vips_foreign_find_save(filename);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_foreign_find_save", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_foreign_find_save_buffer(const char *suffix)
   * }
   */
  public static String foreign_find_save_buffer(Arena arena, String suffixString) throws VipsError {
    var suffix = arena.allocateFrom(suffixString);
    var result = VipsRaw.vips_foreign_find_save_buffer(suffix);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_foreign_find_save_buffer", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_foreign_find_save_target(const char *suffix)
   * }
   */
  public static String foreign_find_save_target(Arena arena, String suffixString) throws VipsError {
    var suffix = arena.allocateFrom(suffixString);
    var result = VipsRaw.vips_foreign_find_save_target(suffix);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_foreign_find_save_target", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_init(const char *argv0)
   * }
   */
  public static int init(Arena arena, String argv0String) throws VipsError {
    var argv0 = arena.allocateFrom(argv0String);
    var result = VipsRaw.vips_init(argv0);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_shutdown()
   * }
   */
  public static void shutdown() throws VipsError {
    VipsRaw.vips_shutdown();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_leak_set(gboolean leak)
   * }
   */
  public static void leak_set(boolean leakBoolean) throws VipsError {
    var leak = leakBoolean ? 1 : 0;
    VipsRaw.vips_leak_set(leak);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_block_untrusted_set(gboolean state)
   * }
   */
  public static void block_untrusted_set(boolean stateBoolean) throws VipsError {
    var state = stateBoolean ? 1 : 0;
    VipsRaw.vips_block_untrusted_set(state);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_version_string()
   * }
   */
  public static String version_string() throws VipsError {
    var result = VipsRaw.vips_version_string();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_version_string", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_version(int flag)
   * }
   */
  public static int version(int flag) throws VipsError {
    var result = VipsRaw.vips_version(flag);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_error_exit(const char *fmt, ...)
   * }
   */
  public static void error_exit(Arena arena, String fmtString, VipsOption... options) throws
      VipsError {
    var fmt = arena.allocateFrom(fmtString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_error_exit.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    invoker.apply(fmt, invokerArgs);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_error_system(int err, const char *domain, const char *fmt, ...)
   * }
   */
  public static void error_system(Arena arena, int err, String domainString, String fmtString,
      VipsOption... options) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    var fmt = arena.allocateFrom(fmtString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_error_system.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    invoker.apply(err, domain, fmt, invokerArgs);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_error(const char *domain, const char *fmt, ...)
   * }
   */
  public static void error(Arena arena, String domainString, String fmtString,
      VipsOption... options) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    var fmt = arena.allocateFrom(fmtString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_error.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    invoker.apply(domain, fmt, invokerArgs);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_write_to_target(VipsImage *in, const char *suffix, VipsTarget *target, ...)
   * }
   */
  public static int image_write_to_target(Arena arena, MemorySegment in, String suffixString,
      MemorySegment target, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_target", "in");
    }
    var suffix = arena.allocateFrom(suffixString);
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_write_to_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, suffix, target, invokerArgs);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_write_to_buffer(VipsImage *in, const char *suffix, void **buf, size_t *size, ...)
   * }
   */
  public static int image_write_to_buffer(Arena arena, MemorySegment in, String suffixString,
      MemorySegment buf, MemorySegment size, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_buffer", "in");
    }
    var suffix = arena.allocateFrom(suffixString);
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_buffer", "buf");
    }
    if(!VipsValidation.isValidPointer(size)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_buffer", "size");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_write_to_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, suffix, buf, size, invokerArgs);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_write_to_file(VipsImage *image, const char *name, ...)
   * }
   */
  public static int image_write_to_file(Arena arena, MemorySegment image, String nameString,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_file", "image");
    }
    var name = arena.allocateFrom(nameString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_write_to_file.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, name, invokerArgs);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_matrixv(int width, int height, ...)
   * }
   */
  public static MemorySegment image_new_matrixv(Arena arena, int width, int height,
      VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_new_matrixv.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(width, height, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_matrixv", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_source(VipsSource *source, const char *option_string, ...)
   * }
   */
  public static MemorySegment image_new_from_source(Arena arena, MemorySegment source,
      String option_stringString, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_source", "source");
    }
    var option_string = arena.allocateFrom(option_stringString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_new_from_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, option_string, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_from_source", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_buffer(const void *buf, size_t len, const char *option_string, ...)
   * }
   */
  public static MemorySegment image_new_from_buffer(Arena arena, MemorySegment buf, long len,
      String option_stringString, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_buffer", "buf");
    }
    var option_string = arena.allocateFrom(option_stringString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_new_from_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, option_string, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_from_buffer", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_file(const char *name, ...)
   * }
   */
  public static MemorySegment image_new_from_file(Arena arena, String nameString,
      VipsOption... options) throws VipsError {
    var name = arena.allocateFrom(nameString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_new_from_file.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(name, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_from_file", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_save_stringf(GValue *value, const char *fmt, ...)
   * }
   */
  public static void value_set_save_stringf(Arena arena, MemorySegment value, String fmtString,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_save_stringf", "value");
    }
    var fmt = arena.allocateFrom(fmtString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_value_set_save_stringf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    invoker.apply(value, fmt, invokerArgs);
  }
}
