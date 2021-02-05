create table status
(
    id integer generated by default as identity
        constraint status_pkey
            primary key,
    color varchar(255),
    created_at timestamp not null,
    name varchar(255),
    updated_at timestamp not null
);

alter table status owner to postgres;

create table building
(
    id integer generated by default as identity
        constraint building_pkey
            primary key,
    active boolean,
    created_at timestamp not null,
    name varchar(255),
    updated_at timestamp not null,
    status_id integer not null
        constraint fkp98d2aknqx7caexi5joeffw4d
            references status
);

alter table building owner to postgres;

create table users
(
    id integer generated by default as identity
        constraint users_pkey
            primary key,
    name varchar(255)
);

alter table users owner to postgres;

create table activities
(
    id integer generated by default as identity
        constraint activities_pkey
            primary key,
    active boolean,
    activity_name varchar(255),
    created_at timestamp not null,
    updated_at timestamp not null,
    building_id integer not null
        constraint fk4wsjp1hayv4bd4wj18xropoy2
            references building,
    status_id integer not null
        constraint fk32qf1db139jl0buvq4lkfkoqw
            references status,
    user_id integer
        constraint fkq6cjukylkgxdjkm9npk9va2f2
            references users
);

alter table activities owner to postgres;