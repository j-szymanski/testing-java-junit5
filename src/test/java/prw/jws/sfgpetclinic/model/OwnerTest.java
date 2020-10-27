package prw.jws.sfgpetclinic.model;


import prw.jws.sfgpetclinic.CustomArgsProvider;
import prw.jws.sfgpetclinic.ModelTests;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
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

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Testing"})
    void testValueSource(String value) {
        System.out.println(value);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void testEnumSource(OwnerType value) {
        System.out.println(value.name());
    }

    @DisplayName("Csv Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL, 1, 1",
            "MI, 8, 5",
            "OH, 2, 3"
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println("State name " + stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("Csv Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String stateName, int val1, int val2) {
        System.out.println("State name " + stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("Method ProviderTest")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void mentodProviderTest(String stateName, int val1, int val2) {
        System.out.println("State name " + stateName + " = " + val1 + ":" + val2);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("FL", 1, 3),
                Arguments.of("MI", 4, 5),
                Arguments.of("OH", 6, 7),
                Arguments.of("RI", 8, 9));
    }

    @DisplayName("Class (Custom) Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void customProviderTest(String stateName, int val1, int val2) {
        System.out.println("State name " + stateName + " = " + val1 + ":" + val2);
    }
}
