/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Particle;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class windhorn implements Listener {
/*    */   @EventHandler
/*    */   public void onInteract(PlayerInteractEvent e) {
/* 23 */     if (e.getAction() == Action.RIGHT_CLICK_AIR) {
/* 24 */       ItemStack item = new ItemStack(Material.FEATHER);
/* 25 */       ItemMeta meta = item.getItemMeta();
/* 26 */       meta.setDisplayName(ChatColor.GOLD + "WindHorn");
/* 27 */       ArrayList<String> lore = new ArrayList<>();
/* 28 */       lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Blows entitys away!");
/* 29 */       meta.setLore(lore);
/* 30 */       item.setItemMeta(meta);
/* 31 */       Player player = e.getPlayer();
/* 32 */       if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())) {
/* 33 */         World world = player.getWorld();
/* 34 */         Location loc = player.getLocation();
/*    */         
/* 36 */         player.playSound(loc, Sound.ITEM_TRIDENT_RIPTIDE_3, 1.0F, 2.0F);
/* 37 */         for (Entity entity : player.getNearbyEntities(10.0D, 10.0D, 10.0D)) {
/* 38 */           entity.setVelocity(player.getLocation().getDirection().multiply(2).setY(1));
/*    */         }
/*    */ 
/*    */         
/* 42 */         world.spawnParticle(Particle.CLOUD, loc, 100, 0.0D, 0.0D, 0.0D);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\windhorn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */