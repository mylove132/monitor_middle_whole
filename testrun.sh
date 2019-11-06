#!/bin/bash

DEPLOY_DIR=/xdfapp/autotest/monitor_middlers_online/target
#jar包目录
LIB_DIR=$DEPLOY_DIR/lib

echo "Current deploy dir is $DEPLOY_DIR"
SERVER_NAME="middler moniter"

#jar路径组装成classpath格式
LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'|tr "\n" ":"`
#java启动参数

echo "$SERVER_NAME starting..."

/xdfapp/jdk/jdk1.8.0_141/bin/java -classpath $LIB_DIR:$LIB_JARS okjiaoyu.qa.middle.auto.main.MainJUnit $1 $2
