fun main() {
    while(true) {
        print("Enter your name: ")
        val name: String = readln()
        try {
            print("Enter your age (in Digits): ")
            val age: Int = readln().toInt()
            if (age !in 1..99) {
                throw IllegalArgumentException("That is a non existent age. Please Enter Real Age")
            }
            if (age >= 18) {
                println("Hello $name, You are eligible to vote. Proceed to voting booth.")
                vote()
            }else {
                println("$name , You will be eligible after ${subtract(18, age)} years.")
            }
            break
        }catch (_: NumberFormatException) {
            println("Error: Enter Digits Only.")
        }catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
        }
    }
}

fun subtract(a: Int, b: Int): Int {
    return a - b
}

fun vote() {
    while (true) {
        try {
            print("Choose the party you want to vote")
            print("\nMENU:\n--------")
            print("\n1. AJP \n2. FJP \n3. GJP \n4. NOTA\n\nChoose an entry: ")
            when (val party: Int = readln().toInt()) {
                1 -> {println("You voted AJP"); break}
                2 -> {println("You voted FJP"); break}
                3 -> {println("You voted GJP"); break}
                4 -> {println("You voted NOTA"); break}
                else -> println("This choice $party is Invalid")
            }
        }catch (_: NumberFormatException) {
            println("Error: Enter Digits Only.")
        }
    }
}