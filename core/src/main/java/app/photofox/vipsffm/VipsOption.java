package app.photofox.vipsffm;

import java.lang.foreign.MemorySegment;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public sealed interface VipsOption permits VipsOption.Int, VipsOption.Double, VipsOption.Long, VipsOption.Boolean, VipsOption.String, VipsOption.Image, VipsOption.Source, VipsOption.Target, VipsOption.Blob, VipsOption.ArrayDouble, VipsOption.ArrayInt, VipsOption.ArrayImage {

    java.lang.String key();
    boolean hasValue();

    record Int(java.lang.String key, AtomicReference<Optional<Integer>> box) implements VipsOption {

        public int valueOrThrow() throws VipsError {
            var optionalValue = box.get();
            return optionalValue.orElseThrow(
                () -> new VipsError("unexpected empty value")
            );
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(int value) {
            this.box.set(Optional.of(value));
        }
    }

    record Double(java.lang.String key, AtomicReference<Optional<java.lang.Double>> box) implements VipsOption {

        public double valueOrThrow() throws VipsError {
            var optionalValue = box.get();
            return optionalValue.orElseThrow(
                () -> new VipsError("unexpected empty value")
            );
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(double value) {
            this.box.set(Optional.of(value));
        }
    }

    record Long(java.lang.String key, AtomicReference<Optional<java.lang.Long>> box) implements VipsOption {

        public java.lang.Long valueOrThrow() throws VipsError {
            var optionalValue = box.get();
            return optionalValue.orElseThrow(
                () -> new VipsError("unexpected empty value")
            );
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(java.lang.Long value) {
            this.box.set(Optional.of(value));
        }
    }

    record Boolean(java.lang.String key, AtomicReference<Optional<java.lang.Boolean>> box) implements VipsOption {

        public boolean valueOrThrow() throws VipsError {
            var optionalValue = box.get();
            return optionalValue.orElseThrow(
                () -> new VipsError("unexpected empty value")
            );
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(boolean value) {
            this.box.set(Optional.of(value));
        }
    }

    record String(java.lang.String key, AtomicReference<Optional<java.lang.String>> box) implements VipsOption {

        public java.lang.String valueOrThrow() throws VipsError {
            var optionalValue = box.get();
            return optionalValue.orElseThrow(
                () -> new VipsError("unexpected empty value")
            );
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(java.lang.String value) {
            this.box.set(Optional.of(value));
        }
    }

    record Image(java.lang.String key, AtomicReference<Optional<VImage>> box) implements VipsOption {

        public VImage valueOrThrow() throws VipsError {
            var optionalValue = box.get();
            return optionalValue.orElseThrow(
                () -> new VipsError("unexpected empty value")
            );
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(VImage value) {
            this.box.set(Optional.of(value));
        }
    }

    record Source(java.lang.String key, AtomicReference<Optional<VSource>> box) implements VipsOption {

        public VSource valueOrThrow() throws VipsError {
            var optionalValue = box.get();
            return optionalValue.orElseThrow(
                () -> new VipsError("unexpected empty value")
            );
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(VSource value) {
            this.box.set(Optional.of(value));
        }
    }

    record Target(java.lang.String key, AtomicReference<Optional<VTarget>> box) implements VipsOption {

        public VTarget valueOrThrow() throws VipsError {
            var optionalValue = box.get();
            return optionalValue.orElseThrow(
                () -> new VipsError("unexpected empty value")
            );
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(VTarget value) {
            this.box.set(Optional.of(value));
        }
    }

    record Blob(java.lang.String key, AtomicReference<Optional<VBlob>> box) implements VipsOption {

        public VBlob valueOrThrow() throws VipsError {
            var optionalValue = box.get();
            return optionalValue.orElseThrow(
                () -> new VipsError("unexpected empty value")
            );
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(VBlob value) {
            this.box.set(Optional.of(value));
        }
    }

    record ArrayDouble(java.lang.String key, AtomicReference<Optional<List<java.lang.Double>>> box) implements VipsOption {

        public List<java.lang.Double> valueOrThrow() throws VipsError {
            var optionalValue = box.get();
            return optionalValue.orElseThrow(
                () -> new VipsError("unexpected empty value")
            );
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(List<java.lang.Double> value) {
            this.box.set(Optional.of(value));
        }
    }

    record ArrayInt(java.lang.String key, AtomicReference<Optional<List<Integer>>> box) implements VipsOption {

        public List<Integer> valueOrThrow() throws VipsError {
            var optionalValue = box.get();
            return optionalValue.orElseThrow(
                    () -> new VipsError("unexpected empty value")
            );
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(List<Integer> value) {
            this.box.set(Optional.of(value));
        }
    }

    record ArrayImage(java.lang.String key, AtomicReference<Optional<List<VImage>>> box) implements VipsOption {

        public List<VImage> valueOrThrow() throws VipsError {
            var optionalValue = box.get();
            return optionalValue.orElseThrow(
                () -> new VipsError("unexpected empty value")
            );
        }

        public boolean hasValue() {
            return box.get().isPresent();
        }

        void setValue(List<VImage> value) {
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
}