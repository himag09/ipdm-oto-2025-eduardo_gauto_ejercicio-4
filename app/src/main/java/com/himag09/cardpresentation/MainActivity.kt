package com.himag09.cardpresentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himag09.cardpresentation.ui.theme.CardPresentationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardPresentationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color(0xFFD2E8D4)
                ) { innerPadding ->
                    Presentation(
                        name = stringResource(R.string.name),
                        role = stringResource(R.string.role),
                        phone = stringResource(R.string.phone),
                        socialMedia = stringResource(R.string.social_media),
                        mail = stringResource(R.string.mail),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Presentation(
    name: String,
    role: String,
    phone: String,
    socialMedia: String,
    mail: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        HeaderCard(
            name = name, role = role,
            modifier = Modifier
                .weight(0.4f),
        )
        FootCard(
            phone = phone,
            mail = mail,
            socialMedia = socialMedia,
            modifier = Modifier
        )
    }
}

@Composable
fun HeaderCard(name: String, role: String, modifier: Modifier = Modifier) {
    val androidImage = painterResource(R.drawable.android_logo)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()

    ) {
        Box(
            modifier = Modifier
                .size(115.dp)
                .background(Color(0xFF073042)),
            contentAlignment = Alignment.Center,

            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = androidImage,
                    contentDescription = null,
                    modifier = Modifier.size(105.dp)
                )
            }
        }
        Text(text = name, fontSize = 52.sp)
        Spacer(Modifier.height(8.dp))
        Text(text = role, fontWeight = FontWeight.Bold, color = Color(0xFF3ddc84))
    }
}

@Composable
fun FootCard(
    phone: String, socialMedia: String, mail: String, modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(bottom = 40.dp)
        ) {
            Row() {
                Icon(
                    Icons.Rounded.Call,
                    contentDescription = stringResource(R.string.phone_description),
                    tint = Color(0xFF3ddc84)
                )
                Spacer(Modifier.width(16.dp))
                Text(text = phone)
            }

            Spacer(Modifier.height(8.dp))

            Row() {
                Icon(
                    Icons.Rounded.Share,
                    contentDescription = stringResource(R.string.social_media_description),
                    tint = Color(0xFF3ddc84)
                )
                Spacer(Modifier.width(16.dp))
                Text(text = socialMedia)
            }

            Spacer(Modifier.height(8.dp))

            Row() {
                Icon(
                    Icons.Rounded.Email,
                    contentDescription = stringResource(R.string.email_description),
                    tint = Color(0xFF3ddc84)
                )
                Spacer(Modifier.width(16.dp))
                Text(text = mail)
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPresentationPreview() {
    CardPresentationTheme {
        Presentation(
            name = stringResource(R.string.name),
            role = stringResource(R.string.role),
            phone = stringResource(R.string.phone),
            socialMedia = stringResource(R.string.social_media),
            mail = stringResource(R.string.mail),
        )
    }
}