/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
 import java.util.ArrayList;
 import java.util.Objects;

 import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
 import org.bukkit.ChatColor;
 import org.bukkit.Color;
 import org.bukkit.FireworkEffect;
 import org.bukkit.Location;
 import org.bukkit.Material;
 import org.bukkit.entity.EntityType;
 import org.bukkit.entity.Firework;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.block.Action;
 import org.bukkit.event.player.PlayerInteractEvent;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.FireworkMeta;
 import org.bukkit.inventory.meta.ItemMeta;

 public class FireWorkArrow implements Listener {
     MinecraftDungeonItems plugin;

     public FireWorkArrow(MinecraftDungeonItems plugin) {
         this.plugin = plugin;
     }
   @EventHandler
   public void onInteract(PlayerInteractEvent e) {
     ItemStack item = new ItemStack(Material.FIREWORK_ROCKET);
     ItemMeta meta = item.getItemMeta();
     meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.fire-work-arrow"));
     ArrayList<String> lore = new ArrayList<>();
     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Shoots out fireworks!");
     meta.setLore(lore);
     item.setItemMeta(meta);
     if (e.getAction().equals(Action.RIGHT_CLICK_AIR) &&
       Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(((ItemStack)Objects.<ItemStack>requireNonNull(e.getItem())).getItemMeta())).getLore(), item.getItemMeta().getLore())
     && plugin.removeEnergy(e.getPlayer(), 0.1f)) {
       Player player = e.getPlayer();
       Firework firework = (Firework)player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
       FireworkMeta fireworkMeta = firework.getFireworkMeta();
       fireworkMeta.setPower(50);
       firework.setShotAtAngle(true);
       Location loc = firework.getLocation();
       loc.setY(loc.getY() + 2.0D);
       firework.teleport(loc);


       fireworkMeta.addEffects(new FireworkEffect[] {
             FireworkEffect.builder()
             .withColor(Color.AQUA)
             .withColor(Color.RED)
             .withColor(Color.ORANGE)
             .withColor(Color.LIME)
             .withColor(Color.BLUE)

             .trail(true)
             .with(FireworkEffect.Type.BALL).build() });
       firework.setFireworkMeta(fireworkMeta);
       firework.setVelocity(player.getLocation().getDirection().multiply(1));
     }
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\FireWorkArrow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */