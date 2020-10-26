package prw.jws.sfgpetclinic.model;

import prw.jws.sfgpetclinic.ModelRepeatedTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;


class PersonRepeatedTest implements ModelRepeatedTest {
    Person person;

    @BeforeEach
    void setUp() {
        //given
        person = new Person(1L, "Jon", "Doe");
    }

    @RepeatedTest(value = 10, name="{displayName}: {currentRepetition}/{totalRepetitions}")
    @DisplayName("My repeated test")
    void myRepeatedPersonTest() {
        //todo
    }


    @RepeatedTest(5)
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName()+ ": "+repetitionInfo.getCurrentRepetition()+"/"+repetitionInfo.getTotalRepetitions());
    }

}
