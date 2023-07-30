/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;

 import java.util.ArrayList;
 import java.util.Objects;

 import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
 import org.bukkit.*;
 import org.bukkit.block.Block;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.block.Action;
 import org.bukkit.event.block.BlockPlaceEvent;
 import org.bukkit.event.player.PlayerInteractEvent;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;



 public class lightning_rod
   implements Listener
 {
     MinecraftDungeonItems plugin;

     public lightning_rod(MinecraftDungeonItems plugin) {
         this.plugin = plugin;
     }
   @EventHandler
   public void onInteract(PlayerInteractEvent e) {
     Player player = e.getPlayer();
     if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {

       ItemStack item = new ItemStack(Material.END_ROD);
       ItemMeta meta = item.getItemMeta();
       meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.lighting-rod"));
       ArrayList<String> lore = new ArrayList<>();
       lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns lightning wherever you look!");
       meta.setLore(lore);
       item.setItemMeta(meta);
       try {
           if (e.getAction().equals(Action.RIGHT_CLICK_AIR) &&
                   Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())) {
               Location loc = player.getLocation();
               World world = player.getWorld();
               Block block = player.getTargetBlockExact(50);
               Location blockLoc = block.getLocation();
               blockLoc.setY(blockLoc.getY() + 1.0D);
               world.strikeLightning(blockLoc);
           }
       } catch(Exception a) {
           player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 0.25F, 1.0F);
       }

     }
   }






   @EventHandler
   public void onPlace(BlockPlaceEvent e) {
     ItemStack item = new ItemStack(Material.END_ROD);
     ItemMeta meta = item.getItemMeta();
     meta.setDisplayName(ChatColor.GOLD + "Lightning Rod");
     ArrayList<String> lore = new ArrayList<>();
     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns lightning wherever you look!");
     meta.setLore(lore);
     item.setItemMeta(meta);
     Player player = e.getPlayer();
     if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore()))
       e.setCancelled(true);
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\lightning_rod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */