create table if not exists a
(
    id
    int,
    s
    text
);

insert into a
select generate_series(1, 10), 'test-text';