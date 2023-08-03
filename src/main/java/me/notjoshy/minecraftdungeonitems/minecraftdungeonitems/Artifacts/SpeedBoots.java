/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import org.bukkit.Bukkit;
 import org.bukkit.ChatColor;
 import org.bukkit.Location;
 import org.bukkit.Material;
 import org.bukkit.World;
 import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 import org.bukkit.plugin.Plugin;
 import org.bukkit.potion.PotionEffect;
 import org.bukkit.potion.PotionEffectType;
 import org.bukkit.scheduler.BukkitRunnable;

 public class SpeedBoots implements Listener {
   public SpeedBoots(MinecraftDungeonItems plugin) {
     this.plugin = plugin;
   }
   MinecraftDungeonItems plugin;
   public void start() {
     (new BukkitRunnable()
       {
         public void run()
         {
           for (Player player : Bukkit.getOnlinePlayers()) {
             ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
             ItemMeta meta = item.getItemMeta();
             meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.speed-boots"));
             ArrayList<String> lore = new ArrayList<>();
             lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Where these to gain speed!");
             meta.setLore(lore);
             item.setItemMeta(meta);

             if (player.getInventory().getBoots() != null)
             {
               if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getBoots().getItemMeta())).getLore(), item.getItemMeta().getLore())) {
                 World world = player.getWorld();
                 Location loc = player.getLocation();


                 player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1, 4, true, false, false));
               }
             }
           }
         }
       }).runTaskTimer((Plugin)this.plugin, 1L, 1L);
   }
     @EventHandler
     public void playerMoveEvent(PlayerMoveEvent e) {

       Player player = e.getPlayer();
       ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
       ItemMeta meta = item.getItemMeta();
       meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.speed-boots"));
       ArrayList<String> lore = new ArrayList<>();
       lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Where these to gain speed!");
       meta.setLore(lore);
       item.setItemMeta(meta);
       try {
           if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getBoots().getItemMeta())).getLore(), item.getItemMeta().getLore())) {
               Boolean bool = plugin.removeEnergy(player, 0.005f);
           }
       } catch (Exception es) {

       }

     }
 }




/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\SpeedBoots.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */