package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Song;

public interface ISongRepository 
{
    //s ff c d singular/plural getters
    public Song save(Song song);

    public Optional<Song> findById(String id);
    public List<Song> findAll();

    public Integer count();

    public void delete(String id);


    public Optional<Song> findSongByArtist(String artist);
    public Optional<Song> findSongBylbum(String album);
    public Optional<Song> findSongByName(String name);
    public List<Song> findAllSongOfAGenre(String genre);


}
