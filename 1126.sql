-- ---------------  评论表

DROP TABLE IF EXISTS 'comment';
CREATE TABLE 'comment'(
'id' INT NOT NULL AUTO_INCREMENT COMMENT '',
'uid' INT NOT NULL COMMENT '用户id',
'aid' INT NOT NULL COMMENT '文章id',
'content' TEXT COMMENT '评论',
'created_at' DATETIME,
'updated_at' DATETIME,
'deketed_at' DATETIME,
PRIMARY KEY('id')
)ENGINE=INNODB AUTO_INCREMENT=20 DEFAULT CHARSET=UTF8 COMMENT='评论';





-- ---------------  收藏表
DROP TABLE IF EXISTS 'favorite';
CREATE TABLE 'favorite'(
'id' INT NOT NULL AUTO_INCREMENT COMMENT '',
'uid' INT NOT NULL COMMENT '用户id',
'aid' INT NOT NULL COMMENT '文章id',
'created_at' DATETIME,
'updated_at' DATETIME,
'deketed_at' DATETIME,
PRIMARY KEY('id')
)ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='收藏';




-- ---------------用户
DROP TABLE IF EXISTS 'user';
CREATE TABLE 'user'(
'id' INT NOT NULL AUTO_INCREMENT COMMENT '',
'name' VARCHAR(16) NOT NULL COMMENT '用户名',
'avatar' VARCHAR(256)  COMMENT '头像链接',
'password' VARCHAR(20) NOT NULL COMMENT '密码',
'showname' VARCHAR(20)  COMMENT '昵称',
'created_at' DATETIME,
'updated_at' DATETIME,
'deketed_at' DATETIME,
PRIMARY KEY('id')
)ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=UTF8 COMMENT='用户';




-- ------------------- 文章
DROP TABLE IF EXISTS 'article';
CREATE TABLE 'article'(
'id' INT NOT NULL AUTO_INCREMENT COMMENT '',
'title' VARCHAR(16) NOT NULL COMMENT '标题',
'uid' INT NOT NULL COMMENT '上传者ID',
'cover' VARCHAR(256)  COMMENT '封面链接',
'link' VARCHAR(256)  COMMENT '文章链接',
'category_id' INT COMMENT '分类ID'，
'created_at' DATETIME,
'updated_at' DATETIME,
'deketed_at' DATETIME,
PRIMARY KEY('id')
)ENGINE=INNODB AUTO_INCREMENT=19 DEFAULT CHARSET=UTF8 COMMENT='文章';





-- ------------------- 分类
DROP TABLE IF EXISTS 'category';
CREATE TABLE 'category'(
'id' INT NOT NULL AUTO_INCREMENT COMMENT '',
'parentid' INT NOT NULL ,
'name' VARCHAR(16) NOT NULL COMMENT '分类名',
'created_at' DATETIME,
'updated_at' DATETIME,
'deketed_at' DATETIME,
PRIMARY KEY('id')
)ENGINE=INNODB  DEFAULT CHARSET=UTF8 COMMENT='分类';







