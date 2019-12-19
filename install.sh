#!/usr/bin/env bash


#mybatis-base-1.0.0.jar
echo "------begin install mybatis-base-------"
mvn clean install:install-file -Dfile=./lib/mybatis-base-1.0.0.jar -DgroupId=com.tsyj -DartifactId=mybatis-base -Dversion=1.0.0 -Dpackaging=jar
echo "mybatis-base has installed..."
#xxl-job-core-1.0.0.jar
echo "------begin install xxl-job-core-------"
mvn clean install:install-file -Dfile=./lib/xxl-job-core-1.0.0.jar -DgroupId=com.xuxueli -DartifactId=xxl-job-core -Dversion=1.0.0 -Dpackaging=jar
echo "xxl-job-core has installed..."
#all
echo "------begin install all-------"
mvn clean install
echo "------all has installed-------"