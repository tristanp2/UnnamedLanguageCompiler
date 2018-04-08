.source ar.ir
.class public ar
.super java/lang/Object

.method public static __main()V
	.limit locals 5
	.var 0 is x [Ljava/lang/String; from L_0 to L_1
	.var 1 is T1  I from L_0 to L_1
	.var 2 is T2  Ljava/lang/String; from L_0 to L_1
	.var 3 is T3  I from L_0 to L_1
	.var 4 is T4  Ljava/lang/String; from L_0 to L_1
	.limit stack 16
L_0:
	aconst_null 
	astore 0
	ldc 0
	istore 1
	aconst_null 
	astore 2
	ldc 0
	istore 3
	aconst_null 
	astore 4
.line 9
;		T0 := NEWARRAY U 3;
	ldc 3
	anewarray java/lang/String
	astore 0
.line 10
;		T1 := 0;
	ldc 0
	istore 1
.line 11
;		T2 := "hello";
	ldc "hello"
	astore 2
.line 12
;		T0[T1] := T2;
	aload 0
	iload 1
	aload 2
	aastore
.line 13
;		T3 := 0;
	ldc 0
	istore 3
.line 14
;		T4 := T0[T3];
	aload 0
	iload 3
	aaload
	astore 4
.line 15
;		PRINTLNU T4;
	getstatic java/lang/System/out Ljava/io/PrintStream;
	aload 4
	invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
.line 16
;		RETURN;
	return
L_1:
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
	invokestatic ar/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
