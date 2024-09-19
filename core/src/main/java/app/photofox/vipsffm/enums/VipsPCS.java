package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsPCS implements VNamedEnum {
  PCS_LAB("VIPS_PCS_LAB", "lab", 0),

  PCS_XYZ("VIPS_PCS_XYZ", "xyz", 1),

  PCS_LAST("VIPS_PCS_LAST", "last", 2);

  public static final String parentName = "VipsPCS";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsPCS(String vipsName, String vipsNickname, int rawValue) {
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
