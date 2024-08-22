package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;

public class SongService 
{
    //01
    private final ISongRepository songRepository;

    //02 (but with dip)
    public SongService(ISongRepository songRepository)
    {
        this.songRepository = songRepository;
    }

    //03
    public Song addSong(String songName, String artist, String album, String genre)
    {
        //02 steps
        Song song = new Song(songName, artist, album, genre);
        return songRepository.save(song);
    }

    //public List<Song> listSong()
    public String listSong()
    {
        List<Song> songList = songRepository.findAll();

        String result="[";
        for(int i=0; i<songList.size(); i++) 
        {
            if(i == songList.size() - 1) 
            {
                result+=songList.get(i).toString();
            }
            else 
            {
                result+=songList.get(i).toString() + ", ";
            }
        }
        result += "]";
        return result;
    }

    // void playSong()
    // {

    // }

    // void nextSong()
    // {

    // }

    // void previousSong()
    // {

    // }

    // void stopSong()
    // {

    // }
    
}
