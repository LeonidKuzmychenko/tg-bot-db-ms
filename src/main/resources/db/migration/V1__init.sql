create table if not exists serials
(
    id     bigint generated by default as identity primary key,
    api_id varchar(100) not null constraint api_id_fk unique
);

create table if not exists users
(
    id      bigint generated by default as identity primary key,
    chat_id varchar(50) not null constraint chat_id_fk unique,
    command varchar(255)
);

create table if not exists users_serials
(
    serial_id bigint not null constraint serial_id_fk references serials,
    user_id   bigint not null constraint user_id_fk references users,
    primary key (user_id, serial_id)
);