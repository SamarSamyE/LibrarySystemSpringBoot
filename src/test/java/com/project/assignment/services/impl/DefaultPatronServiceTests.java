package com.project.assignment.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.assignment.entities.Patron;
import com.project.assignment.models.mapinterface.PatronMapper;
import com.project.assignment.models.request.PatronReqModel;
import com.project.assignment.models.response.PatronResModel;
import com.project.assignment.repositories.PatronRepository;

@ExtendWith(MockitoExtension.class)
public class DefaultPatronServiceTests {

    @Mock
    private PatronRepository patronRepository;

    @Mock
    private PatronMapper patronMapper;

    @InjectMocks
    private DefaultPatronService patronService;

    @Test
    public void testCreatePatron() {
        PatronReqModel patronReqModel = new PatronReqModel();
        patronReqModel.setName("SamarSamyYacout");
        when(patronRepository.save(any(Patron.class))).thenAnswer(invocation -> {
            Patron patronArgument = invocation.getArgument(0);
            patronArgument.setId(1); 
            return patronArgument;
        });

        int patronId = patronService.createPatron(patronReqModel);
        assertNotNull(patronId);
        assertEquals(1, patronId); 
        
    }

    @Test
    public void testUpdatePatron() {
        int patronId = 1;
        PatronReqModel patronReqModel = new PatronReqModel();
        patronReqModel.setName("SamarSamyYacout");
        when(patronRepository.findById(patronId)).thenReturn(Optional.of(new Patron()));
        when(patronRepository.save(any(Patron.class))).thenAnswer(invocation -> {
            Patron updatedPatron = invocation.getArgument(0);
            updatedPatron.setId(patronId);
            return updatedPatron;
        });
        int updatedPatronId = patronService.updatePatron(patronId, patronReqModel);
        assertNotNull(updatedPatronId);
        assertEquals(patronId, updatedPatronId); 
    }

    @Test
    public void testGetPatronById() {
        int patronId = 1;
        when(patronRepository.findById(patronId)).thenReturn(Optional.of(new Patron()));
        when(patronMapper.mapToPatronResModel(any(Patron.class))).thenReturn(new PatronResModel());
        PatronResModel patronResModel = patronService.getPatronById(patronId);
        assertNotNull(patronResModel);
    }

    @Test
    public void testGetAllPatrons() {
        when(patronRepository.findAll()).thenReturn(Collections.singletonList(new Patron()));
        when(patronMapper.mapToPatronResModel(anyList())).thenReturn(Collections.singletonList(new PatronResModel()));
        List<PatronResModel> patronResModels = patronService.getAllPatrons();
        assertNotNull(patronResModels);
        assertEquals(1, patronResModels.size());         
    }

    @Test
    public void testDeletePatronById() {
        int patronId = 1;
        assertDoesNotThrow(() -> patronService.deletePatronById(patronId));
        verify(patronRepository, times(1)).deleteById(patronId);
    }
}