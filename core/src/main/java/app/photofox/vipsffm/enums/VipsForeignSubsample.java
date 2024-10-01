package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>Set subsampling mode.</p>
 */
public enum VipsForeignSubsample implements VNamedEnum {
  /**
   * <p>prevent subsampling when quality &gt;= 90</p>
   */
  FOREIGN_SUBSAMPLE_AUTO("VIPS_FOREIGN_SUBSAMPLE_AUTO", "auto", 0),

  /**
   * <p>always perform subsampling</p>
   */
  FOREIGN_SUBSAMPLE_ON("VIPS_FOREIGN_SUBSAMPLE_ON", "on", 1),

  /**
   * <p>never perform subsampling</p>
   */
  FOREIGN_SUBSAMPLE_OFF("VIPS_FOREIGN_SUBSAMPLE_OFF", "off", 2),

  FOREIGN_SUBSAMPLE_LAST("VIPS_FOREIGN_SUBSAMPLE_LAST", "last", 3);

  public static final String parentName = "VipsForeignSubsample";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsForeignSubsample(String vipsName, String vipsNickname, int rawValue) {
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
