package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// See also: [VImage#complexget].
public enum VipsOperationComplexget implements VNamedEnum {
  /// get real component
  OPERATION_COMPLEXGET_REAL("VIPS_OPERATION_COMPLEXGET_REAL", "real", 0),

  /// get imaginary component
  OPERATION_COMPLEXGET_IMAG("VIPS_OPERATION_COMPLEXGET_IMAG", "imag", 1),

  OPERATION_COMPLEXGET_LAST("VIPS_OPERATION_COMPLEXGET_LAST", "last", 2);

  public static final String parentName = "VipsOperationComplexget";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsOperationComplexget(String vipsName, String vipsNickname, int rawValue) {
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
