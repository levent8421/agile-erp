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



select mo.id               as mo_id,
       mo.state            as mo_state,
       mo.order_no         as mo_order_no,
       mo.creator_id       as mo_creator_id,
       mo.remark           as mo_remark,
       mo.exceed_date      as mo_exceed_date,
       mo.customer_name    as mo_customer_name,
       mo.delivery_address as mo_delivery_address,
       mo.creator_id       as mo_creator_id,
       mo.update_time      as mo_update_time,
       mo.deleted          as mo_deleted
from t_market_order as mo
where mo.deleted = false;