CREATE TABLE LOAN_DETAILS(loan_Id VARCHAR(255) PRIMARY KEY,
BALLOON_PAYMENT_AMOUNT DOUBLE(17)	NOT NULL,
COST_OF_ASSEST	DOUBLE(17)	NOT NULL,
DEPOSIT	DOUBLE(17)	NOT NULL,
IS_BALLOON_PAYMENT	BOOLEAN(1)	NOT NULL,
NO_OF_MONTHLY_PAYMENTS	DOUBLE(17)	NOT NULL,
YEARLY_RATE_OF_INTEREST	DOUBLE(17)	NOT NULL);

CREATE TABLE INSTALLMENT_RECORD (ID	VARCHAR(255) PRIMARY KEY,
BALANCE	DOUBLE(17) NOT NULL,
INTEREST	DOUBLE(17)	NOT	NULL,
PAYMENT	DOUBLE(17)	NOT	NULL,
PAYMENT_DONE	BOOLEAN(1)	NOT	NULL,
PERIOD	INTEGER(10)	NOT NULL,
PRINCIPAL	DOUBLE(17)	NOT	NULL,
LOAN_ID	VARCHAR(255)	NOT NULL );

INSERT INTO LOAN_DETAILS (loan_Id,COST_OF_ASSEST,deposit, YEARLY_RATE_OF_INTEREST , NO_OF_MONTHLY_PAYMENTS , IS_BALLOON_PAYMENT, BALLOON_PAYMENT_AMOUNT) VALUES ('1',25000,5000,7.5,12,TRUE ,10000);
INSERT INTO LOAN_DETAILS (loan_Id,COST_OF_ASSEST,deposit, YEARLY_RATE_OF_INTEREST , NO_OF_MONTHLY_PAYMENTS , IS_BALLOON_PAYMENT, BALLOON_PAYMENT_AMOUNT) VALUES ('2',25000,5000,7.5,12,FALSE ,0);

INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('1',19194.93,125.0,930.07, FALSE , 1,805.07, '1');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('2',18384.83,119.97,930.07, FALSE , 2,810.1, '1');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('3',17569.67,114.91,930.07, FALSE , 3,815.16, '1');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('4',16749.41,109.81,930.07, FALSE , 4,820.26, '1');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('5',15924.02,104.68,930.07, FALSE , 5,825.39, '1');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('6',15093.48,99.53,930.07, FALSE , 6,830.54, '1');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('7',14257.74,94.33,930.07, FALSE , 7,835.74, '1');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('8',13416.78,89.11,930.07, FALSE , 8,840.96, '1');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('9',12570.56,83.85,930.07, FALSE , 9,846.22, '1');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('10',11719.06,78.57,930.07, FALSE , 10,851.5, '1');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('11',10862.23,73.24,930.07, FALSE , 11,856.83, '1');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('12',10000.0,67.89,930.12, FALSE , 12,862.18, '1');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('13',18389.85,125.0,1735.15, FALSE , 1,1610.15, '2');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('14',16769.64,114.94,1735.15, FALSE , 2,1620.21, '2');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('15',15139.3,104.81,1735.15, FALSE , 3,1630.34, '2');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('16',13498.77,94.62,1735.15, FALSE , 4,1640.53, '2');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('17',11847.99,84.37,1735.15, FALSE , 5,1650.78, '2');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('18',10186.89,74.05,1735.15, FALSE , 6,1661.1, '2');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('19',8515.41,63.67,1735.15, FALSE , 7,1671.48, '2');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('20',6833.48,53.22,1735.15, FALSE , 8,1681.93, '2');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('21',5141.04,42.71,1735.15, FALSE , 9,1692.44, '2');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('22',3438.02,32.13,1735.15, FALSE , 10,1703.02, '2');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('23',1724.36,21.49,1735.15, FALSE , 11,1713.66, '2');
INSERT INTO INSTALLMENT_RECORD (id,balance,interest, payment , payment_done , period, principal , loan_id) VALUES ('24',0.0,10.78,1735.14, FALSE , 12,1724.37, '2');
