package pers.paopa.unit.test.spy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SpyTest {

    private static final String TITLE = "TITLE";
    private IssueRepositorySpy repository;

    @BeforeEach
    public void setup(){
        repository = new IssueRepositorySpy();
    }

    @Test
    public void test() {
        //arrange
        Issue issue = new Issue();
        issue.setTitle(TITLE);
        //act
        repository.save(issue);
        //assert
        int executionCount = repository.getSaveExecutionCount();
        Assertions.assertThat(executionCount).isEqualTo(1);
        List<Issue> list = repository.getList();
        Assertions.assertThat(list).contains(issue);
    }
}
