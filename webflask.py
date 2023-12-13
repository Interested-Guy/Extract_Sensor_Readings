#!/usr/bin/env python

import datetime
from flask_cors import CORS
import flask
from flask import *
app=Flask(__name__)
CORS(app)
buffer=[]
time=[]

@app.route('/dummy',methods=['POST'])
def get():
    x=request.values.get('Light_Sensor_Reading')
    #x=request.data.decode().split(':')[1]
    global buffer,time
    buffer.append(x)
    time.append(datetime.datetime.now())
    return make_response("sent")

@app.route('/sse',methods=['GET'])
def server_sent_event():
    def find_value():
        global buffer,time
        while (True):
            if (len(buffer) > 0):
                data={"Light_Sensor_Reading": buffer.pop(0), "Timestamp": time.pop(0)}
                yield f'data: {json.dumps(data)}\n\n'
    return flask.Response(find_value(),mimetype="text/event-stream")

if __name__ == "__main__":
    app.run()
