package com.example.task_manager_4.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(private val context: Context) {
    private val pref by lazy {
        context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
    }

    fun isUserSeen(): Boolean {
        return pref.getBoolean(SEEN_KEY, false)
    }

    fun saveSeen() {
        pref.edit().putBoolean(SEEN_KEY, true).apply()
    }

    fun saveProfileName(name: String) {
        pref.edit().putString(NAME_KEY, name).apply()
    }

    fun getProfileName(): String? {
        return pref.getString(NAME_KEY, "")
    }

    fun saveImage(image: String) {
        pref.edit().putString(IMAGE_KEY, image).apply()
    }

    fun getImage(): String {
        return pref.getString(IMAGE_KEY, "").toString()
    }

    companion object {
        const val PREF_NAME = "task.pref"
        const val SEEN_KEY = "user_key"
        const val NAME_KEY = "name_key"
        const val IMAGE_KEY = "image_key"
    }
}