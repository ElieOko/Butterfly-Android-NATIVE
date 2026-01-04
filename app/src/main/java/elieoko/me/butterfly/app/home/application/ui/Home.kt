package elieoko.me.butterfly.app.home.application.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey


@Composable
fun Home(key: NavKey) {
    HomeBody()
}

@Composable
fun HomeBody(){
    Column {
        Row {

        }
        Row {

        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomePreview(){
    Home(it)
}