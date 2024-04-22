# Spring Boot 学习项目

## 1. Spring Boot 起步练习
spring-boot-quickstart

## 2. Spring Boot 配置管理
spring-boot-config

## 3. Spring Boot 静态资源和模板引擎
spring-boot-template

## 4. MySQL 数据库操作（jdbc和jpa操作）
spring-boot-database

## 5. MyBatis & MyBatis-Plus
spring-boot-mybatis
spring-boot-mp

## 6. 日志框架
spring-boot-log

## 7. 全局异常处理

spring-boot-exception

## 8. 分布式文件服务

spring-boot-files





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

> 第六周

1. **MyBatis-Plus与Spring Boot 3依赖：**

   使用Spring Boot 3项目时，所需的依赖是`mybatis-plus-spring-boot3-starter`。

2. **对象定义（DO/DTO/VO）：**

   - **DO (Data Object)：** 与数据库表结构一一对应，主要用于数据库层次，作为持久层的数据对象。
   - **DTO (Data Transfer Object)：** 在不同层（如业务层与展示层之间，或服务层之间）传输的数据对象，包含了业务处理需要的数据。
   - **VO (View Object)：** 主要用于展示层，包含用户界面展示所需要的数据。

3. **MyBatis-Plus的常见操作：**

   - **CRUD操作：** MyBatis-Plus 提供了简便的API用于执行创建、读取、更新、删除操作。
   - **分页操作：** 通过配置分页插件，可以方便地使用`baseMapper.selectPage(Page, queryWrapper)`方法对查询结果进行分页处理。
   - **分组和排序：** 可以使用动态SQL或查询构造器（如`QueryWrapper`或`LambdaQueryWrapper`）来执行包含分组和排序的复杂SQL查询。
   - **自动填充：** MyBatis-Plus可以自动填充特定字段，例如创建时间和更新时间。可以通过自定义元对象字段填充控制器实现，结合注解`@TableField(fill = FieldFill.INSERT)`等进行配置。
   - **逻辑删除：** 默认使用字段`deleteFlag`作为标识，其中默认删除值为`1`，未删除值为`0`。配置后，逻辑删除功能会自动生效。

> 第七周

1. 复习了JAVA基础：数据类型、异常处理、注解的概念。

2. 复习HTTP常见状态码：200、301、302、304、400、401、403、404、500等.

3. `jakarta.validation.constraints` 的注解：

   | 注解                         | 作用                                              |
   | :--------------------------- | :------------------------------------------------ |
   | @NotNull                     | 标注的元素不能为null                              |
   | @NotEmpty                    | 标注的元素不能为空，可用于字符串、集合、Map或数组 |
   | @NotBlank                    | 标注的字符串不能为空且至少包含一个非空白字符      |
   | @Min(value)                  | 标注的元素至少为指定的值                          |
   | @Max(value)                  | 标注的元素最大不能超过指定的值                    |
   | @Size(min=, max=)            | 标注的元素大小必须在指定的范围之内                |
   | @Digits(integer=, fraction=) | 标注的数字的整数部分和小数部分的最大位数          |
   | @Positive                    | 标注的元素必须为正数                              |
   | @PositiveOrZero              | 标注的元素必须为非负数（正数或0）                 |
   | @Negative                    | 标注的元素必须为负数                              |
   | @NegativeOrZero              | 标注的元素必须为非正数（负数或0）                 |
   | @Email                       | 标注的元素必须是电子邮件地址                      |
   | @Pattern(regexp=)            | 标注的字符串必须匹配指定的正则表达式              |
   | @Past                        | 标注的日期必须是过去的日期                        |
   | @PastOrPresent               | 标注的日期必须是过去或现在的日期                  |
   | @Future                      | 标注的日期必须是将来的日期                        |
   | @FutureOrPresent             | 标注的日期必须是将来或现在的日期                  |

4. 自定义异常和返回结果：

   1. 定义错误码枚举：确定错误类型及消息。
   2. 创建异常类：继承 `Exception` ，关联错误码枚举。
   3. 抛出异常：在逻辑中检测并抛出自定义异常。
   4. 捕获异常：在上层逻辑捕获 `@ExceptionHandler(value = Exception.class)` 自定义异常。
   5. 格式化返回：根据异常返回统一格式的错误信息。

5. 自定义注解的使用：

   1. 定义注解:
      - 使用`@interface`关键字创建自定义注解。
      - 指定注解的适用目标（方法、字段、类等）和保留策略（源码、类文件、运行时）。
      - 定义注解内的元素，可设置默认值。
   2. 应用注解:
      - 在代码中将自定义注解应用于类、方法、字段或其他注解上。
      - 提供必要的注解元素值，除非有默认值。
   3. 处理注解:
      - 通过反射访问类、方法或字段上的注解信息。
      - 根据注解元素的值执行特定的逻辑。

6. 涉及的注解：

   1. `@RestControllerAdvice` 和 `@RestController` 
   2.  `@ExceptionHandler(value = Exception.class)` 
   3.  `@Target({ElementType.FIELD})`  、 `@Retention(RetentionPolicy.RUNTIME)` 和 `@Constraint(validatedBy = IDCardValidator.class)` 。

> 第八周

学习了SpringBoot的文件服务，包括本地文件服务和分布式文件服务（OSS）。

**前端反向代理：**

vue3中在项目更目录下创建 `vue.confing.js`

```js
module.exports = {
  devServer: {
    port: 8090, // 端口号
    proxy: {
      "/api": {
        target: "http://localhost:8080", // 目标接口的域名
        changeOrigin: true,
        ws: false,
        pathRewrite: {
          "^/api": "/", // 将/login重写为/user/login
        },
      }
    },
  },
};
```

**本地文件服务：**

配置文件路径：

```yaml
file:
  upload-path: "D:\\Projects\\Subjects\\Spring Boot Back Basic\\upload"

spring:
  web:
    resources:
      static-locations: classpath:/static,file:${file.upload-path}
```

**分布式MinIO：**

依赖：

```xml
<!--    minio    -->
<dependency>
    <groupId>io.minio</groupId>
    <artifactId>minio</artifactId>
    <version>8.5.9</version>
</dependency>
```

配置文件路径：

```yaml
minio:
  endPoint: http://43.137.12.232:9000
  accessKey: admin
  secretKey: admin123
```

初始化：

```java
@PostConstruct
public void init() {
    client = MinioClient.builder()
            .endpoint(endPoint)
            .credentials(accessKey, secretKey)
            .build();
}
```

**阿里云OSS：**

[官方文档](https://help.aliyun.com/zh/oss/)

依赖：

```xml
<!--    aliyun-oss    -->
<dependency>
    <groupId>com.aliyun.oss</groupId>
    <artifactId>aliyun-sdk-oss</artifactId>
    <version>3.14.0</version>
</dependency>
```

 配置文件路径：

```yaml
minio:
  endPoint: http://43.137.12.232:9000
  accessKey: admin
  secretKey: admin123
```

初始化：

```java
OSS ossClient = new OSSClientBuilder().build(endpoint, accessKey, accessSecretKey);
```

