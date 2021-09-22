package com.example.quizapp

object Data {
    const val usr_name: String="name"
    const val score: String="0"
    fun getQues(): ArrayList<Questions> {
        val QuesList=ArrayList<Questions>()
        val q1=Questions(1,
            "1. What is the capital of India?",
            "New Delhi",
        "Kolkata",
        "Mumbai",
        "Chennai",
        1)
        val q2=Questions(2,
        "2. What is the national bird of U.S.A?",
        "Peacock",
        "Kiwi",
        "Bald Eagle",
        "Vulture",
        3)
        val q3=Questions(3,
        "4. What is a group of fishes called?",
        "herd",
        "flock",
        "pride",
        "school",
        4)
        val q4=Questions(4,
        "5. What is lightyear a measurement of?",
        "speed",
        "distance",
        "time",
        "mass",
        2)
        val q5=Questions(5,
        "6. How many Questions were in this quiz?",
        "3",
        "4",
        "5",
        "6",
        3)
        QuesList.add(q1)
        QuesList.add(q2)
        QuesList.add(q3)
        QuesList.add(q4)
        QuesList.add(q5)
        return QuesList
    }
}