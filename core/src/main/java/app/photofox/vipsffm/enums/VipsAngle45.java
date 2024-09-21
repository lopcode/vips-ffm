package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsAngle45 implements VNamedEnum {
  ANGLE45_D0("VIPS_ANGLE45_D0", "d0", 0),

  ANGLE45_D45("VIPS_ANGLE45_D45", "d45", 1),

  ANGLE45_D90("VIPS_ANGLE45_D90", "d90", 2),

  ANGLE45_D135("VIPS_ANGLE45_D135", "d135", 3),

  ANGLE45_D180("VIPS_ANGLE45_D180", "d180", 4),

  ANGLE45_D225("VIPS_ANGLE45_D225", "d225", 5),

  ANGLE45_D270("VIPS_ANGLE45_D270", "d270", 6),

  ANGLE45_D315("VIPS_ANGLE45_D315", "d315", 7),

  ANGLE45_LAST("VIPS_ANGLE45_LAST", "last", 8);

  public static final String parentName = "VipsAngle45";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsAngle45(String vipsName, String vipsNickname, int rawValue) {
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