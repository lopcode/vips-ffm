typedef gint64 (*CustomStreamReadCallback)(VipsSourceCustom *source, void *data, gint64 length, void *handle);

typedef gint64 (*CustomStreamSeekCallback)(VipsSourceCustom *source, gint64 offset, int whence, void *handle);

typedef gint64 (*CustomStreamWriteCallback)(VipsTargetCustom *source, void *data, gint64 length, void *handle);

typedef int (*CustomStreamEndCallback)(VipsTargetCustom *source, void *handle);