package de.stefanbissell.pdfeasyoutline

import java.nio.file.Path
import javax.script.ScriptEngineManager

fun main(args: Array<String>) {
    val configPath = args[0]
    val inputPath = args[1]
    val outputPath = args[2]

    val config = loadConfig(configPath)

    EasyOutliner(inputPath, outputPath)
        .makeOutline(config)
}

private fun loadConfig(path: String): OutlineEntry {
    val script = Path.of(path).toFile().readText()
    val engine = ScriptEngineManager().getEngineByExtension("kts")
    engine.eval("import de.stefanbissell.pdfeasyoutline.outline\n")
    return engine.eval(script) as OutlineEntry
}
