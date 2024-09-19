package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsFailOn implements VNamedEnum {
  FAIL_ON_NONE("VIPS_FAIL_ON_NONE", "none", 0),

  FAIL_ON_TRUNCATED("VIPS_FAIL_ON_TRUNCATED", "truncated", 1),

  FAIL_ON_ERROR("VIPS_FAIL_ON_ERROR", "error", 2),

  FAIL_ON_WARNING("VIPS_FAIL_ON_WARNING", "warning", 3),

  FAIL_ON_LAST("VIPS_FAIL_ON_LAST", "last", 4);

  public static final String parentName = "VipsFailOn";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsFailOn(String vipsName, String vipsNickname, int rawValue) {
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
