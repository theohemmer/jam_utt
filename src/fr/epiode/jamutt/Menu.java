/*    */ package fr.epiode.jamutt;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Menu
/*    */ {
/*    */   boolean finished = false;
/*    */   boolean settings = false;
/* 25 */   Button b1 = new Button("Play_button.png", 265, 475);
/* 26 */   Button b2 = new Button("Quit_button.png", 265, 750);
/* 27 */   Button s = new Button("settings.png", 900, 900, 2.0F);
/* 28 */   Button lb = new Button("language_box.png", 850, 550, 1.5F);
/* 29 */   Button tv = new Button("tv_episociety.png", 265, 25);
/*    */   
/*    */   private BufferedImage background;
/*    */   
/*    */   public Menu(String bkg_name) {
/*    */     try {
/* 35 */       this.background = ImageIO.read(Main.class.getResourceAsStream(bkg_name));
/* 36 */     } catch (Exception e) {
/* 37 */       System.err.println("Cannot open image " + bkg_name + " see error below.");
/* 38 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void draw(Graphics g) {
/* 43 */     g.setColor(Color.BLACK);
/* 44 */     g.fillRect(0, 0, 1200, 1200);
/* 45 */     g.setColor(Color.WHITE);
/* 46 */     g.drawImage(this.background, 0, 0, null);
/* 47 */     g.drawImage(this.tv.getImage(), this.tv.getX(), this.tv.getY(), null);
/* 48 */     g.drawImage(this.b1.getImage(), this.b1.getX(), this.b1.getY(), null);
/* 49 */     g.drawImage(this.b2.getImage(), this.b2.getX(), this.b2.getY(), null);
/* 50 */     g.drawImage(this.s.getImage(), this.s.getX(), this.s.getY(), null);
/* 51 */     if (this.settings)
/* 52 */       g.drawImage(this.lb.getImage(), this.lb.getX(), this.lb.getY(), null); 
/*    */   }
/*    */   
/*    */   public void click(int x, int y) {
/* 56 */     x -= 8;
/* 57 */     y -= 31;
/* 58 */     if (x >= this.b1.getX() && x <= this.b1.getX() + this.b1.getWidth() && y >= this.b1.getY() && y <= this.b1.getY() + this.b1.getHeight() && !this.finished) {
/* 59 */       this.finished = true;
/*    */     }
/* 61 */     if (x >= this.b2.getX() && x <= this.b2.getX() + this.b2.getWidth() && y >= this.b2.getY() && y <= this.b2.getY() + this.b2.getHeight() && !this.finished) {
/* 62 */       System.exit(0);
/*    */     }
/* 64 */     if (x >= this.s.getX() && x <= this.s.getX() + this.s.getWidth() && y >= this.s.getY() && y <= this.s.getY() + this.s.getHeight() && !this.finished)
/* 65 */       if (!this.settings) {
/* 66 */         this.settings = true;
/*    */       } else {
/* 68 */         this.settings = false;
/*    */       }  
/* 70 */     if (x >= 860 && x <= 973 && y >= 585 && y <= 623 && this.settings)
/* 71 */       Events.set_language(Events.LANGUE.ENGLISH); 
/* 72 */     if (x >= 860 && x <= 980 && y >= 635 && y <= 673 && this.settings)
/* 73 */       Events.set_language(Events.LANGUE.FRENCH); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Menu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */