package pers.paopa.unit.test.stub;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IssueServiceImpl {

    private final IssueRepository repository;

    public Issue find(Issue issue) {
        return repository.find(issue);
    }

}
