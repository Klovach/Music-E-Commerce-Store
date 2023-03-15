package com.gcu.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gcu.model.AlbumModel;

@Service
public class AlbumService {

	private List<AlbumModel> albums = new ArrayList<>();

	public AlbumModel createAlbum(AlbumModel album) {
		album.setId(albums.size() + 1);
		albums.add(album);
		return album;
	}

	 public AlbumService() {
	     AlbumModel album1 = new AlbumModel(1, "Dummy Album 1", "Dummy Artist 1", "Pop", LocalDate.now(), new BigDecimal(10.00), "This is a dummy album.");
	     AlbumModel album2 = new AlbumModel(2, "Dummy Album 2", "Dummy Artist 2", "Rock", LocalDate.now(), new BigDecimal(12.00), "This is another dummy album.");
	     AlbumModel album3 = new AlbumModel(2, "Dummy Album 3", "Dummy Artist 2", "Rock", LocalDate.now(), new BigDecimal(12.00), "This is another dummy album.");
	     AlbumModel album4 = new AlbumModel(2, "Dummy Album 4", "Dummy Artist 4", "Rock", LocalDate.now(), new BigDecimal(12.00), "This is another dummy album.");
	     AlbumModel album5 = new AlbumModel(2, "Dummy Album 5", "Dummy Artist 2", "Rock", LocalDate.now(), new BigDecimal(12.00), "This is another dummy album.");
	     albums.add(album1);
	     albums.add(album2);
	     albums.add(album3);
	     albums.add(album4);
	     albums.add(album5);
	 }
	 
	public AlbumModel getAlbumById(int id) {
	    Optional<AlbumModel> album = albums.stream()
	            .filter(a -> a.getId() == id)
	            .findFirst();

	    if (album.isPresent()) {
	        return album.get();
	    } else {
	        throw new NoSuchElementException("Album not found with id: " + id);
	    }
	}
	

	public List<AlbumModel> getAllAlbums() {
		return albums;
	}

	public void deleteAlbumById(int id) {
		AlbumModel albumToDelete = getAlbumById(id);
		albums.remove(albumToDelete);
	}

	public AlbumModel updateAlbum(AlbumModel albumToUpdate) {
		AlbumModel existingAlbum = getAlbumById(albumToUpdate.getId());
		existingAlbum.setTitle(albumToUpdate.getTitle());
		existingAlbum.setArtist(albumToUpdate.getArtist());
		existingAlbum.setGenre(albumToUpdate.getGenre());
		existingAlbum.setReleaseDate(albumToUpdate.getReleaseDate());
		existingAlbum.setPrice(albumToUpdate.getPrice());
		existingAlbum.setDescription(albumToUpdate.getDescription());
		return existingAlbum;
	}
}