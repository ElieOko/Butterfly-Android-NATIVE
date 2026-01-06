package elieoko.me.butterfly.app.style.application.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey

@Composable
fun Style(key: NavKey?) {
    StyleBody()
}

@Composable
fun StyleBody(){

}

@Composable
@Preview(showBackground = true)
fun StylePreview(){
    Style(null)
}