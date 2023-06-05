drop table member;

create table member(
    id varchar2(100),
    name varchar2(100),
    password varchar2(100),
    address varchar2(200),
    code varchar2(100),
    gender varchar2(100)
);

insert into member (id, name, password, address, code, gender) values ('gnd', '가나다', '1234', '서울특별시 관악구 남부순환로 1820 에그옐로우 14층', '08787', 'female');
insert into member values ('lmb', '라마바', '1234', '서울특별시 관악구 남부순환로 1820 에그옐로우 14층',  '08787', 'female');
delete from member where id='gnd';
commit;
--rollback;
--transaction;

select * from member;
select * from member where id='gnd';
select id, name, password from member;
