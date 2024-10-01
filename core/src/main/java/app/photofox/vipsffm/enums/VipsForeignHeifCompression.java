package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>The compression format to use inside a HEIF container.</p>
 *
 * <p>This is assumed to use the same numbering as {@code heif_compression_format}.</p>
 */
public enum VipsForeignHeifCompression implements VNamedEnum {
  /**
   * <p>x265</p>
   */
  FOREIGN_HEIF_COMPRESSION_HEVC("VIPS_FOREIGN_HEIF_COMPRESSION_HEVC", "hevc", 1),

  /**
   * <p>x264</p>
   */
  FOREIGN_HEIF_COMPRESSION_AVC("VIPS_FOREIGN_HEIF_COMPRESSION_AVC", "avc", 2),

  /**
   * <p>jpeg</p>
   */
  FOREIGN_HEIF_COMPRESSION_JPEG("VIPS_FOREIGN_HEIF_COMPRESSION_JPEG", "jpeg", 3),

  /**
   * <p>aom</p>
   */
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
