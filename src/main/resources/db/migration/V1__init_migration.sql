CREATE TABLE session
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    token     VARCHAR(255) NULL,
    usr_id_id BIGINT NULL,
    CONSTRAINT pk_session PRIMARY KEY (id)
);

CREATE TABLE user
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    email     VARCHAR(255) NULL,
    paswrd    VARCHAR(255) NULL,
    usrname   VARCHAR(255) NULL,
    full_name VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE session
    ADD CONSTRAINT FK_SESSION_ON_USRID FOREIGN KEY (usr_id_id) REFERENCES user (id);