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
sub %esp, 8

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %esi, 1
mov dword ptr [%ebx], %esi

#WHILE STATEMENT
while0:
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
mov %esi, 10
#LESS EQUAL THAN
cmp %ebx, %esi
jg less0
mov %ebx, 1
jmp continue1
less0:
mov %ebx, 0
continue1:
cmp %ebx, 0
je false0
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %esi, 1
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

jmp while0
false0:
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

#ASSIGNMENT
mov %ebx, -8
add %ebx, %ebp
mov %esi, 1
mov dword ptr [%ebx], %esi

#WHILE STATEMENT
while1:
#SCALAR REF
mov %ebx, -8
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
mov %esi, 10
#LESS EQUAL THAN
cmp %ebx, %esi
jg less1
mov %ebx, 1
jmp continue3
less1:
mov %ebx, 0
continue3:
cmp %ebx, 0
je false1
#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %esi, 1
mov dword ptr [%ebx], %esi

#WHILE STATEMENT
while2:
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
mov %esi, 10
#LESS EQUAL THAN
cmp %ebx, %esi
jg less2
mov %ebx, 1
jmp continue5
less2:
mov %ebx, 0
continue5:
cmp %ebx, 0
je false2
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
#SCALAR REF
mov %esi, -8
add %esi, %ebp
mov %esi, dword ptr [%esi]
imul %ebx, %esi
#WRITE STATEMENT
push %ebx
push offset flat:.int_format
call printf
add %esp,8

#ASSIGNMENT
mov %ebx, -4
add %ebx, %ebp
mov %esi, 1
#SCALAR REF
mov %ecx, -4
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

jmp while2
false2:
#ASSIGNMENT
mov %ebx, -8
add %ebx, %ebp
mov %esi, 1
#SCALAR REF
mov %ecx, -8
add %ecx, %ebp
mov %ecx, dword ptr [%ecx]
#ADD STATEMENT
add %ecx, %esi
mov dword ptr [%ebx], %ecx

jmp while1
false1:
leave
ret

