package com.example.demo.entities;

public class Song 
{
    //attributes
    private final String id;
    private final String songName;
    private final String artist;
    private final String album;
    private final String genre;
    
    //constructor (initialization with default values and validation checks)
    public Song(String id, String songName, String artist, String album, String genre)
    {
        this.id = id;
        this.songName = songName;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }

    public Song(String songName, String artist, String album, String genre)
    {
        this(null, songName, artist, album, genre);
    }

    public void playSong()
    {
        System.out.println("Playing the song " + songName);
    }

    //getter
    public String getId()
    {
        return id;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getAlbum()
    {
        return album;
    }

    public String getSongName()
    {
        return songName;
    }

    public String getGenre()
    {
        return genre;
    }

    //setter (not required)

    //a r d c (not required)

    //toString()
    @Override
    public String toString()
    {
        //return "Song[id=" + String.valueOf(getId()) + "]";
        //return "Song[id=" + getId() + "]";    error out because of no space after Song
        return "Song [id=" + getId() + "]"; 
    }


    
}
