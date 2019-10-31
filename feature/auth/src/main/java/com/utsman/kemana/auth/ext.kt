package com.utsman.kemana.auth

import com.google.gson.Gson
import org.json.JSONObject

fun String.stringToUser() = Gson().fromJson(this, User::class.java)
fun User.userToString() = Gson().toJson(this)

fun JSONObject.toUser(): User {
    val objectId = get("object_id") as String
    val userId = get("user_id") as String
    val name = get("name") as String
    val email = get("email") as String
    val vehiclesType = get("vehicles_type") as String
    val vehiclesNum = get("vehicles_num") as String
    val photoProfile = get("photo_url") as String
    val lat = get("lat") as String
    val lon = get("lon") as String
    val angle = get("angle") as String
    val onOrder = get("on_order") as Boolean

    return User(
        userId = userId,
        name = name,
        email = email,
        vehiclesType = vehiclesType,
        vehiclesPlat = vehiclesNum,
        objectId = objectId,
        lat = lat.toDouble(),
        lon = lon.toDouble(),
        angle = angle.toDouble(),
        photoProfile = photoProfile,
        onOrder = onOrder
    )
}

fun User.toJSONObject(): JSONObject {
    val json = JSONObject()
    json.apply {
        put("object_id", objectId)
        put("user_id", userId)
        put("name", name)
        put("email", email)
        put("vehicles_type", vehiclesType)
        put("vehicles_num", vehiclesPlat)
        put("photo_url", photoProfile)
        put("lat", lat.toString())
        put("lon", lon.toString())
        put("angle", angle.toString())
        put("on_order", onOrder)
    }

    return json
}