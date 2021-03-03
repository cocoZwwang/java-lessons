# 第一周作业

代码分支： week-01

## 功能

- 注册
  - /user/signUp 访问注册页面
  - 输入邮箱、密码注册
  - 邮箱不能重复注册，重复注册会在当前页面有错误提示
  - 注册成功 会 forward 到注册成功页面
  - 点击注册成功页面下的按钮可以跳转到登录页面
- 登录
  - 使用注册账号登录
  - 登录成功会跳转到登录成功页面
  - 失败会在失败页面提示



## 实现

Web MVC 大体上使用老师的代码，自己做了一些修改和额外添加了一些功能：

- 实现一个简单的 IOC
  - 通过 ServletContextListener 的实现类 DBConnectionInitializerListener 的 contextInitialized 方法，初始化一些单例对象，并且把对象存储到到本地 Map 中，实现一个简单 IOC 容器，提供依赖查找功能。 
  - DBConnectionInitializerListener  通过web.xml注册。
  - 注册的单例对象，包 数据库相关类 DBConnectionManager、JdbcHelper，还有业务层 Repsotory、Service 相关对象。

## 数据存储

- 使用 derby，数据每次启动都会清空。