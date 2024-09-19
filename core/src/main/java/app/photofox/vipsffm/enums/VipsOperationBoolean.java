package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsOperationBoolean implements VNamedEnum {
  OPERATION_BOOLEAN_AND("VIPS_OPERATION_BOOLEAN_AND", "and", 0),

  OPERATION_BOOLEAN_OR("VIPS_OPERATION_BOOLEAN_OR", "or", 1),

  OPERATION_BOOLEAN_EOR("VIPS_OPERATION_BOOLEAN_EOR", "eor", 2),

  OPERATION_BOOLEAN_LSHIFT("VIPS_OPERATION_BOOLEAN_LSHIFT", "lshift", 3),

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
