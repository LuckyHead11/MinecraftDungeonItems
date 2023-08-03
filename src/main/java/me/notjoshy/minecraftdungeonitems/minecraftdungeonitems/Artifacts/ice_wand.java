/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Particle;
/*    */ import org.bukkit.Sound;
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
/*    */ public class ice_wand
/*    */   implements Listener {
/*    */   public ice_wand(MinecraftDungeonItems plugin) {
/* 26 */     this.plugin = plugin;
/*    */   }
/*    */   MinecraftDungeonItems plugin;
/*    */   @EventHandler
/*    */   public void onInteract(PlayerInteractEvent e) {
/* 31 */     if (e.getAction() == Action.RIGHT_CLICK_AIR) {
/* 32 */       Random rand = new Random();
/* 33 */       ItemStack item = new ItemStack(Material.STICK);
/* 34 */       ItemMeta meta = item.getItemMeta();
/* 35 */       meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.ice-wand"));
/* 36 */       ArrayList<String> lore = new ArrayList<>();
/* 37 */       lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Look at a enemy and click! Its now frozen!");
/* 38 */       meta.setLore(lore);
/* 39 */       item.setItemMeta(meta);
/* 40 */       Player player = e.getPlayer();
/* 41 */       if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())&& plugin.removeEnergy(e.getPlayer(), 0.1f)) {
/* 42 */         final LivingEntity entity = (LivingEntity)e.getPlayer().getTargetEntity(100);
/* 43 */         if (entity != null) {
/* 44 */           entity.damage(entity.getHealth() / 2.0D);
/* 45 */           if (entity.getHealth() <= 1.0D) {
/* 46 */             entity.setHealth(0.0D);
/*    */           }
/* 48 */           final Location loc = entity.getLocation();
/* 49 */           entity.setGliding(true);
/* 50 */           loc.getBlock().setType(Material.ICE);
/* 51 */           loc.add(0.0D, 1.0D, 0.0D).getBlock().setType(Material.ICE);
/* 52 */           loc.getWorld().spawnParticle(Particle.CLOUD, loc, 10, 1.0D, 1.0D, 1.0D);
/* 53 */           entity.setAI(false);
/* 54 */           int wait = rand.nextInt(10);
/* 55 */           for (; wait < 3; wait = rand.nextInt(10));
/* 56 */           (new BukkitRunnable()
/*    */             {
/*    */               public void run()
/*    */               {
/* 60 */                 Location loc2 = entity.getLocation();
/* 61 */                 loc2.getBlock().setType(Material.AIR);
/* 62 */                 loc2.add(0.0D, 1.0D, 0.0D).getBlock().setType(Material.AIR);
/* 63 */                 loc.getWorld().spawnParticle(Particle.CLOUD, loc, 10, 1.0D, 1.0D, 1.0D);
/* 64 */                 loc.getWorld().playSound(loc, Sound.ENTITY_CHICKEN_EGG, 1.0F, 1.0F);
/* 65 */                 entity.setAI(true);
/*    */               }
/* 68 */             }).runTaskLater((Plugin)this.plugin, (wait * 20));
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\ice_wand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */