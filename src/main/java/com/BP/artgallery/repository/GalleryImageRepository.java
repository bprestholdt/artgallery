package com.BP.artgallery.repository;

import com.BP.artgallery.model.GalleryImage;
import org.springframework.data.jpa.repository.JpaRepository;

//repository is interface that handles CRUD operations on Artwork entities
public interface GalleryImageRepository extends JpaRepository<GalleryImage, Long> {


}