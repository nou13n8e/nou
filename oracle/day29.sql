drop table member;

create table member(
    id varchar2(100),
    name varchar2(100),
    password varchar2(100),
    address varchar2(200),
    code varchar2(100),
    gender varchar2(100)
);

insert into member (id, name, password, address, code, gender) values ('gnd', '������', '1234', '����Ư���� ���Ǳ� ���μ�ȯ�� 1820 ���׿��ο� 14��', '08787', 'female');
insert into member values ('lmb', '�󸶹�', '1234', '����Ư���� ���Ǳ� ���μ�ȯ�� 1820 ���׿��ο� 14��',  '08787', 'female');
delete from member where id='gnd';
commit;
--rollback;
--transaction;

select * from member;
select * from member where id='gnd';
select id, name, password from member;
