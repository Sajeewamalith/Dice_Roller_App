package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
               Surface(
                   modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background
               ) {
                   DiceRollerApp()
               }
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp(){
     DiceWithButtonAndImage(
         modifier = androidx.compose.ui.Modifier
        // .fillMaxSize()
        // .wrapContentSize(Alignment.Center)
     )
}


@Composable
fun DiceWithButtonAndImage(modifier: androidx.compose.ui.Modifier.Companion = androidx.compose.ui.Modifier) {
    var result by remember { mutableIntStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

      Column (modifier = modifier,
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center

      ){
          Image(
              painter = painterResource(imageResource),
              contentDescription = result.toString()
          )



          Button(onClick = { result = (1..6).random() }) {
              Text(stringResource(R.string.roll), fontSize = 24.sp)
          }
      }
}


