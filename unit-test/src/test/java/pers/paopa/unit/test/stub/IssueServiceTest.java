package pers.paopa.unit.test.stub;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IssueServiceTest {

    private static final Long ID = 66L;
    private IssueRepository repository;

    @BeforeEach
    public void setup() {
        Issue issue = new Issue();
        issue.setDesc("DESC");
        issue.setTitle("TITLE");
        repository = new IssueRepositoryStub(issue);
    }

    @Test
    public void test() {
        IssueServiceImpl service = new IssueServiceImpl(repository);
        Issue issue = new Issue();
        issue.setId(ID);

        Issue actual = service.find(issue);

        Assertions.assertThat(actual)
                .extracting(Issue::getDesc, Issue::getTitle)
                .doesNotContainNull()
                .contains("DESC", "TITLE");
    }
}
