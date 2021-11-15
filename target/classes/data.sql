
INSERT INTO AUTHOR(AUTHOR_ID, FIRST_NAME, LAST_NAME)
    VALUES
    (     NULL, 'Craig','Wells'    ),
    (     NULL, 'Joshua','Bloch'   ),
    (     NULL, 'Alex','Antonov'   ),
    (     NULL, 'Joyce','Farrell'  ),
    (     NULL, 'Cay','Horstmann'  ), 
    (     NULL, 'Janet','Gregory'  ), 
    (     NULL, 'Greg','Turnquist' ),
    (     NULL, 'Walter','Savich'  ),
    (     NULL, 'John','Carnell'   );

INSERT INTO BOOK (BOOK_ID, BOOK_TITLE, BOOK_YEAR, AUTHOR_ID)
VALUES 
    (NULL, 'Spring Boot in Action', '2018', (SELECT Author_ID from author where last_name = 'Wells')),
    (NULL, 'Core Java for the Impatient', '2018', (SELECT Author_ID from author where last_name = 'Horstmann')),
    (NULL, 'Spring Microservices in Action', '2016', (SELECT Author_ID from author where last_name = 'Carnell')),
    (NULL, 'Java Programming', '2018', (SELECT Author_ID from author where last_name = 'Farrell')),
    (NULL, 'Beginning Java Databases', '2001', (SELECT Author_ID from author where last_name = 'Carnell')),
    (NULL, 'Effective Java', '2017', (SELECT Author_ID from author where last_name = 'Bloch')),
    (NULL, 'Spring Boot 2.0', '2017', (SELECT Author_ID from author where last_name = 'Antonov')),
    (NULL, 'Spring Boot Cookbook', '2015', (SELECT Author_ID from author where last_name = 'Antonov')),
    (NULL, 'Learning spring Boot 2.0', '2017', (SELECT Author_ID from author where last_name = 'Turnquist')),
    (NULL, 'Absolute Java', '2015', (SELECT Author_ID from author where last_name = 'Savich')),
    (NULL, 'Agile Testing', '2015', (SELECT Author_ID from author where last_name = 'Gregory')),
    (NULL, 'Java: An Introduction to Problem Solving', '2017', (SELECT Author_ID from author where last_name = 'Savich'));
