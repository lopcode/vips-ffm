package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsPrecision implements VNamedEnum {
  PRECISION_INTEGER("VIPS_PRECISION_INTEGER", "integer", 0),

  PRECISION_FLOAT("VIPS_PRECISION_FLOAT", "float", 1),

  PRECISION_APPROXIMATE("VIPS_PRECISION_APPROXIMATE", "approximate", 2),

  PRECISION_LAST("VIPS_PRECISION_LAST", "last", 3);

  public static final String parentName = "VipsPrecision";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsPrecision(String vipsName, String vipsNickname, int rawValue) {
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
