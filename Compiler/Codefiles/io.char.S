.intel_syntax
.section .rodata
__str0: .string "testcase First completed***************"
.io_format:
.string "%d\12\0"
.text
.globl main;
.type main, @function
main:
push %ebp
mov %ebp, %esp
sub %esp, 64