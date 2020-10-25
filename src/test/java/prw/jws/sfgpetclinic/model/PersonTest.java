package prw.jws.sfgpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    Person person;

    @BeforeEach
    void setUp() {
        //given
        person = new Person(1L, "Jon", "Doe");
    }

    @Test
    void groupedAssertions() {
        //given
        //when
        //then
        assertAll("Test Props Set",
                ()->assertEquals("Jon", person.getFirstName()),
                ()->assertEquals("Doe", person.getLastName()),
                ()->assertEquals(1L, person.getId())
        );
    }

    @Test
    void groupedAssertionsWithMessages() {
        //given
        //when
        //then
        assertAll("Test Props Set",
                ()->assertEquals("Jon", person.getFirstName(), "First Name failed"),
                ()->assertEquals("Doe", person.getLastName(), "Last Name failed"),
                ()->assertEquals(1L, person.getId())
        );
    }
}
