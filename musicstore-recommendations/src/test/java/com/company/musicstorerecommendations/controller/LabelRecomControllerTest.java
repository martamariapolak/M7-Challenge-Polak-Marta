package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.LabelRecomendation;
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
@WebMvcTest(value = LabelRecomController.class)

public class LabelRecomControllerTest {

    @MockBean
    private LabelRecomController controller;
    private LabelRecomendationRepository repo;
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();
    private LabelRecomendation Null;

    @Before
    public void setUp() throws Exception {
        setupProduceServiceMock();
    }

    private void setupProduceServiceMock() {
        this.repo = mock( LabelRecomendationRepository.class );
        LabelRecomendation label = new LabelRecomendation( 12, 2L, 2L, true );

        LabelRecomendation labelWithoutId = new LabelRecomendation( 2L, 2L, true );

        List<LabelRecomendation> produceList = Arrays.asList( label );

        doReturn( produceList ).when( controller ).getLabels();
        doReturn( label ).when( controller ).addLabel( labelWithoutId );

    }

    @Test
    public void getAllLabelsShouldReturnAListAnd200() throws Exception {
        // Arrange
        LabelRecomendation label = new LabelRecomendation( 12, 2L, 2L, true );
        ;
        System.out.println( "to" + label );
        List<LabelRecomendation> produceList = Arrays.asList( label);

        String expectedJsonValue = mapper.writeValueAsString( produceList );
        // Act
        mockMvc.perform( get( "/labels" ) )
                .andDo( print() )
                .andExpect( status().isOk() )                 // Assert
                .andExpect( content().json( expectedJsonValue ) );
    }


    @Test
    public void ShouldGetLabelById() throws Exception {
        LabelRecomendation label = new LabelRecomendation( 12, 2L, 2L, true );
        List<LabelRecomendation> produceList = Arrays.asList( label );


        Mockito.when( controller.getLabelById( 12 ) ).thenReturn( label );

        LabelRecomendation labelService = controller.getLabelById( 12 );

        // Assert the response
        assertNotNull( String.valueOf( labelService ), "Employee with employeeId : " + 12 + " not found" );
        assertEquals( 12, labelService.getLid() );
        // assertEquals(track.getId(), trackService.getTrackId());
        assertEquals( label.getUserlId(), labelService.getUserlId() );
        assertEquals( label.getLikedL(), labelService.getLikedL() );
    }


    @Test
    public void createLabelShouldReturnNewProduceAndStatus201() throws Exception {
        // Arrange
        LabelRecomendation label = new LabelRecomendation( 12, 2L, 2L, true );
        System.out.println( "to" + label );
        LabelRecomendation labelWithoutId = new LabelRecomendation( 2L, 2L, true );
        System.out.println( "drugie" + labelWithoutId );
        String outputProduceJson = mapper.writeValueAsString( label );
        String inputProduceJson = mapper.writeValueAsString( labelWithoutId );

        // Act
        mockMvc.perform( post( "/labels" )
                                 .contentType( MediaType.APPLICATION_JSON )
                                 .content( inputProduceJson ) )
                .andDo( print() )
                .andExpect( status().isCreated() )            // Assert
                .andExpect( content().json( outputProduceJson ) );  // Assert
    }

    @Test
    public void ShouldUpdateLabel() throws Exception {
        LabelRecomendation label = new LabelRecomendation( 12, 2L, 2L, true );
        List<LabelRecomendation> produceList = Arrays.asList( label );

        Mockito.when( controller.getLabelById( 12 ) ).thenReturn( label );

        LabelRecomendation labelService = controller.getLabelById( 12 );

        labelService.setLabelId( 5L );

        labelService = controller.getLabelById( 12 );
        assertEquals( label.getLabelId(), labelService.getLabelId() );
    }


    @Test
    public void delateLabel() throws Exception {
        LabelRecomendation label = new LabelRecomendation( 12, 2L, 2L, true );
        List<LabelRecomendation> produceList = Arrays.asList( label );
        Mockito.when( controller.getLabelById( 12 ) ).thenReturn( label );
        boolean result = controller.deleteLabel( 12 );
        Mockito.verify( controller, times( 1 ) )
                .deleteLabel( 12 );
        assertEquals( result,
                      false );

    }
}
