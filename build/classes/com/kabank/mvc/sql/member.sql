select * from member;
select * from tab;
select * from attend;
select * from member where id like ?; //로그인할때 쓰임
update member set addr = '서울' where id = 'abc123';
update member set pass = '$' where id = '@';
