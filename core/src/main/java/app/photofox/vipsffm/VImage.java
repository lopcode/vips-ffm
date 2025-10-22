package app.photofox.vipsffm;

import app.photofox.vipsffm.enums.VipsAccess;
import app.photofox.vipsffm.enums.VipsAlign;
import app.photofox.vipsffm.enums.VipsAngle;
import app.photofox.vipsffm.enums.VipsAngle45;
import app.photofox.vipsffm.enums.VipsBandFormat;
import app.photofox.vipsffm.enums.VipsBlendMode;
import app.photofox.vipsffm.enums.VipsCoding;
import app.photofox.vipsffm.enums.VipsCombine;
import app.photofox.vipsffm.enums.VipsCombineMode;
import app.photofox.vipsffm.enums.VipsCompassDirection;
import app.photofox.vipsffm.enums.VipsDirection;
import app.photofox.vipsffm.enums.VipsExtend;
import app.photofox.vipsffm.enums.VipsFailOn;
import app.photofox.vipsffm.enums.VipsForeignDzContainer;
import app.photofox.vipsffm.enums.VipsForeignDzDepth;
import app.photofox.vipsffm.enums.VipsForeignDzLayout;
import app.photofox.vipsffm.enums.VipsForeignHeifCompression;
import app.photofox.vipsffm.enums.VipsForeignHeifEncoder;
import app.photofox.vipsffm.enums.VipsForeignPpmFormat;
import app.photofox.vipsffm.enums.VipsForeignSubsample;
import app.photofox.vipsffm.enums.VipsForeignTiffCompression;
import app.photofox.vipsffm.enums.VipsForeignTiffPredictor;
import app.photofox.vipsffm.enums.VipsForeignTiffResunit;
import app.photofox.vipsffm.enums.VipsForeignWebpPreset;
import app.photofox.vipsffm.enums.VipsIntent;
import app.photofox.vipsffm.enums.VipsInteresting;
import app.photofox.vipsffm.enums.VipsInterpretation;
import app.photofox.vipsffm.enums.VipsKernel;
import app.photofox.vipsffm.enums.VipsOperationBoolean;
import app.photofox.vipsffm.enums.VipsOperationComplex;
import app.photofox.vipsffm.enums.VipsOperationComplex2;
import app.photofox.vipsffm.enums.VipsOperationComplexget;
import app.photofox.vipsffm.enums.VipsOperationMath;
import app.photofox.vipsffm.enums.VipsOperationMath2;
import app.photofox.vipsffm.enums.VipsOperationMorphology;
import app.photofox.vipsffm.enums.VipsOperationRelational;
import app.photofox.vipsffm.enums.VipsOperationRound;
import app.photofox.vipsffm.enums.VipsPCS;
import app.photofox.vipsffm.enums.VipsPrecision;
import app.photofox.vipsffm.enums.VipsRegionShrink;
import app.photofox.vipsffm.enums.VipsSdfShape;
import app.photofox.vipsffm.enums.VipsSize;
import app.photofox.vipsffm.enums.VipsTextWrap;
import app.photofox.vipsffm.jextract.VipsImageMapFn;
import app.photofox.vipsffm.jextract.VipsRaw;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/// A generated wrapper representing a VipsImage. Do not edit.
/// [libvips api docs](https://www.libvips.org/API/current/api-index-full.html)
public final class VImage {
  private final Arena arena;

  final MemorySegment address;

  VImage(Arena arena, MemorySegment address) throws VipsError {
    if (!VipsValidation.isValidPointer(address)) {
      throw new VipsError("invalid pointer used for creation");
    }
    this.arena = arena;
    this.address = address;
  }

  @Override
  public int hashCode() {
    return Objects.hash(arena, address);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof VImage vImage)) return false;
    return Objects.equals(arena, vImage.arena) && Objects.equals(address, vImage.address);
  }

  /// Gets the raw [MemorySegment] (C pointer) for this VipsImage struct
  ///
  /// The memory address' lifetime is bound to the scope of the [#arena]
  ///
  /// Usage of the memory address is strongly discouraged, but it is available if some functionality is missing and you need to use it with [VipsHelper]
  public MemorySegment getUnsafeStructAddress() {
    return this.address;
  }

  /// Turn LCh to CMC.
  ///
  /// See also: [VImage#LCh2CMC]
  /// @param args Array of VipsOption to apply to this operation
  public VImage CMC2LCh(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "CMC2LCh", callArgs);
    return outOption.valueOrThrow();
  }

  /// Turn CMYK to XYZ. If the image has an embedded ICC profile this will be
  /// used for the conversion. If there is no embedded profile, a generic
  /// fallback profile will be used.
  ///
  /// Conversion is to D65 XYZ with relative intent. If you need more control
  /// over the process, use [VImage#iccImport] instead.
  /// @param args Array of VipsOption to apply to this operation
  public VImage CMYK2XYZ(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "CMYK2XYZ", callArgs);
    return outOption.valueOrThrow();
  }

  /// Convert HSV to sRGB.
  ///
  /// HSV is a crude polar coordinate system for RGB images. It is provided for
  /// compatibility with other image processing systems. See [VImage#Lab2LCh] for a
  /// much better colour space.
  ///
  /// See also: [VImage#sRGB2HSV]
  /// @param args Array of VipsOption to apply to this operation
  public VImage HSV2sRGB(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "HSV2sRGB", callArgs);
    return outOption.valueOrThrow();
  }

  /// Turn LCh to CMC.
  ///
  /// The CMC colourspace is described in "Uniform Colour Space Based on the
  /// CMC(l:c) Colour-difference Formula", M R Luo and B Rigg, Journal of the
  /// Society of Dyers and Colourists, vol 102, 1986. Distances in this
  /// colourspace approximate, within 10% or so, differences in the CMC(l:c)
  /// colour difference formula.
  ///
  /// This operation generates CMC(1:1). For CMC(2:1), halve Lucs and double
  /// Cucs.
  ///
  /// See also: [VImage#CMC2LCh]
  /// @param args Array of VipsOption to apply to this operation
  public VImage LCh2CMC(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LCh2CMC", callArgs);
    return outOption.valueOrThrow();
  }

  /// Turn LCh to Lab.
  /// @param args Array of VipsOption to apply to this operation
  public VImage LCh2Lab(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LCh2Lab", callArgs);
    return outOption.valueOrThrow();
  }

  /// Turn Lab to LCh.
  /// @param args Array of VipsOption to apply to this operation
  public VImage Lab2LCh(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "Lab2LCh", callArgs);
    return outOption.valueOrThrow();
  }

  /// Convert a Lab three-band float image to LabQ ([VipsCoding#CODING_LABQ]).
  ///
  /// See also: [VImage#LabQ2Lab]
  /// @param args Array of VipsOption to apply to this operation
  public VImage Lab2LabQ(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "Lab2LabQ", callArgs);
    return outOption.valueOrThrow();
  }

  /// Turn Lab to LabS, signed 16-bit int fixed point.
  ///
  /// See also: [VImage#LabQ2Lab]
  /// @param args Array of VipsOption to apply to this operation
  public VImage Lab2LabS(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "Lab2LabS", callArgs);
    return outOption.valueOrThrow();
  }

  /// Turn Lab to XYZ. The colour temperature defaults to D65, but can be
  /// specified with `temp`.
  ///
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg temp [VipsOption.ArrayDouble] Color temperature
  public VImage Lab2XYZ(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "Lab2XYZ", callArgs);
    return outOption.valueOrThrow();
  }

  /// Unpack a LabQ ([VipsCoding#CODING_LABQ]) image to a three-band float image.
  ///
  /// See also: [VImage#LabQ2Lab], [VImage#LabQ2LabS], [VImage#rad2float]
  /// @param args Array of VipsOption to apply to this operation
  public VImage LabQ2Lab(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LabQ2Lab", callArgs);
    return outOption.valueOrThrow();
  }

  /// Unpack a LabQ ([VipsCoding#CODING_LABQ]) image to a three-band short image.
  ///
  /// See also: [VImage#LabS2LabQ], [VImage#LabQ2LabS], [VImage#rad2float]
  /// @param args Array of VipsOption to apply to this operation
  public VImage LabQ2LabS(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LabQ2LabS", callArgs);
    return outOption.valueOrThrow();
  }

  /// Unpack a LabQ ([VipsCoding#CODING_LABQ]) image to a three-band short image.
  ///
  /// See also: [VImage#LabS2LabQ], [VImage#LabQ2sRGB], [VImage#rad2float]
  /// @param args Array of VipsOption to apply to this operation
  public VImage LabQ2sRGB(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LabQ2sRGB", callArgs);
    return outOption.valueOrThrow();
  }

  /// Convert a LabS three-band signed short image to a three-band float image.
  ///
  /// See also: [VImage#LabS2Lab]
  /// @param args Array of VipsOption to apply to this operation
  public VImage LabS2Lab(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LabS2Lab", callArgs);
    return outOption.valueOrThrow();
  }

  /// Convert a LabS three-band signed short image to LabQ
  ///
  /// See also: [VImage#LabQ2LabS]
  /// @param args Array of VipsOption to apply to this operation
  public VImage LabS2LabQ(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LabS2LabQ", callArgs);
    return outOption.valueOrThrow();
  }

  /// Turn XYZ to CMYK.
  ///
  /// Conversion is from D65 XYZ with relative intent. If you need more control
  /// over the process, use [VImage#iccExport] instead.
  /// @param args Array of VipsOption to apply to this operation
  public VImage XYZ2CMYK(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "XYZ2CMYK", callArgs);
    return outOption.valueOrThrow();
  }

  /// Turn XYZ to Lab, optionally specifying the colour temperature. `temp`
  /// defaults to D65.
  ///
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg temp [VipsOption.ArrayDouble] Colour temperature
  public VImage XYZ2Lab(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "XYZ2Lab", callArgs);
    return outOption.valueOrThrow();
  }

  /// Turn XYZ to Yxy.
  /// @param args Array of VipsOption to apply to this operation
  public VImage XYZ2Yxy(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "XYZ2Yxy", callArgs);
    return outOption.valueOrThrow();
  }

  /// Turn XYZ to scRGB.
  /// @param args Array of VipsOption to apply to this operation
  public VImage XYZ2scRGB(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "XYZ2scRGB", callArgs);
    return outOption.valueOrThrow();
  }

  /// Turn XYZ to Yxy.
  /// @param args Array of VipsOption to apply to this operation
  public VImage Yxy2XYZ(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "Yxy2XYZ", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation finds the absolute value of an image. It does a copy for
  /// unsigned integer types, negate for negative values in
  /// signed integer types, [`fabs()`](man:fabs(3)) for
  /// float types, and calculates modulus for complex
  /// types.
  ///
  /// See also: [VImage#sign]
  /// @param args Array of VipsOption to apply to this operation
  public VImage abs(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "abs", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation calculates `in1` + `in2` and writes the result to `out`.
  ///
  /// If the images differ in size, the smaller image is enlarged to match the
  /// larger by adding zero pixels along the bottom and right.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The two input images are cast up to the smallest common format (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)), then the
  /// following table is used to determine the output type:
  ///
  /// ## [VImage#add] type promotion
  ///
  /// | input type     | output type    |
  /// |----------------|----------------|
  /// | uchar          | ushort         |
  /// | char           | short          |
  /// | ushort         | uint           |
  /// | short          | int            |
  /// | uint           | uint           |
  /// | int            | int            |
  /// | float          | float          |
  /// | double         | double         |
  /// | complex        | complex        |
  /// | double complex | double complex |
  ///
  /// In other words, the output type is just large enough to hold the whole
  /// range of possible values.
  ///
  /// See also: [VImage#subtract], [VImage#linear]
  /// @param right Right-hand image argument
  /// @param args Array of VipsOption to apply to this operation
  public VImage add(VImage right, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "add", callArgs);
    return outOption.valueOrThrow();
  }

  /// Append an alpha channel.
  ///
  /// See also: `Image.hasalpha`
  /// @param args Array of VipsOption to apply to this operation
  public VImage addalpha(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "addalpha", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operator performs an affine transform on an image using `interpolate`.
  ///
  /// The transform is:
  ///
  /// ```
  /// X = `a` * (x + `idx`) + `b` * (y + `idy`) + `odx`
  /// Y = `c` * (x + `idx`) + `d` * (y + `idy`) + `doy`
  /// ```
  ///
  /// where:
  ///
  /// ```
  /// x and y are the coordinates in input image.
  /// X and Y are the coordinates in output image.
  /// (0,0) is the upper left corner.
  /// ```
  ///
  /// The section of the output space defined by `oarea` is written to
  /// `out`. `oarea` is a four-element int array of left, top, width, height.
  /// By default `oarea` is just large enough to cover the whole of the
  /// transformed input image.
  ///
  /// By default, new pixels are filled with `background`. This defaults to
  /// zero (black). You can set other extend types with `extend`.
  /// [VipsExtend#EXTEND_COPY] is better for image upsizing.
  ///
  /// `interpolate` defaults to bilinear.
  ///
  /// `idx`, `idy`, `odx`, `ody` default to zero.
  ///
  /// Image are normally treated as unpremultiplied, so this operation can be
  /// used directly on PNG images. If your images have been through
  /// [VImage#premultiply], set `premultiplied`.
  ///
  /// This operation does not change xres or yres. The image resolution needs to
  /// be updated by the application.
  ///
  /// See also: [VImage#shrink], [VImage#resize], `Interpolate`
  /// @param matrix Transformation matrix
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg interpolate [VipsOption.Interpolate] Interpolate pixels with this
  /// @optionalArg oarea [VipsOption.ArrayInt] Area of output to generate
  /// @optionalArg odx [VipsOption.Double] Horizontal output displacement
  /// @optionalArg ody [VipsOption.Double] Vertical output displacement
  /// @optionalArg idx [VipsOption.Double] Horizontal input displacement
  /// @optionalArg idy [VipsOption.Double] Vertical input displacement
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg premultiplied [VipsOption.Boolean] Images have premultiplied alpha
  /// @optionalArg extend [VipsOption.Enum] [VipsExtend] How to generate the extra pixels
  public VImage affine(List<Double> matrix, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var matrixOption = VipsOption.ArrayDouble("matrix", matrix);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(matrixOption);
    VipsInvoker.invokeOperation(arena, "affine", callArgs);
    return outOption.valueOrThrow();
  }

  /// Load an Analyze 6.0 file. If `filename` is "fred.img", this will look for
  /// an image header called "fred.hdr" and pixel data in "fred.img". You can
  /// also load "fred" or "fred.hdr".
  ///
  /// Images are
  /// loaded lazilly and byte-swapped, if necessary. The Analyze metadata is read
  /// and attached.
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage analyzeload(Arena arena, String filename, VipsOption... args) throws
      VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "analyzeload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Lay out the images in `in` in a grid. The grid is `across` images across and
  /// however high is necessary to use up all of `in`. Images are set down
  /// left-to-right and top-to-bottom. `across` defaults to `n`.
  ///
  /// Each input image is placed with a box of size `hspacing` by `vspacing`
  /// pixels and cropped. These default to the largest width and largest height
  /// of the input images.
  ///
  /// Space between images is filled with `background`. This defaults to 0
  /// (black).
  ///
  /// Images are positioned within their `hspacing` by `vspacing` box at low,
  /// centre or high coordinate values, controlled by `halign` and `valign`. These
  /// default to left-top.
  ///
  /// Boxes are joined and separated by `shim` pixels. This defaults to 0.
  ///
  /// If the number of bands in the input images differs, all but one of the
  /// images must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the n-band images are operated upon.
  ///
  /// The input images are cast up to the smallest common type (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)).
  ///
  /// [VImage#colourspace] can be useful for moving the images to a common
  /// colourspace for compositing.
  ///
  /// See also: [VImage#join], [VImage#insert], [VImage#colourspace]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param in Array of input images
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg across [VipsOption.Int] Number of images across grid
  /// @optionalArg shim [VipsOption.Int] Pixels between images
  /// @optionalArg background [VipsOption.ArrayDouble] Colour for new pixels
  /// @optionalArg halign [VipsOption.Enum] [VipsAlign] Align on the left, centre or right
  /// @optionalArg valign [VipsOption.Enum] [VipsAlign] Align on the top, centre or bottom
  /// @optionalArg hspacing [VipsOption.Int] Horizontal spacing between images
  /// @optionalArg vspacing [VipsOption.Int] Vertical spacing between images
  public static VImage arrayjoin(Arena arena, List<VImage> in, VipsOption... args) throws
      VipsError {
    var inOption = VipsOption.ArrayImage("in", in);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "arrayjoin", callArgs);
    return outOption.valueOrThrow();
  }

  /// Look at the image metadata and rotate and flip the image to make it
  /// upright. The `META_ORIENTATION` tag is removed from `out` to prevent
  /// accidental double rotation.
  ///
  /// Read `angle` to find the amount the image was rotated by. Read `flip` to
  /// see if the image was also flipped.
  ///
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg angle [VipsOption.Enum] [VipsAngle] Angle image was rotated by
  /// @optionalArg flip [VipsOption.Boolean] Whether the image was flipped or not
  public VImage autorot(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "autorot", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation finds the average value in an image. It operates on all
  /// bands of the input image: use [VImage#stats] if you need to calculate an
  /// average for each band. For complex images, return the average modulus.
  ///
  /// See also: [VImage#stats], [VImage#bandmean], [VImage#deviate], [VImage#rank]
  /// @param args Array of VipsOption to apply to this operation
  public double avg(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Double("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "avg", callArgs);
    return outOption.valueOrThrow();
  }

  /// Perform various boolean operations across the bands of an image. For
  /// example, a three-band uchar image operated on with
  /// [VipsOperationBoolean#OPERATION_BOOLEAN_AND] will produce a one-band uchar image where each
  /// pixel is the bitwise and of the band elements of the corresponding pixel in
  /// the input image.
  ///
  /// The output image is the same format as the input image for integer
  /// types. Float types are cast to int before processing. Complex types are not
  /// supported.
  ///
  /// The output image always has one band.
  ///
  /// This operation is useful in conjunction with [VImage#relational]. You can use
  /// it to see if all image bands match exactly.
  ///
  /// See also: [VImage#booleanConst]
  /// @param boolean1 [VipsOperationBoolean] Boolean to perform
  /// @param args Array of VipsOption to apply to this operation
  public VImage bandbool(VipsOperationBoolean boolean1, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var boolean1Option = VipsOption.Enum("boolean", boolean1);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(boolean1Option);
    VipsInvoker.invokeOperation(arena, "bandbool", callArgs);
    return outOption.valueOrThrow();
  }

  /// Fold up an image horizontally: width is collapsed into bands.
  /// Use `factor` to set how much to fold by: `factor` 3, for example, will make
  /// the output image three times narrower than the input, and with three times
  /// as many bands. By default the whole of the input width is folded up.
  ///
  /// See also: [VImage#csvload], [VImage#bandunfold]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg factor [VipsOption.Int] Fold by this factor
  public VImage bandfold(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "bandfold", callArgs);
    return outOption.valueOrThrow();
  }

  /// Join a set of images together, bandwise.
  ///
  /// If the images
  /// have n and m bands, then the output image will have n + m
  /// bands, with the first n coming from the first image and the last m
  /// from the second.
  ///
  /// If the images differ in size, the smaller images are enlarged to match the
  /// larger by adding zero pixels along the bottom and right.
  ///
  /// The input images are cast up to the smallest common type (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)).
  ///
  /// See also: [VImage#insert]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param in Array of input images
  /// @param args Array of VipsOption to apply to this operation
  public static VImage bandjoin(Arena arena, List<VImage> in, VipsOption... args) throws VipsError {
    var inOption = VipsOption.ArrayImage("in", in);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "bandjoin", callArgs);
    return outOption.valueOrThrow();
  }

  /// Append a set of constant bands to an image.
  ///
  /// See also: [VImage#bandjoin]
  /// @param c Array of constants to add
  /// @param args Array of VipsOption to apply to this operation
  public VImage bandjoinConst(List<Double> c, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var cOption = VipsOption.ArrayDouble("c", c);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(cOption);
    VipsInvoker.invokeOperation(arena, "bandjoin_const", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation writes a one-band image where each pixel is the average of
  /// the bands for that pixel in the input image. The output band format is
  /// the same as the input band format. Integer types use round-to-nearest
  /// averaging.
  ///
  /// See also: [VImage#add], [VImage#avg], [VImage#recomb]
  /// @param args Array of VipsOption to apply to this operation
  public VImage bandmean(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "bandmean", callArgs);
    return outOption.valueOrThrow();
  }

  /// Sorts the images `in` band-element-wise, then outputs an
  /// image in which each band element is selected from the sorted list by the
  /// `index` parameter. For example, if `index`
  /// is zero, then each output band element will be the minimum of all the
  /// corresponding input band elements.
  ///
  /// By default, `index` is -1, meaning pick the median value.
  ///
  /// It works for any uncoded, non-complex image type. Images are cast up to the
  /// smallest common-format.
  ///
  /// Any image can have either 1 band or n bands, where n is the same for all
  /// the non-1-band images. Single band images are then effectively copied to
  /// make n-band images.
  ///
  /// Smaller input images are expanded by adding black pixels.
  ///
  /// See also: [VImage#rank]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param in Array of input images
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg index [VipsOption.Int] Select this band element from sorted list
  public static VImage bandrank(Arena arena, List<VImage> in, VipsOption... args) throws VipsError {
    var inOption = VipsOption.ArrayImage("in", in);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "bandrank", callArgs);
    return outOption.valueOrThrow();
  }

  /// Unfold image bands into x axis.
  /// Use `factor` to set how much to unfold by: `factor` 3, for example, will make
  /// the output image three times wider than the input, and with one third
  /// as many bands. By default, all bands are unfolded.
  ///
  /// See also: [VImage#csvload], [VImage#bandfold]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg factor [VipsOption.Int] Unfold by this factor
  public VImage bandunfold(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "bandunfold", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make a black unsigned char image of a specified size.
  ///
  /// See also: [VImage#xyz], [VImage#text], [VImage#gaussnoise]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg bands [VipsOption.Int] Number of bands in image
  public static VImage black(Arena arena, int width, int height, VipsOption... args) throws
      VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "black", callArgs);
    return outOption.valueOrThrow();
  }

  /// Perform various boolean operations on pairs of images.
  ///
  /// The output image is the same format as the upcast input images for integer
  /// types. Float types are cast to int before processing. Complex types are not
  /// supported.
  ///
  /// If the images differ in size, the smaller image is enlarged to match the
  /// larger by adding zero pixels along the bottom and right.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The two input images are cast up to the smallest common format (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)).
  ///
  /// See also: [VImage#booleanConst]
  /// @param right Right-hand image argument
  /// @param boolean1 [VipsOperationBoolean] Boolean to perform
  /// @param args Array of VipsOption to apply to this operation
  public VImage boolean1(VImage right, VipsOperationBoolean boolean1, VipsOption... args) throws
      VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var boolean1Option = VipsOption.Enum("boolean", boolean1);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    callArgs.add(boolean1Option);
    VipsInvoker.invokeOperation(arena, "boolean", callArgs);
    return outOption.valueOrThrow();
  }

  /// Perform various boolean operations on an image against an array of
  /// constants.
  ///
  /// The output type is always uchar, with 0 for `FALSE` and 255 for `TRUE`.
  ///
  /// If the array of constants has just one element, that constant is used for
  /// all image bands. If the array has more than one element and they have
  /// the same number of elements as there are bands in the image, then
  /// one array element is used for each band. If the arrays have more than one
  /// element and the image only has a single band, the result is a many-band
  /// image where each band corresponds to one array element.
  ///
  /// See also: [VImage#boolean1], `Image.boolean_const1`
  /// @param boolean1 [VipsOperationBoolean] Boolean to perform
  /// @param c Array of constants
  /// @param args Array of VipsOption to apply to this operation
  public VImage booleanConst(VipsOperationBoolean boolean1, List<Double> c, VipsOption... args)
      throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var boolean1Option = VipsOption.Enum("boolean", boolean1);
    var cOption = VipsOption.ArrayDouble("c", c);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(boolean1Option);
    callArgs.add(cOption);
    VipsInvoker.invokeOperation(arena, "boolean_const", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation builds a lookup table from a set of points. Intermediate
  /// values are generated by piecewise linear interpolation. The lookup table is
  /// always of type [VipsBandFormat#FORMAT_DOUBLE], use [VImage#cast] to
  /// change it to the type you need.
  ///
  /// For example, consider this 2 x 2 matrix of (x, y) coordinates:
  ///
  /// ```
  /// 2 2
  /// 0   0
  /// 255 100
  /// ```
  ///
  /// We then generate a 1 x 256 element LUT like this:
  ///
  /// | Index | Value |
  /// |-------|-------|
  /// | 0     | 0     |
  /// | 1     | 0.4   |
  /// | etc.  | 0.4   |
  /// | 255   | 100   |
  ///
  /// This is then written as the output image, with the left column giving the
  /// index in the image to place the value.
  ///
  /// The (x, y) points don't need to be sorted: we do that. You can have
  /// several Ys, each becomes a band in the output LUT. You don't need to
  /// start at zero, any integer will do, including negatives.
  ///
  /// See also: [VImage#identity], [VImage#invertlut], [VImage#cast], [VImage#maplut]
  /// @param args Array of VipsOption to apply to this operation
  public VImage buildlut(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "buildlut", callArgs);
    return outOption.valueOrThrow();
  }

  /// Swap the byte order in an image.
  ///
  /// See also: [VImage#rawload]
  /// @param args Array of VipsOption to apply to this operation
  public VImage byteswap(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "byteswap", callArgs);
    return outOption.valueOrThrow();
  }

  /// Find edges by Canny's method: The maximum of the derivative of the gradient
  /// in the direction of the gradient. Output is float, except for uchar input,
  /// where output is uchar, and double input, where output is double. Non-complex
  /// images only.
  ///
  /// Use `sigma` to control the scale over which gradient is measured. 1.4 is
  /// usually a good value.
  ///
  /// Use `precision` to set the precision of edge detection. For uchar images,
  /// setting this to [VipsPrecision#PRECISION_INTEGER] will make edge detection much
  /// faster, but sacrifice some sensitivity.
  ///
  /// You will probably need to process the output further to eliminate weak
  /// edges.
  ///
  /// See also: [VImage#sobel]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg sigma [VipsOption.Double] Sigma of Gaussian
  /// @optionalArg precision [VipsOption.Enum] [VipsPrecision] Convolve with this precision
  public VImage canny(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "canny", callArgs);
    return outOption.valueOrThrow();
  }

  /// Use values in `index` to select pixels from `cases`.
  ///
  /// `index` must have one band. `cases` can have up to 256 elements. Values in
  /// `index` greater than or equal to `n` use the final image in `cases`. The
  /// images in `cases` must have either one band or the same number of bands.
  /// The output image is the same size as `index`. Images in `cases` are
  /// expanded to the smallest common format and number of bands.
  ///
  /// Combine this with [VImage#switch1] to make something like a case
  /// statement or a multi-way [VImage#ifthenelse].
  ///
  /// See also: [VImage#maplut], [VImage#switch1], [VImage#ifthenelse]
  /// @param cases Array of case images
  /// @param args Array of VipsOption to apply to this operation
  public VImage case1(List<VImage> cases, VipsOption... args) throws VipsError {
    var indexOption = VipsOption.Image("index", this);
    var casesOption = VipsOption.ArrayImage("cases", cases);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(indexOption);
    callArgs.add(casesOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "case", callArgs);
    return outOption.valueOrThrow();
  }

  /// Convert `in` to `format`. You can convert between any pair of formats.
  /// Floats are truncated (not rounded). Out of range values are clipped.
  ///
  /// Casting from complex to real returns the real part.
  ///
  /// If `shift` is `TRUE`, integer values are shifted up and down. For example,
  /// casting from unsigned 8 bit to unsigned 16 bit would
  /// shift every value left by 8 bits. The bottom bit is copied into the new
  /// bits, so 255 would become 65535.
  ///
  /// See also: [VImage#scale], [VImage#complexform], `Image.real`, `Image.imag`, `Image.cast_uchar`, [VImage#msb]
  /// @param format [VipsBandFormat] Format to cast to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg shift [VipsOption.Boolean] Shift integer values up and down
  public VImage cast(VipsBandFormat format, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var formatOption = VipsOption.Enum("format", format);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(formatOption);
    VipsInvoker.invokeOperation(arena, "cast", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation clamps pixel values to a range, by default 0 - 1.
  ///
  /// Use `min` and `max` to change the range.
  ///
  /// See also: [VImage#sign], [VImage#abs], [VImage#sdf]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg min [VipsOption.Double] Minimum value
  /// @optionalArg max [VipsOption.Double] Maximum value
  public VImage clamp(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "clamp", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation looks at the interpretation field of `in` (or uses
  /// `source_space`, if set) and runs
  /// a set of colourspace conversion functions to move it to `space`.
  ///
  /// For example, given an image tagged as [VipsInterpretation#INTERPRETATION_YXY], running
  /// [VImage#colourspace] with `space` set to
  /// [VipsInterpretation#INTERPRETATION_LAB] will convert with [VImage#Yxy2XYZ]
  /// and [VImage#XYZ2Lab].
  ///
  /// See also: `Image.colourspace_issupported`, `Image.guess_interpretation`
  /// @param space [VipsInterpretation] Destination color space
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg source-space [VipsOption.Enum] [VipsInterpretation] Source color space
  public VImage colourspace(VipsInterpretation space, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var spaceOption = VipsOption.Enum("space", space);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(spaceOption);
    VipsInvoker.invokeOperation(arena, "colourspace", callArgs);
    return outOption.valueOrThrow();
  }

  /// This convolves `in` with `mask` `times` times, rotating `mask` by `angle`
  /// each time. By default, it comvolves twice, rotating by 90 degrees, taking
  /// the maximum result.
  ///
  /// See also: [VImage#conv]
  /// @param mask Input matrix image
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg times [VipsOption.Int] Rotate and convolve this many times
  /// @optionalArg angle [VipsOption.Enum] [VipsAngle45] Rotate mask by this much between convolutions
  /// @optionalArg combine [VipsOption.Enum] [VipsCombine] Combine convolution results like this
  /// @optionalArg precision [VipsOption.Enum] [VipsPrecision] Convolve with this precision
  /// @optionalArg layers [VipsOption.Int] Use this many layers in approximation
  /// @optionalArg cluster [VipsOption.Int] Cluster lines closer than this in approximation
  public VImage compass(VImage mask, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", mask);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "compass", callArgs);
    return outOption.valueOrThrow();
  }

  /// Perform various operations on complex images.
  ///
  /// Angles are expressed in degrees. The output type is complex unless the
  /// input is double or dpcomplex, in which case the output is dpcomplex.
  /// @param cmplx [VipsOperationComplex] Complex to perform
  /// @param args Array of VipsOption to apply to this operation
  public VImage complex(VipsOperationComplex cmplx, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var cmplxOption = VipsOption.Enum("cmplx", cmplx);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(cmplxOption);
    VipsInvoker.invokeOperation(arena, "complex", callArgs);
    return outOption.valueOrThrow();
  }

  /// Perform various binary operations on complex images.
  ///
  /// Angles are expressed in degrees. The output type is complex unless the
  /// input is double or dpcomplex, in which case the output is dpcomplex.
  /// @param right Right-hand image argument
  /// @param cmplx [VipsOperationComplex2] Binary complex operation to perform
  /// @param args Array of VipsOption to apply to this operation
  public VImage complex2(VImage right, VipsOperationComplex2 cmplx, VipsOption... args) throws
      VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var cmplxOption = VipsOption.Enum("cmplx", cmplx);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    callArgs.add(cmplxOption);
    VipsInvoker.invokeOperation(arena, "complex2", callArgs);
    return outOption.valueOrThrow();
  }

  /// Compose two real images to make a complex image. If either `left` or `right`
  /// are [VipsBandFormat#FORMAT_DOUBLE], `out` is [VipsBandFormat#FORMAT_DPCOMPLEX]. Otherwise `out`
  /// is [VipsBandFormat#FORMAT_COMPLEX]. `left` becomes the real component of `out` and
  /// `right` the imaginary.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// See also: [VImage#complexget]
  /// @param right Right-hand image argument
  /// @param args Array of VipsOption to apply to this operation
  public VImage complexform(VImage right, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "complexform", callArgs);
    return outOption.valueOrThrow();
  }

  /// Get components of complex images.
  ///
  /// The output type is the same as the input type, except [VipsBandFormat#FORMAT_COMPLEX]
  /// becomes [VipsBandFormat#FORMAT_FLOAT] and [VipsBandFormat#FORMAT_DPCOMPLEX] becomes
  /// [VipsBandFormat#FORMAT_DOUBLE].
  /// @param get [VipsOperationComplexget] Complex to perform
  /// @param args Array of VipsOption to apply to this operation
  public VImage complexget(VipsOperationComplexget get, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var getOption = VipsOption.Enum("get", get);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(getOption);
    VipsInvoker.invokeOperation(arena, "complexget", callArgs);
    return outOption.valueOrThrow();
  }

  /// Composite an array of images together.
  ///
  /// Images are placed in a stack, with `in`[0] at the bottom and `in`[@n - 1] at
  /// the top. Pixels are blended together working from the bottom upwards, with
  /// the blend mode at each step being set by the corresponding [VipsBlendMode]
  /// in `mode`.
  ///
  /// Images are transformed to a compositing space before processing. This is
  /// [VipsInterpretation#INTERPRETATION_sRGB], `Vips.Interpretation.B_W`,
  /// [VipsInterpretation#INTERPRETATION_RGB16], or [VipsInterpretation#INTERPRETATION_GREY16]
  /// by default, depending on
  /// how many bands and bits the input images have. You can select any other
  /// space, such as [VipsInterpretation#INTERPRETATION_LAB] or
  /// [VipsInterpretation#INTERPRETATION_scRGB].
  ///
  /// The output image is in the compositing space. It will always be
  /// [VipsBandFormat#FORMAT_FLOAT] unless one of the inputs is
  /// [VipsBandFormat#FORMAT_DOUBLE], in which case the output will be double
  /// as well.
  ///
  /// Complex images are not supported.
  ///
  /// The output image will always have an alpha band. A solid alpha is
  /// added to any input missing an alpha.
  ///
  /// The images do not need to match in size or format. The output image is
  /// always the size of `in`[0], with other images being
  /// positioned with the `x` and `y` parameters and clipped
  /// against that rectangle.
  ///
  /// Image are normally treated as unpremultiplied, so this operation can be used
  /// directly on PNG images. If your images have been through
  /// [VImage#premultiply], set `premultiplied`.
  ///
  /// See also: [VImage#insert]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param in Array of input images
  /// @param mode Array of VipsBlendMode to join with
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg x [VipsOption.ArrayInt] Array of x coordinates to join at
  /// @optionalArg y [VipsOption.ArrayInt] Array of y coordinates to join at
  /// @optionalArg compositing-space [VipsOption.Enum] [VipsInterpretation] Composite images in this colour space
  /// @optionalArg premultiplied [VipsOption.Boolean] Images have premultiplied alpha
  public static VImage composite(Arena arena, List<VImage> in, List<Integer> mode,
      VipsOption... args) throws VipsError {
    var inOption = VipsOption.ArrayImage("in", in);
    var outOption = VipsOption.Image("out");
    var modeOption = VipsOption.ArrayInt("mode", mode);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(modeOption);
    VipsInvoker.invokeOperation(arena, "composite", callArgs);
    return outOption.valueOrThrow();
  }

  /// Composite `overlay` on top of `base` with `mode`. See [VImage#composite].
  ///
  /// @param overlay Overlay image
  /// @param mode [VipsBlendMode] VipsBlendMode to join with
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg x [VipsOption.Int] X position of overlay
  /// @optionalArg y [VipsOption.Int] Y position of overlay
  /// @optionalArg compositing-space [VipsOption.Enum] [VipsInterpretation] Composite images in this colour space
  /// @optionalArg premultiplied [VipsOption.Boolean] Images have premultiplied alpha
  public VImage composite2(VImage overlay, VipsBlendMode mode, VipsOption... args) throws
      VipsError {
    var baseOption = VipsOption.Image("base", this);
    var overlayOption = VipsOption.Image("overlay", overlay);
    var outOption = VipsOption.Image("out");
    var modeOption = VipsOption.Enum("mode", mode);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(baseOption);
    callArgs.add(overlayOption);
    callArgs.add(outOption);
    callArgs.add(modeOption);
    VipsInvoker.invokeOperation(arena, "composite2", callArgs);
    return outOption.valueOrThrow();
  }

  /// Perform a convolution of `in` with `mask`.
  ///
  /// Each output pixel is calculated as:
  ///
  /// ```
  /// sigma[i]{pixel[i] * mask[i]} / scale + offset
  /// ```
  ///
  /// where scale and offset are part of `mask`.
  ///
  /// By default, `precision` is
  /// [VipsPrecision#PRECISION_FLOAT]. The output image
  /// is always [VipsBandFormat#FORMAT_FLOAT] unless `in` is
  /// [VipsBandFormat#FORMAT_DOUBLE], in which case `out` is also
  /// [VipsBandFormat#FORMAT_DOUBLE].
  ///
  /// If `precision` is [VipsPrecision#PRECISION_INTEGER], then elements of `mask`
  /// are converted to integers before convolution, using `rint()`,
  /// and the output image always has the same [VipsBandFormat] as the input
  /// image.
  ///
  /// For [VipsBandFormat#FORMAT_UCHAR] images and [VipsPrecision#PRECISION_INTEGER]
  /// `precision`, [VImage#conv] uses a fast vector path based on
  /// half-float arithmetic. This can produce slightly different results.
  /// Disable the vector path with `--vips-novector` or `VIPS_NOVECTOR` or
  /// `vector_set_enabled`.
  ///
  /// If `precision` is [VipsPrecision#PRECISION_APPROXIMATE] then, like
  /// [VipsPrecision#PRECISION_INTEGER], `mask` is converted to int before
  /// convolution, and the output image
  /// always has the same [VipsBandFormat] as the input image.
  ///
  /// Larger values for `layers` give more accurate
  /// results, but are slower. As `layers` approaches the mask radius, the
  /// accuracy will become close to exact convolution and the speed will drop to
  /// match. For many large masks, such as Gaussian, `n_layers` need be only 10% of
  /// this value and accuracy will still be good.
  ///
  /// Smaller values of `cluster` will give more accurate results, but be slower
  /// and use more memory. 10% of the mask radius is a good rule of thumb.
  ///
  /// See also: [VImage#convsep]
  /// @param mask Input matrix image
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg precision [VipsOption.Enum] [VipsPrecision] Convolve with this precision
  /// @optionalArg layers [VipsOption.Int] Use this many layers in approximation
  /// @optionalArg cluster [VipsOption.Int] Cluster lines closer than this in approximation
  public VImage conv(VImage mask, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", mask);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "conv", callArgs);
    return outOption.valueOrThrow();
  }

  /// Perform an approximate integer convolution of `in` with `mask`.
  /// This is a low-level operation, see [VImage#conv] for something more
  /// convenient.
  ///
  /// The output image
  /// always has the same [VipsBandFormat] as the input image.
  /// Elements of `mask` are converted to
  /// integers before convolution.
  ///
  /// Larger values for `layers` give more accurate
  /// results, but are slower. As `layers` approaches the mask radius, the
  /// accuracy will become close to exact convolution and the speed will drop to
  /// match. For many large masks, such as Gaussian, `layers` need be only 10% of
  /// this value and accuracy will still be good.
  ///
  /// Smaller values of `cluster` will give more accurate results, but be slower
  /// and use more memory. 10% of the mask radius is a good rule of thumb.
  ///
  /// See also: [VImage#conv]
  /// @param mask Input matrix image
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg layers [VipsOption.Int] Use this many layers in approximation
  /// @optionalArg cluster [VipsOption.Int] Cluster lines closer than this in approximation
  public VImage conva(VImage mask, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", mask);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "conva", callArgs);
    return outOption.valueOrThrow();
  }

  /// Approximate separable integer convolution. This is a low-level operation, see
  /// [VImage#convsep] for something more convenient.
  ///
  /// The image is convolved twice: once with `mask` and then again with `mask`
  /// rotated by 90 degrees.
  /// `mask` must be 1xn or nx1 elements.
  /// Elements of `mask` are converted to
  /// integers before convolution.
  ///
  /// Larger values for `layers` give more accurate
  /// results, but are slower. As `layers` approaches the mask radius, the
  /// accuracy will become close to exact convolution and the speed will drop to
  /// match. For many large masks, such as Gaussian, `layers` need be only 10% of
  /// this value and accuracy will still be good.
  ///
  /// The output image
  /// always has the same [VipsBandFormat] as the input image.
  ///
  /// See also: [VImage#convsep]
  /// @param mask Input matrix image
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg layers [VipsOption.Int] Use this many layers in approximation
  public VImage convasep(VImage mask, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", mask);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "convasep", callArgs);
    return outOption.valueOrThrow();
  }

  /// Convolution. This is a low-level operation, see [VImage#conv] for something
  /// more convenient.
  ///
  /// Perform a convolution of `in` with `mask`.
  /// Each output pixel is
  /// calculated as sigma[i]{pixel[i] * mask[i]} / scale + offset, where scale
  /// and offset are part of `mask`.
  ///
  /// The convolution is performed with floating-point arithmetic. The output image
  /// is always [VipsBandFormat#FORMAT_FLOAT] unless `in` is [VipsBandFormat#FORMAT_DOUBLE], in which case
  /// `out` is also [VImage#FORMAT_DOUBLE].
  ///
  /// See also: [VipsBandFormat#conv]
  /// @param mask Input matrix image
  /// @param args Array of VipsOption to apply to this operation
  public VImage convf(VImage mask, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", mask);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "convf", callArgs);
    return outOption.valueOrThrow();
  }

  /// Integer convolution. This is a low-level operation, see [VImage#conv] for
  /// something more convenient.
  ///
  /// `mask` is converted to an integer mask with `rint()` of each element, rint of
  /// scale and rint of offset. Each output pixel is then calculated as
  ///
  /// ```
  /// sigma[i]{pixel[i] * mask[i]} / scale + offset
  /// ```
  ///
  /// The output image always has the same [VipsBandFormat] as the input image.
  ///
  /// For [VipsBandFormat#FORMAT_UCHAR] images, [VImage#convi] uses a fast vector path based on
  /// half-float arithmetic. This can produce slightly different results.
  /// Disable the vector path with `--vips-novector` or `VIPS_NOVECTOR` or
  /// `vector_set_enabled`.
  ///
  /// See also: [VImage#conv]
  /// @param mask Input matrix image
  /// @param args Array of VipsOption to apply to this operation
  public VImage convi(VImage mask, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", mask);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "convi", callArgs);
    return outOption.valueOrThrow();
  }

  /// Perform a separable convolution of `in` with `mask`.
  /// See [VImage#conv] for a detailed description.
  ///
  /// The mask must be 1xn or nx1 elements.
  ///
  /// The image is convolved twice: once with `mask` and then again with `mask`
  /// rotated by 90 degrees. This is much faster for certain types of mask
  /// (gaussian blur, for example) than doing a full 2D convolution.
  ///
  /// See also: [VImage#conv], [VImage#gaussmat]
  /// @param mask Input matrix image
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg precision [VipsOption.Enum] [VipsPrecision] Convolve with this precision
  /// @optionalArg layers [VipsOption.Int] Use this many layers in approximation
  /// @optionalArg cluster [VipsOption.Int] Cluster lines closer than this in approximation
  public VImage convsep(VImage mask, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", mask);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "convsep", callArgs);
    return outOption.valueOrThrow();
  }

  /// Copy an image, optionally modifying the header. VIPS copies images by
  /// copying pointers, so this operation is instant, even for very large images.
  ///
  /// You can optionally change any or all header fields during the copy. You can
  /// make any change which does not change the size of a pel, so for example
  /// you can turn a 4-band uchar image into a 2-band ushort image, but you
  /// cannot change a 100 x 100 RGB image into a 300 x 100 mono image.
  ///
  /// See also: [VImage#byteswap], [VImage#bandfold], [VImage#bandunfold]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg swap [VipsOption.Boolean] Swap bytes in image between little and big-endian
  /// @optionalArg width [VipsOption.Int] Image width in pixels
  /// @optionalArg height [VipsOption.Int] Image height in pixels
  /// @optionalArg bands [VipsOption.Int] Number of bands in image
  /// @optionalArg format [VipsOption.Enum] [VipsBandFormat] Pixel format in image
  /// @optionalArg coding [VipsOption.Enum] [VipsCoding] Pixel coding
  /// @optionalArg interpretation [VipsOption.Enum] [VipsInterpretation] Pixel interpretation
  /// @optionalArg xres [VipsOption.Double] Horizontal resolution in pixels/mm
  /// @optionalArg yres [VipsOption.Double] Vertical resolution in pixels/mm
  /// @optionalArg xoffset [VipsOption.Int] Horizontal offset of origin
  /// @optionalArg yoffset [VipsOption.Int] Vertical offset of origin
  public VImage copy(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "copy", callArgs);
    return outOption.valueOrThrow();
  }

  /// Function which calculates the number of transitions
  /// between black and white for the horizontal or the vertical
  /// direction of an image.  black<128 , white>=128
  /// The function calculates the number of transitions for all
  /// Xsize or Ysize and returns the mean of the result
  /// Input should be one band, 8-bit.
  ///
  /// See also: [VImage#morph], [VImage#conv]
  /// @param direction [VipsDirection] Countlines left-right or up-down
  /// @param args Array of VipsOption to apply to this operation
  public double countlines(VipsDirection direction, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var nolinesOption = VipsOption.Double("nolines");
    var directionOption = VipsOption.Enum("direction", direction);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(nolinesOption);
    callArgs.add(directionOption);
    VipsInvoker.invokeOperation(arena, "countlines", callArgs);
    return nolinesOption.valueOrThrow();
  }

  /// Load a CSV (comma-separated values) file.
  ///
  /// The output image is always 1 band (monochrome),
  /// [VipsBandFormat#FORMAT_DOUBLE]. Use [VImage#bandfold] to turn
  /// RGBRGBRGB mono images into colour images.
  ///
  /// Items in lines can be either floating point numbers in the C locale, or
  /// strings enclosed in double-quotes ("), or empty.
  /// You can use a backslash (\) within the quotes to escape special characters,
  /// such as quote marks.
  ///
  /// `skip` sets the number of lines to skip at the start of the file.
  /// Default zero.
  ///
  /// `lines` sets the number of lines to read from the file. Default -1,
  /// meaning read all lines to end of file.
  ///
  /// `whitespace` sets the skippable whitespace characters.
  /// Default *space*.
  /// Whitespace characters are always run together.
  ///
  /// `separator` sets the characters that separate fields.
  /// Default ;,*tab*. Separators are never run together.
  ///
  /// Use `fail_on` to set the type of error that will cause load to fail. By
  /// default, loaders are permissive, that is, [VipsFailOn#FAIL_ON_NONE].
  ///
  /// See also: `Image.new_from_file`, [VImage#bandfold]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg skip [VipsOption.Int] Skip this many lines at the start of the file
  /// @optionalArg lines [VipsOption.Int] Read this many lines from the file
  /// @optionalArg whitespace [VipsOption.String] Set of whitespace characters
  /// @optionalArg separator [VipsOption.String] Set of separator characters
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage csvload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "csvload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#csvload], but read from a source.
  ///
  /// See also: [VImage#csvload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg skip [VipsOption.Int] Skip this many lines at the start of the file
  /// @optionalArg lines [VipsOption.Int] Read this many lines from the file
  /// @optionalArg whitespace [VipsOption.String] Set of whitespace characters
  /// @optionalArg separator [VipsOption.String] Set of separator characters
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage csvloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "csvload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Writes the pixels in `in` to the `filename` as CSV (comma-separated values).
  ///
  /// The image is written
  /// one line of text per scanline. Complex numbers are written as
  /// "(real,imaginary)" and will need extra parsing I guess. Only the first band
  /// is written.
  ///
  /// `separator` gives the string to use to separate numbers in the output.
  /// The default is "\\t" (tab).
  ///
  /// See also: `Image.write_to_file`
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg separator [VipsOption.String] Separator characters
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void csvsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "csvsave", callArgs);
  }

  /// As [VImage#csvsave], but save to a target.
  ///
  /// See also: [VImage#csvsave]
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg separator [VipsOption.String] Separator characters
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void csvsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "csvsave_target", callArgs);
  }

  /// Calculate dE 00.
  /// @param right Right-hand input image
  /// @param args Array of VipsOption to apply to this operation
  public VImage dE00(VImage right, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "dE00", callArgs);
    return outOption.valueOrThrow();
  }

  /// Calculate dE 76.
  /// @param right Right-hand input image
  /// @param args Array of VipsOption to apply to this operation
  public VImage dE76(VImage right, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "dE76", callArgs);
    return outOption.valueOrThrow();
  }

  /// Calculate dE CMC. The input images are transformed to CMC colour space and
  /// the euclidean distance between corresponding pixels calculated.
  ///
  /// To calculate a colour difference with values for (l:c) other than (1:1),
  /// transform the two source images to CMC yourself, scale the channels
  /// appropriately, and call this function.
  ///
  /// See also: [VImage#colourspace]
  /// @param right Right-hand input image
  /// @param args Array of VipsOption to apply to this operation
  public VImage dECMC(VImage right, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "dECMC", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation finds the standard deviation of all pixels in `in`. It
  /// operates on all bands of the input image: use [VImage#stats] if you need
  /// to calculate an average for each band.
  ///
  /// Non-complex images only.
  ///
  /// See also: [VImage#avg], [VImage#stats]
  /// @param args Array of VipsOption to apply to this operation
  public double deviate(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Double("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "deviate", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation calculates `in1` / `in2` and writes the result to `out`. If any
  /// pixels in `in2` are zero, the corresponding pixel in `out` is also zero.
  ///
  /// If the images differ in size, the smaller image is enlarged to match the
  /// larger by adding zero pixels along the bottom and right.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The two input images are cast up to the smallest common format (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)), then the
  /// following table is used to determine the output type:
  ///
  /// ## [VImage#divide] type promotion
  ///
  /// | input type     | output type    |
  /// |----------------|----------------|
  /// | uchar          | float          |
  /// | char           | float          |
  /// | ushort         | float          |
  /// | short          | float          |
  /// | uint           | float          |
  /// | int            | float          |
  /// | float          | float          |
  /// | double         | double         |
  /// | complex        | complex        |
  /// | double complex | double complex |
  ///
  /// In other words, the output type is just large enough to hold the whole
  /// range of possible values.
  ///
  /// See also: [VImage#multiply], [VImage#linear], `Image.pow`
  /// @param right Right-hand image argument
  /// @param args Array of VipsOption to apply to this operation
  public VImage divide(VImage right, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "divide", callArgs);
    return outOption.valueOrThrow();
  }

  /// Draws a circle on `image`.
  ///
  /// If `fill` is `TRUE` then the circle is filled,
  /// otherwise a 1-pixel-wide perimeter is drawn.
  ///
  /// `ink` is an array of double containing values to draw.
  ///
  /// See also: `Image.draw_circle1`, [VImage#drawLine]
  /// @param ink Color for pixels
  /// @param cx Centre of draw_circle
  /// @param cy Centre of draw_circle
  /// @param radius Radius in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg fill [VipsOption.Boolean] Draw a solid object
  public void drawCircle(List<Double> ink, int cx, int cy, int radius, VipsOption... args) throws
      VipsError {
    var imageOption = VipsOption.Image("image", this);
    var inkOption = VipsOption.ArrayDouble("ink", ink);
    var cxOption = VipsOption.Int("cx", cx);
    var cyOption = VipsOption.Int("cy", cy);
    var radiusOption = VipsOption.Int("radius", radius);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(imageOption);
    callArgs.add(inkOption);
    callArgs.add(cxOption);
    callArgs.add(cyOption);
    callArgs.add(radiusOption);
    VipsInvoker.invokeOperation(arena, "draw_circle", callArgs);
  }

  /// Flood-fill `image` with `ink`, starting at position `x`, `y`.
  ///
  /// The filled area is
  /// bounded by pixels that are equal to the ink colour, in other words, it
  /// searches for pixels enclosed by an edge of `ink`.
  ///
  /// If `equal` is set, it instead searches for pixels which are equal to the
  /// start point and fills them with `ink`.
  ///
  /// Normally it will test and set pixels in `image`. If `test` is set, it will
  /// test pixels in `test` and set pixels in `image`. This lets you search an
  /// image (@test) for continuous areas of pixels without modifying it.
  ///
  /// `left`, `top`, `width`, `height` output the bounding box of the modified
  /// pixels.
  /// `ink` is an array of double containing values to draw.
  ///
  /// See also: `Image.draw_flood1`
  /// @param ink Color for pixels
  /// @param x DrawFlood start point
  /// @param y DrawFlood start point
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg test [VipsOption.Image] Test pixels in this image
  /// @optionalArg equal [VipsOption.Boolean] DrawFlood while equal to edge
  /// @optionalArg left [VipsOption.Int] Left edge of modified area
  /// @optionalArg top [VipsOption.Int] Top edge of modified area
  /// @optionalArg width [VipsOption.Int] Width of modified area
  /// @optionalArg height [VipsOption.Int] Height of modified area
  public void drawFlood(List<Double> ink, int x, int y, VipsOption... args) throws VipsError {
    var imageOption = VipsOption.Image("image", this);
    var inkOption = VipsOption.ArrayDouble("ink", ink);
    var xOption = VipsOption.Int("x", x);
    var yOption = VipsOption.Int("y", y);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(imageOption);
    callArgs.add(inkOption);
    callArgs.add(xOption);
    callArgs.add(yOption);
    VipsInvoker.invokeOperation(arena, "draw_flood", callArgs);
  }

  /// Draw `sub` on top of `image` at position `x`, `y`.
  ///
  /// The two images must have the
  /// same Coding. If `sub` has 1 band, the bands will be duplicated to match the
  /// number of bands in `image`. `sub` will be converted to `image`'s format, see
  /// [VImage#cast].
  ///
  /// Use `mode` to set how pixels are combined. If you use
  /// [VipsCombineMode#COMBINE_MODE_ADD], both images must be uncoded.
  ///
  /// See also: [VImage#drawMask], [VImage#insert]
  /// @param sub Sub-image to insert into main image
  /// @param x Draw image here
  /// @param y Draw image here
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg mode [VipsOption.Enum] [VipsCombineMode] Combining mode
  public void drawImage(VImage sub, int x, int y, VipsOption... args) throws VipsError {
    var imageOption = VipsOption.Image("image", this);
    var subOption = VipsOption.Image("sub", sub);
    var xOption = VipsOption.Int("x", x);
    var yOption = VipsOption.Int("y", y);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(imageOption);
    callArgs.add(subOption);
    callArgs.add(xOption);
    callArgs.add(yOption);
    VipsInvoker.invokeOperation(arena, "draw_image", callArgs);
  }

  /// Draws a 1-pixel-wide line on an image.
  ///
  /// `ink` is an array of double containing values to draw.
  ///
  /// See also: `Image.draw_line1`, [VImage#drawCircle], [VImage#drawMask]
  /// @param ink Color for pixels
  /// @param x1 Start of draw_line
  /// @param y1 Start of draw_line
  /// @param x2 End of draw_line
  /// @param y2 End of draw_line
  /// @param args Array of VipsOption to apply to this operation
  public void drawLine(List<Double> ink, int x1, int y1, int x2, int y2, VipsOption... args) throws
      VipsError {
    var imageOption = VipsOption.Image("image", this);
    var inkOption = VipsOption.ArrayDouble("ink", ink);
    var x1Option = VipsOption.Int("x1", x1);
    var y1Option = VipsOption.Int("y1", y1);
    var x2Option = VipsOption.Int("x2", x2);
    var y2Option = VipsOption.Int("y2", y2);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(imageOption);
    callArgs.add(inkOption);
    callArgs.add(x1Option);
    callArgs.add(y1Option);
    callArgs.add(x2Option);
    callArgs.add(y2Option);
    VipsInvoker.invokeOperation(arena, "draw_line", callArgs);
  }

  /// Draw `mask` on the image. `mask` is a monochrome 8-bit image with 0/255
  /// for transparent or `ink` coloured points. Intermediate values blend the ink
  /// with the pixel. Use with [VImage#text] to draw text on an image. Use in a
  /// [VImage#drawLine] subclass to draw an object along a line.
  ///
  /// `ink` is an array of double containing values to draw.
  ///
  /// See also: [VImage#text], [VImage#drawLine]
  /// @param ink Color for pixels
  /// @param mask Mask of pixels to draw
  /// @param x Draw mask here
  /// @param y Draw mask here
  /// @param args Array of VipsOption to apply to this operation
  public void drawMask(List<Double> ink, VImage mask, int x, int y, VipsOption... args) throws
      VipsError {
    var imageOption = VipsOption.Image("image", this);
    var inkOption = VipsOption.ArrayDouble("ink", ink);
    var maskOption = VipsOption.Image("mask", mask);
    var xOption = VipsOption.Int("x", x);
    var yOption = VipsOption.Int("y", y);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(imageOption);
    callArgs.add(inkOption);
    callArgs.add(maskOption);
    callArgs.add(xOption);
    callArgs.add(yOption);
    VipsInvoker.invokeOperation(arena, "draw_mask", callArgs);
  }

  /// Paint pixels within `left`, `top`, `width`, `height` in `image` with `ink`.
  ///
  /// If `fill` is zero, just paint a 1-pixel-wide outline.
  ///
  /// See also: [VImage#drawCircle]
  /// @param ink Color for pixels
  /// @param left Rect to fill
  /// @param top Rect to fill
  /// @param width Rect to fill
  /// @param height Rect to fill
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg fill [VipsOption.Boolean] Draw a solid object
  public void drawRect(List<Double> ink, int left, int top, int width, int height,
      VipsOption... args) throws VipsError {
    var imageOption = VipsOption.Image("image", this);
    var inkOption = VipsOption.ArrayDouble("ink", ink);
    var leftOption = VipsOption.Int("left", left);
    var topOption = VipsOption.Int("top", top);
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(imageOption);
    callArgs.add(inkOption);
    callArgs.add(leftOption);
    callArgs.add(topOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "draw_rect", callArgs);
  }

  /// Smudge a section of `image`. Each pixel in the area `left`, `top`, `width`,
  /// `height` is replaced by the average of the surrounding 3x3 pixels.
  ///
  /// See also: [VImage#drawLine]
  /// @param left Rect to fill
  /// @param top Rect to fill
  /// @param width Rect to fill
  /// @param height Rect to fill
  /// @param args Array of VipsOption to apply to this operation
  public void drawSmudge(int left, int top, int width, int height, VipsOption... args) throws
      VipsError {
    var imageOption = VipsOption.Image("image", this);
    var leftOption = VipsOption.Int("left", left);
    var topOption = VipsOption.Int("top", top);
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(imageOption);
    callArgs.add(leftOption);
    callArgs.add(topOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "draw_smudge", callArgs);
  }

  /// Save an image as a set of tiles at various resolutions. By default dzsave
  /// uses DeepZoom layout -- use `layout` to pick other conventions.
  ///
  /// [VImage#dzsave] creates a directory called `name` to hold the tiles.
  /// If `name` ends `.zip`, [VImage#dzsave] will create a zip file called
  /// `name` to hold the tiles. You can use `container` to force zip file output.
  ///
  /// Use `basename` to set the name of the image we are creating. The
  /// default value is set from `name`.
  ///
  /// By default, tiles are written as JPEGs. Use `Q` set set the JPEG quality
  /// factor.
  ///
  /// You can set `suffix` to something like `".png[bitdepth=4]"` to write tiles
  /// in another format.
  ///
  /// In Google layout mode, edge tiles are expanded to `tile_size` by `tile_size`
  /// pixels. Normally they are filled with white, but you can set another colour
  /// with `background`. Images are usually placed at the top-left of the tile,
  /// but you can have them centred by turning on `centre`.
  ///
  /// You can set the size and overlap of tiles with `tile_size` and `overlap`.
  /// They default to the correct settings for the selected `layout`. The deepzoom
  /// defaults produce 256x256 jpeg files for centre tiles, the most efficient
  /// size.
  ///
  /// Use `depth` to control how low the pyramid goes. This defaults to the
  /// correct setting for the `layout` you select.
  ///
  /// You can rotate the image during write with the `angle` argument. However,
  /// this will only work for images which support random access, like openslide,
  /// and not for things like JPEG. You'll need to rotate those images
  /// yourself with [VImage#rot]. Note that the `autorotate` option to the loader
  /// may do what you need.
  ///
  /// By default, all tiles are stripped since usually you do not want a copy of
  /// all metadata in every tile. Set `keep` if you want to keep metadata.
  ///
  /// If `container` is set to `zip`, you can set a compression level from -1
  /// (use zlib default), 0 (store, compression disabled) to 9 (max compression).
  /// If no value is given, the default is to store files without compression.
  ///
  /// You can use `region_shrink` to control the method for shrinking each 2x2
  /// region. This defaults to using the average of the 4 input pixels but you can
  /// also use the median in cases where you want to preserve the range of values.
  ///
  /// If you set `skip_blanks` to a value greater than or equal to zero, tiles
  /// which are all within that many pixel values to the background are skipped.
  /// This can save a lot of space for some image types. This option defaults to
  /// 5 in Google layout mode, -1 otherwise.
  ///
  /// In IIIF layout, you can set the base of the `id` property in `info.json`
  /// with `id`. The default is `https://example.com/iiif`.
  ///
  /// Use `layout` [VipsForeignDzLayout#FOREIGN_DZ_LAYOUT_IIIF3] for IIIF v3 layout.
  ///
  /// See also: [VImage#tiffsave]
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg dirname [VipsOption.String] Directory name to save to
  /// @optionalArg imagename [VipsOption.String] Image name
  /// @optionalArg layout [VipsOption.Enum] [VipsForeignDzLayout] Directory layout
  /// @optionalArg suffix [VipsOption.String] Filename suffix for tiles
  /// @optionalArg overlap [VipsOption.Int] Tile overlap in pixels
  /// @optionalArg tile-size [VipsOption.Int] Tile size in pixels
  /// @optionalArg tile-height [VipsOption.Int] Tile height in pixels
  /// @optionalArg tile-width [VipsOption.Int] Tile width in pixels
  /// @optionalArg centre [VipsOption.Boolean] Center image in tile
  /// @optionalArg depth [VipsOption.Enum] [VipsForeignDzDepth] Pyramid depth
  /// @optionalArg angle [VipsOption.Enum] [VipsAngle] Rotate image during save
  /// @optionalArg container [VipsOption.Enum] [VipsForeignDzContainer] Pyramid container type
  /// @optionalArg properties [VipsOption.Boolean] Write a properties file to the output directory
  /// @optionalArg compression [VipsOption.Int] ZIP deflate compression level
  /// @optionalArg region-shrink [VipsOption.Enum] [VipsRegionShrink] Method to shrink regions
  /// @optionalArg skip-blanks [VipsOption.Int] Skip tiles which are nearly equal to the background
  /// @optionalArg id [VipsOption.String] Resource ID
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg no-strip [VipsOption.Boolean] Don't strip tile metadata
  /// @optionalArg basename [VipsOption.String] Base name to save to
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void dzsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "dzsave", callArgs);
  }

  /// As [VImage#dzsave], but save to a memory buffer.
  ///
  /// Output is always in a zip container. Use `basename` to set the name of the
  /// directory that the zip will create when unzipped.
  ///
  /// The address of the buffer is returned in `buf`, the length of the buffer in
  /// `len`. You are responsible for freeing the buffer with `GLib.free` when you
  /// are done with it.
  ///
  /// See also: [VImage#dzsave], `Image.write_to_file`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg dirname [VipsOption.String] Directory name to save to
  /// @optionalArg imagename [VipsOption.String] Image name
  /// @optionalArg layout [VipsOption.Enum] [VipsForeignDzLayout] Directory layout
  /// @optionalArg suffix [VipsOption.String] Filename suffix for tiles
  /// @optionalArg overlap [VipsOption.Int] Tile overlap in pixels
  /// @optionalArg tile-size [VipsOption.Int] Tile size in pixels
  /// @optionalArg tile-height [VipsOption.Int] Tile height in pixels
  /// @optionalArg tile-width [VipsOption.Int] Tile width in pixels
  /// @optionalArg centre [VipsOption.Boolean] Center image in tile
  /// @optionalArg depth [VipsOption.Enum] [VipsForeignDzDepth] Pyramid depth
  /// @optionalArg angle [VipsOption.Enum] [VipsAngle] Rotate image during save
  /// @optionalArg container [VipsOption.Enum] [VipsForeignDzContainer] Pyramid container type
  /// @optionalArg properties [VipsOption.Boolean] Write a properties file to the output directory
  /// @optionalArg compression [VipsOption.Int] ZIP deflate compression level
  /// @optionalArg region-shrink [VipsOption.Enum] [VipsRegionShrink] Method to shrink regions
  /// @optionalArg skip-blanks [VipsOption.Int] Skip tiles which are nearly equal to the background
  /// @optionalArg id [VipsOption.String] Resource ID
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg no-strip [VipsOption.Boolean] Don't strip tile metadata
  /// @optionalArg basename [VipsOption.String] Base name to save to
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public VBlob dzsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "dzsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /// As [VImage#dzsave], but save to a target.
  ///
  /// See also: [VImage#dzsave], `Image.write_to_target`
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg dirname [VipsOption.String] Directory name to save to
  /// @optionalArg imagename [VipsOption.String] Image name
  /// @optionalArg layout [VipsOption.Enum] [VipsForeignDzLayout] Directory layout
  /// @optionalArg suffix [VipsOption.String] Filename suffix for tiles
  /// @optionalArg overlap [VipsOption.Int] Tile overlap in pixels
  /// @optionalArg tile-size [VipsOption.Int] Tile size in pixels
  /// @optionalArg tile-height [VipsOption.Int] Tile height in pixels
  /// @optionalArg tile-width [VipsOption.Int] Tile width in pixels
  /// @optionalArg centre [VipsOption.Boolean] Center image in tile
  /// @optionalArg depth [VipsOption.Enum] [VipsForeignDzDepth] Pyramid depth
  /// @optionalArg angle [VipsOption.Enum] [VipsAngle] Rotate image during save
  /// @optionalArg container [VipsOption.Enum] [VipsForeignDzContainer] Pyramid container type
  /// @optionalArg properties [VipsOption.Boolean] Write a properties file to the output directory
  /// @optionalArg compression [VipsOption.Int] ZIP deflate compression level
  /// @optionalArg region-shrink [VipsOption.Enum] [VipsRegionShrink] Method to shrink regions
  /// @optionalArg skip-blanks [VipsOption.Int] Skip tiles which are nearly equal to the background
  /// @optionalArg id [VipsOption.String] Resource ID
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg no-strip [VipsOption.Boolean] Don't strip tile metadata
  /// @optionalArg basename [VipsOption.String] Base name to save to
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void dzsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "dzsave_target", callArgs);
  }

  /// The opposite of [VImage#extractArea]: embed `in` within an image of
  /// size `width` by `height` at position `x`, `y`.
  ///
  /// `extend` controls what appears in the new pels, see [VipsExtend].
  ///
  /// See also: [VImage#extractArea], [VImage#insert]
  /// @param x Left edge of input in output
  /// @param y Top edge of input in output
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg extend [VipsOption.Enum] [VipsExtend] How to generate the extra pixels
  /// @optionalArg background [VipsOption.ArrayDouble] Color for background pixels
  public VImage embed(int x, int y, int width, int height, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var xOption = VipsOption.Int("x", x);
    var yOption = VipsOption.Int("y", y);
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(xOption);
    callArgs.add(yOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "embed", callArgs);
    return outOption.valueOrThrow();
  }

  /// Extract an area from an image. The area must fit within `in`.
  ///
  /// See also: [VImage#extractBand], [VImage#smartcrop]
  /// @param left Left edge of extract area
  /// @param top Top edge of extract area
  /// @param width Width of extract area
  /// @param height Height of extract area
  /// @param args Array of VipsOption to apply to this operation
  public VImage extractArea(int left, int top, int width, int height, VipsOption... args) throws
      VipsError {
    var inputOption = VipsOption.Image("input", this);
    var outOption = VipsOption.Image("out");
    var leftOption = VipsOption.Int("left", left);
    var topOption = VipsOption.Int("top", top);
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inputOption);
    callArgs.add(outOption);
    callArgs.add(leftOption);
    callArgs.add(topOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "extract_area", callArgs);
    return outOption.valueOrThrow();
  }

  /// Extract a band or bands from an image. Extracting out of range is an error.
  ///
  /// `n` defaults to 1.
  ///
  /// See also: [VImage#extractArea]
  /// @param band Band to extract
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg n [VipsOption.Int] Number of bands to extract
  public VImage extractBand(int band, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var bandOption = VipsOption.Int("band", band);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(bandOption);
    VipsInvoker.invokeOperation(arena, "extract_band", callArgs);
    return outOption.valueOrThrow();
  }

  /// Create a test pattern with increasing spatial frequency in X and
  /// amplitude in Y.
  ///
  /// `factor` should be between 0 and 1 and determines the
  /// maximum spatial frequency.
  ///
  /// Set `uchar` to output a uchar image.
  ///
  /// See also: [VImage#zone]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  /// @optionalArg factor [VipsOption.Double] Maximum spatial frequency
  public static VImage eye(Arena arena, int width, int height, VipsOption... args) throws
      VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "eye", callArgs);
    return outOption.valueOrThrow();
  }

  /// Force `in` to 1 band, 8-bit, then transform to
  /// a 3-band 8-bit image with a false colour
  /// map. The map is supposed to make small differences in brightness more
  /// obvious.
  ///
  /// See also: [VImage#maplut]
  /// @param args Array of VipsOption to apply to this operation
  public VImage falsecolour(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "falsecolour", callArgs);
    return outOption.valueOrThrow();
  }

  /// Calculate a fast correlation surface.
  ///
  /// `ref` is placed at every position in `in` and the sum of squares of
  /// differences calculated.
  ///
  /// The output
  /// image is the same size as the input. Extra input edge pixels are made by
  /// copying the existing edges outwards.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The output type is uint if both inputs are integer, float if both are float
  /// or complex, and double if either is double or double complex.
  /// In other words, the output type is just large enough to hold the whole
  /// range of possible values.
  ///
  /// See also: [VImage#spcor]
  /// @param ref Input reference image
  /// @param args Array of VipsOption to apply to this operation
  public VImage fastcor(VImage ref, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var refOption = VipsOption.Image("ref", ref);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(refOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "fastcor", callArgs);
    return outOption.valueOrThrow();
  }

  /// Fill outwards from every non-zero pixel in `in`, setting pixels in `distance`
  /// and `value`.
  ///
  /// At the position of zero pixels in `in`, `distance` contains the distance to
  /// the nearest non-zero pixel in `in`, and `value` contains the value of that
  /// pixel.
  ///
  /// `distance` is a one-band float image. `value` has the same number of bands and
  /// format as `in`.
  ///
  /// See also: [VImage#histFindIndexed]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg distance [VipsOption.Image] Distance to nearest non-zero pixel
  public VImage fillNearest(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "fill_nearest", callArgs);
    return outOption.valueOrThrow();
  }

  /// Search `in` for the bounding box of the non-background area.
  ///
  /// Any alpha is flattened out, then the image is median-filtered (unless
  /// `line_art` is set, see below). The absolute difference from `background` is
  /// computed and binarized according to `threshold`. Row and column sums of
  /// the absolute difference are calculated from this binary image and searched
  /// for the first row or column in each direction to obtain the bounding box.
  ///
  /// If the image is entirely background, [VImage#findTrim] returns
  /// `width` == 0 and `height` == 0.
  ///
  /// `background` defaults to 255, or 65535 for 16-bit images. Set another value,
  /// or use [VImage#getpoint] to pick a value from an edge. You'll need
  /// to flatten before [VImage#getpoint] to get a correct background value.
  ///
  /// `threshold` defaults to 10.
  ///
  /// The detector is designed for photographic or compressed images where there
  /// is a degree of noise that needs filtering. If your images are synthetic
  /// (eg. rendered from vector art, perhaps), set `line_art` to disable this
  /// filtering.
  ///
  /// The image needs to be at least 3x3 pixels in size.
  ///
  /// See also: [VImage#getpoint], [VImage#extractArea], [VImage#smartcrop]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg threshold [VipsOption.Double] Object threshold
  /// @optionalArg background [VipsOption.ArrayDouble] Color for background pixels
  /// @optionalArg line-art [VipsOption.Boolean] Enable line art mode
  public FindTrimOutput findTrim(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var leftOption = VipsOption.Int("left");
    var topOption = VipsOption.Int("top");
    var widthOption = VipsOption.Int("width");
    var heightOption = VipsOption.Int("height");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(leftOption);
    callArgs.add(topOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "find_trim", callArgs);
    return new FindTrimOutput(leftOption.valueOrThrow(), topOption.valueOrThrow(), widthOption.valueOrThrow(), heightOption.valueOrThrow());
  }

  /// Read a FITS image file into a VIPS image.
  ///
  /// This operation can read images with up to three dimensions. Any higher
  /// dimensions must be empty.
  ///
  /// It can read 8, 16 and 32-bit integer images, signed and unsigned, float and
  /// double.
  ///
  /// FITS metadata is attached with the "fits-" prefix.
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage fitsload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "fitsload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#fitsload], but read from a source.
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage fitsloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "fitsload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Write a VIPS image to a file in FITS format.
  ///
  /// See also: `Image.write_to_file`
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void fitssave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "fitssave", callArgs);
  }

  /// Take the last band of `in` as an alpha and use it to blend the
  /// remaining channels with `background`.
  ///
  /// The alpha channel is 0 - `max_alpha`, where `max_alpha` means 100% image
  /// and 0 means 100% background. `background` defaults to zero (black).
  ///
  /// `max_alpha` has the default value 255, or 65535 for images tagged as
  /// [VipsInterpretation#INTERPRETATION_RGB16] or [VipsInterpretation#INTERPRETATION_GREY16].
  ///
  /// Useful for flattening PNG images to RGB.
  ///
  /// Non-complex images only.
  ///
  /// See also: [VImage#premultiply], [VImage#pngload]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg max-alpha [VipsOption.Double] Maximum value of alpha channel
  public VImage flatten(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "flatten", callArgs);
    return outOption.valueOrThrow();
  }

  /// Flips an image left-right or up-down.
  ///
  /// See also: [VImage#rot]
  /// @param direction [VipsDirection] Direction to flip image
  /// @param args Array of VipsOption to apply to this operation
  public VImage flip(VipsDirection direction, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var directionOption = VipsOption.Enum("direction", direction);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(directionOption);
    VipsInvoker.invokeOperation(arena, "flip", callArgs);
    return outOption.valueOrThrow();
  }

  /// Convert a three-band float image to Radiance 32-bit packed format.
  ///
  /// See also: [VImage#rad2float], [VipsCoding#CODING_RAD], [VImage#LabQ2Lab]
  /// @param args Array of VipsOption to apply to this operation
  public VImage float2rad(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "float2rad", callArgs);
    return outOption.valueOrThrow();
  }

  /// Generate an image of size `width` by `height` and fractal dimension
  /// `fractal_dimension`. The dimension should be between 2 and 3.
  ///
  /// See also: [VImage#gaussnoise], [VImage#maskFractal]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param fractalDimension Fractal dimension
  /// @param args Array of VipsOption to apply to this operation
  public static VImage fractsurf(Arena arena, int width, int height, double fractalDimension,
      VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var fractalDimensionOption = VipsOption.Double("fractal-dimension", fractalDimension);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(fractalDimensionOption);
    VipsInvoker.invokeOperation(arena, "fractsurf", callArgs);
    return outOption.valueOrThrow();
  }

  /// Multiply `in` by `mask` in Fourier space.
  ///
  /// `in` is transformed to Fourier space, multiplied with `mask`, then
  /// transformed back to real space. If `in` is already a complex image, just
  /// multiply then inverse transform.
  ///
  /// See also: [VImage#invfft], [VImage#maskIdeal]
  /// @param mask Input mask image
  /// @param args Array of VipsOption to apply to this operation
  public VImage freqmult(VImage mask, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var maskOption = VipsOption.Image("mask", mask);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(maskOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "freqmult", callArgs);
    return outOption.valueOrThrow();
  }

  /// Transform an image to Fourier space.
  ///
  /// VIPS uses the fftw Fourier Transform library. If this library was not
  /// available when VIPS was configured, these functions will fail.
  ///
  /// See also: [VImage#invfft]
  /// @param args Array of VipsOption to apply to this operation
  public VImage fwfft(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "fwfft", callArgs);
    return outOption.valueOrThrow();
  }

  /// Calculate `in` ** (1 / `exponent`), normalising to the maximum range of the
  /// input type. For float types use 1.0 as the maximum.
  ///
  /// See also: [VImage#identity], `Image.pow_const1`, [VImage#maplut]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg exponent [VipsOption.Double] Gamma factor
  public VImage gamma(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "gamma", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operator runs [VImage#gaussmat] and [VImage#convsep] for
  /// you on an image.
  ///
  /// Set `min_ampl` smaller to generate a larger, more accurate mask. Set `sigma`
  /// larger to make the blur more blurry.
  ///
  /// See also: [VImage#gaussmat], [VImage#convsep]
  /// @param sigma Sigma of Gaussian
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg min-ampl [VipsOption.Double] Minimum amplitude of Gaussian
  /// @optionalArg precision [VipsOption.Enum] [VipsPrecision] Convolve with this precision
  public VImage gaussblur(double sigma, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var sigmaOption = VipsOption.Double("sigma", sigma);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(sigmaOption);
    VipsInvoker.invokeOperation(arena, "gaussblur", callArgs);
    return outOption.valueOrThrow();
  }

  /// Creates a circularly symmetric Gaussian image of radius
  /// `sigma`.
  ///
  /// The size of the mask is determined by the variable `min_ampl`;
  /// if for instance the value .1 is entered this means that the produced mask
  /// is clipped at values less than 10 percent of the maximum amplitude.
  ///
  /// The program uses the following equation:
  ///
  /// ```
  /// H(r) = exp(-(r * r) / (2 * `sigma` * `sigma`))
  /// ```
  ///
  /// The generated image has odd size and its maximum value is normalised to
  /// 1.0, unless `precision` is [VipsPrecision#PRECISION_INTEGER].
  ///
  /// If `separable` is set, only the centre horizontal is generated. This is
  /// useful for separable convolutions.
  ///
  /// If `precision` is [VipsPrecision#PRECISION_INTEGER], an integer gaussian is
  /// generated. This is useful for integer convolutions.
  ///
  /// "scale" is set to the sum of all the mask elements.
  ///
  /// See also: [VImage#logmat], [VImage#conv]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param sigma Sigma of Gaussian
  /// @param minAmpl Minimum amplitude of Gaussian
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg separable [VipsOption.Boolean] Generate separable Gaussian
  /// @optionalArg integer [VipsOption.Boolean] Generate integer Gaussian
  /// @optionalArg precision [VipsOption.Enum] [VipsPrecision] Generate with this precision
  public static VImage gaussmat(Arena arena, double sigma, double minAmpl, VipsOption... args)
      throws VipsError {
    var outOption = VipsOption.Image("out");
    var sigmaOption = VipsOption.Double("sigma", sigma);
    var minAmplOption = VipsOption.Double("min-ampl", minAmpl);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(sigmaOption);
    callArgs.add(minAmplOption);
    VipsInvoker.invokeOperation(arena, "gaussmat", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make a one band float image of gaussian noise with the specified
  /// distribution.
  ///
  /// The gaussian distribution is created by averaging 12 random numbers from a
  /// linear generator, then weighting appropriately with `mean` and `sigma`.
  ///
  /// See also: [VImage#black], [VImage#xyz], [VImage#text]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg sigma [VipsOption.Double] Standard deviation of pixels in generated image
  /// @optionalArg mean [VipsOption.Double] Mean of pixels in generated image
  /// @optionalArg seed [VipsOption.Int] Random number seed
  public static VImage gaussnoise(Arena arena, int width, int height, VipsOption... args) throws
      VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "gaussnoise", callArgs);
    return outOption.valueOrThrow();
  }

  /// Reads a single pixel on an image.
  ///
  /// The pixel values are returned in `vector`, the length of the
  /// array in `n`. You must free the array with `GLib.free` when you are done with
  /// it.
  ///
  /// The result array has an element for each band. If `unpack_complex` is set,
  /// pixels in complex images are returned as double-length arrays.
  ///
  /// See also: `Image.draw_point`
  /// @param x Point to read
  /// @param y Point to read
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg unpack-complex [VipsOption.Boolean] Complex pixels should be unpacked
  public List<Double> getpoint(int x, int y, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outArrayOption = VipsOption.ArrayDouble("out-array");
    var xOption = VipsOption.Int("x", x);
    var yOption = VipsOption.Int("y", y);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outArrayOption);
    callArgs.add(xOption);
    callArgs.add(yOption);
    VipsInvoker.invokeOperation(arena, "getpoint", callArgs);
    return outArrayOption.valueOrThrow();
  }

  /// Read a GIF file into a libvips image.
  ///
  /// Use `page` to select a page to render, numbering from zero.
  ///
  /// Use `n` to select the number of pages to render. The default is 1. Pages are
  /// rendered in a vertical column. Set to -1 to mean "until the end of the
  /// document". Use [VImage#grid] to change page layout.
  ///
  /// Use `fail_on` to set the type of error that will cause load to fail. By
  /// default, loaders are permissive, that is, [VipsFailOn#FAIL_ON_NONE].
  ///
  /// The output image is RGBA for GIFs containing transparent elements, RGB
  /// otherwise.
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage gifload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "gifload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#gifload], but read from a memory buffer.
  ///
  /// You must not free the buffer while `out` is active. The
  /// `Object::postclose` signal on `out` is a good place to free.
  ///
  /// See also: [VImage#gifload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage gifloadBuffer(Arena arena, VBlob buffer, VipsOption... args) throws
      VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "gifload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#gifload], but read from a source.
  ///
  /// See also: [VImage#gifload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage gifloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "gifload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Write to a file in GIF format.
  ///
  /// Use `dither` to set the degree of Floyd-Steinberg dithering
  /// and `effort` to control the CPU effort (1 is the fastest,
  /// 10 is the slowest, 7 is the default).
  ///
  /// Use `bitdepth` (from 1 to 8, default 8) to control the number
  /// of colours in the palette. The first entry in the palette is
  /// always reserved for transparency. For example, a bitdepth of
  /// 4 will allow the output to contain up to 15 colours.
  ///
  /// Use `interframe_maxerror` to set the threshold below which pixels are
  /// considered equal.
  /// Pixels which don't change from frame to frame can be made transparent,
  /// improving the compression rate. Default 0.
  ///
  /// Use `interpalette_maxerror` to set the threshold below which the
  /// previously generated palette will be reused.
  ///
  /// If `reuse` is `TRUE`, the GIF will be saved with a single global
  /// palette taken from the metadata in `in`, and no new palette optimisation
  /// will be done.
  ///
  /// If `interlace` is `TRUE`, the GIF file will be interlaced (progressive GIF).
  /// These files may be better for display over a slow network
  /// connection, but need more memory to encode.
  ///
  /// If `keep_duplicate_frames` is `TRUE`, duplicate frames in the input will be
  /// kept in the output instead of combining them.
  ///
  /// See also: `Image.new_from_file`
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg dither [VipsOption.Double] Amount of dithering
  /// @optionalArg effort [VipsOption.Int] Quantisation effort
  /// @optionalArg bitdepth [VipsOption.Int] Number of bits per pixel
  /// @optionalArg interframe-maxerror [VipsOption.Double] Maximum inter-frame error for transparency
  /// @optionalArg reuse [VipsOption.Boolean] Reuse palette from input
  /// @optionalArg interpalette-maxerror [VipsOption.Double] Maximum inter-palette error for palette reusage
  /// @optionalArg interlace [VipsOption.Boolean] Generate an interlaced (progressive) GIF
  /// @optionalArg reoptimise [VipsOption.Boolean] Reoptimise colour palettes
  /// @optionalArg keep-duplicate-frames [VipsOption.Boolean] Keep duplicate frames in the output instead of combining them
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void gifsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "gifsave", callArgs);
  }

  /// As [VImage#gifsave], but save to a memory buffer.
  ///
  /// The address of the buffer is returned in `buf`, the length of the buffer in
  /// `len`. You are responsible for freeing the buffer with `GLib.free` when you
  /// are done with it.
  ///
  /// See also: [VImage#gifsave], `Image.write_to_file`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg dither [VipsOption.Double] Amount of dithering
  /// @optionalArg effort [VipsOption.Int] Quantisation effort
  /// @optionalArg bitdepth [VipsOption.Int] Number of bits per pixel
  /// @optionalArg interframe-maxerror [VipsOption.Double] Maximum inter-frame error for transparency
  /// @optionalArg reuse [VipsOption.Boolean] Reuse palette from input
  /// @optionalArg interpalette-maxerror [VipsOption.Double] Maximum inter-palette error for palette reusage
  /// @optionalArg interlace [VipsOption.Boolean] Generate an interlaced (progressive) GIF
  /// @optionalArg reoptimise [VipsOption.Boolean] Reoptimise colour palettes
  /// @optionalArg keep-duplicate-frames [VipsOption.Boolean] Keep duplicate frames in the output instead of combining them
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public VBlob gifsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "gifsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /// As [VImage#gifsave], but save to a target.
  ///
  /// See also: [VImage#gifsave], `Image.write_to_target`
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg dither [VipsOption.Double] Amount of dithering
  /// @optionalArg effort [VipsOption.Int] Quantisation effort
  /// @optionalArg bitdepth [VipsOption.Int] Number of bits per pixel
  /// @optionalArg interframe-maxerror [VipsOption.Double] Maximum inter-frame error for transparency
  /// @optionalArg reuse [VipsOption.Boolean] Reuse palette from input
  /// @optionalArg interpalette-maxerror [VipsOption.Double] Maximum inter-palette error for palette reusage
  /// @optionalArg interlace [VipsOption.Boolean] Generate an interlaced (progressive) GIF
  /// @optionalArg reoptimise [VipsOption.Boolean] Reoptimise colour palettes
  /// @optionalArg keep-duplicate-frames [VipsOption.Boolean] Keep duplicate frames in the output instead of combining them
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void gifsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "gifsave_target", callArgs);
  }

  /// [VImage#globalbalance] can be used to remove contrast differences in
  /// an assembled mosaic.
  ///
  /// It reads the History field attached to `in` and builds a list of the source
  /// images that were used to make the mosaic and the position that each ended
  /// up at in the final image.
  ///
  /// It opens each of the source images in turn and extracts all parts which
  /// overlap with any of the other images. It finds the average values in the
  /// overlap areas and uses least-mean-square to find a set of correction
  /// factors which will minimise overlap differences. It uses `gamma` to
  /// gamma-correct the source images before calculating the factors. A value of
  /// 1.0 will stop this.
  ///
  /// Each of the source images is transformed with the appropriate correction
  /// factor, then the mosaic is reassembled. `out` is
  /// [VipsBandFormat#FORMAT_FLOAT], but if `int_output` is set, the output image
  /// is the same format as the input images.
  ///
  /// There are some conditions that must be met before this operation can work:
  /// the source images must all be present under the filenames recorded in the
  /// history on `in`, and the mosaic must have been built using only operations in
  /// this package.
  ///
  /// See also: [VImage#mosaic]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg gamma [VipsOption.Double] Image gamma
  /// @optionalArg int-output [VipsOption.Boolean] Integer output
  public VImage globalbalance(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "globalbalance", callArgs);
    return outOption.valueOrThrow();
  }

  /// The opposite of [VImage#extractArea]: place `in` within an image of
  /// size `width` by `height` at a certain gravity.
  ///
  /// `extend` controls what appears in the new pels, see [VImage].
  ///
  /// See also: [VImage#extractArea], [VipsExtend#insert]
  /// @param direction [VipsCompassDirection] Direction to place image within width/height
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg extend [VipsOption.Enum] [VipsExtend] How to generate the extra pixels
  /// @optionalArg background [VipsOption.ArrayDouble] Color for background pixels
  public VImage gravity(VipsCompassDirection direction, int width, int height, VipsOption... args)
      throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var directionOption = VipsOption.Enum("direction", direction);
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(directionOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "gravity", callArgs);
    return outOption.valueOrThrow();
  }

  /// Create a one-band float image with the left-most column zero and the
  /// right-most 1.
  ///
  /// Intermediate pixels are a linear ramp.
  ///
  /// Set `uchar` to output a uchar image with the leftmost pixel 0 and the
  /// rightmost 255.
  ///
  /// See also: [VImage#xyz], [VImage#identity]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  public static VImage grey(Arena arena, int width, int height, VipsOption... args) throws
      VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "grey", callArgs);
    return outOption.valueOrThrow();
  }

  /// Chop a tall thin image up into a set of tiles, lay the tiles out in a grid.
  ///
  /// The input image should be a very tall, thin image containing a list of
  /// smaller images. Volumetric or time-sequence images are often laid out like
  /// this. This image is chopped into a series of tiles, each `tile_height`
  /// pixels high and the width of `in`. The tiles are then rearranged into a grid
  /// `across` tiles across and `down` tiles down in row-major order.
  ///
  /// Supplying `tile_height`, `across` and `down` is not strictly necessary, we
  /// only really need two of these. Requiring three is a double-check that the
  /// image has the expected geometry.
  ///
  /// See also: [VImage#embed], [VImage#insert], [VImage#join]
  /// @param tileHeight Chop into tiles this high
  /// @param across Number of tiles across
  /// @param down Number of tiles down
  /// @param args Array of VipsOption to apply to this operation
  public VImage grid(int tileHeight, int across, int down, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var tileHeightOption = VipsOption.Int("tile-height", tileHeight);
    var acrossOption = VipsOption.Int("across", across);
    var downOption = VipsOption.Int("down", down);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(tileHeightOption);
    callArgs.add(acrossOption);
    callArgs.add(downOption);
    VipsInvoker.invokeOperation(arena, "grid", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a HEIF image file into a VIPS image.
  ///
  /// Use `page` to select a page to render, numbering from zero. If neither `n`
  /// nor `page` are set, `page` defaults to the primary page, otherwise to 0.
  ///
  /// Use `n` to select the number of pages to render. The default is 1. Pages are
  /// rendered in a vertical column. Set to -1 to mean "until the end of the
  /// document". Use [VImage#grid] to reorganise pages.
  ///
  /// HEIF images have a primary image. The metadata item `heif-primary` gives
  /// the page number of the primary.
  ///
  /// If `thumbnail` is `TRUE`, then fetch a stored thumbnail rather than the
  /// image.
  ///
  /// By default, input image dimensions are limited to 16384x16384.
  /// If `unlimited` is `TRUE`, this increases to the maximum of 65535x65535.
  ///
  /// The bitdepth of the heic image is recorded in the metadata item
  /// `heif-bitdepth`.
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg thumbnail [VipsOption.Boolean] Fetch thumbnail image
  /// @optionalArg autorotate [VipsOption.Boolean] Rotate image using exif orientation
  /// @optionalArg unlimited [VipsOption.Boolean] Remove all denial of service limits
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage heifload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "heifload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a HEIF image file into a VIPS image.
  /// Exactly as [VImage#heifload], but read from a memory buffer.
  ///
  /// You must not free the buffer while `out` is active. The
  /// `Object::postclose` signal on `out` is a good place to free.
  ///
  /// See also: [VImage#heifload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg thumbnail [VipsOption.Boolean] Fetch thumbnail image
  /// @optionalArg autorotate [VipsOption.Boolean] Rotate image using exif orientation
  /// @optionalArg unlimited [VipsOption.Boolean] Remove all denial of service limits
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage heifloadBuffer(Arena arena, VBlob buffer, VipsOption... args) throws
      VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "heifload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#heifload], but read from a source.
  ///
  /// See also: [VImage#heifload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg thumbnail [VipsOption.Boolean] Fetch thumbnail image
  /// @optionalArg autorotate [VipsOption.Boolean] Rotate image using exif orientation
  /// @optionalArg unlimited [VipsOption.Boolean] Remove all denial of service limits
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage heifloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "heifload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Write a VIPS image to a file in HEIF format.
  ///
  /// Use `Q` to set the compression factor. Default 50, which seems to be roughly
  /// what the iphone uses. Q 30 gives about the same quality as JPEG Q 75.
  ///
  /// Set `lossless` `TRUE` to switch to lossless compression.
  ///
  /// Use `compression` to set the compression format e.g. HEVC, AVC, AV1 to use. It defaults to AV1
  /// if the target filename ends with ".avif", otherwise HEVC.
  ///
  /// Use `effort` to control the CPU effort spent improving compression.
  /// This is currently only applicable to AV1 encoders. Defaults to 4, 0 is
  /// fastest, 9 is slowest.
  ///
  /// Chroma subsampling is normally automatically disabled for Q >= 90. You can
  /// force the subsampling mode with `subsample_mode`.
  ///
  /// Use `bitdepth` to set the bitdepth of the output file. HEIC supports at
  /// least 8, 10 and 12 bits; other codecs may support more or fewer options.
  ///
  /// Use `encoder` to set the encode library to use, e.g. aom, SVT-AV1, rav1e etc.
  ///
  /// See also: `Image.write_to_file`, [VImage#heifload]
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg bitdepth [VipsOption.Int] Number of bits per pixel
  /// @optionalArg lossless [VipsOption.Boolean] Enable lossless compression
  /// @optionalArg compression [VipsOption.Enum] [VipsForeignHeifCompression] Compression format
  /// @optionalArg effort [VipsOption.Int] CPU effort
  /// @optionalArg subsample-mode [VipsOption.Enum] [VipsForeignSubsample] Select chroma subsample operation mode
  /// @optionalArg speed [VipsOption.Int] CPU effort
  /// @optionalArg encoder [VipsOption.Enum] [VipsForeignHeifEncoder] Select encoder to use
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void heifsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "heifsave", callArgs);
  }

  /// As [VImage#heifsave], but save to a memory buffer.
  ///
  /// The address of the buffer is returned in `obuf`, the length of the buffer in
  /// `olen`. You are responsible for freeing the buffer with `GLib.free`
  /// when you are done with it.
  ///
  /// See also: [VImage#heifsave], `Image.write_to_file`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg bitdepth [VipsOption.Int] Number of bits per pixel
  /// @optionalArg lossless [VipsOption.Boolean] Enable lossless compression
  /// @optionalArg compression [VipsOption.Enum] [VipsForeignHeifCompression] Compression format
  /// @optionalArg effort [VipsOption.Int] CPU effort
  /// @optionalArg subsample-mode [VipsOption.Enum] [VipsForeignSubsample] Select chroma subsample operation mode
  /// @optionalArg speed [VipsOption.Int] CPU effort
  /// @optionalArg encoder [VipsOption.Enum] [VipsForeignHeifEncoder] Select encoder to use
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public VBlob heifsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "heifsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /// As [VImage#heifsave], but save to a target.
  ///
  /// See also: [VImage#heifsave], `Image.write_to_target`
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg bitdepth [VipsOption.Int] Number of bits per pixel
  /// @optionalArg lossless [VipsOption.Boolean] Enable lossless compression
  /// @optionalArg compression [VipsOption.Enum] [VipsForeignHeifCompression] Compression format
  /// @optionalArg effort [VipsOption.Int] CPU effort
  /// @optionalArg subsample-mode [VipsOption.Enum] [VipsForeignSubsample] Select chroma subsample operation mode
  /// @optionalArg speed [VipsOption.Int] CPU effort
  /// @optionalArg encoder [VipsOption.Enum] [VipsForeignHeifEncoder] Select encoder to use
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void heifsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "heifsave_target", callArgs);
  }

  /// Form cumulative histogram.
  ///
  /// See also: [VImage#histNorm]
  /// @param args Array of VipsOption to apply to this operation
  public VImage histCum(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_cum", callArgs);
    return outOption.valueOrThrow();
  }

  /// Estimate image entropy from a histogram. Entropy is calculated as:
  ///
  /// ```
  /// -sum(p * log2(p))
  /// ```
  ///
  /// where p is histogram-value / sum-of-histogram-values.
  /// @param args Array of VipsOption to apply to this operation
  public double histEntropy(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Double("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_entropy", callArgs);
    return outOption.valueOrThrow();
  }

  /// Histogram-equalise `in`.
  ///
  /// Equalise using band `bandno`, or if `bandno` is -1,
  /// equalise bands independently. The output format is always the same as the
  /// input format.
  ///
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg band [VipsOption.Int] Equalise with this band
  public VImage histEqual(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_equal", callArgs);
    return outOption.valueOrThrow();
  }

  /// Find the histogram of `in`. Find the histogram for band `band` (producing a
  /// one-band histogram), or for all bands (producing an n-band histogram) if
  /// `band` is -1.
  ///
  /// char and uchar images are cast to uchar before histogramming, all other
  /// image types are cast to ushort.
  ///
  /// See also: [VImage#histFindNdim], [VImage#histFindIndexed]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg band [VipsOption.Int] Find histogram of band
  public VImage histFind(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_find", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make a histogram of `in`, but use image `index` to pick the bins. In other
  /// words, element zero in `out` contains the combination of all the pixels in `in`
  /// whose corresponding pixel in `index` is zero.
  ///
  /// char and uchar `index` images are cast to uchar before histogramming, all
  /// other image types are cast to ushort. `index` must have just one band.
  ///
  /// `in` must be non-complex.
  ///
  /// `out` always has the same size and format as `in`.
  ///
  /// Normally, bins are summed, but you can use `combine` to set other combine
  /// modes.
  ///
  /// This operation is useful in conjunction with [VImage#labelregions].
  /// You can use it to find the centre of gravity of blobs in an image, for
  /// example.
  ///
  /// See also: [VImage#histFind], [VImage#labelregions]
  /// @param index Index image
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg combine [VipsOption.Enum] [VipsCombine] Combine bins like this
  public VImage histFindIndexed(VImage index, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var indexOption = VipsOption.Image("index", index);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(indexOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_find_indexed", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make a one, two or three dimensional histogram of a 1, 2 or
  /// 3 band image. Divide each axis into `bins` bins .. ie.
  /// output is 1 x bins, bins x bins, or bins x bins x bins bands.
  /// `bins` defaults to 10.
  ///
  /// char and uchar images are cast to uchar before histogramming, all other
  /// image types are cast to ushort.
  ///
  /// See also: [VImage#histFind], [VImage#histFindIndexed]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg bins [VipsOption.Int] Number of bins in each dimension
  public VImage histFindNdim(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_find_ndim", callArgs);
    return outOption.valueOrThrow();
  }

  /// Test `in` for monotonicity. `out` is set non-zero if `in` is monotonic.
  /// @param args Array of VipsOption to apply to this operation
  public boolean histIsmonotonic(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var monotonicOption = VipsOption.Boolean("monotonic");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(monotonicOption);
    VipsInvoker.invokeOperation(arena, "hist_ismonotonic", callArgs);
    return monotonicOption.valueOrThrow();
  }

  /// Performs local histogram equalisation on `in` using a
  /// window of size `width` by `height` centered on the input pixel.
  ///
  /// The output image is the same size as the input image. The edge pixels are
  /// created by mirroring the input image outwards.
  ///
  /// If `max_slope` is greater than 0, it sets the maximum value for the slope of
  /// the cumulative histogram, that is, the maximum brightening that is
  /// performed. A value of 3 is often used. Local histogram equalization with
  /// contrast limiting is usually called CLAHE.
  ///
  /// See also: [VImage#histEqual]
  /// @param width Window width in pixels
  /// @param height Window height in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg max-slope [VipsOption.Int] Maximum slope (CLAHE)
  public VImage histLocal(int width, int height, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "hist_local", callArgs);
    return outOption.valueOrThrow();
  }

  /// Adjust `in` to match `ref`. If `in` and `ref` are normalised
  /// cumulative histograms, `out` will be a LUT that adjusts the PDF of the image
  /// from which `in` was made to match the PDF of `ref`'s image.
  ///
  /// See also: [VImage#maplut], [VImage#histFind], [VImage#histNorm], [VImage#histCum]
  /// @param ref Reference histogram
  /// @param args Array of VipsOption to apply to this operation
  public VImage histMatch(VImage ref, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var refOption = VipsOption.Image("ref", ref);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(refOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_match", callArgs);
    return outOption.valueOrThrow();
  }

  /// Normalise histogram. The maximum of each band becomes equal to the maximum
  /// index, so for example the max for a uchar image becomes 255.
  /// Normalise each band separately.
  ///
  /// See also: [VImage#histCum]
  /// @param args Array of VipsOption to apply to this operation
  public VImage histNorm(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_norm", callArgs);
    return outOption.valueOrThrow();
  }

  /// Plot a 1 by any or any by 1 image file as a max by any or
  /// any by max image using these rules:
  ///
  /// *unsigned char* max is always 256
  ///
  /// *other unsigned integer types* output 0 - maximum
  /// value of `in`.
  ///
  /// *signed int types* min moved to 0, max moved to max + min.
  ///
  /// *float types* min moved to 0, max moved to any
  /// (square output)
  /// @param args Array of VipsOption to apply to this operation
  public VImage histPlot(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_plot", callArgs);
    return outOption.valueOrThrow();
  }

  /// Find the circular Hough transform of an image. `in` must be one band, with
  /// non-zero pixels for image edges. `out` is three-band, with the third channel
  /// representing the detected circle radius. The operation scales the number of
  /// votes by circle circumference so circles of differing size are given equal
  /// weight.
  ///
  /// The output pixel at (x, y, band) is the strength of the circle centred on
  /// (x, y) and with radius (band).
  ///
  /// Use `max_radius` and `min_radius` to set the range of radii to search for.
  ///
  /// Use `scale` to set how `in` coordinates are scaled to `out` coordinates. A
  /// `scale` of 3, for example, will make `out` 1/3rd of the width and height of
  /// `in`, and reduce the number of radii tested (and hence the number of bands
  /// int `out`) by a factor of three as well.
  ///
  /// See also: [VImage#houghLine]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg scale [VipsOption.Int] Scale down dimensions by this factor
  /// @optionalArg min-radius [VipsOption.Int] Smallest radius to search for
  /// @optionalArg max-radius [VipsOption.Int] Largest radius to search for
  public VImage houghCircle(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hough_circle", callArgs);
    return outOption.valueOrThrow();
  }

  /// Find the line Hough transform for `in`. `in` must have one band. `out` has one
  /// band, with pixels being the number of votes for that line. The X dimension
  /// of `out` is the line angle in 0 - 180 degrees, the Y dimension is the
  /// distance of the closest part of that line to the origin in the top-left.
  ///
  /// Use `width` `height` to set the size of the parameter space image (@out),
  /// that is, how accurate the line determination should be.
  ///
  /// See also: [VImage#houghCircle]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg width [VipsOption.Int] Horizontal size of parameter space
  /// @optionalArg height [VipsOption.Int] Vertical size of parameter space
  public VImage houghLine(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hough_line", callArgs);
    return outOption.valueOrThrow();
  }

  /// Export an image from D65 LAB to device space with an ICC profile.
  ///
  /// If `pcs` is set to [VipsPCS#PCS_XYZ], use CIE XYZ PCS instead.
  /// If `output_profile` is not set, use the embedded profile, if any.
  /// If `output_profile` is set, export with that and attach it to the output
  /// image.
  ///
  /// If `black_point_compensation` is set, LCMS black point compensation is
  /// enabled.
  ///
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg pcs [VipsOption.Enum] [VipsPCS] Set Profile Connection Space
  /// @optionalArg intent [VipsOption.Enum] [VipsIntent] Rendering intent
  /// @optionalArg black-point-compensation [VipsOption.Boolean] Enable black point compensation
  /// @optionalArg output-profile [VipsOption.String] Filename to load output profile from
  /// @optionalArg depth [VipsOption.Int] Output device space depth in bits
  public VImage iccExport(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "icc_export", callArgs);
    return outOption.valueOrThrow();
  }

  /// Import an image from device space to D65 LAB with an ICC profile.
  ///
  /// If `pcs` is set to [VipsPCS#PCS_XYZ], use CIE XYZ PCS instead.
  ///
  /// The input profile is searched for in three places:
  ///
  /// 1. If `embedded` is set, libvips will try to use any profile in the input
  ///    image metadata. You can test for the presence of an embedded profile
  ///    with `Image.get_typeof` with `META_ICC_NAME` as an
  ///    argument. This will return `GObject.Type` 0 if there is no profile.
  ///
  /// 2. Otherwise, if `input_profile` is set, libvips will try to load a
  ///    profile from the named file. This can also be the name of one of the
  ///    built-in profiles.
  ///
  /// 3. Otherwise, libvips will try to pick a compatible profile from the set
  ///    of built-in profiles.
  ///
  /// If `black_point_compensation` is set, LCMS black point compensation is
  /// enabled.
  ///
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg pcs [VipsOption.Enum] [VipsPCS] Set Profile Connection Space
  /// @optionalArg intent [VipsOption.Enum] [VipsIntent] Rendering intent
  /// @optionalArg black-point-compensation [VipsOption.Boolean] Enable black point compensation
  /// @optionalArg embedded [VipsOption.Boolean] Use embedded input profile, if available
  /// @optionalArg input-profile [VipsOption.String] Filename to load input profile from
  public VImage iccImport(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "icc_import", callArgs);
    return outOption.valueOrThrow();
  }

  /// Transform an image with a pair of ICC profiles.
  ///
  /// The input image is moved to profile-connection space with the input
  /// profile and then to the output space with the output profile.
  ///
  /// The input profile is searched for in three places:
  ///
  /// 1. If `embedded` is set, libvips will try to use any profile in the input
  ///    image metadata. You can test for the presence of an embedded profile
  ///    with `Image.get_typeof` with `META_ICC_NAME` as an
  ///    argument. This will return `GObject.Type` 0 if there is no profile.
  ///
  /// 2. Otherwise, if `input_profile` is set, libvips will try to load a
  ///    profile from the named file. This can also be the name of one of the
  ///    built-in profiles.
  ///
  /// 3. Otherwise, libvips will try to pick a compatible profile from the set
  ///    of built-in profiles.
  ///
  /// If `black_point_compensation` is set, LCMS black point compensation is
  /// enabled.
  ///
  /// `depth` defaults to 8, or 16 if `in` is a 16-bit image.
  ///
  /// The output image has the output profile attached to the `META_ICC_NAME`
  /// field.
  ///
  /// Use [VImage#iccImport] and [VImage#iccExport] to do either
  /// the first or second half of this operation in isolation.
  ///
  /// @param outputProfile Filename to load output profile from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg pcs [VipsOption.Enum] [VipsPCS] Set Profile Connection Space
  /// @optionalArg intent [VipsOption.Enum] [VipsIntent] Rendering intent
  /// @optionalArg black-point-compensation [VipsOption.Boolean] Enable black point compensation
  /// @optionalArg embedded [VipsOption.Boolean] Use embedded input profile, if available
  /// @optionalArg input-profile [VipsOption.String] Filename to load input profile from
  /// @optionalArg depth [VipsOption.Int] Output device space depth in bits
  public VImage iccTransform(String outputProfile, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var outputProfileOption = VipsOption.String("output-profile", outputProfile);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(outputProfileOption);
    VipsInvoker.invokeOperation(arena, "icc_transform", callArgs);
    return outOption.valueOrThrow();
  }

  /// Creates an identity lookup table, ie. one which will leave an image
  /// unchanged when applied with [VImage#maplut]. Each entry in the table
  /// has a value equal to its position.
  ///
  /// Use the arithmetic operations on these tables to make LUTs representing
  /// arbitrary functions.
  ///
  /// Normally LUTs are 8-bit. Set `ushort` to create a 16-bit table.
  ///
  /// Normally 16-bit tables have 65536 entries. You can set this smaller with
  /// `size`.
  ///
  /// See also: [VImage#xyz], [VImage#maplut]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg bands [VipsOption.Int] Number of bands in LUT
  /// @optionalArg ushort [VipsOption.Boolean] Create a 16-bit LUT
  /// @optionalArg size [VipsOption.Int] Size of 16-bit LUT
  public static VImage identity(Arena arena, VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "identity", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation scans the condition image `cond`
  /// and uses it to select pixels from either the then image `in1` or the else
  /// image `in2`. Non-zero means `in1`, 0 means `in2`.
  ///
  /// Any image can have either 1 band or n bands, where n is the same for all
  /// the non-1-band images. Single band images are then effectively copied to
  /// make n-band images.
  ///
  /// Images `in1` and `in2` are cast up to the smallest common format. `cond` is
  /// cast to uchar.
  ///
  /// If the images differ in size, the smaller images are enlarged to match the
  /// largest by adding zero pixels along the bottom and right.
  ///
  /// If `blend` is `TRUE`, then values in `out` are smoothly blended between `in1`
  /// and `in2` using the formula:
  ///
  /// ```
  /// out = (cond / 255) * in1 + (1 - cond / 255) * in2
  /// ```
  ///
  /// See also: `Image.equal`
  /// @param in1 Source for TRUE pixels
  /// @param in2 Source for FALSE pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg blend [VipsOption.Boolean] Blend smoothly between then and else parts
  public VImage ifthenelse(VImage in1, VImage in2, VipsOption... args) throws VipsError {
    var condOption = VipsOption.Image("cond", this);
    var in1Option = VipsOption.Image("in1", in1);
    var in2Option = VipsOption.Image("in2", in2);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(condOption);
    callArgs.add(in1Option);
    callArgs.add(in2Option);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "ifthenelse", callArgs);
    return outOption.valueOrThrow();
  }

  /// Insert `sub` into `main` at position `x`, `y`.
  ///
  /// Normally `out` shows the whole of `main`. If `expand` is `TRUE` then `out` is
  /// made large enough to hold all of `main` and `sub`.
  /// Any areas of `out` not coming from
  /// either `main` or `sub` are set to `background` (default 0).
  ///
  /// If `sub` overlaps `main`,
  /// `sub` will appear on top of `main`.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The two input images are cast up to the smallest common type (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)).
  ///
  /// See also: [VImage#join], [VImage#embed], [VImage#extractArea]
  /// @param sub Sub-image to insert into main image
  /// @param x Left edge of sub in main
  /// @param y Top edge of sub in main
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg expand [VipsOption.Boolean] Expand output to hold all of both inputs
  /// @optionalArg background [VipsOption.ArrayDouble] Color for new pixels
  public VImage insert(VImage sub, int x, int y, VipsOption... args) throws VipsError {
    var mainOption = VipsOption.Image("main", this);
    var subOption = VipsOption.Image("sub", sub);
    var outOption = VipsOption.Image("out");
    var xOption = VipsOption.Int("x", x);
    var yOption = VipsOption.Int("y", y);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(mainOption);
    callArgs.add(subOption);
    callArgs.add(outOption);
    callArgs.add(xOption);
    callArgs.add(yOption);
    VipsInvoker.invokeOperation(arena, "insert", callArgs);
    return outOption.valueOrThrow();
  }

  /// For unsigned formats, this operation calculates (max - `in`), eg. (255 -
  /// `in`) for uchar. For signed and float formats, this operation calculates (-1
  /// `in`).
  ///
  /// For complex images, only the real part is inverted. See also `Image.conj`.
  ///
  /// See also: [VImage#linear]
  /// @param args Array of VipsOption to apply to this operation
  public VImage invert(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "invert", callArgs);
    return outOption.valueOrThrow();
  }

  /// Given a mask of target values and real values, generate a LUT which
  /// will map reals to targets.
  ///
  /// Handy for linearising images from measurements of a colour chart. All
  /// values in [0,1]. Piecewise linear interpolation, extrapolate head and tail
  /// to 0 and 1.
  ///
  /// Eg. input like this:
  ///
  /// ```
  /// 4 3
  /// 0.1 0.2 0.3 0.1
  /// 0.2 0.4 0.4 0.2
  /// 0.7 0.5 0.6 0.3
  /// ```
  ///
  /// Means a patch with 10% reflectance produces an image with 20% in
  /// channel 1, 30% in channel 2, and 10% in channel 3, and so on.
  ///
  /// Inputs don't need to be sorted (we do that). Generate any precision
  /// LUT, default to 256 elements.
  ///
  /// It won't work too well for non-monotonic camera responses
  /// (we should fix this). Interpolation is simple piecewise linear; we ought to
  /// do something better really.
  ///
  /// See also: [VImage#buildlut]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg size [VipsOption.Int] LUT size to generate
  public VImage invertlut(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "invertlut", callArgs);
    return outOption.valueOrThrow();
  }

  /// Transform an image from Fourier space to real space.
  ///
  /// The result is complex. If you are OK with a real result, set `real`,
  /// it's quicker.
  ///
  /// VIPS uses the fftw Fourier Transform library. If this library was not
  /// available when VIPS was configured, these functions will fail.
  ///
  /// See also: [VImage#fwfft]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg real [VipsOption.Boolean] Output only the real part of the transform
  public VImage invfft(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "invfft", callArgs);
    return outOption.valueOrThrow();
  }

  /// Join `in1` and `in2` together, left-right or up-down depending on the value
  /// of `direction`.
  ///
  /// If one is taller or wider than the
  /// other, `out` will be has high as the smaller. If `expand` is `TRUE`, then
  /// the output will be expanded to contain all of the input pixels.
  ///
  /// Use `align` to set the edge that the images align on. By default, they align
  /// on the edge with the lower value coordinate.
  ///
  /// Use `background` to set the colour of any pixels in `out` which are not
  /// present in either `in1` or `in2`.
  ///
  /// Use `shim` to set the spacing between the images. By default this is 0.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The two input images are cast up to the smallest common type (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)).
  ///
  /// If you are going to be joining many thousands of images in a regular
  /// grid, [VImage#arrayjoin] is a better choice.
  ///
  /// See also: [VImage#arrayjoin], [VImage#insert]
  /// @param in2 Second input image
  /// @param direction [VipsDirection] Join left-right or up-down
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg expand [VipsOption.Boolean] Expand output to hold all of both inputs
  /// @optionalArg shim [VipsOption.Int] Pixels between images
  /// @optionalArg background [VipsOption.ArrayDouble] Colour for new pixels
  /// @optionalArg align [VipsOption.Enum] [VipsAlign] Align on the low, centre or high coordinate edge
  public VImage join(VImage in2, VipsDirection direction, VipsOption... args) throws VipsError {
    var in1Option = VipsOption.Image("in1", this);
    var in2Option = VipsOption.Image("in2", in2);
    var outOption = VipsOption.Image("out");
    var directionOption = VipsOption.Enum("direction", direction);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(in1Option);
    callArgs.add(in2Option);
    callArgs.add(outOption);
    callArgs.add(directionOption);
    VipsInvoker.invokeOperation(arena, "join", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a JPEG2000 image.
  ///
  /// The loader supports 8, 16 and 32-bit int pixel
  /// values, signed and unsigned. It supports greyscale, RGB, YCC, CMYK and
  /// multispectral colour spaces. It will read any ICC profile on the image.
  ///
  /// It will only load images where all channels have the same format.
  ///
  /// Use `page` to set the page to load, where page 0 is the base resolution
  /// image and higher-numbered pages are x2 reductions. Use the metadata item
  /// "n-pages" to find the number of pyramid layers.
  ///
  /// Some versions of openjpeg can fail to decode some tiled images correctly.
  /// Setting `oneshot` will force the loader to decode tiled images in a single
  /// operation and can improve compatibility.
  ///
  /// Use `fail_on` to set the type of error that will cause load to fail. By
  /// default, loaders are permissive, that is, [VipsFailOn#FAIL_ON_NONE].
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] Load this page from the image
  /// @optionalArg oneshot [VipsOption.Boolean] Load images a frame at a time
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage jp2kload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jp2kload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#jp2kload], but read from a buffer.
  ///
  /// You must not free the buffer while `out` is active. The
  /// `Object::postclose` signal on `out` is a good place to free.
  ///
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] Load this page from the image
  /// @optionalArg oneshot [VipsOption.Boolean] Load images a frame at a time
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage jp2kloadBuffer(Arena arena, VBlob buffer, VipsOption... args) throws
      VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jp2kload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#jp2kload], but read from a source.
  ///
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] Load this page from the image
  /// @optionalArg oneshot [VipsOption.Boolean] Load images a frame at a time
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage jp2kloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jp2kload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Write a VIPS image to a file in JPEG2000 format.
  ///
  /// The saver supports 8, 16 and 32-bit int pixel
  /// values, signed and unsigned. It supports greyscale, RGB, CMYK and
  /// multispectral images.
  ///
  /// Use `Q` to set the compression quality factor. The default value
  /// produces file with approximately the same size as regular JPEG Q 75.
  ///
  /// Set `lossless` to enable lossless compression.
  ///
  /// Use `tile_width` and `tile_height` to set the tile size. The default is 512.
  ///
  /// Chroma subsampling is normally disabled for compatibility. Set
  /// `subsample_mode` to auto to enable chroma subsample for Q < 90. Subsample
  /// mode uses YCC rather than RGB colourspace, and many jpeg2000 decoders do
  /// not support this.
  ///
  /// This operation always writes a pyramid.
  ///
  /// See also: `Image.write_to_file`, [VImage#jp2kload]
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg tile-width [VipsOption.Int] Tile width in pixels
  /// @optionalArg tile-height [VipsOption.Int] Tile height in pixels
  /// @optionalArg lossless [VipsOption.Boolean] Enable lossless compression
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg subsample-mode [VipsOption.Enum] [VipsForeignSubsample] Select chroma subsample operation mode
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void jp2ksave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "jp2ksave", callArgs);
  }

  /// As [VImage#jp2ksave], but save to a target.
  ///
  /// See also: [VImage#jp2ksave], `Image.write_to_target`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg tile-width [VipsOption.Int] Tile width in pixels
  /// @optionalArg tile-height [VipsOption.Int] Tile height in pixels
  /// @optionalArg lossless [VipsOption.Boolean] Enable lossless compression
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg subsample-mode [VipsOption.Enum] [VipsForeignSubsample] Select chroma subsample operation mode
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public VBlob jp2ksaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "jp2ksave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /// As [VImage#jp2ksave], but save to a target.
  ///
  /// See also: [VImage#jp2ksave], `Image.write_to_target`
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg tile-width [VipsOption.Int] Tile width in pixels
  /// @optionalArg tile-height [VipsOption.Int] Tile height in pixels
  /// @optionalArg lossless [VipsOption.Boolean] Enable lossless compression
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg subsample-mode [VipsOption.Enum] [VipsForeignSubsample] Select chroma subsample operation mode
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void jp2ksaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "jp2ksave_target", callArgs);
  }

  /// Read a JPEG file into a VIPS image. It can read most 8-bit JPEG images,
  /// including CMYK and YCbCr.
  ///
  /// `shrink` means shrink by this integer factor during load.  Possible values
  /// are 1, 2, 4 and 8. Shrinking during read is very much faster than
  /// decompressing the whole image and then shrinking later.
  ///
  /// Use `fail_on` to set the type of error that will cause load to fail. By
  /// default, loaders are permissive, that is, [VipsFailOn#FAIL_ON_NONE].
  ///
  /// Setting `autorotate` to `TRUE` will make the loader interpret the
  /// orientation tag and automatically rotate the image appropriately during
  /// load.
  ///
  /// If `autorotate` is `FALSE`, the metadata field `META_ORIENTATION` is set
  /// to the value of the orientation tag. Applications may read and interpret
  /// this field
  /// as they wish later in processing. See [VImage#autorot]. Save
  /// operations will use `META_ORIENTATION`, if present, to set the
  /// orientation of output images.
  ///
  /// Example:
  ///
  /// ```c
  /// vips_jpegload("fred.jpg", &out,
  ///     "shrink", 8,
  ///     "fail_on", VIPS_FAIL_ON_TRUNCATED,
  ///     NULL);
  /// ```
  ///
  /// Any embedded ICC profiles are ignored: you always just get the RGB from
  /// the file. Instead, the embedded profile will be attached to the image as
  /// `META_ICC_NAME`. You need to use something like
  /// [VImage#iccImport] to get CIE values from the file.
  ///
  /// EXIF metadata is attached as `META_EXIF_NAME`, IPTC as
  /// `META_IPTC_NAME`, and XMP as `META_XMP_NAME`.
  ///
  /// The int metadata item "jpeg-multiscan" is set to the result of
  /// `jpeg_has_multiple_scans()`. Interlaced jpeg images need a large amount of
  /// memory to load, so this field gives callers a chance to handle these
  /// images differently.
  ///
  /// The string-valued field "jpeg-chroma-subsample" gives the chroma subsample
  /// in standard notation. 4:4:4 means no subsample, 4:2:0 means YCbCr with
  /// Cb and Cr subsampled horizontally and vertically, 4:4:4:4 means a CMYK
  /// image with no subsampling.
  ///
  /// The EXIF thumbnail, if present, is attached to the image as
  /// "jpeg-thumbnail-data". See `Image.get_blob`.
  ///
  /// See also: [VImage#jpegloadBuffer], [VImage#autorot]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg shrink [VipsOption.Int] Shrink factor on load
  /// @optionalArg autorotate [VipsOption.Boolean] Rotate image using exif orientation
  /// @optionalArg unlimited [VipsOption.Boolean] Remove all denial of service limits
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage jpegload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jpegload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a JPEG-formatted memory block into a VIPS image. Exactly as
  /// [VImage#jpegload], but read from a memory buffer.
  ///
  /// You must not free the buffer while `out` is active. The
  /// `Object::postclose` signal on `out` is a good place to free.
  ///
  /// See also: [VImage#jpegload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg shrink [VipsOption.Int] Shrink factor on load
  /// @optionalArg autorotate [VipsOption.Boolean] Rotate image using exif orientation
  /// @optionalArg unlimited [VipsOption.Boolean] Remove all denial of service limits
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage jpegloadBuffer(Arena arena, VBlob buffer, VipsOption... args) throws
      VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jpegload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a JPEG-formatted memory block into a VIPS image. Exactly as
  /// [VImage#jpegload], but read from a source.
  ///
  /// See also: [VImage#jpegload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg shrink [VipsOption.Int] Shrink factor on load
  /// @optionalArg autorotate [VipsOption.Boolean] Rotate image using exif orientation
  /// @optionalArg unlimited [VipsOption.Boolean] Remove all denial of service limits
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage jpegloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jpegload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Write a VIPS image to a file as JPEG.
  ///
  /// Use `Q` to set the JPEG compression factor. Default 75.
  ///
  /// If `optimize_coding` is set, the Huffman tables are optimized. This is
  /// slightly slower and produces slightly smaller files.
  ///
  /// If `interlace` is set, the jpeg files will be interlaced (progressive jpeg,
  /// in jpg parlance). These files may be better for display over a slow network
  /// connection, but need much more memory to encode and decode.
  ///
  /// Chroma subsampling is normally automatically disabled for Q >= 90. You can
  /// force the subsampling mode with `subsample_mode`.
  ///
  /// If `trellis_quant` is set and the version of libjpeg supports it
  /// (e.g. mozjpeg >= 3.0), apply trellis quantisation to each 8x8 block.
  /// Reduces file size but increases compression time.
  ///
  /// If `overshoot_deringing` is set and the version of libjpeg supports it
  /// (e.g. mozjpeg >= 3.0), apply overshooting to samples with extreme values
  /// for example 0 and 255 for 8-bit. Overshooting may reduce ringing artifacts
  /// from compression, in particular in areas where black text appears on a
  /// white background.
  ///
  /// If `optimize_scans` is set and the version of libjpeg supports it
  /// (e.g. mozjpeg >= 3.0), split the spectrum of DCT coefficients into
  /// separate scans. Reduces file size but increases compression time.
  ///
  /// If `quant_table` is set and the version of libjpeg supports it
  /// (e.g. mozjpeg >= 3.0) it selects the quantization table to use:
  ///
  /// - 0 — Tables from JPEG Annex K (vips and libjpeg default)
  /// - 1 — Flat table
  /// - 2 — Table tuned for MSSIM on Kodak image set
  /// - 3 — Table from ImageMagick by N. Robidoux (current mozjpeg default)
  /// - 4 — Table tuned for PSNR-HVS-M on Kodak image set
  /// - 5 — Table from Relevance of Human Vision to JPEG-DCT Compression (1992)
  /// - 6 — Table from DCTune Perceptual Optimization of Compressed Dental
  ///   X-Rays (1997)
  /// - 7 — Table from A Visual Detection Model for DCT Coefficient
  ///   Quantization (1993)
  /// - 8 — Table from An Improved Detection Model for DCT Coefficient
  ///   Quantization (1993)
  ///
  /// Quantization table 0 is the default in vips and libjpeg(-turbo), but it
  /// tends to favor detail over color accuracy, producing colored patches and
  /// stripes as well as heavy banding in flat areas at high compression ratios.
  /// Quantization table 2 is a good candidate to try if the default quantization
  /// table produces banding or color shifts and is well suited for hires images.
  /// Quantization table 3 is the default in mozjpeg and has been tuned to produce
  /// good results at the default quality setting; banding at high compression.
  /// Quantization table 4 is the most accurate at the cost of compression ratio.
  /// Tables 5-7 are based on older research papers, but generally achieve worse
  /// compression ratios and/or quality than 2 or 4.
  ///
  /// For maximum compression with mozjpeg, a useful set of options is `strip,
  /// optimize-coding, interlace, optimize-scans, trellis-quant, quant_table=3`.
  ///
  /// By default, the output stream won't have restart markers.  If a non-zero
  /// restart_interval is specified, a restart marker will be added after each
  /// specified number of MCU blocks.  This makes the stream more recoverable
  /// if there are transmission errors, but also allows for some decoders to read
  /// part of the JPEG without decoding the whole stream.
  ///
  /// The image is automatically converted to RGB, Monochrome or CMYK before
  /// saving.
  ///
  /// EXIF data is constructed from `META_EXIF_NAME`, then
  /// modified with any other related tags on the image before being written to
  /// the file. `META_RESOLUTION_UNIT` is used to set the EXIF resolution
  /// unit. `META_ORIENTATION` is used to set the EXIF orientation tag.
  ///
  /// IPTC as `META_IPTC_NAME` and XMP as `META_XMP_NAME`
  /// are coded and attached.
  ///
  /// See also: [VImage#jpegsaveBuffer], `Image.write_to_file`
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg optimize-coding [VipsOption.Boolean] Compute optimal Huffman coding tables
  /// @optionalArg interlace [VipsOption.Boolean] Generate an interlaced (progressive) jpeg
  /// @optionalArg no-subsample [VipsOption.Boolean] Disable chroma subsample
  /// @optionalArg trellis-quant [VipsOption.Boolean] Apply trellis quantisation to each 8x8 block
  /// @optionalArg overshoot-deringing [VipsOption.Boolean] Apply overshooting to samples with extreme values
  /// @optionalArg optimize-scans [VipsOption.Boolean] Split spectrum of DCT coefficients into separate scans
  /// @optionalArg quant-table [VipsOption.Int] Use predefined quantization table with given index
  /// @optionalArg subsample-mode [VipsOption.Enum] [VipsForeignSubsample] Select chroma subsample operation mode
  /// @optionalArg restart-interval [VipsOption.Int] Add restart markers every specified number of mcu
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void jpegsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "jpegsave", callArgs);
  }

  /// As [VImage#jpegsave], but save to a memory buffer.
  ///
  /// The address of the buffer is returned in `obuf`, the length of the buffer in
  /// `olen`. You are responsible for freeing the buffer with `GLib.free`
  /// when you are done with it.
  ///
  /// See also: [VImage#jpegsave], `Image.write_to_file`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg optimize-coding [VipsOption.Boolean] Compute optimal Huffman coding tables
  /// @optionalArg interlace [VipsOption.Boolean] Generate an interlaced (progressive) jpeg
  /// @optionalArg no-subsample [VipsOption.Boolean] Disable chroma subsample
  /// @optionalArg trellis-quant [VipsOption.Boolean] Apply trellis quantisation to each 8x8 block
  /// @optionalArg overshoot-deringing [VipsOption.Boolean] Apply overshooting to samples with extreme values
  /// @optionalArg optimize-scans [VipsOption.Boolean] Split spectrum of DCT coefficients into separate scans
  /// @optionalArg quant-table [VipsOption.Int] Use predefined quantization table with given index
  /// @optionalArg subsample-mode [VipsOption.Enum] [VipsForeignSubsample] Select chroma subsample operation mode
  /// @optionalArg restart-interval [VipsOption.Int] Add restart markers every specified number of mcu
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public VBlob jpegsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "jpegsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /// As [VImage#jpegsave], but save as a mime jpeg on stdout.
  ///
  /// See also: [VImage#jpegsave], `Image.write_to_file`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg optimize-coding [VipsOption.Boolean] Compute optimal Huffman coding tables
  /// @optionalArg interlace [VipsOption.Boolean] Generate an interlaced (progressive) jpeg
  /// @optionalArg no-subsample [VipsOption.Boolean] Disable chroma subsample
  /// @optionalArg trellis-quant [VipsOption.Boolean] Apply trellis quantisation to each 8x8 block
  /// @optionalArg overshoot-deringing [VipsOption.Boolean] Apply overshooting to samples with extreme values
  /// @optionalArg optimize-scans [VipsOption.Boolean] Split spectrum of DCT coefficients into separate scans
  /// @optionalArg quant-table [VipsOption.Int] Use predefined quantization table with given index
  /// @optionalArg subsample-mode [VipsOption.Enum] [VipsForeignSubsample] Select chroma subsample operation mode
  /// @optionalArg restart-interval [VipsOption.Int] Add restart markers every specified number of mcu
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void jpegsaveMime(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    VipsInvoker.invokeOperation(arena, "jpegsave_mime", callArgs);
  }

  /// As [VImage#jpegsave], but save to a target.
  ///
  /// See also: [VImage#jpegsave], `Image.write_to_target`
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg optimize-coding [VipsOption.Boolean] Compute optimal Huffman coding tables
  /// @optionalArg interlace [VipsOption.Boolean] Generate an interlaced (progressive) jpeg
  /// @optionalArg no-subsample [VipsOption.Boolean] Disable chroma subsample
  /// @optionalArg trellis-quant [VipsOption.Boolean] Apply trellis quantisation to each 8x8 block
  /// @optionalArg overshoot-deringing [VipsOption.Boolean] Apply overshooting to samples with extreme values
  /// @optionalArg optimize-scans [VipsOption.Boolean] Split spectrum of DCT coefficients into separate scans
  /// @optionalArg quant-table [VipsOption.Int] Use predefined quantization table with given index
  /// @optionalArg subsample-mode [VipsOption.Enum] [VipsForeignSubsample] Select chroma subsample operation mode
  /// @optionalArg restart-interval [VipsOption.Int] Add restart markers every specified number of mcu
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void jpegsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "jpegsave_target", callArgs);
  }

  /// Read a JPEG-XL image.
  ///
  /// The JPEG-XL loader and saver are experimental features and may change
  /// in future libvips versions.
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage jxlload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jxlload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#jxlload], but read from a buffer.
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage jxlloadBuffer(Arena arena, VBlob buffer, VipsOption... args) throws
      VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jxlload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#jxlload], but read from a source.
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage jxlloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jxlload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Write a VIPS image to a file in JPEG-XL format.
  ///
  /// The JPEG-XL loader and saver are experimental features and may change
  /// in future libvips versions.
  ///
  /// `tier` sets the overall decode speed the encoder will target. Minimum is 0
  /// (highest quality), and maximum is 4 (lowest quality). Default is 0.
  ///
  /// `distance` sets the target maximum encoding error. Minimum is 0
  /// (highest quality), and maximum is 15 (lowest quality). Default is 1.0
  /// (visually lossless).
  ///
  /// As a convenience, you can also use `Q` to set `distance`. `Q` uses
  /// approximately the same scale as regular JPEG.
  ///
  /// Set `lossless` to enable lossless compression.
  ///
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg tier [VipsOption.Int] Decode speed tier
  /// @optionalArg distance [VipsOption.Double] Target butteraugli distance
  /// @optionalArg effort [VipsOption.Int] Encoding effort
  /// @optionalArg lossless [VipsOption.Boolean] Enable lossless compression
  /// @optionalArg Q [VipsOption.Int] Quality factor
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void jxlsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "jxlsave", callArgs);
  }

  /// As [VImage#jxlsave], but save to a memory buffer.
  ///
  /// See also: [VImage#jxlsave], `Image.write_to_target`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg tier [VipsOption.Int] Decode speed tier
  /// @optionalArg distance [VipsOption.Double] Target butteraugli distance
  /// @optionalArg effort [VipsOption.Int] Encoding effort
  /// @optionalArg lossless [VipsOption.Boolean] Enable lossless compression
  /// @optionalArg Q [VipsOption.Int] Quality factor
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public VBlob jxlsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "jxlsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /// As [VImage#jxlsave], but save to a target.
  ///
  /// See also: [VImage#jxlsave], `Image.write_to_target`
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg tier [VipsOption.Int] Decode speed tier
  /// @optionalArg distance [VipsOption.Double] Target butteraugli distance
  /// @optionalArg effort [VipsOption.Int] Encoding effort
  /// @optionalArg lossless [VipsOption.Boolean] Enable lossless compression
  /// @optionalArg Q [VipsOption.Int] Quality factor
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void jxlsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "jxlsave_target", callArgs);
  }

  /// Label regions of equal pixels in an image.
  ///
  /// Repeatedly scans `in` for regions of 4-connected pixels
  /// with the same pixel value. Every time a region is discovered, those
  /// pixels are marked in `mask` with a unique serial number. Once all pixels
  /// have been labelled, the operation returns, setting `segments` to the number
  /// of discrete regions which were detected.
  ///
  /// `mask` is always a 1-band [VipsBandFormat#FORMAT_INT] image of the same
  /// dimensions as `in`.
  ///
  /// This operation is useful for, for example, blob counting. You can use the
  /// morphological operators to detect and isolate a series of objects, then use
  /// [VImage#labelregions] to number them all.
  ///
  /// Use [VImage#histFindIndexed] to (for example) find blob coordinates.
  ///
  /// See also: [VImage#histFindIndexed]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg segments [VipsOption.Int] Number of discrete contiguous regions
  public VImage labelregions(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var maskOption = VipsOption.Image("mask");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "labelregions", callArgs);
    return maskOption.valueOrThrow();
  }

  /// Pass an image through a linear transform, ie. (@out = `in` * `a` + `b`). Output
  /// is float for integer input, double for double input, complex for
  /// complex input and double complex for double complex input. Set `uchar` to
  /// output uchar pixels.
  ///
  /// If the arrays of constants have just one element, that constant is used for
  /// all image bands. If the arrays have more than one element and they have
  /// the same number of elements as there are bands in the image, then
  /// one array element is used for each band. If the arrays have more than one
  /// element and the image only has a single band, the result is a many-band
  /// image where each band corresponds to one array element.
  ///
  /// See also: `Image.linear1`, [VImage#add]
  /// @param a Multiply by this
  /// @param b Add this
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output should be uchar
  public VImage linear(List<Double> a, List<Double> b, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var aOption = VipsOption.ArrayDouble("a", a);
    var bOption = VipsOption.ArrayDouble("b", b);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(aOption);
    callArgs.add(bOption);
    VipsInvoker.invokeOperation(arena, "linear", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation behaves rather like [VImage#copy] between images
  /// `in` and `out`, except that it keeps a cache of computed scanlines.
  ///
  /// The number of lines cached is enough for a small amount of non-local
  /// access.
  ///
  /// Each cache tile is made with a single call to `Region.prepare`.
  ///
  /// When the cache fills, a tile is chosen for reuse. If `access` is
  /// [VipsAccess#ACCESS_RANDOM], then the least-recently-used tile is reused. If
  /// `access` is [VipsAccess#ACCESS_SEQUENTIAL], then
  /// the top-most tile is reused. `access` defaults to [VipsAccess#ACCESS_RANDOM].
  ///
  /// `tile_height` can be used to set the size of the strips that
  /// [VImage#linecache] uses. The default is 1 (a single scanline).
  ///
  /// Normally, only a single thread at once is allowed to calculate tiles. If
  /// you set `threaded` to `TRUE`, [VImage#linecache] will allow many
  /// threads to calculate tiles at once and share the cache between them.
  ///
  /// See also: [VImage#tilecache]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg tile-height [VipsOption.Int] Tile height in pixels
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Expected access pattern
  /// @optionalArg threaded [VipsOption.Boolean] Allow threaded access
  /// @optionalArg persistent [VipsOption.Boolean] Keep cache between evaluations
  public VImage linecache(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "linecache", callArgs);
    return outOption.valueOrThrow();
  }

  /// Create a circularly symmetric Laplacian of Gaussian mask of radius
  /// `sigma`.
  ///
  /// The size of the mask is determined by the variable `min_ampl`;
  /// if for instance the value .1 is entered this means that the produced mask
  /// is clipped at values within 10 percent of zero, and where the change
  /// between mask elements is less than 10%.
  ///
  /// The program uses the following equation: (from Handbook of Pattern
  /// Recognition and image processing by Young and Fu, AP 1986 pages 220-221):
  ///
  /// ```
  /// H(r) = (1 / (2 * M_PI * s4)) * (2 - (r2 / s2)) * exp(-r2 / (2 * s2))
  /// ```
  ///
  /// where:
  ///
  /// ```
  /// 2 = `sigma` * `sigma`,
  /// s4 = s2 * s2
  /// r2 = r * r.
  /// ```
  ///
  /// The generated mask has odd size and its maximum value is normalised to
  /// 1.0, unless `precision` is [VipsPrecision#PRECISION_INTEGER].
  ///
  /// If `separable` is set, only the centre horizontal is generated. This is
  /// useful for separable convolutions.
  ///
  /// If `precision` is [VipsPrecision#PRECISION_INTEGER], an integer mask is generated.
  /// This is useful for integer convolutions.
  ///
  /// "scale" is set to the sum of all the mask elements.
  ///
  /// See also: [VImage#gaussmat], [VImage#conv]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param sigma Radius of Gaussian
  /// @param minAmpl Minimum amplitude of Gaussian
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg separable [VipsOption.Boolean] Generate separable Gaussian
  /// @optionalArg integer [VipsOption.Boolean] Generate integer Gaussian
  /// @optionalArg precision [VipsOption.Enum] [VipsPrecision] Generate with this precision
  public static VImage logmat(Arena arena, double sigma, double minAmpl, VipsOption... args) throws
      VipsError {
    var outOption = VipsOption.Image("out");
    var sigmaOption = VipsOption.Double("sigma", sigma);
    var minAmplOption = VipsOption.Double("min-ampl", minAmpl);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(sigmaOption);
    callArgs.add(minAmplOption);
    VipsInvoker.invokeOperation(arena, "logmat", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read in an image using libMagick, the ImageMagick library.
  ///
  /// This library can read more than 80 file formats, including BMP, EPS,
  /// DICOM and many others.
  /// The reader can handle any ImageMagick image, including the float and double
  /// formats. It will work with any quantum size, including HDR. Any metadata
  /// attached to the libMagick image is copied on to the VIPS image.
  ///
  /// The reader should also work with most versions of GraphicsMagick. See the
  /// `-Dmagick-package` configure option.
  ///
  /// The file format is usually guessed from the filename suffix, or sniffed
  /// from the file contents.
  ///
  /// Normally it will only load the first image in a many-image sequence (such
  /// as a GIF or a PDF). Use `page` and `n` to set the start page and number of
  /// pages to load. Set `n` to -1 to load all pages from `page` onwards.
  ///
  /// `density` is "WxH" in DPI, e.g. "600x300" or "600" (default is "72x72"). See
  /// the [density
  /// docs](http://www.imagemagick.org/script/command-line-options.php#density)
  /// on the imagemagick website.
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg density [VipsOption.String] Canvas resolution for rendering vector formats like SVG
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg all-frames [VipsOption.Boolean] Read all frames from an image
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage magickload(Arena arena, String filename, VipsOption... args) throws
      VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "magickload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read an image memory block using libMagick into a VIPS image. Exactly as
  /// [VImage#magickload], but read from a memory source.
  ///
  /// You must not free the buffer while `out` is active. The
  /// `Object::postclose` signal on `out` is a good place to free.
  ///
  /// See also: [VImage#magickload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg density [VipsOption.String] Canvas resolution for rendering vector formats like SVG
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg all-frames [VipsOption.Boolean] Read all frames from an image
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage magickloadBuffer(Arena arena, VBlob buffer, VipsOption... args) throws
      VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "magickload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Write an image using libMagick.
  ///
  /// Use `quality` to set the quality factor. Default 0.
  ///
  /// Use `format` to explicitly set the save format, for example, "BMP". Otherwise
  /// the format is guessed from the filename suffix.
  ///
  /// If `optimize_gif_frames` is set, GIF frames are cropped to the smallest size
  /// while preserving the results of the GIF animation. This takes some time for
  /// computation but saves some time on encoding and produces smaller files in
  /// some cases.
  ///
  /// If `optimize_gif_transparency` is set, pixels that don't change the image
  /// through animation are made transparent. This takes some time for computation
  /// but saves some time on encoding and produces smaller files in some cases.
  ///
  /// `bitdepth` specifies the number of bits per pixel. The image will be quantized
  /// and dithered if the value is within the valid range (1 to 8).
  ///
  /// See also: [VImage#magicksaveBuffer], [VImage#magickload]
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg format [VipsOption.String] Format to save in
  /// @optionalArg quality [VipsOption.Int] Quality to use
  /// @optionalArg optimize-gif-frames [VipsOption.Boolean] Apply GIF frames optimization
  /// @optionalArg optimize-gif-transparency [VipsOption.Boolean] Apply GIF transparency optimization
  /// @optionalArg bitdepth [VipsOption.Int] Number of bits per pixel
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void magicksave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "magicksave", callArgs);
  }

  /// As [VImage#magicksave], but save to a memory buffer.
  ///
  /// The address of the buffer is returned in `obuf`, the length of the buffer in
  /// `olen`. You are responsible for freeing the buffer with `GLib.free`
  /// when you are done with it.
  ///
  /// See also: [VImage#magicksave], `Image.write_to_file`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg format [VipsOption.String] Format to save in
  /// @optionalArg quality [VipsOption.Int] Quality to use
  /// @optionalArg optimize-gif-frames [VipsOption.Boolean] Apply GIF frames optimization
  /// @optionalArg optimize-gif-transparency [VipsOption.Boolean] Apply GIF transparency optimization
  /// @optionalArg bitdepth [VipsOption.Int] Number of bits per pixel
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public VBlob magicksaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "magicksave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /// This operator resamples `in` using `index` to look up pixels.
  ///
  /// `out` is the same size as `index`, with each pixel being fetched from that
  /// position in `in`. That is:
  ///
  /// ```
  /// out[x, y] = in[index[x, y]]
  /// ```
  ///
  /// If `index` has one band, that band must be complex. Otherwise, `index` must
  /// have two bands of any format.
  ///
  /// Coordinates in `index` are in pixels, with (0, 0) being the top-left corner
  /// of `in`, and with y increasing down the image. Use [VImage#xyz] to
  /// build index images.
  ///
  /// `interpolate` defaults to bilinear.
  ///
  /// By default, new pixels are filled with `background`. This defaults to
  /// zero (black). You can set other extend types with `extend`. [VipsExtend#EXTEND_COPY]
  /// is better for image upsizing.
  ///
  /// Image are normally treated as unpremultiplied, so this operation can be used
  /// directly on PNG images. If your images have been through
  /// [VImage#premultiply], set `premultiplied`.
  ///
  /// This operation does not change xres or yres. The image resolution needs to
  /// be updated by the application.
  ///
  /// See [VImage#maplut] for a 1D equivalent of this operation.
  ///
  /// See also: [VImage#xyz], [VImage#affine], [VImage#resize], [VImage#maplut], `Interpolate`
  /// @param index Index pixels with this
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg interpolate [VipsOption.Interpolate] Interpolate pixels with this
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg premultiplied [VipsOption.Boolean] Images have premultiplied alpha
  /// @optionalArg extend [VipsOption.Enum] [VipsExtend] How to generate the extra pixels
  public VImage mapim(VImage index, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var indexOption = VipsOption.Image("index", index);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(indexOption);
    VipsInvoker.invokeOperation(arena, "mapim", callArgs);
    return outOption.valueOrThrow();
  }

  /// Map an image through another image acting as a LUT (Look Up Table).
  /// The lut may have any type and the output image will be that type.
  ///
  /// The input image will be cast to one of the unsigned integer types, that is,
  /// [VipsBandFormat#FORMAT_UCHAR], [VipsBandFormat#FORMAT_USHORT] or [VipsBandFormat#FORMAT_UINT].
  ///
  /// If `lut` is too small for the input type (for example, if `in` is
  /// [VipsBandFormat#FORMAT_UCHAR] but `lut` only has 100 elements), the lut is padded out
  /// by copying the last element. Overflows are reported at the end of
  /// computation.
  /// If `lut` is too large, extra values are ignored.
  ///
  /// If `lut` has one band and `band` is -1 (the default), then all bands of `in`
  /// pass through `lut`. If `band` is >= 0, then just that band of `in` passes
  /// through `lut` and other bands are just copied.
  ///
  /// If `lut`
  /// has same number of bands as `in`, then each band is mapped
  /// separately. If `in` has one band, then `lut` may have many bands and
  /// the output will have the same number of bands as `lut`.
  ///
  /// See also: [VImage#histFind], [VImage#identity]
  /// @param lut Look-up table image
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg band [VipsOption.Int] Apply one-band lut to this band of in
  public VImage maplut(VImage lut, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var lutOption = VipsOption.Image("lut", lut);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(lutOption);
    VipsInvoker.invokeOperation(arena, "maplut", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make an butterworth high- or low-pass filter, that is, one with a variable,
  /// smooth transition
  /// positioned at `frequency_cutoff`, where `frequency_cutoff` is in
  /// range 0 - 1.
  ///
  /// The shape of the curve is controlled by
  /// `order` -- higher values give a sharper transition. See Gonzalez and Wintz,
  /// Digital Image Processing, 1987.
  ///
  /// See also: [VImage#maskIdeal]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param order Filter order
  /// @param frequencyCutoff Frequency cutoff
  /// @param amplitudeCutoff Amplitude cutoff
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  /// @optionalArg nodc [VipsOption.Boolean] Remove DC component
  /// @optionalArg reject [VipsOption.Boolean] Invert the sense of the filter
  /// @optionalArg optical [VipsOption.Boolean] Rotate quadrants to optical space
  public static VImage maskButterworth(Arena arena, int width, int height, double order,
      double frequencyCutoff, double amplitudeCutoff, VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var orderOption = VipsOption.Double("order", order);
    var frequencyCutoffOption = VipsOption.Double("frequency-cutoff", frequencyCutoff);
    var amplitudeCutoffOption = VipsOption.Double("amplitude-cutoff", amplitudeCutoff);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(orderOption);
    callArgs.add(frequencyCutoffOption);
    callArgs.add(amplitudeCutoffOption);
    VipsInvoker.invokeOperation(arena, "mask_butterworth", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make an butterworth band-pass or band-reject filter, that is, one with a
  /// variable, smooth transition positioned at `frequency_cutoff_x`,
  /// `frequency_cutoff_y`, of radius `radius`.
  ///
  /// The shape of the curve is controlled by
  /// `order` -- higher values give a sharper transition. See Gonzalez and Wintz,
  /// Digital Image Processing, 1987.
  ///
  /// See also: [VImage#maskIdeal]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param order Filter order
  /// @param frequencyCutoffX Frequency cutoff x
  /// @param frequencyCutoffY Frequency cutoff y
  /// @param radius Radius of circle
  /// @param amplitudeCutoff Amplitude cutoff
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  /// @optionalArg nodc [VipsOption.Boolean] Remove DC component
  /// @optionalArg reject [VipsOption.Boolean] Invert the sense of the filter
  /// @optionalArg optical [VipsOption.Boolean] Rotate quadrants to optical space
  public static VImage maskButterworthBand(Arena arena, int width, int height, double order,
      double frequencyCutoffX, double frequencyCutoffY, double radius, double amplitudeCutoff,
      VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var orderOption = VipsOption.Double("order", order);
    var frequencyCutoffXOption = VipsOption.Double("frequency-cutoff-x", frequencyCutoffX);
    var frequencyCutoffYOption = VipsOption.Double("frequency-cutoff-y", frequencyCutoffY);
    var radiusOption = VipsOption.Double("radius", radius);
    var amplitudeCutoffOption = VipsOption.Double("amplitude-cutoff", amplitudeCutoff);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(orderOption);
    callArgs.add(frequencyCutoffXOption);
    callArgs.add(frequencyCutoffYOption);
    callArgs.add(radiusOption);
    callArgs.add(amplitudeCutoffOption);
    VipsInvoker.invokeOperation(arena, "mask_butterworth_band", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make a butterworth ring-pass or ring-reject filter, that is, one with a
  /// variable,
  /// smooth transition
  /// positioned at `frequency_cutoff` of width `width`, where `frequency_cutoff` is
  /// in the range 0 - 1.
  ///
  /// The shape of the curve is controlled by
  /// `order` -- higher values give a sharper transition. See Gonzalez and Wintz,
  /// Digital Image Processing, 1987.
  ///
  /// See also: [VImage#maskIdeal]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param order Filter order
  /// @param frequencyCutoff Frequency cutoff
  /// @param amplitudeCutoff Amplitude cutoff
  /// @param ringwidth Ringwidth
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  /// @optionalArg nodc [VipsOption.Boolean] Remove DC component
  /// @optionalArg reject [VipsOption.Boolean] Invert the sense of the filter
  /// @optionalArg optical [VipsOption.Boolean] Rotate quadrants to optical space
  public static VImage maskButterworthRing(Arena arena, int width, int height, double order,
      double frequencyCutoff, double amplitudeCutoff, double ringwidth, VipsOption... args) throws
      VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var orderOption = VipsOption.Double("order", order);
    var frequencyCutoffOption = VipsOption.Double("frequency-cutoff", frequencyCutoff);
    var amplitudeCutoffOption = VipsOption.Double("amplitude-cutoff", amplitudeCutoff);
    var ringwidthOption = VipsOption.Double("ringwidth", ringwidth);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(orderOption);
    callArgs.add(frequencyCutoffOption);
    callArgs.add(amplitudeCutoffOption);
    callArgs.add(ringwidthOption);
    VipsInvoker.invokeOperation(arena, "mask_butterworth_ring", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation should be used to create fractal images by filtering the
  /// power spectrum of Gaussian white noise.
  ///
  /// See [VImage#gaussnoise].
  ///
  /// See also: [VImage#maskIdeal]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param fractalDimension Fractal dimension
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  /// @optionalArg nodc [VipsOption.Boolean] Remove DC component
  /// @optionalArg reject [VipsOption.Boolean] Invert the sense of the filter
  /// @optionalArg optical [VipsOption.Boolean] Rotate quadrants to optical space
  public static VImage maskFractal(Arena arena, int width, int height, double fractalDimension,
      VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var fractalDimensionOption = VipsOption.Double("fractal-dimension", fractalDimension);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(fractalDimensionOption);
    VipsInvoker.invokeOperation(arena, "mask_fractal", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make a gaussian high- or low-pass filter, that is, one with a variable,
  /// smooth transition positioned at `frequency_cutoff`.
  ///
  /// See also: [VImage#maskIdeal]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param frequencyCutoff Frequency cutoff
  /// @param amplitudeCutoff Amplitude cutoff
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  /// @optionalArg nodc [VipsOption.Boolean] Remove DC component
  /// @optionalArg reject [VipsOption.Boolean] Invert the sense of the filter
  /// @optionalArg optical [VipsOption.Boolean] Rotate quadrants to optical space
  public static VImage maskGaussian(Arena arena, int width, int height, double frequencyCutoff,
      double amplitudeCutoff, VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var frequencyCutoffOption = VipsOption.Double("frequency-cutoff", frequencyCutoff);
    var amplitudeCutoffOption = VipsOption.Double("amplitude-cutoff", amplitudeCutoff);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(frequencyCutoffOption);
    callArgs.add(amplitudeCutoffOption);
    VipsInvoker.invokeOperation(arena, "mask_gaussian", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make a gaussian band-pass or band-reject filter, that is, one with a
  /// variable, smooth transition positioned at `frequency_cutoff_x`,
  /// `frequency_cutoff_y`, of radius `radius`.
  ///
  /// See also: [VImage#maskIdeal]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param frequencyCutoffX Frequency cutoff x
  /// @param frequencyCutoffY Frequency cutoff y
  /// @param radius Radius of circle
  /// @param amplitudeCutoff Amplitude cutoff
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  /// @optionalArg nodc [VipsOption.Boolean] Remove DC component
  /// @optionalArg reject [VipsOption.Boolean] Invert the sense of the filter
  /// @optionalArg optical [VipsOption.Boolean] Rotate quadrants to optical space
  public static VImage maskGaussianBand(Arena arena, int width, int height, double frequencyCutoffX,
      double frequencyCutoffY, double radius, double amplitudeCutoff, VipsOption... args) throws
      VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var frequencyCutoffXOption = VipsOption.Double("frequency-cutoff-x", frequencyCutoffX);
    var frequencyCutoffYOption = VipsOption.Double("frequency-cutoff-y", frequencyCutoffY);
    var radiusOption = VipsOption.Double("radius", radius);
    var amplitudeCutoffOption = VipsOption.Double("amplitude-cutoff", amplitudeCutoff);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(frequencyCutoffXOption);
    callArgs.add(frequencyCutoffYOption);
    callArgs.add(radiusOption);
    callArgs.add(amplitudeCutoffOption);
    VipsInvoker.invokeOperation(arena, "mask_gaussian_band", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make a gaussian ring-pass or ring-reject filter, that is, one with a
  /// variable, smooth transition positioned at `frequency_cutoff` of width
  /// `ringwidth`.
  ///
  /// See also: [VImage#maskIdeal]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param frequencyCutoff Frequency cutoff
  /// @param amplitudeCutoff Amplitude cutoff
  /// @param ringwidth Ringwidth
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  /// @optionalArg nodc [VipsOption.Boolean] Remove DC component
  /// @optionalArg reject [VipsOption.Boolean] Invert the sense of the filter
  /// @optionalArg optical [VipsOption.Boolean] Rotate quadrants to optical space
  public static VImage maskGaussianRing(Arena arena, int width, int height, double frequencyCutoff,
      double amplitudeCutoff, double ringwidth, VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var frequencyCutoffOption = VipsOption.Double("frequency-cutoff", frequencyCutoff);
    var amplitudeCutoffOption = VipsOption.Double("amplitude-cutoff", amplitudeCutoff);
    var ringwidthOption = VipsOption.Double("ringwidth", ringwidth);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(frequencyCutoffOption);
    callArgs.add(amplitudeCutoffOption);
    callArgs.add(ringwidthOption);
    VipsInvoker.invokeOperation(arena, "mask_gaussian_ring", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make an ideal high- or low-pass filter, that is, one with a sharp cutoff
  /// positioned at `frequency_cutoff`, where `frequency_cutoff` is in
  /// the range 0 - 1.
  ///
  /// This operation creates a one-band float image of the specified size.
  /// The image has
  /// values in the range [0, 1] and is typically used for multiplying against
  /// frequency domain images to filter them.
  /// Masks are created with the DC component at (0, 0). The DC pixel always
  /// has the value 1.0.
  ///
  /// Set `nodc` to not set the DC pixel.
  ///
  /// Set `optical` to position the DC component in the centre of the image. This
  /// makes the mask suitable for multiplying against optical Fourier transforms.
  /// See [VImage#wrap].
  ///
  /// Set `reject` to invert the sense of
  /// the filter. For example, low-pass becomes low-reject.
  ///
  /// Set `uchar` to output an 8-bit unsigned char image rather than a
  /// float image. In this case, pixels are in the range [0 - 255].
  ///
  /// See also: [VImage#maskIdeal], [VImage#maskIdealRing], [VImage#maskIdealBand], [VImage#maskButterworth], [VImage#maskButterworthRing], [VImage#maskButterworthBand], [VImage#maskGaussian], [VImage#maskGaussianRing], [VImage#maskGaussianBand]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param frequencyCutoff Frequency cutoff
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  /// @optionalArg nodc [VipsOption.Boolean] Remove DC component
  /// @optionalArg reject [VipsOption.Boolean] Invert the sense of the filter
  /// @optionalArg optical [VipsOption.Boolean] Rotate quadrants to optical space
  public static VImage maskIdeal(Arena arena, int width, int height, double frequencyCutoff,
      VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var frequencyCutoffOption = VipsOption.Double("frequency-cutoff", frequencyCutoff);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(frequencyCutoffOption);
    VipsInvoker.invokeOperation(arena, "mask_ideal", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make an ideal band-pass or band-reject filter, that is, one with a
  /// sharp cutoff around the point `frequency_cutoff_x`, `frequency_cutoff_y`,
  /// of size `radius`.
  ///
  /// See also: [VImage#maskIdeal]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param frequencyCutoffX Frequency cutoff x
  /// @param frequencyCutoffY Frequency cutoff y
  /// @param radius Radius of circle
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  /// @optionalArg nodc [VipsOption.Boolean] Remove DC component
  /// @optionalArg reject [VipsOption.Boolean] Invert the sense of the filter
  /// @optionalArg optical [VipsOption.Boolean] Rotate quadrants to optical space
  public static VImage maskIdealBand(Arena arena, int width, int height, double frequencyCutoffX,
      double frequencyCutoffY, double radius, VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var frequencyCutoffXOption = VipsOption.Double("frequency-cutoff-x", frequencyCutoffX);
    var frequencyCutoffYOption = VipsOption.Double("frequency-cutoff-y", frequencyCutoffY);
    var radiusOption = VipsOption.Double("radius", radius);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(frequencyCutoffXOption);
    callArgs.add(frequencyCutoffYOption);
    callArgs.add(radiusOption);
    VipsInvoker.invokeOperation(arena, "mask_ideal_band", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make an ideal ring-pass or ring-reject filter, that is, one with a sharp
  /// ring positioned at `frequency_cutoff` of width `width`, where
  /// `frequency_cutoff` and `width` are expressed as the range 0 - 1.
  ///
  /// See also: [VImage#maskIdeal]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param frequencyCutoff Frequency cutoff
  /// @param ringwidth Ringwidth
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  /// @optionalArg nodc [VipsOption.Boolean] Remove DC component
  /// @optionalArg reject [VipsOption.Boolean] Invert the sense of the filter
  /// @optionalArg optical [VipsOption.Boolean] Rotate quadrants to optical space
  public static VImage maskIdealRing(Arena arena, int width, int height, double frequencyCutoff,
      double ringwidth, VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var frequencyCutoffOption = VipsOption.Double("frequency-cutoff", frequencyCutoff);
    var ringwidthOption = VipsOption.Double("ringwidth", ringwidth);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(frequencyCutoffOption);
    callArgs.add(ringwidthOption);
    VipsInvoker.invokeOperation(arena, "mask_ideal_ring", callArgs);
    return outOption.valueOrThrow();
  }

  /// Scale, rotate and translate `sec` so that the tie-points line up.
  ///
  /// If `search` is `TRUE`, before performing the transformation, the tie-points
  /// are improved by searching an area of `sec` of size `harea` for a
  /// match of size `hwindow` to `ref`.
  ///
  /// This function will only work well for small rotates and scales.
  ///
  /// @param sec Secondary image
  /// @param xr1 Position of first reference tie-point
  /// @param yr1 Position of first reference tie-point
  /// @param xs1 Position of first secondary tie-point
  /// @param ys1 Position of first secondary tie-point
  /// @param xr2 Position of second reference tie-point
  /// @param yr2 Position of second reference tie-point
  /// @param xs2 Position of second secondary tie-point
  /// @param ys2 Position of second secondary tie-point
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg hwindow [VipsOption.Int] Half window size
  /// @optionalArg harea [VipsOption.Int] Half area size
  /// @optionalArg search [VipsOption.Boolean] Search to improve tie-points
  /// @optionalArg interpolate [VipsOption.Interpolate] Interpolate pixels with this
  public VImage match(VImage sec, int xr1, int yr1, int xs1, int ys1, int xr2, int yr2, int xs2,
      int ys2, VipsOption... args) throws VipsError {
    var refOption = VipsOption.Image("ref", this);
    var secOption = VipsOption.Image("sec", sec);
    var outOption = VipsOption.Image("out");
    var xr1Option = VipsOption.Int("xr1", xr1);
    var yr1Option = VipsOption.Int("yr1", yr1);
    var xs1Option = VipsOption.Int("xs1", xs1);
    var ys1Option = VipsOption.Int("ys1", ys1);
    var xr2Option = VipsOption.Int("xr2", xr2);
    var yr2Option = VipsOption.Int("yr2", yr2);
    var xs2Option = VipsOption.Int("xs2", xs2);
    var ys2Option = VipsOption.Int("ys2", ys2);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(refOption);
    callArgs.add(secOption);
    callArgs.add(outOption);
    callArgs.add(xr1Option);
    callArgs.add(yr1Option);
    callArgs.add(xs1Option);
    callArgs.add(ys1Option);
    callArgs.add(xr2Option);
    callArgs.add(yr2Option);
    callArgs.add(xs2Option);
    callArgs.add(ys2Option);
    VipsInvoker.invokeOperation(arena, "match", callArgs);
    return outOption.valueOrThrow();
  }

  /// Perform various functions in -lm, the maths library, on images.
  ///
  /// Angles are expressed in degrees. The output type is float unless the
  /// input is double, in which case the output is double.
  ///
  /// Non-complex images only.
  ///
  /// See also: [VImage#math2]
  /// @param math [VipsOperationMath] Math to perform
  /// @param args Array of VipsOption to apply to this operation
  public VImage math(VipsOperationMath math, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var mathOption = VipsOption.Enum("math", math);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(mathOption);
    VipsInvoker.invokeOperation(arena, "math", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation calculates a 2-ary maths operation on a pair of images
  /// and writes the result to `out`. The images may have any
  /// non-complex format. `out` is float except in the case that either of `left`
  /// or `right` are double, in which case `out` is also double.
  ///
  /// It detects division by zero, setting those pixels to zero in the output.
  /// Beware: it does this silently!
  ///
  /// If the images differ in size, the smaller image is enlarged to match the
  /// larger by adding zero pixels along the bottom and right.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The two input images are cast up to the smallest common format (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)), and that format is the
  /// result type.
  ///
  /// See also: [VImage#math2Const]
  /// @param right Right-hand image argument
  /// @param math2 [VipsOperationMath2] Math to perform
  /// @param args Array of VipsOption to apply to this operation
  public VImage math2(VImage right, VipsOperationMath2 math2, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var math2Option = VipsOption.Enum("math2", math2);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    callArgs.add(math2Option);
    VipsInvoker.invokeOperation(arena, "math2", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation calculates various 2-ary maths operations on an image and
  /// an array of constants and writes the result to `out`.
  /// The image may have any
  /// non-complex format. `out` is float except in the case that `in`
  /// is double, in which case `out` is also double.
  ///
  /// It detects division by zero, setting those pixels to zero in the output.
  /// Beware: it does this silently!
  ///
  /// If the array of constants has just one element, that constant is used for
  /// all image bands. If the array has more than one element and they have
  /// the same number of elements as there are bands in the image, then
  /// one array element is used for each band. If the arrays have more than one
  /// element and the image only has a single band, the result is a many-band
  /// image where each band corresponds to one array element.
  ///
  /// See also: [VImage#math2], [VImage#math]
  /// @param math2 [VipsOperationMath2] Math to perform
  /// @param c Array of constants
  /// @param args Array of VipsOption to apply to this operation
  public VImage math2Const(VipsOperationMath2 math2, List<Double> c, VipsOption... args) throws
      VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var math2Option = VipsOption.Enum("math2", math2);
    var cOption = VipsOption.ArrayDouble("c", c);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(math2Option);
    callArgs.add(cOption);
    VipsInvoker.invokeOperation(arena, "math2_const", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a Matlab save file into a VIPS image.
  ///
  /// This operation searches the save
  /// file for the first array variable with between 1 and 3 dimensions and loads
  /// it as an image. It will not handle complex images. It does not handle
  /// sparse matrices.
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage matload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "matload", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation calculates the inverse of the matrix represented in `m`.
  /// The scale and offset members of the input matrix are ignored.
  ///
  /// See also: [VImage#matrixload], [VImage#matrixmultiply]
  /// @param args Array of VipsOption to apply to this operation
  public VImage matrixinvert(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "matrixinvert", callArgs);
    return outOption.valueOrThrow();
  }

  /// Reads a matrix from a file.
  ///
  /// Matrix files have a simple format that's supposed to be easy to create with
  /// a text editor or a spreadsheet.
  ///
  /// The first line has four numbers for width, height, scale and
  /// offset (scale and offset may be omitted, in which case they default to 1.0
  /// and 0.0). Scale must be non-zero. Width and height must be positive
  /// integers. The numbers are separated by any mixture of spaces, commas,
  /// tabs and quotation marks ("). The scale and offset fields may be
  /// floating-point, and must use '.'
  /// as a decimal separator.
  ///
  /// Subsequent lines each hold one row of matrix data, with numbers again
  /// separated by any mixture of spaces, commas,
  /// tabs and quotation marks ("). The numbers may be floating-point, and must
  /// use '.'
  /// as a decimal separator.
  ///
  /// Extra characters at the ends of lines or at the end of the file are
  /// ignored.
  ///
  /// See also: [VImage#matrixload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage matrixload(Arena arena, String filename, VipsOption... args) throws
      VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "matrixload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#matrixload], but read from a source.
  ///
  /// See also: [VImage#matrixload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage matrixloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "matrixload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Multiplies two matrix images.
  ///
  /// The scale and offset members of `left` and `right` are ignored.
  ///
  /// See also: [VImage#matrixinvert]
  /// @param right Second matrix to multiply
  /// @param args Array of VipsOption to apply to this operation
  public VImage matrixmultiply(VImage right, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "matrixmultiply", callArgs);
    return outOption.valueOrThrow();
  }

  /// Print `in` to %stdout in matrix format. See [VImage#matrixload] for a
  /// description of the format.
  ///
  /// See also: [VImage#matrixload]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void matrixprint(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    VipsInvoker.invokeOperation(arena, "matrixprint", callArgs);
  }

  /// Write `in` to `filename` in matrix format. See [VImage#matrixload] for a
  /// description of the format.
  ///
  /// See also: [VImage#matrixload]
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void matrixsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "matrixsave", callArgs);
  }

  /// As [VImage#matrixsave], but save to a target.
  ///
  /// See also: [VImage#matrixsave]
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void matrixsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "matrixsave_target", callArgs);
  }

  /// This operation finds the maximum value in an image.
  ///
  /// By default it finds the single largest value. If `size` is set >1, it will
  /// find the `size` largest values. It will stop searching early if has found
  /// enough values.
  /// Equal values will be sorted by y then x.
  ///
  /// It operates on all
  /// bands of the input image: use [VImage#stats] if you need to find an
  /// maximum for each band.
  ///
  /// For complex images, this operation finds the maximum modulus.
  ///
  /// You can read out the position of the maximum with `x` and `y`. You can read
  /// out arrays of the values and positions of the top `size` maxima with
  /// `out_array`, `x_array` and `y_array`. These values are returned sorted from
  /// largest to smallest.
  ///
  /// If there are more than `size` maxima, the maxima returned will be a random
  /// selection of the maxima in the image.
  ///
  /// See also: [VImage#min], [VImage#stats]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg x [VipsOption.Int] Horizontal position of maximum
  /// @optionalArg y [VipsOption.Int] Vertical position of maximum
  /// @optionalArg size [VipsOption.Int] Number of maximum values to find
  /// @optionalArg out-array [VipsOption.ArrayDouble] Array of output values
  /// @optionalArg x-array [VipsOption.ArrayInt] Array of horizontal positions
  /// @optionalArg y-array [VipsOption.ArrayInt] Array of vertical positions
  public double max(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Double("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "max", callArgs);
    return outOption.valueOrThrow();
  }

  /// For each pixel, pick the maximum of a pair of images.
  ///
  /// See also: [VImage#minpair]
  /// @param right Right-hand image argument
  /// @param args Array of VipsOption to apply to this operation
  public VImage maxpair(VImage right, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "maxpair", callArgs);
    return outOption.valueOrThrow();
  }

  /// Analyse a grid of colour patches, producing an array of patch averages.
  /// The mask has a row for each measured patch and a column for each image
  /// band. The operations issues a warning if any patch has a deviation more
  /// than 20% of
  /// the mean. Only the central 50% of each patch is averaged.
  ///
  /// If the chart does not fill the whole image, use the optional `left`, `top`,
  /// `width`, `height` arguments to indicate the
  /// position of the chart.
  ///
  /// See also: [VImage#avg], [VImage#deviate]
  /// @param h Number of patches across chart
  /// @param v Number of patches down chart
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg left [VipsOption.Int] Left edge of extract area
  /// @optionalArg top [VipsOption.Int] Top edge of extract area
  /// @optionalArg width [VipsOption.Int] Width of extract area
  /// @optionalArg height [VipsOption.Int] Height of extract area
  public VImage measure(int h, int v, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var hOption = VipsOption.Int("h", h);
    var vOption = VipsOption.Int("v", v);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(hOption);
    callArgs.add(vOption);
    VipsInvoker.invokeOperation(arena, "measure", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation joins two images left-right (with `ref` on the left) or
  /// up-down (with `ref` above) with a smooth seam.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The two input images are cast up to the smallest common type (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)).
  ///
  /// `dx` and `dy` give the displacement of `sec` relative to `ref`, in other words,
  /// the vector to get from the origin of `sec` to the origin of `ref`, in other
  /// words, `dx` will generally be a negative number.
  ///
  /// `mblend` limits the maximum width of the
  /// blend area. A value of "-1" means "unlimited". The two images are blended
  /// with a raised cosine.
  ///
  /// Pixels with all bands equal to zero are "transparent", that
  /// is, zero pixels in the overlap area do not contribute to the merge.
  /// This makes it possible to join non-rectangular images.
  ///
  /// See also: [VImage#mosaic], [VImage#insert]
  /// @param sec Secondary image
  /// @param direction [VipsDirection] Horizontal or vertical merge
  /// @param dx Horizontal displacement from sec to ref
  /// @param dy Vertical displacement from sec to ref
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg mblend [VipsOption.Int] Maximum blend size
  public VImage merge(VImage sec, VipsDirection direction, int dx, int dy, VipsOption... args)
      throws VipsError {
    var refOption = VipsOption.Image("ref", this);
    var secOption = VipsOption.Image("sec", sec);
    var outOption = VipsOption.Image("out");
    var directionOption = VipsOption.Enum("direction", direction);
    var dxOption = VipsOption.Int("dx", dx);
    var dyOption = VipsOption.Int("dy", dy);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(refOption);
    callArgs.add(secOption);
    callArgs.add(outOption);
    callArgs.add(directionOption);
    callArgs.add(dxOption);
    callArgs.add(dyOption);
    VipsInvoker.invokeOperation(arena, "merge", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation finds the minimum value in an image.
  ///
  /// By default it finds the single smallest value. If `size` is set >1, it will
  /// find the `size` smallest values. It will stop searching early if has found
  /// enough values.
  /// Equal values will be sorted by y then x.
  ///
  /// It operates on all
  /// bands of the input image: use [VImage#stats] if you need to find an
  /// minimum for each band.
  ///
  /// For complex images, this operation finds the minimum modulus.
  ///
  /// You can read out the position of the minimum with `x` and `y`. You can read
  /// out arrays of the values and positions of the top `size` minima with
  /// `out_array`, `x_array` and `y_array`.
  /// These values are returned sorted from
  /// smallest to largest.
  ///
  /// If there are more than `size` minima, the minima returned will be a random
  /// selection of the minima in the image.
  ///
  /// See also: [VImage#min], [VImage#stats]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg x [VipsOption.Int] Horizontal position of minimum
  /// @optionalArg y [VipsOption.Int] Vertical position of minimum
  /// @optionalArg size [VipsOption.Int] Number of minimum values to find
  /// @optionalArg out-array [VipsOption.ArrayDouble] Array of output values
  /// @optionalArg x-array [VipsOption.ArrayInt] Array of horizontal positions
  /// @optionalArg y-array [VipsOption.ArrayInt] Array of vertical positions
  public double min(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Double("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "min", callArgs);
    return outOption.valueOrThrow();
  }

  /// For each pixel, pick the minimum of a pair of images.
  ///
  /// See also: [VImage#minpair]
  /// @param right Right-hand image argument
  /// @param args Array of VipsOption to apply to this operation
  public VImage minpair(VImage right, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "minpair", callArgs);
    return outOption.valueOrThrow();
  }

  /// Performs a morphological operation on `in` using `mask` as a
  /// structuring element.
  ///
  /// The image should have 0 (black) for no object and 255
  /// (non-zero) for an object. Note that this is the reverse of the usual
  /// convention for these operations, but more convenient when combined with the
  /// boolean operators. The output image is the same
  /// size as the input image: edge pxels are made by expanding the input image
  /// as necessary.
  ///
  /// Mask coefficients can be either 0 (for object) or 255 (for background)
  /// or 128 (for do not care).  The origin of the mask is at location
  /// (m.xsize / 2, m.ysize / 2), integer division.  All algorithms have been
  /// based on the book "Fundamentals of Digital Image Processing" by A. Jain,
  /// pp 384-388, Prentice-Hall, 1989.
  ///
  /// For [VipsOperationMorphology#OPERATION_MORPHOLOGY_ERODE],
  /// the whole mask must match for the output pixel to be
  /// set, that is, the result is the logical AND of the selected input pixels.
  ///
  /// For [VipsOperationMorphology#OPERATION_MORPHOLOGY_DILATE],
  /// the output pixel is set if any part of the mask
  /// matches, that is, the result is the logical OR of the selected input pixels.
  ///
  /// See the boolean operations `Image.andimage`, `Image.orimage`
  /// and `Image.eorimage`
  /// for analogues of the usual set difference and set union operations.
  ///
  /// Operations are performed using the processor's vector unit,
  /// if possible. Disable this with `--vips-novector` or `VIPS_NOVECTOR` or
  /// `vector_set_enabled`.
  /// @param mask Input matrix image
  /// @param morph [VipsOperationMorphology] Morphological operation to perform
  /// @param args Array of VipsOption to apply to this operation
  public VImage morph(VImage mask, VipsOperationMorphology morph, VipsOption... args) throws
      VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", mask);
    var morphOption = VipsOption.Enum("morph", morph);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    callArgs.add(morphOption);
    VipsInvoker.invokeOperation(arena, "morph", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation joins two images left-right (with `ref` on the left) or
  /// top-bottom (with `ref` above) given an approximate overlap.
  ///
  /// `sec` is positioned so that the pixel (@xsec, `ysec`) in `sec` lies on top of
  /// the pixel (@xref, `yref`) in `ref`. The overlap area is divided into three
  /// sections, 20 high-contrast points in band `bandno` of image `ref` are found
  /// in each, and a window of pixels of size `hwindow` around each high-contrast
  /// point is searched for in `sec` over an area of `harea`.
  ///
  /// A linear model is fitted to the 60 tie-points, points a long way from the
  /// fit are discarded, and the model refitted until either too few points
  /// remain or the model reaches good agreement.
  ///
  /// The detected displacement is used with [VImage#merge] to join the
  /// two images together.
  ///
  /// You can read out the detected transform with `dx0`, `dy0`, `scale1`, `angle1`,
  /// `dx1`, `dy1`.
  ///
  /// See also: [VImage#merge], [VImage#insert]
  /// @param sec Secondary image
  /// @param direction [VipsDirection] Horizontal or vertical mosaic
  /// @param xref Position of reference tie-point
  /// @param yref Position of reference tie-point
  /// @param xsec Position of secondary tie-point
  /// @param ysec Position of secondary tie-point
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg hwindow [VipsOption.Int] Half window size
  /// @optionalArg harea [VipsOption.Int] Half area size
  /// @optionalArg mblend [VipsOption.Int] Maximum blend size
  /// @optionalArg bandno [VipsOption.Int] Band to search for features on
  /// @optionalArg dx0 [VipsOption.Int] Detected integer offset
  /// @optionalArg dy0 [VipsOption.Int] Detected integer offset
  /// @optionalArg scale1 [VipsOption.Double] Detected scale
  /// @optionalArg angle1 [VipsOption.Double] Detected rotation
  /// @optionalArg dy1 [VipsOption.Double] Detected first-order displacement
  /// @optionalArg dx1 [VipsOption.Double] Detected first-order displacement
  public VImage mosaic(VImage sec, VipsDirection direction, int xref, int yref, int xsec, int ysec,
      VipsOption... args) throws VipsError {
    var refOption = VipsOption.Image("ref", this);
    var secOption = VipsOption.Image("sec", sec);
    var outOption = VipsOption.Image("out");
    var directionOption = VipsOption.Enum("direction", direction);
    var xrefOption = VipsOption.Int("xref", xref);
    var yrefOption = VipsOption.Int("yref", yref);
    var xsecOption = VipsOption.Int("xsec", xsec);
    var ysecOption = VipsOption.Int("ysec", ysec);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(refOption);
    callArgs.add(secOption);
    callArgs.add(outOption);
    callArgs.add(directionOption);
    callArgs.add(xrefOption);
    callArgs.add(yrefOption);
    callArgs.add(xsecOption);
    callArgs.add(ysecOption);
    VipsInvoker.invokeOperation(arena, "mosaic", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation joins two images top-bottom (with `sec` on the right)
  /// or left-right (with `sec` at the bottom)
  /// given an approximate pair of tie-points. `sec` is scaled and rotated as
  /// necessary before the join.
  ///
  /// If `search` is `TRUE`, before performing the transformation, the tie-points
  /// are improved by searching an area of `sec` of size `harea` for a
  /// object of size `hwindow` in `ref`.
  ///
  /// `mblend` limits the maximum size of the
  /// blend area. A value of "-1" means "unlimited". The two images are blended
  /// with a raised cosine.
  ///
  /// Pixels with all bands equal to zero are "transparent", that
  /// is, zero pixels in the overlap area do not contribute to the merge.
  /// This makes it possible to join non-rectangular images.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The two input images are cast up to the smallest common type (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)).
  ///
  /// See also: [VImage#merge], [VImage#insert], [VImage#globalbalance]
  /// @param sec Secondary image
  /// @param direction [VipsDirection] Horizontal or vertical mosaic
  /// @param xr1 Position of first reference tie-point
  /// @param yr1 Position of first reference tie-point
  /// @param xs1 Position of first secondary tie-point
  /// @param ys1 Position of first secondary tie-point
  /// @param xr2 Position of second reference tie-point
  /// @param yr2 Position of second reference tie-point
  /// @param xs2 Position of second secondary tie-point
  /// @param ys2 Position of second secondary tie-point
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg hwindow [VipsOption.Int] Half window size
  /// @optionalArg harea [VipsOption.Int] Half area size
  /// @optionalArg search [VipsOption.Boolean] Search to improve tie-points
  /// @optionalArg interpolate [VipsOption.Interpolate] Interpolate pixels with this
  /// @optionalArg mblend [VipsOption.Int] Maximum blend size
  /// @optionalArg bandno [VipsOption.Int] Band to search for features on
  public VImage mosaic1(VImage sec, VipsDirection direction, int xr1, int yr1, int xs1, int ys1,
      int xr2, int yr2, int xs2, int ys2, VipsOption... args) throws VipsError {
    var refOption = VipsOption.Image("ref", this);
    var secOption = VipsOption.Image("sec", sec);
    var outOption = VipsOption.Image("out");
    var directionOption = VipsOption.Enum("direction", direction);
    var xr1Option = VipsOption.Int("xr1", xr1);
    var yr1Option = VipsOption.Int("yr1", yr1);
    var xs1Option = VipsOption.Int("xs1", xs1);
    var ys1Option = VipsOption.Int("ys1", ys1);
    var xr2Option = VipsOption.Int("xr2", xr2);
    var yr2Option = VipsOption.Int("yr2", yr2);
    var xs2Option = VipsOption.Int("xs2", xs2);
    var ys2Option = VipsOption.Int("ys2", ys2);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(refOption);
    callArgs.add(secOption);
    callArgs.add(outOption);
    callArgs.add(directionOption);
    callArgs.add(xr1Option);
    callArgs.add(yr1Option);
    callArgs.add(xs1Option);
    callArgs.add(ys1Option);
    callArgs.add(xr2Option);
    callArgs.add(yr2Option);
    callArgs.add(xs2Option);
    callArgs.add(ys2Option);
    VipsInvoker.invokeOperation(arena, "mosaic1", callArgs);
    return outOption.valueOrThrow();
  }

  /// Turn any integer image to 8-bit unsigned char by discarding all but the most
  /// significant byte. Signed values are converted to unsigned by adding 128.
  ///
  /// Use `band` to make a one-band 8-bit image.
  ///
  /// This operator also works for LABQ coding.
  ///
  /// See also: [VImage#scale], [VImage#cast]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg band [VipsOption.Int] Band to msb
  public VImage msb(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "msb", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation calculates `left` * `right` and writes the result to `out`.
  ///
  /// If the images differ in size, the smaller image is enlarged to match the
  /// larger by adding zero pixels along the bottom and right.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The two input images are cast up to the smallest common format (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)), then the
  /// following table is used to determine the output type:
  ///
  /// ## [VImage#multiply] type promotion
  ///
  /// | input type     | output type    |
  /// |----------------|----------------|
  /// | uchar          | ushort         |
  /// | char           | short          |
  /// | ushort         | uint           |
  /// | short          | int            |
  /// | uint           | uint           |
  /// | int            | int            |
  /// | float          | float          |
  /// | double         | double         |
  /// | complex        | complex        |
  /// | double complex | double complex |
  ///
  /// In other words, the output type is just large enough to hold the whole
  /// range of possible values.
  ///
  /// See also: [VImage#add], [VImage#linear]
  /// @param right Right-hand image argument
  /// @param args Array of VipsOption to apply to this operation
  public VImage multiply(VImage right, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "multiply", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a OpenEXR file into a VIPS image.
  ///
  /// The reader can handle scanline and tiled OpenEXR images. It can't handle
  /// OpenEXR colour management, image attributes, many pixel formats, anything
  /// other than RGBA.
  ///
  /// This reader uses the rather limited OpenEXR C API. It should really be
  /// redone in C++.
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage openexrload(Arena arena, String filename, VipsOption... args) throws
      VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "openexrload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a virtual slide supported by the OpenSlide library into a VIPS image.
  /// OpenSlide supports images in Aperio, Hamamatsu, MIRAX, Sakura, Trestle,
  /// and Ventana formats.
  ///
  /// To facilitate zooming, virtual slide formats include multiple scaled-down
  /// versions of the high-resolution image.  These are typically called
  /// "levels".  By default, [VImage#openslideload] reads the
  /// highest-resolution level (level 0).  Set `level` to the level number you want.
  ///
  /// In addition to the slide image itself, virtual slide formats sometimes
  /// include additional images, such as a scan of the slide's barcode.
  /// OpenSlide calls these "associated images".  To read an associated image,
  /// set `associated` to the image's name.
  /// A slide's associated images are listed in the
  /// "slide-associated-images" metadata item.
  ///
  /// If you set `attach_associated`, then all associated images are attached as
  /// metadata items. Use `Image.get_image` on `out` to retrieve them. Images
  /// are attached as "openslide-associated-XXXXX", where XXXXX is the name of the
  /// associated image.
  ///
  /// By default, the output of this operator is RGBA. Set `rgb` to enable RGB
  /// output.
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg level [VipsOption.Int] Load this level from the file
  /// @optionalArg autocrop [VipsOption.Boolean] Crop to image bounds
  /// @optionalArg associated [VipsOption.String] Load this associated image
  /// @optionalArg attach-associated [VipsOption.Boolean] Attach all associated images
  /// @optionalArg rgb [VipsOption.Boolean] Output RGB (not RGBA)
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage openslideload(Arena arena, String filename, VipsOption... args) throws
      VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "openslideload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#openslideload], but read from a source.
  ///
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg level [VipsOption.Int] Load this level from the file
  /// @optionalArg autocrop [VipsOption.Boolean] Crop to image bounds
  /// @optionalArg associated [VipsOption.String] Load this associated image
  /// @optionalArg attach-associated [VipsOption.Boolean] Attach all associated images
  /// @optionalArg rgb [VipsOption.Boolean] Output RGB (not RGBA)
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage openslideloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "openslideload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Render a PDF file into a VIPS image.
  ///
  /// The output image is always RGBA -- CMYK PDFs will be
  /// converted. If you need CMYK bitmaps, you should use [VImage#magickload]
  /// instead.
  ///
  /// Use `page` to select a page to render, numbering from zero.
  ///
  /// Use `n` to select the number of pages to render. The default is 1. Pages are
  /// rendered in a vertical column, with each individual page aligned to the
  /// left. Set to -1 to mean "until the end of the document". Use
  /// [VImage#grid] to change page layout.
  ///
  /// Use `dpi` to set the rendering resolution. The default is 72. Additionally,
  /// you can scale by setting `scale`. If you set both, they combine.
  ///
  /// Use `background` to set the background RGBA colour. The default is 255
  /// (solid white), use eg. 0 for a transparent background.
  ///
  /// Use `password` to supply a decryption password.
  ///
  /// The operation fills a number of header fields with metadata, for example
  /// "pdf-author". They may be useful.
  ///
  /// This function only reads the image header and does not render any pixel
  /// data. Rendering occurs when pixels are accessed.
  ///
  /// See also: `Image.new_from_file`, [VImage#magickload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg dpi [VipsOption.Double] DPI to render at
  /// @optionalArg scale [VipsOption.Double] Factor to scale by
  /// @optionalArg background [VipsOption.ArrayDouble] Background colour
  /// @optionalArg password [VipsOption.String] Password to decrypt with
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage pdfload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "pdfload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a PDF-formatted memory buffer into a VIPS image. Exactly as
  /// [VImage#pdfload], but read from memory.
  ///
  /// You must not free the buffer while `out` is active. The
  /// `Object::postclose` signal on `out` is a good place to free.
  ///
  /// See also: [VImage#pdfload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg dpi [VipsOption.Double] DPI to render at
  /// @optionalArg scale [VipsOption.Double] Factor to scale by
  /// @optionalArg background [VipsOption.ArrayDouble] Background colour
  /// @optionalArg password [VipsOption.String] Password to decrypt with
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage pdfloadBuffer(Arena arena, VBlob buffer, VipsOption... args) throws
      VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "pdfload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#pdfload], but read from a source.
  ///
  /// See also: [VImage#pdfload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg dpi [VipsOption.Double] DPI to render at
  /// @optionalArg scale [VipsOption.Double] Factor to scale by
  /// @optionalArg background [VipsOption.ArrayDouble] Background colour
  /// @optionalArg password [VipsOption.String] Password to decrypt with
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage pdfloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "pdfload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// [VImage#percent] returns (through the `threshold` parameter) the threshold
  /// below which there are `percent` values of `in`. For example:
  ///
  /// ```bash
  /// $ vips percent k2.jpg 90
  /// 214
  /// ```
  ///
  /// Means that 90% of pixels in `k2.jpg` have a value less than 214.
  ///
  /// The function works for uchar and ushort images only.  It can be used
  /// to threshold the scaled result of a filtering operation.
  ///
  /// See also: [VImage#histFind], [VImage#profile]
  /// @param percent Percent of pixels
  /// @param args Array of VipsOption to apply to this operation
  public int percent(double percent, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var percentOption = VipsOption.Double("percent", percent);
    var thresholdOption = VipsOption.Int("threshold");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(percentOption);
    callArgs.add(thresholdOption);
    VipsInvoker.invokeOperation(arena, "percent", callArgs);
    return thresholdOption.valueOrThrow();
  }

  /// Create a one-band float image of [Perlin
  /// noise](https://en.wikipedia.org/wiki/Perlin_noise).
  ///
  /// Use `cell_size` to set the size of the cells from which the image is
  /// constructed. The default is 256 x 256.
  ///
  /// If `width` and `height` are multiples of `cell_size`, the image will tessellate.
  ///
  /// Normally, output pixels are [VipsBandFormat#FORMAT_FLOAT] in the range
  /// [-1, +1]. Set `uchar` to output a uchar image with pixels in [0, 255].
  ///
  /// See also: [VImage#worley], [VImage#fractsurf], [VImage#gaussnoise]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg cell-size [VipsOption.Int] Size of Perlin cells
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  /// @optionalArg seed [VipsOption.Int] Random number seed
  public static VImage perlin(Arena arena, int width, int height, VipsOption... args) throws
      VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "perlin", callArgs);
    return outOption.valueOrThrow();
  }

  /// Convert the two input images to Fourier space, calculate phase-correlation,
  /// back to real space.
  ///
  /// See also: [VImage#fwfft], `Image.cross_phase`
  /// @param in2 Second input image
  /// @param args Array of VipsOption to apply to this operation
  public VImage phasecor(VImage in2, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var in2Option = VipsOption.Image("in2", in2);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(in2Option);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "phasecor", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a PNG file into a VIPS image. It can read all png images, including 8-
  /// and 16-bit images, 1 and 3 channel, with and without an alpha channel.
  ///
  /// Any ICC profile is read and attached to the VIPS image. It also supports
  /// XMP metadata.
  ///
  /// Use `fail_on` to set the type of error that will cause load to fail. By
  /// default, loaders are permissive, that is, [VipsFailOn#FAIL_ON_NONE].
  ///
  /// By default, the PNG loader limits the number of text and data chunks to
  /// block some denial of service attacks. Set `unlimited` to disable these
  /// limits.
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg unlimited [VipsOption.Boolean] Remove all denial of service limits
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage pngload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "pngload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#pngload], but read from a PNG-formatted memory block.
  ///
  /// You must not free the buffer while `out` is active. The
  /// `Object::postclose` signal on `out` is a good place to free.
  ///
  /// See also: [VImage#pngload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg unlimited [VipsOption.Boolean] Remove all denial of service limits
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage pngloadBuffer(Arena arena, VBlob buffer, VipsOption... args) throws
      VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "pngload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#pngload], but read from a source.
  ///
  /// See also: [VImage#pngload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg unlimited [VipsOption.Boolean] Remove all denial of service limits
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage pngloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "pngload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Write a VIPS image to a file as PNG.
  ///
  /// `compression` means compress with this much effort (0 - 9). Default 6.
  ///
  /// Set `interlace` to `TRUE` to interlace the image with ADAM7
  /// interlacing. Beware
  /// than an interlaced PNG can be up to 7 times slower to write than a
  /// non-interlaced image.
  ///
  /// Use `filter` to specify one or more filters, defaults to none,
  /// see `ForeignPngFilter`.
  ///
  /// The image is automatically converted to RGB, RGBA, Monochrome or Mono +
  /// alpha before saving. Images with more than one byte per band element are
  /// saved as 16-bit PNG, others are saved as 8-bit PNG.
  ///
  /// Set `palette` to `TRUE` to enable palette mode for RGB or RGBA images. A
  /// palette will be computed with enough space for `bitdepth` (1, 2, 4 or 8)
  /// bits. Use `Q` to set the optimisation effort, `dither` to set the degree of
  /// Floyd-Steinberg dithering and `effort` to control the CPU effort
  /// (1 is the fastest, 10 is the slowest, 7 is the default).
  /// This feature requires libvips to be compiled with libimagequant.
  ///
  /// The default `bitdepth` is either 8 or 16 depending on the interpretation.
  /// You can also set `bitdepth` for mono and mono + alpha images, and the image
  /// will be quantized.
  ///
  /// XMP metadata is written to the XMP chunk. PNG comments are written to
  /// separate text chunks.
  ///
  /// See also: `Image.new_from_file`
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg compression [VipsOption.Int] Compression factor
  /// @optionalArg interlace [VipsOption.Boolean] Interlace image
  /// @optionalArg filter [VipsOption.Int] Libspng row filter flag(s)
  /// @optionalArg palette [VipsOption.Boolean] Quantise to 8bpp palette
  /// @optionalArg colours [VipsOption.Int] Max number of palette colours
  /// @optionalArg Q [VipsOption.Int] Quantisation quality
  /// @optionalArg dither [VipsOption.Double] Amount of dithering
  /// @optionalArg bitdepth [VipsOption.Int] Write as a 1, 2, 4, 8 or 16 bit image
  /// @optionalArg effort [VipsOption.Int] Quantisation CPU effort
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void pngsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "pngsave", callArgs);
  }

  /// As [VImage#pngsave], but save to a memory buffer.
  ///
  /// The address of the buffer is returned in `buf`, the length of the buffer in
  /// `len`. You are responsible for freeing the buffer with `GLib.free` when you
  /// are done with it.
  ///
  /// See also: [VImage#pngsave], `Image.write_to_file`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg compression [VipsOption.Int] Compression factor
  /// @optionalArg interlace [VipsOption.Boolean] Interlace image
  /// @optionalArg filter [VipsOption.Int] Libspng row filter flag(s)
  /// @optionalArg palette [VipsOption.Boolean] Quantise to 8bpp palette
  /// @optionalArg colours [VipsOption.Int] Max number of palette colours
  /// @optionalArg Q [VipsOption.Int] Quantisation quality
  /// @optionalArg dither [VipsOption.Double] Amount of dithering
  /// @optionalArg bitdepth [VipsOption.Int] Write as a 1, 2, 4, 8 or 16 bit image
  /// @optionalArg effort [VipsOption.Int] Quantisation CPU effort
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public VBlob pngsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "pngsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /// As [VImage#pngsave], but save to a target.
  ///
  /// See also: [VImage#pngsave], `Image.write_to_target`
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg compression [VipsOption.Int] Compression factor
  /// @optionalArg interlace [VipsOption.Boolean] Interlace image
  /// @optionalArg filter [VipsOption.Int] Libspng row filter flag(s)
  /// @optionalArg palette [VipsOption.Boolean] Quantise to 8bpp palette
  /// @optionalArg colours [VipsOption.Int] Max number of palette colours
  /// @optionalArg Q [VipsOption.Int] Quantisation quality
  /// @optionalArg dither [VipsOption.Double] Amount of dithering
  /// @optionalArg bitdepth [VipsOption.Int] Write as a 1, 2, 4, 8 or 16 bit image
  /// @optionalArg effort [VipsOption.Int] Quantisation CPU effort
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void pngsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "pngsave_target", callArgs);
  }

  /// Read a PPM/PBM/PGM/PFM file into a VIPS image.
  ///
  /// It can read 1, 8, 16 and 32 bit images, colour or monochrome,
  /// stored in binary or in ASCII. One bit images become 8 bit VIPS images,
  /// with 0 and 255 for 0 and 1.
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage ppmload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "ppmload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#ppmload], but read from a memory source.
  ///
  /// See also: [VImage#ppmload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage ppmloadBuffer(Arena arena, VBlob buffer, VipsOption... args) throws
      VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "ppmload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#ppmload], but read from a source.
  ///
  /// See also: [VImage#ppmload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage ppmloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "ppmload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Write a VIPS image to a file as PPM.
  ///
  /// It can write 1, 8, 16 or
  /// 32 bit unsigned integer images, float images, colour or monochrome,
  /// stored as binary or ASCII.
  /// Integer images of more than 8 bits can only be stored in ASCII.
  ///
  /// When writing float (PFM) images the scale factor is set from the
  /// "pfm-scale" metadata.
  ///
  /// Set `ascii` to `TRUE` to write as human-readable ASCII. Normally data is
  /// written in binary.
  ///
  /// Set `bitdepth` to 1 to write a one-bit image.
  ///
  /// `format` defaults to the sub-type for this filename suffix.
  ///
  /// See also: `Image.write_to_file`
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg format [VipsOption.Enum] [VipsForeignPpmFormat] Format to save in
  /// @optionalArg ascii [VipsOption.Boolean] Save as ascii
  /// @optionalArg squash [VipsOption.Boolean] Save as one bit
  /// @optionalArg bitdepth [VipsOption.Int] Set to 1 to write as a 1 bit image
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void ppmsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "ppmsave", callArgs);
  }

  /// As [VImage#ppmsave], but save to a target.
  ///
  /// See also: [VImage#ppmsave]
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg format [VipsOption.Enum] [VipsForeignPpmFormat] Format to save in
  /// @optionalArg ascii [VipsOption.Boolean] Save as ascii
  /// @optionalArg squash [VipsOption.Boolean] Save as one bit
  /// @optionalArg bitdepth [VipsOption.Int] Set to 1 to write as a 1 bit image
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void ppmsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "ppmsave_target", callArgs);
  }

  /// Premultiplies any alpha channel.
  ///
  /// The final band is taken to be the alpha and the bands are transformed as:
  ///
  /// ```
  /// alpha = clip(0, in[in.bands - 1], max_alpha)
  /// norm = alpha / max_alpha
  /// out = [in[0] * norm, ..., in[in.bands - 1] * norm, alpha]
  /// ```
  ///
  /// So for an N-band image, the first N - 1 bands are multiplied by the clipped
  /// and normalised final band, the final band is clipped.
  /// If there is only a single band,
  /// the image is passed through unaltered.
  ///
  /// The result is
  /// [VipsBandFormat#FORMAT_FLOAT] unless the input format is
  /// [VipsBandFormat#FORMAT_DOUBLE], in which case the output is double as well.
  ///
  /// `max_alpha` has the default value 255, or 65535 for images tagged as
  /// [VipsInterpretation#INTERPRETATION_RGB16] or [VipsInterpretation#INTERPRETATION_GREY16], and
  /// 1.0 for images tagged as [VipsInterpretation#INTERPRETATION_scRGB].
  ///
  /// Non-complex images only.
  ///
  /// See also: [VImage#unpremultiply], [VImage#flatten]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg max-alpha [VipsOption.Double] Maximum value of alpha channel
  public VImage premultiply(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "premultiply", callArgs);
    return outOption.valueOrThrow();
  }

  /// Prewitt edge detector.
  ///
  /// uchar images are computed using a fast, low-precision path. Cast to float
  /// for a high-precision implementation.
  ///
  /// See also: [VImage#canny], [VImage#sobel], [VImage#prewitt], [VImage#scharr]
  /// @param args Array of VipsOption to apply to this operation
  public VImage prewitt(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "prewitt", callArgs);
    return outOption.valueOrThrow();
  }

  /// [VImage#profile] searches inward from the edge of `in` and finds the
  /// first non-zero pixel. Pixels in `columns` have the distance from the top edge
  /// to the first non-zero pixel in that column, `rows` has the distance from the
  /// left edge to the first non-zero pixel in that row.
  ///
  /// See also: [VImage#project], [VImage#histFind]
  /// @param args Array of VipsOption to apply to this operation
  public ProfileOutput profile(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var columnsOption = VipsOption.Image("columns");
    var rowsOption = VipsOption.Image("rows");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(columnsOption);
    callArgs.add(rowsOption);
    VipsInvoker.invokeOperation(arena, "profile", callArgs);
    return new ProfileOutput(columnsOption.valueOrThrow(), rowsOption.valueOrThrow());
  }

  /// Find the horizontal and vertical projections of an image, ie. the sum
  /// of every row of pixels, and the sum of every column of pixels. The output
  /// format is uint, int or double, depending on the input format.
  ///
  /// Non-complex images only.
  ///
  /// See also: [VImage#histFind], [VImage#profile]
  /// @param args Array of VipsOption to apply to this operation
  public ProjectOutput project(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var columnsOption = VipsOption.Image("columns");
    var rowsOption = VipsOption.Image("rows");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(columnsOption);
    callArgs.add(rowsOption);
    VipsInvoker.invokeOperation(arena, "project", callArgs);
    return new ProjectOutput(columnsOption.valueOrThrow(), rowsOption.valueOrThrow());
  }

  /// Transform an image with a 0, 1, 2, or 3rd order polynomial.
  ///
  /// The transform we compute:
  ///
  /// ```
  /// x = x' + a              : order 0     image shift only
  ///   + b x' + c y'         : order 1     + affine transf.
  ///   + d x' y'             : order 2     + bilinear transf.
  ///   + e x' x' + f y' y'   : order 3     + quadratic transf.
  ///
  /// y = y' + g
  ///   + h y' + i x'
  ///   + j y' x'
  ///   + k y' y' + l x' x'
  /// ```
  ///
  /// where:
  ///
  /// ```
  /// x', y' = coordinates of srcim
  /// x, y   = coordinates of dstim
  /// a .. l = coefficients
  /// ```
  ///
  /// The coefficients are in the input matrix, ordered as:
  ///
  /// ```
  /// a g
  /// --
  /// b h
  /// c i
  /// --
  /// d j
  /// --
  /// e k
  /// f l
  /// ```
  ///
  /// The matrix height may be 1, 3, 4, 6
  ///
  /// See also: [VImage#affine]
  /// @param coeff Coefficient matrix
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg interpolate [VipsOption.Interpolate] Interpolate values with this
  public VImage quadratic(VImage coeff, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var coeffOption = VipsOption.Image("coeff", coeff);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(coeffOption);
    VipsInvoker.invokeOperation(arena, "quadratic", callArgs);
    return outOption.valueOrThrow();
  }

  /// Unpack a RAD ([VipsCoding#CODING_RAD]) image to a three-band float image.
  ///
  /// See also: [VImage#float2rad], [VImage#LabQ2LabS]
  /// @param args Array of VipsOption to apply to this operation
  public VImage rad2float(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "rad2float", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a Radiance (HDR) file into a VIPS image.
  ///
  /// Radiance files are read as [VipsCoding#CODING_RAD]. They have one byte for each of
  /// red, green and blue, and one byte of shared exponent. Some operations (like
  /// [VImage#extractArea]) can work directly with images in this format, but
  /// mmany (all the arithmetic operations, for example) will not. Unpack
  /// [VipsCoding#CODING_RAD] images to 3 band float with [VImage#rad2float] if
  /// you want to do arithmetic on them.
  ///
  /// This operation ignores some header fields, like VIEW and DATE. It will not
  /// rotate/flip as the FORMAT string asks.
  ///
  /// Sections of this reader from Greg Ward and Radiance with kind permission.
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage radload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "radload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#radload], but read from a HDR-formatted memory block.
  ///
  /// You must not free the buffer while `out` is active. The
  /// `Object::postclose` signal on `out` is a good place to free.
  ///
  /// See also: [VImage#radload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage radloadBuffer(Arena arena, VBlob buffer, VipsOption... args) throws
      VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "radload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#radload], but read from a source.
  ///
  /// See also: [VImage#radload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage radloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "radload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Write a VIPS image in Radiance (HDR) format.
  ///
  /// Sections of this reader from Greg Ward and Radiance with kind permission.
  ///
  /// See also: `Image.write_to_file`
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void radsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "radsave", callArgs);
  }

  /// As [VImage#radsave], but save to a memory buffer.
  ///
  /// The address of the buffer is returned in `buf`, the length of the buffer in
  /// `len`. You are responsible for freeing the buffer with `GLib.free` when you
  /// are done with it.
  ///
  /// See also: [VImage#radsave], `Image.write_to_file`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public VBlob radsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "radsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /// As [VImage#radsave], but save to a target.
  ///
  /// See also: [VImage#radsave]
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void radsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "radsave_target", callArgs);
  }

  /// [VImage#rank] does rank filtering on an image. A window of size `width` by
  /// `height` is passed over the image. At each position, the pixels inside the
  /// window are sorted into ascending order and the pixel at position `index` is
  /// output. `index` numbers from 0.
  ///
  /// It works for any non-complex image type, with any number of bands.
  /// The input is expanded by copying edge pixels before performing the
  /// operation so that the output image has the same size as the input.
  /// Edge pixels in the output image are therefore only approximate.
  ///
  /// For a median filter with mask size m (3 for 3x3, 5 for 5x5, etc.) use
  ///
  /// ```c
  /// vips_rank(in, out, m, m, m * m / 2);
  /// ```
  ///
  /// The special cases n == 0 and n == m * m - 1 are useful dilate and
  /// expand operators.
  ///
  /// See also: [VImage#conv], `Image.median`, [VImage#spcor]
  /// @param width Window width in pixels
  /// @param height Window height in pixels
  /// @param index Select pixel at index
  /// @param args Array of VipsOption to apply to this operation
  public VImage rank(int width, int height, int index, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var indexOption = VipsOption.Int("index", index);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(indexOption);
    VipsInvoker.invokeOperation(arena, "rank", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation mmaps the file, setting up `out` so that access to that
  /// image will read from the file.
  ///
  /// By default, it assumes uchar pixels. Use `format` to select something else.
  ///
  /// The image will be tagged as [VipsInterpretation#INTERPRETATION_MULTIBAND]. Use
  /// `interpretation` to select something else.
  ///
  /// Use [VImage#byteswap] to reverse the byte ordering if necessary.
  ///
  /// See also: `Image.new_from_file`, [VImage#copy], [VImage#byteswap]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param bands Number of bands in image
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg offset [VipsOption.Long] Offset in bytes from start of file
  /// @optionalArg format [VipsOption.Enum] [VipsBandFormat] Pixel format in image
  /// @optionalArg interpretation [VipsOption.Enum] [VipsInterpretation] Pixel interpretation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage rawload(Arena arena, String filename, int width, int height, int bands,
      VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var bandsOption = VipsOption.Int("bands", bands);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(bandsOption);
    VipsInvoker.invokeOperation(arena, "rawload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Writes the pixels in `in` to the file `filename` with no header or other
  /// metadata.
  ///
  /// See also: `Image.write_to_file`
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void rawsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "rawsave", callArgs);
  }

  /// As [VImage#rawsave], but save to a memory buffer.
  ///
  /// The address of the buffer is returned in `buf`, the length of the buffer in
  /// `len`. You are responsible for freeing the buffer with `GLib.free` when you
  /// are done with it.
  ///
  /// See also: [VImage#rawsave], `Image.write_to_memory`, `Image.write_to_file`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public VBlob rawsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "rawsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /// As [VImage#rawsave], but save to a target.
  ///
  /// See also: [VImage#rawsave]
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void rawsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "rawsave_target", callArgs);
  }

  /// This operation recombines an image's bands. Each pixel in `in` is treated as
  /// an n-element vector, where n is the number of bands in `in`, and multiplied by
  /// the n x m matrix `m` to produce the m-band image `out`.
  ///
  /// `out` is always float, unless `in` is double, in which case `out` is double
  /// too. No complex images allowed.
  ///
  /// It's useful for various sorts of colour space conversions.
  ///
  /// See also: [VImage#bandmean]
  /// @param m Matrix of coefficients
  /// @param args Array of VipsOption to apply to this operation
  public VImage recomb(VImage m, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var mOption = VipsOption.Image("m", m);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(mOption);
    VipsInvoker.invokeOperation(arena, "recomb", callArgs);
    return outOption.valueOrThrow();
  }

  /// Reduce `in` by a pair of factors with a pair of 1D kernels.
  ///
  /// This will not work well for shrink factors greater than three.
  ///
  /// Set `gap` to speed up reducing by having [VImage#shrink] to shrink
  /// with a box filter first. The bigger `gap`, the closer the result
  /// to the fair resampling. The smaller `gap`, the faster resizing.
  /// The default value is 0.0 (no optimization).
  ///
  /// This is a very low-level operation: see [VImage#resize] for a more
  /// convenient way to resize images.
  ///
  /// This operation does not change xres or yres. The image resolution needs to
  /// be updated by the application.
  ///
  /// See also: [VImage#shrink], [VImage#resize], [VImage#affine]
  /// @param xshrink Horizontal shrink factor
  /// @param hshrink Horizontal shrink factor
  /// @param yshrink Vertical shrink factor
  /// @param vshrink Vertical shrink factor
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg kernel [VipsOption.Enum] [VipsKernel] Resampling kernel
  /// @optionalArg gap [VipsOption.Double] Reducing gap
  /// @optionalArg centre [VipsOption.Boolean] Use centre sampling convention
  public VImage reduce(double xshrink, double hshrink, double yshrink, double vshrink,
      VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var xshrinkOption = VipsOption.Double("xshrink", xshrink);
    var hshrinkOption = VipsOption.Double("hshrink", hshrink);
    var yshrinkOption = VipsOption.Double("yshrink", yshrink);
    var vshrinkOption = VipsOption.Double("vshrink", vshrink);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(xshrinkOption);
    callArgs.add(hshrinkOption);
    callArgs.add(yshrinkOption);
    callArgs.add(vshrinkOption);
    VipsInvoker.invokeOperation(arena, "reduce", callArgs);
    return outOption.valueOrThrow();
  }

  /// Reduce `in` horizontally by a float factor.
  ///
  /// The pixels in `out` are
  /// interpolated with a 1D mask generated by `kernel`.
  ///
  /// Set `gap` to speed up reducing by having [VImage#shrinkh] to shrink
  /// with a box filter first. The bigger `gap`, the closer the result
  /// to the fair resampling. The smaller `gap`, the faster resizing.
  /// The default value is 0.0 (no optimization).
  ///
  /// This is a very low-level operation: see [VImage#resize] for a more
  /// convenient way to resize images.
  ///
  /// This operation does not change xres or yres. The image resolution needs to
  /// be updated by the application.
  ///
  /// See also: [VImage#shrink], [VImage#resize], [VImage#affine]
  /// @param xshrink Horizontal shrink factor
  /// @param hshrink Horizontal shrink factor
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg kernel [VipsOption.Enum] [VipsKernel] Resampling kernel
  /// @optionalArg gap [VipsOption.Double] Reducing gap
  /// @optionalArg centre [VipsOption.Boolean] Use centre sampling convention
  public VImage reduceh(double xshrink, double hshrink, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var xshrinkOption = VipsOption.Double("xshrink", xshrink);
    var hshrinkOption = VipsOption.Double("hshrink", hshrink);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(xshrinkOption);
    callArgs.add(hshrinkOption);
    VipsInvoker.invokeOperation(arena, "reduceh", callArgs);
    return outOption.valueOrThrow();
  }

  /// Reduce `in` vertically by a float factor.
  ///
  /// The pixels in `out` are
  /// interpolated with a 1D mask generated by `kernel`.
  ///
  /// Set `gap` to speed up reducing by having [VImage#shrinkv] to shrink
  /// with a box filter first. The bigger `gap`, the closer the result
  /// to the fair resampling. The smaller `gap`, the faster resizing.
  /// The default value is 0.0 (no optimization).
  ///
  /// This is a very low-level operation: see [VImage#resize] for a more
  /// convenient way to resize images.
  ///
  /// This operation does not change xres or yres. The image resolution needs to
  /// be updated by the application.
  ///
  /// See also: [VImage#shrink], [VImage#resize], [VImage#affine]
  /// @param yshrink Vertical shrink factor
  /// @param vshrink Vertical shrink factor
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg kernel [VipsOption.Enum] [VipsKernel] Resampling kernel
  /// @optionalArg gap [VipsOption.Double] Reducing gap
  /// @optionalArg centre [VipsOption.Boolean] Use centre sampling convention
  public VImage reducev(double yshrink, double vshrink, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var yshrinkOption = VipsOption.Double("yshrink", yshrink);
    var vshrinkOption = VipsOption.Double("vshrink", vshrink);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(yshrinkOption);
    callArgs.add(vshrinkOption);
    VipsInvoker.invokeOperation(arena, "reducev", callArgs);
    return outOption.valueOrThrow();
  }

  /// Perform various relational operations on pairs of images.
  ///
  /// The output type is always uchar, with 0 for `FALSE` and 255 for `TRUE`.
  ///
  /// Less-than and greater-than for complex images compare the modulus.
  ///
  /// If the images differ in size, the smaller image is enlarged to match the
  /// larger by adding zero pixels along the bottom and right.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The two input images are cast up to the smallest common format (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)).
  ///
  /// To decide if pixels match exactly, that is have the same value in every
  /// band, use [VImage#bandbool] after this operation to AND or OR image
  /// bands together.
  ///
  /// See also: [VImage#boolean1], [VImage#bandbool], [VImage#relationalConst]
  /// @param right Right-hand image argument
  /// @param relational [VipsOperationRelational] Relational to perform
  /// @param args Array of VipsOption to apply to this operation
  public VImage relational(VImage right, VipsOperationRelational relational, VipsOption... args)
      throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var relationalOption = VipsOption.Enum("relational", relational);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    callArgs.add(relationalOption);
    VipsInvoker.invokeOperation(arena, "relational", callArgs);
    return outOption.valueOrThrow();
  }

  /// Perform various relational operations on an image and an array of
  /// constants.
  ///
  /// The output type is always uchar, with 0 for `FALSE` and 255 for `TRUE`.
  ///
  /// If the array of constants has just one element, that constant is used for
  /// all image bands. If the array has more than one element and they have
  /// the same number of elements as there are bands in the image, then
  /// one array element is used for each band. If the arrays have more than one
  /// element and the image only has a single band, the result is a many-band
  /// image where each band corresponds to one array element.
  ///
  /// See also: [VImage#boolean1], [VImage#relational]
  /// @param relational [VipsOperationRelational] Relational to perform
  /// @param c Array of constants
  /// @param args Array of VipsOption to apply to this operation
  public VImage relationalConst(VipsOperationRelational relational, List<Double> c,
      VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var relationalOption = VipsOption.Enum("relational", relational);
    var cOption = VipsOption.ArrayDouble("c", c);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(relationalOption);
    callArgs.add(cOption);
    VipsInvoker.invokeOperation(arena, "relational_const", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation calculates `left` % `right` (remainder after integer division)
  /// and writes the result to `out`. The images may have any
  /// non-complex format. For float formats, [VImage#remainder] calculates `in1` -
  /// `in2` * floor (@in1 / `in2`).
  ///
  /// If the images differ in size, the smaller image is enlarged to match the
  /// larger by adding zero pixels along the bottom and right.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The two input images are cast up to the smallest common format (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)), and that format is the
  /// result type.
  ///
  /// See also: [VImage#remainderConst], [VImage#divide], [VImage#round]
  /// @param right Right-hand image argument
  /// @param args Array of VipsOption to apply to this operation
  public VImage remainder(VImage right, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "remainder", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation calculates `in` % `c` (remainder after division by an
  /// array of constants)
  /// and writes the result to `out`.
  /// The image may have any
  /// non-complex format. For float formats, [VImage#remainderConst] calculates
  /// `in` - `c` * floor (@in / `c`).
  ///
  /// If the array of constants has just one element, that constant is used for
  /// all image bands. If the array has more than one element and they have
  /// the same number of elements as there are bands in the image, then
  /// one array element is used for each band. If the arrays have more than one
  /// element and the image only has a single band, the result is a many-band
  /// image where each band corresponds to one array element.
  ///
  /// See also: [VImage#remainder], [VImage#divide], [VImage#round]
  /// @param c Array of constants
  /// @param args Array of VipsOption to apply to this operation
  public VImage remainderConst(List<Double> c, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var cOption = VipsOption.ArrayDouble("c", c);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(cOption);
    VipsInvoker.invokeOperation(arena, "remainder_const", callArgs);
    return outOption.valueOrThrow();
  }

  /// [VImage#remosaic] works rather as [VImage#globalbalance]. It
  /// takes apart the mosaiced image `in` and rebuilds it, substituting images.
  ///
  /// Unlike [VImage#globalbalance], images are substituted based on their
  /// filenames. The rightmost occurrence of the string `old_str` is swapped
  /// for `new_str`, that file is opened, and that image substituted for
  /// the old image.
  ///
  /// It's convenient for multispectral images. You can mosaic one band, then
  /// use that mosaic as a template for mosaicing the others automatically.
  ///
  /// See also: [VImage#globalbalance]
  /// @param oldStr Search for this string
  /// @param newStr And swap for this string
  /// @param args Array of VipsOption to apply to this operation
  public VImage remosaic(String oldStr, String newStr, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var oldStrOption = VipsOption.String("old-str", oldStr);
    var newStrOption = VipsOption.String("new-str", newStr);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(oldStrOption);
    callArgs.add(newStrOption);
    VipsInvoker.invokeOperation(arena, "remosaic", callArgs);
    return outOption.valueOrThrow();
  }

  /// Repeats an image many times.
  ///
  /// See also: [VImage#extractArea]
  /// @param across Repeat this many times horizontally
  /// @param down Repeat this many times vertically
  /// @param args Array of VipsOption to apply to this operation
  public VImage replicate(int across, int down, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var acrossOption = VipsOption.Int("across", across);
    var downOption = VipsOption.Int("down", down);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(acrossOption);
    callArgs.add(downOption);
    VipsInvoker.invokeOperation(arena, "replicate", callArgs);
    return outOption.valueOrThrow();
  }

  /// Resize an image.
  ///
  /// Set `gap` to speed up downsizing by having [VImage#shrink] to shrink
  /// with a box filter first. The bigger `gap`, the closer the result
  /// to the fair resampling. The smaller `gap`, the faster resizing.
  /// The default value is 2.0 (very close to fair resampling
  /// while still being faster in many cases).
  ///
  /// [VImage#resize] normally uses [VipsKernel#KERNEL_LANCZOS3] for the final
  /// reduce, you can change this with `kernel`. Downsizing is done with centre
  /// convention.
  ///
  /// When upsizing (@scale > 1), the operation uses [VImage#affine] with
  /// a `Interpolate` selected depending on `kernel`. It will use
  /// `Interpolate` "bicubic" for [VipsKernel#KERNEL_CUBIC] and above. It
  /// adds a 0.5 pixel displacement to the input pixels to get centre convention
  /// scaling.
  ///
  /// [VImage#resize] normally maintains the image aspect ratio. If you set
  /// `vscale`, that factor is used for the vertical scale and `scale` for the
  /// horizontal.
  ///
  /// If either axis would drop below 1px in size, the shrink in that dimension
  /// is limited. This breaks the image aspect ratio, but prevents errors due to
  /// fractional pixel sizes.
  ///
  /// This operation does not change xres or yres. The image resolution needs to
  /// be updated by the application.
  ///
  /// This operation does not premultiply alpha. If your image has an alpha
  /// channel, you should use [VImage#premultiply] on it first.
  ///
  /// See also: [VImage#premultiply], [VImage#shrink], [VImage#reduce]
  /// @param scale Scale image by this factor
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg interpolate [VipsOption.Interpolate] Interpolate pixels with this
  /// @optionalArg kernel [VipsOption.Enum] [VipsKernel] Resampling kernel
  /// @optionalArg gap [VipsOption.Double] Reducing gap
  /// @optionalArg centre [VipsOption.Boolean] Use centre sampling convention
  /// @optionalArg vscale [VipsOption.Double] Vertical scale image by this factor
  /// @optionalArg idx [VipsOption.Double] Horizontal input displacement
  /// @optionalArg idy [VipsOption.Double] Vertical input displacement
  public VImage resize(double scale, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var scaleOption = VipsOption.Double("scale", scale);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(scaleOption);
    VipsInvoker.invokeOperation(arena, "resize", callArgs);
    return outOption.valueOrThrow();
  }

  /// Rotate `in` by a multiple of 90 degrees.
  ///
  /// Use [VImage#similarity] to rotate by an arbitrary angle.
  /// [VImage#rot45] is useful for rotating convolution masks by 45 degrees.
  ///
  /// See also: [VImage#flip], [VImage#similarity], [VImage#rot45]
  /// @param angle [VipsAngle] Angle to rotate image
  /// @param args Array of VipsOption to apply to this operation
  public VImage rot(VipsAngle angle, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var angleOption = VipsOption.Enum("angle", angle);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(angleOption);
    VipsInvoker.invokeOperation(arena, "rot", callArgs);
    return outOption.valueOrThrow();
  }

  /// Rotate `in` by a multiple of 45 degrees. Odd-length sides and square images
  /// only.
  ///
  /// This operation is useful for rotating convolution masks. Use
  /// [VImage#similarity] to rotate images by arbitrary angles.
  ///
  /// See also: [VImage#rot], [VImage#similarity]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg angle [VipsOption.Enum] [VipsAngle45] Angle to rotate image
  public VImage rot45(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "rot45", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operator calls [VImage#affine] for you, calculating the matrix
  /// for the affine transform from `scale` and `angle`.
  ///
  /// Other parameters are passed on to [VImage#affine] unaltered.
  ///
  /// See also: [VImage#affine], `Interpolate`
  /// @param angle Rotate clockwise by this many degrees
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg interpolate [VipsOption.Interpolate] Interpolate pixels with this
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg odx [VipsOption.Double] Horizontal output displacement
  /// @optionalArg ody [VipsOption.Double] Vertical output displacement
  /// @optionalArg idx [VipsOption.Double] Horizontal input displacement
  /// @optionalArg idy [VipsOption.Double] Vertical input displacement
  public VImage rotate(double angle, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var angleOption = VipsOption.Double("angle", angle);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(angleOption);
    VipsInvoker.invokeOperation(arena, "rotate", callArgs);
    return outOption.valueOrThrow();
  }

  /// Round to an integral value.
  ///
  /// Copy for integer types, round float and
  /// complex types.
  ///
  /// The format of `out` is always the same as `in`, so you may wish to cast to an
  /// integer format afterwards.
  ///
  /// See also: [VImage#cast]
  /// @param round [VipsOperationRound] Rounding operation to perform
  /// @param args Array of VipsOption to apply to this operation
  public VImage round(VipsOperationRound round, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var roundOption = VipsOption.Enum("round", round);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(roundOption);
    VipsInvoker.invokeOperation(arena, "round", callArgs);
    return outOption.valueOrThrow();
  }

  /// Convert to HSV.
  ///
  /// HSV is a crude polar coordinate system for RGB images. It is provided for
  /// compatibility with other image processing systems. See [VImage#Lab2LCh] for a
  /// much better colour space.
  ///
  /// See also: [VImage#HSV2sRGB], [VImage#Lab2LCh]
  /// @param args Array of VipsOption to apply to this operation
  public VImage sRGB2HSV(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sRGB2HSV", callArgs);
    return outOption.valueOrThrow();
  }

  /// Convert an sRGB image to scRGB.
  ///
  /// RGB16 images are also handled.
  ///
  /// See also: [VImage#scRGB2XYZ], [VImage#scRGB2sRGB], [VImage#rad2float]
  /// @param args Array of VipsOption to apply to this operation
  public VImage sRGB2scRGB(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sRGB2scRGB", callArgs);
    return outOption.valueOrThrow();
  }

  /// Convert an scRGB image to greyscale. Set `depth` to 16 to get 16-bit output.
  ///
  /// See also: [VImage#LabS2LabQ], [VImage#sRGB2scRGB], [VImage#rad2float]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg depth [VipsOption.Int] Output device space depth in bits
  public VImage scRGB2BW(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "scRGB2BW", callArgs);
    return outOption.valueOrThrow();
  }

  /// Turn XYZ to scRGB.
  /// @param args Array of VipsOption to apply to this operation
  public VImage scRGB2XYZ(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "scRGB2XYZ", callArgs);
    return outOption.valueOrThrow();
  }

  /// Convert an scRGB image to sRGB. Set `depth` to 16 to get 16-bit output.
  ///
  /// See also: [VImage#LabS2LabQ], [VImage#sRGB2scRGB], [VImage#rad2float]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg depth [VipsOption.Int] Output device space depth in bits
  public VImage scRGB2sRGB(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "scRGB2sRGB", callArgs);
    return outOption.valueOrThrow();
  }

  /// Search the image for the maximum and minimum value, then return the image
  /// as unsigned 8-bit, scaled so that the maximum value is 255 and the
  /// minimum is zero.
  ///
  /// If `log` is set, transform with log10(1.0 + pow(x, `exp`)) + .5,
  /// then scale so max == 255. By default, `exp` is 0.25.
  ///
  /// See also: [VImage#cast]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg exp [VipsOption.Double] Exponent for log scale
  /// @optionalArg log [VipsOption.Boolean] Log scale
  public VImage scale(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "scale", callArgs);
    return outOption.valueOrThrow();
  }

  /// Scharr edge detector.
  ///
  /// uchar images are computed using a fast, low-precision path. Cast to float
  /// for a high-precision implementation.
  ///
  /// See also: [VImage#canny], [VImage#sobel], [VImage#prewitt], [VImage#scharr]
  /// @param args Array of VipsOption to apply to this operation
  public VImage scharr(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "scharr", callArgs);
    return outOption.valueOrThrow();
  }

  /// Create a signed distance field (SDF) image of the given `shape`.
  ///
  /// Different
  /// shapes use different combinations of the optional arguments, see below.
  ///
  /// `shape` [VipsSdfShape#SDF_SHAPE_CIRCLE]: create a circle centred on `a`, radius `r`.
  ///
  /// `shape` [VipsSdfShape#SDF_SHAPE_BOX]: create a box with top-left corner `a` and
  /// bottom-right corner `b`.
  ///
  /// `shape` `Vips.SdfShape.ROUNDED_BOX`: create a box with top-left corner `a`
  /// and bottom-right corner `b`, whose four corners are
  /// rounded by the four-element float array `corners`. `corners` will default to
  /// 0.0.
  ///
  /// `shape` [VipsSdfShape#SDF_SHAPE_LINE]: draw a line from `a` to `b`.
  ///
  /// See also: [VImage#grey], [VImage#grid], [VImage#xyz]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param shape [VipsSdfShape] SDF shape to create
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg r [VipsOption.Double] Radius
  /// @optionalArg a [VipsOption.ArrayDouble] Point a
  /// @optionalArg b [VipsOption.ArrayDouble] Point b
  /// @optionalArg corners [VipsOption.ArrayDouble] Corner radii
  public static VImage sdf(Arena arena, int width, int height, VipsSdfShape shape,
      VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var shapeOption = VipsOption.Enum("shape", shape);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    callArgs.add(shapeOption);
    VipsInvoker.invokeOperation(arena, "sdf", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation behaves rather like [VImage#copy] between images
  /// `in` and `out`, except that it checks that pixels on `in` are only requested
  /// top-to-bottom. This operation is useful for loading file formats which are
  /// strictly top-to-bottom, like PNG.
  ///
  /// `tile_height` can be used to set the size of the tiles that
  /// [VImage#sequential] uses. The default value is 1.
  ///
  /// See also: [VImage#linecache], [VImage#tilecache]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg trace [VipsOption.Boolean] Trace pixel requests
  /// @optionalArg tile-height [VipsOption.Int] Tile height in pixels
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Expected access pattern
  public VImage sequential(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sequential", callArgs);
    return outOption.valueOrThrow();
  }

  /// Selectively sharpen the L channel of a LAB image. The input image is
  /// transformed to [VipsInterpretation#INTERPRETATION_LABS].
  ///
  /// The operation performs a gaussian blur and subtracts from `in` to generate a
  /// high-frequency signal. This signal is passed through a lookup table formed
  /// from the five parameters and added back to `in`.
  ///
  /// The lookup table is formed like this:
  ///
  /// ```
  ///                     ^
  ///                  y2 |- - - - - -----------
  ///                     |         /
  ///                     |        / slope m2
  ///                     |    .../
  ///             -x1     | ...   |
  /// -------------------...---------------------->
  ///             |   ... |      x1
  ///             |... slope m1
  ///             /       |
  ///            / m2     |
  ///           /         |
  ///          /          |
  ///         /           |
  ///        /            |
  /// ______/ _ _ _ _ _ _ | -y3
  ///                     |
  /// ```
  ///
  /// For screen output, we suggest the following settings (the defaults):
  ///
  /// ```
  /// sigma == 0.5
  /// x1 == 2
  /// y2 == 10         (don't brighten by more than 10 L*)
  /// y3 == 20         (can darken by up to 20 L*)
  /// m1 == 0          (no sharpening in flat areas)
  /// m2 == 3          (some sharpening in jaggy areas)
  /// ```
  ///
  /// If you want more or less sharpening, we suggest you just change the
  /// m2 parameter.
  ///
  /// The `sigma` parameter changes the width of the fringe and can be
  /// adjusted according to the output printing resolution. As an approximate
  /// guideline, use 0.5 for 4 pixels/mm (display resolution),
  /// 1.0 for 12 pixels/mm and 1.5 for 16 pixels/mm (300 dpi == 12
  /// pixels/mm). These figures refer to the image raster, not the half-tone
  /// resolution.
  ///
  /// See also: [VImage#conv]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg radius [VipsOption.Int] Radius of Gaussian
  /// @optionalArg sigma [VipsOption.Double] Sigma of Gaussian
  /// @optionalArg x1 [VipsOption.Double] Flat/jaggy threshold
  /// @optionalArg y2 [VipsOption.Double] Maximum brightening
  /// @optionalArg y3 [VipsOption.Double] Maximum darkening
  /// @optionalArg m1 [VipsOption.Double] Slope for flat areas
  /// @optionalArg m2 [VipsOption.Double] Slope for jaggy areas
  public VImage sharpen(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sharpen", callArgs);
    return outOption.valueOrThrow();
  }

  /// Shrink `in` by a pair of factors with a simple box filter.
  ///
  /// For non-integer factors, [VImage#shrink] will first shrink by the
  /// integer part with a box filter, then use [VImage#reduce] to shrink
  /// by the remaining fractional part.
  ///
  /// This is a very low-level operation: see [VImage#resize] for a more
  /// convenient way to resize images.
  ///
  /// This operation does not change xres or yres. The image resolution needs to
  /// be updated by the application.
  ///
  /// See also: [VImage#resize], [VImage#reduce]
  /// @param xshrink Horizontal shrink factor
  /// @param hshrink Horizontal shrink factor
  /// @param yshrink Vertical shrink factor
  /// @param vshrink Vertical shrink factor
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg ceil [VipsOption.Boolean] Round-up output dimensions
  public VImage shrink(double xshrink, double hshrink, double yshrink, double vshrink,
      VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var xshrinkOption = VipsOption.Double("xshrink", xshrink);
    var hshrinkOption = VipsOption.Double("hshrink", hshrink);
    var yshrinkOption = VipsOption.Double("yshrink", yshrink);
    var vshrinkOption = VipsOption.Double("vshrink", vshrink);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(xshrinkOption);
    callArgs.add(hshrinkOption);
    callArgs.add(yshrinkOption);
    callArgs.add(vshrinkOption);
    VipsInvoker.invokeOperation(arena, "shrink", callArgs);
    return outOption.valueOrThrow();
  }

  /// Shrink `in` horizontally by an integer factor.
  /// Each pixel in the output is
  /// the average of the corresponding line of `hshrink` pixels in the input.
  ///
  /// This is a very low-level operation: see [VImage#resize] for a more
  /// convenient way to resize images.
  ///
  /// This operation does not change xres or yres. The image resolution needs to
  /// be updated by the application.
  ///
  /// See also: [VImage#shrinkv], [VImage#shrink], [VImage#resize], [VImage#affine]
  /// @param xshrink Horizontal shrink factor
  /// @param hshrink Horizontal shrink factor
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg ceil [VipsOption.Boolean] Round-up output dimensions
  public VImage shrinkh(int xshrink, int hshrink, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var xshrinkOption = VipsOption.Int("xshrink", xshrink);
    var hshrinkOption = VipsOption.Int("hshrink", hshrink);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(xshrinkOption);
    callArgs.add(hshrinkOption);
    VipsInvoker.invokeOperation(arena, "shrinkh", callArgs);
    return outOption.valueOrThrow();
  }

  /// Shrink `in` vertically by an integer factor.
  ///
  /// Each pixel in the output is
  /// the average of the corresponding column of `vshrink` pixels in the input.
  ///
  /// This is a very low-level operation: see [VImage#resize] for a more
  /// convenient way to resize images.
  ///
  /// This operation does not change xres or yres. The image resolution needs to
  /// be updated by the application.
  ///
  /// See also: [VImage#shrinkh], [VImage#shrink], [VImage#resize], [VImage#affine]
  /// @param yshrink Vertical shrink factor
  /// @param vshrink Vertical shrink factor
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg ceil [VipsOption.Boolean] Round-up output dimensions
  public VImage shrinkv(int yshrink, int vshrink, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var yshrinkOption = VipsOption.Int("yshrink", yshrink);
    var vshrinkOption = VipsOption.Int("vshrink", vshrink);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(yshrinkOption);
    callArgs.add(vshrinkOption);
    VipsInvoker.invokeOperation(arena, "shrinkv", callArgs);
    return outOption.valueOrThrow();
  }

  /// Finds the unit vector in the direction of the pixel value. For non-complex
  /// images, it returns a signed char image with values -1, 0, and 1 for negative,
  /// zero and positive pixels. For complex images, it returns a
  /// complex normalised to length 1.
  ///
  /// See also: [VImage#abs]
  /// @param args Array of VipsOption to apply to this operation
  public VImage sign(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sign", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operator calls [VImage#affine] for you, calculating the matrix
  /// for the affine transform from `scale` and `angle`. Other parameters are
  /// passed on to [VImage#affine] unaltered.
  ///
  /// See also: [VImage#affine], `Interpolate`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg scale [VipsOption.Double] Scale by this factor
  /// @optionalArg angle [VipsOption.Double] Rotate clockwise by this many degrees
  /// @optionalArg interpolate [VipsOption.Interpolate] Interpolate pixels with this
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg odx [VipsOption.Double] Horizontal output displacement
  /// @optionalArg ody [VipsOption.Double] Vertical output displacement
  /// @optionalArg idx [VipsOption.Double] Horizontal input displacement
  /// @optionalArg idy [VipsOption.Double] Vertical input displacement
  public VImage similarity(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "similarity", callArgs);
    return outOption.valueOrThrow();
  }

  /// Creates a float one band image of the a sine waveform in two
  /// dimensions.
  ///
  /// The number of horizontal and vertical spatial frequencies are
  /// determined by the variables `hfreq` and `vfreq` respectively.  The
  /// function is useful for creating displayable sine waves and
  /// square waves in two dimensions.
  ///
  /// If horfreq and verfreq are integers the resultant image is periodical
  /// and therefore the Fourier transform does not present spikes
  ///
  /// Pixels are normally in [-1, +1], set `uchar` to output [0, 255].
  ///
  /// See also: [VImage#grey], [VImage#xyz]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  /// @optionalArg hfreq [VipsOption.Double] Horizontal spatial frequency
  /// @optionalArg vfreq [VipsOption.Double] Vertical spatial frequency
  public static VImage sines(Arena arena, int width, int height, VipsOption... args) throws
      VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "sines", callArgs);
    return outOption.valueOrThrow();
  }

  /// Crop an image down to a specified width and height by removing boring parts.
  ///
  /// Use `interesting` to pick the method vips uses to decide which bits of the
  /// image should be kept.
  ///
  /// You can test xoffset / yoffset on `out` to find the location of the crop
  /// within the input image.
  ///
  /// See also: [VImage#extractArea]
  /// @param width Width of extract area
  /// @param height Height of extract area
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg attention-x [VipsOption.Int] Horizontal position of attention centre
  /// @optionalArg attention-y [VipsOption.Int] Vertical position of attention centre
  /// @optionalArg interesting [VipsOption.Enum] [VipsInteresting] How to measure interestingness
  /// @optionalArg premultiplied [VipsOption.Boolean] Input image already has premultiplied alpha
  public VImage smartcrop(int width, int height, VipsOption... args) throws VipsError {
    var inputOption = VipsOption.Image("input", this);
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inputOption);
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "smartcrop", callArgs);
    return outOption.valueOrThrow();
  }

  /// Sobel edge detector.
  ///
  /// uchar images are computed using a fast, low-precision path. Cast to float
  /// for a high-precision implementation.
  ///
  /// See also: [VImage#canny], [VImage#sobel], [VImage#prewitt], [VImage#scharr]
  /// @param args Array of VipsOption to apply to this operation
  public VImage sobel(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sobel", callArgs);
    return outOption.valueOrThrow();
  }

  /// Calculate a correlation surface.
  ///
  /// `ref` is placed at every position in `in` and the correlation coefficient
  /// calculated. The output
  /// image is always float.
  ///
  /// The output
  /// image is the same size as the input. Extra input edge pixels are made by
  /// copying the existing edges outwards.
  ///
  /// The correlation coefficient is calculated as:
  ///
  /// ```
  ///          sumij (ref(i,j)-mean(ref))(inkl(i,j)-mean(inkl))
  /// c(k,l) = ------------------------------------------------
  ///          sqrt(sumij (ref(i,j)-mean(ref))^2) *
  ///                      sqrt(sumij (inkl(i,j)-mean(inkl))^2)
  /// ```
  ///
  /// where inkl is the area of `in` centred at position (k,l).
  ///
  /// from Niblack "An Introduction to Digital Image Processing",
  /// Prentice/Hall, pp 138.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The output image is always float, unless either of the two inputs is
  /// double, in which case the output is also double.
  ///
  /// See also: [VImage#fastcor]
  /// @param ref Input reference image
  /// @param args Array of VipsOption to apply to this operation
  public VImage spcor(VImage ref, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var refOption = VipsOption.Image("ref", ref);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(refOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "spcor", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make a displayable (ie. 8-bit unsigned int) power spectrum.
  ///
  /// If `in` is non-complex, it is transformed to Fourier space. Then the
  /// absolute value is passed through [VImage#scale] in log mode, and
  /// [VImage#wrap].
  ///
  /// See also: [VImage#fwfft], [VImage#scale], [VImage#wrap]
  /// @param args Array of VipsOption to apply to this operation
  public VImage spectrum(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "spectrum", callArgs);
    return outOption.valueOrThrow();
  }

  /// Find many image statistics in a single pass through the data. `out` is a
  /// one-band [VipsBandFormat#FORMAT_DOUBLE] image of at least 10 columns by n + 1
  /// (where n is number of bands in image `in`)
  /// rows. Columns are statistics, and are, in order: minimum, maximum, sum,
  /// sum of squares, mean, standard deviation, x coordinate of minimum, y
  /// coordinate of minimum, x coordinate of maximum, y coordinate of maximum.
  /// Later versions of [VImage#stats] may add more columns.
  ///
  /// Row 0 has statistics for all
  /// bands together, row 1 has stats for band 1, and so on.
  ///
  /// If there is more than one maxima or minima, one of them will be chosen at
  /// random.
  ///
  /// See also: [VImage#avg], [VImage#min]
  /// @param args Array of VipsOption to apply to this operation
  public VImage stats(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "stats", callArgs);
    return outOption.valueOrThrow();
  }

  /// [VImage#stdif] performs statistical differencing according to the
  /// formula given in page 45 of the book "An Introduction to Digital Image
  /// Processing" by Wayne Niblack.
  ///
  /// This transformation emphasises the way in
  /// which a pel differs statistically from its neighbours. It is useful for
  /// enhancing low-contrast images with lots of detail, such as X-ray plates.
  ///
  /// At point (i,j) the output is given by the equation:
  ///
  /// ```
  /// vout(i,j) = `a` * `m0` + (1 - `a`) * meanv +
  ///       (vin(i,j) - meanv) * (@b * `s0`) / (@s0 + `b` * stdv)
  /// ```
  ///
  /// Values `a`, `m0`, `b` and `s0` are entered, while meanv and stdv are the values
  /// calculated over a moving window of size `width`, `height` centred on pixel
  /// (i,j). `m0` is the new mean, `a` is the weight given to it. `s0` is the new
  /// standard deviation, `b` is the weight given to it.
  ///
  /// Try:
  ///
  /// ```
  /// vips stdif $VIPSHOME/pics/huysum.v fred.v 0.5 128 0.5 50 11 11
  /// ```
  ///
  /// The operation works on one-band uchar images only, and writes a one-band
  /// uchar image as its result. The output image has the same size as the
  /// input.
  ///
  /// See also: [VImage#histLocal]
  /// @param width Window width in pixels
  /// @param height Window height in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg s0 [VipsOption.Double] New deviation
  /// @optionalArg b [VipsOption.Double] Weight of new deviation
  /// @optionalArg m0 [VipsOption.Double] New mean
  /// @optionalArg a [VipsOption.Double] Weight of new mean
  public VImage stdif(int width, int height, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "stdif", callArgs);
    return outOption.valueOrThrow();
  }

  /// Subsample an image by an integer fraction. This is fast, nearest-neighbour
  /// shrink.
  ///
  /// For small horizontal shrinks, this operation will fetch lines of pixels
  /// from `in` and then subsample that line. For large shrinks it will fetch
  /// single pixels.
  ///
  /// If `point` is set, `in` will always be sampled in points. This can be faster
  /// if the previous operations in the pipeline are very slow.
  ///
  /// See also: [VImage#affine], [VImage#shrink], [VImage#zoom]
  /// @param xfac Horizontal subsample factor
  /// @param yfac Vertical subsample factor
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg point [VipsOption.Boolean] Point sample
  public VImage subsample(int xfac, int yfac, VipsOption... args) throws VipsError {
    var inputOption = VipsOption.Image("input", this);
    var outOption = VipsOption.Image("out");
    var xfacOption = VipsOption.Int("xfac", xfac);
    var yfacOption = VipsOption.Int("yfac", yfac);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inputOption);
    callArgs.add(outOption);
    callArgs.add(xfacOption);
    callArgs.add(yfacOption);
    VipsInvoker.invokeOperation(arena, "subsample", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation calculates `in1` - `in2` and writes the result to `out`.
  ///
  /// If the images differ in size, the smaller image is enlarged to match the
  /// larger by adding zero pixels along the bottom and right.
  ///
  /// If the number of bands differs, one of the images
  /// must have one band. In this case, an n-band image is formed from the
  /// one-band image by joining n copies of the one-band image together, and then
  /// the two n-band images are operated upon.
  ///
  /// The two input images are cast up to the smallest common format (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)), then the
  /// following table is used to determine the output type:
  ///
  /// ## [VImage#subtract] type promotion
  ///
  /// | input type     | output type    |
  /// |----------------|----------------|
  /// | uchar          | short          |
  /// | char           | short          |
  /// | ushort         | int            |
  /// | short          | int            |
  /// | uint           | int            |
  /// | int            | int            |
  /// | float          | float          |
  /// | double         | double         |
  /// | complex        | complex        |
  /// | double complex | double complex |
  ///
  /// In other words, the output type is just large enough to hold the whole
  /// range of possible values.
  ///
  /// See also: [VImage#add], [VImage#linear]
  /// @param right Right-hand image argument
  /// @param args Array of VipsOption to apply to this operation
  public VImage subtract(VImage right, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", right);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "subtract", callArgs);
    return outOption.valueOrThrow();
  }

  /// This operation sums all images in `in` and writes the result to `out`.
  ///
  /// If the images differ in size, the smaller images are enlarged to match the
  /// largest by adding zero pixels along the bottom and right.
  ///
  /// If the number of bands differs, all but one of the images
  /// must have one band. In this case, n-band images are formed from the
  /// one-band images by joining n copies of the one-band images together, and then
  /// the n-band images are operated upon.
  ///
  /// The input images are cast up to the smallest common format (see table
  /// Smallest common format in
  /// [arithmetic](libvips-arithmetic.html)), then the
  /// following table is used to determine the output type:
  ///
  /// ## [VImage#sum] type promotion
  ///
  /// | input type     | output type    |
  /// |----------------|----------------|
  /// | uchar          | uint           |
  /// | char           | int            |
  /// | ushort         | uint           |
  /// | short          | int            |
  /// | uint           | uint           |
  /// | int            | int            |
  /// | float          | float          |
  /// | double         | double         |
  /// | complex        | complex        |
  /// | double complex | double complex |
  ///
  /// In other words, the output type is just large enough to hold the whole
  /// range of possible values.
  ///
  /// See also: [VImage#add]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param in Array of input images
  /// @param args Array of VipsOption to apply to this operation
  public static VImage sum(Arena arena, List<VImage> in, VipsOption... args) throws VipsError {
    var inOption = VipsOption.ArrayImage("in", in);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sum", callArgs);
    return outOption.valueOrThrow();
  }

  /// Render a SVG file into a VIPS image.
  ///
  /// Rendering uses the librsvg library and should be fast.
  ///
  /// Use `dpi` to set the rendering resolution. The default is 72. Additionally,
  /// you can scale by setting `scale`. If you set both, they combine.
  ///
  /// This function only reads the image header and does not render any pixel
  /// data. Rendering occurs when pixels are accessed.
  ///
  /// SVGs larger than 10MB are normally blocked for security. Set `unlimited` to
  /// allow SVGs of any size.
  ///
  /// A UTF-8 string containing custom CSS can be provided via `stylesheet`.
  /// During the CSS cascade, the specified stylesheet will be applied with a
  /// User Origin. This feature requires librsvg 2.48.0 or later.
  ///
  /// If `high_bitdepth` is set and the version of cairo supports it
  /// (e.g. cairo >= 1.17.2), enable 128-bit scRGB output (32-bit per channel).
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg dpi [VipsOption.Double] Render at this DPI
  /// @optionalArg scale [VipsOption.Double] Scale output by this factor
  /// @optionalArg unlimited [VipsOption.Boolean] Allow SVG of any size
  /// @optionalArg stylesheet [VipsOption.String] Custom CSS
  /// @optionalArg high-bitdepth [VipsOption.Boolean] Enable scRGB 128-bit output (32-bit per channel)
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage svgload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "svgload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a SVG-formatted memory block into a VIPS image. Exactly as
  /// [VImage#svgload], but read from a memory buffer.
  ///
  /// You must not free the buffer while `out` is active. The
  /// `Object::postclose` signal on `out` is a good place to free.
  ///
  /// See also: [VImage#svgload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg dpi [VipsOption.Double] Render at this DPI
  /// @optionalArg scale [VipsOption.Double] Scale output by this factor
  /// @optionalArg unlimited [VipsOption.Boolean] Allow SVG of any size
  /// @optionalArg stylesheet [VipsOption.String] Custom CSS
  /// @optionalArg high-bitdepth [VipsOption.Boolean] Enable scRGB 128-bit output (32-bit per channel)
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage svgloadBuffer(Arena arena, VBlob buffer, VipsOption... args) throws
      VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "svgload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#svgload], but read from a source.
  ///
  /// See also: [VImage#svgload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg dpi [VipsOption.Double] Render at this DPI
  /// @optionalArg scale [VipsOption.Double] Scale output by this factor
  /// @optionalArg unlimited [VipsOption.Boolean] Allow SVG of any size
  /// @optionalArg stylesheet [VipsOption.String] Custom CSS
  /// @optionalArg high-bitdepth [VipsOption.Boolean] Enable scRGB 128-bit output (32-bit per channel)
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage svgloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "svgload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// The `tests` images are evaluated and at each point the index of the first
  /// non-zero value is written to `out`. If all `tests` are false, the value
  /// (@n + 1) is written.
  ///
  /// Images in `tests` must have one band. They are expanded to the
  /// bounding box of the set of images in `tests`, and that size is used for
  /// `out`. `tests` can have up to 255 elements.
  ///
  /// Combine with [VImage#case1] to make an efficient multi-way [VImage#ifthenelse].
  ///
  /// See also: [VImage#maplut], [VImage#case1], [VImage#ifthenelse]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param tests Table of images to test
  /// @param args Array of VipsOption to apply to this operation
  public static VImage switch1(Arena arena, List<VImage> tests, VipsOption... args) throws
      VipsError {
    var testsOption = VipsOption.ArrayImage("tests", tests);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(testsOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "switch", callArgs);
    return outOption.valueOrThrow();
  }

  /// Draw the string `text` to an image.
  ///
  /// `out` is normally a one-band 8-bit
  /// unsigned char image, with 0 for no text and 255 for text. Values between
  /// are used for anti-aliasing.
  ///
  /// Set `rgba` to enable RGBA output. This is useful for colour emoji rendering,
  /// or support for pango markup features like `<span
  /// foreground="red">Red!</span>`.
  ///
  /// `text` is the text to render as a UTF-8 string. It can contain Pango markup,
  /// for example `<i>The</i>Guardian`.
  ///
  /// `font` is the font to render with, as a fontconfig name. Examples might be
  /// `sans 12` or perhaps `bitstream charter bold 10`.
  ///
  /// You can specify a font to load with `fontfile`. You'll need to also set the
  /// name of the font with `font`.
  ///
  /// `width` is the number of pixels to word-wrap at. By default, lines of text
  /// wider than this will be broken at word boundaries.
  /// Use `wrap` to set lines to wrap on word or character boundaries, or to
  /// disable line breaks.
  ///
  /// Set `justify` to turn on line justification.
  /// `align` can be used to set the alignment style for multi-line
  /// text to the low (left) edge centre, or high (right) edge. Note that the
  /// output image can be wider than `width` if there are no
  /// word breaks, or narrower if the lines don't break exactly at `width`.
  ///
  /// `height` is the maximum number of pixels high the generated text can be. This
  /// only takes effect when `dpi` is not set, and `width` is set, making a box.
  /// In this case, [VImage#text] will search for a `dpi` and set of line breaks
  /// which will just fit the text into `width` and `height`.
  ///
  /// You can use `autofit_dpi` to read out the DPI selected by auto fit.
  ///
  /// `dpi` sets the resolution to render at. "sans 12" at 72 dpi draws characters
  /// approximately 12 pixels high.
  ///
  /// `spacing` sets the line spacing, in points. It would typically be something
  /// like font size times 1.2.
  ///
  /// You can read the coordinate of the top edge of the character from `Xoffset`
  /// / `Yoffset`. This can be helpful if you need to line up the output of
  /// several [VImage#text].
  ///
  /// See also: [VImage#bandjoin], [VImage#composite]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param text Text to render
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg font [VipsOption.String] Font to render with
  /// @optionalArg width [VipsOption.Int] Maximum image width in pixels
  /// @optionalArg height [VipsOption.Int] Maximum image height in pixels
  /// @optionalArg align [VipsOption.Enum] [VipsAlign] Align on the low, centre or high edge
  /// @optionalArg justify [VipsOption.Boolean] Justify lines
  /// @optionalArg dpi [VipsOption.Int] DPI to render at
  /// @optionalArg autofit-dpi [VipsOption.Int] DPI selected by autofit
  /// @optionalArg spacing [VipsOption.Int] Line spacing
  /// @optionalArg fontfile [VipsOption.String] Load this font file
  /// @optionalArg rgba [VipsOption.Boolean] Enable RGBA output
  /// @optionalArg wrap [VipsOption.Enum] [VipsTextWrap] Wrap lines on word or character boundaries
  public static VImage text(Arena arena, String text, VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var textOption = VipsOption.String("text", text);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(textOption);
    VipsInvoker.invokeOperation(arena, "text", callArgs);
    return outOption.valueOrThrow();
  }

  /// Make a thumbnail from a file.
  ///
  /// Shrinking is done in three stages: using any
  /// shrink-on-load features available in the image load library, using a block
  /// shrink, and using a lanczos3 shrink. At least the final 200% is done with
  /// lanczos3. The output should be high quality, and the operation should be
  /// quick.
  ///
  /// See [VImage#thumbnailBuffer] to thumbnail from a memory buffer, or
  /// [VImage#thumbnailSource] to thumbnail from an arbitrary byte source.
  ///
  /// By default, libvips will only use the first frame of animated or multipage
  /// images. To thumbnail all pages or frames, pass `n=-1` to the loader in
  /// `filename`, for example `"x.gif[n=-1]"`.
  ///
  /// The output image will fit within a square of size `width` x `width`. You can
  /// specify a separate height with the `height` option. Set either `width` or
  /// `height` to a very large number to ignore that dimension.
  ///
  /// If you set `crop`, then the output image will fill the whole of the `width` x
  /// `height` rectangle, with any excess cropped away. See [VImage#smartcrop] for
  /// details on the cropping strategy.
  ///
  /// Normally the operation will upsize or downsize as required to fit the image
  /// inside or outside the target size. If `size` is set to [VipsSize#SIZE_UP],
  /// the operation will only upsize and will just copy if asked to downsize.
  /// If `size` is set to [VipsSize#SIZE_DOWN], the operation will only downsize
  /// and will just copy if asked to upsize.
  /// If `size` is [VipsSize#SIZE_FORCE], the image aspect ratio will be broken
  /// and the image will be forced to fit the target.
  ///
  /// Normally any orientation tags on the input image (such as EXIF tags) are
  /// interpreted to rotate the image upright. If you set `no_rotate` to `TRUE`,
  /// these tags will not be interpreted.
  ///
  /// Shrinking is normally done in sRGB colourspace. Set `linear` to shrink in
  /// linear light colourspace instead. This can give better results, but can
  /// also be far slower, since tricks like JPEG shrink-on-load cannot be used in
  /// linear space.
  ///
  /// If you set `output_profile` to the filename of an ICC profile, the image
  /// will be transformed to the target colourspace before writing to the
  /// output. You can also give an `input_profile` which will be used if the
  /// input image has no ICC profile, or if the profile embedded in the
  /// input image is broken.
  ///
  /// Use `intent` to set the rendering intent for any ICC transform. The default
  /// is [VipsIntent#INTENT_RELATIVE].
  ///
  /// Use `fail_on` to control the types of error that will cause loading to fail.
  /// The default is [VipsFailOn#FAIL_ON_NONE], ie. thumbnail is permissive.
  ///
  /// See also: [VImage#thumbnailBuffer]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to read from
  /// @param width Size to this width
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg height [VipsOption.Int] Size to this height
  /// @optionalArg size [VipsOption.Enum] [VipsSize] Only upsize, only downsize, or both
  /// @optionalArg no-rotate [VipsOption.Boolean] Don't use orientation tags to rotate image upright
  /// @optionalArg crop [VipsOption.Enum] [VipsInteresting] Reduce to fill target rectangle, then crop
  /// @optionalArg linear [VipsOption.Boolean] Reduce in linear light
  /// @optionalArg input-profile [VipsOption.String] Fallback input profile
  /// @optionalArg output-profile [VipsOption.String] Fallback output profile
  /// @optionalArg intent [VipsOption.Enum] [VipsIntent] Rendering intent
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg auto-rotate [VipsOption.Boolean] Use orientation tags to rotate image upright
  /// @optionalArg import-profile [VipsOption.String] Fallback import profile
  /// @optionalArg export-profile [VipsOption.String] Fallback export profile
  public static VImage thumbnail(Arena arena, String filename, int width, VipsOption... args) throws
      VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    callArgs.add(widthOption);
    VipsInvoker.invokeOperation(arena, "thumbnail", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#thumbnail], but read from a memory buffer.
  ///
  /// One extra optional argument, `option_string`, lets you pass options to the
  /// underlying loader.
  ///
  /// See also: [VImage#thumbnail]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param width Size to this width
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg option-string [VipsOption.String] Options that are passed on to the underlying loader
  /// @optionalArg height [VipsOption.Int] Size to this height
  /// @optionalArg size [VipsOption.Enum] [VipsSize] Only upsize, only downsize, or both
  /// @optionalArg no-rotate [VipsOption.Boolean] Don't use orientation tags to rotate image upright
  /// @optionalArg crop [VipsOption.Enum] [VipsInteresting] Reduce to fill target rectangle, then crop
  /// @optionalArg linear [VipsOption.Boolean] Reduce in linear light
  /// @optionalArg input-profile [VipsOption.String] Fallback input profile
  /// @optionalArg output-profile [VipsOption.String] Fallback output profile
  /// @optionalArg intent [VipsOption.Enum] [VipsIntent] Rendering intent
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg auto-rotate [VipsOption.Boolean] Use orientation tags to rotate image upright
  /// @optionalArg import-profile [VipsOption.String] Fallback import profile
  /// @optionalArg export-profile [VipsOption.String] Fallback export profile
  public static VImage thumbnailBuffer(Arena arena, VBlob buffer, int width, VipsOption... args)
      throws VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    callArgs.add(widthOption);
    VipsInvoker.invokeOperation(arena, "thumbnail_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#thumbnail], but read from an existing image.
  ///
  /// This operation
  /// is not able to exploit shrink-on-load features of image load libraries, so
  /// it can be much slower than [VImage#thumbnail] and produce poorer quality
  /// output. Only use this operation if you really have to.
  ///
  /// See also: [VImage#thumbnail]
  /// @param width Size to this width
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg height [VipsOption.Int] Size to this height
  /// @optionalArg size [VipsOption.Enum] [VipsSize] Only upsize, only downsize, or both
  /// @optionalArg no-rotate [VipsOption.Boolean] Don't use orientation tags to rotate image upright
  /// @optionalArg crop [VipsOption.Enum] [VipsInteresting] Reduce to fill target rectangle, then crop
  /// @optionalArg linear [VipsOption.Boolean] Reduce in linear light
  /// @optionalArg input-profile [VipsOption.String] Fallback input profile
  /// @optionalArg output-profile [VipsOption.String] Fallback output profile
  /// @optionalArg intent [VipsOption.Enum] [VipsIntent] Rendering intent
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg auto-rotate [VipsOption.Boolean] Use orientation tags to rotate image upright
  /// @optionalArg import-profile [VipsOption.String] Fallback import profile
  /// @optionalArg export-profile [VipsOption.String] Fallback export profile
  public VImage thumbnailImage(int width, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(widthOption);
    VipsInvoker.invokeOperation(arena, "thumbnail_image", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#thumbnail], but read from a source.
  ///
  /// One extra
  /// optional argument, `option_string`, lets you pass options to the underlying
  /// loader.
  ///
  /// See also: [VImage#thumbnail]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param width Size to this width
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg option-string [VipsOption.String] Options that are passed on to the underlying loader
  /// @optionalArg height [VipsOption.Int] Size to this height
  /// @optionalArg size [VipsOption.Enum] [VipsSize] Only upsize, only downsize, or both
  /// @optionalArg no-rotate [VipsOption.Boolean] Don't use orientation tags to rotate image upright
  /// @optionalArg crop [VipsOption.Enum] [VipsInteresting] Reduce to fill target rectangle, then crop
  /// @optionalArg linear [VipsOption.Boolean] Reduce in linear light
  /// @optionalArg input-profile [VipsOption.String] Fallback input profile
  /// @optionalArg output-profile [VipsOption.String] Fallback output profile
  /// @optionalArg intent [VipsOption.Enum] [VipsIntent] Rendering intent
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg auto-rotate [VipsOption.Boolean] Use orientation tags to rotate image upright
  /// @optionalArg import-profile [VipsOption.String] Fallback import profile
  /// @optionalArg export-profile [VipsOption.String] Fallback export profile
  public static VImage thumbnailSource(Arena arena, VSource source, int width, VipsOption... args)
      throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    callArgs.add(widthOption);
    VipsInvoker.invokeOperation(arena, "thumbnail_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a TIFF file into a VIPS image.
  ///
  /// It is a full baseline TIFF 6 reader,
  /// with extensions for tiled images, multipage images, XYZ and LAB colour
  /// space, pyramidal images and JPEG compression, including CMYK and YCbCr.
  ///
  /// `page` means load this page from the file. By default the first page (page
  /// 0) is read.
  ///
  /// `n` means load this many pages. By default a single page is read. All the
  /// pages must have the same dimensions, and they are loaded as a tall, thin
  /// "toilet roll" image. The `META_PAGE_HEIGHT` metadata
  /// tag gives the height in pixels of each page. Use -1 to load all pages.
  ///
  /// Setting `autorotate` to `TRUE` will make the loader interpret the
  /// orientation tag and automatically rotate the image appropriately during
  /// load.
  ///
  /// If `autorotate` is `FALSE`, the metadata field `META_ORIENTATION` is set
  /// to the value of the orientation tag. Applications may read and interpret
  /// this field
  /// as they wish later in processing. See [VImage#autorot]. Save
  /// operations will use `META_ORIENTATION`, if present, to set the
  /// orientation of output images.
  ///
  /// If `autorotate` is `TRUE`, the image will be rotated upright during load and
  /// no metadata attached. This can be very slow.
  ///
  /// If `subifd` is -1 (the default), the main image is selected for each page.
  /// If it is 0 or greater and there is a SUBIFD tag, the indexed SUBIFD is
  /// selected. This can be used to read lower resolution layers from
  /// bioformats-style image pyramids.
  ///
  /// Use `fail_on` to set the type of error that will cause load to fail. By
  /// default, loaders are permissive, that is, [VipsFailOn#FAIL_ON_NONE].
  ///
  /// When using libtiff 4.7.0+, the TIFF loader will limit memory allocation
  /// for decoding each input file to 50MB to prevent denial of service attacks.
  /// Set `unlimited` to remove this limit.
  ///
  /// Any ICC profile is read and attached to the VIPS image as
  /// `META_ICC_NAME`. Any XMP metadata is read and attached to the image
  /// as `META_XMP_NAME`. Any IPTC is attached as `META_IPTC_NAME`. The
  /// image description is
  /// attached as `META_IMAGEDESCRIPTION`. Data in the photoshop tag is
  /// attached as `META_PHOTOSHOP_NAME`.
  ///
  /// See also: `Image.new_from_file`, [VImage#autorot]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg autorotate [VipsOption.Boolean] Rotate image using orientation tag
  /// @optionalArg subifd [VipsOption.Int] Subifd index
  /// @optionalArg unlimited [VipsOption.Boolean] Remove all denial of service limits
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage tiffload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "tiffload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a TIFF-formatted memory block into a VIPS image. Exactly as
  /// [VImage#tiffload], but read from a memory source.
  ///
  /// You must not free the buffer while `out` is active. The
  /// `Object::postclose` signal on `out` is a good place to free.
  ///
  /// See also: [VImage#tiffload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg autorotate [VipsOption.Boolean] Rotate image using orientation tag
  /// @optionalArg subifd [VipsOption.Int] Subifd index
  /// @optionalArg unlimited [VipsOption.Boolean] Remove all denial of service limits
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage tiffloadBuffer(Arena arena, VBlob buffer, VipsOption... args) throws
      VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "tiffload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#tiffload], but read from a source.
  ///
  /// See also: [VImage#tiffload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg autorotate [VipsOption.Boolean] Rotate image using orientation tag
  /// @optionalArg subifd [VipsOption.Int] Subifd index
  /// @optionalArg unlimited [VipsOption.Boolean] Remove all denial of service limits
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage tiffloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "tiffload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Write a VIPS image to a file as TIFF.
  ///
  /// If `in` has the `META_PAGE_HEIGHT` metadata item, this is assumed to be a
  /// "toilet roll" image. It will be
  /// written as series of pages, each `META_PAGE_HEIGHT` pixels high.
  ///
  /// Use `compression` to set the tiff compression. Currently jpeg, packbits,
  /// fax4, lzw, none, deflate, webp and zstd are supported. The default is no
  /// compression.
  /// JPEG compression is a good lossy compressor for photographs, packbits is
  /// good for 1-bit images, and deflate is the best lossless compression TIFF
  /// can do.
  ///
  /// XYZ images are automatically saved as libtiff LOGLUV with SGILOG compression.
  /// Float LAB images are saved as float CIELAB. Set `bitdepth` to save as 8-bit
  /// CIELAB.
  ///
  /// Use `Q` to set the JPEG compression factor. Default 75.
  ///
  /// User `level` to set the ZSTD (1-22) or Deflate (1-9) compression level. Use `lossless` to
  /// set WEBP lossless mode on. Use `Q` to set the WEBP compression level.
  ///
  /// Use `predictor` to set the predictor for lzw, deflate and zstd compression.
  /// It defaults to [VipsForeignTiffPredictor#FOREIGN_TIFF_PREDICTOR_HORIZONTAL], meaning horizontal
  /// differencing. Please refer to the libtiff
  /// specifications for further discussion of various predictors.
  ///
  /// Set `tile` to `TRUE` to write a tiled tiff.  By default tiff are written in
  /// strips. Use `tile_width` and `tile_height` to set the tile size. The defaiult
  /// is 128 by 128.
  ///
  /// Set `pyramid` to write the image as a set of images, one per page, of
  /// decreasing size. Use `region_shrink` to set how images will be shrunk: by
  /// default each 2x2 block is just averaged, but you can set MODE or MEDIAN as
  /// well.
  ///
  /// By default, the pyramid stops when the image is small enough to fit in one
  /// tile. Use `depth` to stop when the image fits in one pixel, or to only write
  /// a single layer.
  ///
  /// Set `bitdepth` to save 8-bit uchar images as 1, 2 or 4-bit TIFFs.
  /// In case of depth 1: Values >128 are written as white, values <=128 as black.
  /// Normally vips will write MINISBLACK TIFFs where black is a 0 bit, but if you
  /// set `miniswhite`, it will use 0 for a white bit. Many pre-press applications
  /// only work with images which use this sense. `miniswhite` only affects one-bit
  /// images, it does nothing for greyscale images.
  /// In case of depth 2: The same holds but values < 64 are written as black.
  /// For 64 <= values < 128 they are written as dark grey, for 128 <= values < 192
  /// they are written as light gray and values above are written as white.
  /// In case `miniswhite` is set to true this behavior is inverted.
  /// In case of depth 4: values < 16 are written as black, and so on for the
  /// lighter shades. In case `miniswhite` is set to true this behavior is inverted.
  ///
  /// Use `resunit` to override the default resolution unit.
  /// The default
  /// resolution unit is taken from the header field
  /// `META_RESOLUTION_UNIT`. If this field is not set, then
  /// VIPS defaults to cm.
  ///
  /// Use `xres` and `yres` to override the default horizontal and vertical
  /// resolutions. By default these values are taken from the VIPS image header.
  /// libvips resolution is always in pixels per millimetre.
  ///
  /// Set `bigtiff` to attempt to write a bigtiff. Bigtiff is a variant of the TIFF
  /// format that allows more than 4GB in a file.
  ///
  /// Set `properties` to write all vips metadata to the IMAGEDESCRIPTION tag as
  /// xml. If `properties` is not set, the value of `META_IMAGEDESCRIPTION` is
  /// used instead.
  ///
  /// The value of `META_XMP_NAME` is written to
  /// the XMP tag. `META_ORIENTATION` (if set) is used to set the value of
  /// the orientation
  /// tag. `META_IPTC_NAME` (if set) is used to set the value of the IPTC tag.
  /// `META_PHOTOSHOP_NAME` (if set) is used to set the value of the PHOTOSHOP
  /// tag.
  ///
  /// By default, pyramid layers are saved as consecutive pages.
  /// Set `subifd` to save pyramid layers as sub-directories of the main image.
  /// Setting this option can improve compatibility with formats like OME.
  ///
  /// Set `premultiply` to save with premultiplied alpha. Some programs, such as
  /// InDesign, will only work with premultiplied alpha.
  ///
  /// See also: [VImage#tiffload], `Image.write_to_file`
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg compression [VipsOption.Enum] [VipsForeignTiffCompression] Compression for this file
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg predictor [VipsOption.Enum] [VipsForeignTiffPredictor] Compression prediction
  /// @optionalArg tile [VipsOption.Boolean] Write a tiled tiff
  /// @optionalArg tile-width [VipsOption.Int] Tile width in pixels
  /// @optionalArg tile-height [VipsOption.Int] Tile height in pixels
  /// @optionalArg pyramid [VipsOption.Boolean] Write a pyramidal tiff
  /// @optionalArg miniswhite [VipsOption.Boolean] Use 0 for white in 1-bit images
  /// @optionalArg bitdepth [VipsOption.Int] Write as a 1, 2, 4 or 8 bit image
  /// @optionalArg resunit [VipsOption.Enum] [VipsForeignTiffResunit] Resolution unit
  /// @optionalArg xres [VipsOption.Double] Horizontal resolution in pixels/mm
  /// @optionalArg yres [VipsOption.Double] Vertical resolution in pixels/mm
  /// @optionalArg bigtiff [VipsOption.Boolean] Write a bigtiff image
  /// @optionalArg properties [VipsOption.Boolean] Write a properties document to IMAGEDESCRIPTION
  /// @optionalArg region-shrink [VipsOption.Enum] [VipsRegionShrink] Method to shrink regions
  /// @optionalArg level [VipsOption.Int] Deflate (1-9, default 6) or ZSTD (1-22, default 9) compression level
  /// @optionalArg lossless [VipsOption.Boolean] Enable WEBP lossless mode
  /// @optionalArg depth [VipsOption.Enum] [VipsForeignDzDepth] Pyramid depth
  /// @optionalArg subifd [VipsOption.Boolean] Save pyr layers as sub-IFDs
  /// @optionalArg premultiply [VipsOption.Boolean] Save with premultiplied alpha
  /// @optionalArg rgbjpeg [VipsOption.Boolean] Output RGB JPEG rather than YCbCr
  /// @optionalArg squash [VipsOption.Boolean] Squash images down to 1 bit
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void tiffsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "tiffsave", callArgs);
  }

  /// As [VImage#tiffsave], but save to a memory buffer.
  ///
  /// The address of the buffer is returned in `buf`, the length of the buffer in
  /// `len`. You are responsible for freeing the buffer with `GLib.free` when you
  /// are done with it.
  ///
  /// See also: [VImage#tiffsave], `Image.write_to_file`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg compression [VipsOption.Enum] [VipsForeignTiffCompression] Compression for this file
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg predictor [VipsOption.Enum] [VipsForeignTiffPredictor] Compression prediction
  /// @optionalArg tile [VipsOption.Boolean] Write a tiled tiff
  /// @optionalArg tile-width [VipsOption.Int] Tile width in pixels
  /// @optionalArg tile-height [VipsOption.Int] Tile height in pixels
  /// @optionalArg pyramid [VipsOption.Boolean] Write a pyramidal tiff
  /// @optionalArg miniswhite [VipsOption.Boolean] Use 0 for white in 1-bit images
  /// @optionalArg bitdepth [VipsOption.Int] Write as a 1, 2, 4 or 8 bit image
  /// @optionalArg resunit [VipsOption.Enum] [VipsForeignTiffResunit] Resolution unit
  /// @optionalArg xres [VipsOption.Double] Horizontal resolution in pixels/mm
  /// @optionalArg yres [VipsOption.Double] Vertical resolution in pixels/mm
  /// @optionalArg bigtiff [VipsOption.Boolean] Write a bigtiff image
  /// @optionalArg properties [VipsOption.Boolean] Write a properties document to IMAGEDESCRIPTION
  /// @optionalArg region-shrink [VipsOption.Enum] [VipsRegionShrink] Method to shrink regions
  /// @optionalArg level [VipsOption.Int] Deflate (1-9, default 6) or ZSTD (1-22, default 9) compression level
  /// @optionalArg lossless [VipsOption.Boolean] Enable WEBP lossless mode
  /// @optionalArg depth [VipsOption.Enum] [VipsForeignDzDepth] Pyramid depth
  /// @optionalArg subifd [VipsOption.Boolean] Save pyr layers as sub-IFDs
  /// @optionalArg premultiply [VipsOption.Boolean] Save with premultiplied alpha
  /// @optionalArg rgbjpeg [VipsOption.Boolean] Output RGB JPEG rather than YCbCr
  /// @optionalArg squash [VipsOption.Boolean] Squash images down to 1 bit
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public VBlob tiffsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "tiffsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /// As [VImage#tiffsave], but save to a target.
  ///
  /// See also: [VImage#tiffsave], `Image.write_to_target`
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg compression [VipsOption.Enum] [VipsForeignTiffCompression] Compression for this file
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg predictor [VipsOption.Enum] [VipsForeignTiffPredictor] Compression prediction
  /// @optionalArg tile [VipsOption.Boolean] Write a tiled tiff
  /// @optionalArg tile-width [VipsOption.Int] Tile width in pixels
  /// @optionalArg tile-height [VipsOption.Int] Tile height in pixels
  /// @optionalArg pyramid [VipsOption.Boolean] Write a pyramidal tiff
  /// @optionalArg miniswhite [VipsOption.Boolean] Use 0 for white in 1-bit images
  /// @optionalArg bitdepth [VipsOption.Int] Write as a 1, 2, 4 or 8 bit image
  /// @optionalArg resunit [VipsOption.Enum] [VipsForeignTiffResunit] Resolution unit
  /// @optionalArg xres [VipsOption.Double] Horizontal resolution in pixels/mm
  /// @optionalArg yres [VipsOption.Double] Vertical resolution in pixels/mm
  /// @optionalArg bigtiff [VipsOption.Boolean] Write a bigtiff image
  /// @optionalArg properties [VipsOption.Boolean] Write a properties document to IMAGEDESCRIPTION
  /// @optionalArg region-shrink [VipsOption.Enum] [VipsRegionShrink] Method to shrink regions
  /// @optionalArg level [VipsOption.Int] Deflate (1-9, default 6) or ZSTD (1-22, default 9) compression level
  /// @optionalArg lossless [VipsOption.Boolean] Enable WEBP lossless mode
  /// @optionalArg depth [VipsOption.Enum] [VipsForeignDzDepth] Pyramid depth
  /// @optionalArg subifd [VipsOption.Boolean] Save pyr layers as sub-IFDs
  /// @optionalArg premultiply [VipsOption.Boolean] Save with premultiplied alpha
  /// @optionalArg rgbjpeg [VipsOption.Boolean] Output RGB JPEG rather than YCbCr
  /// @optionalArg squash [VipsOption.Boolean] Squash images down to 1 bit
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void tiffsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "tiffsave_target", callArgs);
  }

  /// This operation behaves rather like [VImage#copy] between images
  /// `in` and `out`, except that it keeps a cache of computed pixels.
  /// This cache is made of up to `max_tiles` tiles (a value of -1
  /// means any number of tiles), and each tile is of size `tile_width`
  /// by `tile_height` pixels.
  ///
  /// Each cache tile is made with a single call to
  /// `Region.prepare`.
  ///
  /// When the cache fills, a tile is chosen for reuse. If `access` is
  /// [VipsAccess#ACCESS_RANDOM], then the least-recently-used tile is reused. If
  /// `access` is [VipsAccess#ACCESS_SEQUENTIAL]
  /// the top-most tile is reused.
  ///
  /// By default, `tile_width` and `tile_height` are 128 pixels, and the operation
  /// will cache up to 1,000 tiles. `access` defaults to [VipsAccess#ACCESS_RANDOM].
  ///
  /// Normally, only a single thread at once is allowed to calculate tiles. If
  /// you set `threaded` to `TRUE`, [VImage#tilecache] will allow many
  /// threads to calculate tiles at once, and share the cache between them.
  ///
  /// Normally the cache is dropped when computation finishes. Set `persistent` to
  /// `TRUE` to keep the cache between computations.
  ///
  /// See also: [VImage#linecache]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg tile-width [VipsOption.Int] Tile width in pixels
  /// @optionalArg tile-height [VipsOption.Int] Tile height in pixels
  /// @optionalArg max-tiles [VipsOption.Int] Maximum number of tiles to cache
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Expected access pattern
  /// @optionalArg threaded [VipsOption.Boolean] Allow threaded access
  /// @optionalArg persistent [VipsOption.Boolean] Keep cache between evaluations
  public VImage tilecache(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "tilecache", callArgs);
    return outOption.valueOrThrow();
  }

  /// [VImage#tonelut] generates a tone curve for the adjustment of image
  /// levels.
  ///
  /// This is mostly designed for adjusting the L* part of a LAB image in
  /// a way suitable for print work, but you can use it for other things too.
  ///
  /// The curve is an unsigned 16-bit image with (@in_max + 1) entries,
  /// each in the range [0, `out_max`].
  ///
  /// `Lb`, `Lw` are expressed as 0-100, as in LAB colour space. You
  /// specify the scaling for the input and output images with the `in_max` and
  /// `out_max` parameters.
  ///
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg in-max [VipsOption.Int] Size of LUT to build
  /// @optionalArg out-max [VipsOption.Int] Maximum value in output LUT
  /// @optionalArg Lb [VipsOption.Double] Lowest value in output
  /// @optionalArg Lw [VipsOption.Double] Highest value in output
  /// @optionalArg Ps [VipsOption.Double] Position of shadow
  /// @optionalArg Pm [VipsOption.Double] Position of mid-tones
  /// @optionalArg Ph [VipsOption.Double] Position of highlights
  /// @optionalArg S [VipsOption.Double] Adjust shadows by this much
  /// @optionalArg M [VipsOption.Double] Adjust mid-tones by this much
  /// @optionalArg H [VipsOption.Double] Adjust highlights by this much
  public static VImage tonelut(Arena arena, VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "tonelut", callArgs);
    return outOption.valueOrThrow();
  }

  /// Transpose a volumetric image.
  ///
  /// Volumetric images are very tall, thin images, with the metadata item
  /// `META_PAGE_HEIGHT` set to the height of each sub-image.
  ///
  /// This operation swaps the two major dimensions, so that page N in the
  /// output contains the Nth scanline, in order, from each input page.
  ///
  /// You can override the `META_PAGE_HEIGHT` metadata item with the optional
  /// `page_height` parameter.
  ///
  /// `META_PAGE_HEIGHT` in the output image is the number of pages in the
  /// input image.
  ///
  /// See also: [VImage#grid]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page-height [VipsOption.Int] Height of each input page
  public VImage transpose3d(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "transpose3d", callArgs);
    return outOption.valueOrThrow();
  }

  /// Unpremultiplies any alpha channel.
  ///
  /// Band `alpha_band` (by default the final band) contains the alpha and all
  /// other bands are transformed as:
  ///
  /// ```
  /// alpha = (int) clip(0, in[in.bands - 1], max_alpha);
  /// norm = (double) alpha / max_alpha
  /// if (alpha == 0)
  ///     out = [0, ..., 0, alpha]
  /// else
  ///     out = [in[0] / norm, ..., in[in.bands - 1] / norm, alpha]
  /// ```
  ///
  /// So for an N-band image, the first N - 1 bands are divided by the clipped
  /// and normalised final band, the final band is clipped.
  /// If there is only a single band, the image is passed through unaltered.
  ///
  /// The result is [VipsBandFormat#FORMAT_FLOAT] unless the input format is
  /// [VipsBandFormat#FORMAT_DOUBLE], in which case the output is double as well.
  ///
  /// `max_alpha` has the default value 255, or 65535 for images tagged as
  /// [VipsInterpretation#INTERPRETATION_RGB16] or [VipsInterpretation#INTERPRETATION_GREY16], and
  /// 1.0 for images tagged as  [enum@Vips.Interpretation.scRGB.
  ///
  /// Non-complex images only.
  ///
  /// See also: [VImage#premultiply], [VImage#flatten]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg max-alpha [VipsOption.Double] Maximum value of alpha channel
  /// @optionalArg alpha-band [VipsOption.Int] Unpremultiply with this alpha
  public VImage unpremultiply(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "unpremultiply", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read in a vips image.
  ///
  /// See also: [VImage#vipssave]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage vipsload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "vipsload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#vipsload], but read from a source.
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage vipsloadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "vipsload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Write `in` to `filename` in VIPS format.
  ///
  /// See also: [VImage#vipsload]
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void vipssave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "vipssave", callArgs);
  }

  /// As [VImage#vipssave], but save to a target.
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void vipssaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "vipssave_target", callArgs);
  }

  /// Read a WebP file into a VIPS image.
  ///
  /// Use `page` to select a page to render, numbering from zero.
  ///
  /// Use `n` to select the number of pages to render. The default is 1. Pages are
  /// rendered in a vertical column, with each individual page aligned to the
  /// left. Set to -1 to mean "until the end of the document". Use [VImage#grid]
  /// to change page layout.
  ///
  /// Use `scale` to specify a scale-on-load factor. For example, 2.0 to double
  /// the size on load. Animated webp images don't support shrink-on-load, so a
  /// further resize may be necessary.
  ///
  /// The loader supports ICC, EXIF and XMP metadata.
  ///
  /// See also: `Image.new_from_file`
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param filename Filename to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg scale [VipsOption.Double] Factor to scale by
  /// @optionalArg shrink [VipsOption.Int] Shrink factor on load
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage webpload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "webpload", callArgs);
    return outOption.valueOrThrow();
  }

  /// Read a WebP-formatted memory block into a VIPS image. Exactly as
  /// [VImage#webpload], but read from a memory buffer.
  ///
  /// You must not free the buffer while `out` is active. The
  /// `Object::postclose` signal on `out` is a good place to free.
  ///
  /// See also: [VImage#webpload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param buffer Buffer to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg scale [VipsOption.Double] Factor to scale by
  /// @optionalArg shrink [VipsOption.Int] Shrink factor on load
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage webploadBuffer(Arena arena, VBlob buffer, VipsOption... args) throws
      VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "webpload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /// Exactly as [VImage#webpload], but read from a source.
  ///
  /// See also: [VImage#webpload]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param source Source to load from
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg page [VipsOption.Int] First page to load
  /// @optionalArg n [VipsOption.Int] Number of pages to load, -1 for all
  /// @optionalArg scale [VipsOption.Double] Factor to scale by
  /// @optionalArg shrink [VipsOption.Int] Shrink factor on load
  /// @optionalArg flags [VipsOption.Int] Flags for this file
  /// @optionalArg memory [VipsOption.Boolean] Force open via memory
  /// @optionalArg access [VipsOption.Enum] [VipsAccess] Required access pattern for this file
  /// @optionalArg fail-on [VipsOption.Enum] [VipsFailOn] Error level to fail on
  /// @optionalArg revalidate [VipsOption.Boolean] Don't use a cached result for this operation
  /// @optionalArg sequential [VipsOption.Boolean] Sequential read only
  /// @optionalArg fail [VipsOption.Boolean] Fail on first warning
  /// @optionalArg disc [VipsOption.Boolean] Open to disc
  public static VImage webploadSource(Arena arena, VSource source, VipsOption... args) throws
      VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "webpload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /// Write an image to a file in WebP format.
  ///
  /// By default, images are saved in lossy format, with
  /// `Q` giving the WebP quality factor. It has the range 0 - 100, with the
  /// default 75.
  ///
  /// Use `preset` to hint the image type to the lossy compressor. The default is
  /// [VipsForeignWebpPreset#FOREIGN_WEBP_PRESET_DEFAULT].
  ///
  /// Set `smart_subsample` to enable high quality chroma subsampling.
  ///
  /// Set `smart_deblock` to enable auto-adjusting of the deblocking filter. This
  /// can improve image quality, especially on low-contrast edges, but encoding
  /// can take significantly longer.
  ///
  /// Use `alpha_q` to set the quality for the alpha channel in lossy mode. It has
  /// the range 1 - 100, with the default 100.
  ///
  /// Use `effort` to control how much CPU time to spend attempting to
  /// reduce file size. A higher value means more effort and therefore CPU time
  /// should be spent. It has the range 0-6 and a default value of 4.
  ///
  /// Use `target_size` to set the desired target size in bytes.
  ///
  /// Use `passes` to set the number of entropy-analysis passes, by default 1,
  /// unless `target_size` is set, in which case the default is 3. It is not
  /// recommended to set `passes` unless you set `target_size`. Doing so will
  /// result in longer encoding times for no benefit.
  ///
  /// Set `lossless` to use lossless compression, or combine `near_lossless`
  /// with `Q` 80, 60, 40 or 20 to apply increasing amounts of preprocessing
  /// which improves the near-lossless compression ratio by up to 50%.
  ///
  /// For animated webp output, `min_size` will try to optimize for minimum size.
  ///
  /// For animated webp output, `kmax` sets the maximum number of frames between
  /// keyframes. Setting 0 means only keyframes. `kmin` sets the minimum number of
  /// frames between frames. Setting 0 means no keyframes. By default, keyframes
  /// are disabled.
  ///
  /// For animated webp output, `mixed` tries to improve the file size by mixing
  /// both lossy and lossless encoding.
  ///
  /// Use the metadata items `loop` and `delay` to set the number of
  /// loops for the animation and the frame delays.
  ///
  /// See also: [VImage#webpload], `Image.write_to_file`
  /// @param filename Filename to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg lossless [VipsOption.Boolean] Enable lossless compression
  /// @optionalArg preset [VipsOption.Enum] [VipsForeignWebpPreset] Preset for lossy compression
  /// @optionalArg smart-subsample [VipsOption.Boolean] Enable high quality chroma subsampling
  /// @optionalArg near-lossless [VipsOption.Boolean] Enable preprocessing in lossless mode (uses Q)
  /// @optionalArg alpha-q [VipsOption.Int] Change alpha plane fidelity for lossy compression
  /// @optionalArg min-size [VipsOption.Boolean] Optimise for minimum size
  /// @optionalArg kmin [VipsOption.Int] Minimum number of frames between key frames
  /// @optionalArg kmax [VipsOption.Int] Maximum number of frames between key frames
  /// @optionalArg effort [VipsOption.Int] Level of CPU effort to reduce file size
  /// @optionalArg target-size [VipsOption.Int] Desired target size in bytes
  /// @optionalArg reduction-effort [VipsOption.Int] Level of CPU effort to reduce file size
  /// @optionalArg mixed [VipsOption.Boolean] Allow mixed encoding (might reduce file size)
  /// @optionalArg smart-deblock [VipsOption.Boolean] Enable auto-adjusting of the deblocking filter
  /// @optionalArg passes [VipsOption.Int] Number of entropy-analysis passes (in [1..10])
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void webpsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "webpsave", callArgs);
  }

  /// As [VImage#webpsave], but save to a memory buffer.
  ///
  /// The address of the buffer is returned in `buf`, the length of the buffer in
  /// `len`. You are responsible for freeing the buffer with `GLib.free` when you
  /// are done with it.
  ///
  /// See also: [VImage#webpsave]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg lossless [VipsOption.Boolean] Enable lossless compression
  /// @optionalArg preset [VipsOption.Enum] [VipsForeignWebpPreset] Preset for lossy compression
  /// @optionalArg smart-subsample [VipsOption.Boolean] Enable high quality chroma subsampling
  /// @optionalArg near-lossless [VipsOption.Boolean] Enable preprocessing in lossless mode (uses Q)
  /// @optionalArg alpha-q [VipsOption.Int] Change alpha plane fidelity for lossy compression
  /// @optionalArg min-size [VipsOption.Boolean] Optimise for minimum size
  /// @optionalArg kmin [VipsOption.Int] Minimum number of frames between key frames
  /// @optionalArg kmax [VipsOption.Int] Maximum number of frames between key frames
  /// @optionalArg effort [VipsOption.Int] Level of CPU effort to reduce file size
  /// @optionalArg target-size [VipsOption.Int] Desired target size in bytes
  /// @optionalArg reduction-effort [VipsOption.Int] Level of CPU effort to reduce file size
  /// @optionalArg mixed [VipsOption.Boolean] Allow mixed encoding (might reduce file size)
  /// @optionalArg smart-deblock [VipsOption.Boolean] Enable auto-adjusting of the deblocking filter
  /// @optionalArg passes [VipsOption.Int] Number of entropy-analysis passes (in [1..10])
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public VBlob webpsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "webpsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /// As [VImage#webpsave], but save as a mime webp on stdout.
  ///
  /// See also: [VImage#webpsave], `Image.write_to_file`
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg lossless [VipsOption.Boolean] Enable lossless compression
  /// @optionalArg preset [VipsOption.Enum] [VipsForeignWebpPreset] Preset for lossy compression
  /// @optionalArg smart-subsample [VipsOption.Boolean] Enable high quality chroma subsampling
  /// @optionalArg near-lossless [VipsOption.Boolean] Enable preprocessing in lossless mode (uses Q)
  /// @optionalArg alpha-q [VipsOption.Int] Change alpha plane fidelity for lossy compression
  /// @optionalArg min-size [VipsOption.Boolean] Optimise for minimum size
  /// @optionalArg kmin [VipsOption.Int] Minimum number of frames between key frames
  /// @optionalArg kmax [VipsOption.Int] Maximum number of frames between key frames
  /// @optionalArg effort [VipsOption.Int] Level of CPU effort to reduce file size
  /// @optionalArg target-size [VipsOption.Int] Desired target size in bytes
  /// @optionalArg reduction-effort [VipsOption.Int] Level of CPU effort to reduce file size
  /// @optionalArg mixed [VipsOption.Boolean] Allow mixed encoding (might reduce file size)
  /// @optionalArg smart-deblock [VipsOption.Boolean] Enable auto-adjusting of the deblocking filter
  /// @optionalArg passes [VipsOption.Int] Number of entropy-analysis passes (in [1..10])
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void webpsaveMime(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    VipsInvoker.invokeOperation(arena, "webpsave_mime", callArgs);
  }

  /// As [VImage#webpsave], but save to a target.
  ///
  /// See also: [VImage#webpsave]
  /// @param target Target to save to
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg Q [VipsOption.Int] Q factor
  /// @optionalArg lossless [VipsOption.Boolean] Enable lossless compression
  /// @optionalArg preset [VipsOption.Enum] [VipsForeignWebpPreset] Preset for lossy compression
  /// @optionalArg smart-subsample [VipsOption.Boolean] Enable high quality chroma subsampling
  /// @optionalArg near-lossless [VipsOption.Boolean] Enable preprocessing in lossless mode (uses Q)
  /// @optionalArg alpha-q [VipsOption.Int] Change alpha plane fidelity for lossy compression
  /// @optionalArg min-size [VipsOption.Boolean] Optimise for minimum size
  /// @optionalArg kmin [VipsOption.Int] Minimum number of frames between key frames
  /// @optionalArg kmax [VipsOption.Int] Maximum number of frames between key frames
  /// @optionalArg effort [VipsOption.Int] Level of CPU effort to reduce file size
  /// @optionalArg target-size [VipsOption.Int] Desired target size in bytes
  /// @optionalArg reduction-effort [VipsOption.Int] Level of CPU effort to reduce file size
  /// @optionalArg mixed [VipsOption.Boolean] Allow mixed encoding (might reduce file size)
  /// @optionalArg smart-deblock [VipsOption.Boolean] Enable auto-adjusting of the deblocking filter
  /// @optionalArg passes [VipsOption.Int] Number of entropy-analysis passes (in [1..10])
  /// @optionalArg keep [VipsOption.Int] Which metadata to retain
  /// @optionalArg background [VipsOption.ArrayDouble] Background value
  /// @optionalArg page-height [VipsOption.Int] Set page height for multipage save
  /// @optionalArg profile [VipsOption.String] Filename of ICC profile to embed
  /// @optionalArg strip [VipsOption.Boolean] Strip all metadata from image
  public void webpsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "webpsave_target", callArgs);
  }

  /// Create a one-band float image of [Worley
  /// noise](https://en.wikipedia.org/wiki/Worley_noise).
  ///
  /// Use `cell_size` to set the size of the cells from which the image is
  /// constructed. The default is 256 x 256.
  ///
  /// If `width` and `height` are multiples of `cell_size`, the image will tessellate.
  ///
  /// See also: [VImage#perlin], [VImage#fractsurf], [VImage#gaussnoise]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg cell-size [VipsOption.Int] Size of Worley cells
  /// @optionalArg seed [VipsOption.Int] Random number seed
  public static VImage worley(Arena arena, int width, int height, VipsOption... args) throws
      VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "worley", callArgs);
    return outOption.valueOrThrow();
  }

  /// Slice an image up and move the segments about so that the pixel that was
  /// at 0, 0 is now at `x`, `y`.
  ///
  /// If `x` and `y` are not set, they default to the centre of the image.
  ///
  /// See also: [VImage#embed], [VImage#replicate]
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg x [VipsOption.Int] Left edge of input in output
  /// @optionalArg y [VipsOption.Int] Top edge of input in output
  public VImage wrap(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "wrap", callArgs);
    return outOption.valueOrThrow();
  }

  /// Create a two-band uint32 image where the elements in the first band have the
  /// value of their x coordinate and elements in the second band have their y
  /// coordinate.
  ///
  /// You can make any image where the value of a pixel is a function of its (x,
  /// y) coordinate by combining this operator with the arithmetic operators.
  ///
  /// Set `csize`, `dsize`, `esize` to generate higher dimensions and add more
  /// bands. The extra dimensions are placed down the vertical axis. Use
  /// [VImage#grid] to change the layout.
  ///
  /// See also: [VImage#grey], [VImage#grid], [VImage#identity]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg csize [VipsOption.Int] Size of third dimension
  /// @optionalArg dsize [VipsOption.Int] Size of fourth dimension
  /// @optionalArg esize [VipsOption.Int] Size of fifth dimension
  public static VImage xyz(Arena arena, int width, int height, VipsOption... args) throws
      VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "xyz", callArgs);
    return outOption.valueOrThrow();
  }

  /// Create a one-band image of a zone plate.
  ///
  /// Pixels are normally in [-1, +1], set `uchar` to output [0, 255].
  ///
  /// See also: [VImage#eye], [VImage#xyz]
  /// @param arena The arena that bounds resulting memory allocations during this operation
  /// @param width Image width in pixels
  /// @param height Image height in pixels
  /// @param args Array of VipsOption to apply to this operation
  /// @optionalArg uchar [VipsOption.Boolean] Output an unsigned char image
  public static VImage zone(Arena arena, int width, int height, VipsOption... args) throws
      VipsError {
    var outOption = VipsOption.Image("out");
    var widthOption = VipsOption.Int("width", width);
    var heightOption = VipsOption.Int("height", height);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(widthOption);
    callArgs.add(heightOption);
    VipsInvoker.invokeOperation(arena, "zone", callArgs);
    return outOption.valueOrThrow();
  }

  /// Zoom an image by repeating pixels. This is fast nearest-neighbour
  /// zoom.
  ///
  /// See also: [VImage#affine], [VImage#subsample]
  /// @param xfac Horizontal zoom factor
  /// @param yfac Vertical zoom factor
  /// @param args Array of VipsOption to apply to this operation
  public VImage zoom(int xfac, int yfac, VipsOption... args) throws VipsError {
    var inputOption = VipsOption.Image("input", this);
    var outOption = VipsOption.Image("out");
    var xfacOption = VipsOption.Int("xfac", xfac);
    var yfacOption = VipsOption.Int("yfac", yfac);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inputOption);
    callArgs.add(outOption);
    callArgs.add(xfacOption);
    callArgs.add(yfacOption);
    VipsInvoker.invokeOperation(arena, "zoom", callArgs);
    return outOption.valueOrThrow();
  }

  public int getWidth() throws VipsError {
    return VipsHelper.image_get_width(this.address);
  }

  public int getHeight() throws VipsError {
    return VipsHelper.image_get_height(this.address);
  }

  public boolean hasAlpha() throws VipsError {
    return VipsHelper.image_hasalpha(this.address);
  }

  public static VImage newFromFile(Arena arena, String path, VipsOption... options) throws
      VipsError {
    var filename = VipsHelper.filename_get_filename(arena, path);
    var filenameOptions = VipsHelper.filename_get_options(arena, filename);
    var loader = VipsHelper.foreign_find_load(arena, filename);
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(options));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, loader, filenameOptions, callArgs);
    return outOption.valueOrThrow();
  }

  public static VImage newFromSource(Arena arena, VSource source, String optionString,
      VipsOption... options) throws VipsError {
    var loader = VipsHelper.foreign_find_load_source(source.address);
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(options));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, loader, optionString, callArgs);
    return outOption.valueOrThrow();
  }

  public static VImage newFromSource(Arena arena, VSource source, VipsOption... options) throws
      VipsError {
    return newFromSource(arena, source, "", options);
  }

  /// Creates a new VImage from raw bytes. Note that this is quite inefficient, use [VImage#newFromFile] and friends instead.
  public static VImage newFromBytes(Arena arena, byte[] bytes, String optionString,
      VipsOption... options) throws VipsError {
    var source = VSource.newFromBytes(arena, bytes);
    return newFromSource(arena, source, optionString, options);
  }

  /// See [VImage#newFromBytes]
  public static VImage newFromBytes(Arena arena, byte[] bytes, VipsOption... options) throws
      VipsError {
    var source = VSource.newFromBytes(arena, bytes);
    return newFromSource(arena, source, options);
  }

  /// Creates a new VImage from raw bytes, mapping directly to the `vips_image_new_from_memory` function, with some checks.
  ///
  /// This is included for narrow use cases where you have image bytes representing partially supported image formats from another library (like DICOM), and you need a way to get them in to libvips without using the built-in source loaders.
  /// Note that this uses the Java FFM [MemorySegment] API to avoid an unnecessary copy. 
  ///
  /// This is an advanced method - if possible, use [VImage#newFromFile] and friends instead. If you have bytes to load, you could use [VImage#newFromBytes].
  public static VImage newFromMemory(Arena arena, MemorySegment memorySegment, int width,
      int height, int bands, int format) throws VipsError {
    var imagePointer = VipsHelper.image_new_from_memory(arena, memorySegment, memorySegment.byteSize(), width, height, bands, format);
    return new VImage(arena, imagePointer);
  }

  /// Creates a new VImage from an [InputStream]. This uses libvips' "custom streaming" feature and is
  /// therefore quite efficient, avoiding the need to make extra full copies of the image's data.
  /// You could, for example, use this function to create an image directly from an API call, thumbnail it,
  /// and then upload directly to an S3-compatible API efficiently in memory - all without creating a local
  /// file.
  public static VImage newFromStream(Arena arena, InputStream stream, String optionString,
      VipsOption... options) throws VipsError {
    var source = VSource.newFromInputStream(arena, stream);
    return newFromSource(arena, source, optionString, options);
  }

  /// See [VImage#newFromStream]
  public static VImage newFromStream(Arena arena, InputStream stream, VipsOption... options) throws
      VipsError {
    var source = VSource.newFromInputStream(arena, stream);
    return newFromSource(arena, source, options);
  }

  public void writeToFile(String path, VipsOption... options) throws VipsError {
    var filename = VipsHelper.filename_get_filename(arena, path);
    var filenameOptions = VipsHelper.filename_get_options(arena, filename);
    var loader = VipsHelper.foreign_find_save(arena, filename);
    var filenameOption = VipsOption.String("filename", filename);
    var inOption = VipsOption.Image("in", this);
    var callArgs = new ArrayList<>(Arrays.asList(options));
    callArgs.add(filenameOption);
    callArgs.add(inOption);
    VipsInvoker.invokeOperation(arena, loader, filenameOptions, callArgs);
  }

  public VImage write(VImage out) throws VipsError {
    VipsHelper.image_write(this.address, out.address);
    return out;
  }

  public void writeToTarget(VTarget target, String suffix, VipsOption... options) throws VipsError {
    var loader = VipsHelper.foreign_find_save_target(arena, suffix);
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(options));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, loader, callArgs);
  }

  /// Writes this VImage to an [OutputStream]. This uses libvips' "custom streaming" feature and is
  /// therefore quite efficient, avoiding the need to make extra full copies of the image's data.
  /// You could, for example, use this function to create an image directly from an API call, thumbnail it,
  /// and then upload directly to an S3-compatible API efficiently in memory - all without creating a local
  /// file.
  public void writeToStream(OutputStream stream, String suffix, VipsOption... options) throws
      VipsError {
    var target = VTarget.newFromOutputStream(arena, stream);
    this.writeToTarget(target, suffix, options);
  }

  /// Writes this VImage's raw pixel values to a [MemorySegment], in the following pixel order: RGBRGBRGB etc.
  /// It performs a full memory copy of the image, and so provides an image copying option that is thread-safe
  /// and independent of other VImage operations.
  ///
  /// In performance-critical scenarios where you need to avoid memory copies, and you are sure about the image's
  /// state and lifetime, prefer [VipsHelper#image_get_data] instead.
  public MemorySegment writeToMemory() throws VipsError {
    var outLengthPointer = arena.allocate(VipsRaw.C_LONG);
    var imageMemory = VipsHelper.image_write_to_memory(this.address, outLengthPointer);
    var sizeOfImage = outLengthPointer.get(VipsRaw.C_LONG, 0);
    if (sizeOfImage < 0) {
      throw new VipsError("unexpected image size after write");
    }
    return imageMemory.reinterpret(arena, VipsRaw::g_free).asSlice(0, sizeOfImage);
  }

  public static VImage newImage(Arena arena) throws VipsError {
    var newImagePointer = VipsHelper.image_new(arena);
    return new VImage(arena, newImagePointer);
  }

  /// Helper function to get the metadata stored at `name` on this image, of type `string`, or `null`
  /// if not present
  ///
  /// See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
  public String getString(String name) {
    var type = VipsHelper.image_get_typeof(arena, this.address, name);
    if (type == 0) {
      return null;
    }
    var outPointer = arena.allocate(VipsRaw.C_POINTER);
    var result = VipsHelper.image_get_string(arena, this.address, name, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("image_get_string");
    }
    if (!VipsValidation.isValidPointer(outPointer)) {
      throw new VipsError("failed to read value of type string from field: " + name);
    }
    var dereferenced = outPointer.get(VipsRaw.C_POINTER, 0);
    return dereferenced.getString(0);
  }

  /// Helper function to set the metadata stored at `name` on this image, of type `string`
  ///
  /// See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
  public VImage set(String name, String value) {
    VipsHelper.image_set_string(arena, this.address, name, value);
    return this;
  }

  /// Helper function to get the metadata stored at `name` on this image, of type `int`, or `null`
  /// if not present
  ///
  /// See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
  public Integer getInt(String name) {
    var type = VipsHelper.image_get_typeof(arena, this.address, name);
    if (type == 0) {
      return null;
    }
    var outPointer = arena.allocate(VipsRaw.C_POINTER);
    var result = VipsHelper.image_get_int(arena, this.address, name, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("image_get_int");
    }
    if (!VipsValidation.isValidPointer(outPointer)) {
      throw new VipsError("failed to read value of type int from field: " + name);
    }
    return outPointer.get(VipsRaw.C_INT, 0);
  }

  /// Helper function to set the metadata stored at `name` on this image, of type `int`
  ///
  /// See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
  public VImage set(String name, Integer value) {
    VipsHelper.image_set_int(arena, this.address, name, value);
    return this;
  }

  /// Helper function to get the metadata stored at `name` on this image, of type `double`, or `null`
  /// if not present
  ///
  /// See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
  public Double getDouble(String name) {
    var type = VipsHelper.image_get_typeof(arena, this.address, name);
    if (type == 0) {
      return null;
    }
    var outPointer = arena.allocate(VipsRaw.C_POINTER);
    var result = VipsHelper.image_get_double(arena, this.address, name, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("image_get_double");
    }
    if (!VipsValidation.isValidPointer(outPointer)) {
      throw new VipsError("failed to read value of type double from field: " + name);
    }
    return outPointer.get(VipsRaw.C_DOUBLE, 0);
  }

  /// Helper function to set the metadata stored at `name` on this image, of type `double`
  ///
  /// See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
  public VImage set(String name, Double value) {
    VipsHelper.image_set_double(arena, this.address, name, value);
    return this;
  }

  /// Helper function to get the metadata stored at `name` on this image, of type `blob`, or `null`
  /// if not present
  ///
  /// See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
  public VBlob getBlob(String name) {
    var type = VipsHelper.image_get_typeof(arena, this.address, name);
    if (type == 0) {
      return null;
    }
    var outPointer = arena.allocate(VipsRaw.C_POINTER);
    var outLengthPointer = arena.allocate(VipsRaw.C_LONG);
    var result = VipsHelper.image_get_blob(arena, this.address, name, outPointer, outLengthPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("image_get_blob");
    }
    if (!VipsValidation.isValidPointer(outPointer)) {
      throw new VipsError("failed to read value of type blob from field: " + name);
    }
    var blobAddress = outPointer.get(VipsRaw.C_POINTER, 0);
    return new VBlob(arena, blobAddress);
  }

  /// Helper function to set the metadata stored at `name` on this image, of type `blob`
  ///
  /// See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
  public VImage set(String name, VBlob value) {
    VipsHelper.image_set_blob(arena, this.address, name, MemorySegment.NULL, value.address, value.byteSize());
    return this;
  }

  /// Helper function to get the metadata stored at `name` on this image, of type `image`, or `null`
  /// if not present
  ///
  /// See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
  public VImage getImage(String name) {
    var type = VipsHelper.image_get_typeof(arena, this.address, name);
    if (type == 0) {
      return null;
    }
    var outPointer = arena.allocate(VipsRaw.C_POINTER);
    var result = VipsHelper.image_get_image(arena, this.address, name, outPointer);
    if (!VipsValidation.isValidResult(result)) {
      VipsValidation.throwVipsError("image_get_image");
    }
    if (!VipsValidation.isValidPointer(outPointer)) {
      throw new VipsError("failed to read value of type image from field: " + name);
    }
    var imageAddress = outPointer.get(VipsRaw.C_POINTER, 0).reinterpret(arena, VipsRaw::g_object_unref);
    return new VImage(arena, imageAddress);
  }

  /// Helper function to set the metadata stored at `name` on this image, of type `image`
  ///
  /// See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
  public VImage set(String name, VImage value) {
    VipsHelper.image_set_image(arena, this.address, name, value.address);
    return this;
  }

  /// Returns a list of all metadata entry names for this image
  ///
  /// See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
  public List<String> getFields() {
    var fieldNameStrings = new ArrayList<String>();
    VipsImageMapFn.Function fn = (_, name, _, _) -> {
          if (!VipsValidation.isValidPointer(name)) {
            return MemorySegment.NULL;
          }
          fieldNameStrings.add(name.getString(0));
          return MemorySegment.NULL;
        };
    var callbackPointer = VipsImageMapFn.allocate(fn, arena);
    VipsRaw.vips_image_map(this.address, callbackPointer, MemorySegment.NULL);
    return fieldNameStrings;
  }

  /// Helper function to remove the metadata stored at `name` on this image
  ///
  /// Returns false if there was no metadata entry at `name`
  ///
  /// See also: [libvips header docs](https://www.libvips.org/API/current/libvips-header.html)
  public boolean remove(String name) {
    return VipsHelper.image_remove(arena, this.address, name);
  }

  /// Helper record to hold multiple outputs from the [VImage#findTrim] operation
  public record FindTrimOutput(int left, int top, int width, int height) {
  }

  /// Helper record to hold multiple outputs from the [VImage#profile] operation
  public record ProfileOutput(VImage columns, VImage rows) {
  }

  /// Helper record to hold multiple outputs from the [VImage#project] operation
  public record ProjectOutput(VImage columns, VImage rows) {
  }
}
