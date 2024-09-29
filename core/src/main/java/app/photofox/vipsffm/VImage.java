package app.photofox.vipsffm;

import app.photofox.vipsffm.enums.VipsAngle;
import app.photofox.vipsffm.enums.VipsBandFormat;
import app.photofox.vipsffm.enums.VipsBlendMode;
import app.photofox.vipsffm.enums.VipsCompassDirection;
import app.photofox.vipsffm.enums.VipsDirection;
import app.photofox.vipsffm.enums.VipsInterpretation;
import app.photofox.vipsffm.enums.VipsOperationBoolean;
import app.photofox.vipsffm.enums.VipsOperationComplex;
import app.photofox.vipsffm.enums.VipsOperationComplex2;
import app.photofox.vipsffm.enums.VipsOperationComplexget;
import app.photofox.vipsffm.enums.VipsOperationMath;
import app.photofox.vipsffm.enums.VipsOperationMath2;
import app.photofox.vipsffm.enums.VipsOperationMorphology;
import app.photofox.vipsffm.enums.VipsOperationRelational;
import app.photofox.vipsffm.enums.VipsOperationRound;
import java.lang.Deprecated;
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

/**
 * A generated wrapper representing a VipsImage. Do not edit.
 * @see <a href="https://www.libvips.org/API/current/api-index-full.html">libvips api docs</a>
 */
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

  /**
   * @deprecated See {@link #getUnsafeStructAddress}
   */
  @Deprecated(
      since = "0.5.10",
      forRemoval = true
  )
  public MemorySegment getUnsafeAddress() {
    return this.getUnsafeStructAddress();
  }

  /**
   * Gets the raw {@link MemorySegment} (C pointer) for this VipsImage struct
   * The memory address' lifetime is bound to the scope of the {@link #arena}
   * Usage of the memory address is strongly discouraged, but it is available if some functionality is missing and you need to use it with {@link VipsHelper}
   */
  public MemorySegment getUnsafeStructAddress() {
    return this.address;
  }

  /**
   * <p>Turn LCh to CMC.</p>
   *
   * <p>See also: {@link #LCh2CMC}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage CMC2LCh(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "CMC2LCh", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Turn CMYK to XYZ. If the image has an embedded ICC profile this will be
   * used for the conversion. If there is no embedded profile, a generic
   * fallback profile will be used.</p>
   *
   * <p>Conversion is to D65 XYZ with relative intent. If you need more control
   * over the process, use <code>vips_icc_import</code> instead.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage CMYK2XYZ(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "CMYK2XYZ", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Convert HSV to sRGB.</p>
   *
   * <p>HSV is a crude polar coordinate system for RGB images. It is provided for
   * compatibility with other image processing systems. See {@link #Lab2LCh} for a
   * much better colour space.</p>
   *
   * <p>See also: {@link #sRGB2HSV}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage HSV2sRGB(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "HSV2sRGB", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Turn LCh to CMC.</p>
   *
   * <p>The CMC colourspace is described in "Uniform Colour Space Based on the
   * CMC(l:c) Colour-difference Formula", M R Luo and B Rigg, Journal of the
   * Society of Dyers and Colourists, vol 102, 1986. Distances in this
   * colourspace approximate, within 10% or so, differences in the CMC(l:c)
   * colour difference formula.</p>
   *
   * <p>This operation generates CMC(1:1). For CMC(2:1), halve Lucs and double
   * Cucs.</p>
   *
   * <p>See also: {@link #CMC2LCh}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage LCh2CMC(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LCh2CMC", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Turn LCh to Lab.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage LCh2Lab(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LCh2Lab", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Turn Lab to LCh.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage Lab2LCh(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "Lab2LCh", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Convert a Lab three-band float image to LabQ ({@link app.photofox.vipsffm.enums.VipsCoding#CODING_LABQ}).</p>
   *
   * <p>See also: {@link #LabQ2Lab}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage Lab2LabQ(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "Lab2LabQ", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Turn Lab to LabS, signed 16-bit int fixed point.</p>
   *
   * <p>See also: {@link #LabQ2Lab}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage Lab2LabS(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "Lab2LabS", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Turn Lab to XYZ. The colour temperature defaults to D65, but can be
   * specified with {@optionalArg temp}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg temp {@link VipsOption.ArrayDouble} Color temperature
   */
  public VImage Lab2XYZ(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "Lab2XYZ", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Unpack a LabQ ({@link app.photofox.vipsffm.enums.VipsCoding#CODING_LABQ}) image to a three-band float image.</p>
   *
   * <p>See also: LabQ2Lab, {@link #LabQ2LabS}, {@link #rad2float}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage LabQ2Lab(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LabQ2Lab", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Unpack a LabQ ({@link app.photofox.vipsffm.enums.VipsCoding#CODING_LABQ}) image to a three-band short image.</p>
   *
   * <p>See also: {@link #LabS2LabQ}, LabQ2LabS, {@link #rad2float}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage LabQ2LabS(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LabQ2LabS", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Unpack a LabQ ({@link app.photofox.vipsffm.enums.VipsCoding#CODING_LABQ}) image to a three-band short image.</p>
   *
   * <p>See also: {@link #LabS2LabQ}, LabQ2sRGB, {@link #rad2float}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage LabQ2sRGB(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LabQ2sRGB", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Convert a LabS three-band signed short image to a three-band float image.</p>
   *
   * <p>See also: LabS2Lab.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage LabS2Lab(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LabS2Lab", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Convert a LabS three-band signed short image to LabQ</p>
   *
   * <p>See also: {@link #LabQ2LabS}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage LabS2LabQ(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "LabS2LabQ", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Turn XYZ to CMYK.</p>
   *
   * <p>Conversion is from D65 XYZ with relative intent. If you need more control
   * over the process, use <code>vips_icc_export</code> instead.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage XYZ2CMYK(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "XYZ2CMYK", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Turn XYZ to Lab, optionally specifying the colour temperature. {@optionalArg temp}
   * defaults to D65.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg temp {@link VipsOption.ArrayDouble} Colour temperature
   */
  public VImage XYZ2Lab(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "XYZ2Lab", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Turn XYZ to Yxy.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage XYZ2Yxy(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "XYZ2Yxy", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Turn XYZ to scRGB.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage XYZ2scRGB(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "XYZ2scRGB", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Turn XYZ to Yxy.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage Yxy2XYZ(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "Yxy2XYZ", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation finds the absolute value of an image. It does a copy for
   * unsigned integer types, negate for negative values in
   * signed integer types, <code>fabs(3)</code> for
   * float types, and calculates modulus for complex
   * types.</p>
   *
   * <p>See also: {@link #sign}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage abs(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "abs", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation calculates <code>@in1</code> + <code>@in2</code> and writes the result to {@param out}.</p>
   *
   * <p>If the images differ in size, the smaller image is enlarged to match the
   * larger by adding zero pixels along the bottom and right.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common format (see table
   * Smallest common format in
   * <code>arithmetic</code>), then the
   * following table is used to determine the output type:</p>
   *
   * <pre>{@code
   * <table>
   *   <title>VipsAdd type promotion</title>
   *   <tgroup cols='2' align='left' colsep='1' rowsep='1'>
   *     <thead>
   *       <row>
   *         <entry>input type</entry>
   *         <entry>output type</entry>
   *       </row>
   *     </thead>
   *     <tbody>
   *       <row>
   *         <entry>uchar</entry>
   *         <entry>ushort</entry>
   *       </row>
   *       <row>
   *         <entry>char</entry>
   *         <entry>short</entry>
   *       </row>
   *       <row>
   *         <entry>ushort</entry>
   *         <entry>uint</entry>
   *       </row>
   *       <row>
   *         <entry>short</entry>
   *         <entry>int</entry>
   *       </row>
   *       <row>
   *         <entry>uint</entry>
   *         <entry>uint</entry>
   *       </row>
   *       <row>
   *         <entry>int</entry>
   *         <entry>int</entry>
   *       </row>
   *       <row>
   *         <entry>float</entry>
   *         <entry>float</entry>
   *       </row>
   *       <row>
   *         <entry>double</entry>
   *         <entry>double</entry>
   *       </row>
   *       <row>
   *         <entry>complex</entry>
   *         <entry>complex</entry>
   *       </row>
   *       <row>
   *         <entry>double complex</entry>
   *         <entry>double complex</entry>
   *       </row>
   *     </tbody>
   *   </tgroup>
   * </table>
   * }</pre>
   *
   * <p>In other words, the output type is just large enough to hold the whole
   * range of possible values.</p>
   *
   * <p>See also: {@link #subtract}, {@link #linear}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage add(VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "add", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operator performs an affine transform on an image using {@optionalArg interpolate}.</p>
   *
   * <p>The transform is:</p>
   *
   * <pre>{@code 
   *   X = <code>@a</code> * (x + {@optionalArg idx}) + <code>@b</code> * (y + {@optionalArg idy}) + {@optionalArg odx}
   *   Y = <code>@c</code> * (x + {@optionalArg idx}) + <code>@d</code> * (y + {@optionalArg idy}) + <code>@doy</code>
   *
   *  where:
   *     x and y are the coordinates in input image.
   *     X and Y are the coordinates in output image.
   *     (0,0) is the upper left corner.
   * }</pre>
   *
   * <p>The section of the output space defined by {@optionalArg oarea} is written to
   * {@param out}. {@optionalArg oarea} is a four-element int array of left, top, width, height.
   * By default {@optionalArg oarea} is just large enough to cover the whole of the
   * transformed input image.</p>
   *
   * <p>By default, new pixels are filled with {@optionalArg background}. This defaults to
   * zero (black). You can set other extend types with {@optionalArg extend}. {@link app.photofox.vipsffm.enums.VipsExtend#EXTEND_COPY}
   * is better for image upsizing.</p>
   *
   * <p>{@optionalArg interpolate} defaults to bilinear.</p>
   *
   * <p>{@optionalArg idx}, {@optionalArg idy}, {@optionalArg odx}, {@optionalArg ody} default to zero.</p>
   *
   * <p>Image are normally treated as unpremultiplied, so this operation can be used
   * directly on PNG images. If your images have been through {@link #premultiply},
   * set {@optionalArg premultiplied}.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link #shrink}, {@link #resize}, #VipsInterpolate.</p>
   * @param matrix Transformation matrix
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg interpolate {@link VipsOption.Interpolate} Interpolate pixels with this
   * @optionalArg oarea {@link VipsOption.ArrayInt} Area of output to generate
   * @optionalArg odx {@link VipsOption.Double} Horizontal output displacement
   * @optionalArg ody {@link VipsOption.Double} Vertical output displacement
   * @optionalArg idx {@link VipsOption.Double} Horizontal input displacement
   * @optionalArg idy {@link VipsOption.Double} Vertical input displacement
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg premultiplied {@link VipsOption.Boolean} Images have premultiplied alpha
   * @optionalArg extend {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsExtend} How to generate the extra pixels
   */
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

  /**
   * <p>Load an Analyze 6.0 file. If {@param filename} is "fred.img", this will look for
   * an image header called "fred.hdr" and pixel data in "fred.img". You can
   * also load "fred" or "fred.hdr".</p>
   *
   * <p>Images are
   * loaded lazilly and byte-swapped, if necessary. The Analyze metadata is read
   * and attached.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage analyzeload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "analyzeload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Lay out the images in {@param in} in a grid. The grid is {@optionalArg across} images across and
   * however high is necessary to use up all of {@param in}. Images are set down
   * left-to-right and top-to-bottom. {@optionalArg across} defaults to <code>@n</code>.</p>
   *
   * <p>Each input image is placed with a box of size {@optionalArg hspacing} by {@optionalArg vspacing}
   * pixels and cropped. These default to the largest width and largest height
   * of the input images.</p>
   *
   * <p>Space between images is filled with {@optionalArg background}. This defaults to 0
   * (black).</p>
   *
   * <p>Images are positioned within their {@optionalArg hspacing} by {@optionalArg vspacing} box at low,
   * centre or high coordinate values, controlled by {@optionalArg halign} and {@optionalArg valign}. These
   * default to left-top.</p>
   *
   * <p>Boxes are joined and separated by {@optionalArg shim} pixels. This defaults to 0.</p>
   *
   * <p>If the number of bands in the input images differs, all but one of the
   * images must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the n-band images are operated upon.</p>
   *
   * <p>The input images are cast up to the smallest common type (see table
   * Smallest common format in
   * <code>arithmetic</code>).</p>
   *
   * <p>{@link #colourspace} can be useful for moving the images to a common
   * colourspace for compositing.</p>
   *
   * <p>See also: {@link #join}, {@link #insert}, {@link #colourspace}.</p>
   * @param in Array of input images
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg across {@link VipsOption.Int} Number of images across grid
   * @optionalArg shim {@link VipsOption.Int} Pixels between images
   * @optionalArg background {@link VipsOption.ArrayDouble} Colour for new pixels
   * @optionalArg halign {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAlign} Align on the left, centre or right
   * @optionalArg valign {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAlign} Align on the top, centre or bottom
   * @optionalArg hspacing {@link VipsOption.Int} Horizontal spacing between images
   * @optionalArg vspacing {@link VipsOption.Int} Vertical spacing between images
   */
  public VImage arrayjoin(List<VImage> in, VipsOption... args) throws VipsError {
    var inOption = VipsOption.ArrayImage("in", in);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "arrayjoin", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Look at the image metadata and rotate and flip the image to make it
   * upright. The <code>VIPS_META_ORIENTATION</code> tag is removed from {@param out} to prevent
   * accidental double rotation.</p>
   *
   * <p>Read {@optionalArg angle} to find the amount the image was rotated by. Read {@optionalArg flip} to
   * see if the image was also flipped.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg angle {@link VipsOption.Enum} {@link VipsAngle} Angle image was rotated by
   * @optionalArg flip {@link VipsOption.Boolean} Whether the image was flipped or not
   */
  public VImage autorot(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "autorot", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation finds the average value in an image. It operates on all
   * bands of the input image: use {@link #stats} if you need to calculate an
   * average for each band. For complex images, return the average modulus.</p>
   *
   * <p>See also: {@link #stats}, {@link #bandmean}, {@link #deviate}, {@link #rank}</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public double avg(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Double("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "avg", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Perform various boolean operations across the bands of an image. For
   * example, a three-band uchar image operated on with
   * {@link VipsOperationBoolean#OPERATION_BOOLEAN_AND} will produce a one-band uchar image where each
   * pixel is the bitwise and of the band elements of the corresponding pixel in
   * the input image.</p>
   *
   * <p>The output image is the same format as the input image for integer
   * types. Float types are cast to int before processing. Complex types are not
   * supported.</p>
   *
   * <p>The output image always has one band.</p>
   *
   * <p>This operation is useful in conjunction with {@link #relational}. You can use
   * it to see if all image bands match exactly.</p>
   *
   * <p>See also: <code>vips_boolean_const</code>.</p>
   * @param boolean1 {@link VipsOperationBoolean} Boolean to perform
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Fold up an image horizontally: width is collapsed into bands.
   * Use {@optionalArg factor} to set how much to fold by: {@optionalArg factor} 3, for example, will make
   * the output image three times narrower than the input, and with three times
   * as many bands. By default the whole of the input width is folded up.</p>
   *
   * <p>See also: {@link #csvload}, {@link #bandunfold}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg factor {@link VipsOption.Int} Fold by this factor
   */
  public VImage bandfold(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "bandfold", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Join a set of images together, bandwise.</p>
   *
   * <p>If the images
   * have n and m bands, then the output image will have n + m
   * bands, with the first n coming from the first image and the last m
   * from the second.</p>
   *
   * <p>If the images differ in size, the smaller images are enlarged to match the
   * larger by adding zero pixels along the bottom and right.</p>
   *
   * <p>The input images are cast up to the smallest common type (see table
   * Smallest common format in
   * <code>arithmetic</code>).</p>
   *
   * <p>See also: {@link #insert}.</p>
   * @param in Array of input images
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage bandjoin(List<VImage> in, VipsOption... args) throws VipsError {
    var inOption = VipsOption.ArrayImage("in", in);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "bandjoin", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Append a set of constant bands to an image.</p>
   *
   * <p>See also: {@link #bandjoin}.</p>
   * @param c Array of constants to add
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>This operation writes a one-band image where each pixel is the average of
   * the bands for that pixel in the input image. The output band format is
   * the same as the input band format. Integer types use round-to-nearest
   * averaging.</p>
   *
   * <p>See also: {@link #add}, {@link #avg}, {@link #recomb}</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage bandmean(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "bandmean", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Sorts the images {@param in} band-element-wise, then outputs an
   * image in which each band element is selected from the sorted list by the
   * {@optionalArg index} parameter. For example, if {@optionalArg index}
   * is zero, then each output band element will be the minimum of all the
   * corresponding input band elements.</p>
   *
   * <p>By default, {@optionalArg index} is -1, meaning pick the median value.</p>
   *
   * <p>It works for any uncoded, non-complex image type. Images are cast up to the
   * smallest common-format.</p>
   *
   * <p>Any image can have either 1 band or n bands, where n is the same for all
   * the non-1-band images. Single band images are then effectively copied to
   * make n-band images.</p>
   *
   * <p>Smaller input images are expanded by adding black pixels.</p>
   *
   * <p>See also: {@link #rank}.</p>
   * @param in Array of input images
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg index {@link VipsOption.Int} Select this band element from sorted list
   */
  public VImage bandrank(List<VImage> in, VipsOption... args) throws VipsError {
    var inOption = VipsOption.ArrayImage("in", in);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "bandrank", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Unfold image bands into x axis.
   * Use {@optionalArg factor} to set how much to unfold by: {@optionalArg factor} 3, for example, will make
   * the output image three times wider than the input, and with one third
   * as many bands. By default, all bands are unfolded.</p>
   *
   * <p>See also: {@link #csvload}, {@link #bandfold}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg factor {@link VipsOption.Int} Unfold by this factor
   */
  public VImage bandunfold(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "bandunfold", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Make a black unsigned char image of a specified size.</p>
   *
   * <p>See also: {@link #xyz}, {@link #text}, {@link #gaussnoise}.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg bands {@link VipsOption.Int} Number of bands in image
   */
  public VImage black(int width, int height, VipsOption... args) throws VipsError {
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

  /**
   * <p>Perform various boolean operations on pairs of images.</p>
   *
   * <p>The output image is the same format as the upcast input images for integer
   * types. Float types are cast to int before processing. Complex types are not
   * supported.</p>
   *
   * <p>If the images differ in size, the smaller image is enlarged to match the
   * larger by adding zero pixels along the bottom and right.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common format (see table
   * Smallest common format in
   * <code>arithmetic</code>).</p>
   *
   * <p>See also: <code>vips_boolean_const</code>.</p>
   * @param boolean1 {@link VipsOperationBoolean} Boolean to perform
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage boolean1(VipsOperationBoolean boolean1, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", this);
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

  /**
   * <p>Perform various boolean operations on an image against an array of
   * constants.</p>
   *
   * <p>The output type is always uchar, with 0 for FALSE and 255 for TRUE.</p>
   *
   * <p>If the array of constants has just one element, that constant is used for
   * all image bands. If the array has more than one element and they have
   * the same number of elements as there are bands in the image, then
   * one array element is used for each band. If the arrays have more than one
   * element and the image only has a single band, the result is a many-band
   * image where each band corresponds to one array element.</p>
   *
   * <p>See also: <code>vips_boolean</code>, <code>vips_boolean_const1</code>.</p>
   * @param boolean1 {@link VipsOperationBoolean} Boolean to perform
   * @param c Array of constants
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>This operation builds a lookup table from a set of points. Intermediate
   * values are generated by piecewise linear interpolation. The lookup table is
   * always of type {@link VipsBandFormat#FORMAT_DOUBLE}, use {@link #cast} to change it to the
   * type you need.</p>
   *
   * <p>For example, consider this 2 x 2 matrix of (x, y) coordinates:</p>
   *
   * <pre>{@code 
   *     |-------|-------|
   *     | 0     | 0     |
   *     |-------|-------|
   *     | 255   | 100   |
   *     |-------|-------|
   * }</pre>
   *
   * <p>We then generate a 1 x 256 element LUT like this:</p>
   *
   * <pre>{@code 
   *     |-------|-------|
   *     | Index | Value |
   *     |-------|-------|
   *     | 0     | 0     |
   *     |-------|-------|
   *     | 1     | 0.4   |
   *     |-------|-------|
   *     | etc.  | 0.4   |
   *     |-------|-------|
   *     | 255   | 100   |
   *     |-------|-------|
   * }</pre>
   *
   * <p>This is then written as the output image, with the left column giving the
   * index in the image to place the value.</p>
   *
   * <p>The (x, y) points don't need to be sorted: we do that. You can have
   * several Ys, each becomes a band in the output LUT. You don't need to
   * start at zero, any integer will do, including negatives.</p>
   *
   * <p>See also: {@link #identity}, {@link #invertlut}, {@link #cast}, {@link #maplut}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage buildlut(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "buildlut", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Swap the byte order in an image.</p>
   *
   * <p>See also: {@link #rawload}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage byteswap(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "byteswap", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation behaves rather like {@link #copy} between images
   * {@param in} and {@param out}, except that it keeps a cache of computed pixels.
   * This cache is made of up to {@optionalArg maxTiles} tiles (a value of -1
   * means any number of tiles), and each tile is of size {@optionalArg tileWidth}
   * by {@optionalArg tileHeight} pixels. By default it will cache 250 128 x 128 pixel tiles,
   * enough for two 1920 x 1080 images.</p>
   *
   * <p>This operation is a thin wrapper over <code>vips_sink_screen</code>, see the
   * documentation for that operation for details.</p>
   *
   * <p>It uses a set of background threads to calculate pixels and the various
   * active cache operations coordinate so as not to overwhelm your system. When
   * a request is made for an area of pixels, the operation will block until all
   * of those pixels have been calculated. Pixels are calculated with a set of
   * threads.</p>
   *
   * <p>See also: {@link #tilecache}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg max-tiles {@link VipsOption.Int} Maximum number of tiles to cache
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg tile-width {@link VipsOption.Int} Tile width in pixels
   */
  public VImage cache(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "cache", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Find edges by Canny's method: The maximum of the derivative of the gradient
   * in the direction of the gradient. Output is float, except for uchar input,
   * where output is uchar, and double input, where output is double. Non-complex
   * images only.</p>
   *
   * <p>Use {@optionalArg sigma} to control the scale over which gradient is measured. 1.4 is
   * usually a good value.</p>
   *
   * <p>Use {@optionalArg precision} to set the precision of edge detection. For uchar images,
   * setting this to {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER} will make edge detection much
   * faster, but sacrifice some sensitivity.</p>
   *
   * <p>You will probably need to process the output further to eliminate weak
   * edges.</p>
   *
   * <p>See also: {@link #sobel}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg sigma {@link VipsOption.Double} Sigma of Gaussian
   * @optionalArg precision {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPrecision} Convolve with this precision
   */
  public VImage canny(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "canny", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Use values in {@param index} to select pixels from {@param cases}.</p>
   *
   * <p>{@param index} must have one band. {@param cases} can have up to 256 elements. Values in
   * {@param index} greater than or equal to <code>@n</code> use the final image in {@param cases}. The
   * images in {@param cases} must have either one band or the same number of bands.
   * The output image is the same size as {@param index}. Images in {@param cases} are
   * expanded to the smallest common format and number of bands.</p>
   *
   * <p>Combine this with <code>vips_switch</code> to make something like a case statement or
   * a multi-way {@link #ifthenelse}.</p>
   *
   * <p>See also: {@link #maplut}, <code>vips_switch</code>, {@link #ifthenelse}.</p>
   * @param cases Array of case images
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Convert {@param in} to {@param format}. You can convert between any pair of formats.
   * Floats are truncated (not rounded). Out of range values are clipped.</p>
   *
   * <p>Casting from complex to real returns the real part.</p>
   *
   * <p>If {@optionalArg shift} is <code>TRUE</code>, integer values are shifted up and down. For example,
   * casting from unsigned 8 bit to unsigned 16 bit would
   * shift every value left by 8 bits. The bottom bit is copied into the new
   * bits, so 255 would become 65535.</p>
   *
   * <p>See also: {@link #scale}, {@link #complexform}, <code>vips_real</code>, <code>vips_imag</code>,
   * <code>vips_cast_uchar</code>, {@link #msb}.</p>
   * @param format {@link VipsBandFormat} Format to cast to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg shift {@link VipsOption.Boolean} Shift integer values up and down
   */
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

  /**
   * <p>This operation looks at the interpretation field of {@param in} (or uses
   * {@optionalArg sourceSpace}, if set) and runs
   * a set of colourspace conversion functions to move it to {@param space}.</p>
   *
   * <p>For example, given an image tagged as {@link VipsInterpretation#INTERPRETATION_YXY}, running
   * colourspace with {@param space} set to {@link VipsInterpretation#INTERPRETATION_LAB} will
   * convert with {@link #Yxy2XYZ} and {@link #XYZ2Lab}.</p>
   *
   * <p>See also: <code>vips_colourspace_issupported</code>,
   * <code>vips_image_guess_interpretation</code>.</p>
   * @param space {@link VipsInterpretation} Destination color space
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg source-space {@link VipsOption.Enum} {@link VipsInterpretation} Source color space
   */
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

  /**
   * <p>This convolves {@param in} with {@param mask} {@optionalArg times} times, rotating {@param mask} by {@optionalArg angle}
   * each time. By default, it comvolves twice, rotating by 90 degrees, taking
   * the maximum result.</p>
   *
   * <p>See also: {@link #conv}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg times {@link VipsOption.Int} Rotate and convolve this many times
   * @optionalArg angle {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAngle45} Rotate mask by this much between convolutions
   * @optionalArg combine {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsCombine} Combine convolution results like this
   * @optionalArg precision {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPrecision} Convolve with this precision
   * @optionalArg layers {@link VipsOption.Int} Use this many layers in approximation
   * @optionalArg cluster {@link VipsOption.Int} Cluster lines closer than this in approximation
   */
  public VImage compass(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "compass", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Perform various operations on complex images.</p>
   *
   * <p>Angles are expressed in degrees. The output type is complex unless the
   * input is double or dpcomplex, in which case the output is dpcomplex.</p>
   * @param cmplx {@link VipsOperationComplex} Complex to perform
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Perform various binary operations on complex images.</p>
   *
   * <p>Angles are expressed in degrees. The output type is complex unless the
   * input is double or dpcomplex, in which case the output is dpcomplex.</p>
   * @param cmplx {@link VipsOperationComplex2} Binary complex operation to perform
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage complex2(VipsOperationComplex2 cmplx, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", this);
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

  /**
   * <p>Compose two real images to make a complex image. If either {@param left} or {@param right}
   * are {@link VipsBandFormat#FORMAT_DOUBLE}, {@param out} is {@link VipsBandFormat#FORMAT_DPCOMPLEX}. Otherwise {@param out}
   * is {@link VipsBandFormat#FORMAT_COMPLEX}. {@param left} becomes the real component of {@param out} and
   * {@param right} the imaginary.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>See also: {@link #complexget}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage complexform(VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "complexform", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Get components of complex images.</p>
   *
   * <p>The output type is the same as the input type, except {@link VipsBandFormat#FORMAT_COMPLEX}
   * becomes {@link VipsBandFormat#FORMAT_FLOAT} and {@link VipsBandFormat#FORMAT_DPCOMPLEX} becomes
   * {@link VipsBandFormat#FORMAT_DOUBLE}.</p>
   * @param get {@link VipsOperationComplexget} Complex to perform
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Composite an array of images together.</p>
   *
   * <p>Images are placed in a stack, with {@param in}[0] at the bottom and {@param in}[<code>@n</code> - 1] at
   * the top. Pixels are blended together working from the bottom upwards, with
   * the blend mode at each step being set by the corresponding #VipsBlendMode
   * in {@param mode}.</p>
   *
   * <p>Images are transformed to a compositing space before processing. This is
   * <code>VIPS_INTERPRETATION_</code>sRGB, {@link VipsInterpretation#INTERPRETATION_B_W},
   * {@link VipsInterpretation#INTERPRETATION_RGB16}, or {@link VipsInterpretation#INTERPRETATION_GREY16}
   * by default, depending on
   * how many bands and bits the input images have. You can select any other
   * space, such as {@link VipsInterpretation#INTERPRETATION_LAB} or <code>VIPS_INTERPRETATION_</code>scRGB.</p>
   *
   * <p>The output image is in the compositing space. It will always be
   * {@link VipsBandFormat#FORMAT_FLOAT} unless one of the inputs is {@link VipsBandFormat#FORMAT_DOUBLE}, in
   * which case the output will be double as well.</p>
   *
   * <p>Complex images are not supported.</p>
   *
   * <p>The output image will always have an alpha band. A solid alpha is
   * added to any input missing an alpha.</p>
   *
   * <p>The images do not need to match in size or format. They will be expanded to
   * the smallest common size and format in the usual way. Images are positioned
   * using the {@optionalArg x} and {@optionalArg y} parameters, if set.</p>
   *
   * <p>Image are normally treated as unpremultiplied, so this operation can be used
   * directly on PNG images. If your images have been through {@link #premultiply},
   * set {@optionalArg premultiplied}.</p>
   *
   * <p>See also: {@link #insert}.</p>
   * @param in Array of input images
   * @param mode Array of VipsBlendMode to join with
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg x {@link VipsOption.ArrayInt} Array of x coordinates to join at
   * @optionalArg y {@link VipsOption.ArrayInt} Array of y coordinates to join at
   * @optionalArg compositing-space {@link VipsOption.Enum} {@link VipsInterpretation} Composite images in this colour space
   * @optionalArg premultiplied {@link VipsOption.Boolean} Images have premultiplied alpha
   */
  public VImage composite(List<VImage> in, List<Integer> mode, VipsOption... args) throws
      VipsError {
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

  /**
   * <p>Composite {@param overlay} on top of {@param base} with {@param mode}. See {@link #composite}.</p>
   * @param mode {@link VipsBlendMode} VipsBlendMode to join with
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg x {@link VipsOption.Int} X position of overlay
   * @optionalArg y {@link VipsOption.Int} Y position of overlay
   * @optionalArg compositing-space {@link VipsOption.Enum} {@link VipsInterpretation} Composite images in this colour space
   * @optionalArg premultiplied {@link VipsOption.Boolean} Images have premultiplied alpha
   */
  public VImage composite2(VipsBlendMode mode, VipsOption... args) throws VipsError {
    var baseOption = VipsOption.Image("base", this);
    var overlayOption = VipsOption.Image("overlay", this);
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

  /**
   * <p>Convolution.</p>
   *
   * <p>Perform a convolution of {@param in} with {@param mask}.
   * Each output pixel is calculated as:</p>
   *
   * <pre>{@code 
   * sigma[i]{pixel[i] * mask[i]} / scale + offset
   * }</pre>
   *
   * <p>where scale and offset are part of {@param mask}.</p>
   *
   * <p>By default, {@optionalArg precision} is
   * {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_FLOAT}. The output image
   * is always {@link VipsBandFormat#FORMAT_FLOAT} unless {@param in} is {@link VipsBandFormat#FORMAT_DOUBLE}, in which case
   * {@param out} is also {@link VipsBandFormat#FORMAT_DOUBLE}.</p>
   *
   * <p>If {@optionalArg precision} is {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER}, then
   * elements of {@param mask} are converted to
   * integers before convolution, using rint(),
   * and the output image
   * always has the same #VipsBandFormat as the input image.</p>
   *
   * <p>For {@link VipsBandFormat#FORMAT_UCHAR} images and {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER} {@optionalArg precision},
   * conv uses a fast vector path based on
   * half-float arithmetic. This can produce slightly different results.
   * Disable the vector path with `--vips-novector` or `VIPS_NOVECTOR` or
   * <code>vips_vector_set_enabled</code>.</p>
   *
   * <p>If {@optionalArg precision} is {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_APPROXIMATE} then, like
   * {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER}, {@param mask} is converted to int before convolution, and
   * the output image
   * always has the same #VipsBandFormat as the input image.</p>
   *
   * <p>Larger values for {@optionalArg layers} give more accurate
   * results, but are slower. As {@optionalArg layers} approaches the mask radius, the
   * accuracy will become close to exact convolution and the speed will drop to
   * match. For many large masks, such as Gaussian, <code>@n_layers</code> need be only 10% of
   * this value and accuracy will still be good.</p>
   *
   * <p>Smaller values of {@optionalArg cluster} will give more accurate results, but be slower
   * and use more memory. 10% of the mask radius is a good rule of thumb.</p>
   *
   * <p>See also: {@link #convsep}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg precision {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPrecision} Convolve with this precision
   * @optionalArg layers {@link VipsOption.Int} Use this many layers in approximation
   * @optionalArg cluster {@link VipsOption.Int} Cluster lines closer than this in approximation
   */
  public VImage conv(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "conv", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Perform an approximate integer convolution of {@param in} with {@param mask}.
   * This is a low-level operation, see
   * {@link #conv} for something more convenient.</p>
   *
   * <p>The output image
   * always has the same #VipsBandFormat as the input image.
   * Elements of {@param mask} are converted to
   * integers before convolution.</p>
   *
   * <p>Larger values for {@optionalArg layers} give more accurate
   * results, but are slower. As {@optionalArg layers} approaches the mask radius, the
   * accuracy will become close to exact convolution and the speed will drop to
   * match. For many large masks, such as Gaussian, {@optionalArg layers} need be only 10% of
   * this value and accuracy will still be good.</p>
   *
   * <p>Smaller values of {@optionalArg cluster} will give more accurate results, but be slower
   * and use more memory. 10% of the mask radius is a good rule of thumb.</p>
   *
   * <p>See also: {@link #conv}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg layers {@link VipsOption.Int} Use this many layers in approximation
   * @optionalArg cluster {@link VipsOption.Int} Cluster lines closer than this in approximation
   */
  public VImage conva(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "conva", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Approximate separable integer convolution. This is a low-level operation, see
   * {@link #convsep} for something more convenient.</p>
   *
   * <p>The image is convolved twice: once with {@param mask} and then again with {@param mask}
   * rotated by 90 degrees.
   * {@param mask} must be 1xn or nx1 elements.
   * Elements of {@param mask} are converted to
   * integers before convolution.</p>
   *
   * <p>Larger values for {@optionalArg layers} give more accurate
   * results, but are slower. As {@optionalArg layers} approaches the mask radius, the
   * accuracy will become close to exact convolution and the speed will drop to
   * match. For many large masks, such as Gaussian, {@optionalArg layers} need be only 10% of
   * this value and accuracy will still be good.</p>
   *
   * <p>The output image
   * always has the same #VipsBandFormat as the input image.</p>
   *
   * <p>See also: {@link #convsep}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg layers {@link VipsOption.Int} Use this many layers in approximation
   */
  public VImage convasep(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "convasep", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Convolution. This is a low-level operation, see {@link #conv} for something
   * more convenient.</p>
   *
   * <p>Perform a convolution of {@param in} with {@param mask}.
   * Each output pixel is
   * calculated as sigma[i]{pixel[i] * mask[i]} / scale + offset, where scale
   * and offset are part of {@param mask}.</p>
   *
   * <p>The convolution is performed with floating-point arithmetic. The output image
   * is always {@link VipsBandFormat#FORMAT_FLOAT} unless {@param in} is {@link VipsBandFormat#FORMAT_DOUBLE}, in which case
   * {@param out} is also {@link VipsBandFormat#FORMAT_DOUBLE}.</p>
   *
   * <p>See also: {@link #conv}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage convf(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "convf", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Integer convolution. This is a low-level operation, see {@link #conv} for
   * something more convenient.</p>
   *
   * <p>{@param mask} is converted to an integer mask with rint() of each element, rint of
   * scale and rint of offset. Each output pixel is then calculated as</p>
   *
   * <pre>{@code 
   * sigma[i]{pixel[i] * mask[i]} / scale + offset
   * }</pre>
   *
   * <p>The output image always has the same #VipsBandFormat as the input image.</p>
   *
   * <p>For {@link VipsBandFormat#FORMAT_UCHAR} images, convi uses a fast vector path based on
   * half-float arithmetic. This can produce slightly different results.
   * Disable the vector path with `--vips-novector` or `VIPS_NOVECTOR` or
   * <code>vips_vector_set_enabled</code>.</p>
   *
   * <p>See also: {@link #conv}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage convi(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "convi", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Perform a separable convolution of {@param in} with {@param mask}.
   * See {@link #conv} for a detailed description.</p>
   *
   * <p>The mask must be 1xn or nx1 elements.</p>
   *
   * <p>The image is convolved twice: once with {@param mask} and then again with {@param mask}
   * rotated by 90 degrees. This is much faster for certain types of mask
   * (gaussian blur, for example) than doing a full 2D convolution.</p>
   *
   * <p>See also: {@link #conv}, {@link #gaussmat}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg precision {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPrecision} Convolve with this precision
   * @optionalArg layers {@link VipsOption.Int} Use this many layers in approximation
   * @optionalArg cluster {@link VipsOption.Int} Cluster lines closer than this in approximation
   */
  public VImage convsep(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "convsep", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Copy an image, optionally modifying the header. VIPS copies images by
   * copying pointers, so this operation is instant, even for very large images.</p>
   *
   * <p>You can optionally change any or all header fields during the copy. You can
   * make any change which does not change the size of a pel, so for example
   * you can turn a 4-band uchar image into a 2-band ushort image, but you
   * cannot change a 100 x 100 RGB image into a 300 x 100 mono image.</p>
   *
   * <p>See also: {@link #byteswap}, {@link #bandfold}, {@link #bandunfold}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg swap {@link VipsOption.Boolean} Swap bytes in image between little and big-endian
   * @optionalArg width {@link VipsOption.Int} Image width in pixels
   * @optionalArg height {@link VipsOption.Int} Image height in pixels
   * @optionalArg bands {@link VipsOption.Int} Number of bands in image
   * @optionalArg format {@link VipsOption.Enum} {@link VipsBandFormat} Pixel format in image
   * @optionalArg coding {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsCoding} Pixel coding
   * @optionalArg interpretation {@link VipsOption.Enum} {@link VipsInterpretation} Pixel interpretation
   * @optionalArg xres {@link VipsOption.Double} Horizontal resolution in pixels/mm
   * @optionalArg yres {@link VipsOption.Double} Vertical resolution in pixels/mm
   * @optionalArg xoffset {@link VipsOption.Int} Horizontal offset of origin
   * @optionalArg yoffset {@link VipsOption.Int} Vertical offset of origin
   */
  public VImage copy(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "copy", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Function which calculates the number of transitions
   * between black and white for the horizontal or the vertical
   * direction of an image.  black&lt;128 , white&ge;128
   * The function calculates the number of transitions for all
   * Xsize or Ysize and returns the mean of the result
   * Input should be one band, 8-bit.</p>
   *
   * <p>See also: {@link #morph}, {@link #conv}.</p>
   * @param direction {@link VipsDirection} Countlines left-right or up-down
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Load a CSV (comma-separated values) file. The output image is always 1
   * band (monochrome), {@link VipsBandFormat#FORMAT_DOUBLE}. Use {@link #bandfold} to turn
   * RGBRGBRGB mono images into colour images.</p>
   *
   * <p>Items in lines can be either floating point numbers in the C locale, or
   * strings enclosed in double-quotes ("), or empty.
   * You can use a backslash (\) within the quotes to escape special characters,
   * such as quote marks.</p>
   *
   * <p>{@optionalArg skip} sets the number of lines to skip at the start of the file.
   * Default zero.</p>
   *
   * <p>{@optionalArg lines} sets the number of lines to read from the file. Default -1,
   * meaning read all lines to end of file.</p>
   *
   * <p>{@optionalArg whitespace} sets the skippable whitespace characters.
   * Default <b>space</b>.
   * Whitespace characters are always run together.</p>
   *
   * <p>{@optionalArg separator} sets the characters that separate fields.
   * Default ;,<b>tab</b>. Separators are never run together.</p>
   *
   * <p>Use {@optionalArg failOn} to set the type of error that will cause load to fail. By
   * default, loaders are permissive, that is, {@link app.photofox.vipsffm.enums.VipsFailOn#FAIL_ON_NONE}.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>, {@link #bandfold}.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg skip {@link VipsOption.Int} Skip this many lines at the start of the file
   * @optionalArg lines {@link VipsOption.Int} Read this many lines from the file
   * @optionalArg whitespace {@link VipsOption.String} Set of whitespace characters
   * @optionalArg separator {@link VipsOption.String} Set of separator characters
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage csvload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "csvload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #csvload}, but read from a source.</p>
   *
   * <p>See also: {@link #csvload}.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg skip {@link VipsOption.Int} Skip this many lines at the start of the file
   * @optionalArg lines {@link VipsOption.Int} Read this many lines from the file
   * @optionalArg whitespace {@link VipsOption.String} Set of whitespace characters
   * @optionalArg separator {@link VipsOption.String} Set of separator characters
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage csvloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "csvload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Writes the pixels in {@param in} to the {@param filename} as CSV (comma-separated values).
   * The image is written
   * one line of text per scanline. Complex numbers are written as
   * "(real,imaginary)" and will need extra parsing I guess. Only the first band
   * is written.</p>
   *
   * <p>{@optionalArg separator} gives the string to use to separate numbers in the output.
   * The default is "\\t" (tab).</p>
   *
   * <p>See also: <code>vips_image_write_to_file</code>.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg separator {@link VipsOption.String} Separator characters
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void csvsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "csvsave", callArgs);
  }

  /**
   * <p>As {@link #csvsave}, but save to a target.</p>
   *
   * <p>See also: {@link #csvsave}.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg separator {@link VipsOption.String} Separator characters
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void csvsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "csvsave_target", callArgs);
  }

  /**
   * <p>Calculate dE 00.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage dE00(VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "dE00", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Calculate dE 76.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage dE76(VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "dE76", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Calculate dE CMC. The input images are transformed to CMC colour space and
   * the euclidean distance between corresponding pixels calculated.</p>
   *
   * <p>To calculate a colour difference with values for (l:c) other than (1:1),
   * transform the two source images to CMC yourself, scale the channels
   * appropriately, and call this function.</p>
   *
   * <p>See also: {@link #colourspace}</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage dECMC(VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "dECMC", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation finds the standard deviation of all pixels in {@param in}. It
   * operates on all bands of the input image: use {@link #stats} if you need
   * to calculate an average for each band.</p>
   *
   * <p>Non-complex images only.</p>
   *
   * <p>See also: {@link #avg}, {@link #stats}..</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public double deviate(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Double("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "deviate", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation calculates <code>@in1</code> / <code>@in2</code> and writes the result to {@param out}. If any
   * pixels in <code>@in2</code> are zero, the corresponding pixel in {@param out} is also zero.</p>
   *
   * <p>If the images differ in size, the smaller image is enlarged to match the
   * larger by adding zero pixels along the bottom and right.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common format (see table
   * Smallest common format in
   * <code>arithmetic</code>), then the
   * following table is used to determine the output type:</p>
   *
   * <pre>{@code
   * <table>
   *   <title>divide type promotion</title>
   *   <tgroup cols='2' align='left' colsep='1' rowsep='1'>
   *     <thead>
   *       <row>
   *         <entry>input type</entry>
   *         <entry>output type</entry>
   *       </row>
   *     </thead>
   *     <tbody>
   *       <row>
   *         <entry>uchar</entry>
   *         <entry>float</entry>
   *       </row>
   *       <row>
   *         <entry>char</entry>
   *         <entry>float</entry>
   *       </row>
   *       <row>
   *         <entry>ushort</entry>
   *         <entry>float</entry>
   *       </row>
   *       <row>
   *         <entry>short</entry>
   *         <entry>float</entry>
   *       </row>
   *       <row>
   *         <entry>uint</entry>
   *         <entry>float</entry>
   *       </row>
   *       <row>
   *         <entry>int</entry>
   *         <entry>float</entry>
   *       </row>
   *       <row>
   *         <entry>float</entry>
   *         <entry>float</entry>
   *       </row>
   *       <row>
   *         <entry>double</entry>
   *         <entry>double</entry>
   *       </row>
   *       <row>
   *         <entry>complex</entry>
   *         <entry>complex</entry>
   *       </row>
   *       <row>
   *         <entry>double complex</entry>
   *         <entry>double complex</entry>
   *       </row>
   *     </tbody>
   *   </tgroup>
   * </table>
   * }</pre>
   *
   * <p>In other words, the output type is just large enough to hold the whole
   * range of possible values.</p>
   *
   * <p>See also: {@link #multiply}, {@link #linear}, <code>vips_pow</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage divide(VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "divide", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Draws a circle on {@param image}. If {@optionalArg fill} is <code>TRUE</code> then the circle is filled,
   * otherwise a 1-pixel-wide perimeter is drawn.</p>
   *
   * <p>{@param ink} is an array of double containing values to draw.</p>
   *
   * <p>See also: <code>vips_draw_circle1</code>, <code>vips_draw_line</code>.</p>
   * @param ink Color for pixels
   * @param cx Centre of draw_circle
   * @param cy Centre of draw_circle
   * @param radius Radius in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg fill {@link VipsOption.Boolean} Draw a solid object
   */
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

  /**
   * <p>Flood-fill {@param image} with {@param ink}, starting at position {@param x}, {@param y}. The filled area is
   * bounded by pixels that are equal to the ink colour, in other words, it
   * searches for pixels enclosed by an edge of {@param ink}.</p>
   *
   * <p>If {@optionalArg equal} is set, it instead searches for pixels which are equal to the
   * start point and fills them with {@param ink}.</p>
   *
   * <p>Normally it will test and set pixels in {@param image}. If {@optionalArg test} is set, it will
   * test pixels in {@optionalArg test} and set pixels in {@param image}. This lets you search an
   * image ({@optionalArg test}) for continuous areas of pixels without modifying it.</p>
   *
   * <p>{@optionalArg left}, {@optionalArg top}, {@optionalArg width}, {@optionalArg height} output the bounding box of the modified
   * pixels.</p>
   *
   * <p>{@param ink} is an array of double containing values to draw.</p>
   *
   * <p>See also: <code>vips_draw_flood1</code>.</p>
   * @param ink Color for pixels
   * @param x DrawFlood start point
   * @param y DrawFlood start point
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg test {@link VipsOption.Image} Test pixels in this image
   * @optionalArg equal {@link VipsOption.Boolean} DrawFlood while equal to edge
   * @optionalArg left {@link VipsOption.Int} Left edge of modified area
   * @optionalArg top {@link VipsOption.Int} Top edge of modified area
   * @optionalArg width {@link VipsOption.Int} Width of modified area
   * @optionalArg height {@link VipsOption.Int} Height of modified area
   */
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

  /**
   * <p>Draw {@param sub} on top of {@param image} at position {@param x}, {@param y}. The two images must have the
   * same Coding. If {@param sub} has 1 band, the bands will be duplicated to match the
   * number of bands in {@param image}. {@param sub} will be converted to {@param image}'s format, see
   * {@link #cast}.</p>
   *
   * <p>Use {@optionalArg mode} to set how pixels are combined. If you use
   * {@link app.photofox.vipsffm.enums.VipsCombineMode#COMBINE_MODE_ADD}, both images muct be uncoded.</p>
   *
   * <p>See also: <code>vips_draw_mask</code>, {@link #insert}.</p>
   * @param x Draw image here
   * @param y Draw image here
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg mode {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsCombineMode} Combining mode
   */
  public void drawImage(int x, int y, VipsOption... args) throws VipsError {
    var imageOption = VipsOption.Image("image", this);
    var subOption = VipsOption.Image("sub", this);
    var xOption = VipsOption.Int("x", x);
    var yOption = VipsOption.Int("y", y);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(imageOption);
    callArgs.add(subOption);
    callArgs.add(xOption);
    callArgs.add(yOption);
    VipsInvoker.invokeOperation(arena, "draw_image", callArgs);
  }

  /**
   * <p>Draws a 1-pixel-wide line on an image.</p>
   *
   * <p>{@param ink} is an array of double containing values to draw.</p>
   *
   * <p>See also: <code>vips_draw_line1</code>, <code>vips_draw_circle</code>, <code>vips_draw_mask</code>.</p>
   * @param ink Color for pixels
   * @param x1 Start of draw_line
   * @param y1 Start of draw_line
   * @param x2 End of draw_line
   * @param y2 End of draw_line
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Draw {@param mask} on the image. {@param mask} is a monochrome 8-bit image with 0/255
   * for transparent or {@param ink} coloured points. Intermediate values blend the ink
   * with the pixel. Use with {@link #text} to draw text on an image. Use in a
   * <code>vips_draw_line</code> subclass to draw an object along a line.</p>
   *
   * <p>{@param ink} is an array of double containing values to draw.</p>
   *
   * <p>See also: {@link #text}, <code>vips_draw_line</code>.</p>
   * @param ink Color for pixels
   * @param x Draw mask here
   * @param y Draw mask here
   * @param args Array of VipsOption to apply to this operation
   */
  public void drawMask(List<Double> ink, int x, int y, VipsOption... args) throws VipsError {
    var imageOption = VipsOption.Image("image", this);
    var inkOption = VipsOption.ArrayDouble("ink", ink);
    var maskOption = VipsOption.Image("mask", this);
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

  /**
   * <p>Paint pixels within {@param left}, {@param top}, {@param width}, {@param height} in {@param image} with {@param ink}. If
   * {@optionalArg fill} is zero, just paint a 1-pixel-wide outline.</p>
   *
   * <p>See also: <code>vips_draw_circle</code>.</p>
   * @param ink Color for pixels
   * @param left Rect to fill
   * @param top Rect to fill
   * @param width Rect to fill
   * @param height Rect to fill
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg fill {@link VipsOption.Boolean} Draw a solid object
   */
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

  /**
   * <p>Smudge a section of {@param image}. Each pixel in the area {@param left}, {@param top}, {@param width},
   * {@param height} is replaced by the average of the surrounding 3x3 pixels.</p>
   *
   * <p>See also: <code>vips_draw_line</code>.</p>
   * @param left Rect to fill
   * @param top Rect to fill
   * @param width Rect to fill
   * @param height Rect to fill
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Save an image as a set of tiles at various resolutions. By default dzsave
   * uses DeepZoom layout -- use {@optionalArg layout} to pick other conventions.</p>
   *
   * <p>dzsave creates a directory called <code>@name</code> to hold the tiles. If <code>@name</code>
   * ends `.zip`, dzsave will create a zip file called <code>@name</code> to hold the
   * tiles. You can use {@optionalArg container} to force zip file output.</p>
   *
   * <p>Use {@optionalArg basename} to set the name of the image we are creating. The
   * default value is set from <code>@name</code>.</p>
   *
   * <p>By default, tiles are written as JPEGs. Use {@optionalArg Q} set set the JPEG quality
   * factor.</p>
   *
   * <p>You can set {@optionalArg suffix} to something like `".png[bitdepth=4]"` to write tiles
   * in another format.</p>
   *
   * <p>In Google layout mode, edge tiles are expanded to {@optionalArg tileSize} by {@optionalArg tileSize}
   * pixels. Normally they are filled with white, but you can set another colour
   * with {@optionalArg background}. Images are usually placed at the top-left of the tile,
   * but you can have them centred by turning on {@optionalArg centre}.</p>
   *
   * <p>You can set the size and overlap of tiles with {@optionalArg tileSize} and {@optionalArg overlap}.
   * They default to the correct settings for the selected {@optionalArg layout}. The deepzoom
   * defaults produce 256x256 jpeg files for centre tiles, the most efficient
   * size.</p>
   *
   * <p>Use {@optionalArg depth} to control how low the pyramid goes. This defaults to the
   * correct setting for the {@optionalArg layout} you select.</p>
   *
   * <p>You can rotate the image during write with the {@optionalArg angle} argument. However,
   * this will only work for images which support random access, like openslide,
   * and not for things like JPEG. You'll need to rotate those images
   * yourself with {@link #rot}. Note that the `autorotate` option to the loader
   * may do what you need.</p>
   *
   * <p>By default, all tiles are stripped since usually you do not want a copy of
   * all metadata in every tile. Set {@optionalArg keep} if you want to keep metadata.</p>
   *
   * <p>If {@optionalArg container} is set to `zip`, you can set a compression level from -1
   * (use zlib default), 0 (store, compression disabled) to 9 (max compression).
   * If no value is given, the default is to store files without compression.</p>
   *
   * <p>You can use {@optionalArg regionShrink} to control the method for shrinking each 2x2
   * region. This defaults to using the average of the 4 input pixels but you can
   * also use the median in cases where you want to preserve the range of values.</p>
   *
   * <p>If you set {@optionalArg skipBlanks} to a value greater than or equal to zero, tiles
   * which are all within that many pixel values to the background are skipped.
   * This can save a lot of space for some image types. This option defaults to
   * 5 in Google layout mode, -1 otherwise.</p>
   *
   * <p>In IIIF layout, you can set the base of the `id` property in `info.json`
   * with {@optionalArg id}. The default is `https://example.com/iiif`.</p>
   *
   * <p>Use {@optionalArg layout} {@link app.photofox.vipsffm.enums.VipsForeignDzLayout#FOREIGN_DZ_LAYOUT_IIIF3} for IIIF v3 layout.</p>
   *
   * <p>See also: {@link #tiffsave}.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg dirname {@link VipsOption.String} Directory name to save to
   * @optionalArg imagename {@link VipsOption.String} Image name
   * @optionalArg layout {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignDzLayout} Directory layout
   * @optionalArg suffix {@link VipsOption.String} Filename suffix for tiles
   * @optionalArg overlap {@link VipsOption.Int} Tile overlap in pixels
   * @optionalArg tile-size {@link VipsOption.Int} Tile size in pixels
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg tile-width {@link VipsOption.Int} Tile width in pixels
   * @optionalArg centre {@link VipsOption.Boolean} Center image in tile
   * @optionalArg depth {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignDzDepth} Pyramid depth
   * @optionalArg angle {@link VipsOption.Enum} {@link VipsAngle} Rotate image during save
   * @optionalArg container {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignDzContainer} Pyramid container type
   * @optionalArg properties {@link VipsOption.Boolean} Write a properties file to the output directory
   * @optionalArg compression {@link VipsOption.Int} ZIP deflate compression level
   * @optionalArg region-shrink {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsRegionShrink} Method to shrink regions
   * @optionalArg skip-blanks {@link VipsOption.Int} Skip tiles which are nearly equal to the background
   * @optionalArg id {@link VipsOption.String} Resource ID
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg no-strip {@link VipsOption.Boolean} Don't strip tile metadata
   * @optionalArg basename {@link VipsOption.String} Base name to save to
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void dzsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "dzsave", callArgs);
  }

  /**
   * <p>As {@link #dzsave}, but save to a memory buffer.</p>
   *
   * <p>Output is always in a zip container. Use {@optionalArg basename} to set the name of the
   * directory that the zip will create when unzipped.</p>
   *
   * <p>The address of the buffer is returned in <code>@buf</code>, the length of the buffer in
   * <code>@len</code>. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link #dzsave}, <code>vips_image_write_to_file</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg dirname {@link VipsOption.String} Directory name to save to
   * @optionalArg imagename {@link VipsOption.String} Image name
   * @optionalArg layout {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignDzLayout} Directory layout
   * @optionalArg suffix {@link VipsOption.String} Filename suffix for tiles
   * @optionalArg overlap {@link VipsOption.Int} Tile overlap in pixels
   * @optionalArg tile-size {@link VipsOption.Int} Tile size in pixels
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg tile-width {@link VipsOption.Int} Tile width in pixels
   * @optionalArg centre {@link VipsOption.Boolean} Center image in tile
   * @optionalArg depth {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignDzDepth} Pyramid depth
   * @optionalArg angle {@link VipsOption.Enum} {@link VipsAngle} Rotate image during save
   * @optionalArg container {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignDzContainer} Pyramid container type
   * @optionalArg properties {@link VipsOption.Boolean} Write a properties file to the output directory
   * @optionalArg compression {@link VipsOption.Int} ZIP deflate compression level
   * @optionalArg region-shrink {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsRegionShrink} Method to shrink regions
   * @optionalArg skip-blanks {@link VipsOption.Int} Skip tiles which are nearly equal to the background
   * @optionalArg id {@link VipsOption.String} Resource ID
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg no-strip {@link VipsOption.Boolean} Don't strip tile metadata
   * @optionalArg basename {@link VipsOption.String} Base name to save to
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public VBlob dzsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "dzsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /**
   * <p>As {@link #dzsave}, but save to a target.</p>
   *
   * <p>See also: {@link #dzsave}, <code>vips_image_write_to_target</code>.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg dirname {@link VipsOption.String} Directory name to save to
   * @optionalArg imagename {@link VipsOption.String} Image name
   * @optionalArg layout {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignDzLayout} Directory layout
   * @optionalArg suffix {@link VipsOption.String} Filename suffix for tiles
   * @optionalArg overlap {@link VipsOption.Int} Tile overlap in pixels
   * @optionalArg tile-size {@link VipsOption.Int} Tile size in pixels
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg tile-width {@link VipsOption.Int} Tile width in pixels
   * @optionalArg centre {@link VipsOption.Boolean} Center image in tile
   * @optionalArg depth {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignDzDepth} Pyramid depth
   * @optionalArg angle {@link VipsOption.Enum} {@link VipsAngle} Rotate image during save
   * @optionalArg container {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignDzContainer} Pyramid container type
   * @optionalArg properties {@link VipsOption.Boolean} Write a properties file to the output directory
   * @optionalArg compression {@link VipsOption.Int} ZIP deflate compression level
   * @optionalArg region-shrink {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsRegionShrink} Method to shrink regions
   * @optionalArg skip-blanks {@link VipsOption.Int} Skip tiles which are nearly equal to the background
   * @optionalArg id {@link VipsOption.String} Resource ID
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg no-strip {@link VipsOption.Boolean} Don't strip tile metadata
   * @optionalArg basename {@link VipsOption.String} Base name to save to
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void dzsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "dzsave_target", callArgs);
  }

  /**
   * <p>The opposite of <code>vips_extract_area</code>: embed {@param in} within an image of size
   * {@param width} by {@param height} at position {@param x}, {@param y}.</p>
   *
   * <p>{@optionalArg extend}
   * controls what appears in the new pels, see #VipsExtend.</p>
   *
   * <p>See also: <code>vips_extract_area</code>, {@link #insert}.</p>
   * @param x Left edge of input in output
   * @param y Top edge of input in output
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg extend {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsExtend} How to generate the extra pixels
   * @optionalArg background {@link VipsOption.ArrayDouble} Color for background pixels
   */
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

  /**
   * <p>Extract an area from an image. The area must fit within <code>@in</code>.</p>
   *
   * <p>See also: <code>vips_extract_bands</code>, {@link #smartcrop}.</p>
   * @param left Left edge of extract area
   * @param top Top edge of extract area
   * @param width Width of extract area
   * @param height Height of extract area
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Extract a band or bands from an image. Extracting out of range is an error.</p>
   *
   * <p>See also: <code>vips_extract_area</code>.</p>
   * @param band Band to extract
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg n {@link VipsOption.Int} Number of bands to extract
   */
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

  /**
   * <p>Create a test pattern with increasing spatial frequency in X and
   * amplitude in Y. {@optionalArg factor} should be between 0 and 1 and determines the
   * maximum spatial frequency.</p>
   *
   * <p>Set {@optionalArg uchar} to output a uchar image.</p>
   *
   * <p>See also: {@link #zone}.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg factor {@link VipsOption.Double} Maximum spatial frequency
   */
  public VImage eye(int width, int height, VipsOption... args) throws VipsError {
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

  /**
   * <p>Force {@param in} to 1 band, 8-bit, then transform to
   * a 3-band 8-bit image with a false colour
   * map. The map is supposed to make small differences in brightness more
   * obvious.</p>
   *
   * <p>See also: {@link #maplut}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage falsecolour(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "falsecolour", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Calculate a fast correlation surface.</p>
   *
   * <p>{@param ref} is placed at every position in {@param in} and the sum of squares of
   * differences calculated.</p>
   *
   * <p>The output
   * image is the same size as the input. Extra input edge pixels are made by
   * copying the existing edges outwards.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The output type is uint if both inputs are integer, float if both are float
   * or complex, and double if either is double or double complex.
   * In other words, the output type is just large enough to hold the whole
   * range of possible values.</p>
   *
   * <p>See also: {@link #spcor}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage fastcor(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var refOption = VipsOption.Image("ref", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(refOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "fastcor", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Fill outwards from every non-zero pixel in {@param in}, setting pixels in {@optionalArg distance}
   * and <code>@value</code>.</p>
   *
   * <p>At the position of zero pixels in {@param in}, {@optionalArg distance} contains the distance to
   * the nearest non-zero pixel in {@param in}, and <code>@value</code> contains the value of that
   * pixel.</p>
   *
   * <p>{@optionalArg distance} is a one-band float image. <code>@value</code> has the same number of bands and
   * format as {@param in}.</p>
   *
   * <p>See also: <code>vips_hist_find_indexed</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg distance {@link VipsOption.Image} Distance to nearest non-zero pixel
   */
  public VImage fillNearest(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "fill_nearest", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Search {@param in} for the bounding box of the non-background area.</p>
   *
   * <p>Any alpha is flattened out, then the image is median-filtered (unless
   * {@optionalArg lineArt} is set, see below), all the row
   * and column sums of the absolute
   * difference from {@optionalArg background} are calculated in a
   * single pass, then the first row or column in each of the
   * four directions where the sum is greater than {@optionalArg threshold} gives the bounding
   * box.</p>
   *
   * <p>If the image is entirely background, <code>vips_find_trim</code> returns {@param width} == 0
   * and {@param height} == 0.</p>
   *
   * <p>{@optionalArg background} defaults to 255, or 65535 for 16-bit images. Set another value,
   * or use {@link #getpoint} to pick a value from an edge. You'll need to flatten
   * before {@link #getpoint} to get a correct background value.</p>
   *
   * <p>{@optionalArg threshold} defaults to 10.</p>
   *
   * <p>The detector is designed for photographic or compressed images where there
   * is a degree of noise that needs filtering. If your images are synthetic
   * (eg. rendered from vector art, perhaps), set {@optionalArg lineArt} to disable this
   * filtering.</p>
   *
   * <p>The image needs to be at least 3x3 pixels in size.</p>
   *
   * <p>See also: {@link #getpoint}, <code>vips_extract_area</code>, {@link #smartcrop}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg threshold {@link VipsOption.Double} Object threshold
   * @optionalArg background {@link VipsOption.ArrayDouble} Color for background pixels
   * @optionalArg line-art {@link VipsOption.Boolean} Enable line art mode
   */
  public int findTrim(VipsOption... args) throws VipsError {
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
    return leftOption.valueOrThrow();
  }

  /**
   * <p>Read a FITS image file into a VIPS image.</p>
   *
   * <p>This operation can read images with up to three dimensions. Any higher
   * dimensions must be empty.</p>
   *
   * <p>It can read 8, 16 and 32-bit integer images, signed and unsigned, float and
   * double.</p>
   *
   * <p>FITS metadata is attached with the "fits-" prefix.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage fitsload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "fitsload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * Load FITS from a source
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage fitsloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "fitsload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Write a VIPS image to a file in FITS format.</p>
   *
   * <p>See also: <code>vips_image_write_to_file</code>.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void fitssave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "fitssave", callArgs);
  }

  /**
   * <p>Take the last band of {@param in} as an alpha and use it to blend the
   * remaining channels with {@optionalArg background}.</p>
   *
   * <p>The alpha channel is 0 - {@optionalArg maxAlpha}, where {@optionalArg maxAlpha} means 100% image
   * and 0 means 100% background. {@optionalArg background} defaults to zero (black).</p>
   *
   * <p>{@optionalArg maxAlpha} has the default value 255, or 65535 for images tagged as
   * {@link VipsInterpretation#INTERPRETATION_RGB16} or
   * {@link VipsInterpretation#INTERPRETATION_GREY16}.</p>
   *
   * <p>Useful for flattening PNG images to RGB.</p>
   *
   * <p>Non-complex images only.</p>
   *
   * <p>See also: {@link #premultiply}, {@link #pngload}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg max-alpha {@link VipsOption.Double} Maximum value of alpha channel
   */
  public VImage flatten(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "flatten", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Flips an image left-right or up-down.</p>
   *
   * <p>See also: {@link #rot}.</p>
   * @param direction {@link VipsDirection} Direction to flip image
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Convert a three-band float image to Radiance 32-bit packed format.</p>
   *
   * <p>See also: {@link #rad2float}, {@link app.photofox.vipsffm.enums.VipsCoding#CODING_RAD}, {@link #LabQ2Lab}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage float2rad(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "float2rad", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Generate an image of size {@param width} by {@param height} and fractal dimension
   * {@param fractalDimension}. The dimension should be between 2 and 3.</p>
   *
   * <p>See also: {@link #gaussnoise}, <code>vips_mask_fractal</code>.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param fractalDimension Fractal dimension
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage fractsurf(int width, int height, double fractalDimension, VipsOption... args) throws
      VipsError {
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

  /**
   * <p>Multiply {@param in} by {@param mask} in Fourier space.</p>
   *
   * <p>{@param in} is transformed to Fourier space, multiplied with {@param mask}, then
   * transformed back to real space. If {@param in} is already a complex image, just
   * multiply then inverse transform.</p>
   *
   * <p>See also: {@link #invfft}, <code>vips_mask_ideal</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage freqmult(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var maskOption = VipsOption.Image("mask", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(maskOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "freqmult", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Transform an image to Fourier space.</p>
   *
   * <p>VIPS uses the fftw Fourier Transform library. If this library was not
   * available when VIPS was configured, these functions will fail.</p>
   *
   * <p>See also: {@link #invfft}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage fwfft(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "fwfft", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Calculate {@param in} ** (1 / {@optionalArg exponent}), normalising to the maximum range of the
   * input type. For float types use 1.0 as the maximum.</p>
   *
   * <p>See also: {@link #identity}, <code>vips_pow_const1</code>, {@link #maplut}</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg exponent {@link VipsOption.Double} Gamma factor
   */
  public VImage gamma(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "gamma", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operator runs {@link #gaussmat} and {@link #convsep} for you on an image.
   * Set {@optionalArg minAmpl} smaller to generate a larger, more accurate mask. Set {@param sigma}
   * larger to make the blur more blurry.</p>
   *
   * <p>See also: {@link #gaussmat}, {@link #convsep}.</p>
   * @param sigma Sigma of Gaussian
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg min-ampl {@link VipsOption.Double} Minimum amplitude of Gaussian
   * @optionalArg precision {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPrecision} Convolve with this precision
   */
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

  /**
   * <p>Creates a circularly symmetric Gaussian image of radius
   * {@param sigma}.  The size of the mask is determined by the variable {@param minAmpl};
   * if for instance the value .1 is entered this means that the produced mask
   * is clipped at values less than 10 percent of the maximum amplitude.</p>
   *
   * <p>The program uses the following equation:
   *
   *  H(r) = exp(-(r * r) / (2 * {@param sigma} * {@param sigma}))</p>
   *
   * <p>The generated image has odd size and its maximum value is normalised to
   * 1.0, unless {@optionalArg precision} is {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER}.</p>
   *
   * <p>If {@optionalArg separable} is set, only the centre horizontal is generated. This is
   * useful for separable convolutions.</p>
   *
   * <p>If {@optionalArg precision} is {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER}, an integer gaussian is generated.
   * This is useful for integer convolutions.</p>
   *
   * <p>"scale" is set to the sum of all the mask elements.</p>
   *
   * <p>See also: {@link #logmat}, {@link #conv}.</p>
   * @param sigma Sigma of Gaussian
   * @param minAmpl Minimum amplitude of Gaussian
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg separable {@link VipsOption.Boolean} Generate separable Gaussian
   * @optionalArg integer {@link VipsOption.Boolean} Generate integer Gaussian
   * @optionalArg precision {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPrecision} Generate with this precision
   */
  public VImage gaussmat(double sigma, double minAmpl, VipsOption... args) throws VipsError {
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

  /**
   * <p>Make a one band float image of gaussian noise with the specified
   * distribution. The noise distribution is created by averaging 12 random
   * numbers with the appropriate weights.</p>
   *
   * <p>See also: {@link #black}, {@link #xyz}, {@link #text}.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg sigma {@link VipsOption.Double} Standard deviation of pixels in generated image
   * @optionalArg mean {@link VipsOption.Double} Mean of pixels in generated image
   * @optionalArg seed {@link VipsOption.Int} Random number seed
   */
  public VImage gaussnoise(int width, int height, VipsOption... args) throws VipsError {
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

  /**
   * <p>Reads a single pixel on an image.</p>
   *
   * <p>The pixel values are returned in <code>@vector</code>, the length of the
   * array in <code>@n</code>. You must free the array with g_free() when you are done with
   * it.</p>
   *
   * <p>See also: <code>vips_draw_point</code>.</p>
   * @param x Point to read
   * @param y Point to read
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Read a GIF file into a libvips image.</p>
   *
   * <p>Use {@optionalArg page} to select a page to render, numbering from zero.</p>
   *
   * <p>Use {@optionalArg n} to select the number of pages to render. The default is 1. Pages are
   * rendered in a vertical column. Set to -1 to mean "until the end of the
   * document". Use {@link #grid} to change page layout.</p>
   *
   * <p>Use {@optionalArg failOn} to set the type of error that will cause load to fail. By
   * default, loaders are permissive, that is, {@link app.photofox.vipsffm.enums.VipsFailOn#FAIL_ON_NONE}.</p>
   *
   * <p>The output image is RGBA for GIFs containing transparent elements, RGB
   * otherwise.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage gifload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "gifload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #gifload}, but read from a memory buffer.</p>
   *
   * <p>You must not free the buffer while {@param out} is active. The
   * #VipsObject::postclose signal on {@param out} is a good place to free.</p>
   *
   * <p>See also: {@link #gifload}.</p>
   * @param buffer Buffer to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage gifloadBuffer(VBlob buffer, VipsOption... args) throws VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "gifload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #gifload}, but read from a source.</p>
   *
   * <p>See also: {@link #gifload}.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage gifloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "gifload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Write to a file in GIF format.</p>
   *
   * <p>Use {@optionalArg dither} to set the degree of Floyd-Steinberg dithering
   * and {@optionalArg effort} to control the CPU effort (1 is the fastest,
   * 10 is the slowest, 7 is the default).</p>
   *
   * <p>Use {@optionalArg bitdepth} (from 1 to 8, default 8) to control the number
   * of colours in the palette. The first entry in the palette is
   * always reserved for transparency. For example, a bitdepth of
   * 4 will allow the output to contain up to 15 colours.</p>
   *
   * <p>Use {@optionalArg interframeMaxerror} to set the threshold below which pixels are
   * considered equal.
   * Pixels which don't change from frame to frame can be made transparent,
   * improving the compression rate. Default 0.</p>
   *
   * <p>Use {@optionalArg interpaletteMaxerror} to set the threshold below which the
   * previously generated palette will be reused.</p>
   *
   * <p>If {@optionalArg reuse} is TRUE, the GIF will be saved with a single global
   * palette taken from the metadata in {@param in}, and no new palette optimisation
   * will be done.</p>
   *
   * <p>If {@optionalArg interlace} is TRUE, the GIF file will be interlaced (progressive GIF).
   * These files may be better for display over a slow network
   * connection, but need more memory to encode.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg dither {@link VipsOption.Double} Amount of dithering
   * @optionalArg effort {@link VipsOption.Int} Quantisation effort
   * @optionalArg bitdepth {@link VipsOption.Int} Number of bits per pixel
   * @optionalArg interframe-maxerror {@link VipsOption.Double} Maximum inter-frame error for transparency
   * @optionalArg reuse {@link VipsOption.Boolean} Reuse palette from input
   * @optionalArg interpalette-maxerror {@link VipsOption.Double} Maximum inter-palette error for palette reusage
   * @optionalArg interlace {@link VipsOption.Boolean} Generate an interlaced (progressive) GIF
   * @optionalArg reoptimise {@link VipsOption.Boolean} Reoptimise colour palettes
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void gifsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "gifsave", callArgs);
  }

  /**
   * <p>As {@link #gifsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in <code>@buf</code>, the length of the buffer in
   * <code>@len</code>. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link #gifsave}, <code>vips_image_write_to_file</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg dither {@link VipsOption.Double} Amount of dithering
   * @optionalArg effort {@link VipsOption.Int} Quantisation effort
   * @optionalArg bitdepth {@link VipsOption.Int} Number of bits per pixel
   * @optionalArg interframe-maxerror {@link VipsOption.Double} Maximum inter-frame error for transparency
   * @optionalArg reuse {@link VipsOption.Boolean} Reuse palette from input
   * @optionalArg interpalette-maxerror {@link VipsOption.Double} Maximum inter-palette error for palette reusage
   * @optionalArg interlace {@link VipsOption.Boolean} Generate an interlaced (progressive) GIF
   * @optionalArg reoptimise {@link VipsOption.Boolean} Reoptimise colour palettes
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public VBlob gifsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "gifsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /**
   * <p>As {@link #gifsave}, but save to a target.</p>
   *
   * <p>See also: {@link #gifsave}, <code>vips_image_write_to_target</code>.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg dither {@link VipsOption.Double} Amount of dithering
   * @optionalArg effort {@link VipsOption.Int} Quantisation effort
   * @optionalArg bitdepth {@link VipsOption.Int} Number of bits per pixel
   * @optionalArg interframe-maxerror {@link VipsOption.Double} Maximum inter-frame error for transparency
   * @optionalArg reuse {@link VipsOption.Boolean} Reuse palette from input
   * @optionalArg interpalette-maxerror {@link VipsOption.Double} Maximum inter-palette error for palette reusage
   * @optionalArg interlace {@link VipsOption.Boolean} Generate an interlaced (progressive) GIF
   * @optionalArg reoptimise {@link VipsOption.Boolean} Reoptimise colour palettes
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void gifsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "gifsave_target", callArgs);
  }

  /**
   * <p>globalbalance can be used to remove contrast differences in
   * an assembled mosaic.</p>
   *
   * <p>It reads the History field attached to {@param in} and builds a list of the source
   * images that were used to make the mosaic and the position that each ended
   * up at in the final image.</p>
   *
   * <p>It opens each of the source images in turn and extracts all parts which
   * overlap with any of the other images. It finds the average values in the
   * overlap areas and uses least-mean-square to find a set of correction
   * factors which will minimise overlap differences. It uses {@optionalArg gamma} to
   * gamma-correct the source images before calculating the factors. A value of
   * 1.0 will stop this.</p>
   *
   * <p>Each of the source images is transformed with the appropriate correction
   * factor, then the mosaic is reassembled. {@param out} is {@link VipsBandFormat#FORMAT_FLOAT}, but
   * if {@optionalArg intOutput} is set, the output image is the same format as the input
   * images.</p>
   *
   * <p>There are some conditions that must be met before this operation can work:
   * the source images must all be present under the filenames recorded in the
   * history on {@param in}, and the mosaic must have been built using only operations in
   * this package.</p>
   *
   * <p>See also: <code>vips_remosaic</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg gamma {@link VipsOption.Double} Image gamma
   * @optionalArg int-output {@link VipsOption.Boolean} Integer output
   */
  public VImage globalbalance(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "globalbalance", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>The opposite of <code>vips_extract_area</code>: place {@param in} within an image of size
   * {@param width} by {@param height} at a certain gravity.</p>
   *
   * <p>{@optionalArg extend}
   * controls what appears in the new pels, see #VipsExtend.</p>
   *
   * <p>See also: <code>vips_extract_area</code>, {@link #insert}.</p>
   * @param direction {@link VipsCompassDirection} Direction to place image within width/height
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg extend {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsExtend} How to generate the extra pixels
   * @optionalArg background {@link VipsOption.ArrayDouble} Color for background pixels
   */
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

  /**
   * <p>Create a one-band float image with the left-most column zero and the
   * right-most 1. Intermediate pixels are a linear ramp.</p>
   *
   * <p>Set {@optionalArg uchar} to output a uchar image with the leftmost pixel 0 and the
   * rightmost 255.</p>
   *
   * <p>See also: {@link #xyz}, {@link #identity}.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   */
  public VImage grey(int width, int height, VipsOption... args) throws VipsError {
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

  /**
   * <p>Chop a tall thin image up into a set of tiles, lay the tiles out in a grid.</p>
   *
   * <p>The input image should be a very tall, thin image containing a list of
   * smaller images. Volumetric or time-sequence images are often laid out like
   * this. This image is chopped into a series of tiles, each {@param tileHeight}
   * pixels high and the width of {@param in}. The tiles are then rearranged into a grid
   * {@param across} tiles across and {@param down} tiles down in row-major order.</p>
   *
   * <p>Supplying {@param tileHeight}, {@param across} and {@param down} is not strictly necessary, we
   * only really need two of these. Requiring three is a double-check that the
   * image has the expected geometry.</p>
   *
   * <p>See also: {@link #embed}, {@link #insert}, {@link #join}.</p>
   * @param tileHeight Chop into tiles this high
   * @param across Number of tiles across
   * @param down Number of tiles down
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Read a HEIF image file into a VIPS image.</p>
   *
   * <p>Use {@optionalArg page} to select a page to render, numbering from zero. If neither {@optionalArg n}
   * nor {@optionalArg page} are set, {@optionalArg page} defaults to the primary page, otherwise to 0.</p>
   *
   * <p>Use {@optionalArg n} to select the number of pages to render. The default is 1. Pages are
   * rendered in a vertical column. Set to -1 to mean "until the end of the
   * document". Use {@link #grid} to reorganise pages.</p>
   *
   * <p>HEIF images have a primary image. The metadata item `heif-primary` gives
   * the page number of the primary.</p>
   *
   * <p>If {@optionalArg thumbnail} is <code>TRUE</code>, then fetch a stored thumbnail rather than the
   * image.</p>
   *
   * <p>By default, input image dimensions are limited to 16384x16384.
   * If {@optionalArg unlimited} is <code>TRUE</code>, this increases to the maximum of 65535x65535.</p>
   *
   * <p>The bitdepth of the heic image is recorded in the metadata item
   * `heif-bitdepth`.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg thumbnail {@link VipsOption.Boolean} Fetch thumbnail image
   * @optionalArg autorotate {@link VipsOption.Boolean} Rotate image using exif orientation
   * @optionalArg unlimited {@link VipsOption.Boolean} Remove all denial of service limits
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage heifload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "heifload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Read a HEIF image file into a VIPS image.
   * Exactly as {@link #heifload}, but read from a memory buffer.</p>
   *
   * <p>You must not free the buffer while {@param out} is active. The
   * #VipsObject::postclose signal on {@param out} is a good place to free.</p>
   *
   * <p>See also: {@link #heifload}.</p>
   * @param buffer Buffer to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg thumbnail {@link VipsOption.Boolean} Fetch thumbnail image
   * @optionalArg autorotate {@link VipsOption.Boolean} Rotate image using exif orientation
   * @optionalArg unlimited {@link VipsOption.Boolean} Remove all denial of service limits
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage heifloadBuffer(VBlob buffer, VipsOption... args) throws VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "heifload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #heifload}, but read from a source.</p>
   *
   * <p>See also: {@link #heifload}.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg thumbnail {@link VipsOption.Boolean} Fetch thumbnail image
   * @optionalArg autorotate {@link VipsOption.Boolean} Rotate image using exif orientation
   * @optionalArg unlimited {@link VipsOption.Boolean} Remove all denial of service limits
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage heifloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "heifload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Write a VIPS image to a file in HEIF format.</p>
   *
   * <p>Use {@optionalArg Q} to set the compression factor. Default 50, which seems to be roughly
   * what the iphone uses. Q 30 gives about the same quality as JPEG Q 75.</p>
   *
   * <p>Set {@optionalArg lossless} <code>TRUE</code> to switch to lossless compression.</p>
   *
   * <p>Use {@optionalArg compression} to set the compression format e.g. HEVC, AVC, AV1 to use. It defaults to AV1
   * if the target filename ends with ".avif", otherwise HEVC.</p>
   *
   * <p>Use {@optionalArg effort} to control the CPU effort spent improving compression.
   * This is currently only applicable to AV1 encoders. Defaults to 4, 0 is
   * fastest, 9 is slowest.</p>
   *
   * <p>Chroma subsampling is normally automatically disabled for Q &ge; 90. You can
   * force the subsampling mode with {@optionalArg subsampleMode}.</p>
   *
   * <p>Use {@optionalArg bitdepth} to set the bitdepth of the output file. HEIC supports at
   * least 8, 10 and 12 bits; other codecs may support more or fewer options.</p>
   *
   * <p>Use {@optionalArg encoder} to set the encode library to use, e.g. aom, SVT-AV1, rav1e etc.</p>
   *
   * <p>See also: <code>vips_image_write_to_file</code>, {@link #heifload}.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg bitdepth {@link VipsOption.Int} Number of bits per pixel
   * @optionalArg lossless {@link VipsOption.Boolean} Enable lossless compression
   * @optionalArg compression {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignHeifCompression} Compression format
   * @optionalArg effort {@link VipsOption.Int} CPU effort
   * @optionalArg subsample-mode {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignSubsample} Select chroma subsample operation mode
   * @optionalArg speed {@link VipsOption.Int} CPU effort
   * @optionalArg encoder {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignHeifEncoder} Select encoder to use
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void heifsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "heifsave", callArgs);
  }

  /**
   * <p>As {@link #heifsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in <code>@obuf</code>, the length of the buffer in
   * <code>@olen</code>. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link #heifsave}, <code>vips_image_write_to_file</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg bitdepth {@link VipsOption.Int} Number of bits per pixel
   * @optionalArg lossless {@link VipsOption.Boolean} Enable lossless compression
   * @optionalArg compression {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignHeifCompression} Compression format
   * @optionalArg effort {@link VipsOption.Int} CPU effort
   * @optionalArg subsample-mode {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignSubsample} Select chroma subsample operation mode
   * @optionalArg speed {@link VipsOption.Int} CPU effort
   * @optionalArg encoder {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignHeifEncoder} Select encoder to use
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public VBlob heifsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "heifsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /**
   * <p>As {@link #heifsave}, but save to a target.</p>
   *
   * <p>See also: {@link #heifsave}, <code>vips_image_write_to_target</code>.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg bitdepth {@link VipsOption.Int} Number of bits per pixel
   * @optionalArg lossless {@link VipsOption.Boolean} Enable lossless compression
   * @optionalArg compression {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignHeifCompression} Compression format
   * @optionalArg effort {@link VipsOption.Int} CPU effort
   * @optionalArg subsample-mode {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignSubsample} Select chroma subsample operation mode
   * @optionalArg speed {@link VipsOption.Int} CPU effort
   * @optionalArg encoder {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignHeifEncoder} Select encoder to use
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void heifsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "heifsave_target", callArgs);
  }

  /**
   * <p>Form cumulative histogram.</p>
   *
   * <p>See also: <code>vips_hist_norm</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage histCum(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_cum", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Estimate image entropy from a histogram. Entropy is calculated as:</p>
   *
   * <pre>{@code 
   * -sum(p * log2(p))
   * }</pre>
   *
   * <p>where p is histogram-value / sum-of-histogram-values.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public double histEntropy(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Double("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_entropy", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Histogram-equalise {@param in}. Equalise using band <code>@bandno</code>, or if <code>@bandno</code> is -1,
   * equalise bands independently. The output format is always the same as the
   * input format.</p>
   *
   * <p>See also:</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg band {@link VipsOption.Int} Equalise with this band
   */
  public VImage histEqual(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_equal", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Find the histogram of {@param in}. Find the histogram for band {@optionalArg band} (producing a
   * one-band histogram), or for all bands (producing an n-band histogram) if
   * {@optionalArg band} is -1.</p>
   *
   * <p>char and uchar images are cast to uchar before histogramming, all other
   * image types are cast to ushort.</p>
   *
   * <p>See also: <code>vips_hist_find_ndim</code>, <code>vips_hist_find_indexed</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg band {@link VipsOption.Int} Find histogram of band
   */
  public VImage histFind(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_find", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Make a histogram of {@param in}, but use image {@param index} to pick the bins. In other
   * words, element zero in {@param out} contains the combination of all the pixels in {@param in}
   * whose corresponding pixel in {@param index} is zero.</p>
   *
   * <p>char and uchar {@param index} images are cast to uchar before histogramming, all
   * other image types are cast to ushort. {@param index} must have just one band.</p>
   *
   * <p>{@param in} must be non-complex.</p>
   *
   * <p>{@param out} always has the same size and format as {@param in}.</p>
   *
   * <p>Normally, bins are summed, but you can use {@optionalArg combine} to set other combine
   * modes.</p>
   *
   * <p>This operation is useful in conjunction with {@link #labelregions}. You can
   * use it to find the centre of gravity of blobs in an image, for example.</p>
   *
   * <p>See also: <code>vips_hist_find</code>, {@link #labelregions}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg combine {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsCombine} Combine bins like this
   */
  public VImage histFindIndexed(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var indexOption = VipsOption.Image("index", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(indexOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_find_indexed", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Make a one, two or three dimensional histogram of a 1, 2 or
   * 3 band image. Divide each axis into {@optionalArg bins} bins .. ie.
   * output is 1 x bins, bins x bins, or bins x bins x bins bands.
   * {@optionalArg bins} defaults to 10.</p>
   *
   * <p>char and uchar images are cast to uchar before histogramming, all other
   * image types are cast to ushort.</p>
   *
   * <p>See also: <code>vips_hist_find</code>, <code>vips_hist_find_indexed</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg bins {@link VipsOption.Int} Number of bins in each dimension
   */
  public VImage histFindNdim(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_find_ndim", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Test {@param in} for monotonicity. <code>@out</code> is set non-zero if {@param in} is monotonic.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public boolean histIsmonotonic(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var monotonicOption = VipsOption.Boolean("monotonic");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(monotonicOption);
    VipsInvoker.invokeOperation(arena, "hist_ismonotonic", callArgs);
    return monotonicOption.valueOrThrow();
  }

  /**
   * <p>Performs local histogram equalisation on {@param in} using a
   * window of size {@param width} by {@param height} centered on the input pixel.</p>
   *
   * <p>The output image is the same size as the input image. The edge pixels are
   * created by mirroring the input image outwards.</p>
   *
   * <p>If {@optionalArg maxSlope} is greater than 0, it sets the maximum value for the slope of
   * the cumulative histogram, that is, the maximum brightening that is
   * performed. A value of 3 is often used. Local histogram equalization with
   * contrast limiting is usually called CLAHE.</p>
   *
   * <p>See also: <code>vips_hist_equal</code>.</p>
   * @param width Window width in pixels
   * @param height Window height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg max-slope {@link VipsOption.Int} Maximum slope (CLAHE)
   */
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

  /**
   * <p>Adjust {@param in} to match {@param ref}. If {@param in} and {@param ref} are normalised
   * cumulative histograms, {@param out} will be a LUT that adjusts the PDF of the image
   * from which {@param in} was made to match the PDF of {@param ref}'s image.</p>
   *
   * <p>See also: {@link #maplut}, <code>vips_hist_find</code>, <code>vips_hist_norm</code>,
   * <code>vips_hist_cum</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage histMatch(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var refOption = VipsOption.Image("ref", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(refOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_match", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Normalise histogram. The maximum of each band becomes equal to the maximum
   * index, so for example the max for a uchar image becomes 255.
   * Normalise each band separately.</p>
   *
   * <p>See also: <code>vips_hist_cum</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage histNorm(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_norm", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Plot a 1 by any or any by 1 image file as a max by any or
   * any by max image using these rules:</p>
   *
   * <p><b>unsigned char</b> max is always 256</p>
   *
   * <p><b>other unsigned integer types</b> output 0 - maximum
   * value of {@param in}.</p>
   *
   * <p><b>signed int types</b> min moved to 0, max moved to max + min.</p>
   *
   * <p><b>float types</b> min moved to 0, max moved to any
   * (square output)</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage histPlot(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hist_plot", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Find the circular Hough transform of an image. {@param in} must be one band, with
   * non-zero pixels for image edges. {@param out} is three-band, with the third channel
   * representing the detected circle radius. The operation scales the number of
   * votes by circle circumference so circles of differing size are given equal
   * weight.</p>
   *
   * <p>The output pixel at (x, y, band) is the strength of the circle centred on
   * (x, y) and with radius (band).</p>
   *
   * <p>Use {@optionalArg maxRadius} and {@optionalArg minRadius} to set the range of radii to search for.</p>
   *
   * <p>Use {@optionalArg scale} to set how {@param in} coordinates are scaled to {@param out} coordinates. A
   * {@optionalArg scale} of 3, for example, will make {@param out} 1/3rd of the width and height of
   * {@param in}, and reduce the number of radii tested (and hence the number of bands
   * int {@param out}) by a factor of three as well.</p>
   *
   * <p>See also: <code>vips_hough_line</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg scale {@link VipsOption.Int} Scale down dimensions by this factor
   * @optionalArg min-radius {@link VipsOption.Int} Smallest radius to search for
   * @optionalArg max-radius {@link VipsOption.Int} Largest radius to search for
   */
  public VImage houghCircle(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hough_circle", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Find the line Hough transform for {@param in}. {@param in} must have one band. {@param out} has one
   * band, with pixels being the number of votes for that line. The X dimension
   * of {@param out} is the line angle in 0 - 180 degrees, the Y dimension is the
   * distance of the closest part of that line to the origin in the top-left.</p>
   *
   * <p>Use {@optionalArg width} {@optionalArg height} to set the size of the parameter space image ({@param out}),
   * that is, how accurate the line determination should be.</p>
   *
   * <p>See also: <code>vips_hough_circle</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg width {@link VipsOption.Int} Horizontal size of parameter space
   * @optionalArg height {@link VipsOption.Int} Vertical size of parameter space
   */
  public VImage houghLine(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "hough_line", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Export an image from D65 LAB to device space with an ICC profile.
   * If {@optionalArg pcs} is
   * set to {@link app.photofox.vipsffm.enums.VipsPCS#PCS_XYZ}, use CIE XYZ PCS instead.
   * If {@optionalArg outputProfile} is not set, use the embedded profile, if any.
   * If {@optionalArg outputProfile} is set, export with that and attach it to the output
   * image.</p>
   *
   * <p>If {@optionalArg blackPointCompensation} is set, LCMS black point compensation is
   * enabled.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg pcs {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPCS} Set Profile Connection Space
   * @optionalArg intent {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsIntent} Rendering intent
   * @optionalArg black-point-compensation {@link VipsOption.Boolean} Enable black point compensation
   * @optionalArg output-profile {@link VipsOption.String} Filename to load output profile from
   * @optionalArg depth {@link VipsOption.Int} Output device space depth in bits
   */
  public VImage iccExport(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "icc_export", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Import an image from device space to D65 LAB with an ICC profile. If {@optionalArg pcs} is
   * set to {@link app.photofox.vipsffm.enums.VipsPCS#PCS_XYZ}, use CIE XYZ PCS instead.</p>
   *
   * <p>The input profile is searched for in three places:
   *
   *  1. If {@optionalArg embedded} is set, libvips will try to use any profile in the input
   *   image metadata. You can test for the presence of an embedded profile
   *   with <code>vips_image_get_typeof</code> with <code>VIPS_META_ICC_NAME</code> as an argument.
   *   This will return <code>GType</code> 0 if there is no profile.
   *
   *  2. Otherwise, if {@optionalArg inputProfile} is set, libvips will try to load a
   *   profile from the named file. This can aslso be the name of one of the
   *   built-in profiles.
   *
   *  3. Otherwise, libvips will try to pick a compatible profile from the set
   *   of built-in profiles.</p>
   *
   * <p>If {@optionalArg blackPointCompensation} is set, LCMS black point compensation is
   * enabled.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg pcs {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPCS} Set Profile Connection Space
   * @optionalArg intent {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsIntent} Rendering intent
   * @optionalArg black-point-compensation {@link VipsOption.Boolean} Enable black point compensation
   * @optionalArg embedded {@link VipsOption.Boolean} Use embedded input profile, if available
   * @optionalArg input-profile {@link VipsOption.String} Filename to load input profile from
   */
  public VImage iccImport(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "icc_import", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Transform an image with a pair of ICC profiles. The input image is moved to
   * profile-connection space with the input profile and then to the output
   * space with the output profile.</p>
   *
   * <p>The input profile is searched for in three places:
   *
   *  1. If {@optionalArg embedded} is set, libvips will try to use any profile in the input
   *   image metadata. You can test for the presence of an embedded profile
   *   with <code>vips_image_get_typeof</code> with <code>VIPS_META_ICC_NAME</code> as an argument.
   *   This will return <code>GType</code> 0 if there is no profile.
   *
   *  2. Otherwise, if {@optionalArg inputProfile} is set, libvips will try to load a
   *   profile from the named file. This can aslso be the name of one of the
   *   built-in profiles.
   *
   *  3. Otherwise, libvips will try to pick a compatible profile from the set
   *   of built-in profiles.</p>
   *
   * <p>If {@optionalArg blackPointCompensation} is set, LCMS black point compensation is
   * enabled.</p>
   *
   * <p>{@optionalArg depth} defaults to 8, or 16 if {@param in} is a 16-bit image.</p>
   *
   * <p>The output image has the output profile attached to the <code>VIPS_META_ICC_NAME</code>
   * field.</p>
   *
   * <p>Use <code>vips_icc_import</code> and <code>vips_icc_export</code> to do either the first or
   * second half of this operation in isolation.</p>
   * @param outputProfile Filename to load output profile from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg pcs {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPCS} Set Profile Connection Space
   * @optionalArg intent {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsIntent} Rendering intent
   * @optionalArg black-point-compensation {@link VipsOption.Boolean} Enable black point compensation
   * @optionalArg embedded {@link VipsOption.Boolean} Use embedded input profile, if available
   * @optionalArg input-profile {@link VipsOption.String} Filename to load input profile from
   * @optionalArg depth {@link VipsOption.Int} Output device space depth in bits
   */
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

  /**
   * <p>Creates an identity lookup table, ie. one which will leave an image
   * unchanged when applied with {@link #maplut}. Each entry in the table has a
   * value equal to its position.</p>
   *
   * <p>Use the arithmetic operations on these tables to make LUTs representing
   * arbitrary functions.</p>
   *
   * <p>Normally LUTs are 8-bit. Set {@optionalArg ushort} to create a 16-bit table.</p>
   *
   * <p>Normally 16-bit tables have 65536 entries. You can set this smaller with
   * {@optionalArg size}.</p>
   *
   * <p>See also: {@link #xyz}, {@link #maplut}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg bands {@link VipsOption.Int} Number of bands in LUT
   * @optionalArg ushort {@link VipsOption.Boolean} Create a 16-bit LUT
   * @optionalArg size {@link VipsOption.Int} Size of 16-bit LUT
   */
  public VImage identity(VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "identity", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation scans the condition image {@param cond}
   * and uses it to select pixels from either the then image {@param in1} or the else
   * image {@param in2}. Non-zero means {@param in1}, 0 means {@param in2}.</p>
   *
   * <p>Any image can have either 1 band or n bands, where n is the same for all
   * the non-1-band images. Single band images are then effectively copied to
   * make n-band images.</p>
   *
   * <p>Images {@param in1} and {@param in2} are cast up to the smallest common format. {@param cond} is
   * cast to uchar.</p>
   *
   * <p>If the images differ in size, the smaller images are enlarged to match the
   * largest by adding zero pixels along the bottom and right.</p>
   *
   * <p>If {@optionalArg blend} is <code>TRUE</code>, then values in {@param out} are smoothly blended between {@param in1}
   * and {@param in2} using the formula:
   *
   *  {@param out} = ({@param cond} / 255) * {@param in1} + (1 - {@param cond} / 255) * {@param in2}</p>
   *
   * <p>See also: <code>vips_equal</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg blend {@link VipsOption.Boolean} Blend smoothly between then and else parts
   */
  public VImage ifthenelse(VipsOption... args) throws VipsError {
    var condOption = VipsOption.Image("cond", this);
    var in1Option = VipsOption.Image("in1", this);
    var in2Option = VipsOption.Image("in2", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(condOption);
    callArgs.add(in1Option);
    callArgs.add(in2Option);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "ifthenelse", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Insert {@param sub} into {@param main} at position {@param x}, {@param y}.</p>
   *
   * <p>Normally {@param out} shows the whole of {@param main}. If {@optionalArg expand} is #TRUE then {@param out} is
   * made large enough to hold all of {@param main} and {@param sub}.
   * Any areas of {@param out} not coming from
   * either {@param main} or {@param sub} are set to {@optionalArg background} (default 0).</p>
   *
   * <p>If {@param sub} overlaps {@param main},
   * {@param sub} will appear on top of {@param main}.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common type (see table
   * Smallest common format in
   * <code>arithmetic</code>).</p>
   *
   * <p>See also: {@link #join}, {@link #embed}, <code>vips_extract_area</code>.</p>
   * @param x Left edge of sub in main
   * @param y Top edge of sub in main
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg expand {@link VipsOption.Boolean} Expand output to hold all of both inputs
   * @optionalArg background {@link VipsOption.ArrayDouble} Color for new pixels
   */
  public VImage insert(int x, int y, VipsOption... args) throws VipsError {
    var mainOption = VipsOption.Image("main", this);
    var subOption = VipsOption.Image("sub", this);
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

  /**
   * <p>For unsigned formats, this operation calculates (max - {@param in}), eg. (255 -
   * {@param in}) for uchar. For signed and float formats, this operation calculates (-1
   * {@param in}).</p>
   *
   * <p>For complex images, only the real part is inverted. See also <code>vips_conj</code>.</p>
   *
   * <p>See also: {@link #linear}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage invert(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "invert", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Given a mask of target values and real values, generate a LUT which
   * will map reals to targets. Handy for linearising images from
   * measurements of a colour chart. All values in [0,1]. Piecewise linear
   * interpolation, extrapolate head and tail to 0 and 1.</p>
   *
   * <p>Eg. input like this:</p>
   *
   * <pre>{@code 
   *     |-------|-------|-------|-------|
   *     | 0.1   | 0.2   | 0.3   | 0.1   |
   *     |-------|-------|-------|-------|
   *     | 0.2   | 0.4   | 0.4   | 0.2   |
   *     |-------|-------|-------|-------|
   *     | 0.7   | 0.5   | 0.6   | 0.3   |
   *     |-------|-------|-------|-------|
   * }</pre>
   *
   * <p>Means a patch with 10% reflectance produces an image with 20% in
   * channel 1, 30% in channel 2, and 10% in channel 3, and so on.</p>
   *
   * <p>Inputs don't need to be sorted (we do that). Generate any precision
   * LUT, default to 256 elements.</p>
   *
   * <p>It won't work too well for non-monotonic camera responses
   * (we should fix this). Interpolation is simple piecewise linear; we ought to
   * do something better really.</p>
   *
   * <p>See also: {@link #buildlut}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg size {@link VipsOption.Int} LUT size to generate
   */
  public VImage invertlut(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "invertlut", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Transform an image from Fourier space to real space. The result is complex.
   * If you are OK with a real result, set {@optionalArg real}, it's quicker.</p>
   *
   * <p>VIPS uses the fftw Fourier Transform library. If this library was not
   * available when VIPS was configured, these functions will fail.</p>
   *
   * <p>See also: {@link #fwfft}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg real {@link VipsOption.Boolean} Output only the real part of the transform
   */
  public VImage invfft(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "invfft", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Join {@param in1} and {@param in2} together, left-right or up-down depending on the value
   * of {@param direction}.</p>
   *
   * <p>If one is taller or wider than the
   * other, {@param out} will be has high as the smaller. If {@optionalArg expand} is <code>TRUE</code>, then
   * the output will be expanded to contain all of the input pixels.</p>
   *
   * <p>Use {@optionalArg align} to set the edge that the images align on. By default, they align
   * on the edge with the lower value coordinate.</p>
   *
   * <p>Use {@optionalArg background} to set the colour of any pixels in {@param out} which are not
   * present in either {@param in1} or {@param in2}.</p>
   *
   * <p>Use {@optionalArg shim} to set the spacing between the images. By default this is 0.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common type (see table
   * Smallest common format in
   * <code>arithmetic</code>).</p>
   *
   * <p>If you are going to be joining many thousands of images in a regular
   * grid, {@link #arrayjoin} is a better choice.</p>
   *
   * <p>See also: {@link #arrayjoin}, {@link #insert}.</p>
   * @param direction {@link VipsDirection} Join left-right or up-down
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg expand {@link VipsOption.Boolean} Expand output to hold all of both inputs
   * @optionalArg shim {@link VipsOption.Int} Pixels between images
   * @optionalArg background {@link VipsOption.ArrayDouble} Colour for new pixels
   * @optionalArg align {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAlign} Align on the low, centre or high coordinate edge
   */
  public VImage join(VipsDirection direction, VipsOption... args) throws VipsError {
    var in1Option = VipsOption.Image("in1", this);
    var in2Option = VipsOption.Image("in2", this);
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

  /**
   * <p>Read a JPEG2000 image. The loader supports 8, 16 and 32-bit int pixel
   * values, signed and unsigned. It supports greyscale, RGB, YCC, CMYK and
   * multispectral colour spaces. It will read any ICC profile on the image.</p>
   *
   * <p>It will only load images where all channels have the same format.</p>
   *
   * <p>Use {@optionalArg page} to set the page to load, where page 0 is the base resolution
   * image and higher-numbered pages are x2 reductions. Use the metadata item
   * "n-pages" to find the number of pyramid layers.</p>
   *
   * <p>Use {@optionalArg failOn} to set the type of error that will cause load to fail. By
   * default, loaders are permissive, that is, {@link app.photofox.vipsffm.enums.VipsFailOn#FAIL_ON_NONE}.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} Load this page from the image
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage jp2kload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jp2kload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #jp2kload}, but read from a buffer.</p>
   *
   * <p>You must not free the buffer while {@param out} is active. The
   * #VipsObject::postclose signal on {@param out} is a good place to free.</p>
   * @param buffer Buffer to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} Load this page from the image
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage jp2kloadBuffer(VBlob buffer, VipsOption... args) throws VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jp2kload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #jp2kload}, but read from a source.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} Load this page from the image
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage jp2kloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jp2kload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Write a VIPS image to a file in JPEG2000 format.
   * The saver supports 8, 16 and 32-bit int pixel
   * values, signed and unsigned. It supports greyscale, RGB, CMYK and
   * multispectral images.</p>
   *
   * <p>Use {@optionalArg Q} to set the compression quality factor. The default value
   * produces file with approximately the same size as regular JPEG Q 75.</p>
   *
   * <p>Set {@optionalArg lossless} to enable lossless compression.</p>
   *
   * <p>Use {@optionalArg tileWidth} and {@optionalArg tileHeight} to set the tile size. The default is 512.</p>
   *
   * <p>Chroma subsampling is normally disabled for compatibility. Set
   * {@optionalArg subsampleMode} to auto to enable chroma subsample for Q &lt; 90. Subsample
   * mode uses YCC rather than RGB colourspace, and many jpeg2000 decoders do
   * not support this.</p>
   *
   * <p>This operation always writes a pyramid.</p>
   *
   * <p>See also: <code>vips_image_write_to_file</code>, {@link #jp2kload}.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg tile-width {@link VipsOption.Int} Tile width in pixels
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg lossless {@link VipsOption.Boolean} Enable lossless compression
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg subsample-mode {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignSubsample} Select chroma subsample operation mode
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void jp2ksave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "jp2ksave", callArgs);
  }

  /**
   * <p>As {@link #jp2ksave}, but save to a target.</p>
   *
   * <p>See also: {@link #jp2ksave}, <code>vips_image_write_to_target</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg tile-width {@link VipsOption.Int} Tile width in pixels
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg lossless {@link VipsOption.Boolean} Enable lossless compression
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg subsample-mode {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignSubsample} Select chroma subsample operation mode
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public VBlob jp2ksaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "jp2ksave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /**
   * <p>As {@link #jp2ksave}, but save to a target.</p>
   *
   * <p>See also: {@link #jp2ksave}, <code>vips_image_write_to_target</code>.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg tile-width {@link VipsOption.Int} Tile width in pixels
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg lossless {@link VipsOption.Boolean} Enable lossless compression
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg subsample-mode {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignSubsample} Select chroma subsample operation mode
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void jp2ksaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "jp2ksave_target", callArgs);
  }

  /**
   * <p>Read a JPEG file into a VIPS image. It can read most 8-bit JPEG images,
   * including CMYK and YCbCr.</p>
   *
   * <p>{@optionalArg shrink} means shrink by this integer factor during load.  Possible values
   * are 1, 2, 4 and 8. Shrinking during read is very much faster than
   * decompressing the whole image and then shrinking later.</p>
   *
   * <p>Use {@optionalArg failOn} to set the type of error that will cause load to fail. By
   * default, loaders are permissive, that is, {@link app.photofox.vipsffm.enums.VipsFailOn#FAIL_ON_NONE}.</p>
   *
   * <p>Setting {@optionalArg autorotate} to <code>TRUE</code> will make the loader interpret the
   * orientation tag and automatically rotate the image appropriately during
   * load.</p>
   *
   * <p>If {@optionalArg autorotate} is <code>FALSE</code>, the metadata field <code>VIPS_META_ORIENTATION</code> is set
   * to the value of the orientation tag. Applications may read and interpret
   * this field
   * as they wish later in processing. See {@link #autorot}. Save
   * operations will use <code>VIPS_META_ORIENTATION</code>, if present, to set the
   * orientation of output images.</p>
   *
   * <p>Example:</p>
   *
   * <pre>{@code 
   * vips_jpegload("fred.jpg", &amp;out,
   *     "shrink", 8,
   *     "fail_on", VIPS_FAIL_ON_TRUNCATED,
   *     NULL);
   * }</pre>
   *
   * <p>Any embedded ICC profiles are ignored: you always just get the RGB from
   * the file. Instead, the embedded profile will be attached to the image as
   * <code>VIPS_META_ICC_NAME</code>. You need to use something like
   * <code>vips_icc_import</code> to get CIE values from the file.</p>
   *
   * <p>EXIF metadata is attached as <code>VIPS_META_EXIF_NAME</code>, IPTC as
   * <code>VIPS_META_IPTC_NAME</code>, and XMP as <code>VIPS_META_XMP_NAME</code>.</p>
   *
   * <p>The int metadata item "jpeg-multiscan" is set to the result of
   * jpeg_has_multiple_scans(). Interlaced jpeg images need a large amount of
   * memory to load, so this field gives callers a chance to handle these
   * images differently.</p>
   *
   * <p>The string-valued field "jpeg-chroma-subsample" gives the chroma subsample
   * in standard notation. 4:4:4 means no subsample, 4:2:0 means YCbCr with
   * Cb and Cr subsampled horizontally and vertically, 4:4:4:4 means a CMYK
   * image with no subsampling.</p>
   *
   * <p>The EXIF thumbnail, if present, is attached to the image as
   * "jpeg-thumbnail-data". See <code>vips_image_get_blob</code>.</p>
   *
   * <p>See also: <code>vips_jpegload_buffer</code>, <code>vips_image_new_from_file</code>, {@link #autorot}.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg shrink {@link VipsOption.Int} Shrink factor on load
   * @optionalArg autorotate {@link VipsOption.Boolean} Rotate image using exif orientation
   * @optionalArg unlimited {@link VipsOption.Boolean} Remove all denial of service limits
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage jpegload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jpegload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>during load</p>
   *
   * <p>Read a JPEG-formatted memory block into a VIPS image. Exactly as
   * {@link #jpegload}, but read from a memory buffer.</p>
   *
   * <p>You must not free the buffer while {@param out} is active. The
   * #VipsObject::postclose signal on {@param out} is a good place to free.</p>
   *
   * <p>See also: {@link #jpegload}.</p>
   * @param buffer Buffer to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg shrink {@link VipsOption.Int} Shrink factor on load
   * @optionalArg autorotate {@link VipsOption.Boolean} Rotate image using exif orientation
   * @optionalArg unlimited {@link VipsOption.Boolean} Remove all denial of service limits
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage jpegloadBuffer(VBlob buffer, VipsOption... args) throws VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jpegload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>during load</p>
   *
   * <p>Read a JPEG-formatted memory block into a VIPS image. Exactly as
   * {@link #jpegload}, but read from a source.</p>
   *
   * <p>See also: {@link #jpegload}.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg shrink {@link VipsOption.Int} Shrink factor on load
   * @optionalArg autorotate {@link VipsOption.Boolean} Rotate image using exif orientation
   * @optionalArg unlimited {@link VipsOption.Boolean} Remove all denial of service limits
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage jpegloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jpegload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Write a VIPS image to a file as JPEG.</p>
   *
   * <p>Use {@optionalArg Q} to set the JPEG compression factor. Default 75.</p>
   *
   * <p>If {@optionalArg optimizeCoding} is set, the Huffman tables are optimized. This is
   * slightly slower and produces slightly smaller files.</p>
   *
   * <p>If {@optionalArg interlace} is set, the jpeg files will be interlaced (progressive jpeg,
   * in jpg parlance). These files may be better for display over a slow network
   * connection, but need much more memory to encode and decode.</p>
   *
   * <p>Chroma subsampling is normally automatically disabled for Q &ge; 90. You can
   * force the subsampling mode with {@optionalArg subsampleMode}.</p>
   *
   * <p>If {@optionalArg trellisQuant} is set and the version of libjpeg supports it
   * (e.g. mozjpeg &ge; 3.0), apply trellis quantisation to each 8x8 block.
   * Reduces file size but increases compression time.</p>
   *
   * <p>If {@optionalArg overshootDeringing} is set and the version of libjpeg supports it
   * (e.g. mozjpeg &ge; 3.0), apply overshooting to samples with extreme values
   * for example 0 and 255 for 8-bit. Overshooting may reduce ringing artifacts
   * from compression, in particular in areas where black text appears on a
   * white background.</p>
   *
   * <p>If {@optionalArg optimizeScans} is set and the version of libjpeg supports it
   * (e.g. mozjpeg &ge; 3.0), split the spectrum of DCT coefficients into
   * separate scans. Reduces file size but increases compression time.</p>
   *
   * <p>If {@optionalArg quantTable} is set and the version of libjpeg supports it
   * (e.g. mozjpeg &ge; 3.0) it selects the quantization table to use:</p>
   *
   * <p>* 0 — Tables from JPEG Annex K (vips and libjpeg default)
   * * 1 — Flat table
   * * 2 — Table tuned for MSSIM on Kodak image set
   * * 3 — Table from ImageMagick by N. Robidoux (current mozjpeg default)
   * * 4 — Table tuned for PSNR-HVS-M on Kodak image set
   * * 5 — Table from Relevance of Human Vision to JPEG-DCT Compression (1992)
   * * 6 — Table from DCTune Perceptual Optimization of Compressed Dental
   *   X-Rays (1997)
   * * 7 — Table from A Visual Detection Model for DCT Coefficient
   *   Quantization (1993)
   * * 8 — Table from An Improved Detection Model for DCT Coefficient
   *   Quantization (1993)</p>
   *
   * <p>Quantization table 0 is the default in vips and libjpeg(-turbo), but it
   * tends to favor detail over color accuracy, producing colored patches and
   * stripes as well as heavy banding in flat areas at high compression ratios.
   * Quantization table 2 is a good candidate to try if the default quantization
   * table produces banding or color shifts and is well suited for hires images.
   * Quantization table 3 is the default in mozjpeg and has been tuned to produce
   * good results at the default quality setting; banding at high compression.
   * Quantization table 4 is the most accurate at the cost of compression ratio.
   * Tables 5-7 are based on older research papers, but generally achieve worse
   * compression ratios and/or quality than 2 or 4.</p>
   *
   * <p>For maximum compression with mozjpeg, a useful set of options is `strip,
   * optimize-coding, interlace, optimize-scans, trellis-quant, quant_table=3`.</p>
   *
   * <p>By default, the output stream won't have restart markers.  If a non-zero
   * restart_interval is specified, a restart marker will be added after each
   * specified number of MCU blocks.  This makes the stream more recoverable
   * if there are transmission errors, but also allows for some decoders to read
   * part of the JPEG without decoding the whole stream.</p>
   *
   * <p>The image is automatically converted to RGB, Monochrome or CMYK before
   * saving.</p>
   *
   * <p>EXIF data is constructed from <code>VIPS_META_EXIF_NAME</code>, then
   * modified with any other related tags on the image before being written to
   * the file. <code>VIPS_META_RESOLUTION_UNIT</code> is used to set the EXIF resolution
   * unit. <code>VIPS_META_ORIENTATION</code> is used to set the EXIF orientation tag.</p>
   *
   * <p>IPTC as <code>VIPS_META_IPTC_NAME</code> and XMP as <code>VIPS_META_XMP_NAME</code>
   * are coded and attached.</p>
   *
   * <p>See also: <code>vips_jpegsave_buffer</code>, <code>vips_image_write_to_file</code>.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg optimize-coding {@link VipsOption.Boolean} Compute optimal Huffman coding tables
   * @optionalArg interlace {@link VipsOption.Boolean} Generate an interlaced (progressive) jpeg
   * @optionalArg no-subsample {@link VipsOption.Boolean} Disable chroma subsample
   * @optionalArg trellis-quant {@link VipsOption.Boolean} Apply trellis quantisation to each 8x8 block
   * @optionalArg overshoot-deringing {@link VipsOption.Boolean} Apply overshooting to samples with extreme values
   * @optionalArg optimize-scans {@link VipsOption.Boolean} Split spectrum of DCT coefficients into separate scans
   * @optionalArg quant-table {@link VipsOption.Int} Use predefined quantization table with given index
   * @optionalArg subsample-mode {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignSubsample} Select chroma subsample operation mode
   * @optionalArg restart-interval {@link VipsOption.Int} Add restart markers every specified number of mcu
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void jpegsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "jpegsave", callArgs);
  }

  /**
   * <p>As {@link #jpegsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in <code>@obuf</code>, the length of the buffer in
   * <code>@olen</code>. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link #jpegsave}, <code>vips_image_write_to_file</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg optimize-coding {@link VipsOption.Boolean} Compute optimal Huffman coding tables
   * @optionalArg interlace {@link VipsOption.Boolean} Generate an interlaced (progressive) jpeg
   * @optionalArg no-subsample {@link VipsOption.Boolean} Disable chroma subsample
   * @optionalArg trellis-quant {@link VipsOption.Boolean} Apply trellis quantisation to each 8x8 block
   * @optionalArg overshoot-deringing {@link VipsOption.Boolean} Apply overshooting to samples with extreme values
   * @optionalArg optimize-scans {@link VipsOption.Boolean} Split spectrum of DCT coefficients into separate scans
   * @optionalArg quant-table {@link VipsOption.Int} Use predefined quantization table with given index
   * @optionalArg subsample-mode {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignSubsample} Select chroma subsample operation mode
   * @optionalArg restart-interval {@link VipsOption.Int} Add restart markers every specified number of mcu
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public VBlob jpegsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "jpegsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /**
   * <p>As {@link #jpegsave}, but save as a mime jpeg on stdout.</p>
   *
   * <p>See also: {@link #jpegsave}, <code>vips_image_write_to_file</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg optimize-coding {@link VipsOption.Boolean} Compute optimal Huffman coding tables
   * @optionalArg interlace {@link VipsOption.Boolean} Generate an interlaced (progressive) jpeg
   * @optionalArg no-subsample {@link VipsOption.Boolean} Disable chroma subsample
   * @optionalArg trellis-quant {@link VipsOption.Boolean} Apply trellis quantisation to each 8x8 block
   * @optionalArg overshoot-deringing {@link VipsOption.Boolean} Apply overshooting to samples with extreme values
   * @optionalArg optimize-scans {@link VipsOption.Boolean} Split spectrum of DCT coefficients into separate scans
   * @optionalArg quant-table {@link VipsOption.Int} Use predefined quantization table with given index
   * @optionalArg subsample-mode {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignSubsample} Select chroma subsample operation mode
   * @optionalArg restart-interval {@link VipsOption.Int} Add restart markers every specified number of mcu
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void jpegsaveMime(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    VipsInvoker.invokeOperation(arena, "jpegsave_mime", callArgs);
  }

  /**
   * <p>As {@link #jpegsave}, but save to a target.</p>
   *
   * <p>See also: {@link #jpegsave}, <code>vips_image_write_to_target</code>.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg optimize-coding {@link VipsOption.Boolean} Compute optimal Huffman coding tables
   * @optionalArg interlace {@link VipsOption.Boolean} Generate an interlaced (progressive) jpeg
   * @optionalArg no-subsample {@link VipsOption.Boolean} Disable chroma subsample
   * @optionalArg trellis-quant {@link VipsOption.Boolean} Apply trellis quantisation to each 8x8 block
   * @optionalArg overshoot-deringing {@link VipsOption.Boolean} Apply overshooting to samples with extreme values
   * @optionalArg optimize-scans {@link VipsOption.Boolean} Split spectrum of DCT coefficients into separate scans
   * @optionalArg quant-table {@link VipsOption.Int} Use predefined quantization table with given index
   * @optionalArg subsample-mode {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignSubsample} Select chroma subsample operation mode
   * @optionalArg restart-interval {@link VipsOption.Int} Add restart markers every specified number of mcu
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void jpegsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "jpegsave_target", callArgs);
  }

  /**
   * <p>Read a JPEG-XL image.</p>
   *
   * <p>The JPEG-XL loader and saver are experimental features and may change
   * in future libvips versions.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage jxlload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jxlload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #jxlload}, but read from a buffer.</p>
   * @param buffer Buffer to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage jxlloadBuffer(VBlob buffer, VipsOption... args) throws VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jxlload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #jxlload}, but read from a source.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage jxlloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jxlload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Write a VIPS image to a file in JPEG-XL format.</p>
   *
   * <p>The JPEG-XL loader and saver are experimental features and may change
   * in future libvips versions.</p>
   *
   * <p>{@optionalArg tier} sets the overall decode speed the encoder will target. Minimum is 0
   * (highest quality), and maximum is 4 (lowest quality). Default is 0.</p>
   *
   * <p>{@optionalArg distance} sets the target maximum encoding error. Minimum is 0
   * (highest quality), and maximum is 15 (lowest quality). Default is 1.0
   * (visually lossless).</p>
   *
   * <p>As a convenience, you can also use {@optionalArg Q} to set {@optionalArg distance}. {@optionalArg Q} uses
   * approximately the same scale as regular JPEG.</p>
   *
   * <p>Set {@optionalArg lossless} to enable lossless compression.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg tier {@link VipsOption.Int} Decode speed tier
   * @optionalArg distance {@link VipsOption.Double} Target butteraugli distance
   * @optionalArg effort {@link VipsOption.Int} Encoding effort
   * @optionalArg lossless {@link VipsOption.Boolean} Enable lossless compression
   * @optionalArg Q {@link VipsOption.Int} Quality factor
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void jxlsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "jxlsave", callArgs);
  }

  /**
   * <p>As {@link #jxlsave}, but save to a memory buffer.</p>
   *
   * <p>See also: {@link #jxlsave}, <code>vips_image_write_to_target</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg tier {@link VipsOption.Int} Decode speed tier
   * @optionalArg distance {@link VipsOption.Double} Target butteraugli distance
   * @optionalArg effort {@link VipsOption.Int} Encoding effort
   * @optionalArg lossless {@link VipsOption.Boolean} Enable lossless compression
   * @optionalArg Q {@link VipsOption.Int} Quality factor
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public VBlob jxlsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "jxlsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /**
   * <p>As {@link #jxlsave}, but save to a target.</p>
   *
   * <p>See also: {@link #jxlsave}, <code>vips_image_write_to_target</code>.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg tier {@link VipsOption.Int} Decode speed tier
   * @optionalArg distance {@link VipsOption.Double} Target butteraugli distance
   * @optionalArg effort {@link VipsOption.Int} Encoding effort
   * @optionalArg lossless {@link VipsOption.Boolean} Enable lossless compression
   * @optionalArg Q {@link VipsOption.Int} Quality factor
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void jxlsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "jxlsave_target", callArgs);
  }

  /**
   * <p>Repeatedly scans {@param in} for regions of 4-connected pixels
   * with the same pixel value. Every time a region is discovered, those
   * pixels are marked in {@param mask} with a unique serial number. Once all pixels
   * have been labelled, the operation returns, setting {@optionalArg segments} to the number
   * of discrete regions which were detected.</p>
   *
   * <p>{@param mask} is always a 1-band {@link VipsBandFormat#FORMAT_INT} image of the same dimensions as
   * {@param in}.</p>
   *
   * <p>This operation is useful for, for example, blob counting. You can use the
   * morphological operators to detect and isolate a series of objects, then use
   * labelregions to number them all.</p>
   *
   * <p>Use <code>vips_hist_find_indexed</code> to (for example) find blob coordinates.</p>
   *
   * <p>See also: <code>vips_hist_find_indexed</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg segments {@link VipsOption.Int} Number of discrete contiguous regions
   */
  public VImage labelregions(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var maskOption = VipsOption.Image("mask");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(maskOption);
    VipsInvoker.invokeOperation(arena, "labelregions", callArgs);
    return maskOption.valueOrThrow();
  }

  /**
   * <p>Pass an image through a linear transform, ie. ({@param out} = {@param in} * {@param a} + {@param b}). Output
   * is float for integer input, double for double input, complex for
   * complex input and double complex for double complex input. Set {@optionalArg uchar} to
   * output uchar pixels.</p>
   *
   * <p>If the arrays of constants have just one element, that constant is used for
   * all image bands. If the arrays have more than one element and they have
   * the same number of elements as there are bands in the image, then
   * one array element is used for each band. If the arrays have more than one
   * element and the image only has a single band, the result is a many-band
   * image where each band corresponds to one array element.</p>
   *
   * <p>See also: <code>vips_linear1</code>, {@link #add}.</p>
   * @param a Multiply by this
   * @param b Add this
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output should be uchar
   */
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

  /**
   * <p>This operation behaves rather like {@link #copy} between images
   * {@param in} and {@param out}, except that it keeps a cache of computed scanlines.</p>
   *
   * <p>The number of lines cached is enough for a small amount of non-local
   * access.</p>
   *
   * <p>Each cache tile is made with a single call to
   * <code>vips_region_prepare</code>.</p>
   *
   * <p>When the cache fills, a tile is chosen for reuse. If {@optionalArg access} is
   * {@link app.photofox.vipsffm.enums.VipsAccess#ACCESS_RANDOM}, then the least-recently-used tile is reused. If
   * {@optionalArg access} is {@link app.photofox.vipsffm.enums.VipsAccess#ACCESS_SEQUENTIAL}, then
   * the top-most tile is reused. {@optionalArg access} defaults to {@link app.photofox.vipsffm.enums.VipsAccess#ACCESS_RANDOM}.</p>
   *
   * <p>{@optionalArg tileHeight} can be used to set the size of the strips that
   * linecache uses. The default is 1 (a single scanline).</p>
   *
   * <p>Normally, only a single thread at once is allowed to calculate tiles. If
   * you set {@optionalArg threaded} to <code>TRUE</code>, linecache will allow many threads to
   * calculate tiles at once and share the cache between them.</p>
   *
   * <p>See also: {@link #cache}, {@link #tilecache}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Expected access pattern
   * @optionalArg threaded {@link VipsOption.Boolean} Allow threaded access
   * @optionalArg persistent {@link VipsOption.Boolean} Keep cache between evaluations
   */
  public VImage linecache(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "linecache", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Creates a circularly symmetric Laplacian of Gaussian mask
   * of radius
   * {@param sigma}.  The size of the mask is determined by the variable {@param minAmpl};
   * if for instance the value .1 is entered this means that the produced mask
   * is clipped at values within 10 percent of zero, and where the change
   * between mask elements is less than 10%.</p>
   *
   * <p>The program uses the following equation: (from Handbook of Pattern
   * Recognition and image processing by Young and Fu, AP 1986 pages 220-221):
   *
   *  H(r) = (1 / (2 * M_PI * s4)) *
   * 	(2 - (r2 / s2)) *
   * 	exp(-r2 / (2 * s2))</p>
   *
   * <p>where s2 = {@param sigma} * {@param sigma}, s4 = s2 * s2, r2 = r * r.</p>
   *
   * <p>The generated mask has odd size and its maximum value is normalised to
   * 1.0, unless {@optionalArg precision} is {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER}.</p>
   *
   * <p>If {@optionalArg separable} is set, only the centre horizontal is generated. This is
   * useful for separable convolutions.</p>
   *
   * <p>If {@optionalArg precision} is {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER}, an integer mask is generated.
   * This is useful for integer convolutions.</p>
   *
   * <p>"scale" is set to the sum of all the mask elements.</p>
   *
   * <p>See also: {@link #gaussmat}, {@link #conv}.</p>
   * @param sigma Radius of Gaussian
   * @param minAmpl Minimum amplitude of Gaussian
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg separable {@link VipsOption.Boolean} Generate separable Gaussian
   * @optionalArg integer {@link VipsOption.Boolean} Generate integer Gaussian
   * @optionalArg precision {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPrecision} Generate with this precision
   */
  public VImage logmat(double sigma, double minAmpl, VipsOption... args) throws VipsError {
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

  /**
   * <p>Read in an image using libMagick, the ImageMagick library. This library can
   * read more than 80 file formats, including SVG, BMP, EPS, DICOM and many
   * others.
   * The reader can handle any ImageMagick image, including the float and double
   * formats. It will work with any quantum size, including HDR. Any metadata
   * attached to the libMagick image is copied on to the VIPS image.</p>
   *
   * <p>The reader should also work with most versions of GraphicsMagick. See the
   * "--with-magickpackage" configure option.</p>
   *
   * <p>The file format is usually guessed from the filename suffix, or sniffed
   * from the file contents.</p>
   *
   * <p>Normally it will only load the first image in a many-image sequence (such
   * as a GIF or a PDF). Use {@optionalArg page} and {@optionalArg n} to set the start page and number of
   * pages to load. Set {@optionalArg n} to -1 to load all pages from {@optionalArg page} onwards.</p>
   *
   * <p>{@optionalArg density} is "WxH" in DPI, e.g. "600x300" or "600" (default is "72x72"). See
   * the [density
   * docs](http://www.imagemagick.org/script/command-line-options.php#density)
   * on the imagemagick website.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg density {@link VipsOption.String} Canvas resolution for rendering vector formats like SVG
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg all-frames {@link VipsOption.Boolean} Read all frames from an image
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage magickload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "magickload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Read an image memory block using libMagick into a VIPS image. Exactly as
   * {@link #magickload}, but read from a memory source.</p>
   *
   * <p>You must not free the buffer while {@param out} is active. The
   * #VipsObject::postclose signal on {@param out} is a good place to free.</p>
   *
   * <p>See also: {@link #magickload}.</p>
   * @param buffer Buffer to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg density {@link VipsOption.String} Canvas resolution for rendering vector formats like SVG
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg all-frames {@link VipsOption.Boolean} Read all frames from an image
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage magickloadBuffer(VBlob buffer, VipsOption... args) throws VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "magickload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Write an image using libMagick.</p>
   *
   * <p>Use {@optionalArg quality} to set the quality factor. Default 0.</p>
   *
   * <p>Use {@optionalArg format} to explicitly set the save format, for example, "BMP". Otherwise
   * the format is guessed from the filename suffix.</p>
   *
   * <p>If {@optionalArg optimizeGifFrames} is set, GIF frames are cropped to the smallest size
   * while preserving the results of the GIF animation. This takes some time for
   * computation but saves some time on encoding and produces smaller files in
   * some cases.</p>
   *
   * <p>If {@optionalArg optimizeGifTransparency} is set, pixels that don't change the image
   * through animation are made transparent. This takes some time for computation
   * but saves some time on encoding and produces smaller files in some cases.</p>
   *
   * <p>{@optionalArg bitdepth} specifies the number of bits per pixel. The image will be quantized
   * and dithered if the value is within the valid range (1 to 8).</p>
   *
   * <p>See also: <code>vips_magicksave_buffer</code>, {@link #magickload}.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg format {@link VipsOption.String} Format to save in
   * @optionalArg quality {@link VipsOption.Int} Quality to use
   * @optionalArg optimize-gif-frames {@link VipsOption.Boolean} Apply GIF frames optimization
   * @optionalArg optimize-gif-transparency {@link VipsOption.Boolean} Apply GIF transparency optimization
   * @optionalArg bitdepth {@link VipsOption.Int} Number of bits per pixel
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void magicksave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "magicksave", callArgs);
  }

  /**
   * <p>As {@link #magicksave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in <code>@obuf</code>, the length of the buffer in
   * <code>@olen</code>. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link #magicksave}, <code>vips_image_write_to_file</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg format {@link VipsOption.String} Format to save in
   * @optionalArg quality {@link VipsOption.Int} Quality to use
   * @optionalArg optimize-gif-frames {@link VipsOption.Boolean} Apply GIF frames optimization
   * @optionalArg optimize-gif-transparency {@link VipsOption.Boolean} Apply GIF transparency optimization
   * @optionalArg bitdepth {@link VipsOption.Int} Number of bits per pixel
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public VBlob magicksaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "magicksave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /**
   * <p>This operator resamples {@param in} using {@param index} to look up pixels. {@param out} is
   * the same size as {@param index}, with each pixel being fetched from that position in
   * {@param in}. That is:</p>
   *
   * <pre>{@code 
   * out[x, y] = in[index[x, y]]
   * }</pre>
   *
   * <p>If {@param index} has one band, that band must be complex. Otherwise, {@param index} must
   * have two bands of any format.</p>
   *
   * <p>Coordinates in {@param index} are in pixels, with (0, 0) being the top-left corner
   * of {@param in}, and with y increasing down the image. Use {@link #xyz} to build index
   * images.</p>
   *
   * <p>{@optionalArg interpolate} defaults to bilinear.</p>
   *
   * <p>By default, new pixels are filled with {@optionalArg background}. This defaults to
   * zero (black). You can set other extend types with {@optionalArg extend}. {@link app.photofox.vipsffm.enums.VipsExtend#EXTEND_COPY}
   * is better for image upsizing.</p>
   *
   * <p>Image are normally treated as unpremultiplied, so this operation can be used
   * directly on PNG images. If your images have been through {@link #premultiply},
   * set {@optionalArg premultiplied}.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See {@link #maplut} for a 1D equivalent of this operation.</p>
   *
   * <p>See also: {@link #xyz}, {@link #affine}, {@link #resize},
   * {@link #maplut}, #VipsInterpolate.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg interpolate {@link VipsOption.Interpolate} Interpolate pixels with this
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg premultiplied {@link VipsOption.Boolean} Images have premultiplied alpha
   * @optionalArg extend {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsExtend} How to generate the extra pixels
   */
  public VImage mapim(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var indexOption = VipsOption.Image("index", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(indexOption);
    VipsInvoker.invokeOperation(arena, "mapim", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Map an image through another image acting as a LUT (Look Up Table).
   * The lut may have any type and the output image will be that type.</p>
   *
   * <p>The input image will be cast to one of the unsigned integer types, that is,
   * VIPS_FORMAT_UCHAR, VIPS_FORMAT_USHORT or VIPS_FORMAT_UINT.</p>
   *
   * <p>If {@param lut} is too small for the input type (for example, if {@param in} is
   * VIPS_FORMAT_UCHAR but {@param lut} only has 100 elements), the lut is padded out
   * by copying the last element. Overflows are reported at the end of
   * computation.
   * If {@param lut} is too large, extra values are ignored.</p>
   *
   * <p>If {@param lut} has one band and {@optionalArg band} is -1 (the default), then all bands of {@param in}
   * pass through {@param lut}. If {@optionalArg band} is &ge; 0, then just that band of {@param in} passes
   * through {@param lut} and other bands are just copied.</p>
   *
   * <p>If {@param lut}
   * has same number of bands as {@param in}, then each band is mapped
   * separately. If {@param in} has one band, then {@param lut} may have many bands and
   * the output will have the same number of bands as {@param lut}.</p>
   *
   * <p>See also: <code>vips_hist_find</code>, {@link #identity}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg band {@link VipsOption.Int} Apply one-band lut to this band of in
   */
  public VImage maplut(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var lutOption = VipsOption.Image("lut", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(lutOption);
    VipsInvoker.invokeOperation(arena, "maplut", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Make an butterworth high- or low-pass filter, that is, one with a variable,
   * smooth transition
   * positioned at {@param frequencyCutoff}, where {@param frequencyCutoff} is in
   * range 0 - 1. The shape of the curve is controlled by
   * {@param order} --- higher values give a sharper transition. See Gonzalez and Wintz,
   * Digital Image Processing, 1987.</p>
   *
   * <p>See also: <code>vips_mask_ideal</code>.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param order Filter order
   * @param frequencyCutoff Frequency cutoff
   * @param amplitudeCutoff Amplitude cutoff
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg nodc {@link VipsOption.Boolean} Remove DC component
   * @optionalArg reject {@link VipsOption.Boolean} Invert the sense of the filter
   * @optionalArg optical {@link VipsOption.Boolean} Rotate quadrants to optical space
   */
  public VImage maskButterworth(int width, int height, double order, double frequencyCutoff,
      double amplitudeCutoff, VipsOption... args) throws VipsError {
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

  /**
   * <p>Make an butterworth band-pass or band-reject filter, that is, one with a
   * variable, smooth transition positioned at {@param frequencyCutoffX},
   * {@param frequencyCutoffY}, of radius {@param radius}.
   * The shape of the curve is controlled by
   * {@param order} --- higher values give a sharper transition. See Gonzalez and Wintz,
   * Digital Image Processing, 1987.</p>
   *
   * <p>See also: <code>vips_mask_ideal</code>.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param order Filter order
   * @param frequencyCutoffX Frequency cutoff x
   * @param frequencyCutoffY Frequency cutoff y
   * @param radius Radius of circle
   * @param amplitudeCutoff Amplitude cutoff
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg nodc {@link VipsOption.Boolean} Remove DC component
   * @optionalArg reject {@link VipsOption.Boolean} Invert the sense of the filter
   * @optionalArg optical {@link VipsOption.Boolean} Rotate quadrants to optical space
   */
  public VImage maskButterworthBand(int width, int height, double order, double frequencyCutoffX,
      double frequencyCutoffY, double radius, double amplitudeCutoff, VipsOption... args) throws
      VipsError {
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

  /**
   * <p>Make a butterworth ring-pass or ring-reject filter, that is, one with a
   * variable,
   * smooth transition
   * positioned at {@param frequencyCutoff} of width {@param width}, where {@param frequencyCutoff} is
   * in the range 0 - 1. The shape of the curve is controlled by
   * {@param order} --- higher values give a sharper transition. See Gonzalez and Wintz,
   * Digital Image Processing, 1987.</p>
   *
   * <p>See also: <code>vips_mask_ideal</code>.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param order Filter order
   * @param frequencyCutoff Frequency cutoff
   * @param amplitudeCutoff Amplitude cutoff
   * @param ringwidth Ringwidth
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg nodc {@link VipsOption.Boolean} Remove DC component
   * @optionalArg reject {@link VipsOption.Boolean} Invert the sense of the filter
   * @optionalArg optical {@link VipsOption.Boolean} Rotate quadrants to optical space
   */
  public VImage maskButterworthRing(int width, int height, double order, double frequencyCutoff,
      double amplitudeCutoff, double ringwidth, VipsOption... args) throws VipsError {
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

  /**
   * <p>This operation should be used to create fractal images by filtering the
   * power spectrum of Gaussian white noise. See {@link #gaussnoise}.</p>
   *
   * <p>See also: <code>vips_mask_ideal</code>.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param fractalDimension Fractal dimension
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg nodc {@link VipsOption.Boolean} Remove DC component
   * @optionalArg reject {@link VipsOption.Boolean} Invert the sense of the filter
   * @optionalArg optical {@link VipsOption.Boolean} Rotate quadrants to optical space
   */
  public VImage maskFractal(int width, int height, double fractalDimension, VipsOption... args)
      throws VipsError {
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

  /**
   * <p>Make a gaussian high- or low-pass filter, that is, one with a variable,
   * smooth transition positioned at {@param frequencyCutoff}.</p>
   *
   * <p>See also: <code>vips_mask_ideal</code>.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param frequencyCutoff Frequency cutoff
   * @param amplitudeCutoff Amplitude cutoff
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg nodc {@link VipsOption.Boolean} Remove DC component
   * @optionalArg reject {@link VipsOption.Boolean} Invert the sense of the filter
   * @optionalArg optical {@link VipsOption.Boolean} Rotate quadrants to optical space
   */
  public VImage maskGaussian(int width, int height, double frequencyCutoff, double amplitudeCutoff,
      VipsOption... args) throws VipsError {
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

  /**
   * <p>Make a gaussian band-pass or band-reject filter, that is, one with a
   * variable, smooth transition positioned at {@param frequencyCutoffX},
   * {@param frequencyCutoffY}, of radius {@param radius}.</p>
   *
   * <p>See also: <code>vips_mask_ideal</code>.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param frequencyCutoffX Frequency cutoff x
   * @param frequencyCutoffY Frequency cutoff y
   * @param radius Radius of circle
   * @param amplitudeCutoff Amplitude cutoff
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg nodc {@link VipsOption.Boolean} Remove DC component
   * @optionalArg reject {@link VipsOption.Boolean} Invert the sense of the filter
   * @optionalArg optical {@link VipsOption.Boolean} Rotate quadrants to optical space
   */
  public VImage maskGaussianBand(int width, int height, double frequencyCutoffX,
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

  /**
   * <p>Make a gaussian ring-pass or ring-reject filter, that is, one with a
   * variable, smooth transition positioned at {@param frequencyCutoff} of width
   * {@param ringwidth}.</p>
   *
   * <p>See also: <code>vips_mask_ideal</code>.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param frequencyCutoff Frequency cutoff
   * @param amplitudeCutoff Amplitude cutoff
   * @param ringwidth Ringwidth
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg nodc {@link VipsOption.Boolean} Remove DC component
   * @optionalArg reject {@link VipsOption.Boolean} Invert the sense of the filter
   * @optionalArg optical {@link VipsOption.Boolean} Rotate quadrants to optical space
   */
  public VImage maskGaussianRing(int width, int height, double frequencyCutoff,
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

  /**
   * <p>Make an ideal high- or low-pass filter, that is, one with a sharp cutoff
   * positioned at {@param frequencyCutoff}, where {@param frequencyCutoff} is in
   * the range 0 - 1.</p>
   *
   * <p>This operation creates a one-band float image of the specified size.
   * The image has
   * values in the range [0, 1] and is typically used for multiplying against
   * frequency domain images to filter them.
   * Masks are created with the DC component at (0, 0). The DC pixel always
   * has the value 1.0.</p>
   *
   * <p>Set {@optionalArg nodc} to not set the DC pixel.</p>
   *
   * <p>Set {@optionalArg optical} to position the DC component in the centre of the image. This
   * makes the mask suitable for multiplying against optical Fourier transforms.
   * See {@link #wrap}.</p>
   *
   * <p>Set {@optionalArg reject} to invert the sense of
   * the filter. For example, low-pass becomes low-reject.</p>
   *
   * <p>Set {@optionalArg uchar} to output an 8-bit unsigned char image rather than a
   * float image. In this case, pixels are in the range [0 - 255].</p>
   *
   * <p>See also: <code>vips_mask_ideal</code>, <code>vips_mask_ideal_ring</code>,
   * <code>vips_mask_ideal_band</code>, <code>vips_mask_butterworth</code>,
   * <code>vips_mask_butterworth_ring</code>, <code>vips_mask_butterworth_band</code>,
   * <code>vips_mask_gaussian</code>, <code>vips_mask_gaussian_ring</code>,
   * <code>vips_mask_gaussian_band</code>.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param frequencyCutoff Frequency cutoff
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg nodc {@link VipsOption.Boolean} Remove DC component
   * @optionalArg reject {@link VipsOption.Boolean} Invert the sense of the filter
   * @optionalArg optical {@link VipsOption.Boolean} Rotate quadrants to optical space
   */
  public VImage maskIdeal(int width, int height, double frequencyCutoff, VipsOption... args) throws
      VipsError {
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

  /**
   * <p>Make an ideal band-pass or band-reject filter, that is, one with a
   * sharp cutoff around the point {@param frequencyCutoffX}, {@param frequencyCutoffY},
   * of size {@param radius}.</p>
   *
   * <p>See also: <code>vips_mask_ideal</code>.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param frequencyCutoffX Frequency cutoff x
   * @param frequencyCutoffY Frequency cutoff y
   * @param radius Radius of circle
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg nodc {@link VipsOption.Boolean} Remove DC component
   * @optionalArg reject {@link VipsOption.Boolean} Invert the sense of the filter
   * @optionalArg optical {@link VipsOption.Boolean} Rotate quadrants to optical space
   */
  public VImage maskIdealBand(int width, int height, double frequencyCutoffX,
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

  /**
   * <p>Make an ideal ring-pass or ring-reject filter, that is, one with a sharp
   * ring positioned at {@param frequencyCutoff} of width {@param width}, where
   * {@param frequencyCutoff} and {@param width} are expressed as the range 0 - 1.</p>
   *
   * <p>See also: <code>vips_mask_ideal</code>.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param frequencyCutoff Frequency cutoff
   * @param ringwidth Ringwidth
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg nodc {@link VipsOption.Boolean} Remove DC component
   * @optionalArg reject {@link VipsOption.Boolean} Invert the sense of the filter
   * @optionalArg optical {@link VipsOption.Boolean} Rotate quadrants to optical space
   */
  public VImage maskIdealRing(int width, int height, double frequencyCutoff, double ringwidth,
      VipsOption... args) throws VipsError {
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

  /**
   * <p>Scale, rotate and translate {@param sec} so that the tie-points line up.</p>
   *
   * <p>If {@optionalArg search} is <code>TRUE</code>, before performing the transformation, the tie-points
   * are improved by searching an area of {@param sec} of size {@optionalArg harea} for a
   * match of size {@optionalArg hwindow} to {@param ref}.</p>
   *
   * <p>This function will only work well for small rotates and scales.</p>
   * @param xr1 Position of first reference tie-point
   * @param yr1 Position of first reference tie-point
   * @param xs1 Position of first secondary tie-point
   * @param ys1 Position of first secondary tie-point
   * @param xr2 Position of second reference tie-point
   * @param yr2 Position of second reference tie-point
   * @param xs2 Position of second secondary tie-point
   * @param ys2 Position of second secondary tie-point
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg hwindow {@link VipsOption.Int} Half window size
   * @optionalArg harea {@link VipsOption.Int} Half area size
   * @optionalArg search {@link VipsOption.Boolean} Search to improve tie-points
   * @optionalArg interpolate {@link VipsOption.Interpolate} Interpolate pixels with this
   */
  public VImage match(int xr1, int yr1, int xs1, int ys1, int xr2, int yr2, int xs2, int ys2,
      VipsOption... args) throws VipsError {
    var refOption = VipsOption.Image("ref", this);
    var secOption = VipsOption.Image("sec", this);
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

  /**
   * <p>Perform various functions in -lm, the maths library, on images.</p>
   *
   * <p>Angles are expressed in degrees. The output type is float unless the
   * input is double, in which case the output is double.</p>
   *
   * <p>Non-complex images only.</p>
   *
   * <p>See also: {@link #math2}.</p>
   * @param math {@link VipsOperationMath} Math to perform
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>This operation calculates a 2-ary maths operation on a pair of images
   * and writes the result to {@param out}. The images may have any
   * non-complex format. {@param out} is float except in the case that either of {@param left}
   * or {@param right} are double, in which case {@param out} is also double.</p>
   *
   * <p>It detects division by zero, setting those pixels to zero in the output.
   * Beware: it does this silently!</p>
   *
   * <p>If the images differ in size, the smaller image is enlarged to match the
   * larger by adding zero pixels along the bottom and right.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common format (see table
   * Smallest common format in
   * <code>arithmetic</code>), and that format is the
   * result type.</p>
   *
   * <p>See also: <code>vips_math2_const</code>.</p>
   * @param math2 {@link VipsOperationMath2} Math to perform
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage math2(VipsOperationMath2 math2, VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", this);
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

  /**
   * <p>This operation calculates various 2-ary maths operations on an image and
   * an array of constants and writes the result to {@param out}.
   * The image may have any
   * non-complex format. {@param out} is float except in the case that {@param in}
   * is double, in which case {@param out} is also double.</p>
   *
   * <p>It detects division by zero, setting those pixels to zero in the output.
   * Beware: it does this silently!</p>
   *
   * <p>If the array of constants has just one element, that constant is used for
   * all image bands. If the array has more than one element and they have
   * the same number of elements as there are bands in the image, then
   * one array element is used for each band. If the arrays have more than one
   * element and the image only has a single band, the result is a many-band
   * image where each band corresponds to one array element.</p>
   *
   * <p>See also: {@link #math2}, {@link #math}.</p>
   * @param math2 {@link VipsOperationMath2} Math to perform
   * @param c Array of constants
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Read a Matlab save file into a VIPS image.</p>
   *
   * <p>This operation searches the save
   * file for the first array variable with between 1 and 3 dimensions and loads
   * it as an image. It will not handle complex images. It does not handle
   * sparse matrices.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage matload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "matload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation calculates the inverse of the matrix represented in <code>@m</code>.
   * The scale and offset members of the input matrix are ignored.</p>
   *
   * <p>See also: {@link #matrixload}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage matrixinvert(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "matrixinvert", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Reads a matrix from a file.</p>
   *
   * <p>Matrix files have a simple format that's supposed to be easy to create with
   * a text editor or a spreadsheet.</p>
   *
   * <p>The first line has four numbers for width, height, scale and
   * offset (scale and offset may be omitted, in which case they default to 1.0
   * and 0.0). Scale must be non-zero. Width and height must be positive
   * integers. The numbers are separated by any mixture of spaces, commas,
   * tabs and quotation marks ("). The scale and offset fields may be
   * floating-point, and must use '.'
   * as a decimal separator.</p>
   *
   * <p>Subsequent lines each hold one row of matrix data, with numbers again
   * separated by any mixture of spaces, commas,
   * tabs and quotation marks ("). The numbers may be floating-point, and must
   * use '.'
   * as a decimal separator.</p>
   *
   * <p>Extra characters at the ends of lines or at the end of the file are
   * ignored.</p>
   *
   * <p>See also: matrixload.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage matrixload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "matrixload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #matrixload}, but read from a source.</p>
   *
   * <p>See also: {@link #matrixload}.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage matrixloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "matrixload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Print {@param in} to <code>stdout</code> in matrix format. See {@link #matrixload} for a
   * description of the format.</p>
   *
   * <p>See also: {@link #matrixload}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void matrixprint(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    VipsInvoker.invokeOperation(arena, "matrixprint", callArgs);
  }

  /**
   * <p>Write {@param in} to {@param filename} in matrix format. See {@link #matrixload} for a
   * description of the format.</p>
   *
   * <p>See also: {@link #matrixload}.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void matrixsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "matrixsave", callArgs);
  }

  /**
   * <p>As {@link #matrixsave}, but save to a target.</p>
   *
   * <p>See also: {@link #matrixsave}.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void matrixsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "matrixsave_target", callArgs);
  }

  /**
   * <p>This operation finds the maximum value in an image.</p>
   *
   * <p>By default it finds the single largest value. If {@optionalArg size} is set &gt;1, it will
   * find the {@optionalArg size} largest values. It will stop searching early if has found
   * enough values.
   * Equal values will be sorted by y then x.</p>
   *
   * <p>It operates on all
   * bands of the input image: use {@link #stats} if you need to find an
   * maximum for each band.</p>
   *
   * <p>For complex images, this operation finds the maximum modulus.</p>
   *
   * <p>You can read out the position of the maximum with {@optionalArg x} and {@optionalArg y}. You can read
   * out arrays of the values and positions of the top {@optionalArg size} maxima with
   * {@optionalArg outArray}, {@optionalArg xArray} and {@optionalArg yArray}. These values are returned sorted from
   * largest to smallest.</p>
   *
   * <p>If there are more than {@optionalArg size} maxima, the maxima returned will be a random
   * selection of the maxima in the image.</p>
   *
   * <p>See also: {@link #min}, {@link #stats}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg x {@link VipsOption.Int} Horizontal position of maximum
   * @optionalArg y {@link VipsOption.Int} Vertical position of maximum
   * @optionalArg size {@link VipsOption.Int} Number of maximum values to find
   * @optionalArg out-array {@link VipsOption.ArrayDouble} Array of output values
   * @optionalArg x-array {@link VipsOption.ArrayInt} Array of horizontal positions
   * @optionalArg y-array {@link VipsOption.ArrayInt} Array of vertical positions
   */
  public double max(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Double("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "max", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Analyse a grid of colour patches, producing an array of patch averages.
   * The mask has a row for each measured patch and a column for each image
   * band. The operations issues a warning if any patch has a deviation more
   * than 20% of
   * the mean. Only the central 50% of each patch is averaged.</p>
   *
   * <p>If the chart does not fill the whole image, use the optional {@optionalArg left}, {@optionalArg top},
   * {@optionalArg width}, {@optionalArg height} arguments to indicate the
   * position of the chart.</p>
   *
   * <p>See also: {@link #avg}, {@link #deviate}.</p>
   * @param h Number of patches across chart
   * @param v Number of patches down chart
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg left {@link VipsOption.Int} Left edge of extract area
   * @optionalArg top {@link VipsOption.Int} Top edge of extract area
   * @optionalArg width {@link VipsOption.Int} Width of extract area
   * @optionalArg height {@link VipsOption.Int} Height of extract area
   */
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

  /**
   * <p>This operation joins two images left-right (with {@param ref} on the left) or
   * up-down (with {@param ref} above) with a smooth seam.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common type (see table
   * Smallest common format in
   * <code>arithmetic</code>).</p>
   *
   * <p>{@param dx} and {@param dy} give the displacement of {@param sec} relative to {@param ref}, in other words,
   * the vector to get from the origin of {@param sec} to the origin of {@param ref}, in other
   * words, {@param dx} will generally be a negative number.</p>
   *
   * <p>{@optionalArg mblend} limits  the  maximum width of the
   * blend area.  A value of "-1" means "unlimited". The two images are blended
   * with a raised cosine.</p>
   *
   * <p>Pixels with all bands equal to zero are "transparent", that
   * is, zero pixels in the overlap area do not  contribute  to  the  merge.
   * This makes it possible to join non-rectangular images.</p>
   *
   * <p>See also: {@link #mosaic}, {@link #insert}.</p>
   * @param direction {@link VipsDirection} Horizontal or vertical merge
   * @param dx Horizontal displacement from sec to ref
   * @param dy Vertical displacement from sec to ref
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg mblend {@link VipsOption.Int} Maximum blend size
   */
  public VImage merge(VipsDirection direction, int dx, int dy, VipsOption... args) throws
      VipsError {
    var refOption = VipsOption.Image("ref", this);
    var secOption = VipsOption.Image("sec", this);
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

  /**
   * <p>This operation finds the minimum value in an image.</p>
   *
   * <p>By default it finds the single smallest value. If {@optionalArg size} is set &gt;1, it will
   * find the {@optionalArg size} smallest values. It will stop searching early if has found
   * enough values.
   * Equal values will be sorted by y then x.</p>
   *
   * <p>It operates on all
   * bands of the input image: use {@link #stats} if you need to find an
   * minimum for each band.</p>
   *
   * <p>For complex images, this operation finds the minimum modulus.</p>
   *
   * <p>You can read out the position of the minimum with {@optionalArg x} and {@optionalArg y}. You can read
   * out arrays of the values and positions of the top {@optionalArg size} minima with
   * {@optionalArg outArray}, {@optionalArg xArray} and {@optionalArg yArray}.
   * These values are returned sorted from
   * smallest to largest.</p>
   *
   * <p>If there are more than {@optionalArg size} minima, the minima returned will be a random
   * selection of the minima in the image.</p>
   *
   * <p>See also: min, {@link #stats}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg x {@link VipsOption.Int} Horizontal position of minimum
   * @optionalArg y {@link VipsOption.Int} Vertical position of minimum
   * @optionalArg size {@link VipsOption.Int} Number of minimum values to find
   * @optionalArg out-array {@link VipsOption.ArrayDouble} Array of output values
   * @optionalArg x-array {@link VipsOption.ArrayInt} Array of horizontal positions
   * @optionalArg y-array {@link VipsOption.ArrayInt} Array of vertical positions
   */
  public double min(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Double("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "min", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Performs a morphological operation on {@param in} using {@param mask} as a
   * structuring element.</p>
   *
   * <p>The image should have 0 (black) for no object and 255
   * (non-zero) for an object. Note that this is the reverse of the usual
   * convention for these operations, but more convenient when combined with the
   * boolean operators. The output image is the same
   * size as the input image: edge pxels are made by expanding the input image
   * as necessary.</p>
   *
   * <p>Mask coefficients can be either 0 (for object) or 255 (for background)
   * or 128 (for do not care).  The origin of the mask is at location
   * (m.xsize / 2, m.ysize / 2), integer division.  All algorithms have been
   * based on the book "Fundamentals of Digital Image Processing" by A. Jain,
   * pp 384-388, Prentice-Hall, 1989.</p>
   *
   * <p>For {@link VipsOperationMorphology#OPERATION_MORPHOLOGY_ERODE},
   * the whole mask must match for the output pixel to be
   * set, that is, the result is the logical AND of the selected input pixels.</p>
   *
   * <p>For {@link VipsOperationMorphology#OPERATION_MORPHOLOGY_DILATE},
   * the output pixel is set if any part of the mask
   * matches, that is, the result is the logical OR of the selected input pixels.</p>
   *
   * <p>See the boolean operations <code>vips_andimage</code>, <code>vips_orimage</code> and
   * <code>vips_eorimage</code>
   * for analogues of the usual set difference and set union operations.</p>
   *
   * <p>Operations are performed using the processor's vector unit,
   * if possible. Disable this with `--vips-novector` or `VIPS_NOVECTOR` or
   * <code>vips_vector_set_enabled</code></p>
   * @param morph {@link VipsOperationMorphology} Morphological operation to perform
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage morph(VipsOperationMorphology morph, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var maskOption = VipsOption.Image("mask", this);
    var morphOption = VipsOption.Enum("morph", morph);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(maskOption);
    callArgs.add(morphOption);
    VipsInvoker.invokeOperation(arena, "morph", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation joins two images left-right (with {@param ref} on the left) or
   * top-bottom (with {@param ref} above) given an approximate overlap.</p>
   *
   * <p>{@param sec} is positioned so that the pixel ({@param xsec}, {@param ysec}) in {@param sec} lies on top of
   * the pixel ({@param xref}, {@param yref}) in {@param ref}. The overlap area is divided into three
   * sections, 20 high-contrast points in band {@optionalArg bandno} of image {@param ref} are found
   * in each, and a window of pixels of size {@optionalArg hwindow} around each high-contrast
   * point is searched for in {@param sec} over an area of {@optionalArg harea}.</p>
   *
   * <p>A linear model is fitted to the 60 tie-points, points a long way from the
   * fit are discarded, and the model refitted until either too few points
   * remain or the model reaches good agreement.</p>
   *
   * <p>The detected displacement is used with {@link #merge} to join the two images
   * together.</p>
   *
   * <p>You can read out the detected transform with {@optionalArg dx0}, {@optionalArg dy0}, {@optionalArg scale1}, {@optionalArg angle1},
   * {@optionalArg dx1}, {@optionalArg dy1}.</p>
   *
   * <p>See also: {@link #merge}, {@link #insert}.</p>
   * @param direction {@link VipsDirection} Horizontal or vertical mosaic
   * @param xref Position of reference tie-point
   * @param yref Position of reference tie-point
   * @param xsec Position of secondary tie-point
   * @param ysec Position of secondary tie-point
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg hwindow {@link VipsOption.Int} Half window size
   * @optionalArg harea {@link VipsOption.Int} Half area size
   * @optionalArg mblend {@link VipsOption.Int} Maximum blend size
   * @optionalArg bandno {@link VipsOption.Int} Band to search for features on
   * @optionalArg dx0 {@link VipsOption.Int} Detected integer offset
   * @optionalArg dy0 {@link VipsOption.Int} Detected integer offset
   * @optionalArg scale1 {@link VipsOption.Double} Detected scale
   * @optionalArg angle1 {@link VipsOption.Double} Detected rotation
   * @optionalArg dy1 {@link VipsOption.Double} Detected first-order displacement
   * @optionalArg dx1 {@link VipsOption.Double} Detected first-order displacement
   */
  public VImage mosaic(VipsDirection direction, int xref, int yref, int xsec, int ysec,
      VipsOption... args) throws VipsError {
    var refOption = VipsOption.Image("ref", this);
    var secOption = VipsOption.Image("sec", this);
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

  /**
   * <p>This operation joins two images top-bottom (with {@param sec} on the right)
   * or left-right (with {@param sec} at the bottom)
   * given an approximate pair of tie-points. {@param sec} is scaled and rotated as
   * necessary before the join.</p>
   *
   * <p>If {@optionalArg search} is <code>TRUE</code>, before performing the transformation, the tie-points
   * are improved by searching an area of {@param sec} of size {@optionalArg harea} for a
   * object of size {@optionalArg hwindow} in {@param ref}.</p>
   *
   * <p>{@optionalArg mblend} limits  the  maximum size of the
   * blend area.  A value of "-1" means "unlimited". The two images are blended
   * with a raised cosine.</p>
   *
   * <p>Pixels with all bands equal to zero are "transparent", that
   * is, zero pixels in the overlap area do not  contribute  to  the  merge.
   * This makes it possible to join non-rectangular images.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common type (see table
   * Smallest common format in
   * <code>arithmetic</code>).</p>
   *
   * <p>See also: {@link #merge}, {@link #insert}, {@link #globalbalance}.</p>
   * @param direction {@link VipsDirection} Horizontal or vertical mosaic
   * @param xr1 Position of first reference tie-point
   * @param yr1 Position of first reference tie-point
   * @param xs1 Position of first secondary tie-point
   * @param ys1 Position of first secondary tie-point
   * @param xr2 Position of second reference tie-point
   * @param yr2 Position of second reference tie-point
   * @param xs2 Position of second secondary tie-point
   * @param ys2 Position of second secondary tie-point
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg hwindow {@link VipsOption.Int} Half window size
   * @optionalArg harea {@link VipsOption.Int} Half area size
   * @optionalArg search {@link VipsOption.Boolean} Search to improve tie-points
   * @optionalArg interpolate {@link VipsOption.Interpolate} Interpolate pixels with this
   * @optionalArg mblend {@link VipsOption.Int} Maximum blend size
   * @optionalArg bandno {@link VipsOption.Int} Band to search for features on
   */
  public VImage mosaic1(VipsDirection direction, int xr1, int yr1, int xs1, int ys1, int xr2,
      int yr2, int xs2, int ys2, VipsOption... args) throws VipsError {
    var refOption = VipsOption.Image("ref", this);
    var secOption = VipsOption.Image("sec", this);
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

  /**
   * <p>Turn any integer image to 8-bit unsigned char by discarding all but the most
   * significant byte. Signed values are converted to unsigned by adding 128.</p>
   *
   * <p>Use {@optionalArg band} to make a one-band 8-bit image.</p>
   *
   * <p>This operator also works for LABQ coding.</p>
   *
   * <p>See also: {@link #scale}, {@link #cast}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg band {@link VipsOption.Int} Band to msb
   */
  public VImage msb(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "msb", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation calculates {@param left} * {@param right} and writes the result to {@param out}.</p>
   *
   * <p>If the images differ in size, the smaller image is enlarged to match the
   * larger by adding zero pixels along the bottom and right.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common format (see table
   * Smallest common format in
   * <code>arithmetic</code>), then the
   * following table is used to determine the output type:</p>
   *
   * <pre>{@code
   * <table>
   *   <title>VipsMultiply type promotion</title>
   *   <tgroup cols='2' align='left' colsep='1' rowsep='1'>
   *     <thead>
   *       <row>
   *         <entry>input type</entry>
   *         <entry>output type</entry>
   *       </row>
   *     </thead>
   *     <tbody>
   *       <row>
   *         <entry>uchar</entry>
   *         <entry>ushort</entry>
   *       </row>
   *       <row>
   *         <entry>char</entry>
   *         <entry>short</entry>
   *       </row>
   *       <row>
   *         <entry>ushort</entry>
   *         <entry>uint</entry>
   *       </row>
   *       <row>
   *         <entry>short</entry>
   *         <entry>int</entry>
   *       </row>
   *       <row>
   *         <entry>uint</entry>
   *         <entry>uint</entry>
   *       </row>
   *       <row>
   *         <entry>int</entry>
   *         <entry>int</entry>
   *       </row>
   *       <row>
   *         <entry>float</entry>
   *         <entry>float</entry>
   *       </row>
   *       <row>
   *         <entry>double</entry>
   *         <entry>double</entry>
   *       </row>
   *       <row>
   *         <entry>complex</entry>
   *         <entry>complex</entry>
   *       </row>
   *       <row>
   *         <entry>double complex</entry>
   *         <entry>double complex</entry>
   *       </row>
   *     </tbody>
   *   </tgroup>
   * </table>
   * }</pre>
   *
   * <p>In other words, the output type is just large enough to hold the whole
   * range of possible values.</p>
   *
   * <p>See also: {@link #add}, {@link #linear}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage multiply(VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "multiply", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Read a OpenEXR file into a VIPS image.</p>
   *
   * <p>The reader can handle scanline and tiled OpenEXR images. It can't handle
   * OpenEXR colour management, image attributes, many pixel formats, anything
   * other than RGBA.</p>
   *
   * <p>This reader uses the rather limited OpenEXR C API. It should really be
   * redone in C++.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage openexrload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "openexrload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Read a virtual slide supported by the OpenSlide library into a VIPS image.
   * OpenSlide supports images in Aperio, Hamamatsu, MIRAX, Sakura, Trestle,
   * and Ventana formats.</p>
   *
   * <p>To facilitate zooming, virtual slide formats include multiple scaled-down
   * versions of the high-resolution image.  These are typically called
   * "levels".  By default, openslideload reads the highest-resolution
   * level (level 0).  Set {@optionalArg level} to the level number you want.</p>
   *
   * <p>In addition to the slide image itself, virtual slide formats sometimes
   * include additional images, such as a scan of the slide's barcode.
   * OpenSlide calls these "associated images".  To read an associated image,
   * set {@optionalArg associated} to the image's name.
   * A slide's associated images are listed in the
   * "slide-associated-images" metadata item.</p>
   *
   * <p>If you set {@optionalArg attachAssociated}, then all associated images are attached as
   * metadata items. Use <code>vips_image_get_image</code> on {@param out} to retrieve them. Images
   * are attached as "openslide-associated-XXXXX", where XXXXX is the name of the
   * associated image.</p>
   *
   * <p>By default, the output of this operator is RGBA. Set {@optionalArg rgb} to enable RGB
   * output.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg level {@link VipsOption.Int} Load this level from the file
   * @optionalArg autocrop {@link VipsOption.Boolean} Crop to image bounds
   * @optionalArg associated {@link VipsOption.String} Load this associated image
   * @optionalArg attach-associated {@link VipsOption.Boolean} Attach all associated images
   * @optionalArg rgb {@link VipsOption.Boolean} Output RGB (not RGBA)
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage openslideload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "openslideload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #openslideload}, but read from a source.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg level {@link VipsOption.Int} Load this level from the file
   * @optionalArg autocrop {@link VipsOption.Boolean} Crop to image bounds
   * @optionalArg associated {@link VipsOption.String} Load this associated image
   * @optionalArg attach-associated {@link VipsOption.Boolean} Attach all associated images
   * @optionalArg rgb {@link VipsOption.Boolean} Output RGB (not RGBA)
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage openslideloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "openslideload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Render a PDF file into a VIPS image.</p>
   *
   * <p>The output image is always RGBA --- CMYK PDFs will be
   * converted. If you need CMYK bitmaps, you should use {@link #magickload}
   * instead.</p>
   *
   * <p>Use {@optionalArg page} to select a page to render, numbering from zero.</p>
   *
   * <p>Use {@optionalArg n} to select the number of pages to render. The default is 1. Pages are
   * rendered in a vertical column, with each individual page aligned to the
   * left. Set to -1 to mean "until the end of the document". Use {@link #grid}
   * to change page layout.</p>
   *
   * <p>Use {@optionalArg dpi} to set the rendering resolution. The default is 72. Additionally,
   * you can scale by setting {@optionalArg scale}. If you set both, they combine.</p>
   *
   * <p>Use {@optionalArg background} to set the background RGBA colour. The default is 255
   * (solid white), use eg. 0 for a transparent background.</p>
   *
   * <p>Use {@optionalArg password} to supply a decryption password.</p>
   *
   * <p>The operation fills a number of header fields with metadata, for example
   * "pdf-author". They may be useful.</p>
   *
   * <p>This function only reads the image header and does not render any pixel
   * data. Rendering occurs when pixels are accessed.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>, {@link #magickload}.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg dpi {@link VipsOption.Double} DPI to render at
   * @optionalArg scale {@link VipsOption.Double} Factor to scale by
   * @optionalArg background {@link VipsOption.ArrayDouble} Background colour
   * @optionalArg password {@link VipsOption.String} Password to decrypt with
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage pdfload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "pdfload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Read a PDF-formatted memory buffer into a VIPS image. Exactly as
   * {@link #pdfload}, but read from memory.</p>
   *
   * <p>You must not free the buffer while {@param out} is active. The
   * #VipsObject::postclose signal on {@param out} is a good place to free.</p>
   *
   * <p>See also: {@link #pdfload}.</p>
   * @param buffer Buffer to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg dpi {@link VipsOption.Double} DPI to render at
   * @optionalArg scale {@link VipsOption.Double} Factor to scale by
   * @optionalArg background {@link VipsOption.ArrayDouble} Background colour
   * @optionalArg password {@link VipsOption.String} Password to decrypt with
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage pdfloadBuffer(VBlob buffer, VipsOption... args) throws VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "pdfload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #pdfload}, but read from a source.</p>
   *
   * <p>See also: {@link #pdfload}</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg dpi {@link VipsOption.Double} DPI to render at
   * @optionalArg scale {@link VipsOption.Double} Factor to scale by
   * @optionalArg background {@link VipsOption.ArrayDouble} Background colour
   * @optionalArg password {@link VipsOption.String} Password to decrypt with
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage pdfloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "pdfload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>percent returns (through the {@param threshold} parameter) the threshold
   * below which there are {@param percent} values of {@param in}. For example:</p>
   *
   * <pre>{@code 
   * $ vips percent k2.jpg 90
   * 214
   * }</pre>
   *
   * <p>Means that 90% of pixels in `k2.jpg` have a value less than 214.</p>
   *
   * <p>The function works for uchar and ushort images only.  It can be used
   * to threshold the scaled result of a filtering operation.</p>
   *
   * <p>See also: <code>vips_hist_find</code>, {@link #profile}.</p>
   * @param percent Percent of pixels
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Create a one-band float image of Perlin noise. See:</p>
   *
   * <p>https://en.wikipedia.org/wiki/Perlin_noise</p>
   *
   * <p>Use {@optionalArg cellSize} to set the size of the cells from which the image is
   * constructed. The default is 256 x 256.</p>
   *
   * <p>If {@param width} and {@param height} are multiples of {@optionalArg cellSize}, the image will tessellate.</p>
   *
   * <p>Normally, output pixels are {@link VipsBandFormat#FORMAT_FLOAT} in the range [-1, +1]. Set
   * {@optionalArg uchar} to output a uchar image with pixels in [0, 255].</p>
   *
   * <p>See also: {@link #worley}, {@link #fractsurf}, {@link #gaussnoise}.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg cell-size {@link VipsOption.Int} Size of Perlin cells
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg seed {@link VipsOption.Int} Random number seed
   */
  public VImage perlin(int width, int height, VipsOption... args) throws VipsError {
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

  /**
   * <p>Convert the two input images to Fourier space, calculate phase-correlation,
   * back to real space.</p>
   *
   * <p>See also: {@link #fwfft}, <code>vips_cross_phase</code>,</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage phasecor(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var in2Option = VipsOption.Image("in2", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(in2Option);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "phasecor", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Read a PNG file into a VIPS image. It can read all png images, including 8-
   * and 16-bit images, 1 and 3 channel, with and without an alpha channel.</p>
   *
   * <p>Any ICC profile is read and attached to the VIPS image. It also supports
   * XMP metadata.</p>
   *
   * <p>Use {@optionalArg failOn} to set the type of error that will cause load to fail. By
   * default, loaders are permissive, that is, {@link app.photofox.vipsffm.enums.VipsFailOn#FAIL_ON_NONE}.</p>
   *
   * <p>By default, the PNG loader limits the number of text and data chunks to
   * block some denial of service attacks. Set {@optionalArg unlimited} to disable these
   * limits.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg unlimited {@link VipsOption.Boolean} Remove all denial of service limits
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage pngload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "pngload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #pngload}, but read from a PNG-formatted memory block.</p>
   *
   * <p>You must not free the buffer while {@param out} is active. The
   * #VipsObject::postclose signal on {@param out} is a good place to free.</p>
   *
   * <p>See also: {@link #pngload}.</p>
   * @param buffer Buffer to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg unlimited {@link VipsOption.Boolean} Remove all denial of service limits
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage pngloadBuffer(VBlob buffer, VipsOption... args) throws VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "pngload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #pngload}, but read from a source.</p>
   *
   * <p>See also: {@link #pngload}.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg unlimited {@link VipsOption.Boolean} Remove all denial of service limits
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage pngloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "pngload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Write a VIPS image to a file as PNG.</p>
   *
   * <p>{@optionalArg compression} means compress with this much effort (0 - 9). Default 6.</p>
   *
   * <p>Set {@optionalArg interlace} to <code>TRUE</code> to interlace the image with ADAM7
   * interlacing. Beware
   * than an interlaced PNG can be up to 7 times slower to write than a
   * non-interlaced image.</p>
   *
   * <p>Use {@optionalArg filter} to specify one or more filters, defaults to none,
   * see #VipsForeignPngFilter.</p>
   *
   * <p>The image is automatically converted to RGB, RGBA, Monochrome or Mono +
   * alpha before saving. Images with more than one byte per band element are
   * saved as 16-bit PNG, others are saved as 8-bit PNG.</p>
   *
   * <p>Set {@optionalArg palette} to <code>TRUE</code> to enable palette mode for RGB or RGBA images. A
   * palette will be computed with enough space for {@optionalArg bitdepth} (1, 2, 4 or 8)
   * bits. Use {@optionalArg Q} to set the optimisation effort, {@optionalArg dither} to set the degree of
   * Floyd-Steinberg dithering and {@optionalArg effort} to control the CPU effort
   * (1 is the fastest, 10 is the slowest, 7 is the default).
   * This feature requires libvips to be compiled with libimagequant.</p>
   *
   * <p>The default {@optionalArg bitdepth} is either 8 or 16 depending on the interpretation.
   * You can also set {@optionalArg bitdepth} for mono and mono + alpha images, and the image
   * will be quantized.</p>
   *
   * <p>XMP metadata is written to the XMP chunk. PNG comments are written to
   * separate text chunks.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg compression {@link VipsOption.Int} Compression factor
   * @optionalArg interlace {@link VipsOption.Boolean} Interlace image
   * @optionalArg filter {@link VipsOption.Int} Libspng row filter flag(s)
   * @optionalArg palette {@link VipsOption.Boolean} Quantise to 8bpp palette
   * @optionalArg colours {@link VipsOption.Int} Max number of palette colours
   * @optionalArg Q {@link VipsOption.Int} Quantisation quality
   * @optionalArg dither {@link VipsOption.Double} Amount of dithering
   * @optionalArg bitdepth {@link VipsOption.Int} Write as a 1, 2, 4, 8 or 16 bit image
   * @optionalArg effort {@link VipsOption.Int} Quantisation CPU effort
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void pngsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "pngsave", callArgs);
  }

  /**
   * <p>As {@link #pngsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in <code>@buf</code>, the length of the buffer in
   * <code>@len</code>. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link #pngsave}, <code>vips_image_write_to_file</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg compression {@link VipsOption.Int} Compression factor
   * @optionalArg interlace {@link VipsOption.Boolean} Interlace image
   * @optionalArg filter {@link VipsOption.Int} Libspng row filter flag(s)
   * @optionalArg palette {@link VipsOption.Boolean} Quantise to 8bpp palette
   * @optionalArg colours {@link VipsOption.Int} Max number of palette colours
   * @optionalArg Q {@link VipsOption.Int} Quantisation quality
   * @optionalArg dither {@link VipsOption.Double} Amount of dithering
   * @optionalArg bitdepth {@link VipsOption.Int} Write as a 1, 2, 4, 8 or 16 bit image
   * @optionalArg effort {@link VipsOption.Int} Quantisation CPU effort
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public VBlob pngsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "pngsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /**
   * <p>As {@link #pngsave}, but save to a target.</p>
   *
   * <p>See also: {@link #pngsave}, <code>vips_image_write_to_target</code>.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg compression {@link VipsOption.Int} Compression factor
   * @optionalArg interlace {@link VipsOption.Boolean} Interlace image
   * @optionalArg filter {@link VipsOption.Int} Libspng row filter flag(s)
   * @optionalArg palette {@link VipsOption.Boolean} Quantise to 8bpp palette
   * @optionalArg colours {@link VipsOption.Int} Max number of palette colours
   * @optionalArg Q {@link VipsOption.Int} Quantisation quality
   * @optionalArg dither {@link VipsOption.Double} Amount of dithering
   * @optionalArg bitdepth {@link VipsOption.Int} Write as a 1, 2, 4, 8 or 16 bit image
   * @optionalArg effort {@link VipsOption.Int} Quantisation CPU effort
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void pngsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "pngsave_target", callArgs);
  }

  /**
   * <p>Read a PPM/PBM/PGM/PFM file into a VIPS image.</p>
   *
   * <p>It can read 1, 8, 16 and 32 bit images, colour or monochrome,
   * stored in binary or in ASCII. One bit images become 8 bit VIPS images,
   * with 0 and 255 for 0 and 1.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage ppmload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "ppmload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #ppmload}, but read from a source.</p>
   *
   * <p>See also: {@link #ppmload}.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage ppmloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "ppmload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Write a VIPS image to a file as PPM. It can write 1, 8, 16 or
   * 32 bit unsigned integer images, float images, colour or monochrome,
   * stored as binary or ASCII.
   * Integer images of more than 8 bits can only be stored in ASCII.</p>
   *
   * <p>When writing float (PFM) images the scale factor is set from the
   * "pfm-scale" metadata.</p>
   *
   * <p>Set {@optionalArg ascii} to <code>TRUE</code> to write as human-readable ASCII. Normally data is
   * written in binary.</p>
   *
   * <p>Set {@optionalArg bitdepth} to 1 to write a one-bit image.</p>
   *
   * <p>{@optionalArg format} defaults to the sub-type for this filename suffix.</p>
   *
   * <p>See also: <code>vips_image_write_to_file</code>.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg format {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignPpmFormat} Format to save in
   * @optionalArg ascii {@link VipsOption.Boolean} Save as ascii
   * @optionalArg squash {@link VipsOption.Boolean} Save as one bit
   * @optionalArg bitdepth {@link VipsOption.Int} Set to 1 to write as a 1 bit image
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void ppmsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "ppmsave", callArgs);
  }

  /**
   * <p>As {@link #ppmsave}, but save to a target.</p>
   *
   * <p>See also: {@link #ppmsave}.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg format {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignPpmFormat} Format to save in
   * @optionalArg ascii {@link VipsOption.Boolean} Save as ascii
   * @optionalArg squash {@link VipsOption.Boolean} Save as one bit
   * @optionalArg bitdepth {@link VipsOption.Int} Set to 1 to write as a 1 bit image
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void ppmsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "ppmsave_target", callArgs);
  }

  /**
   * <p>Premultiplies any alpha channel.
   * The final band is taken to be the alpha
   * and the bands are transformed as:</p>
   *
   * <pre>{@code 
   *   alpha = clip(0, in[in.bands - 1], {@optionalArg maxAlpha});
   *   norm = alpha / {@optionalArg maxAlpha};
   *   out = [in[0] * norm, ..., in[in.bands - 1] * norm, alpha];
   * }</pre>
   *
   * <p>So for an N-band image, the first N - 1 bands are multiplied by the clipped
   * and normalised final band, the final band is clipped.
   * If there is only a single band,
   * the image is passed through unaltered.</p>
   *
   * <p>The result is
   * {@link VipsBandFormat#FORMAT_FLOAT} unless the input format is {@link VipsBandFormat#FORMAT_DOUBLE}, in which
   * case the output is double as well.</p>
   *
   * <p>{@optionalArg maxAlpha} has the default value 255, or 65535 for images tagged as
   * {@link VipsInterpretation#INTERPRETATION_RGB16} or
   * {@link VipsInterpretation#INTERPRETATION_GREY16}.</p>
   *
   * <p>Non-complex images only.</p>
   *
   * <p>See also: {@link #unpremultiply}, {@link #flatten}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg max-alpha {@link VipsOption.Double} Maximum value of alpha channel
   */
  public VImage premultiply(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "premultiply", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Prewitt edge detector.</p>
   *
   * <p>uchar images are computed using a fast, low-precision path. Cast to float
   * for a high-precision implementation.</p>
   *
   * <p>See also: {@link #canny}, {@link #sobel}, prewitt, {@link #scharr}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage prewitt(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "prewitt", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>profile searches inward from the edge of {@param in} and finds the
   * first non-zero pixel. Pixels in {@param columns} have the distance from the top edge
   * to the first non-zero pixel in that column, {@param rows} has the distance from the
   * left edge to the first non-zero pixel in that row.</p>
   *
   * <p>See also: {@link #project}, <code>vips_hist_find</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage profile(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var columnsOption = VipsOption.Image("columns");
    var rowsOption = VipsOption.Image("rows");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(columnsOption);
    callArgs.add(rowsOption);
    VipsInvoker.invokeOperation(arena, "profile", callArgs);
    return columnsOption.valueOrThrow();
  }

  /**
   * <p>Find the horizontal and vertical projections of an image, ie. the sum
   * of every row of pixels, and the sum of every column of pixels. The output
   * format is uint, int or double, depending on the input format.</p>
   *
   * <p>Non-complex images only.</p>
   *
   * <p>See also: <code>vips_hist_find</code>, {@link #profile}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage project(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var columnsOption = VipsOption.Image("columns");
    var rowsOption = VipsOption.Image("rows");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(columnsOption);
    callArgs.add(rowsOption);
    VipsInvoker.invokeOperation(arena, "project", callArgs);
    return columnsOption.valueOrThrow();
  }

  /**
   * <p>This operation is unfinished and unusable, sorry.</p>
   *
   * <p>See also: {@link #affine}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg interpolate {@link VipsOption.Interpolate} Interpolate values with this
   */
  public VImage quadratic(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var coeffOption = VipsOption.Image("coeff", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(coeffOption);
    VipsInvoker.invokeOperation(arena, "quadratic", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Unpack a RAD ({@link app.photofox.vipsffm.enums.VipsCoding#CODING_RAD}) image to a three-band float image.</p>
   *
   * <p>See also: {@link #float2rad}, {@link #LabQ2LabS}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage rad2float(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "rad2float", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Read a Radiance (HDR) file into a VIPS image.</p>
   *
   * <p>Radiance files are read as {@link app.photofox.vipsffm.enums.VipsCoding#CODING_RAD}. They have one byte for each of
   * red, green and blue, and one byte of shared exponent. Some operations (like
   * <code>vips_extract_area</code>) can work directly with images in this format, but
   * mmany (all the arithmetic operations, for example) will not. Unpack
   * {@link app.photofox.vipsffm.enums.VipsCoding#CODING_RAD} images to 3 band float with {@link #rad2float} if
   * you want to do arithmetic on them.</p>
   *
   * <p>This operation ignores some header fields, like VIEW and DATE. It will not
   * rotate/flip as the FORMAT string asks.</p>
   *
   * <p>Sections of this reader from Greg Ward and Radiance with kind permission.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage radload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "radload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #radload}, but read from a HDR-formatted memory block.</p>
   *
   * <p>You must not free the buffer while {@param out} is active. The
   * #VipsObject::postclose signal on {@param out} is a good place to free.</p>
   *
   * <p>See also: {@link #radload}.</p>
   * @param buffer Buffer to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage radloadBuffer(VBlob buffer, VipsOption... args) throws VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "radload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #radload}, but read from a source.</p>
   *
   * <p>See also: {@link #radload}.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage radloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "radload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Write a VIPS image in Radiance (HDR) format.</p>
   *
   * <p>Sections of this reader from Greg Ward and Radiance with kind permission.</p>
   *
   * <p>See also: <code>vips_image_write_to_file</code>.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void radsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "radsave", callArgs);
  }

  /**
   * <p>As {@link #radsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in <code>@buf</code>, the length of the buffer in
   * <code>@len</code>. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link #radsave}, <code>vips_image_write_to_file</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public VBlob radsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "radsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /**
   * <p>As {@link #radsave}, but save to a target.</p>
   *
   * <p>See also: {@link #radsave}.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void radsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "radsave_target", callArgs);
  }

  /**
   * <p>rank does rank filtering on an image. A window of size {@param width} by
   * {@param height} is passed over the image. At each position, the pixels inside the
   * window are sorted into ascending order and the pixel at position {@param index} is
   * output. {@param index} numbers from 0.</p>
   *
   * <p>It works for any non-complex image type, with any number of bands.
   * The input is expanded by copying edge pixels before performing the
   * operation so that the output image has the same size as the input.
   * Edge pixels in the output image are therefore only approximate.</p>
   *
   * <p>For a median filter with mask size m (3 for 3x3, 5 for 5x5, etc.) use
   *
   *  vips_rank(in, out, m, m, m * m / 2);</p>
   *
   * <p>The special cases n == 0 and n == m * m - 1 are useful dilate and
   * expand operators.</p>
   *
   * <p>See also: {@link #conv}, <code>vips_median</code>, {@link #spcor}.</p>
   * @param width Window width in pixels
   * @param height Window height in pixels
   * @param index Select pixel at index
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>This operation mmaps the file, setting up {@param out} so that access to that
   * image will read from the file.</p>
   *
   * <p>By default, it assumes uchar pixels. Use {@optionalArg format} to select something else.</p>
   *
   * <p>The image will be tagged as {@link VipsInterpretation#INTERPRETATION_MULTIBAND}. Use
   * {@optionalArg interpretation} to select something else.</p>
   *
   * <p>Use {@link #byteswap} to reverse the byte ordering if necessary.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>, {@link #copy}, {@link #byteswap}.</p>
   * @param filename Filename to load from
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param bands Number of bands in image
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg offset {@link VipsOption.Long} Offset in bytes from start of file
   * @optionalArg format {@link VipsOption.Enum} {@link VipsBandFormat} Pixel format in image
   * @optionalArg interpretation {@link VipsOption.Enum} {@link VipsInterpretation} Pixel interpretation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage rawload(String filename, int width, int height, int bands, VipsOption... args)
      throws VipsError {
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

  /**
   * <p>Writes the pixels in {@param in} to the file {@param filename} with no header or other
   * metadata.</p>
   *
   * <p>See also: <code>vips_image_write_to_file</code>.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void rawsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "rawsave", callArgs);
  }

  /**
   * <p>Writes the pixels in {@param in} to the {@param fd} with no header or other
   * metadata.  Handy for implementing other savers.</p>
   *
   * <p>See also: {@link #rawsave}.</p>
   * @param fd File descriptor to write to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void rawsaveFd(int fd, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var fdOption = VipsOption.Int("fd", fd);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(fdOption);
    VipsInvoker.invokeOperation(arena, "rawsave_fd", callArgs);
  }

  /**
   * <p>This operation recombines an image's bands. Each pixel in {@param in} is treated as
   * an n-element vector, where n is the number of bands in {@param in}, and multiplied by
   * the n x m matrix {@param m} to produce the m-band image {@param out}.</p>
   *
   * <p>{@param out} is always float, unless {@param in} is double, in which case {@param out} is double
   * too. No complex images allowed.</p>
   *
   * <p>It's useful for various sorts of colour space conversions.</p>
   *
   * <p>See also: {@link #bandmean}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage recomb(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var mOption = VipsOption.Image("m", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    callArgs.add(mOption);
    VipsInvoker.invokeOperation(arena, "recomb", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Reduce {@param in} by a pair of factors with a pair of 1D kernels. This
   * will not work well for shrink factors greater than three.</p>
   *
   * <p>Set {@optionalArg gap} to speed up reducing by having {@link #shrink} to shrink
   * with a box filter first. The bigger {@optionalArg gap}, the closer the result
   * to the fair resampling. The smaller {@optionalArg gap}, the faster resizing.
   * The default value is 0.0 (no optimization).</p>
   *
   * <p>This is a very low-level operation: see {@link #resize} for a more
   * convenient way to resize images.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link #shrink}, {@link #resize}, {@link #affine}.</p>
   * @param xshrink Horizontal shrink factor
   * @param hshrink Horizontal shrink factor
   * @param yshrink Vertical shrink factor
   * @param vshrink Vertical shrink factor
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg kernel {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsKernel} Resampling kernel
   * @optionalArg gap {@link VipsOption.Double} Reducing gap
   * @optionalArg centre {@link VipsOption.Boolean} Use centre sampling convention
   */
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

  /**
   * <p>Reduce {@param in} horizontally by a float factor. The pixels in {@param out} are
   * interpolated with a 1D mask generated by {@optionalArg kernel}.</p>
   *
   * <p>Set {@optionalArg gap} to speed up reducing by having {@link #shrinkh} to shrink
   * with a box filter first. The bigger {@optionalArg gap}, the closer the result
   * to the fair resampling. The smaller {@optionalArg gap}, the faster resizing.
   * The default value is 0.0 (no optimization).</p>
   *
   * <p>This is a very low-level operation: see {@link #resize} for a more
   * convenient way to resize images.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link #shrink}, {@link #resize}, {@link #affine}.</p>
   * @param xshrink Horizontal shrink factor
   * @param hshrink Horizontal shrink factor
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg kernel {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsKernel} Resampling kernel
   * @optionalArg gap {@link VipsOption.Double} Reducing gap
   * @optionalArg centre {@link VipsOption.Boolean} Use centre sampling convention
   */
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

  /**
   * <p>Reduce {@param in} vertically by a float factor. The pixels in {@param out} are
   * interpolated with a 1D mask generated by {@optionalArg kernel}.</p>
   *
   * <p>Set {@optionalArg gap} to speed up reducing by having {@link #shrinkv} to shrink
   * with a box filter first. The bigger {@optionalArg gap}, the closer the result
   * to the fair resampling. The smaller {@optionalArg gap}, the faster resizing.
   * The default value is 0.0 (no optimization).</p>
   *
   * <p>This is a very low-level operation: see {@link #resize} for a more
   * convenient way to resize images.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link #shrink}, {@link #resize}, {@link #affine}.</p>
   * @param yshrink Vertical shrink factor
   * @param vshrink Vertical shrink factor
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg kernel {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsKernel} Resampling kernel
   * @optionalArg gap {@link VipsOption.Double} Reducing gap
   * @optionalArg centre {@link VipsOption.Boolean} Use centre sampling convention
   */
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

  /**
   * <p>Perform various relational operations on pairs of images.</p>
   *
   * <p>The output type is always uchar, with 0 for FALSE and 255 for TRUE.</p>
   *
   * <p>Less-than and greater-than for complex images compare the modulus.</p>
   *
   * <p>If the images differ in size, the smaller image is enlarged to match the
   * larger by adding zero pixels along the bottom and right.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common format (see table
   * Smallest common format in
   * <code>arithmetic</code>).</p>
   *
   * <p>To decide if pixels match exactly, that is have the same value in every
   * band, use {@link #bandbool} after this operation to AND or OR image bands
   * together.</p>
   *
   * <p>See also: <code>vips_boolean</code>, {@link #bandbool}, <code>vips_relational_const</code>.</p>
   * @param relational {@link VipsOperationRelational} Relational to perform
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage relational(VipsOperationRelational relational, VipsOption... args) throws
      VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", this);
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

  /**
   * <p>Perform various relational operations on an image and an array of
   * constants.</p>
   *
   * <p>The output type is always uchar, with 0 for FALSE and 255 for TRUE.</p>
   *
   * <p>If the array of constants has just one element, that constant is used for
   * all image bands. If the array has more than one element and they have
   * the same number of elements as there are bands in the image, then
   * one array element is used for each band. If the arrays have more than one
   * element and the image only has a single band, the result is a many-band
   * image where each band corresponds to one array element.</p>
   *
   * <p>See also: <code>vips_boolean</code>, {@link #relational}.</p>
   * @param relational {@link VipsOperationRelational} Relational to perform
   * @param c Array of constants
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>This operation calculates {@param left} % {@param right} (remainder after integer division)
   * and writes the result to {@param out}. The images may have any
   * non-complex format. For float formats, remainder calculates <code>@in1</code> -
   * <code>@in2</code> * floor (<code>@in1</code> / <code>@in2</code>).</p>
   *
   * <p>If the images differ in size, the smaller image is enlarged to match the
   * larger by adding zero pixels along the bottom and right.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common format (see table
   * Smallest common format in
   * <code>arithmetic</code>), and that format is the
   * result type.</p>
   *
   * <p>See also: <code>vips_remainder_const</code>, {@link #divide}, {@link #round}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage remainder(VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "remainder", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation calculates {@param in} % {@param c} (remainder after division by an
   * array of constants)
   * and writes the result to {@param out}.
   * The image may have any
   * non-complex format. For float formats, <code>vips_remainder_const</code> calculates
   * {@param in} - {@param c} * floor ({@param in} / {@param c}).</p>
   *
   * <p>If the array of constants has just one element, that constant is used for
   * all image bands. If the array has more than one element and they have
   * the same number of elements as there are bands in the image, then
   * one array element is used for each band. If the arrays have more than one
   * element and the image only has a single band, the result is a many-band
   * image where each band corresponds to one array element.</p>
   *
   * <p>See also: {@link #remainder}, {@link #divide}, {@link #round}.</p>
   * @param c Array of constants
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Repeats an image many times.</p>
   *
   * <p>See also: <code>vips_extract_area</code>.</p>
   * @param across Repeat this many times horizontally
   * @param down Repeat this many times vertically
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Resize an image.</p>
   *
   * <p>Set {@optionalArg gap} to speed up downsizing by having {@link #shrink} to shrink
   * with a box filter first. The bigger {@optionalArg gap}, the closer the result
   * to the fair resampling. The smaller {@optionalArg gap}, the faster resizing.
   * The default value is 2.0 (very close to fair resampling
   * while still being faster in many cases).</p>
   *
   * <p>resize normally uses {@link app.photofox.vipsffm.enums.VipsKernel#KERNEL_LANCZOS3} for the final reduce, you
   * can change this with {@optionalArg kernel}. Downsizing is done with centre convention.</p>
   *
   * <p>When upsizing ({@param scale} &gt; 1), the operation uses {@link #affine} with
   * a #VipsInterpolate selected depending on {@optionalArg kernel}. It will use
   * #VipsInterpolateBicubic for {@link app.photofox.vipsffm.enums.VipsKernel#KERNEL_CUBIC} and above. It adds a
   * 0.5 pixel displacement to the input pixels to get centre convention scaling.</p>
   *
   * <p>resize normally maintains the image aspect ratio. If you set
   * {@optionalArg vscale}, that factor is used for the vertical scale and {@param scale} for the
   * horizontal.</p>
   *
   * <p>If either axis would drop below 1px in size, the shrink in that dimension
   * is limited. This breaks the image aspect ratio, but prevents errors due to
   * fractional pixel sizes.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>This operation does not premultiply alpha. If your image has an alpha
   * channel, you should use {@link #premultiply} on it first.</p>
   *
   * <p>See also: {@link #premultiply}, {@link #shrink}, {@link #reduce}.</p>
   * @param scale Scale image by this factor
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg interpolate {@link VipsOption.Interpolate} Interpolate pixels with this
   * @optionalArg kernel {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsKernel} Resampling kernel
   * @optionalArg gap {@link VipsOption.Double} Reducing gap
   * @optionalArg centre {@link VipsOption.Boolean} Use centre sampling convention
   * @optionalArg vscale {@link VipsOption.Double} Vertical scale image by this factor
   * @optionalArg idx {@link VipsOption.Double} Horizontal input displacement
   * @optionalArg idy {@link VipsOption.Double} Vertical input displacement
   */
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

  /**
   * <p>Rotate {@param in} by a multiple of 90 degrees.</p>
   *
   * <p>Use {@link #similarity} to rotate by an arbitrary angle. {@link #rot45} is
   * useful for rotating convolution masks by 45 degrees.</p>
   *
   * <p>See also: {@link #flip}, {@link #similarity}, {@link #rot45}.</p>
   * @param angle {@link VipsAngle} Angle to rotate image
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Rotate {@param in} by a multiple of 45 degrees. Odd-length sides and square images
   * only.</p>
   *
   * <p>This operation is useful for rotating convolution masks. Use
   * {@link #similarity} to rotate images by arbitrary angles.</p>
   *
   * <p>See also: {@link #rot}, {@link #similarity}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg angle {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAngle45} Angle to rotate image
   */
  public VImage rot45(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "rot45", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operator calls {@link #affine} for you, calculating the matrix for the
   * affine transform from <code>@scale</code> and {@param angle}. Other parameters are passed on to
   * {@link #affine} unaltered.</p>
   *
   * <p>See also: {@link #affine}, #VipsInterpolate.</p>
   * @param angle Rotate anticlockwise by this many degrees
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg interpolate {@link VipsOption.Interpolate} Interpolate pixels with this
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg odx {@link VipsOption.Double} Horizontal output displacement
   * @optionalArg ody {@link VipsOption.Double} Vertical output displacement
   * @optionalArg idx {@link VipsOption.Double} Horizontal input displacement
   * @optionalArg idy {@link VipsOption.Double} Vertical input displacement
   */
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

  /**
   * <p>Round to an integral value.</p>
   *
   * <p>Copy for integer types, round float and
   * complex types.</p>
   *
   * <p>The format of {@param out} is always the same as {@param in}, so you may wish to cast to an
   * integer format afterwards.</p>
   *
   * <p>See also: {@link #cast}</p>
   * @param round {@link VipsOperationRound} Rounding operation to perform
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Convert to HSV.</p>
   *
   * <p>HSV is a crude polar coordinate system for RGB images. It is provided for
   * compatibility with other image processing systems. See {@link #Lab2LCh} for a
   * much better colour space.</p>
   *
   * <p>See also: {@link #HSV2sRGB}, {@link #Lab2LCh}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage sRGB2HSV(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sRGB2HSV", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Convert an sRGB image to scRGB. The input image can be 8 or 16-bit.</p>
   *
   * <p>If the input image is tagged as {@link VipsInterpretation#INTERPRETATION_RGB16}, any extra
   * channels after RGB are divided by 256. Thus, scRGB alpha is
   * always 0 - 255.99.</p>
   *
   * <p>See also: {@link #scRGB2XYZ}, {@link #scRGB2sRGB}, {@link #rad2float}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage sRGB2scRGB(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sRGB2scRGB", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Convert an scRGB image to greyscale. Set {@optionalArg depth} to 16 to get 16-bit output.</p>
   *
   * <p>If {@optionalArg depth} is 16, any extra channels after RGB are
   * multiplied by 256.</p>
   *
   * <p>See also: {@link #LabS2LabQ}, {@link #sRGB2scRGB}, {@link #rad2float}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg depth {@link VipsOption.Int} Output device space depth in bits
   */
  public VImage scRGB2BW(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "scRGB2BW", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Turn XYZ to scRGB.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage scRGB2XYZ(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "scRGB2XYZ", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Convert an scRGB image to sRGB. Set {@optionalArg depth} to 16 to get 16-bit output.</p>
   *
   * <p>If {@optionalArg depth} is 16, any extra channels after RGB are
   * multiplied by 256.</p>
   *
   * <p>See also: {@link #LabS2LabQ}, {@link #sRGB2scRGB}, {@link #rad2float}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg depth {@link VipsOption.Int} Output device space depth in bits
   */
  public VImage scRGB2sRGB(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "scRGB2sRGB", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Search the image for the maximum and minimum value, then return the image
   * as unsigned 8-bit, scaled so that the maximum value is 255 and the
   * minimum is zero.</p>
   *
   * <p>If {@optionalArg log} is set, transform with log10(1.0 + pow(x, {@optionalArg exp})) + .5,
   * then scale so max == 255. By default, {@optionalArg exp} is 0.25.</p>
   *
   * <p>See also: {@link #cast}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg exp {@link VipsOption.Double} Exponent for log scale
   * @optionalArg log {@link VipsOption.Boolean} Log scale
   */
  public VImage scale(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "scale", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Scharr edge detector.</p>
   *
   * <p>uchar images are computed using a fast, low-precision path. Cast to float
   * for a high-precision implementation.</p>
   *
   * <p>See also: {@link #canny}, {@link #sobel}, {@link #prewitt}, scharr.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage scharr(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "scharr", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation behaves rather like {@link #copy} between images
   * {@param in} and {@param out}, except that it checks that pixels on {@param in} are only requested
   * top-to-bottom. This operation is useful for loading file formats which are
   * strictly top-to-bottom, like PNG.</p>
   *
   * <p>{@optionalArg tileHeight} can be used to set the size of the tiles that
   * sequential uses. The default value is 1.</p>
   *
   * <p>See also: {@link #cache}, {@link #linecache}, {@link #tilecache}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg trace {@link VipsOption.Boolean} Trace pixel requests
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Expected access pattern
   */
  public VImage sequential(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sequential", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Selectively sharpen the L channel of a LAB image. The input image is
   * transformed to {@link VipsInterpretation#INTERPRETATION_LABS}.</p>
   *
   * <p>The operation performs a gaussian blur and subtracts from {@param in} to generate a
   * high-frequency signal. This signal is passed through a lookup table formed
   * from the five parameters and added back to {@param in}.</p>
   *
   * <p>The lookup table is formed like this:</p>
   *
   * <pre>{@code 
   * .                     ^
   * .                  y2 |- - - - - -----------
   * .                     |         /
   * .                     |        / slope m2
   * .                     |    .../
   * .             -x1     | ...   |
   * . -------------------...---------------------->
   * .             |   ... |      x1
   * .             |... slope m1
   * .             /       |
   * .            / m2     |
   * .           /         |
   * .          /          |
   * .         /           |
   * .        /            |
   * . ______/ _ _ _ _ _ _ | -y3
   * .                     |
   * }</pre>
   *
   * <p>For screen output, we suggest the following settings (the defaults):</p>
   *
   * <pre>{@code 
   *   sigma == 0.5
   *   x1 == 2
   *   y2 == 10         (don't brighten by more than 10 L*)
   *   y3 == 20         (can darken by up to 20 L*)
   *   m1 == 0          (no sharpening in flat areas)
   *   m2 == 3          (some sharpening in jaggy areas)
   * }</pre>
   *
   * <p>If you want more or less sharpening, we suggest you just change the
   * m2 parameter.</p>
   *
   * <p>The {@optionalArg sigma} parameter changes the width of the fringe and can be
   * adjusted according to the output printing resolution. As an approximate
   * guideline, use 0.5 for 4 pixels/mm (display resolution),
   * 1.0 for 12 pixels/mm and 1.5 for 16 pixels/mm (300 dpi == 12
   * pixels/mm). These figures refer to the image raster, not the half-tone
   * resolution.</p>
   *
   * <p>See also: {@link #conv}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg radius {@link VipsOption.Int} Radius of Gaussian
   * @optionalArg sigma {@link VipsOption.Double} Sigma of Gaussian
   * @optionalArg x1 {@link VipsOption.Double} Flat/jaggy threshold
   * @optionalArg y2 {@link VipsOption.Double} Maximum brightening
   * @optionalArg y3 {@link VipsOption.Double} Maximum darkening
   * @optionalArg m1 {@link VipsOption.Double} Slope for flat areas
   * @optionalArg m2 {@link VipsOption.Double} Slope for jaggy areas
   */
  public VImage sharpen(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sharpen", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Shrink {@param in} by a pair of factors with a simple box filter. For non-integer
   * factors, shrink will first shrink by the integer part with a box
   * filter, then use {@link #reduce} to shrink by the
   * remaining fractional part.</p>
   *
   * <p>This is a very low-level operation: see {@link #resize} for a more
   * convenient way to resize images.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link #resize}, {@link #reduce}.</p>
   * @param xshrink Horizontal shrink factor
   * @param hshrink Horizontal shrink factor
   * @param yshrink Vertical shrink factor
   * @param vshrink Vertical shrink factor
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg ceil {@link VipsOption.Boolean} Round-up output dimensions
   */
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

  /**
   * <p>Shrink {@param in} horizontally by an integer factor. Each pixel in the output is
   * the average of the corresponding line of {@param hshrink} pixels in the input.</p>
   *
   * <p>This is a very low-level operation: see {@link #resize} for a more
   * convenient way to resize images.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link #shrinkv}, {@link #shrink}, {@link #resize}, {@link #affine}.</p>
   * @param xshrink Horizontal shrink factor
   * @param hshrink Horizontal shrink factor
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg ceil {@link VipsOption.Boolean} Round-up output dimensions
   */
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

  /**
   * <p>Shrink {@param in} vertically by an integer factor. Each pixel in the output is
   * the average of the corresponding column of {@param vshrink} pixels in the input.</p>
   *
   * <p>This is a very low-level operation: see {@link #resize} for a more
   * convenient way to resize images.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link #shrinkh}, {@link #shrink}, {@link #resize}, {@link #affine}.</p>
   * @param yshrink Vertical shrink factor
   * @param vshrink Vertical shrink factor
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg ceil {@link VipsOption.Boolean} Round-up output dimensions
   */
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

  /**
   * <p>Finds the unit vector in the direction of the pixel value. For non-complex
   * images, it returns a signed char image with values -1, 0, and 1 for negative,
   * zero and positive pixels. For complex images, it returns a
   * complex normalised to length 1.</p>
   *
   * <p>See also: {@link #abs}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage sign(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sign", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operator calls {@link #affine} for you, calculating the matrix for the
   * affine transform from {@optionalArg scale} and {@optionalArg angle}. Other parameters are passed on to
   * {@link #affine} unaltered.</p>
   *
   * <p>See also: {@link #affine}, #VipsInterpolate.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg scale {@link VipsOption.Double} Scale by this factor
   * @optionalArg angle {@link VipsOption.Double} Rotate anticlockwise by this many degrees
   * @optionalArg interpolate {@link VipsOption.Interpolate} Interpolate pixels with this
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg odx {@link VipsOption.Double} Horizontal output displacement
   * @optionalArg ody {@link VipsOption.Double} Vertical output displacement
   * @optionalArg idx {@link VipsOption.Double} Horizontal input displacement
   * @optionalArg idy {@link VipsOption.Double} Vertical input displacement
   */
  public VImage similarity(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "similarity", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Creates a float one band image of the a sine waveform in two
   * dimensions.</p>
   *
   * <p>The number of horizontal and vertical spatial frequencies are
   * determined by the variables {@optionalArg hfreq} and {@optionalArg vfreq} respectively.  The
   * function is useful for creating displayable sine waves and
   * square waves in two dimensions.</p>
   *
   * <p>If horfreq and verfreq are integers the resultant image is periodical
   * and therefore the Fourier transform does not present spikes</p>
   *
   * <p>Pixels are normally in [-1, +1], set {@optionalArg uchar} to output [0, 255].</p>
   *
   * <p>See also: {@link #grey}, {@link #xyz}.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg hfreq {@link VipsOption.Double} Horizontal spatial frequency
   * @optionalArg vfreq {@link VipsOption.Double} Vertical spatial frequency
   */
  public VImage sines(int width, int height, VipsOption... args) throws VipsError {
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

  /**
   * <p>Crop an image down to a specified width and height by removing boring parts.</p>
   *
   * <p>Use {@optionalArg interesting} to pick the method vips uses to decide which bits of the
   * image should be kept.</p>
   *
   * <p>You can test xoffset / yoffset on {@param out} to find the location of the crop
   * within the input image.</p>
   *
   * <p>See also: <code>vips_extract_area</code>.</p>
   * @param width Width of extract area
   * @param height Height of extract area
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg attention-x {@link VipsOption.Int} Horizontal position of attention centre
   * @optionalArg attention-y {@link VipsOption.Int} Vertical position of attention centre
   * @optionalArg interesting {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsInteresting} How to measure interestingness
   * @optionalArg premultiplied {@link VipsOption.Boolean} Input image already has premultiplied alpha
   */
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

  /**
   * <p>Sobel edge detector.</p>
   *
   * <p>uchar images are computed using a fast, low-precision path. Cast to float
   * for a high-precision implementation.</p>
   *
   * <p>See also: {@link #canny}, sobel, {@link #prewitt}, {@link #scharr}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage sobel(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sobel", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Calculate a correlation surface.</p>
   *
   * <p>{@param ref} is placed at every position in {@param in} and the correlation coefficient
   * calculated. The output
   * image is always float.</p>
   *
   * <p>The output
   * image is the same size as the input. Extra input edge pixels are made by
   * copying the existing edges outwards.</p>
   *
   * <p>The correlation coefficient is calculated as:</p>
   *
   * <pre>{@code 
   *          sumij (ref(i,j)-mean(ref))(inkl(i,j)-mean(inkl))
   * c(k,l) = ------------------------------------------------
   *          sqrt(sumij (ref(i,j)-mean(ref))^2) *
   *                      sqrt(sumij (inkl(i,j)-mean(inkl))^2)
   * }</pre>
   *
   * <p>where inkl is the area of {@param in} centred at position (k,l).</p>
   *
   * <p>from Niblack "An Introduction to Digital Image Processing",
   * Prentice/Hall, pp 138.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The output image is always float, unless either of the two inputs is
   * double, in which case the output is also double.</p>
   *
   * <p>See also: {@link #fastcor}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage spcor(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var refOption = VipsOption.Image("ref", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(refOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "spcor", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Make a displayable (ie. 8-bit unsigned int) power spectrum.</p>
   *
   * <p>If {@param in} is non-complex, it is transformed to Fourier space. Then the
   * absolute value is passed through {@link #scale} in log mode, and {@link #wrap}.</p>
   *
   * <p>See also: {@link #fwfft}, {@link #scale}, {@link #wrap}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage spectrum(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "spectrum", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Find many image statistics in a single pass through the data. {@param out} is a
   * one-band {@link VipsBandFormat#FORMAT_DOUBLE} image of at least 10 columns by n + 1
   * (where n is number of bands in image {@param in})
   * rows. Columns are statistics, and are, in order: minimum, maximum, sum,
   * sum of squares, mean, standard deviation, x coordinate of minimum, y
   * coordinate of minimum, x coordinate of maximum, y coordinate of maximum.
   * Later versions of stats may add more columns.</p>
   *
   * <p>Row 0 has statistics for all
   * bands together, row 1 has stats for band 1, and so on.</p>
   *
   * <p>If there is more than one maxima or minima, one of them will be chosen at
   * random.</p>
   *
   * <p>See also: {@link #avg}, {@link #min}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage stats(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "stats", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>stdif performs statistical differencing according to the formula
   * given in page 45 of the book "An Introduction to Digital Image
   * Processing" by Wayne Niblack. This transformation emphasises the way in
   * which a pel differs statistically from its neighbours. It is useful for
   * enhancing low-contrast images with lots of detail, such as X-ray plates.</p>
   *
   * <p>At point (i,j) the output is given by the equation:</p>
   *
   * <pre>{@code 
   * vout(i,j) = {@optionalArg a} * {@optionalArg m0} + (1 - {@optionalArg a}) * meanv +
   *       (vin(i,j) - meanv) * ({@optionalArg b} * {@optionalArg s0}) / ({@optionalArg s0} + {@optionalArg b} * stdv)
   * }</pre>
   *
   * <p>Values {@optionalArg a}, {@optionalArg m0}, {@optionalArg b} and {@optionalArg s0} are entered, while meanv and stdv are the values
   * calculated over a moving window of size {@param width}, {@param height} centred on pixel
   * (i,j). {@optionalArg m0} is the new mean, {@optionalArg a} is the weight given to it. {@optionalArg s0} is the new
   * standard deviation, {@optionalArg b} is the weight given to it.</p>
   *
   * <p>Try:</p>
   *
   * <pre>{@code 
   * vips stdif $VIPSHOME/pics/huysum.v fred.v 0.5 128 0.5 50 11 11
   * }</pre>
   *
   * <p>The operation works on one-band uchar images only, and writes a one-band
   * uchar image as its result. The output image has the same size as the
   * input.</p>
   *
   * <p>See also: <code>vips_hist_local</code>.</p>
   * @param width Window width in pixels
   * @param height Window height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg s0 {@link VipsOption.Double} New deviation
   * @optionalArg b {@link VipsOption.Double} Weight of new deviation
   * @optionalArg m0 {@link VipsOption.Double} New mean
   * @optionalArg a {@link VipsOption.Double} Weight of new mean
   */
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

  /**
   * <p>Subsample an image by an integer fraction. This is fast, nearest-neighbour
   * shrink.</p>
   *
   * <p>For small horizontal shrinks, this operation will fetch lines of pixels
   * from <code>@in</code> and then subsample that line. For large shrinks it will fetch
   * single pixels.</p>
   *
   * <p>If {@optionalArg point} is set, <code>@in</code> will always be sampled in points. This can be faster
   * if the previous operations in the pipeline are very slow.</p>
   *
   * <p>See also: {@link #affine}, {@link #shrink}, {@link #zoom}.</p>
   * @param xfac Horizontal subsample factor
   * @param yfac Vertical subsample factor
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg point {@link VipsOption.Boolean} Point sample
   */
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

  /**
   * <p>This operation calculates <code>@in1</code> - <code>@in2</code> and writes the result to {@param out}.</p>
   *
   * <p>If the images differ in size, the smaller image is enlarged to match the
   * larger by adding zero pixels along the bottom and right.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common format (see table
   * Smallest common format in
   * <code>arithmetic</code>), then the
   * following table is used to determine the output type:</p>
   *
   * <pre>{@code
   * <table>
   *   <title>VipsSubtract type promotion</title>
   *   <tgroup cols='2' align='left' colsep='1' rowsep='1'>
   *     <thead>
   *       <row>
   *         <entry>input type</entry>
   *         <entry>output type</entry>
   *       </row>
   *     </thead>
   *     <tbody>
   *       <row>
   *         <entry>uchar</entry>
   *         <entry>short</entry>
   *       </row>
   *       <row>
   *         <entry>char</entry>
   *         <entry>short</entry>
   *       </row>
   *       <row>
   *         <entry>ushort</entry>
   *         <entry>int</entry>
   *       </row>
   *       <row>
   *         <entry>short</entry>
   *         <entry>int</entry>
   *       </row>
   *       <row>
   *         <entry>uint</entry>
   *         <entry>int</entry>
   *       </row>
   *       <row>
   *         <entry>int</entry>
   *         <entry>int</entry>
   *       </row>
   *       <row>
   *         <entry>float</entry>
   *         <entry>float</entry>
   *       </row>
   *       <row>
   *         <entry>double</entry>
   *         <entry>double</entry>
   *       </row>
   *       <row>
   *         <entry>complex</entry>
   *         <entry>complex</entry>
   *       </row>
   *       <row>
   *         <entry>double complex</entry>
   *         <entry>double complex</entry>
   *       </row>
   *     </tbody>
   *   </tgroup>
   * </table>
   * }</pre>
   *
   * <p>In other words, the output type is just large enough to hold the whole
   * range of possible values.</p>
   *
   * <p>See also: {@link #add}, {@link #linear}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage subtract(VipsOption... args) throws VipsError {
    var leftOption = VipsOption.Image("left", this);
    var rightOption = VipsOption.Image("right", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(leftOption);
    callArgs.add(rightOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "subtract", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation sums all images in {@param in} and writes the result to {@param out}.</p>
   *
   * <p>If the images differ in size, the smaller images are enlarged to match the
   * largest by adding zero pixels along the bottom and right.</p>
   *
   * <p>If the number of bands differs, all but one of the images
   * must have one band. In this case, n-band images are formed from the
   * one-band images by joining n copies of the one-band images together, and then
   * the n-band images are operated upon.</p>
   *
   * <p>The input images are cast up to the smallest common format (see table
   * Smallest common format in
   * <code>arithmetic</code>), then the
   * following table is used to determine the output type:</p>
   *
   * <pre>{@code
   * <table>
   *   <title>VipsSum type promotion</title>
   *   <tgroup cols='2' align='left' colsep='1' rowsep='1'>
   *     <thead>
   *       <row>
   *         <entry>input type</entry>
   *         <entry>output type</entry>
   *       </row>
   *     </thead>
   *     <tbody>
   *       <row>
   *         <entry>uchar</entry>
   *         <entry>uint</entry>
   *       </row>
   *       <row>
   *         <entry>char</entry>
   *         <entry>int</entry>
   *       </row>
   *       <row>
   *         <entry>ushort</entry>
   *         <entry>uint</entry>
   *       </row>
   *       <row>
   *         <entry>short</entry>
   *         <entry>int</entry>
   *       </row>
   *       <row>
   *         <entry>uint</entry>
   *         <entry>uint</entry>
   *       </row>
   *       <row>
   *         <entry>int</entry>
   *         <entry>int</entry>
   *       </row>
   *       <row>
   *         <entry>float</entry>
   *         <entry>float</entry>
   *       </row>
   *       <row>
   *         <entry>double</entry>
   *         <entry>double</entry>
   *       </row>
   *       <row>
   *         <entry>complex</entry>
   *         <entry>complex</entry>
   *       </row>
   *       <row>
   *         <entry>double complex</entry>
   *         <entry>double complex</entry>
   *       </row>
   *     </tbody>
   *   </tgroup>
   * </table>
   * }</pre>
   *
   * <p>In other words, the output type is just large enough to hold the whole
   * range of possible values.</p>
   *
   * <p>See also: {@link #add}.</p>
   * @param in Array of input images
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage sum(List<VImage> in, VipsOption... args) throws VipsError {
    var inOption = VipsOption.ArrayImage("in", in);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "sum", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Render a SVG file into a VIPS image.  Rendering uses the librsvg library
   * and should be fast.</p>
   *
   * <p>Use {@optionalArg dpi} to set the rendering resolution. The default is 72. You can also
   * scale the rendering by {@optionalArg scale}.</p>
   *
   * <p>This function only reads the image header and does not render any pixel
   * data. Rendering occurs when pixels are accessed.</p>
   *
   * <p>SVGs larger than 10MB are normally blocked for security. Set {@optionalArg unlimited} to
   * allow SVGs of any size.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg dpi {@link VipsOption.Double} Render at this DPI
   * @optionalArg scale {@link VipsOption.Double} Scale output by this factor
   * @optionalArg unlimited {@link VipsOption.Boolean} Allow SVG of any size
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage svgload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "svgload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Read a SVG-formatted memory block into a VIPS image. Exactly as
   * {@link #svgload}, but read from a memory buffer.</p>
   *
   * <p>You must not free the buffer while {@param out} is active. The
   * #VipsObject::postclose signal on {@param out} is a good place to free.</p>
   *
   * <p>See also: {@link #svgload}.</p>
   * @param buffer Buffer to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg dpi {@link VipsOption.Double} Render at this DPI
   * @optionalArg scale {@link VipsOption.Double} Scale output by this factor
   * @optionalArg unlimited {@link VipsOption.Boolean} Allow SVG of any size
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage svgloadBuffer(VBlob buffer, VipsOption... args) throws VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "svgload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #svgload}, but read from a source.</p>
   *
   * <p>See also: {@link #svgload}.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg dpi {@link VipsOption.Double} Render at this DPI
   * @optionalArg scale {@link VipsOption.Double} Scale output by this factor
   * @optionalArg unlimited {@link VipsOption.Boolean} Allow SVG of any size
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage svgloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "svgload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>The {@param tests} images are evaluated and at each point the index of the first
   * non-zero value is written to {@param out}. If all {@param tests} are false, the value
   * (<code>@n</code> + 1) is written.</p>
   *
   * <p>Images in {@param tests} must have one band. They are expanded to the
   * bounding box of the set of images in {@param tests}, and that size is used for
   * {@param out}. {@param tests} can have up to 255 elements.</p>
   *
   * <p>Combine with <code>vips_case</code> to make an efficient multi-way {@link #ifthenelse}.</p>
   *
   * <p>See also: {@link #maplut}, <code>vips_case</code>, {@link #ifthenelse}.</p>
   * @param tests Table of images to test
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage switch1(List<VImage> tests, VipsOption... args) throws VipsError {
    var testsOption = VipsOption.ArrayImage("tests", tests);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(testsOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "switch", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Draw the string {@param text} to an image. {@param out} is normally a one-band 8-bit
   * unsigned char image, with 0 for no text and 255 for text. Values between
   * are used for anti-aliasing.</p>
   *
   * <p>Set {@optionalArg rgba} to enable RGBA output. This is useful for colour emoji rendering,
   * or support for pango markup features like `<span>Red!</span>`.</p>
   *
   * <p>{@param text} is the text to render as a UTF-8 string. It can contain Pango markup,
   * for example `<i>The</i>Guardian`.</p>
   *
   * <p>{@optionalArg font} is the font to render with, as a fontconfig name. Examples might be
   * `sans 12` or perhaps `bitstream charter bold 10`.</p>
   *
   * <p>You can specify a font to load with {@optionalArg fontfile}. You'll need to also set the
   * name of the font with {@optionalArg font}.</p>
   *
   * <p>{@optionalArg width} is the number of pixels to word-wrap at. By default, lines of text
   * wider than this will be broken at word boundaries.
   * Use {@optionalArg wrap} to set lines to wrap on word or character boundaries, or to
   * disable line breaks.</p>
   *
   * <p>Set {@optionalArg justify} to turn on line justification.
   * {@optionalArg align} can be used to set the alignment style for multi-line
   * text to the low (left) edge centre, or high (right) edge. Note that the
   * output image can be wider than {@optionalArg width} if there are no
   * word breaks, or narrower if the lines don't break exactly at {@optionalArg width}.</p>
   *
   * <p>{@optionalArg height} is the maximum number of pixels high the generated text can be. This
   * only takes effect when {@optionalArg dpi} is not set, and {@optionalArg width} is set, making a box.
   * In this case, text will search for a {@optionalArg dpi} and set of line breaks
   * which will just fit the text into {@optionalArg width} and {@optionalArg height}.</p>
   *
   * <p>You can use {@optionalArg autofitDpi} to read out the DPI selected by auto fit.</p>
   *
   * <p>{@optionalArg dpi} sets the resolution to render at. "sans 12" at 72 dpi draws characters
   * approximately 12 pixels high.</p>
   *
   * <p>{@optionalArg spacing} sets the line spacing, in points. It would typically be something
   * like font size times 1.2.</p>
   *
   * <p>You can read the coordinate of the top edge of the character from `Xoffset`
   * / `Yoffset`. This can be helpful if you need to line up the output of
   * several text.</p>
   *
   * <p>See also: {@link #bandjoin}, {@link #composite}.</p>
   * @param text Text to render
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg font {@link VipsOption.String} Font to render with
   * @optionalArg width {@link VipsOption.Int} Maximum image width in pixels
   * @optionalArg height {@link VipsOption.Int} Maximum image height in pixels
   * @optionalArg align {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAlign} Align on the low, centre or high edge
   * @optionalArg justify {@link VipsOption.Boolean} Justify lines
   * @optionalArg dpi {@link VipsOption.Int} DPI to render at
   * @optionalArg autofit-dpi {@link VipsOption.Int} DPI selected by autofit
   * @optionalArg spacing {@link VipsOption.Int} Line spacing
   * @optionalArg fontfile {@link VipsOption.String} Load this font file
   * @optionalArg rgba {@link VipsOption.Boolean} Enable RGBA output
   * @optionalArg wrap {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsTextWrap} Wrap lines on word or character boundaries
   */
  public VImage text(String text, VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var textOption = VipsOption.String("text", text);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    callArgs.add(textOption);
    VipsInvoker.invokeOperation(arena, "text", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Make a thumbnail from a file. Shrinking is done in three stages: using any
   * shrink-on-load features available in the file import library, using a block
   * shrink, and using a lanczos3 shrink. At least the final 200% is done with
   * lanczos3. The output should be high quality, and the operation should be
   * quick.</p>
   *
   * <p>See <code>vips_thumbnail_buffer</code> to thumbnail from a memory buffer, or
   * <code>vips_thumbnail_source</code> to thumbnail from an arbitrary byte source.</p>
   *
   * <p>By default, libvips will only the first frame of animated or multipage
   * images. To thumbnail all pages or frames, pass `n=-1` to the loader in
   * {@param filename}, for example `"x.gif[n=-1]"`.</p>
   *
   * <p>The output image will fit within a square of size {@param width} x {@param width}. You can
   * specify a separate height with the {@optionalArg height} option. Set either {@param width} or
   * {@optionalArg height} to a very large number to ignore that dimension.</p>
   *
   * <p>If you set {@optionalArg crop}, then the output image will fill the whole of the {@param width} x
   * {@optionalArg height} rectangle, with any excess cropped away. See {@link #smartcrop} for
   * details on the cropping strategy.</p>
   *
   * <p>Normally the operation will upsize or downsize as required to fit the image
   * inside or outside the target size. If {@optionalArg size} is set
   * to {@link app.photofox.vipsffm.enums.VipsSize#SIZE_UP}, the operation will only upsize and will just
   * copy if asked to downsize.
   * If {@optionalArg size} is set
   * to {@link app.photofox.vipsffm.enums.VipsSize#SIZE_DOWN}, the operation will only downsize and will just
   * copy if asked to upsize.
   * If {@optionalArg size} is {@link app.photofox.vipsffm.enums.VipsSize#SIZE_FORCE}, the image aspect ratio will be broken and the
   * image will be forced to fit the target.</p>
   *
   * <p>Normally any orientation tags on the input image (such as EXIF tags) are
   * interpreted to rotate the image upright. If you set {@optionalArg noRotate} to <code>TRUE</code>,
   * these tags will not be interpreted.</p>
   *
   * <p>Shrinking is normally done in sRGB colourspace. Set {@optionalArg linear} to shrink in
   * linear light colourspace instead. This can give better results, but can
   * also be far slower, since tricks like JPEG shrink-on-load cannot be used in
   * linear space.</p>
   *
   * <p>If you set {@optionalArg exportProfile} to the filename of an ICC profile, the image
   * will be transformed to the target colourspace before writing to the
   * output. You can also give an {@optionalArg importProfile} which will be used if the
   * input image has no ICC profile, or if the profile embedded in the
   * input image is broken.</p>
   *
   * <p>Use {@optionalArg intent} to set the rendering intent for any ICC transform. The default
   * is {@link app.photofox.vipsffm.enums.VipsIntent#INTENT_RELATIVE}.</p>
   *
   * <p>Use {@optionalArg failOn} to control the types of error that will cause loading to fail.
   * The default is {@link app.photofox.vipsffm.enums.VipsFailOn#FAIL_ON_NONE}, ie. thumbnail is permissive.</p>
   *
   * <p>See also: <code>vips_thumbnail_buffer</code>.</p>
   * @param filename Filename to read from
   * @param width Size to this width
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg height {@link VipsOption.Int} Size to this height
   * @optionalArg size {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsSize} Only upsize, only downsize, or both
   * @optionalArg no-rotate {@link VipsOption.Boolean} Don't use orientation tags to rotate image upright
   * @optionalArg crop {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsInteresting} Reduce to fill target rectangle, then crop
   * @optionalArg linear {@link VipsOption.Boolean} Reduce in linear light
   * @optionalArg import-profile {@link VipsOption.String} Fallback import profile
   * @optionalArg export-profile {@link VipsOption.String} Fallback export profile
   * @optionalArg intent {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsIntent} Rendering intent
   * @optionalArg auto-rotate {@link VipsOption.Boolean} Use orientation tags to rotate image upright
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   */
  public VImage thumbnail(String filename, int width, VipsOption... args) throws VipsError {
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

  /**
   * <p>Exactly as {@link #thumbnail}, but read from a memory buffer. One extra
   * optional argument, {@optionalArg optionString}, lets you pass options to the underlying
   * loader.</p>
   *
   * <p>See also: {@link #thumbnail}.</p>
   * @param buffer Buffer to load from
   * @param width Size to this width
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg option-string {@link VipsOption.String} Options that are passed on to the underlying loader
   * @optionalArg height {@link VipsOption.Int} Size to this height
   * @optionalArg size {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsSize} Only upsize, only downsize, or both
   * @optionalArg no-rotate {@link VipsOption.Boolean} Don't use orientation tags to rotate image upright
   * @optionalArg crop {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsInteresting} Reduce to fill target rectangle, then crop
   * @optionalArg linear {@link VipsOption.Boolean} Reduce in linear light
   * @optionalArg import-profile {@link VipsOption.String} Fallback import profile
   * @optionalArg export-profile {@link VipsOption.String} Fallback export profile
   * @optionalArg intent {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsIntent} Rendering intent
   * @optionalArg auto-rotate {@link VipsOption.Boolean} Use orientation tags to rotate image upright
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   */
  public VImage thumbnailBuffer(VBlob buffer, int width, VipsOption... args) throws VipsError {
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

  /**
   * <p>Exactly as {@link #thumbnail}, but read from an existing image.</p>
   *
   * <p>This operation
   * is not able to exploit shrink-on-load features of image load libraries, so
   * it can be much slower than `{@link #thumbnail}` and produce poorer quality
   * output. Only use it if you really have to.</p>
   *
   * <p>See also: {@link #thumbnail}.</p>
   * @param width Size to this width
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg height {@link VipsOption.Int} Size to this height
   * @optionalArg size {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsSize} Only upsize, only downsize, or both
   * @optionalArg no-rotate {@link VipsOption.Boolean} Don't use orientation tags to rotate image upright
   * @optionalArg crop {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsInteresting} Reduce to fill target rectangle, then crop
   * @optionalArg linear {@link VipsOption.Boolean} Reduce in linear light
   * @optionalArg import-profile {@link VipsOption.String} Fallback import profile
   * @optionalArg export-profile {@link VipsOption.String} Fallback export profile
   * @optionalArg intent {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsIntent} Rendering intent
   * @optionalArg auto-rotate {@link VipsOption.Boolean} Use orientation tags to rotate image upright
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   */
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

  /**
   * <p>Exactly as {@link #thumbnail}, but read from a source. One extra
   * optional argument, {@optionalArg optionString}, lets you pass options to the underlying
   * loader.</p>
   *
   * <p>See also: {@link #thumbnail}.</p>
   * @param source Source to load from
   * @param width Size to this width
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg option-string {@link VipsOption.String} Options that are passed on to the underlying loader
   * @optionalArg height {@link VipsOption.Int} Size to this height
   * @optionalArg size {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsSize} Only upsize, only downsize, or both
   * @optionalArg no-rotate {@link VipsOption.Boolean} Don't use orientation tags to rotate image upright
   * @optionalArg crop {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsInteresting} Reduce to fill target rectangle, then crop
   * @optionalArg linear {@link VipsOption.Boolean} Reduce in linear light
   * @optionalArg import-profile {@link VipsOption.String} Fallback import profile
   * @optionalArg export-profile {@link VipsOption.String} Fallback export profile
   * @optionalArg intent {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsIntent} Rendering intent
   * @optionalArg auto-rotate {@link VipsOption.Boolean} Use orientation tags to rotate image upright
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   */
  public VImage thumbnailSource(VSource source, int width, VipsOption... args) throws VipsError {
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

  /**
   * <p>during load</p>
   *
   * <p>Read a TIFF file into a VIPS image. It is a full baseline TIFF 6 reader,
   * with extensions for tiled images, multipage images, XYZ and LAB colour
   * space, pyramidal images and JPEG compression, including CMYK and YCbCr.</p>
   *
   * <p>{@optionalArg page} means load this page from the file. By default the first page (page
   * 0) is read.</p>
   *
   * <p>{@optionalArg n} means load this many pages. By default a single page is read. All the
   * pages must have the same dimensions, and they are loaded as a tall, thin
   * "toilet roll" image. The <code>VIPS_META_PAGE_HEIGHT</code> metadata
   * tag gives the height in pixels of each page. Use -1 to load all pages.</p>
   *
   * <p>Setting {@optionalArg autorotate} to <code>TRUE</code> will make the loader interpret the
   * orientation tag and automatically rotate the image appropriately during
   * load.</p>
   *
   * <p>If {@optionalArg autorotate} is <code>FALSE</code>, the metadata field <code>VIPS_META_ORIENTATION</code> is set
   * to the value of the orientation tag. Applications may read and interpret
   * this field
   * as they wish later in processing. See {@link #autorot}. Save
   * operations will use <code>VIPS_META_ORIENTATION</code>, if present, to set the
   * orientation of output images.</p>
   *
   * <p>If {@optionalArg autorotate} is TRUE, the image will be rotated upright during load and
   * no metadata attached. This can be very slow.</p>
   *
   * <p>If {@optionalArg subifd} is -1 (the default), the main image is selected for each page.
   * If it is 0 or greater and there is a SUBIFD tag, the indexed SUBIFD is
   * selected. This can be used to read lower resolution layers from
   * bioformats-style image pyramids.</p>
   *
   * <p>Any ICC profile is read and attached to the VIPS image as
   * <code>VIPS_META_ICC_NAME</code>. Any XMP metadata is read and attached to the image
   * as <code>VIPS_META_XMP_NAME</code>. Any IPTC is attached as <code>VIPS_META_IPTC_NAME</code>. The
   * image description is
   * attached as <code>VIPS_META_IMAGEDESCRIPTION</code>. Data in the photoshop tag is
   * attached as <code>VIPS_META_PHOTOSHOP_NAME</code>.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>, {@link #autorot}.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg subifd {@link VipsOption.Int} Subifd index
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg autorotate {@link VipsOption.Boolean} Rotate image using orientation tag
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage tiffload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "tiffload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>during load</p>
   *
   * <p>Read a TIFF-formatted memory block into a VIPS image. Exactly as
   * {@link #tiffload}, but read from a memory source.</p>
   *
   * <p>You must not free the buffer while {@param out} is active. The
   * #VipsObject::postclose signal on {@param out} is a good place to free.</p>
   *
   * <p>See also: {@link #tiffload}.</p>
   * @param buffer Buffer to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg subifd {@link VipsOption.Int} Subifd index
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg autorotate {@link VipsOption.Boolean} Rotate image using orientation tag
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage tiffloadBuffer(VBlob buffer, VipsOption... args) throws VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "tiffload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>during load</p>
   *
   * <p>Exactly as {@link #tiffload}, but read from a source.</p>
   *
   * <p>See also: {@link #tiffload}.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg subifd {@link VipsOption.Int} Subifd index
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg autorotate {@link VipsOption.Boolean} Rotate image using orientation tag
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage tiffloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "tiffload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Write a VIPS image to a file as TIFF.</p>
   *
   * <p>If {@param in} has the <code>VIPS_META_PAGE_HEIGHT</code> metadata item, this is assumed to be a
   * "toilet roll" image. It will be
   * written as series of pages, each <code>VIPS_META_PAGE_HEIGHT</code> pixels high.</p>
   *
   * <p>Use {@optionalArg compression} to set the tiff compression. Currently jpeg, packbits,
   * fax4, lzw, none, deflate, webp and zstd are supported. The default is no
   * compression.
   * JPEG compression is a good lossy compressor for photographs, packbits is
   * good for 1-bit images, and deflate is the best lossless compression TIFF
   * can do.</p>
   *
   * <p>XYZ images are automatically saved as libtiff LOGLUV with SGILOG compression.
   * Float LAB images are saved as float CIELAB. Set {@optionalArg bitdepth} to save as 8-bit
   * CIELAB.</p>
   *
   * <p>Use {@optionalArg Q} to set the JPEG compression factor. Default 75.</p>
   *
   * <p>User {@optionalArg level} to set the ZSTD compression level. Use {@optionalArg lossless} to
   * set WEBP lossless mode on. Use {@optionalArg Q} to set the WEBP compression level.</p>
   *
   * <p>Use {@optionalArg predictor} to set the predictor for lzw, deflate and zstd compression.
   * It defaults to {@link app.photofox.vipsffm.enums.VipsForeignTiffPredictor#FOREIGN_TIFF_PREDICTOR_HORIZONTAL}, meaning horizontal
   * differencing. Please refer to the libtiff
   * specifications for further discussion of various predictors.</p>
   *
   * <p>Set {@optionalArg tile} to TRUE to write a tiled tiff.  By default tiff are written in
   * strips. Use {@optionalArg tileWidth} and {@optionalArg tileHeight} to set the tile size. The defaiult
   * is 128 by 128.</p>
   *
   * <p>Set {@optionalArg pyramid} to write the image as a set of images, one per page, of
   * decreasing size. Use {@optionalArg regionShrink} to set how images will be shrunk: by
   * default each 2x2 block is just averaged, but you can set MODE or MEDIAN as
   * well.</p>
   *
   * <p>By default, the pyramid stops when the image is small enough to fit in one
   * tile. Use {@optionalArg depth} to stop when the image fits in one pixel, or to only write
   * a single layer.</p>
   *
   * <p>Set {@optionalArg bitdepth} to save 8-bit uchar images as 1, 2 or 4-bit TIFFs.
   * In case of depth 1: Values &gt;128 are written as white, values &le;128 as black.
   * Normally vips will write MINISBLACK TIFFs where black is a 0 bit, but if you
   * set {@optionalArg miniswhite}, it will use 0 for a white bit. Many pre-press applications
   * only work with images which use this sense. {@optionalArg miniswhite} only affects one-bit
   * images, it does nothing for greyscale images.
   * In case of depth 2: The same holds but values &lt; 64 are written as black.
   * For 64 &le; values &lt; 128 they are written as dark grey, for 128 &le; values &lt; 192
   * they are written as light gray and values above are written as white.
   * In case {@optionalArg miniswhite} is set to true this behavior is inverted.
   * In case of depth 4: values &lt; 16 are written as black, and so on for the
   * lighter shades. In case {@optionalArg miniswhite} is set to true this behavior is inverted.</p>
   *
   * <p>Use {@optionalArg resunit} to override the default resolution unit.
   * The default
   * resolution unit is taken from the header field
   * <code>VIPS_META_RESOLUTION_UNIT</code>. If this field is not set, then
   * VIPS defaults to cm.</p>
   *
   * <p>Use {@optionalArg xres} and {@optionalArg yres} to override the default horizontal and vertical
   * resolutions. By default these values are taken from the VIPS image header.
   * libvips resolution is always in pixels per millimetre.</p>
   *
   * <p>Set {@optionalArg bigtiff} to attempt to write a bigtiff. Bigtiff is a variant of the TIFF
   * format that allows more than 4GB in a file.</p>
   *
   * <p>Set {@optionalArg properties} to write all vips metadata to the IMAGEDESCRIPTION tag as
   * xml. If {@optionalArg properties} is not set, the value of <code>VIPS_META_IMAGEDESCRIPTION</code> is
   * used instead.</p>
   *
   * <p>The value of <code>VIPS_META_XMP_NAME</code> is written to
   * the XMP tag. <code>VIPS_META_ORIENTATION</code> (if set) is used to set the value of
   * the orientation
   * tag. <code>VIPS_META_IPTC</code> (if set) is used to set the value of the IPTC tag.
   * <code>VIPS_META_PHOTOSHOP_NAME</code> (if set) is used to set the value of the PHOTOSHOP
   * tag.</p>
   *
   * <p>By default, pyramid layers are saved as consecutive pages.
   * Set {@optionalArg subifd} to save pyramid layers as sub-directories of the main image.
   * Setting this option can improve compatibility with formats like OME.</p>
   *
   * <p>Set {@optionalArg premultiply} to save with premultiplied alpha. Some programs, such as
   * InDesign, will only work with premultiplied alpha.</p>
   *
   * <p>See also: {@link #tiffload}, <code>vips_image_write_to_file</code>.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg compression {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignTiffCompression} Compression for this file
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg predictor {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignTiffPredictor} Compression prediction
   * @optionalArg tile {@link VipsOption.Boolean} Write a tiled tiff
   * @optionalArg tile-width {@link VipsOption.Int} Tile width in pixels
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg pyramid {@link VipsOption.Boolean} Write a pyramidal tiff
   * @optionalArg miniswhite {@link VipsOption.Boolean} Use 0 for white in 1-bit images
   * @optionalArg bitdepth {@link VipsOption.Int} Write as a 1, 2, 4 or 8 bit image
   * @optionalArg resunit {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignTiffResunit} Resolution unit
   * @optionalArg xres {@link VipsOption.Double} Horizontal resolution in pixels/mm
   * @optionalArg yres {@link VipsOption.Double} Vertical resolution in pixels/mm
   * @optionalArg bigtiff {@link VipsOption.Boolean} Write a bigtiff image
   * @optionalArg properties {@link VipsOption.Boolean} Write a properties document to IMAGEDESCRIPTION
   * @optionalArg region-shrink {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsRegionShrink} Method to shrink regions
   * @optionalArg level {@link VipsOption.Int} ZSTD compression level
   * @optionalArg lossless {@link VipsOption.Boolean} Enable WEBP lossless mode
   * @optionalArg depth {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignDzDepth} Pyramid depth
   * @optionalArg subifd {@link VipsOption.Boolean} Save pyr layers as sub-IFDs
   * @optionalArg premultiply {@link VipsOption.Boolean} Save with premultiplied alpha
   * @optionalArg rgbjpeg {@link VipsOption.Boolean} Output RGB JPEG rather than YCbCr
   * @optionalArg squash {@link VipsOption.Boolean} Squash images down to 1 bit
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void tiffsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "tiffsave", callArgs);
  }

  /**
   * <p>As {@link #tiffsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in <code>@buf</code>, the length of the buffer in
   * <code>@len</code>. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link #tiffsave}, <code>vips_image_write_to_file</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg compression {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignTiffCompression} Compression for this file
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg predictor {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignTiffPredictor} Compression prediction
   * @optionalArg tile {@link VipsOption.Boolean} Write a tiled tiff
   * @optionalArg tile-width {@link VipsOption.Int} Tile width in pixels
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg pyramid {@link VipsOption.Boolean} Write a pyramidal tiff
   * @optionalArg miniswhite {@link VipsOption.Boolean} Use 0 for white in 1-bit images
   * @optionalArg bitdepth {@link VipsOption.Int} Write as a 1, 2, 4 or 8 bit image
   * @optionalArg resunit {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignTiffResunit} Resolution unit
   * @optionalArg xres {@link VipsOption.Double} Horizontal resolution in pixels/mm
   * @optionalArg yres {@link VipsOption.Double} Vertical resolution in pixels/mm
   * @optionalArg bigtiff {@link VipsOption.Boolean} Write a bigtiff image
   * @optionalArg properties {@link VipsOption.Boolean} Write a properties document to IMAGEDESCRIPTION
   * @optionalArg region-shrink {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsRegionShrink} Method to shrink regions
   * @optionalArg level {@link VipsOption.Int} ZSTD compression level
   * @optionalArg lossless {@link VipsOption.Boolean} Enable WEBP lossless mode
   * @optionalArg depth {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignDzDepth} Pyramid depth
   * @optionalArg subifd {@link VipsOption.Boolean} Save pyr layers as sub-IFDs
   * @optionalArg premultiply {@link VipsOption.Boolean} Save with premultiplied alpha
   * @optionalArg rgbjpeg {@link VipsOption.Boolean} Output RGB JPEG rather than YCbCr
   * @optionalArg squash {@link VipsOption.Boolean} Squash images down to 1 bit
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public VBlob tiffsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "tiffsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /**
   * <p>As {@link #tiffsave}, but save to a target.</p>
   *
   * <p>See also: {@link #tiffsave}, <code>vips_image_write_to_target</code>.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg compression {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignTiffCompression} Compression for this file
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg predictor {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignTiffPredictor} Compression prediction
   * @optionalArg tile {@link VipsOption.Boolean} Write a tiled tiff
   * @optionalArg tile-width {@link VipsOption.Int} Tile width in pixels
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg pyramid {@link VipsOption.Boolean} Write a pyramidal tiff
   * @optionalArg miniswhite {@link VipsOption.Boolean} Use 0 for white in 1-bit images
   * @optionalArg bitdepth {@link VipsOption.Int} Write as a 1, 2, 4 or 8 bit image
   * @optionalArg resunit {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignTiffResunit} Resolution unit
   * @optionalArg xres {@link VipsOption.Double} Horizontal resolution in pixels/mm
   * @optionalArg yres {@link VipsOption.Double} Vertical resolution in pixels/mm
   * @optionalArg bigtiff {@link VipsOption.Boolean} Write a bigtiff image
   * @optionalArg properties {@link VipsOption.Boolean} Write a properties document to IMAGEDESCRIPTION
   * @optionalArg region-shrink {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsRegionShrink} Method to shrink regions
   * @optionalArg level {@link VipsOption.Int} ZSTD compression level
   * @optionalArg lossless {@link VipsOption.Boolean} Enable WEBP lossless mode
   * @optionalArg depth {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignDzDepth} Pyramid depth
   * @optionalArg subifd {@link VipsOption.Boolean} Save pyr layers as sub-IFDs
   * @optionalArg premultiply {@link VipsOption.Boolean} Save with premultiplied alpha
   * @optionalArg rgbjpeg {@link VipsOption.Boolean} Output RGB JPEG rather than YCbCr
   * @optionalArg squash {@link VipsOption.Boolean} Squash images down to 1 bit
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void tiffsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "tiffsave_target", callArgs);
  }

  /**
   * <p>This operation behaves rather like {@link #copy} between images
   * {@param in} and {@param out}, except that it keeps a cache of computed pixels.
   * This cache is made of up to {@optionalArg maxTiles} tiles (a value of -1
   * means any number of tiles), and each tile is of size {@optionalArg tileWidth}
   * by {@optionalArg tileHeight} pixels.</p>
   *
   * <p>Each cache tile is made with a single call to
   * <code>vips_region_prepare</code>.</p>
   *
   * <p>When the cache fills, a tile is chosen for reuse. If {@optionalArg access} is
   * {@link app.photofox.vipsffm.enums.VipsAccess#ACCESS_RANDOM}, then the least-recently-used tile is reused. If
   * {@optionalArg access} is {@link app.photofox.vipsffm.enums.VipsAccess#ACCESS_SEQUENTIAL}
   * the top-most tile is reused.</p>
   *
   * <p>By default, {@optionalArg tileWidth} and {@optionalArg tileHeight} are 128 pixels, and the operation
   * will cache up to 1,000 tiles. {@optionalArg access} defaults to {@link app.photofox.vipsffm.enums.VipsAccess#ACCESS_RANDOM}.</p>
   *
   * <p>Normally, only a single thread at once is allowed to calculate tiles. If
   * you set {@optionalArg threaded} to <code>TRUE</code>, tilecache will allow many threads to
   * calculate tiles at once, and share the cache between them.</p>
   *
   * <p>Normally the cache is dropped when computation finishes. Set {@optionalArg persistent} to
   * <code>TRUE</code> to keep the cache between computations.</p>
   *
   * <p>See also: {@link #cache}, {@link #linecache}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg tile-width {@link VipsOption.Int} Tile width in pixels
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg max-tiles {@link VipsOption.Int} Maximum number of tiles to cache
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Expected access pattern
   * @optionalArg threaded {@link VipsOption.Boolean} Allow threaded access
   * @optionalArg persistent {@link VipsOption.Boolean} Keep cache between evaluations
   */
  public VImage tilecache(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "tilecache", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>tonelut generates a tone curve for the adjustment of image
   * levels. It is mostly designed for adjusting the L* part of a LAB image in
   * a way suitable for print work, but you can use it for other things too.</p>
   *
   * <p>The curve is an unsigned 16-bit image with ({@optionalArg inMax} + 1) entries,
   * each in the range [0, {@optionalArg outMax}].</p>
   *
   * <p>{@optionalArg Lb}, {@optionalArg Lw} are expressed as 0-100, as in LAB colour space. You
   * specify the scaling for the input and output images with the {@optionalArg inMax} and
   * {@optionalArg outMax} parameters.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg in-max {@link VipsOption.Int} Size of LUT to build
   * @optionalArg out-max {@link VipsOption.Int} Maximum value in output LUT
   * @optionalArg Lb {@link VipsOption.Double} Lowest value in output
   * @optionalArg Lw {@link VipsOption.Double} Highest value in output
   * @optionalArg Ps {@link VipsOption.Double} Position of shadow
   * @optionalArg Pm {@link VipsOption.Double} Position of mid-tones
   * @optionalArg Ph {@link VipsOption.Double} Position of highlights
   * @optionalArg S {@link VipsOption.Double} Adjust shadows by this much
   * @optionalArg M {@link VipsOption.Double} Adjust mid-tones by this much
   * @optionalArg H {@link VipsOption.Double} Adjust highlights by this much
   */
  public VImage tonelut(VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "tonelut", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Transpose a volumetric image.</p>
   *
   * <p>Volumetric images are very tall, thin images, with the metadata item
   * <code>VIPS_META_PAGE_HEIGHT</code> set to the height of each sub-image.</p>
   *
   * <p>This operation swaps the two major dimensions, so that page N in the
   * output contains the Nth scanline, in order, from each input page.</p>
   *
   * <p>You can override the <code>VIPS_META_PAGE_HEIGHT</code> metadata item with the optional
   * {@optionalArg pageHeight} parameter.</p>
   *
   * <p><code>VIPS_META_PAGE_HEIGHT</code> in the output image is the number of pages in the
   * input image.</p>
   *
   * <p>See also: {@link #grid}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page-height {@link VipsOption.Int} Height of each input page
   */
  public VImage transpose3d(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "transpose3d", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Unpremultiplies any alpha channel.
   * Band {@optionalArg alphaBand} (by default the final band) contains the alpha and all
   * other bands are transformed as:</p>
   *
   * <pre>{@code 
   *   alpha = (int) clip(0, in[in.bands - 1], {@optionalArg maxAlpha});
   *   norm = (double) alpha / {@optionalArg maxAlpha};
   *   if (alpha == 0)
   *   	out = [0, ..., 0, alpha];
   *   else
   *   	out = [in[0] / norm, ..., in[in.bands - 1] / norm, alpha];
   * }</pre>
   *
   * <p>So for an N-band image, the first N - 1 bands are divided by the clipped
   * and normalised final band, the final band is clipped.
   * If there is only a single band, the image is passed through unaltered.</p>
   *
   * <p>The result is
   * {@link VipsBandFormat#FORMAT_FLOAT} unless the input format is {@link VipsBandFormat#FORMAT_DOUBLE}, in which
   * case the output is double as well.</p>
   *
   * <p>{@optionalArg maxAlpha} has the default value 255, or 65535 for images tagged as
   * {@link VipsInterpretation#INTERPRETATION_RGB16} or
   * {@link VipsInterpretation#INTERPRETATION_GREY16}.</p>
   *
   * <p>Non-complex images only.</p>
   *
   * <p>See also: {@link #premultiply}, {@link #flatten}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg max-alpha {@link VipsOption.Double} Maximum value of alpha channel
   * @optionalArg alpha-band {@link VipsOption.Int} Unpremultiply with this alpha
   */
  public VImage unpremultiply(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "unpremultiply", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Read in a vips image.</p>
   *
   * <p>See also: {@link #vipssave}.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage vipsload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "vipsload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #vipsload}, but read from a source.</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage vipsloadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "vipsload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Write {@param in} to {@param filename} in VIPS format.</p>
   *
   * <p>See also: {@link #vipsload}.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void vipssave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "vipssave", callArgs);
  }

  /**
   * <p>As {@link #vipssave}, but save to a target.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void vipssaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "vipssave_target", callArgs);
  }

  /**
   * <p>Read a WebP file into a VIPS image.</p>
   *
   * <p>Use {@optionalArg page} to select a page to render, numbering from zero.</p>
   *
   * <p>Use {@optionalArg n} to select the number of pages to render. The default is 1. Pages are
   * rendered in a vertical column, with each individual page aligned to the
   * left. Set to -1 to mean "until the end of the document". Use {@link #grid}
   * to change page layout.</p>
   *
   * <p>Use {@optionalArg scale} to specify a scale-on-load factor. For example, 2.0 to double
   * the size on load. Animated webp images don't support shrink-on-load, so a
   * further resize may be necessary.</p>
   *
   * <p>The loader supports ICC, EXIF and XMP metadata.</p>
   *
   * <p>See also: <code>vips_image_new_from_file</code>.</p>
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg scale {@link VipsOption.Double} Factor to scale by
   * @optionalArg shrink {@link VipsOption.Int} Shrink factor on load
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage webpload(String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "webpload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Read a WebP-formatted memory block into a VIPS image. Exactly as
   * {@link #webpload}, but read from a memory buffer.</p>
   *
   * <p>You must not free the buffer while {@param out} is active. The
   * #VipsObject::postclose signal on {@param out} is a good place to free.</p>
   *
   * <p>See also: {@link #webpload}</p>
   * @param buffer Buffer to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg scale {@link VipsOption.Double} Factor to scale by
   * @optionalArg shrink {@link VipsOption.Int} Shrink factor on load
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage webploadBuffer(VBlob buffer, VipsOption... args) throws VipsError {
    var bufferOption = VipsOption.Blob("buffer", buffer);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(bufferOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "webpload_buffer", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link #webpload}, but read from a source.</p>
   *
   * <p>See also: {@link #webpload}</p>
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg scale {@link VipsOption.Double} Factor to scale by
   * @optionalArg shrink {@link VipsOption.Int} Shrink factor on load
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public VImage webploadSource(VSource source, VipsOption... args) throws VipsError {
    var sourceOption = VipsOption.Source("source", source);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(sourceOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "webpload_source", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Write an image to a file in WebP format.</p>
   *
   * <p>By default, images are saved in lossy format, with
   * {@optionalArg Q} giving the WebP quality factor. It has the range 0 - 100, with the
   * default 75.</p>
   *
   * <p>Use {@optionalArg preset} to hint the image type to the lossy compressor. The default is
   * {@link app.photofox.vipsffm.enums.VipsForeignWebpPreset#FOREIGN_WEBP_PRESET_DEFAULT}.</p>
   *
   * <p>Set {@optionalArg smartSubsample} to enable high quality chroma subsampling.</p>
   *
   * <p>Use {@optionalArg alphaQ} to set the quality for the alpha channel in lossy mode. It has
   * the range 1 - 100, with the default 100.</p>
   *
   * <p>Use {@optionalArg effort} to control how much CPU time to spend attempting to
   * reduce file size. A higher value means more effort and therefore CPU time
   * should be spent. It has the range 0-6 and a default value of 4.</p>
   *
   * <p>Set {@optionalArg lossless} to use lossless compression, or combine {@optionalArg nearLossless}
   * with {@optionalArg Q} 80, 60, 40 or 20 to apply increasing amounts of preprocessing
   * which improves the near-lossless compression ratio by up to 50%.</p>
   *
   * <p>For animated webp output, {@optionalArg minSize} will try to optimize for minimum size.</p>
   *
   * <p>For animated webp output, {@optionalArg kmax} sets the maximum number of frames between
   * keyframes. Setting 0 means only keyframes. {@optionalArg kmin} sets the minimum number of
   * frames between frames. Setting 0 means no keyframes. By default, keyframes
   * are disabled.</p>
   *
   * <p>For animated webp output, {@optionalArg mixed} tries to improve the file size by mixing
   * both lossy and lossless encoding.</p>
   *
   * <p>Use the metadata items `loop` and `delay` to set the number of
   * loops for the animation and the frame delays.</p>
   *
   * <p>See also: {@link #webpload}, <code>vips_image_write_to_file</code>.</p>
   * @param filename Filename to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg lossless {@link VipsOption.Boolean} Enable lossless compression
   * @optionalArg preset {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignWebpPreset} Preset for lossy compression
   * @optionalArg smart-subsample {@link VipsOption.Boolean} Enable high quality chroma subsampling
   * @optionalArg near-lossless {@link VipsOption.Boolean} Enable preprocessing in lossless mode (uses Q)
   * @optionalArg alpha-q {@link VipsOption.Int} Change alpha plane fidelity for lossy compression
   * @optionalArg min-size {@link VipsOption.Boolean} Optimise for minimum size
   * @optionalArg kmin {@link VipsOption.Int} Minimum number of frames between key frames
   * @optionalArg kmax {@link VipsOption.Int} Maximum number of frames between key frames
   * @optionalArg effort {@link VipsOption.Int} Level of CPU effort to reduce file size
   * @optionalArg reduction-effort {@link VipsOption.Int} Level of CPU effort to reduce file size
   * @optionalArg mixed {@link VipsOption.Boolean} Allow mixed encoding (might reduce file size)
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void webpsave(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "webpsave", callArgs);
  }

  /**
   * <p>As {@link #webpsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in <code>@buf</code>, the length of the buffer in
   * <code>@len</code>. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link #webpsave}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg lossless {@link VipsOption.Boolean} Enable lossless compression
   * @optionalArg preset {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignWebpPreset} Preset for lossy compression
   * @optionalArg smart-subsample {@link VipsOption.Boolean} Enable high quality chroma subsampling
   * @optionalArg near-lossless {@link VipsOption.Boolean} Enable preprocessing in lossless mode (uses Q)
   * @optionalArg alpha-q {@link VipsOption.Int} Change alpha plane fidelity for lossy compression
   * @optionalArg min-size {@link VipsOption.Boolean} Optimise for minimum size
   * @optionalArg kmin {@link VipsOption.Int} Minimum number of frames between key frames
   * @optionalArg kmax {@link VipsOption.Int} Maximum number of frames between key frames
   * @optionalArg effort {@link VipsOption.Int} Level of CPU effort to reduce file size
   * @optionalArg reduction-effort {@link VipsOption.Int} Level of CPU effort to reduce file size
   * @optionalArg mixed {@link VipsOption.Boolean} Allow mixed encoding (might reduce file size)
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public VBlob webpsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "webpsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /**
   * <p>As {@link #webpsave}, but save as a mime webp on stdout.</p>
   *
   * <p>See also: {@link #webpsave}, <code>vips_image_write_to_file</code>.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg lossless {@link VipsOption.Boolean} Enable lossless compression
   * @optionalArg preset {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignWebpPreset} Preset for lossy compression
   * @optionalArg smart-subsample {@link VipsOption.Boolean} Enable high quality chroma subsampling
   * @optionalArg near-lossless {@link VipsOption.Boolean} Enable preprocessing in lossless mode (uses Q)
   * @optionalArg alpha-q {@link VipsOption.Int} Change alpha plane fidelity for lossy compression
   * @optionalArg min-size {@link VipsOption.Boolean} Optimise for minimum size
   * @optionalArg kmin {@link VipsOption.Int} Minimum number of frames between key frames
   * @optionalArg kmax {@link VipsOption.Int} Maximum number of frames between key frames
   * @optionalArg effort {@link VipsOption.Int} Level of CPU effort to reduce file size
   * @optionalArg reduction-effort {@link VipsOption.Int} Level of CPU effort to reduce file size
   * @optionalArg mixed {@link VipsOption.Boolean} Allow mixed encoding (might reduce file size)
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void webpsaveMime(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    VipsInvoker.invokeOperation(arena, "webpsave_mime", callArgs);
  }

  /**
   * <p>As {@link #webpsave}, but save to a target.</p>
   *
   * <p>See also: {@link #webpsave}.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg Q {@link VipsOption.Int} Q factor
   * @optionalArg lossless {@link VipsOption.Boolean} Enable lossless compression
   * @optionalArg preset {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsForeignWebpPreset} Preset for lossy compression
   * @optionalArg smart-subsample {@link VipsOption.Boolean} Enable high quality chroma subsampling
   * @optionalArg near-lossless {@link VipsOption.Boolean} Enable preprocessing in lossless mode (uses Q)
   * @optionalArg alpha-q {@link VipsOption.Int} Change alpha plane fidelity for lossy compression
   * @optionalArg min-size {@link VipsOption.Boolean} Optimise for minimum size
   * @optionalArg kmin {@link VipsOption.Int} Minimum number of frames between key frames
   * @optionalArg kmax {@link VipsOption.Int} Maximum number of frames between key frames
   * @optionalArg effort {@link VipsOption.Int} Level of CPU effort to reduce file size
   * @optionalArg reduction-effort {@link VipsOption.Int} Level of CPU effort to reduce file size
   * @optionalArg mixed {@link VipsOption.Boolean} Allow mixed encoding (might reduce file size)
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void webpsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "webpsave_target", callArgs);
  }

  /**
   * <p>Create a one-band float image of Worley noise. See:</p>
   *
   * <p>https://en.wikipedia.org/wiki/Worley_noise</p>
   *
   * <p>Use {@optionalArg cellSize} to set the size of the cells from which the image is
   * constructed. The default is 256 x 256.</p>
   *
   * <p>If {@param width} and {@param height} are multiples of {@optionalArg cellSize}, the image will tessellate.</p>
   *
   * <p>See also: {@link #perlin}, {@link #fractsurf}, {@link #gaussnoise}.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg cell-size {@link VipsOption.Int} Size of Worley cells
   * @optionalArg seed {@link VipsOption.Int} Random number seed
   */
  public VImage worley(int width, int height, VipsOption... args) throws VipsError {
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

  /**
   * <p>Slice an image up and move the segments about so that the pixel that was
   * at 0, 0 is now at {@optionalArg x}, {@optionalArg y}. If {@optionalArg x} and {@optionalArg y} are not set, they default to the
   * centre of the image.</p>
   *
   * <p>See also: {@link #embed}, {@link #replicate}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg x {@link VipsOption.Int} Left edge of input in output
   * @optionalArg y {@link VipsOption.Int} Top edge of input in output
   */
  public VImage wrap(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "wrap", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Create a two-band uint32 image where the elements in the first band have the
   * value of their x coordinate and elements in the second band have their y
   * coordinate.</p>
   *
   * <p>You can make any image where the value of a pixel is a function of its (x,
   * y) coordinate by combining this operator with the arithmetic operators.</p>
   *
   * <p>Set {@optionalArg csize}, {@optionalArg dsize}, {@optionalArg esize} to generate higher dimensions and add more
   * bands. The extra dimensions are placed down the vertical axis. Use
   * {@link #grid} to change the layout.</p>
   *
   * <p>See also: {@link #grey}, {@link #grid}, {@link #identity}.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg csize {@link VipsOption.Int} Size of third dimension
   * @optionalArg dsize {@link VipsOption.Int} Size of fourth dimension
   * @optionalArg esize {@link VipsOption.Int} Size of fifth dimension
   */
  public VImage xyz(int width, int height, VipsOption... args) throws VipsError {
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

  /**
   * <p>Create a one-band image of a zone plate.</p>
   *
   * <p>Pixels are normally in [-1, +1], set {@optionalArg uchar} to output [0, 255].</p>
   *
   * <p>See also: {@link #eye}, {@link #xyz}.</p>
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   */
  public VImage zone(int width, int height, VipsOption... args) throws VipsError {
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

  /**
   * <p>Zoom an image by repeating pixels. This is fast nearest-neighbour
   * zoom.</p>
   *
   * <p>See also: {@link #affine}, {@link #subsample}.</p>
   * @param xfac Horizontal zoom factor
   * @param yfac Vertical zoom factor
   * @param args Array of VipsOption to apply to this operation
   */
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

  public static VImage newImage(Arena arena) throws VipsError {
    var newImagePointer = VipsHelper.image_new(arena);
    return new VImage(arena, newImagePointer);
  }
}
