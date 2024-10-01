package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>Pick the algorithm vips uses to decide image &quot;interestingness&quot;. This is used
 * by {@link app.photofox.vipsffm.VImage#smartcrop}, for example, to decide what parts of the image to
 * keep.</p>
 *
 * <p>{@link VipsInteresting#INTERESTING_NONE} and {@link VipsInteresting#INTERESTING_LOW} mean the same -- the
 * crop is positioned at the top or left. {@link VipsInteresting#INTERESTING_HIGH} positions at
 * the bottom or right.</p>
 *
 * <p>See also: {@link app.photofox.vipsffm.VImage#smartcrop}.</p>
 */
public enum VipsInteresting implements VNamedEnum {
  /**
   * <p>do nothing</p>
   */
  INTERESTING_NONE("VIPS_INTERESTING_NONE", "none", 0),

  /**
   * <p>just take the centre</p>
   */
  INTERESTING_CENTRE("VIPS_INTERESTING_CENTRE", "centre", 1),

  /**
   * <p>use an entropy measure</p>
   */
  INTERESTING_ENTROPY("VIPS_INTERESTING_ENTROPY", "entropy", 2),

  /**
   * <p>look for features likely to draw human attention</p>
   */
  INTERESTING_ATTENTION("VIPS_INTERESTING_ATTENTION", "attention", 3),

  /**
   * <p>position the crop towards the low coordinate</p>
   */
  INTERESTING_LOW("VIPS_INTERESTING_LOW", "low", 4),

  /**
   * <p>position the crop towards the high coordinate</p>
   */
  INTERESTING_HIGH("VIPS_INTERESTING_HIGH", "high", 5),

  /**
   * <p>everything is interesting</p>
   */
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
