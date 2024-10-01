package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>See also: {@link app.photofox.vipsffm.VImage#math}.</p>
 */
public enum VipsOperationMath2 implements VNamedEnum {
  /**
   * <p>pow(left, right)</p>
   */
  OPERATION_MATH2_POW("VIPS_OPERATION_MATH2_POW", "pow", 0),

  /**
   * <p>pow(right, left)</p>
   */
  OPERATION_MATH2_WOP("VIPS_OPERATION_MATH2_WOP", "wop", 1),

  /**
   * <p>atan2(left, right)</p>
   */
  OPERATION_MATH2_ATAN2("VIPS_OPERATION_MATH2_ATAN2", "atan2", 2),

  OPERATION_MATH2_LAST("VIPS_OPERATION_MATH2_LAST", "last", 3);

  public static final String parentName = "VipsOperationMath2";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsOperationMath2(String vipsName, String vipsNickname, int rawValue) {
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
