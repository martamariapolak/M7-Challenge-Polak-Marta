package com.company.musicstorerecommendations.controller;
import com.company.musicstorerecommendations.repository.AlbumRecomendationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.company.musicstorerecommendations.model.TrackRecommendation;
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
@WebMvcTest(value = TrackRecomendationController.class)

public class TrackRecomendationControllerTest {

    @MockBean
    private TrackRecomendationController controller;
    private AlbumRecomendationRepository repo;
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();
    private TrackRecommendation Null;

    @Before
    public void setUp() throws Exception {
        setupProduceServiceMock();
    }

    private void setupProduceServiceMock() {
        this.repo = mock( AlbumRecomendationRepository.class );
        TrackRecommendation track = new TrackRecommendation( 12, 2L, 2L, true );
        TrackRecommendation trackWithoutId = new TrackRecommendation( 2L, 2L, true );

        List<TrackRecommendation> produceList = Arrays.asList( track );

        doReturn( produceList ).when( controller ).getTracks();
        doReturn( track ).when( controller ).addTrack( trackWithoutId );

    }

    @Test
    public void getAllTracksShouldReturnAListAnd200() throws Exception {
        // Arrange
        TrackRecommendation track = new TrackRecommendation( 12, 2L, 2L, true );
        ;
        System.out.println( "to" + track );
        List<TrackRecommendation> produceList = Arrays.asList( track );

        String expectedJsonValue = mapper.writeValueAsString( produceList );
        // Act
        mockMvc.perform( get( "/tracks" ) )
                .andDo( print() )
                .andExpect( status().isOk() )                 // Assert
                .andExpect( content().json( expectedJsonValue ) );
    }


    @Test
    public void ShouldGetTrackById() throws Exception {
        TrackRecommendation track = new TrackRecommendation( 12, 2L, 2L, true );
        List<TrackRecommendation> produceList = Arrays.asList( track );



        Mockito.when( controller.getTrackById( 12 ) ).thenReturn( track );

        TrackRecommendation trackService = controller.getTrackById( 12 );

        // Assert the response
        assertNotNull( String.valueOf( trackService ), "Employee with employeeId : " + 12 + " not found" );
        assertEquals( 12, trackService.getId() );
        // assertEquals(track.getId(), trackService.getTrackId());
        assertEquals( track.getUserId(), trackService.getUserId() );
        assertEquals( track.getLiked(), trackService.getLiked() );
    }


    @Test
    public void createTrackShouldReturnNewProduceAndStatus201() throws Exception {
        // Arrange
        TrackRecommendation track = new TrackRecommendation( 12, 2L, 2L, true );
        System.out.println( "to" + track );
        TrackRecommendation trackWithoutId = new TrackRecommendation( 2L, 2L, true );
        System.out.println( "drugie" + trackWithoutId );
        String outputProduceJson = mapper.writeValueAsString( track );
        String inputProduceJson = mapper.writeValueAsString( trackWithoutId );

        // Act
        mockMvc.perform( post( "/tracks" )
                                 .contentType( MediaType.APPLICATION_JSON )
                                 .content( inputProduceJson ) )
                .andDo( print() )
                .andExpect( status().isCreated() )            // Assert
                .andExpect( content().json( outputProduceJson ) );  // Assert
    }

    @Test
    public void ShouldUpdateTrack() throws Exception {
        TrackRecommendation track = new TrackRecommendation( 12, 2L, 2L, true );
        List<TrackRecommendation> produceList = Arrays.asList( track );

        Mockito.when( controller.getTrackById( 12 ) ).thenReturn( track );

        TrackRecommendation trackService = controller.getTrackById( 12 );

        trackService.setTrackId( 5L );

          //  repo.save(track);

            //Optional<AlbumRecomendation> updatedProduct = repo.findById( 12);
         trackService = controller.getTrackById( 12 );
        assertEquals( track.getTrackId(), trackService.getTrackId());
        }


@Test
    public void delate() throws Exception {
        TrackRecommendation track = new TrackRecommendation( 12, 2L, 2L, true );
        List<TrackRecommendation> produceList = Arrays.asList( track );
       ;
       Mockito.when( controller.getTrackById(12) ).thenReturn( track);
     boolean result = controller.deleteTrack(12);
    Mockito.verify(controller, times(1))
            .deleteTrack(12);
    assertEquals( result,
                   false);

}}




