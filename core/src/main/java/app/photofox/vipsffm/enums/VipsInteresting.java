package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsInteresting implements VNamedEnum {
  INTERESTING_NONE("VIPS_INTERESTING_NONE", "none", 0),

  INTERESTING_CENTRE("VIPS_INTERESTING_CENTRE", "centre", 1),

  INTERESTING_ENTROPY("VIPS_INTERESTING_ENTROPY", "entropy", 2),

  INTERESTING_ATTENTION("VIPS_INTERESTING_ATTENTION", "attention", 3),

  INTERESTING_LOW("VIPS_INTERESTING_LOW", "low", 4),

  INTERESTING_HIGH("VIPS_INTERESTING_HIGH", "high", 5),

  INTERESTING_ALL("VIPS_INTERESTING_ALL", "all", 6),

  INTERESTING_LAST("VIPS_INTERESTING_LAST", "last", 7);

  public static final String parentName = "VipsInteresting";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsInteresting(String vipsName, String vipsNickname, int rawValue) {
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
