package cat.itb.m78.exercices.llistaFaltes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.db.Faltes

@Composable
fun LlistaFaltesScreen() {
    val viewModel = viewModel { LlistFaltesViewModel() }
    LlistaEstudiantsScreen(viewModel.faltes.value)
}

@Composable
fun LlistaEstudiantsScreen(faltes: List<Faltes>?) {
    if (faltes == null) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.size(25.dp))
            }
            faltes.forEach { falta ->
                item {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("${falta.id} ${falta.data_}\n")
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                }
            }
            item {
                Spacer(modifier = Modifier.size(75.dp))
            }
        }
    }
}

