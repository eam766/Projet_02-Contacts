package com.example.projet_02_contacts.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.projet_02_contacts.ObjectBox
import com.example.projet_02_contacts.modele.Contact
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContactViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(Contact("",
        "", "", "", "", "", ""))
    val uiState: StateFlow<Contact> = _uiState.asStateFlow()

    private var _nom = mutableStateOf("")
    private var _prenom = mutableStateOf("")
    private var _telephone = mutableStateOf("")
    private var _courriel = mutableStateOf("")

    private val myEntityBox = ObjectBox.store.boxFor(Contact::class.java)
    private var _contenu_liste = mutableStateOf(emptyList<Contact>())

    fun updateNom(nom: String){
        _nom.value = nom
    }
    fun updatePrenom(prenom: String){
        _prenom.value = prenom
    }
    fun updateTelephone(telephone: String){
        _telephone.value = telephone
    }
    fun updateCourriel(courriel: String){
        _courriel.value = courriel
    }
    fun getNom(): String{
        return _nom.value
    }
    fun getPrenom(): String{
        return _prenom.value
    }
    fun getTelephone(): String{
        return _telephone.value
    }
    fun getCourriel(): String{
        return _courriel.value
    }
    fun getContenuListe():List<Contact>{
        return _contenu_liste.value
    }
    fun resetNom(){
        _nom.value = ""
    }
    fun resetPrenom(){
        _prenom.value = ""
    }
    fun resetTelephone(){
        _telephone.value = ""
    }
    fun resetCourriel(){
        _courriel.value = ""
    }

    fun add() {
        val newContact = Contact(getNom(), getPrenom(), "", getTelephone(), "", getCourriel(), "")
        myEntityBox.put(newContact)

        //Requete
        val query = myEntityBox
            .query()
            .build()
        _contenu_liste.value = query.find()
        query.close()
        _uiState.value = newContact
    }
}