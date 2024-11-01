import time
t = time.time()
for i in range(100):
    file_in = open('timetable.json', 'r')
    file_out = open('main_task.yaml', 'w')

    is_arr = 0
    need_dash = False
    k = -1
    for line in file_in:
        line = line.strip()
        if line == '':
            continue
        if line == '{':
            if is_arr:
                need_dash = True
            k += 1
            continue
        if '{' in line:
            k += 1
        if '[' in line:
            is_arr += 1
            line = line.replace('[', '')
        if ']' in line:
            is_arr -= 1
            line = line.replace(']', '')
        if '}' in line:
            k -= 1
            line = ''
        if ':' in line:
            line = line.replace('"', '', 2)
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
print(time.time() - t)
