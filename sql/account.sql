
create table account(
	id int primary key auto_increment,
	name varchar(100) default'名無し',
	mail varchar(100) not null,
	password varchar(100) not null
);

insert into account(name, mail, password) values
('須藤雄一','yuichi.sudo@ssie.jp',sha2('0000',256));

insert into account(name, mail, password) values
('テスト','test@mail',sha2('pass',256));
