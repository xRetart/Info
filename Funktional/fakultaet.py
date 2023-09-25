#! /usr/bin/env python3

def fakultaetRekursiv(n: int) -> int:
    if n == 0:
        return 1
    if n <= 2:
        return n
    return fakultaetRekursiv(n - 1) * n

def fakultaetIterativ(n: int) -> int:
    result = 1
    for i in range(1, n + 1):
        result *= i
    return result

def testFakultaet(f):
    assert f(0) == 1
    assert f(1) == 1
    assert f(2) == 2
    assert f(3) == 6
    assert f(4) == 24
    assert f(5) == 120
    assert f(6) == 720

testFakultaet(fakultaetIterativ)
print(fakultaetRekursiv(200))
print(fakultaetIterativ(200))
