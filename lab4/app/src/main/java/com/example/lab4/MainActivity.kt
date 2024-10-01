package com.example.lab4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SongsAdapter

    private val songs = mutableListOf<Song>(
        Song("Song 1", "Artist 1", "3:30", "Album 1"),
        Song("Song 2", "Artist 2", "4:15", "Album 2"),
        Song("Song 3", "Artist 3", "2:45", "Album 3")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        if (songs.isEmpty()) {
            Toast.makeText(this, "Список пісень порожній", Toast.LENGTH_SHORT).show()
        } else {
            adapter = SongsAdapter(songs) { song -> showSongDetails(song) }
            recyclerView.adapter = adapter
        }

    }

    private fun showSongDetails(song: Song) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra("SONG_TITLE", song.title)
            putExtra("SONG_ARTIST", song.artist)
            putExtra("SONG_DURATION", song.duration)
            putExtra("SONG_ALBUM", song.album)
        }
        startActivity(intent)
    }
}
