package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// How the values in an image should be interpreted. For example, a
/// three-band float image of type [VipsInterpretation#INTERPRETATION_LAB] should have its
/// pixels interpreted as coordinates in CIE Lab space.
/// 
/// RGB and sRGB are treated in the same way. Use the colourspace functions if
/// you want some other behaviour.
/// 
/// The gaps in numbering are historical and must be maintained. Allocate
/// new numbers from the end.
public enum VipsInterpretation implements VNamedEnum {
  INTERPRETATION_ERROR("VIPS_INTERPRETATION_ERROR", "error", -1),

  /// generic many-band image
  INTERPRETATION_MULTIBAND("VIPS_INTERPRETATION_MULTIBAND", "multiband", 0),

  /// some kind of single-band image
  INTERPRETATION_B_W("VIPS_INTERPRETATION_B_W", "b-w", 1),

  /// a 1D image, eg. histogram or lookup table
  INTERPRETATION_HISTOGRAM("VIPS_INTERPRETATION_HISTOGRAM", "histogram", 10),

  /// the first three bands are CIE XYZ
  INTERPRETATION_XYZ("VIPS_INTERPRETATION_XYZ", "xyz", 12),

  /// pixels are in CIE Lab space
  INTERPRETATION_LAB("VIPS_INTERPRETATION_LAB", "lab", 13),

  /// the first four bands are in CMYK space
  INTERPRETATION_CMYK("VIPS_INTERPRETATION_CMYK", "cmyk", 15),

  /// implies [VipsCoding#CODING_LABQ]
  INTERPRETATION_LABQ("VIPS_INTERPRETATION_LABQ", "labq", 16),

  /// generic RGB space
  INTERPRETATION_RGB("VIPS_INTERPRETATION_RGB", "rgb", 17),

  /// a uniform colourspace based on CMC(1:1)
  INTERPRETATION_CMC("VIPS_INTERPRETATION_CMC", "cmc", 18),

  /// pixels are in CIE LCh space
  INTERPRETATION_LCH("VIPS_INTERPRETATION_LCH", "lch", 19),

  /// CIE LAB coded as three signed 16-bit values
  INTERPRETATION_LABS("VIPS_INTERPRETATION_LABS", "labs", 21),

  /// pixels are sRGB
  INTERPRETATION_sRGB("VIPS_INTERPRETATION_sRGB", "srgb", 22),

  /// pixels are CIE Yxy
  INTERPRETATION_YXY("VIPS_INTERPRETATION_YXY", "yxy", 23),

  /// image is in fourier space
  INTERPRETATION_FOURIER("VIPS_INTERPRETATION_FOURIER", "fourier", 24),

  /// generic 16-bit RGB
  INTERPRETATION_RGB16("VIPS_INTERPRETATION_RGB16", "rgb16", 25),

  /// generic 16-bit mono
  INTERPRETATION_GREY16("VIPS_INTERPRETATION_GREY16", "grey16", 26),

  /// a matrix
  INTERPRETATION_MATRIX("VIPS_INTERPRETATION_MATRIX", "matrix", 27),

  /// pixels are scRGB
  INTERPRETATION_scRGB("VIPS_INTERPRETATION_scRGB", "scrgb", 28),

  /// pixels are HSV
  INTERPRETATION_HSV("VIPS_INTERPRETATION_HSV", "hsv", 29),

  INTERPRETATION_LAST("VIPS_INTERPRETATION_LAST", "last", 30);

  public static final String parentName = "VipsInterpretation";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsInterpretation(String vipsName, String vipsNickname, int rawValue) {
    this.vipsName = vipsName;
    this.vipsNickname = vipsNickname;
    this.rawValue = rawValue;
  }

  @Override
  public String getName() {
    return this.vipsName;
  }

  @Override
  public String getNickname() {
    return this.vipsNickname;
  }

  @Override
  public int getRawValue() {
    return this.rawValue;
  }
}
