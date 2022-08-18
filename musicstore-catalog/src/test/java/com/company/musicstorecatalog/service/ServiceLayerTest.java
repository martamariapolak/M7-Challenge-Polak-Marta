//package com.company.musicstorecatalog.service;
//
//
//import com.company.musicstorecatalog.model.Album;
//import com.company.musicstorecatalog.model.Artist;
//import com.company.musicstorecatalog.model.Label;
//import com.company.musicstorecatalog.repository.AlbumRepository;
//import com.company.musicstorecatalog.repository.ArtistRepository;
//import com.company.musicstorecatalog.repository.LabelRepository;
//import com.company.musicstorecatalog.repository.TrackRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
////@RunWith(SpringRunner.class)
////@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//
//public class ServiceLayerTest {
//
//
//        TrackRepository trackRepository;
//        AlbumRepository albumRepository;
//
//        ArtistRepository artistRepository;
//        LabelRepository labelRepository;
//
//        @Before
//        public void setUp() throws Exception {
//
//               /* trackRepository.deleteAll();
//                albumRepository.deleteAll();
//                artistRepository.deleteAll();
//                labelRepository.deleteAll();
//
//                */
//        }
//
//        @Test
//        public void addGetDeleteAlbum() {
//
//                // Need to create a Label and an Artist first
//                Label label = new Label();
//                label.setName("A&M");
//                label.setWebsite("www.aandm.com");
//                label = labelRepository.save(label);
//
//                Artist artist = new Artist();
//                artist.setName("Rock Start");
//                artist.setInstagram("@RockStart");
//                artist.setTwitter("@TheRockStar");
//                artist = artistRepository.save(artist);
//
//                Album album = new Album();
//                album.setTitle("Greatest Hits");
//                album.setArtistId(artist.getId());
//                album.setLabelId(label.getId());
//                album.setReleaseDate(LocalDate.of(2010, 1, 5));
//                album.setListPrice(new BigDecimal("21.95"));
//
//                album = albumRepository.save(album);
//
//                Optional<Album> album1 = albumRepository.findById(album.getId());
//
//                assertEquals(album1.get(), album);
//
//                albumRepository.deleteById(album.getId());
//
//                album1 = albumRepository.findById(album.getId());
//
//                assertFalse(album1.isPresent());
//
//        }
//
//        @Test(expected  = DataIntegrityViolationException.class)
//        public void addWithRefIntegrityException() {
//
//                Album album = new Album();
//                album.setTitle("Greatest Hits");
//                album.setArtistId(54L);
//                album.setLabelId(91L);
//                album.setReleaseDate(LocalDate.of(2010, 1, 5));
//                album.setListPrice(new BigDecimal("21.95"));
//
//                album =albumRepository.save(album);
//
//        }
//
//        @Test
//        public void getAllAlbums() {
//
//                // Need to create a Label and an Artist first
//                Label label = new Label();
//                label.setName("A&M");
//                label.setWebsite("www.aandm.com");
//                label = labelRepository.save(label);
//
//                Artist artist = new Artist();
//                artist.setName("Rock Start");
//                artist.setInstagram("@RockStart");
//                artist.setTwitter("@TheRockStar");
//                artist = artistRepository.save(artist);
//
//                Album album = new Album();
//                album.setTitle("Greatest Hits");
//                album.setArtistId(artist.getId());
//                album.setLabelId(label.getId());
//                album.setReleaseDate(LocalDate.of(2010, 1, 5));
//                album.setListPrice(new BigDecimal("21.95"));
//
//                album = albumRepository.save(album);
//
//                album = new Album();
//                album.setTitle("Leftovers");
//                album.setArtistId(artist.getId());
//                album.setLabelId(label.getId());
//                album.setReleaseDate(LocalDate.of(2012, 4, 5));
//                album.setListPrice(new BigDecimal("18.95"));
//
//                album = albumRepository.save(album);
//
//                List<Album> aList = albumRepository.findAll();
//
//                assertEquals(aList.size(), 2);
//
//        }
//
//        @Test
//        public void updateAlbum() {
//
//                Label label = new Label();
//                label.setName("A&M");
//                label.setWebsite("www.aandm.com");
//                label = labelRepository.save(label);
//
//                Artist artist = new Artist();
//                artist.setName("Rock Start");
//                artist.setInstagram("@RockStart");
//                artist.setTwitter("@TheRockStar");
//                artist = artistRepository.save(artist);
//
//                Album album = new Album();
//                album.setTitle("Greatest Hits");
//                album.setArtistId(artist.getId());
//                album.setLabelId(label.getId());
//                album.setReleaseDate(LocalDate.of(2010, 1, 1));
//                album.setListPrice(new BigDecimal("21.95"));
//
//                album = albumRepository.save(album);
//
//                album.setTitle("NEW TITLE");
//                album.setReleaseDate(LocalDate.of(2000, 7, 7));
//                album.setListPrice(new BigDecimal("15.68"));
//
//                albumRepository.save(album);
//
//                Optional<Album> album1 = albumRepository.findById(album.getId());
//                assertEquals(album1.get(), album);
//
//        }
//
//}