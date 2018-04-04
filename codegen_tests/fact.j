.source fact.ir
.class public fact
.super java/lang/Object

.method public static factorial(I)I
	.limit locals 8
	.var 0 is n I from L_0 to L_1
	.var 1 is returnValue I from L_0 to L_1
	.var 2 is T2  I from L_0 to L_1
	.var 3 is T3  Z from L_0 to L_1
	.var 4 is T4  Z from L_0 to L_1
	.var 5 is T5  I from L_0 to L_1
	.var 6 is T6  I from L_0 to L_1
	.var 7 is T7  I from L_0 to L_1
	.limit stack 16
L_0:
	ldc 0
	istore 1
	ldc 0
	istore 2
	ldc 0
	istore 3
	ldc 0
	istore 4
	ldc 0
	istore 5
	ldc 0
	istore 6
	ldc 0
	istore 7
.line 12
;		T2 := 1;
	ldc 1
	istore 2
.line 13
;		T3 := T0 I== T2;
	iload 0
	iload 2
	isub
	ifeq L_2
	ldc 0
	goto L_3
L_2:
	ldc 1
L_3:
	istore 3
.line 14
;		T4 := Z! T3;
	iload 3
	ldc 1
	ixor
	istore 4
.line 15
;		IF T4 GOTO L0;
	iload 4
	ifne L0
.line 16
;		T1 := T2;
	iload 2
	istore 1
.line 17
;		GOTO L1;
	goto L1
.line 18
;		L0:;
L0:
.line 19
;		T5 := T0 I- T2;
	iload 0
	iload 2
	isub
	istore 5
.line 20
;		T6 := CALL factorial(T5 );
	iload 5
	invokestatic fact/factorial(I)I
	istore 6
.line 21
;		T7 := T0 I* T6;
	iload 0
	iload 6
	imul
	istore 7
.line 22
;		T1 := T7;
	iload 7
	istore 1
.line 23
;		L1:;
L1:
.line 24
;		RETURN T1;
	iload 1
	ireturn
L_1:
.end method

.method public static __main()V
	.limit locals 3
	.var 0 is T0  Ljava/lang/String; from L_8 to L_9
	.var 1 is T1  I from L_8 to L_9
	.var 2 is T2  I from L_8 to L_9
	.limit stack 16
L_8:
	aconst_null 
	astore 0
	ldc 0
	istore 1
	ldc 0
	istore 2
.line 31
;		T0 := "The factorial of 8 is ";
	ldc "The factorial of 8 is "
	astore 0
.line 32
;		PRINTU T0;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 0
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
.line 33
;		T1 := 8;
	ldc 8
	istore 1
.line 34
;		T2 := CALL factorial(T1 );
	iload 1
	invokestatic fact/factorial(I)I
	istore 2
.line 35
;		PRINTLNI T2;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(I)V
.line 36
;		RETURN;
	return
L_9:
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
	invokestatic fact/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
