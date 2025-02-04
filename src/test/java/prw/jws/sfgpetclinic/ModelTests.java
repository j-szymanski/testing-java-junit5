package prw.jws.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Tag("models")
public interface ModelTests {
    @BeforeEach
    default void beforeEach(TestInfo testInfo){
        StringBuilder sb = new StringBuilder(1000);
        sb.append("INFO: running test ").append(testInfo.getDisplayName()).append('\n');

        if (nonNull(testInfo.getTags()) && !testInfo.getTags().isEmpty()){
            sb.append("INFO:     with tags [");
            testInfo.getTags().forEach(tag ->sb.append(tag).append(", "));
            sb.append(("]\n"));
        }
        else {
            System.out.println("INFO: "+(isNull(testInfo.getTags())?"TAGS set is NULL":"TAGS set IS EMPTY"));
        }
        sb.append("INFO:     for ").append(testInfo.getTestClass()).append('#').append(testInfo.getTestMethod()).append('\n');
        System.out.println(sb.toString());
    }
}
