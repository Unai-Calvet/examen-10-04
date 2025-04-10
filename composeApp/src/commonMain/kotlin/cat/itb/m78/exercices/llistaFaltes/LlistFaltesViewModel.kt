package cat.itb.m78.exercices.llistaFaltes

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.itb.m78.exercices.database
import cat.itb.m78.exercices.db.Faltes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LlistFaltesViewModel : ViewModel() {
    val faltes = mutableStateOf<List<Faltes>?>(null)

    init {
        viewModelScope.launch {
            withContext(Dispatchers.Default){
                faltes.value = database.faltesQueries.selectAll().executeAsList()
            }
            // do after insert
        }
    }

}