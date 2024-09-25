package example.myapp

enum class Direction(val degrees: Int) {
    NORTH(0),
    SOUTH(180),
    EAST(90),
    WEST(270)
}

fun buildAquarium() {
    /*
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()

    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    aquarium6.volume = 70
    aquarium6.printSize() 
    */

    // Create a standard Aquarium
    val myAquarium = Aquarium(length = 25, width = 25, height = 40)
    myAquarium.printSize()

    // Create a TowerTank (cylindrical tank)
    val myTower = TowerTank(diameter = 25, height = 45)
    myTower.printSize()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()

    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun main() {
    buildAquarium()
    makeFish()

    val redColor = Color.RED
    println("Color: ${redColor.name}, RGB: ${redColor.rgb}")
    println(Direction.EAST.name)  
    println(Direction.EAST.ordinal) 
    println(Direction.EAST.degrees) 
}
