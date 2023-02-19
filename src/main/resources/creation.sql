create table locations
(
    id         bigserial
        primary key,
    country    varchar(255),
    latitude   double precision not null,
    longtitude double precision not null,
    name       varchar(255)
);

alter table locations
    owner to root;

