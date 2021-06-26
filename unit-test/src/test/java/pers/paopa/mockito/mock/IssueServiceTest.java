package pers.paopa.mockito.mock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static info.solidsoft.mockito.java8.AssertionMatcher.assertArg;
import static org.assertj.core.api.Assertions.assertThat;

public class IssueServiceTest {

    private IssueRepository repository;

    @BeforeEach
    public void setup() {
        repository = Mockito.mock(IssueRepository.class);
    }

    @Test
    public void test() {
        repository.findById(1L);
        Mockito.verify(repository).findById(1L);
    }

    @Test
    public void test2() {
        repository.findById(1L);
        repository.findById(1L);
        Mockito.verify(repository, Mockito.times(2)).findById(1L);
    }

    @Test
    public void test3() {
        Mockito.verify(repository, Mockito.never()).findById(1L);
    }

    @Test
    public void test4() {
        repository.findById(1L);
        repository.findById(1L);
        Mockito.verify(repository, Mockito.times(2)).findById(1L);
        Mockito.verifyNoMoreInteractions(repository);
    }

    @Test
    public void testEq() {
        repository.findById(1L);
        Mockito.verify(repository).findById(Mockito.eq(1L));
    }

    @Test
    public void testAnyLong() {
        repository.findById(3L);
        Mockito.verify(repository).findById(Mockito.anyLong());
    }

    @Test
    public void testArgumentCaptor() {
        repository.findById(1L);
        ArgumentCaptor<Long> arg = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(repository).findById(arg.capture());
        Long actual = arg.getValue();
        assertThat(actual).isEqualTo(1L);
    }

    /**
     * 需要引入 mockito-java8
     */
    @Test
    public void testArgumentCaptor2() {
        repository.findById(1L);
        Mockito.verify(repository).findById(assertArg(
                argument -> Assertions.assertThat(argument).isEqualTo(1L)
        ));
    }
}
