package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsForeignTiffPredictor implements VNamedEnum {
  FOREIGN_TIFF_PREDICTOR_NONE("VIPS_FOREIGN_TIFF_PREDICTOR_NONE", "none", 1),

  FOREIGN_TIFF_PREDICTOR_HORIZONTAL("VIPS_FOREIGN_TIFF_PREDICTOR_HORIZONTAL", "horizontal", 2),

  FOREIGN_TIFF_PREDICTOR_FLOAT("VIPS_FOREIGN_TIFF_PREDICTOR_FLOAT", "float", 3),

  FOREIGN_TIFF_PREDICTOR_LAST("VIPS_FOREIGN_TIFF_PREDICTOR_LAST", "last", 4);

  public static final String parentName = "VipsForeignTiffPredictor";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsForeignTiffPredictor(String vipsName, String vipsNickname, int rawValue) {
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
