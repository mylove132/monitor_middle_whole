#!/bin/bash
echo "start run middle exception monitor "
/bin/sh testrun.sh teacherpad exception 
#/bin/sh testrun.sh teacher exception
/bin/sh testrun.sh parentapp exception
/bin/sh testrun.sh ticket exception
/bin/sh testrun.sh stupad exception
#/bin/sh testrun.sh mall exception

echo "run middle montor exception finsh"
