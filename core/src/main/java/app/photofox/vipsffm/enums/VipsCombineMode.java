package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsCombineMode implements VNamedEnum {
  COMBINE_MODE_SET("VIPS_COMBINE_MODE_SET", "set", 0),

  COMBINE_MODE_ADD("VIPS_COMBINE_MODE_ADD", "add", 1),

  COMBINE_MODE_LAST("VIPS_COMBINE_MODE_LAST", "last", 2);

  public static final String parentName = "VipsCombineMode";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsCombineMode(String vipsName, String vipsNickname, int rawValue) {
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
