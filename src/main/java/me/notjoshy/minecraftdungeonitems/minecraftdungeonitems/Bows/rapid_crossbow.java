/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Bows;

 import java.util.ArrayList;
 import java.util.Objects;

 import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
 import org.bukkit.ChatColor;
 import org.bukkit.GameMode;
 import org.bukkit.Location;
 import org.bukkit.Material;
 import org.bukkit.entity.Arrow;
 import org.bukkit.entity.EntityType;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.block.Action;
 import org.bukkit.event.player.PlayerInteractEvent;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 import org.bukkit.projectiles.ProjectileSource;



 public class rapid_crossbow
   implements Listener
 {

     MinecraftDungeonItems plugin;

     public rapid_crossbow(MinecraftDungeonItems plugin) {
         this.plugin = plugin;
     }
   @EventHandler
   public void interactEvent(PlayerInteractEvent e) {
     if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
       ItemStack item = new ItemStack(Material.CROSSBOW);
       ItemMeta meta = item.getItemMeta();
       meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("bow-names.rapid-crossbow"));
       ArrayList<String> lore = new ArrayList<>();
       lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "There is no delay, unlike a normal bow.");
       lore.add(ChatColor.GOLD + "SPECIAL: " + ChatColor.GREEN + "Does more damage the more health you have!");
       meta.setLore(lore);
       item.setItemMeta(meta);
       Player player = e.getPlayer();

       if (player.getInventory().getItemInMainHand().getLore() != null &&
         Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())) {

         if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
           Location eye = player.getEyeLocation();
           Location loc = eye.add(eye.getDirection().multiply(1.2D));
           Arrow arrow = (Arrow)player.getWorld().spawnEntity(loc, EntityType.ARROW);
           arrow.setVelocity(loc.getDirection().normalize().multiply(2));
           arrow.setShooter((ProjectileSource)player);
         }
         else if (e.getPlayer().getInventory().containsAtLeast(new ItemStack(Material.ARROW), 1)) {
           Location eye = player.getEyeLocation();
           Location loc = eye.add(eye.getDirection().multiply(1.2D));
           Arrow arrow = (Arrow)player.getWorld().spawnEntity(loc, EntityType.ARROW);
           arrow.setVelocity(loc.getDirection().normalize().multiply(2));
           arrow.setShooter((ProjectileSource)player);
           arrow.setDamage(player.getHealth() * 0.5D);
           player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.ARROW, 1) });
         }



         e.setCancelled(true);
       }
     }
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Bows\rapid_crossbow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */