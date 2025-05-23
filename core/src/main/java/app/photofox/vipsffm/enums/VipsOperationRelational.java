package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>See also: {@link VImage#relational}.</p>
 */
public enum VipsOperationRelational implements VNamedEnum {
  /**
   * <p>==</p>
   */
  OPERATION_RELATIONAL_EQUAL("VIPS_OPERATION_RELATIONAL_EQUAL", "equal", 0),

  /**
   * <p>!=</p>
   */
  OPERATION_RELATIONAL_NOTEQ("VIPS_OPERATION_RELATIONAL_NOTEQ", "noteq", 1),

  /**
   * <p>&lt;</p>
   */
  OPERATION_RELATIONAL_LESS("VIPS_OPERATION_RELATIONAL_LESS", "less", 2),

  /**
   * <p>&lt;=</p>
   */
  OPERATION_RELATIONAL_LESSEQ("VIPS_OPERATION_RELATIONAL_LESSEQ", "lesseq", 3),

  /**
   * <p>&gt;</p>
   */
  OPERATION_RELATIONAL_MORE("VIPS_OPERATION_RELATIONAL_MORE", "more", 4),

  /**
   * <p>&gt;=</p>
   */
  OPERATION_RELATIONAL_MOREEQ("VIPS_OPERATION_RELATIONAL_MOREEQ", "moreeq", 5),

  OPERATION_RELATIONAL_LAST("VIPS_OPERATION_RELATIONAL_LAST", "last", 6);

  public static final String parentName = "VipsOperationRelational";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsOperationRelational(String vipsName, String vipsNickname, int rawValue) {
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
