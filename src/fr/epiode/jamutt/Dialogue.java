/*     */ package fr.epiode.jamutt;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Polygon;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.LinkedList;
/*     */ import javax.imageio.ImageIO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Dialogue
/*     */ {
/*  21 */   Font f = new Font("Courrier New", 0, 22);
/*  22 */   static Polygon fleche = new Polygon();
/*     */   static boolean first_load = true;
/*  24 */   static BufferedImage img = null;
/*  25 */   Dialogue_Choice dc = null;
/*     */   
/*  27 */   int printing_diag = 0;
/*  28 */   int printing_line = 0;
/*  29 */   int printing_char = 0;
/*  30 */   long last_paint = 0L;
/*  31 */   long last_pg_paint = 0L;
/*     */   boolean draw_pg = true;
/*     */   boolean is_choice_open = false;
/*  34 */   Runnable[] actions = null;
/*  35 */   LinkedList<String[]> diag_list = (LinkedList)new LinkedList<>();
/*     */   
/*     */   public Dialogue(String diag, String[] choice, Runnable[] actions, Font font) {
/*  38 */     this.last_paint = System.currentTimeMillis();
/*  39 */     if (first_load) {
/*     */       try {
/*  41 */         img = ImageIO.read(Main.class.getResourceAsStream("boite_dialogue.jpg"));
/*  42 */       } catch (Exception e) {
/*  43 */         System.err.println("Cannot open image boite_dialogue.jpg see error below.");
/*  44 */         e.printStackTrace();
/*     */       } 
/*  46 */       first_load = false;
/*  47 */       fleche.addPoint(950, 950);
/*  48 */       fleche.addPoint(970, 950);
/*  49 */       fleche.addPoint(960, 970);
/*     */     } 
/*  51 */     this.f = font;
/*  52 */     LinkedList<String> temp_diag = new LinkedList<>();
/*  53 */     String[] splitted = diag.split("\n");
/*  54 */     int line_len = 0;
/*  55 */     String one_line = ""; byte b; int j; String[] arrayOfString1;
/*  56 */     for (j = (arrayOfString1 = splitted).length, b = 0; b < j; ) { String x = arrayOfString1[b];
/*  57 */       String[] splitted_again = x.split(" "); byte b1; int k; String[] arrayOfString2;
/*  58 */       for (k = (arrayOfString2 = splitted_again).length, b1 = 0; b1 < k; ) { String s = arrayOfString2[b1];
/*  59 */         if (line_len + s.length() > 70) {
/*  60 */           temp_diag.add(one_line);
/*  61 */           one_line = "";
/*  62 */           line_len = 0;
/*     */         } 
/*  64 */         one_line = String.valueOf(one_line) + s + " ";
/*  65 */         line_len += s.length() + 1; b1++; }
/*     */       
/*  67 */       temp_diag.add(one_line);
/*  68 */       one_line = "";
/*  69 */       line_len = 0; b++; }
/*     */     
/*  71 */     temp_diag.add(one_line);
/*  72 */     for (int i = 0; i < temp_diag.size(); i += 5) {
/*  73 */       String[] one_diag = { "", "", "", "", "" };
/*  74 */       for (int x = 0; x < 5 && x + i < temp_diag.size(); x++)
/*  75 */         one_diag[x] = temp_diag.get(x + i); 
/*  76 */       this.diag_list.add(one_diag);
/*     */     } 
/*  78 */     for (String[] st : this.diag_list) {
/*  79 */       byte b1; int k; String[] arrayOfString2; for (k = (arrayOfString2 = st).length, b1 = 0; b1 < k; ) { String s = arrayOfString2[b1];
/*  80 */         System.out.println(s); b1++; }
/*     */       
/*  82 */       System.out.println("-------------------------------------------------------------------------------------");
/*     */     } 
/*  84 */     if (choice != null)
/*  85 */       this.dc = new Dialogue_Choice(choice, actions, this.f); 
/*  86 */     if (actions != null) {
/*  87 */       this.actions = actions;
/*     */     }
/*     */   }
/*     */   
/*     */   public void paint(Graphics g) {
/*  92 */     if (this.printing_diag >= this.diag_list.size()) {
/*  93 */       if (this.dc == null && this.actions != null) {
/*  94 */         System.out.println("lo");
/*  95 */         if (this.actions[0] != null) {
/*  96 */           this.actions[0].run();
/*  97 */           this.actions = null;
/*     */         } 
/*     */       } 
/*     */       return;
/*     */     } 
/* 102 */     String[] diag = this.diag_list.get(this.printing_diag);
/* 103 */     if (System.currentTimeMillis() - this.last_paint >= 10L) {
/* 104 */       if (this.printing_line != diag.length && 
/* 105 */         this.printing_char < diag[this.printing_line].length())
/* 106 */         this.printing_char++; 
/* 107 */       this.last_paint = System.currentTimeMillis();
/*     */     } 
/* 109 */     if (System.currentTimeMillis() - this.last_pg_paint >= 350L) {
/* 110 */       this.draw_pg = !this.draw_pg;
/* 111 */       this.last_pg_paint = System.currentTimeMillis();
/*     */     } 
/* 113 */     g.setFont(this.f);
/* 114 */     g.setColor(Color.BLACK);
/* 115 */     g.drawImage(img, 10, 820, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     for (int i = 0; i < this.printing_line; i++) {
/* 122 */       g.drawString(diag[i], 30, 865 + i * 22);
/*     */     }
/* 124 */     if (this.printing_line != diag.length)
/* 125 */       g.drawString(diag[this.printing_line].substring(0, this.printing_char), 30, 865 + this.printing_line * 22); 
/* 126 */     if (this.printing_line != diag.length && 
/* 127 */       this.printing_char >= diag[this.printing_line].length()) {
/* 128 */       this.printing_char = 0;
/* 129 */       if (this.printing_line < diag.length) {
/* 130 */         this.printing_line++;
/*     */       }
/*     */     } 
/* 133 */     if (this.draw_pg && this.printing_line == diag.length)
/* 134 */       if (this.printing_diag != this.diag_list.size() - 1) {
/* 135 */         g.fillPolygon(fleche);
/*     */       } else {
/* 137 */         g.fillRoundRect(950, 950, 20, 20, 20, 20);
/*     */       }  
/* 139 */     if (this.dc != null && this.printing_line == diag.length && this.printing_diag == this.diag_list.size() - 1) {
/* 140 */       this.is_choice_open = true;
/* 141 */       this.dc.paint(g);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void skip() {
/* 147 */     if (this.printing_diag >= this.diag_list.size())
/*     */       return; 
/* 149 */     if (this.is_choice_open)
/*     */       return; 
/* 151 */     String[] diag = this.diag_list.get(this.printing_diag);
/* 152 */     if (this.printing_line < diag.length) {
/* 153 */       this.printing_line = diag.length;
/* 154 */       this.printing_char = diag[this.printing_line - 1].length();
/*     */     } else {
/* 156 */       this.printing_diag++;
/* 157 */       this.printing_line = 0;
/* 158 */       this.printing_char = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void choice_up() {
/* 164 */     this.dc.choice_up();
/*     */   }
/*     */ 
/*     */   
/*     */   public void choice_down() {
/* 169 */     this.dc.choice_down();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is_choice_open() {
/* 174 */     return this.is_choice_open;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is_open() {
/* 179 */     if (this.printing_diag >= this.diag_list.size())
/* 180 */       return false; 
/* 181 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void validate_choice() {
/* 186 */     skip();
/* 187 */     this.dc.validate_choice();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFont(Font f) {
/* 192 */     this.f = f;
/*     */   }
/*     */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Dialogue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */