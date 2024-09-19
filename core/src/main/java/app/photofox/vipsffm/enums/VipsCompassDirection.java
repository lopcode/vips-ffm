package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsCompassDirection implements VNamedEnum {
  COMPASS_DIRECTION_CENTRE("VIPS_COMPASS_DIRECTION_CENTRE", "centre", 0),

  COMPASS_DIRECTION_NORTH("VIPS_COMPASS_DIRECTION_NORTH", "north", 1),

  COMPASS_DIRECTION_EAST("VIPS_COMPASS_DIRECTION_EAST", "east", 2),

  COMPASS_DIRECTION_SOUTH("VIPS_COMPASS_DIRECTION_SOUTH", "south", 3),

  COMPASS_DIRECTION_WEST("VIPS_COMPASS_DIRECTION_WEST", "west", 4),

  COMPASS_DIRECTION_NORTH_EAST("VIPS_COMPASS_DIRECTION_NORTH_EAST", "north-east", 5),

  COMPASS_DIRECTION_SOUTH_EAST("VIPS_COMPASS_DIRECTION_SOUTH_EAST", "south-east", 6),

  COMPASS_DIRECTION_SOUTH_WEST("VIPS_COMPASS_DIRECTION_SOUTH_WEST", "south-west", 7),

  COMPASS_DIRECTION_NORTH_WEST("VIPS_COMPASS_DIRECTION_NORTH_WEST", "north-west", 8),

  COMPASS_DIRECTION_LAST("VIPS_COMPASS_DIRECTION_LAST", "last", 9);

  public static final String parentName = "VipsCompassDirection";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsCompassDirection(String vipsName, String vipsNickname, int rawValue) {
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
