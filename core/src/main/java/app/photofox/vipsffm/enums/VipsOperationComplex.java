package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// See also: [VImage#complex].
public enum VipsOperationComplex implements VNamedEnum {
  /// convert to polar coordinates
  OPERATION_COMPLEX_POLAR("VIPS_OPERATION_COMPLEX_POLAR", "polar", 0),

  /// convert to rectangular coordinates
  OPERATION_COMPLEX_RECT("VIPS_OPERATION_COMPLEX_RECT", "rect", 1),

  /// complex conjugate
  OPERATION_COMPLEX_CONJ("VIPS_OPERATION_COMPLEX_CONJ", "conj", 2);

  public static final String parentName = "VipsOperationComplex";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsOperationComplex(String vipsName, String vipsNickname, int rawValue) {
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
