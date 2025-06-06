package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// The SDF to generate,
///
/// See also: [VImage#sdf]
public enum VipsSdfShape implements VNamedEnum {
  /// a circle at `a`, radius `r`
  SDF_SHAPE_CIRCLE("VIPS_SDF_SHAPE_CIRCLE", "circle", 0),

  /// a box from `a` to `b`
  SDF_SHAPE_BOX("VIPS_SDF_SHAPE_BOX", "box", 1),

  /// a box with rounded `corners` from `a` to `b`
  SDF_SHAPE_ROUNDED_BOX("VIPS_SDF_SHAPE_ROUNDED_BOX", "rounded-box", 2),

  /// a line from `a` to `b`
  SDF_SHAPE_LINE("VIPS_SDF_SHAPE_LINE", "line", 3),

  SDF_SHAPE_LAST("VIPS_SDF_SHAPE_LAST", "last", 4);

  public static final String parentName = "VipsSdfShape";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsSdfShape(String vipsName, String vipsNickname, int rawValue) {
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
