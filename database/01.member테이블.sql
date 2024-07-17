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