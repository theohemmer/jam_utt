/*    */ package fr.epiode.jamutt;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Twitter
/*    */ {
/* 13 */   Tl tl = new Tl("tl.png", 0, 50);
/* 14 */   Tl overlay_tl = new Tl("Overlay_tl.png", 0, 0);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void draw(Graphics g) {
/* 21 */     g.drawImage(this.tl.getImage(), this.tl.getX(), this.tl.getY(), null);
/* 22 */     g.drawImage(this.overlay_tl.getImage(), this.overlay_tl.getX(), this.overlay_tl.getY(), null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Twitter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */