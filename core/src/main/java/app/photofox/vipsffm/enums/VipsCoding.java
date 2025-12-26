package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// How pixels are coded.
///
/// Normally, pixels are uncoded and can be manipulated as you would expect.
/// However some file formats code pixels for compression, and sometimes it's
/// useful to be able to manipulate images in the coded format.
///
/// The gaps in the numbering are historical and must be maintained. Allocate
/// new numbers from the end.
public enum VipsCoding implements VNamedEnum {
  CODING_ERROR("VIPS_CODING_ERROR", "error", -1),

  /// pixels are not coded
  CODING_NONE("VIPS_CODING_NONE", "none", 0),

  /// pixels encode 3 float CIELAB values as 4 uchar
  CODING_LABQ("VIPS_CODING_LABQ", "labq", 2),

  /// pixels encode 3 float RGB as 4 uchar (Radiance coding)
  CODING_RAD("VIPS_CODING_RAD", "rad", 6);

  public static final String parentName = "VipsCoding";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsCoding(String vipsName, String vipsNickname, int rawValue) {
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
