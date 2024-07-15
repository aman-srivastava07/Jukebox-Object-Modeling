package com.example.demo.commands;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistService;

public class CreatePlaylistCommand implements ICommand 
{
    //01: service object with dip
    private final PlaylistService playlistService;

    public CreatePlaylistCommand(PlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    //02
    @Override
    public void invoke(List<String> tokens) 
    {
        String playListName=tokens.get(1);

        List<String> songs=new ArrayList<>();
        for(int i=2 ;i<tokens.size();i++)
        {
            songs.add(tokens.get(i));
        }
        
        Playlist playlist = playlistService.createPlaylist(playListName,songs);
        System.out.println(playlist.toString());
    }
    
}
