package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>The selected encoder to use.
 * If libheif hasn't been compiled with the selected encoder,
 * we will fallback to the default encoder for the compression format.</p>
 */
public enum VipsForeignHeifEncoder implements VNamedEnum {
  /**
   * <p>auto</p>
   */
  FOREIGN_HEIF_ENCODER_AUTO("VIPS_FOREIGN_HEIF_ENCODER_AUTO", "auto", 0),

  /**
   * <p>aom</p>
   */
  FOREIGN_HEIF_ENCODER_AOM("VIPS_FOREIGN_HEIF_ENCODER_AOM", "aom", 1),

  /**
   * <p>RAV1E</p>
   */
  FOREIGN_HEIF_ENCODER_RAV1E("VIPS_FOREIGN_HEIF_ENCODER_RAV1E", "rav1e", 2),

  /**
   * <p>SVT-AV1</p>
   */
  FOREIGN_HEIF_ENCODER_SVT("VIPS_FOREIGN_HEIF_ENCODER_SVT", "svt", 3),

  /**
   * <p>x265</p>
   */
  FOREIGN_HEIF_ENCODER_X265("VIPS_FOREIGN_HEIF_ENCODER_X265", "x265", 4),

  FOREIGN_HEIF_ENCODER_LAST("VIPS_FOREIGN_HEIF_ENCODER_LAST", "last", 5);

  public static final String parentName = "VipsForeignHeifEncoder";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsForeignHeifEncoder(String vipsName, String vipsNickname, int rawValue) {
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
