/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
import java.util.ArrayList;
import java.util.Objects;

import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
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

public class totem_of_regeneration implements Listener {
    MinecraftDungeonItems plugin;

    public totem_of_regeneration(MinecraftDungeonItems plugin) {
        this.plugin = plugin;
    }
  @EventHandler
  public void onInteract(PlayerInteractEvent e) {
    if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
      ItemStack item = new ItemStack(Material.APPLE);
      ItemMeta meta = item.getItemMeta();
      meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.totem-of-regeneration"));
      ArrayList<String> lore = new ArrayList<>();
      lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns a regenerationPad");
      meta.setLore(lore);
      item.setItemMeta(meta);
      Player player = e.getPlayer();
      try {
        if (Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore()) && e.getAction().equals(Action.RIGHT_CLICK_BLOCK)&& plugin.removeEnergy(e.getPlayer(), 0.35f)
                && plugin.removeEnergy(e.getPlayer(), 0.2f)) {
          player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_DRINK, 1.0F, 1.0F);
          spawnPad(e.getClickedBlock().getLocation().add(0.5D, 1.1D, 0.5D));
        }
      } catch(Exception es) {

      }

    }
  }


  public void spawnPad(Location loc) {
    AreaEffectCloud pad = (AreaEffectCloud)loc.getWorld().spawnEntity(loc, EntityType.AREA_EFFECT_CLOUD);
    pad.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 5, 1), false);
    pad.setRadius(3.0F);
    pad.setDuration(200);
    pad.setCustomName("BouncePad");
    pad.setCustomNameVisible(false);
    pad.setParticle(Particle.REDSTONE, new Particle.DustOptions(Color.RED, 1.0F));
  }
}


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\totem_of_regeneration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */