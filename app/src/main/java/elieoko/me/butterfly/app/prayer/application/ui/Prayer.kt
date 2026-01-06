package elieoko.me.butterfly.app.prayer.application.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey

@Composable
fun Prayer(key: NavKey?) {
    PrayerBody()
}

@Composable
fun PrayerBody(){

}

@Composable
@Preview(showBackground = true)
fun PrayerPreview(){
    Prayer(null)
}