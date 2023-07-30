/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Weapons;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Particle;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class StormLander
/*    */   implements Listener {
/*    */   @EventHandler
/*    */   public void playerAttack(EntityDamageByEntityEvent e) {
/* 22 */     ItemStack item = new ItemStack(Material.NETHERITE_AXE);
/* 23 */     ItemMeta meta = item.getItemMeta();
/* 24 */     meta.setDisplayName(ChatColor.GOLD + "StormLander");
/* 25 */     ArrayList<String> lore = new ArrayList<>();
/* 26 */     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns lightning on entity attack");
/* 27 */     meta.setLore(lore);
/* 28 */     item.setItemMeta(meta);
/* 29 */     if (e.getDamager() instanceof Player) {
/* 30 */       Player player = (Player)e.getDamager();
/* 31 */       if (player.getInventory().getItemInMainHand().lore() != null && 
/* 32 */         Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).lore(), item.getItemMeta().lore())) {
/* 33 */         Entity entity = e.getEntity();
/* 34 */         World world = player.getWorld();
/* 35 */         Location loc = entity.getLocation();
/* 36 */         world.strikeLightning(loc); world.spawnParticle(Particle.PORTAL, loc, 400, 1.0D, 1.0D, 1.0D);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Weapons\StormLander.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */