/*    */ package fr.epiode.jamutt;
/*    */ 
/*    */ import javax.sound.sampled.AudioInputStream;
/*    */ import javax.sound.sampled.AudioSystem;
/*    */ import javax.sound.sampled.Clip;
/*    */ import javax.sound.sampled.LineEvent;
/*    */ import javax.sound.sampled.LineListener;
/*    */ 
/*    */ public class SoundPlayer
/*    */ {
/*    */   public static synchronized void playSound(final String url, final Runnable end) {
/* 12 */     (new Thread(new Runnable() {
/*    */           public void run() {
/*    */             try {
/* 15 */               Clip clip = AudioSystem.getClip();
/* 16 */               AudioInputStream inputStream = AudioSystem.getAudioInputStream(
/* 17 */                   Main.class.getResourceAsStream(url));
/* 18 */               clip.addLineListener(new LineListener()
/*    */                   {
/*    */                     public void update(LineEvent event)
/*    */                     {
/* 22 */                       if (event.getType() == LineEvent.Type.STOP)
/* 23 */                         end.run(); 
/*    */                     }
/*    */                   });
/* 26 */               clip.open(inputStream);
/* 27 */               clip.start();
/* 28 */             } catch (Exception e) {
/* 29 */               System.err.println(e.getMessage());
/*    */             } 
/*    */           }
/* 32 */         })).start();
/*    */   }
/*    */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\SoundPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */