package prw.jws.sfgpetclinic.services.map;

import prw.jws.sfgpetclinic.model.Owner;
import prw.jws.sfgpetclinic.model.PetType;
import prw.jws.sfgpetclinic.services.PetService;
import prw.jws.sfgpetclinic.services.PetTypeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@DisplayName("Owner map service test - ")
class OwnerMapServiceTest {
    OwnerMapService ownerMapService;
    PetTypeService petTypeService;
    PetService petService;

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);

        System.out.println("setUp in Owner Map Service Test");
    }

    @DisplayName("Verify Zero Owners")
    @Test
    void ownersAreZero() {
        final int ownersCount = ownerMapService.findAll().size();
        assertEquals(0, ownersCount);
    }

    @DisplayName("Pet Type - ")
    @Nested
    class TestCreatePetTypes {
        @BeforeEach
        void setUp() {
            PetType petType1 = new PetType(1L, "Dog");
            PetType petType2 = new PetType(2L, "Cat");
            petTypeService.save(petType1);
            petTypeService.save(petType2);

            System.out.println("setUp in PetType Service Test");
        }

        @DisplayName("Pet Type Count of 2")
        @Test
        void testPetTypeCount() {
            int petTypeCount = petTypeService.findAll().size();
            assertEquals(2, petTypeCount);
        }

        @DisplayName("Save Owners Test - ")
        @Nested
        class SaveOwnersTest {
            @BeforeEach
            void setUp() {
                ownerMapService.save(new Owner(1L, "Before", "Each"));
                System.out.println("setUp in SaveOwner Test");
            }

            @Test
            void saveOwner() {
                Owner owner = new Owner(2L, "Joe", "Black");
                Owner savedOwner = ownerMapService.save(owner);
                assertNotNull(savedOwner);
            }

            @DisplayName("Find Owners Test - ")
            @Nested
            class FindOwnersTest {

                @DisplayName("Find Owner")
                @Test
                void findOwner() {
                    Owner foundOwner = ownerMapService.findById(1L);
                    assertNotNull(foundOwner);
                }

                @DisplayName("Find Owner Not Found")
                @Test
                void findOwnerNotFound() {
                    Owner owner = ownerMapService.findById(2L);
                    assertNull(owner);
                }
            }
        }
    }

    @DisplayName("Verify Still Zero Owners")
    @Test
    void ownersAreStillZero() {
        final int ownersCount = ownerMapService.findAll().size();
        assertEquals(0, ownersCount);
    }
}
