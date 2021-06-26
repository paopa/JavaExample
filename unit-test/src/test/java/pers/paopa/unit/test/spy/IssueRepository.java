package pers.paopa.unit.test.spy;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public interface IssueRepository {
    Issue save(Issue issue);
}

@Data
class Issue {

    private Long id;
    private String desc;
    private String title;
}

final class IssueRepositorySpy implements IssueRepository {

    private int saveExecutionCount;
    private List<Issue> list;

    public IssueRepositorySpy() {
        this.saveExecutionCount = 0;
        list = new ArrayList<>();
    }

    public int getSaveExecutionCount() {
        return this.saveExecutionCount;
    }

    public List<Issue> getList() {
        return this.list;
    }

    @Override
    public Issue save(Issue issue) {
        this.saveExecutionCount++;
        list.add(issue);
        return issue;
    }
}
