
create table list(
	list_id int primary key auto_increment,
	title varchar(200) not null,
	detail text,
	importance int(3) default'1',
	limit_time date
);

insert into list(title, detail, importance, limit_time) values
('タイトル1','テスト1',3,'2019/06/01'),
('タイトル2','テスト2',1,'2019/06/01'),
('タイトル3','テスト3',2,'2019/06/01'),
('タイトル4','テスト4',3,null);

alter table list add status boolean default'0' not null;

