package pers.paopa.unit.test.fake;

import java.util.HashMap;
import java.util.Map;

public class IssueRepositoryFake implements IssueRepository {

    private long nextId;
    private Map<Long, Issue> map;

    public IssueRepositoryFake() {
        this.nextId = 1;
        this.map = new HashMap<>();
    }

    @Override
    public Issue findById(Long id) {
        return this.map.get(id);
    }

    @Override
    public Issue save(Issue issue) {
        issue.setId(nextId);
        this.map.put(nextId, issue);
        nextId++;
        return issue;
    }
}
