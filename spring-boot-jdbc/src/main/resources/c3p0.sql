
DROP TABLE IF EXISTS t_order;

CREATE TABLE t_order 
(
	o_id int NOT NULL ,
	u_id int not null,
	o_name VARCHAR(255) DEFAULT NULL,
	 PRIMARY KEY (o_id)
);


