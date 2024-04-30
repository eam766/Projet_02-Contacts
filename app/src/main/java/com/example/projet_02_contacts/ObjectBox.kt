package com.example.projet_02_contacts

import android.content.Context
import com.example.projet_02_contacts.modele.MyObjectBox
import io.objectbox.BoxStore

object ObjectBox {
    lateinit var store: BoxStore
        private set

    fun init(context: Context){
        store = MyObjectBox.builder()
            .androidContext(context.applicationContext)
            .build()
    }
}