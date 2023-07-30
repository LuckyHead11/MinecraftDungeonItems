/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Color;
/*    */ import org.bukkit.FireworkEffect;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.Firework;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.FireworkMeta;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class FireWorkArrow implements Listener {
/*    */   @EventHandler
/*    */   public void onInteract(PlayerInteractEvent e) {
/* 23 */     ItemStack item = new ItemStack(Material.FIREWORK_ROCKET);
/* 24 */     ItemMeta meta = item.getItemMeta();
/* 25 */     meta.setDisplayName(ChatColor.GOLD + "Firework arrows");
/* 26 */     ArrayList<String> lore = new ArrayList<>();
/* 27 */     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Shoots out fireworks!");
/* 28 */     meta.setLore(lore);
/* 29 */     item.setItemMeta(meta);
/* 30 */     if (e.getAction().equals(Action.RIGHT_CLICK_AIR) && 
/* 31 */       Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(((ItemStack)Objects.<ItemStack>requireNonNull(e.getItem())).getItemMeta())).getLore(), item.getItemMeta().getLore())) {
/* 32 */       Player player = e.getPlayer();
/* 33 */       Firework firework = (Firework)player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
/* 34 */       FireworkMeta fireworkMeta = firework.getFireworkMeta();
/* 35 */       fireworkMeta.setPower(50);
/* 36 */       firework.setShotAtAngle(true);
/* 37 */       Location loc = firework.getLocation();
/* 38 */       loc.setY(loc.getY() + 2.0D);
/* 39 */       firework.teleport(loc);
/*    */ 
/*    */       
/* 42 */       fireworkMeta.addEffects(new FireworkEffect[] {
/* 43 */             FireworkEffect.builder()
/* 44 */             .withColor(Color.AQUA)
/* 45 */             .withColor(Color.RED)
/* 46 */             .withColor(Color.ORANGE)
/* 47 */             .withColor(Color.LIME)
/* 48 */             .withColor(Color.BLUE)
/*    */             
/* 50 */             .trail(true)
/* 51 */             .with(FireworkEffect.Type.BALL).build() });
/* 52 */       firework.setFireworkMeta(fireworkMeta);
/* 53 */       firework.setVelocity(player.getLocation().getDirection().multiply(1));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\FireWorkArrow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */