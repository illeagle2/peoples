package com.example.myfirstapp.data.repository

import com.example.myfirstapp.data.model.people.PeopleModel
import com.example.myfirstapp.data.model.room.RoomModel
import retrofit2.Response

interface Repository {

    suspend fun getPeople(): Response<PeopleModel>

    suspend fun getRoom(): Response<RoomModel>

}