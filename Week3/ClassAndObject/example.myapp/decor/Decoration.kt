package example.myapp.decor

data class Decoration2(val rocks: String, val wood: String, val diver: String)

fun makeDecorations() {
    val decoration = Decoration2("crystal", "wood", "diver")
    println(decoration)  // Prints: Decoration2(rocks=crystal, wood=wood, diver=diver)

    val (rock, wood, diver) = decoration
    println(rock) 
    println(wood)  
    println(diver) 
}
