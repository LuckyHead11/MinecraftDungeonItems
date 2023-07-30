/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.potion.PotionEffect;
/*    */ import org.bukkit.potion.PotionEffectType;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ public class SpeedBoots implements Listener {
/*    */   public SpeedBoots(MinecraftDungeonItems plugin) {
/* 21 */     this.plugin = plugin;
/*    */   }
/*    */   MinecraftDungeonItems plugin;
/*    */   public void start() {
/* 25 */     (new BukkitRunnable()
/*    */       {
/*    */         public void run()
/*    */         {
/* 29 */           for (Player player : Bukkit.getOnlinePlayers()) {
/* 30 */             ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
/* 31 */             ItemMeta meta = item.getItemMeta();
/* 32 */             meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.speed-boots"));
/* 33 */             ArrayList<String> lore = new ArrayList<>();
/* 34 */             lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Where these to gain speed!");
/* 35 */             meta.setLore(lore);
/* 36 */             item.setItemMeta(meta);
/*    */             
/* 38 */             if (player.getInventory().getBoots() != null)
/*    */             {
/* 40 */               if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getBoots().getItemMeta())).getLore(), item.getItemMeta().getLore())) {
/* 41 */                 World world = player.getWorld();
/* 42 */                 Location loc = player.getLocation();
/*    */ 
/*    */                 
/* 45 */                 player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1, 3, true, false, false));
/*    */               } 
/*    */             }
/*    */           } 
/*    */         }
/* 50 */       }).runTaskTimer((Plugin)this.plugin, 1L, 1L);
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\SpeedBoots.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */