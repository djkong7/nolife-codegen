.intel_syntax
.section .rodata
.__str0: .string "Enter: "
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
sub %esp, 4

push offset flat:.__str0
#WRITE STATEMENT
push offset flat:.str_format
call printf
add %esp,8

#READ STATEMENT
mov %ebx, -4
add %ebx, %ebp
push %ebx
push offset flat:.int_in_format
call scanf
add %esp,8

#CASE STATEMENT
#SCALAR REF
mov %ebx, -4
add %ebx, %ebp
mov %ebx, dword ptr [%ebx]
case0:
mov %esi, 1
cmp %ebx, %esi
je case0code
mov %esi, 2
cmp %ebx, %esi
je case0code
jmp case1
case0code:
mov %esi, 0
#WRITE STATEMENT
push %esi
push offset flat:.int_format
call printf
add %esp,8
jmp case3
case1:
mov %esi, 3
cmp %ebx, %esi
je case1code
mov %esi, 4
cmp %ebx, %esi
je case1code
jmp case2
case1code:
mov %esi, 1
#WRITE STATEMENT
push %esi
push offset flat:.int_format
call printf
add %esp,8
jmp case3
case2:
mov %esi, 5
cmp %ebx, %esi
je case2code
jmp case3
case2code:
mov %esi, 2
#WRITE STATEMENT
push %esi
push offset flat:.int_format
call printf
add %esp,8
jmp case3
case3:

leave
ret

