/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;

 import java.util.ArrayList;
 import java.util.Objects;

 import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
 import org.bukkit.ChatColor;
 import org.bukkit.Location;
 import org.bukkit.Material;
 import org.bukkit.Particle;
 import org.bukkit.World;
 import org.bukkit.block.Block;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.block.Action;
 import org.bukkit.event.player.PlayerInteractEvent;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;

 public class LightFeather implements Listener {
     MinecraftDungeonItems plugin;

     public LightFeather(MinecraftDungeonItems plugin) {
         this.plugin = plugin;
     }
   @EventHandler
   public void onInteract(PlayerInteractEvent e) {
     ItemStack item = new ItemStack(Material.FEATHER);
     ItemMeta meta = item.getItemMeta();
     meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.light-feather"));
     ArrayList<String> lore = new ArrayList<>();
     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Boosts you in the direction you're looking.");
     meta.setLore(lore);
     item.setItemMeta(meta);
     Player player = e.getPlayer();
     if (e.getAction().equals(Action.RIGHT_CLICK_AIR) &&
       Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())) {
       World world = player.getWorld();
       Location new_loc = player.getLocation();
       new_loc.setY(new_loc.getY()-1);
       if (new_loc.getBlock().getType() != Material.AIR) {
           player.setVelocity(player.getLocation().getDirection().multiply(2));
           Location loc = player.getLocation();


           world.spawnParticle(Particle.CLOUD, loc, 50, 0.0D, 0.0D, 0.0D);
       }

     }
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\LightFeather.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */