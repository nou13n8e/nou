select * from member;

select count(*) from member;
select count(*) as count from member where id='gnd';

delete from member where id='saj';
commit;

select count(*) as count from member where id = 'gnd';

update member set name='가나다라',email='ganadara@ganadara.com' where id='gnd' and password='1234';
rollback;