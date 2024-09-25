package example.myapp

import java.lang.Math.PI

enum class Color(val rgb: Int) {
    RED(0xFF0000),  // RGB: Red
    GREEN(0x00FF00), // RGB: Green
    BLUE(0x0000FF)   // RGB: Blue
}

enum class Direction(val degrees: Int) {
    NORTH(0),
    SOUTH(180),
    EAST(90),
    WEST(270)
}

open class Aquarium(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    open val volume: Int
        get() = width * height * length / 1000 
    
    open var shape: String = "rectangle"

    open val water: Double
        get() = volume * 0.9  


    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }
    
    init {
        println("aquarium initializing")
    }

    init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} liters")
    }

    fun printSize() {
        println(shape)
        println("Width: $width cm Length: $length cm Height: $height cm")
        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")
    }
}

class TowerTank(override var height: Int, var diameter: Int) : Aquarium(height = height, width = diameter, length = diameter) {

    override val volume: Int
        get() = (PI * (width / 2) * (length / 2) * height / 1000).toInt()  

    override var shape: String = "cylinder"
    
    override val water: Double
        get() = volume * 0.8 
}


/*
abstract class AquariumFish {
    abstract val color: String
}
*/

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

/* 
abstract class AquariumFish : FishAction {
    abstract val color: String
    override fun eat() = println("yum") // Provide default behavior
}

class Shark : AquariumFish() {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus : AquariumFish() {
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}
*/

// Singleton object for GoldColor
object GoldColor : FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

class Shark : FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus(fishColor: FishColor = GoldColor) : 
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

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
