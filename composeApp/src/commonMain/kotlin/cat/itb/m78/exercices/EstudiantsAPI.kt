package cat.itb.m78.exercices

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Estudiant(
    val id: Int,
    val name: String,
    val surnames: String,
    val email: String,
    @SerialName("photo_link") val photoLink: String
)

object EstudiantsAPI {
    private const val URL = "https://fp.mateuyabar.com/DAM-M78/composeP2/exam/students.json"
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun estiadiantsList() = client.get(URL).body<List<Estudiant>>()
}