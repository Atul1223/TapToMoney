package com.example.tapmoney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tapmoney.ui.theme.TapMoneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TapMoneyTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
        }
    }
}

    @Composable
    fun MyApp() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFFFFFFF)
        ) {
            //Text(text = "MyApp")
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "$100",
                    style = appTextStyle)
                Spacer(modifier = Modifier.height(100.dp))
                CreateCircle()
            }
        }
    }


    private val appTextStyle =
        TextStyle(
            color = Color.Magenta, fontSize = 48.sp, fontWeight = FontWeight.ExtraBold
        )

    @Preview
    @Composable
    fun CreateCircle() {
        Card(
            modifier = Modifier
                .padding(3.dp)
                .size(width = 145.dp, height = 145.dp)
                .clickable {

                }
                .background(color = Color.Transparent),
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = Color.Cyan),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Tap", modifier = Modifier)
            }
        }
    }

    @Preview
    @Composable
    fun Preview() {
        TapMoneyTheme {
            MyApp()
        }
    }


}