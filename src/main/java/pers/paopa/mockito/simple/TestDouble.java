package pers.paopa.mockito.simple;

import static org.mockito.Mockito.mock;

public class TestDouble {

    private TestDouble() {
    }

    public static <T> T stub(Class<T> stubClass) {
        return mock(stubClass);
    }
}
