package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.ArtistRecomendation;

import com.company.musicstorerecommendations.model.LabelRecomendation;
import com.company.musicstorerecommendations.repository.ArtistRecomendationRepository;
import com.company.musicstorerecommendations.repository.LabelRecomendationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ArtistRecomendationController.class)

public class ArtistRecomendationControllerTest {

    @MockBean
    private ArtistRecomendationController controller;
    private ArtistRecomendationRepository repo;
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();
    private ArtistRecomendation Null;

    @Before
    public void setUp() throws Exception {
        setupProduceServiceMock();
    }

    private void setupProduceServiceMock() {
        this.repo = mock( ArtistRecomendationRepository.class );
        ArtistRecomendation artist = new ArtistRecomendation( 12, 2L, 2L, true );

        ArtistRecomendation artistWithoutId = new ArtistRecomendation( 2L, 2L, true );

        List<ArtistRecomendation> produceList = Arrays.asList( artist );

        doReturn( produceList ).when( controller ).getArtists();
        doReturn( artist ).when( controller ).addArtist( artistWithoutId );

    }

    @Test
    public void getAllArtistsShouldReturnAListAnd200() throws Exception {
        // Arrange
        ArtistRecomendation artist = new ArtistRecomendation( 12, 2L, 2L, true );
        ;
        System.out.println( "to" + artist );
        List<ArtistRecomendation> produceList = Arrays.asList( artist);

        String expectedJsonValue = mapper.writeValueAsString( produceList );
        // Act
        mockMvc.perform( get( "/artists" ) )
                .andDo( print() )
                .andExpect( status().isOk() )                 // Assert
                .andExpect( content().json( expectedJsonValue ) );
    }


    @Test
    public void ShouldGetArtistById() throws Exception {
        ArtistRecomendation artist = new ArtistRecomendation( 12, 2L, 2L, true );
        List<ArtistRecomendation> produceList = Arrays.asList( artist );


        Mockito.when( controller.getArtistById( 12 ) ).thenReturn( artist);

        ArtistRecomendation artistService = controller.getArtistById( 12 );

        // Assert the response
        assertNotNull( String.valueOf( artistService ), "artist: " + 12 + " not found" );
        assertEquals( 12, artistService.getIda() );
        assertEquals( artist.getUseraId(), artistService.getUseraId() );
        assertEquals( artist.getLikedA(), artistService.getLikedA() );
    }


    @Test
    public void createArtistShouldReturnNewProduceAndStatus201() throws Exception {
        // Arrange
        ArtistRecomendation artist = new ArtistRecomendation( 12, 2L, 2L, true );
        System.out.println( "to" + artist );
        ArtistRecomendation artistWithoutId = new ArtistRecomendation( 2L, 2L, true );
        System.out.println( "drugie" + artistWithoutId );
        String outputProduceJson = mapper.writeValueAsString( artist );
        String inputProduceJson = mapper.writeValueAsString( artistWithoutId );

        // Act
        mockMvc.perform( post( "/artists" )
                                 .contentType( MediaType.APPLICATION_JSON )
                                 .content( inputProduceJson ) )
                .andDo( print() )
                .andExpect( status().isCreated() )            // Assert
                .andExpect( content().json( outputProduceJson ) );  // Assert
    }

    @Test
    public void ShouldUpdateArtist() throws Exception {
        ArtistRecomendation artist = new ArtistRecomendation( 12, 2L, 2L, true );
        List<ArtistRecomendation> produceList = Arrays.asList( artist );

        Mockito.when( controller.getArtistById( 12 ) ).thenReturn( artist);

        ArtistRecomendation artistService = controller.getArtistById( 12 );

        artistService.setArtistId( 5L );

        artistService = controller.getArtistById( 12 );
        assertEquals( artist.getArtistId(), artistService.getArtistId() );
    }


    @Test
    public void delateArtist() throws Exception {
        ArtistRecomendation artist = new ArtistRecomendation( 12, 2L, 2L, true );
        List<ArtistRecomendation> produceList = Arrays.asList( artist );
        Mockito.when( controller.getArtistById( 12 ) ).thenReturn( artist );
        boolean result = controller.deleteArtist( 12 );
        Mockito.verify( controller, times( 1 ) )
                .deleteArtist( 12 );
        assertEquals( result,
                      false );

    }
}

