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
import app.photofox.vipsffm.enums.VipsSdfShape;
import java.io.InputStream;
import java.io.OutputStream;
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
   * <p>See also: {@link VImage#LCh2CMC}.</p>
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
   * over the process, use {@link VImage#iccImport} instead.</p>
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
   * compatibility with other image processing systems. See {@link VImage#Lab2LCh} for a
   * much better colour space.</p>
   *
   * <p>See also: {@link VImage#sRGB2HSV}.</p>
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
   * <p>The CMC colourspace is described in &quot;Uniform Colour Space Based on the
   * CMC(l:c) Colour-difference Formula&quot;, M R Luo and B Rigg, Journal of the
   * Society of Dyers and Colourists, vol 102, 1986. Distances in this
   * colourspace approximate, within 10% or so, differences in the CMC(l:c)
   * colour difference formula.</p>
   *
   * <p>This operation generates CMC(1:1). For CMC(2:1), halve Lucs and double
   * Cucs.</p>
   *
   * <p>See also: {@link VImage#CMC2LCh}.</p>
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
   * <p>See also: {@link VImage#LabQ2Lab}.</p>
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
   * <p>See also: {@link VImage#LabQ2Lab}.</p>
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
   * specified with {@code temp}.</p>
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
   * <p>See also: {@code LabQ2Lab}, {@link VImage#LabQ2LabS}, {@link VImage#rad2float}.</p>
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
   * <p>See also: {@link VImage#LabS2LabQ}, {@code LabQ2LabS}, {@link VImage#rad2float}.</p>
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
   * <p>See also: {@link VImage#LabS2LabQ}, {@code LabQ2sRGB}, {@link VImage#rad2float}.</p>
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
   * <p>See also: {@code LabS2Lab}.</p>
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
   * <p>See also: {@link VImage#LabQ2LabS}.</p>
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
   * over the process, use {@link VImage#iccExport} instead.</p>
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
   * <p>Turn XYZ to Lab, optionally specifying the colour temperature. {@code temp}
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
   * signed integer types, {@code fabs(3)} for
   * float types, and calculates modulus for complex
   * types.</p>
   *
   * <p>See also: {@link VImage#sign}.</p>
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
   * <p>This operation calculates {@code in1} + {@code in2} and writes the result to {@code out}.</p>
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
   * {@code arithmetic}), then the
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
   * <p>See also: {@link VImage#subtract}, {@link VImage#linear}.</p>
   * @param right Right-hand image argument
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Append an alpha channel.</p>
   *
   * <p>See also: {@code vips_image_hasalpha}.</p>
   * @param args Array of VipsOption to apply to this operation
   */
  public VImage addalpha(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "addalpha", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operator performs an affine transform on an image using {@code interpolate}.</p>
   *
   * <p>The transform is:</p>
   *
   * <pre>{@code 
   *   X = {@code a} * (x + {@code idx}) + {@code b} * (y + {@code idy}) + {@code odx}
   *   Y = {@code c} * (x + {@code idx}) + {@code d} * (y + {@code idy}) + {@code doy}
   *
   *  where:
   *     x and y are the coordinates in input image.
   *     X and Y are the coordinates in output image.
   *     (0,0) is the upper left corner.
   * }</pre>
   *
   * <p>The section of the output space defined by {@code oarea} is written to
   * {@code out}. {@code oarea} is a four-element int array of left, top, width, height.
   * By default {@code oarea} is just large enough to cover the whole of the
   * transformed input image.</p>
   *
   * <p>By default, new pixels are filled with {@code background}. This defaults to
   * zero (black). You can set other extend types with {@code extend}. {@link app.photofox.vipsffm.enums.VipsExtend#EXTEND_COPY}
   * is better for image upsizing.</p>
   *
   * <p>{@code interpolate} defaults to bilinear.</p>
   *
   * <p>{@code idx}, {@code idy}, {@code odx}, {@code ody} default to zero.</p>
   *
   * <p>Image are normally treated as unpremultiplied, so this operation can be used
   * directly on PNG images. If your images have been through {@link VImage#premultiply},
   * set {@code premultiplied}.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link VImage#shrink}, {@link VImage#resize}, {@code VipsInterpolate}.</p>
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
   * <p>Load an Analyze 6.0 file. If {@code filename} is &quot;fred.img&quot;, this will look for
   * an image header called &quot;fred.hdr&quot; and pixel data in &quot;fred.img&quot;. You can
   * also load &quot;fred&quot; or &quot;fred.hdr&quot;.</p>
   *
   * <p>Images are
   * loaded lazilly and byte-swapped, if necessary. The Analyze metadata is read
   * and attached.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Lay out the images in {@code in} in a grid. The grid is {@code across} images across and
   * however high is necessary to use up all of {@code in}. Images are set down
   * left-to-right and top-to-bottom. {@code across} defaults to {@code n}.</p>
   *
   * <p>Each input image is placed with a box of size {@code hspacing} by {@code vspacing}
   * pixels and cropped. These default to the largest width and largest height
   * of the input images.</p>
   *
   * <p>Space between images is filled with {@code background}. This defaults to 0
   * (black).</p>
   *
   * <p>Images are positioned within their {@code hspacing} by {@code vspacing} box at low,
   * centre or high coordinate values, controlled by {@code halign} and {@code valign}. These
   * default to left-top.</p>
   *
   * <p>Boxes are joined and separated by {@code shim} pixels. This defaults to 0.</p>
   *
   * <p>If the number of bands in the input images differs, all but one of the
   * images must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the n-band images are operated upon.</p>
   *
   * <p>The input images are cast up to the smallest common type (see table
   * Smallest common format in
   * {@code arithmetic}).</p>
   *
   * <p>{@link VImage#colourspace} can be useful for moving the images to a common
   * colourspace for compositing.</p>
   *
   * <p>See also: {@link VImage#join}, {@link VImage#insert}, {@link VImage#colourspace}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Look at the image metadata and rotate and flip the image to make it
   * upright. The {@code VIPS_META_ORIENTATION} tag is removed from {@code out} to prevent
   * accidental double rotation.</p>
   *
   * <p>Read {@code angle} to find the amount the image was rotated by. Read {@code flip} to
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
   * bands of the input image: use {@link VImage#stats} if you need to calculate an
   * average for each band. For complex images, return the average modulus.</p>
   *
   * <p>See also: {@link VImage#stats}, {@link VImage#bandmean}, {@link VImage#deviate}, {@link VImage#rank}</p>
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
   * Save image in AVIF format
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
  @Deprecated(
      forRemoval = true
  )
  public void avifsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "avifsave_target", callArgs);
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
   * <p>This operation is useful in conjunction with {@link VImage#relational}. You can use
   * it to see if all image bands match exactly.</p>
   *
   * <p>See also: {@link VImage#booleanConst}.</p>
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
   * Use {@code factor} to set how much to fold by: {@code factor} 3, for example, will make
   * the output image three times narrower than the input, and with three times
   * as many bands. By default the whole of the input width is folded up.</p>
   *
   * <p>See also: {@link VImage#csvload}, {@link VImage#bandunfold}.</p>
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
   * {@code arithmetic}).</p>
   *
   * <p>See also: {@link VImage#insert}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param in Array of input images
   * @param args Array of VipsOption to apply to this operation
   */
  public static VImage bandjoin(Arena arena, List<VImage> in, VipsOption... args) throws VipsError {
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
   * <p>See also: {@link VImage#bandjoin}.</p>
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
   * <p>See also: {@link VImage#add}, {@link VImage#avg}, {@link VImage#recomb}</p>
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
   * <p>Sorts the images {@code in} band-element-wise, then outputs an
   * image in which each band element is selected from the sorted list by the
   * {@code index} parameter. For example, if {@code index}
   * is zero, then each output band element will be the minimum of all the
   * corresponding input band elements.</p>
   *
   * <p>By default, {@code index} is -1, meaning pick the median value.</p>
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
   * <p>See also: {@link VImage#rank}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param in Array of input images
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg index {@link VipsOption.Int} Select this band element from sorted list
   */
  public static VImage bandrank(Arena arena, List<VImage> in, VipsOption... args) throws VipsError {
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
   * Use {@code factor} to set how much to unfold by: {@code factor} 3, for example, will make
   * the output image three times wider than the input, and with one third
   * as many bands. By default, all bands are unfolded.</p>
   *
   * <p>See also: {@link VImage#csvload}, {@link VImage#bandfold}.</p>
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
   * <p>See also: {@link VImage#xyz}, {@link VImage#text}, {@link VImage#gaussnoise}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg bands {@link VipsOption.Int} Number of bands in image
   */
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
   * {@code arithmetic}).</p>
   *
   * <p>See also: {@link VImage#booleanConst}.</p>
   * @param right Right-hand image argument
   * @param boolean1 {@link VipsOperationBoolean} Boolean to perform
   * @param args Array of VipsOption to apply to this operation
   */
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
   * <p>See also: {@link VImage#boolean1}, {@code vips_boolean_const1}.</p>
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
   * always of type {@link VipsBandFormat#FORMAT_DOUBLE}, use {@link VImage#cast} to change it to the
   * type you need.</p>
   *
   * <p>For example, consider this 2 x 2 matrix of (x, y) coordinates:
   *
   *  &lt;tgroup cols='2' align='left' colsep='1' rowsep='1'&gt;
   *     &lt;tbody&gt;
   *       &lt;row&gt;
   *         &lt;entry&gt;0&lt;/entry&gt;
   *         &lt;entry&gt;0&lt;/entry&gt;
   *       &lt;/row&gt;
   *       &lt;row&gt;
   *         &lt;entry&gt;255&lt;/entry&gt;
   *         &lt;entry&gt;100&lt;/entry&gt;
   *       &lt;/row&gt;
   *     &lt;/tbody&gt;
   *   &lt;/tgroup&gt;</p>
   *
   * <p>We then generate a 1 x 256 element LUT like this:
   *
   *  &lt;tgroup cols='2' align='left' colsep='1' rowsep='1'&gt;
   *     &lt;thead&gt;
   *       &lt;row&gt;
   *         &lt;entry&gt;Index&lt;/entry&gt;
   *         &lt;entry&gt;Value&lt;/entry&gt;
   *       &lt;/row&gt;
   *     &lt;/thead&gt;
   *     &lt;tbody&gt;
   *       &lt;row&gt;
   *         &lt;entry&gt;0&lt;/entry&gt;
   *         &lt;entry&gt;0&lt;/entry&gt;
   *       &lt;/row&gt;
   *       &lt;row&gt;
   *         &lt;entry&gt;1&lt;/entry&gt;
   *         &lt;entry&gt;0.4&lt;/entry&gt;
   *       &lt;/row&gt;
   *       &lt;row&gt;
   *         &lt;entry&gt;etc.&lt;/entry&gt;
   *         &lt;entry&gt;0.4&lt;/entry&gt;
   *       &lt;/row&gt;
   *       &lt;row&gt;
   *         &lt;entry&gt;255&lt;/entry&gt;
   *         &lt;entry&gt;100&lt;/entry&gt;
   *       &lt;/row&gt;
   *     &lt;/tbody&gt;
   *   &lt;/tgroup&gt;</p>
   *
   * <p>This is then written as the output image, with the left column giving the
   * index in the image to place the value.</p>
   *
   * <p>The (x, y) points don't need to be sorted: we do that. You can have
   * several Ys, each becomes a band in the output LUT. You don't need to
   * start at zero, any integer will do, including negatives.</p>
   *
   * <p>See also: {@link VImage#identity}, {@link VImage#invertlut}, {@link VImage#cast}, {@link VImage#maplut}.</p>
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
   * <p>See also: {@link VImage#rawload}.</p>
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
   * Cache an image
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg max-tiles {@link VipsOption.Int} Maximum number of tiles to cache
   * @optionalArg tile-height {@link VipsOption.Int} Tile height in pixels
   * @optionalArg tile-width {@link VipsOption.Int} Tile width in pixels
   */
  @Deprecated(
      forRemoval = true
  )
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
   * <p>Use {@code sigma} to control the scale over which gradient is measured. 1.4 is
   * usually a good value.</p>
   *
   * <p>Use {@code precision} to set the precision of edge detection. For uchar images,
   * setting this to {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER} will make edge detection much
   * faster, but sacrifice some sensitivity.</p>
   *
   * <p>You will probably need to process the output further to eliminate weak
   * edges.</p>
   *
   * <p>See also: {@link VImage#sobel}.</p>
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
   * <p>Use values in {@code index} to select pixels from {@code cases}.</p>
   *
   * <p>{@code index} must have one band. {@code cases} can have up to 256 elements. Values in
   * {@code index} greater than or equal to {@code n} use the final image in {@code cases}. The
   * images in {@code cases} must have either one band or the same number of bands.
   * The output image is the same size as {@code index}. Images in {@code cases} are
   * expanded to the smallest common format and number of bands.</p>
   *
   * <p>Combine this with {@link VImage#switch1} to make something like a case statement or
   * a multi-way {@link VImage#ifthenelse}.</p>
   *
   * <p>See also: {@link VImage#maplut}, {@link VImage#switch1}, {@link VImage#ifthenelse}.</p>
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
   * <p>Convert {@code in} to {@code format}. You can convert between any pair of formats.
   * Floats are truncated (not rounded). Out of range values are clipped.</p>
   *
   * <p>Casting from complex to real returns the real part.</p>
   *
   * <p>If {@code shift} is {@code TRUE}, integer values are shifted up and down. For example,
   * casting from unsigned 8 bit to unsigned 16 bit would
   * shift every value left by 8 bits. The bottom bit is copied into the new
   * bits, so 255 would become 65535.</p>
   *
   * <p>See also: {@link VImage#scale}, {@link VImage#complexform}, {@code vips_real}, {@code vips_imag},
   * {@code vips_cast_uchar}, {@link VImage#msb}.</p>
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
   * <p>This operation clamps pixel values to a range, by default 0 - 1.</p>
   *
   * <p>Use {@code min} and {@code max} to change the range.</p>
   *
   * <p>See also: {@link VImage#sign}, {@link VImage#abs}, {@link VImage#sdf}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg min {@link VipsOption.Double} Minimum value
   * @optionalArg max {@link VipsOption.Double} Maximum value
   */
  public VImage clamp(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "clamp", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation looks at the interpretation field of {@code in} (or uses
   * {@code source-space}, if set) and runs
   * a set of colourspace conversion functions to move it to {@code space}.</p>
   *
   * <p>For example, given an image tagged as {@link VipsInterpretation#INTERPRETATION_YXY}, running
   * {@code colourspace} with {@code space} set to {@link VipsInterpretation#INTERPRETATION_LAB} will
   * convert with {@link VImage#Yxy2XYZ} and {@link VImage#XYZ2Lab}.</p>
   *
   * <p>See also: {@code vips_colourspace_issupported},
   * {@code vips_image_guess_interpretation}.</p>
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
   * <p>This convolves {@code in} with {@code mask} {@code times} times, rotating {@code mask} by {@code angle}
   * each time. By default, it comvolves twice, rotating by 90 degrees, taking
   * the maximum result.</p>
   *
   * <p>See also: {@link VImage#conv}.</p>
   * @param mask Input matrix image
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg times {@link VipsOption.Int} Rotate and convolve this many times
   * @optionalArg angle {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAngle45} Rotate mask by this much between convolutions
   * @optionalArg combine {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsCombine} Combine convolution results like this
   * @optionalArg precision {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPrecision} Convolve with this precision
   * @optionalArg layers {@link VipsOption.Int} Use this many layers in approximation
   * @optionalArg cluster {@link VipsOption.Int} Cluster lines closer than this in approximation
   */
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
   * @param right Right-hand image argument
   * @param cmplx {@link VipsOperationComplex2} Binary complex operation to perform
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Compose two real images to make a complex image. If either {@code left} or {@code right}
   * are {@link VipsBandFormat#FORMAT_DOUBLE}, {@code out} is {@link VipsBandFormat#FORMAT_DPCOMPLEX}. Otherwise {@code out}
   * is {@link VipsBandFormat#FORMAT_COMPLEX}. {@code left} becomes the real component of {@code out} and
   * {@code right} the imaginary.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>See also: {@link VImage#complexget}.</p>
   * @param right Right-hand image argument
   * @param args Array of VipsOption to apply to this operation
   */
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
   * <p>Images are placed in a stack, with {@code in}[0] at the bottom and {@code in}[{@code n} - 1] at
   * the top. Pixels are blended together working from the bottom upwards, with
   * the blend mode at each step being set by the corresponding {@code VipsBlendMode}
   * in {@code mode}.</p>
   *
   * <p>Images are transformed to a compositing space before processing. This is
   * {@link VipsInterpretation#INTERPRETATION_sRGB}, {@link VipsInterpretation#INTERPRETATION_B_W},
   * {@link VipsInterpretation#INTERPRETATION_RGB16}, or {@link VipsInterpretation#INTERPRETATION_GREY16}
   * by default, depending on
   * how many bands and bits the input images have. You can select any other
   * space, such as {@link VipsInterpretation#INTERPRETATION_LAB} or {@link VipsInterpretation#INTERPRETATION_scRGB}.</p>
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
   * <p>The images do not need to match in size or format. The output image is
   * always the size of {@code in}[0], with other images being
   * positioned with the {@code x} and {@code y} parameters and clipped
   * against that rectangle.</p>
   *
   * <p>Image are normally treated as unpremultiplied, so this operation can be used
   * directly on PNG images. If your images have been through {@link VImage#premultiply},
   * set {@code premultiplied}.</p>
   *
   * <p>See also: {@link VImage#insert}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param in Array of input images
   * @param mode Array of VipsBlendMode to join with
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg x {@link VipsOption.ArrayInt} Array of x coordinates to join at
   * @optionalArg y {@link VipsOption.ArrayInt} Array of y coordinates to join at
   * @optionalArg compositing-space {@link VipsOption.Enum} {@link VipsInterpretation} Composite images in this colour space
   * @optionalArg premultiplied {@link VipsOption.Boolean} Images have premultiplied alpha
   */
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

  /**
   * <p>Composite {@code overlay} on top of {@code base} with {@code mode}. See {@link VImage#composite}.</p>
   * @param overlay Overlay image
   * @param mode {@link VipsBlendMode} VipsBlendMode to join with
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg x {@link VipsOption.Int} X position of overlay
   * @optionalArg y {@link VipsOption.Int} Y position of overlay
   * @optionalArg compositing-space {@link VipsOption.Enum} {@link VipsInterpretation} Composite images in this colour space
   * @optionalArg premultiplied {@link VipsOption.Boolean} Images have premultiplied alpha
   */
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

  /**
   * <p>Convolution.</p>
   *
   * <p>Perform a convolution of {@code in} with {@code mask}.
   * Each output pixel is calculated as:</p>
   *
   * <pre>{@code 
   * sigma[i]{pixel[i] * mask[i]} / scale + offset
   * }</pre>
   *
   * <p>where scale and offset are part of {@code mask}.</p>
   *
   * <p>By default, {@code precision} is
   * {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_FLOAT}. The output image
   * is always {@link VipsBandFormat#FORMAT_FLOAT} unless {@code in} is {@link VipsBandFormat#FORMAT_DOUBLE}, in which case
   * {@code out} is also {@link VipsBandFormat#FORMAT_DOUBLE}.</p>
   *
   * <p>If {@code precision} is {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER}, then
   * elements of {@code mask} are converted to
   * integers before convolution, using rint(),
   * and the output image
   * always has the same {@code VipsBandFormat} as the input image.</p>
   *
   * <p>For {@link VipsBandFormat#FORMAT_UCHAR} images and {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER} {@code precision},
   * {@code conv} uses a fast vector path based on
   * half-float arithmetic. This can produce slightly different results.
   * Disable the vector path with `--vips-novector` or `VIPS_NOVECTOR` or
   * {@code vips_vector_set_enabled}.</p>
   *
   * <p>If {@code precision} is {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_APPROXIMATE} then, like
   * {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER}, {@code mask} is converted to int before convolution, and
   * the output image
   * always has the same {@code VipsBandFormat} as the input image.</p>
   *
   * <p>Larger values for {@code layers} give more accurate
   * results, but are slower. As {@code layers} approaches the mask radius, the
   * accuracy will become close to exact convolution and the speed will drop to
   * match. For many large masks, such as Gaussian, {@code n_layers} need be only 10% of
   * this value and accuracy will still be good.</p>
   *
   * <p>Smaller values of {@code cluster} will give more accurate results, but be slower
   * and use more memory. 10% of the mask radius is a good rule of thumb.</p>
   *
   * <p>See also: {@link VImage#convsep}.</p>
   * @param mask Input matrix image
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg precision {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPrecision} Convolve with this precision
   * @optionalArg layers {@link VipsOption.Int} Use this many layers in approximation
   * @optionalArg cluster {@link VipsOption.Int} Cluster lines closer than this in approximation
   */
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

  /**
   * <p>Perform an approximate integer convolution of {@code in} with {@code mask}.
   * This is a low-level operation, see
   * {@link VImage#conv} for something more convenient.</p>
   *
   * <p>The output image
   * always has the same {@code VipsBandFormat} as the input image.
   * Elements of {@code mask} are converted to
   * integers before convolution.</p>
   *
   * <p>Larger values for {@code layers} give more accurate
   * results, but are slower. As {@code layers} approaches the mask radius, the
   * accuracy will become close to exact convolution and the speed will drop to
   * match. For many large masks, such as Gaussian, {@code layers} need be only 10% of
   * this value and accuracy will still be good.</p>
   *
   * <p>Smaller values of {@code cluster} will give more accurate results, but be slower
   * and use more memory. 10% of the mask radius is a good rule of thumb.</p>
   *
   * <p>See also: {@link VImage#conv}.</p>
   * @param mask Input matrix image
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg layers {@link VipsOption.Int} Use this many layers in approximation
   * @optionalArg cluster {@link VipsOption.Int} Cluster lines closer than this in approximation
   */
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

  /**
   * <p>Approximate separable integer convolution. This is a low-level operation, see
   * {@link VImage#convsep} for something more convenient.</p>
   *
   * <p>The image is convolved twice: once with {@code mask} and then again with {@code mask}
   * rotated by 90 degrees.
   * {@code mask} must be 1xn or nx1 elements.
   * Elements of {@code mask} are converted to
   * integers before convolution.</p>
   *
   * <p>Larger values for {@code layers} give more accurate
   * results, but are slower. As {@code layers} approaches the mask radius, the
   * accuracy will become close to exact convolution and the speed will drop to
   * match. For many large masks, such as Gaussian, {@code layers} need be only 10% of
   * this value and accuracy will still be good.</p>
   *
   * <p>The output image
   * always has the same {@code VipsBandFormat} as the input image.</p>
   *
   * <p>See also: {@link VImage#convsep}.</p>
   * @param mask Input matrix image
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg layers {@link VipsOption.Int} Use this many layers in approximation
   */
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

  /**
   * <p>Convolution. This is a low-level operation, see {@link VImage#conv} for something
   * more convenient.</p>
   *
   * <p>Perform a convolution of {@code in} with {@code mask}.
   * Each output pixel is
   * calculated as sigma[i]{pixel[i] * mask[i]} / scale + offset, where scale
   * and offset are part of {@code mask}.</p>
   *
   * <p>The convolution is performed with floating-point arithmetic. The output image
   * is always {@link VipsBandFormat#FORMAT_FLOAT} unless {@code in} is {@link VipsBandFormat#FORMAT_DOUBLE}, in which case
   * {@code out} is also {@link VipsBandFormat#FORMAT_DOUBLE}.</p>
   *
   * <p>See also: {@link VImage#conv}.</p>
   * @param mask Input matrix image
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Integer convolution. This is a low-level operation, see {@link VImage#conv} for
   * something more convenient.</p>
   *
   * <p>{@code mask} is converted to an integer mask with rint() of each element, rint of
   * scale and rint of offset. Each output pixel is then calculated as</p>
   *
   * <pre>{@code 
   * sigma[i]{pixel[i] * mask[i]} / scale + offset
   * }</pre>
   *
   * <p>The output image always has the same {@code VipsBandFormat} as the input image.</p>
   *
   * <p>For {@link VipsBandFormat#FORMAT_UCHAR} images, {@code convi} uses a fast vector path based on
   * half-float arithmetic. This can produce slightly different results.
   * Disable the vector path with `--vips-novector` or `VIPS_NOVECTOR` or
   * {@code vips_vector_set_enabled}.</p>
   *
   * <p>See also: {@link VImage#conv}.</p>
   * @param mask Input matrix image
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Perform a separable convolution of {@code in} with {@code mask}.
   * See {@link VImage#conv} for a detailed description.</p>
   *
   * <p>The mask must be 1xn or nx1 elements.</p>
   *
   * <p>The image is convolved twice: once with {@code mask} and then again with {@code mask}
   * rotated by 90 degrees. This is much faster for certain types of mask
   * (gaussian blur, for example) than doing a full 2D convolution.</p>
   *
   * <p>See also: {@link VImage#conv}, {@link VImage#gaussmat}.</p>
   * @param mask Input matrix image
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg precision {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPrecision} Convolve with this precision
   * @optionalArg layers {@link VipsOption.Int} Use this many layers in approximation
   * @optionalArg cluster {@link VipsOption.Int} Cluster lines closer than this in approximation
   */
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

  /**
   * <p>Copy an image, optionally modifying the header. VIPS copies images by
   * copying pointers, so this operation is instant, even for very large images.</p>
   *
   * <p>You can optionally change any or all header fields during the copy. You can
   * make any change which does not change the size of a pel, so for example
   * you can turn a 4-band uchar image into a 2-band ushort image, but you
   * cannot change a 100 x 100 RGB image into a 300 x 100 mono image.</p>
   *
   * <p>See also: {@link VImage#byteswap}, {@link VImage#bandfold}, {@link VImage#bandunfold}.</p>
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
   * direction of an image.  black&lt;128 , white&gt;=128
   * The function calculates the number of transitions for all
   * Xsize or Ysize and returns the mean of the result
   * Input should be one band, 8-bit.</p>
   *
   * <p>See also: {@link VImage#morph}, {@link VImage#conv}.</p>
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
   * band (monochrome), {@link VipsBandFormat#FORMAT_DOUBLE}. Use {@link VImage#bandfold} to turn
   * RGBRGBRGB mono images into colour images.</p>
   *
   * <p>Items in lines can be either floating point numbers in the C locale, or
   * strings enclosed in double-quotes (&quot;), or empty.
   * You can use a backslash (\) within the quotes to escape special characters,
   * such as quote marks.</p>
   *
   * <p>{@code skip} sets the number of lines to skip at the start of the file.
   * Default zero.</p>
   *
   * <p>{@code lines} sets the number of lines to read from the file. Default -1,
   * meaning read all lines to end of file.</p>
   *
   * <p>{@code whitespace} sets the skippable whitespace characters.
   * Default &lt;b&gt;space&lt;/b&gt;.
   * Whitespace characters are always run together.</p>
   *
   * <p>{@code separator} sets the characters that separate fields.
   * Default ;,&lt;b&gt;tab&lt;/b&gt;. Separators are never run together.</p>
   *
   * <p>Use {@code fail-on} to set the type of error that will cause load to fail. By
   * default, loaders are permissive, that is, {@link app.photofox.vipsffm.enums.VipsFailOn#FAIL_ON_NONE}.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}, {@link VImage#bandfold}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage csvload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "csvload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link VImage#csvload}, but read from a source.</p>
   *
   * <p>See also: {@link VImage#csvload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Writes the pixels in {@code in} to the {@code filename} as CSV (comma-separated values).
   * The image is written
   * one line of text per scanline. Complex numbers are written as
   * &quot;(real,imaginary)&quot; and will need extra parsing I guess. Only the first band
   * is written.</p>
   *
   * <p>{@code separator} gives the string to use to separate numbers in the output.
   * The default is &quot;\\t&quot; (tab).</p>
   *
   * <p>See also: {@code vips_image_write_to_file}.</p>
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
   * <p>As {@link VImage#csvsave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#csvsave}.</p>
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
   * @param right Right-hand input image
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Calculate dE 76.</p>
   * @param right Right-hand input image
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Calculate dE CMC. The input images are transformed to CMC colour space and
   * the euclidean distance between corresponding pixels calculated.</p>
   *
   * <p>To calculate a colour difference with values for (l:c) other than (1:1),
   * transform the two source images to CMC yourself, scale the channels
   * appropriately, and call this function.</p>
   *
   * <p>See also: {@link VImage#colourspace}</p>
   * @param right Right-hand input image
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>This operation finds the standard deviation of all pixels in {@code in}. It
   * operates on all bands of the input image: use {@link VImage#stats} if you need
   * to calculate an average for each band.</p>
   *
   * <p>Non-complex images only.</p>
   *
   * <p>See also: {@link VImage#avg}, {@link VImage#stats}..</p>
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
   * <p>This operation calculates {@code in1} / {@code in2} and writes the result to {@code out}. If any
   * pixels in {@code in2} are zero, the corresponding pixel in {@code out} is also zero.</p>
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
   * {@code arithmetic}), then the
   * following table is used to determine the output type:</p>
   *
   * <pre>{@code
   * <table>
   *   <title>{@code divide} type promotion</title>
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
   * <p>See also: {@link VImage#multiply}, {@link VImage#linear}, {@code vips_pow}.</p>
   * @param right Right-hand image argument
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Draws a circle on {@code image}. If {@code fill} is {@code TRUE} then the circle is filled,
   * otherwise a 1-pixel-wide perimeter is drawn.</p>
   *
   * <p>{@code ink} is an array of double containing values to draw.</p>
   *
   * <p>See also: {@code vips_draw_circle1}, {@link VImage#drawLine}.</p>
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
   * <p>Flood-fill {@code image} with {@code ink}, starting at position {@code x}, {@code y}. The filled area is
   * bounded by pixels that are equal to the ink colour, in other words, it
   * searches for pixels enclosed by an edge of {@code ink}.</p>
   *
   * <p>If {@code equal} is set, it instead searches for pixels which are equal to the
   * start point and fills them with {@code ink}.</p>
   *
   * <p>Normally it will test and set pixels in {@code image}. If {@code test} is set, it will
   * test pixels in {@code test} and set pixels in {@code image}. This lets you search an
   * image ({@code test}) for continuous areas of pixels without modifying it.</p>
   *
   * <p>{@code left}, {@code top}, {@code width}, {@code height} output the bounding box of the modified
   * pixels.</p>
   *
   * <p>{@code ink} is an array of double containing values to draw.</p>
   *
   * <p>See also: {@code vips_draw_flood1}.</p>
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
   * <p>Draw {@code sub} on top of {@code image} at position {@code x}, {@code y}. The two images must have the
   * same Coding. If {@code sub} has 1 band, the bands will be duplicated to match the
   * number of bands in {@code image}. {@code sub} will be converted to {@code image}'s format, see
   * {@link VImage#cast}.</p>
   *
   * <p>Use {@code mode} to set how pixels are combined. If you use
   * {@link app.photofox.vipsffm.enums.VipsCombineMode#COMBINE_MODE_ADD}, both images muct be uncoded.</p>
   *
   * <p>See also: {@link VImage#drawMask}, {@link VImage#insert}.</p>
   * @param sub Sub-image to insert into main image
   * @param x Draw image here
   * @param y Draw image here
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg mode {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsCombineMode} Combining mode
   */
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

  /**
   * <p>Draws a 1-pixel-wide line on an image.</p>
   *
   * <p>{@code ink} is an array of double containing values to draw.</p>
   *
   * <p>See also: {@code vips_draw_line1}, {@link VImage#drawCircle}, {@link VImage#drawMask}.</p>
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
   * <p>Draw {@code mask} on the image. {@code mask} is a monochrome 8-bit image with 0/255
   * for transparent or {@code ink} coloured points. Intermediate values blend the ink
   * with the pixel. Use with {@link VImage#text} to draw text on an image. Use in a
   * {@link VImage#drawLine} subclass to draw an object along a line.</p>
   *
   * <p>{@code ink} is an array of double containing values to draw.</p>
   *
   * <p>See also: {@link VImage#text}, {@link VImage#drawLine}.</p>
   * @param ink Color for pixels
   * @param mask Mask of pixels to draw
   * @param x Draw mask here
   * @param y Draw mask here
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Paint pixels within {@code left}, {@code top}, {@code width}, {@code height} in {@code image} with {@code ink}. If
   * {@code fill} is zero, just paint a 1-pixel-wide outline.</p>
   *
   * <p>See also: {@link VImage#drawCircle}.</p>
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
   * <p>Smudge a section of {@code image}. Each pixel in the area {@code left}, {@code top}, {@code width},
   * {@code height} is replaced by the average of the surrounding 3x3 pixels.</p>
   *
   * <p>See also: {@link VImage#drawLine}.</p>
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
   * uses DeepZoom layout -- use {@code layout} to pick other conventions.</p>
   *
   * <p>{@code dzsave} creates a directory called {@code name} to hold the tiles. If {@code name}
   * ends `.zip`, {@code dzsave} will create a zip file called {@code name} to hold the
   * tiles. You can use {@code container} to force zip file output.</p>
   *
   * <p>Use {@code basename} to set the name of the image we are creating. The
   * default value is set from {@code name}.</p>
   *
   * <p>By default, tiles are written as JPEGs. Use {@code Q} set set the JPEG quality
   * factor.</p>
   *
   * <p>You can set {@code suffix} to something like `&quot;.png[bitdepth=4]&quot;` to write tiles
   * in another format.</p>
   *
   * <p>In Google layout mode, edge tiles are expanded to {@code tile-size} by {@code tile-size}
   * pixels. Normally they are filled with white, but you can set another colour
   * with {@code background}. Images are usually placed at the top-left of the tile,
   * but you can have them centred by turning on {@code centre}.</p>
   *
   * <p>You can set the size and overlap of tiles with {@code tile-size} and {@code overlap}.
   * They default to the correct settings for the selected {@code layout}. The deepzoom
   * defaults produce 256x256 jpeg files for centre tiles, the most efficient
   * size.</p>
   *
   * <p>Use {@code depth} to control how low the pyramid goes. This defaults to the
   * correct setting for the {@code layout} you select.</p>
   *
   * <p>You can rotate the image during write with the {@code angle} argument. However,
   * this will only work for images which support random access, like openslide,
   * and not for things like JPEG. You'll need to rotate those images
   * yourself with {@link VImage#rot}. Note that the `autorotate` option to the loader
   * may do what you need.</p>
   *
   * <p>By default, all tiles are stripped since usually you do not want a copy of
   * all metadata in every tile. Set {@code keep} if you want to keep metadata.</p>
   *
   * <p>If {@code container} is set to `zip`, you can set a compression level from -1
   * (use zlib default), 0 (store, compression disabled) to 9 (max compression).
   * If no value is given, the default is to store files without compression.</p>
   *
   * <p>You can use {@code region-shrink} to control the method for shrinking each 2x2
   * region. This defaults to using the average of the 4 input pixels but you can
   * also use the median in cases where you want to preserve the range of values.</p>
   *
   * <p>If you set {@code skip-blanks} to a value greater than or equal to zero, tiles
   * which are all within that many pixel values to the background are skipped.
   * This can save a lot of space for some image types. This option defaults to
   * 5 in Google layout mode, -1 otherwise.</p>
   *
   * <p>In IIIF layout, you can set the base of the `id` property in `info.json`
   * with {@code id}. The default is `https://example.com/iiif`.</p>
   *
   * <p>Use {@code layout} {@link app.photofox.vipsffm.enums.VipsForeignDzLayout#FOREIGN_DZ_LAYOUT_IIIF3} for IIIF v3 layout.</p>
   *
   * <p>See also: {@link VImage#tiffsave}.</p>
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
   * <p>As {@link VImage#dzsave}, but save to a memory buffer.</p>
   *
   * <p>Output is always in a zip container. Use {@code basename} to set the name of the
   * directory that the zip will create when unzipped.</p>
   *
   * <p>The address of the buffer is returned in {@code buf}, the length of the buffer in
   * {@code len}. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link VImage#dzsave}, {@code vips_image_write_to_file}.</p>
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
   * <p>As {@link VImage#dzsave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#dzsave}, {@code vips_image_write_to_target}.</p>
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
   * <p>The opposite of {@link VImage#extractArea}: embed {@code in} within an image of size
   * {@code width} by {@code height} at position {@code x}, {@code y}.</p>
   *
   * <p>{@code extend}
   * controls what appears in the new pels, see {@code VipsExtend}.</p>
   *
   * <p>See also: {@link VImage#extractArea}, {@link VImage#insert}.</p>
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
   * <p>Extract an area from an image. The area must fit within {@code in}.</p>
   *
   * <p>See also: {@code vips_extract_bands}, {@link VImage#smartcrop}.</p>
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
   * <p>See also: {@link VImage#extractArea}.</p>
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
   * amplitude in Y. {@code factor} should be between 0 and 1 and determines the
   * maximum spatial frequency.</p>
   *
   * <p>Set {@code uchar} to output a uchar image.</p>
   *
   * <p>See also: {@link VImage#zone}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg factor {@link VipsOption.Double} Maximum spatial frequency
   */
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

  /**
   * <p>Force {@code in} to 1 band, 8-bit, then transform to
   * a 3-band 8-bit image with a false colour
   * map. The map is supposed to make small differences in brightness more
   * obvious.</p>
   *
   * <p>See also: {@link VImage#maplut}.</p>
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
   * <p>{@code ref} is placed at every position in {@code in} and the sum of squares of
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
   * <p>See also: {@link VImage#spcor}.</p>
   * @param ref Input reference image
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Fill outwards from every non-zero pixel in {@code in}, setting pixels in {@code distance}
   * and {@code value}.</p>
   *
   * <p>At the position of zero pixels in {@code in}, {@code distance} contains the distance to
   * the nearest non-zero pixel in {@code in}, and {@code value} contains the value of that
   * pixel.</p>
   *
   * <p>{@code distance} is a one-band float image. {@code value} has the same number of bands and
   * format as {@code in}.</p>
   *
   * <p>See also: {@link VImage#histFindIndexed}.</p>
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
   * <p>Search {@code in} for the bounding box of the non-background area.</p>
   *
   * <p>Any alpha is flattened out, then the image is median-filtered (unless
   * {@code line-art} is set, see below). The absolute difference from {@code background} is
   * computed and binarized according to {@code threshold}. Row and column sums of
   * the absolute difference are calculated from this binary image and searched
   * for the first row or column in each direction to obtain the bounding box.</p>
   *
   * <p>If the image is entirely background, {@code findTrim} returns {@code width} == 0
   * and {@code height} == 0.</p>
   *
   * <p>{@code background} defaults to 255, or 65535 for 16-bit images. Set another value,
   * or use {@link VImage#getpoint} to pick a value from an edge. You'll need to flatten
   * before {@link VImage#getpoint} to get a correct background value.</p>
   *
   * <p>{@code threshold} defaults to 10.</p>
   *
   * <p>The detector is designed for photographic or compressed images where there
   * is a degree of noise that needs filtering. If your images are synthetic
   * (eg. rendered from vector art, perhaps), set {@code line-art} to disable this
   * filtering.</p>
   *
   * <p>The image needs to be at least 3x3 pixels in size.</p>
   *
   * <p>See also: {@link VImage#getpoint}, {@link VImage#extractArea}, {@link VImage#smartcrop}.</p>
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
   * <p>FITS metadata is attached with the &quot;fits-&quot; prefix.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage fitsload(Arena arena, String filename, VipsOption... args) throws VipsError {
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
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Write a VIPS image to a file in FITS format.</p>
   *
   * <p>See also: {@code vips_image_write_to_file}.</p>
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
   * <p>Take the last band of {@code in} as an alpha and use it to blend the
   * remaining channels with {@code background}.</p>
   *
   * <p>The alpha channel is 0 - {@code max-alpha}, where {@code max-alpha} means 100% image
   * and 0 means 100% background. {@code background} defaults to zero (black).</p>
   *
   * <p>{@code max-alpha} has the default value 255, or 65535 for images tagged as
   * {@link VipsInterpretation#INTERPRETATION_RGB16} or
   * {@link VipsInterpretation#INTERPRETATION_GREY16}.</p>
   *
   * <p>Useful for flattening PNG images to RGB.</p>
   *
   * <p>Non-complex images only.</p>
   *
   * <p>See also: {@link VImage#premultiply}, {@link VImage#pngload}.</p>
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
   * <p>See also: {@link VImage#rot}.</p>
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
   * <p>See also: {@link VImage#rad2float}, {@link app.photofox.vipsffm.enums.VipsCoding#CODING_RAD}, {@link VImage#LabQ2Lab}.</p>
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
   * <p>Generate an image of size {@code width} by {@code height} and fractal dimension
   * {@code fractalDimension}. The dimension should be between 2 and 3.</p>
   *
   * <p>See also: {@link VImage#gaussnoise}, {@link VImage#maskFractal}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param fractalDimension Fractal dimension
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Multiply {@code in} by {@code mask} in Fourier space.</p>
   *
   * <p>{@code in} is transformed to Fourier space, multiplied with {@code mask}, then
   * transformed back to real space. If {@code in} is already a complex image, just
   * multiply then inverse transform.</p>
   *
   * <p>See also: {@link VImage#invfft}, {@link VImage#maskIdeal}.</p>
   * @param mask Input mask image
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Transform an image to Fourier space.</p>
   *
   * <p>VIPS uses the fftw Fourier Transform library. If this library was not
   * available when VIPS was configured, these functions will fail.</p>
   *
   * <p>See also: {@link VImage#invfft}.</p>
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
   * <p>Calculate {@code in} ** (1 / {@code exponent}), normalising to the maximum range of the
   * input type. For float types use 1.0 as the maximum.</p>
   *
   * <p>See also: {@link VImage#identity}, {@code vips_pow_const1}, {@link VImage#maplut}</p>
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
   * <p>This operator runs {@link VImage#gaussmat} and {@link VImage#convsep} for you on an image.
   * Set {@code min-ampl} smaller to generate a larger, more accurate mask. Set {@code sigma}
   * larger to make the blur more blurry.</p>
   *
   * <p>See also: {@link VImage#gaussmat}, {@link VImage#convsep}.</p>
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
   * {@code sigma}.  The size of the mask is determined by the variable {@code minAmpl};
   * if for instance the value .1 is entered this means that the produced mask
   * is clipped at values less than 10 percent of the maximum amplitude.</p>
   *
   * <p>The program uses the following equation:
   *
   *  H(r) = exp(-(r * r) / (2 * {@code sigma} * {@code sigma}))</p>
   *
   * <p>The generated image has odd size and its maximum value is normalised to
   * 1.0, unless {@code precision} is {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER}.</p>
   *
   * <p>If {@code separable} is set, only the centre horizontal is generated. This is
   * useful for separable convolutions.</p>
   *
   * <p>If {@code precision} is {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER}, an integer gaussian is generated.
   * This is useful for integer convolutions.</p>
   *
   * <p>&quot;scale&quot; is set to the sum of all the mask elements.</p>
   *
   * <p>See also: {@link VImage#logmat}, {@link VImage#conv}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param sigma Sigma of Gaussian
   * @param minAmpl Minimum amplitude of Gaussian
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg separable {@link VipsOption.Boolean} Generate separable Gaussian
   * @optionalArg integer {@link VipsOption.Boolean} Generate integer Gaussian
   * @optionalArg precision {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPrecision} Generate with this precision
   */
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

  /**
   * <p>Make a one band float image of gaussian noise with the specified
   * distribution. The noise distribution is created by averaging 12 random
   * numbers with the appropriate weights.</p>
   *
   * <p>See also: {@link VImage#black}, {@link VImage#xyz}, {@link VImage#text}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg sigma {@link VipsOption.Double} Standard deviation of pixels in generated image
   * @optionalArg mean {@link VipsOption.Double} Mean of pixels in generated image
   * @optionalArg seed {@link VipsOption.Int} Random number seed
   */
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

  /**
   * <p>Reads a single pixel on an image.</p>
   *
   * <p>The pixel values are returned in {@code vector}, the length of the
   * array in {@code n}. You must free the array with g_free() when you are done with
   * it.</p>
   *
   * <p>The result array has an element for each band. If {@code unpack-complex} is set,
   * pixels in complex images are returned as double-length arrays.</p>
   *
   * <p>See also: {@code vips_draw_point}.</p>
   * @param x Point to read
   * @param y Point to read
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg unpack-complex {@link VipsOption.Boolean} Complex pixels should be unpacked
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
   * <p>Use {@code page} to select a page to render, numbering from zero.</p>
   *
   * <p>Use {@code n} to select the number of pages to render. The default is 1. Pages are
   * rendered in a vertical column. Set to -1 to mean &quot;until the end of the
   * document&quot;. Use {@link VImage#grid} to change page layout.</p>
   *
   * <p>Use {@code fail-on} to set the type of error that will cause load to fail. By
   * default, loaders are permissive, that is, {@link app.photofox.vipsffm.enums.VipsFailOn#FAIL_ON_NONE}.</p>
   *
   * <p>The output image is RGBA for GIFs containing transparent elements, RGB
   * otherwise.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage gifload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "gifload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link VImage#gifload}, but read from a memory buffer.</p>
   *
   * <p>You must not free the buffer while {@code out} is active. The
   * {@code VipsObject}::postclose signal on {@code out} is a good place to free.</p>
   *
   * <p>See also: {@link VImage#gifload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Exactly as {@link VImage#gifload}, but read from a source.</p>
   *
   * <p>See also: {@link VImage#gifload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Write to a file in GIF format.</p>
   *
   * <p>Use {@code dither} to set the degree of Floyd-Steinberg dithering
   * and {@code effort} to control the CPU effort (1 is the fastest,
   * 10 is the slowest, 7 is the default).</p>
   *
   * <p>Use {@code bitdepth} (from 1 to 8, default 8) to control the number
   * of colours in the palette. The first entry in the palette is
   * always reserved for transparency. For example, a bitdepth of
   * 4 will allow the output to contain up to 15 colours.</p>
   *
   * <p>Use {@code interframe-maxerror} to set the threshold below which pixels are
   * considered equal.
   * Pixels which don't change from frame to frame can be made transparent,
   * improving the compression rate. Default 0.</p>
   *
   * <p>Use {@code interpalette-maxerror} to set the threshold below which the
   * previously generated palette will be reused.</p>
   *
   * <p>If {@code reuse} is TRUE, the GIF will be saved with a single global
   * palette taken from the metadata in {@code in}, and no new palette optimisation
   * will be done.</p>
   *
   * <p>If {@code interlace} is TRUE, the GIF file will be interlaced (progressive GIF).
   * These files may be better for display over a slow network
   * connection, but need more memory to encode.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
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
   * <p>As {@link VImage#gifsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in {@code buf}, the length of the buffer in
   * {@code len}. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link VImage#gifsave}, {@code vips_image_write_to_file}.</p>
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
   * <p>As {@link VImage#gifsave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#gifsave}, {@code vips_image_write_to_target}.</p>
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
   * <p>{@code globalbalance} can be used to remove contrast differences in
   * an assembled mosaic.</p>
   *
   * <p>It reads the History field attached to {@code in} and builds a list of the source
   * images that were used to make the mosaic and the position that each ended
   * up at in the final image.</p>
   *
   * <p>It opens each of the source images in turn and extracts all parts which
   * overlap with any of the other images. It finds the average values in the
   * overlap areas and uses least-mean-square to find a set of correction
   * factors which will minimise overlap differences. It uses {@code gamma} to
   * gamma-correct the source images before calculating the factors. A value of
   * 1.0 will stop this.</p>
   *
   * <p>Each of the source images is transformed with the appropriate correction
   * factor, then the mosaic is reassembled. {@code out} is {@link VipsBandFormat#FORMAT_FLOAT}, but
   * if {@code int-output} is set, the output image is the same format as the input
   * images.</p>
   *
   * <p>There are some conditions that must be met before this operation can work:
   * the source images must all be present under the filenames recorded in the
   * history on {@code in}, and the mosaic must have been built using only operations in
   * this package.</p>
   *
   * <p>See also: {@code vips_remosaic}.</p>
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
   * <p>The opposite of {@link VImage#extractArea}: place {@code in} within an image of size
   * {@code width} by {@code height} at a certain gravity.</p>
   *
   * <p>{@code extend}
   * controls what appears in the new pels, see {@code VipsExtend}.</p>
   *
   * <p>See also: {@link VImage#extractArea}, {@link VImage#insert}.</p>
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
   * <p>Set {@code uchar} to output a uchar image with the leftmost pixel 0 and the
   * rightmost 255.</p>
   *
   * <p>See also: {@link VImage#xyz}, {@link VImage#identity}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   */
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

  /**
   * <p>Chop a tall thin image up into a set of tiles, lay the tiles out in a grid.</p>
   *
   * <p>The input image should be a very tall, thin image containing a list of
   * smaller images. Volumetric or time-sequence images are often laid out like
   * this. This image is chopped into a series of tiles, each {@code tileHeight}
   * pixels high and the width of {@code in}. The tiles are then rearranged into a grid
   * {@code across} tiles across and {@code down} tiles down in row-major order.</p>
   *
   * <p>Supplying {@code tileHeight}, {@code across} and {@code down} is not strictly necessary, we
   * only really need two of these. Requiring three is a double-check that the
   * image has the expected geometry.</p>
   *
   * <p>See also: {@link VImage#embed}, {@link VImage#insert}, {@link VImage#join}.</p>
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
   * <p>Use {@code page} to select a page to render, numbering from zero. If neither {@code n}
   * nor {@code page} are set, {@code page} defaults to the primary page, otherwise to 0.</p>
   *
   * <p>Use {@code n} to select the number of pages to render. The default is 1. Pages are
   * rendered in a vertical column. Set to -1 to mean &quot;until the end of the
   * document&quot;. Use {@link VImage#grid} to reorganise pages.</p>
   *
   * <p>HEIF images have a primary image. The metadata item `heif-primary` gives
   * the page number of the primary.</p>
   *
   * <p>If {@code thumbnail} is {@code TRUE}, then fetch a stored thumbnail rather than the
   * image.</p>
   *
   * <p>By default, input image dimensions are limited to 16384x16384.
   * If {@code unlimited} is {@code TRUE}, this increases to the maximum of 65535x65535.</p>
   *
   * <p>The bitdepth of the heic image is recorded in the metadata item
   * `heif-bitdepth`.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage heifload(Arena arena, String filename, VipsOption... args) throws VipsError {
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
   * Exactly as {@link VImage#heifload}, but read from a memory buffer.</p>
   *
   * <p>You must not free the buffer while {@code out} is active. The
   * {@code VipsObject}::postclose signal on {@code out} is a good place to free.</p>
   *
   * <p>See also: {@link VImage#heifload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Exactly as {@link VImage#heifload}, but read from a source.</p>
   *
   * <p>See also: {@link VImage#heifload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Write a VIPS image to a file in HEIF format.</p>
   *
   * <p>Use {@code Q} to set the compression factor. Default 50, which seems to be roughly
   * what the iphone uses. Q 30 gives about the same quality as JPEG Q 75.</p>
   *
   * <p>Set {@code lossless} {@code TRUE} to switch to lossless compression.</p>
   *
   * <p>Use {@code compression} to set the compression format e.g. HEVC, AVC, AV1 to use. It defaults to AV1
   * if the target filename ends with &quot;.avif&quot;, otherwise HEVC.</p>
   *
   * <p>Use {@code effort} to control the CPU effort spent improving compression.
   * This is currently only applicable to AV1 encoders. Defaults to 4, 0 is
   * fastest, 9 is slowest.</p>
   *
   * <p>Chroma subsampling is normally automatically disabled for Q &gt;= 90. You can
   * force the subsampling mode with {@code subsample-mode}.</p>
   *
   * <p>Use {@code bitdepth} to set the bitdepth of the output file. HEIC supports at
   * least 8, 10 and 12 bits; other codecs may support more or fewer options.</p>
   *
   * <p>Use {@code encoder} to set the encode library to use, e.g. aom, SVT-AV1, rav1e etc.</p>
   *
   * <p>See also: {@code vips_image_write_to_file}, {@link VImage#heifload}.</p>
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
   * <p>As {@link VImage#heifsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in {@code obuf}, the length of the buffer in
   * {@code olen}. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link VImage#heifsave}, {@code vips_image_write_to_file}.</p>
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
   * <p>As {@link VImage#heifsave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#heifsave}, {@code vips_image_write_to_target}.</p>
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
   * <p>See also: {@link VImage#histNorm}.</p>
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
   * <p>Histogram-equalise {@code in}. Equalise using band {@code bandno}, or if {@code bandno} is -1,
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
   * <p>Find the histogram of {@code in}. Find the histogram for band {@code band} (producing a
   * one-band histogram), or for all bands (producing an n-band histogram) if
   * {@code band} is -1.</p>
   *
   * <p>char and uchar images are cast to uchar before histogramming, all other
   * image types are cast to ushort.</p>
   *
   * <p>See also: {@link VImage#histFindNdim}, {@link VImage#histFindIndexed}.</p>
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
   * <p>Make a histogram of {@code in}, but use image {@code index} to pick the bins. In other
   * words, element zero in {@code out} contains the combination of all the pixels in {@code in}
   * whose corresponding pixel in {@code index} is zero.</p>
   *
   * <p>char and uchar {@code index} images are cast to uchar before histogramming, all
   * other image types are cast to ushort. {@code index} must have just one band.</p>
   *
   * <p>{@code in} must be non-complex.</p>
   *
   * <p>{@code out} always has the same size and format as {@code in}.</p>
   *
   * <p>Normally, bins are summed, but you can use {@code combine} to set other combine
   * modes.</p>
   *
   * <p>This operation is useful in conjunction with {@link VImage#labelregions}. You can
   * use it to find the centre of gravity of blobs in an image, for example.</p>
   *
   * <p>See also: {@link VImage#histFind}, {@link VImage#labelregions}.</p>
   * @param index Index image
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg combine {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsCombine} Combine bins like this
   */
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

  /**
   * <p>Make a one, two or three dimensional histogram of a 1, 2 or
   * 3 band image. Divide each axis into {@code bins} bins .. ie.
   * output is 1 x bins, bins x bins, or bins x bins x bins bands.
   * {@code bins} defaults to 10.</p>
   *
   * <p>char and uchar images are cast to uchar before histogramming, all other
   * image types are cast to ushort.</p>
   *
   * <p>See also: {@link VImage#histFind}, {@link VImage#histFindIndexed}.</p>
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
   * <p>Test {@code in} for monotonicity. {@code out} is set non-zero if {@code in} is monotonic.</p>
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
   * <p>Performs local histogram equalisation on {@code in} using a
   * window of size {@code width} by {@code height} centered on the input pixel.</p>
   *
   * <p>The output image is the same size as the input image. The edge pixels are
   * created by mirroring the input image outwards.</p>
   *
   * <p>If {@code max-slope} is greater than 0, it sets the maximum value for the slope of
   * the cumulative histogram, that is, the maximum brightening that is
   * performed. A value of 3 is often used. Local histogram equalization with
   * contrast limiting is usually called CLAHE.</p>
   *
   * <p>See also: {@link VImage#histEqual}.</p>
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
   * <p>Adjust {@code in} to match {@code ref}. If {@code in} and {@code ref} are normalised
   * cumulative histograms, {@code out} will be a LUT that adjusts the PDF of the image
   * from which {@code in} was made to match the PDF of {@code ref}'s image.</p>
   *
   * <p>See also: {@link VImage#maplut}, {@link VImage#histFind}, {@link VImage#histNorm},
   * {@link VImage#histCum}.</p>
   * @param ref Reference histogram
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Normalise histogram. The maximum of each band becomes equal to the maximum
   * index, so for example the max for a uchar image becomes 255.
   * Normalise each band separately.</p>
   *
   * <p>See also: {@link VImage#histCum}.</p>
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
   * <p>&lt;b&gt;unsigned char&lt;/b&gt; max is always 256</p>
   *
   * <p>&lt;b&gt;other unsigned integer types&lt;/b&gt; output 0 - maximum
   * value of {@code in}.</p>
   *
   * <p>&lt;b&gt;signed int types&lt;/b&gt; min moved to 0, max moved to max + min.</p>
   *
   * <p>&lt;b&gt;float types&lt;/b&gt; min moved to 0, max moved to any
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
   * <p>Find the circular Hough transform of an image. {@code in} must be one band, with
   * non-zero pixels for image edges. {@code out} is three-band, with the third channel
   * representing the detected circle radius. The operation scales the number of
   * votes by circle circumference so circles of differing size are given equal
   * weight.</p>
   *
   * <p>The output pixel at (x, y, band) is the strength of the circle centred on
   * (x, y) and with radius (band).</p>
   *
   * <p>Use {@code max-radius} and {@code min-radius} to set the range of radii to search for.</p>
   *
   * <p>Use {@code scale} to set how {@code in} coordinates are scaled to {@code out} coordinates. A
   * {@code scale} of 3, for example, will make {@code out} 1/3rd of the width and height of
   * {@code in}, and reduce the number of radii tested (and hence the number of bands
   * int {@code out}) by a factor of three as well.</p>
   *
   * <p>See also: {@link VImage#houghLine}.</p>
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
   * <p>Find the line Hough transform for {@code in}. {@code in} must have one band. {@code out} has one
   * band, with pixels being the number of votes for that line. The X dimension
   * of {@code out} is the line angle in 0 - 180 degrees, the Y dimension is the
   * distance of the closest part of that line to the origin in the top-left.</p>
   *
   * <p>Use {@code width} {@code height} to set the size of the parameter space image ({@code out}),
   * that is, how accurate the line determination should be.</p>
   *
   * <p>See also: {@link VImage#houghCircle}.</p>
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
   * If {@code pcs} is
   * set to {@link app.photofox.vipsffm.enums.VipsPCS#PCS_XYZ}, use CIE XYZ PCS instead.
   * If {@code output-profile} is not set, use the embedded profile, if any.
   * If {@code output-profile} is set, export with that and attach it to the output
   * image.</p>
   *
   * <p>If {@code black-point-compensation} is set, LCMS black point compensation is
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
   * <p>Import an image from device space to D65 LAB with an ICC profile. If {@code pcs} is
   * set to {@link app.photofox.vipsffm.enums.VipsPCS#PCS_XYZ}, use CIE XYZ PCS instead.</p>
   *
   * <p>The input profile is searched for in three places:
   *
   *  1. If {@code embedded} is set, libvips will try to use any profile in the input
   *   image metadata. You can test for the presence of an embedded profile
   *   with {@code vips_image_get_typeof} with {@code VIPS_META_ICC_NAME} as an argument.
   *   This will return {@code GType} 0 if there is no profile.
   *
   *  2. Otherwise, if {@code input-profile} is set, libvips will try to load a
   *   profile from the named file. This can aslso be the name of one of the
   *   built-in profiles.
   *
   *  3. Otherwise, libvips will try to pick a compatible profile from the set
   *   of built-in profiles.</p>
   *
   * <p>If {@code black-point-compensation} is set, LCMS black point compensation is
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
   *  1. If {@code embedded} is set, libvips will try to use any profile in the input
   *   image metadata. You can test for the presence of an embedded profile
   *   with {@code vips_image_get_typeof} with {@code VIPS_META_ICC_NAME} as an argument.
   *   This will return {@code GType} 0 if there is no profile.
   *
   *  2. Otherwise, if {@code input-profile} is set, libvips will try to load a
   *   profile from the named file. This can aslso be the name of one of the
   *   built-in profiles.
   *
   *  3. Otherwise, libvips will try to pick a compatible profile from the set
   *   of built-in profiles.</p>
   *
   * <p>If {@code black-point-compensation} is set, LCMS black point compensation is
   * enabled.</p>
   *
   * <p>{@code depth} defaults to 8, or 16 if {@code in} is a 16-bit image.</p>
   *
   * <p>The output image has the output profile attached to the {@code VIPS_META_ICC_NAME}
   * field.</p>
   *
   * <p>Use {@link VImage#iccImport} and {@link VImage#iccExport} to do either the first or
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
   * unchanged when applied with {@link VImage#maplut}. Each entry in the table has a
   * value equal to its position.</p>
   *
   * <p>Use the arithmetic operations on these tables to make LUTs representing
   * arbitrary functions.</p>
   *
   * <p>Normally LUTs are 8-bit. Set {@code ushort} to create a 16-bit table.</p>
   *
   * <p>Normally 16-bit tables have 65536 entries. You can set this smaller with
   * {@code size}.</p>
   *
   * <p>See also: {@link VImage#xyz}, {@link VImage#maplut}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg bands {@link VipsOption.Int} Number of bands in LUT
   * @optionalArg ushort {@link VipsOption.Boolean} Create a 16-bit LUT
   * @optionalArg size {@link VipsOption.Int} Size of 16-bit LUT
   */
  public static VImage identity(Arena arena, VipsOption... args) throws VipsError {
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "identity", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation scans the condition image {@code cond}
   * and uses it to select pixels from either the then image {@code in1} or the else
   * image {@code in2}. Non-zero means {@code in1}, 0 means {@code in2}.</p>
   *
   * <p>Any image can have either 1 band or n bands, where n is the same for all
   * the non-1-band images. Single band images are then effectively copied to
   * make n-band images.</p>
   *
   * <p>Images {@code in1} and {@code in2} are cast up to the smallest common format. {@code cond} is
   * cast to uchar.</p>
   *
   * <p>If the images differ in size, the smaller images are enlarged to match the
   * largest by adding zero pixels along the bottom and right.</p>
   *
   * <p>If {@code blend} is {@code TRUE}, then values in {@code out} are smoothly blended between {@code in1}
   * and {@code in2} using the formula:
   *
   *  {@code out} = ({@code cond} / 255) * {@code in1} + (1 - {@code cond} / 255) * {@code in2}</p>
   *
   * <p>See also: {@code vips_equal}.</p>
   * @param in1 Source for TRUE pixels
   * @param in2 Source for FALSE pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg blend {@link VipsOption.Boolean} Blend smoothly between then and else parts
   */
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

  /**
   * <p>Insert {@code sub} into {@code main} at position {@code x}, {@code y}.</p>
   *
   * <p>Normally {@code out} shows the whole of {@code main}. If {@code expand} is {@code TRUE} then {@code out} is
   * made large enough to hold all of {@code main} and {@code sub}.
   * Any areas of {@code out} not coming from
   * either {@code main} or {@code sub} are set to {@code background} (default 0).</p>
   *
   * <p>If {@code sub} overlaps {@code main},
   * {@code sub} will appear on top of {@code main}.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common type (see table
   * Smallest common format in
   * {@code arithmetic}).</p>
   *
   * <p>See also: {@link VImage#join}, {@link VImage#embed}, {@link VImage#extractArea}.</p>
   * @param sub Sub-image to insert into main image
   * @param x Left edge of sub in main
   * @param y Top edge of sub in main
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg expand {@link VipsOption.Boolean} Expand output to hold all of both inputs
   * @optionalArg background {@link VipsOption.ArrayDouble} Color for new pixels
   */
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

  /**
   * <p>For unsigned formats, this operation calculates (max - {@code in}), eg. (255 -
   * {@code in}) for uchar. For signed and float formats, this operation calculates (-1
   * {@code in}).</p>
   *
   * <p>For complex images, only the real part is inverted. See also {@code vips_conj}.</p>
   *
   * <p>See also: {@link VImage#linear}.</p>
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
   * <p>Eg. input like this:
   *
   *  &lt;tgroup cols='4' align='left' colsep='1' rowsep='1'&gt;
   *     &lt;tbody&gt;
   *       &lt;row&gt;
   *         &lt;entry&gt;4&lt;/entry&gt;
   *         &lt;entry&gt;3&lt;/entry&gt;
   *       &lt;/row&gt;
   *       &lt;row&gt;
   *         &lt;entry&gt;0.1&lt;/entry&gt;
   *         &lt;entry&gt;0.2&lt;/entry&gt;
   *         &lt;entry&gt;0.3&lt;/entry&gt;
   *         &lt;entry&gt;0.1&lt;/entry&gt;
   *       &lt;/row&gt;
   *       &lt;row&gt;
   *         &lt;entry&gt;0.2&lt;/entry&gt;
   *         &lt;entry&gt;0.4&lt;/entry&gt;
   *         &lt;entry&gt;0.4&lt;/entry&gt;
   *         &lt;entry&gt;0.2&lt;/entry&gt;
   *       &lt;/row&gt;
   *       &lt;row&gt;
   *         &lt;entry&gt;0.7&lt;/entry&gt;
   *         &lt;entry&gt;0.5&lt;/entry&gt;
   *         &lt;entry&gt;0.6&lt;/entry&gt;
   *         &lt;entry&gt;0.3&lt;/entry&gt;
   *       &lt;/row&gt;
   *     &lt;/tbody&gt;
   *   &lt;/tgroup&gt;</p>
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
   * <p>See also: {@link VImage#buildlut}.</p>
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
   * If you are OK with a real result, set {@code real}, it's quicker.</p>
   *
   * <p>VIPS uses the fftw Fourier Transform library. If this library was not
   * available when VIPS was configured, these functions will fail.</p>
   *
   * <p>See also: {@link VImage#fwfft}.</p>
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
   * <p>Join {@code in1} and {@code in2} together, left-right or up-down depending on the value
   * of {@code direction}.</p>
   *
   * <p>If one is taller or wider than the
   * other, {@code out} will be has high as the smaller. If {@code expand} is {@code TRUE}, then
   * the output will be expanded to contain all of the input pixels.</p>
   *
   * <p>Use {@code align} to set the edge that the images align on. By default, they align
   * on the edge with the lower value coordinate.</p>
   *
   * <p>Use {@code background} to set the colour of any pixels in {@code out} which are not
   * present in either {@code in1} or {@code in2}.</p>
   *
   * <p>Use {@code shim} to set the spacing between the images. By default this is 0.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common type (see table
   * Smallest common format in
   * {@code arithmetic}).</p>
   *
   * <p>If you are going to be joining many thousands of images in a regular
   * grid, {@link VImage#arrayjoin} is a better choice.</p>
   *
   * <p>See also: {@link VImage#arrayjoin}, {@link VImage#insert}.</p>
   * @param in2 Second input image
   * @param direction {@link VipsDirection} Join left-right or up-down
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg expand {@link VipsOption.Boolean} Expand output to hold all of both inputs
   * @optionalArg shim {@link VipsOption.Int} Pixels between images
   * @optionalArg background {@link VipsOption.ArrayDouble} Colour for new pixels
   * @optionalArg align {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAlign} Align on the low, centre or high coordinate edge
   */
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

  /**
   * <p>Read a JPEG2000 image. The loader supports 8, 16 and 32-bit int pixel
   * values, signed and unsigned. It supports greyscale, RGB, YCC, CMYK and
   * multispectral colour spaces. It will read any ICC profile on the image.</p>
   *
   * <p>It will only load images where all channels have the same format.</p>
   *
   * <p>Use {@code page} to set the page to load, where page 0 is the base resolution
   * image and higher-numbered pages are x2 reductions. Use the metadata item
   * &quot;n-pages&quot; to find the number of pyramid layers.</p>
   *
   * <p>Use {@code fail-on} to set the type of error that will cause load to fail. By
   * default, loaders are permissive, that is, {@link app.photofox.vipsffm.enums.VipsFailOn#FAIL_ON_NONE}.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage jp2kload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jp2kload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link VImage#jp2kload}, but read from a buffer.</p>
   *
   * <p>You must not free the buffer while {@code out} is active. The
   * {@code VipsObject}::postclose signal on {@code out} is a good place to free.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Exactly as {@link VImage#jp2kload}, but read from a source.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Write a VIPS image to a file in JPEG2000 format.
   * The saver supports 8, 16 and 32-bit int pixel
   * values, signed and unsigned. It supports greyscale, RGB, CMYK and
   * multispectral images.</p>
   *
   * <p>Use {@code Q} to set the compression quality factor. The default value
   * produces file with approximately the same size as regular JPEG Q 75.</p>
   *
   * <p>Set {@code lossless} to enable lossless compression.</p>
   *
   * <p>Use {@code tile-width} and {@code tile-height} to set the tile size. The default is 512.</p>
   *
   * <p>Chroma subsampling is normally disabled for compatibility. Set
   * {@code subsample-mode} to auto to enable chroma subsample for Q &lt; 90. Subsample
   * mode uses YCC rather than RGB colourspace, and many jpeg2000 decoders do
   * not support this.</p>
   *
   * <p>This operation always writes a pyramid.</p>
   *
   * <p>See also: {@code vips_image_write_to_file}, {@link VImage#jp2kload}.</p>
   * @param filename Filename to save to
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
   * <p>As {@link VImage#jp2ksave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#jp2ksave}, {@code vips_image_write_to_target}.</p>
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
   * <p>As {@link VImage#jp2ksave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#jp2ksave}, {@code vips_image_write_to_target}.</p>
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
   * <p>{@code shrink} means shrink by this integer factor during load.  Possible values
   * are 1, 2, 4 and 8. Shrinking during read is very much faster than
   * decompressing the whole image and then shrinking later.</p>
   *
   * <p>Use {@code fail-on} to set the type of error that will cause load to fail. By
   * default, loaders are permissive, that is, {@link app.photofox.vipsffm.enums.VipsFailOn#FAIL_ON_NONE}.</p>
   *
   * <p>Setting {@code autorotate} to {@code TRUE} will make the loader interpret the
   * orientation tag and automatically rotate the image appropriately during
   * load.</p>
   *
   * <p>If {@code autorotate} is {@code FALSE}, the metadata field {@code VIPS_META_ORIENTATION} is set
   * to the value of the orientation tag. Applications may read and interpret
   * this field
   * as they wish later in processing. See {@link VImage#autorot}. Save
   * operations will use {@code VIPS_META_ORIENTATION}, if present, to set the
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
   * {@code VIPS_META_ICC_NAME}. You need to use something like
   * {@link VImage#iccImport} to get CIE values from the file.</p>
   *
   * <p>EXIF metadata is attached as {@code VIPS_META_EXIF_NAME}, IPTC as
   * {@code VIPS_META_IPTC_NAME}, and XMP as {@code VIPS_META_XMP_NAME}.</p>
   *
   * <p>The int metadata item &quot;jpeg-multiscan&quot; is set to the result of
   * jpeg_has_multiple_scans(). Interlaced jpeg images need a large amount of
   * memory to load, so this field gives callers a chance to handle these
   * images differently.</p>
   *
   * <p>The string-valued field &quot;jpeg-chroma-subsample&quot; gives the chroma subsample
   * in standard notation. 4:4:4 means no subsample, 4:2:0 means YCbCr with
   * Cb and Cr subsampled horizontally and vertically, 4:4:4:4 means a CMYK
   * image with no subsampling.</p>
   *
   * <p>The EXIF thumbnail, if present, is attached to the image as
   * &quot;jpeg-thumbnail-data&quot;. See {@code vips_image_get_blob}.</p>
   *
   * <p>See also: {@link VImage#jpegloadBuffer}, {@code vips_image_new_from_file}, {@link VImage#autorot}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage jpegload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jpegload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Read a JPEG-formatted memory block into a VIPS image. Exactly as
   * {@link VImage#jpegload}, but read from a memory buffer.</p>
   *
   * <p>You must not free the buffer while {@code out} is active. The
   * {@code VipsObject}::postclose signal on {@code out} is a good place to free.</p>
   *
   * <p>See also: {@link VImage#jpegload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Read a JPEG-formatted memory block into a VIPS image. Exactly as
   * {@link VImage#jpegload}, but read from a source.</p>
   *
   * <p>See also: {@link VImage#jpegload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Write a VIPS image to a file as JPEG.</p>
   *
   * <p>Use {@code Q} to set the JPEG compression factor. Default 75.</p>
   *
   * <p>If {@code optimize-coding} is set, the Huffman tables are optimized. This is
   * slightly slower and produces slightly smaller files.</p>
   *
   * <p>If {@code interlace} is set, the jpeg files will be interlaced (progressive jpeg,
   * in jpg parlance). These files may be better for display over a slow network
   * connection, but need much more memory to encode and decode.</p>
   *
   * <p>Chroma subsampling is normally automatically disabled for Q &gt;= 90. You can
   * force the subsampling mode with {@code subsample-mode}.</p>
   *
   * <p>If {@code trellis-quant} is set and the version of libjpeg supports it
   * (e.g. mozjpeg &gt;= 3.0), apply trellis quantisation to each 8x8 block.
   * Reduces file size but increases compression time.</p>
   *
   * <p>If {@code overshoot-deringing} is set and the version of libjpeg supports it
   * (e.g. mozjpeg &gt;= 3.0), apply overshooting to samples with extreme values
   * for example 0 and 255 for 8-bit. Overshooting may reduce ringing artifacts
   * from compression, in particular in areas where black text appears on a
   * white background.</p>
   *
   * <p>If {@code optimize-scans} is set and the version of libjpeg supports it
   * (e.g. mozjpeg &gt;= 3.0), split the spectrum of DCT coefficients into
   * separate scans. Reduces file size but increases compression time.</p>
   *
   * <p>If {@code quant-table} is set and the version of libjpeg supports it
   * (e.g. mozjpeg &gt;= 3.0) it selects the quantization table to use:</p>
   *
   * <p>* 0 &mdash; Tables from JPEG Annex K (vips and libjpeg default)
   * * 1 &mdash; Flat table
   * * 2 &mdash; Table tuned for MSSIM on Kodak image set
   * * 3 &mdash; Table from ImageMagick by N. Robidoux (current mozjpeg default)
   * * 4 &mdash; Table tuned for PSNR-HVS-M on Kodak image set
   * * 5 &mdash; Table from Relevance of Human Vision to JPEG-DCT Compression (1992)
   * * 6 &mdash; Table from DCTune Perceptual Optimization of Compressed Dental
   *   X-Rays (1997)
   * * 7 &mdash; Table from A Visual Detection Model for DCT Coefficient
   *   Quantization (1993)
   * * 8 &mdash; Table from An Improved Detection Model for DCT Coefficient
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
   * <p>EXIF data is constructed from {@code VIPS_META_EXIF_NAME}, then
   * modified with any other related tags on the image before being written to
   * the file. {@code VIPS_META_RESOLUTION_UNIT} is used to set the EXIF resolution
   * unit. {@code VIPS_META_ORIENTATION} is used to set the EXIF orientation tag.</p>
   *
   * <p>IPTC as {@code VIPS_META_IPTC_NAME} and XMP as {@code VIPS_META_XMP_NAME}
   * are coded and attached.</p>
   *
   * <p>See also: {@link VImage#jpegsaveBuffer}, {@code vips_image_write_to_file}.</p>
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
   * <p>As {@link VImage#jpegsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in {@code obuf}, the length of the buffer in
   * {@code olen}. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link VImage#jpegsave}, {@code vips_image_write_to_file}.</p>
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
   * <p>As {@link VImage#jpegsave}, but save as a mime jpeg on stdout.</p>
   *
   * <p>See also: {@link VImage#jpegsave}, {@code vips_image_write_to_file}.</p>
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
   * <p>As {@link VImage#jpegsave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#jpegsave}, {@code vips_image_write_to_target}.</p>
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
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param filename Filename to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
  public static VImage jxlload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "jxlload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link VImage#jxlload}, but read from a buffer.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param buffer Buffer to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
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

  /**
   * <p>Exactly as {@link VImage#jxlload}, but read from a source.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param source Source to load from
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg page {@link VipsOption.Int} First page to load
   * @optionalArg n {@link VipsOption.Int} Number of pages to load, -1 for all
   * @optionalArg flags {@link VipsOption.Int} Flags for this file
   * @optionalArg memory {@link VipsOption.Boolean} Force open via memory
   * @optionalArg access {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAccess} Required access pattern for this file
   * @optionalArg fail-on {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsFailOn} Error level to fail on
   * @optionalArg revalidate {@link VipsOption.Boolean} Don't use a cached result for this operation
   * @optionalArg sequential {@link VipsOption.Boolean} Sequential read only
   * @optionalArg fail {@link VipsOption.Boolean} Fail on first warning
   * @optionalArg disc {@link VipsOption.Boolean} Open to disc
   */
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

  /**
   * <p>Write a VIPS image to a file in JPEG-XL format.</p>
   *
   * <p>The JPEG-XL loader and saver are experimental features and may change
   * in future libvips versions.</p>
   *
   * <p>{@code tier} sets the overall decode speed the encoder will target. Minimum is 0
   * (highest quality), and maximum is 4 (lowest quality). Default is 0.</p>
   *
   * <p>{@code distance} sets the target maximum encoding error. Minimum is 0
   * (highest quality), and maximum is 15 (lowest quality). Default is 1.0
   * (visually lossless).</p>
   *
   * <p>As a convenience, you can also use {@code Q} to set {@code distance}. {@code Q} uses
   * approximately the same scale as regular JPEG.</p>
   *
   * <p>Set {@code lossless} to enable lossless compression.</p>
   * @param filename Filename to save to
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
   * <p>As {@link VImage#jxlsave}, but save to a memory buffer.</p>
   *
   * <p>See also: {@link VImage#jxlsave}, {@code vips_image_write_to_target}.</p>
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
   * <p>As {@link VImage#jxlsave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#jxlsave}, {@code vips_image_write_to_target}.</p>
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
   * <p>Repeatedly scans {@code in} for regions of 4-connected pixels
   * with the same pixel value. Every time a region is discovered, those
   * pixels are marked in {@code mask} with a unique serial number. Once all pixels
   * have been labelled, the operation returns, setting {@code segments} to the number
   * of discrete regions which were detected.</p>
   *
   * <p>{@code mask} is always a 1-band {@link VipsBandFormat#FORMAT_INT} image of the same dimensions as
   * {@code in}.</p>
   *
   * <p>This operation is useful for, for example, blob counting. You can use the
   * morphological operators to detect and isolate a series of objects, then use
   * {@code labelregions} to number them all.</p>
   *
   * <p>Use {@link VImage#histFindIndexed} to (for example) find blob coordinates.</p>
   *
   * <p>See also: {@link VImage#histFindIndexed}.</p>
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
   * <p>Pass an image through a linear transform, ie. ({@code out} = {@code in} * {@code a} + {@code b}). Output
   * is float for integer input, double for double input, complex for
   * complex input and double complex for double complex input. Set {@code uchar} to
   * output uchar pixels.</p>
   *
   * <p>If the arrays of constants have just one element, that constant is used for
   * all image bands. If the arrays have more than one element and they have
   * the same number of elements as there are bands in the image, then
   * one array element is used for each band. If the arrays have more than one
   * element and the image only has a single band, the result is a many-band
   * image where each band corresponds to one array element.</p>
   *
   * <p>See also: {@code vips_linear1}, {@link VImage#add}.</p>
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
   * <p>This operation behaves rather like {@link VImage#copy} between images
   * {@code in} and {@code out}, except that it keeps a cache of computed scanlines.</p>
   *
   * <p>The number of lines cached is enough for a small amount of non-local
   * access.</p>
   *
   * <p>Each cache tile is made with a single call to
   * {@code vips_region_prepare}.</p>
   *
   * <p>When the cache fills, a tile is chosen for reuse. If {@code access} is
   * {@link app.photofox.vipsffm.enums.VipsAccess#ACCESS_RANDOM}, then the least-recently-used tile is reused. If
   * {@code access} is {@link app.photofox.vipsffm.enums.VipsAccess#ACCESS_SEQUENTIAL}, then
   * the top-most tile is reused. {@code access} defaults to {@link app.photofox.vipsffm.enums.VipsAccess#ACCESS_RANDOM}.</p>
   *
   * <p>{@code tile-height} can be used to set the size of the strips that
   * {@code linecache} uses. The default is 1 (a single scanline).</p>
   *
   * <p>Normally, only a single thread at once is allowed to calculate tiles. If
   * you set {@code threaded} to {@code TRUE}, {@code linecache} will allow many threads to
   * calculate tiles at once and share the cache between them.</p>
   *
   * <p>See also: {@code vips_cache}, {@link VImage#tilecache}.</p>
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
   * {@code sigma}.  The size of the mask is determined by the variable {@code minAmpl};
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
   * <p>where s2 = {@code sigma} * {@code sigma}, s4 = s2 * s2, r2 = r * r.</p>
   *
   * <p>The generated mask has odd size and its maximum value is normalised to
   * 1.0, unless {@code precision} is {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER}.</p>
   *
   * <p>If {@code separable} is set, only the centre horizontal is generated. This is
   * useful for separable convolutions.</p>
   *
   * <p>If {@code precision} is {@link app.photofox.vipsffm.enums.VipsPrecision#PRECISION_INTEGER}, an integer mask is generated.
   * This is useful for integer convolutions.</p>
   *
   * <p>&quot;scale&quot; is set to the sum of all the mask elements.</p>
   *
   * <p>See also: {@link VImage#gaussmat}, {@link VImage#conv}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param sigma Radius of Gaussian
   * @param minAmpl Minimum amplitude of Gaussian
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg separable {@link VipsOption.Boolean} Generate separable Gaussian
   * @optionalArg integer {@link VipsOption.Boolean} Generate integer Gaussian
   * @optionalArg precision {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsPrecision} Generate with this precision
   */
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

  /**
   * <p>Read in an image using libMagick, the ImageMagick library. This library can
   * read more than 80 file formats, including SVG, BMP, EPS, DICOM and many
   * others.
   * The reader can handle any ImageMagick image, including the float and double
   * formats. It will work with any quantum size, including HDR. Any metadata
   * attached to the libMagick image is copied on to the VIPS image.</p>
   *
   * <p>The reader should also work with most versions of GraphicsMagick. See the
   * &quot;--with-magickpackage&quot; configure option.</p>
   *
   * <p>The file format is usually guessed from the filename suffix, or sniffed
   * from the file contents.</p>
   *
   * <p>Normally it will only load the first image in a many-image sequence (such
   * as a GIF or a PDF). Use {@code page} and {@code n} to set the start page and number of
   * pages to load. Set {@code n} to -1 to load all pages from {@code page} onwards.</p>
   *
   * <p>{@code density} is &quot;WxH&quot; in DPI, e.g. &quot;600x300&quot; or &quot;600&quot; (default is &quot;72x72&quot;). See
   * the [density
   * docs](http://www.imagemagick.org/script/command-line-options.php{@code density})
   * on the imagemagick website.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Read an image memory block using libMagick into a VIPS image. Exactly as
   * {@link VImage#magickload}, but read from a memory source.</p>
   *
   * <p>You must not free the buffer while {@code out} is active. The
   * {@code VipsObject}::postclose signal on {@code out} is a good place to free.</p>
   *
   * <p>See also: {@link VImage#magickload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Write an image using libMagick.</p>
   *
   * <p>Use {@code quality} to set the quality factor. Default 0.</p>
   *
   * <p>Use {@code format} to explicitly set the save format, for example, &quot;BMP&quot;. Otherwise
   * the format is guessed from the filename suffix.</p>
   *
   * <p>If {@code optimize-gif-frames} is set, GIF frames are cropped to the smallest size
   * while preserving the results of the GIF animation. This takes some time for
   * computation but saves some time on encoding and produces smaller files in
   * some cases.</p>
   *
   * <p>If {@code optimize-gif-transparency} is set, pixels that don't change the image
   * through animation are made transparent. This takes some time for computation
   * but saves some time on encoding and produces smaller files in some cases.</p>
   *
   * <p>{@code bitdepth} specifies the number of bits per pixel. The image will be quantized
   * and dithered if the value is within the valid range (1 to 8).</p>
   *
   * <p>See also: {@link VImage#magicksaveBuffer}, {@link VImage#magickload}.</p>
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
   * Save bmp image with ImageMagick
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
  @Deprecated(
      forRemoval = true
  )
  public void magicksaveBmp(String filename, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var filenameOption = VipsOption.String("filename", filename);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(filenameOption);
    VipsInvoker.invokeOperation(arena, "magicksave_bmp", callArgs);
  }

  /**
   * Save bmp image to magick buffer
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
  @Deprecated(
      forRemoval = true
  )
  public VBlob magicksaveBmpBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "magicksave_bmp_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /**
   * <p>As {@link VImage#magicksave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in {@code obuf}, the length of the buffer in
   * {@code olen}. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link VImage#magicksave}, {@code vips_image_write_to_file}.</p>
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
   * <p>This operator resamples {@code in} using {@code index} to look up pixels. {@code out} is
   * the same size as {@code index}, with each pixel being fetched from that position in
   * {@code in}. That is:</p>
   *
   * <pre>{@code 
   * out[x, y] = in[index[x, y]]
   * }</pre>
   *
   * <p>If {@code index} has one band, that band must be complex. Otherwise, {@code index} must
   * have two bands of any format.</p>
   *
   * <p>Coordinates in {@code index} are in pixels, with (0, 0) being the top-left corner
   * of {@code in}, and with y increasing down the image. Use {@link VImage#xyz} to build index
   * images.</p>
   *
   * <p>{@code interpolate} defaults to bilinear.</p>
   *
   * <p>By default, new pixels are filled with {@code background}. This defaults to
   * zero (black). You can set other extend types with {@code extend}. {@link app.photofox.vipsffm.enums.VipsExtend#EXTEND_COPY}
   * is better for image upsizing.</p>
   *
   * <p>Image are normally treated as unpremultiplied, so this operation can be used
   * directly on PNG images. If your images have been through {@link VImage#premultiply},
   * set {@code premultiplied}.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See {@link VImage#maplut} for a 1D equivalent of this operation.</p>
   *
   * <p>See also: {@link VImage#xyz}, {@link VImage#affine}, {@link VImage#resize},
   * {@link VImage#maplut}, {@code VipsInterpolate}.</p>
   * @param index Index pixels with this
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg interpolate {@link VipsOption.Interpolate} Interpolate pixels with this
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg premultiplied {@link VipsOption.Boolean} Images have premultiplied alpha
   * @optionalArg extend {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsExtend} How to generate the extra pixels
   */
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

  /**
   * <p>Map an image through another image acting as a LUT (Look Up Table).
   * The lut may have any type and the output image will be that type.</p>
   *
   * <p>The input image will be cast to one of the unsigned integer types, that is,
   * VIPS_FORMAT_UCHAR, VIPS_FORMAT_USHORT or VIPS_FORMAT_UINT.</p>
   *
   * <p>If {@code lut} is too small for the input type (for example, if {@code in} is
   * VIPS_FORMAT_UCHAR but {@code lut} only has 100 elements), the lut is padded out
   * by copying the last element. Overflows are reported at the end of
   * computation.
   * If {@code lut} is too large, extra values are ignored.</p>
   *
   * <p>If {@code lut} has one band and {@code band} is -1 (the default), then all bands of {@code in}
   * pass through {@code lut}. If {@code band} is &gt;= 0, then just that band of {@code in} passes
   * through {@code lut} and other bands are just copied.</p>
   *
   * <p>If {@code lut}
   * has same number of bands as {@code in}, then each band is mapped
   * separately. If {@code in} has one band, then {@code lut} may have many bands and
   * the output will have the same number of bands as {@code lut}.</p>
   *
   * <p>See also: {@link VImage#histFind}, {@link VImage#identity}.</p>
   * @param lut Look-up table image
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg band {@link VipsOption.Int} Apply one-band lut to this band of in
   */
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

  /**
   * <p>Make an butterworth high- or low-pass filter, that is, one with a variable,
   * smooth transition
   * positioned at {@code frequencyCutoff}, where {@code frequencyCutoff} is in
   * range 0 - 1. The shape of the curve is controlled by
   * {@code order} --- higher values give a sharper transition. See Gonzalez and Wintz,
   * Digital Image Processing, 1987.</p>
   *
   * <p>See also: {@link VImage#maskIdeal}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Make an butterworth band-pass or band-reject filter, that is, one with a
   * variable, smooth transition positioned at {@code frequencyCutoffX},
   * {@code frequencyCutoffY}, of radius {@code radius}.
   * The shape of the curve is controlled by
   * {@code order} --- higher values give a sharper transition. See Gonzalez and Wintz,
   * Digital Image Processing, 1987.</p>
   *
   * <p>See also: {@link VImage#maskIdeal}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Make a butterworth ring-pass or ring-reject filter, that is, one with a
   * variable,
   * smooth transition
   * positioned at {@code frequencyCutoff} of width {@code width}, where {@code frequencyCutoff} is
   * in the range 0 - 1. The shape of the curve is controlled by
   * {@code order} --- higher values give a sharper transition. See Gonzalez and Wintz,
   * Digital Image Processing, 1987.</p>
   *
   * <p>See also: {@link VImage#maskIdeal}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>This operation should be used to create fractal images by filtering the
   * power spectrum of Gaussian white noise. See {@link VImage#gaussnoise}.</p>
   *
   * <p>See also: {@link VImage#maskIdeal}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param fractalDimension Fractal dimension
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg nodc {@link VipsOption.Boolean} Remove DC component
   * @optionalArg reject {@link VipsOption.Boolean} Invert the sense of the filter
   * @optionalArg optical {@link VipsOption.Boolean} Rotate quadrants to optical space
   */
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

  /**
   * <p>Make a gaussian high- or low-pass filter, that is, one with a variable,
   * smooth transition positioned at {@code frequencyCutoff}.</p>
   *
   * <p>See also: {@link VImage#maskIdeal}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Make a gaussian band-pass or band-reject filter, that is, one with a
   * variable, smooth transition positioned at {@code frequencyCutoffX},
   * {@code frequencyCutoffY}, of radius {@code radius}.</p>
   *
   * <p>See also: {@link VImage#maskIdeal}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Make a gaussian ring-pass or ring-reject filter, that is, one with a
   * variable, smooth transition positioned at {@code frequencyCutoff} of width
   * {@code ringwidth}.</p>
   *
   * <p>See also: {@link VImage#maskIdeal}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Make an ideal high- or low-pass filter, that is, one with a sharp cutoff
   * positioned at {@code frequencyCutoff}, where {@code frequencyCutoff} is in
   * the range 0 - 1.</p>
   *
   * <p>This operation creates a one-band float image of the specified size.
   * The image has
   * values in the range [0, 1] and is typically used for multiplying against
   * frequency domain images to filter them.
   * Masks are created with the DC component at (0, 0). The DC pixel always
   * has the value 1.0.</p>
   *
   * <p>Set {@code nodc} to not set the DC pixel.</p>
   *
   * <p>Set {@code optical} to position the DC component in the centre of the image. This
   * makes the mask suitable for multiplying against optical Fourier transforms.
   * See {@link VImage#wrap}.</p>
   *
   * <p>Set {@code reject} to invert the sense of
   * the filter. For example, low-pass becomes low-reject.</p>
   *
   * <p>Set {@code uchar} to output an 8-bit unsigned char image rather than a
   * float image. In this case, pixels are in the range [0 - 255].</p>
   *
   * <p>See also: {@code maskIdeal}, {@link VImage#maskIdealRing},
   * {@link VImage#maskIdealBand}, {@link VImage#maskButterworth},
   * {@link VImage#maskButterworthRing}, {@link VImage#maskButterworthBand},
   * {@link VImage#maskGaussian}, {@link VImage#maskGaussianRing},
   * {@link VImage#maskGaussianBand}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param frequencyCutoff Frequency cutoff
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg nodc {@link VipsOption.Boolean} Remove DC component
   * @optionalArg reject {@link VipsOption.Boolean} Invert the sense of the filter
   * @optionalArg optical {@link VipsOption.Boolean} Rotate quadrants to optical space
   */
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

  /**
   * <p>Make an ideal band-pass or band-reject filter, that is, one with a
   * sharp cutoff around the point {@code frequencyCutoffX}, {@code frequencyCutoffY},
   * of size {@code radius}.</p>
   *
   * <p>See also: {@link VImage#maskIdeal}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Make an ideal ring-pass or ring-reject filter, that is, one with a sharp
   * ring positioned at {@code frequencyCutoff} of width {@code width}, where
   * {@code frequencyCutoff} and {@code width} are expressed as the range 0 - 1.</p>
   *
   * <p>See also: {@link VImage#maskIdeal}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Scale, rotate and translate {@code sec} so that the tie-points line up.</p>
   *
   * <p>If {@code search} is {@code TRUE}, before performing the transformation, the tie-points
   * are improved by searching an area of {@code sec} of size {@code harea} for a
   * match of size {@code hwindow} to {@code ref}.</p>
   *
   * <p>This function will only work well for small rotates and scales.</p>
   * @param sec Secondary image
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

  /**
   * <p>Perform various functions in -lm, the maths library, on images.</p>
   *
   * <p>Angles are expressed in degrees. The output type is float unless the
   * input is double, in which case the output is double.</p>
   *
   * <p>Non-complex images only.</p>
   *
   * <p>See also: {@link VImage#math2}.</p>
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
   * and writes the result to {@code out}. The images may have any
   * non-complex format. {@code out} is float except in the case that either of {@code left}
   * or {@code right} are double, in which case {@code out} is also double.</p>
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
   * {@code arithmetic}), and that format is the
   * result type.</p>
   *
   * <p>See also: {@link VImage#math2Const}.</p>
   * @param right Right-hand image argument
   * @param math2 {@link VipsOperationMath2} Math to perform
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>This operation calculates various 2-ary maths operations on an image and
   * an array of constants and writes the result to {@code out}.
   * The image may have any
   * non-complex format. {@code out} is float except in the case that {@code in}
   * is double, in which case {@code out} is also double.</p>
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
   * <p>See also: {@link VImage#math2}, {@link VImage#math}.</p>
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
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage matload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "matload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>This operation calculates the inverse of the matrix represented in {@code m}.
   * The scale and offset members of the input matrix are ignored.</p>
   *
   * <p>See also: {@link VImage#matrixload}.</p>
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
   * tabs and quotation marks (&quot;). The scale and offset fields may be
   * floating-point, and must use '.'
   * as a decimal separator.</p>
   *
   * <p>Subsequent lines each hold one row of matrix data, with numbers again
   * separated by any mixture of spaces, commas,
   * tabs and quotation marks (&quot;). The numbers may be floating-point, and must
   * use '.'
   * as a decimal separator.</p>
   *
   * <p>Extra characters at the ends of lines or at the end of the file are
   * ignored.</p>
   *
   * <p>See also: {@code matrixload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Exactly as {@link VImage#matrixload}, but read from a source.</p>
   *
   * <p>See also: {@link VImage#matrixload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Print {@code in} to {@code stdout} in matrix format. See {@link VImage#matrixload} for a
   * description of the format.</p>
   *
   * <p>See also: {@link VImage#matrixload}.</p>
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
   * <p>Write {@code in} to {@code filename} in matrix format. See {@link VImage#matrixload} for a
   * description of the format.</p>
   *
   * <p>See also: {@link VImage#matrixload}.</p>
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
   * <p>As {@link VImage#matrixsave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#matrixsave}.</p>
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
   * <p>By default it finds the single largest value. If {@code size} is set &gt;1, it will
   * find the {@code size} largest values. It will stop searching early if has found
   * enough values.
   * Equal values will be sorted by y then x.</p>
   *
   * <p>It operates on all
   * bands of the input image: use {@link VImage#stats} if you need to find an
   * maximum for each band.</p>
   *
   * <p>For complex images, this operation finds the maximum modulus.</p>
   *
   * <p>You can read out the position of the maximum with {@code x} and {@code y}. You can read
   * out arrays of the values and positions of the top {@code size} maxima with
   * {@code out-array}, {@code x-array} and {@code y-array}. These values are returned sorted from
   * largest to smallest.</p>
   *
   * <p>If there are more than {@code size} maxima, the maxima returned will be a random
   * selection of the maxima in the image.</p>
   *
   * <p>See also: {@link VImage#min}, {@link VImage#stats}.</p>
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
   * <p>For each pixel, pick the maximum of a pair of images.</p>
   *
   * <p>See also: {@link VImage#minpair}.</p>
   * @param right Right-hand image argument
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Analyse a grid of colour patches, producing an array of patch averages.
   * The mask has a row for each measured patch and a column for each image
   * band. The operations issues a warning if any patch has a deviation more
   * than 20% of
   * the mean. Only the central 50% of each patch is averaged.</p>
   *
   * <p>If the chart does not fill the whole image, use the optional {@code left}, {@code top},
   * {@code width}, {@code height} arguments to indicate the
   * position of the chart.</p>
   *
   * <p>See also: {@link VImage#avg}, {@link VImage#deviate}.</p>
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
   * <p>This operation joins two images left-right (with {@code ref} on the left) or
   * up-down (with {@code ref} above) with a smooth seam.</p>
   *
   * <p>If the number of bands differs, one of the images
   * must have one band. In this case, an n-band image is formed from the
   * one-band image by joining n copies of the one-band image together, and then
   * the two n-band images are operated upon.</p>
   *
   * <p>The two input images are cast up to the smallest common type (see table
   * Smallest common format in
   * {@code arithmetic}).</p>
   *
   * <p>{@code dx} and {@code dy} give the displacement of {@code sec} relative to {@code ref}, in other words,
   * the vector to get from the origin of {@code sec} to the origin of {@code ref}, in other
   * words, {@code dx} will generally be a negative number.</p>
   *
   * <p>{@code mblend} limits  the  maximum width of the
   * blend area.  A value of &quot;-1&quot; means &quot;unlimited&quot;. The two images are blended
   * with a raised cosine.</p>
   *
   * <p>Pixels with all bands equal to zero are &quot;transparent&quot;, that
   * is, zero pixels in the overlap area do not  contribute  to  the  merge.
   * This makes it possible to join non-rectangular images.</p>
   *
   * <p>See also: {@link VImage#mosaic}, {@link VImage#insert}.</p>
   * @param sec Secondary image
   * @param direction {@link VipsDirection} Horizontal or vertical merge
   * @param dx Horizontal displacement from sec to ref
   * @param dy Vertical displacement from sec to ref
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg mblend {@link VipsOption.Int} Maximum blend size
   */
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

  /**
   * <p>This operation finds the minimum value in an image.</p>
   *
   * <p>By default it finds the single smallest value. If {@code size} is set &gt;1, it will
   * find the {@code size} smallest values. It will stop searching early if has found
   * enough values.
   * Equal values will be sorted by y then x.</p>
   *
   * <p>It operates on all
   * bands of the input image: use {@link VImage#stats} if you need to find an
   * minimum for each band.</p>
   *
   * <p>For complex images, this operation finds the minimum modulus.</p>
   *
   * <p>You can read out the position of the minimum with {@code x} and {@code y}. You can read
   * out arrays of the values and positions of the top {@code size} minima with
   * {@code out-array}, {@code x-array} and {@code y-array}.
   * These values are returned sorted from
   * smallest to largest.</p>
   *
   * <p>If there are more than {@code size} minima, the minima returned will be a random
   * selection of the minima in the image.</p>
   *
   * <p>See also: {@code min}, {@link VImage#stats}.</p>
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
   * <p>For each pixel, pick the minimum of a pair of images.</p>
   *
   * <p>See also: {@code minpair}.</p>
   * @param right Right-hand image argument
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Performs a morphological operation on {@code in} using {@code mask} as a
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
   * based on the book &quot;Fundamentals of Digital Image Processing&quot; by A. Jain,
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
   * <p>See the boolean operations {@code vips_andimage}, {@code vips_orimage} and
   * {@code vips_eorimage}
   * for analogues of the usual set difference and set union operations.</p>
   *
   * <p>Operations are performed using the processor's vector unit,
   * if possible. Disable this with `--vips-novector` or `VIPS_NOVECTOR` or
   * {@code vips_vector_set_enabled}</p>
   * @param mask Input matrix image
   * @param morph {@link VipsOperationMorphology} Morphological operation to perform
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>This operation joins two images left-right (with {@code ref} on the left) or
   * top-bottom (with {@code ref} above) given an approximate overlap.</p>
   *
   * <p>{@code sec} is positioned so that the pixel ({@code xsec}, {@code ysec}) in {@code sec} lies on top of
   * the pixel ({@code xref}, {@code yref}) in {@code ref}. The overlap area is divided into three
   * sections, 20 high-contrast points in band {@code bandno} of image {@code ref} are found
   * in each, and a window of pixels of size {@code hwindow} around each high-contrast
   * point is searched for in {@code sec} over an area of {@code harea}.</p>
   *
   * <p>A linear model is fitted to the 60 tie-points, points a long way from the
   * fit are discarded, and the model refitted until either too few points
   * remain or the model reaches good agreement.</p>
   *
   * <p>The detected displacement is used with {@link VImage#merge} to join the two images
   * together.</p>
   *
   * <p>You can read out the detected transform with {@code dx0}, {@code dy0}, {@code scale1}, {@code angle1},
   * {@code dx1}, {@code dy1}.</p>
   *
   * <p>See also: {@link VImage#merge}, {@link VImage#insert}.</p>
   * @param sec Secondary image
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

  /**
   * <p>This operation joins two images top-bottom (with {@code sec} on the right)
   * or left-right (with {@code sec} at the bottom)
   * given an approximate pair of tie-points. {@code sec} is scaled and rotated as
   * necessary before the join.</p>
   *
   * <p>If {@code search} is {@code TRUE}, before performing the transformation, the tie-points
   * are improved by searching an area of {@code sec} of size {@code harea} for a
   * object of size {@code hwindow} in {@code ref}.</p>
   *
   * <p>{@code mblend} limits  the  maximum size of the
   * blend area.  A value of &quot;-1&quot; means &quot;unlimited&quot;. The two images are blended
   * with a raised cosine.</p>
   *
   * <p>Pixels with all bands equal to zero are &quot;transparent&quot;, that
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
   * {@code arithmetic}).</p>
   *
   * <p>See also: {@link VImage#merge}, {@link VImage#insert}, {@link VImage#globalbalance}.</p>
   * @param sec Secondary image
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

  /**
   * <p>Turn any integer image to 8-bit unsigned char by discarding all but the most
   * significant byte. Signed values are converted to unsigned by adding 128.</p>
   *
   * <p>Use {@code band} to make a one-band 8-bit image.</p>
   *
   * <p>This operator also works for LABQ coding.</p>
   *
   * <p>See also: {@link VImage#scale}, {@link VImage#cast}.</p>
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
   * <p>This operation calculates {@code left} * {@code right} and writes the result to {@code out}.</p>
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
   * {@code arithmetic}), then the
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
   * <p>See also: {@link VImage#add}, {@link VImage#linear}.</p>
   * @param right Right-hand image argument
   * @param args Array of VipsOption to apply to this operation
   */
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
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Read a virtual slide supported by the OpenSlide library into a VIPS image.
   * OpenSlide supports images in Aperio, Hamamatsu, MIRAX, Sakura, Trestle,
   * and Ventana formats.</p>
   *
   * <p>To facilitate zooming, virtual slide formats include multiple scaled-down
   * versions of the high-resolution image.  These are typically called
   * &quot;levels&quot;.  By default, {@code openslideload} reads the highest-resolution
   * level (level 0).  Set {@code level} to the level number you want.</p>
   *
   * <p>In addition to the slide image itself, virtual slide formats sometimes
   * include additional images, such as a scan of the slide's barcode.
   * OpenSlide calls these &quot;associated images&quot;.  To read an associated image,
   * set {@code associated} to the image's name.
   * A slide's associated images are listed in the
   * &quot;slide-associated-images&quot; metadata item.</p>
   *
   * <p>If you set {@code attach-associated}, then all associated images are attached as
   * metadata items. Use {@code vips_image_get_image} on {@code out} to retrieve them. Images
   * are attached as &quot;openslide-associated-XXXXX&quot;, where XXXXX is the name of the
   * associated image.</p>
   *
   * <p>By default, the output of this operator is RGBA. Set {@code rgb} to enable RGB
   * output.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Exactly as {@link VImage#openslideload}, but read from a source.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * Save image in pbm format
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
  @Deprecated(
      forRemoval = true
  )
  public void pbmsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "pbmsave_target", callArgs);
  }

  /**
   * <p>Render a PDF file into a VIPS image.</p>
   *
   * <p>The output image is always RGBA --- CMYK PDFs will be
   * converted. If you need CMYK bitmaps, you should use {@link VImage#magickload}
   * instead.</p>
   *
   * <p>Use {@code page} to select a page to render, numbering from zero.</p>
   *
   * <p>Use {@code n} to select the number of pages to render. The default is 1. Pages are
   * rendered in a vertical column, with each individual page aligned to the
   * left. Set to -1 to mean &quot;until the end of the document&quot;. Use {@link VImage#grid}
   * to change page layout.</p>
   *
   * <p>Use {@code dpi} to set the rendering resolution. The default is 72. Additionally,
   * you can scale by setting {@code scale}. If you set both, they combine.</p>
   *
   * <p>Use {@code background} to set the background RGBA colour. The default is 255
   * (solid white), use eg. 0 for a transparent background.</p>
   *
   * <p>Use {@code password} to supply a decryption password.</p>
   *
   * <p>The operation fills a number of header fields with metadata, for example
   * &quot;pdf-author&quot;. They may be useful.</p>
   *
   * <p>This function only reads the image header and does not render any pixel
   * data. Rendering occurs when pixels are accessed.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}, {@link VImage#magickload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage pdfload(Arena arena, String filename, VipsOption... args) throws VipsError {
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
   * {@link VImage#pdfload}, but read from memory.</p>
   *
   * <p>You must not free the buffer while {@code out} is active. The
   * {@code VipsObject}::postclose signal on {@code out} is a good place to free.</p>
   *
   * <p>See also: {@link VImage#pdfload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Exactly as {@link VImage#pdfload}, but read from a source.</p>
   *
   * <p>See also: {@link VImage#pdfload}</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>{@code percent} returns (through the {@code threshold} parameter) the threshold
   * below which there are {@code percent} values of {@code in}. For example:</p>
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
   * <p>See also: {@link VImage#histFind}, {@link VImage#profile}.</p>
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
   * <p>Use {@code cell-size} to set the size of the cells from which the image is
   * constructed. The default is 256 x 256.</p>
   *
   * <p>If {@code width} and {@code height} are multiples of {@code cell-size}, the image will tessellate.</p>
   *
   * <p>Normally, output pixels are {@link VipsBandFormat#FORMAT_FLOAT} in the range [-1, +1]. Set
   * {@code uchar} to output a uchar image with pixels in [0, 255].</p>
   *
   * <p>See also: {@link VImage#worley}, {@link VImage#fractsurf}, {@link VImage#gaussnoise}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg cell-size {@link VipsOption.Int} Size of Perlin cells
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg seed {@link VipsOption.Int} Random number seed
   */
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

  /**
   * Save image in pfm format
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
  @Deprecated(
      forRemoval = true
  )
  public void pfmsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "pfmsave_target", callArgs);
  }

  /**
   * Save image in pgm format
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
  @Deprecated(
      forRemoval = true
  )
  public void pgmsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "pgmsave_target", callArgs);
  }

  /**
   * <p>Convert the two input images to Fourier space, calculate phase-correlation,
   * back to real space.</p>
   *
   * <p>See also: {@link VImage#fwfft}, {@code vips_cross_phase},</p>
   * @param in2 Second input image
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Read a PNG file into a VIPS image. It can read all png images, including 8-
   * and 16-bit images, 1 and 3 channel, with and without an alpha channel.</p>
   *
   * <p>Any ICC profile is read and attached to the VIPS image. It also supports
   * XMP metadata.</p>
   *
   * <p>Use {@code fail-on} to set the type of error that will cause load to fail. By
   * default, loaders are permissive, that is, {@link app.photofox.vipsffm.enums.VipsFailOn#FAIL_ON_NONE}.</p>
   *
   * <p>By default, the PNG loader limits the number of text and data chunks to
   * block some denial of service attacks. Set {@code unlimited} to disable these
   * limits.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage pngload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "pngload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link VImage#pngload}, but read from a PNG-formatted memory block.</p>
   *
   * <p>You must not free the buffer while {@code out} is active. The
   * {@code VipsObject}::postclose signal on {@code out} is a good place to free.</p>
   *
   * <p>See also: {@link VImage#pngload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Exactly as {@link VImage#pngload}, but read from a source.</p>
   *
   * <p>See also: {@link VImage#pngload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Write a VIPS image to a file as PNG.</p>
   *
   * <p>{@code compression} means compress with this much effort (0 - 9). Default 6.</p>
   *
   * <p>Set {@code interlace} to {@code TRUE} to interlace the image with ADAM7
   * interlacing. Beware
   * than an interlaced PNG can be up to 7 times slower to write than a
   * non-interlaced image.</p>
   *
   * <p>Use {@code filter} to specify one or more filters, defaults to none,
   * see {@code VipsForeignPngFilter}.</p>
   *
   * <p>The image is automatically converted to RGB, RGBA, Monochrome or Mono +
   * alpha before saving. Images with more than one byte per band element are
   * saved as 16-bit PNG, others are saved as 8-bit PNG.</p>
   *
   * <p>Set {@code palette} to {@code TRUE} to enable palette mode for RGB or RGBA images. A
   * palette will be computed with enough space for {@code bitdepth} (1, 2, 4 or 8)
   * bits. Use {@code Q} to set the optimisation effort, {@code dither} to set the degree of
   * Floyd-Steinberg dithering and {@code effort} to control the CPU effort
   * (1 is the fastest, 10 is the slowest, 7 is the default).
   * This feature requires libvips to be compiled with libimagequant.</p>
   *
   * <p>The default {@code bitdepth} is either 8 or 16 depending on the interpretation.
   * You can also set {@code bitdepth} for mono and mono + alpha images, and the image
   * will be quantized.</p>
   *
   * <p>XMP metadata is written to the XMP chunk. PNG comments are written to
   * separate text chunks.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
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
   * <p>As {@link VImage#pngsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in {@code buf}, the length of the buffer in
   * {@code len}. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link VImage#pngsave}, {@code vips_image_write_to_file}.</p>
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
   * <p>As {@link VImage#pngsave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#pngsave}, {@code vips_image_write_to_target}.</p>
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
   * Save image in pnm format
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
  @Deprecated(
      forRemoval = true
  )
  public void pnmsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "pnmsave_target", callArgs);
  }

  /**
   * <p>Read a PPM/PBM/PGM/PFM file into a VIPS image.</p>
   *
   * <p>It can read 1, 8, 16 and 32 bit images, colour or monochrome,
   * stored in binary or in ASCII. One bit images become 8 bit VIPS images,
   * with 0 and 255 for 0 and 1.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage ppmload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "ppmload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link VImage#ppmload}, but read from a source.</p>
   *
   * <p>See also: {@link VImage#ppmload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Write a VIPS image to a file as PPM. It can write 1, 8, 16 or
   * 32 bit unsigned integer images, float images, colour or monochrome,
   * stored as binary or ASCII.
   * Integer images of more than 8 bits can only be stored in ASCII.</p>
   *
   * <p>When writing float (PFM) images the scale factor is set from the
   * &quot;pfm-scale&quot; metadata.</p>
   *
   * <p>Set {@code ascii} to {@code TRUE} to write as human-readable ASCII. Normally data is
   * written in binary.</p>
   *
   * <p>Set {@code bitdepth} to 1 to write a one-bit image.</p>
   *
   * <p>{@code format} defaults to the sub-type for this filename suffix.</p>
   *
   * <p>See also: {@code vips_image_write_to_file}.</p>
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
   * <p>As {@link VImage#ppmsave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#ppmsave}.</p>
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
   *   alpha = clip(0, in[in.bands - 1], {@code max-alpha});
   *   norm = alpha / {@code max-alpha};
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
   * <p>{@code max-alpha} has the default value 255, or 65535 for images tagged as
   * {@link VipsInterpretation#INTERPRETATION_RGB16} or
   * {@link VipsInterpretation#INTERPRETATION_GREY16}.</p>
   *
   * <p>Non-complex images only.</p>
   *
   * <p>See also: {@link VImage#unpremultiply}, {@link VImage#flatten}.</p>
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
   * <p>See also: {@link VImage#canny}, {@link VImage#sobel}, {@code prewitt}, {@link VImage#scharr}.</p>
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
   * <p>{@code profile} searches inward from the edge of {@code in} and finds the
   * first non-zero pixel. Pixels in {@code columns} have the distance from the top edge
   * to the first non-zero pixel in that column, {@code rows} has the distance from the
   * left edge to the first non-zero pixel in that row.</p>
   *
   * <p>See also: {@link VImage#project}, {@link VImage#histFind}.</p>
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
   * <p>See also: {@link VImage#histFind}, {@link VImage#profile}.</p>
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
   * <p>See also: {@link VImage#affine}.</p>
   * @param coeff Coefficient matrix
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg interpolate {@link VipsOption.Interpolate} Interpolate values with this
   */
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

  /**
   * <p>Unpack a RAD ({@link app.photofox.vipsffm.enums.VipsCoding#CODING_RAD}) image to a three-band float image.</p>
   *
   * <p>See also: {@link VImage#float2rad}, {@link VImage#LabQ2LabS}.</p>
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
   * {@link VImage#extractArea}) can work directly with images in this format, but
   * mmany (all the arithmetic operations, for example) will not. Unpack
   * {@link app.photofox.vipsffm.enums.VipsCoding#CODING_RAD} images to 3 band float with {@link VImage#rad2float} if
   * you want to do arithmetic on them.</p>
   *
   * <p>This operation ignores some header fields, like VIEW and DATE. It will not
   * rotate/flip as the FORMAT string asks.</p>
   *
   * <p>Sections of this reader from Greg Ward and Radiance with kind permission.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage radload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "radload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link VImage#radload}, but read from a HDR-formatted memory block.</p>
   *
   * <p>You must not free the buffer while {@code out} is active. The
   * {@code VipsObject}::postclose signal on {@code out} is a good place to free.</p>
   *
   * <p>See also: {@link VImage#radload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Exactly as {@link VImage#radload}, but read from a source.</p>
   *
   * <p>See also: {@link VImage#radload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Write a VIPS image in Radiance (HDR) format.</p>
   *
   * <p>Sections of this reader from Greg Ward and Radiance with kind permission.</p>
   *
   * <p>See also: {@code vips_image_write_to_file}.</p>
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
   * <p>As {@link VImage#radsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in {@code buf}, the length of the buffer in
   * {@code len}. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link VImage#radsave}, {@code vips_image_write_to_file}.</p>
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
   * <p>As {@link VImage#radsave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#radsave}.</p>
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
   * <p>{@code rank} does rank filtering on an image. A window of size {@code width} by
   * {@code height} is passed over the image. At each position, the pixels inside the
   * window are sorted into ascending order and the pixel at position {@code index} is
   * output. {@code index} numbers from 0.</p>
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
   * <p>See also: {@link VImage#conv}, {@code vips_median}, {@link VImage#spcor}.</p>
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
   * <p>This operation mmaps the file, setting up {@code out} so that access to that
   * image will read from the file.</p>
   *
   * <p>By default, it assumes uchar pixels. Use {@code format} to select something else.</p>
   *
   * <p>The image will be tagged as {@link VipsInterpretation#INTERPRETATION_MULTIBAND}. Use
   * {@code interpretation} to select something else.</p>
   *
   * <p>Use {@link VImage#byteswap} to reverse the byte ordering if necessary.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}, {@link VImage#copy}, {@link VImage#byteswap}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Writes the pixels in {@code in} to the file {@code filename} with no header or other
   * metadata.</p>
   *
   * <p>See also: {@code vips_image_write_to_file}.</p>
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
   * <p>As {@link VImage#rawsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in {@code buf}, the length of the buffer in
   * {@code len}. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link VImage#rawsave}, {@code vips_image_write_to_memory}, {@code vips_image_write_to_file}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public VBlob rawsaveBuffer(VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var bufferOption = VipsOption.Blob("buffer");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(bufferOption);
    VipsInvoker.invokeOperation(arena, "rawsave_buffer", callArgs);
    return bufferOption.valueOrThrow();
  }

  /**
   * <p>As {@link VImage#rawsave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#rawsave}.</p>
   * @param target Target to save to
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg keep {@link VipsOption.Int} Which metadata to retain
   * @optionalArg background {@link VipsOption.ArrayDouble} Background value
   * @optionalArg page-height {@link VipsOption.Int} Set page height for multipage save
   * @optionalArg profile {@link VipsOption.String} Filename of ICC profile to embed
   * @optionalArg strip {@link VipsOption.Boolean} Strip all metadata from image
   */
  public void rawsaveTarget(VTarget target, VipsOption... args) throws VipsError {
    var inOption = VipsOption.Image("in", this);
    var targetOption = VipsOption.Target("target", target);
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(inOption);
    callArgs.add(targetOption);
    VipsInvoker.invokeOperation(arena, "rawsave_target", callArgs);
  }

  /**
   * <p>This operation recombines an image's bands. Each pixel in {@code in} is treated as
   * an n-element vector, where n is the number of bands in {@code in}, and multiplied by
   * the n x m matrix {@code m} to produce the m-band image {@code out}.</p>
   *
   * <p>{@code out} is always float, unless {@code in} is double, in which case {@code out} is double
   * too. No complex images allowed.</p>
   *
   * <p>It's useful for various sorts of colour space conversions.</p>
   *
   * <p>See also: {@link VImage#bandmean}.</p>
   * @param m Matrix of coefficients
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Reduce {@code in} by a pair of factors with a pair of 1D kernels. This
   * will not work well for shrink factors greater than three.</p>
   *
   * <p>Set {@code gap} to speed up reducing by having {@link VImage#shrink} to shrink
   * with a box filter first. The bigger {@code gap}, the closer the result
   * to the fair resampling. The smaller {@code gap}, the faster resizing.
   * The default value is 0.0 (no optimization).</p>
   *
   * <p>This is a very low-level operation: see {@link VImage#resize} for a more
   * convenient way to resize images.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link VImage#shrink}, {@link VImage#resize}, {@link VImage#affine}.</p>
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
   * <p>Reduce {@code in} horizontally by a float factor. The pixels in {@code out} are
   * interpolated with a 1D mask generated by {@code kernel}.</p>
   *
   * <p>Set {@code gap} to speed up reducing by having {@link VImage#shrinkh} to shrink
   * with a box filter first. The bigger {@code gap}, the closer the result
   * to the fair resampling. The smaller {@code gap}, the faster resizing.
   * The default value is 0.0 (no optimization).</p>
   *
   * <p>This is a very low-level operation: see {@link VImage#resize} for a more
   * convenient way to resize images.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link VImage#shrink}, {@link VImage#resize}, {@link VImage#affine}.</p>
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
   * <p>Reduce {@code in} vertically by a float factor. The pixels in {@code out} are
   * interpolated with a 1D mask generated by {@code kernel}.</p>
   *
   * <p>Set {@code gap} to speed up reducing by having {@link VImage#shrinkv} to shrink
   * with a box filter first. The bigger {@code gap}, the closer the result
   * to the fair resampling. The smaller {@code gap}, the faster resizing.
   * The default value is 0.0 (no optimization).</p>
   *
   * <p>This is a very low-level operation: see {@link VImage#resize} for a more
   * convenient way to resize images.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link VImage#shrink}, {@link VImage#resize}, {@link VImage#affine}.</p>
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
   * {@code arithmetic}).</p>
   *
   * <p>To decide if pixels match exactly, that is have the same value in every
   * band, use {@link VImage#bandbool} after this operation to AND or OR image bands
   * together.</p>
   *
   * <p>See also: {@link VImage#boolean1}, {@link VImage#bandbool}, {@link VImage#relationalConst}.</p>
   * @param right Right-hand image argument
   * @param relational {@link VipsOperationRelational} Relational to perform
   * @param args Array of VipsOption to apply to this operation
   */
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
   * <p>See also: {@link VImage#boolean1}, {@link VImage#relational}.</p>
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
   * <p>This operation calculates {@code left} % {@code right} (remainder after integer division)
   * and writes the result to {@code out}. The images may have any
   * non-complex format. For float formats, {@code remainder} calculates {@code in1} -
   * {@code in2} * floor ({@code in1} / {@code in2}).</p>
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
   * {@code arithmetic}), and that format is the
   * result type.</p>
   *
   * <p>See also: {@link VImage#remainderConst}, {@link VImage#divide}, {@link VImage#round}.</p>
   * @param right Right-hand image argument
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>This operation calculates {@code in} % {@code c} (remainder after division by an
   * array of constants)
   * and writes the result to {@code out}.
   * The image may have any
   * non-complex format. For float formats, {@code remainderConst} calculates
   * {@code in} - {@code c} * floor ({@code in} / {@code c}).</p>
   *
   * <p>If the array of constants has just one element, that constant is used for
   * all image bands. If the array has more than one element and they have
   * the same number of elements as there are bands in the image, then
   * one array element is used for each band. If the arrays have more than one
   * element and the image only has a single band, the result is a many-band
   * image where each band corresponds to one array element.</p>
   *
   * <p>See also: {@link VImage#remainder}, {@link VImage#divide}, {@link VImage#round}.</p>
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
   * <p>See also: {@link VImage#extractArea}.</p>
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
   * <p>Set {@code gap} to speed up downsizing by having {@link VImage#shrink} to shrink
   * with a box filter first. The bigger {@code gap}, the closer the result
   * to the fair resampling. The smaller {@code gap}, the faster resizing.
   * The default value is 2.0 (very close to fair resampling
   * while still being faster in many cases).</p>
   *
   * <p>{@code resize} normally uses {@link app.photofox.vipsffm.enums.VipsKernel#KERNEL_LANCZOS3} for the final reduce, you
   * can change this with {@code kernel}. Downsizing is done with centre convention.</p>
   *
   * <p>When upsizing ({@code scale} &gt; 1), the operation uses {@link VImage#affine} with
   * a {@code VipsInterpolate} selected depending on {@code kernel}. It will use
   * {@code VipsInterpolateBicubic} for {@link app.photofox.vipsffm.enums.VipsKernel#KERNEL_CUBIC} and above. It adds a
   * 0.5 pixel displacement to the input pixels to get centre convention scaling.</p>
   *
   * <p>{@code resize} normally maintains the image aspect ratio. If you set
   * {@code vscale}, that factor is used for the vertical scale and {@code scale} for the
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
   * channel, you should use {@link VImage#premultiply} on it first.</p>
   *
   * <p>See also: {@link VImage#premultiply}, {@link VImage#shrink}, {@link VImage#reduce}.</p>
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
   * <p>Rotate {@code in} by a multiple of 90 degrees.</p>
   *
   * <p>Use {@link VImage#similarity} to rotate by an arbitrary angle. {@link VImage#rot45} is
   * useful for rotating convolution masks by 45 degrees.</p>
   *
   * <p>See also: {@link VImage#flip}, {@link VImage#similarity}, {@link VImage#rot45}.</p>
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
   * <p>Rotate {@code in} by a multiple of 45 degrees. Odd-length sides and square images
   * only.</p>
   *
   * <p>This operation is useful for rotating convolution masks. Use
   * {@link VImage#similarity} to rotate images by arbitrary angles.</p>
   *
   * <p>See also: {@link VImage#rot}, {@link VImage#similarity}.</p>
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
   * <p>This operator calls {@link VImage#affine} for you, calculating the matrix for the
   * affine transform from {@code scale} and {@code angle}. Other parameters are passed on to
   * {@link VImage#affine} unaltered.</p>
   *
   * <p>See also: {@link VImage#affine}, {@code VipsInterpolate}.</p>
   * @param angle Rotate clockwise by this many degrees
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
   * <p>The format of {@code out} is always the same as {@code in}, so you may wish to cast to an
   * integer format afterwards.</p>
   *
   * <p>See also: {@link VImage#cast}</p>
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
   * compatibility with other image processing systems. See {@link VImage#Lab2LCh} for a
   * much better colour space.</p>
   *
   * <p>See also: {@link VImage#HSV2sRGB}, {@link VImage#Lab2LCh}.</p>
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
   * <p>See also: {@link VImage#scRGB2XYZ}, {@link VImage#scRGB2sRGB}, {@link VImage#rad2float}.</p>
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
   * <p>Convert an scRGB image to greyscale. Set {@code depth} to 16 to get 16-bit output.</p>
   *
   * <p>If {@code depth} is 16, any extra channels after RGB are
   * multiplied by 256.</p>
   *
   * <p>See also: {@link VImage#LabS2LabQ}, {@link VImage#sRGB2scRGB}, {@link VImage#rad2float}.</p>
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
   * <p>Convert an scRGB image to sRGB. Set {@code depth} to 16 to get 16-bit output.</p>
   *
   * <p>If {@code depth} is 16, any extra channels after RGB are
   * multiplied by 256.</p>
   *
   * <p>See also: {@link VImage#LabS2LabQ}, {@link VImage#sRGB2scRGB}, {@link VImage#rad2float}.</p>
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
   * <p>If {@code log} is set, transform with log10(1.0 + pow(x, {@code exp})) + .5,
   * then scale so max == 255. By default, {@code exp} is 0.25.</p>
   *
   * <p>See also: {@link VImage#cast}.</p>
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
   * <p>See also: {@link VImage#canny}, {@link VImage#sobel}, {@link VImage#prewitt}, {@code scharr}.</p>
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
   * <p>Create a signed distance field (SDF) image of the given shape. Different
   * shapes use different combinations of the optional arguments, see below.</p>
   *
   * <p>{@code shape} {@link VipsSdfShape#SDF_SHAPE_CIRCLE}: create a circle centred on {@code a}, radius {@code r}.</p>
   *
   * <p>{@code shape} {@link VipsSdfShape#SDF_SHAPE_BOX}: create a box with top-left corner {@code a} and
   * bottom-right corner {@code b}.</p>
   *
   * <p>{@code shape} {@link VipsSdfShape#SDF_SHAPE_ROUNDED_BOX}: create a box with top-left corner {@code a}
   * and bottom-right corner {@code b}, whose four corners are
   * rounded by the four-element float array {@code corners}. {@code corners} will default to
   * 0.0.</p>
   *
   * <p>{@code shape} {@link VipsSdfShape#SDF_SHAPE_LINE}: draw a line from {@code a} to {@code b}.</p>
   *
   * <p>See also: {@link VImage#grey}, {@link VImage#grid}, {@link VImage#xyz}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param shape {@link VipsSdfShape} SDF shape to create
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg r {@link VipsOption.Double} Radius
   * @optionalArg a {@link VipsOption.ArrayDouble} Point a
   * @optionalArg b {@link VipsOption.ArrayDouble} Point b
   * @optionalArg corners {@link VipsOption.ArrayDouble} Corner radii
   */
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

  /**
   * <p>This operation behaves rather like {@link VImage#copy} between images
   * {@code in} and {@code out}, except that it checks that pixels on {@code in} are only requested
   * top-to-bottom. This operation is useful for loading file formats which are
   * strictly top-to-bottom, like PNG.</p>
   *
   * <p>{@code tile-height} can be used to set the size of the tiles that
   * {@code sequential} uses. The default value is 1.</p>
   *
   * <p>See also: {@code vips_cache}, {@link VImage#linecache}, {@link VImage#tilecache}.</p>
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
   * <p>The operation performs a gaussian blur and subtracts from {@code in} to generate a
   * high-frequency signal. This signal is passed through a lookup table formed
   * from the five parameters and added back to {@code in}.</p>
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
   * <p>The {@code sigma} parameter changes the width of the fringe and can be
   * adjusted according to the output printing resolution. As an approximate
   * guideline, use 0.5 for 4 pixels/mm (display resolution),
   * 1.0 for 12 pixels/mm and 1.5 for 16 pixels/mm (300 dpi == 12
   * pixels/mm). These figures refer to the image raster, not the half-tone
   * resolution.</p>
   *
   * <p>See also: {@link VImage#conv}.</p>
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
   * <p>Shrink {@code in} by a pair of factors with a simple box filter. For non-integer
   * factors, {@code shrink} will first shrink by the integer part with a box
   * filter, then use {@link VImage#reduce} to shrink by the
   * remaining fractional part.</p>
   *
   * <p>This is a very low-level operation: see {@link VImage#resize} for a more
   * convenient way to resize images.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link VImage#resize}, {@link VImage#reduce}.</p>
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
   * <p>Shrink {@code in} horizontally by an integer factor. Each pixel in the output is
   * the average of the corresponding line of {@code hshrink} pixels in the input.</p>
   *
   * <p>This is a very low-level operation: see {@link VImage#resize} for a more
   * convenient way to resize images.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link VImage#shrinkv}, {@link VImage#shrink}, {@link VImage#resize}, {@link VImage#affine}.</p>
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
   * <p>Shrink {@code in} vertically by an integer factor. Each pixel in the output is
   * the average of the corresponding column of {@code vshrink} pixels in the input.</p>
   *
   * <p>This is a very low-level operation: see {@link VImage#resize} for a more
   * convenient way to resize images.</p>
   *
   * <p>This operation does not change xres or yres. The image resolution needs to
   * be updated by the application.</p>
   *
   * <p>See also: {@link VImage#shrinkh}, {@link VImage#shrink}, {@link VImage#resize}, {@link VImage#affine}.</p>
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
   * <p>See also: {@link VImage#abs}.</p>
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
   * <p>This operator calls {@link VImage#affine} for you, calculating the matrix for the
   * affine transform from {@code scale} and {@code angle}. Other parameters are passed on to
   * {@link VImage#affine} unaltered.</p>
   *
   * <p>See also: {@link VImage#affine}, {@code VipsInterpolate}.</p>
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg scale {@link VipsOption.Double} Scale by this factor
   * @optionalArg angle {@link VipsOption.Double} Rotate clockwise by this many degrees
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
   * determined by the variables {@code hfreq} and {@code vfreq} respectively.  The
   * function is useful for creating displayable sine waves and
   * square waves in two dimensions.</p>
   *
   * <p>If horfreq and verfreq are integers the resultant image is periodical
   * and therefore the Fourier transform does not present spikes</p>
   *
   * <p>Pixels are normally in [-1, +1], set {@code uchar} to output [0, 255].</p>
   *
   * <p>See also: {@link VImage#grey}, {@link VImage#xyz}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   * @optionalArg hfreq {@link VipsOption.Double} Horizontal spatial frequency
   * @optionalArg vfreq {@link VipsOption.Double} Vertical spatial frequency
   */
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

  /**
   * <p>Crop an image down to a specified width and height by removing boring parts.</p>
   *
   * <p>Use {@code interesting} to pick the method vips uses to decide which bits of the
   * image should be kept.</p>
   *
   * <p>You can test xoffset / yoffset on {@code out} to find the location of the crop
   * within the input image.</p>
   *
   * <p>See also: {@link VImage#extractArea}.</p>
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
   * <p>See also: {@link VImage#canny}, {@code sobel}, {@link VImage#prewitt}, {@link VImage#scharr}.</p>
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
   * <p>{@code ref} is placed at every position in {@code in} and the correlation coefficient
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
   * <p>where inkl is the area of {@code in} centred at position (k,l).</p>
   *
   * <p>from Niblack &quot;An Introduction to Digital Image Processing&quot;,
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
   * <p>See also: {@link VImage#fastcor}.</p>
   * @param ref Input reference image
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Make a displayable (ie. 8-bit unsigned int) power spectrum.</p>
   *
   * <p>If {@code in} is non-complex, it is transformed to Fourier space. Then the
   * absolute value is passed through {@link VImage#scale} in log mode, and {@link VImage#wrap}.</p>
   *
   * <p>See also: {@link VImage#fwfft}, {@link VImage#scale}, {@link VImage#wrap}.</p>
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
   * <p>Find many image statistics in a single pass through the data. {@code out} is a
   * one-band {@link VipsBandFormat#FORMAT_DOUBLE} image of at least 10 columns by n + 1
   * (where n is number of bands in image {@code in})
   * rows. Columns are statistics, and are, in order: minimum, maximum, sum,
   * sum of squares, mean, standard deviation, x coordinate of minimum, y
   * coordinate of minimum, x coordinate of maximum, y coordinate of maximum.
   * Later versions of {@code stats} may add more columns.</p>
   *
   * <p>Row 0 has statistics for all
   * bands together, row 1 has stats for band 1, and so on.</p>
   *
   * <p>If there is more than one maxima or minima, one of them will be chosen at
   * random.</p>
   *
   * <p>See also: {@link VImage#avg}, {@link VImage#min}.</p>
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
   * <p>{@code stdif} performs statistical differencing according to the formula
   * given in page 45 of the book &quot;An Introduction to Digital Image
   * Processing&quot; by Wayne Niblack. This transformation emphasises the way in
   * which a pel differs statistically from its neighbours. It is useful for
   * enhancing low-contrast images with lots of detail, such as X-ray plates.</p>
   *
   * <p>At point (i,j) the output is given by the equation:</p>
   *
   * <pre>{@code 
   * vout(i,j) = {@code a} * {@code m0} + (1 - {@code a}) * meanv +
   *       (vin(i,j) - meanv) * ({@code b} * {@code s0}) / ({@code s0} + {@code b} * stdv)
   * }</pre>
   *
   * <p>Values {@code a}, {@code m0}, {@code b} and {@code s0} are entered, while meanv and stdv are the values
   * calculated over a moving window of size {@code width}, {@code height} centred on pixel
   * (i,j). {@code m0} is the new mean, {@code a} is the weight given to it. {@code s0} is the new
   * standard deviation, {@code b} is the weight given to it.</p>
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
   * <p>See also: {@link VImage#histLocal}.</p>
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
   * from {@code in} and then subsample that line. For large shrinks it will fetch
   * single pixels.</p>
   *
   * <p>If {@code point} is set, {@code in} will always be sampled in points. This can be faster
   * if the previous operations in the pipeline are very slow.</p>
   *
   * <p>See also: {@link VImage#affine}, {@link VImage#shrink}, {@link VImage#zoom}.</p>
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
   * <p>This operation calculates {@code in1} - {@code in2} and writes the result to {@code out}.</p>
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
   * {@code arithmetic}), then the
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
   * <p>See also: {@link VImage#add}, {@link VImage#linear}.</p>
   * @param right Right-hand image argument
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>This operation sums all images in {@code in} and writes the result to {@code out}.</p>
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
   * {@code arithmetic}), then the
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
   * <p>See also: {@link VImage#add}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param in Array of input images
   * @param args Array of VipsOption to apply to this operation
   */
  public static VImage sum(Arena arena, List<VImage> in, VipsOption... args) throws VipsError {
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
   * <p>Use {@code dpi} to set the rendering resolution. The default is 72. You can also
   * scale the rendering by {@code scale}.</p>
   *
   * <p>This function only reads the image header and does not render any pixel
   * data. Rendering occurs when pixels are accessed.</p>
   *
   * <p>SVGs larger than 10MB are normally blocked for security. Set {@code unlimited} to
   * allow SVGs of any size.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage svgload(Arena arena, String filename, VipsOption... args) throws VipsError {
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
   * {@link VImage#svgload}, but read from a memory buffer.</p>
   *
   * <p>You must not free the buffer while {@code out} is active. The
   * {@code VipsObject}::postclose signal on {@code out} is a good place to free.</p>
   *
   * <p>See also: {@link VImage#svgload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Exactly as {@link VImage#svgload}, but read from a source.</p>
   *
   * <p>See also: {@link VImage#svgload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>The {@code tests} images are evaluated and at each point the index of the first
   * non-zero value is written to {@code out}. If all {@code tests} are false, the value
   * ({@code n} + 1) is written.</p>
   *
   * <p>Images in {@code tests} must have one band. They are expanded to the
   * bounding box of the set of images in {@code tests}, and that size is used for
   * {@code out}. {@code tests} can have up to 255 elements.</p>
   *
   * <p>Combine with {@link VImage#case1} to make an efficient multi-way {@link VImage#ifthenelse}.</p>
   *
   * <p>See also: {@link VImage#maplut}, {@link VImage#case1}, {@link VImage#ifthenelse}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param tests Table of images to test
   * @param args Array of VipsOption to apply to this operation
   */
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

  /**
   * <p>Draw the string {@code text} to an image. {@code out} is normally a one-band 8-bit
   * unsigned char image, with 0 for no text and 255 for text. Values between
   * are used for anti-aliasing.</p>
   *
   * <p>Set {@code rgba} to enable RGBA output. This is useful for colour emoji rendering,
   * or support for pango markup features like `&lt;span
   * foreground=&quot;red&quot;&gt;Red!&lt;/span&gt;`.</p>
   *
   * <p>{@code text} is the text to render as a UTF-8 string. It can contain Pango markup,
   * for example `&lt;i&gt;The&lt;/i&gt;Guardian`.</p>
   *
   * <p>{@code font} is the font to render with, as a fontconfig name. Examples might be
   * `sans 12` or perhaps `bitstream charter bold 10`.</p>
   *
   * <p>You can specify a font to load with {@code fontfile}. You'll need to also set the
   * name of the font with {@code font}.</p>
   *
   * <p>{@code width} is the number of pixels to word-wrap at. By default, lines of text
   * wider than this will be broken at word boundaries.
   * Use {@code wrap} to set lines to wrap on word or character boundaries, or to
   * disable line breaks.</p>
   *
   * <p>Set {@code justify} to turn on line justification.
   * {@code align} can be used to set the alignment style for multi-line
   * text to the low (left) edge centre, or high (right) edge. Note that the
   * output image can be wider than {@code width} if there are no
   * word breaks, or narrower if the lines don't break exactly at {@code width}.</p>
   *
   * <p>{@code height} is the maximum number of pixels high the generated text can be. This
   * only takes effect when {@code dpi} is not set, and {@code width} is set, making a box.
   * In this case, {@code text} will search for a {@code dpi} and set of line breaks
   * which will just fit the text into {@code width} and {@code height}.</p>
   *
   * <p>You can use {@code autofit-dpi} to read out the DPI selected by auto fit.</p>
   *
   * <p>{@code dpi} sets the resolution to render at. &quot;sans 12&quot; at 72 dpi draws characters
   * approximately 12 pixels high.</p>
   *
   * <p>{@code spacing} sets the line spacing, in points. It would typically be something
   * like font size times 1.2.</p>
   *
   * <p>You can read the coordinate of the top edge of the character from `Xoffset`
   * / `Yoffset`. This can be helpful if you need to line up the output of
   * several {@code text}.</p>
   *
   * <p>See also: {@link VImage#bandjoin}, {@link VImage#composite}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage text(Arena arena, String text, VipsOption... args) throws VipsError {
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
   * <p>See {@link VImage#thumbnailBuffer} to thumbnail from a memory buffer, or
   * {@link VImage#thumbnailSource} to thumbnail from an arbitrary byte source.</p>
   *
   * <p>By default, libvips will only use the first frame of animated or multipage
   * images. To thumbnail all pages or frames, pass `n=-1` to the loader in
   * {@code filename}, for example `&quot;x.gif[n=-1]&quot;`.</p>
   *
   * <p>The output image will fit within a square of size {@code width} x {@code width}. You can
   * specify a separate height with the {@code height} option. Set either {@code width} or
   * {@code height} to a very large number to ignore that dimension.</p>
   *
   * <p>If you set {@code crop}, then the output image will fill the whole of the {@code width} x
   * {@code height} rectangle, with any excess cropped away. See {@link VImage#smartcrop} for
   * details on the cropping strategy.</p>
   *
   * <p>Normally the operation will upsize or downsize as required to fit the image
   * inside or outside the target size. If {@code size} is set
   * to {@link app.photofox.vipsffm.enums.VipsSize#SIZE_UP}, the operation will only upsize and will just
   * copy if asked to downsize.
   * If {@code size} is set
   * to {@link app.photofox.vipsffm.enums.VipsSize#SIZE_DOWN}, the operation will only downsize and will just
   * copy if asked to upsize.
   * If {@code size} is {@link app.photofox.vipsffm.enums.VipsSize#SIZE_FORCE}, the image aspect ratio will be broken and the
   * image will be forced to fit the target.</p>
   *
   * <p>Normally any orientation tags on the input image (such as EXIF tags) are
   * interpreted to rotate the image upright. If you set {@code no-rotate} to {@code TRUE},
   * these tags will not be interpreted.</p>
   *
   * <p>Shrinking is normally done in sRGB colourspace. Set {@code linear} to shrink in
   * linear light colourspace instead. This can give better results, but can
   * also be far slower, since tricks like JPEG shrink-on-load cannot be used in
   * linear space.</p>
   *
   * <p>If you set {@code export-profile} to the filename of an ICC profile, the image
   * will be transformed to the target colourspace before writing to the
   * output. You can also give an {@code import-profile} which will be used if the
   * input image has no ICC profile, or if the profile embedded in the
   * input image is broken.</p>
   *
   * <p>Use {@code intent} to set the rendering intent for any ICC transform. The default
   * is {@link app.photofox.vipsffm.enums.VipsIntent#INTENT_RELATIVE}.</p>
   *
   * <p>Use {@code fail-on} to control the types of error that will cause loading to fail.
   * The default is {@link app.photofox.vipsffm.enums.VipsFailOn#FAIL_ON_NONE}, ie. thumbnail is permissive.</p>
   *
   * <p>See also: {@link VImage#thumbnailBuffer}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Exactly as {@link VImage#thumbnail}, but read from a memory buffer. One extra
   * optional argument, {@code option-string}, lets you pass options to the underlying
   * loader.</p>
   *
   * <p>See also: {@link VImage#thumbnail}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Exactly as {@link VImage#thumbnail}, but read from an existing image.</p>
   *
   * <p>This operation
   * is not able to exploit shrink-on-load features of image load libraries, so
   * it can be much slower than `{@link VImage#thumbnail}` and produce poorer quality
   * output. Only use it if you really have to.</p>
   *
   * <p>See also: {@link VImage#thumbnail}.</p>
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
   * <p>Exactly as {@link VImage#thumbnail}, but read from a source. One extra
   * optional argument, {@code option-string}, lets you pass options to the underlying
   * loader.</p>
   *
   * <p>See also: {@link VImage#thumbnail}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Read a TIFF file into a VIPS image. It is a full baseline TIFF 6 reader,
   * with extensions for tiled images, multipage images, XYZ and LAB colour
   * space, pyramidal images and JPEG compression, including CMYK and YCbCr.</p>
   *
   * <p>{@code page} means load this page from the file. By default the first page (page
   * 0) is read.</p>
   *
   * <p>{@code n} means load this many pages. By default a single page is read. All the
   * pages must have the same dimensions, and they are loaded as a tall, thin
   * &quot;toilet roll&quot; image. The {@code VIPS_META_PAGE_HEIGHT} metadata
   * tag gives the height in pixels of each page. Use -1 to load all pages.</p>
   *
   * <p>Setting {@code autorotate} to {@code TRUE} will make the loader interpret the
   * orientation tag and automatically rotate the image appropriately during
   * load.</p>
   *
   * <p>If {@code autorotate} is {@code FALSE}, the metadata field {@code VIPS_META_ORIENTATION} is set
   * to the value of the orientation tag. Applications may read and interpret
   * this field
   * as they wish later in processing. See {@link VImage#autorot}. Save
   * operations will use {@code VIPS_META_ORIENTATION}, if present, to set the
   * orientation of output images.</p>
   *
   * <p>If {@code autorotate} is TRUE, the image will be rotated upright during load and
   * no metadata attached. This can be very slow.</p>
   *
   * <p>If {@code subifd} is -1 (the default), the main image is selected for each page.
   * If it is 0 or greater and there is a SUBIFD tag, the indexed SUBIFD is
   * selected. This can be used to read lower resolution layers from
   * bioformats-style image pyramids.</p>
   *
   * <p>Any ICC profile is read and attached to the VIPS image as
   * {@code VIPS_META_ICC_NAME}. Any XMP metadata is read and attached to the image
   * as {@code VIPS_META_XMP_NAME}. Any IPTC is attached as {@code VIPS_META_IPTC_NAME}. The
   * image description is
   * attached as {@code VIPS_META_IMAGEDESCRIPTION}. Data in the photoshop tag is
   * attached as {@code VIPS_META_PHOTOSHOP_NAME}.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}, {@link VImage#autorot}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage tiffload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "tiffload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Read a TIFF-formatted memory block into a VIPS image. Exactly as
   * {@link VImage#tiffload}, but read from a memory source.</p>
   *
   * <p>You must not free the buffer while {@code out} is active. The
   * {@code VipsObject}::postclose signal on {@code out} is a good place to free.</p>
   *
   * <p>See also: {@link VImage#tiffload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Exactly as {@link VImage#tiffload}, but read from a source.</p>
   *
   * <p>See also: {@link VImage#tiffload}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Write a VIPS image to a file as TIFF.</p>
   *
   * <p>If {@code in} has the {@code VIPS_META_PAGE_HEIGHT} metadata item, this is assumed to be a
   * &quot;toilet roll&quot; image. It will be
   * written as series of pages, each {@code VIPS_META_PAGE_HEIGHT} pixels high.</p>
   *
   * <p>Use {@code compression} to set the tiff compression. Currently jpeg, packbits,
   * fax4, lzw, none, deflate, webp and zstd are supported. The default is no
   * compression.
   * JPEG compression is a good lossy compressor for photographs, packbits is
   * good for 1-bit images, and deflate is the best lossless compression TIFF
   * can do.</p>
   *
   * <p>XYZ images are automatically saved as libtiff LOGLUV with SGILOG compression.
   * Float LAB images are saved as float CIELAB. Set {@code bitdepth} to save as 8-bit
   * CIELAB.</p>
   *
   * <p>Use {@code Q} to set the JPEG compression factor. Default 75.</p>
   *
   * <p>User {@code level} to set the ZSTD (1-22) or Deflate (1-9) compression level. Use {@code lossless} to
   * set WEBP lossless mode on. Use {@code Q} to set the WEBP compression level.</p>
   *
   * <p>Use {@code predictor} to set the predictor for lzw, deflate and zstd compression.
   * It defaults to {@link app.photofox.vipsffm.enums.VipsForeignTiffPredictor#FOREIGN_TIFF_PREDICTOR_HORIZONTAL}, meaning horizontal
   * differencing. Please refer to the libtiff
   * specifications for further discussion of various predictors.</p>
   *
   * <p>Set {@code tile} to TRUE to write a tiled tiff.  By default tiff are written in
   * strips. Use {@code tile-width} and {@code tile-height} to set the tile size. The defaiult
   * is 128 by 128.</p>
   *
   * <p>Set {@code pyramid} to write the image as a set of images, one per page, of
   * decreasing size. Use {@code region-shrink} to set how images will be shrunk: by
   * default each 2x2 block is just averaged, but you can set MODE or MEDIAN as
   * well.</p>
   *
   * <p>By default, the pyramid stops when the image is small enough to fit in one
   * tile. Use {@code depth} to stop when the image fits in one pixel, or to only write
   * a single layer.</p>
   *
   * <p>Set {@code bitdepth} to save 8-bit uchar images as 1, 2 or 4-bit TIFFs.
   * In case of depth 1: Values &gt;128 are written as white, values &lt;=128 as black.
   * Normally vips will write MINISBLACK TIFFs where black is a 0 bit, but if you
   * set {@code miniswhite}, it will use 0 for a white bit. Many pre-press applications
   * only work with images which use this sense. {@code miniswhite} only affects one-bit
   * images, it does nothing for greyscale images.
   * In case of depth 2: The same holds but values &lt; 64 are written as black.
   * For 64 &lt;= values &lt; 128 they are written as dark grey, for 128 &lt;= values &lt; 192
   * they are written as light gray and values above are written as white.
   * In case {@code miniswhite} is set to true this behavior is inverted.
   * In case of depth 4: values &lt; 16 are written as black, and so on for the
   * lighter shades. In case {@code miniswhite} is set to true this behavior is inverted.</p>
   *
   * <p>Use {@code resunit} to override the default resolution unit.
   * The default
   * resolution unit is taken from the header field
   * {@code VIPS_META_RESOLUTION_UNIT}. If this field is not set, then
   * VIPS defaults to cm.</p>
   *
   * <p>Use {@code xres} and {@code yres} to override the default horizontal and vertical
   * resolutions. By default these values are taken from the VIPS image header.
   * libvips resolution is always in pixels per millimetre.</p>
   *
   * <p>Set {@code bigtiff} to attempt to write a bigtiff. Bigtiff is a variant of the TIFF
   * format that allows more than 4GB in a file.</p>
   *
   * <p>Set {@code properties} to write all vips metadata to the IMAGEDESCRIPTION tag as
   * xml. If {@code properties} is not set, the value of {@code VIPS_META_IMAGEDESCRIPTION} is
   * used instead.</p>
   *
   * <p>The value of {@code VIPS_META_XMP_NAME} is written to
   * the XMP tag. {@code VIPS_META_ORIENTATION} (if set) is used to set the value of
   * the orientation
   * tag. {@code VIPS_META_IPTC} (if set) is used to set the value of the IPTC tag.
   * {@code VIPS_META_PHOTOSHOP_NAME} (if set) is used to set the value of the PHOTOSHOP
   * tag.</p>
   *
   * <p>By default, pyramid layers are saved as consecutive pages.
   * Set {@code subifd} to save pyramid layers as sub-directories of the main image.
   * Setting this option can improve compatibility with formats like OME.</p>
   *
   * <p>Set {@code premultiply} to save with premultiplied alpha. Some programs, such as
   * InDesign, will only work with premultiplied alpha.</p>
   *
   * <p>See also: {@link VImage#tiffload}, {@code vips_image_write_to_file}.</p>
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
   * @optionalArg level {@link VipsOption.Int} Deflate (1-9, default 6) or ZSTD (1-22, default 9) compression level
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
   * <p>As {@link VImage#tiffsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in {@code buf}, the length of the buffer in
   * {@code len}. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link VImage#tiffsave}, {@code vips_image_write_to_file}.</p>
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
   * @optionalArg level {@link VipsOption.Int} Deflate (1-9, default 6) or ZSTD (1-22, default 9) compression level
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
   * <p>As {@link VImage#tiffsave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#tiffsave}, {@code vips_image_write_to_target}.</p>
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
   * @optionalArg level {@link VipsOption.Int} Deflate (1-9, default 6) or ZSTD (1-22, default 9) compression level
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
   * <p>This operation behaves rather like {@link VImage#copy} between images
   * {@code in} and {@code out}, except that it keeps a cache of computed pixels.
   * This cache is made of up to {@code max-tiles} tiles (a value of -1
   * means any number of tiles), and each tile is of size {@code tile-width}
   * by {@code tile-height} pixels.</p>
   *
   * <p>Each cache tile is made with a single call to
   * {@code vips_region_prepare}.</p>
   *
   * <p>When the cache fills, a tile is chosen for reuse. If {@code access} is
   * {@link app.photofox.vipsffm.enums.VipsAccess#ACCESS_RANDOM}, then the least-recently-used tile is reused. If
   * {@code access} is {@link app.photofox.vipsffm.enums.VipsAccess#ACCESS_SEQUENTIAL}
   * the top-most tile is reused.</p>
   *
   * <p>By default, {@code tile-width} and {@code tile-height} are 128 pixels, and the operation
   * will cache up to 1,000 tiles. {@code access} defaults to {@link app.photofox.vipsffm.enums.VipsAccess#ACCESS_RANDOM}.</p>
   *
   * <p>Normally, only a single thread at once is allowed to calculate tiles. If
   * you set {@code threaded} to {@code TRUE}, {@code tilecache} will allow many threads to
   * calculate tiles at once, and share the cache between them.</p>
   *
   * <p>Normally the cache is dropped when computation finishes. Set {@code persistent} to
   * {@code TRUE} to keep the cache between computations.</p>
   *
   * <p>See also: {@code vips_cache}, {@link VImage#linecache}.</p>
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
   * <p>{@code tonelut} generates a tone curve for the adjustment of image
   * levels. It is mostly designed for adjusting the L* part of a LAB image in
   * a way suitable for print work, but you can use it for other things too.</p>
   *
   * <p>The curve is an unsigned 16-bit image with ({@code in-max} + 1) entries,
   * each in the range [0, {@code out-max}].</p>
   *
   * <p>{@code Lb}, {@code Lw} are expressed as 0-100, as in LAB colour space. You
   * specify the scaling for the input and output images with the {@code in-max} and
   * {@code out-max} parameters.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage tonelut(Arena arena, VipsOption... args) throws VipsError {
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
   * {@code VIPS_META_PAGE_HEIGHT} set to the height of each sub-image.</p>
   *
   * <p>This operation swaps the two major dimensions, so that page N in the
   * output contains the Nth scanline, in order, from each input page.</p>
   *
   * <p>You can override the {@code VIPS_META_PAGE_HEIGHT} metadata item with the optional
   * {@code page-height} parameter.</p>
   *
   * <p>{@code VIPS_META_PAGE_HEIGHT} in the output image is the number of pages in the
   * input image.</p>
   *
   * <p>See also: {@link VImage#grid}.</p>
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
   * Band {@code alpha-band} (by default the final band) contains the alpha and all
   * other bands are transformed as:</p>
   *
   * <pre>{@code 
   *   alpha = (int) clip(0, in[in.bands - 1], {@code max-alpha});
   *   norm = (double) alpha / {@code max-alpha};
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
   * <p>{@code max-alpha} has the default value 255, or 65535 for images tagged as
   * {@link VipsInterpretation#INTERPRETATION_RGB16} or
   * {@link VipsInterpretation#INTERPRETATION_GREY16}.</p>
   *
   * <p>Non-complex images only.</p>
   *
   * <p>See also: {@link VImage#premultiply}, {@link VImage#flatten}.</p>
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
   * <p>See also: {@link VImage#vipssave}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage vipsload(Arena arena, String filename, VipsOption... args) throws VipsError {
    var filenameOption = VipsOption.String("filename", filename);
    var outOption = VipsOption.Image("out");
    var callArgs = new ArrayList<>(Arrays.asList(args));
    callArgs.add(filenameOption);
    callArgs.add(outOption);
    VipsInvoker.invokeOperation(arena, "vipsload", callArgs);
    return outOption.valueOrThrow();
  }

  /**
   * <p>Exactly as {@link VImage#vipsload}, but read from a source.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Write {@code in} to {@code filename} in VIPS format.</p>
   *
   * <p>See also: {@link VImage#vipsload}.</p>
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
   * <p>As {@link VImage#vipssave}, but save to a target.</p>
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
   * <p>Use {@code page} to select a page to render, numbering from zero.</p>
   *
   * <p>Use {@code n} to select the number of pages to render. The default is 1. Pages are
   * rendered in a vertical column, with each individual page aligned to the
   * left. Set to -1 to mean &quot;until the end of the document&quot;. Use {@link VImage#grid}
   * to change page layout.</p>
   *
   * <p>Use {@code scale} to specify a scale-on-load factor. For example, 2.0 to double
   * the size on load. Animated webp images don't support shrink-on-load, so a
   * further resize may be necessary.</p>
   *
   * <p>The loader supports ICC, EXIF and XMP metadata.</p>
   *
   * <p>See also: {@code vips_image_new_from_file}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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
  public static VImage webpload(Arena arena, String filename, VipsOption... args) throws VipsError {
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
   * {@link VImage#webpload}, but read from a memory buffer.</p>
   *
   * <p>You must not free the buffer while {@code out} is active. The
   * {@code VipsObject}::postclose signal on {@code out} is a good place to free.</p>
   *
   * <p>See also: {@link VImage#webpload}</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Exactly as {@link VImage#webpload}, but read from a source.</p>
   *
   * <p>See also: {@link VImage#webpload}</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
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

  /**
   * <p>Write an image to a file in WebP format.</p>
   *
   * <p>By default, images are saved in lossy format, with
   * {@code Q} giving the WebP quality factor. It has the range 0 - 100, with the
   * default 75.</p>
   *
   * <p>Use {@code preset} to hint the image type to the lossy compressor. The default is
   * {@link app.photofox.vipsffm.enums.VipsForeignWebpPreset#FOREIGN_WEBP_PRESET_DEFAULT}.</p>
   *
   * <p>Set {@code smart-subsample} to enable high quality chroma subsampling.</p>
   *
   * <p>Set {@code smart-deblock} to enable auto-adjusting of the deblocking filter. This
   * can improve image quality, especially on low-contrast edges, but encoding
   * can take significantly longer.</p>
   *
   * <p>Use {@code alpha-q} to set the quality for the alpha channel in lossy mode. It has
   * the range 1 - 100, with the default 100.</p>
   *
   * <p>Use {@code effort} to control how much CPU time to spend attempting to
   * reduce file size. A higher value means more effort and therefore CPU time
   * should be spent. It has the range 0-6 and a default value of 4.</p>
   *
   * <p>Use {@code target-size} to set the desired target size in bytes.</p>
   *
   * <p>Use {@code passes} to set the number of entropy-analysis passes, by default 1,
   * unless {@code target-size} is set, in which case the default is 3. It is not
   * recommended to set {@code passes} unless you set {@code target-size}. Doing so will
   * result in longer encoding times for no benefit.</p>
   *
   * <p>Set {@code lossless} to use lossless compression, or combine {@code near-lossless}
   * with {@code Q} 80, 60, 40 or 20 to apply increasing amounts of preprocessing
   * which improves the near-lossless compression ratio by up to 50%.</p>
   *
   * <p>For animated webp output, {@code min-size} will try to optimize for minimum size.</p>
   *
   * <p>For animated webp output, {@code kmax} sets the maximum number of frames between
   * keyframes. Setting 0 means only keyframes. {@code kmin} sets the minimum number of
   * frames between frames. Setting 0 means no keyframes. By default, keyframes
   * are disabled.</p>
   *
   * <p>For animated webp output, {@code mixed} tries to improve the file size by mixing
   * both lossy and lossless encoding.</p>
   *
   * <p>Use the metadata items `loop` and `delay` to set the number of
   * loops for the animation and the frame delays.</p>
   *
   * <p>See also: {@link VImage#webpload}, {@code vips_image_write_to_file}.</p>
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
   * @optionalArg target-size {@link VipsOption.Int} Desired target size in bytes
   * @optionalArg reduction-effort {@link VipsOption.Int} Level of CPU effort to reduce file size
   * @optionalArg mixed {@link VipsOption.Boolean} Allow mixed encoding (might reduce file size)
   * @optionalArg smart-deblock {@link VipsOption.Boolean} Enable auto-adjusting of the deblocking filter
   * @optionalArg passes {@link VipsOption.Int} Number of entropy-analysis passes (in [1..10])
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
   * <p>As {@link VImage#webpsave}, but save to a memory buffer.</p>
   *
   * <p>The address of the buffer is returned in {@code buf}, the length of the buffer in
   * {@code len}. You are responsible for freeing the buffer with g_free() when you
   * are done with it.</p>
   *
   * <p>See also: {@link VImage#webpsave}.</p>
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
   * @optionalArg target-size {@link VipsOption.Int} Desired target size in bytes
   * @optionalArg reduction-effort {@link VipsOption.Int} Level of CPU effort to reduce file size
   * @optionalArg mixed {@link VipsOption.Boolean} Allow mixed encoding (might reduce file size)
   * @optionalArg smart-deblock {@link VipsOption.Boolean} Enable auto-adjusting of the deblocking filter
   * @optionalArg passes {@link VipsOption.Int} Number of entropy-analysis passes (in [1..10])
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
   * <p>As {@link VImage#webpsave}, but save as a mime webp on stdout.</p>
   *
   * <p>See also: {@link VImage#webpsave}, {@code vips_image_write_to_file}.</p>
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
   * @optionalArg target-size {@link VipsOption.Int} Desired target size in bytes
   * @optionalArg reduction-effort {@link VipsOption.Int} Level of CPU effort to reduce file size
   * @optionalArg mixed {@link VipsOption.Boolean} Allow mixed encoding (might reduce file size)
   * @optionalArg smart-deblock {@link VipsOption.Boolean} Enable auto-adjusting of the deblocking filter
   * @optionalArg passes {@link VipsOption.Int} Number of entropy-analysis passes (in [1..10])
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
   * <p>As {@link VImage#webpsave}, but save to a target.</p>
   *
   * <p>See also: {@link VImage#webpsave}.</p>
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
   * @optionalArg target-size {@link VipsOption.Int} Desired target size in bytes
   * @optionalArg reduction-effort {@link VipsOption.Int} Level of CPU effort to reduce file size
   * @optionalArg mixed {@link VipsOption.Boolean} Allow mixed encoding (might reduce file size)
   * @optionalArg smart-deblock {@link VipsOption.Boolean} Enable auto-adjusting of the deblocking filter
   * @optionalArg passes {@link VipsOption.Int} Number of entropy-analysis passes (in [1..10])
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
   * <p>Use {@code cell-size} to set the size of the cells from which the image is
   * constructed. The default is 256 x 256.</p>
   *
   * <p>If {@code width} and {@code height} are multiples of {@code cell-size}, the image will tessellate.</p>
   *
   * <p>See also: {@link VImage#perlin}, {@link VImage#fractsurf}, {@link VImage#gaussnoise}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg cell-size {@link VipsOption.Int} Size of Worley cells
   * @optionalArg seed {@link VipsOption.Int} Random number seed
   */
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

  /**
   * <p>Slice an image up and move the segments about so that the pixel that was
   * at 0, 0 is now at {@code x}, {@code y}. If {@code x} and {@code y} are not set, they default to the
   * centre of the image.</p>
   *
   * <p>See also: {@link VImage#embed}, {@link VImage#replicate}.</p>
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
   * <p>Set {@code csize}, {@code dsize}, {@code esize} to generate higher dimensions and add more
   * bands. The extra dimensions are placed down the vertical axis. Use
   * {@link VImage#grid} to change the layout.</p>
   *
   * <p>See also: {@link VImage#grey}, {@link VImage#grid}, {@link VImage#identity}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg csize {@link VipsOption.Int} Size of third dimension
   * @optionalArg dsize {@link VipsOption.Int} Size of fourth dimension
   * @optionalArg esize {@link VipsOption.Int} Size of fifth dimension
   */
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

  /**
   * <p>Create a one-band image of a zone plate.</p>
   *
   * <p>Pixels are normally in [-1, +1], set {@code uchar} to output [0, 255].</p>
   *
   * <p>See also: {@link VImage#eye}, {@link VImage#xyz}.</p>
   * @param arena The arena that bounds resulting memory allocations during this operation
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg uchar {@link VipsOption.Boolean} Output an unsigned char image
   */
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

  /**
   * <p>Zoom an image by repeating pixels. This is fast nearest-neighbour
   * zoom.</p>
   *
   * <p>See also: {@link VImage#affine}, {@link VImage#subsample}.</p>
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

  public static VImage newFromSource(Arena arena, VSource source, VipsOption... options) throws
      VipsError {
    return newFromSource(arena, source, "", options);
  }

  /**
   * Creates a new VImage from raw bytes. Note that this is quite inefficient, use {@link VImage#newFromFile(Arena, String, VipsOption...)} and friends instead.
   */
  public static VImage newFromBytes(Arena arena, byte[] bytes, String optionString,
      VipsOption... options) throws VipsError {
    var source = VSource.newFromBytes(arena, bytes);
    return newFromSource(arena, source, optionString, options);
  }

  /**
   * See {@link VImage#newFromBytes(Arena, byte[], String, VipsOption...)}
   */
  public static VImage newFromBytes(Arena arena, byte[] bytes, VipsOption... options) throws
      VipsError {
    var source = VSource.newFromBytes(arena, bytes);
    return newFromSource(arena, source, options);
  }

  /**
   * Creates a new VImage from an {@link InputStream}. This uses libvips' "custom streaming" feature and is
   * therefore quite efficient, avoiding the need to make extra full copies of the image's data.
   * You could, for example, use this function to create an image directly from an API call, thumbnail it,
   * and then upload directly to an S3-compatible API efficiently in memory - all without creating a local
   * file.
   */
  public static VImage newFromStream(Arena arena, InputStream stream, String optionString,
      VipsOption... options) throws VipsError {
    var source = VSource.newFromInputStream(arena, stream);
    return newFromSource(arena, source, optionString, options);
  }

  /**
   * See {@link VImage#newFromStream(Arena, InputStream, String, VipsOption...)}
   */
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

  /**
   * Writes this VImage to an {@link OutputStream}. This uses libvips' "custom streaming" feature and is
   * therefore quite efficient, avoiding the need to make extra full copies of the image's data.
   * You could, for example, use this function to create an image directly from an API call, thumbnail it,
   * and then upload directly to an S3-compatible API efficiently in memory - all without creating a local
   * file.
   */
  public void writeToStream(OutputStream stream, String suffix, VipsOption... options) throws
      VipsError {
    var target = VTarget.newFromOutputStream(arena, stream);
    this.writeToTarget(target, suffix, options);
  }

  public static VImage newImage(Arena arena) throws VipsError {
    var newImagePointer = VipsHelper.image_new(arena);
    return new VImage(arena, newImagePointer);
  }
}
