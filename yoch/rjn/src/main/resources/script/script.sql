CREATE TABLE role (
  id serial NOT NULL,
  code varchar(1000) DEFAULT NULL,
  label varchar(1000) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE account (
  id serial NOT NULL,
  my_user_name varchar(1000) NOT NULL,
  password varchar(1000) NOT NULL,
  enabled boolean NOT NULL DEFAULT true,
  credentialsexpired boolean NOT NULL DEFAULT '0',
  expired boolean NOT NULL DEFAULT '0',
  locked boolean NOT NULL DEFAULT '0',
  reg_id varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE accountrole (
  accountId serial NOT NULL,
  roleId serial NOT NULL,
  PRIMARY KEY (accountId, roleId)
)


INSERT INTO role VALUES (1,'ROLE_USER','USER'),(2,'ROLE_ADMIN','ADMIN'),(3,'ROLE_VENDOR','VENDOR'),(4,'ROLE_CANDIDATE','CANDIDATE');


INSERT INTO account VALUES (1,'admin','$2a$10$78sNXmOHnlcxEmke4idBJe2O9EuLJIkQCwomPefJnosrNyxVcv1Pi',true,false,false,false,NULL),
(4,'partner1@gmail.com','$2a$10$EDlmOy9YnG63g1MeOo7VaOL7eOJJU.AtWorbWTV6goYwguHyt/TEq',true,false,false,false,'PREG-10-08-2016-5'),(
5,'member_1@apnaoffice.in','$2a$10$NuK5nbvgQvdpPmkTUeoqj.VCdE5Ixzk82sQDqAqIZtA0Y4cuZCdlq',true,false,false,false,'CREG-258'),
(6,'hel11@gmail.com','$2a$10$fnffTAflUWopreMvtXXsCusRNnGCSMKJYp2DVcqVWm7SU/ouwmUwe',true,false,false,false,'CREG-259');

INSERT INTO accountrole VALUES (1,2),(2,3),(3,4),(4,3),(5,4),(6,4);

