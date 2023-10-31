package com.arditakrasniqi.healthclinic.data

data class Credentials(
    var username: String = "",
    var pwd: String = "",
    var remember: Boolean = false
) {
    fun isNotEmpty(): Boolean {
        return username.isNotEmpty() && pwd.isNotEmpty()
    }
}