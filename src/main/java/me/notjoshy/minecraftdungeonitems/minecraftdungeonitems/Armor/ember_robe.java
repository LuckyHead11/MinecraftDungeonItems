/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Armor;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Random;
/*    */ import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ public class ember_robe {
/*    */   MinecraftDungeonItems plugin;
/*    */   
/*    */   public ember_robe(MinecraftDungeonItems plugin) {
/* 20 */     this.plugin = plugin;
/*    */   }
/*    */   
/*    */   public void start() {
/* 24 */     final Random rand = new Random();
/* 25 */     (new BukkitRunnable()
/*    */       {
/*    */         public void run()
/*    */         {
/* 29 */           for (Player player : Bukkit.getServer().getOnlinePlayers()) {
/* 30 */             ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
/* 31 */             ItemMeta meta = item.getItemMeta();
/* 32 */             meta.setDisplayName(ChatColor.GOLD + "Ember Robe");
/* 33 */             ArrayList<String> lore = new ArrayList<>();
/* 34 */             lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "When you get near entities they get set on fire!");
/* 35 */             meta.setLore(lore);
/* 36 */             item.setItemMeta(meta);
/* 37 */             if (player.getInventory().getChestplate() != null && 
/* 38 */               player.getInventory().getChestplate().getItemMeta().getLore().equals(item.getItemMeta().getLore())) {
/* 39 */               for (Entity entity : player.getNearbyEntities(2.0D, 2.0D, 2.0D)) {
/* 40 */                 if (entity != null) {
/* 41 */                   int a = rand.nextInt(300);
/* 42 */                   for (; a < 60; a = rand.nextInt(300));
/* 43 */                   entity.setFireTicks(a);
/*    */                 }
/*    */               
/*    */               }
/*    */             
/*    */             }
/*    */           } 
/*    */         }
/* 51 */       }).runTaskTimer((Plugin)this.plugin, 0L, 10L);
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Armor\ember_robe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */