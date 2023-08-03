/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;

 import java.util.ArrayList;
 import java.util.Objects;

 import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
 import org.bukkit.ChatColor;
 import org.bukkit.Location;
 import org.bukkit.Material;
 import org.bukkit.Particle;
 import org.bukkit.Sound;
 import org.bukkit.World;
 import org.bukkit.entity.Entity;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.block.Action;
 import org.bukkit.event.player.PlayerInteractEvent;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;

 public class windhorn implements Listener {
     MinecraftDungeonItems plugin;

     public windhorn(MinecraftDungeonItems plugin) {
         this.plugin = plugin;
     }
   @EventHandler
   public void onInteract(PlayerInteractEvent e) {
     if (e.getAction() == Action.RIGHT_CLICK_AIR) {
       ItemStack item = new ItemStack(Material.FEATHER);
       ItemMeta meta = item.getItemMeta();
       meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.wind-horn"));
       ArrayList<String> lore = new ArrayList<>();
       lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Blows entities away!");
       meta.setLore(lore);
       item.setItemMeta(meta);
       Player player = e.getPlayer();
       if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())) {
           if (this.plugin.removeEnergy(player, 0.1f)) {
               World world = player.getWorld();
               Location loc = player.getLocation();

               player.playSound(loc, Sound.ITEM_TRIDENT_RIPTIDE_3, 1.0F, 2.0F);
               for (Entity entity : player.getNearbyEntities(10.0D, 10.0D, 10.0D)) {
                   entity.setVelocity(player.getLocation().getDirection().multiply(2).setY(1));
               }


               world.spawnParticle(Particle.CLOUD, loc, 100, 0.0D, 0.0D, 0.0D);
           }

       }
     }
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\windhorn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */