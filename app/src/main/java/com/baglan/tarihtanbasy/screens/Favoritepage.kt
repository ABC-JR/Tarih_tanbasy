package com.baglan.tarihtanbasy.screens

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun Favoritepage(context: Context , navController: NavController) {
    val database = FavoriteDatabase(context , null)
    var list  by remember {
        mutableStateOf(database.getAllNotes())
    }
    LazyColumn (modifier = Modifier.padding(top = 82.dp  ,  bottom = 162.dp)) {
        items(list){favorite->
            Mycard(favorite ,context , navController , true)
        }
    }
}