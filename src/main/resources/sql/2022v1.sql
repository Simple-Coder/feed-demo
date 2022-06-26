create
database feed_demo0;

use
feed_demo0;

drop table if exists `feed_info_0`;
create table `feed_info_0`
(
    `id`           bigint not null comment '主键',
    `user_id`      bigint comment '用户id',
    `feed_status`  int comment '状态(0:删除,1:正常)',
    `feed_content` text charset utf8mb4 comment '内容',
    `create_time`  datetime comment '创建时间',
    `update_time`  datetime comment '更新时间',
    primary key (`id`) USING BTREE
)ENGINE=InnoDB character set = utf8mb4 collate=utf8mb4_general_ci comment='feed信息表';

drop table if exists `feed_info_1`;
create table `feed_info_1`
(
    `id`           bigint not null comment '主键',
    `user_id`      bigint comment '用户id',
    `feed_status`  int comment '状态(0:删除,1:正常)',
    `feed_content` text charset utf8mb4 comment '内容',
    `create_time`  datetime comment '创建时间',
    `update_time`  datetime comment '更新时间',
    primary key (`id`) USING BTREE
)ENGINE=InnoDB character set = utf8mb4 collate=utf8mb4_general_ci comment='feed信息表';


drop table if exists `user_feed_0`;
create table `user_feed_0`
(
    `id`           bigint not null comment '主键',
    `user_id`      bigint comment '用户id',
    `feed_id`      bigint comment 'feed_id',
    `feed_user_id` bigint comment 'feed_user_id',
    `feed_status`  int comment '状态(0:删除,1:正常)',
    `create_time`  datetime comment '创建时间',
    `update_time`  datetime comment '更新时间',
    primary key (`id`) USING BTREE
)ENGINE=InnoDB character set = utf8mb4 collate=utf8mb4_general_ci comment='userFeed 关系表';