package com.example.gatoapp.BarraBusqueda

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gatoapp.DatosAlmacenados.lista
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class SearchViewModel : ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _gatos = MutableStateFlow(lista)
    val gatos = searchQuery
        .debounce(500L)//espera entre toques del teclado
        .onEach { _isSearching.update { true } }
        .combine(_gatos){
            text, gatos ->
            if(text.isBlank()){
                gatos//mostrar los gatos
            } else{
                gatos.filter {
                    it.doesMatchSearchQuery(text)//mostrar contenido filtrado
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),//tiempo de espera para comenzar a buscar
            _gatos.value
        )
    fun onSearchTextChange(text:String){
        _searchQuery.value = text
    }

}