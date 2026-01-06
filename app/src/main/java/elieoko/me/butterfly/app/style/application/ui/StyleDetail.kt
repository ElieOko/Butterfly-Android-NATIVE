package elieoko.me.butterfly.app.style.application.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey

@Composable
fun StyleDetail(key: NavKey?) {
    StyleDetailBody()
}

@Composable
fun StyleDetailBody(){

}

@Composable
@Preview(showBackground = true)
fun StyleDetailPreview(){
    StyleDetail(null)
}