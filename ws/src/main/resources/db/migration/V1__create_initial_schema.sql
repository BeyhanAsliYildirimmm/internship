
CREATE TABLE city(
                     id INT NOT NULL AUTO_INCREMENT  PRIMARY KEY,
                     created_at datetime(6),
                     name varchar(255)


);
CREATE TABLE role(
                     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                     name varchar(255),
                     created_at datetime(6)

);
CREATE TABLE departmentType (
                                id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                active TINYINT(1),
                                name varchar(255),
                                created_at datetime(6),
                                deleted_at  datetime(6)

);
CREATE TABLE companyType (
                             id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             active TINYINT(1),
                             name varchar(255),
                             created_at datetime(6),
                             deleted_at  datetime(6)

);
CREATE TABLE region (
                        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        created_at datetime(6),
                        city_id INT NOT NULL ,
                        name varchar(255)
);
CREATE TABLE town (
                      id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      name varchar(255),
                      region_id INT NOT NULL ,
                      created_at datetime(6)

);
CREATE TABLE company (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         active TINYINT(1),
                         name varchar(255),
                         short_name varchar(255),
                         address_detail varchar(255),
                         company_type_id INT NOT NULL ,
                         town_id INT NOT NULL ,
                         created_at datetime(6),
                         deleted_at  datetime(6)
);
CREATE TABLE department (
                            id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            active TINYINT(1),
                            name varchar(255),
                            short_name varchar(255),
                            address_detail varchar(255),
                            company_id INT NOT NULL ,
                            department_type_id INT NOT NULL ,
                            town_id INT NOT NULL ,
                            created_at datetime(6),
                            deleted_at  datetime(6)
);
CREATE TABLE user (

                      id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      name varchar(255),
                      active TINYINT(1) ,
                      user_name varchar(255),
                      e_mail varchar(255) ,
                      password varchar(20),
                      enabled TINYINT(1) ,
                      role_id INT NOT NULL ,
                      department_id INT NOT NULL ,
                      created_at datetime(6),
                      deleted_at datetime(6)
);

CREATE  TABLE DepartmentHerarchy
(
    child_department_id int,
    parent_department_id int,
    CONSTRAINT  child_parent_pk PRIMARY KEY (child_department_id, parent_department_id),
    CONSTRAINT FK_child
        FOREIGN KEY (child_department_id) REFERENCES department (id),
    CONSTRAINT FK_parent
        FOREIGN KEY (parent_department_id) REFERENCES department (id)
);
delete from flyway_schema_history where installed_rank = 1;

ALTER TABLE region
    ADD FOREIGN KEY (city_id) REFERENCES city(id);
ALTER TABLE company
    ADD FOREIGN KEY (town_id) REFERENCES town(id);
ALTER TABLE company
    ADD FOREIGN KEY (company_type_id) REFERENCES companyType(id);
ALTER TABLE department
    ADD FOREIGN KEY (company_id) REFERENCES company(id);
ALTER TABLE department
    ADD FOREIGN KEY (department_type_id) REFERENCES departmentType(id);
ALTER TABLE department
    ADD FOREIGN KEY (town_id) REFERENCES town(id);
ALTER TABLE town
    ADD FOREIGN KEY (region_id) REFERENCES region(id);
ALTER TABLE user
    ADD FOREIGN KEY (role_id) REFERENCES role(id);
ALTER TABLE user
    ADD FOREIGN KEY (department_id) REFERENCES department(id);

