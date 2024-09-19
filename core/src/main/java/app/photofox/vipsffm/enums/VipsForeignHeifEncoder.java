package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsForeignHeifEncoder implements VNamedEnum {
  FOREIGN_HEIF_ENCODER_AUTO("VIPS_FOREIGN_HEIF_ENCODER_AUTO", "auto", 0),

  FOREIGN_HEIF_ENCODER_AOM("VIPS_FOREIGN_HEIF_ENCODER_AOM", "aom", 1),

  FOREIGN_HEIF_ENCODER_RAV1E("VIPS_FOREIGN_HEIF_ENCODER_RAV1E", "rav1e", 2),

  FOREIGN_HEIF_ENCODER_SVT("VIPS_FOREIGN_HEIF_ENCODER_SVT", "svt", 3),

  FOREIGN_HEIF_ENCODER_X265("VIPS_FOREIGN_HEIF_ENCODER_X265", "x265", 4),

  FOREIGN_HEIF_ENCODER_LAST("VIPS_FOREIGN_HEIF_ENCODER_LAST", "last", 5);

  public static final String parentName = "VipsForeignHeifEncoder";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsForeignHeifEncoder(String vipsName, String vipsNickname, int rawValue) {
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
