package com.example.lab4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
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

        val emptyView: TextView = findViewById(R.id.emptyView)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        if (songs.isEmpty()) {
            recyclerView.visibility = View.GONE
            emptyView.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyView.visibility = View.GONE

            adapter = SongsAdapter(songs) { song -> showSongDetails(song) }
            recyclerView.adapter = adapter
        }

    }

    private fun showSongDetails(song: Song) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra("SONG", song.toJson())
        }
        startActivity(intent)
    }
}
