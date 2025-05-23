package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>Controls whether an operation should upsize, downsize, both up and
 * downsize, or force a size.</p>
 *
 * <p>See also: {@link VImage#thumbnail}.</p>
 */
public enum VipsSize implements VNamedEnum {
  /**
   * <p>size both up and down</p>
   */
  SIZE_BOTH("VIPS_SIZE_BOTH", "both", 0),

  /**
   * <p>only upsize</p>
   */
  SIZE_UP("VIPS_SIZE_UP", "up", 1),

  /**
   * <p>only downsize</p>
   */
  SIZE_DOWN("VIPS_SIZE_DOWN", "down", 2),

  /**
   * <p>force size, that is, break aspect ratio</p>
   */
  SIZE_FORCE("VIPS_SIZE_FORCE", "force", 3),

  SIZE_LAST("VIPS_SIZE_LAST", "last", 4);

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
