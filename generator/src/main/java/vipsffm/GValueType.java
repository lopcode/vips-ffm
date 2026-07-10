package vipsffm;

public sealed interface GValueType permits GValueType.Simple, GValueType.Unknown {

    enum Simple implements GValueType {
        BOOLEAN,
        INT,
        UINT64,
        DOUBLE,
        CHAR_ARRAY,
        ENUM,
        FLAGS,
        OBJECT,
        VIPS_IMAGE,
        VIPS_ARRAY_INT,
        VIPS_ARRAY_DOUBLE,
        VIPS_ARRAY_IMAGE,
        VIPS_REF_STRING,
        VIPS_BLOB,
        VIPS_SOURCE,
        VIPS_TARGET,
        VIPS_INTERPOLATE
    }

    record Unknown(String rawName) implements GValueType {
    }

    static GValueType fromString(String raw) {
        return switch (raw) {
            case "gboolean" -> Simple.BOOLEAN;
            case "gint" -> Simple.INT;
            case "guint64" -> Simple.UINT64;
            case "gdouble" -> Simple.DOUBLE;
            case "gchararray" -> Simple.CHAR_ARRAY;
            case "GEnum" -> Simple.ENUM;
            case "GFlags" -> Simple.FLAGS;
            case "GObject" -> Simple.OBJECT;
            case "VipsImage" -> Simple.VIPS_IMAGE;
            case "VipsArrayInt" -> Simple.VIPS_ARRAY_INT;
            case "VipsArrayDouble" -> Simple.VIPS_ARRAY_DOUBLE;
            case "VipsArrayImage" -> Simple.VIPS_ARRAY_IMAGE;
            case "VipsRefString" -> Simple.VIPS_REF_STRING;
            case "VipsBlob" -> Simple.VIPS_BLOB;
            case "VipsSource" -> Simple.VIPS_SOURCE;
            case "VipsTarget" -> Simple.VIPS_TARGET;
            case "VipsInterpolate" -> Simple.VIPS_INTERPOLATE;
            default -> new Unknown(raw);
        };
    }
}
