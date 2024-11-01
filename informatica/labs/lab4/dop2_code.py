import re

file_in = open('timetable.json', 'r')
file_out = open('dop2.yaml', 'w')

is_arr = 0
need_dash = False
k = -1
for line in file_in:
    if line == '':
        continue
    if line.strip() == '{':
        if is_arr:
            need_dash = True
        k += 1
        continue
    if '{' in line:
        k += 1
    if '[' in line:
        is_arr += 1
        line = re.sub(r'\[$', '', line)
    if ']' in line:
        is_arr -= 1
        continue
    if '}' in line:
        k -= 1
        continue
    if ':' in line:
        line = re.sub(r'"', '', line, count=2)
    line = line.strip()
    if line and line[-1] == ',':
        line = line[:-1]
    if need_dash:
        line = ('  ' * (k - 1) + '- ' + line.strip())
        need_dash = False
    elif line and line[-1] == '{':
        line = ('  ' * (k - 1) + line.strip()[:-1])
    else:
        line = ('  ' * k) + line.strip()
    file_out.write(line + '\n')

file_in.close()
file_out.close()
