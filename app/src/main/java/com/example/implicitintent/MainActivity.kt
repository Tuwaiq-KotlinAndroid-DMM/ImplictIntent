package com.example.implicitintent

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val message:EditText = findViewById(R.id.message_text_field)
        val sendButton: Button = findViewById(R.id.send_button)
        val showMapButton: Button = findViewById(R.id.showmap_button)
        val showContactsButton: Button = findViewById(R.id.showContacts_button)

        sendButton.setOnClickListener(){
            val sendIntent = Intent().apply{
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, message.text.toString())
                type = "text/plain"
            }
            try{
                startActivity(sendIntent)
            }
            catch (e: ActivityNotFoundException)
            {
                // Handle Exception
            }

        }

        showMapButton.setOnClickListener(){
            val gmapsIntentURI = Uri.parse("https://www.google.com/maps/place/Kingdom+Tower/@24.7113877,46.6722064,17z/data=!3m1!4b1!4m5!3m4!1s0x3e2f03280e046f99:0x37737eab160a212!8m2!3d24.7113828!4d46.6743951")

            val mapIntent = Intent(Intent.ACTION_VIEW, gmapsIntentURI)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        showContactsButton.setOnClickListener(){
            val contactsIntent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)

            startActivity(contactsIntent)
        }

//        Implicit Intents LAB
// 1. Make a new android app for the Implicit Intent LAB with name ImplicitIntentLab
// 2. Create an intent to launch the Phone Keypad/ Phone Dialer.
// 3. Pass your cell phone number through an intent to the Phone Dialer.

    }
}