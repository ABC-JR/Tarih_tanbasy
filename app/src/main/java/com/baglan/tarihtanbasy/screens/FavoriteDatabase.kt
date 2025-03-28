package com.baglan.tarihtanbasy.screens

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class FavoriteDatabase(context: Context, factory: SQLiteDatabase.CursorFactory?) :


    SQLiteOpenHelper(context, "app", factory, 1)


{
    var getname = ""
    var getonlyname = ""
    override fun onCreate(db: SQLiteDatabase?) {
        val query = """
            CREATE TABLE favourites (
                url TEXT, 
                title TEXT, 
                description TEXT , 
                txt TEXT
)
        """.trimIndent()
        db?.execSQL(query)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS favourites")
        onCreate(db)
    }
    fun addToFavourites(newsItem: NewsItem) {
        val db = writableDatabase
        val statement = db.compileStatement("INSERT INTO favourites (url, title, description , txt) VALUES (?, ?, ? , ?)")

        statement.bindString(1, newsItem.url)
        statement.bindString(2, newsItem.title)
        statement.bindString(3, newsItem.desc)
        statement.bindString(4, newsItem.pathpdf)

        statement.execute()
        statement.close()
        db.close()
    }

    fun deleteFromFavourites(newsItem: NewsItem) {
        val db = writableDatabase
        val statement = db.compileStatement(
            "DELETE FROM favourites WHERE url = ? AND title = ? AND description = ? AND txt = ?"
        )
        statement.bindString(1, newsItem.url)
        statement.bindString(2, newsItem.title) // исправлено
        statement.bindString(3, newsItem.desc)  // исправлено
        statement.bindString(4, newsItem.pathpdf)
        statement.executeUpdateDelete()
        statement.close()
        db.close()
    }


    fun getAllNotes(): List<NewsItem> {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM favourites", null)
        val notes = mutableListOf<NewsItem>()
        if (cursor.moveToFirst()) {
            do {
                val url = cursor.getString(cursor.getColumnIndexOrThrow("url"))
                val title = cursor.getString(cursor.getColumnIndexOrThrow("title"))
                val desc = cursor.getString(cursor.getColumnIndexOrThrow("description"))
                val txt = cursor.getString(cursor.getColumnIndexOrThrow("txt"))
                notes.add(NewsItem(url.toString(),title , desc , txt))

            } while (cursor.moveToNext())
        }
        cursor.close()
        return notes
    }



}

