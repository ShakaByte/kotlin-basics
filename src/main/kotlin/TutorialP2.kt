data class StudentDet(val sid: Int, val name: String, val age: Int, val m1: Int, val m2: Int, val m3: Int)

fun main() {
    val student = mutableListOf<StudentDet>()

    while (true) {
        try {
            println("-----MENU-----")
            println("1. Add Students \n2. Search Students \n3. Delete Students \n4. Display Students \n5. Average of Student")
            println("6. Filter based on average \n7. Sort by name \n8. List Vacant SIDs' \n9. Exit")
            println("Choose the Operation you want to perform: ")
            val choice = readln().toInt()
            when (choice) {
                1 -> {
                    print("Enter number of Students to be added: ")
                    val numStd: Int = readln().toInt()
                    repeat(numStd) { addStd(student, student.size + 1) }
                }

                2 -> search(student)
                3 -> deleteStd(student)
                4 -> display(student)
                5 -> stdAverage(student)
                6 -> filterAvg(student)
                7 -> sortNames(student)
                8 -> emptySid(student)
                9 -> break
                else -> println("Invalid Choice.")
            }
        } catch(_: NumberFormatException){
            println("Please enter a number only")
        }
    }
}

fun addStd(students: MutableList<StudentDet>,sid: Int) {
    try {
        print("Enter Name: ")
        var name = readln()
        while (name.any { it.isDigit() }) {
            println("Enter a valid name: ")
            name = readln()
        }
        print("Enter Age: ")
        val age = readln().toInt()
        print("Enter M1: ")
        val m1 = readln().toInt()
        print("Enter M2: ")
        val m2 = readln().toInt()
        print("Enter M3: ")
        val m3 = readln().toInt()
        students.add(StudentDet(sid, name, age, m1, m2, m3))
    }catch (_: NumberFormatException){
        println("Please enter a number only")
    }
}

fun display(students: MutableList<StudentDet>){
    println("| %-3s | %-10s | %-3s | %-4s | %-4s | %-4s |".format("SID", "Name", "Age", "M1", "M2", "M3"))
    students.forEach{
        println(
            "| %-3d | %-10s | %-3d | %-4d | %-4d | %-4d |".format(
                it.sid,
                it.name,
                it.age,
                it.m1,
                it.m2,
                it.m3
            )
        )
    }
    println("Total Students: ${students.size}")
}

fun deleteStd(students: MutableList<StudentDet>) {
    try {
        print("Enter the SID of the student to be deleted: ")
        val sid: Int = readln().toInt()
        val result = (students.find { it.sid == sid })
        if (result != null) {
            println("Removed $result")
            students.remove(result)
        } else {
            println("Student not found")
        }
    }catch (_: NumberFormatException){
        println("Please enter a number only")
    }
}

fun search(students: MutableList<StudentDet>) {
    try {
        print("Enter the SID of the student to be searched: ")
        val sid: Int = readln().toInt()
        val result = students.find { it.sid == sid }
        if (result != null) {
            println(result)
        } else {
            println("Student not found")
        }
    }catch (_: NumberFormatException){
        println("Please enter a number only")
    }
}

fun stdAverage(students: MutableList<StudentDet>) {
    try {
        print("Enter the SID of the student to be avg: ")
        val sid: Int = readln().toInt()
        val result = students.find { it.sid == sid }
        if (result != null) {
            println("| %-3s | %-10s | %-3s | %-4s | %-4s | %-4s |".format("SID", "Name", "Age", "M1", "M2", "M3"))
            println(
                "| %-3d | %-10s | %-3d | %-4d | %-4d | %-4d |".format(
                    result.sid,
                    result.name,
                    result.age,
                    result.m1,
                    result.m2,
                    result.m3
                )
            )
            val average = (result.m1 + result.m2 + result.m3) / 3.0
            println("Average: %-4.2f".format(average))
        } else {
            println("No student found with that ID.")
        }
    } catch (_: NumberFormatException) {
        println("Please enter a number only")
    }
}

fun StudentDet.averageGrade(): Double {
    return (m1 + m2 + m3) / 3.0
}

fun filterAvg(students: MutableList<StudentDet>) {
    try {
        println("Below or Above: ")
        val choose = readln()
        when (choose) {
            "Below", "below" -> {
                println("Number between 1-100: ")
                val threshold = readln().toInt()
                if (threshold !in 1..100){
                    throw IllegalArgumentException("Threshold must be between 1 and 100")
                }
                val averages = students.filter { it.averageGrade() < threshold }.map { Pair(it.sid, it.averageGrade()) }
                println("| %-4s | %-7s ".format("SID", "Average"))
                averages.forEach { (sid, avg) ->
                    println("| %-4d | %-7.2f |".format(sid, avg))
                }
            }

            "Above", "above" -> {
                println("Number between 1-100: ")
                val threshold = readln().toInt()
                if (threshold !in 1..100){
                    throw IllegalArgumentException("Threshold must be between 1 and 100")
                }
                val averages = students.filter { it.averageGrade() > threshold }.map { Pair(it.sid, it.averageGrade()) }
                println("| %-4s | %-5s ".format("SID", "Avg"))
                averages.forEach { (sid, avg) ->
                    println("| %-4d | %-5.2f |".format(sid, avg))
                }
            }

            else -> {
                println("Invalid Choice. Choose from Above or Below")
            }
        }
    }catch (_: NumberFormatException){
        println("Please enter a number only")
    }catch (e: IllegalArgumentException){
        println(e.message)
    }
}
fun sortNames(students: MutableList<StudentDet>) {
    students.sortBy{ it.name.uppercase() }
    display(students)
}

fun emptySid(students: MutableList<StudentDet>) {
    val existingSids = students.map { it.sid }
    val fullRange = 1..(existingSids.maxOrNull() ?: 0)
    val missingSids = fullRange.filter { it !in existingSids }
    println(missingSids)
}