#!/bin/bash
set a
a=$(who | grep "s21339" | wc -l)
while[ $a -ne 5 ]
do
slepp 4
echo $a
a=$(who | grep "s21339" | wc -l)
done
