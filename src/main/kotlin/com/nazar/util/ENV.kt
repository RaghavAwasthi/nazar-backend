package com.nazar.util

fun getEnvironmentVariable(name:ENVNAME): String {
    return System.getenv(name.key) ?: throw IllegalArgumentException("Environment variable $name is not set")
}

fun getEnvironmentVariableOrNull(name:ENVNAME): String? {
    return System.getenv(name.key)
}


sealed class ENVNAME(var key:String){
    data object CONNECTION_STRING:ENVNAME("MONGO_CONNECTION_STRING")
    data object JWT_SECRET:ENVNAME("JWT_SECRET")
}