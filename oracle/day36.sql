select * from board where id <= 160 and id > 150 order by id desc;

select * from board;
select * from board order by id desc;
--order by (column) desc;
--데이터를 역순으로 출력하고 싶을 때 사용

select * from
(select rownum as no, b.* from 
(select * from board order by id desc) b) where no >= 1 and no <= 10;
--select안에 select가 들어있는 형태? 서브 쿼리

select count(*) from board;