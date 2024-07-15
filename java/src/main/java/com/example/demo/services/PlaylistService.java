package com.example.demo.services;

import java.util.LinkedList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;

public class PlaylistService 
{
    //01
    private final IPlaylistRepository playlistRepository;
    private final ISongRepository songRepository;
    private final Player player;

    //02(but with dip)
    public PlaylistService(IPlaylistRepository playlistRepository, ISongRepository songRepository)
    {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
        this.player = new Player();
    }

    //03
    public Playlist createPlaylist(String playlistName, List<String> songIds)
    {
        List<Song> songList = new LinkedList<>();
        for (int i=0;i< songIds.size();i++) 
        {
            Song song = songRepository.findById(songIds.get(i)).orElseThrow(()-> new RuntimeException("Song not found!"));
            songList.add(song);
        }
        //02 steps
        Playlist playlistToCreate = new Playlist(playlistName, songList);
        return playlistRepository.save(playlistToCreate);
    }

    //public String addSongToPlaylist(String playlistName, Long songId)
    public String addSongToPlaylist(String playlistName, String songId)
    {
        Playlist playList = playlistRepository.findByName(playlistName).orElseThrow(()-> new RuntimeException("invalid playlist " + playlistName));
        // playlist.addSongIdInPlaylist(songId);
        Song song = songRepository.findById(songId).get();
        //how to pring findAllSongsInPlaylistNow ??
        // List<Long> songIdsList = playlist.getSongIdsInPlaylist();
        // List<Song> updatedPlaylist = new LinkedList<>();
        // songIdsList.forEach((songIdObj)->{
        //     Song song = songRepository.findById(songIdObj).orElseThrow(()-> new RuntimeException("invalid songId"));
        //     updatedPlaylist.add(song);
        // });
        // System.out.println("Playlist " + playlistName + " is revised with " + updatedPlaylist);

        String result = "[";
        List<Song> playlist = playList.getListOfSong();
        if(!playlist.stream().anyMatch(t->t.getId().equals(songId)))
        {
            playlist.add(song);
        }
        List<Song> updatedPlayList  = playList.getListOfSong();
        for (int i = 0; i < updatedPlayList.size(); i++) 
        {
            if(i== updatedPlayList.size()-1)
            {
                result += updatedPlayList.get(i).toString();
            }
            else
            {
                result += updatedPlayList.get(i).toString()+ ", ";
            }
        }
        result+="]";

        return "Playlist " + playList.getPlaylistName() +" is revised with "+result;
    }

    public String deleteSongFromPlaylist(String playlistName, String songId)
    {
        //same implementation as above
        Playlist playList = playlistRepository.findByName(playlistName).orElseThrow(()-> new RuntimeException("invalid playlist " + playlistName));
       //playlist.removeSongIdInPlaylist(songId);

        // List<Long> songIdsList = playlist.getSongIdsInPlaylist();
        // List<Song> updatedPlaylist = new LinkedList<>();
        // songIdsList.forEach((songIdObj)->{
        //     Song song = songRepository.findById(songIdObj).orElseThrow(()-> new RuntimeException("invalid songId"));
        //     updatedPlaylist.add(song);
        // });
        // System.out.println("Playlist " + playlistName + " is revised with " + updatedPlaylist);

        Song song = songRepository.findById(songId).orElseThrow(()-> new RuntimeException("Song is not there in PlayList"));

        String result = "[";
        List<Song> playlist = playList.getListOfSong();
        if(playlist.stream().anyMatch(t->t.getId().equals(songId)))
        {
            playlist.remove(song);
        }
        List<Song> updatedPlayList  = playList.getListOfSong();
        for (int i = 0; i < updatedPlayList.size(); i++) 
        {
            if(i==updatedPlayList.size()-1)
            {
                result += updatedPlayList.get(i).toString();
            }
            else
            {
                result += updatedPlayList.get(i).toString()+ ", ";
            }
        }
        result+="]";

        return "Playlist "+playList.getPlaylistName()+" is revised with "+result;
    }

    public String deletePlaylist(String playlistName)
    {
        Playlist playList = playlistRepository.findByName(playlistName).orElseThrow(()-> new RuntimeException("invalid playlist " + playlistName));
        String playlistId = playList.getId();

        playlistRepository.delete(playlistId);

        return "Playlist "+playList.getPlaylistName()+" is deleted!";
    }

    public String loadPlaylist(String playlistName)
    {
        Playlist playList = playlistRepository.findByName(playlistName).orElseThrow(()-> new RuntimeException("invalid playlist " + playlistName));
        List<Song> songList = playList.getListOfSong();
        player.setSongQueue(songList);
        return "Playlist"+" "+playList.getPlaylistName()+" "+"is loaded!";
    }

    public void playHandler(String request) 
    {
        switch(request)
        {
            case "PLAY_SONG":
                player.play();
                break;

            case "NEXT_SONG":
                player.next();
                break;

            case "PREVIOUS_SONG":
                player.previous();
                break;
            
            case "STOP_SONG":
                player.stop();
                break; 
            
            default:
                break;
        }
    }
    
}
