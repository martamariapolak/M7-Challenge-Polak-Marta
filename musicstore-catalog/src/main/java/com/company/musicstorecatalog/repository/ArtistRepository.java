package com.company.musicstorecatalog.repository;

//import com.company.reccoll.model.Artist;
import com.company.musicstorecatalog.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
