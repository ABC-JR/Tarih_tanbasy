package com.baglan.tarihtanbasy.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.baglan.tarihtanbasy.R
import com.baglan.tarihtanbasy.ui.theme.backcolor

@Composable
fun testpage(context: Context, navController: NavController) {
    val listoftest = remember {
        mutableStateOf(
            mapOf(
                "Кіріспе. Ежелгі шығыс тарихы" to 1,
                "Ежелгі Египет тарихы" to 2,
                "Шумер" to 3,
                "Хетт мемлекеті" to 4,
                "Финикия атауы" to 5,
                "Мидия мемлекеті" to 6,
                "Ежелгі Үндістан" to 7,
                "Ежелгі Рим" to 8,
                "Ежелгі Рим 2" to 9,
                "Орта ғасыр кезеңіндегі Азия және Африка елдерінің мәдениеті" to 10,
                "Орта ғасырларындағы Африка қоғамы" to 11,
                "Орта ғасырлардағы Закавказье және Орта Азия" to 12,
                "Орта ғасырлардағы Осман империясы" to 13,
                "Үндістан" to 14,
                "Корея тарихы" to 15,
                "Жапония тарихы" to 16,
                "Қытай тарихы" to 17,
                "Азия және Африка елдерінің ортағасыр тарихының деректік базасы мен тарихнамасы" to 18  ,
                "XX СОҢЫ-XXI Басындағы Азия және Африка елдері" to 19,
                "Бірінші және екінші кейінгі Қиыр Шығыс елдері" to 20,
                "Қазіргі Азия мен Африка елдері" to 21,
                "XVII-XIX ғасырдағы Осман империясы" to 22,
                "XVII-XIX ғасырдағы Иран" to 23,
                "XVII-XIX ғасырлардағы Үндістан" to 24,
                "XVII-XX ғасыр басындағы Қытай" to 25,
                "Шығыс елдерінің жаңа заман тарихи процесі" to 26,
                "Жаңа замандағы Азия және Африка елдері" to 27

            )
        )
    }


    LazyColumn(
        modifier = Modifier
            .padding(top = 100.dp, bottom = 170.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Преобразуем Map в список пар и делим на строки по 2 элемента
        items(listoftest.value.toList().chunked(2)) { rowItems ->
            Row {
                rowItems.forEach { (testname, number) -> // Распаковываем Pair в ключ и значение
                    testcard(testname, context, navController, number)
                }
            }
        }
    }
}

@Composable
fun testcard(name: String, context: Context, navController: NavController, number: Int) {
    Card(
        modifier = Modifier
            .size(150.dp, 150.dp)
            .padding(8.dp)
            .clickable {
                navController.navigate("quiz")
                Whichquiz.level = number
            },
        colors = CardDefaults.cardColors(
            contentColor = Color.Black,
            containerColor = Color.White
        ),
        border = BorderStroke(1.dp, backcolor)
    ) {
        androidx.compose.foundation.layout.Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.forum)),
                fontWeight = FontWeight.W500,
                fontSize = 25.sp

            )
        }
    }
}
