create table scheduled_tasks (
  task_name varchar(100) not null,
  task_instance varchar(100) not null,
  task_data bytea,
  execution_time timestamp with time zone not null,
  picked BOOLEAN not null,
  picked_by varchar(500),
  last_success timestamp with time zone,
  last_failure timestamp with time zone,
  consecutive_failures INT,
  last_heartbeat timestamp with time zone,
  version BIGINT not null,
  PRIMARY KEY (task_name, task_instance)
)
