package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Commands;

import java.util.ArrayList;
import java.util.List;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class giveCommand implements CommandExecutor, TabCompleter {
    MinecraftDungeonItems plugin;

    public giveCommand(MinecraftDungeonItems plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {

            if (args[0].equals("give")) {
                Player player = (Player) sender;
                if (args[1].equals("storm_lander")) {
                    ItemStack item = new ItemStack(Material.NETHERITE_AXE);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("weapon-names.storm-lander"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns lightning on entity attack");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("fire_brand")) {
                    ItemStack item = new ItemStack(Material.GOLDEN_AXE);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("weapon-names.fire-brand"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Makes entities catch on fire");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("whirl_wind")) {
                    ItemStack item = new ItemStack(Material.NETHERITE_AXE);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("weapon-names.whirl-wind"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Blows entities away when hit.");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("golem_kit")) {
                    ItemStack item = new ItemStack(Material.PUMPKIN);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.golem-kit"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawn Iron Golems for 10s!");
                    lore.add(ChatColor.GREEN + "SPECIAL: Has a 30% Chance to set fire nearby enemies when it dies");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("light_feather")) {
                    ItemStack item = new ItemStack(Material.FEATHER);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.light-feather"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Boosts you in the direction you're looking.");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("totem_of_regeneration")) {
                    ItemStack item = new ItemStack(Material.APPLE);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.totem-of-regeneration"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns a regeneration pad!");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("wind_horn")) {
                    ItemStack item = new ItemStack(Material.FEATHER);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.wind-horn"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Blows entities away!");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("lightning_rod")) {
                    ItemStack item = new ItemStack(Material.END_ROD);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.lightning-rod"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns lightning wherever you look!");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("speed_boots")) {
                    ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.speed-boots"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Wear these to gain speed!");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("corrupted_seeds")) {
                    ItemStack item = new ItemStack(Material.POTION);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.corrupted-seeds"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns a poison cloud!");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("firework_arrow")) {
                    ItemStack item = new ItemStack(Material.FIREWORK_ROCKET);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.fire-work-arrow"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Shoots out fireworks!");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("ember_robe")) {
                    ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("armor-names.ember-robe"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "When you get near entities they get set on fire!");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("wither_armor")) {
                    ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("armor-names.wither-armor"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Shoot wither skulls with a simple click!");
                    lore.add(ChatColor.GREEN + "SPECIAL: " + ChatColor.GREEN + "Immune to wither affect");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("satchel_of_elements")) {
                    ItemStack item = new ItemStack(Material.POTION);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.satchel-of-elements"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Has a chance to spawn lightning or set on fire to mobs!");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("kong_of_weakening")) {
                    ItemStack item = new ItemStack(Material.BELL);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.kong-of-weakening"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Weakens nearby enemys!");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("nameless_blade")) {
                    ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("weapon-names.nameless-blade"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "On attack, it weakens enemies.");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("ice_wand")) {
                    ItemStack item = new ItemStack(Material.STICK);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.ice-wand"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Look at an enemy and click! It's now frozen!");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                } else if (args[1].equals("rapid_crossbow")) {
                    ItemStack item = new ItemStack(Material.CROSSBOW);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.rapid-crossbow"));
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "There is no delay, unlike a normal bow.");
                    lore.add(ChatColor.GOLD + "SPECIAL: " + ChatColor.GREEN + "Does more damage the more health you have!");
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    player.sendMessage("There you go!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                    player.getInventory().addItem(new ItemStack[]{item});
                }
            } else if (args[0].equals("gui")) {
                Player player = (Player) sender;
                this.plugin.typeGUI(player);
            }
        } catch (Exception e) {
            Player player = (Player) sender;

        }
        return true;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            list.add("give");
            list.add("gui");
        }
        if (args.length == 2) {
            list.add("storm_lander");
            list.add("fire_brand");
            list.add("WhirlWind");
            list.add("whirl_wind");
            list.add("light_feather");
            list.add("totem_of_regeneration");
            list.add("wind_horn");
            list.add("lightning_rod");
            list.add("speed_boots");
            list.add("corrupted_seeds");
            list.add("firework_arrow");
            list.add("ember_robe");
            list.add("wither_armor");
            list.add("satchel_of_elements");
            list.add("kong_of_weakening");
            list.add("nameless_blade");
            list.add("ice_wand");
            list.add("rapid_crossbow");
        }
        return list;
    }
}
