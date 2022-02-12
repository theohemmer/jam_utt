/*    */ package fr.epiode.jamutt;
/*    */ 
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.image.BufferedImage;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ 
/*    */ public class Button
/*    */ {
/*    */   private int x;
/*    */   private int y;
/*    */   private int height;
/*    */   private int width;
/*    */   private BufferedImage img;
/*    */   
/*    */   public Button(String button_name, int x, int y, float fact) {
/* 17 */     this.x = x;
/* 18 */     this.y = y;
/*    */     try {
/* 20 */       this.img = ImageIO.read(Main.class.getResourceAsStream(button_name));
/* 21 */       BufferedImage scaled = new BufferedImage((int)(this.img.getWidth() / fact), (int)(this.img.getHeight() / fact), this.img.getType());
/* 22 */       Graphics2D g2d = scaled.createGraphics();
/* 23 */       g2d.drawImage(this.img, 0, 0, scaled.getWidth(), scaled.getHeight(), null);
/* 24 */       g2d.dispose();
/* 25 */       this.img = scaled;
/* 26 */     } catch (Exception e) {
/* 27 */       System.err.println("Cannot open image " + button_name + " see error below.");
/* 28 */       e.printStackTrace();
/*    */     } 
/* 30 */     this.width = this.img.getWidth();
/* 31 */     this.height = this.img.getHeight();
/*    */   }
/*    */ 
/*    */   
/*    */   public Button(String button_name, int x, int y) {
/* 36 */     this.x = x;
/* 37 */     this.y = y;
/*    */     try {
/* 39 */       this.img = ImageIO.read(Main.class.getResourceAsStream(button_name));
/* 40 */     } catch (Exception e) {
/* 41 */       System.err.println("Cannot open image " + button_name + " see error below.");
/* 42 */       e.printStackTrace();
/*    */     } 
/* 44 */     this.width = this.img.getWidth();
/* 45 */     this.height = this.img.getHeight();
/*    */   }
/*    */   
/*    */   public BufferedImage getImage() {
/* 49 */     return this.img;
/*    */   }
/*    */   
/*    */   public int getX() {
/* 53 */     return this.x;
/*    */   }
/*    */   
/*    */   public int getY() {
/* 57 */     return this.y;
/*    */   }
/*    */   
/*    */   public int getWidth() {
/* 61 */     return this.width;
/*    */   }
/*    */   
/*    */   public int getHeight() {
/* 65 */     return this.height;
/*    */   }
/*    */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Button.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */