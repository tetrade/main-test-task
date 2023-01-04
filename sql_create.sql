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

