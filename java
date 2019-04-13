升级mysql-connector 5到8遇到的问题
2018-08-28 11:26:00   作者：MangoCool   来源：MangoCool
以下是我升级mysql-connector 从5.1.46到8.0.11时遇到的问题 ：

1、Establishing SSL connection without server's identity verification is not recommend

解决办法：在mysql连接字符串url中加入ssl=true或者false即可，如下：

                url=jdbc:mysql://xxx.xxx.xxx.xxx:3306/xxx?characterEncoding=utf8&useSSL=true

参考：https://blog.csdn.net/guoweimelon/article/details/50810399



2、The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.


解决办法：在mysql连接字符串url中加入serverTimezone=UTC即可，如下：。

               url=jdbc:mysql://xxx.xxx.xxx.xxx:3306/xxx?characterEncoding=utf8&useSSL=true&serverTimezone=UTC

参考：https://blog.csdn.net/yefengzhichen/article/details/51834511


3、java.sql.SQLException: The connection property 'zeroDateTimeBehavior' acceptable values are: 'CONVERT_TO_NULL', 'EXCEPTION' or 'ROUND'. The value 'convertToNull' is not acceptable.
java.lang.IllegalArgumentException: No enum constant com.mysql.cj.conf.PropertyDefinitions.ZeroDatetimeBehavior.CONVERTTONULL

解决办法：由于MySql废弃了convertToNull该写法，改为 CONVERT_TO_NULL

                url=jdbc:mysql://xxx.xxx.xxx.xxx:3306/xxx?characterEncoding=utf8&useSSL=true&serverTimezone=UTC&zeroDateTimeBehavior=CONVERT_TO_NULL

参考：https://blog.csdn.net/qq_32454537/article/details/80109800


4、Exception in thread "main" org.springframework.beans.factory.parsing.BeanDefinitionParsingException: Configuration problem: Unable to locate Spring NamespaceHandler for XML schema namespace [http://www.springframework.org/schema/context]
Offending resource: class path resource [spring-mybatis.xml]

参考：http://chenzhou123520.iteye.com/blog/1971322


5、Caused by: java.lang.UnsupportedClassVersionError: com/mysql/jdbc/Driver : Unsupported major.minor version 52.0

解决办法：mysql8 依赖jdk1.8，升级jdk
这是sql的使用
帮大忙了
哈哈哈哈哈哈