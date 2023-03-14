package com.gcu.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumModel {
    private int id;
    private String title;
    private String artist;
    private String genre;
    private LocalDate releaseDate;
    private BigDecimal price;
    private String description;
    
    //CONSTRUCTOR
    public AlbumModel() {
    	
    }
    
	public AlbumModel(int id, String title, String artist, String genre, LocalDate releaseDate, BigDecimal price,
			String description) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.price = price;
		this.description = description;
	}
	
    
    //GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
