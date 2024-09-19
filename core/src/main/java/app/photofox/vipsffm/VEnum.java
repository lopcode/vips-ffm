package app.photofox.vipsffm;

public interface VEnum {

    int getRawValue();

    record Raw(int rawValue) implements VEnum {

        @Override
        public int getRawValue() {
            return this.rawValue;
        }
    }

    static VEnum of(int rawValue) {
        return new VEnum.Raw(rawValue);
    }
}