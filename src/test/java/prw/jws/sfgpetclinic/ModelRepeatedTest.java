package prw.jws.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Tag("repeated")
public interface ModelRepeatedTest {
    @BeforeEach
    default void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo){
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
        if (nonNull(repetitionInfo)) {
            sb.append("INFO:     Repetition ").append(repetitionInfo.getCurrentRepetition())
              .append(" of ").append(repetitionInfo.getCurrentRepetition());
        }
        else {
            System.out.println("INFO: RepetitionInfo is NULL");
        }
        System.out.println(sb.toString());

    }
}
