create table member(
    member_id varchar2(20),
    member_pw varchar2(16),
    member_nickname varchar2(30),
    member_birth char(10),
    member_contact char(13)
    );

drop table member;

```sql
drop sequence board_seq;
create sequence board_seq;

drop table board;
create table board (
board_no number primary key,
board_title varchar2(300 byte) not null,
board_content varchar2(4000 byte) not null,
board_writer references member(member_id) on delete set null,
board_wtime date default sysdate not null,
board_utime date,
board_views number default 0 not null,
board_likes number default 0 not null,
board_replies number default 0 not null,
board_group number not null,
board_target references board(board_no) on delete cascade,
board_depth number not null,
check(board_no > 0),
check(board_views >= 0),
check(board_likes >= 0),
check(board_replies >= 0),
check(board_group > 0),
check(board_depth >= 0)
);
```


```sql
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth)
values(1, '첫 번째 게시글', '첫 번째 게시글 내용', 'testuser1', 1, null, 0);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth)
values(2, '두 번째 게시글', '두 번째 게시글 내용', 'testuser1', 2, null, 0);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth)
values(3, '세 번째 게시글', '세 번째 게시글 내용', 'testuser1', 2, 2, 1);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth)
values(4, '네 번째 게시글', '네 번째 게시글 내용', 'testuser1', 2, 2, 1);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth)
values(5, '다섯 번째 게시글', '다섯 번째 게시글 내용', 'testuser1', 2, 3, 2);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth)
values(6, '여섯 번째 게시글', '여섯 번째 게시글 내용', 'testuser1', 2, 4, 2);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth)
values(7, '일곱 번째 게시글', '일곱 번째 게시글 내용', 'testuser1', 7, null, 0);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth)
values(8, '여덟 번째 게시글', '여덟 번째 게시글 내용', 'testuser1', 7, 7, 1);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth)
values(9, '아홉 번째 게시글', '아홉 번째 게시글 내용', 'testuser1', 2, 3, 2);
commit;
```

```sql
drop sequence board_seq;
create sequence board_seq start with 10;
```