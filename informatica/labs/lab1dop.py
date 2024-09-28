def decimal(x):
    if len(x) == 1:
        return x
    rez = int(x[-1]) + 2 * int(x[-2])
    a, b = 2, 1
    for i in range(len(x) - 3, -1, -1):
        rez += int(x[i]) * (a + b)
        a, b = a + b, a
    return rez


x = input()
print(decimal(x))
