def correct_message(message):
    rez = {
        '000': 'correct',
        '001': 'r3',
        '010': 'r2',
        '100': 'r1',
        '110': 'i1',
        '011': 'i3',
        '101': 'i2',
        '111': 'i4'
    }
    s1 = (int(message[0]) + int(message[2]) + int(message[4]) + int(message[6])) % 2
    s2 = (int(message[1]) + int(message[2]) + int(message[5]) + int(message[6])) % 2
    s3 = (int(message[3]) + int(message[4]) + int(message[5]) + int(message[6])) % 2
    s = str(s1) + str(s2) + str(s3)
    print(rez[s])
    f.write(rez[s])


f = open('result.txt', 'r+')
message = input('Введите сообщение, состоящее из 7 цифр 0 или 1: ')
while (len(message) != 7) or (message[0] not in '01') or (message[1] not in '01') or (message[2] not in '01') or\
(message[3] not in '01') or (message[4] not in '01') or (message[5] not in '01') or\
(message[6] not in '01'):
    print('error')
    message = input('Введите сообщение, состоящее из 7 цифр 0 или 1: ')
correct_message(message)
f.close()
