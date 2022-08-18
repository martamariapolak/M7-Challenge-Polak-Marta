package com.company.musicstorecatalog.repository;


import com.company.musicstorecatalog.model.Album;
import com.company.musicstorecatalog.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}


