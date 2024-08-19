package app.photofox.vipsffm.generated;

import app.photofox.vipsffm.helper.VipsError;
import app.photofox.vipsffm.helper.VipsInvoker;
import app.photofox.vipsffm.helper.VipsOption;
import app.photofox.vipsffm.helper.VipsValidation;
import java.lang.String;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public final class Vips {
  private Arena arena;

  public Vips(Arena arena) {
    this(arena, "vips-ffm", false);
  }

  public Vips(Arena arena, String name, boolean allowUntrusted) {
    this.arena = arena;
    Vips.init(arena, name, allowUntrusted);
  }

  public static void init(Arena arena, String argv0, boolean allowUntrusted) {
    var nameCString = arena.allocateFrom(argv0);
    var result = VipsRaw.vips_init(nameCString);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_init");
    }
    VipsRaw.vips_block_untrusted_set(allowUntrusted ? 0 : 1);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_interpretation_get_type()
   * }
   */
  public long interpretationGetType() throws VipsError {
    return VipsRaw.vips_interpretation_get_type();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_band_format_get_type()
   * }
   */
  public long bandFormatGetType() throws VipsError {
    return VipsRaw.vips_band_format_get_type();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_coding_get_type()
   * }
   */
  public long codingGetType() throws VipsError {
    return VipsRaw.vips_coding_get_type();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_access_get_type()
   * }
   */
  public long accessGetType() throws VipsError {
    return VipsRaw.vips_access_get_type();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_morphology_get_type()
   * }
   */
  public long operationMorphologyGetType() throws VipsError {
    return VipsRaw.vips_operation_morphology_get_type();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_argument_flags_get_type()
   * }
   */
  public long argumentFlagsGetType() throws VipsError {
    return VipsRaw.vips_argument_flags_get_type();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_flags_get_type()
   * }
   */
  public long operationFlagsGetType() throws VipsError {
    return VipsRaw.vips_operation_flags_get_type();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_region_shrink_get_type()
   * }
   */
  public long regionShrinkGetType() throws VipsError {
    return VipsRaw.vips_region_shrink_get_type();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_kernel_get_type()
   * }
   */
  public long kernelGetType() throws VipsError {
    return VipsRaw.vips_kernel_get_type();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_size_get_type()
   * }
   */
  public long sizeGetType() throws VipsError {
    return VipsRaw.vips_size_get_type();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_token_get_type()
   * }
   */
  public long tokenGetType() throws VipsError {
    return VipsRaw.vips_token_get_type();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_autorot_remove_angle(VipsImage *image)
   * }
   */
  public void autorotRemoveAngle(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_autorot_remove_angle", "image");
    }
    VipsRaw.vips_autorot_remove_angle(image);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_colourspace_issupported(const VipsImage *image)
   * }
   */
  public int colourspaceIssupported(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_colourspace_issupported", "image");
    }
    return VipsRaw.vips_colourspace_issupported(image);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_icc_present()
   * }
   */
  public int iccPresent() throws VipsError {
    return VipsRaw.vips_icc_present();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_icc_ac2rc(VipsImage *in, VipsImage **out, const char *profile_filename)
   * }
   */
  public int iccAc2rc(MemorySegment in, MemorySegment out, MemorySegment profile_filename) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_icc_ac2rc", "in");
    }
    if(!VipsValidation.isValidPointer(profile_filename)) {
      VipsValidation.throwInvalidInputError("vips_icc_ac2rc", "profile_filename");
    }
    return VipsRaw.vips_icc_ac2rc(in, out, profile_filename);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_icc_is_compatible_profile(VipsImage *image, const void *data, size_t data_length)
   * }
   */
  public int iccIsCompatibleProfile(MemorySegment image, MemorySegment data, long data_length)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_icc_is_compatible_profile", "image");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_icc_is_compatible_profile", "data");
    }
    return VipsRaw.vips_icc_is_compatible_profile(image, data, data_length);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_col_Lab2XYZ(float L, float a, float b, float *X, float *Y, float *Z)
   * }
   */
  public void colLab2XYZ(float L, float a, float b, MemorySegment X, MemorySegment Y,
      MemorySegment Z) throws VipsError {
    if(!VipsValidation.isValidPointer(X)) {
      VipsValidation.throwInvalidInputError("vips_col_Lab2XYZ", "X");
    }
    if(!VipsValidation.isValidPointer(Y)) {
      VipsValidation.throwInvalidInputError("vips_col_Lab2XYZ", "Y");
    }
    if(!VipsValidation.isValidPointer(Z)) {
      VipsValidation.throwInvalidInputError("vips_col_Lab2XYZ", "Z");
    }
    VipsRaw.vips_col_Lab2XYZ(L, a, b, X, Y, Z);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_col_XYZ2Lab(float X, float Y, float Z, float *L, float *a, float *b)
   * }
   */
  public void colXYZ2Lab(float X, float Y, float Z, MemorySegment L, MemorySegment a,
      MemorySegment b) throws VipsError {
    if(!VipsValidation.isValidPointer(L)) {
      VipsValidation.throwInvalidInputError("vips_col_XYZ2Lab", "L");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_col_XYZ2Lab", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_col_XYZ2Lab", "b");
    }
    VipsRaw.vips_col_XYZ2Lab(X, Y, Z, L, a, b);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * double vips_col_ab2h(double a, double b)
   * }
   */
  public double colAb2h(double a, double b) throws VipsError {
    return VipsRaw.vips_col_ab2h(a, b);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_col_ab2Ch(float a, float b, float *C, float *h)
   * }
   */
  public void colAb2Ch(float a, float b, MemorySegment C, MemorySegment h) throws VipsError {
    if(!VipsValidation.isValidPointer(C)) {
      VipsValidation.throwInvalidInputError("vips_col_ab2Ch", "C");
    }
    if(!VipsValidation.isValidPointer(h)) {
      VipsValidation.throwInvalidInputError("vips_col_ab2Ch", "h");
    }
    VipsRaw.vips_col_ab2Ch(a, b, C, h);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_col_Ch2ab(float C, float h, float *a, float *b)
   * }
   */
  public void colCh2ab(float C, float h, MemorySegment a, MemorySegment b) throws VipsError {
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_col_Ch2ab", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_col_Ch2ab", "b");
    }
    VipsRaw.vips_col_Ch2ab(C, h, a, b);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_col_L2Lcmc(float L)
   * }
   */
  public float colL2Lcmc(float L) throws VipsError {
    return VipsRaw.vips_col_L2Lcmc(L);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_col_C2Ccmc(float C)
   * }
   */
  public float colC2Ccmc(float C) throws VipsError {
    return VipsRaw.vips_col_C2Ccmc(C);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_col_Ch2hcmc(float C, float h)
   * }
   */
  public float colCh2hcmc(float C, float h) throws VipsError {
    return VipsRaw.vips_col_Ch2hcmc(C, h);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_col_make_tables_CMC()
   * }
   */
  public void colMakeTablesCMC() throws VipsError {
    VipsRaw.vips_col_make_tables_CMC();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_col_Lcmc2L(float Lcmc)
   * }
   */
  public float colLcmc2L(float Lcmc) throws VipsError {
    return VipsRaw.vips_col_Lcmc2L(Lcmc);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_col_Ccmc2C(float Ccmc)
   * }
   */
  public float colCcmc2C(float Ccmc) throws VipsError {
    return VipsRaw.vips_col_Ccmc2C(Ccmc);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_col_Chcmc2h(float C, float hcmc)
   * }
   */
  public float colChcmc2h(float C, float hcmc) throws VipsError {
    return VipsRaw.vips_col_Chcmc2h(C, hcmc);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_sRGB2scRGB_8(int r, int g, int b, float *R, float *G, float *B)
   * }
   */
  public int colSRGB2scRGB8(int r, int g, int b, MemorySegment R, MemorySegment G, MemorySegment B)
      throws VipsError {
    if(!VipsValidation.isValidPointer(R)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_8", "R");
    }
    if(!VipsValidation.isValidPointer(G)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_8", "G");
    }
    if(!VipsValidation.isValidPointer(B)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_8", "B");
    }
    return VipsRaw.vips_col_sRGB2scRGB_8(r, g, b, R, G, B);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_sRGB2scRGB_16(int r, int g, int b, float *R, float *G, float *B)
   * }
   */
  public int colSRGB2scRGB16(int r, int g, int b, MemorySegment R, MemorySegment G, MemorySegment B)
      throws VipsError {
    if(!VipsValidation.isValidPointer(R)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_16", "R");
    }
    if(!VipsValidation.isValidPointer(G)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_16", "G");
    }
    if(!VipsValidation.isValidPointer(B)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_16", "B");
    }
    return VipsRaw.vips_col_sRGB2scRGB_16(r, g, b, R, G, B);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_sRGB2scRGB_8_noclip(int r, int g, int b, float *R, float *G, float *B)
   * }
   */
  public int colSRGB2scRGB8Noclip(int r, int g, int b, MemorySegment R, MemorySegment G,
      MemorySegment B) throws VipsError {
    if(!VipsValidation.isValidPointer(R)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_8_noclip", "R");
    }
    if(!VipsValidation.isValidPointer(G)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_8_noclip", "G");
    }
    if(!VipsValidation.isValidPointer(B)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_8_noclip", "B");
    }
    return VipsRaw.vips_col_sRGB2scRGB_8_noclip(r, g, b, R, G, B);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_sRGB2scRGB_16_noclip(int r, int g, int b, float *R, float *G, float *B)
   * }
   */
  public int colSRGB2scRGB16Noclip(int r, int g, int b, MemorySegment R, MemorySegment G,
      MemorySegment B) throws VipsError {
    if(!VipsValidation.isValidPointer(R)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_16_noclip", "R");
    }
    if(!VipsValidation.isValidPointer(G)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_16_noclip", "G");
    }
    if(!VipsValidation.isValidPointer(B)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_16_noclip", "B");
    }
    return VipsRaw.vips_col_sRGB2scRGB_16_noclip(r, g, b, R, G, B);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_scRGB2XYZ(float R, float G, float B, float *X, float *Y, float *Z)
   * }
   */
  public int colScRGB2XYZ(float R, float G, float B, MemorySegment X, MemorySegment Y,
      MemorySegment Z) throws VipsError {
    if(!VipsValidation.isValidPointer(X)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2XYZ", "X");
    }
    if(!VipsValidation.isValidPointer(Y)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2XYZ", "Y");
    }
    if(!VipsValidation.isValidPointer(Z)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2XYZ", "Z");
    }
    return VipsRaw.vips_col_scRGB2XYZ(R, G, B, X, Y, Z);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_XYZ2scRGB(float X, float Y, float Z, float *R, float *G, float *B)
   * }
   */
  public int colXYZ2scRGB(float X, float Y, float Z, MemorySegment R, MemorySegment G,
      MemorySegment B) throws VipsError {
    if(!VipsValidation.isValidPointer(R)) {
      VipsValidation.throwInvalidInputError("vips_col_XYZ2scRGB", "R");
    }
    if(!VipsValidation.isValidPointer(G)) {
      VipsValidation.throwInvalidInputError("vips_col_XYZ2scRGB", "G");
    }
    if(!VipsValidation.isValidPointer(B)) {
      VipsValidation.throwInvalidInputError("vips_col_XYZ2scRGB", "B");
    }
    return VipsRaw.vips_col_XYZ2scRGB(X, Y, Z, R, G, B);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_scRGB2sRGB_8(float R, float G, float B, int *r, int *g, int *b, int *og)
   * }
   */
  public int colScRGB2sRGB8(float R, float G, float B, MemorySegment r, MemorySegment g,
      MemorySegment b, MemorySegment og) throws VipsError {
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2sRGB_8", "r");
    }
    if(!VipsValidation.isValidPointer(g)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2sRGB_8", "g");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2sRGB_8", "b");
    }
    if(!VipsValidation.isValidPointer(og)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2sRGB_8", "og");
    }
    return VipsRaw.vips_col_scRGB2sRGB_8(R, G, B, r, g, b, og);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_scRGB2sRGB_16(float R, float G, float B, int *r, int *g, int *b, int *og)
   * }
   */
  public int colScRGB2sRGB16(float R, float G, float B, MemorySegment r, MemorySegment g,
      MemorySegment b, MemorySegment og) throws VipsError {
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2sRGB_16", "r");
    }
    if(!VipsValidation.isValidPointer(g)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2sRGB_16", "g");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2sRGB_16", "b");
    }
    if(!VipsValidation.isValidPointer(og)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2sRGB_16", "og");
    }
    return VipsRaw.vips_col_scRGB2sRGB_16(R, G, B, r, g, b, og);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_scRGB2BW_16(float R, float G, float B, int *g, int *og)
   * }
   */
  public int colScRGB2BW16(float R, float G, float B, MemorySegment g, MemorySegment og) throws
      VipsError {
    if(!VipsValidation.isValidPointer(g)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2BW_16", "g");
    }
    if(!VipsValidation.isValidPointer(og)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2BW_16", "og");
    }
    return VipsRaw.vips_col_scRGB2BW_16(R, G, B, g, og);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_scRGB2BW_8(float R, float G, float B, int *g, int *og)
   * }
   */
  public int colScRGB2BW8(float R, float G, float B, MemorySegment g, MemorySegment og) throws
      VipsError {
    if(!VipsValidation.isValidPointer(g)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2BW_8", "g");
    }
    if(!VipsValidation.isValidPointer(og)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2BW_8", "og");
    }
    return VipsRaw.vips_col_scRGB2BW_8(R, G, B, g, og);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_pythagoras(float L1, float a1, float b1, float L2, float a2, float b2)
   * }
   */
  public float pythagoras(float L1, float a1, float b1, float L2, float a2, float b2) throws
      VipsError {
    return VipsRaw.vips_pythagoras(L1, a1, b1, L2, a2, b2);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_col_dE00(float L1, float a1, float b1, float L2, float a2, float b2)
   * }
   */
  public float colDE00(float L1, float a1, float b1, float L2, float a2, float b2) throws
      VipsError {
    return VipsRaw.vips_col_dE00(L1, a1, b1, L2, a2, b2);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_init(const char *argv0)
   * }
   */
  public int init(MemorySegment argv0) throws VipsError {
    if(!VipsValidation.isValidPointer(argv0)) {
      VipsValidation.throwInvalidInputError("vips_init", "argv0");
    }
    return VipsRaw.vips_init(argv0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_get_argv0()
   * }
   */
  public MemorySegment getArgv0() throws VipsError {
    return VipsRaw.vips_get_argv0();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_get_prgname()
   * }
   */
  public MemorySegment getPrgname() throws VipsError {
    return VipsRaw.vips_get_prgname();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_shutdown()
   * }
   */
  public void shutdown() throws VipsError {
    VipsRaw.vips_shutdown();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_thread_shutdown()
   * }
   */
  public void threadShutdown() throws VipsError {
    VipsRaw.vips_thread_shutdown();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_add_option_entries(GOptionGroup *option_group)
   * }
   */
  public void addOptionEntries(MemorySegment option_group) throws VipsError {
    if(!VipsValidation.isValidPointer(option_group)) {
      VipsValidation.throwInvalidInputError("vips_add_option_entries", "option_group");
    }
    VipsRaw.vips_add_option_entries(option_group);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_leak_set(gboolean leak)
   * }
   */
  public void leakSet(int leak) throws VipsError {
    VipsRaw.vips_leak_set(leak);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_block_untrusted_set(gboolean state)
   * }
   */
  public void blockUntrustedSet(int state) throws VipsError {
    VipsRaw.vips_block_untrusted_set(state);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_version_string()
   * }
   */
  public MemorySegment versionString() throws VipsError {
    return VipsRaw.vips_version_string();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_version(int flag)
   * }
   */
  public int version(int flag) throws VipsError {
    return VipsRaw.vips_version(flag);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_guess_prefix(const char *argv0, const char *env_name)
   * }
   */
  public MemorySegment guessPrefix(MemorySegment argv0, MemorySegment env_name) throws VipsError {
    if(!VipsValidation.isValidPointer(argv0)) {
      VipsValidation.throwInvalidInputError("vips_guess_prefix", "argv0");
    }
    if(!VipsValidation.isValidPointer(env_name)) {
      VipsValidation.throwInvalidInputError("vips_guess_prefix", "env_name");
    }
    return VipsRaw.vips_guess_prefix(argv0, env_name);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_guess_libdir(const char *argv0, const char *env_name)
   * }
   */
  public MemorySegment guessLibdir(MemorySegment argv0, MemorySegment env_name) throws VipsError {
    if(!VipsValidation.isValidPointer(argv0)) {
      VipsValidation.throwInvalidInputError("vips_guess_libdir", "argv0");
    }
    if(!VipsValidation.isValidPointer(env_name)) {
      VipsValidation.throwInvalidInputError("vips_guess_libdir", "env_name");
    }
    return VipsRaw.vips_guess_libdir(argv0, env_name);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_perlin(VipsImage **out, int width, int height, ...)
   * }
   */
  public void perlin(MemorySegment out, int width, int height, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_perlin.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_perlin");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_worley(VipsImage **out, int width, int height, ...)
   * }
   */
  public void worley(MemorySegment out, int width, int height, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_worley.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_worley");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_fractsurf(VipsImage **out, int width, int height, double fractal_dimension, ...)
   * }
   */
  public void fractsurf(MemorySegment out, int width, int height, double fractal_dimension,
      VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_fractsurf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, fractal_dimension, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_fractsurf");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_fractal(VipsImage **out, int width, int height, double fractal_dimension, ...)
   * }
   */
  public void maskFractal(MemorySegment out, int width, int height, double fractal_dimension,
      VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_fractal.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, fractal_dimension, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_fractal");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_gaussian_band(VipsImage **out, int width, int height, double frequency_cutoff_x, double frequency_cutoff_y, double radius, double amplitude_cutoff, ...)
   * }
   */
  public void maskGaussianBand(MemorySegment out, int width, int height, double frequency_cutoff_x,
      double frequency_cutoff_y, double radius, double amplitude_cutoff, VipsOption... options)
      throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_gaussian_band.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, frequency_cutoff_x, frequency_cutoff_y, radius, amplitude_cutoff, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_gaussian_band");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_gaussian_ring(VipsImage **out, int width, int height, double frequency_cutoff, double amplitude_cutoff, double ringwidth, ...)
   * }
   */
  public void maskGaussianRing(MemorySegment out, int width, int height, double frequency_cutoff,
      double amplitude_cutoff, double ringwidth, VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_gaussian_ring.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, frequency_cutoff, amplitude_cutoff, ringwidth, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_gaussian_ring");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_gaussian(VipsImage **out, int width, int height, double frequency_cutoff, double amplitude_cutoff, ...)
   * }
   */
  public void maskGaussian(MemorySegment out, int width, int height, double frequency_cutoff,
      double amplitude_cutoff, VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_gaussian.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, frequency_cutoff, amplitude_cutoff, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_gaussian");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_butterworth_band(VipsImage **out, int width, int height, double order, double frequency_cutoff_x, double frequency_cutoff_y, double radius, double amplitude_cutoff, ...)
   * }
   */
  public void maskButterworthBand(MemorySegment out, int width, int height, double order,
      double frequency_cutoff_x, double frequency_cutoff_y, double radius, double amplitude_cutoff,
      VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_butterworth_band.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, order, frequency_cutoff_x, frequency_cutoff_y, radius, amplitude_cutoff, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_butterworth_band");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_butterworth_ring(VipsImage **out, int width, int height, double order, double frequency_cutoff, double amplitude_cutoff, double ringwidth, ...)
   * }
   */
  public void maskButterworthRing(MemorySegment out, int width, int height, double order,
      double frequency_cutoff, double amplitude_cutoff, double ringwidth, VipsOption... options)
      throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_butterworth_ring.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, order, frequency_cutoff, amplitude_cutoff, ringwidth, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_butterworth_ring");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_butterworth(VipsImage **out, int width, int height, double order, double frequency_cutoff, double amplitude_cutoff, ...)
   * }
   */
  public void maskButterworth(MemorySegment out, int width, int height, double order,
      double frequency_cutoff, double amplitude_cutoff, VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_butterworth.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, order, frequency_cutoff, amplitude_cutoff, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_butterworth");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_ideal_band(VipsImage **out, int width, int height, double frequency_cutoff_x, double frequency_cutoff_y, double radius, ...)
   * }
   */
  public void maskIdealBand(MemorySegment out, int width, int height, double frequency_cutoff_x,
      double frequency_cutoff_y, double radius, VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_ideal_band.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, frequency_cutoff_x, frequency_cutoff_y, radius, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_ideal_band");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_ideal_ring(VipsImage **out, int width, int height, double frequency_cutoff, double ringwidth, ...)
   * }
   */
  public void maskIdealRing(MemorySegment out, int width, int height, double frequency_cutoff,
      double ringwidth, VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_ideal_ring.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, frequency_cutoff, ringwidth, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_ideal_ring");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_ideal(VipsImage **out, int width, int height, double frequency_cutoff, ...)
   * }
   */
  public void maskIdeal(MemorySegment out, int width, int height, double frequency_cutoff,
      VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_ideal.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, frequency_cutoff, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_ideal");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tonelut(VipsImage **out, ...)
   * }
   */
  public void tonelut(MemorySegment out, VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tonelut.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tonelut");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_invertlut(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void invertlut(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_invertlut", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_invertlut.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_invertlut");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_buildlut(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void buildlut(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_buildlut", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_buildlut.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_buildlut");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_identity(VipsImage **out, ...)
   * }
   */
  public void identity(MemorySegment out, VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_identity.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_identity");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_zone(VipsImage **out, int width, int height, ...)
   * }
   */
  public void zone(MemorySegment out, int width, int height, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_zone.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_zone");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sines(VipsImage **out, int width, int height, ...)
   * }
   */
  public void sines(MemorySegment out, int width, int height, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sines.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sines");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_eye(VipsImage **out, int width, int height, ...)
   * }
   */
  public void eye(MemorySegment out, int width, int height, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_eye.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_eye");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gaussnoise(VipsImage **out, int width, int height, ...)
   * }
   */
  public void gaussnoise(MemorySegment out, int width, int height, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gaussnoise.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gaussnoise");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_text(VipsImage **out, const char *text, ...)
   * }
   */
  public void text(MemorySegment out, MemorySegment text, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(text)) {
      VipsValidation.throwInvalidInputError("vips_text", "text");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_text.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, text, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_text");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_logmat(VipsImage **out, double sigma, double min_ampl, ...)
   * }
   */
  public void logmat(MemorySegment out, double sigma, double min_ampl, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_logmat.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, sigma, min_ampl, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_logmat");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gaussmat(VipsImage **out, double sigma, double min_ampl, ...)
   * }
   */
  public void gaussmat(MemorySegment out, double sigma, double min_ampl, VipsOption... options)
      throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gaussmat.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, sigma, min_ampl, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gaussmat");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_grey(VipsImage **out, int width, int height, ...)
   * }
   */
  public void grey(MemorySegment out, int width, int height, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_grey.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_grey");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_xyz(VipsImage **out, int width, int height, ...)
   * }
   */
  public void xyz(MemorySegment out, int width, int height, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_xyz.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_xyz");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_black(VipsImage **out, int width, int height, ...)
   * }
   */
  public void black(MemorySegment out, int width, int height, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_black.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_black");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_smudge(VipsImage *image, int left, int top, int width, int height, ...)
   * }
   */
  public void drawSmudge(MemorySegment image, int left, int top, int width, int height,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_smudge", "image");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_smudge.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, left, top, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_smudge");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_flood1(VipsImage *image, double ink, int x, int y, ...)
   * }
   */
  public void drawFlood1(MemorySegment image, double ink, int x, int y, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_flood1", "image");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_flood1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, ink, x, y, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_flood1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_flood(VipsImage *image, double *ink, int n, int x, int y, ...)
   * }
   */
  public void drawFlood(MemorySegment image, MemorySegment ink, int n, int x, int y,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_flood", "image");
    }
    if(!VipsValidation.isValidPointer(ink)) {
      VipsValidation.throwInvalidInputError("vips_draw_flood", "ink");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_flood.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, ink, n, x, y, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_flood");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_circle1(VipsImage *image, double ink, int cx, int cy, int radius, ...)
   * }
   */
  public void drawCircle1(MemorySegment image, double ink, int cx, int cy, int radius,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_circle1", "image");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_circle1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, ink, cx, cy, radius, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_circle1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_circle(VipsImage *image, double *ink, int n, int cx, int cy, int radius, ...)
   * }
   */
  public void drawCircle(MemorySegment image, MemorySegment ink, int n, int cx, int cy, int radius,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_circle", "image");
    }
    if(!VipsValidation.isValidPointer(ink)) {
      VipsValidation.throwInvalidInputError("vips_draw_circle", "ink");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_circle.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, ink, n, cx, cy, radius, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_circle");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_line1(VipsImage *image, double ink, int x1, int y1, int x2, int y2, ...)
   * }
   */
  public void drawLine1(MemorySegment image, double ink, int x1, int y1, int x2, int y2,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_line1", "image");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_line1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, ink, x1, y1, x2, y2, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_line1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_line(VipsImage *image, double *ink, int n, int x1, int y1, int x2, int y2, ...)
   * }
   */
  public void drawLine(MemorySegment image, MemorySegment ink, int n, int x1, int y1, int x2,
      int y2, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_line", "image");
    }
    if(!VipsValidation.isValidPointer(ink)) {
      VipsValidation.throwInvalidInputError("vips_draw_line", "ink");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_line.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, ink, n, x1, y1, x2, y2, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_line");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_mask1(VipsImage *image, double ink, VipsImage *mask, int x, int y, ...)
   * }
   */
  public void drawMask1(MemorySegment image, double ink, MemorySegment mask, int x, int y,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_mask1", "image");
    }
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_draw_mask1", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_mask1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, ink, mask, x, y, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_mask1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_mask(VipsImage *image, double *ink, int n, VipsImage *mask, int x, int y, ...)
   * }
   */
  public void drawMask(MemorySegment image, MemorySegment ink, int n, MemorySegment mask, int x,
      int y, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_mask", "image");
    }
    if(!VipsValidation.isValidPointer(ink)) {
      VipsValidation.throwInvalidInputError("vips_draw_mask", "ink");
    }
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_draw_mask", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_mask.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, ink, n, mask, x, y, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_mask");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_image(VipsImage *image, VipsImage *sub, int x, int y, ...)
   * }
   */
  public void drawImage(MemorySegment image, MemorySegment sub, int x, int y, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_image", "image");
    }
    if(!VipsValidation.isValidPointer(sub)) {
      VipsValidation.throwInvalidInputError("vips_draw_image", "sub");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_image.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, sub, x, y, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_image");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_point1(VipsImage *image, double ink, int x, int y, ...)
   * }
   */
  public void drawPoint1(MemorySegment image, double ink, int x, int y, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_point1", "image");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_point1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, ink, x, y, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_point1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_point(VipsImage *image, double *ink, int n, int x, int y, ...)
   * }
   */
  public void drawPoint(MemorySegment image, MemorySegment ink, int n, int x, int y,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_point", "image");
    }
    if(!VipsValidation.isValidPointer(ink)) {
      VipsValidation.throwInvalidInputError("vips_draw_point", "ink");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_point.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, ink, n, x, y, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_point");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_rect1(VipsImage *image, double ink, int left, int top, int width, int height, ...)
   * }
   */
  public void drawRect1(MemorySegment image, double ink, int left, int top, int width, int height,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_rect1", "image");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_rect1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, ink, left, top, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_rect1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_draw_rect(VipsImage *image, double *ink, int n, int left, int top, int width, int height, ...)
   * }
   */
  public void drawRect(MemorySegment image, MemorySegment ink, int n, int left, int top, int width,
      int height, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_draw_rect", "image");
    }
    if(!VipsValidation.isValidPointer(ink)) {
      VipsValidation.throwInvalidInputError("vips_draw_rect", "ink");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_draw_rect.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, ink, n, left, top, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_draw_rect");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_dECMC(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void dECMC(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_dECMC", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_dECMC", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_dECMC.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_dECMC");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_dE00(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void dE00(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_dE00", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_dE00", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_dE00.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_dE00");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_dE76(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void dE76(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_dE76", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_dE76", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_dE76.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_dE76");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_icc_export(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void iccExport(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_icc_export", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_icc_export.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_icc_export");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_icc_import(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void iccImport(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_icc_import", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_icc_import.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_icc_import");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_icc_transform(VipsImage *in, VipsImage **out, const char *output_profile, ...)
   * }
   */
  public void iccTransform(MemorySegment in, MemorySegment out, MemorySegment output_profile,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_icc_transform", "in");
    }
    if(!VipsValidation.isValidPointer(output_profile)) {
      VipsValidation.throwInvalidInputError("vips_icc_transform", "output_profile");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_icc_transform.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, output_profile, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_icc_transform");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_profile_load(const char *name, VipsBlob **profile, ...)
   * }
   */
  public void profileLoad(MemorySegment name, MemorySegment profile, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(name)) {
      VipsValidation.throwInvalidInputError("vips_profile_load", "name");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_profile_load.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(name, profile, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_profile_load");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_XYZ2CMYK(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void xYZ2CMYK(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_XYZ2CMYK", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_XYZ2CMYK.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_XYZ2CMYK");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_CMYK2XYZ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void cMYK2XYZ(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_CMYK2XYZ", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_CMYK2XYZ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_CMYK2XYZ");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_Lab2LabS(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void lab2LabS(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_Lab2LabS", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_Lab2LabS.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_Lab2LabS");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LabS2Lab(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void labS2Lab(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LabS2Lab", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LabS2Lab.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LabS2Lab");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_Yxy2XYZ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void yxy2XYZ(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_Yxy2XYZ", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_Yxy2XYZ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_Yxy2XYZ");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_XYZ2Yxy(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void xYZ2Yxy(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_XYZ2Yxy", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_XYZ2Yxy.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_XYZ2Yxy");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_CMC2LCh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void cMC2LCh(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_CMC2LCh", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_CMC2LCh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_CMC2LCh");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LCh2CMC(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void lCh2CMC(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LCh2CMC", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LCh2CMC.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LCh2CMC");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sRGB2HSV(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sRGB2HSV(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sRGB2HSV", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sRGB2HSV.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sRGB2HSV");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_HSV2sRGB(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void hSV2sRGB(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_HSV2sRGB", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_HSV2sRGB.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_HSV2sRGB");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_scRGB2XYZ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void scRGB2XYZ(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_scRGB2XYZ", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_scRGB2XYZ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_scRGB2XYZ");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sRGB2scRGB(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sRGB2scRGB(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sRGB2scRGB", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sRGB2scRGB.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sRGB2scRGB");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_scRGB2BW(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void scRGB2BW(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_scRGB2BW", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_scRGB2BW.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_scRGB2BW");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_scRGB2sRGB(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void scRGB2sRGB(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_scRGB2sRGB", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_scRGB2sRGB.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_scRGB2sRGB");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_XYZ2scRGB(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void xYZ2scRGB(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_XYZ2scRGB", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_XYZ2scRGB.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_XYZ2scRGB");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_XYZ2Lab(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void xYZ2Lab(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_XYZ2Lab", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_XYZ2Lab.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_XYZ2Lab");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_Lab2XYZ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void lab2XYZ(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_Lab2XYZ", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_Lab2XYZ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_Lab2XYZ");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_CMC2XYZ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void cMC2XYZ(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_CMC2XYZ", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_CMC2XYZ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_CMC2XYZ");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_Yxy2Lab(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void yxy2Lab(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_Yxy2Lab", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_Yxy2Lab.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_Yxy2Lab");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_Lab2LCh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void lab2LCh(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_Lab2LCh", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_Lab2LCh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_Lab2LCh");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LCh2Lab(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void lCh2Lab(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LCh2Lab", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LCh2Lab.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LCh2Lab");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_Lab2LabQ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void lab2LabQ(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_Lab2LabQ", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_Lab2LabQ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_Lab2LabQ");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LabQ2Lab(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void labQ2Lab(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LabQ2Lab", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LabQ2Lab.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LabQ2Lab");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LabQ2LabS(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void labQ2LabS(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LabQ2LabS", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LabQ2LabS.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LabQ2LabS");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LabS2LabQ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void labS2LabQ(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LabS2LabQ", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LabS2LabQ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LabS2LabQ");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_float2rad(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void float2rad(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_float2rad", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_float2rad.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_float2rad");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rad2float(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rad2float(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rad2float", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rad2float.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rad2float");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LabQ2sRGB(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void labQ2sRGB(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LabQ2sRGB", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LabQ2sRGB.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LabQ2sRGB");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_colourspace(VipsImage *in, VipsImage **out, VipsInterpretation space, ...)
   * }
   */
  public void colourspace(MemorySegment in, MemorySegment out, int space, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_colourspace", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_colourspace.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, space, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_colourspace");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_quadratic(VipsImage *in, VipsImage **out, VipsImage *coeff, ...)
   * }
   */
  public void quadratic(MemorySegment in, MemorySegment out, MemorySegment coeff,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_quadratic", "in");
    }
    if(!VipsValidation.isValidPointer(coeff)) {
      VipsValidation.throwInvalidInputError("vips_quadratic", "coeff");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_quadratic.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, coeff, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_quadratic");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mapim(VipsImage *in, VipsImage **out, VipsImage *index, ...)
   * }
   */
  public void mapim(MemorySegment in, MemorySegment out, MemorySegment index, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_mapim", "in");
    }
    if(!VipsValidation.isValidPointer(index)) {
      VipsValidation.throwInvalidInputError("vips_mapim", "index");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mapim.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, index, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mapim");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_resize(VipsImage *in, VipsImage **out, double scale, ...)
   * }
   */
  public void resize(MemorySegment in, MemorySegment out, double scale, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_resize", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_resize.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, scale, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_resize");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_affine(VipsImage *in, VipsImage **out, double a, double b, double c, double d, ...)
   * }
   */
  public void affine(MemorySegment in, MemorySegment out, double a, double b, double c, double d,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_affine", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_affine.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, a, b, c, d, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_affine");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rotate(VipsImage *in, VipsImage **out, double angle, ...)
   * }
   */
  public void rotate(MemorySegment in, MemorySegment out, double angle, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rotate", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rotate.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, angle, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rotate");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_similarity(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void similarity(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_similarity", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_similarity.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_similarity");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_thumbnail_source(VipsSource *source, VipsImage **out, int width, ...)
   * }
   */
  public void thumbnailSource(MemorySegment source, MemorySegment out, int width,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_thumbnail_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_thumbnail_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, width, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_thumbnail_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_thumbnail_image(VipsImage *in, VipsImage **out, int width, ...)
   * }
   */
  public void thumbnailImage(MemorySegment in, MemorySegment out, int width, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_thumbnail_image", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_thumbnail_image.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, width, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_thumbnail_image");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_thumbnail_buffer(void *buf, size_t len, VipsImage **out, int width, ...)
   * }
   */
  public void thumbnailBuffer(MemorySegment buf, long len, MemorySegment out, int width,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_thumbnail_buffer", "buf");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_thumbnail_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, out, width, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_thumbnail_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_thumbnail(const char *filename, VipsImage **out, int width, ...)
   * }
   */
  public void thumbnail(MemorySegment filename, MemorySegment out, int width, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_thumbnail", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_thumbnail.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, width, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_thumbnail");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_reducev(VipsImage *in, VipsImage **out, double vshrink, ...)
   * }
   */
  public void reducev(MemorySegment in, MemorySegment out, double vshrink, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_reducev", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_reducev.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, vshrink, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_reducev");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_reduceh(VipsImage *in, VipsImage **out, double hshrink, ...)
   * }
   */
  public void reduceh(MemorySegment in, MemorySegment out, double hshrink, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_reduceh", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_reduceh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, hshrink, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_reduceh");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_reduce(VipsImage *in, VipsImage **out, double hshrink, double vshrink, ...)
   * }
   */
  public void reduce(MemorySegment in, MemorySegment out, double hshrink, double vshrink,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_reduce", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_reduce.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, hshrink, vshrink, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_reduce");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_shrinkv(VipsImage *in, VipsImage **out, int vshrink, ...)
   * }
   */
  public void shrinkv(MemorySegment in, MemorySegment out, int vshrink, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_shrinkv", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_shrinkv.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, vshrink, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_shrinkv");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_shrinkh(VipsImage *in, VipsImage **out, int hshrink, ...)
   * }
   */
  public void shrinkh(MemorySegment in, MemorySegment out, int hshrink, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_shrinkh", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_shrinkh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, hshrink, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_shrinkh");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_shrink(VipsImage *in, VipsImage **out, double hshrink, double vshrink, ...)
   * }
   */
  public void shrink(MemorySegment in, MemorySegment out, double hshrink, double vshrink,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_shrink", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_shrink.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, hshrink, vshrink, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_shrink");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_phasecor(VipsImage *in1, VipsImage *in2, VipsImage **out, ...)
   * }
   */
  public void phasecor(MemorySegment in1, MemorySegment in2, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in1)) {
      VipsValidation.throwInvalidInputError("vips_phasecor", "in1");
    }
    if(!VipsValidation.isValidPointer(in2)) {
      VipsValidation.throwInvalidInputError("vips_phasecor", "in2");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_phasecor.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in1, in2, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_phasecor");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_spectrum(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void spectrum(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_spectrum", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_spectrum.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_spectrum");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_freqmult(VipsImage *in, VipsImage *mask, VipsImage **out, ...)
   * }
   */
  public void freqmult(MemorySegment in, MemorySegment mask, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_freqmult", "in");
    }
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_freqmult", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_freqmult.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, mask, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_freqmult");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_invfft(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void invfft(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_invfft", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_invfft.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_invfft");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_fwfft(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void fwfft(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_fwfft", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_fwfft.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_fwfft");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_case(VipsImage *index, VipsImage **cases, VipsImage **out, int n, ...)
   * }
   */
  public void case1(MemorySegment index, MemorySegment cases, MemorySegment out, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(index)) {
      VipsValidation.throwInvalidInputError("vips_case", "index");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_case.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(index, cases, out, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_case");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_entropy(VipsImage *in, double *out, ...)
   * }
   */
  public void histEntropy(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_entropy", "in");
    }
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_hist_entropy", "out");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_entropy.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_entropy");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_ismonotonic(VipsImage *in, gboolean *out, ...)
   * }
   */
  public void histIsmonotonic(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_ismonotonic", "in");
    }
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_hist_ismonotonic", "out");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_ismonotonic.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_ismonotonic");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_local(VipsImage *in, VipsImage **out, int width, int height, ...)
   * }
   */
  public void histLocal(MemorySegment in, MemorySegment out, int width, int height,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_local", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_local.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_local");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_match(VipsImage *in, VipsImage *ref, VipsImage **out, ...)
   * }
   */
  public void histMatch(MemorySegment in, MemorySegment ref, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_match", "in");
    }
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_hist_match", "ref");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_match.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, ref, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_match");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_plot(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void histPlot(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_plot", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_plot.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_plot");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_equal(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void histEqual(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_equal", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_equal.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_equal");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_norm(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void histNorm(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_norm", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_norm.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_norm");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_cum(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void histCum(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_cum", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_cum.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_cum");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_stdif(VipsImage *in, VipsImage **out, int width, int height, ...)
   * }
   */
  public void stdif(MemorySegment in, MemorySegment out, int width, int height,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_stdif", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_stdif.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_stdif");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_percent(VipsImage *in, double percent, int *threshold, ...)
   * }
   */
  public void percent(MemorySegment in, double percent, MemorySegment threshold,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_percent", "in");
    }
    if(!VipsValidation.isValidPointer(threshold)) {
      VipsValidation.throwInvalidInputError("vips_percent", "threshold");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_percent.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, percent, threshold, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_percent");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_maplut(VipsImage *in, VipsImage **out, VipsImage *lut, ...)
   * }
   */
  public void maplut(MemorySegment in, MemorySegment out, MemorySegment lut, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_maplut", "in");
    }
    if(!VipsValidation.isValidPointer(lut)) {
      VipsValidation.throwInvalidInputError("vips_maplut", "lut");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_maplut.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, lut, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_maplut");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_matrixinvert(VipsImage *m, VipsImage **out, ...)
   * }
   */
  public void matrixinvert(MemorySegment m, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(m)) {
      VipsValidation.throwInvalidInputError("vips_matrixinvert", "m");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_matrixinvert.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(m, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_matrixinvert");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_remosaic(VipsImage *in, VipsImage **out, const char *old_str, const char *new_str, ...)
   * }
   */
  public void remosaic(MemorySegment in, MemorySegment out, MemorySegment old_str,
      MemorySegment new_str, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_remosaic", "in");
    }
    if(!VipsValidation.isValidPointer(old_str)) {
      VipsValidation.throwInvalidInputError("vips_remosaic", "old_str");
    }
    if(!VipsValidation.isValidPointer(new_str)) {
      VipsValidation.throwInvalidInputError("vips_remosaic", "new_str");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_remosaic.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, old_str, new_str, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_remosaic");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_globalbalance(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void globalbalance(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_globalbalance", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_globalbalance.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_globalbalance");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_match(VipsImage *ref, VipsImage *sec, VipsImage **out, int xr1, int yr1, int xs1, int ys1, int xr2, int yr2, int xs2, int ys2, ...)
   * }
   */
  public void match(MemorySegment ref, MemorySegment sec, MemorySegment out, int xr1, int yr1,
      int xs1, int ys1, int xr2, int yr2, int xs2, int ys2, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_match", "ref");
    }
    if(!VipsValidation.isValidPointer(sec)) {
      VipsValidation.throwInvalidInputError("vips_match", "sec");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_match.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(ref, sec, out, xr1, yr1, xs1, ys1, xr2, yr2, xs2, ys2, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_match");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mosaic1(VipsImage *ref, VipsImage *sec, VipsImage **out, VipsDirection direction, int xr1, int yr1, int xs1, int ys1, int xr2, int yr2, int xs2, int ys2, ...)
   * }
   */
  public void mosaic1(MemorySegment ref, MemorySegment sec, MemorySegment out, int direction,
      int xr1, int yr1, int xs1, int ys1, int xr2, int yr2, int xs2, int ys2, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_mosaic1", "ref");
    }
    if(!VipsValidation.isValidPointer(sec)) {
      VipsValidation.throwInvalidInputError("vips_mosaic1", "sec");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mosaic1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(ref, sec, out, direction, xr1, yr1, xs1, ys1, xr2, yr2, xs2, ys2, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mosaic1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mosaic(VipsImage *ref, VipsImage *sec, VipsImage **out, VipsDirection direction, int xref, int yref, int xsec, int ysec, ...)
   * }
   */
  public void mosaic(MemorySegment ref, MemorySegment sec, MemorySegment out, int direction,
      int xref, int yref, int xsec, int ysec, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_mosaic", "ref");
    }
    if(!VipsValidation.isValidPointer(sec)) {
      VipsValidation.throwInvalidInputError("vips_mosaic", "sec");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mosaic.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(ref, sec, out, direction, xref, yref, xsec, ysec, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mosaic");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_merge(VipsImage *ref, VipsImage *sec, VipsImage **out, VipsDirection direction, int dx, int dy, ...)
   * }
   */
  public void merge(MemorySegment ref, MemorySegment sec, MemorySegment out, int direction, int dx,
      int dy, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_merge", "ref");
    }
    if(!VipsValidation.isValidPointer(sec)) {
      VipsValidation.throwInvalidInputError("vips_merge", "sec");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_merge.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(ref, sec, out, direction, dx, dy, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_merge");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_fill_nearest(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void fillNearest(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_fill_nearest", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_fill_nearest.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_fill_nearest");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_labelregions(VipsImage *in, VipsImage **mask, ...)
   * }
   */
  public void labelregions(MemorySegment in, MemorySegment mask, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_labelregions", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_labelregions.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_labelregions");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_countlines(VipsImage *in, double *nolines, VipsDirection direction, ...)
   * }
   */
  public void countlines(MemorySegment in, MemorySegment nolines, int direction,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_countlines", "in");
    }
    if(!VipsValidation.isValidPointer(nolines)) {
      VipsValidation.throwInvalidInputError("vips_countlines", "nolines");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_countlines.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, nolines, direction, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_countlines");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_median(VipsImage *in, VipsImage **out, int size, ...)
   * }
   */
  public void median(MemorySegment in, MemorySegment out, int size, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_median", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_median.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, size, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_median");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rank(VipsImage *in, VipsImage **out, int width, int height, int index, ...)
   * }
   */
  public void rank(MemorySegment in, MemorySegment out, int width, int height, int index,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rank", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rank.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, width, height, index, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rank");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_morph(VipsImage *in, VipsImage **out, VipsImage *mask, VipsOperationMorphology morph, ...)
   * }
   */
  public void morph(MemorySegment in, MemorySegment out, MemorySegment mask, int morph,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_morph", "in");
    }
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_morph", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_morph.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, mask, morph, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_morph");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_canny(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void canny(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_canny", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_canny.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_canny");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_prewitt(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void prewitt(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_prewitt", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_prewitt.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_prewitt");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_scharr(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void scharr(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_scharr", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_scharr.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_scharr");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sobel(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sobel(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sobel", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sobel.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sobel");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_fastcor(VipsImage *in, VipsImage *ref, VipsImage **out, ...)
   * }
   */
  public void fastcor(MemorySegment in, MemorySegment ref, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_fastcor", "in");
    }
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_fastcor", "ref");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_fastcor.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, ref, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_fastcor");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_spcor(VipsImage *in, VipsImage *ref, VipsImage **out, ...)
   * }
   */
  public void spcor(MemorySegment in, MemorySegment ref, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_spcor", "in");
    }
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_spcor", "ref");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_spcor.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, ref, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_spcor");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sharpen(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sharpen(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sharpen", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sharpen.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sharpen");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gaussblur(VipsImage *in, VipsImage **out, double sigma, ...)
   * }
   */
  public void gaussblur(MemorySegment in, MemorySegment out, double sigma, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_gaussblur", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gaussblur.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, sigma, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gaussblur");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_compass(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void compass(MemorySegment in, MemorySegment out, MemorySegment mask,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_compass", "in");
    }
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_compass", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_compass.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_compass");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_convasep(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void convasep(MemorySegment in, MemorySegment out, MemorySegment mask,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_convasep", "in");
    }
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_convasep", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_convasep.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_convasep");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_convsep(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void convsep(MemorySegment in, MemorySegment out, MemorySegment mask,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_convsep", "in");
    }
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_convsep", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_convsep.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_convsep");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_conva(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void conva(MemorySegment in, MemorySegment out, MemorySegment mask, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_conva", "in");
    }
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_conva", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_conva.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_conva");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_convi(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void convi(MemorySegment in, MemorySegment out, MemorySegment mask, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_convi", "in");
    }
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_convi", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_convi.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_convi");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_convf(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void convf(MemorySegment in, MemorySegment out, MemorySegment mask, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_convf", "in");
    }
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_convf", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_convf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_convf");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_conv(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void conv(MemorySegment in, MemorySegment out, MemorySegment mask, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_conv", "in");
    }
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_conv", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_conv.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_conv");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gamma(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void gamma(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_gamma", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gamma.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gamma");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_falsecolour(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void falsecolour(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_falsecolour", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_falsecolour.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_falsecolour");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_composite2(VipsImage *base, VipsImage *overlay, VipsImage **out, VipsBlendMode mode, ...)
   * }
   */
  public void composite2(MemorySegment base, MemorySegment overlay, MemorySegment out, int mode,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(base)) {
      VipsValidation.throwInvalidInputError("vips_composite2", "base");
    }
    if(!VipsValidation.isValidPointer(overlay)) {
      VipsValidation.throwInvalidInputError("vips_composite2", "overlay");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_composite2.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(base, overlay, out, mode, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_composite2");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_composite(VipsImage **in, VipsImage **out, int n, int *mode, ...)
   * }
   */
  public void composite(MemorySegment in, MemorySegment out, int n, MemorySegment mode,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(mode)) {
      VipsValidation.throwInvalidInputError("vips_composite", "mode");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_composite.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, n, mode, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_composite");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_unpremultiply(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void unpremultiply(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_unpremultiply", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_unpremultiply.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_unpremultiply");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_premultiply(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void premultiply(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_premultiply", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_premultiply.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_premultiply");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_addalpha(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void addalpha(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_addalpha", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_addalpha.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_addalpha");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_flatten(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void flatten(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_flatten", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_flatten.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_flatten");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_switch(VipsImage **tests, VipsImage **out, int n, ...)
   * }
   */
  public void switch1(MemorySegment tests, MemorySegment out, int n, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_switch.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(tests, out, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_switch");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_ifthenelse(VipsImage *cond, VipsImage *in1, VipsImage *in2, VipsImage **out, ...)
   * }
   */
  public void ifthenelse(MemorySegment cond, MemorySegment in1, MemorySegment in2,
      MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(cond)) {
      VipsValidation.throwInvalidInputError("vips_ifthenelse", "cond");
    }
    if(!VipsValidation.isValidPointer(in1)) {
      VipsValidation.throwInvalidInputError("vips_ifthenelse", "in1");
    }
    if(!VipsValidation.isValidPointer(in2)) {
      VipsValidation.throwInvalidInputError("vips_ifthenelse", "in2");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_ifthenelse.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(cond, in1, in2, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_ifthenelse");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_recomb(VipsImage *in, VipsImage **out, VipsImage *m, ...)
   * }
   */
  public void recomb(MemorySegment in, MemorySegment out, MemorySegment m, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_recomb", "in");
    }
    if(!VipsValidation.isValidPointer(m)) {
      VipsValidation.throwInvalidInputError("vips_recomb", "m");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_recomb.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, m, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_recomb");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandmean(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void bandmean(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandmean", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandmean.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandmean");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandeor(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void bandeor(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandeor", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandeor.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandeor");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandor(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void bandor(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandor", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandor.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandor");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandand(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void bandand(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandand", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandand.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandand");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandbool(VipsImage *in, VipsImage **out, VipsOperationBoolean boolean, ...)
   * }
   */
  public void bandbool(MemorySegment in, MemorySegment out, int boolean1, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandbool", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandbool.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, boolean1, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandbool");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandunfold(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void bandunfold(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandunfold", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandunfold.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandunfold");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandfold(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void bandfold(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandfold", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandfold.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandfold");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandrank(VipsImage **in, VipsImage **out, int n, ...)
   * }
   */
  public void bandrank(MemorySegment in, MemorySegment out, int n, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandrank.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandrank");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandjoin_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void bandjoinConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandjoin_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandjoin_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandjoin_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandjoin_const(VipsImage *in, VipsImage **out, double *c, int n, ...)
   * }
   */
  public void bandjoinConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandjoin_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_bandjoin_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandjoin_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandjoin_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandjoin2(VipsImage *in1, VipsImage *in2, VipsImage **out, ...)
   * }
   */
  public void bandjoin2(MemorySegment in1, MemorySegment in2, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in1)) {
      VipsValidation.throwInvalidInputError("vips_bandjoin2", "in1");
    }
    if(!VipsValidation.isValidPointer(in2)) {
      VipsValidation.throwInvalidInputError("vips_bandjoin2", "in2");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandjoin2.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in1, in2, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandjoin2");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandjoin(VipsImage **in, VipsImage **out, int n, ...)
   * }
   */
  public void bandjoin(MemorySegment in, MemorySegment out, int n, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandjoin.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandjoin");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_byteswap(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void byteswap(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_byteswap", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_byteswap.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_byteswap");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_msb(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void msb(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_msb", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_msb.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_msb");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_scale(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void scale(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_scale", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_scale.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_scale");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_dpcomplex(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castDpcomplex(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_dpcomplex", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_dpcomplex.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_dpcomplex");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_complex(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castComplex(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_complex", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_complex.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_complex");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_double(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castDouble(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_double", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_double.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_double");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_float(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castFloat(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_float", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_float.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_float");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_int(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castInt(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_int", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_int.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_int");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_uint(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castUint(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_uint", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_uint.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_uint");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_short(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castShort(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_short", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_short.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_short");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_ushort(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castUshort(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_ushort", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_ushort.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_ushort");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_char(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castChar(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_char", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_char.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_char");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_uchar(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castUchar(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_uchar", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_uchar.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_uchar");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast(VipsImage *in, VipsImage **out, VipsBandFormat format, ...)
   * }
   */
  public void cast(MemorySegment in, MemorySegment out, int format, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, format, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_subsample(VipsImage *in, VipsImage **out, int xfac, int yfac, ...)
   * }
   */
  public void subsample(MemorySegment in, MemorySegment out, int xfac, int yfac,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_subsample", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_subsample.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, xfac, yfac, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_subsample");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_zoom(VipsImage *in, VipsImage **out, int xfac, int yfac, ...)
   * }
   */
  public void zoom(MemorySegment in, MemorySegment out, int xfac, int yfac, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_zoom", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_zoom.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, xfac, yfac, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_zoom");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_autorot(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void autorot(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_autorot", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_autorot.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_autorot");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rot45(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rot45(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rot45", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rot45.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rot45");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rot270(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rot270(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rot270", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rot270.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rot270");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rot180(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rot180(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rot180", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rot180.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rot180");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rot90(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rot90(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rot90", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rot90.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rot90");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rot(VipsImage *in, VipsImage **out, VipsAngle angle, ...)
   * }
   */
  public void rot(MemorySegment in, MemorySegment out, int angle, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rot", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rot.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, angle, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rot");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_wrap(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void wrap(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_wrap", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_wrap.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_wrap");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_transpose3d(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void transpose3d(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_transpose3d", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_transpose3d.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_transpose3d");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_grid(VipsImage *in, VipsImage **out, int tile_height, int across, int down, ...)
   * }
   */
  public void grid(MemorySegment in, MemorySegment out, int tile_height, int across, int down,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_grid", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_grid.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, tile_height, across, down, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_grid");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_replicate(VipsImage *in, VipsImage **out, int across, int down, ...)
   * }
   */
  public void replicate(MemorySegment in, MemorySegment out, int across, int down,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_replicate", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_replicate.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, across, down, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_replicate");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_extract_band(VipsImage *in, VipsImage **out, int band, ...)
   * }
   */
  public void extractBand(MemorySegment in, MemorySegment out, int band, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_extract_band", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_extract_band.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, band, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_extract_band");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_smartcrop(VipsImage *in, VipsImage **out, int width, int height, ...)
   * }
   */
  public void smartcrop(MemorySegment in, MemorySegment out, int width, int height,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_smartcrop", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_smartcrop.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_smartcrop");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_crop(VipsImage *in, VipsImage **out, int left, int top, int width, int height, ...)
   * }
   */
  public void crop(MemorySegment in, MemorySegment out, int left, int top, int width, int height,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_crop", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_crop.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, left, top, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_crop");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_extract_area(VipsImage *in, VipsImage **out, int left, int top, int width, int height, ...)
   * }
   */
  public void extractArea(MemorySegment in, MemorySegment out, int left, int top, int width,
      int height, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_extract_area", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_extract_area.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, left, top, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_extract_area");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_arrayjoin(VipsImage **in, VipsImage **out, int n, ...)
   * }
   */
  public void arrayjoin(MemorySegment in, MemorySegment out, int n, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_arrayjoin.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_arrayjoin");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_join(VipsImage *in1, VipsImage *in2, VipsImage **out, VipsDirection direction, ...)
   * }
   */
  public void join(MemorySegment in1, MemorySegment in2, MemorySegment out, int direction,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in1)) {
      VipsValidation.throwInvalidInputError("vips_join", "in1");
    }
    if(!VipsValidation.isValidPointer(in2)) {
      VipsValidation.throwInvalidInputError("vips_join", "in2");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_join.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in1, in2, out, direction, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_join");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_insert(VipsImage *main, VipsImage *sub, VipsImage **out, int x, int y, ...)
   * }
   */
  public void insert(MemorySegment main, MemorySegment sub, MemorySegment out, int x, int y,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(main)) {
      VipsValidation.throwInvalidInputError("vips_insert", "main");
    }
    if(!VipsValidation.isValidPointer(sub)) {
      VipsValidation.throwInvalidInputError("vips_insert", "sub");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_insert.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(main, sub, out, x, y, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_insert");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_flip(VipsImage *in, VipsImage **out, VipsDirection direction, ...)
   * }
   */
  public void flip(MemorySegment in, MemorySegment out, int direction, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_flip", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_flip.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, direction, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_flip");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gravity(VipsImage *in, VipsImage **out, VipsCompassDirection direction, int width, int height, ...)
   * }
   */
  public void gravity(MemorySegment in, MemorySegment out, int direction, int width, int height,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_gravity", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gravity.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, direction, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gravity");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_embed(VipsImage *in, VipsImage **out, int x, int y, int width, int height, ...)
   * }
   */
  public void embed(MemorySegment in, MemorySegment out, int x, int y, int width, int height,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_embed", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_embed.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, x, y, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_embed");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_copy_file(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void copyFile(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_copy_file", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_copy_file.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_copy_file");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cache(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void cache(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cache", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cache.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cache");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sequential(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sequential(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sequential", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sequential.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sequential");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_linecache(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void linecache(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_linecache", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_linecache.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_linecache");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tilecache(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void tilecache(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_tilecache", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tilecache.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tilecache");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_copy(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void copy(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_copy", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_copy.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_copy");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_profile(VipsImage *in, VipsImage **columns, VipsImage **rows, ...)
   * }
   */
  public void profile(MemorySegment in, MemorySegment columns, MemorySegment rows,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_profile", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_profile.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, columns, rows, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_profile");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_project(VipsImage *in, VipsImage **columns, VipsImage **rows, ...)
   * }
   */
  public void project(MemorySegment in, MemorySegment columns, MemorySegment rows,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_project", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_project.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, columns, rows, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_project");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hough_circle(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void houghCircle(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hough_circle", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hough_circle.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hough_circle");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hough_line(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void houghLine(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hough_line", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hough_line.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hough_line");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_find_indexed(VipsImage *in, VipsImage *index, VipsImage **out, ...)
   * }
   */
  public void histFindIndexed(MemorySegment in, MemorySegment index, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_find_indexed", "in");
    }
    if(!VipsValidation.isValidPointer(index)) {
      VipsValidation.throwInvalidInputError("vips_hist_find_indexed", "index");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_find_indexed.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, index, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_find_indexed");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_find_ndim(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void histFindNdim(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_find_ndim", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_find_ndim.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_find_ndim");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_find(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void histFind(MemorySegment in, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_find", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_find.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_find");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_getpoint(VipsImage *in, double **vector, int *n, int x, int y, ...)
   * }
   */
  public void getpoint(MemorySegment in, MemorySegment vector, MemorySegment n, int x, int y,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_getpoint", "in");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_getpoint", "n");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_getpoint.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, vector, n, x, y, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_getpoint");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_find_trim(VipsImage *in, int *left, int *top, int *width, int *height, ...)
   * }
   */
  public void findTrim(MemorySegment in, MemorySegment left, MemorySegment top, MemorySegment width,
      MemorySegment height, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_find_trim", "in");
    }
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_find_trim", "left");
    }
    if(!VipsValidation.isValidPointer(top)) {
      VipsValidation.throwInvalidInputError("vips_find_trim", "top");
    }
    if(!VipsValidation.isValidPointer(width)) {
      VipsValidation.throwInvalidInputError("vips_find_trim", "width");
    }
    if(!VipsValidation.isValidPointer(height)) {
      VipsValidation.throwInvalidInputError("vips_find_trim", "height");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_find_trim.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, left, top, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_find_trim");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_measure(VipsImage *in, VipsImage **out, int h, int v, ...)
   * }
   */
  public void measure(MemorySegment in, MemorySegment out, int h, int v, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_measure", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_measure.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, h, v, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_measure");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_stats(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void stats(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_stats", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_stats.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_stats");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_max(VipsImage *in, double *out, ...)
   * }
   */
  public void max(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_max", "in");
    }
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_max", "out");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_max.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_max");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_min(VipsImage *in, double *out, ...)
   * }
   */
  public void min(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_min", "in");
    }
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_min", "out");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_min.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_min");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_deviate(VipsImage *in, double *out, ...)
   * }
   */
  public void deviate(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_deviate", "in");
    }
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_deviate", "out");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_deviate.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_deviate");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_avg(VipsImage *in, double *out, ...)
   * }
   */
  public void avg(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_avg", "in");
    }
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_avg", "out");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_avg.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_avg");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_atan2_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void atan2Const1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_atan2_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_atan2_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_atan2_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_wop_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void wopConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_wop_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_wop_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_wop_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pow_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void powConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_pow_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pow_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pow_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_math2_const1(VipsImage *in, VipsImage **out, VipsOperationMath2 math2, double c, ...)
   * }
   */
  public void math2Const1(MemorySegment in, MemorySegment out, int math2, double c,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_math2_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_math2_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, math2, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_math2_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_atan2_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void atan2Const(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_atan2_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_atan2_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_atan2_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_atan2_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_wop_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void wopConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_wop_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_wop_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_wop_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_wop_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pow_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void powConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_pow_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_pow_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pow_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pow_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_math2_const(VipsImage *in, VipsImage **out, VipsOperationMath2 math2, const double *c, int n, ...)
   * }
   */
  public void math2Const(MemorySegment in, MemorySegment out, int math2, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_math2_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_math2_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_math2_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, math2, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_math2_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_atan2(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void atan2(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_atan2", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_atan2", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_atan2.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_atan2");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_wop(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void wop(MemorySegment left, MemorySegment right, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_wop", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_wop", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_wop.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_wop");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pow(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void pow(MemorySegment left, MemorySegment right, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_pow", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_pow", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pow.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pow");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_math2(VipsImage *left, VipsImage *right, VipsImage **out, VipsOperationMath2 math2, ...)
   * }
   */
  public void math2(MemorySegment left, MemorySegment right, MemorySegment out, int math2,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_math2", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_math2", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_math2.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, math2, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_math2");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rshift_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void rshiftConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rshift_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rshift_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rshift_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_lshift_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void lshiftConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_lshift_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_lshift_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_lshift_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_eorimage_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void eorimageConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_eorimage_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_eorimage_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_eorimage_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_orimage_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void orimageConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_orimage_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_orimage_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_orimage_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_andimage_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void andimageConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_andimage_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_andimage_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_andimage_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_boolean_const1(VipsImage *in, VipsImage **out, VipsOperationBoolean boolean, double c, ...)
   * }
   */
  public void booleanConst1(MemorySegment in, MemorySegment out, int boolean1, double c,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_boolean_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_boolean_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, boolean1, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_boolean_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rshift_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void rshiftConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rshift_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_rshift_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rshift_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rshift_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_lshift_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void lshiftConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_lshift_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_lshift_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_lshift_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_lshift_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_eorimage_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void eorimageConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_eorimage_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_eorimage_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_eorimage_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_eorimage_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_orimage_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void orimageConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_orimage_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_orimage_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_orimage_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_orimage_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_andimage_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void andimageConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_andimage_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_andimage_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_andimage_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_andimage_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_boolean_const(VipsImage *in, VipsImage **out, VipsOperationBoolean boolean, const double *c, int n, ...)
   * }
   */
  public void booleanConst(MemorySegment in, MemorySegment out, int boolean1, MemorySegment c,
      int n, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_boolean_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_boolean_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_boolean_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, boolean1, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_boolean_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rshift(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void rshift(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_rshift", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_rshift", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rshift.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rshift");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_lshift(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void lshift(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_lshift", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_lshift", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_lshift.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_lshift");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_eorimage(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void eorimage(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_eorimage", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_eorimage", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_eorimage.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_eorimage");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_orimage(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void orimage(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_orimage", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_orimage", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_orimage.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_orimage");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_andimage(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void andimage(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_andimage", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_andimage", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_andimage.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_andimage");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_boolean(VipsImage *left, VipsImage *right, VipsImage **out, VipsOperationBoolean boolean, ...)
   * }
   */
  public void boolean1(MemorySegment left, MemorySegment right, MemorySegment out, int boolean1,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_boolean", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_boolean", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_boolean.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, boolean1, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_boolean");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_moreeq_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void moreeqConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_moreeq_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_moreeq_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_moreeq_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_more_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void moreConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_more_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_more_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_more_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_lesseq_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void lesseqConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_lesseq_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_lesseq_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_lesseq_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_less_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void lessConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_less_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_less_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_less_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_notequal_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void notequalConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_notequal_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_notequal_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_notequal_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_equal_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void equalConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_equal_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_equal_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_equal_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_relational_const1(VipsImage *in, VipsImage **out, VipsOperationRelational relational, double c, ...)
   * }
   */
  public void relationalConst1(MemorySegment in, MemorySegment out, int relational, double c,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_relational_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_relational_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, relational, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_relational_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_moreeq_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void moreeqConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_moreeq_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_moreeq_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_moreeq_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_moreeq_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_more_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void moreConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_more_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_more_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_more_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_more_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_lesseq_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void lesseqConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_lesseq_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_lesseq_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_lesseq_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_lesseq_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_less_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void lessConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_less_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_less_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_less_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_less_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_notequal_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void notequalConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_notequal_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_notequal_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_notequal_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_notequal_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_equal_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void equalConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_equal_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_equal_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_equal_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_equal_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_relational_const(VipsImage *in, VipsImage **out, VipsOperationRelational relational, const double *c, int n, ...)
   * }
   */
  public void relationalConst(MemorySegment in, MemorySegment out, int relational, MemorySegment c,
      int n, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_relational_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_relational_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_relational_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, relational, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_relational_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_moreeq(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void moreeq(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_moreeq", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_moreeq", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_moreeq.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_moreeq");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_more(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void more(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_more", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_more", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_more.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_more");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_lesseq(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void lesseq(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_lesseq", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_lesseq", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_lesseq.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_lesseq");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_less(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void less(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_less", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_less", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_less.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_less");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_notequal(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void notequal(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_notequal", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_notequal", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_notequal.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_notequal");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_equal(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void equal(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_equal", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_equal", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_equal.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_equal");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_relational(VipsImage *left, VipsImage *right, VipsImage **out, VipsOperationRelational relational, ...)
   * }
   */
  public void relational(MemorySegment left, MemorySegment right, MemorySegment out, int relational,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_relational", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_relational", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_relational.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, relational, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_relational");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_complexform(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void complexform(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_complexform", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_complexform", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_complexform.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_complexform");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_imag(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void imag(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_imag", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_imag.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_imag");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_real(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void real(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_real", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_real.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_real");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_complexget(VipsImage *in, VipsImage **out, VipsOperationComplexget get, ...)
   * }
   */
  public void complexget(MemorySegment in, MemorySegment out, int get, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_complexget", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_complexget.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, get, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_complexget");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cross_phase(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void crossPhase(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_cross_phase", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_cross_phase", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cross_phase.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cross_phase");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_complex2(VipsImage *left, VipsImage *right, VipsImage **out, VipsOperationComplex2 cmplx, ...)
   * }
   */
  public void complex2(MemorySegment left, MemorySegment right, MemorySegment out, int cmplx,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_complex2", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_complex2", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_complex2.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, cmplx, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_complex2");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_conj(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void conj(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_conj", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_conj.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_conj");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rect(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rect(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rect", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rect.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rect");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_polar(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void polar(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_polar", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_polar.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_polar");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_complex(VipsImage *in, VipsImage **out, VipsOperationComplex cmplx, ...)
   * }
   */
  public void complex(MemorySegment in, MemorySegment out, int cmplx, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_complex", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_complex.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, cmplx, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_complex");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_atanh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void atanh(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_atanh", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_atanh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_atanh");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_acosh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void acosh(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_acosh", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_acosh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_acosh");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_asinh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void asinh(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_asinh", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_asinh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_asinh");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tanh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void tanh(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_tanh", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tanh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tanh");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cosh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void cosh(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cosh", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cosh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cosh");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sinh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sinh(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sinh", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sinh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sinh");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_log10(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void log10(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_log10", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_log10.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_log10");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_log(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void log(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_log", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_log.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_log");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_exp10(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void exp10(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_exp10", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_exp10.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_exp10");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_exp(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void exp(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_exp", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_exp.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_exp");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_atan(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void atan(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_atan", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_atan.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_atan");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_acos(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void acos(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_acos", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_acos.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_acos");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_asin(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void asin(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_asin", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_asin.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_asin");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tan(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void tan(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_tan", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tan.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tan");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cos(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void cos(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cos", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cos.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cos");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sin(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sin(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sin", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sin.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sin");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_math(VipsImage *in, VipsImage **out, VipsOperationMath math, ...)
   * }
   */
  public void math(MemorySegment in, MemorySegment out, int math, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_math", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_math.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, math, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_math");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rint(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rint(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rint", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rint.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rint");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_ceil(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void ceil(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_ceil", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_ceil.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_ceil");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_floor(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void floor(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_floor", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_floor.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_floor");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_round(VipsImage *in, VipsImage **out, VipsOperationRound round, ...)
   * }
   */
  public void round(MemorySegment in, MemorySegment out, int round, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_round", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_round.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, round, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_round");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sign(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sign(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sign", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sign.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sign");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_abs(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void abs(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_abs", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_abs.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_abs");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_invert(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void invert(MemorySegment in, MemorySegment out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_invert", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_invert.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_invert");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_remainder_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void remainderConst1(MemorySegment in, MemorySegment out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_remainder_const1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_remainder_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_remainder_const1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_remainder_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void remainderConst(MemorySegment in, MemorySegment out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_remainder_const", "in");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_remainder_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_remainder_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_remainder_const");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_remainder(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void remainder(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_remainder", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_remainder", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_remainder.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_remainder");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_linear1(VipsImage *in, VipsImage **out, double a, double b, ...)
   * }
   */
  public void linear1(MemorySegment in, MemorySegment out, double a, double b,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_linear1", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_linear1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, a, b, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_linear1");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_linear(VipsImage *in, VipsImage **out, const double *a, const double *b, int n, ...)
   * }
   */
  public void linear(MemorySegment in, MemorySegment out, MemorySegment a, MemorySegment b, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_linear", "in");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_linear", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_linear", "b");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_linear.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, a, b, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_linear");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_divide(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void divide(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_divide", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_divide", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_divide.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_divide");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_multiply(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void multiply(MemorySegment left, MemorySegment right, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_multiply", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_multiply", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_multiply.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_multiply");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_subtract(VipsImage *in1, VipsImage *in2, VipsImage **out, ...)
   * }
   */
  public void subtract(MemorySegment in1, MemorySegment in2, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in1)) {
      VipsValidation.throwInvalidInputError("vips_subtract", "in1");
    }
    if(!VipsValidation.isValidPointer(in2)) {
      VipsValidation.throwInvalidInputError("vips_subtract", "in2");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_subtract.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in1, in2, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_subtract");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sum(VipsImage **in, VipsImage **out, int n, ...)
   * }
   */
  public void sum(MemorySegment in, MemorySegment out, int n, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sum.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, out, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sum");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_add(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void add(MemorySegment left, MemorySegment right, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_add", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_add", "right");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_add.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_add");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_dzsave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void dzsaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_dzsave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_dzsave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_dzsave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_dzsave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_dzsave_buffer(VipsImage *in, void **buf, size_t *len, ...)
   * }
   */
  public void dzsaveBuffer(MemorySegment in, MemorySegment buf, MemorySegment len,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_dzsave_buffer", "in");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_dzsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_dzsave_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, buf, len, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_dzsave_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_dzsave(VipsImage *in, const char *name, ...)
   * }
   */
  public void dzsave(MemorySegment in, MemorySegment name, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_dzsave", "in");
    }
    if(!VipsValidation.isValidPointer(name)) {
      VipsValidation.throwInvalidInputError("vips_dzsave", "name");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_dzsave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, name, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_dzsave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jxlsave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void jxlsaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_jxlsave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_jxlsave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jxlsave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jxlsave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jxlsave_buffer(VipsImage *in, void **buf, size_t *len, ...)
   * }
   */
  public void jxlsaveBuffer(MemorySegment in, MemorySegment buf, MemorySegment len,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_jxlsave_buffer", "in");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_jxlsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jxlsave_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, buf, len, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jxlsave_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jxlsave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void jxlsave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_jxlsave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_jxlsave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jxlsave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jxlsave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jxlload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void jxlload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_jxlload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jxlload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jxlload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jxlload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void jxlloadBuffer(MemorySegment buf, long len, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_jxlload_buffer", "buf");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jxlload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jxlload_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jxlload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void jxlloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_jxlload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jxlload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jxlload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jp2ksave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void jp2ksaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_jp2ksave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_jp2ksave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jp2ksave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jp2ksave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jp2ksave_buffer(VipsImage *in, void **buf, size_t *len, ...)
   * }
   */
  public void jp2ksaveBuffer(MemorySegment in, MemorySegment buf, MemorySegment len,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_jp2ksave_buffer", "in");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_jp2ksave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jp2ksave_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, buf, len, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jp2ksave_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jp2ksave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void jp2ksave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_jp2ksave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_jp2ksave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jp2ksave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jp2ksave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jp2kload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void jp2kloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_jp2kload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jp2kload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jp2kload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jp2kload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void jp2kloadBuffer(MemorySegment buf, long len, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_jp2kload_buffer", "buf");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jp2kload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jp2kload_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jp2kload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void jp2kload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_jp2kload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jp2kload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jp2kload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_niftisave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void niftisave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_niftisave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_niftisave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_niftisave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_niftisave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_niftiload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void niftiloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_niftiload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_niftiload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_niftiload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_niftiload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void niftiload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_niftiload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_niftiload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_niftiload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_heifsave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void heifsaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_heifsave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_heifsave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_heifsave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_heifsave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_heifsave_buffer(VipsImage *in, void **buf, size_t *len, ...)
   * }
   */
  public void heifsaveBuffer(MemorySegment in, MemorySegment buf, MemorySegment len,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_heifsave_buffer", "in");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_heifsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_heifsave_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, buf, len, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_heifsave_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_heifsave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void heifsave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_heifsave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_heifsave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_heifsave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_heifsave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_heifload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void heifloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_heifload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_heifload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_heifload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_heifload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void heifloadBuffer(MemorySegment buf, long len, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_heifload_buffer", "buf");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_heifload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_heifload_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_heifload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void heifload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_heifload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_heifload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_heifload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gifsave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void gifsaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_gifsave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_gifsave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gifsave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gifsave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gifsave_buffer(VipsImage *in, void **buf, size_t *len, ...)
   * }
   */
  public void gifsaveBuffer(MemorySegment in, MemorySegment buf, MemorySegment len,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_gifsave_buffer", "in");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_gifsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gifsave_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, buf, len, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gifsave_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gifsave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void gifsave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_gifsave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_gifsave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gifsave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gifsave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gifload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void gifloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_gifload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gifload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gifload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gifload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void gifloadBuffer(MemorySegment buf, long len, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_gifload_buffer", "buf");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gifload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gifload_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gifload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void gifload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_gifload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gifload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gifload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_svgload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void svgloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_svgload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_svgload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_svgload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_svgload_string(const char *str, VipsImage **out, ...)
   * }
   */
  public void svgloadString(MemorySegment str, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(str)) {
      VipsValidation.throwInvalidInputError("vips_svgload_string", "str");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_svgload_string.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(str, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_svgload_string");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_svgload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void svgloadBuffer(MemorySegment buf, long len, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_svgload_buffer", "buf");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_svgload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_svgload_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_svgload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void svgload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_svgload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_svgload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_svgload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pdfload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void pdfloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_pdfload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pdfload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pdfload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pdfload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void pdfloadBuffer(MemorySegment buf, long len, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_pdfload_buffer", "buf");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pdfload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pdfload_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pdfload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void pdfload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_pdfload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pdfload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pdfload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_radsave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void radsaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_radsave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_radsave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_radsave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_radsave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_radsave_buffer(VipsImage *in, void **buf, size_t *len, ...)
   * }
   */
  public void radsaveBuffer(MemorySegment in, MemorySegment buf, MemorySegment len,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_radsave_buffer", "in");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_radsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_radsave_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, buf, len, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_radsave_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_radsave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void radsave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_radsave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_radsave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_radsave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_radsave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_radload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void radloadBuffer(MemorySegment buf, long len, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_radload_buffer", "buf");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_radload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_radload_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_radload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void radload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_radload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_radload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_radload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_radload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void radloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_radload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_radload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_radload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_matload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void matload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_matload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_matload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_matload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_ppmsave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void ppmsaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_ppmsave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_ppmsave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_ppmsave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_ppmsave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_ppmsave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void ppmsave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_ppmsave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_ppmsave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_ppmsave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_ppmsave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_ppmload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void ppmloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_ppmload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_ppmload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_ppmload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_ppmload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void ppmload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_ppmload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_ppmload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_ppmload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pngsave_buffer(VipsImage *in, void **buf, size_t *len, ...)
   * }
   */
  public void pngsaveBuffer(MemorySegment in, MemorySegment buf, MemorySegment len,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_pngsave_buffer", "in");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_pngsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pngsave_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, buf, len, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pngsave_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pngsave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void pngsave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_pngsave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_pngsave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pngsave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pngsave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pngsave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void pngsaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_pngsave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_pngsave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pngsave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pngsave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pngload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void pngloadBuffer(MemorySegment buf, long len, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_pngload_buffer", "buf");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pngload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pngload_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pngload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void pngload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_pngload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pngload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pngload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pngload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void pngloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_pngload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pngload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pngload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_magicksave_buffer(VipsImage *in, void **buf, size_t *len, ...)
   * }
   */
  public void magicksaveBuffer(MemorySegment in, MemorySegment buf, MemorySegment len,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_magicksave_buffer", "in");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_magicksave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_magicksave_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, buf, len, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_magicksave_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_magicksave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void magicksave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_magicksave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_magicksave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_magicksave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_magicksave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_magickload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void magickloadBuffer(MemorySegment buf, long len, MemorySegment out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_magickload_buffer", "buf");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_magickload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_magickload_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_magickload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void magickload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_magickload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_magickload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_magickload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_matrixprint(VipsImage *in, ...)
   * }
   */
  public void matrixprint(MemorySegment in, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_matrixprint", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_matrixprint.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_matrixprint");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_matrixsave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void matrixsaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_matrixsave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_matrixsave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_matrixsave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_matrixsave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_matrixsave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void matrixsave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_matrixsave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_matrixsave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_matrixsave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_matrixsave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_matrixload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void matrixloadSource(MemorySegment source, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_matrixload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_matrixload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_matrixload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_matrixload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void matrixload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_matrixload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_matrixload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_matrixload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_csvsave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void csvsaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_csvsave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_csvsave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_csvsave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_csvsave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_csvsave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void csvsave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_csvsave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_csvsave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_csvsave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_csvsave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_csvload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void csvloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_csvload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_csvload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_csvload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_csvload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void csvload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_csvload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_csvload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_csvload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rawsave_fd(VipsImage *in, int fd, ...)
   * }
   */
  public void rawsaveFd(MemorySegment in, int fd, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rawsave_fd", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rawsave_fd.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, fd, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rawsave_fd");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rawsave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void rawsave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rawsave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_rawsave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rawsave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rawsave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rawload(const char *filename, VipsImage **out, int width, int height, int bands, ...)
   * }
   */
  public void rawload(MemorySegment filename, MemorySegment out, int width, int height, int bands,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_rawload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rawload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, width, height, bands, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rawload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_analyzeload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void analyzeload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_analyzeload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_analyzeload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_analyzeload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_fitssave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void fitssave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_fitssave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_fitssave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_fitssave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_fitssave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_fitsload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void fitsload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_fitsload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_fitsload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_fitsload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_openexrload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void openexrload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_openexrload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_openexrload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_openexrload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tiffsave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void tiffsaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_tiffsave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_tiffsave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tiffsave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tiffsave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tiffsave_buffer(VipsImage *in, void **buf, size_t *len, ...)
   * }
   */
  public void tiffsaveBuffer(MemorySegment in, MemorySegment buf, MemorySegment len,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_tiffsave_buffer", "in");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_tiffsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tiffsave_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, buf, len, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tiffsave_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tiffsave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void tiffsave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_tiffsave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_tiffsave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tiffsave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tiffsave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tiffload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void tiffloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_tiffload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tiffload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tiffload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tiffload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void tiffloadBuffer(MemorySegment buf, long len, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_tiffload_buffer", "buf");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tiffload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tiffload_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tiffload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void tiffload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_tiffload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tiffload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tiffload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_webpsave_mime(VipsImage *in, ...)
   * }
   */
  public void webpsaveMime(MemorySegment in, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_webpsave_mime", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_webpsave_mime.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_webpsave_mime");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_webpsave_buffer(VipsImage *in, void **buf, size_t *len, ...)
   * }
   */
  public void webpsaveBuffer(MemorySegment in, MemorySegment buf, MemorySegment len,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_webpsave_buffer", "in");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_webpsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_webpsave_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, buf, len, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_webpsave_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_webpsave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void webpsave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_webpsave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_webpsave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_webpsave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_webpsave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_webpsave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void webpsaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_webpsave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_webpsave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_webpsave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_webpsave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_webpload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void webploadBuffer(MemorySegment buf, long len, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_webpload_buffer", "buf");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_webpload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_webpload_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_webpload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void webpload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_webpload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_webpload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_webpload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_webpload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void webploadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_webpload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_webpload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_webpload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jpegsave_mime(VipsImage *in, ...)
   * }
   */
  public void jpegsaveMime(MemorySegment in, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_jpegsave_mime", "in");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jpegsave_mime.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jpegsave_mime");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jpegsave_buffer(VipsImage *in, void **buf, size_t *len, ...)
   * }
   */
  public void jpegsaveBuffer(MemorySegment in, MemorySegment buf, MemorySegment len,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_jpegsave_buffer", "in");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_jpegsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jpegsave_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, buf, len, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jpegsave_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jpegsave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void jpegsave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_jpegsave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_jpegsave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jpegsave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jpegsave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jpegsave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void jpegsaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_jpegsave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_jpegsave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jpegsave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jpegsave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jpegload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void jpegloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_jpegload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jpegload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jpegload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jpegload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void jpegloadBuffer(MemorySegment buf, long len, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_jpegload_buffer", "buf");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jpegload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jpegload_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jpegload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void jpegload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_jpegload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jpegload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jpegload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_openslideload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void openslideloadSource(MemorySegment source, MemorySegment out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_openslideload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_openslideload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_openslideload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_openslideload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void openslideload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_openslideload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_openslideload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_openslideload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_vipssave_target(VipsImage *in, VipsTarget *target, ...)
   * }
   */
  public void vipssaveTarget(MemorySegment in, MemorySegment target, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_vipssave_target", "in");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_vipssave_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_vipssave_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_vipssave_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_vipssave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void vipssave(MemorySegment in, MemorySegment filename, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_vipssave", "in");
    }
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_vipssave", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_vipssave.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, filename, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_vipssave");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_vipsload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void vipsloadSource(MemorySegment source, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_vipsload_source", "source");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_vipsload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_vipsload_source");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_vipsload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void vipsload(MemorySegment filename, MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(filename)) {
      VipsValidation.throwInvalidInputError("vips_vipsload", "filename");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_vipsload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, out, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_vipsload");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_call_split_option_string(const char *operation_name, const char *option_string, va_list optional, ...)
   * }
   */
  public void callSplitOptionString(MemorySegment operation_name, MemorySegment option_string,
      MemorySegment optional, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(operation_name)) {
      VipsValidation.throwInvalidInputError("vips_call_split_option_string", "operation_name");
    }
    if(!VipsValidation.isValidPointer(option_string)) {
      VipsValidation.throwInvalidInputError("vips_call_split_option_string", "option_string");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_call_split_option_string.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(operation_name, option_string, optional, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_call_split_option_string");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_call_split(const char *operation_name, va_list optional, ...)
   * }
   */
  public void callSplit(MemorySegment operation_name, MemorySegment optional, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(operation_name)) {
      VipsValidation.throwInvalidInputError("vips_call_split", "operation_name");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_call_split.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(operation_name, optional, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_call_split");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_call(const char *operation_name, ...)
   * }
   */
  public void call(MemorySegment operation_name, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(operation_name)) {
      VipsValidation.throwInvalidInputError("vips_call", "operation_name");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_call.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(operation_name, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_call");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_history_printf(VipsImage *image, const char *format, ...)
   * }
   */
  public void imageHistoryPrintf(MemorySegment image, MemorySegment format, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_history_printf", "image");
    }
    if(!VipsValidation.isValidPointer(format)) {
      VipsValidation.throwInvalidInputError("vips_image_history_printf", "format");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_history_printf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, format, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_history_printf");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_pipelinev(VipsImage *image, VipsDemandStyle hint, ...)
   * }
   */
  public void imagePipelinev(MemorySegment image, int hint, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_pipelinev", "image");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_pipelinev.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, hint, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_pipelinev");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage **vips_allocate_input_array(VipsImage *out, ...)
   * }
   */
  public MemorySegment allocateInputArray(MemorySegment out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(out)) {
      VipsValidation.throwInvalidInputError("vips_allocate_input_array", "out");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_allocate_input_array.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(out, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_allocate_input_array", "result");
    }
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_error_exit(const char *fmt, ...)
   * }
   */
  public void errorExit(MemorySegment fmt, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(fmt)) {
      VipsValidation.throwInvalidInputError("vips_error_exit", "fmt");
    }
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
  public void errorSystem(int err, MemorySegment domain, MemorySegment fmt, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(domain)) {
      VipsValidation.throwInvalidInputError("vips_error_system", "domain");
    }
    if(!VipsValidation.isValidPointer(fmt)) {
      VipsValidation.throwInvalidInputError("vips_error_system", "fmt");
    }
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
  public void error(MemorySegment domain, MemorySegment fmt, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(domain)) {
      VipsValidation.throwInvalidInputError("vips_error", "domain");
    }
    if(!VipsValidation.isValidPointer(fmt)) {
      VipsValidation.throwInvalidInputError("vips_error", "fmt");
    }
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
  public MemorySegment arrayImageNewv(int n, VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_array_image_newv.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(n, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_image_newv", "result");
    }
    VipsArrayImage.reinterpret(result, arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_system(const char *cmd_format, ...)
   * }
   */
  public void system(MemorySegment cmd_format, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(cmd_format)) {
      VipsValidation.throwInvalidInputError("vips_system", "cmd_format");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_system.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(cmd_format, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_system");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_write_to_target(VipsImage *in, const char *suffix, VipsTarget *target, ...)
   * }
   */
  public void imageWriteToTarget(MemorySegment in, MemorySegment suffix, MemorySegment target,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_target", "in");
    }
    if(!VipsValidation.isValidPointer(suffix)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_target", "suffix");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_target", "target");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_write_to_target.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, suffix, target, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_write_to_target");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_write_to_buffer(VipsImage *in, const char *suffix, void **buf, size_t *size, ...)
   * }
   */
  public void imageWriteToBuffer(MemorySegment in, MemorySegment suffix, MemorySegment buf,
      MemorySegment size, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_buffer", "in");
    }
    if(!VipsValidation.isValidPointer(suffix)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_buffer", "suffix");
    }
    if(!VipsValidation.isValidPointer(size)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_buffer", "size");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_write_to_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, suffix, buf, size, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_write_to_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_write_to_file(VipsImage *image, const char *name, ...)
   * }
   */
  public void imageWriteToFile(MemorySegment image, MemorySegment name, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_file", "image");
    }
    if(!VipsValidation.isValidPointer(name)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_file", "name");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_write_to_file.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(image, name, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_write_to_file");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_matrixv(int width, int height, ...)
   * }
   */
  public MemorySegment imageNewMatrixv(int width, int height, VipsOption... options) throws
      VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_new_matrixv.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(width, height, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_matrixv", "result");
    }
    VipsImage.reinterpret(result, arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_source(VipsSource *source, const char *option_string, ...)
   * }
   */
  public MemorySegment imageNewFromSource(MemorySegment source, MemorySegment option_string,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_source", "source");
    }
    if(!VipsValidation.isValidPointer(option_string)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_source", "option_string");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_new_from_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, option_string, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_from_source", "result");
    }
    VipsImage.reinterpret(result, arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_buffer(const void *buf, size_t len, const char *option_string, ...)
   * }
   */
  public MemorySegment imageNewFromBuffer(MemorySegment buf, long len, MemorySegment option_string,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_buffer", "buf");
    }
    if(!VipsValidation.isValidPointer(option_string)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_buffer", "option_string");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_new_from_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, option_string, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_from_buffer", "result");
    }
    VipsImage.reinterpret(result, arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_file(const char *name, ...)
   * }
   */
  public MemorySegment imageNewFromFile(MemorySegment name, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(name)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_file", "name");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_image_new_from_file.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(name, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_image_new_from_file", "result");
    }
    VipsImage.reinterpret(result, arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_target_writef(VipsTarget *target, const char *fmt, ...)
   * }
   */
  public void targetWritef(MemorySegment target, MemorySegment fmt, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_writef", "target");
    }
    if(!VipsValidation.isValidPointer(fmt)) {
      VipsValidation.throwInvalidInputError("vips_target_writef", "fmt");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_target_writef.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(target, fmt, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_target_writef");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_save_stringf(GValue *value, const char *fmt, ...)
   * }
   */
  public void valueSetSaveStringf(MemorySegment value, MemorySegment fmt, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_save_stringf", "value");
    }
    if(!VipsValidation.isValidPointer(fmt)) {
      VipsValidation.throwInvalidInputError("vips_value_set_save_stringf", "fmt");
    }
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
  public MemorySegment arrayIntNewv(int n, VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_array_int_newv.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(n, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_int_newv", "result");
    }
    VipsArrayInt.reinterpret(result, arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArrayDouble *vips_array_double_newv(int n, ...)
   * }
   */
  public MemorySegment arrayDoubleNewv(int n, VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_array_double_newv.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(n, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_array_double_newv", "result");
    }
    VipsArrayDouble.reinterpret(result, arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_set(VipsObject *object, ...)
   * }
   */
  public void objectSet(MemorySegment object, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_set", "object");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_object_set.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(object, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_object_set");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rmdirf(const char *name, ...)
   * }
   */
  public void rmdirf(MemorySegment name, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(name)) {
      VipsValidation.throwInvalidInputError("vips_rmdirf", "name");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rmdirf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(name, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rmdirf");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mkdirf(const char *name, ...)
   * }
   */
  public void mkdirf(MemorySegment name, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(name)) {
      VipsValidation.throwInvalidInputError("vips_mkdirf", "name");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mkdirf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(name, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mkdirf");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_isdirf(const char *name, ...)
   * }
   */
  public void isdirf(MemorySegment name, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(name)) {
      VipsValidation.throwInvalidInputError("vips_isdirf", "name");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_isdirf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(name, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_isdirf");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_existsf(const char *name, ...)
   * }
   */
  public void existsf(MemorySegment name, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(name)) {
      VipsValidation.throwInvalidInputError("vips_existsf", "name");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_existsf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(name, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_existsf");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_snprintf(char *str, size_t size, const char *format, ...)
   * }
   */
  public void snprintf(MemorySegment str, long size, MemorySegment format, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(str)) {
      VipsValidation.throwInvalidInputError("vips_snprintf", "str");
    }
    if(!VipsValidation.isValidPointer(format)) {
      VipsValidation.throwInvalidInputError("vips_snprintf", "format");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_snprintf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(str, size, format, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_snprintf");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_dbuf_writef(VipsDbuf *dbuf, const char *fmt, ...)
   * }
   */
  public void dbufWritef(MemorySegment dbuf, MemorySegment fmt, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(dbuf)) {
      VipsValidation.throwInvalidInputError("vips_dbuf_writef", "dbuf");
    }
    if(!VipsValidation.isValidPointer(fmt)) {
      VipsValidation.throwInvalidInputError("vips_dbuf_writef", "fmt");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_dbuf_writef.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(dbuf, fmt, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_dbuf_writef");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_appendf(VipsBuf *buf, const char *fmt, ...)
   * }
   */
  public void bufAppendf(MemorySegment buf, MemorySegment fmt, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_appendf", "buf");
    }
    if(!VipsValidation.isValidPointer(fmt)) {
      VipsValidation.throwInvalidInputError("vips_buf_appendf", "fmt");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_buf_appendf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, fmt, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_buf_appendf");
    }
  }
}
