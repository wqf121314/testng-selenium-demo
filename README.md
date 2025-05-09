# testng-selenium-demo
TestNG and Selenium Demo
## 介绍
testng.xml 配置文件定义了两个阶段的测试：
SerialPhase: 串行执行。
ParallelPhase: 并行执行，每个方法单独线程，线程数为 3。
可以根据env来指定任意的tag来运行测试
## 运行
mvn clean test -Denv=env1