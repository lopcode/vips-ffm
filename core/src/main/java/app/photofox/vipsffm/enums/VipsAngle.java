package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// See [VImage#rot] and so on.
/// 
/// Fixed rotate angles.
/// 
/// See also: [VImage#rot]
public enum VipsAngle implements VNamedEnum {
  /// no rotate
  ANGLE_D0("VIPS_ANGLE_D0", "d0", 0),

  /// 90 degrees clockwise
  ANGLE_D90("VIPS_ANGLE_D90", "d90", 1),

  /// 180 degree rotate
  ANGLE_D180("VIPS_ANGLE_D180", "d180", 2),

  /// 90 degrees anti-clockwise
  ANGLE_D270("VIPS_ANGLE_D270", "d270", 3),

  ANGLE_LAST("VIPS_ANGLE_LAST", "last", 4);

  public static final String parentName = "VipsAngle";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsAngle(String vipsName, String vipsNickname, int rawValue) {
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
