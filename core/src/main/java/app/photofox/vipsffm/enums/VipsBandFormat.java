package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsBandFormat implements VNamedEnum {
  FORMAT_NOTSET("VIPS_FORMAT_NOTSET", "notset", -1),

  FORMAT_UCHAR("VIPS_FORMAT_UCHAR", "uchar", 0),

  FORMAT_CHAR("VIPS_FORMAT_CHAR", "char", 1),

  FORMAT_USHORT("VIPS_FORMAT_USHORT", "ushort", 2),

  FORMAT_SHORT("VIPS_FORMAT_SHORT", "short", 3),

  FORMAT_UINT("VIPS_FORMAT_UINT", "uint", 4),

  FORMAT_INT("VIPS_FORMAT_INT", "int", 5),

  FORMAT_FLOAT("VIPS_FORMAT_FLOAT", "float", 6),

  FORMAT_COMPLEX("VIPS_FORMAT_COMPLEX", "complex", 7),

  FORMAT_DOUBLE("VIPS_FORMAT_DOUBLE", "double", 8),

  FORMAT_DPCOMPLEX("VIPS_FORMAT_DPCOMPLEX", "dpcomplex", 9),

  FORMAT_LAST("VIPS_FORMAT_LAST", "last", 10);

  public static final String parentName = "VipsBandFormat";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsBandFormat(String vipsName, String vipsNickname, int rawValue) {
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
