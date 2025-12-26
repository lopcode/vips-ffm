package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// Set subsampling mode.
public enum VipsForeignSubsample implements VNamedEnum {
  /// prevent subsampling when quality >= 90
  FOREIGN_SUBSAMPLE_AUTO("VIPS_FOREIGN_SUBSAMPLE_AUTO", "auto", 0),

  /// always perform subsampling
  FOREIGN_SUBSAMPLE_ON("VIPS_FOREIGN_SUBSAMPLE_ON", "on", 1),

  /// never perform subsampling
  FOREIGN_SUBSAMPLE_OFF("VIPS_FOREIGN_SUBSAMPLE_OFF", "off", 2);

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
