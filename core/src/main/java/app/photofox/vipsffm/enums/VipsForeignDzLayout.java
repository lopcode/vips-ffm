package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// What directory layout and metadata standard to use.
public enum VipsForeignDzLayout implements VNamedEnum {
  /// use DeepZoom directory layout
  FOREIGN_DZ_LAYOUT_DZ("VIPS_FOREIGN_DZ_LAYOUT_DZ", "dz", 0),

  /// use Zoomify directory layout
  FOREIGN_DZ_LAYOUT_ZOOMIFY("VIPS_FOREIGN_DZ_LAYOUT_ZOOMIFY", "zoomify", 1),

  /// use Google maps directory layout
  FOREIGN_DZ_LAYOUT_GOOGLE("VIPS_FOREIGN_DZ_LAYOUT_GOOGLE", "google", 2),

  /// use IIIF v2 directory layout
  FOREIGN_DZ_LAYOUT_IIIF("VIPS_FOREIGN_DZ_LAYOUT_IIIF", "iiif", 3),

  /// use IIIF v3 directory layout
  FOREIGN_DZ_LAYOUT_IIIF3("VIPS_FOREIGN_DZ_LAYOUT_IIIF3", "iiif3", 4),

  FOREIGN_DZ_LAYOUT_LAST("VIPS_FOREIGN_DZ_LAYOUT_LAST", "last", 5);

  public static final String parentName = "VipsForeignDzLayout";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsForeignDzLayout(String vipsName, String vipsNickname, int rawValue) {
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
