package prw.jws.sfgpetclinic.model;


import prw.jws.sfgpetclinic.ModelTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@Tag("models")
class OwnerTest implements ModelTests {
    Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner(1L, "Jon", "Doe");
        owner.setCity("Warsaw");
        owner.setTelephone("123456789");
    }

    @Test
    void dependentAssertions() {
        assertAll("Properties test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Jon", owner.getFirstName(), "Owner First Name does not match"),
                        () -> assertEquals("Doe", owner.getLastName(), "Owner Last Name does not match")
                )
                ,
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Warsaw", owner.getCity(), "Owner City does not match"),
                        () -> assertEquals("123456789", owner.getTelephone(), "Owner Phone does not match")
                )
        );
        //Hamcrest assertions
        assertThat(owner.getCity(), is("Warsaw"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Spring", "Framework", "Testing"})
    void testValueSource(String value) {
        System.out.println(value);
    }
}
