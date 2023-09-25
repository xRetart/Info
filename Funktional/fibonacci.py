#! /usr/bin/env python3


def fibonacciRekursiv(n: int) -> int:
    assert n >= 0

    if n < 2:
        return n

    return fibonacciRekursiv(n - 1) + fibonacciRekursiv(n - 2)

def fibonacciIterativ(n: int) -> int:
    a, b = (0, 1)
    for _ in range(0, n):
        x = a + b
        a = b
        b = x
    return a

def fibonacciEinzeiler(n: int) -> int:
    return n if n < 2 else fibonacciRekursiv(n - 1) + fibonacciRekursiv(n - 2)

def fibonacciMemo(n: int) -> int:
    speicher = [0, 1] + [None] * (n - 1)

    def inner(n: int) -> int:
        gespeichert = speicher[n]
        if gespeichert is not None:
            return gespeichert

        ergebnis = inner(n - 1) + inner(n - 2)
        speicher[n] = ergebnis
        return ergebnis

    return inner(n)

def testFibonacci(f) -> None:
    assert f(0) == 0
    assert f(1) == 1
    assert f(2) == 1
    assert f(3) == 2
    assert f(4) == 3
    assert f(5) == 5
    assert f(6) == 8
    assert f(7) == 13
    print(f(40))

if __name__ == '__main__':
    testFibonacci(fibonacciMemo)
