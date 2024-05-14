package com.example.projet_02_contacts.ui.theme

import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.projet_02_contacts.ObjectBox
import com.example.projet_02_contacts.modele.Contact
import com.example.projet_02_contacts.modele.Contact_
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.regex.Pattern

class ContactViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(Contact(0,"",
        "", "", "", "", "", ""))
    val uiState: StateFlow<Contact> = _uiState.asStateFlow()

    private var _nom = mutableStateOf("")
    private var _prenom = mutableStateOf("")
    private var _telephone = mutableStateOf("")
    private var _courriel = mutableStateOf("")
    private var _mobile = mutableStateOf("")
    private var _adresse = mutableStateOf("")
    private var _entreprise = mutableStateOf("")
    private var _id = mutableLongStateOf(0L)

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
    fun updateId(id: Long){
        _id.longValue = id
    }
    fun updateMobile(mobile: String){
        _mobile.value = mobile
    }
    fun updateAdresse(adresse: String){
        _adresse.value = adresse
    }
    fun updateEntreprise(entreprise: String){
        _entreprise.value = entreprise
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
    fun getId(): Long{
        return _id.longValue
    }
    fun getMobile(): String{
        return _mobile.value
    }
    fun getAdresse(): String{
        return _adresse.value
    }
    fun getEntreprise(): String{
        return _entreprise.value
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
    fun resetMobile(){
        _mobile.value = ""
    }
    fun resetAdresse(){
        _adresse.value = ""
    }
    fun resetEntreprise(){
        _entreprise.value = ""
    }

    // Charger les données au démarrage de l'application
    init {
        chargerDonnees()
    }
    //Récupérer toutes les données de la base de données
    private fun chargerDonnees() {
        val query = myEntityBox
            .query()
            .order(Contact_.nom)
            .build()
        _contenu_liste.value = query.find()
        query.close()
    }
    //Supprimer les données de tout les champs
    fun resetAll(){
        resetNom()
        resetPrenom()
        resetCourriel()
        resetTelephone()
        resetMobile()
        resetAdresse()
        resetEntreprise()
    }
    //Ajouter un contact
    fun add() {
        val newContact = Contact(0,getNom(), getPrenom(), getEntreprise(), getTelephone(), getMobile(), getCourriel(), getAdresse())
        myEntityBox.put(newContact)
        //Requete
        val query = myEntityBox
            .query()
            .build()
        _contenu_liste.value = query.find()
        query.close()
        chargerDonnees()
    }
    //Montrer les détails d'un contact
    fun showDetails(contact: Contact){
       // val contactDetails = myEntityBox[contact.id]
        _uiState.value = contact
    }
    //Supprimer un contact
    fun delete(id: Long){
        myEntityBox.remove(id)
        chargerDonnees()
    }
    //Mettre à jour un contact
    fun update(){
        val editContact = Contact(getId(),getNom(), getPrenom(), getEntreprise(), getTelephone(), getMobile(), getCourriel(), getAdresse())
        myEntityBox.put(editContact)
        //Requete
        val query = myEntityBox
            .query()
            .build()
        _contenu_liste.value = query.find()
        query.close()
        _uiState.value = editContact
        chargerDonnees()
    }

}