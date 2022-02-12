package fr.epiode.jamutt;

import java.awt.image.BufferedImage;

public interface Entity {
  int getX();
  
  int getY();
  
  void setX(int paramInt);
  
  void setY(int paramInt);
  
  void update();
  
  int getHeight();
  
  int getWidth();
  
  void setMovingX(int paramInt);
  
  void setMovingY(int paramInt);
  
  BufferedImage getImage();
}


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Entity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */