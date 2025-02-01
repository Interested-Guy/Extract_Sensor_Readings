# Extract_Sensor_Readings

A demonstration of the app used to be available on https://roger123.pythonanywhere.com/graph/ . To obtain the demo first install the app on an android phone with a light sensor. Then open the above url. To obtain the graph, open the app. The graph should appear.

## Final Implementation: The previous implementation uses two separate servers, the flask and the websocket, and also involves making calls to weboscket from flask which makes it computationally more expensive. Since the task is to just pass the phone sensor readings from the server to the client for visualization the Server Sent Events can be used. This simply eliminated the websocket server and hence the need for a call to it. 
Final Implementation: First we run a websocket server. Then we run a flask server. We then open the flask app url which gives a page to visualize phone sensor readings through a graph. This page opens a websocket connection with the websocket server. We then run the android application. The app sends the sensor readings to the flask server. The flask server then uses websocket connection to send those readings to the websocket server. The websocket server then sends those readings to the html page. These readings are finally displayed in the graph. All files related to this implementation can be found in the final_implementation folder. An image ...210911.jpg has been included in the repository to observe the results. In order to simulate the android phone, webstest.py can be run. 

Implementation 3: I created a VM on Azure called realtimegraphvm containing a kafka cluster. I connected to the cluster through colab(Refer Kafka_sample.ipynb). I setted up a kafka consumer. Whenver there is a new message in the channel, it is consumed. Here, the message is nothing but the Sensor reading. I set up a flask server in my local computer, exposed it to internet through ngrok and then sent my phone sensor readings to the flask app through post requests. The flask app(flaskapp.py) sends the data to the Kafka cluster. The Kafka Consumer is notified of the data and consumes it. Hence we can plot realtime graph(Kafka_Sample.ipynb).


Implementation 2: I have included the apk(PhoneSensorReading.apk) for an app that uploads the light sensor data from a phone to a web server. To visualize the data, you can run the SensorVisualization.ipynb file. UpdatedMainActivity.java contains the modified source code. I modified my "tango with django project" views.py and urls.py to handle requests containing the phone sensor data. I have also included the java file(Requests.java) that is behind the updated main activity file. My objective was to plot realtime sensor data. Thus I came up with the following implementation: simply upload the data to the web app. App stores data in a text file. The data in the file is retrieved by the Colab file.

Implementation 1: This is an app which sends the light sensor readings of an Android phone to a python application(receive_sensor_readings.py) to visualize the readings in the form of a real time graph. The transmission of readings occurs via a TCP Connection between the Android phone and the computer containing the Python Script. Add the IP address of your computer at the required location in the MainActivity.java file to make this app work. Note that this setup works only when both the sending and receiving devices are on the same network. In case of the devices being in different networks, add the public IP of your network and make sure that the router has a port forwarding rule to route traffic from external networks to the receiving device.

I used a combination of these projects along with the knowledge of socket programming and android studio:

1. https://github.com/google-developer-training/android-advanced/tree/master/SensorListeners

2. https://www.geeksforgeeks.org/how-to-communicate-with-pc-using-android/

3. https://learn.sparkfun.com/tutorials/graph-sensor-data-with-python-and-matplotlib/update-a-graph-in-real-time

## Useful Apps

https://github.com/Foxpace/SensorBox?tab=readme-ov-file

Play Store: sensor toolbox

Morever, ChatGPT can generate simple Android Apps nowadays.

