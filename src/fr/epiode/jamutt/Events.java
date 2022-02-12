/*     */ package fr.epiode.jamutt;
/*     */ 
/*     */ import java.util.Random;
/*     */ 
/*     */ public class Events
/*     */ {
/*     */   public enum LANGUE {
/*   8 */     FRENCH,
/*   9 */     ENGLISH;
/*     */   }
/*     */   
/*  12 */   static LANGUE language = LANGUE.FRENCH;
/*     */   
/*  14 */   static String[] random_dialogue_fr = new String[] { 
/*  15 */       "Quelle belle journée!", 
/*  16 */       "Bonjour jeune aventurier!", 
/*  17 */       "Gloire au régime!", 
/*  18 */       "Il fait beau aujourd'hui", 
/*  19 */       "J'ai vu un hippie hier dans la rue...", 
/*  20 */       "Vous allez bien?", 
/*  21 */       "J'ai mangé des brocolis aujourd'hui", 
/*  22 */       "Je me demande quel temps il fera demain?", 
/*  23 */       "Heureusement que les policiers nous protegent", 
/*  24 */       "J'ai vu ma voisine faire des trucs louches", 
/*  25 */       "On m'as proposé un poste dans le gouvernement", 
/*  26 */       "Je n'aime pas les gens différents", 
/*  27 */       "J'éspère que vous réspectez bien les lois" };
/*     */ 
/*     */   
/*  30 */   static String[] random_dialogue_en = new String[] { 
/*  31 */       "What a beautiful day!", 
/*  32 */       "Hello young adventurer!", 
/*  33 */       "Glory to the diet!", 
/*  34 */       "Such a beautiful weather today", 
/*  35 */       "I saw a hippie yesterday in the street ...", 
/*  36 */       "You are fine?", 
/*  37 */       "I ate broccoli today", 
/*  38 */       "I wonder what the weather will be tomorrow?", 
/*  39 */       "Fortunately the police are protecting us", 
/*  40 */       "I saw my neighbor doing shady things", 
/*  41 */       "I was offered a job in the government", 
/*  42 */       "I don't like different people", 
/*  43 */       "I hope you obey the laws well" };
/*     */ 
/*     */   
/*     */   public static void eventRectOne(Panel pan) {
/*  47 */     System.out.println("test");
/*  48 */     pan.openDialogue(new Dialogue("Coucou je suis le rectangle 1 !", null, null, null));
/*     */   }
/*     */   
/*     */   public static void eventRectTwo(Panel pan) {
/*  52 */     pan.openDialogue(new Dialogue("Coucou je suis le rectangle 2 !", null, null, null));
/*     */   }
/*     */   
/*     */   public static void clodo_events(Panel panel, Camera cam, Player p) {
/*  56 */     p.setCanMove(false);
/*  57 */     cam.goTo(3394, 873, () -> clodo_events_next(panel, cam, p));
/*     */   }
/*     */   
/*     */   public static void clodo_events_next(Panel panel, Camera cam, Player p) {
/*  61 */     Runnable[] end = { () -> return_to_player(panel, cam, p) };
/*  62 */     String diag = "";
/*  63 */     if (language == LANGUE.FRENCH) {
/*  64 */       diag = "Putain de gouvernement de merde.";
/*  65 */     } else if (language == LANGUE.ENGLISH) {
/*  66 */       diag = "Fucking gouvernement of asshole.";
/*     */     } 
/*  68 */     panel.openDialogue(new Dialogue(diag, null, end, null));
/*     */   }
/*     */   
/*     */   public static void return_to_player(Panel pan, Camera cam, Player p) {
/*  72 */     int end_y = 0, end_x = 0;
/*  73 */     if (p.getY() > 500)
/*  74 */       end_y = p.getY() - 500; 
/*  75 */     if (p.getX() > 500)
/*  76 */       end_x = p.getX() - 500; 
/*  77 */     if (end_x < 0)
/*  78 */       end_x = 0; 
/*  79 */     if (end_x + cam.getWidth() > cam.getMaxX())
/*  80 */       end_x = cam.getMaxX() - cam.getWidth(); 
/*  81 */     if (end_y < 0)
/*  82 */       end_y = 0; 
/*  83 */     if (end_y + cam.getHeight() > cam.getMaxY())
/*  84 */       end_y = cam.getMaxY() - cam.getHeight(); 
/*  85 */     cam.goTo(end_x, end_y, () -> p.setCanMove(true));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void flic_events(Panel panel, Camera cam, Player p, Cop cop1, Cop cop2, Interactible damien, Interactible damien_mort) {
/*  90 */     p.setCanMove(false);
/*  91 */     cam.goTo(1441, 3495, () -> flic_events_next(panel, cam, p, cop1, cop2, damien, damien_mort));
/*     */   }
/*     */   
/*     */   public static void flic_events_next(Panel pan, Camera cam, Player p, Cop cop1, Cop cop2, Interactible damien, Interactible damien_mort) {
/*  95 */     Runnable[] end = { () -> flash_black_and_sound(pan, cam, p, cop1, cop2, damien, damien_mort) };
/*  96 */     String diag = "";
/*  97 */     if (language == LANGUE.FRENCH) {
/*  98 */       diag = "Flic: \nBah alors connard tu vole une pomme?\n\n\n\nMec:\nMais j'avais vraiment faim...\n\n\n\nFlic:\nOn s'en tape.\nD'ailleurs en parlant de taper.";
/*  99 */     } else if (language == LANGUE.ENGLISH) {
/* 100 */       diag = "Cop: \nSo, you were caught stealing an apple?\n\n\n\nGuy:\nBut I was really hungry...\n\n\n\nCop:\nWe don't give a fuck.\nTalking about fuck.";
/*     */     } 
/* 102 */     pan.openDialogue(new Dialogue(diag, null, end, null));
/*     */   }
/*     */   
/*     */   public static void flash_black_and_sound(Panel pan, Camera cam, Player p, Cop cop1, Cop cop2, Interactible damien, Interactible damien_mort) {
/* 106 */     pan.switch_flash_back();
/* 107 */     SoundPlayer.playSound("tabassage.wav", () -> flash_blakc_ended(pan, cam, p, cop1, cop2, damien, damien_mort));
/*     */   }
/*     */   
/*     */   public static void flash_blakc_ended(Panel pan, Camera cam, Player p, Cop cop1, Cop cop2, Interactible damien, Interactible damien_mort) {
/* 111 */     pan.setShowDamienMort(true);
/* 112 */     pan.setShowDamien(false);
/* 113 */     pan.switch_flash_back();
/* 114 */     Runnable[] end = { () -> cop_go_home(pan, cam, p, cop1, cop2, damien, damien_mort) };
/* 115 */     String diag = "";
/* 116 */     if (language == LANGUE.FRENCH) {
/* 117 */       diag = "Flic:\nAllez. Tu viens avec nous au poste. Connard.";
/* 118 */     } else if (language == LANGUE.ENGLISH) {
/* 119 */       diag = "Cop:\nSo. You're comming with us. Asshole.";
/*     */     } 
/* 121 */     pan.openDialogue(new Dialogue(diag, null, end, null));
/*     */   }
/*     */   
/*     */   public static void cop_go_home(Panel pan, Camera cam, Player p, Cop cop1, Cop cop2, Interactible damien, Interactible damien_mort) {
/* 125 */     cop1.goTo(cop1.getX(), cop1.getY() + 1000, () -> cop_end_event(pan, cam, p));
/* 126 */     cop2.goTo(cop2.getX(), cop2.getY() + 1000, () -> System.out.println());
/* 127 */     damien_mort.goTo(damien_mort.getX(), damien_mort.getY() + 1000);
/*     */   }
/*     */   
/*     */   public static void cop_end_event(Panel pan, Camera cam, Player p) {
/* 131 */     pan.setShowCops(false);
/* 132 */     pan.setShowDamienMort(false);
/* 133 */     return_to_player(pan, cam, p);
/*     */   }
/*     */   
/*     */   public static void set_language(LANGUE lang) {
/* 137 */     language = lang;
/*     */   }
/*     */   
/*     */   public static void png_talk(Panel pan) {
/* 141 */     Random r = new Random();
/* 142 */     String diag = "";
/* 143 */     if (language == LANGUE.FRENCH) {
/* 144 */       diag = random_dialogue_fr[r.nextInt(random_dialogue_fr.length)];
/* 145 */     } else if (language == LANGUE.ENGLISH) {
/* 146 */       diag = random_dialogue_en[r.nextInt(random_dialogue_en.length)];
/*     */     } 
/* 148 */     pan.openDialogue(new Dialogue(diag, null, null, null));
/*     */   }
/*     */   
/*     */   public static void damien_talk(Panel pan) {
/* 152 */     String diag = "";
/* 153 */     if (language == LANGUE.FRENCH) {
/* 154 */       diag = "Ce monde est honteux, on privilègie l'uniformité à l'individualité.\nOn donne l'argent des pauvres aux riches.\nDu coup les pauvres sont encore plus pauvres.\nC'est honteux.\nOn devrait faire quelque chose pour changer ça mais on est capable de rien.\nEn perdant l'individualité on perd la personnalité.\nSoyez tolérant.";
/* 155 */     } else if (language == LANGUE.ENGLISH) {
/* 156 */       diag = "This world is shameful, we privilege uniformity over individuality.\nGive money from the poor to the rich.\nSo the poor are even poorer.\nIt's shameful.\nWe should do something. thing to change that but we are capable of nothing.\nLossing individuality we lose personality.\nBe tolerant.";
/*     */     } 
/* 158 */     pan.openDialogue(new Dialogue(diag, null, null, null));
/*     */   }
/*     */ }


/* Location:              C:\Users\Theo\Downloads\EpiSociety.jar!\fr\epiode\jamutt\Events.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */