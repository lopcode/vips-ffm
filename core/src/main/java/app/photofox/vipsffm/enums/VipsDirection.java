package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>See {@link app.photofox.vipsffm.VImage#flip}, {@link app.photofox.vipsffm.VImage#join} and so on.</p>
 *
 * <p>Operations like {@link app.photofox.vipsffm.VImage#flip} need to be told whether to flip left-right or
 * top-bottom.</p>
 *
 * <p>See also: {@link app.photofox.vipsffm.VImage#flip}, {@link app.photofox.vipsffm.VImage#join}.</p>
 */
public enum VipsDirection implements VNamedEnum {
  /**
   * <p>left-right</p>
   */
  DIRECTION_HORIZONTAL("VIPS_DIRECTION_HORIZONTAL", "horizontal", 0),

  /**
   * <p>top-bottom</p>
   */
  DIRECTION_VERTICAL("VIPS_DIRECTION_VERTICAL", "vertical", 1),

  DIRECTION_LAST("VIPS_DIRECTION_LAST", "last", 2);

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
