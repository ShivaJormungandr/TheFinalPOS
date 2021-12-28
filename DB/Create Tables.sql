create table CATEGORY
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint CATEGORY_PK
        primary key,
    CATEGORY VARCHAR(30)
);

create table ROLE
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint ROLE_PK
        primary key,
    ROLE VARCHAR(30)
);

create table STATE
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint STATE_PK
        primary key,
    STATE VARCHAR(30)
);

create table TRANSACTION_TYPE
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint TRANSACTION_TYPE_PK
        primary key,
    TYPE VARCHAR(30)
);

create table UNIT
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint UNIT_PK
        primary key,
    UNIT VARCHAR(30)
);

create table PRODUCT
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint PRODUCT_PK
        primary key,
    PRODUCT_NAME VARCHAR(30),
    ID_CATEGORY  INTEGER not null
        constraint FK_PRODUCT_CATEGORY
            references CATEGORY,
    PRICE        DOUBLE,
    ID_UNIT      INTEGER not null
        constraint FK_PRODUCT_UNIT
            references UNIT,
    IMG_PATH     VARCHAR(255)
);

create table USER_TABLE
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint USER_PK
        primary key,
    USERNAME VARCHAR(64)
        constraint USER_USERNAME_UINDEX
            unique,
    FULLNAME VARCHAR(64),
    PASSWORD VARCHAR(256),
    ID_ROLE  INTEGER not null
        constraint FK_USER_ROLE
            references ROLE
            on delete cascade,
    ID_STATE INTEGER not null
        constraint FK_USER_STATE
            references STATE,
    EMAIL    VARCHAR(64)
);

create table TRANSACTION_TABLE
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint TRANSACTION_PK
        primary key,
    TRANSACTION_DATE   TIMESTAMP,
    ID_CASHIER         INTEGER not null
        constraint FK_TRANSACTION_USER
            references "USER_TABLE",
    ID_TYPE            INTEGER not null
        constraint FK_TRANSACTION_TRANSACTION_TYPE
            references TRANSACTION_TYPE,
    VALUE              DOUBLE,
    RENTAL_RETURN_DATE TIMESTAMP
);

create table TRANSACTED_PRODUCTS
(
    ID INTEGER GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1)
        constraint TRANSACTED_PRODUCTS_PK
        primary key,
    ID_TRANSACTION INTEGER not null
        constraint FK_TRANSACTED_PRODUCTS_TRANSACTION
            references "TRANSACTION_TABLE",
    ID_PRODUCT     INTEGER not null
        constraint FK_TRANSACTED_PRODUCTS_PRODUCT
            references PRODUCT
);