package com.example.lab4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_detail)

        val title = intent.getStringExtra("SONG_TITLE")
        val artist = intent.getStringExtra("SONG_ARTIST")
        val duration = intent.getStringExtra("SONG_DURATION")
        val album = intent.getStringExtra("SONG_ALBUM")

        findViewById<TextView>(R.id.songTitle).text = title
        findViewById<TextView>(R.id.songArtist).text = artist
        findViewById<TextView>(R.id.songDuration).text = duration
        findViewById<TextView>(R.id.songAlbum).text = album

        // Закриває цю активність та повертає назад
        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}