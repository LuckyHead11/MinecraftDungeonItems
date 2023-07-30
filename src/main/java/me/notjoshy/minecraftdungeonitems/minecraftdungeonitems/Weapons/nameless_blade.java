/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Weapons;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ 
/*    */ public class nameless_blade
/*    */   implements Listener {
/*    */   @EventHandler
/*    */   public void onAttack(EntityDamageByEntityEvent e) {
/* 25 */     Random rand = new Random();
/* 26 */     ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
/* 27 */     ItemMeta meta = item.getItemMeta();
/* 28 */     meta.setDisplayName(ChatColor.GOLD + "Nameless Blade");
/* 29 */     ArrayList<String> lore = new ArrayList<>();
/* 30 */     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "On attack, it weakens enemy's!");
/* 31 */     meta.setLore(lore);
/* 32 */     item.setItemMeta(meta);
/* 33 */     if (e.getDamager() instanceof Player) {
/* 34 */       Player player = (Player)e.getDamager();
/* 35 */       if (player.getInventory().getItemInMainHand().lore() != null && 
/* 36 */         Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).lore(), item.getItemMeta().lore())) {
/* 37 */         World world = player.getWorld();
/* 38 */         Entity mainEntity = e.getEntity();
/* 39 */         Location playerLocation = player.getLocation();
/* 40 */         LivingEntity entity = (LivingEntity)e.getEntity();
/* 41 */         entity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 7, true, true, true));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Weapons\nameless_blade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */