package elieoko.me.butterfly.core.network.http.client.ktor

import android.util.Log
import elieoko.me.butterfly.core.network.Remote as Net
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientAndroidBuild(var tokenAccess: String = ""){
    private val timeOut = 15_000L
    val httpClientAndroid = HttpClient(Android) {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    useAlternativeNames = true
                    ignoreUnknownKeys = true
                    encodeDefaults = true
                }
            )
        }
        install(HttpTimeout) {
            requestTimeoutMillis = timeOut
            connectTimeoutMillis = timeOut
            socketTimeoutMillis = timeOut
        }
        install(ResponseObserver) {
            onResponse { response ->
                Log.d("HTTP status:", "${response.status.value}")
            }
        }
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
        if (tokenAccess != ""){
            install(Auth) {
                bearer {
                    loadTokens {
                        BearerTokens(
                            accessToken = tokenAccess,
                            refreshToken = ""
                        )
                    }
                }
            }
        }
        defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
    }
}
class KtorClientAndroid {
    suspend fun postData(route: String, data: Any, token: String = ""): HttpResponse {
        return HttpClientAndroidBuild(token).httpClientAndroid.post {
            url {
                protocol = if (Net.isProd) URLProtocol.HTTPS else URLProtocol.HTTP
                host = if (Net.isProd) Net.hostProd else Net.hostDev
                encodedPath = route
            }
            headers {
                append(HttpHeaders.ContentType, "application/json")
            }
            // Serialize the body
            setBody(data)
        }
    }
    suspend fun getData(route: String, token : String = "", typeToken : String = "Bearer"): HttpResponse {
        return HttpClientAndroidBuild(token).httpClientAndroid.get {
            url {
                protocol = if (Net.isProd) URLProtocol.HTTPS else URLProtocol.HTTP
                host = if (Net.isProd) Net.hostProd else Net.hostDev
                encodedPath = route
            }
            headers {
                append(HttpHeaders.ContentType, "application/json")
            }
        }
    }
}
suspend fun KtorClientAndroid.get(path : String,token : String = "") : HttpResponse = this.getData(path,token)
suspend fun KtorClientAndroid.post(path : String,data : Any,token : String = "") : HttpResponse = this.postData(path,data,token)

suspend fun KtorClientAndroid.delete(){
    //TODO()
}
suspend fun KtorClientAndroid.put(){
    //TODO()
}

