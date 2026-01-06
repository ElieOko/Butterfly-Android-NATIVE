package elieoko.me.butterfly.core.ui.components.element

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import elieoko.me.butterfly.R

@Composable
@Preview(showBackground = true)
fun MCard(){
    Card {
        Column(
            modifier = Modifier.padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Outlined.Start,null)
            Text("Verse of the day")
            Spacer(Modifier.height(10.dp))
            Text("I am the true vine, and my Father is the husbandman.", fontSize = 19.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            SuggestionChip(
                label = {Text("Jean 15")},
                onClick = {},
                icon = {Icon(painter = painterResource(R.drawable.books), null, modifier = Modifier.size(14.dp))}
            )
        }
    }
}