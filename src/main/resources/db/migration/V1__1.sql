
create table exchangeRate (
	id bigint not null auto_increment,
    symbol varchar(255),
    date_time datetime,
    closeValue double,
    primary key(id)
);

create table users (
	id bigint not null auto_increment,
    account_number varchar(10),
    name varchar(255),
    surname varchar(255),
    currency_shortname enum('KZT','RUB'),
    balance decimal(10,0),
    userMaxLimit bigint,
    userRemainingLimit bigint,
    max_limit_id bigint,
    remaining_limit_id bigint,
    primary key(id)
);

create table category (
	id bigint not null auto_increment,
    category_type enum('SERVICE','PRODUCT'),
    account_number varchar(10),
    account_name varchar(255),
    currency_shortname enum('KZT','RUB'),
    balance float,
    primary key(id)
);

create table max_limits (
	id bigint not null auto_increment,
    currency_shortname enum('USD'),
    product_max_limit double,
    service_max_limit double,
    date_time datetime,
    close double,
    symbol varchar(255),
    primary key(id)
);
create table remaining_limits (
	id bigint not null auto_increment,
    currency_shortname enum('USD'),
    product_remaining_limit double,
    service_remaining_limit double,
    date_time datetime,
    primary key(id)
);

create table expense_transactions (
	id bigint not null auto_increment,
    account_from bigint,
    account_to bigint,
    currency_shortname enum('KZT','RUB'),
    sum decimal(10,0),
    date_time datetime,
    limit_exceeded bit(1),
    primary key(id)
);
