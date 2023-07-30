/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Weapons;

 import java.util.ArrayList;
 import java.util.Objects;
 import java.util.Random;

 import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
 import org.bukkit.ChatColor;
 import org.bukkit.Location;
 import org.bukkit.Material;
 import org.bukkit.World;
 import org.bukkit.entity.Entity;
 import org.bukkit.entity.LivingEntity;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.entity.EntityDamageByEntityEvent;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 import org.bukkit.potion.PotionEffect;
 import org.bukkit.potion.PotionEffectType;

 public class nameless_blade

   implements Listener {
     MinecraftDungeonItems plugin;

     public nameless_blade(MinecraftDungeonItems plugin) {
         this.plugin = plugin;
     }
   @EventHandler
   public void onAttack(EntityDamageByEntityEvent e) {
     Random rand = new Random();
     ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
     ItemMeta meta = item.getItemMeta();
     meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("weapon-names.nameless-blade"));
     ArrayList<String> lore = new ArrayList<>();
     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "On attack, it weakens enemies.");
     meta.setLore(lore);
     item.setItemMeta(meta);
     if (e.getDamager() instanceof Player) {
       Player player = (Player)e.getDamager();
       if (player.getInventory().getItemInMainHand().lore() != null &&
         Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).lore(), item.getItemMeta().lore())) {
         World world = player.getWorld();
         Entity mainEntity = e.getEntity();
         Location playerLocation = player.getLocation();
         LivingEntity entity = (LivingEntity)e.getEntity();
         entity.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 7, true, true, true));
       }
     }
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Weapons\nameless_blade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */