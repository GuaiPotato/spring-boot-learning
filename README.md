# Spring Boot 学习项目

## 1. Spring Boot 起步练习
spring-boot-quickstart

## 2. Spring Boot 配置管理
spring-boot-config

## 3. Spring Boot 静态资源和模板引擎
spring-boot-template



# 小结

> 第三周

今天的学习主要内容：

- **Spring Boot** 多模块管理

- 在 **Spring Boot** 项目中的读取 `yaml` 和 `properties` 配置文件
  - `@Value` ：`SpEL` 只能使用 `@Value`
  - `@ConfigurationProperties` ：快速配置，松散格式
- 一些 **Spring Boot** 启动配置，以及项目模式的切换。
- 前后端不分离的 **Spring Boot** 项目的项目结构
- `Bootstrap` 前端框架一些样式的使用

补充：

**Spring Boot** 项目中 `facicon` 不显示问题解决：https://www.cnblogs.com/ShakeTian/articles/13161945.html

> 第五周

- **MySQL驱动类名的变化**：在MySQL 5中，驱动类名为`com.mysql.jdbc.Driver`。然而在MySQL 8(8.0 版本以后)，JDBC驱动类名已经变成了`com.mysql.cj.jdbc.Driver`。在配置数据源时，需要按照MySQL版本选择对应的驱动类名。
- **resultMap vs resultType**：这两个标签都用于MyBatis中结果集的映射。`resultType`是映射到单个对象或基本数据类型，它是简洁易用的。例如，`resultType="com.xyz.User"` 或 `resultType="java.util.HashMap"`。然而，`resultMap`是更强大和灵活的结果映射机制，它可以处理复杂表的映射和关联对象，并允许一对一、一对多等复杂映射关系。
- **association vs collection**：这两个标签都用于ORM场景中的关联映射。`association`处理一对一关系，比如学生和班级关系，学生与班级为一对一关系。`collection`处理一对多关系，比如学生和课程关系，一门课程可以被多个学生选修，为一对多关系。
- **MyBatis关联查询和resultMap同名冲突**：如果在SQL查询返回的结果集有同名字段，并且需要分别映射到不同的属性，您需要在查询SQL里使用别名（ `AS` ）来解决冲突，然后在`resultMap`映射中使用这些别名去映射到正确的属性。
- **复习SQL语句基础**
