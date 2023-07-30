/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
 import java.util.ArrayList;
 import java.util.Objects;

 import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
 import org.bukkit.*;



 import org.bukkit.entity.LivingEntity;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.block.Action;
 import org.bukkit.event.block.BlockPlaceEvent;
 import org.bukkit.event.player.PlayerInteractEvent;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 import org.bukkit.potion.PotionEffect;
 import org.bukkit.potion.PotionEffectType;

 public class kong_of_weakening implements Listener {
     MinecraftDungeonItems plugin;

     public kong_of_weakening(MinecraftDungeonItems plugin) {
         this.plugin = plugin;
     }
   @EventHandler
   public void onInteract(PlayerInteractEvent e) {
     Player player = e.getPlayer();
     if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {

       ItemStack item = new ItemStack(Material.BELL);
       ItemMeta meta = item.getItemMeta();
       meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.kong-of-weakening"));
       ArrayList<String> lore = new ArrayList<>();
       lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Weakens nearby enemys!");
       meta.setLore(lore);
       item.setItemMeta(meta);

       if (e.getAction().equals(Action.RIGHT_CLICK_AIR) &&
         Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())) {
         Location loc = player.getLocation();
         World world = player.getWorld();
         player.playSound(player.getLocation(), Sound.BLOCK_BELL_USE, 1.0F, 1.0F);

         for (LivingEntity entity : loc.getNearbyLivingEntities(7.0D, 7.0D, 7.0D)) {
           if (entity != player) {
             entity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 2, false, false, false));
           }
         }
       }
     }
   }








   @EventHandler
   public void onPlace(BlockPlaceEvent e) {
     ItemStack item = new ItemStack(Material.BELL);
     ItemMeta meta = item.getItemMeta();
     meta.setDisplayName(ChatColor.GOLD + "Kong of weakening");
     ArrayList<String> lore = new ArrayList<>();
     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Weakens nearby enemys!");
     meta.setLore(lore);
     item.setItemMeta(meta);
     Player player = e.getPlayer();
     if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore()))
       e.setCancelled(true);
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\kong_of_weakening.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */