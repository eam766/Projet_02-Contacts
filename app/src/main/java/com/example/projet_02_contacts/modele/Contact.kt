package com.example.projet_02_contacts.modele

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class Contact(
    @Id
    var id: Long = 0,
    var nom:String,
    var prenom: String,
    var entreprise: String,
    var telephone: String,
    var mobile:String,
    var email: String,
    var adresse: String) {
}