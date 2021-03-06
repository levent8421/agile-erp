drop table if exists t_part;

create table t_part
(
    id               int(10) auto_increment
        primary key,
    user_id          int(10)      not null,
    part_category_id int(10)      not null,
    part_status_id   int(10)      not null,
    part_cluster_id  int(10)      not null,
    partNo           varchar(32)  not null,
    description      varchar(128) null,
    model            varchar(128) null,
    packaging        varchar(128) null,
    brand            varchar(128) null,
    packingQty       varchar(128) null,
    version          varchar(4)   null,
    create_time      datetime     null,
    update_time      datetime     null comment '更新时间',
    deleted          bit          null comment '标记是否删除'
);

create index bom
    on t_part (partNo);

#  2021-03-04 ERP
alter table t_part
    add column
        produce_type int(3) not null default 0 comment 'Part type',
    add column
        task_time decimal(20, 3) not null default 0 comment 'Task time',
    add column
        task_cost decimal(20, 10) not null default 0 comment 'Task cost' ,
    add column
        has_children bit(1) not null default 0 comment 'mark this part has children';


select p.id               p_id,
       p.user_id          p_user_id,
       p.part_category_id p_part_category_id,
       p.part_status_id   p_part_status_id,
       p.part_cluster_id  p_part_cluster_id,
       p.partNo           p_partNo,
       p.description      p_description,
       p.model            p_model,
       p.packaging        p_packaging,
       p.brand            p_brand,
       p.packingQty       p_packingQty,
       p.version          p_version,
       p.create_time      p_create_time,
       p.update_time      p_update_time,
       p.deleted          p_deleted
from t_part as p
where (p.deleted = false or p.deleted is null);