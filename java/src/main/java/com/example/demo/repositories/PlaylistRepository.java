package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Playlist;

public class PlaylistRepository implements IPlaylistRepository 
{
     //01
     private final Map<String, Playlist> playlistMap;
     private Long autoincrement = 1L;
 
     //02
     public PlaylistRepository()
     {
         playlistMap = new HashMap<>();
     }
 
     //03
     @Override
     public Playlist save(Playlist playlist) //04 steps
     {
         Playlist playlistToCreate = new Playlist(String.valueOf(autoincrement), playlist.getPlaylistName(), playlist.getListOfSong());
         playlistMap.putIfAbsent(playlistToCreate.getId(), playlistToCreate);
 
         ++autoincrement;
         return playlistToCreate;
     }
 
     @Override
     //public Optional<Playlist> findById(Long id)
     public Optional<Playlist> findById(String id)
     {
         return Optional.ofNullable(playlistMap.get(id));
     }
 
     @Override
     public List<Playlist> findAll()
     {
         return playlistMap.values().stream().collect(Collectors.toList());
     }
 
     @Override
     public Integer count()
     {
         return playlistMap.size();
     }
 
     @Override
     public void delete(String id)
     {
         playlistMap.remove(id);
     }
 
 
     @Override
     public Optional<Playlist> findByName(String name)
     {
         return playlistMap.values().stream().filter(u->u.getPlaylistName().equals(name)).findFirst();
     }
     
    
}
