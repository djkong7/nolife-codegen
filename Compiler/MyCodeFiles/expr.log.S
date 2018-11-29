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
sub %esp, 52

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %esi, 1
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, -8
add %ebx, %ebp
mov %esi, 2
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, -12
add %ebx, %ebp
mov %esi, 3
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, -16
add %ebx, %ebp
mov %esi, 4
mov dword ptr [%ebx], %esi

#ASSIGNMENT
mov %ebx, -20
add %ebx, %ebp
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SCALAR REF
mov %edx, -8
add %edx, %ebp
mov %edx, dword ptr [%edx]
#LESS THAN
cmp %esi, %edx
jge less0
mov %esi, 1
jmp continue0
less0:
mov %esi, 0
continue0:
mov dword ptr [%ebx], %esi

#SCALAR REF
mov %ebx, -20
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

#SCALAR REF
mov %ebx, -16
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %esi, -12
add %esi, %ebp
mov %esi, dword ptr [%esi]
#GREATER THAN
cmp %ebx, %esi
jg greater0
mov %ebx, 0
jmp continue1
greater0:
mov %ebx, 1
continue1:
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

#SCALAR REF
mov %ebx, -16
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %esi, -12
add %esi, %ebp
mov %esi, dword ptr [%esi]
#GREATER THAN
cmp %ebx, %esi
jg greater1
mov %ebx, 0
jmp continue2
greater1:
mov %ebx, 1
continue2:
#NOT
cmp %ebx, 0
je false0
mov %ebx, 0
jmp continue3
false0:
mov %ebx, 1
continue3:
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

mov %ebx, 0
#SCALAR REF
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
#SCALAR REF
mov %edx, -8
add %edx, %ebp
mov %edx, dword ptr [%edx]
#LESS THAN
cmp %esi, %edx
jge less1
mov %esi, 1
jmp continue4
less1:
mov %esi, 0
continue4:
#SCALAR REF
mov %edx, -12
add %edx, %ebp
mov %edx, dword ptr [%edx]
#SCALAR REF
mov %ecx, -16
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#NOT EQUAL
cmp %edx, %ecx
je not0
mov %edx, 1
jmp continue5
not0:
mov %edx, 0
continue5:
#AND
cmp %esi, %edx
je true0
mov %esi, 0
jmp continue6
true0:
mov %esi, 1
continue6:
#OR
cmp %ebx, 1
je true1
cmp %esi, 1
je true1
mov %ebx, 0
jmp continue7
true1:
mov %ebx, 1
continue7:
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

leave
ret

