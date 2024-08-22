package com.example.demo.state_pattern;

import com.example.demo.entities.Song;
import com.example.demo.services.Player;

public class PausedState extends PlayerState 
{
    public PausedState(Player player) 
    {
        super(player);
    }

    // public String play()
    // {
    //     return "Playing->Play->Paused";
    // }

    public String next()
    {
        player.setCurrentState(new PlayingState(player));
        return "next Song can't be played";
    }

    public String back()
    {
        player.setCurrentState(new PlayingState(player));
        return "Previous Song can't be played";
    }

    public String stop()
    {
        Song currentlyPlaying=player.getSongQueue().get(player.getSelectedSongPosition());
        System.out.println(currentlyPlaying.toString()+" "+"is stopped!");
        player.setCurrentState(new IdleState(player));
        return "Playing->Stop->Idle";
    }

}
