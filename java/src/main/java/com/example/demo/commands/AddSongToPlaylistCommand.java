package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class AddSongToPlaylistCommand implements ICommand 
{
    //01: service object with dip
    private final PlaylistService playlistService;

    public AddSongToPlaylistCommand(PlaylistService playlistService)
    {
        this.playlistService = playlistService;
    }

    //02
    @Override
    public void invoke(List<String> tokens) 
    {
        //tokens.get(2) is String But we want List<Long>
        //System.out.println(playlistService.addSongToPlaylist(tokens.get(1), Long.parseLong(tokens.get(2))));
        System.out.println(playlistService.addSongToPlaylist(tokens.get(1), tokens.get(2)));
    }
    
}
