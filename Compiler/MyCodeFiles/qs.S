.intel_syntax
.section .rodata
.__flt0: .float 1.700000
.__str0: .string "A:"
.__str1: .string "A?"
.int_format:
	.string "%d\12\0"
.str_format:
	.string "%s\12\0"
.flt_format:
	.string "%f\12\0"
.char_format:
	.string "%c\12\0"
.int_in_format:
	.string "%d"
.flt_in_format:
	.string "%f"
.char_in_format:
	.string "%c"
.text
.globl main;
.type main, @function
main:
push %ebp
mov %ebp, %esp
sub %esp, 116
mov %ebx, offset flat:.__main_ebp
mov dword ptr [%ebx], %ebp

#ASSIGNMENT
#ARRAY REFERENCE
mov %ecx, 0
mov %ebx, 20
sub %ebx, %ecx
imul %ebx, 4
add %ebx, -84
add %ebx, %ebp
mov %ecx, 1
mov %esi, 0
#SUBTRACT STATEMENT
sub %esi, %ecx
mov dword ptr [%ebx], %esi

#ASSIGNMENT
#ARRAY REFERENCE
mov %ecx, 20
mov %ebx, 20
sub %ebx, %ecx
imul %ebx, 4
add %ebx, -84
add %ebx, %ebp
mov %ecx, 1000
mov dword ptr [%ebx], %ecx

#FUNCTION INVOCATION
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#PUSH THE PARAMS
call readarray
add %esp, 0
add %esp, 0
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

#FUNCTION INVOCATION
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#PUSH THE PARAMS
call writearray
add %esp, 0
add %esp, 0
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

#FUNCTION INVOCATION
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#PUSH THE PARAMS
#OTHER PARAM
mov %ebx, 19
#compilerTempNext: -88
mov %ecx, -88
add %ecx, %ebp
mov dword ptr [%ecx], %ebx
push %ecx
#OTHER PARAM
mov %ebx, 1
#compilerTempNext: -92
mov %ecx, -92
add %ecx, %ebp
mov dword ptr [%ecx], %ebx
push %ecx
#SCALAR REF PARAM
mov %ebx, -84
add %ebx, %ebp
push %ebx
call quicksort
add %esp, 12
add %esp, 12
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

#FUNCTION INVOCATION
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#PUSH THE PARAMS
call writearray
add %esp, 0
add %esp, 0
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

leave
ret

.globl readarray;
.type readarray, @function
readarray:
push %ebp
mov %ebp, %esp
sub %esp, 36

#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
push offset flat:.__str1
#WRITE STATEMENT
push offset flat:.str_format
call printf
add %esp,8
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %ecx, 1
mov dword ptr [%ebx], %ecx

#WHILE STATEMENT
while0:
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
mov %ecx, 20
#LESS THAN
cmp %ebx, %ecx
jge less0
mov %ebx, 1
jmp continue1
less0:
mov %ebx, 0
continue1:
cmp %ebx, 0
je false0
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

#READ STATEMENT
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %ebx, 20
sub %ebx, %ecx
imul %ebx, 4
add %ebx, -84
mov %ecx, offset flat:.__main_ebp
mov %ecx, dword ptr [%ecx]
add %ebx, %ecx
push %ebx
push offset flat:.int_in_format
call scanf
add %esp,8

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %esi, 1
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

jmp while0
false0:

leave
ret

.globl writearray;
.type writearray, @function
writearray:
push %ebp
mov %ebp, %esp
sub %esp, 36

#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
push offset flat:.__str0
#WRITE STATEMENT
push offset flat:.str_format
call printf
add %esp,8
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %ecx, 1
mov dword ptr [%ebx], %ecx

#WHILE STATEMENT
while1:
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
mov %ecx, 20
#LESS THAN
cmp %ebx, %ecx
jge less1
mov %ebx, 1
jmp continue3
less1:
mov %ebx, 0
continue3:
cmp %ebx, 0
je false1
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#ARRAY REFERENCE
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %ebx, 20
sub %ebx, %ecx
imul %ebx, 4
add %ebx, -84
mov %ecx, offset flat:.__main_ebp
mov %ecx, dword ptr [%ecx]
add %ebx, %ecx
mov %ebx, dword ptr [%ebx]
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %esi, 1
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

jmp while1
false1:

leave
ret

.globl partition;
.type partition, @function
partition:
push %ebp
mov %ebp, %esp
sub %esp, 52

#ASSIGNMENT
mov %ebx, -12
add %ebx, %ebp
#ARRAY REFERENCE
#SCALAR REF
mov %esi, 12
add %esi, %ebp
mov %esi, dword ptr [%esi]
#PARAMETER REFERENCE
mov %esi, dword ptr [%esi]
mov %ecx, 20
sub %ecx, %esi
imul %ecx, 4
mov %esi, 8
add %esi, %ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
mov %ecx, dword ptr [%ecx]
mov dword ptr [%ebx], %ecx

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %ecx, 1
#SCALAR REF
mov %esi, 12
add %esi, %ebp
mov %esi, dword ptr [%esi]
#PARAMETER REFERENCE
mov %esi, dword ptr [%esi]
#SUBTRACT STATEMENT
sub %esi, %ecx
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, -8
add %ebx, %ebp
#SCALAR REF
mov %ecx, 16
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
mov %esi, 1
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

#WHILE STATEMENT
while2:
#FLOAT CONSTANT
finit
fld dword ptr .__flt0
sub %esp, 4
fstp dword ptr [%esp]
pop %ebx
cmp %ebx, 0
je false2
#ASSIGNMENT
mov %ebx, -8
add %ebx, %ebp
mov %ecx, 1
#SCALAR REF
mov %esi, -8
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SUBTRACT STATEMENT
sub %esi, %ecx
mov dword ptr [%ebx], %esi

#WHILE STATEMENT
while3:
#ARRAY REFERENCE
#SCALAR REF
mov %ecx, -8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %ebx, 20
sub %ebx, %ecx
imul %ebx, 4
add %ebx, -84
mov %ecx, offset flat:.__main_ebp
mov %ecx, dword ptr [%ecx]
add %ebx, %ecx
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, -12
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#GREATER THAN
cmp %ebx, %ecx
jg greater0
mov %ebx, 0
jmp continue6
greater0:
mov %ebx, 1
continue6:
cmp %ebx, 0
je false3
#ASSIGNMENT
mov %ebx, -8
add %ebx, %ebp
mov %ecx, 1
#SCALAR REF
mov %esi, -8
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SUBTRACT STATEMENT
sub %esi, %ecx
mov dword ptr [%ebx], %esi

jmp while3
false3:

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %esi, 1
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

#WHILE STATEMENT
while4:
#ARRAY REFERENCE
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %ebx, 20
sub %ebx, %ecx
imul %ebx, 4
add %ebx, -84
mov %ecx, offset flat:.__main_ebp
mov %ecx, dword ptr [%ecx]
add %ebx, %ecx
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, -12
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#LESS THAN
cmp %ebx, %ecx
jge less2
mov %ebx, 1
jmp continue8
less2:
mov %ebx, 0
continue8:
cmp %ebx, 0
je false4
#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %esi, 1
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

jmp while4
false4:

#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %ecx, -8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#LESS THAN
cmp %ebx, %ecx
jge less3
mov %ebx, 1
jmp continue10
less3:
mov %ebx, 0
continue10:
#IF STATEMENT
cmp %ebx, 0
je false5
#ASSIGNMENT
mov %ecx, -16
add %ecx, %ebp
#ARRAY REFERENCE
#SCALAR REF
mov %edi, -4
add %edi, %ebp
mov %edi, dword ptr [%edi]
mov %esi, 20
sub %esi, %edi
imul %esi, 4
add %esi, -84
mov %edi, offset flat:.__main_ebp
mov %edi, dword ptr [%edi]
add %esi, %edi
mov %esi, dword ptr [%esi]
mov dword ptr [%ecx], %esi

#ASSIGNMENT
#ARRAY REFERENCE
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
mov %ecx, 20
sub %ecx, %esi
imul %ecx, 4
add %ecx, -84
mov %esi, offset flat:.__main_ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
#ARRAY REFERENCE
#SCALAR REF
mov %edi, -8
add %edi, %ebp
mov %edi, dword ptr [%edi]
mov %esi, 20
sub %esi, %edi
imul %esi, 4
add %esi, -84
mov %edi, offset flat:.__main_ebp
mov %edi, dword ptr [%edi]
add %esi, %edi
mov %esi, dword ptr [%esi]
mov dword ptr [%ecx], %esi

#ASSIGNMENT
#ARRAY REFERENCE
#SCALAR REF
mov %esi, -8
add %esi, %ebp
mov %esi, dword ptr [%esi]
mov %ecx, 20
sub %ecx, %esi
imul %ecx, 4
add %ecx, -84
mov %esi, offset flat:.__main_ebp
mov %esi, dword ptr [%esi]
add %ecx, %esi
#SCALAR REF
mov %esi, -16
add %esi, %ebp
mov %esi, dword ptr [%esi]
mov dword ptr [%ecx], %esi

jmp continue9
false5:
#SCALAR REF
mov %ecx, -8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %eax, %ecx
leave
ret
jmp continue9
continue9:

jmp while2
false2:

leave
ret

.globl quicksort;
.type quicksort, @function
quicksort:
push %ebp
mov %ebp, %esp
sub %esp, 36

#SCALAR REF
mov %ecx, 12
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
#SCALAR REF
mov %esi, 16
add %esi, %ebp
mov %esi, dword ptr [%esi]
#PARAMETER REFERENCE
mov %esi, dword ptr [%esi]
#LESS THAN
cmp %ecx, %esi
jge less4
mov %ecx, 1
jmp continue12
less4:
mov %ecx, 0
continue12:
#IF STATEMENT
cmp %ecx, 0
je false6
#ASSIGNMENT
mov %esi, -4
add %esi, %ebp
#FUNCTION INVOCATION
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#PUSH THE PARAMS
#SCALAR REF PARAM
mov %edi, 16
add %edi, %ebp
#PARAM PASSED AS PARAM
mov %edi, dword ptr [%edi]
push %edi
#SCALAR REF PARAM
mov %edi, 12
add %edi, %ebp
#PARAM PASSED AS PARAM
mov %edi, dword ptr [%edi]
push %edi
#SCALAR REF PARAM
mov %edi, 8
add %edi, %ebp
#PARAM PASSED AS PARAM
mov %edi, dword ptr [%edi]
push %edi
call partition
add %esp, 12
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF
mov %edi, %eax
mov dword ptr [%esi], %edi

#FUNCTION INVOCATION
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#PUSH THE PARAMS
#SCALAR REF PARAM
mov %esi, -4
add %esi, %ebp
push %esi
#SCALAR REF PARAM
mov %esi, 12
add %esi, %ebp
#PARAM PASSED AS PARAM
mov %esi, dword ptr [%esi]
push %esi
#SCALAR REF PARAM
mov %esi, 8
add %esi, %ebp
#PARAM PASSED AS PARAM
mov %esi, dword ptr [%esi]
push %esi
call quicksort
add %esp, 12
add %esp, 12
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

#FUNCTION INVOCATION
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
#DO THE OTHER STUFF
#PUSH THE PARAMS
#SCALAR REF PARAM
mov %esi, 16
add %esi, %ebp
#PARAM PASSED AS PARAM
mov %esi, dword ptr [%esi]
push %esi
#OTHER PARAM
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
mov %edi, 1
#ADD STATEMENT
add %esi, %edi
#compilerTempNext: -8
mov %edi, -8
add %edi, %ebp
mov dword ptr [%edi], %esi
push %edi
#SCALAR REF PARAM
mov %esi, 8
add %esi, %ebp
#PARAM PASSED AS PARAM
mov %esi, dword ptr [%esi]
push %esi
call quicksort
add %esp, 12
add %esp, 12
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF

jmp continue11
false6:
jmp continue11
continue11:

leave
ret

.comm .__main_ebp,4,4
