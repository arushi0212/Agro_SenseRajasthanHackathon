int sound = 5;


void setup() 
{

  pinMode (sound, INPUT);
  Serial.begin(9600);
  
}

void loop()
{
  int beat = digitalRead (sound);
  
  if (beat == 1)
  {
    Serial.println("Sounds Detected !");
    delay(1000);
  }
  
  
}


