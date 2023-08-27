package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.energy;

import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class EnergyHandler {


    MinecraftDungeonItems plugin;

    public EnergyHandler(MinecraftDungeonItems plugin) {
        this.plugin = plugin;
    }

    public List<String> players = new ArrayList<String>();
    public List<BossBar> bossbars = new ArrayList<>();

    public void start() {

        Player[] playerCount = Bukkit.getOnlinePlayers().toArray(new Player[0]);
        for (int i = 0; i < playerCount.length; i ++) {
            BossBar boss = Bukkit.createBossBar("Energy",BarColor.GREEN,BarStyle.SOLID);
            boss.addPlayer(playerCount[i]);
            players.add(playerConvert(playerCount[i]));
            bossbars.add(boss);

        }
        (new BukkitRunnable()
        {


            public void run()

            {

                for(int i = 0; i < bossbars.size(); i++) {
                    BossBar bossbar = bossbars.get(i);
                    try {
                        if(bossbar.getProgress() > 0.15) {
                            bossbar.setColor(BarColor.GREEN);
                            bossbar.setTitle(ChatColor.GREEN + "Energy");
                        }
                        if(bossbar.getProgress() >= 1f) {
                            bossbar.setProgress(1F);

                        } else {
                            bossbar.setProgress(bossbar.getProgress() + plugin.getConfig().getDouble("energy.increments"));
                        }
                    } catch (Exception e) {

                    }

                }


            }
        }).runTaskTimer(this.plugin, 0L, 25L);




    }



    public BossBar getBossbar(Player player) {
        String playerString = playerConvert(player);
        return bossbars.get( this.players.indexOf(playerString));
    }
    public String playerConvert(Player player) {
        return String.valueOf(player.getUniqueId());
    }
    public BossBar createBossbarPair(Player player) {
        BossBar boss = Bukkit.createBossBar("Energy",BarColor.GREEN,BarStyle.SOLID);
        boss.addPlayer(player);
        players.add(playerConvert(player));
        bossbars.add(boss);
        return boss;
    }



    public void addBossbar(BossBar bossbar) {
        bossbars.add(bossbar);
    }
    public void addPlayer(String string) {
        players.add(string);
    }
}
