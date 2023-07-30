/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Color;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Particle;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.AreaEffectCloud;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class totem_of_regeneration implements Listener {
/*    */   @EventHandler
/*    */   public void onInteract(PlayerInteractEvent e) {
/* 24 */     if (e.getAction() == Action.RIGHT_CLICK_AIR) {
/* 25 */       ItemStack item = new ItemStack(Material.APPLE);
/* 26 */       ItemMeta meta = item.getItemMeta();
/* 27 */       meta.setDisplayName(ChatColor.GOLD + "Totem of Regeneration");
/* 28 */       ArrayList<String> lore = new ArrayList<>();
/* 29 */       lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns a regenerationPad");
/* 30 */       meta.setLore(lore);
/* 31 */       item.setItemMeta(meta);
/* 32 */       Player player = e.getPlayer();
/* 33 */       if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore()) && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
/* 34 */         player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_DRINK, 1.0F, 1.0F);
/* 35 */         spawnPad(e.getClickedBlock().getLocation().add(0.5D, 1.1D, 0.5D));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void spawnPad(Location loc) {
/* 42 */     AreaEffectCloud pad = (AreaEffectCloud)loc.getWorld().spawnEntity(loc, EntityType.AREA_EFFECT_CLOUD);
/* 43 */     pad.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 5, 1), false);
/* 44 */     pad.setRadius(3.0F);
/* 45 */     pad.setDuration(200);
/* 46 */     pad.setCustomName("BouncePad");
/* 47 */     pad.setCustomNameVisible(false);
/* 48 */     pad.setParticle(Particle.REDSTONE, new Particle.DustOptions(Color.RED, 1.0F));
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\totem_of_regeneration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */