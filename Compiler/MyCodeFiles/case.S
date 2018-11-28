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
mov %esi, -4
add %esi, %ebp
push %esi
push offset flat:.int_in_format
call scanf
add %esp,8

#CASE STATEMENT
mov %esi, -4
add %esi, %ebp
mov %esi, dword ptr [%esi]
case0:
mov %ecx, 1
cmp %esi, %ecx
je case0code
mov %ecx, 2
cmp %esi, %ecx
je case0code
jmp case1
case0code:
mov %ecx, 0
#WRITE STATEMENT
push %ecx
push offset flat:.int_format
call printf
add %esp,8
jmp case3
case1:
mov %ecx, 3
cmp %esi, %ecx
je case1code
mov %ecx, 4
cmp %esi, %ecx
je case1code
jmp case2
case1code:
mov %ecx, 1
#WRITE STATEMENT
push %ecx
push offset flat:.int_format
call printf
add %esp,8
jmp case3
case2:
mov %ecx, 5
cmp %esi, %ecx
je case2code
jmp case3
case2code:
mov %ecx, 2
#WRITE STATEMENT
push %ecx
push offset flat:.int_format
call printf
add %esp,8
jmp case3
case3:

leave
ret

