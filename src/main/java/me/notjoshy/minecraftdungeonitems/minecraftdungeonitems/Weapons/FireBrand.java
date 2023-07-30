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
/*    */ public class FireBrand implements Listener {
/*    */   @EventHandler
/*    */   public void attack(EntityDamageByEntityEvent e) {
/* 21 */     ItemStack item = new ItemStack(Material.NETHERITE_AXE);
/* 22 */     ItemMeta meta = item.getItemMeta();
/* 23 */     meta.setDisplayName(ChatColor.GOLD + "FireBrand");
/* 24 */     ArrayList<String> lore = new ArrayList<>();
/* 25 */     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Makes entity catch on fire");
/* 26 */     meta.setLore(lore);
/* 27 */     item.setItemMeta(meta);
/* 28 */     if (e.getDamager() instanceof Player) {
/* 29 */       Player player = (Player)e.getDamager();
/* 30 */       if (player.getInventory().getItemInMainHand().lore() != null && 
/* 31 */         Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).lore(), item.getItemMeta().lore())) {
/* 32 */         Entity entity = e.getEntity();
/*    */         
/* 34 */         World world = player.getWorld();
/* 35 */         Location loc = entity.getLocation();
/* 36 */         entity.setFireTicks(80);
/* 37 */         world.spawnParticle(Particle.FLAME, loc, 100, -0.1D, -0.1D, -0.1D);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Weapons\FireBrand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */