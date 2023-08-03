package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.energy;


import io.papermc.paper.event.player.PlayerDeepSleepEvent;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class EnergyListener implements Listener {

    EnergyHandler energy;

    MinecraftDungeonItems plugin;

    public EnergyListener(MinecraftDungeonItems plugin) {
        this.plugin = plugin;
        energy = plugin.energy;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        try {
            Player player = e.getPlayer();
            BossBar bossbar = energy.getBossbar(player);
            float progress = (float) bossbar.getProgress();
            energy.bossbars.remove(bossbar);
            energy.players.remove(energy.playerConvert(player));

            BossBar newBoss = energy.createBossbarPair(player);
            newBoss.setProgress(progress);
        } catch (Exception error) {
            Player player = e.getPlayer();
            energy.createBossbarPair(player);
        }
    }





}
