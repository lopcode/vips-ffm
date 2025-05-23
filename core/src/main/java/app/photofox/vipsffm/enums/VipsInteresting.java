package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// Pick the algorithm vips uses to decide image "interestingness". This is used
/// by [VImage#smartcrop], for example, to decide what parts of the image to
/// keep.
/// 
/// [VipsInteresting#INTERESTING_NONE] and [VipsInteresting#INTERESTING_LOW] mean the same -- the
/// crop is positioned at the top or left. [VipsInteresting#INTERESTING_HIGH] positions at
/// the bottom or right.
/// 
/// See also: [VImage#smartcrop]
public enum VipsInteresting implements VNamedEnum {
  /// do nothing
  INTERESTING_NONE("VIPS_INTERESTING_NONE", "none", 0),

  /// just take the centre
  INTERESTING_CENTRE("VIPS_INTERESTING_CENTRE", "centre", 1),

  /// use an entropy measure
  INTERESTING_ENTROPY("VIPS_INTERESTING_ENTROPY", "entropy", 2),

  /// look for features likely to draw human attention
  INTERESTING_ATTENTION("VIPS_INTERESTING_ATTENTION", "attention", 3),

  /// position the crop towards the low coordinate
  INTERESTING_LOW("VIPS_INTERESTING_LOW", "low", 4),

  /// position the crop towards the high coordinate
  INTERESTING_HIGH("VIPS_INTERESTING_HIGH", "high", 5),

  /// everything is interesting
  INTERESTING_ALL("VIPS_INTERESTING_ALL", "all", 6),

  INTERESTING_LAST("VIPS_INTERESTING_LAST", "last", 7);

  public static final String parentName = "VipsInteresting";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsInteresting(String vipsName, String vipsNickname, int rawValue) {
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
