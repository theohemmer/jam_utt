/*    */ package fr.epiode.jamutt;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ public class Pause
/*    */ {
/*    */   boolean inp = false;
/*    */   boolean esc = false;
/* 10 */   Button b3 = new Button("Play_button.png", 265, 375);
/* 11 */   Button b4 = new Button("Quit_button.png", 265, 725);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void draw(Graphics g) {
/* 18 */     g.drawImage(this.b3.getImage(), this.b3.getX(), this.b3.getY(), null);
/* 19 */     g.drawImage(this.b4.getImage(), this.b4.getX(), this.b4.getY(), null);
/*    */   }
/*    */   
/*    */   public void click(int x, int y) {
/* 23 */     x -= 8;
/* 24 */     y -= 31;
/* 25 */     if (x >= this.b3.getX() && x <= this.b3.getX() + this.b3.getWidth() && y >= this.b3.getY() && y <= this.b3.getY() + this.b3.getHeight()) {
/* 26 */       this.inp = false;
/*    */     }
/* 28 */     if (x >= this.b4.getX() && x <= this.b4.getX() + this.b4.getWidth() && y >= this.b4.getY() && y <= this.b4.getY() + this.b4.getHeight())
/* 29 */       System.exit(0); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Pause.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */