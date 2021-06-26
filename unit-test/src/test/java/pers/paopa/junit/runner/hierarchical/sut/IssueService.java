package pers.paopa.junit.runner.hierarchical.sut;

public class IssueService {

    public Issue findById(long id) {
        return new Issue(id);
    }
}
