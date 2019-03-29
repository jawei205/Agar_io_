float spielerX;
float spielerY;
float xs = 0;
float ys = 0;
float radius;
int score = 0;
color aColor = color( random(255), random(255), random(255) ); 

Nahrung[] nahrung = new Nahrung[30];

void setup() {

  fullScreen();
  spielerX = width/2;
  spielerY = height/2;
  radius = 50;

  for (int i = 0; i < nahrung.length; i++) {
    nahrung[i]= new Nahrung();
  }
}
void draw() {
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

void keyPressed() {

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