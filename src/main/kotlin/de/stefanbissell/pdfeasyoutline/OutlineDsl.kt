package de.stefanbissell.pdfeasyoutline

fun outline(
    label: String,
    page: Int = 1,
    block: OutlineEntry.() -> Unit
) = OutlineEntry(label, page).apply(block)

class OutlineEntry(
    val label: String,
    val page: Int
) {
    val entries = mutableListOf<OutlineEntry>()

    fun entry(
        label: String,
        page: Int,
        block: OutlineEntry.() -> Unit = {}
    ) {
        entries += OutlineEntry(label, page).apply(block)
    }
}
