/*    */ package fr.epiode.jamutt;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ 
/*    */ public class Tl
/*    */ {
/*    */   private BufferedImage tl;
/*    */   private int x;
/*    */   private int y;
/*    */   
/*    */   public Tl(String tl_name, int x, int y) {
/* 14 */     this.x = x;
/* 15 */     this.y = y;
/*    */     try {
/* 17 */       this.tl = ImageIO.read(Main.class.getResourceAsStream(tl_name));
/* 18 */     } catch (Exception e) {
/* 19 */       System.err.println("Cannot open image " + tl_name + " see error below.");
/* 20 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   public BufferedImage getImage() {
/* 24 */     return this.tl;
/*    */   }
/*    */   
/*    */   public int getX() {
/* 28 */     return this.x;
/*    */   }
/*    */   public int getY() {
/* 31 */     return this.y;
/*    */   }
/*    */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Tl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */