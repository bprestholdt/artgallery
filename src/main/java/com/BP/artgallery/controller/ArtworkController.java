package com.BP.artgallery.controller;

import com.BP.artgallery.service.ArtworkService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

//accepts HTTP request from frontend and triggers backend method
@RestController
@RequestMapping("api/artworks")
public class ArtworkController {

    //dependency injection of ArtworkService
    private final ArtworkService artworkService;

    @Autowired
    //constructor injection of service class containing methods controller is dependent on
    public ArtworkController (ArtworkService artworkService) {

        this.artworkService = artworkService;
    }

    //handles POST /api/artworks
    @PostMapping
    public void uploadArtwork (
         @RequestParam("title") String title,
         @RequestParam("description") String description,
         @RequestParam("images") MultipartFile[] images
    ) throws IOException {
        artworkService.saveArtwork(title, description, images);
    }





}