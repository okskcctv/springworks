CREATE USER c##prjnet
IDENTIFIED BY spring
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;

GRANT CONNECT, DBA TO
c##prjnet;

CREATE TABLE member(
    uno     NUMBER PRIMARY KEY,
    id      VARCHAR2(50) NOT NULL,
    pw      VARCHAR2(20) NOT NULL,
    name    VARCHAR2(10) NOT NULL,
    age     NUMBER NOT NULL
);

CREATE TABLE board(
    bno     NUMBER PRIMARY KEY,
    title   VARCHAR2(50) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    image   VARCHAR2(20),
    uno     NUMBER NOT NULL,
    CONSTRAINT fk_member_board FOREIGN KEY(uno)
    REFERENCES member(uno) ON DELETE CASCADE
);

DROP TABLE board;

CREATE TABLE member_auth(
    uno     NUMBER NOT NULL,
    auth    VARCHAR2(10) NOT NULL,
    CONSTRAINT fk_member_auth FOREIGN KEY(uno)
    REFERENCES member(uno) ON DELETE CASCADE
);

CREATE SEQUENCE seq;
CREATE SEQUENCE seq_b;

INSERT INTO member VALUES (seq.NEXTVAL, 'admin', 'admin', '관리자', '19');
INSERT INTO member VALUES (seq.NEXTVAL, 'member', 'member', '멤버', '19');
INSERT INTO member VALUES (seq.NEXTVAL, 'kids', 'kids', '어린이', '12');

INSERT INTO board (bno, title, content, uno)
VALUES (seq_b.NEXTVAL, '관리자 입니다', '내용입니다', 1);

INSERT INTO member_auth VALUES (1, 'ADMIN');
INSERT INTO member_auth VALUES (2, 'MEMBER');
INSERT INTO member_auth VALUES (3, 'KIDS');

SELECT * FROM member;
SELECT * FROM board;
SELECT * FROM member_auth;

COMMIT;