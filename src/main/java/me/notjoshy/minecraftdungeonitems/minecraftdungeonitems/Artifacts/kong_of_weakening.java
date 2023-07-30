/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.*;
/*    */
/*    */
/*    */
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.block.BlockPlaceEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class kong_of_weakening implements Listener {
/*    */   @EventHandler
/*    */   public void onInteract(PlayerInteractEvent e) {
/* 23 */     Player player = e.getPlayer();
/* 24 */     if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
/*    */       
/* 26 */       ItemStack item = new ItemStack(Material.BELL);
/* 27 */       ItemMeta meta = item.getItemMeta();
/* 28 */       meta.setDisplayName(ChatColor.GOLD + "Kong of weakening");
/* 29 */       ArrayList<String> lore = new ArrayList<>();
/* 30 */       lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Weakens nearby enemys!");
/* 31 */       meta.setLore(lore);
/* 32 */       item.setItemMeta(meta);
/*    */       
/* 34 */       if (e.getAction().equals(Action.RIGHT_CLICK_AIR) && 
/* 35 */         Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())) {
/* 36 */         Location loc = player.getLocation();
/* 37 */         World world = player.getWorld();
/* 38 */         player.playSound(player.getLocation(), Sound.BLOCK_BELL_USE, 1.0F, 1.0F);
/*    */         
/* 40 */         for (LivingEntity entity : loc.getNearbyLivingEntities(7.0D, 7.0D, 7.0D)) {
/* 41 */           if (entity != player) {
/* 42 */             entity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 2, false, false, false));
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onPlace(BlockPlaceEvent e) {
/* 58 */     ItemStack item = new ItemStack(Material.BELL);
/* 59 */     ItemMeta meta = item.getItemMeta();
/* 60 */     meta.setDisplayName(ChatColor.GOLD + "Kong of weakening");
/* 61 */     ArrayList<String> lore = new ArrayList<>();
/* 62 */     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Weakens nearby enemys!");
/* 63 */     meta.setLore(lore);
/* 64 */     item.setItemMeta(meta);
/* 65 */     Player player = e.getPlayer();
/* 66 */     if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore()))
/* 67 */       e.setCancelled(true); 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\kong_of_weakening.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */