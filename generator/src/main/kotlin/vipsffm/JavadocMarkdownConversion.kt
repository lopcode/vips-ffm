package vipsffm

object JavadocMarkdownConversion {

    private val startRegex = "[ \\t]*/\\*\\*[ \\t]*\n".toRegex() // /**
    private val endRegex = "[ \\t]*\\*/[ \\t]*\n".toRegex()// */
    private val middleRegex = "([ \\t]+)\\*([ \\t]|\n)".toRegex() // *

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
                val end = match.groups[2]?.value?.removeSuffix(" ") ?: ""
                return@replace "${whitespace.removeSuffix(" ")}/// $end"
            }
    }
}