package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>See also: {@link app.photofox.vipsffm.VImage#round}.</p>
 */
public enum VipsOperationRound implements VNamedEnum {
  /**
   * <p>round to nearest</p>
   */
  OPERATION_ROUND_RINT("VIPS_OPERATION_ROUND_RINT", "rint", 0),

  /**
   * <p>the smallest integral value not less than</p>
   */
  OPERATION_ROUND_CEIL("VIPS_OPERATION_ROUND_CEIL", "ceil", 1),

  /**
   * <p>largest integral value not greater than</p>
   */
  OPERATION_ROUND_FLOOR("VIPS_OPERATION_ROUND_FLOOR", "floor", 2),

  OPERATION_ROUND_LAST("VIPS_OPERATION_ROUND_LAST", "last", 3);

  public static final String parentName = "VipsOperationRound";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsOperationRound(String vipsName, String vipsNickname, int rawValue) {
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
