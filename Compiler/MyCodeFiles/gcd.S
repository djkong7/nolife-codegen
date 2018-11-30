.intel_syntax
.section .rodata
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
sub %esp, 40

#READ STATEMENT
mov %ebx, -4
add %ebx, %ebp
push %ebx
push offset flat:.int_in_format
call scanf
add %esp,8

#READ STATEMENT
mov %ebx, -8
add %ebx, %ebp
push %ebx
push offset flat:.int_in_format
call scanf
add %esp,8

#WHILE STATEMENT
while0:
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
mov %ecx, 0
#NOT EQUAL
cmp %ebx, %ecx
je not0
mov %ebx, 1
jmp continue1
not0:
mov %ebx, 0
continue1:
#SCALAR REF
mov %ecx, -8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
mov %esi, 0
#NOT EQUAL
cmp %ecx, %esi
je not1
mov %ecx, 1
jmp continue2
not1:
mov %ecx, 0
continue2:
#OR
cmp %ebx, 1
je true0
cmp %ecx, 1
je true0
mov %ebx, 0
jmp continue3
true0:
mov %ebx, 1
continue3:
cmp %ebx, 0
je false0
#SAVE THOSE REGISTERS
push %ebx
push %ecx
push %edx
push %esi
push %edi
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
mov %ebx, -8
add %ebx, %ebp
push %ebx
#SCALAR REF PARAM
mov %ebx, -4
add %ebx, %ebp
push %ebx
call gcd
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF
mov %ebx, %eax
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
mov %ebx, -4
add %ebx, %ebp
push %ebx
push offset flat:.int_in_format
call scanf
add %esp,8

#READ STATEMENT
mov %ebx, -8
add %ebx, %ebp
push %ebx
push offset flat:.int_in_format
call scanf
add %esp,8

jmp while0
false0:

leave
ret

.globl gcd;
.type gcd, @function
gcd:
push %ebp
mov %ebp, %esp
sub %esp, 32

#SCALAR REF
mov %ebx, 12
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#PARAMETER REFERENCE
mov %ebx, dword ptr [%ebx]
mov %ecx, 0
#EQUAL
cmp %ebx, %ecx
je equal0
mov %ebx, 0
jmp continue5
equal0:
mov %ebx, 1
continue5:
#IF STATEMENT
cmp %ebx, 0
je false1
#SCALAR REF
mov %ecx, 8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
mov %eax, %ecx
jmp continue4
false1:
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
#SCALAR REF
mov %ecx, 8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#PARAMETER REFERENCE
mov %ecx, dword ptr [%ecx]
#SCALAR REF
mov %esi, 12
add %esi, %ebp
mov %esi, dword ptr [%esi]
#PARAMETER REFERENCE
mov %esi, dword ptr [%esi]
#MOD
mov %eax, %ecx
cdq
idiv %esi
mov %ecx, %edx
#compilerTempNext: -4
mov %esi, -4
add %esi, %ebp
mov dword ptr [%esi], %ecx
push %esi
#SCALAR REF PARAM
mov %ecx, 12
add %ecx, %ebp
#PARAM PASSED AS PARAM
mov %ecx, dword ptr [%ecx]
push %ecx
call gcd
#RESTORE THOSE REGISTERS
pop %edi
pop %esi
pop %edx
pop %ecx
pop %ebx
#DO THE OTHER STUFF
mov %ecx, %eax
mov %eax, %ecx
jmp continue4
continue4:

leave
ret

