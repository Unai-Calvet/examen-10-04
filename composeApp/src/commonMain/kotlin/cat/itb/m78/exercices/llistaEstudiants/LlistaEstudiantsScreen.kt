package cat.itb.m78.exercices.llistaEstudiants

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.itb.m78.exercices.Estudiant
import coil3.compose.AsyncImage

@Composable
fun LlistaEstudiantsScreen() {
    val viewModel = viewModel { LlistaEstudiantsViewModel() }
    LlistaEstudiantsScreen(viewModel.estudiants.value, viewModel::insert)
}

@Composable
fun LlistaEstudiantsScreen(alumnes: List<Estudiant>?, afegirFalta: (Int) -> Unit) {
    if (alumnes == null) {
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
            alumnes.forEach { alumne ->
                item {
                    TextButton(
                        onClick = { afegirFalta(alumne.id) },
                        shape = RoundedCornerShape(0),
                        border = BorderStroke(1.dp, Color.Gray)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("${alumne.name} ${alumne.surnames}\n${alumne.email}\n")
                            AsyncImage(
                                model = alumne.photoLink,
                                contentDescription = "fotoAlumne",
                                modifier = Modifier.size(100.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.size(25.dp))
                }
            }
            item {
                Spacer(modifier = Modifier.size(75.dp))
            }
        }
    }
}