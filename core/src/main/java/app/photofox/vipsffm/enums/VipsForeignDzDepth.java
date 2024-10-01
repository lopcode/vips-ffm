package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>How many pyramid layers to create.</p>
 */
public enum VipsForeignDzDepth implements VNamedEnum {
  /**
   * <p>create layers down to 1x1 pixel</p>
   */
  FOREIGN_DZ_DEPTH_ONEPIXEL("VIPS_FOREIGN_DZ_DEPTH_ONEPIXEL", "onepixel", 0),

  /**
   * <p>create layers down to 1x1 tile</p>
   */
  FOREIGN_DZ_DEPTH_ONETILE("VIPS_FOREIGN_DZ_DEPTH_ONETILE", "onetile", 1),

  /**
   * <p>only create a single layer</p>
   */
  FOREIGN_DZ_DEPTH_ONE("VIPS_FOREIGN_DZ_DEPTH_ONE", "one", 2),

  FOREIGN_DZ_DEPTH_LAST("VIPS_FOREIGN_DZ_DEPTH_LAST", "last", 3);

  public static final String parentName = "VipsForeignDzDepth";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsForeignDzDepth(String vipsName, String vipsNickname, int rawValue) {
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
