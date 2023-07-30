 package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Armor;

 import java.util.ArrayList;
 import java.util.Objects;

 import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
 import org.bukkit.ChatColor;
 import org.bukkit.Location;
 import org.bukkit.Material;
 import org.bukkit.World;
 import org.bukkit.entity.EntityType;
 import org.bukkit.entity.Player;
 import org.bukkit.entity.WitherSkull;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.block.Action;
 import org.bukkit.event.player.PlayerInteractEvent;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;







 public class wither_armor
   implements Listener
 {
     MinecraftDungeonItems plugin;

     public wither_armor(MinecraftDungeonItems plugin) {
         this.plugin = plugin;
     }
   @EventHandler
   public void onInteract(PlayerInteractEvent e) {
     ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
     ItemMeta meta = item.getItemMeta();
     meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("armor-names.wither_armor"));
     ArrayList<String> lore = new ArrayList<>();
     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Shoot wither skulls with a simple click!");
     lore.add(ChatColor.GREEN + "SPECIAL: " + ChatColor.GREEN + "Immune to wither affect");
     meta.setLore(lore);
     item.setItemMeta(meta);
     Player player = e.getPlayer();
     if ((e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) &&
       player.getInventory().getChestplate() != null &&
       Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(((ItemStack)Objects.<ItemStack>requireNonNull(e.getPlayer().getInventory().getChestplate())).getItemMeta())).getLore(), item.getItemMeta().getLore())) {
       World world = player.getWorld();
       Location loc = player.getLocation();
       loc.setY(loc.getY() + 2.0D);
       WitherSkull skull = (WitherSkull)world.spawnEntity(loc, EntityType.WITHER_SKULL);
       skull.setCharged(true);
       skull.setVelocity(player.getLocation().getDirection().multiply(3));
       skull.setBounce(true);
     }
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Armor\wither_armor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */