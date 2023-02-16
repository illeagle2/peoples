package com.example.myfirstapp.ui.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstapp.data.model.room.RoomModel
import com.example.myfirstapp.data.repository.Repository
import com.example.myfirstapp.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _roomList = MutableLiveData<NetworkResult<RoomModel>>()
    val roomList: LiveData<NetworkResult<RoomModel>> = _roomList

//    init {
//        getPeopleList()
//    }

    fun getRoomList() {
        viewModelScope.launch {
            _roomList.value = NetworkResult.Loading()
            val result = repository.getRoom()

            if (result.isSuccessful) {
                _roomList.value = NetworkResult.Success(result.body()!!)
            } else {
                _roomList.value = NetworkResult.Error(result.message())
            }
        }
    }

}