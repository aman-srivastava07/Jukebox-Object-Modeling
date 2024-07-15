package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

public class ListSongCommand implements ICommand
{
    //01: service object with dip
    private final SongService songService;

    public ListSongCommand(SongService songService)
    {
        this.songService = songService;
    }

    //02
    @Override
    public void invoke(List<String> tokens) 
    {
        System.out.println(songService.listSong());
    }
    
}
