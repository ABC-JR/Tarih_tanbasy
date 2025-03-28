package com.baglan.tarihtanbasy.screens


import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baglan.tarihtanbasy.R
import com.baglan.tarihtanbasy.ui.theme.colorinsta


@Composable
fun Info(context: Context ) {
    Column(modifier = Modifier.fillMaxWidth().
    background(brush = Brush.linearGradient(
        colors = listOf(Color(0xFF5DE0E6), Color(0xFF004AAD)),
        start = androidx.compose.ui.geometry.Offset.Zero,
        end = androidx.compose.ui.geometry.Offset.Infinite))
        .verticalScroll(rememberScrollState())
        .padding(5.dp , top = 100.dp  ,  bottom = 170.dp)

         , horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        val imginsta = R.drawable.instagram
        val imglinkedin =R.drawable.linkedin

        val intentforinsta = Intent(Intent.ACTION_VIEW , Uri.parse("https://www.instagram.com/_abc_jr")).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        val intentforlinkedin = Intent(Intent.ACTION_VIEW , Uri.parse("https://www.linkedin.com/in/baglanbek-aglanbek-593b87335")).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }



        Text(text= "Біз жайлы"
            ,fontFamily = FontFamily(Font(R.font.forum))  ,
            fontSize = 25.sp , modifier = Modifier.padding(top = 5.dp),
            color = Color.White ,
            fontWeight = FontWeight.Bold)
        Image(painterResource(R.drawable.logotarih) , "logo"  ,
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .size(200.dp)
                .padding(8.dp)
            )



        line("Жусупова Гулмира Куракбаевна \n" +
                "76 Жалпы Білім беретін мектептің \nтарих пәні мұғалімі," +
                "\nСанаты: педагог- зерттеуші")



        Text("You can contact the developer here by simply clicking write" ,
             fontFamily = FontFamily(Font(R.font.forum)))
        developerline("instagram @abc" , imginsta , colorinsta , intentforinsta  , context)
        developerline("linkedin"  ,imglinkedin ,Color.Blue , intentforlinkedin , context)
    }
}


@Composable
fun line(text:String){
    Card(modifier =Modifier.padding(5.dp)
        .fillMaxWidth(0.9f),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent) ,
        border = BorderStroke(1.dp , color = Color.White)
    ) {

        Row(modifier = Modifier.padding(5.dp) ,
            horizontalArrangement = Arrangement.SpaceEvenly
            ){
            Image(painterResource(R.drawable.removedoiyu) , "" ,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(20.dp)
                )
            Text(text = text , fontFamily = FontFamily(Font(R.font.yess)) , color = Color.White )
        }

    }
}


@Composable
fun developerline(text:String, image: Int, color:Color , intent: Intent  , context: Context){
    Card(modifier =Modifier.padding(5.dp).clickable {
        context.startActivity(intent)
    }
        .fillMaxWidth(0.5f).height(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp ,color)
    ) {
        Row(modifier = Modifier.padding(5.dp) ,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Image(painterResource(image) ,
                "" ,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(50.dp)
            )

            Text(text = text , fontFamily = FontFamily(Font(R.font.forum)))
        }


    }
}


@Composable
@Preview(showBackground = true)
fun main23(){
    var context = LocalContext.current
    Info(context)
}