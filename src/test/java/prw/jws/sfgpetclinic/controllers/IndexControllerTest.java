package prw.jws.sfgpetclinic.controllers;

import prw.jws.sfgpetclinic.controllers.exceptions.ValueNotFoundException;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("controllers")
class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test proper view returned for index")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view returned");

        //AssertJ Fluent assertions
        assertThat(controller.index()).isEqualTo("index");
    }

    @Test
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () ->controller.oopsHandler());
//        assertTrue("notimplemented".equals(controller.oopsHandler()), () -> "This is an EXPENSIVE message provided in lambda!");
    }

    @Disabled
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("Thread awake");
        }, "Timeout exceeded");
    }

    @Disabled
    @Test
    void testTimeoutPreemptively() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("Preemptive: Thread is going further");
        }, "Preemptive timeout exceeded!");
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueValid() {
        assumeTrue("GURU".equalsIgnoreCase("guru"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testOnMac() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testOnJava11() {
    }

    @EnabledForJreRange(min = JRE.JAVA_9)
    @Test
    void testOnJavaHigherThan8() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "JUREK|jurek")
    @Test
    void testIfUserJurekOnWindows() {

    }

    @EnabledOnOs(OS.MAC)
    @EnabledIfEnvironmentVariable(named = "USER", matches = "JUREK|jurek")
    @Test
    void testIfUserJurekOnMac() {

    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "ADMIN")
    @Test
    void testIfUserAdmin() {

    }
}
