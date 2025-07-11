package com.BP.artgallery.model;

import jakarta.persistence.*;
import java.time.LocalDate;

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
    private LocalDate uploadDate;
    private String imageFilename;

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

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getImageFilename() {
        return imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }


}