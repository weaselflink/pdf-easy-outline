# pdf-easy-outline

Add an outline to an existing PDF.

## Motivation

Navigating inside a PDF is improved by having an outline (like a table of contents, which is shown
by most PDF readers in a sidebar).

This software uses the excellent (but complicated) [itext7](https://github.com/itext/itext7) library
to achieve this.

## Building the binary

### Requirements

You need to have any Java JDK installed that is version 11 or higher.
The OpenJDK build by [azul](https://www.azul.com/downloads/?package=jdk#download-openjdk) is a good choice.

### On Linux/MacOS:

```
./gradlew clean build
```

### On Windows

```
.\gradlew.bat clean build
```

### Binary location

The binary can be found under `build/libs/pdf-easy-outline-1.0-all.jar`.

## Usage

First create the outline using a text editor. The file should contain Kotlin script
that describes the outline. 

Example:
```
outline("Title of book") {
    entry("Chapter One - Journey", 4) {
        entry("A start", 5)
        entry("An example", 34)
    }
    entry("Chapter Two", 54) {
        entry("Interesting bits", 55)
        entry("Never mind the text", 78)
    }
    entry("Appendix A - Codes", 106)
}
```

Entries can be nested further without any limit (to my knowledge). There are also some more examples
in the `examples` folder.

When you have created the outline file call the program with the following arguments:

```
java -jar pdf-easy-outline-1.0-all.jar <outline-file> <input-file> <output-file>
```

This will take the outline in `outline-file` and the PDF without an outline `input-file` and create a
PDF with an outline in `output-file`.

### Limitations

When used on a PDF that already has an outline, the new outline is added to the existing one.
