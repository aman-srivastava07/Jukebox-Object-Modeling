package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Playlist;

public interface IPlaylistRepository 
{
    //s ff c d singular/plural getters
    public Playlist save(Playlist playlist);

    public Optional<Playlist> findById(String id);
    public List<Playlist> findAll();

    public Integer count();

    public void delete(String id);


   
    public Optional<Playlist> findByName(String name);
    
}
