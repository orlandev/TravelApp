package com.orlandev.travelapp.ui.screens.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.orlandev.travelapp.data.DataResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val city: String? = savedStateHandle["city"]

    val currentCityData = mutableStateOf(DataResult.mock.find { it.city == city })

}