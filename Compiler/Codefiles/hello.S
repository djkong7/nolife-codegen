.intel_syntax
.section .rodata
.__str0: .string "Hello world!"
.int_format:
	.string "%d\12\0"
.str_format:
	.string "%s\12\0"
.flt_format:
	.string "%f\12\0"
.text
.globl main;
.type main, @function
main:
push %ebp
mov %ebp, %esp
sub %esp, 64

push offset flat:.__str0
push offset flat:.str_format
call printf
add %esp,8
leave
ret
