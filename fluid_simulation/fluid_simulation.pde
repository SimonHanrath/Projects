final int N = 256;
final int iter = 16;
final int SCALE = 3;
final float[] smoke_color = {0,255,255};
float t = 0;
String colString = "use arrows to switch color";

Fluid fluid;

void settings() {
  size(N*SCALE, N*SCALE);
}

void setup() {
  fluid = new Fluid(0.07, 0, 0);
}

void mouseDragged() {
  fluid.addDensity(mouseX/SCALE, mouseY/SCALE, 500);
  float amtX = mouseX - pmouseX;
  float amtY = mouseY - pmouseY;
  
  fluid.addVelocity(mouseX/SCALE, mouseY/SCALE, amtX, amtY);
  
}

void draw() {
  background(0);
  fluid.step();
  
  fluid.renderD();
  //fluid.renderV();
  fluid.fadeD();
  
}
