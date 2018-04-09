.source towersOfHanoi.ir
.class public towersOfHanoi
.super java/lang/Object

.method public static towersOfHanoi(ICCC)V
	.limit locals 16
	.var 0 is n I from L_0 to L_1
	.var 1 is fromRod C from L_0 to L_1
	.var 2 is toRod C from L_0 to L_1
	.var 3 is auxRod C from L_0 to L_1
	.var 4 is T4  I from L_0 to L_1
	.var 5 is T5  Z from L_0 to L_1
	.var 6 is T6  Z from L_0 to L_1
	.var 7 is T7  Ljava/lang/String; from L_0 to L_1
	.var 8 is T8  Ljava/lang/String; from L_0 to L_1
	.var 9 is T9  I from L_0 to L_1
	.var 10 is T10  I from L_0 to L_1
	.var 11 is T11  Ljava/lang/String; from L_0 to L_1
	.var 12 is T12  Ljava/lang/String; from L_0 to L_1
	.var 13 is T13  Ljava/lang/String; from L_0 to L_1
	.var 14 is T14  I from L_0 to L_1
	.var 15 is T15  I from L_0 to L_1
	.limit stack 16
L_0:
	ldc 0
	istore 4
	ldc 0
	istore 5
	ldc 0
	istore 6
	aconst_null 
	astore 7
	aconst_null 
	astore 8
	ldc 0
	istore 9
	ldc 0
	istore 10
	aconst_null 
	astore 11
	aconst_null 
	astore 12
	aconst_null 
	astore 13
	ldc 0
	istore 14
	ldc 0
	istore 15
.line 20
;		T4 := 1;
	ldc 1
	istore 4
.line 21
;		T5 := T0 I== T4;
	iload 0
	iload 4
	isub
	ifeq L_2
	ldc 0
	goto L_3
L_2:
	ldc 1
L_3:
	istore 5
.line 22
;		T6 := Z! T5;
	iload 5
	ldc 1
	ixor
	istore 6
.line 23
;		IF T6 GOTO L0;
	iload 6
	ifne L0
.line 24
;		T7 := "Move disk 1 from rod ";
	ldc "Move disk 1 from rod "
	astore 7
.line 25
;		PRINTU T7;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 7
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
.line 26
;		PRINTC T1;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/print(C)V
.line 27
;		T8 := " to rod ";
	ldc " to rod "
	astore 8
.line 28
;		PRINTU T8;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 8
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
.line 29
;		PRINTLNC T2;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(C)V
.line 30
;		GOTO L1;
	goto L1
.line 31
;		L0:;
L0:
.line 32
;		T9 := 1;
	ldc 1
	istore 9
.line 33
;		T10 := T0 I- T9;
	iload 0
	iload 9
	isub
	istore 10
.line 34
;		CALL towersOfHanoi(T10 T1 T3 T2 );
	iload 10
	iload 1
	iload 3
	iload 2
	invokestatic towersOfHanoi/towersOfHanoi(ICCC)V
.line 35
;		T11 := "Move disk ";
	ldc "Move disk "
	astore 11
.line 36
;		PRINTU T11;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 11
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
.line 37
;		PRINTI T0;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream/print(I)V
.line 38
;		T12 := " from rod ";
	ldc " from rod "
	astore 12
.line 39
;		PRINTU T12;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 12
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
.line 40
;		PRINTC T1;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/print(C)V
.line 41
;		T13 := " to rod ";
	ldc " to rod "
	astore 13
.line 42
;		PRINTU T13;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 13
	invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
.line 43
;		PRINTLNC T2;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/println(C)V
.line 44
;		T14 := 1;
	ldc 1
	istore 14
.line 45
;		T15 := T0 I- T14;
	iload 0
	iload 14
	isub
	istore 15
.line 46
;		CALL towersOfHanoi(T15 T3 T2 T1 );
	iload 15
	iload 3
	iload 2
	iload 1
	invokestatic towersOfHanoi/towersOfHanoi(ICCC)V
.line 47
;		L1:;
L1:
.line 48
;		RETURN;
	return
L_1:
.end method

.method public static __main()V
	.limit locals 5
	.var 0 is n I from L_8 to L_9
	.var 1 is T1  I from L_8 to L_9
	.var 2 is T2  C from L_8 to L_9
	.var 3 is T3  C from L_8 to L_9
	.var 4 is T4  C from L_8 to L_9
	.limit stack 16
L_8:
	ldc 0
	istore 0
	ldc 0
	istore 1
	ldc 0
	istore 2
	ldc 0
	istore 3
	ldc 0
	istore 4
.line 57
;		T1 := 4;
	ldc 4
	istore 1
.line 58
;		T0 := T1;
	iload 1
	istore 0
.line 59
;		T2 := 'A';
	ldc 65
	istore 2
.line 60
;		T3 := 'B';
	ldc 66
	istore 3
.line 61
;		T4 := 'C';
	ldc 67
	istore 4
.line 62
;		CALL towersOfHanoi(T0 T2 T3 T4 );
	iload 0
	iload 2
	iload 3
	iload 4
	invokestatic towersOfHanoi/towersOfHanoi(ICCC)V
.line 63
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
	invokestatic towersOfHanoi/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
