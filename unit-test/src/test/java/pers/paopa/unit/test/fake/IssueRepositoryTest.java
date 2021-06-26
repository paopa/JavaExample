package pers.paopa.unit.test.fake;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IssueRepositoryTest {

    private static final Long ID = 1L;
    private static final String TITLE = "ISSUE";

    private IssueRepository repository= new IssueRepositoryFake();;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void saveTest() {
        Issue issue = new Issue();
        issue.setTitle(TITLE);
        Issue actual1 = repository.save(issue);
        Assertions.assertThat(actual1)
                .extracting(Issue::getId, Issue::getTitle)
                .contains(ID, TITLE);

        Issue actual2 = repository.findById(ID);
        Assertions.assertThat(actual2)
                .extracting(Issue::getId, Issue::getTitle)
                .contains(ID, TITLE);
    }

}
