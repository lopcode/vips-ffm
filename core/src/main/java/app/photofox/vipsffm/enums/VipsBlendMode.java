package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsBlendMode implements VNamedEnum {
  BLEND_MODE_CLEAR("VIPS_BLEND_MODE_CLEAR", "clear", 0),

  BLEND_MODE_SOURCE("VIPS_BLEND_MODE_SOURCE", "source", 1),

  BLEND_MODE_OVER("VIPS_BLEND_MODE_OVER", "over", 2),

  BLEND_MODE_IN("VIPS_BLEND_MODE_IN", "in", 3),

  BLEND_MODE_OUT("VIPS_BLEND_MODE_OUT", "out", 4),

  BLEND_MODE_ATOP("VIPS_BLEND_MODE_ATOP", "atop", 5),

  BLEND_MODE_DEST("VIPS_BLEND_MODE_DEST", "dest", 6),

  BLEND_MODE_DEST_OVER("VIPS_BLEND_MODE_DEST_OVER", "dest-over", 7),

  BLEND_MODE_DEST_IN("VIPS_BLEND_MODE_DEST_IN", "dest-in", 8),

  BLEND_MODE_DEST_OUT("VIPS_BLEND_MODE_DEST_OUT", "dest-out", 9),

  BLEND_MODE_DEST_ATOP("VIPS_BLEND_MODE_DEST_ATOP", "dest-atop", 10),

  BLEND_MODE_XOR("VIPS_BLEND_MODE_XOR", "xor", 11),

  BLEND_MODE_ADD("VIPS_BLEND_MODE_ADD", "add", 12),

  BLEND_MODE_SATURATE("VIPS_BLEND_MODE_SATURATE", "saturate", 13),

  BLEND_MODE_MULTIPLY("VIPS_BLEND_MODE_MULTIPLY", "multiply", 14),

  BLEND_MODE_SCREEN("VIPS_BLEND_MODE_SCREEN", "screen", 15),

  BLEND_MODE_OVERLAY("VIPS_BLEND_MODE_OVERLAY", "overlay", 16),

  BLEND_MODE_DARKEN("VIPS_BLEND_MODE_DARKEN", "darken", 17),

  BLEND_MODE_LIGHTEN("VIPS_BLEND_MODE_LIGHTEN", "lighten", 18),

  BLEND_MODE_COLOUR_DODGE("VIPS_BLEND_MODE_COLOUR_DODGE", "colour-dodge", 19),

  BLEND_MODE_COLOUR_BURN("VIPS_BLEND_MODE_COLOUR_BURN", "colour-burn", 20),

  BLEND_MODE_HARD_LIGHT("VIPS_BLEND_MODE_HARD_LIGHT", "hard-light", 21),

  BLEND_MODE_SOFT_LIGHT("VIPS_BLEND_MODE_SOFT_LIGHT", "soft-light", 22),

  BLEND_MODE_DIFFERENCE("VIPS_BLEND_MODE_DIFFERENCE", "difference", 23),

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
