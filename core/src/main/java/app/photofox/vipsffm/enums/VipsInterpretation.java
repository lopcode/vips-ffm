package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>How the values in an image should be interpreted. For example, a
 * three-band float image of type {@link VipsInterpretation#INTERPRETATION_LAB} should have its
 * pixels interpreted as coordinates in CIE Lab space.</p>
 *
 * <p>RGB and sRGB are treated in the same way. Use the colourspace functions if
 * you want some other behaviour.</p>
 *
 * <p>The gaps in numbering are historical and must be maintained. Allocate
 * new numbers from the end.</p>
 */
public enum VipsInterpretation implements VNamedEnum {
  INTERPRETATION_ERROR("VIPS_INTERPRETATION_ERROR", "error", -1),

  /**
   * <p>generic many-band image</p>
   */
  INTERPRETATION_MULTIBAND("VIPS_INTERPRETATION_MULTIBAND", "multiband", 0),

  /**
   * <p>some kind of single-band image</p>
   */
  INTERPRETATION_B_W("VIPS_INTERPRETATION_B_W", "b-w", 1),

  /**
   * <p>a 1D image, eg. histogram or lookup table</p>
   */
  INTERPRETATION_HISTOGRAM("VIPS_INTERPRETATION_HISTOGRAM", "histogram", 10),

  /**
   * <p>the first three bands are CIE XYZ</p>
   */
  INTERPRETATION_XYZ("VIPS_INTERPRETATION_XYZ", "xyz", 12),

  /**
   * <p>pixels are in CIE Lab space</p>
   */
  INTERPRETATION_LAB("VIPS_INTERPRETATION_LAB", "lab", 13),

  /**
   * <p>the first four bands are in CMYK space</p>
   */
  INTERPRETATION_CMYK("VIPS_INTERPRETATION_CMYK", "cmyk", 15),

  /**
   * <p>implies {@link VipsCoding#CODING_LABQ}</p>
   */
  INTERPRETATION_LABQ("VIPS_INTERPRETATION_LABQ", "labq", 16),

  /**
   * <p>generic RGB space</p>
   */
  INTERPRETATION_RGB("VIPS_INTERPRETATION_RGB", "rgb", 17),

  /**
   * <p>a uniform colourspace based on CMC(1:1)</p>
   */
  INTERPRETATION_CMC("VIPS_INTERPRETATION_CMC", "cmc", 18),

  /**
   * <p>pixels are in CIE LCh space</p>
   */
  INTERPRETATION_LCH("VIPS_INTERPRETATION_LCH", "lch", 19),

  /**
   * <p>CIE LAB coded as three signed 16-bit values</p>
   */
  INTERPRETATION_LABS("VIPS_INTERPRETATION_LABS", "labs", 21),

  /**
   * <p>pixels are sRGB</p>
   */
  INTERPRETATION_sRGB("VIPS_INTERPRETATION_sRGB", "srgb", 22),

  /**
   * <p>pixels are CIE Yxy</p>
   */
  INTERPRETATION_YXY("VIPS_INTERPRETATION_YXY", "yxy", 23),

  /**
   * <p>image is in fourier space</p>
   */
  INTERPRETATION_FOURIER("VIPS_INTERPRETATION_FOURIER", "fourier", 24),

  /**
   * <p>generic 16-bit RGB</p>
   */
  INTERPRETATION_RGB16("VIPS_INTERPRETATION_RGB16", "rgb16", 25),

  /**
   * <p>generic 16-bit mono</p>
   */
  INTERPRETATION_GREY16("VIPS_INTERPRETATION_GREY16", "grey16", 26),

  /**
   * <p>a matrix</p>
   */
  INTERPRETATION_MATRIX("VIPS_INTERPRETATION_MATRIX", "matrix", 27),

  /**
   * <p>pixels are scRGB</p>
   */
  INTERPRETATION_scRGB("VIPS_INTERPRETATION_scRGB", "scrgb", 28),

  /**
   * <p>pixels are HSV</p>
   */
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
