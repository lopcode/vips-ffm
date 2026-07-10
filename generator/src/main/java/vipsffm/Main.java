package vipsffm;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length > 0 && args[0].equals("bootstrap")) {
            ReplaceVipsLoader.main(args);
            return;
        }
        GenerateVipsHelperClass.main(args);
        GenerateVClasses.main(args);
    }
}
