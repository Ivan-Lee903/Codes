-- MinHang Lee CSE305_Assignment_1, minhang.lee@stonybrook.edu

DROP DATABASE IF EXISTS ps2db;

CREATE DATABASE ps2db;

DROP user IF EXISTS grader@localhost;

CREATE user grader@localhost IDENTIFIED BY 'allowme';

GRANT ALL PRIVILEGES ON ps2db.* to grader@localhost IDENTIFIED BY 'allowme';

USE ps2db;

CREATE TABLE Students (
    sid INTEGER NOT NULL, 
    sname VARCHAR(256) NOT NULL, 
    PRIMARY KEY (sid)
);

CREATE TABLE Courses (
    ctitle VARCHAR(256) NOT NULL,
    cid INTEGER NOT NULL,        
    csem VARCHAR(256) NOT NULL,
    PRIMARY KEY (cid)
);

CREATE TABLE Faculty (
    fid INTEGER NOT NULL,
    fname VARCHAR(256) NOT NULL,
    PRIMARY KEY (fid)
);

CREATE TABLE Takes (
    sid INTEGER NOT NULL,
    cid INTEGER NOT NULL,
    PRIMARY KEY (sid, cid)
);

CREATE TABLE Teaches (
    fid INTEGER NOT NULL,
    cid INTEGER NOT NULL,
    PRIMARY KEY (fid, cid)
);

INSERT INTO Students (sid, sname) VALUES (1, "Thomas");
INSERT INTO Students (sid, sname) VALUES (2, "Kevin");
INSERT INTO Students (sid, sname) VALUES (3, "Bill");
INSERT INTO Students (sid, sname) VALUES (4, "Mark");
INSERT INTO Students (sid, sname) VALUES (5, "Bob");

INSERT INTO Courses (cid, ctitle, csem) VALUES (1, "CSE101", "FALL2017");
INSERT INTO Courses (cid, ctitle, csem) VALUES (2, "CSE114", "FALL2017");
INSERT INTO Courses (cid, ctitle, csem) VALUES (3, "CSE215", "FALL2017");
INSERT INTO Courses (cid, ctitle, csem) VALUES (4, "CSE214", "FALL2017");
INSERT INTO Courses (cid, ctitle, csem) VALUES (5, "CSE220", "FALL2017");

INSERT INTO Faculty (fid, fname) VALUES (1, "Prof_Julia");
INSERT INTO Faculty (fid, fname) VALUES (2, "Prof_Kim");
INSERT INTO Faculty (fid, fname) VALUES (3, "Prof_Matthew");
INSERT INTO Faculty (fid, fname) VALUES (4, "Prof_Brian");
INSERT INTO Faculty (fid, fname) VALUES (5, "Prof_Chris");

INSERT INTO Takes(sid, cid) VALUES (1,1);
INSERT INTO Takes(sid, cid) VALUES (2,2);
INSERT INTO Takes(sid, cid) VALUES (2,5);
INSERT INTO Takes(sid, cid) VALUES (3,4);
INSERT INTO Takes(sid, cid) VALUES (4,5);
INSERT INTO Takes(sid, cid) VALUES (5,5);

INSERT INTO Teaches(fid, cid) VALUES (1,1);
INSERT INTO Teaches(fid, cid) VALUES (1,3);
INSERT INTO Teaches(fid, cid) VALUES (2,2);
INSERT INTO Teaches(fid, cid) VALUES (3,3);
INSERT INTO Teaches(fid, cid) VALUES (4,4);
INSERT INTO Teaches(fid, cid) VALUES (5,5);