package com.example.lab4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_detail)

        val song = Song.fromJson(intent.getStringExtra("SONG"))

        findViewById<TextView>(R.id.songTitle).text = song.title
        findViewById<TextView>(R.id.songArtist).text = song.artist
        findViewById<TextView>(R.id.songDuration).text = song.duration
        findViewById<TextView>(R.id.songAlbum).text = song.album

        findViewById<Button>(R.id.backButton).setOnClickListener {
            finish()
        }
    }
}