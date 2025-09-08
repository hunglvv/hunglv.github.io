package org.testarossa.portfolio.core.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.js.Js
import io.ktor.client.engine.js.JsClient

actual class HttpClientEngineFactory {
    actual fun getHttpEngine(): HttpClientEngine {
        return Js.create()
    }
}