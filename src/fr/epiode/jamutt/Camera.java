/*     */ package fr.epiode.jamutt;
/*     */ 
/*     */ public class Camera
/*     */ {
/*     */   private int x;
/*     */   private int y;
/*     */   private int width;
/*     */   private int height;
/*   9 */   private int movingX = 0;
/*  10 */   private int movingY = 0;
/*  11 */   private int maxX = 0;
/*  12 */   private int maxY = 0;
/*  13 */   private int goToX = 0;
/*  14 */   private int goToY = 0;
/*  15 */   private Runnable actionWhenFinishedMoving = null;
/*     */   
/*     */   public Camera(int x, int y, int width, int height, int maxX, int maxY) {
/*  18 */     this.x = x;
/*  19 */     this.y = y;
/*  20 */     this.width = width;
/*  21 */     this.height = height;
/*  22 */     this.maxX = maxX;
/*  23 */     this.maxY = maxY;
/*     */   }
/*     */   
/*     */   public void update() {
/*  27 */     this.x += this.movingX;
/*  28 */     if (this.x < 0)
/*  29 */       this.x = 0; 
/*  30 */     if (this.x + this.width > this.maxX)
/*  31 */       this.x = this.maxX - this.width; 
/*  32 */     this.y += this.movingY;
/*  33 */     if (this.y < 0)
/*  34 */       this.y = 0; 
/*  35 */     if (this.y + this.height > this.maxY)
/*  36 */       this.y = this.maxY - this.height; 
/*     */   }
/*     */   
/*     */   public int getX() {
/*  40 */     return -this.x;
/*     */   }
/*     */   
/*     */   public int getY() {
/*  44 */     return -this.y;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/*  48 */     return this.width;
/*     */   }
/*     */   
/*     */   public int getHeight() {
/*  52 */     return this.height;
/*     */   }
/*     */   
/*     */   public void followPlayer(Player p) {
/*  56 */     if (this.goToX != 0 || this.goToY != 0) {
/*  57 */       this.x += (this.x != this.goToX) ? ((this.goToX > this.x) ? 5 : -5) : 0;
/*  58 */       this.y += (this.y != this.goToY) ? ((this.goToY > this.y) ? 5 : -5) : 0;
/*  59 */       if (this.x == this.goToX && this.y == this.goToY) {
/*  60 */         this.goToX = 0;
/*  61 */         this.goToY = 0;
/*  62 */         this.actionWhenFinishedMoving.run();
/*     */       } 
/*     */       return;
/*     */     } 
/*  66 */     if (p.canMove()) {
/*  67 */       if (p.getY() > 500)
/*  68 */         this.y = p.getY() - 500; 
/*  69 */       if (p.getX() > 500)
/*  70 */         this.x = p.getX() - 500; 
/*  71 */       if (this.x < 0)
/*  72 */         this.x = 0; 
/*  73 */       if (this.x + this.width > this.maxX)
/*  74 */         this.x = this.maxX - this.width; 
/*  75 */       if (this.y < 0)
/*  76 */         this.y = 0; 
/*  77 */       if (this.y + this.height > this.maxY)
/*  78 */         this.y = this.maxY - this.height; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setMovingX(int dir) {
/*  83 */     this.movingX = dir;
/*     */   }
/*     */   
/*     */   public void setMovingY(int dir) {
/*  87 */     this.movingY = dir;
/*     */   }
/*     */   
/*     */   public void setX(int x) {
/*  91 */     this.x = x;
/*     */   }
/*     */   
/*     */   public void setY(int y) {
/*  95 */     this.y = y;
/*     */   }
/*     */   
/*     */   public void goTo(int x, int y, Runnable actionWhenFinishedMoving) {
/*  99 */     this.goToX = x;
/* 100 */     this.goToY = y;
/* 101 */     this.actionWhenFinishedMoving = actionWhenFinishedMoving;
/*     */   }
/*     */   
/*     */   public int getMaxY() {
/* 105 */     return this.maxY;
/*     */   }
/*     */   
/*     */   public int getMaxX() {
/* 109 */     return this.maxX;
/*     */   }
/*     */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Camera.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */