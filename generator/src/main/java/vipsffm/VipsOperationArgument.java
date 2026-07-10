package vipsffm;

public record VipsOperationArgument(
    String name,
    int flags,
    String blurb,
    GValueType type,
    boolean isRequired,
    boolean isInput,
    boolean isOutput,
    boolean isDeprecated,
    boolean isModify,
    boolean isEnum
) {
}
