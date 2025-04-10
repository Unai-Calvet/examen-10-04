package cat.itb.m78.exercices

import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object LlistaEstudiantsScreen

    @Serializable
    data object LlistaFaltesScreen
}