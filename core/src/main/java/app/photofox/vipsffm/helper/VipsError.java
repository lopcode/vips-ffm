package app.photofox.vipsffm.helper;

public class VipsError extends RuntimeException {

    public VipsError(String message) {
        super(message);
    }

    public VipsError(String message, Throwable cause) {
        super(message, cause);
    }

    public VipsError(Throwable cause) {
        super(cause);
    }

    protected VipsError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}