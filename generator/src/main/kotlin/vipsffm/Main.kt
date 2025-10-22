package vipsffm

fun main(args: Array<String>) {
    if (args.firstOrNull() == "bootstrap") {
        ReplaceVipsLoader.main(args)
        return
    }
    GenerateVipsHelperClass.main(args)
    GenerateVClasses.main(args)
}