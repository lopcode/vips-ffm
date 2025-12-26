package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// See [VImage#join] and so on.
///
/// Operations like [VImage#join] need to be told whether to align images on the
/// low or high coordinate edge, or centre.
///
/// See also: [VImage#join]
public enum VipsAlign implements VNamedEnum {
  /// align low coordinate edge
  ALIGN_LOW("VIPS_ALIGN_LOW", "low", 0),

  /// align centre
  ALIGN_CENTRE("VIPS_ALIGN_CENTRE", "centre", 1),

  /// align high coordinate edge
  ALIGN_HIGH("VIPS_ALIGN_HIGH", "high", 2);

  public static final String parentName = "VipsAlign";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsAlign(String vipsName, String vipsNickname, int rawValue) {
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
