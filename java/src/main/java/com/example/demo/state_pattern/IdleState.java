package com.example.demo.state_pattern;

import com.example.demo.services.Player;

public class IdleState extends PlayerState
{
    public IdleState(Player player) 
    {
        super(player);
    }

    public String play() 
    {
        player.setCurrentState(new PlayingState(player));
        player.setSelectedSongPosition(0);
        System.out.println(player.getSongQueue().get(0).toString()+" "+"is playing!");
        return "First song of playlist starts playing!";
    }
}
