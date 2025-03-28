package com.baglan.tarihtanbasy.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.baglan.tarihtanbasy.R


@Composable
fun MainScreen(navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(
                colors = listOf(Color(0xFF5DE0E6), Color(0xFF004AAD)),
                start = androidx.compose.ui.geometry.Offset.Zero,
                end = androidx.compose.ui.geometry.Offset.Infinite
            )).padding(16.dp)

        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                Levelofhistory.level = "first"
                navController.navigate("allessons")
            },
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent ,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            itemslevel("Eжелгі заман тарихы")
        }

        Button(
            onClick = {
                navController.navigate("secondmain")
            },
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent ,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            itemslevel("Орта заман тарихы")
        }

        Button(
            onClick = {
                Levelofhistory.level = "third"
                navController.navigate("allessons")
            },
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent ,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            itemslevel("Жаңа және Қазіргі заман тарихы")
        }
    }
}





@Composable
fun Screenfor2(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(
                colors = listOf(Color(0xFF5DE0E6), Color(0xFF004AAD)),
                start = androidx.compose.ui.geometry.Offset.Zero,
                end = androidx.compose.ui.geometry.Offset.Infinite
            )).padding(16.dp)

        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                Levelofhistory.level = "second1"
                navController.navigate("allessons")
            },
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent ,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            itemslevel("Түркі кезең")
        }

        Button(
            onClick = {
                Levelofhistory.level = "second2"
                navController.navigate("allessons")
            },
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent ,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            itemslevel("Маңғол кезеңі ")
        }

        Button(
            onClick = {
                Levelofhistory.level = "second3"
                navController.navigate("allessons")
            },
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent ,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            itemslevel("Қазақ хандығы кезеңі")
        }
    }
}
@Composable
fun itemslevel(name:String) {
    Card(
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, color = Color.White),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.removedoiyu),
                contentDescription = "image",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
            )
            Text(
                text = name,
                modifier = Modifier.padding(start = 8.dp)  ,
                fontWeight = FontWeight.Bold ,
                color = Color.White ,
              fontFamily = FontFamily(Font(R.font.forum))

            )
        }
    }
}


