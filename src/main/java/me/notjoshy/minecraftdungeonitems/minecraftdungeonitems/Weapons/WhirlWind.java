/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Weapons;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Particle;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class WhirlWind implements Listener {
/*    */   @EventHandler
/*    */   public void onAttack(EntityDamageByEntityEvent e) {
/* 23 */     Random rand = new Random();
/* 24 */     ItemStack item = new ItemStack(Material.NETHERITE_AXE);
/* 25 */     ItemMeta meta = item.getItemMeta();
/* 26 */     meta.setDisplayName(ChatColor.GOLD + "WhirlWind");
/* 27 */     ArrayList<String> lore = new ArrayList<>();
/* 28 */     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Super super super super POWERFUL weapon");
/* 29 */     meta.setLore(lore);
/* 30 */     item.setItemMeta(meta);
/* 31 */     if (e.getDamager() instanceof Player) {
/* 32 */       Player player = (Player)e.getDamager();
/* 33 */       if (player.getInventory().getItemInMainHand().lore() != null && 
/* 34 */         Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).lore(), item.getItemMeta().lore())) {
/* 35 */         World world = player.getWorld();
/* 36 */         Entity mainEntity = e.getEntity();
/* 37 */         Location playerLocation = player.getLocation();
/* 38 */         for (LivingEntity entity : playerLocation.getNearbyLivingEntities(5.0D, 5.0D, 5.0D)) {
/* 39 */           if (entity.getType().equals(mainEntity.getType())) {
/* 40 */             Location loca = entity.getLocation();
/* 41 */             entity.setVelocity(player.getLocation().getDirection().multiply(2).setY(1));
/* 42 */             world.spawnParticle(Particle.CLOUD, loca, 10, 0.0D, 0.0D, 0.0D);
/* 43 */             int damage = rand.nextInt(7);
/* 44 */             for (; damage < 3; damage = rand.nextInt(7));
/* 45 */             entity.damage(damage);
/*    */           } 
/* 47 */           Location playerLocation2 = player.getLocation();
/* 48 */           for (LivingEntity entity2 : playerLocation2.getNearbyLivingEntities(5.0D, 5.0D, 5.0D)) {
/*    */             
/* 50 */             if (entity2.getType().equals(mainEntity.getType())) {
/* 51 */               Location loc = entity2.getLocation();
/* 52 */               entity2.setVelocity(player.getLocation().getDirection().multiply(2).setY(1));
/* 53 */               world.spawnParticle(Particle.CLOUD, loc, 10, 0.0D, 0.0D, 0.0D);
/* 54 */               int damage = rand.nextInt(7);
/* 55 */               for (; damage < 3; damage = rand.nextInt(7));
/* 56 */               entity.damage(damage);
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Weapons\WhirlWind.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */