package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsAlign implements VNamedEnum {
  ALIGN_LOW("VIPS_ALIGN_LOW", "low", 0),

  ALIGN_CENTRE("VIPS_ALIGN_CENTRE", "centre", 1),

  ALIGN_HIGH("VIPS_ALIGN_HIGH", "high", 2),

  ALIGN_LAST("VIPS_ALIGN_LAST", "last", 3);

  public static final String parentName = "VipsAlign";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsAlign(String vipsName, String vipsNickname, int rawValue) {
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