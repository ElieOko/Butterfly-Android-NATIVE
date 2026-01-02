package elieoko.me.butterfly.view.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.*
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
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
//                        TodoListScreen(
//                            onTodoClick = {
//                                backStack.add(Route.TodoDetail(it))
//                            }
//                        )
                    }
                }
                is Route.Note -> {
                    NavEntry(key) {
//                        TodoDetailScreen(
//                            todo = key.todo
//                        )
                    }
                }
                is Route.NoteEditor ->{ NavEntry(key){}}
                is Route.NoteDetail ->{ NavEntry(key){}}
                is Route.Prayer ->{ NavEntry(key){}}
                is Route.PrayerDetail ->{ NavEntry(key){}}
                is Route.Meditation ->{ NavEntry(key){}}
                is Route.MeditationDetail ->{ NavEntry(key){}}
                is Route.Style ->{ NavEntry(key){}}
                is Route.StyleDetail ->{ NavEntry(key){}}
                else -> error("Unknown NavKey: $key")
            }
        }
    )
}