package de.stefanbissell.pdfeasyoutline

fun outline(block: OutlineEntry.() -> Unit) =
    OutlineEntry().apply(block)

class OutlineEntry(
    var label: String = "",
    var page: Int = 1
) {
    val entries = mutableListOf<OutlineEntry>()

    fun entry(label: String, page: Int, block: OutlineEntry.() -> Unit = {}) {
        entries += OutlineEntry(label, page).apply(block)
    }
}
