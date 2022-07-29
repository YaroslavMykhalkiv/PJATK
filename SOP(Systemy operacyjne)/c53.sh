#!/bin/bash
ls -l $1| tr -s ' ' |cut -d' ' -f7 >  $2.txt
