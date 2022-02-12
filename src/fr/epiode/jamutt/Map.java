/*    */ package fr.epiode.jamutt;
/*    */ 
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.image.BufferedImage;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ 
/*    */ public class Map
/*    */ {
/* 10 */   private BufferedImage img = null;
/*    */   private int width;
/*    */   private int height;
/*    */   
/*    */   public Map(String map_name) {
/*    */     try {
/* 16 */       this.img = ImageIO.read(Main.class.getResourceAsStream(map_name));
/* 17 */       BufferedImage scaled = new BufferedImage(5920, 5360, this.img.getType());
/* 18 */       Graphics2D g2d = scaled.createGraphics();
/* 19 */       g2d.drawImage(this.img, 0, 0, 5920, 5360, null);
/* 20 */       g2d.dispose();
/* 21 */       this.img = scaled;
/* 22 */     } catch (Exception e) {
/* 23 */       System.err.println("Cannot open image " + map_name + " see error below.");
/* 24 */       e.printStackTrace();
/*    */     } 
/* 26 */     this.width = this.img.getWidth();
/* 27 */     this.height = this.img.getHeight();
/*    */   }
/*    */   
/*    */   public BufferedImage getImage() {
/* 31 */     return this.img;
/*    */   }
/*    */   
/*    */   public int getWidth() {
/* 35 */     return this.width;
/*    */   }
/*    */   
/*    */   public int getHeight() {
/* 39 */     return this.height;
/*    */   }
/*    */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Map.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */