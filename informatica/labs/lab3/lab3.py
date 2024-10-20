import re

# Задание 1, смайлик составлен из номеров 4, 2, 2
# smile =-}P
s1 = 'we4+=-}P' # ответ - 1
s2 = 'we4+=-}9P' # ответ - 0
s3 = '=-}P-}P' # ответ - 1
s4 = '=-}Pqwerr=-}P=-}P' # ответ - 3
s5 = '=-}P==-}P=-}Р' # ответ - 3
pattern1 = r'=-}[P,Р]'

print('Задание 1:')
print(len(re.findall(pattern1, s1))) # ответ - 1
print(len(re.findall(pattern1, s2))) # ответ - 0
print(len(re.findall(pattern1, s3))) # ответ - 1
print(len(re.findall(pattern1, s4))) # ответ - 3
print(len(re.findall(pattern1, s5))) # ответ - 3
print()

# Задание 2, вариант 4
print('Задание 2:')
pattern2 = r'([01][0-9]|2[0-3]):[0-5][0-9](:[0-5][0-9])?'
s1 = 'Вот это заменится - 13:24:34, а это нет - 24:12:23'
s2 = 'Вот это заменится - 13:24:34, а это частично - 24:12:23'
s3 = 'Рейс будет перенесен на 2 часа, а именно на 12:30'
s4 = '00:00:00'
s5 = '13:61:45'

s1 = re.sub(pattern2, '(TBD)', s1)
print(s1)
print(re.sub(pattern2, '(TBD)', s2))
print(re.sub(pattern2, '(TBD)', s3))
print(re.sub(pattern2, '(TBD)', s4))
print(re.sub(pattern2, '(TBD)', s5))
print()

#Задание 3, вариант 2
print('Задание 3:')

s1 = 'Цена Bitcoin в реальном времени сегодня составляет ₽5,797,806.88 RUB.Ethereum стоит на данный момент \₽229,590,78 RUB.'
s2 = '₽6,222.45 RUB стоит сейчас Bitcoin. Общие торги с использованием Bitcoin на сегодня ₽3,698,222.45 RUB'
s3 = 'Bitcoin стоит ₽86,222 RUB'
s4 = '₽86,222.67 RUB стоит Bitcoin'
s4 = '₽86,222.67 стоит Bitcoin'

pattern3 = r'Bitcoin.*?₽(\d+(?:,\d+)*(?:.\d+)?)\sRUB'
pattern4 = r'₽(\d+(?:,\d+)*(?:.\d+)?)\sRUB.*?Bitcoin'

summs = []
for match in re.findall(pattern3, s2):
    summs.append([float(match[1:].replace(',', '')), match])
for match in re.findall(pattern4, s2):
    summs.append([float(match[1:].replace(',', '')), match])

if len(summs) > 0:
    print(sorted(summs)[0][1])
else:
    print('No matches')
