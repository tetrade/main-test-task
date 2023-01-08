-- we don't know how to generate root <with-no-name> (class Root) :(
grant audit_abort_exempt, firewall_exempt, select, system_user on *.* to 'mysql.infoschema'@localhost;

grant audit_abort_exempt, authentication_policy_admin, backup_admin, clone_admin, connection_admin, firewall_exempt, persist_ro_variables_admin, session_variables_admin, shutdown, super, system_user, system_variables_admin on *.* to 'mysql.session'@localhost;

grant audit_abort_exempt, firewall_exempt, system_user on *.* to 'mysql.sys'@localhost;

grant alter, alter routine, application_password_admin, audit_abort_exempt, audit_admin, authentication_policy_admin, backup_admin, binlog_admin, binlog_encryption_admin, clone_admin, connection_admin, create, create role, create routine, create tablespace, create temporary tables, create user, create view, delete, drop, drop role, encryption_key_admin, event, execute, file, firewall_exempt, flush_optimizer_costs, flush_status, flush_tables, flush_user_resources, group_replication_admin, group_replication_stream, index, innodb_redo_log_archive, innodb_redo_log_enable, insert, lock tables, passwordless_user_admin, persist_ro_variables_admin, process, references, reload, replication client, replication slave, replication_applier, replication_slave_admin, resource_group_admin, resource_group_user, role_admin, select, sensitive_variables_observer, service_connection_admin, session_variables_admin, set_user_id, show databases, show view, show_routine, shutdown, super, system_user, system_variables_admin, table_encryption_admin, trigger, update, xa_recover_admin, grant option on *.* to root@localhost;

create table contracts
(
    name          char(50) not null,
    type          char(8)  not null,
    planned_start date     null,
    id            int auto_increment
        primary key,
    planned_end   date     null,
    actual_start  date     null,
    actual_end    date     null,
    user_id       int      null,
    constraint check_type
        check (`type` in (_utf8mb4\'ÐÐ°ÐºÑÐ¿ÐºÐ°\',_utf8mb4\'ÐÐ¾ÑÑÐ°Ð²ÐºÐ°\',_utf8mb4\'Ð Ð°Ð±Ð¾ÑÑ\'))
);

create table contract_stages
(
    name          char(50) not null,
    actual_start  date     null,
    planned_start date     null,
    id            int auto_increment
        primary key,
    contract_id   int      not null,
    actual_end    date     null,
    planned_end   date     null,
    constraint contract_stages_contracts_id_fk
        foreign key (contract_id) references contracts (id)
);

create table counterparty_organizations
(
    id      int auto_increment
        primary key,
    name    varchar(50)  not null,
    address varchar(100) null,
    inn     char(12)     null
);

create table counterparty_contracts
(
    id                           int auto_increment
        primary key,
    name                         char(50) null,
    type                         char(8)  null,
    counterparty_organization_id int      null,
    amount                       int      null,
    actual_start                 date     null,
    actual_end                   date     null,
    planned_start                date     null,
    planned_end                  date     null,
    constraint counterparty_contracts_ibfk_1
        foreign key (counterparty_organization_id) references counterparty_organizations (id),
    check (`type` in (_utf8mb4\'ÐÐ°ÐºÑÐ¿ÐºÐ°\',_utf8mb4\'ÐÐ¾ÑÑÐ°Ð²ÐºÐ°\',_utf8mb4\'Ð Ð°Ð±Ð¾ÑÑ\'))
);

create index organization_id
    on counterparty_contracts (counterparty_organization_id);

create index inn
    on counterparty_organizations (inn);

