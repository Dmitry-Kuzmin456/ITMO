import json
import yaml

file_in = open('timetable.json', 'r')
file_out = open('dop1.yaml', 'w')
json_data = file_in.read()

data = json.loads(json_data)

yaml_data = yaml.dump(data, allow_unicode=True, default_flow_style=False)
file_out.write(yaml_data)
file_in.close()
file_out.close()
