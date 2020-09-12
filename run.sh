#!/usr/bin/env bash


#mybatis-base-1.0.0.jar
echo "------begin install-------"
mvn clean install -Dmaven.test.skip=true
echo "------installed-------"
cd target
echo '当前路径--->'$(pwd)
#后台运行和日志目录：
#nohup java -jar -Dloader.path=.,resources,lib springboot-base.jar >/xxx/log/springboot-base.log &
#前台运行：
java -jar -Dloader.path=.,resources,lib springboot-base.jar