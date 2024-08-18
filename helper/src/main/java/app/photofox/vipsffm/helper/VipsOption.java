package app.photofox.vipsffm.helper;

public sealed interface VipsOption permits VipsStringOption, VipsIntOption {

    String key();
}
