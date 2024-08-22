package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;

public class NextSongCommand implements ICommand 
{
    //01: service object with dip
    private final PlaylistService playlistService;

    public NextSongCommand(PlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    //02
    @Override
    public void invoke(List<String> tokens) 
    {
       playlistService.playHandler(tokens.get(0));
    }
    
}
