/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.block.BlockPlaceEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class lightning_rod
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onInteract(PlayerInteractEvent e) {
/* 26 */     Player player = e.getPlayer();
/* 27 */     if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
/*    */       
/* 29 */       ItemStack item = new ItemStack(Material.END_ROD);
/* 30 */       ItemMeta meta = item.getItemMeta();
/* 31 */       meta.setDisplayName(ChatColor.GOLD + "Lightning Staff");
/* 32 */       ArrayList<String> lore = new ArrayList<>();
/* 33 */       lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns lightning wherever you look!");
/* 34 */       meta.setLore(lore);
/* 35 */       item.setItemMeta(meta);
/* 36 */       if (e.getAction().equals(Action.RIGHT_CLICK_AIR) && 
/* 37 */         Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())) {
/* 38 */         Location loc = player.getLocation();
/* 39 */         World world = player.getWorld();
/* 40 */         Block block = player.getTargetBlockExact(50);
/* 41 */         Location blockLoc = block.getLocation();
/* 42 */         blockLoc.setY(blockLoc.getY() + 1.0D);
/* 43 */         world.strikeLightning(blockLoc);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onPlace(BlockPlaceEvent e) {
/* 55 */     ItemStack item = new ItemStack(Material.END_ROD);
/* 56 */     ItemMeta meta = item.getItemMeta();
/* 57 */     meta.setDisplayName(ChatColor.GOLD + "Lightning Rod");
/* 58 */     ArrayList<String> lore = new ArrayList<>();
/* 59 */     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns lightning wherever you look!");
/* 60 */     meta.setLore(lore);
/* 61 */     item.setItemMeta(meta);
/* 62 */     Player player = e.getPlayer();
/* 63 */     if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore()))
/* 64 */       e.setCancelled(true); 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\lightning_rod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */