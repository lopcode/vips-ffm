package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>Tune lossy encoder settings for different image types.</p>
 */
public enum VipsForeignWebpPreset implements VNamedEnum {
  /**
   * <p>default preset</p>
   */
  FOREIGN_WEBP_PRESET_DEFAULT("VIPS_FOREIGN_WEBP_PRESET_DEFAULT", "default", 0),

  /**
   * <p>digital picture, like portrait, inner shot</p>
   */
  FOREIGN_WEBP_PRESET_PICTURE("VIPS_FOREIGN_WEBP_PRESET_PICTURE", "picture", 1),

  /**
   * <p>outdoor photograph, with natural lighting</p>
   */
  FOREIGN_WEBP_PRESET_PHOTO("VIPS_FOREIGN_WEBP_PRESET_PHOTO", "photo", 2),

  /**
   * <p>hand or line drawing, with high-contrast details</p>
   */
  FOREIGN_WEBP_PRESET_DRAWING("VIPS_FOREIGN_WEBP_PRESET_DRAWING", "drawing", 3),

  /**
   * <p>small-sized colorful images</p>
   */
  FOREIGN_WEBP_PRESET_ICON("VIPS_FOREIGN_WEBP_PRESET_ICON", "icon", 4),

  /**
   * <p>text-like</p>
   */
  FOREIGN_WEBP_PRESET_TEXT("VIPS_FOREIGN_WEBP_PRESET_TEXT", "text", 5),

  FOREIGN_WEBP_PRESET_LAST("VIPS_FOREIGN_WEBP_PRESET_LAST", "last", 6);

  public static final String parentName = "VipsForeignWebpPreset";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsForeignWebpPreset(String vipsName, String vipsNickname, int rawValue) {
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
