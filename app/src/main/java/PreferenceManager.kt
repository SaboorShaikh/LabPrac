import android.content.Context

class PreferenceManager(context: Context) {
    //Step 1 - Create sharedPrefs objects
    val prefs = context.getSharedPreferences("myprefs", Context.MODE_PRIVATE)

    //Step 2 - For Writing Purpose
    fun writeString(key: String, value: String) {
        val editor = prefs.edit()
        editor.putString(key, value)
        editor.apply()
    }

    //Step 3 - For reading
    fun readString(key: String, defValues: String): String {
        return prefs.getString(key, defValues) ?: defValues
    }
}