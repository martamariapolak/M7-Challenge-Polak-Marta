package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.AlbumRecomendation;
import com.company.musicstorerecommendations.repository.AlbumRecomendationRepository;
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
@WebMvcTest(value = AlbumRecomController.class)

public class AlbumRecomControllerTest {

    @MockBean
    private AlbumRecomController controller;
    private AlbumRecomendationRepository repo;
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();
    private AlbumRecomendation Null;

    @Before
    public void setUp() throws Exception {
        setupProduceServiceMock();
    }

    private void setupProduceServiceMock() {
        this.repo = mock( AlbumRecomendationRepository.class );
        AlbumRecomendation album = new AlbumRecomendation( 12, 2L, 2L, true );

        AlbumRecomendation albumWithoutId = new AlbumRecomendation( 2L, 2L, true );

        List<AlbumRecomendation> produceList = Arrays.asList( album );

        doReturn( produceList ).when( controller ).getAlbums();
        doReturn( album ).when( controller ).addAlbum( albumWithoutId );

    }

    @Test
    public void getAllAlbumsShouldReturnAListAnd200() throws Exception {
        // Arrange
        AlbumRecomendation album = new AlbumRecomendation( 12, 2L, 2L, true );
        ;
        System.out.println( "to" + album );
        List<AlbumRecomendation> produceList = Arrays.asList( album );

        String expectedJsonValue = mapper.writeValueAsString( produceList );
        // Act
        mockMvc.perform( get( "/albums" ) )
                .andDo( print() )
                .andExpect( status().isOk() )                 // Assert
                .andExpect( content().json( expectedJsonValue ) );
    }


    @Test
    public void ShouldGetAlbumById() throws Exception {
        AlbumRecomendation album = new AlbumRecomendation( 12, 2L, 2L, true );
        List<AlbumRecomendation> produceList = Arrays.asList( album );


        Mockito.when( controller.getAlbumById( 12 ) ).thenReturn( album );

        AlbumRecomendation albumService = controller.getAlbumById( 12 );

        // Assert the response
        assertNotNull( String.valueOf( albumService ), "Employee with employeeId : " + 12 + " not found" );
        assertEquals( 12, albumService.getAlid() );
        // assertEquals(track.getId(), trackService.getTrackId());
        assertEquals( album.getUseralId(), albumService.getUseralId() );
        assertEquals( album.getLikedAl(), albumService.getLikedAl() );
    }


    @Test
    public void createAlbumShouldReturnNewProduceAndStatus201() throws Exception {
        // Arrange
        AlbumRecomendation album = new AlbumRecomendation( 12, 2L, 2L, true );
        System.out.println( "to" + album );
        AlbumRecomendation albumWithoutId = new AlbumRecomendation( 2L, 2L, true );
        System.out.println( "drugie" + albumWithoutId );
        String outputProduceJson = mapper.writeValueAsString( album );
        String inputProduceJson = mapper.writeValueAsString( albumWithoutId );

        // Act
        mockMvc.perform( post( "/albums" )
                                 .contentType( MediaType.APPLICATION_JSON )
                                 .content( inputProduceJson ) )
                .andDo( print() )
                .andExpect( status().isCreated() )            // Assert
                .andExpect( content().json( outputProduceJson ) );  // Assert
    }

    @Test
    public void ShouldUpdateAlbum() throws Exception {
        AlbumRecomendation album = new AlbumRecomendation( 12, 2L, 2L, true );
        List<AlbumRecomendation> produceList = Arrays.asList( album );

        Mockito.when( controller.getAlbumById( 12 ) ).thenReturn( album );

        AlbumRecomendation albumService = controller.getAlbumById( 12 );

        albumService.setAlbumId( 5L );

        //  repo.save(track);


        albumService = controller.getAlbumById( 12 );
        assertEquals( album.getAlbumId(), albumService.getAlbumId() );
    }


    @Test
    public void delate() throws Exception {
        AlbumRecomendation album = new AlbumRecomendation( 12, 2L, 2L, true );
        List<AlbumRecomendation> produceList = Arrays.asList( album );
        ;
        Mockito.when( controller.getAlbumById( 12 ) ).thenReturn( album );
        boolean result = controller.deleteAlbum( 12 );
        Mockito.verify( controller, times( 1 ) )
                .deleteAlbum( 12 );
        assertEquals( result,
                      false );

    }
}



