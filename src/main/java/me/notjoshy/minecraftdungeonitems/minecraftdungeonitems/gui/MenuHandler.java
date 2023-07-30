/*     */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.gui;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Objects;
/*     */ import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ 
/*     */ public class MenuHandler
/*     */   implements Listener
/*     */ {
/*     */   MinecraftDungeonItems plugin;
/*     */   
/*     */   public MenuHandler(MinecraftDungeonItems plugin) {
/*  21 */     this.plugin = plugin;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onMenuClick(InventoryClickEvent e) throws IOException {
/*  26 */     Player player = (Player)e.getWhoClicked();
/*  27 */     if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Select")) {
/*  28 */       if (e.getCurrentItem() != null) {
/*  29 */         switch (((ItemStack)Objects.requireNonNull(e.getCurrentItem())).getType()) {
/*     */           case LEATHER_CHESTPLATE:
/*  31 */             this.plugin.armorRarity(player);
/*     */             break;
/*     */           case DIAMOND_SWORD:
/*  34 */             this.plugin.choose(player);
/*     */             break;
/*     */           case POTION:
/*  37 */             this.plugin.artifactRarity(player);
/*     */             break;
/*     */           case REPEATER:
/*  40 */             this.plugin.settings(player);
/*     */             break;
/*     */           case BARRIER:
/*  43 */             player.closeInventory();
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/*     */       }
/*  49 */       e.setCancelled(true);
/*  50 */     } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Food Drops")) {
/*  51 */       if (e.getCurrentItem() != null) {
/*  52 */         switch (e.getCurrentItem().getType()) {
/*     */           case BARRIER:
/*  54 */             this.plugin.settings(player);
/*     */             break;
/*     */           case APPLE:
/*  57 */             if (this.plugin.getConfig().getBoolean("food-drops.drop-food")) {
/*  58 */               this.plugin.getConfig().set("food-drops.drop-food", Boolean.valueOf(false));
/*     */             } else {
/*  60 */               this.plugin.getConfig().set("food-drops.drop-food", Boolean.valueOf(true));
/*     */             } 
/*     */             
/*  63 */             this.plugin.saveConfig();
/*  64 */             this.plugin.FoodDrops(player);
/*     */             break;
/*     */           case ENDER_PEARL:
/*  67 */             if (this.plugin.getConfig().getInt("food-drops.food-amount") >= 10) {
/*  68 */               this.plugin.getConfig().set("food-drops.food-amount", Integer.valueOf(1));
/*     */             } else {
/*  70 */               this.plugin.getConfig().set("food-drops.food-amount", Integer.valueOf(this.plugin.getConfig().getInt("food-drops.food-amount") + 1));
/*     */             } 
/*     */             
/*  73 */             this.plugin.saveConfig();
/*  74 */             this.plugin.FoodDrops(player);
/*     */             break;
/*     */           case ENDER_EYE:
/*  77 */             if (this.plugin.getConfig().getInt("food-drops.food-chance") >= 100) {
/*  78 */               this.plugin.getConfig().set("food-drops.food-chance", Integer.valueOf(25));
/*     */             } else {
/*  80 */               this.plugin.getConfig().set("food-drops.food-chance", Integer.valueOf(this.plugin.getConfig().getInt("food-drops.food-chance") + 25));
/*     */             } 
/*  82 */             this.plugin.saveConfig();
/*  83 */             this.plugin.FoodDrops(player);
/*     */             break;
/*     */         } 
/*     */         
/*  87 */         e.setCancelled(true);
/*     */       }
/*     */     
/*  90 */     } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Potion Drops")) {
/*  91 */       if (e.getCurrentItem() != null) {
/*  92 */         switch (e.getCurrentItem().getType()) {
/*     */           case BARRIER:
/*  94 */             this.plugin.settings(player);
/*     */             break;
/*     */           case POTION:
/*  97 */             if (this.plugin.getConfig().getBoolean("potion-drops.drop-potion")) {
/*  98 */               this.plugin.getConfig().set("potion-drops.drop-potion", Boolean.valueOf(false));
/*     */             } else {
/* 100 */               this.plugin.getConfig().set("potion-drops.drop-potion", Boolean.valueOf(true));
/*     */             } 
/*     */             
/* 103 */             this.plugin.saveConfig();
/* 104 */             this.plugin.PotionDrops(player);
/*     */             break;
/*     */           case ENDER_PEARL:
/* 107 */             if (this.plugin.getConfig().getInt("potion-drops.potion-amount") >= 10) {
/* 108 */               this.plugin.getConfig().set("potion-drops.potion-amount", Integer.valueOf(1));
/*     */             } else {
/* 110 */               this.plugin.getConfig().set("potion-drops.potion-amount", Integer.valueOf(this.plugin.getConfig().getInt("potion-drops.potion-amount") + 1));
/*     */             } 
/*     */             
/* 113 */             this.plugin.saveConfig();
/* 114 */             this.plugin.PotionDrops(player);
/*     */             break;
/*     */           case ENDER_EYE:
/* 117 */             if (this.plugin.getConfig().getInt("potion-drops.potion-chance") >= 100) {
/* 118 */               this.plugin.getConfig().set("potion-drops.potion-chance", Integer.valueOf(25));
/*     */             } else {
/* 120 */               this.plugin.getConfig().set("potion-drops.potion-chance", Integer.valueOf(this.plugin.getConfig().getInt("potion-drops.potion-chance") + 25));
/*     */             } 
/* 122 */             this.plugin.saveConfig();
/* 123 */             this.plugin.PotionDrops(player);
/*     */             break;
/*     */         } 
/*     */         
/* 127 */         e.setCancelled(true);
/*     */       } 
/* 129 */     } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Settings")) {
/* 130 */       if (e.getCurrentItem() != null) {
/* 131 */         switch (e.getCurrentItem().getType()) {
/*     */           case BARRIER:
/* 133 */             this.plugin.typeGUI(player);
/*     */             break;
/*     */           case COMPASS:
/* 136 */             this.plugin.reloadConfig();
/* 137 */             player.sendMessage(ChatColor.DARK_GRAY + "Minecraft Dungeons - " + ChatColor.GREEN + "Done reloading!");
/* 138 */             this.plugin.settings(player);
/*     */             break;
/*     */           case BREAD:
/* 141 */             this.plugin.FoodDrops(player);
/*     */             break;
/*     */           case POTION:
/* 144 */             this.plugin.PotionDrops(player);
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/*     */       }
/* 150 */       e.setCancelled(true);
/* 151 */     } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Choose")) {
/* 152 */       switch (((ItemStack)Objects.requireNonNull(e.getCurrentItem())).getType()) {
/*     */         case BARRIER:
/* 154 */           this.plugin.typeGUI(player);
/*     */           break;
/*     */         case DIAMOND_SWORD:
/* 157 */           this.plugin.weaponRarity(player);
/*     */           break;
/*     */         case BOW:
/* 160 */           this.plugin.bowRarity(player);
/*     */           break;
/*     */       } 
/*     */       
/* 164 */       e.setCancelled(true);
/*     */     } 
/* 166 */     if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Weapon Rarity")) {
/* 167 */       switch (((ItemStack)Objects.requireNonNull(e.getCurrentItem())).getType()) {
/*     */         case BARRIER:
/* 169 */           this.plugin.choose(player);
/*     */           break;
/*     */         case LEATHER_CHESTPLATE:
/* 172 */           this.plugin.commonWeapon(player);
/*     */           break;
/*     */         case DIAMOND_CHESTPLATE:
/* 175 */           this.plugin.rareWeapon(player);
/*     */           break;
/*     */         case NETHERITE_CHESTPLATE:
/* 178 */           this.plugin.uniqueWeapon(player);
/*     */           break;
/*     */       } 
/* 181 */       e.setCancelled(true);
/*     */     } 
/*     */     
/* 184 */     if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "UNIQUE WEAPONS") || e
/* 185 */       .getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "COMMON WEAPONS") || e
/* 186 */       .getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "RARE WEAPONS")) {
/* 187 */       if (((ItemStack)Objects.<ItemStack>requireNonNull(e.getCurrentItem())).getType() == Material.BARRIER) {
/* 188 */         this.plugin.choose(player);
/*     */       }
/* 190 */       if (e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.BARRIER)) {
/* 191 */         e.setCancelled(true);
/*     */       } else {
/* 193 */         player.getInventory().addItem(new ItemStack[] { e.getCurrentItem() });
/* 194 */         e.setCancelled(true);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 201 */     if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Artifact Rarity")) {
/* 202 */       switch (((ItemStack)Objects.requireNonNull(e.getCurrentItem())).getType()) {
/*     */         case BARRIER:
/* 204 */           this.plugin.typeGUI(player);
/*     */           break;
/*     */         case LEATHER_CHESTPLATE:
/* 207 */           this.plugin.commonArtifact(player);
/*     */           break;
/*     */         case DIAMOND_CHESTPLATE:
/* 210 */           this.plugin.rareArtifact(player);
/*     */           break;
/*     */         case NETHERITE_CHESTPLATE:
/* 213 */           this.plugin.uniqueArtifact(player);
/*     */           break;
/*     */       } 
/* 216 */       e.setCancelled(true);
/*     */     } 
/*     */     
/* 219 */     if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "UNIQUE ARTIFACTS") || e
/* 220 */       .getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "COMMON ARTIFACTS") || e
/* 221 */       .getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "RARE ARTIFACTS")) {
/* 222 */       if (((ItemStack)Objects.<ItemStack>requireNonNull(e.getCurrentItem())).getType() == Material.BARRIER) {
/* 223 */         this.plugin.artifactRarity(player);
/*     */       }
/* 225 */       if (e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.BARRIER)) {
/* 226 */         e.setCancelled(true);
/*     */       } else {
/* 228 */         player.getInventory().addItem(new ItemStack[] { e.getCurrentItem() });
/* 229 */         e.setCancelled(true);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 235 */     if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Armor Rarity")) {
/* 236 */       switch (((ItemStack)Objects.requireNonNull(e.getCurrentItem())).getType()) {
/*     */         case BARRIER:
/* 238 */           this.plugin.typeGUI(player);
/*     */           break;
/*     */         case LEATHER_CHESTPLATE:
/* 241 */           this.plugin.commonArmor(player);
/*     */           break;
/*     */         case DIAMOND_CHESTPLATE:
/* 244 */           this.plugin.rareArmor(player);
/*     */           break;
/*     */         case NETHERITE_CHESTPLATE:
/* 247 */           this.plugin.uniqueArmor(player);
/*     */           break;
/*     */       } 
/* 250 */       e.setCancelled(true);
/*     */     } 
/*     */     
/* 253 */     if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "UNIQUE ARMOR") || e
/* 254 */       .getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "COMMON ARMOR") || e
/* 255 */       .getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "RARE ARMOR")) {
/* 256 */       if (((ItemStack)Objects.<ItemStack>requireNonNull(e.getCurrentItem())).getType() == Material.BARRIER) {
/* 257 */         this.plugin.armorRarity(player);
/*     */       }
/* 259 */       if (e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.BARRIER)) {
/* 260 */         e.setCancelled(true);
/*     */       } else {
/* 262 */         player.getInventory().addItem(new ItemStack[] { e.getCurrentItem() });
/* 263 */         e.setCancelled(true);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 269 */     if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Bow Rarity")) {
/* 270 */       switch (((ItemStack)Objects.requireNonNull(e.getCurrentItem())).getType()) {
/*     */         case BARRIER:
/* 272 */           this.plugin.choose(player);
/*     */           break;
/*     */         case LEATHER_CHESTPLATE:
/* 275 */           this.plugin.commonBows(player);
/*     */           break;
/*     */         case DIAMOND_CHESTPLATE:
/* 278 */           this.plugin.rareBows(player);
/*     */           break;
/*     */         case NETHERITE_CHESTPLATE:
/* 281 */           this.plugin.uniqueBows(player);
/*     */           break;
/*     */       } 
/* 284 */       e.setCancelled(true);
/*     */     } 
/*     */ 
/*     */     
/* 288 */     if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "UNIQUE BOWS") || e
/* 289 */       .getView().getTitle().equalsIgnoreCase(ChatColor.GREEN + "COMMON BOWS") || e
/* 290 */       .getView().getTitle().equalsIgnoreCase(ChatColor.DARK_PURPLE + "RARE BOWS")) {
/* 291 */       if (((ItemStack)Objects.<ItemStack>requireNonNull(e.getCurrentItem())).getType() == Material.BARRIER) {
/* 292 */         this.plugin.bowRarity(player);
/*     */       }
/* 294 */       if (!e.getCurrentItem().getType().equals(Material.GRAY_STAINED_GLASS_PANE) && !e.getCurrentItem().getType().equals(Material.BARRIER)) {
/* 295 */         player.getInventory().addItem(new ItemStack[] { e.getCurrentItem() });
/*     */       }
/* 297 */       e.setCancelled(true);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\gui\MenuHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */