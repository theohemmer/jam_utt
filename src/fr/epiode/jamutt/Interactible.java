/*     */ package fr.epiode.jamutt;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.image.BufferedImage;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ public class Interactible
/*     */   implements Entity
/*     */ {
/*     */   private BufferedImage img;
/*     */   private BufferedImage selected_img;
/*     */   private BufferedImage not_selected;
/*     */   private int x;
/*     */   private int y;
/*     */   private int base_y;
/*     */   private int goToX;
/*     */   private int goToY;
/*     */   private int width;
/*     */   private int height;
/*  21 */   private int movingX = 0;
/*  22 */   private int movingY = 0;
/*     */   private boolean selected = false;
/*     */   private Player p;
/*     */   private Runnable action;
/*  26 */   static int count = 0;
/*  27 */   private int number = 0;
/*     */   
/*     */   public Interactible(String image_name, int x, int y, Player p, Runnable action) {
/*     */     try {
/*  31 */       this.img = ImageIO.read(Main.class.getResourceAsStream(image_name));
/*  32 */       this.selected_img = ImageIO.read(Main.class.getResourceAsStream("bulle_dialogue.png"));
/*  33 */       BufferedImage tmp = new BufferedImage(64, 160, this.img.getType());
/*  34 */       Graphics2D g2d = tmp.createGraphics();
/*  35 */       g2d.drawImage(this.selected_img, 24, 8, 16, 16, null);
/*  36 */       g2d.drawImage(this.img, 0, 32, 64, 128, null);
/*  37 */       g2d.dispose();
/*  38 */       this.selected_img = tmp;
/*  39 */       this.not_selected = this.img;
/*  40 */       System.out.println("ok");
/*  41 */     } catch (Exception e) {
/*  42 */       System.err.println("Cannot open image " + image_name + " see error below.");
/*  43 */       e.printStackTrace();
/*     */     } 
/*     */     
/*  46 */     this.number = ++count;
/*  47 */     this.x = x;
/*  48 */     this.y = y;
/*  49 */     this.base_y = y;
/*  50 */     this.width = this.img.getWidth();
/*  51 */     this.height = this.img.getHeight();
/*  52 */     this.p = p;
/*  53 */     this.action = action;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX() {
/*  58 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY() {
/*  63 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX(int x) {
/*  68 */     this.x = x;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY(int y) {
/*  73 */     this.y = y;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/*  78 */     if (this.goToX != 0 || this.goToY != 0) {
/*  79 */       this.x += (this.x != this.goToX) ? ((this.goToX > this.x) ? 5 : -5) : 0;
/*  80 */       this.y += (this.y != this.goToY) ? ((this.goToY > this.y) ? 5 : -5) : 0;
/*  81 */       if (this.x == this.goToX && this.y == this.goToY) {
/*  82 */         this.goToX = 0;
/*  83 */         this.goToY = 0;
/*  84 */         this.movingX = 0;
/*  85 */         this.movingY = 0;
/*     */       } 
/*     */       return;
/*     */     } 
/*  89 */     this.x += this.movingX;
/*  90 */     this.y += this.movingY;
/*  91 */     Rectangle r1 = new Rectangle(this.x - 50, this.y - 50, this.width + 100, this.height + 100);
/*  92 */     Rectangle r2 = new Rectangle(this.p.getX(), this.p.getY(), this.p.getWidth(), this.p.getY());
/*  93 */     if (r1.intersects(r2)) {
/*  94 */       this.selected = true;
/*  95 */       this.img = this.selected_img;
/*  96 */       this.y = this.base_y - 32;
/*  97 */       this.width = this.img.getWidth();
/*  98 */       this.height = this.img.getHeight();
/*     */     } else {
/* 100 */       this.y = this.base_y;
/* 101 */       this.selected = false;
/* 102 */       this.img = this.not_selected;
/* 103 */       this.width = this.img.getWidth();
/* 104 */       this.height = this.img.getHeight();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 110 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 115 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMovingX(int dir) {
/* 120 */     this.movingX = dir;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMovingY(int dir) {
/* 125 */     this.movingY = dir;
/*     */   }
/*     */ 
/*     */   
/*     */   public BufferedImage getImage() {
/* 130 */     return this.img;
/*     */   }
/*     */   
/*     */   public void doActionIfSelected() {
/* 134 */     if (this.selected) {
/* 135 */       this.action.run();
/*     */     }
/*     */   }
/*     */   
/*     */   public void goTo(int x, int y) {
/* 140 */     this.goToX = x;
/* 141 */     this.goToY = y;
/* 142 */     this.movingX = x;
/* 143 */     this.movingY = y;
/*     */   }
/*     */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Interactible.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */