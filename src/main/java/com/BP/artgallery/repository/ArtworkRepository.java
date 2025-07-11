package com.BP.artgallery.repository;

import com.BP.artgallery.model.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;

//repository is interface that handles CRUD operations on Artwork entities
public interface ArtworkRepository extends JpaRepository<Artwork, Long> {


}