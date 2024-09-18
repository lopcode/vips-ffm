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
   * gboolean vips_object_argument_isset(VipsObject *object, const char *name)
   * }
   */
  public static boolean object_argument_isset(Arena arena, MemorySegment object, String nameString)
      throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_argument_isset", "object");
    }
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw.vips_object_argument_isset(object, name);
    return result == 1;
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
   * void vips_object_set_property(GObject *gobject, guint property_id, const GValue *value, GParamSpec *pspec)
   * }
   */
  public static void object_set_property(MemorySegment gobject, int property_id,
      MemorySegment value, MemorySegment pspec) throws VipsError {
    if(!VipsValidation.isValidPointer(gobject)) {
      VipsValidation.throwInvalidInputError("vips_object_set_property", "gobject");
    }
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_object_set_property", "value");
    }
    if(!VipsValidation.isValidPointer(pspec)) {
      VipsValidation.throwInvalidInputError("vips_object_set_property", "pspec");
    }
    VipsRaw.vips_object_set_property(gobject, property_id, value, pspec);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_get_property(GObject *gobject, guint property_id, GValue *value, GParamSpec *pspec)
   * }
   */
  public static void object_get_property(MemorySegment gobject, int property_id,
      MemorySegment value, MemorySegment pspec) throws VipsError {
    if(!VipsValidation.isValidPointer(gobject)) {
      VipsValidation.throwInvalidInputError("vips_object_get_property", "gobject");
    }
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_object_get_property", "value");
    }
    if(!VipsValidation.isValidPointer(pspec)) {
      VipsValidation.throwInvalidInputError("vips_object_get_property", "pspec");
    }
    VipsRaw.vips_object_get_property(gobject, property_id, value, pspec);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_preclose(VipsObject *object)
   * }
   */
  public static void object_preclose(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_preclose", "object");
    }
    VipsRaw.vips_object_preclose(object);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_build(VipsObject *object)
   * }
   */
  public static int object_build(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_build", "object");
    }
    var result = VipsRaw.vips_object_build(object);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_summary_class(VipsObjectClass *klass, VipsBuf *buf)
   * }
   */
  public static void object_summary_class(MemorySegment klass, MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(klass)) {
      VipsValidation.throwInvalidInputError("vips_object_summary_class", "klass");
    }
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_object_summary_class", "buf");
    }
    VipsRaw.vips_object_summary_class(klass, buf);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_summary(VipsObject *object, VipsBuf *buf)
   * }
   */
  public static void object_summary(MemorySegment object, MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_summary", "object");
    }
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_object_summary", "buf");
    }
    VipsRaw.vips_object_summary(object, buf);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_dump(VipsObject *object, VipsBuf *buf)
   * }
   */
  public static void object_dump(MemorySegment object, MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_dump", "object");
    }
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_object_dump", "buf");
    }
    VipsRaw.vips_object_dump(object, buf);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_print_summary_class(VipsObjectClass *klass)
   * }
   */
  public static void object_print_summary_class(MemorySegment klass) throws VipsError {
    if(!VipsValidation.isValidPointer(klass)) {
      VipsValidation.throwInvalidInputError("vips_object_print_summary_class", "klass");
    }
    VipsRaw.vips_object_print_summary_class(klass);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_print_summary(VipsObject *object)
   * }
   */
  public static void object_print_summary(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_print_summary", "object");
    }
    VipsRaw.vips_object_print_summary(object);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_print_dump(VipsObject *object)
   * }
   */
  public static void object_print_dump(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_print_dump", "object");
    }
    VipsRaw.vips_object_print_dump(object);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_print_name(VipsObject *object)
   * }
   */
  public static void object_print_name(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_print_name", "object");
    }
    VipsRaw.vips_object_print_name(object);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_object_sanity(VipsObject *object)
   * }
   */
  public static boolean object_sanity(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_sanity", "object");
    }
    var result = VipsRaw.vips_object_sanity(object);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_object_get_type()
   * }
   */
  public static long object_get_type() throws VipsError {
    var result = VipsRaw.vips_object_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_class_install_argument(VipsObjectClass *cls, GParamSpec *pspec, VipsArgumentFlags flags, int priority, guint offset)
   * }
   */
  public static void object_class_install_argument(MemorySegment cls, MemorySegment pspec,
      int flags, int priority, int offset) throws VipsError {
    if(!VipsValidation.isValidPointer(cls)) {
      VipsValidation.throwInvalidInputError("vips_object_class_install_argument", "cls");
    }
    if(!VipsValidation.isValidPointer(pspec)) {
      VipsValidation.throwInvalidInputError("vips_object_class_install_argument", "pspec");
    }
    VipsRaw.vips_object_class_install_argument(cls, pspec, flags, priority, offset);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_set_argument_from_string(VipsObject *object, const char *name, const char *value)
   * }
   */
  public static int object_set_argument_from_string(Arena arena, MemorySegment object,
      String nameString, String valueString) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_set_argument_from_string", "object");
    }
    var name = arena.allocateFrom(nameString);
    var value = arena.allocateFrom(valueString);
    var result = VipsRaw.vips_object_set_argument_from_string(object, name, value);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_object_argument_needsstring(VipsObject *object, const char *name)
   * }
   */
  public static boolean object_argument_needsstring(Arena arena, MemorySegment object,
      String nameString) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_argument_needsstring", "object");
    }
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw.vips_object_argument_needsstring(object, name);
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
   * int vips_object_set_required(VipsObject *object, const char *value)
   * }
   */
  public static int object_set_required(Arena arena, MemorySegment object, String valueString)
      throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_set_required", "object");
    }
    var value = arena.allocateFrom(valueString);
    var result = VipsRaw.vips_object_set_required(object, value);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsObject *vips_object_new(GType type, VipsObjectSetArguments set, void *a, void *b)
   * }
   */
  public static MemorySegment object_new(Arena arena, long type, MemorySegment set, MemorySegment a,
      MemorySegment b) throws VipsError {
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_object_new", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_object_new", "b");
    }
    var result = VipsRaw.vips_object_new(type, set, a, b);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_object_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_set_valist(VipsObject *object, va_list ap)
   * }
   */
  public static int object_set_valist(MemorySegment object, MemorySegment ap) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_set_valist", "object");
    }
    var result = VipsRaw.vips_object_set_valist(object, ap);
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
   * VipsObject *vips_object_new_from_string(VipsObjectClass *object_class, const char *p)
   * }
   */
  public static MemorySegment object_new_from_string(Arena arena, MemorySegment object_class,
      String pString) throws VipsError {
    if(!VipsValidation.isValidPointer(object_class)) {
      VipsValidation.throwInvalidInputError("vips_object_new_from_string", "object_class");
    }
    var p = arena.allocateFrom(pString);
    var result = VipsRaw.vips_object_new_from_string(object_class, p);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_object_new_from_string", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_to_string(VipsObject *object, VipsBuf *buf)
   * }
   */
  public static void object_to_string(MemorySegment object, MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_to_string", "object");
    }
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_object_to_string", "buf");
    }
    VipsRaw.vips_object_to_string(object, buf);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_object_map(VipsSListMap2Fn fn, void *a, void *b)
   * }
   */
  public static MemorySegment object_map(Arena arena, MemorySegment fn, MemorySegment a,
      MemorySegment b) throws VipsError {
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_object_map", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_object_map", "b");
    }
    var result = VipsRaw.vips_object_map(fn, a, b);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_object_map", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
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
   * VipsObject **vips_object_local_array(VipsObject *parent, int n)
   * }
   */
  public static MemorySegment object_local_array(MemorySegment parent, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(parent)) {
      VipsValidation.throwInvalidInputError("vips_object_local_array", "parent");
    }
    var result = VipsRaw.vips_object_local_array(parent, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_object_local_array", "result");
    }
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_local_cb(VipsObject *vobject, GObject *gobject)
   * }
   */
  public static void object_local_cb(MemorySegment vobject, MemorySegment gobject) throws
      VipsError {
    if(!VipsValidation.isValidPointer(vobject)) {
      VipsValidation.throwInvalidInputError("vips_object_local_cb", "vobject");
    }
    if(!VipsValidation.isValidPointer(gobject)) {
      VipsValidation.throwInvalidInputError("vips_object_local_cb", "gobject");
    }
    VipsRaw.vips_object_local_cb(vobject, gobject);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_set_static(VipsObject *object, gboolean static_object)
   * }
   */
  public static void object_set_static(MemorySegment object, boolean static_objectBoolean) throws
      VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_set_static", "object");
    }
    var static_object = static_objectBoolean ? 1 : 0;
    VipsRaw.vips_object_set_static(object, static_object);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_print_all()
   * }
   */
  public static void object_print_all() throws VipsError {
    VipsRaw.vips_object_print_all();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_sanity_all()
   * }
   */
  public static void object_sanity_all() throws VipsError {
    VipsRaw.vips_object_sanity_all();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_rewind(VipsObject *object)
   * }
   */
  public static void object_rewind(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_rewind", "object");
    }
    VipsRaw.vips_object_rewind(object);
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
   * VipsArrayDouble *vips_array_double_new(const double *array, int n)
   * }
   */
  public static MemorySegment array_double_new(Arena arena, MemorySegment array, int n) throws
      VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_double_new", "array");
    }
    var result = VipsRaw.vips_array_double_new(array, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_double_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * double *vips_array_double_get(VipsArrayDouble *array, int *n)
   * }
   */
  public static MemorySegment array_double_get(Arena arena, MemorySegment array, MemorySegment n)
      throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_double_get", "array");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_array_double_get", "n");
    }
    var result = VipsRaw.vips_array_double_get(array, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_double_get", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
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
   * VipsArrayInt *vips_array_int_new(const int *array, int n)
   * }
   */
  public static MemorySegment array_int_new(Arena arena, MemorySegment array, int n) throws
      VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_int_new", "array");
    }
    var result = VipsRaw.vips_array_int_new(array, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_int_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int *vips_array_int_get(VipsArrayInt *array, int *n)
   * }
   */
  public static MemorySegment array_int_get(Arena arena, MemorySegment array, MemorySegment n)
      throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_int_get", "array");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_array_int_get", "n");
    }
    var result = VipsRaw.vips_array_int_get(array, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_int_get", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
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
   * void vips_source_minimise(VipsSource *source)
   * }
   */
  public static void source_minimise(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_minimise", "source");
    }
    VipsRaw.vips_source_minimise(source);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_source_unminimise(VipsSource *source)
   * }
   */
  public static int source_unminimise(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_unminimise", "source");
    }
    var result = VipsRaw.vips_source_unminimise(source);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_source_decode(VipsSource *source)
   * }
   */
  public static int source_decode(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_decode", "source");
    }
    var result = VipsRaw.vips_source_decode(source);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gint64 vips_source_read(VipsSource *source, void *data, size_t length)
   * }
   */
  public static long source_read(MemorySegment source, MemorySegment data, long length) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_read", "source");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_source_read", "data");
    }
    var result = VipsRaw.vips_source_read(source, data, length);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_source_is_mappable(VipsSource *source)
   * }
   */
  public static boolean source_is_mappable(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_is_mappable", "source");
    }
    var result = VipsRaw.vips_source_is_mappable(source);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_source_is_file(VipsSource *source)
   * }
   */
  public static boolean source_is_file(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_is_file", "source");
    }
    var result = VipsRaw.vips_source_is_file(source);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const void *vips_source_map(VipsSource *source, size_t *length)
   * }
   */
  public static MemorySegment source_map(Arena arena, MemorySegment source, MemorySegment length)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_map", "source");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_source_map", "length");
    }
    var result = VipsRaw.vips_source_map(source, length);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_source_map", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsBlob *vips_source_map_blob(VipsSource *source)
   * }
   */
  public static MemorySegment source_map_blob(Arena arena, MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_map_blob", "source");
    }
    var result = VipsRaw.vips_source_map_blob(source);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_source_map_blob", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gint64 vips_source_seek(VipsSource *source, gint64 offset, int whence)
   * }
   */
  public static long source_seek(MemorySegment source, long offset, int whence) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_seek", "source");
    }
    var result = VipsRaw.vips_source_seek(source, offset, whence);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_source_rewind(VipsSource *source)
   * }
   */
  public static int source_rewind(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_rewind", "source");
    }
    var result = VipsRaw.vips_source_rewind(source);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gint64 vips_source_sniff_at_most(VipsSource *source, unsigned char **data, size_t length)
   * }
   */
  public static long source_sniff_at_most(MemorySegment source, MemorySegment data, long length)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_sniff_at_most", "source");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_source_sniff_at_most", "data");
    }
    var result = VipsRaw.vips_source_sniff_at_most(source, data, length);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * unsigned char *vips_source_sniff(VipsSource *source, size_t length)
   * }
   */
  public static MemorySegment source_sniff(Arena arena, MemorySegment source, long length) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_sniff", "source");
    }
    var result = VipsRaw.vips_source_sniff(source, length);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_source_sniff", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gint64 vips_source_length(VipsSource *source)
   * }
   */
  public static long source_length(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_length", "source");
    }
    var result = VipsRaw.vips_source_length(source);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_source_custom_get_type()
   * }
   */
  public static long source_custom_get_type() throws VipsError {
    var result = VipsRaw.vips_source_custom_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsSourceCustom *vips_source_custom_new()
   * }
   */
  public static MemorySegment source_custom_new(Arena arena) throws VipsError {
    var result = VipsRaw.vips_source_custom_new();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_source_custom_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsSourceGInputStream *vips_source_g_input_stream_new(GInputStream *stream)
   * }
   */
  public static MemorySegment source_g_input_stream_new(Arena arena, MemorySegment stream) throws
      VipsError {
    if(!VipsValidation.isValidPointer(stream)) {
      VipsValidation.throwInvalidInputError("vips_source_g_input_stream_new", "stream");
    }
    var result = VipsRaw.vips_source_g_input_stream_new(stream);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_source_g_input_stream_new", "result");
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
   * int vips_target_write(VipsTarget *target, const void *data, size_t length)
   * }
   */
  public static int target_write(MemorySegment target, MemorySegment data, long length) throws
      VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_write", "target");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_target_write", "data");
    }
    var result = VipsRaw.vips_target_write(target, data, length);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gint64 vips_target_read(VipsTarget *target, void *buffer, size_t length)
   * }
   */
  public static long target_read(MemorySegment target, MemorySegment buffer, long length) throws
      VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_read", "target");
    }
    if(!VipsValidation.isValidPointer(buffer)) {
      VipsValidation.throwInvalidInputError("vips_target_read", "buffer");
    }
    var result = VipsRaw.vips_target_read(target, buffer, length);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gint64 vips_target_seek(VipsTarget *target, gint64 offset, int whence)
   * }
   */
  public static long target_seek(MemorySegment target, long offset, int whence) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_seek", "target");
    }
    var result = VipsRaw.vips_target_seek(target, offset, whence);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_target_end(VipsTarget *target)
   * }
   */
  public static int target_end(MemorySegment target) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_end", "target");
    }
    var result = VipsRaw.vips_target_end(target);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_target_finish(VipsTarget *target)
   * }
   */
  public static void target_finish(MemorySegment target) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_finish", "target");
    }
    VipsRaw.vips_target_finish(target);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * unsigned char *vips_target_steal(VipsTarget *target, size_t *length)
   * }
   */
  public static MemorySegment target_steal(Arena arena, MemorySegment target, MemorySegment length)
      throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_steal", "target");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_target_steal", "length");
    }
    var result = VipsRaw.vips_target_steal(target, length);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_target_steal", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * char *vips_target_steal_text(VipsTarget *target)
   * }
   */
  public static String target_steal_text(MemorySegment target) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_steal_text", "target");
    }
    var result = VipsRaw.vips_target_steal_text(target);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_target_steal_text", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_target_putc(VipsTarget *target, int ch)
   * }
   */
  public static int target_putc(MemorySegment target, int ch) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_putc", "target");
    }
    var result = VipsRaw.vips_target_putc(target, ch);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_target_writes(VipsTarget *target, const char *str)
   * }
   */
  public static int target_writes(Arena arena, MemorySegment target, String strString) throws
      VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_writes", "target");
    }
    var str = arena.allocateFrom(strString);
    var result = VipsRaw.vips_target_writes(target, str);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_target_write_amp(VipsTarget *target, const char *str)
   * }
   */
  public static int target_write_amp(Arena arena, MemorySegment target, String strString) throws
      VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_write_amp", "target");
    }
    var str = arena.allocateFrom(strString);
    var result = VipsRaw.vips_target_write_amp(target, str);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_target_custom_get_type()
   * }
   */
  public static long target_custom_get_type() throws VipsError {
    var result = VipsRaw.vips_target_custom_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsTargetCustom *vips_target_custom_new()
   * }
   */
  public static MemorySegment target_custom_new(Arena arena) throws VipsError {
    var result = VipsRaw.vips_target_custom_new();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_target_custom_new", "result");
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
   * void vips_image_invalidate_all(VipsImage *image)
   * }
   */
  public static void image_invalidate_all(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_invalidate_all", "image");
    }
    VipsRaw.vips_image_invalidate_all(image);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_minimise_all(VipsImage *image)
   * }
   */
  public static void image_minimise_all(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_minimise_all", "image");
    }
    VipsRaw.vips_image_minimise_all(image);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_is_sequential(VipsImage *image)
   * }
   */
  public static boolean image_is_sequential(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_is_sequential", "image");
    }
    var result = VipsRaw.vips_image_is_sequential(image);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_progress(VipsImage *image, gboolean progress)
   * }
   */
  public static void image_set_progress(MemorySegment image, boolean progressBoolean) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_progress", "image");
    }
    var progress = progressBoolean ? 1 : 0;
    VipsRaw.vips_image_set_progress(image, progress);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_iskilled(VipsImage *image)
   * }
   */
  public static boolean image_iskilled(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_iskilled", "image");
    }
    var result = VipsRaw.vips_image_iskilled(image);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_kill(VipsImage *image, gboolean kill)
   * }
   */
  public static void image_set_kill(MemorySegment image, boolean killBoolean) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_kill", "image");
    }
    var kill = killBoolean ? 1 : 0;
    VipsRaw.vips_image_set_kill(image, kill);
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
   * VipsImage *vips_image_memory()
   * }
   */
  public static MemorySegment image_memory(Arena arena) throws VipsError {
    var result = VipsRaw.vips_image_memory();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_memory", "result");
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
   * VipsImage *vips_image_matrix_from_array(int width, int height, const double *array, int size)
   * }
   */
  public static MemorySegment image_matrix_from_array(Arena arena, int width, int height,
      MemorySegment array, int size) throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_image_matrix_from_array", "array");
    }
    var result = VipsRaw.vips_image_matrix_from_array(width, height, array, size);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_matrix_from_array", "result");
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
   * void vips_image_set_delete_on_close(VipsImage *image, gboolean delete_on_close)
   * }
   */
  public static void image_set_delete_on_close(MemorySegment image, boolean delete_on_closeBoolean)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_delete_on_close", "image");
    }
    var delete_on_close = delete_on_closeBoolean ? 1 : 0;
    VipsRaw.vips_image_set_delete_on_close(image, delete_on_close);
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
   * int vips_image_decode_predict(VipsImage *in, int *bands, VipsBandFormat *format)
   * }
   */
  public static int image_decode_predict(MemorySegment in, MemorySegment bands,
      MemorySegment format) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_decode_predict", "in");
    }
    if(!VipsValidation.isValidPointer(bands)) {
      VipsValidation.throwInvalidInputError("vips_image_decode_predict", "bands");
    }
    if(!VipsValidation.isValidPointer(format)) {
      VipsValidation.throwInvalidInputError("vips_image_decode_predict", "format");
    }
    var result = VipsRaw.vips_image_decode_predict(in, bands, format);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_decode(VipsImage *in, VipsImage **out)
   * }
   */
  public static int image_decode(MemorySegment in, MemorySegment out) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_decode", "in");
    }
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_image_decode", "out");
    }
    var result = VipsRaw.vips_image_decode(in, out);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_encode(VipsImage *in, VipsImage **out, VipsCoding coding)
   * }
   */
  public static int image_encode(MemorySegment in, MemorySegment out, int coding) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_encode", "in");
    }
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_image_encode", "out");
    }
    var result = VipsRaw.vips_image_encode(in, out, coding);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_isMSBfirst(VipsImage *image)
   * }
   */
  public static boolean image_isMSBfirst(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_isMSBfirst", "image");
    }
    var result = VipsRaw.vips_image_isMSBfirst(image);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_isfile(VipsImage *image)
   * }
   */
  public static boolean image_isfile(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_isfile", "image");
    }
    var result = VipsRaw.vips_image_isfile(image);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_ispartial(VipsImage *image)
   * }
   */
  public static boolean image_ispartial(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_ispartial", "image");
    }
    var result = VipsRaw.vips_image_ispartial(image);
    return result == 1;
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
   * VipsImage *vips_image_copy_memory(VipsImage *image)
   * }
   */
  public static MemorySegment image_copy_memory(Arena arena, MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_copy_memory", "image");
    }
    var result = VipsRaw.vips_image_copy_memory(image);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_copy_memory", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_wio_input(VipsImage *image)
   * }
   */
  public static int image_wio_input(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_wio_input", "image");
    }
    var result = VipsRaw.vips_image_wio_input(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_pio_input(VipsImage *image)
   * }
   */
  public static int image_pio_input(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_pio_input", "image");
    }
    var result = VipsRaw.vips_image_pio_input(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_pio_output(VipsImage *image)
   * }
   */
  public static int image_pio_output(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_pio_output", "image");
    }
    var result = VipsRaw.vips_image_pio_output(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_inplace(VipsImage *image)
   * }
   */
  public static int image_inplace(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_inplace", "image");
    }
    var result = VipsRaw.vips_image_inplace(image);
    return result;
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
   * VipsArrayImage *vips_array_image_new(VipsImage **array, int n)
   * }
   */
  public static MemorySegment array_image_new(Arena arena, MemorySegment array, int n) throws
      VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_image_new", "array");
    }
    var result = VipsRaw.vips_array_image_new(array, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_image_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArrayImage *vips_array_image_new_from_string(const char *string, VipsAccess flags)
   * }
   */
  public static MemorySegment array_image_new_from_string(Arena arena, String stringString,
      int flags) throws VipsError {
    var string = arena.allocateFrom(stringString);
    var result = VipsRaw.vips_array_image_new_from_string(string, flags);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_image_new_from_string", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArrayImage *vips_array_image_empty()
   * }
   */
  public static MemorySegment array_image_empty(Arena arena) throws VipsError {
    var result = VipsRaw.vips_array_image_empty();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_image_empty", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArrayImage *vips_array_image_append(VipsArrayImage *array, VipsImage *image)
   * }
   */
  public static MemorySegment array_image_append(Arena arena, MemorySegment array,
      MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_image_append", "array");
    }
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_array_image_append", "image");
    }
    var result = VipsRaw.vips_array_image_append(array, image);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_image_append", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage **vips_array_image_get(VipsArrayImage *array, int *n)
   * }
   */
  public static MemorySegment array_image_get(MemorySegment array, MemorySegment n) throws
      VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_image_get", "array");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_array_image_get", "n");
    }
    var result = VipsRaw.vips_array_image_get(array, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_image_get", "result");
    }
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
   * void vips_image_free_buffer(VipsImage *image, void *buffer)
   * }
   */
  public static void image_free_buffer(MemorySegment image, MemorySegment buffer) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_free_buffer", "image");
    }
    if(!VipsValidation.isValidPointer(buffer)) {
      VipsValidation.throwInvalidInputError("vips_image_free_buffer", "buffer");
    }
    VipsRaw.vips_image_free_buffer(image, buffer);
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
   * int vips_image_generate(VipsImage *image, VipsStartFn start_fn, VipsGenerateFn generate_fn, VipsStopFn stop_fn, void *a, void *b)
   * }
   */
  public static int image_generate(MemorySegment image, MemorySegment start_fn,
      MemorySegment generate_fn, MemorySegment stop_fn, MemorySegment a, MemorySegment b) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_generate", "image");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_image_generate", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_image_generate", "b");
    }
    var result = VipsRaw.vips_image_generate(image, start_fn, generate_fn, stop_fn, a, b);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_pipeline_array(VipsImage *image, VipsDemandStyle hint, VipsImage **in)
   * }
   */
  public static int image_pipeline_array(MemorySegment image, int hint, MemorySegment in) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_pipeline_array", "image");
    }
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_pipeline_array", "in");
    }
    var result = VipsRaw.vips_image_pipeline_array(image, hint, in);
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
   * int vips_image_get_bands(const VipsImage *image)
   * }
   */
  public static int image_get_bands(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_bands", "image");
    }
    var result = VipsRaw.vips_image_get_bands(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsBandFormat vips_image_get_format(const VipsImage *image)
   * }
   */
  public static int image_get_format(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_format", "image");
    }
    var result = VipsRaw.vips_image_get_format(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * double vips_image_get_format_max(VipsBandFormat format)
   * }
   */
  public static double image_get_format_max(int format) throws VipsError {
    var result = VipsRaw.vips_image_get_format_max(format);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsBandFormat vips_image_guess_format(const VipsImage *image)
   * }
   */
  public static int image_guess_format(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_guess_format", "image");
    }
    var result = VipsRaw.vips_image_guess_format(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsCoding vips_image_get_coding(const VipsImage *image)
   * }
   */
  public static int image_get_coding(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_coding", "image");
    }
    var result = VipsRaw.vips_image_get_coding(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsInterpretation vips_image_get_interpretation(const VipsImage *image)
   * }
   */
  public static int image_get_interpretation(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_interpretation", "image");
    }
    var result = VipsRaw.vips_image_get_interpretation(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsInterpretation vips_image_guess_interpretation(const VipsImage *image)
   * }
   */
  public static int image_guess_interpretation(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_guess_interpretation", "image");
    }
    var result = VipsRaw.vips_image_guess_interpretation(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * double vips_image_get_xres(const VipsImage *image)
   * }
   */
  public static double image_get_xres(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_xres", "image");
    }
    var result = VipsRaw.vips_image_get_xres(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * double vips_image_get_yres(const VipsImage *image)
   * }
   */
  public static double image_get_yres(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_yres", "image");
    }
    var result = VipsRaw.vips_image_get_yres(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_xoffset(const VipsImage *image)
   * }
   */
  public static int image_get_xoffset(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_xoffset", "image");
    }
    var result = VipsRaw.vips_image_get_xoffset(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_yoffset(const VipsImage *image)
   * }
   */
  public static int image_get_yoffset(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_yoffset", "image");
    }
    var result = VipsRaw.vips_image_get_yoffset(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_image_get_filename(const VipsImage *image)
   * }
   */
  public static String image_get_filename(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_filename", "image");
    }
    var result = VipsRaw.vips_image_get_filename(image);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_get_filename", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_image_get_mode(const VipsImage *image)
   * }
   */
  public static String image_get_mode(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_mode", "image");
    }
    var result = VipsRaw.vips_image_get_mode(image);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_get_mode", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * double vips_image_get_scale(const VipsImage *image)
   * }
   */
  public static double image_get_scale(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_scale", "image");
    }
    var result = VipsRaw.vips_image_get_scale(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * double vips_image_get_offset(const VipsImage *image)
   * }
   */
  public static double image_get_offset(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_offset", "image");
    }
    var result = VipsRaw.vips_image_get_offset(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_page_height(VipsImage *image)
   * }
   */
  public static int image_get_page_height(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_page_height", "image");
    }
    var result = VipsRaw.vips_image_get_page_height(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_n_pages(VipsImage *image)
   * }
   */
  public static int image_get_n_pages(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_n_pages", "image");
    }
    var result = VipsRaw.vips_image_get_n_pages(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_n_subifds(VipsImage *image)
   * }
   */
  public static int image_get_n_subifds(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_n_subifds", "image");
    }
    var result = VipsRaw.vips_image_get_n_subifds(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_orientation(VipsImage *image)
   * }
   */
  public static int image_get_orientation(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_orientation", "image");
    }
    var result = VipsRaw.vips_image_get_orientation(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_get_orientation_swap(VipsImage *image)
   * }
   */
  public static boolean image_get_orientation_swap(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_orientation_swap", "image");
    }
    var result = VipsRaw.vips_image_get_orientation_swap(image);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_concurrency(VipsImage *image, int default_concurrency)
   * }
   */
  public static int image_get_concurrency(MemorySegment image, int default_concurrency) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_concurrency", "image");
    }
    var result = VipsRaw.vips_image_get_concurrency(image, default_concurrency);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const void *vips_image_get_data(VipsImage *image)
   * }
   */
  public static MemorySegment image_get_data(Arena arena, MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_data", "image");
    }
    var result = VipsRaw.vips_image_get_data(image);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_get_data", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_init_fields(VipsImage *image, int xsize, int ysize, int bands, VipsBandFormat format, VipsCoding coding, VipsInterpretation interpretation, double xres, double yres)
   * }
   */
  public static void image_init_fields(MemorySegment image, int xsize, int ysize, int bands,
      int format, int coding, int interpretation, double xres, double yres) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_init_fields", "image");
    }
    VipsRaw.vips_image_init_fields(image, xsize, ysize, bands, format, coding, interpretation, xres, yres);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set(VipsImage *image, const char *name, GValue *value)
   * }
   */
  public static void image_set(Arena arena, MemorySegment image, String nameString,
      MemorySegment value) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_image_set", "value");
    }
    VipsRaw.vips_image_set(image, name, value);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get(const VipsImage *image, const char *name, GValue *value_copy)
   * }
   */
  public static int image_get(Arena arena, MemorySegment image, String nameString,
      MemorySegment value_copy) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(value_copy)) {
      VipsValidation.throwInvalidInputError("vips_image_get", "value_copy");
    }
    var result = VipsRaw.vips_image_get(image, name, value_copy);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_as_string(const VipsImage *image, const char *name, char **out)
   * }
   */
  public static int image_get_as_string(Arena arena, MemorySegment image, String nameString,
      MemorySegment out) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_as_string", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_image_get_as_string", "out");
    }
    var result = VipsRaw.vips_image_get_as_string(image, name, out);
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
   * gboolean vips_image_remove(VipsImage *image, const char *name)
   * }
   */
  public static boolean image_remove(Arena arena, MemorySegment image, String nameString) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_remove", "image");
    }
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw.vips_image_remove(image, name);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_image_map(VipsImage *image, VipsImageMapFn fn, void *a)
   * }
   */
  public static MemorySegment image_map(Arena arena, MemorySegment image, MemorySegment fn,
      MemorySegment a) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_map", "image");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_image_map", "a");
    }
    var result = VipsRaw.vips_image_map(image, fn, a);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_map", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gchar **vips_image_get_fields(VipsImage *image)
   * }
   */
  public static MemorySegment image_get_fields(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_fields", "image");
    }
    var result = VipsRaw.vips_image_get_fields(image);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_get_fields", "result");
    }
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_area(VipsImage *image, const char *name, VipsCallbackFn free_fn, void *data)
   * }
   */
  public static void image_set_area(Arena arena, MemorySegment image, String nameString,
      MemorySegment free_fn, MemorySegment data) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_area", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_image_set_area", "data");
    }
    VipsRaw.vips_image_set_area(image, name, free_fn, data);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_area(const VipsImage *image, const char *name, const void **data)
   * }
   */
  public static int image_get_area(Arena arena, MemorySegment image, String nameString,
      MemorySegment data) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_area", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_image_get_area", "data");
    }
    var result = VipsRaw.vips_image_get_area(image, name, data);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_blob(VipsImage *image, const char *name, VipsCallbackFn free_fn, const void *data, size_t length)
   * }
   */
  public static void image_set_blob(Arena arena, MemorySegment image, String nameString,
      MemorySegment free_fn, MemorySegment data, long length) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_blob", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_image_set_blob", "data");
    }
    VipsRaw.vips_image_set_blob(image, name, free_fn, data, length);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_blob_copy(VipsImage *image, const char *name, const void *data, size_t length)
   * }
   */
  public static void image_set_blob_copy(Arena arena, MemorySegment image, String nameString,
      MemorySegment data, long length) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_blob_copy", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_image_set_blob_copy", "data");
    }
    VipsRaw.vips_image_set_blob_copy(image, name, data, length);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_blob(const VipsImage *image, const char *name, const void **data, size_t *length)
   * }
   */
  public static int image_get_blob(Arena arena, MemorySegment image, String nameString,
      MemorySegment data, MemorySegment length) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_blob", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_image_get_blob", "data");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_image_get_blob", "length");
    }
    var result = VipsRaw.vips_image_get_blob(image, name, data, length);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_int(const VipsImage *image, const char *name, int *out)
   * }
   */
  public static int image_get_int(Arena arena, MemorySegment image, String nameString,
      MemorySegment out) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_int", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_image_get_int", "out");
    }
    var result = VipsRaw.vips_image_get_int(image, name, out);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_int(VipsImage *image, const char *name, int i)
   * }
   */
  public static void image_set_int(Arena arena, MemorySegment image, String nameString, int i)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_int", "image");
    }
    var name = arena.allocateFrom(nameString);
    VipsRaw.vips_image_set_int(image, name, i);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_double(const VipsImage *image, const char *name, double *out)
   * }
   */
  public static int image_get_double(Arena arena, MemorySegment image, String nameString,
      MemorySegment out) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_double", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_image_get_double", "out");
    }
    var result = VipsRaw.vips_image_get_double(image, name, out);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_double(VipsImage *image, const char *name, double d)
   * }
   */
  public static void image_set_double(Arena arena, MemorySegment image, String nameString, double d)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_double", "image");
    }
    var name = arena.allocateFrom(nameString);
    VipsRaw.vips_image_set_double(image, name, d);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_string(const VipsImage *image, const char *name, const char **out)
   * }
   */
  public static int image_get_string(Arena arena, MemorySegment image, String nameString,
      MemorySegment out) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_string", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_image_get_string", "out");
    }
    var result = VipsRaw.vips_image_get_string(image, name, out);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_string(VipsImage *image, const char *name, const char *str)
   * }
   */
  public static void image_set_string(Arena arena, MemorySegment image, String nameString,
      String strString) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_string", "image");
    }
    var name = arena.allocateFrom(nameString);
    var str = arena.allocateFrom(strString);
    VipsRaw.vips_image_set_string(image, name, str);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_print_field(const VipsImage *image, const char *name)
   * }
   */
  public static void image_print_field(Arena arena, MemorySegment image, String nameString) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_print_field", "image");
    }
    var name = arena.allocateFrom(nameString);
    VipsRaw.vips_image_print_field(image, name);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_image(const VipsImage *image, const char *name, VipsImage **out)
   * }
   */
  public static int image_get_image(Arena arena, MemorySegment image, String nameString,
      MemorySegment out) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_image", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_image_get_image", "out");
    }
    var result = VipsRaw.vips_image_get_image(image, name, out);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_image(VipsImage *image, const char *name, VipsImage *im)
   * }
   */
  public static void image_set_image(Arena arena, MemorySegment image, String nameString,
      MemorySegment im) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_image", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_image_set_image", "im");
    }
    VipsRaw.vips_image_set_image(image, name, im);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_array_int(VipsImage *image, const char *name, const int *array, int n)
   * }
   */
  public static void image_set_array_int(Arena arena, MemorySegment image, String nameString,
      MemorySegment array, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_array_int", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_image_set_array_int", "array");
    }
    VipsRaw.vips_image_set_array_int(image, name, array, n);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_array_int(VipsImage *image, const char *name, int **out, int *n)
   * }
   */
  public static int image_get_array_int(Arena arena, MemorySegment image, String nameString,
      MemorySegment out, MemorySegment n) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_array_int", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_image_get_array_int", "out");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_image_get_array_int", "n");
    }
    var result = VipsRaw.vips_image_get_array_int(image, name, out, n);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_array_double(VipsImage *image, const char *name, double **out, int *n)
   * }
   */
  public static int image_get_array_double(Arena arena, MemorySegment image, String nameString,
      MemorySegment out, MemorySegment n) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_array_double", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_image_get_array_double", "out");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_image_get_array_double", "n");
    }
    var result = VipsRaw.vips_image_get_array_double(image, name, out, n);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_array_double(VipsImage *image, const char *name, const double *array, int n)
   * }
   */
  public static void image_set_array_double(Arena arena, MemorySegment image, String nameString,
      MemorySegment array, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_array_double", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_image_set_array_double", "array");
    }
    VipsRaw.vips_image_set_array_double(image, name, array, n);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_history_args(VipsImage *image, const char *name, int argc, char *argv[])
   * }
   */
  public static int image_history_args(Arena arena, MemorySegment image, String nameString,
      int argc, List<String> argvStringArray) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_history_args", "image");
    }
    var name = arena.allocateFrom(nameString);
    var argv = VipsInvoker.makeCharStarArray(arena, argvStringArray);
    var result = VipsRaw.vips_image_history_args(image, name, argc, argv);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_image_get_history(VipsImage *image)
   * }
   */
  public static String image_get_history(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_history", "image");
    }
    var result = VipsRaw.vips_image_get_history(image);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_get_history", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_get_type()
   * }
   */
  public static long operation_get_type() throws VipsError {
    var result = VipsRaw.vips_operation_get_type();
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
   * void vips_operation_class_print_usage(VipsOperationClass *operation_class)
   * }
   */
  public static void operation_class_print_usage(MemorySegment operation_class) throws VipsError {
    if(!VipsValidation.isValidPointer(operation_class)) {
      VipsValidation.throwInvalidInputError("vips_operation_class_print_usage", "operation_class");
    }
    VipsRaw.vips_operation_class_print_usage(operation_class);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_operation_invalidate(VipsOperation *operation)
   * }
   */
  public static void operation_invalidate(MemorySegment operation) throws VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_operation_invalidate", "operation");
    }
    VipsRaw.vips_operation_invalidate(operation);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_operation_call_valist(VipsOperation *operation, va_list ap)
   * }
   */
  public static int operation_call_valist(MemorySegment operation, MemorySegment ap) throws
      VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_operation_call_valist", "operation");
    }
    var result = VipsRaw.vips_operation_call_valist(operation, ap);
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
   * void vips_cache_drop_all()
   * }
   */
  public static void cache_drop_all() throws VipsError {
    VipsRaw.vips_cache_drop_all();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsOperation *vips_cache_operation_lookup(VipsOperation *operation)
   * }
   */
  public static MemorySegment cache_operation_lookup(Arena arena, MemorySegment operation) throws
      VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_cache_operation_lookup", "operation");
    }
    var result = VipsRaw.vips_cache_operation_lookup(operation);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_cache_operation_lookup", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_cache_operation_add(VipsOperation *operation)
   * }
   */
  public static void cache_operation_add(MemorySegment operation) throws VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_cache_operation_add", "operation");
    }
    VipsRaw.vips_cache_operation_add(operation);
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
   * void vips_cache_print()
   * }
   */
  public static void cache_print() throws VipsError {
    VipsRaw.vips_cache_print();
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
   * int vips_cache_get_max()
   * }
   */
  public static int cache_get_max() throws VipsError {
    var result = VipsRaw.vips_cache_get_max();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cache_get_size()
   * }
   */
  public static int cache_get_size() throws VipsError {
    var result = VipsRaw.vips_cache_get_size();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * size_t vips_cache_get_max_mem()
   * }
   */
  public static long cache_get_max_mem() throws VipsError {
    var result = VipsRaw.vips_cache_get_max_mem();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cache_get_max_files()
   * }
   */
  public static int cache_get_max_files() throws VipsError {
    var result = VipsRaw.vips_cache_get_max_files();
    return result;
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
   * void vips_operation_block_set(const char *name, gboolean state)
   * }
   */
  public static void operation_block_set(Arena arena, String nameString, boolean stateBoolean)
      throws VipsError {
    var name = arena.allocateFrom(nameString);
    var state = stateBoolean ? 1 : 0;
    VipsRaw.vips_operation_block_set(name, state);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_math_get_type()
   * }
   */
  public static long operation_math_get_type() throws VipsError {
    var result = VipsRaw.vips_operation_math_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_math2_get_type()
   * }
   */
  public static long operation_math2_get_type() throws VipsError {
    var result = VipsRaw.vips_operation_math2_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_round_get_type()
   * }
   */
  public static long operation_round_get_type() throws VipsError {
    var result = VipsRaw.vips_operation_round_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_relational_get_type()
   * }
   */
  public static long operation_relational_get_type() throws VipsError {
    var result = VipsRaw.vips_operation_relational_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_boolean_get_type()
   * }
   */
  public static long operation_boolean_get_type() throws VipsError {
    var result = VipsRaw.vips_operation_boolean_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_complex_get_type()
   * }
   */
  public static long operation_complex_get_type() throws VipsError {
    var result = VipsRaw.vips_operation_complex_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_complex2_get_type()
   * }
   */
  public static long operation_complex2_get_type() throws VipsError {
    var result = VipsRaw.vips_operation_complex2_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_complexget_get_type()
   * }
   */
  public static long operation_complexget_get_type() throws VipsError {
    var result = VipsRaw.vips_operation_complexget_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_image_type_get_type()
   * }
   */
  public static long image_type_get_type() throws VipsError {
    var result = VipsRaw.vips_image_type_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_morphology_get_type()
   * }
   */
  public static long operation_morphology_get_type() throws VipsError {
    var result = VipsRaw.vips_operation_morphology_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_flags_get_type()
   * }
   */
  public static long operation_flags_get_type() throws VipsError {
    var result = VipsRaw.vips_operation_flags_get_type();
    return result;
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
   * int vips_arrayjoin(VipsImage **in, VipsImage **out, int n, ...)
   * }
   */
  public static int arrayjoin(Arena arena, MemorySegment in, MemorySegment out, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_arrayjoin", "in");
    }
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_arrayjoin", "out");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_arrayjoin.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, n, invokerArgs);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cache(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public static int cache(Arena arena, MemorySegment in, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cache", "in");
    }
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_cache", "out");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cache.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_history_printf(VipsImage *image, const char *format, ...)
   * }
   */
  public static int image_history_printf(Arena arena, MemorySegment image, String formatString,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_history_printf", "image");
    }
    var format = arena.allocateFrom(formatString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_history_printf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, format, invokerArgs);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_pipelinev(VipsImage *image, VipsDemandStyle hint, ...)
   * }
   */
  public static int image_pipelinev(Arena arena, MemorySegment image, int hint,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_pipelinev", "image");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_pipelinev.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, hint, invokerArgs);
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
   * VipsArrayImage *vips_array_image_newv(int n, ...)
   * }
   */
  public static MemorySegment array_image_newv(Arena arena, int n, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_array_image_newv.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(n, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_image_newv", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
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
   * int vips_target_writef(VipsTarget *target, const char *fmt, ...)
   * }
   */
  public static int target_writef(Arena arena, MemorySegment target, String fmtString,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_writef", "target");
    }
    var fmt = arena.allocateFrom(fmtString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_target_writef.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(target, fmt, invokerArgs);
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

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArrayInt *vips_array_int_newv(int n, ...)
   * }
   */
  public static MemorySegment array_int_newv(Arena arena, int n, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_array_int_newv.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(n, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_int_newv", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArrayDouble *vips_array_double_newv(int n, ...)
   * }
   */
  public static MemorySegment array_double_newv(Arena arena, int n, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_array_double_newv.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(n, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_double_newv", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_set(VipsObject *object, ...)
   * }
   */
  public static int object_set(Arena arena, MemorySegment object, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_set", "object");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_object_set.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(object, invokerArgs);
    return result;
  }
}
