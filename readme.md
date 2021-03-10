# 第二周作业

代码分支： week-02

作业是模仿老师的架构，依葫芦画瓢自己重新写了一遍，所以总体上代码会有些许出入，但是大体相同。



## 功能



- 通过依赖注入实现用户注册
  - 通过首页注册/登录：localhost:8080
- UserRepository 的实现有 DBUserRepository（JDBC） 换成了 DBJPAUserRepository（JPA）
- 添加注册时候用户信息校验
  - id 必须大于 0，这个需要在代码 pers.cocoadel.user.platform.controller.RegisterController 中手动修改测试，因为页面没有id输入框
  - 密码长度必须 6 - 32 之间
  - 电话号码必须 1 开头的 11 位数字。
  - 校验失败回在页面红字提示

- 数据存储使用 derby，数据每次启动都会清空。

