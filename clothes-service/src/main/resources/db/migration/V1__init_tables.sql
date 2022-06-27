create table clothes
(
    id serial primary key,
    headwear character varying(255),
    outherwear character varying(255),
    pants character varying(255),
    shoes character varying(255)
);
create table recommendations
(
    id serial primary key,
    recommendation character varying(255),
    weather_range_start numeric(4,2),
    weather_range_end numeric(4,2),
);