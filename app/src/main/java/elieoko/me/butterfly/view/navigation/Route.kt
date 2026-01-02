package elieoko.me.butterfly.view.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route{

    @Serializable
    data object Home : Route, NavKey

    @Serializable
    data object Note : Route, NavKey
    @Serializable
    data object NoteEditor : Route, NavKey
    @Serializable
    data class NoteDetail(val note : String) : Route, NavKey

    @Serializable
    data object Prayer : Route, NavKey
    @Serializable
    data class PrayerDetail(val prayer : String) : Route, NavKey

    @Serializable
    data object Meditation : Route, NavKey
    @Serializable
    data class MeditationDetail(val meditation : String) : Route, NavKey

    @Serializable
    data object Style : Route, NavKey
    @Serializable
    data object StyleDetail : Route, NavKey
}