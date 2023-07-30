/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Weapons;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Particle;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class WhirlWind implements Listener {

    MinecraftDungeonItems plugin;

    public WhirlWind(MinecraftDungeonItems plugin) {
        this.plugin = plugin;
    }
   @EventHandler
   public void onAttack(EntityDamageByEntityEvent e) {
     Random rand = new Random();
     ItemStack item = new ItemStack(Material.NETHERITE_AXE);
     ItemMeta meta = item.getItemMeta();
     meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("weapon-names.whirl-wind"));
     ArrayList<String> lore = new ArrayList<>();
     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Super super super super POWERFUL weapon");
     meta.setLore(lore);
     item.setItemMeta(meta);
     if (e.getDamager() instanceof Player) {
       Player player = (Player)e.getDamager();
       if (player.getInventory().getItemInMainHand().lore() != null &&
         Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).lore(), item.getItemMeta().lore())) {
         World world = player.getWorld();
         Entity mainEntity = e.getEntity();
         Location playerLocation = player.getLocation();
         for (LivingEntity entity : playerLocation.getNearbyLivingEntities(5.0D, 5.0D, 5.0D)) {
           if (entity.getType().equals(mainEntity.getType())) {
             Location loca = entity.getLocation();
             entity.setVelocity(player.getLocation().getDirection().multiply(2).setY(1));
             world.spawnParticle(Particle.CLOUD, loca, 10, 0.0D, 0.0D, 0.0D);
             int damage = rand.nextInt(7);
             for (; damage < 3; damage = rand.nextInt(7));
             entity.damage(damage);
           }
           Location playerLocation2 = player.getLocation();
           for (LivingEntity entity2 : playerLocation2.getNearbyLivingEntities(5.0D, 5.0D, 5.0D)) {

             if (entity2.getType().equals(mainEntity.getType())) {
               Location loc = entity2.getLocation();
               entity2.setVelocity(player.getLocation().getDirection().multiply(2).setY(1));
               world.spawnParticle(Particle.CLOUD, loc, 10, 0.0D, 0.0D, 0.0D);
               int damage = rand.nextInt(7);
               for (; damage < 3; damage = rand.nextInt(7));
               entity.damage(damage);
             }
           }
         }
       }
     }
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Weapons\WhirlWind.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */