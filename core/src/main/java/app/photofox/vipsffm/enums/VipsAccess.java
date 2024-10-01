package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>The type of access an operation has to supply. See {@link app.photofox.vipsffm.VImage#tilecache}
 * and {@code VipsForeign}.</p>
 *
 * <p>{@link VipsAccess#ACCESS_RANDOM} means requests can come in any order.</p>
 *
 * <p>{@link VipsAccess#ACCESS_SEQUENTIAL} means requests will be top-to-bottom, but with some
 * amount of buffering behind the read point for small non-local accesses.</p>
 */
public enum VipsAccess implements VNamedEnum {
  /**
   * <p>can read anywhere</p>
   */
  ACCESS_RANDOM("VIPS_ACCESS_RANDOM", "random", 0),

  /**
   * <p>top-to-bottom reading only, but with a small buffer</p>
   */
  ACCESS_SEQUENTIAL("VIPS_ACCESS_SEQUENTIAL", "sequential", 1),

  ACCESS_SEQUENTIAL_UNBUFFERED("VIPS_ACCESS_SEQUENTIAL_UNBUFFERED", "sequential-unbuffered", 2),

  ACCESS_LAST("VIPS_ACCESS_LAST", "last", 3);

  public static final String parentName = "VipsAccess";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsAccess(String vipsName, String vipsNickname, int rawValue) {
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
