drop table member;

create table member(
    id varchar2(100) unique not null,
    --id varchar2(100) primary key,�� �ۼ� ����
    --��������: unique�ߺ� �Ұ�, not null�� �Ұ�
    name varchar2(100) not null,
    password varchar2(100) not null,
    email varchar2(100) not null,
    zonecode number(5) not null,
    address varchar2(300) not null,
    detailaddress varchar2(100),
    extraaddress varchar2(100)
);

select * from member;

select * from member where id='gnd';
select id,name,address,zonecode,lpad(zonecode,5,'0'),detailAddress from member;

delete from member where id='lmb' and password='1234';
rollback;

