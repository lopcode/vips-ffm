package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>See also: {@link VImage#boolean1}.</p>
 */
public enum VipsOperationBoolean implements VNamedEnum {
  /**
   * <p>&amp;</p>
   */
  OPERATION_BOOLEAN_AND("VIPS_OPERATION_BOOLEAN_AND", "and", 0),

  /**
   * <p>|</p>
   */
  OPERATION_BOOLEAN_OR("VIPS_OPERATION_BOOLEAN_OR", "or", 1),

  /**
   * <p>^</p>
   */
  OPERATION_BOOLEAN_EOR("VIPS_OPERATION_BOOLEAN_EOR", "eor", 2),

  /**
   * <p>&gt;&gt;</p>
   */
  OPERATION_BOOLEAN_LSHIFT("VIPS_OPERATION_BOOLEAN_LSHIFT", "lshift", 3),

  /**
   * <p>&lt;&lt;</p>
   */
  OPERATION_BOOLEAN_RSHIFT("VIPS_OPERATION_BOOLEAN_RSHIFT", "rshift", 4),

  OPERATION_BOOLEAN_LAST("VIPS_OPERATION_BOOLEAN_LAST", "last", 5);

  public static final String parentName = "VipsOperationBoolean";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsOperationBoolean(String vipsName, String vipsNickname, int rawValue) {
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
