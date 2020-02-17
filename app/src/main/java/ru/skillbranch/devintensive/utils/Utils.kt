package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.extensions.translate

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?>{
//        TODO FIX ME!!!
        val parts : List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        when(firstName){
              ""," " -> firstName = null
        }

        when(lastName){
            ""," " -> lastName = null
        }


        return Pair(firstName, lastName)
    }

    fun translitaration(payload: String, divider: String = " "): String {
        val words: List<String> = payload.split(" ")
        val transWord = mutableListOf<String>()

        for (word in words){
            transWord.add(translationWord(word))
        }

        return transWord.joinToString(separator = divider)
    }

    private fun translationWord(word: String): String {
        var retWord = ""
        val arrChar = word.toCharArray()
        for (ch in arrChar) {
            retWord += ch.toLowerCase().translate()
        }

        return retWord.capitalize()
    }


    fun toInitials(firstName: String?, lastName: String?): String? {

        var firstName = firstName?.replace(" ","")
        var lastName = lastName?.replace(" ","")


        var end: String? = null
        if (firstName == null && lastName == null){
            end = null
        }else if (firstName == null && lastName != null){
            if (lastName == "") end = null else end = capitalizeFirst(lastName)
        }else if (firstName != null && lastName == null){
            if (firstName == "") end = null else end = capitalizeFirst(firstName)
        }else if (firstName == "" && lastName == ""){
            end = null
        }else if (firstName == "" && lastName != ""){
            end = capitalizeFirst(lastName as String)
        }else if (firstName != "" && lastName == ""){
            end = capitalizeFirst(firstName as String)
        }else if (firstName != "" && lastName != ""){
            end = capitalizeFirst(firstName as String) + capitalizeFirst(lastName as String)
        }

        return end
    }


    fun capitalizeFirst(str: String): String{
        return str[0].toUpperCase().toString()
    }




}