create table review_slr(
    id_review_slr varchar2(100),
    title varchar2(200),
    constraint pk_review_slr primary key(id_review_slr)
);

create table relevance(
    id number,
    id_review_slr varchar2(100),
    id_user varchar(20),
    keyword varchar2(100),
    --constraint fk_id_review foreign key(id_review_slr) references review_slr(id_review_slr)
    constraint fk_id_user foreign key(id_user) references searcher(id)
    );
