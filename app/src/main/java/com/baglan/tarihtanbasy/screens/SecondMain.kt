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

val listsecond1 =  listOf(

    NewsItem("https://cf2.ppt-online.org/files2/slide/g/gVML3fNWE48YJ9siCuaOqbyZFKRH7zjn2cBtdm6pk1/slide-1.jpg" ,
        "«Түрік қағанаты»" , "552-603ж" ,
        "https://drive.google.com/file/d/1Kwwu9lRT0bF2zf_cBaqhlbyvgm_N77mo/view?usp=drive_link" ) ,
    NewsItem("https://cf2.ppt-online.org/files2/slide/g/gVML3fNWE48YJ9siCuaOqbyZFKRH7zjn2cBtdm6pk1/slide-1.jpg" ,
        "Батыс түрік және Шығыс Түрік" ,
        "БАТЫС ТҮРІК ҚАҒАНАТЫ 603- 704 " +
                "ШЫҒЫС ТҮРІК ҚАҒАНАТЫ 682- 744" ,
        "https://drive.google.com/file/d/1UGnDE7EEeZF470OluesAHNNCvqjjKhqc/view?usp=drive_link")

    ,
    NewsItem("https://sun9-77.userapi.com/impf/c824410/v824410649/c5e0a/-XZl-7vwTlo.jpg?size=807x404&quality=96&sign=ac9e7a78b0bfe8545eb883ca9930e0c3&type=album" , "«Қарлұқ» " , "Қарлұқ қағанатының құрылуы (756- 940) " ,"https://drive.google.com/file/d/1CEff664kIZtakLsWwO1KURDl4oT42xFF/view?usp=drive_link")
    ,
    NewsItem("https://cf2.ppt-online.org/files2/slide/w/WKCJNVxn5u7QTIH6hlA1Bij2kgvwtFfoz9Z4POYcp/slide-1.jpg" ,
        "«Оғыз» " , "ІХ- Х ғ" +
            "басындағы" +
            "шығармалардан" +
            "кездестіреміз." ,"https://drive.google.com/file/d/1flRV5YjW8mtRK924K9XTRuUf0vu9Th9b/view?usp=drive_link")
    ,
    NewsItem("https://cf.ppt-online.org/files/slide/k/k0tz3JwR6jd1qEFZHmPuApXBSNI5L4C2gvQfUY/slide-22.jpg" ,
        "«Қимақ қағанаты»\n" +
            "«Көне түркі дәуір мәдениеті”" , "VIII- IX ғғ" +

            "Солтүстік- Шығыс" +
            "Қазақстан" +
            "аумағында қимақ" +
            "тайпалар одағы" +
            "қалыптасты." ,"https://drive.google.com/file/d/1jpRl0wcqsAa2zC_m55AektDWBpqHRSgw/view?usp=drive_link")
    ,
    NewsItem("https://th.bing.com/th/id/R.fa00e26adf6e04cdcd79f21497bee98d?rik=jTuXUa0NFoXNQQ&pid=ImgRaw&r=0" ,
        "«Қарахан мемлекеті»" , "Қарахан мемлкеті (942- 1212 жж)" ,"https://drive.google.com/file/d/14tvHQ02R8JkGayH8zRUbLdIyJBEES6mS/view?usp=drive_link")
    ,
    NewsItem("https://th.bing.com/th/id/R.fa00e26adf6e04cdcd79f21497bee98d?rik=jTuXUa0NFoXNQQ&pid=ImgRaw&r=0" ,
        "“Қарақытай”" , "Қарақытай мемлекеті (1128- 1212 жж)" ,"https://drive.google.com/file/d/1oqaHcdvJMzFoVQnrOYDhmKbrkhhcv3bS/view?usp=drive_link")
    ,
    NewsItem("https://cf2.ppt-online.org/files2/slide/y/yQDMVx7ILFjEPow9f81HuChg5RiXa24GJZTktBvdzs/slide-3.jpg" , "«Найман.Керейіт .Жалайырлар»" , "VIII ғ ортасында Ертіс пен Орхон өзендері арасында" +
            "қалыптасқан." ,"https://drive.google.com/file/d/132bVK5W_tAjBzIO_qHREr8zLHISI1F1V/view?usp=drive_link")
    ,
    NewsItem("https://forumcontent.paradoxplaza.com/public/866380/1663558658324.png" , "«Қыпшақ хандығы»" , "Қыпшақ хандығы (ХІ- ХІІІ ғасырдың басы)" ,"https://drive.google.com/file/d/1tDg04MSBp9j_NkI-u-75FXOgBbD0PC8h/view?usp=drive_link")



)
val listsecond2 =  listOf(
    NewsItem("https://th.bing.com/th/id/R.174c2e209683167dcd3a7d2c81f6447d?rik=tRA33vG%2foZUJhA&riu=http%3a%2f%2fsun9-78.userapi.com%2fimpf%2fc631423%2fv631423613%2f4fa13%2fGjP2quA2s9k.jpg%3fsize%3d604x438%26quality%3d96%26sign%3de6051c338e49df34119f48554de28682%26type%3dalbum&ehk=M6TmAGuwDS69NCkB35%2bpsT%2fqNRNtNnnyfiGC%2fPsy8oU%3d&risl=&pid=ImgRaw&r=0" ,
        "«Моңғол империясы»" ,"Темучин шамамен 1155 ж өмірге келді." ,"https://drive.google.com/file/d/1614lKZhu5y2XyMTKuUsRUEP-u5OKlUxt/view?usp=sharing"),
    NewsItem("https://i.ytimg.com/vi/rvLQIRABdNg/maxresdefault.jpg"
        ,"«Ақ Орда»" ,"XIII ғ ортасы- XV ғ басында Шығыс Дешті Қыпшақ аумағында" +
            "Ақ Орда мемлекеті өмір сүрді." ,"https://drive.google.com/file/d/1p7ytFh_Nr95Tg6xFsL3J9v5erohq_15b/view?usp=sharing"),
    NewsItem("https://cf2.ppt-online.org/files2/slide/b/bg8k97XaG23spJ1nOhuQBrYUvxmFZHTWfyIEAeN4Pz/slide-12.jpg" ,"«Моғолстан»" ,"Моғолстан мемлекеті" +
            "XIV ғ ортасы- XVI ғ басы" ,"https://drive.google.com/file/d/1utj_DookY4DS6044z8uw0jwFutBqw-DU/view?usp=sharing"),
    NewsItem("https://th.bing.com/th/id/OIP.NKgiRK7h26pfG6W1ZrK9-gHaEt?rs=1&pid=ImgDetMain" ,"«Әмір Темір»" ,"Әмір Темір 1405 ж Қытайға" +
            "жорыққа жиналған сәтте қайтыс" +
            "болды;" ,"https://drive.google.com/file/d/1DApbQmn2TGJqa0N7mCs0syqRJGhNtdb2/view?usp=sharing"),
    NewsItem("https://i.ytimg.com/vi/b6Q6GrR9LH8/maxresdefault.jpg" ,"«Ноғай ордасы», «Сібір хандығы»" ,"1581- 1583 жж атаман Ермак бастаған орыс казактары" +
            "Іскер қаласы мен Көшімнің иеліктерін басып алды;" ,"https://drive.google.com/file/d/1CB8txtndXULXPNo4DsmUr_FkzSlv9fjr/view?usp=sharing"),

    NewsItem("https://th.bing.com/th/id/OIP.NKgiRK7h26pfG6W1ZrK9-gHaEt?rs=1&pid=ImgDetMain" ,"«Әбілқайыр хандығы»" ,"Әбілқайыр хандығының құрылуы\n" +
            "(1428- 1468 ЖЖ)" ,"https://drive.google.com/file/d/1CB8txtndXULXPNo4DsmUr_FkzSlv9fjr/view?usp=drive_link"),
)
val listsecond3 =  listOf(
    NewsItem("https://th.bing.com/th/id/R.01842e85584c0a34b2dc47c1ee8236d1?rik=QTwcNlWfqh07xg&riu=http%3a%2f%2fsun9-27.userapi.com%2fimpf%2fc604320%2fv604320692%2f26738%2fCj20Vt5HbtU.jpg%3fsize%3d552x375%26quality%3d96%26sign%3d5b15b8fc5f17fffed3def335728fd500%26type%3dalbum&ehk=P7FMEvIAbQATw2DlrnUpl2CZNoVe3Hc%2bAI3dHEhwF9o%3d&risl=&pid=ImgRaw&r=0" ,
        "«Қазақ хандығының құрылуы»" ,"Шу мен Талас" +
            "алқаптарында 1465 ж" +
            "Қазақ хандығы" +
            "жарияланды." ,"https://drive.google.com/file/d/1Jc5B0zRN3e4Nejnt95jmdUcwNYPZnDyW/view?usp=sharing"),
    NewsItem("https://www.google.com/url?sa=i&url=https%3A%2F%2Fsputnik.kz%2F20231111%2Fqazaqtyn-ushinshi-khany--buryndyq-khan-turaly-qyzyqty-derekter-40293339.html&psig=AOvVaw0ZaC2lz0nDmwKQwXhrBSYl&ust=1741195275738000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCNj67b748IsDFQAAAAAdAAAAABAE" ,"“Бұрыныдық хан мен Қасым хан”" ,"Бұрындық хан (1474- 1511)\n Қасым хан(1511-1518)" ,"https://drive.google.com/file/d/1kr5f5jzEzKXOb1Od8lFBbJd-ds9eB4uv/view?usp=sharing"),
    NewsItem("https://e-history.kz/media/upload/4624/2015/08/11/75d5209bf187a524c16ecc283ec5cd98.jpg" ,
        "«Тәуке хан»" ,"Тәуке хан (1680- 1715/18)" ,"https://drive.google.com/file/d/1ryJrPH2toqEWRSTwzzxcHZfghDMpCWhM/view?usp=sharing"),
    NewsItem("https://egemen.kz/article_photo/1552272210_article_b.jpeg?width=1300&height=700" ,"Тәуекел хан" ,"Тәуекел хан (1582- 1598)" ,"https://drive.google.com/file/d/1KYiwzsB8gYcS1gIuAZcSmB6an_udcNsJ/view?usp=sharing"),
    NewsItem("https://qazaqadebieti.kz/wp-content/uploads/2021/06/Esim-han-vvv.jpg" ,"«Есім хан»" ,"Есім хан (1598- 1628)" ,"https://drive.google.com/file/d/1ryJrPH2toqEWRSTwzzxcHZfghDMpCWhM/view?usp=sharing"),
    NewsItem("https://th.bing.com/th/id/OIP.P-3QVsiaj-tVENxv2TdC3QAAAA?rs=1&pid=ImgDetMain" ,"«Жәңгір хан»" ,"Жәңгір хан (1629- 1652)" ,"https://drive.google.com/file/d/1MfqDTDEPab5WpO_pWy85WdTOvHUYXuVP/view?usp=sharing"),
    NewsItem("https://martebe.kz/wp-content/uploads/2018/10/%D1%85%D0%B0%D2%9B%D0%BD%D0%B0%D0%B7%D0%B0%D1%80-%D1%85%D0%B0%D0%BD.jpg" ,"«Хақназар хан»" ,"Хақназар хан 1538 - 1580 " ,"https://drive.google.com/file/d/1up8M4GzD5SH4s91Nfof4TWhRaOyKtOgW/view?usp=sharing"),
    NewsItem("https://th.bing.com/th/id/OIP.Qi4h1g3A9bFSP7B_ZYV2qAHaE8?rs=1&pid=ImgDetMain" ,"«Қазақ қоғамының әлеуметтік құрылымы»" ,"ХҮ- ХҮІ" +
            "ғасырларды ірі" +
            "және ұсақ" +
            "ұлыстардан тұрды." ,"https://drive.google.com/file/d/1mm9of50u33G21VuvtiJlS8UlCoTcFpyG/view?usp=sharing"),
)

val listthird =  listOf(
    NewsItem("https://sun9-24.userapi.com/impf/c630225/v630225491/54d7c/FQsK5gcWt4U.jpg?size=510x340&quality=96&crop=80,0,864,576&sign=311f1ec735d9da79af58fb96ee941b9a&type=album" ,"«Қазақ- жоңғар соғыстары»" ,"1635 ж Батыр қоңтайшы бастаған" +
            "Жоңғар хандығы құрылды;" ,"https://drive.google.com/file/d/1HpHitJ6r2k10KyED4XItDBsdy3Zco3wM/view?usp=sharing"),
    NewsItem("https://www.zharar.com/uploads/posts/2020-01/1580322770_cc68b79cc686da0db3ab5e42efeb5200.jpg" ,"«XVIII ғ басындағы қазақ- орыс қарым- қатынастары»," +
            "«Ресей империясының қазақ хандығын қосып ала" +
            "бастауы»" ,"Қазақ- орыс қарым- қатынастары XVI ғ бастау алады." ,"https://drive.google.com/file/d/15pRv2gng85YQbAcJdgrhnrlvfITYUz62/view?usp=sharing"),
    NewsItem("https://th.bing.com/th/id/R.8f52627b6b9d68a7de1018dc7b4bf51a?rik=7%2b1iZeppt1uVKw&riu=http%3a%2f%2ftestent.ru%2ftarih%2fvel_ludi%2fabilay_han_m.JPG&ehk=d8P6uety76whfZUUNjcgtfVuEbNGOrV52dxeyVBBUvQ%3d&risl=&pid=ImgRaw&r=0" ,"«Абылай хан»" ,"Aбылай хан (1713)- 1781 жж." ,"https://drive.google.com/file/d/1tg-hz1109ChEM6SHnWhj_5aBGoYy0Pua/view?usp=sharing"),
    NewsItem("https://abai.kz/content/uploads/2020/10/photo_69467.jpg" ,"«Сырым датұлы көтерілісі»" ,"«1783- 1797 жж Сырым датұлы көтерілісі»" ,"https://drive.google.com/file/d/1XPtcHh3BuPkiFK0rbpNmdIAMIboJ-Wya/view?usp=sharing"),
    NewsItem("https://cf4.ppt-online.org/files4/slide/e/e3rDamYS0ovAtRNhg1ykpicwPzqBOuKMfFTZ4U/slide-13.jpg" ,"«1822- 1824 жылдардағы патша реформалары»" ,"1822-1824" +
            "жылдары" +
            "патша" +
            "үкіметі" +
            "Орта жүз" +
            "бен Кіші" +
            "жүздегі" +
            "хан" +
            "билігін" +
            "жойды." ,"https://drive.google.com/file/d/1cST45xUNL1z758M38Iumr9iREUxh_VlR/view?usp=sharing"),
    NewsItem("https://th.bing.com/th/id/OIP.u1maYE7yaQhscv_juOmESwAAAA?rs=1&pid=ImgDetMain" ,"«1836 - 1838 жылғы шаруалар көтерілісі»" ,"Отаршылдық қысымынан туындаған жердің" +
            "жетіспеушілігі." ,"https://drive.google.com/file/d/1zjl_ciyLHhWmb5wI6j130Yv1hjEba3L6/view?usp=sharing"),
    NewsItem("https://th.bing.com/th/id/OIP.4AvipZ47WbXdXkjt1yQr9wHaJ3?rs=1&pid=ImgDetMain" ,"«Кенесары Қасымұлы бастаған ұлт- азаттық қоғалыс»" ,"Сұлтан Кенесары 1802 жылы дүниеге келген.\n" +
            "Абылай ханның туған немересі." ,"https://drive.google.com/file/d/1nKYXHanTld-pE2vtf19iUD28iPnjShes/view?usp=sharing"),
    NewsItem("https://www.zharar.com/uploads/posts/2020-01/1580384714_img2-6.jpg" ,"«1867-1868 жылдардағы реформалар»" ,"САЛЫҚ: Қазақстанда\n" +
            "біртұтас «Түтін салығы»" +
            "енгізілді." ,"https://drive.google.com/file/d/1ILDc1lgN12u69qsYS9IF7hoB8f233O_-/view?usp=sharing"),
    NewsItem("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Peterburg%2C_Senate_Square%2C_1825%2C_dec._14.jpg/1200px-Peterburg%2C_Senate_Square%2C_1825%2C_dec._14.jpg" ,"«1867-1868 жылдардағы реформалар»" ,"Қазақ даласында сақталып қалған\n" +
            "сұлтандардың билігі патша үкіметінің\n" +
            "\n" +
            "Қазақстан аймағын тезірек отарлауына кедергі\n" +
            "келтірді." ,"https://drive.google.com/file/d/1ILDc1lgN12u69qsYS9IF7hoB8f233O_-/view?usp=sharing"),
    NewsItem("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Peterburg%2C_Senate_Square%2C_1825%2C_dec._14.jpg/1200px-Peterburg%2C_Senate_Square%2C_1825%2C_dec._14.jpg" ,"«XIX ғасырдың 60- 70 жылдарындағы отарлық" +
            "езгіге қарсы ұлт- азаттық көтеріліс»" ,"1868- 1869 жж" +
            "Орал және Торғай" +
            "облыстарында" ,"https://drive.google.com/file/d/1n6Tp6ssyzeJEEdu9N7x8fiGA6moGChcy/view?usp=sharing"),
    NewsItem("https://e-history.kz/media/upload/ckimages/Z-5Jy1fbtV4.jpg" ,"«Қазақстанның ХХ ғасырдың басындағы\n" +
            "әлеуметтік- экономикалық жағдайы»." ,"1905- 1907 жж бірінші орыс революциясы өтті. Петербургте 1905 жылы 9" +
            "қаңтарда қарусыз жұмысшыларды қырды. Ол" ,"https://drive.google.com/file/d/1BjQ-edK9hZNOIh9_LtmuuW_39srxncTM/view?usp=sharing"),
    NewsItem("https://www.zharar.com/uploads/posts/2020-01/1580384714_img2-6.jpg" ,"«1916 жылғы ұлт- азаттық көтеріліс»." ,"Шаруалардың" +
            "қоныс" +
            "аудартылуы" +
            "Қазақтардың" +
            "құнарлы" +
            "жерлері" +
            "тартып" +
            "алынды" ,"https://drive.google.com/file/d/1QB5hCf-cClIDjjLyWeNRRLit2nDsudES/view?usp=sharing"),
    NewsItem("https://th.bing.com/th/id/OIP.eDPWy8YfoctEtARmE1x0sQHaFi?rs=1&pid=ImgDetMain" ,"«Ресейдегі 1917 жылғы ақпан, қазан" +

            "буржуазиялық- демократиялық" +
            "революциясы»." ,"Әлеуметтік- экономикалық және саяси" +
            "дағдарыс орын алды." ,"https://drive.google.com/file/d/1gkSffte7msoMzUcf1Tifg9PCx5UO4CCa/view?usp=sharing"),
    NewsItem("https://th.bing.com/th/id/OIP.6b3S0IqCCAFQcHMsHeg0RwHaF5?rs=1&pid=ImgDetMain" ,"«Алаш партиясы мен Алаш үкіметі»." ,"1917 жылы желтоқсанда Орынборда ІІ жалпықазақ" +
            "съезі өтіп, «Алаш» атауымен автономия құрылды." ,"https://drive.google.com/file/d/1msMlFl-fXB-ClIBsQzo1Uq3DOnvnemI1/view?usp=sharing"),
    NewsItem("https://th.bing.com/th/id/OIP.bekLkzvZ9859DsUqDhafvAHaE7?w=750&h=499&rs=1&pid=ImgDetMain" ,"«Кеңес одағының саясаттары»" ,"1918 жылы «Әскери коммунизм»" +
            "саясаты қабылданды. РКП- ның 1921 жылы өткен Х\n" +
            "съезінде ЖЭС бағыт алу" +
            "қабылданды." ,"https://drive.google.com/file/d/1iNfbA_UPpRs29-fSv2yegUXxZQg1sUUl/view?usp=sharing"),
    NewsItem("https://api.ust.kz/storage/files/materials/ppt/image/2018/october/d28/1540705671-12.jpeg" ,"«Қазақстандағы ұлттық автономиялар»," ,"1917 жылы қарашада\n" +
            "ІҮ өлкелік" +
            "мұсылмандар съезі" +
            "өтіп Түркістан" +
            "автономиясы" +
            "құрылды." ,"https://drive.google.com/file/d/1WL57alTIYoiawMe1mH848lUZwg2T8BPM/view?usp=sharing"),
    NewsItem("https://present5.com/presentation/219675912_346974158/image-4.jpg" ,"1920- 1930 жылдардағы саяси репрессиялар" ,"1930 жылдар" +
            "КСРО да" +
            "Тоталитарлық," +
            "казармалық" +
            "социализм" +
            "жүйесі орнады." ,"https://drive.google.com/file/d/1rqs__97fVWMLQl3qbq9NHqdNgottc0l9/view?usp=sharing"),
    NewsItem("https://static.islam.kz/uploads/images/UNL/uZE/HV39hIZ7BZ2AB279-lg.jpg" ,"«Ұлы отан соғысы»" ,"1941 жылдың 22 маусымында Германия КСРО аумағына баса- көктеп кіріп," +
            "Ұлы Отан соғысы басталды." ,"https://drive.google.com/file/d/1LywpYe5qSxiM9IWNqzCFeVHWbHx-_I28/view?usp=sharing"),
    NewsItem("https://static.islam.kz/uploads/images/UNL/uZE/HV39hIZ7BZ2AB279-lg.jpg" ,"«Соғыстан кейінгі Қазақ КСР»" ,"ҰОС кейін халықтың тұрмыс жағдайын жақсарту үшін 1947" +
            "жылы азық- түлікті карточкамен өлшеп беру жойылып, ақша\n" +
            "реформасы енгізілді." ,"https://drive.google.com/file/d/1xx7jDd32CHA6o4Wb5Wapo5xtbd6AFWG8/view?usp=sharing"),
    NewsItem("https://tirshilik-tynysy.kz/uploads/posts/2020-12/1608194408_1514780520_article_b.jpeg" ,"«Тәуелсіз Қазақстан республикасы»" ,"1991 ж 16 желтоқсанында ҚР Тәуелсіздігі жөніндегі\n" +
            "Конституциялық Заң қабылданып, ҚР тәуелсіздік күні деп\n" +
            "белгіленді." ,"https://drive.google.com/file/d/1aZZFSQ7IO_U2XlDuKwjm0AdfcI-rtHdG/view?usp=sharing"),
)
val listfirst =  listOf(
    NewsItem("https://museum.satbayev.university/upload/base/2023/12/slide-4.jpg",
        "Энолит және Қола дәуірі" ,
        "Энолит Б.з.б. III- II мың жылдықты қамтиды.Қола дәуірі б.з.б. II- I \n" +
                "МЫҢЖЫЛДЫҚТЫ " ,
        "https://drive.google.com/file/d/1Nz3EvBHU10XrClYRY249WWf9wvG8PiDF/view?usp=drive_link"
    ) ,
    NewsItem("https://th.bing.com/th/id/R.ca6414c669f9fe26018a0428d03de100?rik=e%2bvNzDZDr%2bTNPQ&pid=ImgRaw&r=0",
        "«Темір дәуірі», «Сақ тайпасы»" ,
        "Темір дәуірі б.з.б І мыңжылдық пен б.з. ҮІ ғасырына дейінгі аралықты қамтиды." ,
        "https://drive.google.com/file/d/1MGfYjjdZ6_9ICY4cgCNqYEzMmvQlDJeX/view?usp=drive_link"
    )
     , NewsItem("https://th.bing.com/th/id/R.ae4ea7715ccdad5bbc33fad88d4f97d2?rik=OV497K0MhxA0Hw&riu=http%3a%2f%2fimages.myshared.ru%2f108%2f1412262%2fslide_2.jpg&ehk=Neqc8P6EOURJtGcurMP1xZVPX5zU0COzArAQ7McMZBM%3d&risl=&pid=ImgRaw&r=0" , "Үйсін" ,"Б.з.б. І мың жж соңында Жетісу, Тарбағатай, Тянь- Шань жерінде үйсін тайпасы құрылды. " ,
         "https://drive.google.com/file/d/1hXrQ8Hl2Eo7P0Fb5ECaQ8lX_8BRL-P5n/view?usp=drive_link"
         ) ,
    NewsItem("https://th.bing.com/th/id/R.ae4ea7715ccdad5bbc33fad88d4f97d2?rik=OV497K0MhxA0Hw&riu=http%3a%2f%2fimages.myshared.ru%2f108%2f1412262%2fslide_2.jpg&ehk=Neqc8P6EOURJtGcurMP1xZVPX5zU0COzArAQ7McMZBM%3d&risl=&pid=ImgRaw&r=0" ,
        "Қаңлы" ,
        "б.з.б. ІІ ғ Сырдың орта ағысында күшейді." ,
        "https://drive.google.com/file/d/155HY_SDBi0MEjkEsdFtIusJve1-WY4iS/view?usp=drive_link"
        ) ,
    NewsItem("https://th.bing.com/th/id/R.ae4ea7715ccdad5bbc33fad88d4f97d2?rik=OV497K0MhxA0Hw&riu=http%3a%2f%2fimages.myshared.ru%2f108%2f1412262%2fslide_2.jpg&ehk=Neqc8P6EOURJtGcurMP1xZVPX5zU0COzArAQ7McMZBM%3d&risl=&pid=ImgRaw&r=0" ,
        "«Сармат» " , "Сарматтардың б.з.б. ҮІІІ ғ атауы- савроматтар болған."  ,
        "https://drive.google.com/file/d/11ntiLgNLooGa5YWn2q42MKoinFg-9Dhm/view?usp=drive_link") ,
            NewsItem("https://th.bing.com/th/id/R.ae4ea7715ccdad5bbc33fad88d4f97d2?rik=OV497K0MhxA0Hw&riu=http%3a%2f%2fimages.myshared.ru%2f108%2f1412262%2fslide_2.jpg&ehk=Neqc8P6EOURJtGcurMP1xZVPX5zU0COzArAQ7McMZBM%3d&risl=&pid=ImgRaw&r=0" ,
                "«Ғұн» " ,
                "Б.з.б. ІІІ ғ.соңында Ұлы Даланы " +
                        "мекендеген ғұн тайпасының " +
                        "билігіне Мөде қолбасшы келеді."  ,
    "https://drive.google.com/file/d/1rlw8gOz-40TRUte4_mLnJBxARNRqacFy/view?usp=drive_link")

)



@Composable
fun SecondMain(context: Context , navController: NavController) {
    var list by remember { mutableStateOf(listOf<NewsItem>()) }
    val level = Levelofhistory.level
    if(level == "first"){
        list = listfirst
    }else if( level == "second1"){
        list = listsecond1
    }else if( level == "second2"){
        list = listsecond2
    }else if( level == "second3"){
        list = listsecond3
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





