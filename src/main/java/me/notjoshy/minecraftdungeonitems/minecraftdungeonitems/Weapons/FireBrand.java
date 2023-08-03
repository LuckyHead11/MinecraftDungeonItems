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

 public class FireBrand implements Listener {
     MinecraftDungeonItems plugin;

     public FireBrand(MinecraftDungeonItems plugin) {
         this.plugin = plugin;
     }
   @EventHandler
   public void attack(EntityDamageByEntityEvent e) {
     ItemStack item = new ItemStack(Material.GOLDEN_AXE);
     ItemMeta meta = item.getItemMeta();
     meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("weapon-names.fire-brand"));
     ArrayList<String> lore = new ArrayList<>();
     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Makes entities catch on fire");
     meta.setLore(lore);
     item.setItemMeta(meta);
     if (e.getDamager() instanceof Player) {
       Player player = (Player)e.getDamager();
       if (player.getInventory().getItemInMainHand().lore() != null &&
         Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).lore(), item.getItemMeta().lore())
               && plugin.removeEnergy(player, 0.1f)) {
         Entity entity = e.getEntity();

         World world = player.getWorld();
         Location loc = entity.getLocation();
         entity.setFireTicks(80);
         world.spawnParticle(Particle.FLAME, loc, 100, -0.1D, -0.1D, -0.1D);
       }
     }
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Weapons\FireBrand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */