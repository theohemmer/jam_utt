/*     */ package fr.epiode.jamutt;
/*     */ 
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.image.BufferedImage;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ public class Player
/*     */   implements Entity
/*     */ {
/*  11 */   private BufferedImage[] img = new BufferedImage[8];
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
/*     */   public Player(String img_name, Map map, Camera cam) {
/*     */     try {
/*  28 */       BufferedImage tmp = ImageIO.read(Main.class.getResourceAsStream(img_name));
/*  29 */       for (int i = 0; i < 8; i++) {
/*  30 */         this.img[i] = new BufferedImage(64, 128, tmp.getType());
/*  31 */         Graphics2D g2d = this.img[i].createGraphics();
/*  32 */         g2d.drawImage(tmp.getSubimage(i % 4 * 64, i / 4 * 128, 64, 128), 0, 0, 64, 128, null);
/*  33 */         g2d.dispose();
/*     */       } 
/*  35 */     } catch (Exception e) {
/*  36 */       System.err.println("Cannot open image " + img_name + " see error below.");
/*  37 */       e.printStackTrace();
/*     */     } 
/*  39 */     this.width = 64;
/*  40 */     this.height = 128;
/*  41 */     this.x = 1411;
/*  42 */     this.y = 802;
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
/*  54 */         this.actionWhenFinishedMoving.run();
/*     */       } 
/*     */       return;
/*     */     } 
/*  58 */     if (this.canMove) {
/*  59 */       Rectangle r2 = new Rectangle(3923, 4305, 633, 654);
/*  60 */       this.x += this.movingX * 10;
/*  61 */       if (this.x < 0)
/*  62 */         this.x = 0; 
/*  63 */       if (this.x + this.width > this.map.getWidth())
/*  64 */         this.x = this.map.getWidth() - this.width; 
/*  65 */       this.y += this.movingY * 10;
/*  66 */       if (this.y < 0)
/*  67 */         this.y = 0; 
/*  68 */       if (this.y + this.height > this.map.getHeight())
/*  69 */         this.y = this.map.getHeight() - this.height; 
/*  70 */       if (!ColidChecker.checkCanMove(this)) {
/*  71 */         this.x -= this.movingX * 10;
/*  72 */         this.y -= this.movingY * 10;
/*     */       } 
/*     */     } 
/*  75 */     if (System.currentTimeMillis() - this.last_update > 150L) {
/*  76 */       if (this.movingX < 0) {
/*  77 */         this.state = (this.state + 1) % 3;
/*  78 */       } else if (this.movingX > 0) {
/*  79 */         this.state = 4 + (this.state + 1) % 3;
/*  80 */       } else if (this.movingY != 0) {
/*  81 */         this.state = ((this.state < 3) ? 0 : 4) + (this.state + 1) % 3;
/*     */       } else {
/*  83 */         this.state = (this.state < 3) ? 0 : 4;
/*     */       } 
/*  85 */       this.last_update = System.currentTimeMillis();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX() {
/*  91 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY() {
/*  96 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setX(int x) {
/* 101 */     this.x = x;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setY(int y) {
/* 106 */     this.y = y;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 111 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 116 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMovingX(int dir) {
/* 121 */     this.movingX = dir;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMovingY(int dir) {
/* 126 */     this.movingY = dir;
/*     */   }
/*     */ 
/*     */   
/*     */   public BufferedImage getImage() {
/* 131 */     return this.img[this.state];
/*     */   }
/*     */   
/*     */   public void setCanMove(boolean canMove) {
/* 135 */     this.canMove = canMove;
/*     */   }
/*     */   
/*     */   public boolean canMove() {
/* 139 */     return this.canMove;
/*     */   }
/*     */   
/*     */   public void goTo(int x, int y, Runnable actionWhenFinishedMoving) {
/* 143 */     this.goToX = x;
/* 144 */     this.goToY = y;
/* 145 */     this.actionWhenFinishedMoving = actionWhenFinishedMoving;
/*     */   }
/*     */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Player.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */