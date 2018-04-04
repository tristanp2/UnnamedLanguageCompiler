.source foo.ir
.class public foo
.super java/lang/Object

.method public static foo(II)I
	.limit locals 11
	.var 0 is x I from L_0 to L_1
	.var 1 is y I from L_0 to L_1
	.var 2 is z F from L_0 to L_1
	.var 3 is p Ljava/lang/String; from L_0 to L_1
	.var 4 is c C from L_0 to L_1
	.var 5 is w [I from L_0 to L_1
	.var 6 is T6  C from L_0 to L_1
	.var 7 is T7  I from L_0 to L_1
	.var 8 is T8  Ljava/lang/String; from L_0 to L_1
	.var 9 is T9  F from L_0 to L_1
	.var 10 is T10  I from L_0 to L_1
	.limit stack 16
L_0:
	ldc 0.0
	fstore 2
	aconst_null 
	astore 3
	ldc 0
	istore 4
	aconst_null 
	astore 5
	ldc 0
	istore 6
	ldc 0
	istore 7
	aconst_null 
	astore 8
	ldc 0.0
	fstore 9
	ldc 0
	istore 10
.line 15
;		T5 := NEWARRAY I 3;
	ldc 3
	newarray int
	astore 5
.line 16
;		T6 := 'A';
	ldc 65
	istore 6
.line 17
;		T4 := T6;
	iload 6
	istore 4
.line 18
;		T7 := 7;
	ldc 7
	istore 7
.line 19
;		T0 := T7;
	iload 7
	istore 0
.line 20
;		T8 := "Hi there";
	ldc "Hi there"
	astore 8
.line 21
;		T3 := T8;
	aload 8
	astore 3
.line 22
;		T9 := 3.732;
	ldc 3.732000
	fstore 9
.line 23
;		T2 := T9;
	fload 9
	fstore 2
.line 24
;		T1 := T0;
	iload 0
	istore 1
.line 25
;		T10 := 8;
	ldc 8
	istore 10
.line 26
;		RETURN T10;
	iload 10
	ireturn
L_1:
.end method

.method public static __main()V
	.limit locals 2
	.var 0 is T0  I from L_2 to L_3
	.var 1 is T1  I from L_2 to L_3
	.limit stack 16
L_2:
	ldc 0
	istore 0
	ldc 0
	istore 1
.line 32
;		T0 := 2;
	ldc 2
	istore 0
.line 33
;		T1 := CALL foo(T0 T0 );
	iload 0
	iload 0
	invokestatic foo/foo(II)I
	istore 1
.line 34
;		RETURN;
	return
L_3:
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
	invokestatic foo/__main()V
	return
.end method

; standard initializer
.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method
