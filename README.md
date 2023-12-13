# Extract_Sensor_Readings

YouTube Video link: https://youtube.com/shorts/Ft0gfIN4DVk?feature=share

Project: An Android app transmits light sensor values to a flask server. A client opens a browser and opens a page rendered by the flask server where the sensor values are displayed in the form of a graph. Initially before the transmission of the values, the client opens a server sent event connection that opens a channel with the server to recieve the values from the server. As and when values are transmitted from the phone, the server sends the values to the client and the graph updates itself. Hence a true event based realtime graph is obtained unlike a pseudo realtime graph that polls the server for values at periodic intervals.



