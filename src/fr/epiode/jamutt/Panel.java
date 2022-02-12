/*     */ package fr.epiode.jamutt;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontFormatException;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Panel
/*     */   extends JPanel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   boolean debug = true;
/*     */   boolean isBlack = false;
/*     */   boolean showCops = true;
/*     */   boolean showDamienVivant = true;
/*     */   boolean showDamienMort = false;
/*  39 */   Font f = null;
/*  40 */   Font cr_f = null;
/*  41 */   Font cre_f = null;
/*     */   
/*     */   Credits cr;
/*  44 */   Map map = new Map("mapdetest1500x1100.png");
/*  45 */   Camera cam = new Camera(0, 0, 1000, 1000, this.map.getWidth(), this.map.getHeight());
/*  46 */   Player p = new Player("perso_principale.png", this.map, this.cam);
/*  47 */   Menu menu = new Menu("background.png");
/*  48 */   Pause pause = new Pause();
/*  49 */   Interactible damien_mort = new Interactible("damien_mort.png", 1981, 3799, this.p, () -> System.out.println());
/*  50 */   Interactible damien = new Interactible("Damien_le_shmake.png", 1841, 3799, this.p, () -> System.out.println());
/*  51 */   Cop cop1 = new Cop("cop.png", this.map, this.cam, 1935, 3780);
/*  52 */   Cop cop2 = new Cop("cop.png", this.map, this.cam, 1980, 3827);
/*  53 */   Rectangle colid = null;
/*  54 */   Twitter twitter = new Twitter();
/*  55 */   EventZone clodo_event = new EventZone(4880, 1605, 238, 1, this.p, () -> Events.clodo_events(this, this.cam, this.p));
/*  56 */   EventZone flic_event = new EventZone(1842, 4963, 1, 231, this.p, () -> Events.flic_events(this, this.cam, this.p, this.cop1, this.cop2, this.damien, this.damien_mort));
/*     */   
/*  58 */   Interactible[] npcs = new Interactible[] { 
/*  59 */       new Interactible("pnj1.png", 2679, 4912, this.p, () -> Events.png_talk(this)), 
/*  60 */       new Interactible("pngf.png", 1061, 3277, this.p, () -> Events.png_talk(this)), 
/*  61 */       new Interactible("pngf.png", 182, 1001, this.p, () -> Events.png_talk(this)), 
/*  62 */       new Interactible("pnj1.png", 2332, 1514, this.p, () -> Events.png_talk(this)), 
/*  63 */       new Interactible("pnj1.png", 2565, 3012, this.p, () -> Events.png_talk(this)), 
/*  64 */       new Interactible("pngf.png", 3942, 2801, this.p, () -> Events.png_talk(this)), 
/*  65 */       new Interactible("pngf.png", 5110, 4922, this.p, () -> Events.png_talk(this)), 
/*  66 */       new Interactible("pnj1.png", 4893, 3349, this.p, () -> Events.png_talk(this)), 
/*  67 */       new Interactible("pngf.png", 5049, 205, this.p, () -> Events.png_talk(this)), 
/*  68 */       new Interactible("pnj1.png", 3411, 713, this.p, () -> Events.png_talk(this)), 
/*  69 */       new Interactible("Damien.png", 3910, 1315, this.p, () -> Events.damien_talk(this)) };
/*     */ 
/*     */   
/*     */   boolean dragging = false;
/*     */   
/*  74 */   String[] choices = new String[] { "Choix 1", "Choix 2", "Choix 3", "Licorne!" };
/*  75 */   Dialogue d = null;
/*  76 */   int[][] tests_btn = new int[][] {
/*  77 */       { 65, 367, 273, 94
/*  78 */       }, { 477, 369, 273, 94
/*  79 */       }, { 62, 616, 273, 94
/*  80 */       }, { 477, 616, 273, 94 }
/*     */     };
/*     */ 
/*     */   
/*     */   private void importFont() {
/*     */     try {
/*  86 */       this.f = Font.createFont(0, Main.class.getResourceAsStream("JetBrainsMono-Medium.ttf")).deriveFont(22.0F);
/*  87 */       this.cr_f = Font.createFont(0, Main.class.getResourceAsStream("JetBrainsMono-Medium.ttf")).deriveFont(55.0F);
/*  88 */       this.cre_f = Font.createFont(0, Main.class.getResourceAsStream("JetBrainsMono-Medium.ttf")).deriveFont(30.0F);
/*  89 */     } catch (FontFormatException|java.io.IOException e) {
/*  90 */       System.err.println("Using Courrier New as default font. See error below.");
/*  91 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public Panel(JFrame frame) {
/*  96 */     importFont();
/*  97 */     this.cr = new Credits(this.cr_f, this.cre_f);
/*  98 */     frame.addKeyListener(new KeyListener()
/*     */         {
/*     */           public void keyTyped(KeyEvent e) {}
/*     */ 
/*     */ 
/*     */           
/*     */           public void keyReleased(KeyEvent e) {
/* 105 */             if (e.getKeyCode() == 37 || e.getKeyCode() == 39)
/* 106 */               Panel.this.p.setMovingX(0); 
/* 107 */             if (e.getKeyCode() == 38 || e.getKeyCode() == 40)
/* 108 */               Panel.this.p.setMovingY(0); 
/* 109 */             if (e.getKeyCode() == 27) {
/* 110 */               Panel.this.pause.esc = false;
/*     */             }
/*     */           }
/*     */           
/*     */           public void keyPressed(KeyEvent e) {
/* 115 */             System.out.println("Code : " + e.getKeyCode());
/* 116 */             if (!Panel.this.pause.inp && 
/* 117 */               Panel.this.d != null && Panel.this.d.is_open()) {
/* 118 */               if (Panel.this.d.is_choice_open()) {
/* 119 */                 if (e.getKeyCode() == 38)
/* 120 */                   Panel.this.d.choice_up(); 
/* 121 */                 if (e.getKeyCode() == 40)
/* 122 */                   Panel.this.d.choice_down(); 
/* 123 */                 if (e.getKeyCode() == 10) {
/* 124 */                   Panel.this.d.validate_choice();
/*     */                 }
/* 126 */               } else if (e.getKeyCode() == 10) {
/* 127 */                 Panel.this.d.skip();
/*     */               } 
/*     */               
/*     */               return;
/*     */             } 
/* 132 */             if (e.getKeyCode() == 114)
/* 133 */               Panel.this.debug = !Panel.this.debug; 
/* 134 */             if (e.getKeyCode() == 37)
/* 135 */               Panel.this.p.setMovingX(-1); 
/* 136 */             if (e.getKeyCode() == 39)
/* 137 */               Panel.this.p.setMovingX(1); 
/* 138 */             if (e.getKeyCode() == 38)
/* 139 */               Panel.this.p.setMovingY(-1); 
/* 140 */             if (e.getKeyCode() == 40)
/* 141 */               Panel.this.p.setMovingY(1); 
/* 142 */             if (e.getKeyChar() == '\n') {
/* 143 */               System.out.println("Coord: " + Panel.this.p.getX() + ", " + Panel.this.p.getY()); byte b; int i; Interactible[] arrayOfInteractible;
/* 144 */               for (i = (arrayOfInteractible = Panel.this.npcs).length, b = 0; b < i; ) { Interactible it = arrayOfInteractible[b];
/* 145 */                 it.doActionIfSelected(); b++; }
/*     */             
/* 147 */             }  if (e.getKeyCode() == 27 && !Panel.this.pause.inp && !Panel.this.pause.esc) {
/* 148 */               Panel.this.pause.esc = true;
/* 149 */               Panel.this.pause.inp = true;
/* 150 */               Panel.this.p.setCanMove(false);
/*     */             } 
/* 152 */             if (e.getKeyCode() == 27 && Panel.this.pause.inp && !Panel.this.pause.esc) {
/* 153 */               Panel.this.pause.esc = true;
/* 154 */               Panel.this.pause.inp = false;
/* 155 */               Panel.this.p.setCanMove(true);
/*     */             } 
/*     */           }
/*     */         });
/* 159 */     frame.addMouseListener(new MouseListener()
/*     */         {
/*     */           public void mouseReleased(MouseEvent e)
/*     */           {
/* 163 */             int e_x = -Panel.this.cam.getX() + e.getX() - 8;
/* 164 */             int e_y = -Panel.this.cam.getY() + e.getY() - 31;
/* 165 */             Panel.this.colid.setBounds(Panel.this.colid.x, Panel.this.colid.y, e_x - Panel.this.colid.x, e_y - Panel.this.colid.y);
/* 166 */             System.out.println("{" + Panel.this.colid.x + ", " + Panel.this.colid.y + ", " + Panel.this.colid.width + ", " + Panel.this.colid.height + "}");
/* 167 */             Panel.this.dragging = false;
/*     */           }
/*     */ 
/*     */           
/*     */           public void mousePressed(MouseEvent e) {
/* 172 */             int x = -Panel.this.cam.getX() + e.getX() - 8;
/* 173 */             int y = -Panel.this.cam.getY() + e.getY() - 31;
/* 174 */             Panel.this.colid = new Rectangle(x, y, 1, 1);
/* 175 */             Panel.this.dragging = true;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void mouseExited(MouseEvent e) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void mouseEntered(MouseEvent e) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void mouseClicked(MouseEvent e) {
/* 192 */             System.out.println("u");
/* 193 */             if (e.getButton() == 1) {
/* 194 */               Panel.this.menu.click(e.getX(), e.getY());
/* 195 */               Panel.this.pause.click(e.getX(), e.getY());
/*     */             } 
/*     */           }
/*     */         });
/* 199 */     frame.addMouseMotionListener(new MouseMotionListener()
/*     */         {
/*     */           public void mouseMoved(MouseEvent e)
/*     */           {
/* 203 */             if (Panel.this.colid != null && Panel.this.dragging) {
/* 204 */               int e_x = -Panel.this.cam.getX() + e.getX() - 8;
/* 205 */               int e_y = -Panel.this.cam.getY() + e.getY() - 31;
/* 206 */               Panel.this.colid.setBounds(Panel.this.colid.x, Panel.this.colid.y, e_x - Panel.this.colid.x, e_y - Panel.this.colid.y);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void mouseDragged(MouseEvent e) {
/* 212 */             if (Panel.this.colid != null && Panel.this.dragging) {
/* 213 */               int e_x = -Panel.this.cam.getX() + e.getX() - 8;
/* 214 */               int e_y = -Panel.this.cam.getY() + e.getY() - 31;
/* 215 */               Panel.this.colid.setBounds(Panel.this.colid.x, Panel.this.colid.y, e_x - Panel.this.colid.x, e_y - Panel.this.colid.y);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void paintComponent(Graphics g) {
/* 224 */     this.cr.finished = true;
/* 225 */     if (Main.from_who == Main.from.THEO) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 232 */       if (this.debug)
/* 233 */         ColidChecker.drawRect(this.cam, g); 
/*     */     } else {
/* 235 */       if (!this.cr.finished) {
/* 236 */         this.cr.paint(g); return;
/*     */       } 
/* 238 */       if (!this.menu.finished) {
/* 239 */         this.menu.draw(g);
/* 240 */       } else if (this.pause.inp) {
/* 241 */         this.pause.draw(g);
/*     */       } else {         
/* 244 */         if (this.isBlack) {
/* 245 */           g.setColor(Color.BLACK);
/* 246 */           g.fillRect(0, 0, 1000, 1000);
/*     */           return;
/*     */         } 
/* 249 */         this.p.update();
/* 250 */         this.clodo_event.update();
/* 251 */         this.flic_event.update();
/* 252 */         this.cop1.update();
/* 253 */         this.cop2.update();
/* 254 */         this.damien.update();
/* 255 */         this.damien_mort.update();
/* 256 */         this.cam.followPlayer(this.p);
/* 257 */         g.drawImage(this.map.getImage(), this.cam.getX(), this.cam.getY(), null);
/* 258 */         g.drawImage(this.p.getImage(), this.cam.getX() + this.p.getX(), this.cam.getY() + this.p.getY(), null); byte b; int i; Interactible[] arrayOfInteractible;
/* 259 */         for (i = (arrayOfInteractible = this.npcs).length, b = 0; b < i; ) { Interactible it = arrayOfInteractible[b];
/* 260 */           it.update();
/* 261 */           g.drawImage(it.getImage(), this.cam.getX() + it.getX(), this.cam.getY() + it.getY(), null); b++; }
/*     */         
/* 263 */         if (this.showDamienVivant) {
/* 264 */           g.drawImage(this.damien.getImage(), this.cam.getX() + this.damien.getX(), this.cam.getY() + this.damien.getY(), null);
/*     */         }
/* 266 */         if (this.showDamienMort) {
/* 267 */           g.drawImage(this.damien_mort.getImage(), this.cam.getX() + this.damien_mort.getX(), this.cam.getY() + this.damien_mort.getY(), null);
/*     */         }
/* 269 */         if (this.showCops) {
/* 270 */           g.drawImage(this.cop1.getImage(), this.cam.getX() + this.cop1.getX(), this.cam.getY() + this.cop1.getY(), null);
/* 271 */           g.drawImage(this.cop2.getImage(), this.cam.getX() + this.cop2.getX(), this.cam.getY() + this.cop2.getY(), null);
/*     */         } 
/*     *//* 233 */         ColidChecker.drawRect(this.cam, g);
							g.drawRect(this.cam.getX() + colid.x, this.cam.getY() + colid.y, colid.width, colid.height);
/*     */       } 
/*     */     } 
/* 275 */     if (this.d != null && !this.pause.inp) {
/* 276 */       this.d.paint(g);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void openDialogue(Dialogue dialogue) {
/* 283 */     this.d = dialogue;
/* 284 */     if (this.d != null)
/* 285 */       this.d.setFont(this.f); 
/*     */   }
/*     */   
/*     */   public void switch_flash_back() {
/* 289 */     this.isBlack = !this.isBlack;
/*     */   }
/*     */   
/*     */   public void setShowCops(boolean bool) {
/* 293 */     this.showCops = bool;
/*     */   }
/*     */   
/*     */   public void setShowDamien(boolean bool) {
/* 297 */     this.showDamienVivant = bool;
/*     */   }
/*     */   
/*     */   public void setShowDamienMort(boolean bool) {
/* 301 */     this.showDamienMort = bool;
/*     */   }
/*     */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Panel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */