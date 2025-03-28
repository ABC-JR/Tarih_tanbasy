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
                "Ғұн" to 1,
                "Қаңлы" to 2,
                "Сармат" to 3,
                "Темір дәуірі және сақ тайпасы" to 4,
                "Үйсіндер" to 5,
                "Энеолит және Қола дәуірі" to 6,
                "Түрік қағанаты" to 7,
                "Түргеш қағанаты" to 8,
                "Оғыз мемлекеті" to 9,
                "Найман.Керей.Жалайыр." to 10,
                "Қыпшақ хандығы" to 11,
                "Қимақ қағанаты" to 12,
                "Қарлұқ қағанаты" to 13,
                "Қарахан мемлекеті" to 14,
                "Қарақытай мемлекеті" to 15,
                "Батыс түрік және Шығыс түрік" to 16,
                "Ноғай Ордасы мен Сібір хандығы" to 17,
                "Моғолстан" to 18,
                "Маңғол империясы" to 19,
                "Әмір темір мен Әбілқайыр хандығы" to 20,
                "Ақ орда" to 21,
                "Хақназар хан" to 22,
                "Тәуке хан" to 23,
                "Тәуекел хан" to 24,
                "Қасым хан мен Бұрындық хан" to 25,
                "Қазақ хандығының құрылуы" to 26,
                "Қазақ қоғамының әлеуметтік құрлымы" to 27,
                "Жәңгір хан" to 28,
                "Есім хан" to 29 ,
                "Әскери коммунизм ЖЭС Индустрияландыру" to 30 ,
                "1822-1824ж. реформалар" to 31 ,
                "1836 1838ж Бөкей ордасындағы көтерліс" to 32 ,
                "1867 1868 ж. реформалар" to 33 ,
                "1916 жылғы ұлт азаттық көтеріліс" to 34 ,
                "1917 ж. революциялар" to 35 ,
                "Абылай хан" to 36 ,
                "Алаш партиясы мен Алаш үкіметі" to 37 ,
                "Кенесары Қасымұлы бастаған көтеріліс" to 38 ,
                "Соғыстан кейінгі ҚАЗ КСР" to 39 ,
                "Соғыстан кейінгі Қазақ КСР экономикалық жағдайы" to 40 ,
                "Сырым Датұлы" to 41 ,
                "Тәуелсіз Қазақстан республикасы" to 42 ,
                "XIX ғ. 60 70 ж. көтерілістер" to 43 ,
                "Қазақстан ұлттық автономиялары" to 44 ,
                "Қазақ орыс қарым қатынасы" to 45 ,
                "Қазақ жоңғар соғысы" to 46 ,
                "Қазақстандықтардың ҰОС қатысуы" to 47 ,
                "Қазақстанның Ресейге қосылуының аяқталуы" to 48 ,
                "Қазақстанның ХХ ғ. басындағы экономикалық жағдайы" to 49 ,
                "Ұжымдастыру саясаты мен Репрессиялар" to 50 ,
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
