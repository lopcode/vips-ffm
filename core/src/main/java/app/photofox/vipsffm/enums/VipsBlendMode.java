package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// The various Porter-Duff and PDF blend modes. See [VImage#composite],
/// for example.
/// 
/// The Cairo docs have [a nice explanation of all the blend
/// modes](https://www.cairographics.org/operators).
/// 
/// The non-separable modes are not implemented.
public enum VipsBlendMode implements VNamedEnum {
  /// where the second object is drawn, the first is removed
  BLEND_MODE_CLEAR("VIPS_BLEND_MODE_CLEAR", "clear", 0),

  /// the second object is drawn as if nothing were below
  BLEND_MODE_SOURCE("VIPS_BLEND_MODE_SOURCE", "source", 1),

  /// the image shows what you would expect if you held two semi-transparent slides on top of each other
  BLEND_MODE_OVER("VIPS_BLEND_MODE_OVER", "over", 2),

  /// the first object is removed completely, the second is only drawn where the first was
  BLEND_MODE_IN("VIPS_BLEND_MODE_IN", "in", 3),

  /// the second is drawn only where the first isn't
  BLEND_MODE_OUT("VIPS_BLEND_MODE_OUT", "out", 4),

  /// this leaves the first object mostly intact, but mixes both objects in the overlapping area
  BLEND_MODE_ATOP("VIPS_BLEND_MODE_ATOP", "atop", 5),

  /// leaves the first object untouched, the second is discarded completely
  BLEND_MODE_DEST("VIPS_BLEND_MODE_DEST", "dest", 6),

  /// like OVER, but swaps the arguments
  BLEND_MODE_DEST_OVER("VIPS_BLEND_MODE_DEST_OVER", "dest-over", 7),

  /// like IN, but swaps the arguments
  BLEND_MODE_DEST_IN("VIPS_BLEND_MODE_DEST_IN", "dest-in", 8),

  /// like OUT, but swaps the arguments
  BLEND_MODE_DEST_OUT("VIPS_BLEND_MODE_DEST_OUT", "dest-out", 9),

  /// like ATOP, but swaps the arguments
  BLEND_MODE_DEST_ATOP("VIPS_BLEND_MODE_DEST_ATOP", "dest-atop", 10),

  /// something like a difference operator
  BLEND_MODE_XOR("VIPS_BLEND_MODE_XOR", "xor", 11),

  /// a bit like adding the two images
  BLEND_MODE_ADD("VIPS_BLEND_MODE_ADD", "add", 12),

  /// a bit like the darker of the two
  BLEND_MODE_SATURATE("VIPS_BLEND_MODE_SATURATE", "saturate", 13),

  /// at least as dark as the darker of the two inputs
  BLEND_MODE_MULTIPLY("VIPS_BLEND_MODE_MULTIPLY", "multiply", 14),

  /// at least as light as the lighter of the inputs
  BLEND_MODE_SCREEN("VIPS_BLEND_MODE_SCREEN", "screen", 15),

  /// multiplies or screens colors, depending on the lightness
  BLEND_MODE_OVERLAY("VIPS_BLEND_MODE_OVERLAY", "overlay", 16),

  /// the darker of each component
  BLEND_MODE_DARKEN("VIPS_BLEND_MODE_DARKEN", "darken", 17),

  /// the lighter of each component
  BLEND_MODE_LIGHTEN("VIPS_BLEND_MODE_LIGHTEN", "lighten", 18),

  /// brighten first by a factor second
  BLEND_MODE_COLOUR_DODGE("VIPS_BLEND_MODE_COLOUR_DODGE", "colour-dodge", 19),

  /// darken first by a factor of second
  BLEND_MODE_COLOUR_BURN("VIPS_BLEND_MODE_COLOUR_BURN", "colour-burn", 20),

  /// multiply or screen, depending on lightness
  BLEND_MODE_HARD_LIGHT("VIPS_BLEND_MODE_HARD_LIGHT", "hard-light", 21),

  /// darken or lighten, depending on lightness
  BLEND_MODE_SOFT_LIGHT("VIPS_BLEND_MODE_SOFT_LIGHT", "soft-light", 22),

  /// difference of the two
  BLEND_MODE_DIFFERENCE("VIPS_BLEND_MODE_DIFFERENCE", "difference", 23),

  /// somewhat like DIFFERENCE, but lower-contrast
  BLEND_MODE_EXCLUSION("VIPS_BLEND_MODE_EXCLUSION", "exclusion", 24),

  BLEND_MODE_LAST("VIPS_BLEND_MODE_LAST", "last", 25);

  public static final String parentName = "VipsBlendMode";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsBlendMode(String vipsName, String vipsNickname, int rawValue) {
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
