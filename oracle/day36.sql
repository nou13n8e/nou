select * from board where id <= 160 and id > 150 order by id desc;

select * from board;
select * from board order by id desc;
--order by (column) desc;
--�����͸� �������� ����ϰ� ���� �� ���

select * from
(select rownum as no, b.* from 
(select * from board order by id desc) b) where no >= 1 and no <= 10;
--select�ȿ� select�� ����ִ� ����? ���� ����

select count(*) from board;