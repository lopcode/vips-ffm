package app.photofox.vipsffm.generated;

import app.photofox.vipsffm.helper.VipsError;
import app.photofox.vipsffm.helper.VipsInvoker;
import app.photofox.vipsffm.helper.VipsOption;
import app.photofox.vipsffm.helper.VipsOutputPointer;
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
    var result = VipsRaw.vips_interpretation_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_band_format_get_type()
   * }
   */
  public long bandFormatGetType() throws VipsError {
    var result = VipsRaw.vips_band_format_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_coding_get_type()
   * }
   */
  public long codingGetType() throws VipsError {
    var result = VipsRaw.vips_coding_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_access_get_type()
   * }
   */
  public long accessGetType() throws VipsError {
    var result = VipsRaw.vips_access_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_morphology_get_type()
   * }
   */
  public long operationMorphologyGetType() throws VipsError {
    var result = VipsRaw.vips_operation_morphology_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_argument_flags_get_type()
   * }
   */
  public long argumentFlagsGetType() throws VipsError {
    var result = VipsRaw.vips_argument_flags_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_flags_get_type()
   * }
   */
  public long operationFlagsGetType() throws VipsError {
    var result = VipsRaw.vips_operation_flags_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_region_shrink_get_type()
   * }
   */
  public long regionShrinkGetType() throws VipsError {
    var result = VipsRaw.vips_region_shrink_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_kernel_get_type()
   * }
   */
  public long kernelGetType() throws VipsError {
    var result = VipsRaw.vips_kernel_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_size_get_type()
   * }
   */
  public long sizeGetType() throws VipsError {
    var result = VipsRaw.vips_size_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_token_get_type()
   * }
   */
  public long tokenGetType() throws VipsError {
    var result = VipsRaw.vips_token_get_type();
    return result;
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
  public void colourspaceIssupported(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_colourspace_issupported", "image");
    }
    var result = VipsRaw.vips_colourspace_issupported(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_colourspace_issupported");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_icc_present()
   * }
   */
  public void iccPresent() throws VipsError {
    var result = VipsRaw.vips_icc_present();
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_icc_present");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_icc_ac2rc(VipsImage *in, VipsImage **out, const char *profile_filename)
   * }
   */
  public void iccAc2rc(MemorySegment in, VipsOutputPointer out, String profile_filenameString)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_icc_ac2rc", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var profile_filename = arena.allocateFrom(profile_filenameString);
    var result = VipsRaw.vips_icc_ac2rc(in, outPointer, profile_filename);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_icc_ac2rc");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_icc_is_compatible_profile(VipsImage *image, const void *data, size_t data_length)
   * }
   */
  public void iccIsCompatibleProfile(MemorySegment image, MemorySegment data, long data_length)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_icc_is_compatible_profile", "image");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_icc_is_compatible_profile", "data");
    }
    var result = VipsRaw.vips_icc_is_compatible_profile(image, data, data_length);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_icc_is_compatible_profile");
    }
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
    var result = VipsRaw.vips_col_ab2h(a, b);
    return result;
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
    var result = VipsRaw.vips_col_L2Lcmc(L);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_col_C2Ccmc(float C)
   * }
   */
  public float colC2Ccmc(float C) throws VipsError {
    var result = VipsRaw.vips_col_C2Ccmc(C);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_col_Ch2hcmc(float C, float h)
   * }
   */
  public float colCh2hcmc(float C, float h) throws VipsError {
    var result = VipsRaw.vips_col_Ch2hcmc(C, h);
    return result;
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
    var result = VipsRaw.vips_col_Lcmc2L(Lcmc);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_col_Ccmc2C(float Ccmc)
   * }
   */
  public float colCcmc2C(float Ccmc) throws VipsError {
    var result = VipsRaw.vips_col_Ccmc2C(Ccmc);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_col_Chcmc2h(float C, float hcmc)
   * }
   */
  public float colChcmc2h(float C, float hcmc) throws VipsError {
    var result = VipsRaw.vips_col_Chcmc2h(C, hcmc);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_sRGB2scRGB_8(int r, int g, int b, float *R, float *G, float *B)
   * }
   */
  public void colSRGB2scRGB8(int r, int g, int b, MemorySegment R, MemorySegment G, MemorySegment B)
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
    var result = VipsRaw.vips_col_sRGB2scRGB_8(r, g, b, R, G, B);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_col_sRGB2scRGB_8");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_sRGB2scRGB_16(int r, int g, int b, float *R, float *G, float *B)
   * }
   */
  public void colSRGB2scRGB16(int r, int g, int b, MemorySegment R, MemorySegment G,
      MemorySegment B) throws VipsError {
    if(!VipsValidation.isValidPointer(R)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_16", "R");
    }
    if(!VipsValidation.isValidPointer(G)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_16", "G");
    }
    if(!VipsValidation.isValidPointer(B)) {
      VipsValidation.throwInvalidInputError("vips_col_sRGB2scRGB_16", "B");
    }
    var result = VipsRaw.vips_col_sRGB2scRGB_16(r, g, b, R, G, B);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_col_sRGB2scRGB_16");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_sRGB2scRGB_8_noclip(int r, int g, int b, float *R, float *G, float *B)
   * }
   */
  public void colSRGB2scRGB8Noclip(int r, int g, int b, MemorySegment R, MemorySegment G,
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
    var result = VipsRaw.vips_col_sRGB2scRGB_8_noclip(r, g, b, R, G, B);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_col_sRGB2scRGB_8_noclip");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_sRGB2scRGB_16_noclip(int r, int g, int b, float *R, float *G, float *B)
   * }
   */
  public void colSRGB2scRGB16Noclip(int r, int g, int b, MemorySegment R, MemorySegment G,
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
    var result = VipsRaw.vips_col_sRGB2scRGB_16_noclip(r, g, b, R, G, B);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_col_sRGB2scRGB_16_noclip");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_scRGB2XYZ(float R, float G, float B, float *X, float *Y, float *Z)
   * }
   */
  public void colScRGB2XYZ(float R, float G, float B, MemorySegment X, MemorySegment Y,
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
    var result = VipsRaw.vips_col_scRGB2XYZ(R, G, B, X, Y, Z);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_col_scRGB2XYZ");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_XYZ2scRGB(float X, float Y, float Z, float *R, float *G, float *B)
   * }
   */
  public void colXYZ2scRGB(float X, float Y, float Z, MemorySegment R, MemorySegment G,
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
    var result = VipsRaw.vips_col_XYZ2scRGB(X, Y, Z, R, G, B);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_col_XYZ2scRGB");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_scRGB2sRGB_8(float R, float G, float B, int *r, int *g, int *b, int *og)
   * }
   */
  public void colScRGB2sRGB8(float R, float G, float B, MemorySegment r, MemorySegment g,
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
    var result = VipsRaw.vips_col_scRGB2sRGB_8(R, G, B, r, g, b, og);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_col_scRGB2sRGB_8");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_scRGB2sRGB_16(float R, float G, float B, int *r, int *g, int *b, int *og)
   * }
   */
  public void colScRGB2sRGB16(float R, float G, float B, MemorySegment r, MemorySegment g,
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
    var result = VipsRaw.vips_col_scRGB2sRGB_16(R, G, B, r, g, b, og);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_col_scRGB2sRGB_16");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_scRGB2BW_16(float R, float G, float B, int *g, int *og)
   * }
   */
  public void colScRGB2BW16(float R, float G, float B, MemorySegment g, MemorySegment og) throws
      VipsError {
    if(!VipsValidation.isValidPointer(g)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2BW_16", "g");
    }
    if(!VipsValidation.isValidPointer(og)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2BW_16", "og");
    }
    var result = VipsRaw.vips_col_scRGB2BW_16(R, G, B, g, og);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_col_scRGB2BW_16");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_col_scRGB2BW_8(float R, float G, float B, int *g, int *og)
   * }
   */
  public void colScRGB2BW8(float R, float G, float B, MemorySegment g, MemorySegment og) throws
      VipsError {
    if(!VipsValidation.isValidPointer(g)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2BW_8", "g");
    }
    if(!VipsValidation.isValidPointer(og)) {
      VipsValidation.throwInvalidInputError("vips_col_scRGB2BW_8", "og");
    }
    var result = VipsRaw.vips_col_scRGB2BW_8(R, G, B, g, og);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_col_scRGB2BW_8");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_pythagoras(float L1, float a1, float b1, float L2, float a2, float b2)
   * }
   */
  public float pythagoras(float L1, float a1, float b1, float L2, float a2, float b2) throws
      VipsError {
    var result = VipsRaw.vips_pythagoras(L1, a1, b1, L2, a2, b2);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * float vips_col_dE00(float L1, float a1, float b1, float L2, float a2, float b2)
   * }
   */
  public float colDE00(float L1, float a1, float b1, float L2, float a2, float b2) throws
      VipsError {
    var result = VipsRaw.vips_col_dE00(L1, a1, b1, L2, a2, b2);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_init(const char *argv0)
   * }
   */
  public void init(String argv0String) throws VipsError {
    var argv0 = arena.allocateFrom(argv0String);
    var result = VipsRaw.vips_init(argv0);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_init");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_get_argv0()
   * }
   */
  public String getArgv0() throws VipsError {
    var result = VipsRaw.vips_get_argv0();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_get_argv0", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_get_prgname()
   * }
   */
  public String getPrgname() throws VipsError {
    var result = VipsRaw.vips_get_prgname();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_get_prgname", "result");
    }
    return result.getString(0);
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
  public void leakSet(boolean leakBoolean) throws VipsError {
    var leak = leakBoolean ? 1 : 0;
    VipsRaw.vips_leak_set(leak);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_block_untrusted_set(gboolean state)
   * }
   */
  public void blockUntrustedSet(boolean stateBoolean) throws VipsError {
    var state = stateBoolean ? 1 : 0;
    VipsRaw.vips_block_untrusted_set(state);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_version_string()
   * }
   */
  public String versionString() throws VipsError {
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
  public void version(int flag) throws VipsError {
    var result = VipsRaw.vips_version(flag);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_version");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_guess_prefix(const char *argv0, const char *env_name)
   * }
   */
  public String guessPrefix(String argv0String, String env_nameString) throws VipsError {
    var argv0 = arena.allocateFrom(argv0String);
    var env_name = arena.allocateFrom(env_nameString);
    var result = VipsRaw.vips_guess_prefix(argv0, env_name);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_guess_prefix", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_guess_libdir(const char *argv0, const char *env_name)
   * }
   */
  public String guessLibdir(String argv0String, String env_nameString) throws VipsError {
    var argv0 = arena.allocateFrom(argv0String);
    var env_name = arena.allocateFrom(env_nameString);
    var result = VipsRaw.vips_guess_libdir(argv0, env_name);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_guess_libdir", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_perlin(VipsImage **out, int width, int height, ...)
   * }
   */
  public void perlin(VipsOutputPointer out, int width, int height, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_perlin.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_perlin");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_worley(VipsImage **out, int width, int height, ...)
   * }
   */
  public void worley(VipsOutputPointer out, int width, int height, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_worley.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_worley");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_fractsurf(VipsImage **out, int width, int height, double fractal_dimension, ...)
   * }
   */
  public void fractsurf(VipsOutputPointer out, int width, int height, double fractal_dimension,
      VipsOption... options) throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_fractsurf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, fractal_dimension, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_fractsurf");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_fractal(VipsImage **out, int width, int height, double fractal_dimension, ...)
   * }
   */
  public void maskFractal(VipsOutputPointer out, int width, int height, double fractal_dimension,
      VipsOption... options) throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_fractal.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, fractal_dimension, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_fractal");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_gaussian_band(VipsImage **out, int width, int height, double frequency_cutoff_x, double frequency_cutoff_y, double radius, double amplitude_cutoff, ...)
   * }
   */
  public void maskGaussianBand(VipsOutputPointer out, int width, int height,
      double frequency_cutoff_x, double frequency_cutoff_y, double radius, double amplitude_cutoff,
      VipsOption... options) throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_gaussian_band.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, frequency_cutoff_x, frequency_cutoff_y, radius, amplitude_cutoff, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_gaussian_band");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_gaussian_ring(VipsImage **out, int width, int height, double frequency_cutoff, double amplitude_cutoff, double ringwidth, ...)
   * }
   */
  public void maskGaussianRing(VipsOutputPointer out, int width, int height,
      double frequency_cutoff, double amplitude_cutoff, double ringwidth, VipsOption... options)
      throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_gaussian_ring.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, frequency_cutoff, amplitude_cutoff, ringwidth, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_gaussian_ring");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_gaussian(VipsImage **out, int width, int height, double frequency_cutoff, double amplitude_cutoff, ...)
   * }
   */
  public void maskGaussian(VipsOutputPointer out, int width, int height, double frequency_cutoff,
      double amplitude_cutoff, VipsOption... options) throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_gaussian.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, frequency_cutoff, amplitude_cutoff, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_gaussian");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_butterworth_band(VipsImage **out, int width, int height, double order, double frequency_cutoff_x, double frequency_cutoff_y, double radius, double amplitude_cutoff, ...)
   * }
   */
  public void maskButterworthBand(VipsOutputPointer out, int width, int height, double order,
      double frequency_cutoff_x, double frequency_cutoff_y, double radius, double amplitude_cutoff,
      VipsOption... options) throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_butterworth_band.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, order, frequency_cutoff_x, frequency_cutoff_y, radius, amplitude_cutoff, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_butterworth_band");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_butterworth_ring(VipsImage **out, int width, int height, double order, double frequency_cutoff, double amplitude_cutoff, double ringwidth, ...)
   * }
   */
  public void maskButterworthRing(VipsOutputPointer out, int width, int height, double order,
      double frequency_cutoff, double amplitude_cutoff, double ringwidth, VipsOption... options)
      throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_butterworth_ring.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, order, frequency_cutoff, amplitude_cutoff, ringwidth, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_butterworth_ring");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_butterworth(VipsImage **out, int width, int height, double order, double frequency_cutoff, double amplitude_cutoff, ...)
   * }
   */
  public void maskButterworth(VipsOutputPointer out, int width, int height, double order,
      double frequency_cutoff, double amplitude_cutoff, VipsOption... options) throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_butterworth.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, order, frequency_cutoff, amplitude_cutoff, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_butterworth");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_ideal_band(VipsImage **out, int width, int height, double frequency_cutoff_x, double frequency_cutoff_y, double radius, ...)
   * }
   */
  public void maskIdealBand(VipsOutputPointer out, int width, int height, double frequency_cutoff_x,
      double frequency_cutoff_y, double radius, VipsOption... options) throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_ideal_band.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, frequency_cutoff_x, frequency_cutoff_y, radius, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_ideal_band");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_ideal_ring(VipsImage **out, int width, int height, double frequency_cutoff, double ringwidth, ...)
   * }
   */
  public void maskIdealRing(VipsOutputPointer out, int width, int height, double frequency_cutoff,
      double ringwidth, VipsOption... options) throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_ideal_ring.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, frequency_cutoff, ringwidth, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_ideal_ring");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mask_ideal(VipsImage **out, int width, int height, double frequency_cutoff, ...)
   * }
   */
  public void maskIdeal(VipsOutputPointer out, int width, int height, double frequency_cutoff,
      VipsOption... options) throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mask_ideal.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, frequency_cutoff, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mask_ideal");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tonelut(VipsImage **out, ...)
   * }
   */
  public void tonelut(VipsOutputPointer out, VipsOption... options) throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tonelut.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tonelut");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_invertlut(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void invertlut(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_invertlut", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_invertlut.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_invertlut");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_buildlut(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void buildlut(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_buildlut", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_buildlut.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_buildlut");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_identity(VipsImage **out, ...)
   * }
   */
  public void identity(VipsOutputPointer out, VipsOption... options) throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_identity.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_identity");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_zone(VipsImage **out, int width, int height, ...)
   * }
   */
  public void zone(VipsOutputPointer out, int width, int height, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_zone.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_zone");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sines(VipsImage **out, int width, int height, ...)
   * }
   */
  public void sines(VipsOutputPointer out, int width, int height, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sines.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sines");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_eye(VipsImage **out, int width, int height, ...)
   * }
   */
  public void eye(VipsOutputPointer out, int width, int height, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_eye.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_eye");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gaussnoise(VipsImage **out, int width, int height, ...)
   * }
   */
  public void gaussnoise(VipsOutputPointer out, int width, int height, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gaussnoise.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gaussnoise");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_text(VipsImage **out, const char *text, ...)
   * }
   */
  public void text(VipsOutputPointer out, String textString, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var text = arena.allocateFrom(textString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_text.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, text, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_text");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_logmat(VipsImage **out, double sigma, double min_ampl, ...)
   * }
   */
  public void logmat(VipsOutputPointer out, double sigma, double min_ampl, VipsOption... options)
      throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_logmat.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, sigma, min_ampl, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_logmat");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gaussmat(VipsImage **out, double sigma, double min_ampl, ...)
   * }
   */
  public void gaussmat(VipsOutputPointer out, double sigma, double min_ampl, VipsOption... options)
      throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gaussmat.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, sigma, min_ampl, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gaussmat");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_grey(VipsImage **out, int width, int height, ...)
   * }
   */
  public void grey(VipsOutputPointer out, int width, int height, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_grey.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_grey");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_xyz(VipsImage **out, int width, int height, ...)
   * }
   */
  public void xyz(VipsOutputPointer out, int width, int height, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_xyz.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_xyz");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_black(VipsImage **out, int width, int height, ...)
   * }
   */
  public void black(VipsOutputPointer out, int width, int height, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_black.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_black");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void dECMC(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_dECMC", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_dECMC", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_dECMC.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_dECMC");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_dE00(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void dE00(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_dE00", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_dE00", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_dE00.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_dE00");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_dE76(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void dE76(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_dE76", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_dE76", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_dE76.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_dE76");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_icc_export(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void iccExport(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_icc_export", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_icc_export.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_icc_export");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_icc_import(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void iccImport(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_icc_import", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_icc_import.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_icc_import");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_icc_transform(VipsImage *in, VipsImage **out, const char *output_profile, ...)
   * }
   */
  public void iccTransform(MemorySegment in, VipsOutputPointer out, String output_profileString,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_icc_transform", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var output_profile = arena.allocateFrom(output_profileString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_icc_transform.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, output_profile, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_icc_transform");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_profile_load(const char *name, VipsBlob **profile, ...)
   * }
   */
  public void profileLoad(String nameString, MemorySegment profile, VipsOption... options) throws
      VipsError {
    var name = arena.allocateFrom(nameString);
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
  public void xYZ2CMYK(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_XYZ2CMYK", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_XYZ2CMYK.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_XYZ2CMYK");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_CMYK2XYZ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void cMYK2XYZ(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_CMYK2XYZ", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_CMYK2XYZ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_CMYK2XYZ");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_Lab2LabS(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void lab2LabS(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_Lab2LabS", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_Lab2LabS.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_Lab2LabS");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LabS2Lab(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void labS2Lab(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LabS2Lab", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LabS2Lab.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LabS2Lab");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_Yxy2XYZ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void yxy2XYZ(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_Yxy2XYZ", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_Yxy2XYZ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_Yxy2XYZ");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_XYZ2Yxy(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void xYZ2Yxy(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_XYZ2Yxy", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_XYZ2Yxy.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_XYZ2Yxy");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_CMC2LCh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void cMC2LCh(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_CMC2LCh", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_CMC2LCh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_CMC2LCh");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LCh2CMC(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void lCh2CMC(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LCh2CMC", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LCh2CMC.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LCh2CMC");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sRGB2HSV(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sRGB2HSV(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sRGB2HSV", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sRGB2HSV.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sRGB2HSV");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_HSV2sRGB(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void hSV2sRGB(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_HSV2sRGB", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_HSV2sRGB.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_HSV2sRGB");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_scRGB2XYZ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void scRGB2XYZ(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_scRGB2XYZ", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_scRGB2XYZ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_scRGB2XYZ");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sRGB2scRGB(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sRGB2scRGB(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sRGB2scRGB", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sRGB2scRGB.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sRGB2scRGB");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_scRGB2BW(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void scRGB2BW(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_scRGB2BW", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_scRGB2BW.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_scRGB2BW");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_scRGB2sRGB(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void scRGB2sRGB(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_scRGB2sRGB", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_scRGB2sRGB.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_scRGB2sRGB");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_XYZ2scRGB(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void xYZ2scRGB(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_XYZ2scRGB", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_XYZ2scRGB.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_XYZ2scRGB");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_XYZ2Lab(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void xYZ2Lab(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_XYZ2Lab", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_XYZ2Lab.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_XYZ2Lab");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_Lab2XYZ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void lab2XYZ(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_Lab2XYZ", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_Lab2XYZ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_Lab2XYZ");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_CMC2XYZ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void cMC2XYZ(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_CMC2XYZ", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_CMC2XYZ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_CMC2XYZ");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_Yxy2Lab(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void yxy2Lab(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_Yxy2Lab", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_Yxy2Lab.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_Yxy2Lab");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_Lab2LCh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void lab2LCh(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_Lab2LCh", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_Lab2LCh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_Lab2LCh");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LCh2Lab(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void lCh2Lab(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LCh2Lab", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LCh2Lab.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LCh2Lab");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_Lab2LabQ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void lab2LabQ(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_Lab2LabQ", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_Lab2LabQ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_Lab2LabQ");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LabQ2Lab(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void labQ2Lab(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LabQ2Lab", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LabQ2Lab.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LabQ2Lab");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LabQ2LabS(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void labQ2LabS(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LabQ2LabS", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LabQ2LabS.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LabQ2LabS");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LabS2LabQ(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void labS2LabQ(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LabS2LabQ", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LabS2LabQ.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LabS2LabQ");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_float2rad(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void float2rad(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_float2rad", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_float2rad.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_float2rad");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rad2float(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rad2float(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rad2float", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rad2float.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rad2float");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_LabQ2sRGB(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void labQ2sRGB(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_LabQ2sRGB", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_LabQ2sRGB.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_LabQ2sRGB");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_colourspace(VipsImage *in, VipsImage **out, VipsInterpretation space, ...)
   * }
   */
  public void colourspace(MemorySegment in, VipsOutputPointer out, int space, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_colourspace", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_colourspace.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, space, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_colourspace");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_quadratic(VipsImage *in, VipsImage **out, VipsImage *coeff, ...)
   * }
   */
  public void quadratic(MemorySegment in, VipsOutputPointer out, MemorySegment coeff,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_quadratic", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(coeff)) {
      VipsValidation.throwInvalidInputError("vips_quadratic", "coeff");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_quadratic.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, coeff, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_quadratic");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mapim(VipsImage *in, VipsImage **out, VipsImage *index, ...)
   * }
   */
  public void mapim(MemorySegment in, VipsOutputPointer out, MemorySegment index,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_mapim", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(index)) {
      VipsValidation.throwInvalidInputError("vips_mapim", "index");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mapim.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, index, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mapim");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_resize(VipsImage *in, VipsImage **out, double scale, ...)
   * }
   */
  public void resize(MemorySegment in, VipsOutputPointer out, double scale, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_resize", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_resize.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, scale, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_resize");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_affine(VipsImage *in, VipsImage **out, double a, double b, double c, double d, ...)
   * }
   */
  public void affine(MemorySegment in, VipsOutputPointer out, double a, double b, double c,
      double d, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_affine", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_affine.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, a, b, c, d, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_affine");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rotate(VipsImage *in, VipsImage **out, double angle, ...)
   * }
   */
  public void rotate(MemorySegment in, VipsOutputPointer out, double angle, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rotate", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rotate.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, angle, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rotate");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_similarity(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void similarity(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_similarity", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_similarity.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_similarity");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_thumbnail_source(VipsSource *source, VipsImage **out, int width, ...)
   * }
   */
  public void thumbnailSource(MemorySegment source, VipsOutputPointer out, int width,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_thumbnail_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_thumbnail_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, width, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_thumbnail_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_thumbnail_image(VipsImage *in, VipsImage **out, int width, ...)
   * }
   */
  public void thumbnailImage(MemorySegment in, VipsOutputPointer out, int width,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_thumbnail_image", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_thumbnail_image.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, width, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_thumbnail_image");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_thumbnail_buffer(void *buf, size_t len, VipsImage **out, int width, ...)
   * }
   */
  public void thumbnailBuffer(MemorySegment buf, long len, VipsOutputPointer out, int width,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_thumbnail_buffer", "buf");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_thumbnail_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, outPointer, width, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_thumbnail_buffer");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_thumbnail(const char *filename, VipsImage **out, int width, ...)
   * }
   */
  public void thumbnail(String filenameString, VipsOutputPointer out, int width,
      VipsOption... options) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_thumbnail.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, width, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_thumbnail");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_reducev(VipsImage *in, VipsImage **out, double vshrink, ...)
   * }
   */
  public void reducev(MemorySegment in, VipsOutputPointer out, double vshrink,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_reducev", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_reducev.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, vshrink, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_reducev");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_reduceh(VipsImage *in, VipsImage **out, double hshrink, ...)
   * }
   */
  public void reduceh(MemorySegment in, VipsOutputPointer out, double hshrink,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_reduceh", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_reduceh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, hshrink, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_reduceh");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_reduce(VipsImage *in, VipsImage **out, double hshrink, double vshrink, ...)
   * }
   */
  public void reduce(MemorySegment in, VipsOutputPointer out, double hshrink, double vshrink,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_reduce", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_reduce.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, hshrink, vshrink, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_reduce");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_shrinkv(VipsImage *in, VipsImage **out, int vshrink, ...)
   * }
   */
  public void shrinkv(MemorySegment in, VipsOutputPointer out, int vshrink, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_shrinkv", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_shrinkv.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, vshrink, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_shrinkv");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_shrinkh(VipsImage *in, VipsImage **out, int hshrink, ...)
   * }
   */
  public void shrinkh(MemorySegment in, VipsOutputPointer out, int hshrink, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_shrinkh", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_shrinkh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, hshrink, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_shrinkh");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_shrink(VipsImage *in, VipsImage **out, double hshrink, double vshrink, ...)
   * }
   */
  public void shrink(MemorySegment in, VipsOutputPointer out, double hshrink, double vshrink,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_shrink", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_shrink.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, hshrink, vshrink, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_shrink");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_phasecor(VipsImage *in1, VipsImage *in2, VipsImage **out, ...)
   * }
   */
  public void phasecor(MemorySegment in1, MemorySegment in2, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in1)) {
      VipsValidation.throwInvalidInputError("vips_phasecor", "in1");
    }
    if(!VipsValidation.isValidPointer(in2)) {
      VipsValidation.throwInvalidInputError("vips_phasecor", "in2");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_phasecor.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in1, in2, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_phasecor");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_spectrum(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void spectrum(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_spectrum", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_spectrum.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_spectrum");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_freqmult(VipsImage *in, VipsImage *mask, VipsImage **out, ...)
   * }
   */
  public void freqmult(MemorySegment in, MemorySegment mask, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_freqmult", "in");
    }
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_freqmult", "mask");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_freqmult.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, mask, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_freqmult");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_invfft(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void invfft(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_invfft", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_invfft.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_invfft");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_fwfft(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void fwfft(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_fwfft", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_fwfft.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_fwfft");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_case(VipsImage *index, VipsImage **cases, VipsImage **out, int n, ...)
   * }
   */
  public void case1(MemorySegment index, MemorySegment cases, VipsOutputPointer out, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(index)) {
      VipsValidation.throwInvalidInputError("vips_case", "index");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_case.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(index, cases, outPointer, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_case");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_entropy(VipsImage *in, double *out, ...)
   * }
   */
  public void histEntropy(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_entropy", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_entropy.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_entropy");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_ismonotonic(VipsImage *in, gboolean *out, ...)
   * }
   */
  public void histIsmonotonic(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_ismonotonic", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_ismonotonic.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_ismonotonic");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_local(VipsImage *in, VipsImage **out, int width, int height, ...)
   * }
   */
  public void histLocal(MemorySegment in, VipsOutputPointer out, int width, int height,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_local", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_local.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_local");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_match(VipsImage *in, VipsImage *ref, VipsImage **out, ...)
   * }
   */
  public void histMatch(MemorySegment in, MemorySegment ref, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_match", "in");
    }
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_hist_match", "ref");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_match.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, ref, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_match");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_plot(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void histPlot(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_plot", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_plot.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_plot");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_equal(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void histEqual(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_equal", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_equal.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_equal");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_norm(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void histNorm(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_norm", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_norm.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_norm");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_cum(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void histCum(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_cum", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_cum.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_cum");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_stdif(VipsImage *in, VipsImage **out, int width, int height, ...)
   * }
   */
  public void stdif(MemorySegment in, VipsOutputPointer out, int width, int height,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_stdif", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_stdif.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_stdif");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void maplut(MemorySegment in, VipsOutputPointer out, MemorySegment lut,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_maplut", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(lut)) {
      VipsValidation.throwInvalidInputError("vips_maplut", "lut");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_maplut.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, lut, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_maplut");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_matrixinvert(VipsImage *m, VipsImage **out, ...)
   * }
   */
  public void matrixinvert(MemorySegment m, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(m)) {
      VipsValidation.throwInvalidInputError("vips_matrixinvert", "m");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_matrixinvert.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(m, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_matrixinvert");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_remosaic(VipsImage *in, VipsImage **out, const char *old_str, const char *new_str, ...)
   * }
   */
  public void remosaic(MemorySegment in, VipsOutputPointer out, String old_strString,
      String new_strString, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_remosaic", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var old_str = arena.allocateFrom(old_strString);
    var new_str = arena.allocateFrom(new_strString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_remosaic.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, old_str, new_str, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_remosaic");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_globalbalance(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void globalbalance(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_globalbalance", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_globalbalance.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_globalbalance");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_match(VipsImage *ref, VipsImage *sec, VipsImage **out, int xr1, int yr1, int xs1, int ys1, int xr2, int yr2, int xs2, int ys2, ...)
   * }
   */
  public void match(MemorySegment ref, MemorySegment sec, VipsOutputPointer out, int xr1, int yr1,
      int xs1, int ys1, int xr2, int yr2, int xs2, int ys2, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_match", "ref");
    }
    if(!VipsValidation.isValidPointer(sec)) {
      VipsValidation.throwInvalidInputError("vips_match", "sec");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_match.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(ref, sec, outPointer, xr1, yr1, xs1, ys1, xr2, yr2, xs2, ys2, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_match");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mosaic1(VipsImage *ref, VipsImage *sec, VipsImage **out, VipsDirection direction, int xr1, int yr1, int xs1, int ys1, int xr2, int yr2, int xs2, int ys2, ...)
   * }
   */
  public void mosaic1(MemorySegment ref, MemorySegment sec, VipsOutputPointer out, int direction,
      int xr1, int yr1, int xs1, int ys1, int xr2, int yr2, int xs2, int ys2, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_mosaic1", "ref");
    }
    if(!VipsValidation.isValidPointer(sec)) {
      VipsValidation.throwInvalidInputError("vips_mosaic1", "sec");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mosaic1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(ref, sec, outPointer, direction, xr1, yr1, xs1, ys1, xr2, yr2, xs2, ys2, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mosaic1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_mosaic(VipsImage *ref, VipsImage *sec, VipsImage **out, VipsDirection direction, int xref, int yref, int xsec, int ysec, ...)
   * }
   */
  public void mosaic(MemorySegment ref, MemorySegment sec, VipsOutputPointer out, int direction,
      int xref, int yref, int xsec, int ysec, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_mosaic", "ref");
    }
    if(!VipsValidation.isValidPointer(sec)) {
      VipsValidation.throwInvalidInputError("vips_mosaic", "sec");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_mosaic.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(ref, sec, outPointer, direction, xref, yref, xsec, ysec, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_mosaic");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_merge(VipsImage *ref, VipsImage *sec, VipsImage **out, VipsDirection direction, int dx, int dy, ...)
   * }
   */
  public void merge(MemorySegment ref, MemorySegment sec, VipsOutputPointer out, int direction,
      int dx, int dy, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_merge", "ref");
    }
    if(!VipsValidation.isValidPointer(sec)) {
      VipsValidation.throwInvalidInputError("vips_merge", "sec");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_merge.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(ref, sec, outPointer, direction, dx, dy, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_merge");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_fill_nearest(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void fillNearest(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_fill_nearest", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_fill_nearest.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_fill_nearest");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void median(MemorySegment in, VipsOutputPointer out, int size, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_median", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_median.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, size, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_median");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rank(VipsImage *in, VipsImage **out, int width, int height, int index, ...)
   * }
   */
  public void rank(MemorySegment in, VipsOutputPointer out, int width, int height, int index,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rank", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rank.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, width, height, index, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rank");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_morph(VipsImage *in, VipsImage **out, VipsImage *mask, VipsOperationMorphology morph, ...)
   * }
   */
  public void morph(MemorySegment in, VipsOutputPointer out, MemorySegment mask, int morph,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_morph", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_morph", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_morph.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, mask, morph, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_morph");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_canny(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void canny(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_canny", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_canny.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_canny");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_prewitt(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void prewitt(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_prewitt", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_prewitt.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_prewitt");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_scharr(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void scharr(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_scharr", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_scharr.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_scharr");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sobel(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sobel(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sobel", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sobel.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sobel");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_fastcor(VipsImage *in, VipsImage *ref, VipsImage **out, ...)
   * }
   */
  public void fastcor(MemorySegment in, MemorySegment ref, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_fastcor", "in");
    }
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_fastcor", "ref");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_fastcor.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, ref, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_fastcor");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_spcor(VipsImage *in, VipsImage *ref, VipsImage **out, ...)
   * }
   */
  public void spcor(MemorySegment in, MemorySegment ref, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_spcor", "in");
    }
    if(!VipsValidation.isValidPointer(ref)) {
      VipsValidation.throwInvalidInputError("vips_spcor", "ref");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_spcor.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, ref, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_spcor");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sharpen(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sharpen(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sharpen", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sharpen.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sharpen");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gaussblur(VipsImage *in, VipsImage **out, double sigma, ...)
   * }
   */
  public void gaussblur(MemorySegment in, VipsOutputPointer out, double sigma,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_gaussblur", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gaussblur.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, sigma, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gaussblur");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_compass(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void compass(MemorySegment in, VipsOutputPointer out, MemorySegment mask,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_compass", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_compass", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_compass.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_compass");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_convasep(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void convasep(MemorySegment in, VipsOutputPointer out, MemorySegment mask,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_convasep", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_convasep", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_convasep.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_convasep");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_convsep(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void convsep(MemorySegment in, VipsOutputPointer out, MemorySegment mask,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_convsep", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_convsep", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_convsep.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_convsep");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_conva(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void conva(MemorySegment in, VipsOutputPointer out, MemorySegment mask,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_conva", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_conva", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_conva.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_conva");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_convi(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void convi(MemorySegment in, VipsOutputPointer out, MemorySegment mask,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_convi", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_convi", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_convi.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_convi");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_convf(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void convf(MemorySegment in, VipsOutputPointer out, MemorySegment mask,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_convf", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_convf", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_convf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_convf");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_conv(VipsImage *in, VipsImage **out, VipsImage *mask, ...)
   * }
   */
  public void conv(MemorySegment in, VipsOutputPointer out, MemorySegment mask,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_conv", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_conv", "mask");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_conv.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, mask, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_conv");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gamma(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void gamma(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_gamma", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gamma.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gamma");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_falsecolour(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void falsecolour(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_falsecolour", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_falsecolour.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_falsecolour");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_composite2(VipsImage *base, VipsImage *overlay, VipsImage **out, VipsBlendMode mode, ...)
   * }
   */
  public void composite2(MemorySegment base, MemorySegment overlay, VipsOutputPointer out, int mode,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(base)) {
      VipsValidation.throwInvalidInputError("vips_composite2", "base");
    }
    if(!VipsValidation.isValidPointer(overlay)) {
      VipsValidation.throwInvalidInputError("vips_composite2", "overlay");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_composite2.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(base, overlay, outPointer, mode, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_composite2");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_composite(VipsImage **in, VipsImage **out, int n, int *mode, ...)
   * }
   */
  public void composite(MemorySegment in, VipsOutputPointer out, int n, MemorySegment mode,
      VipsOption... options) throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(mode)) {
      VipsValidation.throwInvalidInputError("vips_composite", "mode");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_composite.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, n, mode, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_composite");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_unpremultiply(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void unpremultiply(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_unpremultiply", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_unpremultiply.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_unpremultiply");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_premultiply(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void premultiply(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_premultiply", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_premultiply.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_premultiply");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_addalpha(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void addalpha(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_addalpha", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_addalpha.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_addalpha");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_flatten(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void flatten(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_flatten", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_flatten.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_flatten");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_switch(VipsImage **tests, VipsImage **out, int n, ...)
   * }
   */
  public void switch1(MemorySegment tests, VipsOutputPointer out, int n, VipsOption... options)
      throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_switch.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(tests, outPointer, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_switch");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_ifthenelse(VipsImage *cond, VipsImage *in1, VipsImage *in2, VipsImage **out, ...)
   * }
   */
  public void ifthenelse(MemorySegment cond, MemorySegment in1, MemorySegment in2,
      VipsOutputPointer out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(cond)) {
      VipsValidation.throwInvalidInputError("vips_ifthenelse", "cond");
    }
    if(!VipsValidation.isValidPointer(in1)) {
      VipsValidation.throwInvalidInputError("vips_ifthenelse", "in1");
    }
    if(!VipsValidation.isValidPointer(in2)) {
      VipsValidation.throwInvalidInputError("vips_ifthenelse", "in2");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_ifthenelse.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(cond, in1, in2, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_ifthenelse");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_recomb(VipsImage *in, VipsImage **out, VipsImage *m, ...)
   * }
   */
  public void recomb(MemorySegment in, VipsOutputPointer out, MemorySegment m,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_recomb", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(m)) {
      VipsValidation.throwInvalidInputError("vips_recomb", "m");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_recomb.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, m, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_recomb");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandmean(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void bandmean(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandmean", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandmean.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandmean");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandeor(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void bandeor(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandeor", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandeor.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandeor");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandor(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void bandor(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandor", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandor.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandor");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandand(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void bandand(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandand", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandand.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandand");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandbool(VipsImage *in, VipsImage **out, VipsOperationBoolean boolean, ...)
   * }
   */
  public void bandbool(MemorySegment in, VipsOutputPointer out, int boolean1, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandbool", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandbool.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, boolean1, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandbool");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandunfold(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void bandunfold(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandunfold", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandunfold.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandunfold");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandfold(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void bandfold(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandfold", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandfold.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandfold");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandrank(VipsImage **in, VipsImage **out, int n, ...)
   * }
   */
  public void bandrank(MemorySegment in, VipsOutputPointer out, int n, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandrank.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandrank");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandjoin_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void bandjoinConst1(MemorySegment in, VipsOutputPointer out, double c,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandjoin_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandjoin_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandjoin_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandjoin_const(VipsImage *in, VipsImage **out, double *c, int n, ...)
   * }
   */
  public void bandjoinConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandjoin_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_bandjoin_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandjoin_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandjoin_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandjoin2(VipsImage *in1, VipsImage *in2, VipsImage **out, ...)
   * }
   */
  public void bandjoin2(MemorySegment in1, MemorySegment in2, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in1)) {
      VipsValidation.throwInvalidInputError("vips_bandjoin2", "in1");
    }
    if(!VipsValidation.isValidPointer(in2)) {
      VipsValidation.throwInvalidInputError("vips_bandjoin2", "in2");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandjoin2.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in1, in2, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandjoin2");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_bandjoin(VipsImage **in, VipsImage **out, int n, ...)
   * }
   */
  public void bandjoin(MemorySegment in, VipsOutputPointer out, int n, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_bandjoin.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_bandjoin");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_byteswap(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void byteswap(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_byteswap", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_byteswap.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_byteswap");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_msb(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void msb(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_msb", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_msb.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_msb");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_scale(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void scale(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_scale", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_scale.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_scale");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_dpcomplex(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castDpcomplex(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_dpcomplex", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_dpcomplex.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_dpcomplex");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_complex(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castComplex(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_complex", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_complex.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_complex");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_double(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castDouble(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_double", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_double.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_double");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_float(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castFloat(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_float", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_float.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_float");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_int(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castInt(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_int", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_int.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_int");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_uint(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castUint(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_uint", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_uint.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_uint");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_short(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castShort(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_short", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_short.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_short");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_ushort(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castUshort(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_ushort", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_ushort.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_ushort");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_char(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castChar(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_char", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_char.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_char");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast_uchar(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void castUchar(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast_uchar", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast_uchar.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast_uchar");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cast(VipsImage *in, VipsImage **out, VipsBandFormat format, ...)
   * }
   */
  public void cast(MemorySegment in, VipsOutputPointer out, int format, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cast", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cast.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, format, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cast");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_subsample(VipsImage *in, VipsImage **out, int xfac, int yfac, ...)
   * }
   */
  public void subsample(MemorySegment in, VipsOutputPointer out, int xfac, int yfac,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_subsample", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_subsample.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, xfac, yfac, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_subsample");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_zoom(VipsImage *in, VipsImage **out, int xfac, int yfac, ...)
   * }
   */
  public void zoom(MemorySegment in, VipsOutputPointer out, int xfac, int yfac,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_zoom", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_zoom.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, xfac, yfac, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_zoom");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_autorot(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void autorot(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_autorot", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_autorot.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_autorot");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rot45(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rot45(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rot45", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rot45.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rot45");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rot270(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rot270(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rot270", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rot270.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rot270");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rot180(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rot180(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rot180", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rot180.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rot180");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rot90(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rot90(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rot90", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rot90.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rot90");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rot(VipsImage *in, VipsImage **out, VipsAngle angle, ...)
   * }
   */
  public void rot(MemorySegment in, VipsOutputPointer out, int angle, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rot", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rot.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, angle, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rot");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_wrap(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void wrap(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_wrap", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_wrap.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_wrap");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_transpose3d(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void transpose3d(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_transpose3d", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_transpose3d.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_transpose3d");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_grid(VipsImage *in, VipsImage **out, int tile_height, int across, int down, ...)
   * }
   */
  public void grid(MemorySegment in, VipsOutputPointer out, int tile_height, int across, int down,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_grid", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_grid.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, tile_height, across, down, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_grid");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_replicate(VipsImage *in, VipsImage **out, int across, int down, ...)
   * }
   */
  public void replicate(MemorySegment in, VipsOutputPointer out, int across, int down,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_replicate", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_replicate.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, across, down, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_replicate");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_extract_band(VipsImage *in, VipsImage **out, int band, ...)
   * }
   */
  public void extractBand(MemorySegment in, VipsOutputPointer out, int band, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_extract_band", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_extract_band.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, band, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_extract_band");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_smartcrop(VipsImage *in, VipsImage **out, int width, int height, ...)
   * }
   */
  public void smartcrop(MemorySegment in, VipsOutputPointer out, int width, int height,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_smartcrop", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_smartcrop.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_smartcrop");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_crop(VipsImage *in, VipsImage **out, int left, int top, int width, int height, ...)
   * }
   */
  public void crop(MemorySegment in, VipsOutputPointer out, int left, int top, int width,
      int height, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_crop", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_crop.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, left, top, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_crop");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_extract_area(VipsImage *in, VipsImage **out, int left, int top, int width, int height, ...)
   * }
   */
  public void extractArea(MemorySegment in, VipsOutputPointer out, int left, int top, int width,
      int height, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_extract_area", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_extract_area.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, left, top, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_extract_area");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_arrayjoin(VipsImage **in, VipsImage **out, int n, ...)
   * }
   */
  public void arrayjoin(MemorySegment in, VipsOutputPointer out, int n, VipsOption... options)
      throws VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_arrayjoin.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_arrayjoin");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_join(VipsImage *in1, VipsImage *in2, VipsImage **out, VipsDirection direction, ...)
   * }
   */
  public void join(MemorySegment in1, MemorySegment in2, VipsOutputPointer out, int direction,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in1)) {
      VipsValidation.throwInvalidInputError("vips_join", "in1");
    }
    if(!VipsValidation.isValidPointer(in2)) {
      VipsValidation.throwInvalidInputError("vips_join", "in2");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_join.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in1, in2, outPointer, direction, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_join");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_insert(VipsImage *main, VipsImage *sub, VipsImage **out, int x, int y, ...)
   * }
   */
  public void insert(MemorySegment main, MemorySegment sub, VipsOutputPointer out, int x, int y,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(main)) {
      VipsValidation.throwInvalidInputError("vips_insert", "main");
    }
    if(!VipsValidation.isValidPointer(sub)) {
      VipsValidation.throwInvalidInputError("vips_insert", "sub");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_insert.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(main, sub, outPointer, x, y, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_insert");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_flip(VipsImage *in, VipsImage **out, VipsDirection direction, ...)
   * }
   */
  public void flip(MemorySegment in, VipsOutputPointer out, int direction, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_flip", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_flip.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, direction, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_flip");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gravity(VipsImage *in, VipsImage **out, VipsCompassDirection direction, int width, int height, ...)
   * }
   */
  public void gravity(MemorySegment in, VipsOutputPointer out, int direction, int width, int height,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_gravity", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gravity.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, direction, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gravity");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_embed(VipsImage *in, VipsImage **out, int x, int y, int width, int height, ...)
   * }
   */
  public void embed(MemorySegment in, VipsOutputPointer out, int x, int y, int width, int height,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_embed", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_embed.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, x, y, width, height, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_embed");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_copy_file(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void copyFile(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_copy_file", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_copy_file.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_copy_file");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cache(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void cache(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cache", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cache.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cache");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sequential(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sequential(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sequential", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sequential.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sequential");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_linecache(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void linecache(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_linecache", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_linecache.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_linecache");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tilecache(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void tilecache(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_tilecache", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tilecache.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tilecache");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_copy(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void copy(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_copy", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_copy.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_copy");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void houghCircle(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hough_circle", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hough_circle.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hough_circle");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hough_line(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void houghLine(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hough_line", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hough_line.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hough_line");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_find_indexed(VipsImage *in, VipsImage *index, VipsImage **out, ...)
   * }
   */
  public void histFindIndexed(MemorySegment in, MemorySegment index, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_find_indexed", "in");
    }
    if(!VipsValidation.isValidPointer(index)) {
      VipsValidation.throwInvalidInputError("vips_hist_find_indexed", "index");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_find_indexed.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, index, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_find_indexed");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_find_ndim(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void histFindNdim(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_find_ndim", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_find_ndim.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_find_ndim");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_hist_find(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void histFind(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_hist_find", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_hist_find.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_hist_find");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void measure(MemorySegment in, VipsOutputPointer out, int h, int v, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_measure", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_measure.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, h, v, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_measure");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_stats(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void stats(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_stats", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_stats.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_stats");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_max(VipsImage *in, double *out, ...)
   * }
   */
  public void max(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_max", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_max.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_max");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_min(VipsImage *in, double *out, ...)
   * }
   */
  public void min(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_min", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_min.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_min");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_deviate(VipsImage *in, double *out, ...)
   * }
   */
  public void deviate(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_deviate", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_deviate.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_deviate");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_avg(VipsImage *in, double *out, ...)
   * }
   */
  public void avg(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_avg", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_avg.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_avg");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_atan2_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void atan2Const1(MemorySegment in, VipsOutputPointer out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_atan2_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_atan2_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_atan2_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_wop_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void wopConst1(MemorySegment in, VipsOutputPointer out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_wop_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_wop_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_wop_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pow_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void powConst1(MemorySegment in, VipsOutputPointer out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_pow_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pow_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pow_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_math2_const1(VipsImage *in, VipsImage **out, VipsOperationMath2 math2, double c, ...)
   * }
   */
  public void math2Const1(MemorySegment in, VipsOutputPointer out, int math2, double c,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_math2_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_math2_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, math2, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_math2_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_atan2_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void atan2Const(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_atan2_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_atan2_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_atan2_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_atan2_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_wop_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void wopConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_wop_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_wop_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_wop_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_wop_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pow_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void powConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_pow_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_pow_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pow_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pow_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_math2_const(VipsImage *in, VipsImage **out, VipsOperationMath2 math2, const double *c, int n, ...)
   * }
   */
  public void math2Const(MemorySegment in, VipsOutputPointer out, int math2, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_math2_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_math2_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_math2_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, math2, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_math2_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_atan2(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void atan2(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_atan2", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_atan2", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_atan2.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_atan2");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_wop(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void wop(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_wop", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_wop", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_wop.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_wop");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pow(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void pow(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_pow", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_pow", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pow.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pow");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_math2(VipsImage *left, VipsImage *right, VipsImage **out, VipsOperationMath2 math2, ...)
   * }
   */
  public void math2(MemorySegment left, MemorySegment right, VipsOutputPointer out, int math2,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_math2", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_math2", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_math2.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, math2, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_math2");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rshift_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void rshiftConst1(MemorySegment in, VipsOutputPointer out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rshift_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rshift_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rshift_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_lshift_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void lshiftConst1(MemorySegment in, VipsOutputPointer out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_lshift_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_lshift_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_lshift_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_eorimage_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void eorimageConst1(MemorySegment in, VipsOutputPointer out, double c,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_eorimage_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_eorimage_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_eorimage_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_orimage_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void orimageConst1(MemorySegment in, VipsOutputPointer out, double c,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_orimage_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_orimage_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_orimage_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_andimage_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void andimageConst1(MemorySegment in, VipsOutputPointer out, double c,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_andimage_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_andimage_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_andimage_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_boolean_const1(VipsImage *in, VipsImage **out, VipsOperationBoolean boolean, double c, ...)
   * }
   */
  public void booleanConst1(MemorySegment in, VipsOutputPointer out, int boolean1, double c,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_boolean_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_boolean_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, boolean1, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_boolean_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rshift_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void rshiftConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rshift_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_rshift_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rshift_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rshift_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_lshift_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void lshiftConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_lshift_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_lshift_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_lshift_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_lshift_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_eorimage_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void eorimageConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_eorimage_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_eorimage_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_eorimage_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_eorimage_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_orimage_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void orimageConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_orimage_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_orimage_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_orimage_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_orimage_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_andimage_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void andimageConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_andimage_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_andimage_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_andimage_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_andimage_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_boolean_const(VipsImage *in, VipsImage **out, VipsOperationBoolean boolean, const double *c, int n, ...)
   * }
   */
  public void booleanConst(MemorySegment in, VipsOutputPointer out, int boolean1, MemorySegment c,
      int n, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_boolean_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_boolean_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_boolean_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, boolean1, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_boolean_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rshift(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void rshift(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_rshift", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_rshift", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rshift.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rshift");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_lshift(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void lshift(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_lshift", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_lshift", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_lshift.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_lshift");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_eorimage(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void eorimage(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_eorimage", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_eorimage", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_eorimage.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_eorimage");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_orimage(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void orimage(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_orimage", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_orimage", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_orimage.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_orimage");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_andimage(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void andimage(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_andimage", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_andimage", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_andimage.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_andimage");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_boolean(VipsImage *left, VipsImage *right, VipsImage **out, VipsOperationBoolean boolean, ...)
   * }
   */
  public void boolean1(MemorySegment left, MemorySegment right, VipsOutputPointer out, int boolean1,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_boolean", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_boolean", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_boolean.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, boolean1, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_boolean");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_moreeq_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void moreeqConst1(MemorySegment in, VipsOutputPointer out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_moreeq_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_moreeq_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_moreeq_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_more_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void moreConst1(MemorySegment in, VipsOutputPointer out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_more_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_more_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_more_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_lesseq_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void lesseqConst1(MemorySegment in, VipsOutputPointer out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_lesseq_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_lesseq_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_lesseq_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_less_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void lessConst1(MemorySegment in, VipsOutputPointer out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_less_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_less_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_less_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_notequal_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void notequalConst1(MemorySegment in, VipsOutputPointer out, double c,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_notequal_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_notequal_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_notequal_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_equal_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void equalConst1(MemorySegment in, VipsOutputPointer out, double c, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_equal_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_equal_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_equal_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_relational_const1(VipsImage *in, VipsImage **out, VipsOperationRelational relational, double c, ...)
   * }
   */
  public void relationalConst1(MemorySegment in, VipsOutputPointer out, int relational, double c,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_relational_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_relational_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, relational, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_relational_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_moreeq_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void moreeqConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_moreeq_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_moreeq_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_moreeq_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_moreeq_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_more_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void moreConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_more_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_more_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_more_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_more_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_lesseq_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void lesseqConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_lesseq_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_lesseq_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_lesseq_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_lesseq_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_less_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void lessConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_less_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_less_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_less_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_less_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_notequal_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void notequalConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_notequal_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_notequal_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_notequal_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_notequal_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_equal_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void equalConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_equal_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_equal_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_equal_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_equal_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_relational_const(VipsImage *in, VipsImage **out, VipsOperationRelational relational, const double *c, int n, ...)
   * }
   */
  public void relationalConst(MemorySegment in, VipsOutputPointer out, int relational,
      MemorySegment c, int n, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_relational_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_relational_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_relational_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, relational, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_relational_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_moreeq(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void moreeq(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_moreeq", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_moreeq", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_moreeq.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_moreeq");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_more(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void more(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_more", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_more", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_more.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_more");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_lesseq(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void lesseq(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_lesseq", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_lesseq", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_lesseq.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_lesseq");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_less(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void less(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_less", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_less", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_less.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_less");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_notequal(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void notequal(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_notequal", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_notequal", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_notequal.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_notequal");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_equal(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void equal(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_equal", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_equal", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_equal.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_equal");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_relational(VipsImage *left, VipsImage *right, VipsImage **out, VipsOperationRelational relational, ...)
   * }
   */
  public void relational(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      int relational, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_relational", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_relational", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_relational.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, relational, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_relational");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_complexform(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void complexform(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_complexform", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_complexform", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_complexform.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_complexform");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_imag(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void imag(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_imag", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_imag.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_imag");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_real(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void real(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_real", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_real.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_real");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_complexget(VipsImage *in, VipsImage **out, VipsOperationComplexget get, ...)
   * }
   */
  public void complexget(MemorySegment in, VipsOutputPointer out, int get, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_complexget", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_complexget.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, get, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_complexget");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cross_phase(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void crossPhase(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_cross_phase", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_cross_phase", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cross_phase.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cross_phase");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_complex2(VipsImage *left, VipsImage *right, VipsImage **out, VipsOperationComplex2 cmplx, ...)
   * }
   */
  public void complex2(MemorySegment left, MemorySegment right, VipsOutputPointer out, int cmplx,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_complex2", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_complex2", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_complex2.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, cmplx, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_complex2");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_conj(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void conj(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_conj", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_conj.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_conj");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rect(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rect(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rect", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rect.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rect");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_polar(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void polar(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_polar", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_polar.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_polar");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_complex(VipsImage *in, VipsImage **out, VipsOperationComplex cmplx, ...)
   * }
   */
  public void complex(MemorySegment in, VipsOutputPointer out, int cmplx, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_complex", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_complex.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, cmplx, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_complex");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_atanh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void atanh(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_atanh", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_atanh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_atanh");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_acosh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void acosh(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_acosh", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_acosh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_acosh");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_asinh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void asinh(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_asinh", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_asinh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_asinh");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tanh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void tanh(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_tanh", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tanh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tanh");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cosh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void cosh(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cosh", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cosh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cosh");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sinh(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sinh(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sinh", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sinh.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sinh");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_log10(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void log10(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_log10", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_log10.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_log10");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_log(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void log(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_log", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_log.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_log");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_exp10(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void exp10(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_exp10", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_exp10.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_exp10");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_exp(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void exp(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_exp", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_exp.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_exp");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_atan(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void atan(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_atan", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_atan.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_atan");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_acos(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void acos(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_acos", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_acos.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_acos");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_asin(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void asin(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_asin", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_asin.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_asin");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tan(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void tan(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_tan", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tan.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tan");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cos(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void cos(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_cos", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_cos.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cos");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sin(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sin(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sin", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sin.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sin");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_math(VipsImage *in, VipsImage **out, VipsOperationMath math, ...)
   * }
   */
  public void math(MemorySegment in, VipsOutputPointer out, int math, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_math", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_math.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, math, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_math");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rint(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void rint(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rint", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rint.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rint");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_ceil(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void ceil(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_ceil", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_ceil.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_ceil");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_floor(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void floor(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_floor", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_floor.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_floor");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_round(VipsImage *in, VipsImage **out, VipsOperationRound round, ...)
   * }
   */
  public void round(MemorySegment in, VipsOutputPointer out, int round, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_round", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_round.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, round, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_round");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sign(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void sign(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sign", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sign.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sign");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_abs(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void abs(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_abs", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_abs.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_abs");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_invert(VipsImage *in, VipsImage **out, ...)
   * }
   */
  public void invert(MemorySegment in, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_invert", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_invert.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_invert");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_remainder_const1(VipsImage *in, VipsImage **out, double c, ...)
   * }
   */
  public void remainderConst1(MemorySegment in, VipsOutputPointer out, double c,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_remainder_const1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_remainder_const1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_remainder_const1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_remainder_const(VipsImage *in, VipsImage **out, const double *c, int n, ...)
   * }
   */
  public void remainderConst(MemorySegment in, VipsOutputPointer out, MemorySegment c, int n,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_remainder_const", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_remainder_const", "c");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_remainder_const.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, c, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_remainder_const");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_remainder(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void remainder(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_remainder", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_remainder", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_remainder.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_remainder");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_linear1(VipsImage *in, VipsImage **out, double a, double b, ...)
   * }
   */
  public void linear1(MemorySegment in, VipsOutputPointer out, double a, double b,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_linear1", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_linear1.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, a, b, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_linear1");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_linear(VipsImage *in, VipsImage **out, const double *a, const double *b, int n, ...)
   * }
   */
  public void linear(MemorySegment in, VipsOutputPointer out, MemorySegment a, MemorySegment b,
      int n, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_linear", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_linear", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_linear", "b");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_linear.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, a, b, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_linear");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_divide(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void divide(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_divide", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_divide", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_divide.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_divide");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_multiply(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void multiply(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_multiply", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_multiply", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_multiply.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_multiply");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_subtract(VipsImage *in1, VipsImage *in2, VipsImage **out, ...)
   * }
   */
  public void subtract(MemorySegment in1, MemorySegment in2, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in1)) {
      VipsValidation.throwInvalidInputError("vips_subtract", "in1");
    }
    if(!VipsValidation.isValidPointer(in2)) {
      VipsValidation.throwInvalidInputError("vips_subtract", "in2");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_subtract.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in1, in2, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_subtract");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sum(VipsImage **in, VipsImage **out, int n, ...)
   * }
   */
  public void sum(MemorySegment in, VipsOutputPointer out, int n, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_sum.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(in, outPointer, n, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sum");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_add(VipsImage *left, VipsImage *right, VipsImage **out, ...)
   * }
   */
  public void add(MemorySegment left, MemorySegment right, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(left)) {
      VipsValidation.throwInvalidInputError("vips_add", "left");
    }
    if(!VipsValidation.isValidPointer(right)) {
      VipsValidation.throwInvalidInputError("vips_add", "right");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_add.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(left, right, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_add");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void dzsave(MemorySegment in, String nameString, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_dzsave", "in");
    }
    var name = arena.allocateFrom(nameString);
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
  public void jxlsave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_jxlsave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void jxlload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jxlload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jxlload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jxlload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void jxlloadBuffer(MemorySegment buf, long len, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_jxlload_buffer", "buf");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jxlload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jxlload_buffer");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jxlload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void jxlloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_jxlload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jxlload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jxlload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void jp2ksave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_jp2ksave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void jp2kloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_jp2kload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jp2kload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jp2kload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jp2kload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void jp2kloadBuffer(MemorySegment buf, long len, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_jp2kload_buffer", "buf");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jp2kload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jp2kload_buffer");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jp2kload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void jp2kload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jp2kload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jp2kload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_niftisave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void niftisave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_niftisave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void niftiloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_niftiload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_niftiload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_niftiload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_niftiload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void niftiload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_niftiload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_niftiload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void heifsave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_heifsave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void heifloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_heifload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_heifload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_heifload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_heifload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void heifloadBuffer(MemorySegment buf, long len, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_heifload_buffer", "buf");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_heifload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_heifload_buffer");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_heifload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void heifload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_heifload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_heifload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void gifsave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_gifsave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void gifloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_gifload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gifload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gifload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gifload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void gifloadBuffer(MemorySegment buf, long len, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_gifload_buffer", "buf");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gifload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gifload_buffer");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_gifload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void gifload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_gifload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_gifload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_svgload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void svgloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_svgload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_svgload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_svgload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_svgload_string(const char *str, VipsImage **out, ...)
   * }
   */
  public void svgloadString(String strString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var str = arena.allocateFrom(strString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_svgload_string.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(str, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_svgload_string");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_svgload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void svgloadBuffer(MemorySegment buf, long len, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_svgload_buffer", "buf");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_svgload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_svgload_buffer");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_svgload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void svgload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_svgload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_svgload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pdfload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void pdfloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_pdfload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pdfload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pdfload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pdfload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void pdfloadBuffer(MemorySegment buf, long len, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_pdfload_buffer", "buf");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pdfload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pdfload_buffer");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pdfload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void pdfload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pdfload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pdfload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void radsave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_radsave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void radloadBuffer(MemorySegment buf, long len, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_radload_buffer", "buf");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_radload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_radload_buffer");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_radload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void radload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_radload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_radload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_radload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void radloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_radload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_radload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_radload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_matload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void matload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_matload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_matload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void ppmsave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_ppmsave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void ppmloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_ppmload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_ppmload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_ppmload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_ppmload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void ppmload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_ppmload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_ppmload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void pngsave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_pngsave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void pngloadBuffer(MemorySegment buf, long len, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_pngload_buffer", "buf");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pngload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pngload_buffer");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pngload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void pngload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pngload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pngload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_pngload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void pngloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_pngload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_pngload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_pngload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void magicksave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_magicksave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void magickloadBuffer(MemorySegment buf, long len, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_magickload_buffer", "buf");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_magickload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_magickload_buffer");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_magickload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void magickload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_magickload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_magickload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void matrixsave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_matrixsave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void matrixloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_matrixload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_matrixload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_matrixload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_matrixload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void matrixload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_matrixload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_matrixload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void csvsave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_csvsave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void csvloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_csvload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_csvload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_csvload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_csvload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void csvload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_csvload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_csvload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void rawsave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_rawsave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void rawload(String filenameString, VipsOutputPointer out, int width, int height,
      int bands, VipsOption... options) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_rawload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, width, height, bands, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rawload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_analyzeload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void analyzeload(String filenameString, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_analyzeload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_analyzeload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_fitssave(VipsImage *in, const char *filename, ...)
   * }
   */
  public void fitssave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_fitssave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void fitsload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_fitsload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_fitsload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_openexrload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void openexrload(String filenameString, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_openexrload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_openexrload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void tiffsave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_tiffsave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void tiffloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_tiffload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tiffload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tiffload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tiffload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void tiffloadBuffer(MemorySegment buf, long len, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_tiffload_buffer", "buf");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tiffload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tiffload_buffer");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tiffload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void tiffload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_tiffload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tiffload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void webpsave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_webpsave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void webploadBuffer(MemorySegment buf, long len, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_webpload_buffer", "buf");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_webpload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_webpload_buffer");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_webpload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void webpload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_webpload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_webpload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_webpload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void webploadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_webpload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_webpload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_webpload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void jpegsave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_jpegsave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void jpegloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_jpegload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jpegload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jpegload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jpegload_buffer(void *buf, size_t len, VipsImage **out, ...)
   * }
   */
  public void jpegloadBuffer(MemorySegment buf, long len, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_jpegload_buffer", "buf");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jpegload_buffer.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, len, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jpegload_buffer");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_jpegload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void jpegload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_jpegload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_jpegload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_openslideload_source(VipsSource *source, VipsImage **out, ...)
   * }
   */
  public void openslideloadSource(MemorySegment source, VipsOutputPointer out,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_openslideload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_openslideload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_openslideload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_openslideload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void openslideload(String filenameString, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_openslideload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_openslideload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
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
  public void vipssave(MemorySegment in, String filenameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_vipssave", "in");
    }
    var filename = arena.allocateFrom(filenameString);
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
  public void vipsloadSource(MemorySegment source, VipsOutputPointer out, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_vipsload_source", "source");
    }
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_vipsload_source.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(source, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_vipsload_source");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_vipsload(const char *filename, VipsImage **out, ...)
   * }
   */
  public void vipsload(String filenameString, VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_vipsload.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(filename, outPointer, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_vipsload");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_call_split_option_string(const char *operation_name, const char *option_string, va_list optional, ...)
   * }
   */
  public void callSplitOptionString(String operation_nameString, String option_stringString,
      MemorySegment optional, VipsOption... options) throws VipsError {
    var operation_name = arena.allocateFrom(operation_nameString);
    var option_string = arena.allocateFrom(option_stringString);
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
  public void callSplit(String operation_nameString, MemorySegment optional, VipsOption... options)
      throws VipsError {
    var operation_name = arena.allocateFrom(operation_nameString);
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
  public void call(String operation_nameString, VipsOption... options) throws VipsError {
    var operation_name = arena.allocateFrom(operation_nameString);
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
  public void imageHistoryPrintf(MemorySegment image, String formatString, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_history_printf", "image");
    }
    var format = arena.allocateFrom(formatString);
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
  public MemorySegment allocateInputArray(VipsOutputPointer out, VipsOption... options) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_allocate_input_array.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(outPointer, invokerArgs);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_allocate_input_array", "result");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_error_exit(const char *fmt, ...)
   * }
   */
  public void errorExit(String fmtString, VipsOption... options) throws VipsError {
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
  public void errorSystem(int err, String domainString, String fmtString, VipsOption... options)
      throws VipsError {
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
  public void error(String domainString, String fmtString, VipsOption... options) throws VipsError {
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
  public void system(String cmd_formatString, VipsOption... options) throws VipsError {
    var cmd_format = arena.allocateFrom(cmd_formatString);
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
  public void imageWriteToTarget(MemorySegment in, String suffixString, MemorySegment target,
      VipsOption... options) throws VipsError {
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
  public void imageWriteToBuffer(MemorySegment in, String suffixString, MemorySegment buf,
      MemorySegment size, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_buffer", "in");
    }
    var suffix = arena.allocateFrom(suffixString);
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
  public void imageWriteToFile(MemorySegment image, String nameString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_file", "image");
    }
    var name = arena.allocateFrom(nameString);
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
  public MemorySegment imageNewFromSource(MemorySegment source, String option_stringString,
      VipsOption... options) throws VipsError {
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
    VipsImage.reinterpret(result, arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_buffer(const void *buf, size_t len, const char *option_string, ...)
   * }
   */
  public MemorySegment imageNewFromBuffer(MemorySegment buf, long len, String option_stringString,
      VipsOption... options) throws VipsError {
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
    VipsImage.reinterpret(result, arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_from_file(const char *name, ...)
   * }
   */
  public MemorySegment imageNewFromFile(String nameString, VipsOption... options) throws VipsError {
    var name = arena.allocateFrom(nameString);
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
  public void targetWritef(MemorySegment target, String fmtString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_writef", "target");
    }
    var fmt = arena.allocateFrom(fmtString);
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
  public void valueSetSaveStringf(MemorySegment value, String fmtString, VipsOption... options)
      throws VipsError {
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
  public void rmdirf(String nameString, VipsOption... options) throws VipsError {
    var name = arena.allocateFrom(nameString);
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
  public void mkdirf(String nameString, VipsOption... options) throws VipsError {
    var name = arena.allocateFrom(nameString);
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
  public void isdirf(String nameString, VipsOption... options) throws VipsError {
    var name = arena.allocateFrom(nameString);
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
  public void existsf(String nameString, VipsOption... options) throws VipsError {
    var name = arena.allocateFrom(nameString);
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
  public void snprintf(MemorySegment str, long size, String formatString, VipsOption... options)
      throws VipsError {
    if(!VipsValidation.isValidPointer(str)) {
      VipsValidation.throwInvalidInputError("vips_snprintf", "str");
    }
    var format = arena.allocateFrom(formatString);
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
  public void dbufWritef(MemorySegment dbuf, String fmtString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(dbuf)) {
      VipsValidation.throwInvalidInputError("vips_dbuf_writef", "dbuf");
    }
    var fmt = arena.allocateFrom(fmtString);
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
  public void bufAppendf(MemorySegment buf, String fmtString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_appendf", "buf");
    }
    var fmt = arena.allocateFrom(fmtString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw.vips_buf_appendf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, fmt, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_buf_appendf");
    }
  }
}
