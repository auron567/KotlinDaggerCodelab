package com.example.kotlindagger.viewmodel

import com.example.kotlindagger.model.UserManager
import  com.example.kotlindagger.view.registration.RegistrationActivity
import com.example.kotlindagger.view.registration.enterdetails.EnterDetailsFragment
import com.example.kotlindagger.view.registration.termsandconditions.TermsAndConditionsFragment

/**
 * RegistrationViewModel is the ViewModel that the Registration flow ([RegistrationActivity],
 * [EnterDetailsFragment] and [TermsAndConditionsFragment]) uses to keep user's input data.
 */
class RegistrationViewModel(private val userManager: UserManager) {
    private var username: String? = null
    private var password: String? = null
    private var acceptedTCs: Boolean = false

    fun updateUserData(username: String, password: String) {
        this.username = username
        this.password = password
    }

    fun acceptTCs() {
        acceptedTCs = true
    }

    fun registerUser() {
        assert(username != null)
        assert(password != null)
        assert(acceptedTCs)

        userManager.registerUser(username!!, password!!)
    }
}