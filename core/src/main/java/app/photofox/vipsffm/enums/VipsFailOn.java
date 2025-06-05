package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// How sensitive loaders are to errors, from never stop (very insensitive), to
/// stop on the smallest warning (very sensitive).
///
/// Each one implies the ones before it, so [VipsFailOn#FAIL_ON_ERROR] implies
/// [VipsFailOn#FAIL_ON_TRUNCATED].
public enum VipsFailOn implements VNamedEnum {
  /// never stop
  FAIL_ON_NONE("VIPS_FAIL_ON_NONE", "none", 0),

  /// stop on image truncated, nothing else
  FAIL_ON_TRUNCATED("VIPS_FAIL_ON_TRUNCATED", "truncated", 1),

  /// stop on serious error or truncation
  FAIL_ON_ERROR("VIPS_FAIL_ON_ERROR", "error", 2),

  /// stop on anything, even warnings
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
