package de.stefanbissell.pdfeasyoutline

fun main() {
    EasyOutliner(
        "Fading_Suns_Worlds_of_the_Realm.pdf",
        "Fading_Suns_Worlds_of_the_Realm_outlined.pdf"
    ).makeOutline(config)
}

val config = outline {
    label = "Fading Suns - Worlds of the Realm"
    entry("Hawkwood Fiefs", 5) {
        entry("Delphi", 8)
        entry("Ravenna", 15)
        entry("Leminkainen", 22)
        entry("Gwynneth", 30)
        entry("Other Holdings", 38)
    }
    entry("al-Malik Fiefs", 39) {
        entry("Criticorum", 41)
        entry("Shaprut", 49)
        entry("Aylon", 58)
        entry("Istakhr", 65)
        entry("Other Holdings", 72)
    }
    entry("Hazat Fiefs", 77) {
        entry("Sutek", 80)
        entry("Aragon", 87)
        entry("Vera Cruz", 95)
        entry("Hira", 102)
        entry("Other Holdings", 109)
    }
    entry("Li Halan Fiefs", 113) {
        entry("Kish", 115)
        entry("Icon", 122)
        entry("Midian", 129)
        entry("Rampart", 137)
        entry("Other Holdings", 144)
    }
    entry("Decados Fiefs", 149) {
        entry("Severus", 151)
        entry("Cadavus", 159)
        entry("Malignatius", 167)
        entry("Cadiz", 175)
        entry("Other Holdings", 183)
    }
    entry("Imperial Fiefs", 185) {
        entry("Byzantium Secundus", 187)
        entry("Tethys", 192)
        entry("Stigmata", 199)
        entry("Nowhere", 201)
    }
    entry("Appendix: d20 System Rules", 208) {
        entry("New Skill Rules", 214)
        entry("Relics", 217)
    }
}
