package de.stefanbissell.pdfeasyoutline

import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfOutline
import com.itextpdf.kernel.pdf.PdfReader
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.kernel.pdf.action.PdfAction
import com.itextpdf.kernel.pdf.navigation.PdfExplicitDestination

class EasyOutliner(
    source: String,
    dest: String
) {

    private val doc = PdfDocument(reader(source), writer(dest))

    fun makeOutline(config: OutlineEntry) {
        doc.getOutlines(true)
            .removeOutline()

        doc.getOutlines(true)
            .also {
                addEntry(it, config)
            }

        doc.close()
    }

    private fun addEntry(outline: PdfOutline, entry: OutlineEntry) {
        outline
            .addGotoPage(entry.label, entry.page)
            .also { inner ->
                entry.entries.forEach {
                    addEntry(inner, it)
                }
            }
    }

    private fun PdfOutline.addGotoPage(label: String, pageNumber: Int): PdfOutline {
        return addOutline(label).also {
            it.addAction(
                PdfAction
                    .createGoTo(
                        PdfExplicitDestination.createFit(doc.getPage(pageNumber))
                    )
            )
        }
    }

    private fun reader(source: String) = PdfReader(source)

    private fun writer(dest: String) = PdfWriter(dest)
}
