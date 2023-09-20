def eingabeZahl(prompt: str) -> int:
    try:
        return int(input(prompt))
    except ValueError:
        print('Das ist keine Zahl.')
        return eingabeZahl(prompt)

operation = input('Welche Rechenoperation (plus/minus/mal/geteilt): ').lower()
x = eingabeZahl('Erste Zahl: ')
y = eingabeZahl('Zweite Zahl: ')

if operation == 'plus':
    print(x + y)
elif operation == 'minus':
    print(x - y)
elif operation == 'mal':
    print(x * y)
elif operation == 'geteilt':
    print(x / y)
else:
    print('Das ist keine Rechenoperation.')
