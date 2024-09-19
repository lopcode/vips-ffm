package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsCoding implements VNamedEnum {
  CODING_ERROR("VIPS_CODING_ERROR", "error", -1),

  CODING_NONE("VIPS_CODING_NONE", "none", 0),

  CODING_LABQ("VIPS_CODING_LABQ", "labq", 2),

  CODING_RAD("VIPS_CODING_RAD", "rad", 6),

  CODING_LAST("VIPS_CODING_LAST", "last", 7);

  public static final String parentName = "VipsCoding";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsCoding(String vipsName, String vipsNickname, int rawValue) {
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
