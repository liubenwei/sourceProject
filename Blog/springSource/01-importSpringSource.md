    1、先来说下导入环境和工具：
        java版本：1.8
        idea： idea2020
        gradle：gradle5.3
    2、gradle的安装
        idea导入spring的源码时，每次构建的时候都会去下载gradle，所以如果我们能提前下好gradle可以提高构建速度。
        gradle下载地址：https://services.gradle.org/distributions/
        上面放的地址可以找到gradle的所有版本。(注意：构建spring源码是有版本要求的，所以尽量选择高版本的gradle)
        下载完成之后可以配置环境变量什么的，也可以不配，问题不大。
    3、在idea2020中配置gradle
        如下图所示：
        
    4、下载并且修改build.gradle
        先放github上spring源码的地址：https://github.com/spring-projects/spring-framework/tree/5.1.x (直接从github上进的话记得选择5.1分支)
           下载源码有两种：
            1、使用git clone从github上克隆(不推荐去gitee上下载所谓的镜像，我下过，和github上的代码不一致，应该是没更新的缘故)
            2、直接下载jar包
            这里推荐直接下载压缩包，个人感觉使用git clone有点慢。下载完成后解压缩即可。
        修改spring源码依赖的jar包的下载地址，打开根目录下的build.gradle
        第一处： 在文件的首行，修改后的配置如下：
            repositories {
            		maven { url "https://maven.aliyun.com/repository/spring-plugin" }
            		maven{ url "https://maven.aliyun.com/nexus/content/repositories/spring-plugin"}
            		maven { url "https://repo.spring.io/plugins-release" }
            	}
        第二处：大概在第150行，修改后的配置如下：
            repositories {
            		maven { url "https://maven.aliyun.com/repository/central" }
            		maven { url "https://repo.spring.io/libs-release" }
            		mavenCentral()
            	}
    5、打开idea2020，导入spring源码
        idea2020导入源码之后会自动进行build，这个时候会下载许多依赖包，等一会儿就好了。
    6、到了这里基本上已经讲完了。我是一名java程序猿，欢迎加我的个人微信交流：zmy 