#! /usr/bin/env python3

from functools import cache

def potenzRekursiv(basis, exponent):
    if exponent == 0:
        return 1
    elif exponent > 0:
        return basis * potenzRekursiv(basis, exponent - 1)
    else:
        return 1 / potenzRekursiv(basis, -exponent)

def potenzIterativ(basis, exponent):
    ergebnis = 1
    for _ in range(0, abs(exponent)):
        ergebnis = ergebnis * basis

    if exponent < 0:
        return 1 / ergebnis
    else:
        return ergebnis

def testPotenz(funktion) -> None:
    assert funktion(2,3) == 8
    assert funktion(2,-3) == (1/8)
    assert funktion(2,0) == 1
    assert funktion(2,4) == 16


testPotenz(potenzIterativ)

@cache
def fibonacci(n: int) -> int:
    assert n >= 0

    if n < 2:
        return n

    return fibonacci(n - 1) + fibonacci(n - 2)

@cache
def fibonacciEinzeiler(n: int) -> int:
    return n if n < 2 else fibonacci(n - 1) + fibonacci(n - 2)

def testFibonacci() -> None:
    assert fibonacciEinzeiler(0) == 0
    assert fibonacciEinzeiler(1) == 1
    assert fibonacciEinzeiler(2) == 1
    assert fibonacciEinzeiler(3) == 2
    assert fibonacciEinzeiler(4) == 3
    assert fibonacciEinzeiler(5) == 5
    assert fibonacciEinzeiler(6) == 8
    assert fibonacciEinzeiler(7) == 13
    print(fibonacciEinzeiler(40))

testFibonacci()
