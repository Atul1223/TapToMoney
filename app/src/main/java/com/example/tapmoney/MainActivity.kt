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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
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
        val moneyCounter = remember {
            mutableStateOf(0)
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFFFFFFF)
        ) {
            //Text(text = "MyApp")
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "${moneyCounter.value}",
                    style = appTextStyle)
                Spacer(modifier = Modifier.height(100.dp))
                CreateCircle(tapCounter = moneyCounter.value) {
                    moneyCounter.value = it+1
                }
            }
        }
    }


    private val appTextStyle =
        TextStyle(
            color = Color.Magenta, fontSize = 48.sp, fontWeight = FontWeight.ExtraBold
        )


    @Composable
    fun CreateCircle(tapCounter: Int = 0, updateCounter:(Int) -> Unit) {
//        var tapCounter by remember {
//            mutableStateOf(0)
//        }
        Card(
            modifier = Modifier
                .padding(3.dp)
                .size(width = 145.dp, height = 145.dp)
                .clickable {
                    //this is a callback function -> trailing lambda
                    updateCounter(tapCounter)
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
                Text(text = "Tap $tapCounter", modifier = Modifier)
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