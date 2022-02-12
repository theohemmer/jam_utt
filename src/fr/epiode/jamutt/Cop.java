/*     */ package fr.epiode.jamutt;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ 
/*     */ public class Cop
/*     */   implements Entity
/*     */ {
/*  11 */   private BufferedImage[] img = new BufferedImage[3];
/*  12 */   private int state = 0;
/*     */   private int x;
/*     */   private int y;
/*     */   private int width;
/*     */   private int height;
/*  17 */   private int movingX = 0;
/*  18 */   private int movingY = 0;
/*  19 */   private int goToX = 0;
/*  20 */   private int goToY = 0;
/*  21 */   private Runnable actionWhenFinishedMoving = null;
/*     */   private boolean canMove = true;
/*     */   private Map map;
/*  24 */   private long last_update = System.currentTimeMillis();
/*     */   
/*     */   public Cop(String img_name, Map map, Camera cam, int x, int y) {
/*     */     try {
/*  28 */       BufferedImage tmp = ImageIO.read(Main.class.getResourceAsStream(img_name));
/*  29 */       for (int i = 0; i < 3; i++) {
/*  30 */         this.img[i] = new BufferedImage(64, 128, tmp.getType());
/*  31 */         Graphics2D g2d = this.img[i].createGraphics();
/*  32 */         g2d.drawImage(tmp.getSubimage(i % 3 * 64, i / 3 * 128, 64, 128), 0, 0, 64, 128, null);
/*  33 */         g2d.dispose();
/*     */       } 
/*  35 */     } catch (Exception e) {
/*  36 */       System.err.println("Cannot open image " + img_name + " see error below.");
/*  37 */       e.printStackTrace();
/*     */     } 
/*  39 */     this.width = 64;
/*  40 */     this.height = 128;
/*  41 */     this.x = x;
/*  42 */     this.y = y;
/*  43 */     this.map = map;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/*  48 */     if (this.goToX != 0 || this.goToY != 0) {
/*  49 */       this.x += (this.x != this.goToX) ? ((this.goToX > this.x) ? 5 : -5) : 0;
/*  50 */       this.y += (this.y != this.goToY) ? ((this.goToY > this.y) ? 5 : -5) : 0;
/*  51 */       if (this.x == this.goToX && this.y == this.goToY) {
/*  52 */         this.goToX = 0;
/*  53 */         this.goToY = 0;
/*  54 */         this.movingX = 0;
/*  55 */         this.movingY = 0;
/*  56 */         this.actionWhenFinishedMoving.run();
/*     */       } 
/*     */     } 
/*  59 */     if (System.currentTimeMillis() - this.last_update > 150L) {
/*  60 */       if (this.movingX != 0 || this.movingY != 0) {
/*  61 */         this.state = (this.state + 1) % 2;
/*     */       } else {
/*  63 */         this.state = 0;
/*     */       } 
/*  65 */       this.last_update = System.currentTimeMillis();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX() {
/*  71 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY() {
/*  76 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX(int x) {
/*  81 */     this.x = x;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY(int y) {
/*  86 */     this.y = y;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/*  91 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  96 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMovingX(int dir) {
/* 101 */     this.movingX = dir;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMovingY(int dir) {
/* 106 */     this.movingY = dir;
/*     */   }
/*     */ 
/*     */   
/*     */   public BufferedImage getImage() {
/* 111 */     return this.img[this.state];
/*     */   }
/*     */   
/*     */   public void setCanMove(boolean canMove) {
/* 115 */     this.canMove = canMove;
/*     */   }
/*     */   
/*     */   public boolean canMove() {
/* 119 */     return this.canMove;
/*     */   }
/*     */   
/*     */   public void goTo(int x, int y, Runnable actionWhenFinishedMoving) {
/* 123 */     this.goToX = x;
/* 124 */     this.goToY = y;
/* 125 */     this.movingX = x;
/* 126 */     this.movingY = y;
/* 127 */     this.actionWhenFinishedMoving = actionWhenFinishedMoving;
/*     */   }
/*     */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Cop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */