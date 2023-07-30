/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Weapons;

 import java.util.ArrayList;
 import java.util.Objects;

 import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
 import org.bukkit.ChatColor;
 import org.bukkit.Location;
 import org.bukkit.Material;
 import org.bukkit.Particle;
 import org.bukkit.World;
 import org.bukkit.entity.Entity;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.entity.EntityDamageByEntityEvent;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;

 public class StormLander
   implements Listener {

     MinecraftDungeonItems plugin;

     public StormLander(MinecraftDungeonItems plugin) {
         this.plugin = plugin;
     }
   @EventHandler
   public void playerAttack(EntityDamageByEntityEvent e) {
     ItemStack item = new ItemStack(Material.NETHERITE_AXE);
     ItemMeta meta = item.getItemMeta();
     meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("weapon-names.storm-lander"));
     ArrayList<String> lore = new ArrayList<>();
     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns lightning on entity attack");
     meta.setLore(lore);
     item.setItemMeta(meta);
     if (e.getDamager() instanceof Player) {
       Player player = (Player)e.getDamager();
       if (player.getInventory().getItemInMainHand().lore() != null &&
         Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).lore(), item.getItemMeta().lore())) {
         Entity entity = e.getEntity();
         World world = player.getWorld();
         Location loc = entity.getLocation();
         world.strikeLightning(loc); world.spawnParticle(Particle.PORTAL, loc, 400, 1.0D, 1.0D, 1.0D);
       }
     }
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Weapons\StormLander.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */