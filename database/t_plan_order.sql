drop table if exists t_plan_order;

create table t_plan_order
(
    id                   int(10)         not null auto_increment primary key comment 'Row id',
    order_no             varchar(255)    not null comment 'Produce order number',
    plan_type            int(3)          not null comment 'Plan type',
    market_order_item_id int(10)         null comment 'Ref: t_market_order_item.id',
    market_order_id      int(10)         null comment 'Ref: t_market_order.id',
    part_id              int(10)         not null comment 'Ref: t_part.id',
    pcs                  decimal(20, 3)  not null comment 'PCS',
    pcs_completed        decimal(20, 3)  not null comment 'PCS for completed',
    state                int(3)          not null comment 'State code',
    remark               text            null comment 'Remark Text',
    start_date           datetime        null comment 'order start date',
    end_date             datetime        null comment 'Order end date',
    plan_start_date      datetime        null comment 'Order plan start date',
    plan_end_date        datetime        null comment 'Order end date',
    supplier_id          int(10)         not null comment 'Ref: t_supplier.id',
    task_time            decimal(20, 3)  not null comment 'Task time in hours',
    task_cost            decimal(20, 10) not null comment 'Task cost in yuan',
    create_time          datetime        not null comment 'Create time',
    update_time          datetime        not null comment 'Last update time',
    deleted              bit(1)          not null comment 'deleted mark'
) engine = 'Innodb'
  charset utf8
  collate utf8_general_ci;