package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// Pick a Profile Connection Space for [VImage#iccImport] and
/// [VImage#iccExport]. LAB is usually best, XYZ can be more convenient in some
/// cases.
public enum VipsPCS implements VNamedEnum {
  /// use CIELAB D65 as the Profile Connection Space
  PCS_LAB("VIPS_PCS_LAB", "lab", 0),

  /// use XYZ as the Profile Connection Space
  PCS_XYZ("VIPS_PCS_XYZ", "xyz", 1),

  PCS_LAST("VIPS_PCS_LAST", "last", 2);

  public static final String parentName = "VipsPCS";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsPCS(String vipsName, String vipsNickname, int rawValue) {
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
