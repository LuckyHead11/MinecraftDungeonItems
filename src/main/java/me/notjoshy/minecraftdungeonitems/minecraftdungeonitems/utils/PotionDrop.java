package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.utils;

import java.util.Random;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;

public class PotionDrop implements Listener {
    MinecraftDungeonItems plugin;

    public PotionDrop(MinecraftDungeonItems plugin) {
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
                        if (doIt <= PotionDrop.this.plugin.getConfig().getInt("potion-drops.potion-chance") &&
                                PotionDrop.this.plugin.getConfig().getBoolean("potion-drops.drop-potion") &&
                                entity.getHealth() <= 0.0D) {
                            Potion item;
                            Random rand = new Random();
                            int num = rand.nextInt(4);
                            switch (num) {
                                case 0:
                                    item = new Potion(PotionType.SPEED, 2);
                                    break;
                                case 1:
                                    item = new Potion(PotionType.STRENGTH, 2);
                                    break;
                                case 2:
                                    item = new Potion(PotionType.REGEN, 2);
                                    break;
                                default:
                                    item = new Potion(PotionType.FIRE_RESISTANCE, 2);
                                    break;
                            }

                            Random randa = new Random();
                            int times = rand.nextInt(PotionDrop.this.plugin.getConfig().getInt("potion-drops.potion-amount") + 1);
                            for (; times < 1; times = rand.nextInt(PotionDrop.this.plugin.getConfig().getInt("potion-drops.potion-amount") + 1));
                            for (int i = 0; i < times; i++) {
                                World world = entity.getWorld();
                                world.dropItemNaturally(loc, item.toItemStack(1));
                            }
                        }
                    }
                } catch (Exception e) {

                }

            }
        }).runTaskLater((Plugin)this.plugin, 11L);
    }
}
