package elieoko.me.butterfly.app.prayer.application.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey

@Composable
fun PrayerDetail(key: NavKey?) {
    PrayerDetailBody()
}

@Composable
fun PrayerDetailBody(){

}

@Composable
@Preview(showBackground = true)
fun PrayerDetailPreview(){
    PrayerDetail(null)
}