package elieoko.me.butterfly.app.meditation.application.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey

@Composable
fun Meditation(key: NavKey?) {
    MeditationBody()
}

@Composable
fun MeditationBody(){

}

@Composable
@Preview(showBackground = true)
fun MeditationPreview(){
    Meditation(null)
}