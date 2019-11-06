#!/bin/bash

DEPLOY_DIR=/xdfapp/autotest/monitor_middlers_online
DATA_DIR=/xdfapp/jenkins/data/workspace/qa_middle_monitors_online

#jar包目录
echo "start copy file"
\cp -rf $DATA_DIR/target/lib/* $DEPLOY_DIR/target/lib/
\cp -rf $DATA_DIR/target/classes/* $DEPLOY_DIR/target/classes/
\cp -rf $DATA_DIR/target/middle_monitors.jar $DEPLOY_DIR/target/lib  
echo "copy finsh"
