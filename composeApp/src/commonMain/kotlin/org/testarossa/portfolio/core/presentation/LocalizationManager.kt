package org.testarossa.portfolio.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive
import myportfolio.composeapp.generated.resources.Res
import org.testarossa.portfolio.portfolio.presentation.navigation_bar.Language


@Composable
fun rememberStrings(): LocalizationManager {
    val locale by LocalizationManager.locale.collectAsStateWithLifecycle()
    return remember(locale) { LocalizationManager }
}



object LocalizationManager {
    private val json = Json { ignoreUnknownKeys = true }
    private val localeMap = mutableMapOf<String, Map<String, String>>()

    private val _locale = MutableStateFlow(Language.EN)
    val locale = _locale.asStateFlow()

    fun changeLocale(locale: Language) {
        _locale.value = locale
    }
    suspend fun load() {
        Language.entries.forEach { language ->
            val resourcePath = "files/strings_${language.code}.json"
            val bytes = Res.readBytes(resourcePath)
            val json = json.parseToJsonElement(bytes.decodeToString()) as JsonObject
            localeMap[language.code] = json.mapValues { it.value.jsonPrimitive.content }
        }
    }

    fun get(key: String, vararg args: Any?): String {
        val loaded = localeMap.containsKey(_locale.value.code)
        if (!loaded){
            return ""
        }
        val map = localeMap[_locale.value.code]!!
        val template = map[key] ?: key
        return formatTemplate(template, args)
    }

    private fun formatTemplate(template: String, args: Array<out Any?>): String {
        var out = template
        args.forEachIndexed { i, arg ->
            out = out.replace("{$i}", arg?.toString() ?: "")
        }
        return out
    }
}