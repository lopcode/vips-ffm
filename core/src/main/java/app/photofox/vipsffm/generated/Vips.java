package app.photofox.vipsffm.generated;

import app.photofox.vipsffm.helper.VipsError;
import app.photofox.vipsffm.helper.VipsInvoker;
import app.photofox.vipsffm.helper.VipsOption;
import app.photofox.vipsffm.helper.VipsOutputPointer;
import app.photofox.vipsffm.helper.VipsValidation;
import java.lang.String;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.List;

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
   * GType vips_foreign_dz_depth_get_type()
   * }
   */
  public long foreignDzDepthGetType() throws VipsError {
    var result = VipsRaw.vips_foreign_dz_depth_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_dz_container_get_type()
   * }
   */
  public long foreignDzContainerGetType() throws VipsError {
    var result = VipsRaw.vips_foreign_dz_container_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_heif_compression_get_type()
   * }
   */
  public long foreignHeifCompressionGetType() throws VipsError {
    var result = VipsRaw.vips_foreign_heif_compression_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_heif_encoder_get_type()
   * }
   */
  public long foreignHeifEncoderGetType() throws VipsError {
    var result = VipsRaw.vips_foreign_heif_encoder_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_demand_style_get_type()
   * }
   */
  public long demandStyleGetType() throws VipsError {
    var result = VipsRaw.vips_demand_style_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_image_type_get_type()
   * }
   */
  public long imageTypeGetType() throws VipsError {
    var result = VipsRaw.vips_image_type_get_type();
    return result;
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
  public boolean colourspaceIssupported(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_colourspace_issupported", "image");
    }
    var result = VipsRaw.vips_colourspace_issupported(image);
    return result == 1;
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
  public boolean iccIsCompatibleProfile(MemorySegment image, MemorySegment data, long data_length)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_icc_is_compatible_profile", "image");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_icc_is_compatible_profile", "data");
    }
    var result = VipsRaw.vips_icc_is_compatible_profile(image, data, data_length);
    return result == 1;
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
   * char *vips_path_filename7(const char *path)
   * }
   */
  public String pathFilename7(String pathString) throws VipsError {
    var path = arena.allocateFrom(pathString);
    var result = VipsRaw_1.vips_path_filename7(path);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_path_filename7", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * char *vips_path_mode7(const char *path)
   * }
   */
  public String pathMode7(String pathString) throws VipsError {
    var path = arena.allocateFrom(pathString);
    var result = VipsRaw_1.vips_path_mode7(path);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_path_mode7", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_buf_rewind(VipsBuf *buf)
   * }
   */
  public void bufRewind(MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_rewind", "buf");
    }
    VipsRaw_1.vips_buf_rewind(buf);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_buf_destroy(VipsBuf *buf)
   * }
   */
  public void bufDestroy(MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_destroy", "buf");
    }
    VipsRaw_1.vips_buf_destroy(buf);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_buf_init(VipsBuf *buf)
   * }
   */
  public void bufInit(MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_init", "buf");
    }
    VipsRaw_1.vips_buf_init(buf);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_buf_set_static(VipsBuf *buf, char *base, int mx)
   * }
   */
  public void bufSetStatic(MemorySegment buf, String baseString, int mx) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_set_static", "buf");
    }
    var base = arena.allocateFrom(baseString);
    VipsRaw_1.vips_buf_set_static(buf, base, mx);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_buf_set_dynamic(VipsBuf *buf, int mx)
   * }
   */
  public void bufSetDynamic(MemorySegment buf, int mx) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_set_dynamic", "buf");
    }
    VipsRaw_1.vips_buf_set_dynamic(buf, mx);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_buf_init_static(VipsBuf *buf, char *base, int mx)
   * }
   */
  public void bufInitStatic(MemorySegment buf, String baseString, int mx) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_init_static", "buf");
    }
    var base = arena.allocateFrom(baseString);
    VipsRaw_1.vips_buf_init_static(buf, base, mx);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_buf_init_dynamic(VipsBuf *buf, int mx)
   * }
   */
  public void bufInitDynamic(MemorySegment buf, int mx) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_init_dynamic", "buf");
    }
    VipsRaw_1.vips_buf_init_dynamic(buf, mx);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_appendns(VipsBuf *buf, const char *str, int sz)
   * }
   */
  public boolean bufAppendns(MemorySegment buf, String strString, int sz) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_appendns", "buf");
    }
    var str = arena.allocateFrom(strString);
    var result = VipsRaw_1.vips_buf_appendns(buf, str, sz);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_appends(VipsBuf *buf, const char *str)
   * }
   */
  public boolean bufAppends(MemorySegment buf, String strString) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_appends", "buf");
    }
    var str = arena.allocateFrom(strString);
    var result = VipsRaw_1.vips_buf_appends(buf, str);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_vappendf(VipsBuf *buf, const char *fmt, va_list ap)
   * }
   */
  public boolean bufVappendf(MemorySegment buf, String fmtString, MemorySegment ap) throws
      VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_vappendf", "buf");
    }
    var fmt = arena.allocateFrom(fmtString);
    var result = VipsRaw_1.vips_buf_vappendf(buf, fmt, ap);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_appendc(VipsBuf *buf, char ch)
   * }
   */
  public boolean bufAppendc(MemorySegment buf, byte ch) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_appendc", "buf");
    }
    var result = VipsRaw_1.vips_buf_appendc(buf, ch);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_appendsc(VipsBuf *buf, gboolean quote, const char *str)
   * }
   */
  public boolean bufAppendsc(MemorySegment buf, boolean quoteBoolean, String strString) throws
      VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_appendsc", "buf");
    }
    var quote = quoteBoolean ? 1 : 0;
    var str = arena.allocateFrom(strString);
    var result = VipsRaw_1.vips_buf_appendsc(buf, quote, str);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_appendgv(VipsBuf *buf, GValue *value)
   * }
   */
  public boolean bufAppendgv(MemorySegment buf, MemorySegment value) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_appendgv", "buf");
    }
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_buf_appendgv", "value");
    }
    var result = VipsRaw_1.vips_buf_appendgv(buf, value);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_append_size(VipsBuf *buf, size_t n)
   * }
   */
  public boolean bufAppendSize(MemorySegment buf, long n) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_append_size", "buf");
    }
    var result = VipsRaw_1.vips_buf_append_size(buf, n);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_removec(VipsBuf *buf, char ch)
   * }
   */
  public boolean bufRemovec(MemorySegment buf, byte ch) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_removec", "buf");
    }
    var result = VipsRaw_1.vips_buf_removec(buf, ch);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_change(VipsBuf *buf, const char *o, const char *n)
   * }
   */
  public boolean bufChange(MemorySegment buf, String oString, String nString) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_change", "buf");
    }
    var o = arena.allocateFrom(oString);
    var n = arena.allocateFrom(nString);
    var result = VipsRaw_1.vips_buf_change(buf, o, n);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_is_empty(VipsBuf *buf)
   * }
   */
  public boolean bufIsEmpty(MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_is_empty", "buf");
    }
    var result = VipsRaw_1.vips_buf_is_empty(buf);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_is_full(VipsBuf *buf)
   * }
   */
  public boolean bufIsFull(MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_is_full", "buf");
    }
    var result = VipsRaw_1.vips_buf_is_full(buf);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_buf_all(VipsBuf *buf)
   * }
   */
  public String bufAll(MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_all", "buf");
    }
    var result = VipsRaw_1.vips_buf_all(buf);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_buf_all", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_buf_firstline(VipsBuf *buf)
   * }
   */
  public String bufFirstline(MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_firstline", "buf");
    }
    var result = VipsRaw_1.vips_buf_firstline(buf);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_buf_firstline", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_appendg(VipsBuf *buf, double g)
   * }
   */
  public boolean bufAppendg(MemorySegment buf, double g) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_appendg", "buf");
    }
    var result = VipsRaw_1.vips_buf_appendg(buf, g);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_appendd(VipsBuf *buf, int d)
   * }
   */
  public boolean bufAppendd(MemorySegment buf, int d) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_appendd", "buf");
    }
    var result = VipsRaw_1.vips_buf_appendd(buf, d);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_buf_len(VipsBuf *buf)
   * }
   */
  public void bufLen(MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_len", "buf");
    }
    var result = VipsRaw_1.vips_buf_len(buf);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_buf_len");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_enum_string(GType enm, int value)
   * }
   */
  public String enumString(long enm, int value) throws VipsError {
    var result = VipsRaw_1.vips_enum_string(enm, value);
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
  public String enumNick(long enm, int value) throws VipsError {
    var result = VipsRaw_1.vips_enum_nick(enm, value);
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
  public void enumFromNick(String domainString, long type, String strString) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    var str = arena.allocateFrom(strString);
    var result = VipsRaw_1.vips_enum_from_nick(domain, type, str);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_enum_from_nick");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_flags_from_nick(const char *domain, GType type, const char *nick)
   * }
   */
  public void flagsFromNick(String domainString, long type, String nickString) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    var nick = arena.allocateFrom(nickString);
    var result = VipsRaw_1.vips_flags_from_nick(domain, type, nick);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_flags_from_nick");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_slist_equal(GSList *l1, GSList *l2)
   * }
   */
  public boolean slistEqual(MemorySegment l1, MemorySegment l2) throws VipsError {
    if(!VipsValidation.isValidPointer(l1)) {
      VipsValidation.throwInvalidInputError("vips_slist_equal", "l1");
    }
    if(!VipsValidation.isValidPointer(l2)) {
      VipsValidation.throwInvalidInputError("vips_slist_equal", "l2");
    }
    var result = VipsRaw_1.vips_slist_equal(l1, l2);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_slist_free_all(GSList *list)
   * }
   */
  public void slistFreeAll(MemorySegment list) throws VipsError {
    if(!VipsValidation.isValidPointer(list)) {
      VipsValidation.throwInvalidInputError("vips_slist_free_all", "list");
    }
    VipsRaw_1.vips_slist_free_all(list);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_map_equal(void *a, void *b)
   * }
   */
  public MemorySegment mapEqual(MemorySegment a, MemorySegment b) throws VipsError {
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_map_equal", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_map_equal", "b");
    }
    var result = VipsRaw_1.vips_map_equal(a, b);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_map_equal", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * char *vips_strncpy(char *dest, const char *src, int n)
   * }
   */
  public String strncpy(String destString, String srcString, int n) throws VipsError {
    var dest = arena.allocateFrom(destString);
    var src = arena.allocateFrom(srcString);
    var result = VipsRaw_1.vips_strncpy(dest, src, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_strncpy", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * char *vips_strrstr(const char *haystack, const char *needle)
   * }
   */
  public String strrstr(String haystackString, String needleString) throws VipsError {
    var haystack = arena.allocateFrom(haystackString);
    var needle = arena.allocateFrom(needleString);
    var result = VipsRaw_1.vips_strrstr(haystack, needle);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_strrstr", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_ispostfix(const char *a, const char *b)
   * }
   */
  public boolean ispostfix(String aString, String bString) throws VipsError {
    var a = arena.allocateFrom(aString);
    var b = arena.allocateFrom(bString);
    var result = VipsRaw_1.vips_ispostfix(a, b);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_iscasepostfix(const char *a, const char *b)
   * }
   */
  public boolean iscasepostfix(String aString, String bString) throws VipsError {
    var a = arena.allocateFrom(aString);
    var b = arena.allocateFrom(bString);
    var result = VipsRaw_1.vips_iscasepostfix(a, b);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_isprefix(const char *a, const char *b)
   * }
   */
  public boolean isprefix(String aString, String bString) throws VipsError {
    var a = arena.allocateFrom(aString);
    var b = arena.allocateFrom(bString);
    var result = VipsRaw_1.vips_isprefix(a, b);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * char *vips_break_token(char *str, const char *brk)
   * }
   */
  public String breakToken(String strString, String brkString) throws VipsError {
    var str = arena.allocateFrom(strString);
    var brk = arena.allocateFrom(brkString);
    var result = VipsRaw_1.vips_break_token(str, brk);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_break_token", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_vsnprintf(char *str, size_t size, const char *format, va_list ap)
   * }
   */
  public void vsnprintf(String strString, long size, String formatString, MemorySegment ap) throws
      VipsError {
    var str = arena.allocateFrom(strString);
    var format = arena.allocateFrom(formatString);
    var result = VipsRaw_1.vips_vsnprintf(str, size, format, ap);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_vsnprintf");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_filename_suffix_match(const char *path, const char *suffixes[])
   * }
   */
  public void filenameSuffixMatch(String pathString, List<String> suffixesStringArray) throws
      VipsError {
    var path = arena.allocateFrom(pathString);
    var suffixes = VipsInvoker.makeCharStarArray(arena, suffixesStringArray);
    var result = VipsRaw_1.vips_filename_suffix_match(path, suffixes);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_filename_suffix_match");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gint64 vips_file_length(int fd)
   * }
   */
  public long fileLength(int fd) throws VipsError {
    var result = VipsRaw_1.vips_file_length(fd);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_rename(const char *old_name, const char *new_name)
   * }
   */
  public void rename(String old_nameString, String new_nameString) throws VipsError {
    var old_name = arena.allocateFrom(old_nameString);
    var new_name = arena.allocateFrom(new_nameString);
    var result = VipsRaw_1.vips_rename(old_name, new_name);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_rename");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_ispoweroftwo(int p)
   * }
   */
  public void ispoweroftwo(int p) throws VipsError {
    var result = VipsRaw_1.vips_ispoweroftwo(p);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_ispoweroftwo");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_amiMSBfirst()
   * }
   */
  public void amiMSBfirst() throws VipsError {
    var result = VipsRaw_1.vips_amiMSBfirst();
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_amiMSBfirst");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * char *vips_realpath(const char *path)
   * }
   */
  public String realpath(String pathString) throws VipsError {
    var path = arena.allocateFrom(pathString);
    var result = VipsRaw_1.vips_realpath(path);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_realpath", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_strtod(const char *str, double *out)
   * }
   */
  public void strtod(String strString, VipsOutputPointer out) throws VipsError {
    var str = arena.allocateFrom(strString);
    var outPointer = out.pointerOrNull$internal();
    var result = VipsRaw_1.vips_strtod(str, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_strtod");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_argument_get_id()
   * }
   */
  public void argumentGetId() throws VipsError {
    var result = VipsRaw_1.vips_argument_get_id();
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_argument_get_id");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_get_args(VipsObject *object, const char ***names, int **flags, int *n_args)
   * }
   */
  public void objectGetArgs(MemorySegment object, MemorySegment names, MemorySegment flags,
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
    var result = VipsRaw_1.vips_object_get_args(object, names, flags, n_args);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_object_get_args");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_argument_class_needsstring(VipsArgumentClass *argument_class)
   * }
   */
  public boolean argumentClassNeedsstring(MemorySegment argument_class) throws VipsError {
    if(!VipsValidation.isValidPointer(argument_class)) {
      VipsValidation.throwInvalidInputError("vips_argument_class_needsstring", "argument_class");
    }
    var result = VipsRaw_1.vips_argument_class_needsstring(argument_class);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_get_argument(VipsObject *object, const char *name, GParamSpec **pspec, VipsArgumentClass **argument_class, VipsArgumentInstance **argument_instance)
   * }
   */
  public void objectGetArgument(MemorySegment object, String nameString, MemorySegment pspec,
      MemorySegment argument_class, MemorySegment argument_instance) throws VipsError {
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
    var result = VipsRaw_1.vips_object_get_argument(object, name, pspec, argument_class, argument_instance);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_object_get_argument");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_object_argument_isset(VipsObject *object, const char *name)
   * }
   */
  public boolean objectArgumentIsset(MemorySegment object, String nameString) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_argument_isset", "object");
    }
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw_1.vips_object_argument_isset(object, name);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArgumentFlags vips_object_get_argument_flags(VipsObject *object, const char *name)
   * }
   */
  public void objectGetArgumentFlags(MemorySegment object, String nameString) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_get_argument_flags", "object");
    }
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw_1.vips_object_get_argument_flags(object, name);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_object_get_argument_flags");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_get_argument_priority(VipsObject *object, const char *name)
   * }
   */
  public void objectGetArgumentPriority(MemorySegment object, String nameString) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_get_argument_priority", "object");
    }
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw_1.vips_object_get_argument_priority(object, name);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_object_get_argument_priority");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_value_is_null(GParamSpec *psoec, const GValue *value)
   * }
   */
  public boolean valueIsNull(MemorySegment psoec, MemorySegment value) throws VipsError {
    if(!VipsValidation.isValidPointer(psoec)) {
      VipsValidation.throwInvalidInputError("vips_value_is_null", "psoec");
    }
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_is_null", "value");
    }
    var result = VipsRaw_1.vips_value_is_null(psoec, value);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_set_property(GObject *gobject, guint property_id, const GValue *value, GParamSpec *pspec)
   * }
   */
  public void objectSetProperty(MemorySegment gobject, int property_id, MemorySegment value,
      MemorySegment pspec) throws VipsError {
    if(!VipsValidation.isValidPointer(gobject)) {
      VipsValidation.throwInvalidInputError("vips_object_set_property", "gobject");
    }
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_object_set_property", "value");
    }
    if(!VipsValidation.isValidPointer(pspec)) {
      VipsValidation.throwInvalidInputError("vips_object_set_property", "pspec");
    }
    VipsRaw_1.vips_object_set_property(gobject, property_id, value, pspec);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_get_property(GObject *gobject, guint property_id, GValue *value, GParamSpec *pspec)
   * }
   */
  public void objectGetProperty(MemorySegment gobject, int property_id, MemorySegment value,
      MemorySegment pspec) throws VipsError {
    if(!VipsValidation.isValidPointer(gobject)) {
      VipsValidation.throwInvalidInputError("vips_object_get_property", "gobject");
    }
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_object_get_property", "value");
    }
    if(!VipsValidation.isValidPointer(pspec)) {
      VipsValidation.throwInvalidInputError("vips_object_get_property", "pspec");
    }
    VipsRaw_1.vips_object_get_property(gobject, property_id, value, pspec);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_preclose(VipsObject *object)
   * }
   */
  public void objectPreclose(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_preclose", "object");
    }
    VipsRaw_1.vips_object_preclose(object);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_build(VipsObject *object)
   * }
   */
  public void objectBuild(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_build", "object");
    }
    var result = VipsRaw_1.vips_object_build(object);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_object_build");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_summary_class(VipsObjectClass *klass, VipsBuf *buf)
   * }
   */
  public void objectSummaryClass(MemorySegment klass, MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(klass)) {
      VipsValidation.throwInvalidInputError("vips_object_summary_class", "klass");
    }
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_object_summary_class", "buf");
    }
    VipsRaw_1.vips_object_summary_class(klass, buf);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_summary(VipsObject *object, VipsBuf *buf)
   * }
   */
  public void objectSummary(MemorySegment object, MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_summary", "object");
    }
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_object_summary", "buf");
    }
    VipsRaw_1.vips_object_summary(object, buf);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_dump(VipsObject *object, VipsBuf *buf)
   * }
   */
  public void objectDump(MemorySegment object, MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_dump", "object");
    }
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_object_dump", "buf");
    }
    VipsRaw_1.vips_object_dump(object, buf);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_print_summary_class(VipsObjectClass *klass)
   * }
   */
  public void objectPrintSummaryClass(MemorySegment klass) throws VipsError {
    if(!VipsValidation.isValidPointer(klass)) {
      VipsValidation.throwInvalidInputError("vips_object_print_summary_class", "klass");
    }
    VipsRaw_1.vips_object_print_summary_class(klass);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_print_summary(VipsObject *object)
   * }
   */
  public void objectPrintSummary(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_print_summary", "object");
    }
    VipsRaw_1.vips_object_print_summary(object);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_print_dump(VipsObject *object)
   * }
   */
  public void objectPrintDump(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_print_dump", "object");
    }
    VipsRaw_1.vips_object_print_dump(object);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_print_name(VipsObject *object)
   * }
   */
  public void objectPrintName(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_print_name", "object");
    }
    VipsRaw_1.vips_object_print_name(object);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_object_sanity(VipsObject *object)
   * }
   */
  public boolean objectSanity(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_sanity", "object");
    }
    var result = VipsRaw_1.vips_object_sanity(object);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_object_get_type()
   * }
   */
  public long objectGetType() throws VipsError {
    var result = VipsRaw_1.vips_object_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_class_install_argument(VipsObjectClass *cls, GParamSpec *pspec, VipsArgumentFlags flags, int priority, guint offset)
   * }
   */
  public void objectClassInstallArgument(MemorySegment cls, MemorySegment pspec, int flags,
      int priority, int offset) throws VipsError {
    if(!VipsValidation.isValidPointer(cls)) {
      VipsValidation.throwInvalidInputError("vips_object_class_install_argument", "cls");
    }
    if(!VipsValidation.isValidPointer(pspec)) {
      VipsValidation.throwInvalidInputError("vips_object_class_install_argument", "pspec");
    }
    VipsRaw_1.vips_object_class_install_argument(cls, pspec, flags, priority, offset);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_set_argument_from_string(VipsObject *object, const char *name, const char *value)
   * }
   */
  public void objectSetArgumentFromString(MemorySegment object, String nameString,
      String valueString) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_set_argument_from_string", "object");
    }
    var name = arena.allocateFrom(nameString);
    var value = arena.allocateFrom(valueString);
    var result = VipsRaw_1.vips_object_set_argument_from_string(object, name, value);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_object_set_argument_from_string");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_object_argument_needsstring(VipsObject *object, const char *name)
   * }
   */
  public boolean objectArgumentNeedsstring(MemorySegment object, String nameString) throws
      VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_argument_needsstring", "object");
    }
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw_1.vips_object_argument_needsstring(object, name);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_get_argument_to_string(VipsObject *object, const char *name, const char *arg)
   * }
   */
  public void objectGetArgumentToString(MemorySegment object, String nameString, String argString)
      throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_get_argument_to_string", "object");
    }
    var name = arena.allocateFrom(nameString);
    var arg = arena.allocateFrom(argString);
    var result = VipsRaw_1.vips_object_get_argument_to_string(object, name, arg);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_object_get_argument_to_string");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_set_required(VipsObject *object, const char *value)
   * }
   */
  public void objectSetRequired(MemorySegment object, String valueString) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_set_required", "object");
    }
    var value = arena.allocateFrom(valueString);
    var result = VipsRaw_1.vips_object_set_required(object, value);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_object_set_required");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsObject *vips_object_new(GType type, VipsObjectSetArguments set, void *a, void *b)
   * }
   */
  public MemorySegment objectNew(long type, MemorySegment set, MemorySegment a, MemorySegment b)
      throws VipsError {
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_object_new", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_object_new", "b");
    }
    var result = VipsRaw_1.vips_object_new(type, set, a, b);
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
  public void objectSetValist(MemorySegment object, MemorySegment ap) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_set_valist", "object");
    }
    var result = VipsRaw_1.vips_object_set_valist(object, ap);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_object_set_valist");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_object_set_from_string(VipsObject *object, const char *string)
   * }
   */
  public void objectSetFromString(MemorySegment object, String stringString) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_set_from_string", "object");
    }
    var string = arena.allocateFrom(stringString);
    var result = VipsRaw_1.vips_object_set_from_string(object, string);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_object_set_from_string");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsObject *vips_object_new_from_string(VipsObjectClass *object_class, const char *p)
   * }
   */
  public MemorySegment objectNewFromString(MemorySegment object_class, String pString) throws
      VipsError {
    if(!VipsValidation.isValidPointer(object_class)) {
      VipsValidation.throwInvalidInputError("vips_object_new_from_string", "object_class");
    }
    var p = arena.allocateFrom(pString);
    var result = VipsRaw_1.vips_object_new_from_string(object_class, p);
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
  public void objectToString(MemorySegment object, MemorySegment buf) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_to_string", "object");
    }
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_object_to_string", "buf");
    }
    VipsRaw_1.vips_object_to_string(object, buf);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_type_depth(GType type)
   * }
   */
  public void typeDepth(long type) throws VipsError {
    var result = VipsRaw_1.vips_type_depth(type);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_type_depth");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_type_find(const char *basename, const char *nickname)
   * }
   */
  public long typeFind(String basenameString, String nicknameString) throws VipsError {
    var basename = arena.allocateFrom(basenameString);
    var nickname = arena.allocateFrom(nicknameString);
    var result = VipsRaw_1.vips_type_find(basename, nickname);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_nickname_find(GType type)
   * }
   */
  public String nicknameFind(long type) throws VipsError {
    var result = VipsRaw_1.vips_nickname_find(type);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_nickname_find", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const VipsObjectClass *vips_class_find(const char *basename, const char *nickname)
   * }
   */
  public MemorySegment classFind(String basenameString, String nicknameString) throws VipsError {
    var basename = arena.allocateFrom(basenameString);
    var nickname = arena.allocateFrom(nicknameString);
    var result = VipsRaw_1.vips_class_find(basename, nickname);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_class_find", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsObject **vips_object_local_array(VipsObject *parent, int n)
   * }
   */
  public MemorySegment objectLocalArray(MemorySegment parent, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(parent)) {
      VipsValidation.throwInvalidInputError("vips_object_local_array", "parent");
    }
    var result = VipsRaw_1.vips_object_local_array(parent, n);
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
  public void objectLocalCb(MemorySegment vobject, MemorySegment gobject) throws VipsError {
    if(!VipsValidation.isValidPointer(vobject)) {
      VipsValidation.throwInvalidInputError("vips_object_local_cb", "vobject");
    }
    if(!VipsValidation.isValidPointer(gobject)) {
      VipsValidation.throwInvalidInputError("vips_object_local_cb", "gobject");
    }
    VipsRaw_1.vips_object_local_cb(vobject, gobject);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_set_static(VipsObject *object, gboolean static_object)
   * }
   */
  public void objectSetStatic(MemorySegment object, boolean static_objectBoolean) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_set_static", "object");
    }
    var static_object = static_objectBoolean ? 1 : 0;
    VipsRaw_1.vips_object_set_static(object, static_object);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_print_all()
   * }
   */
  public void objectPrintAll() throws VipsError {
    VipsRaw_1.vips_object_print_all();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_sanity_all()
   * }
   */
  public void objectSanityAll() throws VipsError {
    VipsRaw_1.vips_object_sanity_all();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_rewind(VipsObject *object)
   * }
   */
  public void objectRewind(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_rewind", "object");
    }
    VipsRaw_1.vips_object_rewind(object);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_object_unref_outputs(VipsObject *object)
   * }
   */
  public void objectUnrefOutputs(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_unref_outputs", "object");
    }
    VipsRaw_1.vips_object_unref_outputs(object);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_object_get_description(VipsObject *object)
   * }
   */
  public String objectGetDescription(MemorySegment object) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_get_description", "object");
    }
    var result = VipsRaw_1.vips_object_get_description(object);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_object_get_description", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_thing_get_type()
   * }
   */
  public long thingGetType() throws VipsError {
    var result = VipsRaw_1.vips_thing_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsThing *vips_thing_new(int i)
   * }
   */
  public MemorySegment thingNew(int i) throws VipsError {
    var result = VipsRaw_1.vips_thing_new(i);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_thing_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArea *vips_area_copy(VipsArea *area)
   * }
   */
  public MemorySegment areaCopy(MemorySegment area) throws VipsError {
    if(!VipsValidation.isValidPointer(area)) {
      VipsValidation.throwInvalidInputError("vips_area_copy", "area");
    }
    var result = VipsRaw_1.vips_area_copy(area);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_area_copy", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_area_free_cb(void *mem, VipsArea *area)
   * }
   */
  public void areaFreeCb(MemorySegment mem, MemorySegment area) throws VipsError {
    if(!VipsValidation.isValidPointer(mem)) {
      VipsValidation.throwInvalidInputError("vips_area_free_cb", "mem");
    }
    if(!VipsValidation.isValidPointer(area)) {
      VipsValidation.throwInvalidInputError("vips_area_free_cb", "area");
    }
    var result = VipsRaw_1.vips_area_free_cb(mem, area);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_area_free_cb");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_area_unref(VipsArea *area)
   * }
   */
  public void areaUnref(MemorySegment area) throws VipsError {
    if(!VipsValidation.isValidPointer(area)) {
      VipsValidation.throwInvalidInputError("vips_area_unref", "area");
    }
    VipsRaw_1.vips_area_unref(area);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArea *vips_area_new(VipsCallbackFn free_fn, void *data)
   * }
   */
  public MemorySegment areaNew(MemorySegment free_fn, MemorySegment data) throws VipsError {
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_area_new", "data");
    }
    var result = VipsRaw_1.vips_area_new(free_fn, data);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_area_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArea *vips_area_new_array(GType type, size_t sizeof_type, int n)
   * }
   */
  public MemorySegment areaNewArray(long type, long sizeof_type, int n) throws VipsError {
    var result = VipsRaw_1.vips_area_new_array(type, sizeof_type, n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_area_new_array", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArea *vips_area_new_array_object(int n)
   * }
   */
  public MemorySegment areaNewArrayObject(int n) throws VipsError {
    var result = VipsRaw_1.vips_area_new_array_object(n);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_area_new_array_object", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_area_get_data(VipsArea *area, size_t *length, int *n, GType *type, size_t *sizeof_type)
   * }
   */
  public MemorySegment areaGetData(MemorySegment area, MemorySegment length, MemorySegment n,
      MemorySegment type, MemorySegment sizeof_type) throws VipsError {
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
    var result = VipsRaw_1.vips_area_get_data(area, length, n, type, sizeof_type);
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
  public long areaGetType() throws VipsError {
    var result = VipsRaw_1.vips_area_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_save_string_get_type()
   * }
   */
  public long saveStringGetType() throws VipsError {
    var result = VipsRaw_1.vips_save_string_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsRefString *vips_ref_string_new(const char *str)
   * }
   */
  public MemorySegment refStringNew(String strString) throws VipsError {
    var str = arena.allocateFrom(strString);
    var result = VipsRaw_1.vips_ref_string_new(str);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_ref_string_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_ref_string_get(VipsRefString *refstr, size_t *length)
   * }
   */
  public String refStringGet(MemorySegment refstr, MemorySegment length) throws VipsError {
    if(!VipsValidation.isValidPointer(refstr)) {
      VipsValidation.throwInvalidInputError("vips_ref_string_get", "refstr");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_ref_string_get", "length");
    }
    var result = VipsRaw_1.vips_ref_string_get(refstr, length);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_ref_string_get", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_ref_string_get_type()
   * }
   */
  public long refStringGetType() throws VipsError {
    var result = VipsRaw_1.vips_ref_string_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsBlob *vips_blob_new(VipsCallbackFn free_fn, const void *data, size_t length)
   * }
   */
  public MemorySegment blobNew(MemorySegment free_fn, MemorySegment data, long length) throws
      VipsError {
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_blob_new", "data");
    }
    var result = VipsRaw_1.vips_blob_new(free_fn, data, length);
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
  public MemorySegment blobCopy(MemorySegment data, long length) throws VipsError {
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_blob_copy", "data");
    }
    var result = VipsRaw_1.vips_blob_copy(data, length);
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
  public MemorySegment blobGet(MemorySegment blob, MemorySegment length) throws VipsError {
    if(!VipsValidation.isValidPointer(blob)) {
      VipsValidation.throwInvalidInputError("vips_blob_get", "blob");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_blob_get", "length");
    }
    var result = VipsRaw_1.vips_blob_get(blob, length);
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
  public void blobSet(MemorySegment blob, MemorySegment free_fn, MemorySegment data, long length)
      throws VipsError {
    if(!VipsValidation.isValidPointer(blob)) {
      VipsValidation.throwInvalidInputError("vips_blob_set", "blob");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_blob_set", "data");
    }
    VipsRaw_1.vips_blob_set(blob, free_fn, data, length);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_blob_get_type()
   * }
   */
  public long blobGetType() throws VipsError {
    var result = VipsRaw_1.vips_blob_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArrayDouble *vips_array_double_new(const double *array, int n)
   * }
   */
  public MemorySegment arrayDoubleNew(MemorySegment array, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_double_new", "array");
    }
    var result = VipsRaw_1.vips_array_double_new(array, n);
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
  public MemorySegment arrayDoubleGet(MemorySegment array, MemorySegment n) throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_double_get", "array");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_array_double_get", "n");
    }
    var result = VipsRaw_1.vips_array_double_get(array, n);
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
  public long arrayDoubleGetType() throws VipsError {
    var result = VipsRaw_1.vips_array_double_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArrayInt *vips_array_int_new(const int *array, int n)
   * }
   */
  public MemorySegment arrayIntNew(MemorySegment array, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_int_new", "array");
    }
    var result = VipsRaw_1.vips_array_int_new(array, n);
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
  public MemorySegment arrayIntGet(MemorySegment array, MemorySegment n) throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_int_get", "array");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_array_int_get", "n");
    }
    var result = VipsRaw_1.vips_array_int_get(array, n);
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
  public long arrayIntGetType() throws VipsError {
    var result = VipsRaw_1.vips_array_int_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_array_image_get_type()
   * }
   */
  public long arrayImageGetType() throws VipsError {
    var result = VipsRaw_1.vips_array_image_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_area(GValue *value, VipsCallbackFn free_fn, void *data)
   * }
   */
  public void valueSetArea(MemorySegment value, MemorySegment free_fn, MemorySegment data) throws
      VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_area", "value");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_value_set_area", "data");
    }
    VipsRaw_1.vips_value_set_area(value, free_fn, data);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_value_get_area(const GValue *value, size_t *length)
   * }
   */
  public MemorySegment valueGetArea(MemorySegment value, MemorySegment length) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_area", "value");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_value_get_area", "length");
    }
    var result = VipsRaw_1.vips_value_get_area(value, length);
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
  public String valueGetSaveString(MemorySegment value) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_save_string", "value");
    }
    var result = VipsRaw_1.vips_value_get_save_string(value);
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
  public void valueSetSaveString(MemorySegment value, String strString) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_save_string", "value");
    }
    var str = arena.allocateFrom(strString);
    VipsRaw_1.vips_value_set_save_string(value, str);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_value_get_ref_string(const GValue *value, size_t *length)
   * }
   */
  public String valueGetRefString(MemorySegment value, MemorySegment length) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_ref_string", "value");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_value_get_ref_string", "length");
    }
    var result = VipsRaw_1.vips_value_get_ref_string(value, length);
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
  public void valueSetRefString(MemorySegment value, String strString) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_ref_string", "value");
    }
    var str = arena.allocateFrom(strString);
    VipsRaw_1.vips_value_set_ref_string(value, str);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_value_get_blob(const GValue *value, size_t *length)
   * }
   */
  public MemorySegment valueGetBlob(MemorySegment value, MemorySegment length) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_blob", "value");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_value_get_blob", "length");
    }
    var result = VipsRaw_1.vips_value_get_blob(value, length);
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
  public void valueSetBlob(MemorySegment value, MemorySegment free_fn, MemorySegment data,
      long length) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_blob", "value");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_value_set_blob", "data");
    }
    VipsRaw_1.vips_value_set_blob(value, free_fn, data, length);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_blob_free(GValue *value, void *data, size_t length)
   * }
   */
  public void valueSetBlobFree(MemorySegment value, MemorySegment data, long length) throws
      VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_blob_free", "value");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_value_set_blob_free", "data");
    }
    VipsRaw_1.vips_value_set_blob_free(value, data, length);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_value_set_array(GValue *value, int n, GType type, size_t sizeof_type)
   * }
   */
  public void valueSetArray(MemorySegment value, int n, long type, long sizeof_type) throws
      VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array", "value");
    }
    VipsRaw_1.vips_value_set_array(value, n, type, sizeof_type);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_value_get_array(const GValue *value, int *n, GType *type, size_t *sizeof_type)
   * }
   */
  public MemorySegment valueGetArray(MemorySegment value, MemorySegment n, MemorySegment type,
      MemorySegment sizeof_type) throws VipsError {
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
    var result = VipsRaw_1.vips_value_get_array(value, n, type, sizeof_type);
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
  public MemorySegment valueGetArrayDouble(MemorySegment value, MemorySegment n) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_double", "value");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_double", "n");
    }
    var result = VipsRaw_1.vips_value_get_array_double(value, n);
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
  public void valueSetArrayDouble(MemorySegment value, MemorySegment array, int n) throws
      VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array_double", "value");
    }
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array_double", "array");
    }
    VipsRaw_1.vips_value_set_array_double(value, array, n);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int *vips_value_get_array_int(const GValue *value, int *n)
   * }
   */
  public MemorySegment valueGetArrayInt(MemorySegment value, MemorySegment n) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_int", "value");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_int", "n");
    }
    var result = VipsRaw_1.vips_value_get_array_int(value, n);
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
  public void valueSetArrayInt(MemorySegment value, MemorySegment array, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array_int", "value");
    }
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array_int", "array");
    }
    VipsRaw_1.vips_value_set_array_int(value, array, n);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GObject **vips_value_get_array_object(const GValue *value, int *n)
   * }
   */
  public MemorySegment valueGetArrayObject(MemorySegment value, MemorySegment n) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_object", "value");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_object", "n");
    }
    var result = VipsRaw_1.vips_value_get_array_object(value, n);
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
  public void valueSetArrayObject(MemorySegment value, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array_object", "value");
    }
    VipsRaw_1.vips_value_set_array_object(value, n);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_profile_set(gboolean profile)
   * }
   */
  public void profileSet(boolean profileBoolean) throws VipsError {
    var profile = profileBoolean ? 1 : 0;
    VipsRaw_1.vips_profile_set(profile);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_connection_get_type()
   * }
   */
  public long connectionGetType() throws VipsError {
    var result = VipsRaw_1.vips_connection_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_connection_filename(VipsConnection *connection)
   * }
   */
  public String connectionFilename(MemorySegment connection) throws VipsError {
    if(!VipsValidation.isValidPointer(connection)) {
      VipsValidation.throwInvalidInputError("vips_connection_filename", "connection");
    }
    var result = VipsRaw_1.vips_connection_filename(connection);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_connection_filename", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_connection_nick(VipsConnection *connection)
   * }
   */
  public String connectionNick(MemorySegment connection) throws VipsError {
    if(!VipsValidation.isValidPointer(connection)) {
      VipsValidation.throwInvalidInputError("vips_connection_nick", "connection");
    }
    var result = VipsRaw_1.vips_connection_nick(connection);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_connection_nick", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_pipe_read_limit_set(gint64 limit)
   * }
   */
  public void pipeReadLimitSet(long limit) throws VipsError {
    VipsRaw_1.vips_pipe_read_limit_set(limit);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_source_get_type()
   * }
   */
  public long sourceGetType() throws VipsError {
    var result = VipsRaw_1.vips_source_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsSource *vips_source_new_from_descriptor(int descriptor)
   * }
   */
  public MemorySegment sourceNewFromDescriptor(int descriptor) throws VipsError {
    var result = VipsRaw_1.vips_source_new_from_descriptor(descriptor);
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
  public MemorySegment sourceNewFromFile(String filenameString) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw_1.vips_source_new_from_file(filename);
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
  public MemorySegment sourceNewFromBlob(MemorySegment blob) throws VipsError {
    if(!VipsValidation.isValidPointer(blob)) {
      VipsValidation.throwInvalidInputError("vips_source_new_from_blob", "blob");
    }
    var result = VipsRaw_1.vips_source_new_from_blob(blob);
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
  public MemorySegment sourceNewFromTarget(MemorySegment target) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_source_new_from_target", "target");
    }
    var result = VipsRaw_1.vips_source_new_from_target(target);
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
  public MemorySegment sourceNewFromMemory(MemorySegment data, long size) throws VipsError {
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_source_new_from_memory", "data");
    }
    var result = VipsRaw_1.vips_source_new_from_memory(data, size);
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
  public MemorySegment sourceNewFromOptions(String optionsString) throws VipsError {
    var options = arena.allocateFrom(optionsString);
    var result = VipsRaw_1.vips_source_new_from_options(options);
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
  public void sourceMinimise(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_minimise", "source");
    }
    VipsRaw_1.vips_source_minimise(source);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_source_unminimise(VipsSource *source)
   * }
   */
  public void sourceUnminimise(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_unminimise", "source");
    }
    var result = VipsRaw_1.vips_source_unminimise(source);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_source_unminimise");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_source_decode(VipsSource *source)
   * }
   */
  public void sourceDecode(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_decode", "source");
    }
    var result = VipsRaw_1.vips_source_decode(source);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_source_decode");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gint64 vips_source_read(VipsSource *source, void *data, size_t length)
   * }
   */
  public long sourceRead(MemorySegment source, MemorySegment data, long length) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_read", "source");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_source_read", "data");
    }
    var result = VipsRaw_1.vips_source_read(source, data, length);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_source_is_mappable(VipsSource *source)
   * }
   */
  public boolean sourceIsMappable(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_is_mappable", "source");
    }
    var result = VipsRaw_1.vips_source_is_mappable(source);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_source_is_file(VipsSource *source)
   * }
   */
  public boolean sourceIsFile(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_is_file", "source");
    }
    var result = VipsRaw_1.vips_source_is_file(source);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const void *vips_source_map(VipsSource *source, size_t *length)
   * }
   */
  public MemorySegment sourceMap(MemorySegment source, MemorySegment length) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_map", "source");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_source_map", "length");
    }
    var result = VipsRaw_1.vips_source_map(source, length);
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
  public MemorySegment sourceMapBlob(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_map_blob", "source");
    }
    var result = VipsRaw_1.vips_source_map_blob(source);
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
  public long sourceSeek(MemorySegment source, long offset, int whence) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_seek", "source");
    }
    var result = VipsRaw_1.vips_source_seek(source, offset, whence);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_source_rewind(VipsSource *source)
   * }
   */
  public void sourceRewind(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_rewind", "source");
    }
    var result = VipsRaw_1.vips_source_rewind(source);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_source_rewind");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gint64 vips_source_sniff_at_most(VipsSource *source, unsigned char **data, size_t length)
   * }
   */
  public long sourceSniffAtMost(MemorySegment source, MemorySegment data, long length) throws
      VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_sniff_at_most", "source");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_source_sniff_at_most", "data");
    }
    var result = VipsRaw_1.vips_source_sniff_at_most(source, data, length);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * unsigned char *vips_source_sniff(VipsSource *source, size_t length)
   * }
   */
  public MemorySegment sourceSniff(MemorySegment source, long length) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_sniff", "source");
    }
    var result = VipsRaw_1.vips_source_sniff(source, length);
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
  public long sourceLength(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_source_length", "source");
    }
    var result = VipsRaw_1.vips_source_length(source);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_source_custom_get_type()
   * }
   */
  public long sourceCustomGetType() throws VipsError {
    var result = VipsRaw_1.vips_source_custom_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsSourceCustom *vips_source_custom_new()
   * }
   */
  public MemorySegment sourceCustomNew() throws VipsError {
    var result = VipsRaw_1.vips_source_custom_new();
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
  public MemorySegment sourceGInputStreamNew(MemorySegment stream) throws VipsError {
    if(!VipsValidation.isValidPointer(stream)) {
      VipsValidation.throwInvalidInputError("vips_source_g_input_stream_new", "stream");
    }
    var result = VipsRaw_1.vips_source_g_input_stream_new(stream);
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
  public long targetGetType() throws VipsError {
    var result = VipsRaw_1.vips_target_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsTarget *vips_target_new_to_descriptor(int descriptor)
   * }
   */
  public MemorySegment targetNewToDescriptor(int descriptor) throws VipsError {
    var result = VipsRaw_1.vips_target_new_to_descriptor(descriptor);
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
  public MemorySegment targetNewToFile(String filenameString) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw_1.vips_target_new_to_file(filename);
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
  public MemorySegment targetNewToMemory() throws VipsError {
    var result = VipsRaw_1.vips_target_new_to_memory();
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
  public MemorySegment targetNewTemp(MemorySegment target) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_new_temp", "target");
    }
    var result = VipsRaw_1.vips_target_new_temp(target);
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
  public void targetWrite(MemorySegment target, MemorySegment data, long length) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_write", "target");
    }
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_target_write", "data");
    }
    var result = VipsRaw_1.vips_target_write(target, data, length);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_target_write");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gint64 vips_target_read(VipsTarget *target, void *buffer, size_t length)
   * }
   */
  public long targetRead(MemorySegment target, MemorySegment buffer, long length) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_read", "target");
    }
    if(!VipsValidation.isValidPointer(buffer)) {
      VipsValidation.throwInvalidInputError("vips_target_read", "buffer");
    }
    var result = VipsRaw_1.vips_target_read(target, buffer, length);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gint64 vips_target_seek(VipsTarget *target, gint64 offset, int whence)
   * }
   */
  public long targetSeek(MemorySegment target, long offset, int whence) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_seek", "target");
    }
    var result = VipsRaw_1.vips_target_seek(target, offset, whence);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_target_end(VipsTarget *target)
   * }
   */
  public void targetEnd(MemorySegment target) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_end", "target");
    }
    var result = VipsRaw_1.vips_target_end(target);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_target_end");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_target_finish(VipsTarget *target)
   * }
   */
  public void targetFinish(MemorySegment target) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_finish", "target");
    }
    VipsRaw_1.vips_target_finish(target);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * unsigned char *vips_target_steal(VipsTarget *target, size_t *length)
   * }
   */
  public MemorySegment targetSteal(MemorySegment target, MemorySegment length) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_steal", "target");
    }
    if(!VipsValidation.isValidPointer(length)) {
      VipsValidation.throwInvalidInputError("vips_target_steal", "length");
    }
    var result = VipsRaw_1.vips_target_steal(target, length);
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
  public String targetStealText(MemorySegment target) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_steal_text", "target");
    }
    var result = VipsRaw_1.vips_target_steal_text(target);
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
  public void targetPutc(MemorySegment target, int ch) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_putc", "target");
    }
    var result = VipsRaw_1.vips_target_putc(target, ch);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_target_putc");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_target_writes(VipsTarget *target, const char *str)
   * }
   */
  public void targetWrites(MemorySegment target, String strString) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_writes", "target");
    }
    var str = arena.allocateFrom(strString);
    var result = VipsRaw_1.vips_target_writes(target, str);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_target_writes");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_target_write_amp(VipsTarget *target, const char *str)
   * }
   */
  public void targetWriteAmp(MemorySegment target, String strString) throws VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_write_amp", "target");
    }
    var str = arena.allocateFrom(strString);
    var result = VipsRaw_1.vips_target_write_amp(target, str);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_target_write_amp");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_target_custom_get_type()
   * }
   */
  public long targetCustomGetType() throws VipsError {
    var result = VipsRaw_1.vips_target_custom_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsTargetCustom *vips_target_custom_new()
   * }
   */
  public MemorySegment targetCustomNew() throws VipsError {
    var result = VipsRaw_1.vips_target_custom_new();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_target_custom_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_sbuf_get_type()
   * }
   */
  public long sbufGetType() throws VipsError {
    var result = VipsRaw_1.vips_sbuf_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsSbuf *vips_sbuf_new_from_source(VipsSource *source)
   * }
   */
  public MemorySegment sbufNewFromSource(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_sbuf_new_from_source", "source");
    }
    var result = VipsRaw_1.vips_sbuf_new_from_source(source);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_sbuf_new_from_source", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_sbuf_unbuffer(VipsSbuf *sbuf)
   * }
   */
  public void sbufUnbuffer(MemorySegment sbuf) throws VipsError {
    if(!VipsValidation.isValidPointer(sbuf)) {
      VipsValidation.throwInvalidInputError("vips_sbuf_unbuffer", "sbuf");
    }
    VipsRaw_1.vips_sbuf_unbuffer(sbuf);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sbuf_getc(VipsSbuf *sbuf)
   * }
   */
  public void sbufGetc(MemorySegment sbuf) throws VipsError {
    if(!VipsValidation.isValidPointer(sbuf)) {
      VipsValidation.throwInvalidInputError("vips_sbuf_getc", "sbuf");
    }
    var result = VipsRaw_1.vips_sbuf_getc(sbuf);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sbuf_getc");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_sbuf_ungetc(VipsSbuf *sbuf)
   * }
   */
  public void sbufUngetc(MemorySegment sbuf) throws VipsError {
    if(!VipsValidation.isValidPointer(sbuf)) {
      VipsValidation.throwInvalidInputError("vips_sbuf_ungetc", "sbuf");
    }
    VipsRaw_1.vips_sbuf_ungetc(sbuf);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sbuf_require(VipsSbuf *sbuf, int require)
   * }
   */
  public void sbufRequire(MemorySegment sbuf, int require) throws VipsError {
    if(!VipsValidation.isValidPointer(sbuf)) {
      VipsValidation.throwInvalidInputError("vips_sbuf_require", "sbuf");
    }
    var result = VipsRaw_1.vips_sbuf_require(sbuf, require);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sbuf_require");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_sbuf_get_line(VipsSbuf *sbuf)
   * }
   */
  public String sbufGetLine(MemorySegment sbuf) throws VipsError {
    if(!VipsValidation.isValidPointer(sbuf)) {
      VipsValidation.throwInvalidInputError("vips_sbuf_get_line", "sbuf");
    }
    var result = VipsRaw_1.vips_sbuf_get_line(sbuf);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_sbuf_get_line", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * char *vips_sbuf_get_line_copy(VipsSbuf *sbuf)
   * }
   */
  public String sbufGetLineCopy(MemorySegment sbuf) throws VipsError {
    if(!VipsValidation.isValidPointer(sbuf)) {
      VipsValidation.throwInvalidInputError("vips_sbuf_get_line_copy", "sbuf");
    }
    var result = VipsRaw_1.vips_sbuf_get_line_copy(sbuf);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_sbuf_get_line_copy", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_sbuf_get_non_whitespace(VipsSbuf *sbuf)
   * }
   */
  public String sbufGetNonWhitespace(MemorySegment sbuf) throws VipsError {
    if(!VipsValidation.isValidPointer(sbuf)) {
      VipsValidation.throwInvalidInputError("vips_sbuf_get_non_whitespace", "sbuf");
    }
    var result = VipsRaw_1.vips_sbuf_get_non_whitespace(sbuf);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_sbuf_get_non_whitespace", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sbuf_skip_whitespace(VipsSbuf *sbuf)
   * }
   */
  public void sbufSkipWhitespace(MemorySegment sbuf) throws VipsError {
    if(!VipsValidation.isValidPointer(sbuf)) {
      VipsValidation.throwInvalidInputError("vips_sbuf_skip_whitespace", "sbuf");
    }
    var result = VipsRaw_1.vips_sbuf_skip_whitespace(sbuf);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sbuf_skip_whitespace");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_rect_isempty(const VipsRect *r)
   * }
   */
  public boolean rectIsempty(MemorySegment r) throws VipsError {
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_rect_isempty", "r");
    }
    var result = VipsRaw_1.vips_rect_isempty(r);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_rect_includespoint(const VipsRect *r, int x, int y)
   * }
   */
  public boolean rectIncludespoint(MemorySegment r, int x, int y) throws VipsError {
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_rect_includespoint", "r");
    }
    var result = VipsRaw_1.vips_rect_includespoint(r, x, y);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_rect_includesrect(const VipsRect *r1, const VipsRect *r2)
   * }
   */
  public boolean rectIncludesrect(MemorySegment r1, MemorySegment r2) throws VipsError {
    if(!VipsValidation.isValidPointer(r1)) {
      VipsValidation.throwInvalidInputError("vips_rect_includesrect", "r1");
    }
    if(!VipsValidation.isValidPointer(r2)) {
      VipsValidation.throwInvalidInputError("vips_rect_includesrect", "r2");
    }
    var result = VipsRaw_1.vips_rect_includesrect(r1, r2);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_rect_equalsrect(const VipsRect *r1, const VipsRect *r2)
   * }
   */
  public boolean rectEqualsrect(MemorySegment r1, MemorySegment r2) throws VipsError {
    if(!VipsValidation.isValidPointer(r1)) {
      VipsValidation.throwInvalidInputError("vips_rect_equalsrect", "r1");
    }
    if(!VipsValidation.isValidPointer(r2)) {
      VipsValidation.throwInvalidInputError("vips_rect_equalsrect", "r2");
    }
    var result = VipsRaw_1.vips_rect_equalsrect(r1, r2);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_rect_overlapsrect(const VipsRect *r1, const VipsRect *r2)
   * }
   */
  public boolean rectOverlapsrect(MemorySegment r1, MemorySegment r2) throws VipsError {
    if(!VipsValidation.isValidPointer(r1)) {
      VipsValidation.throwInvalidInputError("vips_rect_overlapsrect", "r1");
    }
    if(!VipsValidation.isValidPointer(r2)) {
      VipsValidation.throwInvalidInputError("vips_rect_overlapsrect", "r2");
    }
    var result = VipsRaw_1.vips_rect_overlapsrect(r1, r2);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_rect_marginadjust(VipsRect *r, int n)
   * }
   */
  public void rectMarginadjust(MemorySegment r, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_rect_marginadjust", "r");
    }
    VipsRaw_1.vips_rect_marginadjust(r, n);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_rect_intersectrect(const VipsRect *r1, const VipsRect *r2, VipsRect *out)
   * }
   */
  public void rectIntersectrect(MemorySegment r1, MemorySegment r2, VipsOutputPointer out) throws
      VipsError {
    if(!VipsValidation.isValidPointer(r1)) {
      VipsValidation.throwInvalidInputError("vips_rect_intersectrect", "r1");
    }
    if(!VipsValidation.isValidPointer(r2)) {
      VipsValidation.throwInvalidInputError("vips_rect_intersectrect", "r2");
    }
    var outPointer = out.pointerOrNull$internal();
    VipsRaw_1.vips_rect_intersectrect(r1, r2, outPointer);
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_rect_unionrect(const VipsRect *r1, const VipsRect *r2, VipsRect *out)
   * }
   */
  public void rectUnionrect(MemorySegment r1, MemorySegment r2, VipsOutputPointer out) throws
      VipsError {
    if(!VipsValidation.isValidPointer(r1)) {
      VipsValidation.throwInvalidInputError("vips_rect_unionrect", "r1");
    }
    if(!VipsValidation.isValidPointer(r2)) {
      VipsValidation.throwInvalidInputError("vips_rect_unionrect", "r2");
    }
    var outPointer = out.pointerOrNull$internal();
    VipsRaw_1.vips_rect_unionrect(r1, r2, outPointer);
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsRect *vips_rect_dup(const VipsRect *r)
   * }
   */
  public MemorySegment rectDup(MemorySegment r) throws VipsError {
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_rect_dup", "r");
    }
    var result = VipsRaw_1.vips_rect_dup(r);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_rect_dup", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_rect_normalise(VipsRect *r)
   * }
   */
  public void rectNormalise(MemorySegment r) throws VipsError {
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_rect_normalise", "r");
    }
    VipsRaw_1.vips_rect_normalise(r);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_window_unref(VipsWindow *window)
   * }
   */
  public void windowUnref(MemorySegment window) throws VipsError {
    if(!VipsValidation.isValidPointer(window)) {
      VipsValidation.throwInvalidInputError("vips_window_unref", "window");
    }
    var result = VipsRaw_1.vips_window_unref(window);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_window_unref");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_window_print(VipsWindow *window)
   * }
   */
  public void windowPrint(MemorySegment window) throws VipsError {
    if(!VipsValidation.isValidPointer(window)) {
      VipsValidation.throwInvalidInputError("vips_window_print", "window");
    }
    VipsRaw_1.vips_window_print(window);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_buffer_dump_all()
   * }
   */
  public void bufferDumpAll() throws VipsError {
    VipsRaw_1.vips_buffer_dump_all();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_buffer_done(VipsBuffer *buffer)
   * }
   */
  public void bufferDone(MemorySegment buffer) throws VipsError {
    if(!VipsValidation.isValidPointer(buffer)) {
      VipsValidation.throwInvalidInputError("vips_buffer_done", "buffer");
    }
    VipsRaw_1.vips_buffer_done(buffer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_buffer_undone(VipsBuffer *buffer)
   * }
   */
  public void bufferUndone(MemorySegment buffer) throws VipsError {
    if(!VipsValidation.isValidPointer(buffer)) {
      VipsValidation.throwInvalidInputError("vips_buffer_undone", "buffer");
    }
    VipsRaw_1.vips_buffer_undone(buffer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_buffer_unref(VipsBuffer *buffer)
   * }
   */
  public void bufferUnref(MemorySegment buffer) throws VipsError {
    if(!VipsValidation.isValidPointer(buffer)) {
      VipsValidation.throwInvalidInputError("vips_buffer_unref", "buffer");
    }
    VipsRaw_1.vips_buffer_unref(buffer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsBuffer *vips_buffer_new(struct _VipsImage *im, VipsRect *area)
   * }
   */
  public MemorySegment bufferNew(MemorySegment im, MemorySegment area) throws VipsError {
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_buffer_new", "im");
    }
    if(!VipsValidation.isValidPointer(area)) {
      VipsValidation.throwInvalidInputError("vips_buffer_new", "area");
    }
    var result = VipsRaw_1.vips_buffer_new(im, area);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_buffer_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsBuffer *vips_buffer_ref(struct _VipsImage *im, VipsRect *area)
   * }
   */
  public MemorySegment bufferRef(MemorySegment im, MemorySegment area) throws VipsError {
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_buffer_ref", "im");
    }
    if(!VipsValidation.isValidPointer(area)) {
      VipsValidation.throwInvalidInputError("vips_buffer_ref", "area");
    }
    var result = VipsRaw_1.vips_buffer_ref(im, area);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_buffer_ref", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsBuffer *vips_buffer_unref_ref(VipsBuffer *buffer, struct _VipsImage *im, VipsRect *area)
   * }
   */
  public MemorySegment bufferUnrefRef(MemorySegment buffer, MemorySegment im, MemorySegment area)
      throws VipsError {
    if(!VipsValidation.isValidPointer(buffer)) {
      VipsValidation.throwInvalidInputError("vips_buffer_unref_ref", "buffer");
    }
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_buffer_unref_ref", "im");
    }
    if(!VipsValidation.isValidPointer(area)) {
      VipsValidation.throwInvalidInputError("vips_buffer_unref_ref", "area");
    }
    var result = VipsRaw_1.vips_buffer_unref_ref(buffer, im, area);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_buffer_unref_ref", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_buffer_print(VipsBuffer *buffer)
   * }
   */
  public void bufferPrint(MemorySegment buffer) throws VipsError {
    if(!VipsValidation.isValidPointer(buffer)) {
      VipsValidation.throwInvalidInputError("vips_buffer_print", "buffer");
    }
    VipsRaw_1.vips_buffer_print(buffer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_region_dump_all()
   * }
   */
  public void regionDumpAll() throws VipsError {
    VipsRaw_1.vips_region_dump_all();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_region_prepare_many(struct _VipsRegion **reg, const VipsRect *r)
   * }
   */
  public void regionPrepareMany(MemorySegment reg, MemorySegment r) throws VipsError {
    if(!VipsValidation.isValidPointer(reg)) {
      VipsValidation.throwInvalidInputError("vips_region_prepare_many", "reg");
    }
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_region_prepare_many", "r");
    }
    var result = VipsRaw_1.vips_region_prepare_many(reg, r);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_region_prepare_many");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_region_get_type()
   * }
   */
  public long regionGetType() throws VipsError {
    var result = VipsRaw_1.vips_region_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsRegion *vips_region_new(VipsImage *image)
   * }
   */
  public MemorySegment regionNew(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_region_new", "image");
    }
    var result = VipsRaw_1.vips_region_new(image);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_region_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_region_buffer(VipsRegion *reg, const VipsRect *r)
   * }
   */
  public void regionBuffer(MemorySegment reg, MemorySegment r) throws VipsError {
    if(!VipsValidation.isValidPointer(reg)) {
      VipsValidation.throwInvalidInputError("vips_region_buffer", "reg");
    }
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_region_buffer", "r");
    }
    var result = VipsRaw_1.vips_region_buffer(reg, r);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_region_buffer");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_region_image(VipsRegion *reg, const VipsRect *r)
   * }
   */
  public void regionImage(MemorySegment reg, MemorySegment r) throws VipsError {
    if(!VipsValidation.isValidPointer(reg)) {
      VipsValidation.throwInvalidInputError("vips_region_image", "reg");
    }
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_region_image", "r");
    }
    var result = VipsRaw_1.vips_region_image(reg, r);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_region_image");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_region_region(VipsRegion *reg, VipsRegion *dest, const VipsRect *r, int x, int y)
   * }
   */
  public void regionRegion(MemorySegment reg, MemorySegment dest, MemorySegment r, int x, int y)
      throws VipsError {
    if(!VipsValidation.isValidPointer(reg)) {
      VipsValidation.throwInvalidInputError("vips_region_region", "reg");
    }
    if(!VipsValidation.isValidPointer(dest)) {
      VipsValidation.throwInvalidInputError("vips_region_region", "dest");
    }
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_region_region", "r");
    }
    var result = VipsRaw_1.vips_region_region(reg, dest, r, x, y);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_region_region");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_region_equalsregion(VipsRegion *reg1, VipsRegion *reg2)
   * }
   */
  public void regionEqualsregion(MemorySegment reg1, MemorySegment reg2) throws VipsError {
    if(!VipsValidation.isValidPointer(reg1)) {
      VipsValidation.throwInvalidInputError("vips_region_equalsregion", "reg1");
    }
    if(!VipsValidation.isValidPointer(reg2)) {
      VipsValidation.throwInvalidInputError("vips_region_equalsregion", "reg2");
    }
    var result = VipsRaw_1.vips_region_equalsregion(reg1, reg2);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_region_equalsregion");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_region_position(VipsRegion *reg, int x, int y)
   * }
   */
  public void regionPosition(MemorySegment reg, int x, int y) throws VipsError {
    if(!VipsValidation.isValidPointer(reg)) {
      VipsValidation.throwInvalidInputError("vips_region_position", "reg");
    }
    var result = VipsRaw_1.vips_region_position(reg, x, y);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_region_position");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_region_paint(VipsRegion *reg, const VipsRect *r, int value)
   * }
   */
  public void regionPaint(MemorySegment reg, MemorySegment r, int value) throws VipsError {
    if(!VipsValidation.isValidPointer(reg)) {
      VipsValidation.throwInvalidInputError("vips_region_paint", "reg");
    }
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_region_paint", "r");
    }
    VipsRaw_1.vips_region_paint(reg, r, value);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_region_paint_pel(VipsRegion *reg, const VipsRect *r, const VipsPel *ink)
   * }
   */
  public void regionPaintPel(MemorySegment reg, MemorySegment r, MemorySegment ink) throws
      VipsError {
    if(!VipsValidation.isValidPointer(reg)) {
      VipsValidation.throwInvalidInputError("vips_region_paint_pel", "reg");
    }
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_region_paint_pel", "r");
    }
    if(!VipsValidation.isValidPointer(ink)) {
      VipsValidation.throwInvalidInputError("vips_region_paint_pel", "ink");
    }
    VipsRaw_1.vips_region_paint_pel(reg, r, ink);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_region_black(VipsRegion *reg)
   * }
   */
  public void regionBlack(MemorySegment reg) throws VipsError {
    if(!VipsValidation.isValidPointer(reg)) {
      VipsValidation.throwInvalidInputError("vips_region_black", "reg");
    }
    VipsRaw_1.vips_region_black(reg);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_region_copy(VipsRegion *reg, VipsRegion *dest, const VipsRect *r, int x, int y)
   * }
   */
  public void regionCopy(MemorySegment reg, MemorySegment dest, MemorySegment r, int x, int y)
      throws VipsError {
    if(!VipsValidation.isValidPointer(reg)) {
      VipsValidation.throwInvalidInputError("vips_region_copy", "reg");
    }
    if(!VipsValidation.isValidPointer(dest)) {
      VipsValidation.throwInvalidInputError("vips_region_copy", "dest");
    }
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_region_copy", "r");
    }
    VipsRaw_1.vips_region_copy(reg, dest, r, x, y);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_region_shrink_method(VipsRegion *from, VipsRegion *to, const VipsRect *target, VipsRegionShrink method)
   * }
   */
  public void regionShrinkMethod(MemorySegment from, MemorySegment to, MemorySegment target,
      int method) throws VipsError {
    if(!VipsValidation.isValidPointer(from)) {
      VipsValidation.throwInvalidInputError("vips_region_shrink_method", "from");
    }
    if(!VipsValidation.isValidPointer(to)) {
      VipsValidation.throwInvalidInputError("vips_region_shrink_method", "to");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_region_shrink_method", "target");
    }
    var result = VipsRaw_1.vips_region_shrink_method(from, to, target, method);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_region_shrink_method");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_region_shrink(VipsRegion *from, VipsRegion *to, const VipsRect *target)
   * }
   */
  public void regionShrink(MemorySegment from, MemorySegment to, MemorySegment target) throws
      VipsError {
    if(!VipsValidation.isValidPointer(from)) {
      VipsValidation.throwInvalidInputError("vips_region_shrink", "from");
    }
    if(!VipsValidation.isValidPointer(to)) {
      VipsValidation.throwInvalidInputError("vips_region_shrink", "to");
    }
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_region_shrink", "target");
    }
    var result = VipsRaw_1.vips_region_shrink(from, to, target);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_region_shrink");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_region_prepare(VipsRegion *reg, const VipsRect *r)
   * }
   */
  public void regionPrepare(MemorySegment reg, MemorySegment r) throws VipsError {
    if(!VipsValidation.isValidPointer(reg)) {
      VipsValidation.throwInvalidInputError("vips_region_prepare", "reg");
    }
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_region_prepare", "r");
    }
    var result = VipsRaw_1.vips_region_prepare(reg, r);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_region_prepare");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_region_prepare_to(VipsRegion *reg, VipsRegion *dest, const VipsRect *r, int x, int y)
   * }
   */
  public void regionPrepareTo(MemorySegment reg, MemorySegment dest, MemorySegment r, int x, int y)
      throws VipsError {
    if(!VipsValidation.isValidPointer(reg)) {
      VipsValidation.throwInvalidInputError("vips_region_prepare_to", "reg");
    }
    if(!VipsValidation.isValidPointer(dest)) {
      VipsValidation.throwInvalidInputError("vips_region_prepare_to", "dest");
    }
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_region_prepare_to", "r");
    }
    var result = VipsRaw_1.vips_region_prepare_to(reg, dest, r, x, y);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_region_prepare_to");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsPel *vips_region_fetch(VipsRegion *region, int left, int top, int width, int height, size_t *len)
   * }
   */
  public MemorySegment regionFetch(MemorySegment region, int left, int top, int width, int height,
      MemorySegment len) throws VipsError {
    if(!VipsValidation.isValidPointer(region)) {
      VipsValidation.throwInvalidInputError("vips_region_fetch", "region");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_region_fetch", "len");
    }
    var result = VipsRaw_1.vips_region_fetch(region, left, top, width, height, len);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_region_fetch", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_region_width(VipsRegion *region)
   * }
   */
  public void regionWidth(MemorySegment region) throws VipsError {
    if(!VipsValidation.isValidPointer(region)) {
      VipsValidation.throwInvalidInputError("vips_region_width", "region");
    }
    var result = VipsRaw_1.vips_region_width(region);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_region_width");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_region_height(VipsRegion *region)
   * }
   */
  public void regionHeight(MemorySegment region) throws VipsError {
    if(!VipsValidation.isValidPointer(region)) {
      VipsValidation.throwInvalidInputError("vips_region_height", "region");
    }
    var result = VipsRaw_1.vips_region_height(region);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_region_height");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_region_invalidate(VipsRegion *reg)
   * }
   */
  public void regionInvalidate(MemorySegment reg) throws VipsError {
    if(!VipsValidation.isValidPointer(reg)) {
      VipsValidation.throwInvalidInputError("vips_region_invalidate", "reg");
    }
    VipsRaw_1.vips_region_invalidate(reg);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_image_get_type()
   * }
   */
  public long imageGetType() throws VipsError {
    var result = VipsRaw_1.vips_image_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_progress_set(gboolean progress)
   * }
   */
  public void progressSet(boolean progressBoolean) throws VipsError {
    var progress = progressBoolean ? 1 : 0;
    VipsRaw_1.vips_progress_set(progress);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_invalidate_all(VipsImage *image)
   * }
   */
  public void imageInvalidateAll(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_invalidate_all", "image");
    }
    VipsRaw_1.vips_image_invalidate_all(image);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_minimise_all(VipsImage *image)
   * }
   */
  public void imageMinimiseAll(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_minimise_all", "image");
    }
    VipsRaw_1.vips_image_minimise_all(image);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_is_sequential(VipsImage *image)
   * }
   */
  public boolean imageIsSequential(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_is_sequential", "image");
    }
    var result = VipsRaw_1.vips_image_is_sequential(image);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_progress(VipsImage *image, gboolean progress)
   * }
   */
  public void imageSetProgress(MemorySegment image, boolean progressBoolean) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_progress", "image");
    }
    var progress = progressBoolean ? 1 : 0;
    VipsRaw_1.vips_image_set_progress(image, progress);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_iskilled(VipsImage *image)
   * }
   */
  public boolean imageIskilled(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_iskilled", "image");
    }
    var result = VipsRaw_1.vips_image_iskilled(image);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_kill(VipsImage *image, gboolean kill)
   * }
   */
  public void imageSetKill(MemorySegment image, boolean killBoolean) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_kill", "image");
    }
    var kill = killBoolean ? 1 : 0;
    VipsRaw_1.vips_image_set_kill(image, kill);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * char *vips_filename_get_filename(const char *vips_filename)
   * }
   */
  public String filenameGetFilename(String vips_filenameString) throws VipsError {
    var vips_filename = arena.allocateFrom(vips_filenameString);
    var result = VipsRaw_1.vips_filename_get_filename(vips_filename);
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
  public String filenameGetOptions(String vips_filenameString) throws VipsError {
    var vips_filename = arena.allocateFrom(vips_filenameString);
    var result = VipsRaw_1.vips_filename_get_options(vips_filename);
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
  public MemorySegment imageNew() throws VipsError {
    var result = VipsRaw_1.vips_image_new();
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
  public MemorySegment imageNewMemory() throws VipsError {
    var result = VipsRaw_1.vips_image_new_memory();
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
  public MemorySegment imageMemory() throws VipsError {
    var result = VipsRaw_1.vips_image_memory();
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
  public MemorySegment imageNewFromFileRW(String filenameString) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw_1.vips_image_new_from_file_RW(filename);
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
  public MemorySegment imageNewFromFileRaw(String filenameString, int xsize, int ysize, int bands,
      long offset) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw_1.vips_image_new_from_file_raw(filename, xsize, ysize, bands, offset);
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
  public MemorySegment imageNewFromMemory(MemorySegment data, long size, int width, int height,
      int bands, int format) throws VipsError {
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_memory", "data");
    }
    var result = VipsRaw_1.vips_image_new_from_memory(data, size, width, height, bands, format);
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
  public MemorySegment imageNewFromMemoryCopy(MemorySegment data, long size, int width, int height,
      int bands, int format) throws VipsError {
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_memory_copy", "data");
    }
    var result = VipsRaw_1.vips_image_new_from_memory_copy(data, size, width, height, bands, format);
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
  public MemorySegment imageNewMatrix(int width, int height) throws VipsError {
    var result = VipsRaw_1.vips_image_new_matrix(width, height);
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
  public MemorySegment imageNewMatrixFromArray(int width, int height, MemorySegment array, int size)
      throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_image_new_matrix_from_array", "array");
    }
    var result = VipsRaw_1.vips_image_new_matrix_from_array(width, height, array, size);
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
  public MemorySegment imageMatrixFromArray(int width, int height, MemorySegment array, int size)
      throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_image_matrix_from_array", "array");
    }
    var result = VipsRaw_1.vips_image_matrix_from_array(width, height, array, size);
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
  public MemorySegment imageNewFromImage(MemorySegment image, MemorySegment c, int n) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_image", "image");
    }
    if(!VipsValidation.isValidPointer(c)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_image", "c");
    }
    var result = VipsRaw_1.vips_image_new_from_image(image, c, n);
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
  public MemorySegment imageNewFromImage1(MemorySegment image, double c) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_image1", "image");
    }
    var result = VipsRaw_1.vips_image_new_from_image1(image, c);
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
  public void imageSetDeleteOnClose(MemorySegment image, boolean delete_on_closeBoolean) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_delete_on_close", "image");
    }
    var delete_on_close = delete_on_closeBoolean ? 1 : 0;
    VipsRaw_1.vips_image_set_delete_on_close(image, delete_on_close);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_new_temp_file(const char *format)
   * }
   */
  public MemorySegment imageNewTempFile(String formatString) throws VipsError {
    var format = arena.allocateFrom(formatString);
    var result = VipsRaw_1.vips_image_new_temp_file(format);
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
  public void imageWrite(MemorySegment image, VipsOutputPointer out) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_write", "image");
    }
    var outPointer = out.pointerOrNull$internal();
    var result = VipsRaw_1.vips_image_write(image, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_write");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_image_write_to_memory(VipsImage *in, size_t *size)
   * }
   */
  public MemorySegment imageWriteToMemory(MemorySegment in, MemorySegment size) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_memory", "in");
    }
    if(!VipsValidation.isValidPointer(size)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_memory", "size");
    }
    var result = VipsRaw_1.vips_image_write_to_memory(in, size);
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
  public void imageDecodePredict(MemorySegment in, MemorySegment bands, MemorySegment format) throws
      VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_decode_predict", "in");
    }
    if(!VipsValidation.isValidPointer(bands)) {
      VipsValidation.throwInvalidInputError("vips_image_decode_predict", "bands");
    }
    if(!VipsValidation.isValidPointer(format)) {
      VipsValidation.throwInvalidInputError("vips_image_decode_predict", "format");
    }
    var result = VipsRaw_1.vips_image_decode_predict(in, bands, format);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_decode_predict");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_decode(VipsImage *in, VipsImage **out)
   * }
   */
  public void imageDecode(MemorySegment in, VipsOutputPointer out) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_decode", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var result = VipsRaw_1.vips_image_decode(in, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_decode");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_encode(VipsImage *in, VipsImage **out, VipsCoding coding)
   * }
   */
  public void imageEncode(MemorySegment in, VipsOutputPointer out, int coding) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_encode", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    var result = VipsRaw_1.vips_image_encode(in, outPointer, coding);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_encode");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_isMSBfirst(VipsImage *image)
   * }
   */
  public boolean imageIsMSBfirst(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_isMSBfirst", "image");
    }
    var result = VipsRaw_1.vips_image_isMSBfirst(image);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_isfile(VipsImage *image)
   * }
   */
  public boolean imageIsfile(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_isfile", "image");
    }
    var result = VipsRaw_1.vips_image_isfile(image);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_ispartial(VipsImage *image)
   * }
   */
  public boolean imageIspartial(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_ispartial", "image");
    }
    var result = VipsRaw_1.vips_image_ispartial(image);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_hasalpha(VipsImage *image)
   * }
   */
  public boolean imageHasalpha(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_hasalpha", "image");
    }
    var result = VipsRaw_1.vips_image_hasalpha(image);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsImage *vips_image_copy_memory(VipsImage *image)
   * }
   */
  public MemorySegment imageCopyMemory(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_copy_memory", "image");
    }
    var result = VipsRaw_1.vips_image_copy_memory(image);
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
  public void imageWioInput(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_wio_input", "image");
    }
    var result = VipsRaw_1.vips_image_wio_input(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_wio_input");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_pio_input(VipsImage *image)
   * }
   */
  public void imagePioInput(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_pio_input", "image");
    }
    var result = VipsRaw_1.vips_image_pio_input(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_pio_input");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_pio_output(VipsImage *image)
   * }
   */
  public void imagePioOutput(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_pio_output", "image");
    }
    var result = VipsRaw_1.vips_image_pio_output(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_pio_output");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_inplace(VipsImage *image)
   * }
   */
  public void imageInplace(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_inplace", "image");
    }
    var result = VipsRaw_1.vips_image_inplace(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_inplace");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_write_prepare(VipsImage *image)
   * }
   */
  public void imageWritePrepare(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_write_prepare", "image");
    }
    var result = VipsRaw_1.vips_image_write_prepare(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_write_prepare");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_write_line(VipsImage *image, int ypos, VipsPel *linebuffer)
   * }
   */
  public void imageWriteLine(MemorySegment image, int ypos, MemorySegment linebuffer) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_write_line", "image");
    }
    if(!VipsValidation.isValidPointer(linebuffer)) {
      VipsValidation.throwInvalidInputError("vips_image_write_line", "linebuffer");
    }
    var result = VipsRaw_1.vips_image_write_line(image, ypos, linebuffer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_write_line");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_band_format_isint(VipsBandFormat format)
   * }
   */
  public boolean bandFormatIsint(int format) throws VipsError {
    var result = VipsRaw_1.vips_band_format_isint(format);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_band_format_isuint(VipsBandFormat format)
   * }
   */
  public boolean bandFormatIsuint(int format) throws VipsError {
    var result = VipsRaw_1.vips_band_format_isuint(format);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_band_format_is8bit(VipsBandFormat format)
   * }
   */
  public boolean bandFormatIs8bit(int format) throws VipsError {
    var result = VipsRaw_1.vips_band_format_is8bit(format);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_band_format_isfloat(VipsBandFormat format)
   * }
   */
  public boolean bandFormatIsfloat(int format) throws VipsError {
    var result = VipsRaw_1.vips_band_format_isfloat(format);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_band_format_iscomplex(VipsBandFormat format)
   * }
   */
  public boolean bandFormatIscomplex(int format) throws VipsError {
    var result = VipsRaw_1.vips_band_format_iscomplex(format);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsArrayImage *vips_array_image_new(VipsImage **array, int n)
   * }
   */
  public MemorySegment arrayImageNew(MemorySegment array, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_image_new", "array");
    }
    var result = VipsRaw_1.vips_array_image_new(array, n);
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
  public MemorySegment arrayImageNewFromString(String stringString, int flags) throws VipsError {
    var string = arena.allocateFrom(stringString);
    var result = VipsRaw_1.vips_array_image_new_from_string(string, flags);
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
  public MemorySegment arrayImageEmpty() throws VipsError {
    var result = VipsRaw_1.vips_array_image_empty();
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
  public MemorySegment arrayImageAppend(MemorySegment array, MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_image_append", "array");
    }
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_array_image_append", "image");
    }
    var result = VipsRaw_1.vips_array_image_append(array, image);
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
  public MemorySegment arrayImageGet(MemorySegment array, MemorySegment n) throws VipsError {
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_array_image_get", "array");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_array_image_get", "n");
    }
    var result = VipsRaw_1.vips_array_image_get(array, n);
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
  public MemorySegment valueGetArrayImage(MemorySegment value, MemorySegment n) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_image", "value");
    }
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_value_get_array_image", "n");
    }
    var result = VipsRaw_1.vips_value_get_array_image(value, n);
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
  public void valueSetArrayImage(MemorySegment value, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_value_set_array_image", "value");
    }
    VipsRaw_1.vips_value_set_array_image(value, n);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_reorder_prepare_many(VipsImage *image, VipsRegion **regions, VipsRect *r)
   * }
   */
  public void reorderPrepareMany(MemorySegment image, MemorySegment regions, MemorySegment r) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_reorder_prepare_many", "image");
    }
    if(!VipsValidation.isValidPointer(regions)) {
      VipsValidation.throwInvalidInputError("vips_reorder_prepare_many", "regions");
    }
    if(!VipsValidation.isValidPointer(r)) {
      VipsValidation.throwInvalidInputError("vips_reorder_prepare_many", "r");
    }
    var result = VipsRaw_1.vips_reorder_prepare_many(image, regions, r);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_reorder_prepare_many");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_reorder_margin_hint(VipsImage *image, int margin)
   * }
   */
  public void reorderMarginHint(MemorySegment image, int margin) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_reorder_margin_hint", "image");
    }
    VipsRaw_1.vips_reorder_margin_hint(image, margin);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_free_buffer(VipsImage *image, void *buffer)
   * }
   */
  public void imageFreeBuffer(MemorySegment image, MemorySegment buffer) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_free_buffer", "image");
    }
    if(!VipsValidation.isValidPointer(buffer)) {
      VipsValidation.throwInvalidInputError("vips_image_free_buffer", "buffer");
    }
    VipsRaw_1.vips_image_free_buffer(image, buffer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_malloc(VipsObject *object, size_t size)
   * }
   */
  public MemorySegment malloc(MemorySegment object, long size) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_malloc", "object");
    }
    var result = VipsRaw_1.vips_malloc(object, size);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_malloc", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * char *vips_strdup(VipsObject *object, const char *str)
   * }
   */
  public String strdup(MemorySegment object, String strString) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_strdup", "object");
    }
    var str = arena.allocateFrom(strString);
    var result = VipsRaw_1.vips_strdup(object, str);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_strdup", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_tracked_free(void *s)
   * }
   */
  public void trackedFree(MemorySegment s) throws VipsError {
    if(!VipsValidation.isValidPointer(s)) {
      VipsValidation.throwInvalidInputError("vips_tracked_free", "s");
    }
    VipsRaw_1.vips_tracked_free(s);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_tracked_aligned_free(void *s)
   * }
   */
  public void trackedAlignedFree(MemorySegment s) throws VipsError {
    if(!VipsValidation.isValidPointer(s)) {
      VipsValidation.throwInvalidInputError("vips_tracked_aligned_free", "s");
    }
    VipsRaw_1.vips_tracked_aligned_free(s);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_tracked_malloc(size_t size)
   * }
   */
  public MemorySegment trackedMalloc(long size) throws VipsError {
    var result = VipsRaw_1.vips_tracked_malloc(size);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_tracked_malloc", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_tracked_aligned_alloc(size_t size, size_t align)
   * }
   */
  public MemorySegment trackedAlignedAlloc(long size, long align) throws VipsError {
    var result = VipsRaw_1.vips_tracked_aligned_alloc(size, align);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_tracked_aligned_alloc", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * size_t vips_tracked_get_mem()
   * }
   */
  public long trackedGetMem() throws VipsError {
    var result = VipsRaw_1.vips_tracked_get_mem();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * size_t vips_tracked_get_mem_highwater()
   * }
   */
  public long trackedGetMemHighwater() throws VipsError {
    var result = VipsRaw_1.vips_tracked_get_mem_highwater();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tracked_get_allocs()
   * }
   */
  public void trackedGetAllocs() throws VipsError {
    var result = VipsRaw_1.vips_tracked_get_allocs();
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tracked_get_allocs");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tracked_open(const char *pathname, int flags, int mode)
   * }
   */
  public void trackedOpen(String pathnameString, int flags, int mode) throws VipsError {
    var pathname = arena.allocateFrom(pathnameString);
    var result = VipsRaw_1.vips_tracked_open(pathname, flags, mode);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tracked_open");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tracked_close(int fd)
   * }
   */
  public void trackedClose(int fd) throws VipsError {
    var result = VipsRaw_1.vips_tracked_close(fd);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tracked_close");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_tracked_get_files()
   * }
   */
  public void trackedGetFiles() throws VipsError {
    var result = VipsRaw_1.vips_tracked_get_files();
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_tracked_get_files");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_error_buffer()
   * }
   */
  public String errorBuffer() throws VipsError {
    var result = VipsRaw_1.vips_error_buffer();
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
  public String errorBufferCopy() throws VipsError {
    var result = VipsRaw_1.vips_error_buffer_copy();
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
  public void errorClear() throws VipsError {
    VipsRaw_1.vips_error_clear();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_error_freeze()
   * }
   */
  public void errorFreeze() throws VipsError {
    VipsRaw_1.vips_error_freeze();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_error_thaw()
   * }
   */
  public void errorThaw() throws VipsError {
    VipsRaw_1.vips_error_thaw();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_verror(const char *domain, const char *fmt, va_list ap)
   * }
   */
  public void verror(String domainString, String fmtString, MemorySegment ap) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    var fmt = arena.allocateFrom(fmtString);
    VipsRaw_1.vips_verror(domain, fmt, ap);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_verror_system(int err, const char *domain, const char *fmt, va_list ap)
   * }
   */
  public void verrorSystem(int err, String domainString, String fmtString, MemorySegment ap) throws
      VipsError {
    var domain = arena.allocateFrom(domainString);
    var fmt = arena.allocateFrom(fmtString);
    VipsRaw_1.vips_verror_system(err, domain, fmt, ap);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_error_g(GError **error)
   * }
   */
  public void errorG(MemorySegment error) throws VipsError {
    if(!VipsValidation.isValidPointer(error)) {
      VipsValidation.throwInvalidInputError("vips_error_g", "error");
    }
    VipsRaw_1.vips_error_g(error);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_uncoded(const char *domain, VipsImage *im)
   * }
   */
  public void checkUncoded(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_uncoded", "im");
    }
    var result = VipsRaw_1.vips_check_uncoded(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_uncoded");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_coding(const char *domain, VipsImage *im, VipsCoding coding)
   * }
   */
  public void checkCoding(String domainString, MemorySegment im, int coding) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_coding", "im");
    }
    var result = VipsRaw_1.vips_check_coding(domain, im, coding);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_coding");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_coding_known(const char *domain, VipsImage *im)
   * }
   */
  public void checkCodingKnown(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_coding_known", "im");
    }
    var result = VipsRaw_1.vips_check_coding_known(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_coding_known");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_coding_noneorlabq(const char *domain, VipsImage *im)
   * }
   */
  public void checkCodingNoneorlabq(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_coding_noneorlabq", "im");
    }
    var result = VipsRaw_1.vips_check_coding_noneorlabq(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_coding_noneorlabq");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_coding_same(const char *domain, VipsImage *im1, VipsImage *im2)
   * }
   */
  public void checkCodingSame(String domainString, MemorySegment im1, MemorySegment im2) throws
      VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im1)) {
      VipsValidation.throwInvalidInputError("vips_check_coding_same", "im1");
    }
    if(!VipsValidation.isValidPointer(im2)) {
      VipsValidation.throwInvalidInputError("vips_check_coding_same", "im2");
    }
    var result = VipsRaw_1.vips_check_coding_same(domain, im1, im2);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_coding_same");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_mono(const char *domain, VipsImage *im)
   * }
   */
  public void checkMono(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_mono", "im");
    }
    var result = VipsRaw_1.vips_check_mono(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_mono");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_bands(const char *domain, VipsImage *im, int bands)
   * }
   */
  public void checkBands(String domainString, MemorySegment im, int bands) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_bands", "im");
    }
    var result = VipsRaw_1.vips_check_bands(domain, im, bands);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_bands");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_bands_1or3(const char *domain, VipsImage *im)
   * }
   */
  public void checkBands1or3(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_bands_1or3", "im");
    }
    var result = VipsRaw_1.vips_check_bands_1or3(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_bands_1or3");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_bands_atleast(const char *domain, VipsImage *im, int bands)
   * }
   */
  public void checkBandsAtleast(String domainString, MemorySegment im, int bands) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_bands_atleast", "im");
    }
    var result = VipsRaw_1.vips_check_bands_atleast(domain, im, bands);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_bands_atleast");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_bands_1orn(const char *domain, VipsImage *im1, VipsImage *im2)
   * }
   */
  public void checkBands1orn(String domainString, MemorySegment im1, MemorySegment im2) throws
      VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im1)) {
      VipsValidation.throwInvalidInputError("vips_check_bands_1orn", "im1");
    }
    if(!VipsValidation.isValidPointer(im2)) {
      VipsValidation.throwInvalidInputError("vips_check_bands_1orn", "im2");
    }
    var result = VipsRaw_1.vips_check_bands_1orn(domain, im1, im2);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_bands_1orn");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_bands_1orn_unary(const char *domain, VipsImage *im, int n)
   * }
   */
  public void checkBands1ornUnary(String domainString, MemorySegment im, int n) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_bands_1orn_unary", "im");
    }
    var result = VipsRaw_1.vips_check_bands_1orn_unary(domain, im, n);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_bands_1orn_unary");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_bands_same(const char *domain, VipsImage *im1, VipsImage *im2)
   * }
   */
  public void checkBandsSame(String domainString, MemorySegment im1, MemorySegment im2) throws
      VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im1)) {
      VipsValidation.throwInvalidInputError("vips_check_bands_same", "im1");
    }
    if(!VipsValidation.isValidPointer(im2)) {
      VipsValidation.throwInvalidInputError("vips_check_bands_same", "im2");
    }
    var result = VipsRaw_1.vips_check_bands_same(domain, im1, im2);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_bands_same");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_bandno(const char *domain, VipsImage *im, int bandno)
   * }
   */
  public void checkBandno(String domainString, MemorySegment im, int bandno) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_bandno", "im");
    }
    var result = VipsRaw_1.vips_check_bandno(domain, im, bandno);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_bandno");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_int(const char *domain, VipsImage *im)
   * }
   */
  public void checkInt(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_int", "im");
    }
    var result = VipsRaw_1.vips_check_int(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_int");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_uint(const char *domain, VipsImage *im)
   * }
   */
  public void checkUint(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_uint", "im");
    }
    var result = VipsRaw_1.vips_check_uint(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_uint");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_uintorf(const char *domain, VipsImage *im)
   * }
   */
  public void checkUintorf(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_uintorf", "im");
    }
    var result = VipsRaw_1.vips_check_uintorf(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_uintorf");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_noncomplex(const char *domain, VipsImage *im)
   * }
   */
  public void checkNoncomplex(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_noncomplex", "im");
    }
    var result = VipsRaw_1.vips_check_noncomplex(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_noncomplex");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_complex(const char *domain, VipsImage *im)
   * }
   */
  public void checkComplex(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_complex", "im");
    }
    var result = VipsRaw_1.vips_check_complex(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_complex");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_twocomponents(const char *domain, VipsImage *im)
   * }
   */
  public void checkTwocomponents(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_twocomponents", "im");
    }
    var result = VipsRaw_1.vips_check_twocomponents(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_twocomponents");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_format(const char *domain, VipsImage *im, VipsBandFormat fmt)
   * }
   */
  public void checkFormat(String domainString, MemorySegment im, int fmt) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_format", "im");
    }
    var result = VipsRaw_1.vips_check_format(domain, im, fmt);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_format");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_u8or16(const char *domain, VipsImage *im)
   * }
   */
  public void checkU8or16(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_u8or16", "im");
    }
    var result = VipsRaw_1.vips_check_u8or16(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_u8or16");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_8or16(const char *domain, VipsImage *im)
   * }
   */
  public void check8or16(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_8or16", "im");
    }
    var result = VipsRaw_1.vips_check_8or16(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_8or16");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_u8or16orf(const char *domain, VipsImage *im)
   * }
   */
  public void checkU8or16orf(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_u8or16orf", "im");
    }
    var result = VipsRaw_1.vips_check_u8or16orf(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_u8or16orf");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_format_same(const char *domain, VipsImage *im1, VipsImage *im2)
   * }
   */
  public void checkFormatSame(String domainString, MemorySegment im1, MemorySegment im2) throws
      VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im1)) {
      VipsValidation.throwInvalidInputError("vips_check_format_same", "im1");
    }
    if(!VipsValidation.isValidPointer(im2)) {
      VipsValidation.throwInvalidInputError("vips_check_format_same", "im2");
    }
    var result = VipsRaw_1.vips_check_format_same(domain, im1, im2);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_format_same");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_size_same(const char *domain, VipsImage *im1, VipsImage *im2)
   * }
   */
  public void checkSizeSame(String domainString, MemorySegment im1, MemorySegment im2) throws
      VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im1)) {
      VipsValidation.throwInvalidInputError("vips_check_size_same", "im1");
    }
    if(!VipsValidation.isValidPointer(im2)) {
      VipsValidation.throwInvalidInputError("vips_check_size_same", "im2");
    }
    var result = VipsRaw_1.vips_check_size_same(domain, im1, im2);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_size_same");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_oddsquare(const char *domain, VipsImage *im)
   * }
   */
  public void checkOddsquare(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_oddsquare", "im");
    }
    var result = VipsRaw_1.vips_check_oddsquare(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_oddsquare");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_vector_length(const char *domain, int n, int len)
   * }
   */
  public void checkVectorLength(String domainString, int n, int len) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    var result = VipsRaw_1.vips_check_vector_length(domain, n, len);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_vector_length");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_vector(const char *domain, int n, VipsImage *im)
   * }
   */
  public void checkVector(String domainString, int n, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_vector", "im");
    }
    var result = VipsRaw_1.vips_check_vector(domain, n, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_vector");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_hist(const char *domain, VipsImage *im)
   * }
   */
  public void checkHist(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_hist", "im");
    }
    var result = VipsRaw_1.vips_check_hist(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_hist");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_matrix(const char *domain, VipsImage *im, VipsImage **out)
   * }
   */
  public void checkMatrix(String domainString, MemorySegment im, VipsOutputPointer out) throws
      VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_matrix", "im");
    }
    var outPointer = out.pointerOrNull$internal();
    var result = VipsRaw_1.vips_check_matrix(domain, im, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_matrix");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_separable(const char *domain, VipsImage *im)
   * }
   */
  public void checkSeparable(String domainString, MemorySegment im) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_check_separable", "im");
    }
    var result = VipsRaw_1.vips_check_separable(domain, im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_separable");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_check_precision_intfloat(const char *domain, VipsPrecision precision)
   * }
   */
  public void checkPrecisionIntfloat(String domainString, int precision) throws VipsError {
    var domain = arena.allocateFrom(domainString);
    var result = VipsRaw_1.vips_check_precision_intfloat(domain, precision);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_check_precision_intfloat");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_format_get_type()
   * }
   */
  public long formatGetType() throws VipsError {
    var result = VipsRaw_1.vips_format_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsFormatClass *vips_format_for_file(const char *filename)
   * }
   */
  public MemorySegment formatForFile(String filenameString) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw_1.vips_format_for_file(filename);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_format_for_file", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsFormatClass *vips_format_for_name(const char *filename)
   * }
   */
  public MemorySegment formatForName(String filenameString) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw_1.vips_format_for_name(filename);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_format_for_name", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsFormatFlags vips_format_get_flags(VipsFormatClass *format, const char *filename)
   * }
   */
  public void formatGetFlags(MemorySegment format, String filenameString) throws VipsError {
    if(!VipsValidation.isValidPointer(format)) {
      VipsValidation.throwInvalidInputError("vips_format_get_flags", "format");
    }
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw_1.vips_format_get_flags(format, filename);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_format_get_flags");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_format_read(const char *filename, VipsImage *out)
   * }
   */
  public void formatRead(String filenameString, VipsOutputPointer out) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var outPointer = out.pointerOrNull$internal();
    var result = VipsRaw_1.vips_format_read(filename, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_format_read");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_format_write(VipsImage *in, const char *filename)
   * }
   */
  public void formatWrite(MemorySegment in, String filenameString) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_format_write", "in");
    }
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw_1.vips_format_write(in, filename);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_format_write");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sink_disc(VipsImage *im, VipsRegionWrite write_fn, void *a)
   * }
   */
  public void sinkDisc(MemorySegment im, MemorySegment write_fn, MemorySegment a) throws VipsError {
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_sink_disc", "im");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_sink_disc", "a");
    }
    var result = VipsRaw_1.vips_sink_disc(im, write_fn, a);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sink_disc");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sink(VipsImage *im, VipsStartFn start_fn, VipsGenerateFn generate_fn, VipsStopFn stop_fn, void *a, void *b)
   * }
   */
  public void sink(MemorySegment im, MemorySegment start_fn, MemorySegment generate_fn,
      MemorySegment stop_fn, MemorySegment a, MemorySegment b) throws VipsError {
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_sink", "im");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_sink", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_sink", "b");
    }
    var result = VipsRaw_1.vips_sink(im, start_fn, generate_fn, stop_fn, a, b);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sink");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sink_tile(VipsImage *im, int tile_width, int tile_height, VipsStartFn start_fn, VipsGenerateFn generate_fn, VipsStopFn stop_fn, void *a, void *b)
   * }
   */
  public void sinkTile(MemorySegment im, int tile_width, int tile_height, MemorySegment start_fn,
      MemorySegment generate_fn, MemorySegment stop_fn, MemorySegment a, MemorySegment b) throws
      VipsError {
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_sink_tile", "im");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_sink_tile", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_sink_tile", "b");
    }
    var result = VipsRaw_1.vips_sink_tile(im, tile_width, tile_height, start_fn, generate_fn, stop_fn, a, b);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sink_tile");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sink_screen(VipsImage *in, VipsImage *out, VipsImage *mask, int tile_width, int tile_height, int max_tiles, int priority, VipsSinkNotify notify_fn, void *a)
   * }
   */
  public void sinkScreen(MemorySegment in, VipsOutputPointer out, MemorySegment mask,
      int tile_width, int tile_height, int max_tiles, int priority, MemorySegment notify_fn,
      MemorySegment a) throws VipsError {
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sink_screen", "in");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_sink_screen", "mask");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_sink_screen", "a");
    }
    var result = VipsRaw_1.vips_sink_screen(in, outPointer, mask, tile_width, tile_height, max_tiles, priority, notify_fn, a);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sink_screen");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_sink_memory(VipsImage *im)
   * }
   */
  public void sinkMemory(MemorySegment im) throws VipsError {
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_sink_memory", "im");
    }
    var result = VipsRaw_1.vips_sink_memory(im);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_sink_memory");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_start_one(VipsImage *out, void *a, void *b)
   * }
   */
  public MemorySegment startOne(VipsOutputPointer out, MemorySegment a, MemorySegment b) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_start_one", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_start_one", "b");
    }
    var result = VipsRaw_1.vips_start_one(outPointer, a, b);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_start_one", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_stop_one(void *seq, void *a, void *b)
   * }
   */
  public void stopOne(MemorySegment seq, MemorySegment a, MemorySegment b) throws VipsError {
    if(!VipsValidation.isValidPointer(seq)) {
      VipsValidation.throwInvalidInputError("vips_stop_one", "seq");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_stop_one", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_stop_one", "b");
    }
    var result = VipsRaw_1.vips_stop_one(seq, a, b);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_stop_one");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_start_many(VipsImage *out, void *a, void *b)
   * }
   */
  public MemorySegment startMany(VipsOutputPointer out, MemorySegment a, MemorySegment b) throws
      VipsError {
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_start_many", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_start_many", "b");
    }
    var result = VipsRaw_1.vips_start_many(outPointer, a, b);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_start_many", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_stop_many(void *seq, void *a, void *b)
   * }
   */
  public void stopMany(MemorySegment seq, MemorySegment a, MemorySegment b) throws VipsError {
    if(!VipsValidation.isValidPointer(seq)) {
      VipsValidation.throwInvalidInputError("vips_stop_many", "seq");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_stop_many", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_stop_many", "b");
    }
    var result = VipsRaw_1.vips_stop_many(seq, a, b);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_stop_many");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_generate(VipsImage *image, VipsStartFn start_fn, VipsGenerateFn generate_fn, VipsStopFn stop_fn, void *a, void *b)
   * }
   */
  public void imageGenerate(MemorySegment image, MemorySegment start_fn, MemorySegment generate_fn,
      MemorySegment stop_fn, MemorySegment a, MemorySegment b) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_generate", "image");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_image_generate", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_image_generate", "b");
    }
    var result = VipsRaw_1.vips_image_generate(image, start_fn, generate_fn, stop_fn, a, b);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_generate");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_pipeline_array(VipsImage *image, VipsDemandStyle hint, VipsImage **in)
   * }
   */
  public void imagePipelineArray(MemorySegment image, int hint, MemorySegment in) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_pipeline_array", "image");
    }
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_image_pipeline_array", "in");
    }
    var result = VipsRaw_1.vips_image_pipeline_array(image, hint, in);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_pipeline_array");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_interpolate_get_type()
   * }
   */
  public long interpolateGetType() throws VipsError {
    var result = VipsRaw_1.vips_interpolate_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_interpolate(VipsInterpolate *interpolate, void *out, VipsRegion *in, double x, double y)
   * }
   */
  public void interpolate(MemorySegment interpolate, VipsOutputPointer out, MemorySegment in,
      double x, double y) throws VipsError {
    if(!VipsValidation.isValidPointer(interpolate)) {
      VipsValidation.throwInvalidInputError("vips_interpolate", "interpolate");
    }
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_interpolate", "in");
    }
    VipsRaw_1.vips_interpolate(interpolate, outPointer, in, x, y);
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsInterpolateMethod vips_interpolate_get_method(VipsInterpolate *interpolate)
   * }
   */
  public MemorySegment interpolateGetMethod(MemorySegment interpolate) throws VipsError {
    if(!VipsValidation.isValidPointer(interpolate)) {
      VipsValidation.throwInvalidInputError("vips_interpolate_get_method", "interpolate");
    }
    var result = VipsRaw_1.vips_interpolate_get_method(interpolate);
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
  public void interpolateGetWindowSize(MemorySegment interpolate) throws VipsError {
    if(!VipsValidation.isValidPointer(interpolate)) {
      VipsValidation.throwInvalidInputError("vips_interpolate_get_window_size", "interpolate");
    }
    var result = VipsRaw_1.vips_interpolate_get_window_size(interpolate);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_interpolate_get_window_size");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_interpolate_get_window_offset(VipsInterpolate *interpolate)
   * }
   */
  public void interpolateGetWindowOffset(MemorySegment interpolate) throws VipsError {
    if(!VipsValidation.isValidPointer(interpolate)) {
      VipsValidation.throwInvalidInputError("vips_interpolate_get_window_offset", "interpolate");
    }
    var result = VipsRaw_1.vips_interpolate_get_window_offset(interpolate);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_interpolate_get_window_offset");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsInterpolate *vips_interpolate_nearest_static()
   * }
   */
  public MemorySegment interpolateNearestStatic() throws VipsError {
    var result = VipsRaw_1.vips_interpolate_nearest_static();
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
  public MemorySegment interpolateBilinearStatic() throws VipsError {
    var result = VipsRaw_1.vips_interpolate_bilinear_static();
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
  public MemorySegment interpolateNew(String nicknameString) throws VipsError {
    var nickname = arena.allocateFrom(nicknameString);
    var result = VipsRaw_1.vips_interpolate_new(nickname);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_interpolate_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_thread_isvips()
   * }
   */
  public boolean threadIsvips() throws VipsError {
    var result = VipsRaw_1.vips_thread_isvips();
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_thread_execute(const char *domain, GFunc func, gpointer data)
   * }
   */
  public void threadExecute(String domainString, MemorySegment func, MemorySegment data) throws
      VipsError {
    var domain = arena.allocateFrom(domainString);
    var result = VipsRaw_1.vips_thread_execute(domain, func, data);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_thread_execute");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_semaphore_up(VipsSemaphore *s)
   * }
   */
  public void semaphoreUp(MemorySegment s) throws VipsError {
    if(!VipsValidation.isValidPointer(s)) {
      VipsValidation.throwInvalidInputError("vips_semaphore_up", "s");
    }
    var result = VipsRaw_1.vips_semaphore_up(s);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_semaphore_up");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_semaphore_upn(VipsSemaphore *s, int n)
   * }
   */
  public void semaphoreUpn(MemorySegment s, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(s)) {
      VipsValidation.throwInvalidInputError("vips_semaphore_upn", "s");
    }
    var result = VipsRaw_1.vips_semaphore_upn(s, n);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_semaphore_upn");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_semaphore_down(VipsSemaphore *s)
   * }
   */
  public void semaphoreDown(MemorySegment s) throws VipsError {
    if(!VipsValidation.isValidPointer(s)) {
      VipsValidation.throwInvalidInputError("vips_semaphore_down", "s");
    }
    var result = VipsRaw_1.vips_semaphore_down(s);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_semaphore_down");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_semaphore_downn(VipsSemaphore *s, int n)
   * }
   */
  public void semaphoreDownn(MemorySegment s, int n) throws VipsError {
    if(!VipsValidation.isValidPointer(s)) {
      VipsValidation.throwInvalidInputError("vips_semaphore_downn", "s");
    }
    var result = VipsRaw_1.vips_semaphore_downn(s, n);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_semaphore_downn");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_semaphore_down_timeout(VipsSemaphore *s, gint64 timeout)
   * }
   */
  public void semaphoreDownTimeout(MemorySegment s, long timeout) throws VipsError {
    if(!VipsValidation.isValidPointer(s)) {
      VipsValidation.throwInvalidInputError("vips_semaphore_down_timeout", "s");
    }
    var result = VipsRaw_1.vips_semaphore_down_timeout(s, timeout);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_semaphore_down_timeout");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_semaphore_destroy(VipsSemaphore *s)
   * }
   */
  public void semaphoreDestroy(MemorySegment s) throws VipsError {
    if(!VipsValidation.isValidPointer(s)) {
      VipsValidation.throwInvalidInputError("vips_semaphore_destroy", "s");
    }
    VipsRaw_1.vips_semaphore_destroy(s);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_semaphore_init(VipsSemaphore *s, int v, char *name)
   * }
   */
  public void semaphoreInit(MemorySegment s, int v, String nameString) throws VipsError {
    if(!VipsValidation.isValidPointer(s)) {
      VipsValidation.throwInvalidInputError("vips_semaphore_init", "s");
    }
    var name = arena.allocateFrom(nameString);
    VipsRaw_1.vips_semaphore_init(s, v, name);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void *vips_thread_state_set(VipsObject *object, void *a, void *b)
   * }
   */
  public MemorySegment threadStateSet(MemorySegment object, MemorySegment a, MemorySegment b) throws
      VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_thread_state_set", "object");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_thread_state_set", "a");
    }
    if(!VipsValidation.isValidPointer(b)) {
      VipsValidation.throwInvalidInputError("vips_thread_state_set", "b");
    }
    var result = VipsRaw_1.vips_thread_state_set(object, a, b);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_thread_state_set", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_thread_state_get_type()
   * }
   */
  public long threadStateGetType() throws VipsError {
    var result = VipsRaw_1.vips_thread_state_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsThreadState *vips_thread_state_new(VipsImage *im, void *a)
   * }
   */
  public MemorySegment threadStateNew(MemorySegment im, MemorySegment a) throws VipsError {
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_thread_state_new", "im");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_thread_state_new", "a");
    }
    var result = VipsRaw_1.vips_thread_state_new(im, a);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_thread_state_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_threadpool_run(VipsImage *im, VipsThreadStartFn start, VipsThreadpoolAllocateFn allocate, VipsThreadpoolWorkFn work, VipsThreadpoolProgressFn progress, void *a)
   * }
   */
  public void threadpoolRun(MemorySegment im, MemorySegment start, MemorySegment allocate,
      MemorySegment work, MemorySegment progress, MemorySegment a) throws VipsError {
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_threadpool_run", "im");
    }
    if(!VipsValidation.isValidPointer(a)) {
      VipsValidation.throwInvalidInputError("vips_threadpool_run", "a");
    }
    var result = VipsRaw_1.vips_threadpool_run(im, start, allocate, work, progress, a);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_threadpool_run");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * guint64 vips_format_sizeof(VipsBandFormat format)
   * }
   */
  public long formatSizeof(int format) throws VipsError {
    var result = VipsRaw_1.vips_format_sizeof(format);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * guint64 vips_format_sizeof_unsafe(VipsBandFormat format)
   * }
   */
  public long formatSizeofUnsafe(int format) throws VipsError {
    var result = VipsRaw_1.vips_format_sizeof_unsafe(format);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * double vips_interpretation_max_alpha(VipsInterpretation interpretation)
   * }
   */
  public double interpretationMaxAlpha(int interpretation) throws VipsError {
    var result = VipsRaw_1.vips_interpretation_max_alpha(interpretation);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_width(const VipsImage *image)
   * }
   */
  public void imageGetWidth(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_width", "image");
    }
    var result = VipsRaw_1.vips_image_get_width(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_width");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_height(const VipsImage *image)
   * }
   */
  public void imageGetHeight(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_height", "image");
    }
    var result = VipsRaw_1.vips_image_get_height(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_height");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_bands(const VipsImage *image)
   * }
   */
  public void imageGetBands(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_bands", "image");
    }
    var result = VipsRaw_1.vips_image_get_bands(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_bands");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsBandFormat vips_image_get_format(const VipsImage *image)
   * }
   */
  public void imageGetFormat(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_format", "image");
    }
    var result = VipsRaw_1.vips_image_get_format(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_format");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * double vips_image_get_format_max(VipsBandFormat format)
   * }
   */
  public double imageGetFormatMax(int format) throws VipsError {
    var result = VipsRaw_1.vips_image_get_format_max(format);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsBandFormat vips_image_guess_format(const VipsImage *image)
   * }
   */
  public void imageGuessFormat(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_guess_format", "image");
    }
    var result = VipsRaw_1.vips_image_guess_format(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_guess_format");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsCoding vips_image_get_coding(const VipsImage *image)
   * }
   */
  public void imageGetCoding(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_coding", "image");
    }
    var result = VipsRaw_1.vips_image_get_coding(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_coding");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsInterpretation vips_image_get_interpretation(const VipsImage *image)
   * }
   */
  public void imageGetInterpretation(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_interpretation", "image");
    }
    var result = VipsRaw_1.vips_image_get_interpretation(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_interpretation");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsInterpretation vips_image_guess_interpretation(const VipsImage *image)
   * }
   */
  public void imageGuessInterpretation(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_guess_interpretation", "image");
    }
    var result = VipsRaw_1.vips_image_guess_interpretation(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_guess_interpretation");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * double vips_image_get_xres(const VipsImage *image)
   * }
   */
  public double imageGetXres(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_xres", "image");
    }
    var result = VipsRaw_1.vips_image_get_xres(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * double vips_image_get_yres(const VipsImage *image)
   * }
   */
  public double imageGetYres(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_yres", "image");
    }
    var result = VipsRaw_1.vips_image_get_yres(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_xoffset(const VipsImage *image)
   * }
   */
  public void imageGetXoffset(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_xoffset", "image");
    }
    var result = VipsRaw_1.vips_image_get_xoffset(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_xoffset");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_yoffset(const VipsImage *image)
   * }
   */
  public void imageGetYoffset(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_yoffset", "image");
    }
    var result = VipsRaw_1.vips_image_get_yoffset(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_yoffset");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_image_get_filename(const VipsImage *image)
   * }
   */
  public String imageGetFilename(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_filename", "image");
    }
    var result = VipsRaw_1.vips_image_get_filename(image);
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
  public String imageGetMode(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_mode", "image");
    }
    var result = VipsRaw_1.vips_image_get_mode(image);
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
  public double imageGetScale(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_scale", "image");
    }
    var result = VipsRaw_1.vips_image_get_scale(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * double vips_image_get_offset(const VipsImage *image)
   * }
   */
  public double imageGetOffset(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_offset", "image");
    }
    var result = VipsRaw_1.vips_image_get_offset(image);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_page_height(VipsImage *image)
   * }
   */
  public void imageGetPageHeight(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_page_height", "image");
    }
    var result = VipsRaw_1.vips_image_get_page_height(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_page_height");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_n_pages(VipsImage *image)
   * }
   */
  public void imageGetNPages(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_n_pages", "image");
    }
    var result = VipsRaw_1.vips_image_get_n_pages(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_n_pages");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_n_subifds(VipsImage *image)
   * }
   */
  public void imageGetNSubifds(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_n_subifds", "image");
    }
    var result = VipsRaw_1.vips_image_get_n_subifds(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_n_subifds");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_orientation(VipsImage *image)
   * }
   */
  public void imageGetOrientation(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_orientation", "image");
    }
    var result = VipsRaw_1.vips_image_get_orientation(image);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_orientation");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_get_orientation_swap(VipsImage *image)
   * }
   */
  public boolean imageGetOrientationSwap(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_orientation_swap", "image");
    }
    var result = VipsRaw_1.vips_image_get_orientation_swap(image);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_concurrency(VipsImage *image, int default_concurrency)
   * }
   */
  public void imageGetConcurrency(MemorySegment image, int default_concurrency) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_concurrency", "image");
    }
    var result = VipsRaw_1.vips_image_get_concurrency(image, default_concurrency);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_concurrency");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const void *vips_image_get_data(VipsImage *image)
   * }
   */
  public MemorySegment imageGetData(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_data", "image");
    }
    var result = VipsRaw_1.vips_image_get_data(image);
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
  public void imageInitFields(MemorySegment image, int xsize, int ysize, int bands, int format,
      int coding, int interpretation, double xres, double yres) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_init_fields", "image");
    }
    VipsRaw_1.vips_image_init_fields(image, xsize, ysize, bands, format, coding, interpretation, xres, yres);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set(VipsImage *image, const char *name, GValue *value)
   * }
   */
  public void imageSet(MemorySegment image, String nameString, MemorySegment value) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(value)) {
      VipsValidation.throwInvalidInputError("vips_image_set", "value");
    }
    VipsRaw_1.vips_image_set(image, name, value);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get(const VipsImage *image, const char *name, GValue *value_copy)
   * }
   */
  public void imageGet(MemorySegment image, String nameString, MemorySegment value_copy) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(value_copy)) {
      VipsValidation.throwInvalidInputError("vips_image_get", "value_copy");
    }
    var result = VipsRaw_1.vips_image_get(image, name, value_copy);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_as_string(const VipsImage *image, const char *name, char **out)
   * }
   */
  public void imageGetAsString(MemorySegment image, String nameString, VipsOutputPointer out) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_as_string", "image");
    }
    var name = arena.allocateFrom(nameString);
    var outPointer = out.pointerOrNull$internal();
    var result = VipsRaw_1.vips_image_get_as_string(image, name, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_as_string");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = resultingOutPointer.reinterpret(arena, VipsRaw::g_free);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_image_get_typeof(const VipsImage *image, const char *name)
   * }
   */
  public long imageGetTypeof(MemorySegment image, String nameString) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_typeof", "image");
    }
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw_1.vips_image_get_typeof(image, name);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_image_remove(VipsImage *image, const char *name)
   * }
   */
  public boolean imageRemove(MemorySegment image, String nameString) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_remove", "image");
    }
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw_1.vips_image_remove(image, name);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gchar **vips_image_get_fields(VipsImage *image)
   * }
   */
  public MemorySegment imageGetFields(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_fields", "image");
    }
    var result = VipsRaw_1.vips_image_get_fields(image);
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
  public void imageSetArea(MemorySegment image, String nameString, MemorySegment free_fn,
      MemorySegment data) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_area", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_image_set_area", "data");
    }
    VipsRaw_1.vips_image_set_area(image, name, free_fn, data);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_area(const VipsImage *image, const char *name, const void **data)
   * }
   */
  public void imageGetArea(MemorySegment image, String nameString, MemorySegment data) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_area", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_image_get_area", "data");
    }
    var result = VipsRaw_1.vips_image_get_area(image, name, data);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_area");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_blob(VipsImage *image, const char *name, VipsCallbackFn free_fn, const void *data, size_t length)
   * }
   */
  public void imageSetBlob(MemorySegment image, String nameString, MemorySegment free_fn,
      MemorySegment data, long length) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_blob", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_image_set_blob", "data");
    }
    VipsRaw_1.vips_image_set_blob(image, name, free_fn, data, length);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_blob_copy(VipsImage *image, const char *name, const void *data, size_t length)
   * }
   */
  public void imageSetBlobCopy(MemorySegment image, String nameString, MemorySegment data,
      long length) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_blob_copy", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_image_set_blob_copy", "data");
    }
    VipsRaw_1.vips_image_set_blob_copy(image, name, data, length);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_blob(const VipsImage *image, const char *name, const void **data, size_t *length)
   * }
   */
  public void imageGetBlob(MemorySegment image, String nameString, MemorySegment data,
      MemorySegment length) throws VipsError {
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
    var result = VipsRaw_1.vips_image_get_blob(image, name, data, length);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_blob");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_int(const VipsImage *image, const char *name, int *out)
   * }
   */
  public void imageGetInt(MemorySegment image, String nameString, VipsOutputPointer out) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_int", "image");
    }
    var name = arena.allocateFrom(nameString);
    var outPointer = out.pointerOrNull$internal();
    var result = VipsRaw_1.vips_image_get_int(image, name, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_int");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_int(VipsImage *image, const char *name, int i)
   * }
   */
  public void imageSetInt(MemorySegment image, String nameString, int i) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_int", "image");
    }
    var name = arena.allocateFrom(nameString);
    VipsRaw_1.vips_image_set_int(image, name, i);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_double(const VipsImage *image, const char *name, double *out)
   * }
   */
  public void imageGetDouble(MemorySegment image, String nameString, VipsOutputPointer out) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_double", "image");
    }
    var name = arena.allocateFrom(nameString);
    var outPointer = out.pointerOrNull$internal();
    var result = VipsRaw_1.vips_image_get_double(image, name, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_double");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    out.setReinterpretedPointer$internal(resultingOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_double(VipsImage *image, const char *name, double d)
   * }
   */
  public void imageSetDouble(MemorySegment image, String nameString, double d) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_double", "image");
    }
    var name = arena.allocateFrom(nameString);
    VipsRaw_1.vips_image_set_double(image, name, d);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_string(const VipsImage *image, const char *name, const char **out)
   * }
   */
  public void imageGetString(MemorySegment image, String nameString, VipsOutputPointer out) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_string", "image");
    }
    var name = arena.allocateFrom(nameString);
    var outPointer = out.pointerOrNull$internal();
    var result = VipsRaw_1.vips_image_get_string(image, name, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_string");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = resultingOutPointer.reinterpret(arena, VipsRaw::g_free);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_string(VipsImage *image, const char *name, const char *str)
   * }
   */
  public void imageSetString(MemorySegment image, String nameString, String strString) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_string", "image");
    }
    var name = arena.allocateFrom(nameString);
    var str = arena.allocateFrom(strString);
    VipsRaw_1.vips_image_set_string(image, name, str);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_print_field(const VipsImage *image, const char *name)
   * }
   */
  public void imagePrintField(MemorySegment image, String nameString) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_print_field", "image");
    }
    var name = arena.allocateFrom(nameString);
    VipsRaw_1.vips_image_print_field(image, name);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_image(const VipsImage *image, const char *name, VipsImage **out)
   * }
   */
  public void imageGetImage(MemorySegment image, String nameString, VipsOutputPointer out) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_image", "image");
    }
    var name = arena.allocateFrom(nameString);
    var outPointer = out.pointerOrNull$internal();
    var result = VipsRaw_1.vips_image_get_image(image, name, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_image");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = VipsImage.reinterpret(resultingOutPointer, arena, VipsRaw::g_object_unref);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_image(VipsImage *image, const char *name, VipsImage *im)
   * }
   */
  public void imageSetImage(MemorySegment image, String nameString, MemorySegment im) throws
      VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_image", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(im)) {
      VipsValidation.throwInvalidInputError("vips_image_set_image", "im");
    }
    VipsRaw_1.vips_image_set_image(image, name, im);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_array_int(VipsImage *image, const char *name, const int *array, int n)
   * }
   */
  public void imageSetArrayInt(MemorySegment image, String nameString, MemorySegment array, int n)
      throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_array_int", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_image_set_array_int", "array");
    }
    VipsRaw_1.vips_image_set_array_int(image, name, array, n);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_array_int(VipsImage *image, const char *name, int **out, int *n)
   * }
   */
  public void imageGetArrayInt(MemorySegment image, String nameString, VipsOutputPointer out,
      MemorySegment n) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_array_int", "image");
    }
    var name = arena.allocateFrom(nameString);
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_image_get_array_int", "n");
    }
    var result = VipsRaw_1.vips_image_get_array_int(image, name, outPointer, n);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_array_int");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = resultingOutPointer.reinterpret(arena, VipsRaw::g_free);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_get_array_double(VipsImage *image, const char *name, double **out, int *n)
   * }
   */
  public void imageGetArrayDouble(MemorySegment image, String nameString, VipsOutputPointer out,
      MemorySegment n) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_array_double", "image");
    }
    var name = arena.allocateFrom(nameString);
    var outPointer = out.pointerOrNull$internal();
    if(!VipsValidation.isValidPointer(n)) {
      VipsValidation.throwInvalidInputError("vips_image_get_array_double", "n");
    }
    var result = VipsRaw_1.vips_image_get_array_double(image, name, outPointer, n);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_get_array_double");
    }
    var resultingOutPointer = outPointer.get(VipsRaw.C_POINTER, 0);
    var reinterpretedOutPointer = resultingOutPointer.reinterpret(arena, VipsRaw::g_free);
    out.setReinterpretedPointer$internal(reinterpretedOutPointer);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_image_set_array_double(VipsImage *image, const char *name, const double *array, int n)
   * }
   */
  public void imageSetArrayDouble(MemorySegment image, String nameString, MemorySegment array,
      int n) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_set_array_double", "image");
    }
    var name = arena.allocateFrom(nameString);
    if(!VipsValidation.isValidPointer(array)) {
      VipsValidation.throwInvalidInputError("vips_image_set_array_double", "array");
    }
    VipsRaw_1.vips_image_set_array_double(image, name, array, n);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_image_history_args(VipsImage *image, const char *name, int argc, char *argv[])
   * }
   */
  public void imageHistoryArgs(MemorySegment image, String nameString, int argc,
      List<String> argvStringArray) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_history_args", "image");
    }
    var name = arena.allocateFrom(nameString);
    var argv = VipsInvoker.makeCharStarArray(arena, argvStringArray);
    var result = VipsRaw_1.vips_image_history_args(image, name, argc, argv);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_image_history_args");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_image_get_history(VipsImage *image)
   * }
   */
  public String imageGetHistory(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_image_get_history", "image");
    }
    var result = VipsRaw_1.vips_image_get_history(image);
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
  public long operationGetType() throws VipsError {
    var result = VipsRaw_1.vips_operation_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsOperationFlags vips_operation_get_flags(VipsOperation *operation)
   * }
   */
  public void operationGetFlags(MemorySegment operation) throws VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_operation_get_flags", "operation");
    }
    var result = VipsRaw_1.vips_operation_get_flags(operation);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_operation_get_flags");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_operation_class_print_usage(VipsOperationClass *operation_class)
   * }
   */
  public void operationClassPrintUsage(MemorySegment operation_class) throws VipsError {
    if(!VipsValidation.isValidPointer(operation_class)) {
      VipsValidation.throwInvalidInputError("vips_operation_class_print_usage", "operation_class");
    }
    VipsRaw_1.vips_operation_class_print_usage(operation_class);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_operation_invalidate(VipsOperation *operation)
   * }
   */
  public void operationInvalidate(MemorySegment operation) throws VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_operation_invalidate", "operation");
    }
    VipsRaw_1.vips_operation_invalidate(operation);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_operation_call_valist(VipsOperation *operation, va_list ap)
   * }
   */
  public void operationCallValist(MemorySegment operation, MemorySegment ap) throws VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_operation_call_valist", "operation");
    }
    var result = VipsRaw_1.vips_operation_call_valist(operation, ap);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_operation_call_valist");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsOperation *vips_operation_new(const char *name)
   * }
   */
  public MemorySegment operationNew(String nameString) throws VipsError {
    var name = arena.allocateFrom(nameString);
    var result = VipsRaw_1.vips_operation_new(name);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_operation_new", "result");
    }
    result = result.reinterpret(arena, VipsRaw::g_object_unref);
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_call_required_optional(VipsOperation **operation, va_list required, va_list optional)
   * }
   */
  public void callRequiredOptional(MemorySegment operation, MemorySegment required,
      MemorySegment optional) throws VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_call_required_optional", "operation");
    }
    var result = VipsRaw_1.vips_call_required_optional(operation, required, optional);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_call_required_optional");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_call_options(GOptionGroup *group, VipsOperation *operation)
   * }
   */
  public void callOptions(MemorySegment group, MemorySegment operation) throws VipsError {
    if(!VipsValidation.isValidPointer(group)) {
      VipsValidation.throwInvalidInputError("vips_call_options", "group");
    }
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_call_options", "operation");
    }
    VipsRaw_1.vips_call_options(group, operation);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_call_argv(VipsOperation *operation, int argc, char **argv)
   * }
   */
  public void callArgv(MemorySegment operation, int argc, MemorySegment argv) throws VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_call_argv", "operation");
    }
    if(!VipsValidation.isValidPointer(argv)) {
      VipsValidation.throwInvalidInputError("vips_call_argv", "argv");
    }
    var result = VipsRaw_1.vips_call_argv(operation, argc, argv);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_call_argv");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_cache_drop_all()
   * }
   */
  public void cacheDropAll() throws VipsError {
    VipsRaw_1.vips_cache_drop_all();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsOperation *vips_cache_operation_lookup(VipsOperation *operation)
   * }
   */
  public MemorySegment cacheOperationLookup(MemorySegment operation) throws VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_cache_operation_lookup", "operation");
    }
    var result = VipsRaw_1.vips_cache_operation_lookup(operation);
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
  public void cacheOperationAdd(MemorySegment operation) throws VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_cache_operation_add", "operation");
    }
    VipsRaw_1.vips_cache_operation_add(operation);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cache_operation_buildp(VipsOperation **operation)
   * }
   */
  public void cacheOperationBuildp(MemorySegment operation) throws VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_cache_operation_buildp", "operation");
    }
    var result = VipsRaw_1.vips_cache_operation_buildp(operation);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cache_operation_buildp");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsOperation *vips_cache_operation_build(VipsOperation *operation)
   * }
   */
  public MemorySegment cacheOperationBuild(MemorySegment operation) throws VipsError {
    if(!VipsValidation.isValidPointer(operation)) {
      VipsValidation.throwInvalidInputError("vips_cache_operation_build", "operation");
    }
    var result = VipsRaw_1.vips_cache_operation_build(operation);
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
  public void cachePrint() throws VipsError {
    VipsRaw_1.vips_cache_print();
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_cache_set_max(int max)
   * }
   */
  public void cacheSetMax(int max) throws VipsError {
    VipsRaw_1.vips_cache_set_max(max);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_cache_set_max_mem(size_t max_mem)
   * }
   */
  public void cacheSetMaxMem(long max_mem) throws VipsError {
    VipsRaw_1.vips_cache_set_max_mem(max_mem);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cache_get_max()
   * }
   */
  public void cacheGetMax() throws VipsError {
    var result = VipsRaw_1.vips_cache_get_max();
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cache_get_max");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cache_get_size()
   * }
   */
  public void cacheGetSize() throws VipsError {
    var result = VipsRaw_1.vips_cache_get_size();
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cache_get_size");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * size_t vips_cache_get_max_mem()
   * }
   */
  public long cacheGetMaxMem() throws VipsError {
    var result = VipsRaw_1.vips_cache_get_max_mem();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_cache_get_max_files()
   * }
   */
  public void cacheGetMaxFiles() throws VipsError {
    var result = VipsRaw_1.vips_cache_get_max_files();
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_cache_get_max_files");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_cache_set_max_files(int max_files)
   * }
   */
  public void cacheSetMaxFiles(int max_files) throws VipsError {
    VipsRaw_1.vips_cache_set_max_files(max_files);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_cache_set_dump(gboolean dump)
   * }
   */
  public void cacheSetDump(boolean dumpBoolean) throws VipsError {
    var dump = dumpBoolean ? 1 : 0;
    VipsRaw_1.vips_cache_set_dump(dump);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_cache_set_trace(gboolean trace)
   * }
   */
  public void cacheSetTrace(boolean traceBoolean) throws VipsError {
    var trace = traceBoolean ? 1 : 0;
    VipsRaw_1.vips_cache_set_trace(trace);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_concurrency_set(int concurrency)
   * }
   */
  public void concurrencySet(int concurrency) throws VipsError {
    VipsRaw_1.vips_concurrency_set(concurrency);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * int vips_concurrency_get()
   * }
   */
  public void concurrencyGet() throws VipsError {
    var result = VipsRaw_1.vips_concurrency_get();
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_concurrency_get");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_operation_block_set(const char *name, gboolean state)
   * }
   */
  public void operationBlockSet(String nameString, boolean stateBoolean) throws VipsError {
    var name = arena.allocateFrom(nameString);
    var state = stateBoolean ? 1 : 0;
    VipsRaw_1.vips_operation_block_set(name, state);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_get_type()
   * }
   */
  public long foreignGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_load_get_type()
   * }
   */
  public long foreignLoadGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_load_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_foreign_find_load(const char *filename)
   * }
   */
  public String foreignFindLoad(String filenameString) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw_1.vips_foreign_find_load(filename);
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
  public String foreignFindLoadBuffer(MemorySegment data, long size) throws VipsError {
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_foreign_find_load_buffer", "data");
    }
    var result = VipsRaw_1.vips_foreign_find_load_buffer(data, size);
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
  public String foreignFindLoadSource(MemorySegment source) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_foreign_find_load_source", "source");
    }
    var result = VipsRaw_1.vips_foreign_find_load_source(source);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_foreign_find_load_source", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * VipsForeignFlags vips_foreign_flags(const char *loader, const char *filename)
   * }
   */
  public void foreignFlags(String loaderString, String filenameString) throws VipsError {
    var loader = arena.allocateFrom(loaderString);
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw_1.vips_foreign_flags(loader, filename);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_foreign_flags");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_foreign_is_a(const char *loader, const char *filename)
   * }
   */
  public boolean foreignIsA(String loaderString, String filenameString) throws VipsError {
    var loader = arena.allocateFrom(loaderString);
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw_1.vips_foreign_is_a(loader, filename);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_foreign_is_a_buffer(const char *loader, const void *data, size_t size)
   * }
   */
  public boolean foreignIsABuffer(String loaderString, MemorySegment data, long size) throws
      VipsError {
    var loader = arena.allocateFrom(loaderString);
    if(!VipsValidation.isValidPointer(data)) {
      VipsValidation.throwInvalidInputError("vips_foreign_is_a_buffer", "data");
    }
    var result = VipsRaw_1.vips_foreign_is_a_buffer(loader, data, size);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_foreign_is_a_source(const char *loader, VipsSource *source)
   * }
   */
  public boolean foreignIsASource(String loaderString, MemorySegment source) throws VipsError {
    var loader = arena.allocateFrom(loaderString);
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_foreign_is_a_source", "source");
    }
    var result = VipsRaw_1.vips_foreign_is_a_source(loader, source);
    return result == 1;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * void vips_foreign_load_invalidate(VipsImage *image)
   * }
   */
  public void foreignLoadInvalidate(MemorySegment image) throws VipsError {
    if(!VipsValidation.isValidPointer(image)) {
      VipsValidation.throwInvalidInputError("vips_foreign_load_invalidate", "image");
    }
    VipsRaw_1.vips_foreign_load_invalidate(image);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_save_get_type()
   * }
   */
  public long foreignSaveGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_save_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_foreign_find_save(const char *filename)
   * }
   */
  public String foreignFindSave(String filenameString) throws VipsError {
    var filename = arena.allocateFrom(filenameString);
    var result = VipsRaw_1.vips_foreign_find_save(filename);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_foreign_find_save", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gchar **vips_foreign_get_suffixes()
   * }
   */
  public MemorySegment foreignGetSuffixes() throws VipsError {
    var result = VipsRaw_1.vips_foreign_get_suffixes();
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_foreign_get_suffixes", "result");
    }
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * const char *vips_foreign_find_save_buffer(const char *suffix)
   * }
   */
  public String foreignFindSaveBuffer(String suffixString) throws VipsError {
    var suffix = arena.allocateFrom(suffixString);
    var result = VipsRaw_1.vips_foreign_find_save_buffer(suffix);
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
  public String foreignFindSaveTarget(String suffixString) throws VipsError {
    var suffix = arena.allocateFrom(suffixString);
    var result = VipsRaw_1.vips_foreign_find_save_target(suffix);
    if(!VipsValidation.isValidPointer(result)) {
      VipsValidation.throwInvalidOutputError("vips_foreign_find_save_target", "result");
    }
    return result.getString(0);
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_math_get_type()
   * }
   */
  public long operationMathGetType() throws VipsError {
    var result = VipsRaw_1.vips_operation_math_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_math2_get_type()
   * }
   */
  public long operationMath2GetType() throws VipsError {
    var result = VipsRaw_1.vips_operation_math2_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_round_get_type()
   * }
   */
  public long operationRoundGetType() throws VipsError {
    var result = VipsRaw_1.vips_operation_round_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_relational_get_type()
   * }
   */
  public long operationRelationalGetType() throws VipsError {
    var result = VipsRaw_1.vips_operation_relational_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_boolean_get_type()
   * }
   */
  public long operationBooleanGetType() throws VipsError {
    var result = VipsRaw_1.vips_operation_boolean_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_complex_get_type()
   * }
   */
  public long operationComplexGetType() throws VipsError {
    var result = VipsRaw_1.vips_operation_complex_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_complex2_get_type()
   * }
   */
  public long operationComplex2GetType() throws VipsError {
    var result = VipsRaw_1.vips_operation_complex2_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_operation_complexget_get_type()
   * }
   */
  public long operationComplexgetGetType() throws VipsError {
    var result = VipsRaw_1.vips_operation_complexget_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_precision_get_type()
   * }
   */
  public long precisionGetType() throws VipsError {
    var result = VipsRaw_1.vips_precision_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_intent_get_type()
   * }
   */
  public long intentGetType() throws VipsError {
    var result = VipsRaw_1.vips_intent_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_pcs_get_type()
   * }
   */
  public long pcsGetType() throws VipsError {
    var result = VipsRaw_1.vips_pcs_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_extend_get_type()
   * }
   */
  public long extendGetType() throws VipsError {
    var result = VipsRaw_1.vips_extend_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_compass_direction_get_type()
   * }
   */
  public long compassDirectionGetType() throws VipsError {
    var result = VipsRaw_1.vips_compass_direction_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_direction_get_type()
   * }
   */
  public long directionGetType() throws VipsError {
    var result = VipsRaw_1.vips_direction_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_align_get_type()
   * }
   */
  public long alignGetType() throws VipsError {
    var result = VipsRaw_1.vips_align_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_angle_get_type()
   * }
   */
  public long angleGetType() throws VipsError {
    var result = VipsRaw_1.vips_angle_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_angle45_get_type()
   * }
   */
  public long angle45GetType() throws VipsError {
    var result = VipsRaw_1.vips_angle45_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_interesting_get_type()
   * }
   */
  public long interestingGetType() throws VipsError {
    var result = VipsRaw_1.vips_interesting_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_blend_mode_get_type()
   * }
   */
  public long blendModeGetType() throws VipsError {
    var result = VipsRaw_1.vips_blend_mode_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_combine_get_type()
   * }
   */
  public long combineGetType() throws VipsError {
    var result = VipsRaw_1.vips_combine_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_text_wrap_get_type()
   * }
   */
  public long textWrapGetType() throws VipsError {
    var result = VipsRaw_1.vips_text_wrap_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_combine_mode_get_type()
   * }
   */
  public long combineModeGetType() throws VipsError {
    var result = VipsRaw_1.vips_combine_mode_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_flags_get_type()
   * }
   */
  public long foreignFlagsGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_flags_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_fail_on_get_type()
   * }
   */
  public long failOnGetType() throws VipsError {
    var result = VipsRaw_1.vips_fail_on_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_saveable_get_type()
   * }
   */
  public long saveableGetType() throws VipsError {
    var result = VipsRaw_1.vips_saveable_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_keep_get_type()
   * }
   */
  public long foreignKeepGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_keep_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_subsample_get_type()
   * }
   */
  public long foreignSubsampleGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_subsample_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_jpeg_subsample_get_type()
   * }
   */
  public long foreignJpegSubsampleGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_jpeg_subsample_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_webp_preset_get_type()
   * }
   */
  public long foreignWebpPresetGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_webp_preset_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_tiff_compression_get_type()
   * }
   */
  public long foreignTiffCompressionGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_tiff_compression_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_tiff_predictor_get_type()
   * }
   */
  public long foreignTiffPredictorGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_tiff_predictor_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_tiff_resunit_get_type()
   * }
   */
  public long foreignTiffResunitGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_tiff_resunit_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_png_filter_get_type()
   * }
   */
  public long foreignPngFilterGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_png_filter_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_ppm_format_get_type()
   * }
   */
  public long foreignPpmFormatGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_ppm_format_get_type();
    return result;
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * GType vips_foreign_dz_layout_get_type()
   * }
   */
  public long foreignDzLayoutGetType() throws VipsError {
    var result = VipsRaw_1.vips_foreign_dz_layout_get_type();
    return result;
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
    if(!VipsValidation.isValidPointer(profile)) {
      VipsValidation.throwInvalidInputError("vips_profile_load", "profile");
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
    if(!VipsValidation.isValidPointer(cases)) {
      VipsValidation.throwInvalidInputError("vips_case", "cases");
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
    if(!VipsValidation.isValidPointer(mask)) {
      VipsValidation.throwInvalidInputError("vips_labelregions", "mask");
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
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_composite", "in");
    }
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
    if(!VipsValidation.isValidPointer(tests)) {
      VipsValidation.throwInvalidInputError("vips_switch", "tests");
    }
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
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandrank", "in");
    }
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
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_bandjoin", "in");
    }
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
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_arrayjoin", "in");
    }
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
    if(!VipsValidation.isValidPointer(columns)) {
      VipsValidation.throwInvalidInputError("vips_profile", "columns");
    }
    if(!VipsValidation.isValidPointer(rows)) {
      VipsValidation.throwInvalidInputError("vips_profile", "rows");
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
    if(!VipsValidation.isValidPointer(columns)) {
      VipsValidation.throwInvalidInputError("vips_project", "columns");
    }
    if(!VipsValidation.isValidPointer(rows)) {
      VipsValidation.throwInvalidInputError("vips_project", "rows");
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
    if(!VipsValidation.isValidPointer(in)) {
      VipsValidation.throwInvalidInputError("vips_sum", "in");
    }
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
    var invoker = VipsRaw_1.vips_dzsave_target.makeInvoker(layouts);
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
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_dzsave_buffer", "buf");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_dzsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_dzsave_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_dzsave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jxlsave_target.makeInvoker(layouts);
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
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_jxlsave_buffer", "buf");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_jxlsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_jxlsave_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jxlsave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jxlload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jxlload_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jxlload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jp2ksave_target.makeInvoker(layouts);
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
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_jp2ksave_buffer", "buf");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_jp2ksave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_jp2ksave_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jp2ksave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jp2kload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jp2kload_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jp2kload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_niftisave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_niftiload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_niftiload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_heifsave_target.makeInvoker(layouts);
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
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_heifsave_buffer", "buf");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_heifsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_heifsave_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_heifsave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_heifload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_heifload_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_heifload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_svgload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_svgload_string.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_svgload_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_svgload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_pdfload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_pdfload_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_pdfload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_radsave_target.makeInvoker(layouts);
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
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_radsave_buffer", "buf");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_radsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_radsave_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_radsave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_radload_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_radload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_radload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_matload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_ppmsave_target.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_ppmsave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_ppmload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_ppmload.makeInvoker(layouts);
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
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_pngsave_buffer", "buf");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_pngsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_pngsave_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_pngsave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_pngsave_target.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_pngload_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_pngload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_pngload_source.makeInvoker(layouts);
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
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_magicksave_buffer", "buf");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_magicksave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_magicksave_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_magicksave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_magickload_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_magickload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_matrixprint.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_matrixsave_target.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_matrixsave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_matrixload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_matrixload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_csvsave_target.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_csvsave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_csvload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_csvload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_rawsave_fd.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_rawsave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_rawload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_analyzeload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_fitssave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_fitsload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_openexrload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_tiffsave_target.makeInvoker(layouts);
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
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_tiffsave_buffer", "buf");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_tiffsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_tiffsave_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_tiffsave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_tiffload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_tiffload_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_tiffload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_webpsave_mime.makeInvoker(layouts);
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
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_webpsave_buffer", "buf");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_webpsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_webpsave_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_webpsave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_webpsave_target.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_webpload_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_webpload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_webpload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jpegsave_mime.makeInvoker(layouts);
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
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_jpegsave_buffer", "buf");
    }
    if(!VipsValidation.isValidPointer(len)) {
      VipsValidation.throwInvalidInputError("vips_jpegsave_buffer", "len");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_jpegsave_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jpegsave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jpegsave_target.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jpegload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jpegload_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_jpegload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_openslideload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_openslideload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_vipssave_target.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_vipssave.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_vipsload_source.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_vipsload.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_call_split_option_string.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_call_split.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_call.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_image_history_printf.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_image_pipelinev.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_allocate_input_array.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_error_exit.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_error_system.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_error.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_array_image_newv.makeInvoker(layouts);
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
   * int vips_system(const char *cmd_format, ...)
   * }
   */
  public void system(String cmd_formatString, VipsOption... options) throws VipsError {
    var cmd_format = arena.allocateFrom(cmd_formatString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_system.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_image_write_to_target.makeInvoker(layouts);
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
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_buffer", "buf");
    }
    if(!VipsValidation.isValidPointer(size)) {
      VipsValidation.throwInvalidInputError("vips_image_write_to_buffer", "size");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_image_write_to_buffer.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_image_write_to_file.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_image_new_matrixv.makeInvoker(layouts);
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
  public MemorySegment imageNewFromSource(MemorySegment source, String option_stringString,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(source)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_source", "source");
    }
    var option_string = arena.allocateFrom(option_stringString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_image_new_from_source.makeInvoker(layouts);
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
  public MemorySegment imageNewFromBuffer(MemorySegment buf, long len, String option_stringString,
      VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_image_new_from_buffer", "buf");
    }
    var option_string = arena.allocateFrom(option_stringString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_image_new_from_buffer.makeInvoker(layouts);
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
  public MemorySegment imageNewFromFile(String nameString, VipsOption... options) throws VipsError {
    var name = arena.allocateFrom(nameString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_image_new_from_file.makeInvoker(layouts);
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
  public void targetWritef(MemorySegment target, String fmtString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(target)) {
      VipsValidation.throwInvalidInputError("vips_target_writef", "target");
    }
    var fmt = arena.allocateFrom(fmtString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_target_writef.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_value_set_save_stringf.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_array_int_newv.makeInvoker(layouts);
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
  public MemorySegment arrayDoubleNewv(int n, VipsOption... options) throws VipsError {
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_array_double_newv.makeInvoker(layouts);
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
  public void objectSet(MemorySegment object, VipsOption... options) throws VipsError {
    if(!VipsValidation.isValidPointer(object)) {
      VipsValidation.throwInvalidInputError("vips_object_set", "object");
    }
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_object_set.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_rmdirf.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_mkdirf.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_isdirf.makeInvoker(layouts);
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
    var invoker = VipsRaw_1.vips_existsf.makeInvoker(layouts);
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
  public void snprintf(String strString, long size, String formatString, VipsOption... options)
      throws VipsError {
    var str = arena.allocateFrom(strString);
    var format = arena.allocateFrom(formatString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_snprintf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(str, size, format, invokerArgs);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("vips_snprintf");
    }
  }

  /**
   * Binding for:
   * {@snippet lang=c :
   * gboolean vips_buf_appendf(VipsBuf *buf, const char *fmt, ...)
   * }
   */
  public boolean bufAppendf(MemorySegment buf, String fmtString, VipsOption... options) throws
      VipsError {
    if(!VipsValidation.isValidPointer(buf)) {
      VipsValidation.throwInvalidInputError("vips_buf_appendf", "buf");
    }
    var fmt = arena.allocateFrom(fmtString);
    var layouts = VipsInvoker.makeInvokerVarargLayouts(options);
    var invoker = VipsRaw_1.vips_buf_appendf.makeInvoker(layouts);
    var invokerArgs = VipsInvoker.makeInvokerVarargObjects(arena, options);
    var result = invoker.apply(buf, fmt, invokerArgs);
    return result == 1;
  }
}
