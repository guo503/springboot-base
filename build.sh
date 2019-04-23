#!/bin/bash -ilex
#####  jenkins发布  ####

#####  传参获取需要更新的项目和版本信息
#项目
project_name=$1

#####  需要操作的远端目录路径
path=/usr/project/${project_name}

#####  要修改内容的远端文件夹
target_dir=${path}
shell_bin=${path}/bin/start.sh

#####jar目录
echo "path = ${path}"
echo "target_dir = ${target_dir}"
echo "shell_bin = ${shell_bin}"

echo "-------------------开始执行mvn----------------------"

cd /var/lib/jenkins/workspace/${project_name};
return_value=`mvn clean & mvn install`;

echo "${return_value}";
num=`echo "${return_value}" | grep "BUILD FAILURE" |wc -l`;

[ $num -ne 0 ]&& {
        echo "-----------------------> maven构建失败 <-----------------------";
        exit 1;
};


  
    if [ -d ${path} ]; then
        export JAVA_HOME=/usr/java/jdk1.8.0_201;
        export JRE_HOME=${JAVA_HOME}/jre;
        export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib;
        export PATH=${JAVA_HOME}/bin:$PATH;
        echo '停止服务：'${project_name};                                                      
        sh ${shell_bin} stop ${project_name};
        echo '-------------------------------------------------------------------------------------';
        echo '清空目录：'${target_dir};
        rm -rf ${target_dir}/*.jar;
        echo '-------------------------------------------------------------------------------------';
        echo '从target目录复制到project目录：'${target_dir};
        cp /var/lib/jenkins/workspace/${project_name}/target/*.jar ${target_dir}; 
        rm -rf /var/lib/jenkins/workspace/${project_name}/target/;
        echo '-------------------------------------------------------------------------------------';
        echo '重启服务';
        BUILD_ID=DONTKILLME;
        sh ${shell_bin} start ${project_name};
        echo '-------------------------------------------------------------------------------------';
    else
        echo 'There is no such file：'${path};
    fi
