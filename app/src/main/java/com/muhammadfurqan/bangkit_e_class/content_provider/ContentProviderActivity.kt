package com.muhammadfurqan.bangkit_e_class.content_provider

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import com.muhammadfurqan.bangkit_e_class.R


class ContentProviderActivity : AppCompatActivity() {

    private lateinit var btnReadContact: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        btnReadContact = findViewById(R.id.btn_read_contact)
        btnReadContact.setOnClickListener {
            requestContactPermission()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSIONS_REQUEST_READ_CONTACTS -> {
                if (grantResults.isNotEmpty() && grantResults[0] === PackageManager.PERMISSION_GRANTED) {
                    onReadContact()
                } else {
                    Toast.makeText(
                        this,
                        "You have disabled a contacts permission",
                        Toast.LENGTH_LONG
                    ).show()
                }
                return
            }
        }
    }

    private fun onReadContact() {
        val projection = arrayOf(
            ContactsContract.Profile._ID,
            ContactsContract.Profile.DISPLAY_NAME,
            ContactsContract.Profile.HAS_PHONE_NUMBER
        )

        val profileCursor = contentResolver.query(
            ContactsContract.Profile.CONTENT_URI,
            projection,
            null,
            null,
            null
        )

        profileCursor?.apply {
            while (moveToNext()) {
                Toast.makeText(
                    this@ContentProviderActivity,
                    getString(getColumnIndexOrThrow(ContactsContract.Profile.DISPLAY_NAME)),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun requestContactPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.READ_CONTACTS
                )
            ) {
                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder.setTitle("Read Contacts permission")
                builder.setPositiveButton(android.R.string.ok, null)
                builder.setMessage("Please enable access to contacts.")
                builder.setOnDismissListener(DialogInterface.OnDismissListener {
                    requestPermissions(
                        arrayOf(Manifest.permission.READ_CONTACTS),
                        PERMISSIONS_REQUEST_READ_CONTACTS
                    )
                })
                builder.show()
            } else {
                requestPermissions(
                    this, arrayOf(Manifest.permission.READ_CONTACTS),
                    PERMISSIONS_REQUEST_READ_CONTACTS
                )
            }
        } else {
            onReadContact()
        }
    }

    companion object {
        private const val PERMISSIONS_REQUEST_READ_CONTACTS = 101
    }
}