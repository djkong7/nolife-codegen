#!/bin/bash
javac frontend/*.java frontend/ast/*.java frontend/parser/nolife/*.java frontend/visitor/*.java
mkdir -p ../MyCodeFiles/
for file in ../CodeGeneratorTestfiles/done/*.nl; do
  echo ${file##.*/}
  filename=${file##.*/}
  java frontend/Frontend ${file} > ../MyCodeFiles/${filename%.*}.S
  gcc ../MyCodeFiles/${filename%.*}.S -o t
  ./t
done