此框架是基于SpringMVC+Spring+myBatis的封装，为了快速开发，做了一些改进。

1，由于myBatis是半自动框架，对数据库的操作比较麻烦，为了集成hibernate的优点，
   封装了myBatis的基本操作，基于实体类的注解，数据库默认用下划线规范，字段用驼峰命名规范。
   也可以用实体的注解实现其它变换。
   
2，利用泛型的特点，对service和dao进行了泛型注入，在简单的增删改查条件查询更新，等操作，不用在
   service和dao中写代码。控制层入口类，com.qk.core.module.user.web.UserController。
   
3，加入代码代码生成器，更好的规范代码，和提高开发效率，地址 https://github.com/wangbing234/code_factory
   同时也加入了文档生成器。
	1)代码生成器主类路径：com.codefactory.CodeGenerator.java
	2)代码生成器主类路径：com.doc.DB_Main.java
	3)代码生成器主类路径：com.doc.IF_Main.java


计划：在实体类校验这块打算也使用实体注解实现，统一校验。
	希望提出宝贵意见，持续优化代码框架。
