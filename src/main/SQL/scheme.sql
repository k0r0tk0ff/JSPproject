
--------------------  Creating database -------------------------

create TABLE clients (
 id serial PRIMARY KEY,
 name VARCHAR(20)
);

 /*
 Create table "user`s pets"
 user_id - foreign key
 */
create table pets (
 petId serial primary key,
 nick varchar(20),
 type varchar(20),
 user_id int not null references clients(id)
);

 -- Create exemplar of client

INSERT into clients (name) VALUES ('mpgonch1');

 -- Create mpgonch1`s pet -> Tomcat (type is cat)

INSERT into pets (user_id, nick, type) VALUES ('1', 'Tomcat', 'cat');

 -- Create mpgonch1`s pet -> PussyCat (type is cat)

INSERT into pets (user_id, nick, type) VALUES ('1', 'PussyCat', 'cat');

 -- select colums from table client with alias client.
 -- alias may be use with join

 -------------------------   SELECTING  &  Updating ---------------------------

SELECT * FROM clients as client;

 -- with "if"

select * from clients as customer WHERE customer.name = 'mpgonch1';

 -- select with output from two table.
 -- show table with first column "pet`s nick"
 -- and second column "user`s name"

SELECT pet.nick, customer.name
FROM pets as pet
INNER JOIN clients as customer
on customer.id = pet.user_id;

 -- update data
 -- in table pets find pet with name 'Tomcat' and set petId to '1'

UPDATE pets as pet set pet.petId = '1'
WHERE pet.nick = 'Tomcat';

 -- update data
 -- in table pets find pet with name 'Tomcat' and rename to 'Dodya'

UPDATE pets as pet set nick = 'Dodya'
WHERE pet.nick = 'Tomcat';

 -- delete
 -- if we want to delete client, previos we must delete his pets!!!
 -- but framework HIBERNATE may it

DELETE from pets as pet
where pet.user_id = '1';

DELETE from clients as customer
where customer.name = 'mpgonch1';


