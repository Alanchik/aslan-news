create table articles(
    id serial primary key not null,
    author_id int not null,
    title varchar(255) not null,
    text text not null,
    date timestamp not null,
    constraint fk_author
    foreign key (author_id) references users (id)
)