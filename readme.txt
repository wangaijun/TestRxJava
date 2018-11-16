RxJava是一个响应式编程框架，实现异步操作，如事件响应、网络请求等。
R表示Reactive（响应式），x表示任何，则Rx表示将响应式的编程思想应用于任何语言，如Java，因此RxJava就是响应式编程的Java版本。
同时，在RxJava的基础上，还扩展成为RxAndroid，引入了Android系统的线程概念。
响应式编程的核心思想是观察者模式，RxJava采用观察者模式的被动模式，通过订阅的方式将观察者与被观察者绑定，当被观察者的状态发生变化时，通知观察者做出适当的反应。
RxJava的五种基本用法：
1）掌握RxJava响应式编程的链式表达式
2）熟悉RxJava常见的流的加工函数，方便地管理异步数据流
3）使用RxJava&Lanbda表达式，避免冗余代码
4）使用RxJava&Retrofit，处理异步的网络请求
5）使用RxJava&RxBinding,处理异步的控件事件
6）使用RxJava&RxLifecycle，管理线程的循环任务，避免内存泄漏
对于一个Android工程而言，有两类的Gradle文件，一类是项目的Gradle文件，一类是工程的Gradle文件。工程的Gradle配置主要用于管理全部项目的通用属性和工程的构建，如工程构建脚本
（buildscript）、库的下载地址（jcenter）等
工程最基本的Gradle配置包含三个部分，即buildscript，allprojects，taskAffinity clean。其中
buildscript表示构建脚本，依赖库来源于jcenter，依赖于gradle的build tools工具包。
allprojects表示全部项目的通用配置，依赖库来自于jcenter；
task clean表示清除命令（gradle clean）脚本，删除工程根目录的build文件夹。
注意：JCenter与Maven Central都是下载第三方依赖库的仓库。相比于Maven central，JCenter拥有更多的依赖库，下载性能也更好，是Gradle的内置仓库。
但是Maven Central不是JCenter的子集，某些特定的依赖库仅存在与Maven Central中。

RxJava与RxAndroid：核心库，两者配合使用，RxJava提供基础的响应式编程框架，RxAndroid提供针对Anroid系统的补充。
Retrofit:网络加载库，封装OKHttp库，简洁地编写网络请求
通过Lambda表达式，省略多层嵌套的匿名类和匿名接口，改写为一层Lambda表达式，仅含有输入、输出、逻辑三个部分，增加代码的可读性。
