alter table board modify contents clob;
--2GB정도 까지의 데이터도 넣을 수 있다

alter table member add profile varchar(100);
alter table member add realprofile varchar(100);
--2개를 넣은 이유 : 파일이 rename이 되었을 경우 대비