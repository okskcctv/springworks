select * from all_users;

drop user c##spring;

create user c##spring identified by spring
default tablespace users
temporary tablespace TEMP;

grant connect, dba to c##spring;

commit;

-- board ���̺� ����
CREATE TABLE tbl_board(
    bno         NUMBER(5),
    title       VARCHAR2(200) NOT NULL,
    writer      VARCHAR2(20) NOT NULL,
    content     VARCHAR2(2000) NOT NULL,
    regdate     DATE DEFAULT SYSDATE,
    updatedate  DATE DEFAULT SYSDATE,
    cnt         NUMBER(5) DEFAULT 0,
    replycnt    NUMBER DEFAULT 0
);
-- �⺻Ű ���� ���� �̸� ����
ALTER TABLE tbl_board ADD CONSTRAINT pk_board
PRIMARY KEY(bno);

-- ������ : �ڵ� ����
CREATE SEQUENCE seq;

DROP SEQUENCE seq;

ALTER TABLE board RENAME TO tbl_board;

DROP TABLE tbl_board;

-- ��� ���� Į�� �߰�
ALTER TABLE tbl_board ADD replycnt NUMBER DEFAULT 0;

-- �Խñ� �߰�
INSERT INTO tbl_board(bno, title, writer, content)
VALUES (seq.NEXTVAL, '�����λ�', '������', '�� ��Ź�帳�ϴ�...');

-- user ���̺� ����
CREATE TABLE tbl_user(
    id      VARCHAR2(8) PRIMARY KEY,
    passwd  VARCHAR2(8) NOT NULL,
    name    VARCHAR2(20) NOT NULL,
    role    VARCHAR2(5)
);

ALTER TABLE users RENAME TO tbl_users;

ALTER TABLE tbl_users RENAME TO tbl_user;

-- ȸ�� �߰�
INSERT INTO tbl_user VALUES ('test', 'test123', '������', 'Admin');
INSERT INTO tbl_user VALUES ('user1', 'user123', '��׷�', 'User');

COMMIT;

-- Spring security
CREATE TABLE users(
    username    VARCHAR2(50) NOT NULL PRIMARY KEY,
    password    VARCHAR2(50) NOT NULL,
    enabled     CHAR(1) DEFAULT '1'
);

CREATE TABLE authorities(
    username    VARCHAR2(50) NOT NULL,
    authority   VARCHAR2(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY(username)
    REFERENCES users(username)
);

-- index ����
CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

-- users �߰�
INSERT INTO users(username, password) VALUES ('user00', 'pw00');
INSERT INTO users(username, password) VALUES ('member00', 'pw00');
INSERT INTO users(username, password) VALUES ('admin00', 'pw00');

-- ���� �߰�
INSERT INTO authorities(username, authority) VALUES ('user00', 'ROLE_USER');
INSERT INTO authorities(username, authority) VALUES ('member00', 'ROLE_MEMBER');
INSERT INTO authorities(username, authority) VALUES ('admin00', 'ROLE_MEMBER');
INSERT INTO authorities(username, authority) VALUES ('admin00', 'ROLE_ADMIN');

SELECT * FROM users;
SELECT * FROM authorities;

COMMIT;


-- Security ȸ�� ���̺�� ���� ���̺�
CREATE TABLE tbl_member(
    userid      VARCHAR2(50) PRIMARY KEY,
    userpw      VARCHAR2(100) NOT NULL,
    username    VARCHAR2(100) NOT NULL,
    regdate     DATE DEFAULT SYSDATE,
    updatedate  DATE DEFAULT SYSDATE,
    enabled     CHAR(1) DEFAULT '1'
);

CREATE TABLE tbl_member_auth(
    auth        VARCHAR2(50) NOT NULL,
    userid      VARCHAR2(50) NOT NULL,
    CONSTRAINT fk_member_auth FOREIGN KEY (userid)
    REFERENCES tbl_member(userid)
);

SELECT * FROM tbl_member;
SELECT * FROM tbl_member_auth;

SELECT mem.userid, userpw, username, enabled, regdate, updatedate, auth 
		FROM tbl_member mem 
			LEFT OUTER JOIN tbl_member_auth auth 
			on mem.userid = auth.userid 
		WHERE mem.userid = 'admin93';

COMMIT;

UPDATE tbl_member_auth SET auth = 'ROLE_ADMIN' WHERE userid='admin';

SELECT mem.userid, userpw, username, enabled, regdate, updatedate, auth
		FROM tbl_member mem
     		LEFT OUTER JOIN tbl_member_auth auth
     		ON mem.userid = auth.userid;

-- �����̶� ����� ���            
SELECT * FROM tbl_member mem
LEFT OUTER JOIN tbl_member_auth auth
     		ON mem.userid = auth.userid
            ORDER BY regdate DESC;

SELECT * FROM tbl_member ORDER BY regdate DESC;

-- ��� ���̺�
CREATE TABLE tbl_reply(
    rno         NUMBER(5),
    bno         NUMBER(5) NOT NULL,
    reply       VARCHAR2(1000) NOT NULL,
    replyer     VARCHAR2(50) NOT NULL,
    replydate   DATE DEFAULT SYSDATE,
    updatedate  DATE DEFAULT SYSDATE
);

-- �ڵ� ����
CREATE SEQUENCE seq_reply;
-- �⺻Ű ����
ALTER TABLE tbl_reply ADD CONSTRAINT pk_reply PRIMARY KEY(rno);
-- �ܷ�Ű ����
ALTER TABLE tbl_reply ADD CONSTRAINT fk_reply_board
FOREIGN KEY(bno) REFERENCES tbl_board(bno) ON DELETE CASCADE;

COMMIT;

SELECT * FROM tbl_board;

-- ���� ������(���) �Է�
INSERT INTO tbl_reply(rno, bno, reply, replyer)
VALUES (seq_reply.NEXTVAL, 2, '��ǳ�� ���� ���׿�...', 'admin');

SELECT * FROM tbl_reply
WHERE bno = 2;

-- ��� �� ������Ʈ(������ �ۼ��� ��� ����)
UPDATE tbl_board
SET replycnt =
    (
    SELECT COUNT(rno) FROM tbl_reply
    WHERE tbl_reply.bno = tbl_board.bno
    );