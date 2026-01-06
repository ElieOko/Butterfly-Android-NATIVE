package elieoko.me.butterfly.core.ui.components.element

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Start
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import elieoko.me.butterfly.R

@Composable
@Preview(showBackground = true)
fun MCard(){
    Card {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Outlined.Start,null)
            Text("Verse of the day")
            Text("I am the true vine, and my Father is the husbandman.")
            SuggestionChip(
                label = {Text("Jean 15")},
                onClick = {},
                icon = {Icon(painter = painterResource(R.drawable.books), null, modifier = Modifier.size(14.dp))}
            )
        }
    }
}