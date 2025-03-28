package com.baglan.tarihtanbasy.screens

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.baglan.tarihtanbasy.R

val listsecond =  listOf(
    NewsItem( "https://yandex-images.clstorage.net/m5ivs4121/728178oWi/kQ9Xx3yDM4e8k7EQwomIUtMVzIDn_pbtoQLGZ7UxoFbYuI8Z7sfwDljccl5bDkRKl8w-0Rna6QGeCzeHA4Ld19FGMspNmj_6wdKdTZKphEbbYLmMo4_-_NVrzxbYJahruL3b_EMeKefFIK-vk7Ohf9vxc5Vo-tFkLvtX1z6bjKYFE_cnbPPyN9zjYHxyBSCO49T4gNuPpgjhNgeaYNAskgW8j0wb8s0nZbSnvx8jvd9HCTuNoR4xVPKe0wcuH-TeBQtnCxALdgu8q1js8gEojnPgQABfJ_Lw4ZJrttT0HPqtqMdAiwY9X5n8w08Xy0mPC81zHeFiPZDOWhMznu-AwpljxwfoB1rnWGtw8Ho59P7j7BysM2sC3Enqc9q4MAxmRXQb3FcibS-xiMuPXxMVs8-Fy5UVfknYHjq3XzoTmMYR00O7cOMer2i3KCwGQWReS_gwMKfjpmxVeluyBNjQmmlwX8gbJpl7WQS3YyPbqTsfbdOxqYr5JEZGm1eOwwTK9TODC1QbUuOAKyCUDkUsnuPc0CR7h3YolU7fQiRo6P5dHB_YBx7pW2mog48Lky2HG0XzuVnuKTjmknfHlgcseh0TA6NYWxbbhEOwNOq5lKp75CzQ4zcy0FHu-y6o7Nz-Jdh3oP9-BQct2M_X61elM78RJ6WdBj3k9tbLw3J3EL7Bz_OrsMPeg5QfdCz-7dgCr9SgkEMPFmTR_l-O0Izc8okwD2hfRqEjGZT7W88PCUPz_VuF3V7FtOo286cuszSCiV8XzxBr4hPML0gQsp3UBh9wTBwTf8pwxaJHPnCAAArJdHNQryL1Q2EI108nK6XTPwmrQUXmXYiOgmubKp-0XhHTF6_sK7YnnL84pPYtHB7PINi8TxeOqLV6g6oM9FDifSwTJCeGRfd9KFOH14OJf4eVh70BolXEBhoDr9oLPHolvwfHaJviC4SfJPDiUVgSW5AkcHtLvgRNngeavDCY","Орта ғасыр кезеңіндегі Азия және Африка елдерінің мәдениеті",
        "Орта ғасырлардағы Азия және Африка елдерінің мәдениеті" ,
        "https://drive.google.com/file/d/155dpYWbfDPAZPhd9mLmym7Zs0AvUr8i-/view?usp=sharing") ,
    NewsItem("https://yandex-images.clstorage.net/m5ivs4121/728178oWi/kQ9Xx3yDM4e8k7EQwomIUtMVzIDn_pbtoQLGZ7UxoFbYuI8Z7sfwDljccl5bDkRKl8w-0Rna6QGeCzeHA4Ld19FGMspNmj_6wdKdTZKphEbbYLmMo4_-_NVrzxbYJahruL3b_EMeKefFIK-vk7Ohf9vxc5Vo-tFkLvtX1z6bjKYFE_cnbPPyN9zjYHxyBSCO49T4gNuPpgjhNgeaYNAskgW8j0wb8s0nZbSnvx8jvd9HCTuNoR4xVPKe0wcuH-TeBQtnCxALdgu8q1js8gEojnPgQABfJ_Lw4ZJrttT0HPqtqMdAiwY9X5n8w08Xy0mPC81zHeFiPZDOWhMznu-AwpljxwfoB1rnWGtw8Ho59P7j7BysM2sC3Enqc9q4MAxmRXQb3FcibS-xiMuPXxMVs8-Fy5UVfknYHjq3XzoTmMYR00O7cOMer2i3KCwGQWReS_gwMKfjpmxVeluyBNjQmmlwX8gbJpl7WQS3YyPbqTsfbdOxqYr5JEZGm1eOwwTK9TODC1QbUuOAKyCUDkUsnuPc0CR7h3YolU7fQiRo6P5dHB_YBx7pW2mog48Lky2HG0XzuVnuKTjmknfHlgcseh0TA6NYWxbbhEOwNOq5lKp75CzQ4zcy0FHu-y6o7Nz-Jdh3oP9-BQct2M_X61elM78RJ6WdBj3k9tbLw3J3EL7Bz_OrsMPeg5QfdCz-7dgCr9SgkEMPFmTR_l-O0Izc8okwD2hfRqEjGZT7W88PCUPz_VuF3V7FtOo286cuszSCiV8XzxBr4hPML0gQsp3UBh9wTBwTf8pwxaJHPnCAAArJdHNQryL1Q2EI108nK6XTPwmrQUXmXYiOgmubKp-0XhHTF6_sK7YnnL84pPYtHB7PINi8TxeOqLV6g6oM9FDifSwTJCeGRfd9KFOH14OJf4eVh70BolXEBhoDr9oLPHolvwfHaJviC4SfJPDiUVgSW5AkcHtLvgRNngeavDCY" ,"Орта ғасырларындағы Африка қоғамы",
                "Африка құрлығындағы ортағасырлық қоғам құрылымы, әлеуметтік қатынастар және мәдени ерекшеліктер." ,
                "https://drive.google.com/file/d/1U53g2Yj96biBTx6FvOBrF1Ch7wTz3101/view?usp=sharing") ,

NewsItem(
    "https://avatars.mds.yandex.net/i?id=659ae0ff477880e55f742a74dfec3c8bf5921d87-4012489-images-thumbs&n=13" , "Орта ғасырлардағы Закавказье және Орта Азия", "Закавказье мен Орта Азиядағы тарихи оқиғалар, саяси құрылымдар және мәдени байланыстар." ,
    "https://drive.google.com/file/d/1VSPW58gEaXfuY7qoPLLiJJ8yBFvVHCEb/view?usp=sharing"),
NewsItem("https://avatars.mds.yandex.net/i?id=a1e7112b065a9ba4ae3a529d121928a4afc4ae80-5686316-images-thumbs&n=13" ,"Орта ғасырлардағы Осман империясы", "Осман империясының құрылуы, дамуы және оның әлемдік тарихтағы маңызы." ,"https://drive.google.com/file/d/1xJMBSNiP36noS5JoY8vgZHylOWCSsqDK/view?usp=sharing"),

NewsItem("https://avatars.mds.yandex.net/i?id=659ae0ff477880e55f742a74dfec3c8bf5921d87-4012489-images-thumbs&n=13" , "Үндістан", "Орта ғасырлардағы Үндістанның мемлекеттері, экономикасы және мәдениеті." , "https://drive.google.com/file/d/1xJMBSNiP36noS5JoY8vgZHylOWCSsqDK/view?usp=sharing") ,
NewsItem("https://avatars.mds.yandex.net/i?id=c9f4de615baf94ae1e5d9bac661220a2d94b1162-5276390-images-thumbs&n=13" ,"Корея тарихы", "Кореяның ортағасырлық тарихы, басқару жүйесі және мәдени жетістіктері." , "https://drive.google.com/file/d/1VkkSEmILdO27dj-bGC2BWqznTy1cLGl_/view?usp=sharing"),
NewsItem("https://avatars.mds.yandex.net/i?id=b4e349ac7acea4bb2267ba7431ec2675bbb50e7c-5263021-images-thumbs&n=13" , "Жапония тарихы", "Жапонияның орта ғасырлардағы дамуы, феодалдық жүйесі мен жауынгерлік дәстүрлері." , "https://drive.google.com/file/d/1bdgCbamJbynwmOuiTgiT7oiccTiPPyux/view?usp=sharing"),
NewsItem("https://avatars.mds.yandex.net/i?id=180939271d77f108ae9a4cc9c071752a611f5b8d-5273766-images-thumbs&n=13" , "Қытай тарихы", "Ортағасырлық Қытайдың саяси құрылымы, әулеттер билігі және мәдени өрлеуі." , "https://drive.google.com/file/d/1bdgCbamJbynwmOuiTgiT7oiccTiPPyux/view?usp=sharing"),
NewsItem("https://avatars.mds.yandex.net/i?id=48685469c6026fba5958acea4958701785a80953-4755642-images-thumbs&n=13" , "Азия және Африка елдерінің ортағасыр тарихының деректік базасы мен тарихнамасы",
    "Азия мен Африка елдерінің ортағасырлық тарихына қатысты деректер мен зерттеулер." , "https://drive.google.com/file/d/1MB4PNbo8Djm8d2xv6p-4kaDaVQ9Nqvam/view?usp=sharing"),

)


val listthird =  listOf(
    NewsItem("https://avatars.mds.yandex.net/i?id=c8bd968fa649a1bba3c5f707cb6500df094ef54f-5695151-images-thumbs&n=13", "XX СОҢЫ-XXI Басындағы Азия және Африка елдері",
        "XX ғасырдың соңындағы және XXI ғасырдың басындағы Азия мен Африкадағы маңызды оқиғалар."  ,
        "https://drive.google.com/file/d/1HUeTDwz4D8FVL8s2WXplns9tsj0yNidN/view?usp=sharing"),

    NewsItem("https://yandex-images.clstorage.net/m5ivs4121/728178oWi/kQ9Xx3yDM4e8k7EQwomIUtMVzIDn_pbtoQLGZuE0wELEoJsQrtq4ImzYcx5OTwkWjoV64FCHuEjKHl-bH5rh2oVDXtZNmjfywdK1bZKphEbbYLmMo4_-_NVrzxbYJahruL3b_EMeKefFIK-vk7Ohf9vxc5Vo-tFkLvtX1z6bjKYFE_cnbPPyN9zjYHxyBSCO49T4gNuPpgjhNgeaYNAskgW8j0wb8s0nZbSnvx8jvd9HCTuNoR4xVPKe0wcuH-TeBQtnCxALdgu8q1js8gEojnPgQABfJ_Lw4ZJrttT0HPqtqMdAiwY9X5n8w08Xy0mPC81zHeFiPZDOWhMznu-AwpljxwfoB1rnWGtw8Ho59P7j7BysM2sC3Enqc9q4MAxmRXQb3FcibS-xiMuPXxMVs8-Fy5UVfknYHjq3XzoTmMYR00O7cOMer2i3KCwGQWReS_gwMKfjpmxVeluyBNjQmmlwX8gbJpl7WQS3YyPbqTsfbdOxqYr5JEZGm1eOwwTK9TODC1QbUuOAKyCUDkUsnuPc0CR7h3YolU7fQiRo6P5dHB_YBx7pW2mog48Lky2HG0XzuVnuKTjmknfHlgcseh0TA6NYWxbbhEOwNOq5lKp75CzQ4zcy0FHu-y6o7Nz-Jdh3oP9-BQct2M_X61elM78RJ6WdBj3k9tbLw3J3EL7Bz_OrsMPeg5QfdCz-7dgCr9SgkEMPFmTR_l-O0Izc8okwD2hfRqEjGZT7W88PCUPz_VuF3V7FtOo286cuszSCiV8XzxBr4hPML0gQsp3UBh9wTBwTf8pwxaJHPnCAAArJdHNQryL1Q2EI108nK6XTPwmrQUXmXYiOgmubKp-0XhHTF6_sK7YnnL84pPYtHB7PINi8TxeOqLV6g6oM9FDifSwTJCeGRfd9KFOH14OJf4eVh70BolXEBhoDr9oLPHolvwfHaJviC4SfJPDiUVgSW5AkcHtLvgRNngeavDCY", "Бірінші және екінші кейінгі Қиыр Шығыс елдері", "Бірінші және екінші Қиыр Шығыс қақтығыстарының елдерге әсері." ,
        "https://drive.google.com/file/d/1yCnDEUuPUzVz-WNvniSCBZ0pJm5eTAC7/view?usp=sharing"),

    NewsItem("https://avatars.mds.yandex.net/i?id=535e721eec293a39b3acd6fe4d4d1efa33c9c41f-5013948-images-thumbs&n=13",
        "Қазіргі Азия мен Африка елдері", "Қазіргі заманғы Азия және Африка елдерінің экономикалық және саяси жағдайы." ,
        "https://drive.google.com/file/d/1cirjPnmN6M0cO0ndMW-OrthY6vgHslGk/view?usp=sharing"),

    NewsItem("https://avatars.mds.yandex.net/i?id=769e8122df1d145d82e97f2956476a026e991e96-8794956-images-thumbs&n=13", "XVII-XIX ғасырдағы Осман империясы", "XVII-XIX ғасырлардағы Осман империясының саяси және әлеуметтік дамуы." ,
        "https://drive.google.com/file/d/1Glm8G9jeaiwllMnEjXlVQ6CHuwIYcRnn/view?usp=sharing"),

    NewsItem("https://avatars.mds.yandex.net/i?id=23e23dd09b9266472f1b0c40b5a15bf61caaf538-9068343-images-thumbs&n=13", "XVII-XIX ғасырдағы Иран", "XVII-XIX ғасырлардағы Ирандағы маңызды тарихи өзгерістер мен реформалар." ,
        "https://drive.google.com/file/d/1HSivjtJlHY0PEBQY-9OzPZSsDpuxlwc3/view?usp=sharing"),

    NewsItem("https://avatars.mds.yandex.net/i?id=952291bf02a30df519fbb7b3bf0c5348576415ed-4598782-images-thumbs&n=13", "XVII-XIX ғасырлардағы Үндістан", "XVII-XIX ғасырлардағы Үндістанның саяси және экономикалық дамуы." ,
        "https://drive.google.com/file/d/1BET1MTnKQZ_WZ3Sfl_kt8dtesDrbZ1qg/view?usp=sharing"),

    NewsItem("https://avatars.mds.yandex.net/i?id=eb41384b18a987ff0e126758bdf8c362995e95ea-4614822-images-thumbs&n=13", "XVII-XX ғасыр басындағы Қытай", "XVII ғасырдан XX ғасырдың басына дейінгі Қытайдың өзгерістері." ,
        "https://drive.google.com/file/d/1uGkdPCubWh3ty7BD0lNAGgLwxPnkR_wm/view?usp=sharing"),

    NewsItem("https://avatars.mds.yandex.net/i?id=727f08917aa57b2950ba89c87d769037d6b9facb-10256045-images-thumbs&n=13", "Шығыс елдерінің жаңа заман тарихи процесі", "Шығыс елдерінің жаңа замандағы тарихи процестері."  ,
        "https://drive.google.com/file/d/1AkowyihWxrsdsu1MQlJ8FLm0EUpkKX0R/view?usp=sharing"),

    NewsItem("https://avatars.mds.yandex.net/i?id=edbdf15460fbdaa0c11cda297d217e5cfbe4c284-13096454-images-thumbs&n=13", "Жаңа замандағы Азия және Африка елдері", "Жаңа замандағы Азия мен Африка елдерінің дамуы мен трансформациясы." ,
        "https://drive.google.com/file/d/1v5p0FIhFZBaMx4MfUq1i4Qxg6zA3OiP6/view?usp=sharing"),

    )
val listfirst =  listOf(
    NewsItem("https://avatars.mds.yandex.net/i?id=bddbab2791bcf6cefccf620f7440e62c_l-5234181-images-thumbs&n=13",
        "ЕЖЕЛГІ ДҮНИЕ\n" +
                "ТАРИХЫНА КІРІСПЕ" ,
        "Ежелгі дүние тарихы – жер бетіндегі ең көне\n" +
                "таптық қоғамдардың, өркениеттердің тарихы." ,
        "https://drive.google.com/file/d/1oItGvZXyFVzl3SB2qdZI90WsRLlQQ_ey/view?usp=sharing"
    ) ,
    NewsItem("https://avatars.mds.yandex.net/i?id=1027cfb4062b7f9cb0f262aee0db70d393b8cad9-5235433-images-thumbs&n=13",
        "Ежелгі Египет" ,
        "\"Егер уақыт машинасы болса, сіз 3000 жыл\n" +
                "бұрынғы Египетке сапар шегер ме едіңіз? Неге?\"" ,
        "https://drive.google.com/file/d/1prlTSuHs13F9sA-O0wR6h7vdmv3hqoMX/view?usp=sharing"
    )
     , NewsItem("https://avatars.mds.yandex.net/i?id=ac2147fbeb154d6871260415361cd6ad27167a31-5365451-images-thumbs&n=13" ,
        " Шумер қала-мемлекеттері Месопотамия тарихы" ,
        "Вельд-Бланделл\n" +
                "призмасы" ,
         "https://drive.google.com/file/d/1prlTSuHs13F9sA-O0wR6h7vdmv3hqoMX/view?usp=sharing"
         ) ,
    NewsItem("https://avatars.mds.yandex.net/i?id=34e00cc532a3348581c0bd634669c7e56558dce3-7458047-images-thumbs&n=13" ,
        "Ертедегі Кіші Азия " +
                "\n" +
                "және Хетт" +
                "\n" +
                "патшалығы" ,
        "Кіші Азиядағы хеттерге дейінгі дәуір Қазіргі\n" +
                "Түркияның азиялық бөлігі – Анатолия\n" +
                "түбегі,." ,
        "https://drive.google.com/file/d/1_rpJqctCWk9yvQ9hepUYv4mp4U0dIzPK/view?usp=sharing"
        ) ,
    NewsItem("https://avatars.mds.yandex.net/i?id=2f304a4ebe9cf4394b39639fbafe5bf83831141d-4578267-images-thumbs&n=13" ,
        "Б.З.Д. ІІІ-ІІ МЫҢЖЫЛДЫҚТАРДАҒЫ " ,
        "Сирия, Финикия және Палестина"  ,
        "https://drive.google.com/file/d/1_rpJqctCWk9yvQ9hepUYv4mp4U0dIzPK/view?usp=sharing") ,

            NewsItem(
                "https://avatars.mds.yandex.net/i?id=992a5037abb76953f2e8f5e1e44ca4e5b0f73ddc-7450098-images-thumbs&n=13" ,
                "Мидиялық және Ахеменидтік\n" +
                        "дәуірдегі " ,
                "Иран"  ,
    "https://drive.google.com/file/d/1BvoJNfKsbUb7pEWKv9lINhQmGJDV11jF/view?usp=sharing") ,
    NewsItem("https://avatars.mds.yandex.net/i?id=531b4597511a5ca5acfbd63d7be35f00b6eaa53f-10931100-images-thumbs&n=13" , "Е Ж Е Л Г І  Ү Н Д І С Т А Н"  ,
        "Қазіргі Оңтүстік Азияның негізгі халқы үндіеуропалық нәсілге\n" +
                "жатады, алайда Үндістан түбегінің оңтүстігі мен Шри-Ланка\n" +
                "аралының халықтары кейбір нәсілдің белгілері бойынша\n" +
                "австралоидтарға жақын." ,
        "https://drive.google.com/file/d/1UQXEBXvvQdHklVWHLa0CcBFGudZXoHSa/view?usp=sharing"),
    NewsItem("https://avatars.mds.yandex.net/i?id=b199560c64e1467569bcdc202cb70c662a715d68-4503134-images-thumbs&n=13" , "Ежелгі" +
            "Рим"  ,
        "Ежелгі Рим (лат. Roma antiqua) — ерте\n" +
                "заманның бас өркениеттерінің бірі, өз атауын\n" +
                "Ромулдың атымен аталған астанасының есімінен\n" +
                "алды." , "https://drive.google.com/file/d/1pzdJZiKX-5ILNfbXpiWey7dSTJiqNWWL/view?usp=sharing"),
)

@Composable
fun SecondMain(context: Context , navController: NavController) {
    var list by remember { mutableStateOf(listOf<NewsItem>()) }
    val level = Levelofhistory.level
    if(level == "first"){
        list = listfirst
    }else if( level == "second"){
        list = listsecond
    }else if (level == "third"){
        list = listthird
    }


    LazyColumn(modifier = Modifier.padding(5.dp , top = 100.dp , bottom = 130.dp) ) {
        items(list){news->
            Mycard(news , context =context , navController , false)
        }
    }
}



@Composable
fun Mycard(news: NewsItem, context: Context, navController: NavController, isfav:Boolean) {

    val database = FavoriteDatabase(context , null)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
        ,
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp) ,
        onClick = {
            Lessons.level = news
            navController.navigate("fullinfo")
        }
    ) {



        Row(modifier = Modifier.padding(2.dp)) {
            AsyncImage(
                model = news.url,
                contentDescription = "News Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = news.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    maxLines = 2
                    , fontFamily = FontFamily(Font(R.font.forum))
                )
                Text(
                    text = news.desc,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    maxLines = 3
                    , fontFamily = FontFamily(Font(R.font.forum))
                )


                var isFavorite by remember { mutableStateOf(isfav) }

                Icon(
                    painter = painterResource(R.drawable.baseline_favorite_24),
                    contentDescription = "Favorite",
                    tint = if (isFavorite) Color.Red else Color.Gray, // Меняем цвет иконки
                    modifier = Modifier
                        .size(24.dp) // Размер иконки
                        .clickable {
                            isFavorite = !isFavorite // Переключаем состояние
                            if(isFavorite == false){
                                database.deleteFromFavourites(news)

                            }else{
                                database.addToFavourites(news)
                            }

                        }
                )
            }
        }
    }
}



data class NewsItem(
    val url:String ,
    val title:String ,
    val desc :String  ,
    val pathpdf :String
)





