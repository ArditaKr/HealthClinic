package com.arditakrasniqi.healthclinic.presentation.screens.common.login

class LoginUtils {
    fun loginFormatValidation(email: String, password: String): Int {
        if (email.trim().isEmpty()) {
            return 2 // Invalid email
        }

        if (email.length <= 5) {
            return 3 // Email length is too short
        }

        if (!email.contains("@")) {
            return 4 // Email does not contain '@'
        }

        if (password.trim().isEmpty()) {
            return 5 // Password is empty
        }

        return 1 // Valid login
    }
}
