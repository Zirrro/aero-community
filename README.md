sql脚本:

用户表
```
create table user
(
    id           int auto_increment
        primary key,
    account_id   varchar(100) null,
    name         varchar(50)  null,
    token        char(36)     null,
    gmt_create   bigint       null,
    gmt_modified bigint       null,
    avatar_url   varchar(100) null
);
```

提问表
```
create table question
(
    id            int auto_increment
        primary key,
    title         varchar(50)   null,
    description   text          null,
    gmt_create    bigint        null,
    gmt_modified  bigint        null,
    creator       int           null,
    comment_count int default 0 null,
    view_count    int default 0 null,
    like_count    int default 0 null,
    tag           varchar(256)  null
);
```

```
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```