package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>How to calculate the output pixels when shrinking a 2x2 region.</p>
 */
public enum VipsRegionShrink implements VNamedEnum {
  /**
   * <p>use the average</p>
   */
  REGION_SHRINK_MEAN("VIPS_REGION_SHRINK_MEAN", "mean", 0),

  /**
   * <p>use the median</p>
   */
  REGION_SHRINK_MEDIAN("VIPS_REGION_SHRINK_MEDIAN", "median", 1),

  /**
   * <p>use the mode</p>
   */
  REGION_SHRINK_MODE("VIPS_REGION_SHRINK_MODE", "mode", 2),

  /**
   * <p>use the maximum</p>
   */
  REGION_SHRINK_MAX("VIPS_REGION_SHRINK_MAX", "max", 3),

  /**
   * <p>use the minimum</p>
   */
  REGION_SHRINK_MIN("VIPS_REGION_SHRINK_MIN", "min", 4),

  /**
   * <p>use the top-left pixel</p>
   */
  REGION_SHRINK_NEAREST("VIPS_REGION_SHRINK_NEAREST", "nearest", 5),

  REGION_SHRINK_LAST("VIPS_REGION_SHRINK_LAST", "last", 6);

  public static final String parentName = "VipsRegionShrink";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsRegionShrink(String vipsName, String vipsNickname, int rawValue) {
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
