drop table if exists t_market_order_item;
create table t_market_order_item
(
    id              int(10)        not null auto_increment primary key comment 'Row id',
    market_order_id int(10)        not null comment 'Ref: t_market_order.id',
    part_id         int(10)        not null comment 'Ref: t_part.id',
    pcs             decimal(20, 3) not null comment 'Pcs',
    remark          text           null comment 'Remark text',
    state           int(3)         not null comment 'State code',
    create_time     datetime       not null comment 'Create time',
    update_time     datetime       not null comment 'Last update time',
    deleted         bit(1)         not null comment 'deleted mark'
) engine = 'Innodb'
  charset utf8
  collate utf8_general_ci;

select moi.id              as moi_id,
       moi.market_order_id as moi_market_order_id,
       moi.part_id         as moi_part_id,
       moi.pcs             as moi_pcs,
       moi.remark          as moi_remark,
       moi.state           as moi_state,
       moi.create_time     as moi_create_time,
       moi.update_time     as moi_update_time,
       moi.deleted         as moi_deleted
from t_market_order_item as moi
where moi.deleted = false;