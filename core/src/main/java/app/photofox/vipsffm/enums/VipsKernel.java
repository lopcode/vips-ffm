package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

public enum VipsKernel implements VNamedEnum {
  KERNEL_NEAREST("VIPS_KERNEL_NEAREST", "nearest", 0),

  KERNEL_LINEAR("VIPS_KERNEL_LINEAR", "linear", 1),

  KERNEL_CUBIC("VIPS_KERNEL_CUBIC", "cubic", 2),

  KERNEL_MITCHELL("VIPS_KERNEL_MITCHELL", "mitchell", 3),

  KERNEL_LANCZOS2("VIPS_KERNEL_LANCZOS2", "lanczos2", 4),

  KERNEL_LANCZOS3("VIPS_KERNEL_LANCZOS3", "lanczos3", 5),

  KERNEL_LAST("VIPS_KERNEL_LAST", "last", 6);

  public static final String parentName = "VipsKernel";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsKernel(String vipsName, String vipsNickname, int rawValue) {
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
