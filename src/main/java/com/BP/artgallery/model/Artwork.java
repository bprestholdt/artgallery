package com.BP.artgallery.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


//Artwork entity
//table in database, each entry will be a row with fields as columns
@Entity
public class Artwork {

    //each artwork instance will be 1 row in artwork table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //fields for the artwork on website- title, description, etc
    private Long id;

    private String title;
    private String description;

    private LocalDate localDate;

    @OneToMany(mappedBy = "artwork", cascade = CascadeType.ALL)
    private List<GalleryImage> galleryImages = new ArrayList<>();

    //only need default constructor, as all Artwork objs will be modified by users, not manually in code
    public Artwork () {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GalleryImage> getGalleryImages() {
        return galleryImages;
    }

    public void setGalleryImages(List<GalleryImage> galleryImages) {
        this.galleryImages = galleryImages;
    }
    public LocalDate getUploadDate() {
        return localDate;
    }

    public void setUploadDate(LocalDate localDate) {
        this.localDate = localDate;
    }


}