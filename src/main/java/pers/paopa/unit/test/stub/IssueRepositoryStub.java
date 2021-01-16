package pers.paopa.unit.test.stub;

final public class IssueRepositoryStub implements IssueRepository {

    private final Issue issue;

    public IssueRepositoryStub(Issue issue) {
        this.issue = issue;
    }

    @Override
    public Issue find(Issue issue) {
        issue.setDesc(this.issue.getDesc());
        issue.setTitle(this.issue.getTitle());
        return issue;
    }
}
