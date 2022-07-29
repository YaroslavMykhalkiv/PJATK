#!/bin/bash
read plik
ls "$plik" | grep ^- | wc -l
