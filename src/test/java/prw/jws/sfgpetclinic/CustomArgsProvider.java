package prw.jws.sfgpetclinic;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

/**
 * Created by Jerzy Szymanski on 27.10.2020 at 22:00
 */
public class CustomArgsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(final ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("FL", 11, 23),
                Arguments.of("MI", 14, 25),
                Arguments.of("OH", 16, 27),
                Arguments.of("RI", 18, 29));
    }
}
