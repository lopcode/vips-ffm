package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>See {@link VImage#embed}, {@link VImage#conv}, {@link VImage#affine} and so on.</p>
 *
 * <p>When the edges of an image are extended, you can specify
 * how you want the extension done.</p>
 *
 * <p>{@link VipsExtend#EXTEND_BLACK} --- new pixels are black, ie. all bits are zero.</p>
 *
 * <p>{@link VipsExtend#EXTEND_COPY} --- each new pixel takes the value of the nearest edge
 * pixel</p>
 *
 * <p>{@link VipsExtend#EXTEND_REPEAT} --- the image is tiled to fill the new area</p>
 *
 * <p>{@link VipsExtend#EXTEND_MIRROR} --- the image is reflected and tiled to reduce hash
 * edges</p>
 *
 * <p>{@link VipsExtend#EXTEND_WHITE} --- new pixels are white, ie. all bits are set</p>
 *
 * <p>{@link VipsExtend#EXTEND_BACKGROUND} --- colour set from the {@code background} property</p>
 *
 * <p>We have to specify the exact value of each enum member since we have to
 * keep these frozen for back compat with vips7.</p>
 *
 * <p>See also: {@link VImage#embed}.</p>
 */
public enum VipsExtend implements VNamedEnum {
  /**
   * <p>extend with black (all 0) pixels</p>
   */
  EXTEND_BLACK("VIPS_EXTEND_BLACK", "black", 0),

  /**
   * <p>copy the image edges</p>
   */
  EXTEND_COPY("VIPS_EXTEND_COPY", "copy", 1),

  /**
   * <p>repeat the whole image</p>
   */
  EXTEND_REPEAT("VIPS_EXTEND_REPEAT", "repeat", 2),

  /**
   * <p>mirror the whole image</p>
   */
  EXTEND_MIRROR("VIPS_EXTEND_MIRROR", "mirror", 3),

  /**
   * <p>extend with white (all bits set) pixels</p>
   */
  EXTEND_WHITE("VIPS_EXTEND_WHITE", "white", 4),

  /**
   * <p>extend with colour from the {@code background} property</p>
   */
  EXTEND_BACKGROUND("VIPS_EXTEND_BACKGROUND", "background", 5),

  EXTEND_LAST("VIPS_EXTEND_LAST", "last", 6);

  public static final String parentName = "VipsExtend";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsExtend(String vipsName, String vipsNickname, int rawValue) {
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
