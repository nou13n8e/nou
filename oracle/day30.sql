drop table member;

create table member(
    id varchar2(100),
    name varchar2(100),
    password varchar2(100),
    zonecode number(5),
    address varchar2(300),
    detailaddress varchar2(100),
    extraaddress varchar2(100)
);

select * from member;

select * from member where id='gnd';
select id,name,address,zonecode,lpad(zonecode,5,'0'),detailAddress from member;

delete from member where id='lmb' and password='1234';
rollback;