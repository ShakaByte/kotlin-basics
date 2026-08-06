data class StudentDet(val sid: Int, val name: String, val age: Int, val m1: Int, val m2: Int, val m3: Int)

fun main() {
    print("Enter number of Students: ")
    val numStd: Int = readln().toInt()
    val student = mutableListOf<StudentDet>()
    while(true){
        println("-----MENU-----")
        println("1. Add Students \n2. Search Students \n3. Delete Students \n4. Display Students \n5. Average of Student")
        println("6. Filter based on average \n7. Sort by name \n8. List Vacant SIDs' \n9. Exit")
        println("Choose the Operation you want to perform: ")
        val choice = readln().toInt()
        when(choice){
            1 -> repeat(numStd) { addStd(student, student.size + 1) }
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
    }
    println("Total Students: ${student.size}")
}

fun addStd(list: MutableList<StudentDet>,sid: Int){
    print("Enter Name: ")
    val name = readln()
    print("Enter Age: ")
    val age = readln().toInt()
    print("Enter M1: ")
    val m1 = readln().toInt()
    print("Enter M2: ")
    val m2 = readln().toInt()
    print("Enter M3: ")
    val m3 = readln().toInt()
    list.add(StudentDet(sid, name, age, m1, m2, m3))
}

fun display(students: MutableList<StudentDet>){
    println("| %-3s | %-10s | %-3s | %-4s | %-4s | %-4s |".format("SID", "Name", "Age", "M1", "M2", "M3"))
    students.forEach{
        println("| %-3d | %-10s | %-3d | %-4d | %-4d | %-4d |".format(it.sid, it.name, it.age, it.m1, it.m2, it.m3))
    }
}

fun deleteStd(students: MutableList<StudentDet>){
    print("Enter the SID of the student to be deleted: ")
    val sid: Int = readln().toInt()
    val result = (students.find { it.sid == sid })
    if (result != null){
        println("Removed $result")
        students.remove(result)
    }else{
        println("Student not found")
    }
}

fun search(students: MutableList<StudentDet>){
    print("Enter the SID of the student to be searched: ")
    val sid: Int = readln().toInt()
    println(students.find { it.sid == sid })
}

fun stdAverage(students: MutableList<StudentDet>) {
    print("Enter the SID of the student to be avg: ")
    val sid: Int = readln().toInt()
    val result = students.find { it.sid == sid }
    if (result != null) {
        println(result)
        val average = (result.m1 + result.m2 + result.m3) / 3.0
        println(average)
    } else {
        println("No student found with that ID.")
    }
}

fun StudentDet.averageGrade(): Double {
    return (m1 + m2 + m3) / 3.0
}

fun filterAvg(students: MutableList<StudentDet>) {
    println("Below or Above: ")
    val choose = readln()
    when (choose) {
        "Below", "below" -> {
            println("Number between 1-100: ")
            val threshold = readln().toInt()
            val averages = students.filter { it.averageGrade() < threshold }.map { Pair(it.sid, it.averageGrade()) }
            println(averages)
        }
        "Above", "above" -> {
            println("Number between 1-100: ")
            val threshold = readln().toInt()
            val averages = students.filter { it.averageGrade() > threshold }.map { Pair(it.sid, it.averageGrade()) }
            println(averages)
        }
        else -> {
            println("Invalid Choice")
        }
    }
}

fun sortNames(students: MutableList<StudentDet>) {
    students.sortBy{ it.name }
    display(students)
}

fun emptySid(students: MutableList<StudentDet>) {
    val existingSids = students.map { it.sid }
    val fullRange = 1..(existingSids.maxOrNull() ?: 0)
    val missingSids = fullRange.filter { it !in existingSids }
    println(missingSids)
}