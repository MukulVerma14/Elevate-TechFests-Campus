CREATE TABLE campus_profiles
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    user_id        BIGINT NOT NULL,
    campus_name    VARCHAR(255) NULL,
    location       VARCHAR(255) NULL,
    contact_person VARCHAR(255) NULL,
    CONSTRAINT pk_campus_profiles PRIMARY KEY (id)
);

CREATE TABLE corporate_profiles
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    user_id      BIGINT NOT NULL,
    company_name VARCHAR(255) NULL,
    type         VARCHAR(255) NULL,
    intent       TEXT NULL,
    CONSTRAINT pk_corporate_profiles PRIMARY KEY (id)
);

CREATE TABLE deal_closures
(
    id                    BIGINT AUTO_INCREMENT NOT NULL,
    eoi_id                BIGINT NOT NULL,
    campus_deliverable    TEXT NULL,
    corporate_deliverable TEXT NULL,
    closed_at             datetime NULL,
    CONSTRAINT pk_deal_closures PRIMARY KEY (id)
);

CREATE TABLE expressions_of_interest
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    corporate_id BIGINT NOT NULL,
    programme_id BIGINT NOT NULL,
    status       VARCHAR(255) NULL,
    created_at   datetime NULL,
    updated_at   datetime NULL,
    CONSTRAINT pk_expressions_of_interest PRIMARY KEY (id)
);

CREATE TABLE programme_participation_term
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    programme_id  BIGINT NOT NULL,
    term_type     VARCHAR(255) NULL,
    `description` TEXT NULL,
    CONSTRAINT pk_programmeparticipationterm PRIMARY KEY (id)
);

CREATE TABLE programmes
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    campus_id          BIGINT NOT NULL,
    title              VARCHAR(255) NULL,
    type               VARCHAR(255) NULL,
    domain             VARCHAR(255) NULL,
    sub_domain         VARCHAR(255) NULL,
    location           VARCHAR(255) NULL,
    scale              VARCHAR(255) NULL,
    start_date         datetime NULL,
    end_date           datetime NULL,
    participants_count INT NULL,
    `description`      TEXT NULL,
    fee_based          BIT(1) NULL,
    status             VARCHAR(255) NULL,
    CONSTRAINT pk_programmes PRIMARY KEY (id)
);

CREATE TABLE users
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    email      VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    `role`     VARCHAR(255) NOT NULL,
    created_at datetime NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE campus_profiles
    ADD CONSTRAINT uc_campus_profiles_user UNIQUE (user_id);

ALTER TABLE corporate_profiles
    ADD CONSTRAINT uc_corporate_profiles_user UNIQUE (user_id);

ALTER TABLE deal_closures
    ADD CONSTRAINT uc_deal_closures_eoi UNIQUE (eoi_id);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

CREATE INDEX idx_domain ON programmes (domain);

CREATE INDEX idx_location ON programmes (location);

ALTER TABLE campus_profiles
    ADD CONSTRAINT FK_CAMPUS_PROFILES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE corporate_profiles
    ADD CONSTRAINT FK_CORPORATE_PROFILES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE deal_closures
    ADD CONSTRAINT FK_DEAL_CLOSURES_ON_EOI FOREIGN KEY (eoi_id) REFERENCES expressions_of_interest (id);

ALTER TABLE expressions_of_interest
    ADD CONSTRAINT FK_EXPRESSIONS_OF_INTEREST_ON_CORPORATE FOREIGN KEY (corporate_id) REFERENCES corporate_profiles (id);

ALTER TABLE expressions_of_interest
    ADD CONSTRAINT FK_EXPRESSIONS_OF_INTEREST_ON_PROGRAMME FOREIGN KEY (programme_id) REFERENCES programmes (id);

ALTER TABLE programme_participation_term
    ADD CONSTRAINT FK_PROGRAMMEPARTICIPATIONTERM_ON_PROGRAMME FOREIGN KEY (programme_id) REFERENCES programmes (id);

ALTER TABLE programmes
    ADD CONSTRAINT FK_PROGRAMMES_ON_CAMPUS FOREIGN KEY (campus_id) REFERENCES campus_profiles (id);
