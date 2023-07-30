/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Particle;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class LightFeather implements Listener {
/*    */   @EventHandler
/*    */   public void onInteract(PlayerInteractEvent e) {
/* 21 */     ItemStack item = new ItemStack(Material.FEATHER);
/* 22 */     ItemMeta meta = item.getItemMeta();
/* 23 */     meta.setDisplayName(ChatColor.GOLD + "LightFeather");
/* 24 */     ArrayList<String> lore = new ArrayList<>();
/* 25 */     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Boosts you up!");
/* 26 */     meta.setLore(lore);
/* 27 */     item.setItemMeta(meta);
/* 28 */     Player player = e.getPlayer();
/* 29 */     if (e.getAction().equals(Action.RIGHT_CLICK_AIR) && 
/* 30 */       Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())) {
/* 31 */       World world = player.getWorld();
/*    */       
/* 33 */       player.setVelocity(player.getLocation().getDirection().multiply(2));
/* 34 */       Location loc = player.getLocation();
/* 35 */       world.spawnParticle(Particle.CLOUD, loc, 50, 0.0D, 0.0D, 0.0D);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\LightFeather.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */