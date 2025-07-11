package com.BP.artgallery.service;

import com.BP.artgallery.repository.ArtworkRepository;
import com.BP.artgallery.model.Artwork;
import com.BP.artgallery.model.GalleryImage;
import com.BP.artgallery.repository.ArtworkRepository;
import com.BP.artgallery.repository.GalleryImageRepository;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//contains methos that handles business logic concerning saving and modifying artwork objects
@Service
public class ArtworkService {

    private final ArtworkRepository artworkRepository;

    private final GalleryImageRepository galleryImageRepository;


    public ArtworkService (ArtworkRepository artworkRepository, GalleryImageRepository galleryImageRepository) {
        this.artworkRepository = artworkRepository;
        this.galleryImageRepository = galleryImageRepository;

    }

    public void saveArtwork (String title, String description, MultipartFile[] images) throws IOException{

        Artwork artwork = new Artwork();
        artwork.setTitle(title);
        artwork.setDescription(description);
        artwork.setUploadDate(LocalDate.now());

        //save files from user input to uploads folder
        Path uploadPath = Paths.get("uploads");
        for (MultipartFile file : images) {
            Files.copy(file.getInputStream(), uploadPath.resolve(file.getOriginalFilename()));
        }
        //add file images to list of GalleryImage objects
        List<GalleryImage> artworkImages = new ArrayList<>();

        for (MultipartFile file: images) {
            String filename = file.getOriginalFilename();

            GalleryImage galleryImage = new GalleryImage();
            galleryImage.setFilename(filename);
            galleryImage.setArtwork(artwork);

            artwork.getGalleryImages().add(galleryImage);

        }


        artworkRepository.save(artwork);
    }

}