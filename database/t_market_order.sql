drop table if exists t_market_order;

create table t_market_order
(
    id               int(10)      not null auto_increment primary key comment 'Row id',
    state            int(3)       not null default 0 comment 'State Code',
    order_no         varchar(255) not null comment 'Order number',
    creator_id       int(10)      not null comment 'Ref: t_user.id',
    remark           text         null comment 'Remark text',
    exceed_date      datetime     not null comment 'Exceed date',
    customer_name    varchar(255) null comment 'Customer name',
    delivery_address text         null comment 'Delivery address ',
    create_time      datetime     not null comment 'Create time',
    update_time      datetime     not null comment 'Last update time',
    deleted          bit(1)       not null comment 'deleted mark'
) engine = 'Innodb'
  charset utf8
  collate utf8_general_ci;


