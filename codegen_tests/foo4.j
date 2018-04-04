.source foo4.ir
.class public foo4
.super java/lang/Object

.method public static foo(II)I
	.limit locals 3
	.var 0 is x I from L_0 to L_1
	.var 1 is y I from L_0 to L_1
	.var 2 is T2  I from L_0 to L_1
	.limit stack 16
L_0:
	ldc 0
	istore 2
.line 7
;		T2 := T0 I+ T1;
	iload 0
	iload 1
	iadd
	istore 2
.line 8
;		RETURN T2;
	iload 2
	ireturn
L_1:
.end method

.method public static __main()V
	.limit locals 3
	.var 0 is T0  I from L_4 to L_5
	.var 1 is T1  I from L_4 to L_5
	.var 2 is T2  I from L_4 to L_5
	.limit stack 16
L_4:
	ldc 0
	istore 0
	ldc 0
	istore 1
	ldc 0
	istore 2
.line 15
;		T0 := 2;
	ldc 2
	istore 0
.line 16
;		T1 := 3;
	ldc 3
	istore 1
.line 17
;		T2 := CALL foo(T0 T1 );
	iload 0
	iload 1
	invokestatic foo4/foo(II)I
	istore 2
.line 18
;		PRINTLNI T2;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(I)V
.line 19
;		RETURN;
	return
L_5:
.end method

;--------------------------------------------;
;                                            ;
; Boilerplate                                ;
;                                            ;
;--------------------------------------------;

.method public static main([Ljava/lang/String;)V
	; set limits used by this method
	.limit locals 1
	.limit stack 4
	invokestatic foo4/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
