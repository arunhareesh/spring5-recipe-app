package arun.spring.services;

import arun.spring.commands.UnitOfMeasureCommand;
import arun.spring.converters.UnitOfMeasureToUnitOfMeasureCommand;
import arun.spring.domain.UnitOfMeasure;
import arun.spring.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UnitOfMeasureServiceImplTest {
    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService service;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new UnitOfMeasureServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    void listAllUoms() {
        //given
        Set<UnitOfMeasure> uomSet = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        uomSet.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom1.setId(2L);
        uomSet.add(uom2);

        when(unitOfMeasureRepository.findAll()).thenReturn(uomSet);

        //when
        Set<UnitOfMeasureCommand> uomCommands = service.listAllUoms();

        //then
        assertEquals(2, uomCommands.size());
        verify(unitOfMeasureRepository,times(1)).findAll();

    }
}