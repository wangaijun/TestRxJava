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
Schedulers的值：
computation：计算线程，io：io线程，newThread:新线程，from：由执行器转变的线程？，test测试线程，immediate：当前线程（立即执行）、trampoline：当前线程（队列执行）

just:输入待分发的异步接口，调用完成后直接分发，使编写更加简洁，省略其他回调。
from：与just类似，异步接口的数据变成数组，将数组转变成单个元素，分发多次。
map：映射，调用大小写转换、控制取值范围等特定的方法加工数据流，继续分发。
flatMap: 增肥映射,将一个列表变成多个，一个一个发射。
reduce：简化，把数组的多个值合成一个数据值，分发一次

闭包类似于一个可调用的对象，可以记录作用域的相关信息。Java中使用兰布达表达式代替匿名类的方法，其概念接近于闭包。

Retrofit是一个可用于Android的网络请求库，简化网络请求的编写，提高开发效率。Retrofit基于OkHttp，在其之上进一步封装，最终的网络请求都是交给OkHttp处理。
在Retrofit的外层接口，仅仅使用注解，就能实现复杂的网络请求功能，完成客户端与服务器的数据交互，开发极其高校。
RxJava的核心是处理异步任务，而网络请求正是最常用的异步任务。
在实现网络请求的过程中，同时使用Retrofit和RxJava，可以极大地提高开发效率