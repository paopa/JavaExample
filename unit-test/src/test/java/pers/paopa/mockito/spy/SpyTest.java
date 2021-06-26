package pers.paopa.mockito.spy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

public class SpyTest {

    private IssueRepository repository;

    @BeforeEach
    public void setup() {
        repository = Mockito.spy(new IssueRepositoryImpl());
    }

    @Test
    public void ExecuteTimesTest() {
        //arrange
        Issue expected = new Issue();
        expected.setTitle("nya-hello");
        //act
        Issue saved = repository.save(expected);
        //assert
        Mockito.verify(repository, Mockito.times(1)).save(saved);
    }

    @Test
    public void testReturnObject() {
        //arrange
        Issue expected = new Issue();
        BDDMockito.willReturn(expected).given(repository).save(Mockito.any());
        //act
        Issue saved = repository.save(expected);
        Assertions.assertThat(saved).isSameAs(expected);
    }
}
