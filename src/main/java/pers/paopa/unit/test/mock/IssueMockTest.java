package pers.paopa.unit.test.mock;

import lombok.Builder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IssueMockTest {
    private static final Long ID = 66L;
    private IssueRepositoryMock issueRepository;

    @BeforeEach
    public void setup() {
        this.issueRepository = new IssueRepositoryMock();
    }

    @Test
    public void test1() {
        issueRepository.setExpectedArgumentId(ID);
        issueRepository.deleteById(ID);
        issueRepository.verify();
    }

    @Test
    public void test2() {
        Issue issue = Issue.builder().id(ID).build();
        issueRepository.setReturnIssue(issue);
        Issue returnIssue = issueRepository.deleteById(ID);
        Assertions.assertThat(returnIssue).isSameAs(issue);
    }
}

interface IssueRepository {
    Issue deleteById(Long id);
}

final class IssueRepositoryMock implements IssueRepository {

    private Issue returnIssue;

    public void setExpectedArgumentId(Long expectedArgumentId) {
        this.expectedArgumentId = expectedArgumentId;
    }

    private Long expectedArgumentId;

    public void setReturnIssue(Issue returnIssue) {
        this.returnIssue = returnIssue;
    }

    private Long actualArgumentId;

    public void setActualArgumentId(Long actualArgumentId) {
        this.actualArgumentId = actualArgumentId;
    }

    private boolean deleteByIdCalled = false;

    @Override
    public Issue deleteById(Long id) {
        this.actualArgumentId = id;
        deleteByIdCalled = true;
        return this.returnIssue;
    }

    public void verify() {
        assertThat(this.deleteByIdCalled)
                .overridingErrorMessage("Expected that deleteById() was called " +
                        "but it was not").isTrue();
        assertThat(this.actualArgumentId)
                .overridingErrorMessage("Invalid id argument. Expected %d but was: %d",
                        this.expectedArgumentId, this.actualArgumentId)
                .isEqualByComparingTo(this.expectedArgumentId);
    }
}

@Builder
class Issue {
    private Long id;
}
