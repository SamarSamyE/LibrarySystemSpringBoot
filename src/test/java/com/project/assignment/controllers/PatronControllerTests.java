package com.project.assignment.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.assignment.models.request.PatronReqModel;
import com.project.assignment.models.response.PatronResModel;
import com.project.assignment.services.PatronService;

@ExtendWith(MockitoExtension.class)
public class PatronControllerTests {

    @Mock
    private PatronService patronService;

    @InjectMocks
    private PatronController patronController;

    @Test
    public void testCreatePatron() {
        when(patronService.createPatron(any(PatronReqModel.class))).thenReturn(1);
        ResponseEntity<Integer> response = patronController.createPatron(new PatronReqModel());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody());
     }

    @Test
    public void testUpdatePatron() {
        when(patronService.updatePatron(anyInt(), any(PatronReqModel.class))).thenReturn(1);
        ResponseEntity<Integer> response = patronController.updatePatron(1, new PatronReqModel());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody());
    }

    @Test
    public void testGetPatronById() {
        when(patronService.getPatronById(anyInt())).thenReturn(new PatronResModel());
        ResponseEntity<PatronResModel> response = patronController.getPatronById(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        
    }

    @Test
    public void testGetAllPatrons() {
        when(patronService.getAllPatrons()).thenReturn(List.of(new PatronResModel(), new PatronResModel()));
        ResponseEntity<List<PatronResModel>> response = patronController.getAllPatrons();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        
        
        
    }

    @Test
    public void testDeletePatronById() {
        ResponseEntity<Void> response = patronController.deletePatronById(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}