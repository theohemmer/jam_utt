/*    */ package fr.epiode.jamutt;
/*    */ 
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Frame
/*    */   extends JFrame
/*    */ {
/*    */   private static final long serialVersionUID = -2505623935156920146L;
/* 16 */   Frame f = null;
/*    */   
/*    */   public Frame() {
/* 19 */     System.out.println("Prout");
/*    */     
/* 21 */     this.f = this;
/* 22 */     setSize(1016, 1039);
/* 23 */     setTitle("PPF Jam");
/* 24 */     setLocationRelativeTo(null);
/* 25 */     setContentPane(new Panel(this));
/* 26 */     setDefaultCloseOperation(3);
/* 27 */     setVisible(true);
/* 28 */     repaint();
/* 29 */     Thread t = new Thread(new Runnable()
/*    */         {
/*    */           
/*    */           public void run()
/*    */           {
/*    */             while (true) {
/* 35 */               Frame.this.f.repaint();
/*    */               try {
/* 37 */                 Thread.sleep(2L);
/* 38 */               } catch (InterruptedException e) {
/*    */                 
/* 40 */                 e.printStackTrace();
/*    */               } 
/*    */             } 
/*    */           }
/*    */         });
/* 45 */     t.start();
/*    */   }
/*    */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Frame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */