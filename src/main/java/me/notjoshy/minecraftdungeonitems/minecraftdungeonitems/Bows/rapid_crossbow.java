/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Bows;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.GameMode;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Arrow;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.projectiles.ProjectileSource;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class rapid_crossbow
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void interactEvent(PlayerInteractEvent e) {
/* 27 */     if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
/* 28 */       ItemStack item = new ItemStack(Material.CROSSBOW);
/* 29 */       ItemMeta meta = item.getItemMeta();
/* 30 */       meta.setDisplayName(ChatColor.GOLD + "Rapid Crossbow");
/* 31 */       ArrayList<String> lore = new ArrayList<>();
/* 32 */       lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Shoot like crazy!");
/* 33 */       lore.add(ChatColor.GOLD + "SPECIAL: " + ChatColor.GREEN + "Does more damage the more health you have!");
/* 34 */       meta.setLore(lore);
/* 35 */       item.setItemMeta(meta);
/* 36 */       Player player = e.getPlayer();
/*    */       
/* 38 */       if (player.getInventory().getItemInMainHand().getLore() != null && 
/* 39 */         Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())) {
/*    */         
/* 41 */         if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
/* 42 */           Location eye = player.getEyeLocation();
/* 43 */           Location loc = eye.add(eye.getDirection().multiply(1.2D));
/* 44 */           Arrow arrow = (Arrow)player.getWorld().spawnEntity(loc, EntityType.ARROW);
/* 45 */           arrow.setVelocity(loc.getDirection().normalize().multiply(2));
/* 46 */           arrow.setShooter((ProjectileSource)player);
/*    */         }
/* 48 */         else if (e.getPlayer().getInventory().containsAtLeast(new ItemStack(Material.ARROW), 1)) {
/* 49 */           Location eye = player.getEyeLocation();
/* 50 */           Location loc = eye.add(eye.getDirection().multiply(1.2D));
/* 51 */           Arrow arrow = (Arrow)player.getWorld().spawnEntity(loc, EntityType.ARROW);
/* 52 */           arrow.setVelocity(loc.getDirection().normalize().multiply(2));
/* 53 */           arrow.setShooter((ProjectileSource)player);
/* 54 */           arrow.setDamage(player.getHealth() * 1.2D);
/* 55 */           player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.ARROW, 1) });
/*    */         } 
/*    */ 
/*    */ 
/*    */         
/* 60 */         e.setCancelled(true);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Bows\rapid_crossbow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */