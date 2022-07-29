#!/bin/bash

echo "" > $1
for i in {1..6}
do
	y=${RANDOM:0:1}
	z=${RANDOM:0:1}
	echo "p$i:$y:$z" >> $1
done
