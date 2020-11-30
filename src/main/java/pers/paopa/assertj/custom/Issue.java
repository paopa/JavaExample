package pers.paopa.assertj.custom;

import lombok.Data;

@Data
public class Issue {
    private Long id;
    private ActiveState activeState;
    private ResultState resultState;
    private String creator;
    private String solver;
    private String log;
}

enum ActiveState {
    TODO, PROGRESS, DONE
}

enum ResultState {
    RESOLVED, UNSOLVED
}
