create table decision_table_rules
(
    id               bigint auto_increment
        primary key,
    rule_name        varchar(255)                        not null,
    rule_description text                                null,
    rule_data        longtext                            not null,
    version          int       default 1                 not null,
    created_at       timestamp default CURRENT_TIMESTAMP not null,
    updated_at       timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    effective_from   datetime                            not null,
    effective_to     datetime                            null
)
    charset = utf8mb4;

