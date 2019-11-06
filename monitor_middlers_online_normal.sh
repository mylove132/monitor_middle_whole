#!/bin/bash
RUNPATH=/xdfapp/autotest/monitor_middlers_online/bin
echo "start run middle monitor "
/bin/sh $RUNPATH/testrun.sh teacherpad normal 
/bin/sh $RUNPATH/testrun.sh teacher normal
/bin/sh $RUNPATH/testrun.sh parentapp normal
/bin/sh $RUNPATH/testrun.sh ticket normal
/bin/sh $RUNPATH/testrun.sh stupad normal
#/bin/sh testrun.sh mall normal

echo "run middle montor finsh"
