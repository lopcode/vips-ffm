package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// The rendering intent. [VipsIntent#INTENT_ABSOLUTE] is best for
/// scientific work, [VipsIntent#INTENT_RELATIVE] is usually best for
/// accurate communication with other imaging libraries.
public enum VipsIntent implements VNamedEnum {
  /// perceptual rendering intent
  INTENT_PERCEPTUAL("VIPS_INTENT_PERCEPTUAL", "perceptual", 0),

  /// relative colorimetric rendering intent
  INTENT_RELATIVE("VIPS_INTENT_RELATIVE", "relative", 1),

  /// saturation rendering intent
  INTENT_SATURATION("VIPS_INTENT_SATURATION", "saturation", 2),

  /// absolute colorimetric rendering intent
  INTENT_ABSOLUTE("VIPS_INTENT_ABSOLUTE", "absolute", 3),

  /// the rendering intent that the profile suggests
  INTENT_AUTO("VIPS_INTENT_AUTO", "auto", 32);

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
