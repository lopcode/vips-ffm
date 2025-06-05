package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// The format used for each band element.
///
/// Each corresponds to a native C type for the current machine. For example,
/// [VipsBandFormat#FORMAT_USHORT] is `unsigned short`.
public enum VipsBandFormat implements VNamedEnum {
  /// invalid setting
  FORMAT_NOTSET("VIPS_FORMAT_NOTSET", "notset", -1),

  /// unsigned char format
  FORMAT_UCHAR("VIPS_FORMAT_UCHAR", "uchar", 0),

  /// char format
  FORMAT_CHAR("VIPS_FORMAT_CHAR", "char", 1),

  /// unsigned short format
  FORMAT_USHORT("VIPS_FORMAT_USHORT", "ushort", 2),

  /// short format
  FORMAT_SHORT("VIPS_FORMAT_SHORT", "short", 3),

  /// unsigned int format
  FORMAT_UINT("VIPS_FORMAT_UINT", "uint", 4),

  /// int format
  FORMAT_INT("VIPS_FORMAT_INT", "int", 5),

  /// float format
  FORMAT_FLOAT("VIPS_FORMAT_FLOAT", "float", 6),

  /// complex (two floats) format
  FORMAT_COMPLEX("VIPS_FORMAT_COMPLEX", "complex", 7),

  /// double float format
  FORMAT_DOUBLE("VIPS_FORMAT_DOUBLE", "double", 8),

  /// double complex (two double) format
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
