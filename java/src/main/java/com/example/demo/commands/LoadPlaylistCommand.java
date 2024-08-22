package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class LoadPlaylistCommand implements ICommand 
{
    //01: service object with dip
    private final PlaylistService playlistService;

    public LoadPlaylistCommand(PlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    //02
    @Override
    public void invoke(List<String> tokens) 
    {
        System.out.println(playlistService.loadPlaylist(tokens.get(1)));
    }
    
}
