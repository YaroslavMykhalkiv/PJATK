#!/bin/bash

w=`cat $1 | wc -l`
x=1
i=0
t=0
while test $x -lt $w
do
	if cat $1 | grep -q ":$i:"
	then
		m=`cat $1 | grep ":$i:"`
		for n in $m
		do
			for((g=`echo $n | cut -d ':' -f3`; g>0; g--))
			do
				let t++
				echo $n | cut -d ':' -f1
				sleep 1
			done
			let x++
		done
	fi

	if test $t -le $i
	then
		echo "puste"
		let t++
		sleep 1
	fi
	let i++
done
