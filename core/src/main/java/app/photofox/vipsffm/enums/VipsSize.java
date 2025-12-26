package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// Controls whether an operation should upsize, downsize, both up and
/// downsize, or force a size.
///
/// See also: [VImage#thumbnail]
public enum VipsSize implements VNamedEnum {
  /// size both up and down
  SIZE_BOTH("VIPS_SIZE_BOTH", "both", 0),

  /// only upsize
  SIZE_UP("VIPS_SIZE_UP", "up", 1),

  /// only downsize
  SIZE_DOWN("VIPS_SIZE_DOWN", "down", 2),

  /// force size, that is, break aspect ratio
  SIZE_FORCE("VIPS_SIZE_FORCE", "force", 3);

  public static final String parentName = "VipsSize";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsSize(String vipsName, String vipsNickname, int rawValue) {
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
