.source if.ir
.class public if
.super java/lang/Object

.method public static less(II)V
    .limit locals 5
    .var 0 is x I from L_0 to L_1
    .var 1 is y I from L_0 to L_1
    .var 2 is T2 Z from L_0 to L_1
    .var 3 is T3 Z from L_0 to L_1
    .var 4 is T4 Ljava/lang/String; from L_0 to L_1
    .limit stack 20
L_0:
    ldc 0
    istore 2
    ldc 0
    istore 3
    aconst_null
    astore 4
;         T2 := T0 I< T1;
    iload 0
    iload 1
    isub
    iflt L_2
    ldc 0
    goto L_3
L_2:
    ldc 1
L_3:
    istore 2
;         T3 := Z! T2;
    iload 2
    ldc 1
    ixor
    istore 3
;         IF T3 GOTO L0;
    iload 3
    ifne L0
;         PRINTI T0;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 0
    invokevirtual java/io/PrintStream/print(I)V
;         T4 := " is less than ";
    ldc " is less than "
    astore 4
;         PRINTU T4;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 4
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;         L0:;
L0:
;         PRINTLNI T1;
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/println(I)V
;         RETURN;
    return
L_1:
.end method
.method public static __main()V
    .limit locals 2
    .var 0 is T0 I from L_4 to L_5
    .var 1 is T1 I from L_4 to L_5
    .limit stack 8
L_4:
    ldc 0
    istore 0
    ldc 0
    istore 1
;         T0 := 2;
    ldc 2
    istore 0
;         T1 := 3;
    ldc 3
    istore 1
;         CALL less(T0 T1 );
    iload 0
    iload 1
    invokestatic if/less(II)V
;         RETURN;
    return
L_5:
.end method

;---------------------------;
;  Boiler's plates          ;
;---------------------------;

.method public static main([Ljava/lang/String;)V

    .limit locals 1
    .limit stack 4
    invokestatic if/__main()V
    return
.end method

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method
