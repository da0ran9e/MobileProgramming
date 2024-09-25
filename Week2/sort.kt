package sort

fun <T> bubbleSort(array: Array<T>, asc: (T, T) -> Boolean) {
    val length = array.size - 1

    for (i in 0..length) {
        var isSwapped = false
        for (j in 1..length - i) {
            if (asc(array[j], array[j - 1])) {
                isSwapped = true
                swapElements(array, j, j - 1)
            }
        }

        if (!isSwapped) break
    }
}

fun <T> swapElements(array: Array<T>, idx1: Int, idx2: Int) {
    array[idx1] = array[idx2].also {
        array[idx2] = array[idx1]
    }
}

fun main() {
    val numbers = arrayOf(15, 88, -2, 1, 13)

    bubbleSort(numbers) { a, b -> a < b }
    println("asc: ${numbers.joinToString()}")

    bubbleSort(numbers) { a, b -> a > b }
    println("des: ${numbers.joinToString()}")
}
