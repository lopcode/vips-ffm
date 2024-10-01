package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>See also: {@link app.photofox.vipsffm.VImage#complex2}.</p>
 */
public enum VipsOperationComplex2 implements VNamedEnum {
  /**
   * <p>convert to polar coordinates</p>
   */
  OPERATION_COMPLEX2_CROSS_PHASE("VIPS_OPERATION_COMPLEX2_CROSS_PHASE", "cross-phase", 0),

  OPERATION_COMPLEX2_LAST("VIPS_OPERATION_COMPLEX2_LAST", "last", 1);

  public static final String parentName = "VipsOperationComplex2";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsOperationComplex2(String vipsName, String vipsNickname, int rawValue) {
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
