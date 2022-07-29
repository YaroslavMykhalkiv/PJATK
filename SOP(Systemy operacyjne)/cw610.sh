#!/bin/bash
read N
for((k=1; k<=N; k++))
do
for((i=1; i<=N; i++)) ; do
let "o = k * i"
echo -n "$o "
done
echo ""
done
