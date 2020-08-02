package com.shalom.marvelogy.utils

import java.security.MessageDigest


fun String.generateMD5Hash(): String {
     return MessageDigest
        .getInstance("MD5")
        .digest(this.toByteArray()).toHex()

}

fun ByteArray.toHex(): String {
    return joinToString("") { "%02x".format(it) }
}
