package elieoko.me.butterfly.view.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.*
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import elieoko.me.butterfly.app.home.application.ui.Home
import elieoko.me.butterfly.app.meditation.application.ui.Meditation
import elieoko.me.butterfly.app.meditation.application.ui.MeditationDetail
import elieoko.me.butterfly.app.note.application.ui.Note
import elieoko.me.butterfly.app.note.application.ui.NoteDetail
import elieoko.me.butterfly.app.prayer.application.ui.Prayer
import elieoko.me.butterfly.app.prayer.application.ui.PrayerDetail
import elieoko.me.butterfly.app.style.application.ui.Style
import elieoko.me.butterfly.app.style.application.ui.StyleDetail
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
){
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Route.Home::class, Route.Home.serializer())
                    subclass(Route.Note::class, Route.Note.serializer())
                    subclass(Route.NoteDetail::class, Route.NoteDetail.serializer())
                    subclass(Route.NoteEditor::class, Route.NoteEditor.serializer())
                    subclass(Route.Prayer::class, Route.Prayer.serializer())
                    subclass(Route.PrayerDetail::class, Route.PrayerDetail.serializer())
                    subclass(Route.Meditation::class, Route.Meditation.serializer())
                    subclass(Route.MeditationDetail::class, Route.MeditationDetail.serializer())
                    subclass(Route.Style::class, Route.Style.serializer())
                    subclass(Route.StyleDetail::class, Route.StyleDetail.serializer())
                }
            }
        },
        Route.Home
    )
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = { key ->
            when(key) {
                is Route.Home -> {
                    NavEntry(key) {
                        Home(it)
//                        TodoListScreen(
//                            onTodoClick = {
//                                backStack.add(Route.TodoDetail(it))
//                            }
//                        )
                    }
                }
                is Route.Note -> {
                    NavEntry(key) {
                        Note(it)
//                        TodoDetailScreen(
//                            todo = key.todo
//                        )
                    }
                }
                is Route.NoteEditor ->{ NavEntry(key){}}
                is Route.NoteDetail ->{ NavEntry(key){ NoteDetail(it) }}
                is Route.Prayer ->{ NavEntry(key){ Prayer(it) }}
                is Route.PrayerDetail ->{ NavEntry(key){ PrayerDetail(it) }}
                is Route.Meditation ->{ NavEntry(key){ Meditation(it) }}
                is Route.MeditationDetail ->{ NavEntry(key){ MeditationDetail(it) }}
                is Route.Style ->{ NavEntry(key){ Style(it) }}
                is Route.StyleDetail ->{ NavEntry(key){ StyleDetail(it) }}
                else -> error("Unknown NavKey: $key")
            }
        }
    )
}