package com.example.demo.state_pattern;

import com.example.demo.entities.Song;
import com.example.demo.services.Player;

public class PlayingState extends PlayerState 
{
    
    public PlayingState(Player player)
    {
        super(player);
    }

    //methods
    public String play() 
    {
        //current song + stateChange
        Song currentlyPlaying=player.getSongQueue().get(player.getSelectedSongPosition());
        System.out.println(currentlyPlaying.toString()+" "+"is paused!");
        player.setCurrentState(new PausedState(player));
        return "Playing->Play->Paused";    
    }

    public String next() 
    {
        int numberOfSongs = player.getSongQueue().size();
        int nextSongToPlay = (player.getSelectedSongPosition()+1)%numberOfSongs;
        
        if(nextSongToPlay==numberOfSongs+1){
            player.setSelectedSongPosition(0);
        }

        Song currentlyPlaying= player.getSongQueue().get(nextSongToPlay);

        player.setSelectedSongPosition(nextSongToPlay);

        System.out.println(currentlyPlaying.toString()+" "+"is playing!");
        return "Playing->Next->Playing";   
    }

    public String back() 
    {
        int numberOfSongs = player.getSongQueue().size();
        int nextSongToPlay = (numberOfSongs + player.getSelectedSongPosition()-1) % numberOfSongs;
        Song currentlyPlaying=null;
        currentlyPlaying= player.getSongQueue().get(nextSongToPlay);

        player.setSelectedSongPosition(nextSongToPlay);

        System.out.println(currentlyPlaying.toString()+" "+"is playing!");
        return "Playing->Next->Playing";
    }

    public String stop() 
    {
       Song currentlyPlaying=player.getSongQueue().get(player.getSelectedSongPosition());
       System.out.println(currentlyPlaying.toString()+" "+"is stopped!");
       player.setCurrentState(new IdleState(player));
       return "Playing->Stop->Idle";
        
    }
    
}
