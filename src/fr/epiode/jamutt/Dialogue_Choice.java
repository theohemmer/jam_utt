/*    */ package fr.epiode.jamutt;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Dialogue_Choice
/*    */ {
/* 17 */   int len_x = 0;
/* 18 */   int len_y = 0;
/* 19 */   int selected = 0;
/*    */   String[] choice;
/*    */   Runnable[] actions;
/*    */   
/*    */   public Dialogue_Choice(String[] choice, Runnable[] actions, Font f) {
/*    */     byte b;
/*    */     int i;
/*    */     String[] arrayOfString;
/* 27 */     for (i = (arrayOfString = choice).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 28 */       int len = s.length() * 22;
/* 29 */       this.len_x = (this.len_x < len) ? len : this.len_x; b++; }
/*    */     
/* 31 */     this.len_x += 20;
/* 32 */     this.len_y = 22 * choice.length + 40;
/* 33 */     this.choice = choice;
/* 34 */     this.actions = actions;
/* 35 */     if (first_load) {
/* 36 */       first_load = false;
/* 37 */       this.f = f;
/*    */     } 
/*    */   }
/*    */   static boolean first_load = true; Font f;
/*    */   
/*    */   public void paint(Graphics g) {
/* 43 */     g.setFont(this.f);
/* 44 */     g.setColor(Color.BLACK);
/* 45 */     g.fillRoundRect(990 - this.len_x, 810 - this.len_y, this.len_x, this.len_y, 25, 25);
/* 46 */     g.setColor(Color.WHITE);
/* 47 */     g.fillRoundRect(1000 - this.len_x, 820 - this.len_y, this.len_x - 20, this.len_y - 20, 25, 25);
/* 48 */     g.setColor(Color.BLACK);
/* 49 */     for (int i = 0; i < this.choice.length; i++) {
/* 50 */       g.drawString(this.choice[i], 1000 - this.len_x + 20, 820 - this.len_y + i * 25 + 25);
/*    */     }
/* 52 */     g.setColor(Color.red);
/* 53 */     g.fillRoundRect(1005 - this.len_x, 806 - this.len_y + 25 + this.selected * 25, 10, 10, 10, 10);
/*    */   }
/*    */ 
/*    */   
/*    */   public void choice_up() {
/* 58 */     if (this.selected > 0) {
/* 59 */       this.selected--;
/*    */     }
/*    */   }
/*    */   
/*    */   public void choice_down() {
/* 64 */     if (this.selected < this.choice.length - 1) {
/* 65 */       this.selected++;
/*    */     }
/*    */   }
/*    */   
/*    */   public void validate_choice() {
/* 70 */     if (this.actions != null && 
/* 71 */       this.actions[this.selected] != null)
/* 72 */       this.actions[this.selected].run(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Dialogue_Choice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */