package com.orlandev.travelapp.ui.screens.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.orlandev.travelapp.data.DataResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle
) : ViewModel() {

    val city = stateHandle["city"]

    val dataResult = mutableStateOf(DataResult.mock)

}