#! /usr/bin/env python3


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

