package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>How to combine values. See {@link VImage#compass}, for example.</p>
 */
public enum VipsCombine implements VNamedEnum {
  /**
   * <p>take the maximum of the possible values</p>
   */
  COMBINE_MAX("VIPS_COMBINE_MAX", "max", 0),

  /**
   * <p>sum all the values</p>
   */
  COMBINE_SUM("VIPS_COMBINE_SUM", "sum", 1),

  /**
   * <p>take the minimum value</p>
   */
  COMBINE_MIN("VIPS_COMBINE_MIN", "min", 2),

  COMBINE_LAST("VIPS_COMBINE_LAST", "last", 3);

  public static final String parentName = "VipsCombine";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsCombine(String vipsName, String vipsNickname, int rawValue) {
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
