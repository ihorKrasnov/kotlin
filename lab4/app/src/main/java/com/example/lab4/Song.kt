package com.example.lab4

data class Song(
    val title: String,
    val artist: String,
    val duration: String,
    val album: String
) {
    // Method to convert a Song object to a JSON string
    fun toJson(): String {
        return """
            {
                "title": "$title",
                "artist": "$artist",
                "duration": "$duration",
                "album": "$album"
            }
        """.trimIndent()
    }

    // Method to convert a JSON string to a Song object
    companion object {
        fun fromJson(json: String?): Song {
            // Check for null or empty string
            if (json.isNullOrEmpty()) {
                return Song("", "", "", "")
            }

            // Extract values from the JSON string
            val values = json.trim()
                .removeSurrounding("{", "}")
                .split(",")
                .associate {
                    val (key, value) = it.split(": ").map { it.trim().removeSurrounding("\"") }
                    key to value
                }

            return Song(
                title = values["title"] ?: "",
                artist = values["artist"] ?: "",
                duration = values["duration"] ?: "",
                album = values["album"] ?: ""
            )
        }
    }
}
