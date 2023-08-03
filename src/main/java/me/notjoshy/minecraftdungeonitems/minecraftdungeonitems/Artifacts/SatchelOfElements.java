/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Particle;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ public class SatchelOfElements implements Listener {
/*    */   public SatchelOfElements(MinecraftDungeonItems plugin) {
/* 26 */     this.plugin = plugin;
/*    */   }
/*    */   MinecraftDungeonItems plugin;
/*    */   @EventHandler
/*    */   public void onInteract(PlayerInteractEvent e) {
/* 31 */     Random rand = new Random();
/* 32 */     ItemStack item = new ItemStack(Material.POTION);
/* 33 */     ItemMeta meta = item.getItemMeta();
/* 34 */     meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.satchel-of-elements"));
/* 35 */     ArrayList<String> lore = new ArrayList<>();
/* 36 */     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Has a change to lightning or setFire to mobs!");
/* 37 */     meta.setLore(lore);
/* 38 */     item.setItemMeta(meta);
/* 39 */     Player player = e.getPlayer();
/*    */
/* 41 */     if (e.getAction().equals(Action.RIGHT_CLICK_AIR) && 
/* 42 */       Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())&& plugin.removeEnergy(e.getPlayer(), 0.1f)) {
/* 43 */       World world = player.getWorld();
/* 44 */       int random = rand.nextInt(3);
/* 45 */       if (random == 0) {
/* 46 */         for (Entity entity : player.getNearbyEntities(10.0D, 10.0D, 10.0D)) {
/* 47 */           Location locer = entity.getLocation();
/* 48 */           locer.setY(locer.getY() + 1.0D);
/* 49 */           world.strikeLightning(locer);
/*    */         } 
/* 51 */       } else if (random == 1) {
/* 52 */         for (Entity entity : player.getNearbyEntities(10.0D, 10.0D, 10.0D)) {
/* 53 */           int longer = rand.nextInt(300);
/* 54 */           for (; longer < 100; longer = rand.nextInt(300));
/* 55 */           entity.setFireTicks(longer);
/*    */         } 
/*    */       } else {
/* 58 */         for (LivingEntity entity : player.getLocation().getNearbyLivingEntities(10.0D, 10.0D, 10.0D)) {
/* 59 */           if (entity != null && !Objects.equals(entity.getCustomName(), player.getCustomName())) {
/* 60 */             entity.damage(entity.getHealth() / 2.0D);
/* 61 */             if (entity.getHealth() <= 1.0D) {
/* 62 */               entity.setHealth(0.0D);
/*    */             }
/* 64 */             final Location loc = entity.getLocation();
/* 65 */             entity.setGliding(true);
/* 66 */             loc.getBlock().setType(Material.ICE);
/* 67 */             loc.add(0.0D, 1.0D, 0.0D).getBlock().setType(Material.ICE);
/* 68 */             loc.getWorld().spawnParticle(Particle.CLOUD, loc, 10, 1.0D, 1.0D, 1.0D);
/* 69 */             entity.setAI(false);
/* 70 */             int wait = rand.nextInt(10);
/* 71 */             for (; wait < 3; wait = rand.nextInt(10));
/* 72 */             (new BukkitRunnable()
/*    */               {
/*    */                 public void run()
/*    */                 {
/* 76 */                   Location loc2 = entity.getLocation();
/* 77 */                   loc2.getBlock().setType(Material.AIR);
/* 78 */                   loc2.add(0.0D, 1.0D, 0.0D).getBlock().setType(Material.AIR);
/* 79 */                   loc.getWorld().spawnParticle(Particle.CLOUD, loc, 10, 1.0D, 1.0D, 1.0D);
/* 80 */                   loc.getWorld().playSound(loc, Sound.ENTITY_CHICKEN_EGG, 1.0F, 1.0F);
/* 81 */                   entity.setAI(true);
/*    */                 }
/* 84 */               }).runTaskLater((Plugin)this.plugin, (wait * 20));
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\SatchelOfElements.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */