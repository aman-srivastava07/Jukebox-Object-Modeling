package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.state_pattern.IdleState;
import com.example.demo.state_pattern.PlayerState;

public class Player 
{
    PlayerState currentState;
    List<Song> songQueue;
    Integer selectedSongPosition;

    public Player()
    {
        this.currentState = new IdleState(this);
        this.songQueue = new ArrayList<>();
    }

    //setter
    public void setSelectedSongPosition(Integer selectedSongPosition) {
        this.selectedSongPosition = selectedSongPosition;
    }

    public void setCurrentState(PlayerState currentState) {
        this.currentState = currentState;
    }

    public void setSongQueue(List<Song> songQueue) {
        this.songQueue = songQueue;
    }

    //getter
    public Integer getSelectedSongPosition() {
        return selectedSongPosition;
    }

    public List<Song> getSongQueue() {
        return songQueue;
    }

    //methods
    public String play()
    {
        return currentState.play();
    }

    public String next(){
        return currentState.next();
    }

    public String previous(){
        return currentState.back();
    }
    
    public String stop(){
        return currentState.stop();
    }
    
}
