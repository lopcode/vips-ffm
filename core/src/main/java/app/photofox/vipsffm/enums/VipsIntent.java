package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>The rendering intent. {@link VipsIntent#INTENT_ABSOLUTE} is best for
 * scientific work, {@link VipsIntent#INTENT_RELATIVE} is usually best for
 * accurate communication with other imaging libraries.</p>
 */
public enum VipsIntent implements VNamedEnum {
  /**
   * <p>perceptual rendering intent</p>
   */
  INTENT_PERCEPTUAL("VIPS_INTENT_PERCEPTUAL", "perceptual", 0),

  /**
   * <p>relative colorimetric rendering intent</p>
   */
  INTENT_RELATIVE("VIPS_INTENT_RELATIVE", "relative", 1),

  /**
   * <p>saturation rendering intent</p>
   */
  INTENT_SATURATION("VIPS_INTENT_SATURATION", "saturation", 2),

  /**
   * <p>absolute colorimetric rendering intent</p>
   */
  INTENT_ABSOLUTE("VIPS_INTENT_ABSOLUTE", "absolute", 3),

  INTENT_LAST("VIPS_INTENT_LAST", "last", 4);

  public static final String parentName = "VipsIntent";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsIntent(String vipsName, String vipsNickname, int rawValue) {
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
