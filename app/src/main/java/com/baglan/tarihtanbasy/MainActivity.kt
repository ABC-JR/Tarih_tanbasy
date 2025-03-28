package com.baglan.tarihtanbasy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
//import com.baglan.quizapp.QuizScreen
import com.baglan.tarihtanbasy.screens.Favoritepage
import com.baglan.tarihtanbasy.screens.FullInformation

import com.baglan.tarihtanbasy.screens.Info
import com.baglan.tarihtanbasy.screens.MainScreen

import com.baglan.tarihtanbasy.screens.SecondMain
import com.baglan.tarihtanbasy.screens.testpage
import com.baglan.tarihtanbasy.ui.theme.backcolor
import com.baglan.quizapp.QuizScreen
import kotlinx.coroutines.delay





class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var ispage2sec by  rememberSaveable{mutableStateOf(false)}
            val  navController = rememberNavController()
            val currenroute  = navController.currentBackStackEntryAsState().value?.destination?.route

            val listofbottom = listOf(
                bottomitem("Басты бет"  , R.drawable.home , "home") ,
                bottomitem("Тест"  , R.drawable.test  , "test") ,
                bottomitem("Tаңдаулылар" , R.drawable.fav ,"favorite"),
                bottomitem("back" , R.drawable.back, "toback")
            )
            Scaffold(modifier = Modifier.fillMaxSize().background(brush = Brush.linearGradient(
                colors = listOf(Color(0xFFF4E1C1), Color(0xFFB8860B)),
                start = Offset.Zero,
                end = Offset.Infinite
            )) ,
                topBar = {
                    if(ispage2sec){
                        MyTopAppBar(navController)
                    }

                } ,
                bottomBar = {
                    if(ispage2sec){
                        MyBottomNavigation(listofbottom , currenroute  , navController)
                    }

                }
                ) {
                NavHost(navController , startDestination = "logo"){
                    composable("logo") {
                       Showinglogo2sec(navController)
                        ispage2sec = true

                    }
                    composable("test") {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Brush.linearGradient(
                                    colors = listOf(Color(0xFFF4E1C1), Color(0xFFB8860B)),
                                    start = Offset.Zero,
                                    end = Offset.Infinite
                                ))
                        ) {
                            testpage(this@MainActivity , navController)
                        }

                    }
//                    composable("secondmain") {
//                        Screenfor2(navController)
//                    }
                    composable("home") {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Brush.linearGradient(
                                    colors = listOf(Color(0xFFF4E1C1), Color(0xFFB8860B)),
                                    start = Offset.Zero,
                                    end = Offset.Infinite
                                ))
                        ) {
                            MainScreen(navController)
                        }

                    }
                    composable("allessons") {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Brush.linearGradient(
                                    colors = listOf(Color(0xFFF4E1C1), Color(0xFFB8860B)),
                                    start = Offset.Zero,
                                    end = Offset.Infinite
                                ))
                        ) {
                            SecondMain(this@MainActivity , navController)
                        }

                    }
                    composable("fullinfo") {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Brush.linearGradient(
                                    colors =listOf(Color(0xFFF4E1C1), Color(0xFFB8860B)),
                                    start = Offset.Zero,
                                    end = Offset.Infinite
                                ))
                        ) {
                            FullInformation(this@MainActivity ,navController)
                        }
                    }
                    composable("info") {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Brush.linearGradient(
                                    colors = listOf(Color(0xFFF4E1C1), Color(0xFFB8860B)),
                                    start = Offset.Zero,
                                    end = Offset.Infinite
                                ))
                        ) {
                            Info(this@MainActivity)
                        }

                    }
                    composable("quiz") {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Brush.linearGradient(
                                    colors = listOf(Color(0xFFF4E1C1), Color(0xFFB8860B)),
                                    start = Offset.Zero,
                                    end = Offset.Infinite
                                ))
                        ) {
                            QuizScreen()
                        }

                    }
                    composable("favorite") {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Brush.linearGradient(
                                    colors = listOf(Color(0xFFF4E1C1), Color(0xFFB8860B)),
                                    start = Offset.Zero,
                                    end = Offset.Infinite
                                ))
                        ) {
                            Favoritepage(this@MainActivity , navController)
                        }

                    }
                }
            }
        }
    }


}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navController: NavController) {
    TopAppBar(
        modifier = Modifier.background(color = Color.Transparent),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Tarih",
                            fontFamily = FontFamily(Font(R.font.lora)),
                            fontSize = 35.sp,
                            fontWeight = FontWeight.W800,
                            color = Color.White
                        )
                        Image(
                            painterResource(R.drawable.tas),
                            contentDescription = "tas",
                            modifier = Modifier.size(50.dp)
                        )
                    }

                }
            }
        },
        actions = {
            Image(
                painter = painterResource(R.drawable.info),
                contentDescription = "info",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
                    .clickable {
                        navController.navigate("info")
                    }
            )
        }
    )
}

@Composable
fun MyBottomNavigation(listofbottom: List<bottomitem>, currenroute: String?, navController: NavHostController) {
    NavigationBar (containerColor = Color.Transparent , contentColor = Color.Transparent   , modifier = Modifier.run { border(2.dp , color = Color.Transparent) }){
        listofbottom.forEach { nav->
            NavigationBarItem(
                selected = nav.route == currenroute ,
                onClick = {
                    if(nav.route == "toback"){
                        if (navController.previousBackStackEntry != null) {
                            navController.popBackStack()
                        } else {
                            navController.navigate("home") {
                                popUpTo("home") { inclusive = false }
                            }
                        }
                    }else{
                        navController.navigate(nav.route)
                    }

                } ,
                icon = {
                    Image(painterResource(nav.img) , "imgs" ,
                        contentScale = ContentScale.Inside,
                        modifier = Modifier
                            .size(60.dp)
                            .padding(8.dp))
                } ,
                label = {
                    Text(text = nav.name , fontFamily = FontFamily(Font(R.font.forum)),)
                } ,
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = backcolor,
                    unselectedIconColor = Color.Transparent,
                    unselectedTextColor = Color.Transparent ,
                )
            )
        }

    }
}

@Composable
fun Showinglogo2sec(navController: NavController,) {
    LaunchedEffect(key1 = true) {
        delay(500)

        navController.navigate("home") {
            popUpTo("logo") { inclusive = true }
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.logotarih),
            contentDescription = ""
        )
        Text(
            text = "Tarih tanbasy",
            fontFamily = FontFamily(Font(R.font.lora)),
            fontWeight = FontWeight.Bold
        )
    }
}



data class bottomitem(val name:String, val img: Int, val route:String)


