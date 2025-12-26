package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// See [VImage#embed], [VImage#conv], [VImage#affine] and so on.
///
/// When the edges of an image are extended, you can specify
/// how you want the extension done.
///
/// [VipsExtend#EXTEND_BLACK] -- new pixels are black, ie. all bits are zero.
///
/// [VipsExtend#EXTEND_COPY] -- each new pixel takes the value of the nearest edge
/// pixel
///
/// [VipsExtend#EXTEND_REPEAT] -- the image is tiled to fill the new area
///
/// [VipsExtend#EXTEND_MIRROR] -- the image is reflected and tiled to reduce hash
/// edges
///
/// [VipsExtend#EXTEND_WHITE] -- new pixels are white, ie. all bits are set
///
/// [VipsExtend#EXTEND_BACKGROUND] -- colour set from the `background` property
///
/// We have to specify the exact value of each enum member since we have to
/// keep these frozen for back compat with vips7.
///
/// See also: [VImage#embed]
public enum VipsExtend implements VNamedEnum {
  /// extend with black (all 0) pixels
  EXTEND_BLACK("VIPS_EXTEND_BLACK", "black", 0),

  /// copy the image edges
  EXTEND_COPY("VIPS_EXTEND_COPY", "copy", 1),

  /// repeat the whole image
  EXTEND_REPEAT("VIPS_EXTEND_REPEAT", "repeat", 2),

  /// mirror the whole image
  EXTEND_MIRROR("VIPS_EXTEND_MIRROR", "mirror", 3),

  /// extend with white (all bits set) pixels
  EXTEND_WHITE("VIPS_EXTEND_WHITE", "white", 4),

  /// extend with colour from the `background` property
  EXTEND_BACKGROUND("VIPS_EXTEND_BACKGROUND", "background", 5);

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
