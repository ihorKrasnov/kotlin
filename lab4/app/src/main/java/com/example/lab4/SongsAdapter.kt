package com.example.lab4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongsAdapter(private val songs: List<Song>, private val onItemClick: (Song) -> Unit) :
    RecyclerView.Adapter<SongsAdapter.SongViewHolder>() {

    class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.songTitle)
        private val artistTextView: TextView = itemView.findViewById(R.id.songArtist)

        fun bind(song: Song, onItemClick: (Song) -> Unit) {
            titleTextView.text = song.title
            artistTextView.text = song.artist
            itemView.setOnClickListener { onItemClick(song) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_song, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(songs[position], onItemClick)
    }

    override fun getItemCount(): Int = songs.size
}
