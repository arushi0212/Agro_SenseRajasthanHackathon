#include <SoftwareSerial.h>
#include <dht.h>
#define dataPin 8 // Defines pin number to which the sensor is connected
dht DHT; // Creats a DHT object

int sensor_pin = A0;//Soil Moisture
int output_value ;//Soil Moisture
const int read = A5 ; //Water Level Sensor AO pin to Arduino pin A0
int value;          //Water Level Variable to store the incomming data
int sound = 5;//Sound Sensor
/*SoftwareSerial mySerial(9, 10);
char msg;
char call;*/

void setup()
{
  Serial.begin(9600);
  Serial.println("Reading From the Sensors ...");//SoilMoisture
  delay(2000);    
  pinMode (sound, INPUT);
  
  /*mySerial.begin(9600);   // Setting the baud rate of GSM Module  
  Serial.begin(9600);    // Setting the baud rate of Serial Monitor (Arduino)
  Serial.println("GSM SIM900A BEGIN");
  Serial.println("Enter character for control option:");
  Serial.println("h : to disconnect a call");
  Serial.println("i : to receive a call");
  Serial.println("s : to send message");
  Serial.println("c : to make a call");  
  Serial.println("e : to redial");
  Serial.println();
  delay(100);*/
}

void loop()
{
  int readData = DHT.read22(dataPin); // Reads the data from the sensor
  float t = DHT.temperature; // Gets the values of the temperature
  float h = DHT.humidity; // Gets the values of the humidity
  
  // Printing the results on the serial monitor
  Serial.print("Temperature = ");
  Serial.print(t);
  Serial.print(" *C ");
  Serial.print("    Humidity = ");
  Serial.print(h);
  Serial.println(" % ");
  delay(2000); // Delays 2 secods, as the DHT22 sampling rate is 0.5Hz

  //SoilMoisture
  output_value= analogRead(sensor_pin);
  output_value = map(output_value,550,0,0,100);
  Serial.print("Mositure :");
  Serial.print(output_value);
  Serial.println("%");
  delay(5000); 

  int beat = digitalRead (sound);
  
  if (beat == 1)
  {
    Serial.println("Sounds Detected");
  }
  
//Water Level
  value = analogRead(read); //Read data from analog pin and store it to value variable
  
  if (value<=480){ 
    Serial.println("Water level: 0mm - Empty!"); 
  }
  else if (value>480 && value<=530){ 
    Serial.println("Water level: 0mm to 5mm"); 
  }
  else if (value>530 && value<=615){ 
    Serial.println("Water level: 5mm to 10mm"); 
  }
  else if (value>615 && value<=660){ 
    Serial.println("Water level: 10mm to 15mm"); 
  } 
  else if (value>660 && value<=680){ 
    Serial.println("Water level: 15mm to 20mm"); 
  }
  else if (value>680 && value<=690){ 
    Serial.println("Water level: 20mm to 25mm"); 
  }
  else if (value>690 && value<=700){ 
    Serial.println("Water level: 25mm to 30mm"); 
  }
  else if (value>700 && value<=705){ 
    Serial.println("Water level: 30mm to 35mm"); 
  }
  else if (value>705){ 
    Serial.println("Water level: 35mm to 40mm"); 
  }
  
  delay(5000); // Check for new value every 5 sec

  

  /*GSM
   if (Serial.available()>0)
   switch(Serial.read())
  {
    case 's':
      SendMessage();
      break;
    case 'c':
      MakeCall();
      break;
    case 'h':
      HangupCall();
      break;
    case 'e':
      RedialCall();
      break;
    case 'i':
      ReceiveCall();
      break;
  }
 if (mySerial.available()>0)
 Serial.write(mySerial.read());*/
}

/*void SendMessage()
{
  mySerial.println("AT+CMGF=1");    //Sets the GSM Module in Text Mode
  delay(1000);  // Delay of 1000 milli seconds or 1 second
  mySerial.println("AT+CMGS=\"+918130572816\"\r"); // Replace x with mobile number
  delay(1000);
  mySerial.println("sim900a sms");// The SMS text you want to send
  delay(100);
   mySerial.println((char)26);// ASCII code of CTRL+Z
  delay(1000);
}

void ReceiveMessage()
{
  mySerial.println("AT+CNMI=2,2,0,0,0"); // AT Command to recieve a live SMS
  delay(1000);
  if (mySerial.available()>0)
  {
    msg=mySerial.read();
    Serial.print(msg);
  }
}

void MakeCall()
{
  mySerial.println("ATD+918130572816;"); // ATDxxxxxxxxxx; -- watch out here for semicolon at the end!!
  Serial.println("Calling  "); // print response over serial port
  delay(1000);
}


void HangupCall()
{
  mySerial.println("ATH");
  Serial.println("Hangup Call");
  delay(1000);
}

void ReceiveCall()
{
  mySerial.println("ATA");
  delay(1000);
  {
    call=mySerial.read();
    Serial.print(call);
  }
}

void RedialCall()
{
  mySerial.println("ATDL");
  Serial.println("Redialing");
  delay(1000);
}*/
