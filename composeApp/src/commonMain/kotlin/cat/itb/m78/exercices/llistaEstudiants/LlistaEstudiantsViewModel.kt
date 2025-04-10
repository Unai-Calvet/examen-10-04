package cat.itb.m78.exercices.llistaEstudiants

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.itb.m78.exercices.Estudiant
import cat.itb.m78.exercices.EstudiantsAPI
import cat.itb.m78.exercices.database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock

class LlistaEstudiantsViewModel : ViewModel() {
    val estudiants = mutableStateOf<List<Estudiant>?>(null)

    init {
        viewModelScope.launch(Dispatchers.Default) {
            estudiants.value = EstudiantsAPI.estiadiantsList()
        }
    }

    fun insert(id: Int) {
        val dateTime = Clock.System.now().toString()
        database.faltesQueries.insert(id.toLong(), dateTime)
    }
}