package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// More like hit-miss, really.
///
/// See also: [VImage#morph]
public enum VipsOperationMorphology implements VNamedEnum {
  /// true if all set
  OPERATION_MORPHOLOGY_ERODE("VIPS_OPERATION_MORPHOLOGY_ERODE", "erode", 0),

  /// true if one set
  OPERATION_MORPHOLOGY_DILATE("VIPS_OPERATION_MORPHOLOGY_DILATE", "dilate", 1),

  OPERATION_MORPHOLOGY_LAST("VIPS_OPERATION_MORPHOLOGY_LAST", "last", 2);

  public static final String parentName = "VipsOperationMorphology";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsOperationMorphology(String vipsName, String vipsNickname, int rawValue) {
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
