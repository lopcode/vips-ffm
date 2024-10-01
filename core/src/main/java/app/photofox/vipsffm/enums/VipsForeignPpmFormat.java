package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>The netpbm file format to save as.</p>
 *
 * <p>{@link VipsForeignPpmFormat#FOREIGN_PPM_FORMAT_PBM} images are single bit.</p>
 *
 * <p>{@link VipsForeignPpmFormat#FOREIGN_PPM_FORMAT_PGM} images are 8, 16, or 32-bits, one band.</p>
 *
 * <p>{@link VipsForeignPpmFormat#FOREIGN_PPM_FORMAT_PPM} images are 8, 16, or 32-bits, three bands.</p>
 *
 * <p>{@link VipsForeignPpmFormat#FOREIGN_PPM_FORMAT_PFM} images are 32-bit float pixels.</p>
 *
 * <p>{@link VipsForeignPpmFormat#FOREIGN_PPM_FORMAT_PNM} images are anymap images -- the image format
 * is used to pick the saver.</p>
 */
public enum VipsForeignPpmFormat implements VNamedEnum {
  /**
   * <p>portable bitmap</p>
   */
  FOREIGN_PPM_FORMAT_PBM("VIPS_FOREIGN_PPM_FORMAT_PBM", "pbm", 0),

  /**
   * <p>portable greymap</p>
   */
  FOREIGN_PPM_FORMAT_PGM("VIPS_FOREIGN_PPM_FORMAT_PGM", "pgm", 1),

  /**
   * <p>portable pixmap</p>
   */
  FOREIGN_PPM_FORMAT_PPM("VIPS_FOREIGN_PPM_FORMAT_PPM", "ppm", 2),

  /**
   * <p>portable float map</p>
   */
  FOREIGN_PPM_FORMAT_PFM("VIPS_FOREIGN_PPM_FORMAT_PFM", "pfm", 3),

  /**
   * <p>portable anymap</p>
   */
  FOREIGN_PPM_FORMAT_PNM("VIPS_FOREIGN_PPM_FORMAT_PNM", "pnm", 4),

  FOREIGN_PPM_FORMAT_LAST("VIPS_FOREIGN_PPM_FORMAT_LAST", "last", 5);

  public static final String parentName = "VipsForeignPpmFormat";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsForeignPpmFormat(String vipsName, String vipsNickname, int rawValue) {
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
