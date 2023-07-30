package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.utils;

import java.util.Random;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class FoodDrop implements Listener {
    MinecraftDungeonItems plugin;

    public FoodDrop(MinecraftDungeonItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void kill(final EntityDamageEvent e) {
        (new BukkitRunnable() {
            public void run() {
                try {
                    LivingEntity entity = (LivingEntity)e.getEntity();
                    if (!(entity instanceof org.bukkit.entity.Item)) {
                        Location loc = entity.getLocation();
                        Random rando = new Random();
                        int doIt = rando.nextInt(101);
                        if (doIt <= FoodDrop.this.plugin.getConfig().getInt("food-drops.food-chance") &&
                                FoodDrop.this.plugin.getConfig().getBoolean("food-drops.drop-food") &&
                                entity.getHealth() <= 0.0D) {
                            ItemStack item;
                            Random rand = new Random();
                            int num = rand.nextInt(3);
                            switch (num) {
                                case 0:
                                    item = new ItemStack(Material.BREAD);
                                    break;
                                case 1:
                                    item = new ItemStack(Material.APPLE);
                                    break;
                                case 2:
                                    item = new ItemStack(Material.PORKCHOP);
                                    break;
                                default:
                                    item = new ItemStack(Material.BEEF);
                                    break;
                            }

                            Random randa = new Random();
                            int amount = randa.nextInt(FoodDrop.this.plugin.getConfig().getInt("food-drops.food-amount") + 1);
                            for (; amount < 1; amount = randa.nextInt(FoodDrop.this.plugin.getConfig().getInt("food-drops.food-amount") + 1));
                            for (int i = 0; i < amount; i++) {
                                World world = entity.getWorld();
                                world.dropItemNaturally(loc, item);
                            }
                        }
                    }
                } catch (Exception e) {

                }
            }
        }).runTaskLater((Plugin)this.plugin, 11L);
    }
}