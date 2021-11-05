SET NAMES utf8mb4;
DROP TABLE IF EXISTS t_goods;

CREATE TABLE t_goods (
	g_id int(11) NOT NULL ,
	g_name varchar(255) DEFAULT NULL,
	g_monery varchar(255) DEFAULT NULL,
	 PRIMARY KEY (g_id)
) ENGINE=InnoDB CHARSET=utf8;