package prw.jws.sfgpetclinic.controllers;

import prw.jws.sfgpetclinic.fauxspring.Model;
import prw.jws.sfgpetclinic.fauxspring.ModelMapImpl;
import prw.jws.sfgpetclinic.model.Speciality;
import prw.jws.sfgpetclinic.model.Vet;
import prw.jws.sfgpetclinic.services.SpecialtyService;
import prw.jws.sfgpetclinic.services.VetService;
import prw.jws.sfgpetclinic.services.map.SpecialityMapService;
import prw.jws.sfgpetclinic.services.map.VetMapService;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("controller")
class VetControllerTest {

    SpecialtyService specialityService;
    VetService vetService;

    VetController sut;
    @BeforeEach
    void setUp() {
        specialityService = new SpecialityMapService();
        vetService = new VetMapService(specialityService);
        sut = new VetController(vetService);
        Vet vet1 = new Vet(1L, "Jon", "Doe",null);// Set.of(new Speciality(1L, "Rabbit")));
        Vet vet2 = new Vet(2L, "Jane", "Cormish", null);
        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();
        final String view = sut.listVets(model);
        assertEquals("vets/index", view);
        Set modelAttribute = (Set)((ModelMapImpl)model).getMap().get("vets");
        assertEquals(2, modelAttribute.size());
    }
}
