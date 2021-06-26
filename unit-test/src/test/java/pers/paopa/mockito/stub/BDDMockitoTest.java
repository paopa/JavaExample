package pers.paopa.mockito.stub;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;

public class BDDMockitoTest {

    private IssueRepository repository;

    @BeforeEach
    public void setup() {
        repository = TestDouble.stub(IssueRepository.class);
    }

    @Test
    public void testCount() {
        given(repository.count()).willReturn(1L);
        long actualCount = repository.count();
        Assertions.assertThat(actualCount).isEqualByComparingTo(1L);
    }

    @Test
    public void testFindById1() {
        Issue expected = new Issue();

        given(repository.find(1L)).willReturn(expected);
        Issue actual = repository.find(1L);

        Assertions.assertThat(actual).isSameAs(expected);
    }

    @Test
    public void testFindById2() {
        Issue expected = new Issue();
        given(repository.find(eq(1L))).willReturn(expected);
        Issue actual = repository.find(1L);
        Assertions.assertThat(actual).isSameAs(expected);
    }

    @Test
    public void testFindById3() {
        Issue expected = new Issue();
        given(repository.find(anyLong())).willReturn(expected);
        Issue actual = repository.find(1L);
        Assertions.assertThat(actual).isSameAs(expected);
    }

    @Test
    public void testFindById4() {
        assertThrows(Exception.class, () -> {
            given(repository.find(1L)).willThrow(new Exception());
            repository.find(1L);
        });
    }

    @Test
    public void testDelete() {
        assertThrows(Exception.class, () -> {
            Issue deleted = new Issue();
            /*
              調用BDDMockito類別的方法，沒有回傳值，跟前面不一樣是以given()開頭
              willThrow(指定的Exception).given(Stub).執行方法
             */
            willThrow(new Exception()).given(repository).delete(deleted);
            repository.delete(deleted);
        });
    }

    @Test
    public void testFindById5() {
        Issue expected = new Issue();

        given(repository.find(1L)).willAnswer((Answer<Issue>) invocation -> {
            Long idParameter = (Long) invocation.getArguments()[0];
            if (idParameter.equals(1L)) {
                return expected;
            }
            return null;
        });

        Issue actual = repository.find(1L);
        Assertions.assertThat(actual).isSameAs(expected);

    }
}
