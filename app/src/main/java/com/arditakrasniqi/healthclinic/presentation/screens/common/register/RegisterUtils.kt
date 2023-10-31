package com.arditakrasniqi.healthclinic.presentation.screens.common.register

class RegisterUtils {


    fun registerFormatValidation(email: String, password: String, passwordTwo: String): Int {

        if (email.trim().isNotEmpty()) {

            if (email.length > 5) {

                if (email.contains("@")) {

                    if (password.trim().isNotEmpty() && passwordTwo.trim().isNotEmpty()) {

                        if (password == passwordTwo) {

                            return if (password.length > 7 && passwordTwo.length > 7) {

                                1

                            } else {

                                7
                            }

                        } else {

                            return 6

                        }

                    } else {

                        return 5

                    }


                } else {

                    return 4

                }

            } else {

                return 3

            }


        } else {

            return 2

        }

    }


}