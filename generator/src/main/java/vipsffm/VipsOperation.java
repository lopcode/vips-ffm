package vipsffm;

import java.util.List;

public record VipsOperation(
    String nickname,
    String description,
    List<VipsOperationArgument> args,
    boolean isDeprecated,
    DiscoverVipsOperations.GIRRepository.GIRMethod gir
) {
    @Override
    public String toString() {
        var girText = gir != null ? "has gir" : "no gir";
        return "VipsOperation(nickname=" + nickname + ", " + args.size() + " args, " + girText + ")";
    }
}
