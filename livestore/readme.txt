1°¢π∞Ω®ø™∑¢ª∑æ≥
	1.1 µº»Îø™∑¢∞¸
		mysql«˝∂Ø
		c3p0¡¨Ω”≥ÿ
		dbutilsø™∑¢∞¸
		beanutilsø™∑¢∞¸
		jstlø™∑¢∞¸
		log4jø™∑¢∞¸
	
	1.2 ¥¥Ω®≥Ã–Ú∞¸
		domain
		dao
		dao.impl
		service
		service.impl
		web.manager
		web.client
		utils
		
		webroot\manager  ±£¥Ê∫ÛÃ®œ‡πÿµƒjsp
		webroot\client   ±£¥Ê«∞Ã®œ‡πÿµƒjsp
		webroot\images   ±£¥ÊÕ¯’æÕº∆¨
		
		«∞Ã®∑÷÷°£∫
		index.jsp--client--head.jsp
				         --body.jsp
		∫ÛÃ®∑÷÷°£∫
		manager.jsp--manager--head.jsp
		                    --left.jsp
		                    --body.jsp
    1.3 ¥¥Ω®ø‚
    	create database bookstore;
    
    1.4 –¥Õ¯’æµƒ“ª–©≥£”√π§æﬂ¿‡
    	CharacterEncoding
    	HtmlFilter
    	JdbcUtils
    	DaoFactory

2°£∑÷¿‡ƒ£øÈ
	create table category
	(
		id varchar(40) primary key,
		name varchar(100) not null unique,
		description varchar(255)
	);	
	
3°£Õº Èƒ£øÈ	
	create table book
	(
		id varchar(40) primary key,
		name varchar(100) not null unique,
		author varchar(40) not null,
		price double not null,
		image varchar(100),
		description varchar(255),
		category_id varchar(40),
		constraint category_id_FK foreign key(category_id) references category(id)
		
	);	
	
4.”√ªß£∫
	create table user
	(
		id varchar(40) primary key,
		username varchar(40) not null unique,
		password varchar(40),
		phone varchar(40) not null,
		cellphone varchar(40) not null,
		address varchar(100) not null,
		email varchar(40) not null
	);
	
5\∂©µ•
	
	create table orders
	(
		id varchar(40) primary key,
		ordertime datetime not null,
		price double,
		state boolean,
		user_id varchar(40),
		constraint user_id_FK foreign key(user_id) references user(id)
	);
	
	create table orderitem
	(
		id varchar(40) primary key,
		quantity int,
		price double,
		order_id varchar(40),
		book_id varchar(40),
		constraint order_id_FK foreign key(order_id) references orders(id),
		constraint book_id_FK foreign key(book_id) references book(id)
	);
	