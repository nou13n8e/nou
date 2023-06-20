--자동증가(auto increment) 오라클에서는 시퀀스
create table replyBoard (
    id number primary key,
    userId varchar2(100) not null,
    name varchar2(100) not null,
    title varchar2(300) not null,
    contents clob not null,
    regdate date default sysdate,
    hit number,
    regroup number not null,
    relevel number not null,
    restep number not null,
    available number(1) default 1,
    constraint fk02_userId foreign key(userId) references member (id)
);

drop table replyBoard;
commit;

select * from replyBoard;

select nvl(max(regroup), 0) as regroupmax from replyBoard;

--댓글을 쓸 때 group안에 level을 1증가 시킴
update replyBoard set relevel=relevel+1 where regroup=2 and relevel>0;
rollback;

delete from replyBoard;

select rownum as no, b.* from(
    select * from replyBoard order by regroup desc, relevel asc
    ) b;










