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
   * Gets the raw [MemorySegment] (C pointer) for this image
   * The memory address' lifetime is bound to the scope of the [arena]
   * Usage of the memory address is strongly discouraged, but it is available if some functionality is missing and you need to use it with [VipsHelper]
   */
  public MemorySegment getUnsafeAddress() {
    return this.address;
  }

  /**
   * Transform LCh to CMC
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
   * Transform CMYK to XYZ
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
   * Transform HSV to sRGB
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
   * Transform LCh to CMC
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
   * Transform LCh to Lab
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
   * Transform Lab to LCh
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
   * Transform float Lab to LabQ coding
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
   * Transform float Lab to signed short
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
   * Transform CIELAB to XYZ
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
   * Unpack a LabQ image to float Lab
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
   * Unpack a LabQ image to short Lab
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
   * Convert a LabQ image to sRGB
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
   * Transform signed short Lab to float
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
   * Transform short Lab to LabQ coding
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
   * Transform XYZ to CMYK
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
   * Transform XYZ to Lab
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
   * Transform XYZ to Yxy
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
   * Transform XYZ to scRGB
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
   * Transform Yxy to XYZ
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
   * Absolute value of an image
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
   * Add two images
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
   * Affine transform of an image
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
   * Load an Analyze6 image
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
   * Join an array of images
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
   * Autorotate image by exif tag
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg angle {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAngle} Angle image was rotated by
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
   * Find image average
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
   * Boolean operation across image bands
   * @param boolean1 {@link app.photofox.vipsffm.enums.VipsOperationBoolean} Boolean to perform
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
   * Fold up x axis into bands
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
   * Bandwise join a set of images
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
   * Append a constant band to an image
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
   * Band-wise average
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
   * Band-wise rank of a set of images
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
   * Unfold image bands into x axis
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
   * Make a black image
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
   * Boolean operation on two images
   * @param boolean1 {@link app.photofox.vipsffm.enums.VipsOperationBoolean} Boolean to perform
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
   * Boolean operations against a constant
   * @param boolean1 {@link app.photofox.vipsffm.enums.VipsOperationBoolean} Boolean to perform
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
   * Build a look-up table
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
   * Byteswap an image
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
   * Canny edge detector
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
   * Use pixel values to pick cases from an array of images
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
   * Cast an image
   * @param format {@link app.photofox.vipsffm.enums.VipsBandFormat} Format to cast to
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
   * Convert to a new colorspace
   * @param space {@link app.photofox.vipsffm.enums.VipsInterpretation} Destination color space
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg source-space {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsInterpretation} Source color space
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
   * Convolve with rotating mask
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
   * Perform a complex operation on an image
   * @param cmplx {@link app.photofox.vipsffm.enums.VipsOperationComplex} Complex to perform
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
   * Complex binary operations on two images
   * @param cmplx {@link app.photofox.vipsffm.enums.VipsOperationComplex2} Binary complex operation to perform
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
   * Form a complex image from two real images
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
   * Get a component from a complex image
   * @param get {@link app.photofox.vipsffm.enums.VipsOperationComplexget} Complex to perform
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
   * Blend an array of images with an array of blend modes
   * @param in Array of input images
   * @param mode Array of VipsBlendMode to join with
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg x {@link VipsOption.ArrayInt} Array of x coordinates to join at
   * @optionalArg y {@link VipsOption.ArrayInt} Array of y coordinates to join at
   * @optionalArg compositing-space {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsInterpretation} Composite images in this colour space
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
   * Blend a pair of images with a blend mode
   * @param mode {@link app.photofox.vipsffm.enums.VipsBlendMode} VipsBlendMode to join with
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg x {@link VipsOption.Int} X position of overlay
   * @optionalArg y {@link VipsOption.Int} Y position of overlay
   * @optionalArg compositing-space {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsInterpretation} Composite images in this colour space
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
   * Convolution operation
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
   * Approximate integer convolution
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
   * Approximate separable integer convolution
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
   * Float convolution operation
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
   * Int convolution operation
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
   * Separable convolution operation
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
   * Copy an image
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg swap {@link VipsOption.Boolean} Swap bytes in image between little and big-endian
   * @optionalArg width {@link VipsOption.Int} Image width in pixels
   * @optionalArg height {@link VipsOption.Int} Image height in pixels
   * @optionalArg bands {@link VipsOption.Int} Number of bands in image
   * @optionalArg format {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsBandFormat} Pixel format in image
   * @optionalArg coding {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsCoding} Pixel coding
   * @optionalArg interpretation {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsInterpretation} Pixel interpretation
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
   * Count lines in an image
   * @param direction {@link app.photofox.vipsffm.enums.VipsDirection} Countlines left-right or up-down
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
   * Load csv
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
   * Load csv
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
   * Save image to csv
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
   * Save image to csv
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
   * Calculate dE00
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
   * Calculate dE76
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
   * Calculate dECMC
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
   * Find image standard deviation
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
   * Divide two images
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
   * Draw a circle on an image
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
   * Flood-fill an area
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
   * Paint an image into another image
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
   * Draw a line on an image
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
   * Draw a mask on an image
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
   * Paint a rectangle on an image
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
   * Blur a rectangle on an image
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
   * Save image to deepzoom file
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
   * @optionalArg angle {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAngle} Rotate image during save
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
   * Save image to dz buffer
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
   * @optionalArg angle {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAngle} Rotate image during save
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
   * Save image to deepzoom target
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
   * @optionalArg angle {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsAngle} Rotate image during save
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
   * Embed an image in a larger image
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
   * Extract an area from an image
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
   * Extract band from an image
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
   * Make an image showing the eye's spatial response
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
   * False-color an image
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
   * Fast correlation
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
   * Fill image zeros with nearest non-zero pixel
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
   * Search an image for non-edge areas
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
   * Load a FITS image
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
   * Save image to fits file
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
   * Flatten alpha out of an image
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
   * Flip an image
   * @param direction {@link app.photofox.vipsffm.enums.VipsDirection} Direction to flip image
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
   * Transform float RGB to Radiance coding
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
   * Make a fractal surface
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
   * Frequency-domain filtering
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
   * Forward FFT
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
   * Gamma an image
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
   * Gaussian blur
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
   * Make a gaussian image
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
   * Make a gaussnoise image
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
   * Read a point from an image
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
   * Load GIF with libnsgif
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
   * Load GIF with libnsgif
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
   * Load gif from source
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
   * Save as gif
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
   * Save as gif
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
   * Save as gif
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
   * Global balance an image mosaic
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
   * Place an image within a larger image with a certain gravity
   * @param direction {@link app.photofox.vipsffm.enums.VipsCompassDirection} Direction to place image within width/height
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
   * Make a grey ramp image
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
   * Grid an image
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
   * Load a HEIF image
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
   * Load a HEIF image
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
   * Load a HEIF image
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
   * Save image in HEIF format
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
   * Save image in HEIF format
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
   * Save image in HEIF format
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
   * Form cumulative histogram
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
   * Estimate image entropy
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
   * Histogram equalisation
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
   * Find image histogram
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
   * Find indexed image histogram
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
   * Find n-dimensional image histogram
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
   * Test for monotonicity
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
   * Local histogram equalisation
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
   * Match two histograms
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
   * Normalise histogram
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
   * Plot histogram
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
   * Find hough circle transform
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
   * Find hough line transform
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
   * Output to device with ICC profile
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
   * Import from device with ICC profile
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
   * Transform between devices with ICC profiles
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
   * Make a 1D image where pixel values are indexes
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
   * Ifthenelse an image
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
   * Insert image @sub into @main at @x, @y
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
   * Invert an image
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
   * Build an inverted look-up table
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
   * Inverse FFT
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
   * Join a pair of images
   * @param direction {@link app.photofox.vipsffm.enums.VipsDirection} Join left-right or up-down
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
   * Load JPEG2000 image
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
   * Load JPEG2000 image
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
   * Load JPEG2000 image
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
   * Save image in JPEG2000 format
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
   * Save image in JPEG2000 format
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
   * Save image in JPEG2000 format
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
   * Load jpeg from file
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
   * Load jpeg from buffer
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
   * Load image from jpeg source
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
   * Save image to jpeg file
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
   * Save image to jpeg buffer
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
   * Save image to jpeg mime
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
   * Save image to jpeg target
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
   * Load JPEG-XL image
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
   * Load JPEG-XL image
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
   * Load JPEG-XL image
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
   * Save image in JPEG-XL format
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
   * Save image in JPEG-XL format
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
   * Save image in JPEG-XL format
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
   * Label regions in an image
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
   * Calculate (a * in + b)
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
   * Cache an image as a set of lines
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
   * Make a Laplacian of Gaussian image
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
   * Load file with ImageMagick7
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
   * Load buffer with ImageMagick7
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
   * Save file with ImageMagick
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
   * Save image to magick buffer
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
   * Resample with a map image
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
   * Map an image though a lut
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
   * Make a butterworth filter
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
   * Make a butterworth_band filter
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
   * Make a butterworth ring filter
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
   * Make fractal filter
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
   * Make a gaussian filter
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
   * Make a gaussian filter
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
   * Make a gaussian ring filter
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
   * Make an ideal filter
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
   * Make an ideal band filter
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
   * Make an ideal ring filter
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
   * First-order match of two images
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
   * Apply a math operation to an image
   * @param math {@link app.photofox.vipsffm.enums.VipsOperationMath} Math to perform
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
   * Binary math operations
   * @param math2 {@link app.photofox.vipsffm.enums.VipsOperationMath2} Math to perform
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
   * Binary math operations with a constant
   * @param math2 {@link app.photofox.vipsffm.enums.VipsOperationMath2} Math to perform
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
   * Load mat from file
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
   * Invert an matrix
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
   * Load matrix
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
   * Load matrix
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
   * Print matrix
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
   * Save image to matrix
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
   * Save image to matrix
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
   * Find image maximum
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
   * Measure a set of patches on a color chart
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
   * Merge two images
   * @param direction {@link app.photofox.vipsffm.enums.VipsDirection} Horizontal or vertical merge
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
   * Find image minimum
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
   * Morphology operation
   * @param morph {@link app.photofox.vipsffm.enums.VipsOperationMorphology} Morphological operation to perform
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
   * Mosaic two images
   * @param direction {@link app.photofox.vipsffm.enums.VipsDirection} Horizontal or vertical mosaic
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
   * First-order mosaic of two images
   * @param direction {@link app.photofox.vipsffm.enums.VipsDirection} Horizontal or vertical mosaic
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
   * Pick most-significant byte from an image
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
   * Multiply two images
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
   * Load an OpenEXR image
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
   * Load file with OpenSlide
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
   * Load source with OpenSlide
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
   * Load PDF from file
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
   * Load PDF from buffer
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
   * Load PDF from source
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
   * Find threshold for percent of pixels
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
   * Make a perlin noise image
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
   * Calculate phase correlation
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
   * Load png from file
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
   * Load png from buffer
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
   * Load png from source
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
   * Save image to file as PNG
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
   * Save image to buffer as PNG
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
   * Save image to target as PNG
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
   * Load ppm from file
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
   * Load ppm base class
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
   * Save image to ppm file
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
   * Save to ppm
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
   * Premultiply image alpha
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
   * Prewitt edge detector
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
   * Find image profiles
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
   * Find image projections
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
   * Resample an image with a quadratic transform
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
   * Unpack Radiance coding to float RGB
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
   * Load a Radiance image from a file
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
   * Load rad from buffer
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
   * Load rad from source
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
   * Save image to Radiance file
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
   * Save image to Radiance buffer
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
   * Save image to Radiance target
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
   * Rank filter
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
   * Load raw data from a file
   * @param filename Filename to load from
   * @param width Image width in pixels
   * @param height Image height in pixels
   * @param bands Number of bands in image
   * @param args Array of VipsOption to apply to this operation
   * @optionalArg offset {@link VipsOption.Long} Offset in bytes from start of file
   * @optionalArg format {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsBandFormat} Pixel format in image
   * @optionalArg interpretation {@link VipsOption.Enum} {@link app.photofox.vipsffm.enums.VipsInterpretation} Pixel interpretation
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
   * Save image to raw file
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
   * Write raw image to file descriptor
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
   * Linear recombination with matrix
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
   * Reduce an image
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
   * Shrink an image horizontally
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
   * Shrink an image vertically
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
   * Relational operation on two images
   * @param relational {@link app.photofox.vipsffm.enums.VipsOperationRelational} Relational to perform
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
   * Relational operations against a constant
   * @param relational {@link app.photofox.vipsffm.enums.VipsOperationRelational} Relational to perform
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
   * Remainder after integer division of two images
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
   * Remainder after integer division of an image and a constant
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
   * Replicate an image
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
   * Resize an image
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
   * Rotate an image
   * @param angle {@link app.photofox.vipsffm.enums.VipsAngle} Angle to rotate image
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
   * Rotate an image
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
   * Rotate an image by a number of degrees
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
   * Perform a round function on an image
   * @param round {@link app.photofox.vipsffm.enums.VipsOperationRound} Rounding operation to perform
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
   * Transform sRGB to HSV
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
   * Convert an sRGB image to scRGB
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
   * Convert scRGB to BW
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
   * Transform scRGB to XYZ
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
   * Convert an scRGB image to sRGB
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
   * Scale an image to uchar
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
   * Scharr edge detector
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
   * Check sequential access
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
   * Unsharp masking for print
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
   * Shrink an image
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
   * Shrink an image horizontally
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
   * Shrink an image vertically
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
   * Unit vector of pixel
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
   * Similarity transform of an image
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
   * Make a 2D sine wave
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
   * Extract an area from an image
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
   * Sobel edge detector
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
   * Spatial correlation
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
   * Make displayable power spectrum
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
   * Find many image stats
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
   * Statistical difference
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
   * Subsample an image
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
   * Subtract two images
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
   * Sum an array of images
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
   * Load SVG with rsvg
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
   * Load SVG with rsvg
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
   * Load svg from source
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
   * Find the index of the first non-zero pixel in tests
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
   * Make a text image
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
   * Generate thumbnail from file
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
   * Generate thumbnail from buffer
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
   * Generate thumbnail from image
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
   * Generate thumbnail from source
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
   * Load tiff from file
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
   * Load tiff from buffer
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
   * Load tiff from source
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
   * Save image to tiff file
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
   * Save image to tiff buffer
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
   * Save image to tiff target
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
   * Cache an image as a set of tiles
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
   * Build a look-up table
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
   * Transpose3d an image
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
   * Unpremultiply image alpha
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
   * Load vips from file
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
   * Load vips from source
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
   * Save image to file in vips format
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
   * Save image to target in vips format
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
   * Load webp from file
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
   * Load webp from buffer
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
   * Load webp from source
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
   * Save as WebP
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
   * Save as WebP
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
   * Save image to webp mime
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
   * Save as WebP
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
   * Make a worley noise image
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
   * Wrap image origin
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
   * Make an image where pixel values are coordinates
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
   * Make a zone plate
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
   * Zoom an image
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
