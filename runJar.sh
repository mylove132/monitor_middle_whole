#!/bin/bash
LIBPATH=/xdfapp/autotest/monitor_middlers_online/target/lib
echo "start run testcase"
java -Djava.ext.dirs=$LIBPATH -jar $LIBPATH/middle_monitors.jar $1 $2 
echo "run testcase finsh"
