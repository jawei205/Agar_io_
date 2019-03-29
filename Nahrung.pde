class Nahrung {
  float eatX;
  float eatY;

  Nahrung() {
    eatX = random(width);
    eatY = random(height);
  }
  void show(){
   colorMode(HSB);
   fill(aColor);
    ellipse(eatX,eatY,20,20);    
  }
}