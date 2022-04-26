package de.stefanbissell.pdfeasyoutline

import java.nio.file.Path
import javax.script.ScriptEngineManager
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 3) {
        printUsage()
    }
    val configPath = args[0].checkExists()
    val inputPath = args[1].checkExists()
    val outputPath = args[2]

    val config = loadConfig(configPath)

    EasyOutliner(inputPath, outputPath)
        .makeOutline(config)
}

private fun loadConfig(path: String): OutlineEntry {
    val script = Path.of(path).toFile().readText()
    val engine = ScriptEngineManager().getEngineByExtension("kts")
    requireNotNull(engine) { "Could not load kts script engine" }
    engine.eval("import de.stefanbissell.pdfeasyoutline.outline\n")
    return engine.eval(script) as OutlineEntry
}

private fun printUsage() {
    println("Usage:")
    println("java -jar pdf-easy-outline-1.0-all.jar <outline-file> <input-file> <output-file>")
    exitProcess(1)
}

private fun String.checkExists(): String {
    if (!Path.of(this).toFile().exists()) {
        println("Could not find $this")
        exitProcess(1)
    }
    return this
}
