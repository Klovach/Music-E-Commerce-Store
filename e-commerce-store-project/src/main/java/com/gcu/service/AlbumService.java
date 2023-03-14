package com.gcu.service;

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