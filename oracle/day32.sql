--�ڵ�����(auto increment) ����Ŭ������ ������
create table board (
    id number primary key,
    userId varchar2(100) not null,
    name varchar2(100) not null,
    title varchar2(300) not null,
    contents varchar2(3000) not null,
    regdate date default sysdate,
    hit number,
    constraint fk_userId foreign key(userId) references member (id)
);

drop table board;

insert into board values (seq_board.nextval, 'gnd', '������', '����', '����', sysdate, 0);
rollback;

select * from board where id <= 160 and id > 150 order by id desc;


update board set hit=hit+1 where id=8;



