#!/bin/bash
echo czw 7
read c

for ((i=1 ; i<=$c ; i++)) ; do
        for ((j=1 ; j <=$c ; j++)) ; do
                echo -n $(( $i*$j )) " "
        done
echo
done
