package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(30.dp)
                .verticalScroll(rememberScrollState())
                .weight(2f)


        ) {
            artInterface(
                R.drawable.eclipse,
                R.string.mysterious_name,
                R.string.eclipse
            )

            artInterface(
                R.drawable.hotel_globo,
                R.string.anonymous_artist,
                R.string.hotel_globo
            )

            artInterface(
                R.drawable.hotel_globo_s_view,
                R.string.anonymous_artist,
                R.string.hotel_globo_view
            )

            artInterface(
                R.drawable.happy_night,
                R.string.lucas_henrique,
                R.string.happy_night
            )
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ) {
            Icon(
                painterResource(id = R.drawable.baseline_house_24),
                contentDescription = "favorite button",
                tint = Color.Black
            )
        }
    }

}

@Composable
fun artInterface(
    imgResource : Int,
    artistNameDate : String,
    imgDescription : String
) {
    Image(
        painter = painterResource(imgResource),
        contentDescription = null,
        modifier = Modifier.padding(15.dp)
    )
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
    ){
        Column(
            modifier = Modifier
        ){
            Text(
                text = imgDescription,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 3.dp, top = 3.dp)
            )

            Text(
                text = artistNameDate,
                fontSize = 13.sp,
                modifier = Modifier.padding(start = 3.dp)
            )
        }


        imageButtons(
            modifier = Modifier
        )

    }

    Spacer(
        modifier = Modifier.padding(bottom = 200.dp)
    )
}

@Composable
fun artInterface(
    imgResource : Int,
    artistNameDate : Int,
    imgDescription : Int
) {
    Image(
        painter = painterResource(imgResource),
        contentDescription = null,
        modifier = Modifier.padding(15.dp)
    )
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
    ){
        Column(
            modifier = Modifier
        ){
            Text(
                text = stringResource(imgDescription),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 3.dp, top = 3.dp)
            )

            Text(
                text = stringResource(artistNameDate),
                fontSize = 13.sp,
                modifier = Modifier.padding(start = 3.dp)
            )
        }


        imageButtons(
            modifier = Modifier
        )

    }

    Spacer(
        modifier = Modifier.padding(bottom = 200.dp)
    )
}

@Composable
fun imageButtons(
    modifier : Modifier
){
    var liked by remember { mutableStateOf(false) }
    var likeIcon = R.drawable.baseline_favorite_border_24

    if(liked) {
        likeIcon = R.drawable.baseline_favorite_24
    }
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { liked = !liked },
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ){
            Icon(
                painterResource(id = likeIcon),
                contentDescription = "favorite button",
                tint = Color.Black
            )
        }
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(Color.Transparent)
        ){
            Icon(
                painterResource(id = R.drawable.baseline_share_24),
                contentDescription = "share button",
                tint = Color.Black
            )
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ArtSpacePreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}