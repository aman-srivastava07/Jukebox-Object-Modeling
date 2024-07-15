package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class DeletePlaylistCommand implements ICommand 
{
    //01: service object with dip
    private final PlaylistService playlistService;

    public DeletePlaylistCommand(PlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    //02
    @Override
    public void invoke(List<String> tokens) 
    {
        //tokens.get(2) is String But we want List<Long>
        System.out.println(playlistService.deletePlaylist(tokens.get(1)));
    }
    
}
