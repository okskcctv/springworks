CREATE USER c##prjnet
IDENTIFIED BY spring
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;

GRANT CONNECT, DBA TO
c##prjnet;

CREATE TABLE member(
    id      VARCHAR2(50) PRIMARY KEY,
    pw      VARCHAR2(20) NOT NULL,
    name    VARCHAR2(10) NOT NULL,
    age     NUMBER NOT NULL
);

CREATE TABLE board(
    bno     NUMBER PRIMARY KEY,
    title   VARCHAR2(50) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    image   VARCHAR2(20),
    id      VARCHAR2(50) NOT NULL,
    CONSTRAINT fk_member_board FOREIGN KEY(id)
    REFERENCES member(id) ON DELETE CASCADE
);

-- 댓글 개수 칼럼 추가 (넣을지 말지 고민중)
ALTER TABLE board ADD replycnt NUMBER DEFAULT 0;

DROP TABLE board;
DROP TABLE member;
DROP TABLE member_auth;

CREATE TABLE member_auth(
    id      VARCHAR2(50) NOT NULL,
    auth    VARCHAR2(10) NOT NULL,
    CONSTRAINT fk_member_auth FOREIGN KEY(id)
    REFERENCES member(id) ON DELETE CASCADE
);

CREATE SEQUENCE seq;

DROP SEQUENCE seq;

INSERT INTO member VALUES ('admin', 'admin', '관리자', '19');
INSERT INTO member VALUES ('member', 'member', '멤버', '19');
INSERT INTO member VALUES ('kids', 'kids', '어린이', '12');

INSERT INTO board (bno, title, content, id)
VALUES (seq.NEXTVAL, '관리자 입니다', '내용입니다', 'admin');

INSERT INTO member_auth VALUES ('admin', 'ADMIN');
INSERT INTO member_auth VALUES ('member', 'MEMBER');
INSERT INTO member_auth VALUES ('kids', 'KIDS');

SELECT * FROM member;
SELECT * FROM board;
SELECT * FROM member_auth;

SELECT id, pw FROM member;

COMMIT;