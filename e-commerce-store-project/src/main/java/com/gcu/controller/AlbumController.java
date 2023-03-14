package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.AlbumModel;
import com.gcu.service.AlbumService;
import jakarta.servlet.http.HttpSession;


@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/albums")
    public String showAlbums(Model model) {
        List<AlbumModel> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);
        return "albums";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/store/login";
        }
        AlbumModel album = new AlbumModel();
        model.addAttribute("album", album);
        return "create";
    }

    @PostMapping("/create")
    public String createAlbum(@ModelAttribute("album") AlbumModel album, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/store/login";
        }
        albumService.createAlbum(album);
        return "redirect:/albums";
    }
}