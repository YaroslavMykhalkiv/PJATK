#!/bin/bash
read l1
read l2
read l3
set suma
suma=$[$l1+$l2+$l3]
echo "suma: $suma"
set najw
najw=$l1
if [[ $najw -lt $l2 ]]
then
 najw=$l2
fi
if [[ $najw -lt $l3 ]]
then
 najw=$l3
fi
echo "max = $najw"
set min
min=$l1
if [[ $min -gt $l2 ]]
then
 najw=$l2
fi
if [[ $min -gt $l3 ]]
then
 najw=$l3
fi
echo "min=$min"
set LC
LC=$[ $(echo $najw | wc -l)-1]
echo "count=$LC"
sred=$[$suma/3]
echo "srednia=$sred"
