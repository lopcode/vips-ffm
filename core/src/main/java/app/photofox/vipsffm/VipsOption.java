package app.photofox.vipsffm;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public sealed interface VipsOption<T> permits VipsOption.Int, VipsOption.Double, VipsOption.Long, VipsOption.Boolean, VipsOption.String, VipsOption.Image, VipsOption.Source, VipsOption.Target, VipsOption.Blob, VipsOption.ArrayDouble, VipsOption.ArrayInt, VipsOption.ArrayImage, VipsOption.Interpolate, VipsOption.Enum {

    java.lang.String key();

    boolean hasValue();

    Optional<T> value();

    /**
     * Returns the value contained within the Optional, or throws a VipsError
     * if the Optional is empty.
     *
     * @return The value of type T.
     * @throws VipsError if the Optional is empty.
     */
    default T valueOrThrow() throws VipsError {
        Optional<T> optionalValue = value();
        return optionalValue.orElseThrow(
                () -> new VipsError("Unexpected empty value from " + this.getClass().getSimpleName())
        );
    }

    record Int(java.lang.String key, AtomicReference<Optional<Integer>> box) implements VipsOption<Integer> {

        public boolean hasValue() {
            return box.get().isPresent();
        }

        @Override
        public Optional<Integer> value() {
            return box.get();
        }

        void setValue(int value) {
            this.box.set(Optional.of(value));
        }
    }

    record Double(java.lang.String key,
                  AtomicReference<Optional<java.lang.Double>> box) implements VipsOption<java.lang.Double> {

        @Override
        public Optional<java.lang.Double> value() {
            return box.get();
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(double value) {
            this.box.set(Optional.of(value));
        }
    }

    record Long(java.lang.String key,
                AtomicReference<Optional<java.lang.Long>> box) implements VipsOption<java.lang.Long> {

        @Override
        public Optional<java.lang.Long> value() {
            return box.get();
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(java.lang.Long value) {
            this.box.set(Optional.of(value));
        }
    }

    record Boolean(java.lang.String key,
                   AtomicReference<Optional<java.lang.Boolean>> box) implements VipsOption<java.lang.Boolean> {

        @Override
        public Optional<java.lang.Boolean> value() {
            return box.get();
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(boolean value) {
            this.box.set(Optional.of(value));
        }
    }

    record String(java.lang.String key,
                  AtomicReference<Optional<java.lang.String>> box) implements VipsOption<java.lang.String> {

        @Override
        public Optional<java.lang.String> value() {
            return box.get();
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(java.lang.String value) {
            this.box.set(Optional.of(value));
        }
    }

    record Image(java.lang.String key, AtomicReference<Optional<VImage>> box) implements VipsOption<VImage> {

        @Override
        public Optional<VImage> value() {
            return box.get();
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(VImage value) {
            this.box.set(Optional.of(value));
        }
    }

    record Source(java.lang.String key, AtomicReference<Optional<VSource>> box) implements VipsOption<VSource> {

        @Override
        public Optional<VSource> value() {
            return box.get();
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(VSource value) {
            this.box.set(Optional.of(value));
        }
    }

    record Target(java.lang.String key, AtomicReference<Optional<VTarget>> box) implements VipsOption<VTarget> {

        @Override
        public Optional<VTarget> value() {
            return box.get();
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(VTarget value) {
            this.box.set(Optional.of(value));
        }
    }

    record Blob(java.lang.String key, AtomicReference<Optional<VBlob>> box) implements VipsOption<VBlob> {

        @Override
        public Optional<VBlob> value() {
            return box.get();
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(VBlob value) {
            this.box.set(Optional.of(value));
        }
    }

    record ArrayDouble(java.lang.String key,
                       AtomicReference<Optional<List<java.lang.Double>>> box) implements VipsOption<List<java.lang.Double>> {

        @Override
        public Optional<List<java.lang.Double>> value() {
            return box.get();
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(List<java.lang.Double> value) {
            this.box.set(Optional.of(value));
        }
    }

    record ArrayInt(java.lang.String key,
                    AtomicReference<Optional<List<Integer>>> box) implements VipsOption<List<Integer>> {

        @Override
        public Optional<List<Integer>> value() {
            return box.get();
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(List<Integer> value) {
            this.box.set(Optional.of(value));
        }
    }

    record ArrayImage(java.lang.String key,
                      AtomicReference<Optional<List<VImage>>> box) implements VipsOption<List<VImage>> {

        @Override
        public Optional<List<VImage>> value() {
            return box.get();
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(List<VImage> value) {
            this.box.set(Optional.of(value));
        }
    }

    record Interpolate(java.lang.String key,
                       AtomicReference<Optional<VInterpolate>> box) implements VipsOption<VInterpolate> {

        @Override
        public Optional<VInterpolate> value() {
            return box.get();
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(VInterpolate value) {
            this.box.set(Optional.of(value));
        }
    }

    record Enum(java.lang.String key, AtomicReference<Optional<VEnum>> box) implements VipsOption<VEnum> {

        @Override
        public Optional<VEnum> value() {
            return box.get();
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(VEnum value) {
            this.box.set(Optional.of(value));
        }
    }

    static VipsOption.Int Int(java.lang.String key, Integer value) {
        return new VipsOption.Int(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.Int Int(java.lang.String key) {
        return new VipsOption.Int(key, new AtomicReference<>(Optional.empty()));
    }

    static VipsOption.Double Double(java.lang.String key, java.lang.Double value) {
        return new VipsOption.Double(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.Double Double(java.lang.String key) {
        return new VipsOption.Double(key, new AtomicReference<>(Optional.empty()));
    }

    static VipsOption.Long Long(java.lang.String key, java.lang.Long value) {
        return new VipsOption.Long(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.Long Long(java.lang.String key) {
        return new VipsOption.Long(key, new AtomicReference<>(Optional.empty()));
    }

    static VipsOption.Boolean Boolean(java.lang.String key, boolean value) {
        return new VipsOption.Boolean(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.Boolean Boolean(java.lang.String key) {
        return new VipsOption.Boolean(key, new AtomicReference<>(Optional.empty()));
    }

    static VipsOption.String String(java.lang.String key, java.lang.String value) {
        return new VipsOption.String(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.String String(java.lang.String key) {
        return new VipsOption.String(key, new AtomicReference<>(Optional.empty()));
    }

    static VipsOption.Image Image(java.lang.String key, VImage value) {
        return new VipsOption.Image(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.Image Image(java.lang.String key) {
        return new VipsOption.Image(key, new AtomicReference<>(Optional.empty()));
    }

    static VipsOption.Source Source(java.lang.String key, VSource value) {
        return new VipsOption.Source(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.Source Source(java.lang.String key) {
        return new VipsOption.Source(key, new AtomicReference<>(Optional.empty()));
    }

    static VipsOption.Target Target(java.lang.String key, VTarget value) {
        return new VipsOption.Target(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.Target Target(java.lang.String key) {
        return new VipsOption.Target(key, new AtomicReference<>(Optional.empty()));
    }

    static VipsOption.Blob Blob(java.lang.String key, VBlob value) {
        return new VipsOption.Blob(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.Blob Blob(java.lang.String key) {
        return new VipsOption.Blob(key, new AtomicReference<>(Optional.empty()));
    }

    static VipsOption.ArrayDouble ArrayDouble(java.lang.String key, List<java.lang.Double> value) {
        return new VipsOption.ArrayDouble(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.ArrayDouble ArrayDouble(java.lang.String key) {
        return new VipsOption.ArrayDouble(key, new AtomicReference<>(Optional.empty()));
    }

    static VipsOption.ArrayInt ArrayInt(java.lang.String key, List<Integer> value) {
        return new VipsOption.ArrayInt(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.ArrayInt ArrayInt(java.lang.String key) {
        return new VipsOption.ArrayInt(key, new AtomicReference<>(Optional.empty()));
    }

    static VipsOption.ArrayImage ArrayImage(java.lang.String key, List<VImage> value) {
        return new VipsOption.ArrayImage(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.ArrayImage ArrayImage(java.lang.String key) {
        return new VipsOption.ArrayImage(key, new AtomicReference<>(Optional.empty()));
    }

    static VipsOption.Interpolate Interpolate(java.lang.String key, VInterpolate value) {
        return new VipsOption.Interpolate(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.Interpolate Interpolate(java.lang.String key) {
        return new VipsOption.Interpolate(key, new AtomicReference<>(Optional.empty()));
    }

    static VipsOption.Enum Enum(java.lang.String key, int value) {
        var boxedValue = new VEnum.Raw(value);
        return new VipsOption.Enum(key, new AtomicReference<>(Optional.of(boxedValue)));
    }

    static VipsOption.Enum Enum(java.lang.String key, VEnum value) {
        return new VipsOption.Enum(key, new AtomicReference<>(Optional.of(value)));
    }

    static VipsOption.Enum Enum(java.lang.String key) {
        return new VipsOption.Enum(key, new AtomicReference<>(Optional.empty()));
    }
}