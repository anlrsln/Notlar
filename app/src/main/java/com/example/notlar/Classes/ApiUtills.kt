package com.example.notlar.Classes

import com.example.notlar.Interfaces.NotlarDaoInterface

class ApiUtills {
    companion object{
        val BASE_URL="http://kasimadalan.pe.hu/"

        fun getNotlarDaoInterface():NotlarDaoInterface{
            return RetrofitParser.getClient(BASE_URL).create(NotlarDaoInterface::class.java)
        }
    }
}