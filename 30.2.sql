ALTER TABLE BOOKS ADD BESTSELLER BOOL DEFAULT 0;

DROP PROCEDURE IF EXISTS UpdateBestsellers;

DELIMITER $$

CREATE PROCEDURE UpdateBestsellers()
BEGIN
    DECLARE RENT_COUNT, BK_ID INT;
    DECLARE FINISHED INT DEFAULT 0;
    DECLARE ALL_BOOKS CURSOR FOR SELECT BOOK_ID FROM BOOKS;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED = 1;
    OPEN ALL_BOOKS;
    WHILE (FINISHED = 0) DO
            FETCH ALL_BOOKS INTO BK_ID;
            IF (FINISHED = 0) THEN
                SELECT COUNT(*) FROM RENTS
                WHERE BOOK_ID = BK_ID
                INTO RENT_COUNT;
                UPDATE BOOKS SET BESTSELLER = 1
                WHERE BOOK_ID = BK_ID AND RENT_COUNT > 2;
                COMMIT;
            END IF;
        END WHILE;
    CLOSE ALL_BOOKS;
END $$

DELIMITER ;

show databases;
set global log_bin_trust_function_creators=1;

show tables;

CREATE TABLE BOOKS (
                       BOOK_ID int(11) NOT NULL AUTO_INCREMENT,
                       TITLE varchar(255) NOT NULL,
                       PUBYEAR int(4) NOT NULL,
                       PRIMARY KEY (BOOK_ID)
);

CREATE TABLE READERS (
                         READER_ID int(11) NOT NULL AUTO_INCREMENT,
                         FIRSTNAME varchar(255) NOT NULL ,
                         LASTNAME varchar(255) NOT NULL ,
                         PESEL_ID varchar(11),
                         PRIMARY KEY (READER_ID)
);

CREATE TABLE RENTS (
                       RENT_ID int(11) NOT NULL AUTO_INCREMENT,
                       BOOK_ID int(11) NOT NULL,
                       READER_ID int(11) NOT NULL,
                       RENT_DATE datetime NOT NULL,
                       RETURN_DATE datetime,
                       PRIMARY KEY (RENT_ID),
                       FOREIGN KEY (BOOK_ID) REFERENCES BOOKS(BOOK_ID),
                       FOREIGN KEY (READER_ID) REFERENCES READERS(READER_ID)
);

SELECT * FROM BOOKS;

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (1, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (2, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (4, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), DATE_SUB(CURDATE(), INTERVAL 5 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (1, 3, DATE_SUB(CURDATE(), INTERVAL 8 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 3, DATE_SUB(CURDATE(), INTERVAL 4 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 4, DATE_SUB(CURDATE(), INTERVAL 10 DAY), DATE_SUB(CURDATE(), INTERVAL 8 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 5, DATE_SUB(CURDATE(), INTERVAL 8 DAY), null);

COMMIT;



DELIMITER $$

CREATE PROCEDURE ListBooks()
BEGIN
    SELECT * FROM BOOKS;
END $$

DELIMITER ;

CALL ListBooks();

DROP PROCEDURE IF EXISTS ListBooks;

DELIMITER $$

CREATE PROCEDURE ListBooks()
BEGIN
    SELECT BOOK_ID, TITLE, PUBYEAR FROM  BOOKS;
end $$

DELIMITER ;

CALL ListBooks();

DROP FUNCTION IF EXISTS VipLevel;

DELIMITER $$

CREATE FUNCTION VipLevel(booksRented INT) RETURNS VARCHAR(20) DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255) DEFAULT 'Standard Customer';
    IF booksrented >= 10 THEN						                        -- [4]
        SET result = 'Gold customer';					                        -- [5]
    ELSEIF booksrented >= 5 AND booksrented < 10 THEN			            -- [6]
        SET result = 'Silver customer';				                        -- [7]
    ELSEIF booksrented >= 2 AND booksrented < 5 THEN			            -- [8]
        SET result = 'Bronze customer';		           		                -- [9]
    ELSE				      					                                -- [10]
        SET result = 'Standard customer';				                        -- [11]
    END IF;
    RETURN result;
END $$

DELIMITER ;

SELECT VipLevel(2) AS LEVEL;

DROP FUNCTION IF EXISTS ShowReaderName;

DELIMITER $$

CREATE FUNCTION ShowReaderName(readerId INT) RETURNS VARCHAR(255)
BEGIN
    DECLARE result VARCHAR(255);
    IF readerId <= 0 THEN
        SET result = 'Invalid reader ID';
    ELSE
        SET result = (SELECT CONCAT(`FIRSTNAME`, ' ', `LASTNAME`) FROM READERS
                      WHERE READER_ID = readerId);
    END IF;
    RETURN result;
END $$

DELIMITER ;

SELECT ShowReaderName(4);

ALTER TABLE READERS ADD VIP_LEVEL VARCHAR(20);

DROP PROCEDURE IF EXISTS UpdateVipLevels;

DELIMITER $$

CREATE PROCEDURE UpdateVipLevels()
BEGIN
    DECLARE BOOKSREAD, DAYS, RDR_ID INT;
    DECLARE BOOKSPERMONTH DECIMAL(5,2);
    DECLARE FINISHED INT DEFAULT 0;
    DECLARE ALL_READERS CURSOR FOR SELECT READER_ID FROM READERS;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED = 1;
    OPEN ALL_READERS;
    WHILE (FINISHED = 0) DO
            FETCH ALL_READERS INTO RDR_ID;
            IF (FINISHED = 0) THEN
                SELECT COUNT(*) FROM RENTS
                WHERE READER_ID = RDR_ID
                INTO BOOKSREAD;

                SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE)) + 1 FROM RENTS
                WHERE READER_ID = RDR_ID
                INTO DAYS;

                SET BOOKSPERMONTH = BOOKSREAD / DAYS * 30;

                UPDATE READERS SET VIP_LEVEL = VipLevel(BOOKSPERMONTH)
                WHERE READER_ID = RDR_ID;
                COMMIT;
            END IF;
        END WHILE;

    CLOSE ALL_READERS;
END $$

DELIMITER ;

CALL UpdateVipLevels();
SELECT * FROM READERS;

ALTER TABLE BOOKS ADD BESTSELLER BOOL DEFAULT 0;

DROP PROCEDURE IF EXISTS UpdateBestsellers;

DELIMITER $$

CREATE PROCEDURE UpdateBestsellers()
BEGIN
    DECLARE RENT_COUNT, BK_ID INT;
    DECLARE FINISHED INT DEFAULT 0;
    DECLARE ALL_BOOKS CURSOR FOR SELECT BOOK_ID FROM BOOKS;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED = 1;
    OPEN ALL_BOOKS;
    WHILE (FINISHED = 0) DO
            FETCH ALL_BOOKS INTO BK_ID;
            IF (FINISHED = 0) THEN
                SELECT COUNT(*) FROM RENTS
                WHERE BOOK_ID = BK_ID
                INTO RENT_COUNT;
                UPDATE BOOKS SET BESTSELLER = 1
                WHERE BOOK_ID = BK_ID AND RENT_COUNT > 2;
                COMMIT;
            END IF;
        END WHILE;
    CLOSE ALL_BOOKS;
END $$

DELIMITER ;

SELECT * FROM BOOKS;

CALL UpdateBestsellers();
