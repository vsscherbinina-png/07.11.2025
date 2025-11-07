def combinations_correct(l, k):
    if k == 0:
        return [[]]  # Правильный базовый случай
    if k > len(l):
        return []    # Невозможно создать сочетание
    
    comb = []
    for i, item in enumerate(l):
        rem_items = l[i+1:]  # Элементы после текущего
        rem_comb = combinations_correct(rem_items, k-1)
        for c in rem_comb:
            comb.append((item,) + tuple(c) if c else (item,))
    return comb

# Тест
n = 4
k = 2
result = combinations_correct(list(range(1, n+1)), k)
print(result)  # [(1, 2), (1, 3), (1, 4), (2, 3), (2, 4), (3, 4)]
