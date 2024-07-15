package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class PreviousSongCommand implements ICommand 
{
    //01: service object with dip
    private final PlaylistService playlistService;

    public PreviousSongCommand(PlaylistService playlistService)
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
