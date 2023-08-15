package com.farouk.inova_taskk.presentation.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farouk.inova_taskk.common.Resource
import com.farouk.inova_taskk.domin.model.Book
import com.farouk.inova_taskk.domin.usecase.GetDataUseCase
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
 class HomeViewModel @Inject constructor(
     val useCase: GetDataUseCase,
) : ViewModel(){
    private val _booksLiveData = MutableLiveData<Resource<List<Book>>>()
    val booksLiveData = _booksLiveData



     fun fetchBooks() {
        viewModelScope.launch {
            try {
                _booksLiveData.postValue(Resource.Loading())
                val response : List<Book> = useCase()
                _booksLiveData.postValue(Resource.Success(response))
            }catch (t : Throwable){
                _booksLiveData.postValue(Resource.Error(t.message, null))
            }

        }
    }
}