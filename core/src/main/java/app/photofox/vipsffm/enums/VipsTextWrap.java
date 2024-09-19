package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsTextWrap implements VNamedEnum {
  TEXT_WRAP_WORD("VIPS_TEXT_WRAP_WORD", "word", 0),

  TEXT_WRAP_CHAR("VIPS_TEXT_WRAP_CHAR", "char", 1),

  TEXT_WRAP_WORD_CHAR("VIPS_TEXT_WRAP_WORD_CHAR", "word-char", 2),

  TEXT_WRAP_NONE("VIPS_TEXT_WRAP_NONE", "none", 3),

  TEXT_WRAP_LAST("VIPS_TEXT_WRAP_LAST", "last", 4);

  public static final String parentName = "VipsTextWrap";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsTextWrap(String vipsName, String vipsNickname, int rawValue) {
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
