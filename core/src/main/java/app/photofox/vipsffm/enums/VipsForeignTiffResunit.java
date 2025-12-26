package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// Use inches or centimeters as the resolution unit for a tiff file.
public enum VipsForeignTiffResunit implements VNamedEnum {
  /// use centimeters
  FOREIGN_TIFF_RESUNIT_CM("VIPS_FOREIGN_TIFF_RESUNIT_CM", "cm", 0),

  /// use inches
  FOREIGN_TIFF_RESUNIT_INCH("VIPS_FOREIGN_TIFF_RESUNIT_INCH", "inch", 1);

  public static final String parentName = "VipsForeignTiffResunit";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsForeignTiffResunit(String vipsName, String vipsNickname, int rawValue) {
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
