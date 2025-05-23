package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/**
 * <p>The resampling kernels vips supports. See {@link VImage#reduce}, for example.</p>
 */
public enum VipsKernel implements VNamedEnum {
  /**
   * <p>The nearest pixel to the point.</p>
   */
  KERNEL_NEAREST("VIPS_KERNEL_NEAREST", "nearest", 0),

  /**
   * <p>Convolve with a triangle filter.</p>
   */
  KERNEL_LINEAR("VIPS_KERNEL_LINEAR", "linear", 1),

  /**
   * <p>Convolve with a cubic filter.</p>
   */
  KERNEL_CUBIC("VIPS_KERNEL_CUBIC", "cubic", 2),

  /**
   * <p>Convolve with a Mitchell kernel.</p>
   */
  KERNEL_MITCHELL("VIPS_KERNEL_MITCHELL", "mitchell", 3),

  /**
   * <p>Convolve with a two-lobe Lanczos kernel.</p>
   */
  KERNEL_LANCZOS2("VIPS_KERNEL_LANCZOS2", "lanczos2", 4),

  /**
   * <p>Convolve with a three-lobe Lanczos kernel.</p>
   */
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
