/*     */ package fr.epiode.jamutt;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Credits
/*     */ {
/*     */   Font f;
/*     */   Font cr_f;
/*     */   boolean finished = false;
/*  21 */   int e_pos = -50;
/*  22 */   int pi_pos = -50;
/*  23 */   int ode_pos = -50;
/*     */   
/*  25 */   int last_size = 0;
/*     */   
/*  27 */   int decal = 0;
/*  28 */   int mask = 0;
/*     */   
/*  30 */   int state = 0;
/*     */   
/*  32 */   String txt = "EPIODE ";
/*     */   
/*  34 */   long last_paint = System.currentTimeMillis();
/*  35 */   long last_update = this.last_paint;
/*     */   
/*     */   public Credits(Font f, Font cr_f) {
/*  38 */     this.f = f;
/*  39 */     this.cr_f = cr_f;
/*     */   }
/*     */   
/*     */   public void paint(Graphics g) {
/*  43 */     this.last_size++;
/*  44 */     g.setFont(this.f);
/*  45 */     g.setColor(Color.BLACK);
/*  46 */     g.fillRect(0, 0, 1000, 1000);
/*  47 */     g.setColor(Color.WHITE);
/*  48 */     if (System.currentTimeMillis() - this.last_paint >= 5L && !this.finished) {
/*  49 */       if (this.decal > -1000)
/*  50 */         this.decal--; 
/*  51 */       this.last_paint = System.currentTimeMillis();
/*     */     } 
/*  53 */     if (System.currentTimeMillis() - this.last_update >= 500L && !this.finished) {
/*  54 */       if (this.mask < 8)
/*  55 */         this.mask++; 
/*  56 */       if (this.mask == 8) {
/*  57 */         this.state++;
/*     */       }
/*  59 */       if (this.state == 4) {
/*  60 */         this.txt = "PRESENTS ";
/*  61 */         this.decal = 0;
/*     */       } 
/*  63 */       if (this.state == 8) {
/*  64 */         this.txt = "EPISOCIETY ";
/*  65 */         this.decal = 0;
/*     */       } 
/*  67 */       if (this.state == 12) {
/*  68 */         this.txt = "A GAME BY - ";
/*  69 */         this.decal = 0;
/*     */       } 
/*  71 */       if (this.state >= 22)
/*  72 */         this.finished = true; 
/*  73 */       System.out.println("State: " + this.state);
/*     */ 
/*     */       
/*  76 */       this.last_update = System.currentTimeMillis();
/*     */     } 
/*  78 */     if (this.state < 16) {
/*  79 */       int x = 0;
/*  80 */       String epiode = "";
/*  81 */       for (int j = 0; j < 13; j++) {
/*  82 */         epiode = String.valueOf(epiode) + this.txt;
/*     */       }
/*     */       
/*  85 */       for (int y = -2; y < 1000; y += 55) {
/*  86 */         g.drawString(epiode.substring(x), this.decal, y);
/*  87 */         x++;
/*     */       } 
/*  89 */       g.setColor(Color.BLACK); int i;
/*  90 */       for (i = 0; i < this.mask; i++) {
/*  91 */         g.fillRect(0, i * 55, 1000, 65);
/*     */       }
/*  93 */       for (i = 0; i < this.mask; i++) {
/*  94 */         g.fillRect(0, 1000 - i * 55 - 55, 1000, 65);
/*     */       }
/*     */     } else {
/*  97 */       g.setFont(this.cr_f);
/*  98 */       g.drawString("Yann JULITE - Developer", 272, 440);
/*  99 */       g.drawString("Vincent THOMAS - Developer", 253, 470);
/* 100 */       g.drawString("Benjamin MESSMER - Developer", 234, 500);
/* 101 */       g.drawString("Théo HEMMER - Lead Developer", 234, 530);
/* 102 */       g.drawString("Floriane MANTEY - Graphic Designer", 196, 560);
/* 103 */       g.drawString("François ROLLAND - Graphic Designer", 177, 590);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Credits.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */