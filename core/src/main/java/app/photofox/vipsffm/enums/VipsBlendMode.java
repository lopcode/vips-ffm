package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>The various Porter-Duff and PDF blend modes. See {@link app.photofox.vipsffm.VImage#composite},
 * for example.</p>
 *
 * <p>The Cairo docs have a nice explanation of all the blend modes:</p>
 *
 * <p>https://www.cairographics.org/operators</p>
 *
 * <p>The non-separable modes are not implemented.</p>
 */
public enum VipsBlendMode implements VNamedEnum {
  /**
   * <p>where the second object is drawn, the first is removed</p>
   */
  BLEND_MODE_CLEAR("VIPS_BLEND_MODE_CLEAR", "clear", 0),

  /**
   * <p>the second object is drawn as if nothing were below</p>
   */
  BLEND_MODE_SOURCE("VIPS_BLEND_MODE_SOURCE", "source", 1),

  /**
   * <p>the image shows what you would expect if you held two semi-transparent slides on top of each other</p>
   */
  BLEND_MODE_OVER("VIPS_BLEND_MODE_OVER", "over", 2),

  /**
   * <p>the first object is removed completely, the second is only drawn where the first was</p>
   */
  BLEND_MODE_IN("VIPS_BLEND_MODE_IN", "in", 3),

  /**
   * <p>the second is drawn only where the first isn't</p>
   */
  BLEND_MODE_OUT("VIPS_BLEND_MODE_OUT", "out", 4),

  /**
   * <p>this leaves the first object mostly intact, but mixes both objects in the overlapping area</p>
   */
  BLEND_MODE_ATOP("VIPS_BLEND_MODE_ATOP", "atop", 5),

  /**
   * <p>leaves the first object untouched, the second is discarded completely</p>
   */
  BLEND_MODE_DEST("VIPS_BLEND_MODE_DEST", "dest", 6),

  /**
   * <p>like OVER, but swaps the arguments</p>
   */
  BLEND_MODE_DEST_OVER("VIPS_BLEND_MODE_DEST_OVER", "dest-over", 7),

  /**
   * <p>like IN, but swaps the arguments</p>
   */
  BLEND_MODE_DEST_IN("VIPS_BLEND_MODE_DEST_IN", "dest-in", 8),

  /**
   * <p>like OUT, but swaps the arguments</p>
   */
  BLEND_MODE_DEST_OUT("VIPS_BLEND_MODE_DEST_OUT", "dest-out", 9),

  /**
   * <p>like ATOP, but swaps the arguments</p>
   */
  BLEND_MODE_DEST_ATOP("VIPS_BLEND_MODE_DEST_ATOP", "dest-atop", 10),

  /**
   * <p>something like a difference operator</p>
   */
  BLEND_MODE_XOR("VIPS_BLEND_MODE_XOR", "xor", 11),

  /**
   * <p>a bit like adding the two images</p>
   */
  BLEND_MODE_ADD("VIPS_BLEND_MODE_ADD", "add", 12),

  /**
   * <p>a bit like the darker of the two</p>
   */
  BLEND_MODE_SATURATE("VIPS_BLEND_MODE_SATURATE", "saturate", 13),

  /**
   * <p>at least as dark as the darker of the two inputs</p>
   */
  BLEND_MODE_MULTIPLY("VIPS_BLEND_MODE_MULTIPLY", "multiply", 14),

  /**
   * <p>at least as light as the lighter of the inputs</p>
   */
  BLEND_MODE_SCREEN("VIPS_BLEND_MODE_SCREEN", "screen", 15),

  /**
   * <p>multiplies or screens colors, depending on the lightness</p>
   */
  BLEND_MODE_OVERLAY("VIPS_BLEND_MODE_OVERLAY", "overlay", 16),

  /**
   * <p>the darker of each component</p>
   */
  BLEND_MODE_DARKEN("VIPS_BLEND_MODE_DARKEN", "darken", 17),

  /**
   * <p>the lighter of each component</p>
   */
  BLEND_MODE_LIGHTEN("VIPS_BLEND_MODE_LIGHTEN", "lighten", 18),

  /**
   * <p>brighten first by a factor second</p>
   */
  BLEND_MODE_COLOUR_DODGE("VIPS_BLEND_MODE_COLOUR_DODGE", "colour-dodge", 19),

  /**
   * <p>darken first by a factor of second</p>
   */
  BLEND_MODE_COLOUR_BURN("VIPS_BLEND_MODE_COLOUR_BURN", "colour-burn", 20),

  /**
   * <p>multiply or screen, depending on lightness</p>
   */
  BLEND_MODE_HARD_LIGHT("VIPS_BLEND_MODE_HARD_LIGHT", "hard-light", 21),

  /**
   * <p>darken or lighten, depending on lightness</p>
   */
  BLEND_MODE_SOFT_LIGHT("VIPS_BLEND_MODE_SOFT_LIGHT", "soft-light", 22),

  /**
   * <p>difference of the two</p>
   */
  BLEND_MODE_DIFFERENCE("VIPS_BLEND_MODE_DIFFERENCE", "difference", 23),

  /**
   * <p>somewhat like DIFFERENCE, but lower-contrast</p>
   */
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
