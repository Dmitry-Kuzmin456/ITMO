def correct_message(message):
    order = ['r1', 'r2', 'i1', 'r3', 'i2', 'i3', 'i4']
    values = {}
    for i in range(7):
        values[order[i]] = int(message[i])

    s1_used = {'r1', 'i1', 'i2', 'i4'}
    s1 = (values['r1'] + values['i1'] + values['i2'] + values['i4']) % 2
    s2_used = {'r2', 'i1', 'i3', 'i4'}
    s2 = (values['r2'] + values['i1'] + values['i3'] + values['i4']) % 2
    s3_used = {'r3', 'i2', 'i3', 'i4'}
    s3 = (values['r3'] + values['i2'] + values['i3'] + values['i4']) % 2
    error = set(values.keys())

    if s1 == 1:
        error &= s1_used
    else:
        error -= s1_used
    if s2 == 1:
        error &= s2_used
    else:
        error -= s2_used
    if s3 == 1:
        error &= s3_used
    else:
        error -= s3_used

    error = list(error)[0]
    print('error in:', error)
    values[error] = int(values[error] == 0)
    rez = str(values['i1']) + str(values['i2']) + str(values['i3']) + str(values['i4'])
    return rez


message = input()
print('Правильное сообщение:', correct_message(message))
