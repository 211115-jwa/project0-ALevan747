--Database for new project0
DROP TABLE IF EXISTS Candy; --DROP BEFORE testing
CREATE TABLE IF NOT EXISTS Candy(
id serial primary key,
name varchar(50) not null,
brand varchar(50) not null,
flavor varchar(30) not null,
isSugarFree BOOLEAN,
inStock varchar(10) not null
);

--insert data for candy
insert into candy (name, brand, flavor, issugarfree, inStock) values ('meloxicam', 'Youspan', 'Blue Berry', false, 'Yes');
insert into candy (name, brand, flavor, issugarfree, inStock) values ('Tussin CF', 'Realfire', 'Crimson Tide', false, 'Yes');
insert into candy (name, brand, flavor, issugarfree, inStock) values ('Cyanocobalamin', 'Jaxnation', 'Pink Punch', true, 'Yes');
insert into candy (name, brand, flavor, issugarfree, inStock) values ('ZYRTEC-D', 'Skivee', 'Grape', false, 'Yes');
insert into candy (name, brand, flavor, issugarfree, inStock) values ('Tussin', 'Linktype', 'Teal Tingle', false, 'Yes');



DROP TABLE IF EXISTS Users; --DROP BEFORE testing
CREATE TABLE IF NOT EXISTS Users(
id serial primary key,
name varchar(50) not null,
username varchar(50) not null unique,
password varchar(40) not null
);

--insert data for Users;
insert into Users (name, username, password) values ('Name', 'Username', 'Password');
insert into Users (name, username, password) values ('Amy', 'Francesca', 'Ascough');
insert into Users (name, username, password) values ('Joe', 'Katti', 'Lettington');
insert into Users (name, username, password) values ('Tim', 'Wilmer', 'Negri');
insert into Users (name, username, password) values ('Sam', 'Daphne', 'MacMakin');
