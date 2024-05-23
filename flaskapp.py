from flask import *
from flask_cors import CORS
from kafka import KafkaProducer
my_producer = KafkaProducer(
    bootstrap_servers = ['20.232.178.123:9092'],
    value_serializer = lambda x:x.encode('utf-8')
    )
app = Flask(__name__)
CORS(app)

@app.route('/dummy', methods=['POST'])
def dummy():
    my_producer.send('sensor', value=str(request.data))
    my_producer.flush()
    return make_response("Data inserted!")
