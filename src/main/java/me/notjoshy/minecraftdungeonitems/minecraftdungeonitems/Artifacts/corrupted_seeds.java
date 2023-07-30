/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Color;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Particle;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.AreaEffectCloud;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class corrupted_seeds
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onInteract(PlayerInteractEvent e) {
/* 29 */     if (e.getAction() == Action.RIGHT_CLICK_AIR) {
/* 30 */       ItemStack item = new ItemStack(Material.POTION);
/* 31 */       ItemMeta meta = item.getItemMeta();
/* 32 */       meta.setDisplayName(ChatColor.GOLD + "Corrupted Seeds");
/* 33 */       ArrayList<String> lore = new ArrayList<>();
/* 34 */       lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns a poison cloud!");
/*    */       
/* 36 */       meta.setLore(lore);
/* 37 */       item.setItemMeta(meta);
/* 38 */       Player player = e.getPlayer();
/* 39 */       if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore()))
/*    */       {
/* 41 */         if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
/* 42 */           player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1.0F, 1.0F);
/* 43 */           spawnPad(((Block)Objects.<Block>requireNonNull(e.getClickedBlock())).getLocation().add(0.5D, 1.1D, 0.5D));
/*    */         } 
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void spawnPad(Location loc) {
/* 51 */     AreaEffectCloud pad = (AreaEffectCloud)loc.getWorld().spawnEntity(loc, EntityType.AREA_EFFECT_CLOUD);
/* 52 */     pad.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 200, 1), false);
/* 53 */     pad.setRadius(5.0F);
/* 54 */     pad.setDuration(200);
/* 55 */     pad.setCustomName("BouncePad");
/* 56 */     pad.setCustomNameVisible(false);
/* 57 */     pad.setParticle(Particle.REDSTONE, new Particle.DustOptions(Color.GREEN, 1.0F));
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\corrupted_seeds.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */