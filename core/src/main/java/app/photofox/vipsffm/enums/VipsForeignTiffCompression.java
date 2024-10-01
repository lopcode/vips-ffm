package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>The compression types supported by the tiff writer.</p>
 *
 * <p>Use {@code Q} to set the jpeg compression level, default 75.</p>
 *
 * <p>Use {@code predictor} to set the lzw or deflate prediction, default horizontal.</p>
 *
 * <p>Use {@code lossless} to set WEBP lossless compression.</p>
 *
 * <p>Use {@code level} to set webp and zstd compression level.</p>
 */
public enum VipsForeignTiffCompression implements VNamedEnum {
  /**
   * <p>no compression</p>
   */
  FOREIGN_TIFF_COMPRESSION_NONE("VIPS_FOREIGN_TIFF_COMPRESSION_NONE", "none", 0),

  /**
   * <p>jpeg compression</p>
   */
  FOREIGN_TIFF_COMPRESSION_JPEG("VIPS_FOREIGN_TIFF_COMPRESSION_JPEG", "jpeg", 1),

  /**
   * <p>deflate (zip) compression</p>
   */
  FOREIGN_TIFF_COMPRESSION_DEFLATE("VIPS_FOREIGN_TIFF_COMPRESSION_DEFLATE", "deflate", 2),

  /**
   * <p>packbits compression</p>
   */
  FOREIGN_TIFF_COMPRESSION_PACKBITS("VIPS_FOREIGN_TIFF_COMPRESSION_PACKBITS", "packbits", 3),

  /**
   * <p>fax4 compression</p>
   */
  FOREIGN_TIFF_COMPRESSION_CCITTFAX4("VIPS_FOREIGN_TIFF_COMPRESSION_CCITTFAX4", "ccittfax4", 4),

  /**
   * <p>LZW compression</p>
   */
  FOREIGN_TIFF_COMPRESSION_LZW("VIPS_FOREIGN_TIFF_COMPRESSION_LZW", "lzw", 5),

  /**
   * <p>WEBP compression</p>
   */
  FOREIGN_TIFF_COMPRESSION_WEBP("VIPS_FOREIGN_TIFF_COMPRESSION_WEBP", "webp", 6),

  /**
   * <p>ZSTD compression</p>
   */
  FOREIGN_TIFF_COMPRESSION_ZSTD("VIPS_FOREIGN_TIFF_COMPRESSION_ZSTD", "zstd", 7),

  /**
   * <p>JP2K compression</p>
   */
  FOREIGN_TIFF_COMPRESSION_JP2K("VIPS_FOREIGN_TIFF_COMPRESSION_JP2K", "jp2k", 8),

  FOREIGN_TIFF_COMPRESSION_LAST("VIPS_FOREIGN_TIFF_COMPRESSION_LAST", "last", 9);

  public static final String parentName = "VipsForeignTiffCompression";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsForeignTiffCompression(String vipsName, String vipsNickname, int rawValue) {
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
