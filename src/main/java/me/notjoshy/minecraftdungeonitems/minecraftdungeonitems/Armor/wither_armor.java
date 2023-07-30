/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Armor;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.entity.WitherSkull;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class wither_armor
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onInteract(PlayerInteractEvent e) {
/* 30 */     ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
/* 31 */     ItemMeta meta = item.getItemMeta();
/* 32 */     meta.setDisplayName(ChatColor.GOLD + "Wither armor");
/* 33 */     ArrayList<String> lore = new ArrayList<>();
/* 34 */     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Shoot wither skulls with a simple click!");
/* 35 */     lore.add(ChatColor.GREEN + "SPECIAL: " + ChatColor.GREEN + "Immune to wither affect");
/* 36 */     meta.setLore(lore);
/* 37 */     item.setItemMeta(meta);
/* 38 */     Player player = e.getPlayer();
/* 39 */     if ((e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && 
/* 40 */       player.getInventory().getChestplate() != null && 
/* 41 */       Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(((ItemStack)Objects.<ItemStack>requireNonNull(e.getPlayer().getInventory().getChestplate())).getItemMeta())).getLore(), item.getItemMeta().getLore())) {
/* 42 */       World world = player.getWorld();
/* 43 */       Location loc = player.getLocation();
/* 44 */       loc.setY(loc.getY() + 2.0D);
/* 45 */       WitherSkull skull = (WitherSkull)world.spawnEntity(loc, EntityType.WITHER_SKULL);
/* 46 */       skull.setCharged(true);
/* 47 */       skull.setVelocity(player.getLocation().getDirection().multiply(3));
/* 48 */       skull.setBounce(true);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Armor\wither_armor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */