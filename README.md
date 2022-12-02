# yogurt
Yogurt 프로젝트(토이 프로젝트)

주문 및 배송 서비스
Table script(MySQL)
CREATE TABLE member ( id bigint(20) NOT NULL, created_date datetime(6) DEFAULT NULL, updated_date datetime(6) DEFAULT NULL, name varchar(255) DEFAULT NULL, password varchar(255) DEFAULT NULL, email varchar(255) DEFAULT NULL, PRIMARY KEY (id) ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE yogurt ( id bigint(20) NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, type varchar(255) NOT NULL DEFAULT '', price bigint(20) NOT NULL, PRIMARY KEY (id) ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

CREATE TABLE yogurt_order ( id bigint(20) NOT NULL AUTO_INCREMENT, created_date datetime(6) DEFAULT NULL, member_id bigint(20) NOT NULL, yogurt_id bigint(20) NOT NULL, type varchar(255) NOT NULL DEFAULT '', PRIMARY KEY (id) ) ENGINE=InnoDB AUTO_INCREMENT=7897855853038395603 DEFAULT CHARSET=utf8mb4;
