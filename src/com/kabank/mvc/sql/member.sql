drop sequence customNum;
drop table member;
select * from member;
select * from tab;
select * from bank;
select * from phone;
select * from member where id like ?; //로그인할때 쓰임
update member set addr = '서울' where id = 'abc123';
update member set pass = '$' where id = '@';
create sequence custom_Num start with 1000;
create table kakao(
 custom_Num number primary key,
 account_Num varchar2(20) not null,
 money VARCHAR2(20) default 0,
 id VARCHAR2(20),
 foreign key(id) references Member(id)
 on delete cascade
);

insert into Bank(customNum,accountNum,money,id)
into('10000','1234-5678','0','abc123');

select 
m.id as 아이디,
m.pass as 비번,
m.name as 이름,
m.ssn as 주민번호,
m.phone as 폰번호,
m.email as 이메일,
m.profile as 프로필,
a.customnum as 고객번호,
a.accountnum as 계좌번호,
a.money as 잔액
from member m,bank a
where m.id = a.id 
order by a.customnum














