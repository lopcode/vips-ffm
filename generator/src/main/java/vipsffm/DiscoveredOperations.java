package vipsffm;

import java.util.List;

public record DiscoveredOperations(
    List<VipsOperation> operations,
    List<VipsEnum> enums
) {
}
