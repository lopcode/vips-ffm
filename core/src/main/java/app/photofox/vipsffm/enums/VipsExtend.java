package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsExtend implements VNamedEnum {
  EXTEND_BLACK("VIPS_EXTEND_BLACK", "black", 0),

  EXTEND_COPY("VIPS_EXTEND_COPY", "copy", 1),

  EXTEND_REPEAT("VIPS_EXTEND_REPEAT", "repeat", 2),

  EXTEND_MIRROR("VIPS_EXTEND_MIRROR", "mirror", 3),

  EXTEND_WHITE("VIPS_EXTEND_WHITE", "white", 4),

  EXTEND_BACKGROUND("VIPS_EXTEND_BACKGROUND", "background", 5),

  EXTEND_LAST("VIPS_EXTEND_LAST", "last", 6);

  public static final String parentName = "VipsExtend";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsExtend(String vipsName, String vipsNickname, int rawValue) {
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
