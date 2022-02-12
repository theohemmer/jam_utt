/*    */ package fr.epiode.jamutt;
/*    */ 
/*    */ import java.awt.Rectangle;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ 
/*    */ public class EventZone
/*    */   implements Entity
/*    */ {
/*    */   private int x;
/*    */   private int y;
/*    */   private int width;
/*    */   private int height;
/*    */   private Player p;
/*    */   private Runnable action;
/*    */   private boolean done = false;
/*    */   
/*    */   public EventZone(int x, int y, int width, int height, Player p, Runnable action) {
/* 19 */     this.x = x;
/* 20 */     this.y = y;
/* 21 */     this.width = width;
/* 22 */     this.height = height;
/* 23 */     this.p = p;
/* 24 */     this.action = action;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getX() {
/* 29 */     return this.x;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getY() {
/* 34 */     return this.y;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setX(int x) {
/* 39 */     this.x = x;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setY(int y) {
/* 44 */     this.y = y;
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {
/* 49 */     if (!this.done) {
/* 50 */       Rectangle r1 = new Rectangle(this.x, this.y, this.width, this.height);
/* 51 */       Rectangle r2 = new Rectangle(this.p.getX(), this.p.getY(), this.p.getWidth(), this.p.getHeight());
/* 52 */       if (r1.intersects(r2)) {
/* 53 */         this.action.run();
/* 54 */         this.done = true;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 61 */     return this.height;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getWidth() {
/* 66 */     return this.width;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMovingX(int dir) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMovingY(int dir) {}
/*    */ 
/*    */   
/*    */   public BufferedImage getImage() {
/* 79 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\EventZone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */