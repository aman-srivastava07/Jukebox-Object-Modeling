package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Song;

public class SongRepository implements ISongRepository 
{
    //01
    //private final Map<Long, Song> songMap;
    private final Map<String, Song> songMap;
    private Long autoincrement = 1L;

    //02
    public SongRepository()
    {
        songMap = new HashMap<>();
    }

    //03
    @Override
    public Song save(Song song) //04 steps
    {
        Song songToAdd = new Song(String.valueOf(autoincrement), song.getSongName(), song.getArtist(), song.getAlbum(), song.getGenre());
        songMap.putIfAbsent(songToAdd.getId() , songToAdd);

        ++autoincrement;
        return songToAdd;
    }

    @Override
    public Optional<Song> findById(String id)
    {
        return Optional.ofNullable(songMap.get(id));
    }

    @Override
    public List<Song> findAll()
    {
        return songMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Integer count()
    {
        return songMap.size();
    }

    @Override
    public void delete(String id)
    {
        songMap.remove(id);
    }

    @Override
    public Optional<Song> findSongByArtist(String artist)
    {
        return songMap.values().stream().filter(u->u.getArtist().equals(artist)).findFirst();
    }

    @Override
    public Optional<Song> findSongBylbum(String album)
    {
        return songMap.values().stream().filter(u->u.getAlbum().equals(album)).findFirst();
    }

    @Override
    public Optional<Song> findSongByName(String name)
    {
        return songMap.values().stream().filter(u->u.getSongName().equals(name)).findFirst();
    }

    @Override
    public List<Song> findAllSongOfAGenre(String genre)
    {
        return songMap.values().stream().filter(u->u.getGenre().equals(genre)).collect(Collectors.toList());
    }
    
}
