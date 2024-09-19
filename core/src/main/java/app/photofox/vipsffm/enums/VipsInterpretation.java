package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsInterpretation implements VNamedEnum {
  INTERPRETATION_ERROR("VIPS_INTERPRETATION_ERROR", "error", -1),

  INTERPRETATION_MULTIBAND("VIPS_INTERPRETATION_MULTIBAND", "multiband", 0),

  INTERPRETATION_B_W("VIPS_INTERPRETATION_B_W", "b-w", 1),

  INTERPRETATION_HISTOGRAM("VIPS_INTERPRETATION_HISTOGRAM", "histogram", 10),

  INTERPRETATION_XYZ("VIPS_INTERPRETATION_XYZ", "xyz", 12),

  INTERPRETATION_LAB("VIPS_INTERPRETATION_LAB", "lab", 13),

  INTERPRETATION_CMYK("VIPS_INTERPRETATION_CMYK", "cmyk", 15),

  INTERPRETATION_LABQ("VIPS_INTERPRETATION_LABQ", "labq", 16),

  INTERPRETATION_RGB("VIPS_INTERPRETATION_RGB", "rgb", 17),

  INTERPRETATION_CMC("VIPS_INTERPRETATION_CMC", "cmc", 18),

  INTERPRETATION_LCH("VIPS_INTERPRETATION_LCH", "lch", 19),

  INTERPRETATION_LABS("VIPS_INTERPRETATION_LABS", "labs", 21),

  INTERPRETATION_sRGB("VIPS_INTERPRETATION_sRGB", "srgb", 22),

  INTERPRETATION_YXY("VIPS_INTERPRETATION_YXY", "yxy", 23),

  INTERPRETATION_FOURIER("VIPS_INTERPRETATION_FOURIER", "fourier", 24),

  INTERPRETATION_RGB16("VIPS_INTERPRETATION_RGB16", "rgb16", 25),

  INTERPRETATION_GREY16("VIPS_INTERPRETATION_GREY16", "grey16", 26),

  INTERPRETATION_MATRIX("VIPS_INTERPRETATION_MATRIX", "matrix", 27),

  INTERPRETATION_scRGB("VIPS_INTERPRETATION_scRGB", "scrgb", 28),

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
