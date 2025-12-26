package app.photofox.vipsffm.enums;

import app.photofox.vipsffm.VNamedEnum;
import java.lang.Override;
import java.lang.String;

/// Each page of a PDF document can contain multiple page boxes,
/// also known as boundary boxes or print marks.
///
/// Each page box defines a region of the complete page that
/// should be rendered. The default region is the crop box.
public enum VipsForeignPdfPageBox implements VNamedEnum {
  /// media box
  FOREIGN_PDF_PAGE_BOX_MEDIA("VIPS_FOREIGN_PDF_PAGE_BOX_MEDIA", "media", 0),

  /// crop box
  FOREIGN_PDF_PAGE_BOX_CROP("VIPS_FOREIGN_PDF_PAGE_BOX_CROP", "crop", 1),

  /// trim box
  FOREIGN_PDF_PAGE_BOX_TRIM("VIPS_FOREIGN_PDF_PAGE_BOX_TRIM", "trim", 2),

  /// bleed box
  FOREIGN_PDF_PAGE_BOX_BLEED("VIPS_FOREIGN_PDF_PAGE_BOX_BLEED", "bleed", 3),

  /// art box
  FOREIGN_PDF_PAGE_BOX_ART("VIPS_FOREIGN_PDF_PAGE_BOX_ART", "art", 4);

  public static final String parentName = "VipsForeignPdfPageBox";

  private final String vipsName;

  private final String vipsNickname;

  private final int rawValue;

  VipsForeignPdfPageBox(String vipsName, String vipsNickname, int rawValue) {
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
