#!/usr/bin/env bash


#mybatis-base-1.0.0.jar
echo "------begin install mybatis-base-------"
mvn clean install:install-file -Dfile=./lib/mybatis-base-1.0.0.jar -DgroupId=com.tsyj -DartifactId=mybatis-base -Dversion=1.0.0 -Dpackaging=jar
echo "mybatis-base has installed..."
#all
echo "------begin install all-------"
mvn clean install
echo "------all has installed-------"