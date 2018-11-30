.intel_syntax
.section .rodata
.__str0: .string "Hello world!"
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
sub %esp, 33

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

leave
ret

