//package com.company.musicstorecatalog.controller;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//@AutoConfigureMockMvc(addFilters = false)
//@RunWith(SpringRunner.class)
//@WebMvcTest(AlbumController.class)
//public class AlbumControllerTest {}
//  /*@Autowired
//    private MockMvc mockMvc;
//    @MockBean
//   // ObjectMapper used to convert Java objects to JSON and vice versa
//    private ObjectMapper mapper = new ObjectMapper();
//
//
//        // ACT
//        mockMvc.perform(get("/records/2"))
//                .andDo(print())
//                .andExpect(status().isOk())                     // ASSERT that we got back 200 OK.
//                .andExpect(content().json(outputJson));         // ASSERT that what we're expecting is what we got back.
//    */