package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>See also: {@link VImage#math}.</p>
 */
public enum VipsOperationMath implements VNamedEnum {
  /**
   * <p>sin(), angles in degrees</p>
   */
  OPERATION_MATH_SIN("VIPS_OPERATION_MATH_SIN", "sin", 0),

  /**
   * <p>cos(), angles in degrees</p>
   */
  OPERATION_MATH_COS("VIPS_OPERATION_MATH_COS", "cos", 1),

  /**
   * <p>tan(), angles in degrees</p>
   */
  OPERATION_MATH_TAN("VIPS_OPERATION_MATH_TAN", "tan", 2),

  /**
   * <p>asin(), angles in degrees</p>
   */
  OPERATION_MATH_ASIN("VIPS_OPERATION_MATH_ASIN", "asin", 3),

  /**
   * <p>acos(), angles in degrees</p>
   */
  OPERATION_MATH_ACOS("VIPS_OPERATION_MATH_ACOS", "acos", 4),

  /**
   * <p>atan(), angles in degrees</p>
   */
  OPERATION_MATH_ATAN("VIPS_OPERATION_MATH_ATAN", "atan", 5),

  /**
   * <p>log base e</p>
   */
  OPERATION_MATH_LOG("VIPS_OPERATION_MATH_LOG", "log", 6),

  /**
   * <p>log base 10</p>
   */
  OPERATION_MATH_LOG10("VIPS_OPERATION_MATH_LOG10", "log10", 7),

  /**
   * <p>e to the something</p>
   */
  OPERATION_MATH_EXP("VIPS_OPERATION_MATH_EXP", "exp", 8),

  /**
   * <p>10 to the something</p>
   */
  OPERATION_MATH_EXP10("VIPS_OPERATION_MATH_EXP10", "exp10", 9),

  /**
   * <p>sinh(), angles in radians</p>
   */
  OPERATION_MATH_SINH("VIPS_OPERATION_MATH_SINH", "sinh", 10),

  /**
   * <p>cosh(), angles in radians</p>
   */
  OPERATION_MATH_COSH("VIPS_OPERATION_MATH_COSH", "cosh", 11),

  /**
   * <p>tanh(), angles in radians</p>
   */
  OPERATION_MATH_TANH("VIPS_OPERATION_MATH_TANH", "tanh", 12),

  /**
   * <p>asinh(), angles in radians</p>
   */
  OPERATION_MATH_ASINH("VIPS_OPERATION_MATH_ASINH", "asinh", 13),

  /**
   * <p>acosh(), angles in radians</p>
   */
  OPERATION_MATH_ACOSH("VIPS_OPERATION_MATH_ACOSH", "acosh", 14),

  /**
   * <p>atanh(), angles in radians</p>
   */
  OPERATION_MATH_ATANH("VIPS_OPERATION_MATH_ATANH", "atanh", 15),

  OPERATION_MATH_LAST("VIPS_OPERATION_MATH_LAST", "last", 16);

  public static final String parentName = "VipsOperationMath";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsOperationMath(String vipsName, String vipsNickname, int rawValue) {
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
