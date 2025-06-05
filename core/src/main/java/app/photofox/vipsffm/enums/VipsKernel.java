package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VImage;
import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// The resampling kernels vips supports. See [VImage#reduce], for example.
public enum VipsKernel implements VNamedEnum {
  /// The nearest pixel to the point.
  KERNEL_NEAREST("VIPS_KERNEL_NEAREST", "nearest", 0),

  /// Convolve with a triangle filter.
  KERNEL_LINEAR("VIPS_KERNEL_LINEAR", "linear", 1),

  /// Convolve with a cubic filter.
  KERNEL_CUBIC("VIPS_KERNEL_CUBIC", "cubic", 2),

  /// Convolve with a Mitchell kernel.
  KERNEL_MITCHELL("VIPS_KERNEL_MITCHELL", "mitchell", 3),

  /// Convolve with a two-lobe Lanczos kernel.
  KERNEL_LANCZOS2("VIPS_KERNEL_LANCZOS2", "lanczos2", 4),

  /// Convolve with a three-lobe Lanczos kernel.
  KERNEL_LANCZOS3("VIPS_KERNEL_LANCZOS3", "lanczos3", 5),

  /// Convolve with Magic Kernel Sharp 2013.
  KERNEL_MKS2013("VIPS_KERNEL_MKS2013", "mks2013", 6),

  /// Convolve with Magic Kernel Sharp 2021.
  KERNEL_MKS2021("VIPS_KERNEL_MKS2021", "mks2021", 7),

  KERNEL_LAST("VIPS_KERNEL_LAST", "last", 8);

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
