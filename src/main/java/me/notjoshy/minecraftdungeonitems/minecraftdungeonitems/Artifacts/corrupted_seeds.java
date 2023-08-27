/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;

 import java.util.ArrayList;
 import java.util.Objects;

 import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
 import org.bukkit.*;
 import org.bukkit.block.Block;
 import org.bukkit.boss.BarColor;
 import org.bukkit.boss.BossBar;
 import org.bukkit.entity.AreaEffectCloud;
 import org.bukkit.entity.EntityType;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.block.Action;
 import org.bukkit.event.player.PlayerInteractEvent;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 import org.bukkit.potion.PotionEffect;
 import org.bukkit.potion.PotionEffectType;
 import org.bukkit.scheduler.BukkitRunnable;

public class corrupted_seeds
   implements Listener
 {

     MinecraftDungeonItems plugin;

     public corrupted_seeds(MinecraftDungeonItems plugin) {
         this.plugin = plugin;
     }
   @EventHandler
   public void onInteract(PlayerInteractEvent e) {
     if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
       ItemStack item = new ItemStack(Material.POTION);
       ItemMeta meta = item.getItemMeta();
       meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.corrupted-seeds"));
       ArrayList<String> lore = new ArrayList<>();
       lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns a poison cloud!");

       meta.setLore(lore);
       item.setItemMeta(meta);
       Player player = e.getPlayer();
       try {
           if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())
           )
           {
               if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && plugin.removeEnergy(e.getPlayer(), 0.25f)) {
                   player.sendMessage(ChatColor.DARK_GRAY + "[Minecraft Dungeons] - " + ChatColor.GREEN + "You have 5 seconds to move, before the poison cloud spawns where you were standing!");



                   (new BukkitRunnable()
                   {


                       public void run()
                       {
                           player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1.0F, 1.0F);
                           spawnPad(((Block)Objects.<Block>requireNonNull(e.getClickedBlock())).getLocation().add(0.5D, 1.1D, 0.5D));
                       }
                   }).runTaskLater(this.plugin, 100L);




               }
           }
       } catch(Exception es) {

       }

     }
   }


   public void spawnPad(Location loc) {
     AreaEffectCloud pad = (AreaEffectCloud)loc.getWorld().spawnEntity(loc, EntityType.AREA_EFFECT_CLOUD);
     pad.addCustomEffect(new PotionEffect(PotionEffectType.POISON, 200, 1), false);
     pad.setRadius(5.0F);
     pad.setDuration(200);
     pad.setCustomName("BouncePad");
     pad.setCustomNameVisible(false);
     pad.setParticle(Particle.REDSTONE, new Particle.DustOptions(Color.GREEN, 1.0F));
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\corrupted_seeds.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */