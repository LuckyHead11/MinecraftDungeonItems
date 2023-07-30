/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Armor;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Random;
/*    */ import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import org.bukkit.Bukkit;
 import org.bukkit.ChatColor;
 import org.bukkit.Material;
 import org.bukkit.entity.Entity;
 import org.bukkit.entity.Player;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 import org.bukkit.plugin.Plugin;
 import org.bukkit.scheduler.BukkitRunnable;

 public class ember_robe {
   MinecraftDungeonItems plugin;

   public ember_robe(MinecraftDungeonItems plugin) {
     this.plugin = plugin;
   }

   public void start() {
     final Random rand = new Random();
     (new BukkitRunnable()
       {
         public void run()
         {
           for (Player player : Bukkit.getServer().getOnlinePlayers()) {
             ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
             ItemMeta meta = item.getItemMeta();
             meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("armor-names.ember-robe"));
             ArrayList<String> lore = new ArrayList<>();
             lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "When you get near entities they get set on fire!");
             meta.setLore(lore);
             item.setItemMeta(meta);
             if (player.getInventory().getChestplate() != null &&
               player.getInventory().getChestplate().getItemMeta().getLore().equals(item.getItemMeta().getLore())) {
               for (Entity entity : player.getNearbyEntities(2.0D, 2.0D, 2.0D)) {
                 if (entity != null) {
                   int a = rand.nextInt(300);
                   for (; a < 60; a = rand.nextInt(300));
                   entity.setFireTicks(a);
                 }

               }

             }
           }
         }
       }).runTaskTimer((Plugin)this.plugin, 0L, 10L);
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Armor\ember_robe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */