package vipsffm

object JavadocMarkdownConversion {

    private val startRegex = "[ \\t]*/\\*\\*[ \\t]*\n".toRegex() // /**
    private val endRegex = "[ \\t]*\\*/[ \\t]*\n".toRegex()// */
    private val middleRegex = "([\n^]\\s+)\\*".toRegex() // *

    // attempts to crudely convert a code block from old javadoc style to new markdown style
    fun convert(original: String): String {
        // [whitespace]/**[whitespace] | remove entirely
        // [whitespace]*/[whitespace]  | remove entirely
        // [whitespace]*[whitespace]   | replace with [whitespace]///[single space]

        return original
            .replace(startRegex, "")
            .replace(endRegex, "")
            .replace(middleRegex) { match ->
                val whitespace = match.groups[1]?.value ?: ""
                if (original.contains("need to be told whether to align images on the")) {
                    val x = 1
                }
                return@replace "${whitespace.removeSuffix(" ")}///"
            }
    }
}