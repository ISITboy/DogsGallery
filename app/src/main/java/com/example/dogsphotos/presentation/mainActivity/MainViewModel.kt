package com.example.dogsphotos.presentation.mainActivity

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsphotos.presentation.nvgraph.Route
import com.example.domain.model.Message
import com.example.domain.usecases.app_entry.ReadAppEntry
import com.example.domain.usecases.breedsDogs.GetBreedsDogs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val readAppEntry: ReadAppEntry,
    private val getBreedsDogs: GetBreedsDogs
):ViewModel() {
    private val _splashCondition = mutableStateOf(true)
    val splashCondition: State<Boolean> = _splashCondition

    private val _startDestination = mutableStateOf(Route.AppStartNavigation.route)
    val startDestination: State<String> = _startDestination

    private val _listBreedsDogs = mutableStateOf(listOf<Message>())
    val listBreedsDogs : MutableState<List<Message>> = _listBreedsDogs


    init {
        getListBreedsDogs()
        readAppEntry().onEach { shouldStartFromHomeScreen ->
            if(shouldStartFromHomeScreen){
                _startDestination.value = Route.PhotosNavigator.route
            }else{
                _startDestination.value = Route.AppStartNavigation.route
            }
            delay(300)
            _splashCondition.value = false
        }.launchIn(viewModelScope)
    }

    fun getListBreedsDogs() = viewModelScope.launch{
        _listBreedsDogs.value = listOf(getBreedsDogs())
    }
}