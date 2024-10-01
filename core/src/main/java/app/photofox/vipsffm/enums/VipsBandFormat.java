package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>The format used for each band element.</p>
 *
 * <p>Each corresponds to a native C type for the current machine. For example,
 * {@link VipsBandFormat#FORMAT_USHORT} is &lt;type&gt;unsigned short&lt;/type&gt;.</p>
 */
public enum VipsBandFormat implements VNamedEnum {
  /**
   * <p>invalid setting</p>
   */
  FORMAT_NOTSET("VIPS_FORMAT_NOTSET", "notset", -1),

  /**
   * <p>unsigned char format</p>
   */
  FORMAT_UCHAR("VIPS_FORMAT_UCHAR", "uchar", 0),

  /**
   * <p>char format</p>
   */
  FORMAT_CHAR("VIPS_FORMAT_CHAR", "char", 1),

  /**
   * <p>unsigned short format</p>
   */
  FORMAT_USHORT("VIPS_FORMAT_USHORT", "ushort", 2),

  /**
   * <p>short format</p>
   */
  FORMAT_SHORT("VIPS_FORMAT_SHORT", "short", 3),

  /**
   * <p>unsigned int format</p>
   */
  FORMAT_UINT("VIPS_FORMAT_UINT", "uint", 4),

  /**
   * <p>int format</p>
   */
  FORMAT_INT("VIPS_FORMAT_INT", "int", 5),

  /**
   * <p>float format</p>
   */
  FORMAT_FLOAT("VIPS_FORMAT_FLOAT", "float", 6),

  /**
   * <p>complex (two floats) format</p>
   */
  FORMAT_COMPLEX("VIPS_FORMAT_COMPLEX", "complex", 7),

  /**
   * <p>double float format</p>
   */
  FORMAT_DOUBLE("VIPS_FORMAT_DOUBLE", "double", 8),

  /**
   * <p>double complex (two double) format</p>
   */
  FORMAT_DPCOMPLEX("VIPS_FORMAT_DPCOMPLEX", "dpcomplex", 9),

  FORMAT_LAST("VIPS_FORMAT_LAST", "last", 10);

  public static final String parentName = "VipsBandFormat";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsBandFormat(String vipsName, String vipsNickname, int rawValue) {
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
