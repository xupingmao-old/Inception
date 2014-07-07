drop database if exists inceptionDB;
create database inceptionDB;
use inceptionDB;

create table inception_user(
	id int primary key auto_increment,
	userType int default 0 comment 'default 0, weibo 1, qq, 2 renren 3',
	`permission` int default 0 comment 'normal user 0, admin 1, superuser 2',
	email varchar(100) default NULL,
	userName varchar(50) NOT NULL,
	sex int NOT NULL default 0 comment 'default 0, male 1, female 2',
	passwd varchar(20) NOT NULL,
	qqNo varchar(20) default NULL,
	weiboNo varchar(20) default NULL,
	renrenNo varchar(20) default NULL,
	imageUrl varchar(1024) default NULL,
	loginDate datetime comment 'last login date',
	updateDate datetime NOT NULL,
	registDate datetime NOT NULL
);

create table inception_zone(
	id int primary key auto_increment,
	zoneName varchar(100) NOT NULL
);

insert into inception_zone (zoneName) values ('δ֪');

drop table if exists inception_artist;
create table inception_artist(
	id int primary key auto_increment,
	artistName varchar(50) NOT NULL,
	artistPhoto varchar(1024) default NULL,
	description varchar(1024) default NULL,
	popularity int default 0,
	zoneName varchar(100) default 0
);

drop table if exists inception_album;
create table inception_album(
	id int primary key auto_increment,
	albumName varchar(50) NOT NULL,
	publishDate datetime default NULL,
	imageUrl varchar(1024) default NULL,
	recordCompany varchar(1024) default NULL,
	artistName varchar(100) default NULL,
	description varchar(1024) default NULL
);

create table inception_music(
	id int primary key auto_increment,
	uploadedBy int default 0,
    musicName varchar(100) NOT NULL comment 'music name',
	musicStyle varchar(20) default NULL,
	musicLanguage varchar(20) default NULL,
	artistName varchar(20) default NULL,
	albumName varchar(100) default NULL,
    uploadDate datetime NOT NULL,
    description varchar(512) default NULL,
    publishDate datetime default NULL,
    imageUrl varchar(1024) default NULL,
    musicUrl varchar(1024) default NULL,
    fileSize int default 0,
    musicLength time default NULL,
    lyrics text default NULL,
    CTR int default 0 comment 'click ratio'
);

create table inception_styles(
	id int primary key auto_increment,
	styleName varchar(50) NOT NULL
);

create table inception_history(
    id int primary key auto_increment,
    userId int NOT NULL,
    musicId int NOT NULL,
    historyDate datetime NOT NULL
);

create table inception_comment(
	id int primary key auto_increment,
	content text,
	userId int NOT NULL,
	musicId int NOT NULL,
	commentDate datetime NOT NULL
);

create table inception_log(
	id int primary key,
	logTitle varchar(1024) NOT NULL,
	content text,
	logDate datetime NOT NULL,
	userId int NOT NULL
);

create table inception_follow(
	id int primary key,
	followerId int NOT NULL,
	beFollowedId int NOT NULL
);

drop table if exists inception_preference ;
create table inception_preference(
	id int primary key auto_increment,
	userId int NOT NULL,
	musicId int NOT NULL
);

create table inception_gallery(
	id int primary key auto_increment,
	featureId int NOT NULL,
	creationDate datetime NOT NULL,
	imageUrl varchar(1024) NOT NULL
);

create table inception_feature(
	id int primary key auto_increment,
	featureName varchar(100) NOT NULL,
	creationDate datetime NOT NULL,
	description text,
	zoneId int ,
	userId int
);

create table inception_message(
	id int primary key auto_increment,
	content text,
	userFrom int NOT NULL,
	userTo int NOT NULL,
	messageDate datetime NOT NULL
);

create table inception_log_comment(
	id int primary key auto_increment,
	content text,
	userId int NOT NULL,
	logId int NOT NULL,
	commentDate datetime NOT NULL
);



# ��
create table inception_board(
	id int primary key auto_increment,
	musicId int NOT NULL,
	boardDate datetime NOT NULL
);

	
	
	
