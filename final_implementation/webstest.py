import requests
import time
import random

for i in range(1000):
    parameters = {'Light_Sensor_Reading': random.randint(0, 1000)}
    requests.post('http://localhost:5000/dummy',data=parameters)
    time.sleep(1)