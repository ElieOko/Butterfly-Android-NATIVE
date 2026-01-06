package elieoko.me.butterfly.app.meditation.application.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey

@Composable
fun MeditationDetail(key: NavKey?) {
    MeditationDetailBody()
}

@Composable
fun MeditationDetailBody(){

}

@Composable
@Preview(showBackground = true)
fun MeditationDetailPreview(){
    MeditationDetail(null)
}