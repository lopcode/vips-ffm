package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// The compression format to use inside a HEIF container.
/// 
/// This is assumed to use the same numbering as `heif_compression_format`.
public enum VipsForeignHeifCompression implements VNamedEnum {
  /// x265
  FOREIGN_HEIF_COMPRESSION_HEVC("VIPS_FOREIGN_HEIF_COMPRESSION_HEVC", "hevc", 1),

  /// x264
  FOREIGN_HEIF_COMPRESSION_AVC("VIPS_FOREIGN_HEIF_COMPRESSION_AVC", "avc", 2),

  /// jpeg
  FOREIGN_HEIF_COMPRESSION_JPEG("VIPS_FOREIGN_HEIF_COMPRESSION_JPEG", "jpeg", 3),

  /// aom
  FOREIGN_HEIF_COMPRESSION_AV1("VIPS_FOREIGN_HEIF_COMPRESSION_AV1", "av1", 4),

  FOREIGN_HEIF_COMPRESSION_LAST("VIPS_FOREIGN_HEIF_COMPRESSION_LAST", "last", 5);

  public static final String parentName = "VipsForeignHeifCompression";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsForeignHeifCompression(String vipsName, String vipsNickname, int rawValue) {
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
