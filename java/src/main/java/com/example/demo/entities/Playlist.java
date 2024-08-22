package com.example.demo.entities;


import java.util.List;


public class Playlist 
{
    //attributes
    private final String id;
    private final String playlistName;
    private List<Song> listOfSong;

    //constructor (initialization with default values and validation checks)
    public Playlist(String id, String playlistName, List<Song> listOfSong)
    {
        this.id = id;
        this.playlistName = playlistName;
        this.listOfSong = listOfSong;
    }

    public Playlist(String playlistName, List<Song> listOfSong)
    {
        this(null, playlistName, listOfSong);
    }

    //getter
    public String getId()
    {
        return id;
    }

    public String getPlaylistName()
    {
        return playlistName;
    }

    public List<Song> getListOfSong()
    {
        return listOfSong;
    }

    //setter()
    public void setListOfSong(List<Song> listOfSong)
    {
        this.listOfSong = listOfSong;
    }

    //a r d c
    public void addSongInPlaylist(Song song)
    {
        listOfSong.add(song);
    }

    public void removeSongFromPlaylist(Song song)
    {
        listOfSong.remove(song);
    }

    // public List<Song> getSongFromPlaylist()
    // {
    //     return listOfSong;  //we already have a getter for this. So comment it.
    // }

    public boolean isSongIdExist(Song song)
    {
        if(listOfSong.contains(song))
            return true;
        else
            return false;
    }

    //toString()
    @Override
    public String toString()
    {
        //return "Playlist[id=" + String.valueOf(getId()) + "]";
        //return "Playlist[id=" + getId() + "]";  error out because of no space after Playlist
        return "Playlist [id=" + getId() + "]";
    }

    
}

