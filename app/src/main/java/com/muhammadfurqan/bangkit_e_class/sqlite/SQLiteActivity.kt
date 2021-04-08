package com.muhammadfurqan.bangkit_e_class.sqlite

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.lifecycle.lifecycleScope
import com.muhammadfurqan.bangkit_e_class.R
import com.muhammadfurqan.bangkit_e_class.sqlite.db.MyBookDatabase
import kotlinx.coroutines.launch

class SQLiteActivity : AppCompatActivity() {

    // implement recyclerview to show the book list (only name)
    // the recyclerview data must be updated every time new book added
    // item must have edit function to change the book name
    // item must have delete function to delete book

    private lateinit var etBookName: AppCompatEditText
    private lateinit var btnAdd: AppCompatButton
    private lateinit var btnRead: AppCompatButton

    private val bookDatabase: MyBookDatabase by lazy {
        MyBookDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        etBookName = findViewById(R.id.et_book_name)

        btnAdd = findViewById(R.id.btn_add)
        btnAdd.setOnClickListener {
            onAdd()
        }

        btnRead = findViewById(R.id.btn_read)
        btnRead.setOnClickListener {
            onRead()
        }
    }

    private fun onAdd() {
        val bookName = etBookName.text.toString()
        etBookName.setText("")

        if (bookName.isNotEmpty()) {
            lifecycleScope.launch {
                bookDatabase.addBook(bookName)
            }
        } else {
            Toast.makeText(this, "Please input the book name", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onRead() {
        val bookList = bookDatabase.getAllBooks()
        val stringOfBookList = bookList.joinToString(separator = "\n") {
            "Book ${it.id} is ${it.name}"
        }
        if (stringOfBookList.isEmpty()) {
            Toast.makeText(this, "No Books Available", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, stringOfBookList, Toast.LENGTH_LONG).show()
        }
    }
}