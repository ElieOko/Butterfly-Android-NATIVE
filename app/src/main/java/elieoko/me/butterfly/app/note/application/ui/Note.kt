package elieoko.me.butterfly.app.note.application.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey

@Composable
fun Note(key: NavKey) {
    NoteBody()
}

@Composable
fun NoteBody(){

}

@Composable
@Preview(showBackground = true)
fun NotePreview(){
    Note(it)
}