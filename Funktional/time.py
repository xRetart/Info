#! /usr/bin/env python3


from timeit import timeit
from fibonacci import fibonacciRekursiv, fibonacciIterativ, fibonacciMemo


def time(f) -> float:
    return timeit(lambda: f(n), number=1)

min = 1
max = 50
for n in range(min, max):
    iterativ = time(fibonacciIterativ)
    rekursiv = time(fibonacciRekursiv)
    memo = time(fibonacciMemo)

    print(f'{n = }: {iterativ = }s ; {rekursiv = }s ; {memo = }s')
