package elieoko.me.butterfly.app.note.application.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey

@Composable
fun NoteDetail(key: NavKey) {
    NoteDetailBody()
}

@Composable
fun NoteDetailBody(){

}

@Composable
@Preview(showBackground = true)
fun NoteDetailPreview(){
    NoteDetail(it)
}