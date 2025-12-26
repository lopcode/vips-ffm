package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// See [VImage#flip], [VImage#join] and so on.
///
/// Operations like [VImage#flip] need to be told whether to flip left-right or
/// top-bottom.
///
/// See also: [VImage#flip], [VImage#join]
public enum VipsDirection implements VNamedEnum {
  /// left-right
  DIRECTION_HORIZONTAL("VIPS_DIRECTION_HORIZONTAL", "horizontal", 0),

  /// top-bottom
  DIRECTION_VERTICAL("VIPS_DIRECTION_VERTICAL", "vertical", 1);

  public static final String parentName = "VipsDirection";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsDirection(String vipsName, String vipsNickname, int rawValue) {
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
