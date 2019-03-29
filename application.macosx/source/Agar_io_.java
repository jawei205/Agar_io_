import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Agar_io_ extends PApplet {

float spielerX;
float spielerY;
float xs = 0;
float ys = 0;
float radius;
int score = 0;
int aColor = color( random(255),random(255),random(255) ); 


Nahrung[] nahrung = new Nahrung[30];

public void setup() {
  
  
  spielerX = width/2;
  spielerY = height/2;
  radius = 50;
  
  for (int i = 0; i < nahrung.length; i++) {
    nahrung[i]= new Nahrung();
  }
}
public void draw() {
  background(51);
  noStroke();
  ellipse(spielerX, spielerY, radius, radius);

  for (int i  =0; i < nahrung.length; i++) {
    nahrung[i].show();
    ellipse(spielerX, spielerY, 30, 30); 


    if (dist(spielerX, spielerY, nahrung[i].eatX, nahrung[i].eatY) <50) {
      radius+=10;
      score++;
      nahrung[i]= new Nahrung();
    }
  }
  

  spielerX=spielerX+xs;
  spielerY=spielerY+ys;





  if (radius>200) {
    radius = 50;
    spielerX = width/2;
    spielerY = height/2;
    score=0;
    
    
  }
  
  textSize(32);
  text("Score:" + score, 35, 40);
}

public void keyPressed() {

  if (keyCode==UP) {
    ys -= 3;
  }
  if (keyCode==DOWN) {
    ys += 3;
  }
  if (keyCode==RIGHT) {
    xs += 3;
  }
  if (keyCode==LEFT) {
    xs -= 3;
  }
}
class Nahrung {
  float eatX;
  float eatY;

  Nahrung() {
    eatX = random(width);
    eatY = random(height);
  }
  public void show(){
   colorMode(HSB);
   fill(aColor);
    ellipse(eatX,eatY,20,20);    
  }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Agar_io_" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
