# springmvc
底层采用sping架构，使用maven进行项目管理，ebea连接数据库，log4j打印日志

## 项目启动

1. 修改ebean.properties配置文件，正确的连接数据库
2. 数据库中建表（以下语句是插入mysql的语句）
```
create table parent (
  id                        integer auto_increment not null,
  name                      varchar(255),
  student_id                integer,
  constraint pk_parent primary key (id))
;

create table student (
  id                        integer auto_increment not null,
  name                      varchar(255),
  age                       integer,
  constraint pk_student primary key (id))
;
```
3. 使用maven命令：mvn clean compile 编译项目

4. 使用maven命令用配置的jetty启动服务：mven jetty:run

5. 浏览器中输入地址：http://localhost:8080/springmvc
