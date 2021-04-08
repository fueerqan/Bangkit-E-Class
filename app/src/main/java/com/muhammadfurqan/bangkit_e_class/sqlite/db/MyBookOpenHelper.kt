package com.muhammadfurqan.bangkit_e_class.sqlite.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * @author by furqan on 08/04/2021
 */
class MyBookOpenHelper(context: Context) : SQLiteOpenHelper(
    context,
    DB_NAME, null,
    DB_VERSION
) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_BOOK_TABLE = "CREATE TABLE $TABLE_BOOK (" +
                "$FIELD_ID INTEGER PRIMARY KEY, " +
                "$FIELD_NAME TEXT)"
        db.execSQL(CREATE_BOOK_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_BOOK")
        onCreate(db)
    }

    companion object {
        const val DB_NAME = "Book-E.db"
        const val DB_VERSION = 1

        const val TABLE_BOOK = "book"
        const val FIELD_ID = "id"
        const val FIELD_NAME = "name"

    }
}