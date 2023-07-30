/*     */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems;
/*     */ import java.util.ArrayList;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Armor.ember_robe;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Armor.wither_armor;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts.*;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Bows.rapid_crossbow;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Commands.giveCommand;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Weapons.FireBrand;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Weapons.StormLander;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Weapons.WhirlWind;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Weapons.nameless_blade;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.gui.MenuHandler;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.utils.FoodDrop;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.utils.PotionDrop;
import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.InventoryHolder;
/*     */ import org.bukkit.inventory.ItemFlag;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

/*     */
/*     */ public final class MinecraftDungeonItems extends JavaPlugin {
   public void onEnable() {
     print("CONFIG.YML: ");
     print("     Creating config.yml");
     getConfig().options().copyDefaults();
     print("     Saving config.yml");
     saveDefaultConfig();
     print("     Reloading");
     reloadConfig();
     print("     Done!");

     print("Initializing Commands");
     getCommand("mcd").setExecutor((CommandExecutor)new giveCommand(this));
     print("Done!");




     print("Initializing Events");
     getServer().getPluginManager().registerEvents((Listener)new MenuHandler(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new StormLander(), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new FireBrand(), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new WhirlWind(), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new golem_kit(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new LightFeather(), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new totem_of_regeneration(), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new windhorn(), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new lightning_rod(), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new corrupted_seeds(), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new FireWorkArrow(), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new wither_armor(), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new SatchelOfElements(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new kong_of_weakening(), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new nameless_blade(), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new ice_wand(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new rapid_crossbow(), (Plugin)this);

     getServer().getPluginManager().registerEvents((Listener)new FoodDrop(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new PotionDrop(this), (Plugin)this);
     print("Done!");
     print("Starting Runnables!");
     ember_robe robe = new ember_robe(this);
     SpeedBoots boots = new SpeedBoots(this);
     robe.start();
     boots.start();
     print("Done!");
   }





   public void print(String print) {
     System.out.println(ChatColor.GREEN + "MinecraftDungeons - " + ChatColor.BOLD + print);
   }


   public void typeGUI(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 27, ChatColor.BLUE + "Select");
     ItemStack armor = new ItemStack(Material.LEATHER_CHESTPLATE);
     ItemStack weapon = new ItemStack(Material.DIAMOND_SWORD);
     ItemStack artifact = new ItemStack(Material.POTION);
     ItemStack settings = new ItemStack(Material.REPEATER);
     ItemStack close = new ItemStack(Material.BARRIER);
     ItemMeta armor_meta = armor.getItemMeta();
     armor_meta.setDisplayName(ChatColor.GREEN + "Armor");
     ItemMeta weapon_meta = weapon.getItemMeta();
     weapon_meta.setDisplayName(ChatColor.RED + "Weapons");
     ItemMeta artifact_meta = artifact.getItemMeta();
     artifact_meta.setDisplayName(ChatColor.DARK_PURPLE + "Artifacts");
     ItemMeta close_meta = close.getItemMeta();
     close_meta.setDisplayName(ChatColor.RED + "Close");
     ItemMeta settings_meta = settings.getItemMeta();
     settings_meta.setDisplayName(ChatColor.RED + "Settings");
     armor.setItemMeta(armor_meta);
     weapon.setItemMeta(weapon_meta);
     artifact.setItemMeta(artifact_meta);
     close.setItemMeta(close_meta);
     settings.setItemMeta(settings_meta);

     menu.setItem(10, armor);
     menu.setItem(13, weapon);
     menu.setItem(16, artifact);
     menu.setItem(26, close);
     menu.setItem(18, settings);
     for (int i = 0; i < menu.getSize(); i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }

     player.openInventory(menu);
   }
   public void choose(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 27, ChatColor.GREEN + "Choose");

     ItemStack weapons = new ItemStack(Material.DIAMOND_SWORD);
     ItemStack bow = new ItemStack(Material.BOW);
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta weapon_meta = weapons.getItemMeta();
     weapon_meta.setDisplayName(ChatColor.RED + "Weapons");
     ItemMeta bow_meta = bow.getItemMeta();
     bow_meta.setDisplayName(ChatColor.YELLOW + "Bows");
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     weapons.setItemMeta(weapon_meta);
     bow.setItemMeta(bow_meta);
     back.setItemMeta(back_meta);

     menu.setItem(12, weapons);
     menu.setItem(14, bow);
     menu.setItem(26, back);

     for (int i = 0; i < menu.getSize(); i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }

     player.openInventory(menu);
   }
   public void FoodDrops(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 27, ChatColor.RED + "Food Drops");
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemStack food = new ItemStack(Material.APPLE);
     ItemStack amount = new ItemStack(Material.ENDER_PEARL);
     ItemStack rarity = new ItemStack(Material.ENDER_EYE);

     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.YELLOW + "Food Drops");


     ItemMeta food_meta = food.getItemMeta();
     food_meta.setDisplayName(ChatColor.YELLOW + "Food Drops");
     ArrayList<String> food_lore = new ArrayList<>();
     food_lore.add(ChatColor.DARK_GRAY + "Has a chance to drop food when you kill a enemy");
     if (getConfig().getBoolean("food-drops.drop-food")) {
       food_lore.add(ChatColor.DARK_GRAY + "Enabled: " + ChatColor.GREEN + "TRUE");
     } else {
       food_lore.add(ChatColor.DARK_GRAY + "Enabled: " + ChatColor.RED + "FALSE");
     }
     ItemMeta amount_meta = amount.getItemMeta();
     amount_meta.setDisplayName(ChatColor.GREEN + "Amount");
     ArrayList<String> amount_lore = new ArrayList<>();
     amount_lore.add(ChatColor.DARK_GRAY + "Change the range of the random amount of the food drops");
     amount_lore.add(ChatColor.DARK_GRAY + "Amount: " + ChatColor.GREEN + getConfig().getInt("food-drops.food-amount"));

     ItemMeta rarity_meta = rarity.getItemMeta();
     rarity_meta.setDisplayName(ChatColor.RED + "Chance");
     ArrayList<String> rarity_lore = new ArrayList<>();
     rarity_lore.add(ChatColor.DARK_GRAY + "The rarity of the food dropping");
     rarity_lore.add(ChatColor.DARK_GRAY + "Chance: " + ChatColor.GREEN + getConfig().getInt("food-drops.food-chance") + ChatColor.DARK_GRAY + "%");

     amount_meta.setLore(amount_lore);
     food_meta.setLore(food_lore);
     rarity_meta.setLore(rarity_lore);

     food.setItemMeta(food_meta);
     back.setItemMeta(back_meta);
     amount.setItemMeta(amount_meta);
     rarity.setItemMeta(rarity_meta);







     menu.setItem(26, back);
     menu.setItem(10, food);
     menu.setItem(13, amount);
     menu.setItem(16, rarity);
     for (int i = 0; i < menu.getSize(); i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }

     player.openInventory(menu);
   }
   public void PotionDrops(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 27, ChatColor.DARK_PURPLE + "Potion Drops");


     ItemStack potion = new ItemStack(Material.POTION);
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemStack amount = new ItemStack(Material.ENDER_PEARL);
     ItemStack rarity = new ItemStack(Material.ENDER_EYE);


     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     ItemMeta potion_meta = potion.getItemMeta();
     potion_meta.setDisplayName(ChatColor.DARK_PURPLE + "Drop Potions");
     ArrayList<String> potion_lore = new ArrayList<>();
     if (getConfig().getBoolean("potion-drops.drop-potion")) {
       potion_lore.add(ChatColor.DARK_GRAY + "Enabled: " + ChatColor.GREEN + "TRUE");
     } else {
       potion_lore.add(ChatColor.DARK_GRAY + "Enabled: " + ChatColor.RED + "FALSE");
     }
     potion_meta.setLore(potion_lore);

     ItemMeta amount_meta = amount.getItemMeta();
     amount_meta.setDisplayName(ChatColor.GREEN + "Amount");
     ArrayList<String> amount_lore = new ArrayList<>();
     amount_lore.add(ChatColor.DARK_GRAY + "Change the range of the random amount of the food drops");
     amount_lore.add(ChatColor.DARK_GRAY + "Amount: " + ChatColor.GREEN + getConfig().getInt("potion-drops.potion-amount"));
     amount_meta.setLore(amount_lore);

     ItemMeta rarity_meta = rarity.getItemMeta();
     rarity_meta.setDisplayName(ChatColor.RED + "Chance");
     ArrayList<String> rarity_lore = new ArrayList<>();
     rarity_lore.add(ChatColor.DARK_GRAY + "The rarity of the food dropping");
     rarity_lore.add(ChatColor.DARK_GRAY + "Chance: " + ChatColor.GREEN + getConfig().getInt("potion-drops.potion-chance") + ChatColor.DARK_GRAY + "%");
     rarity_meta.setLore(rarity_lore);


     back.setItemMeta(back_meta);
     potion.setItemMeta(potion_meta);
     amount.setItemMeta(amount_meta);
     rarity.setItemMeta(rarity_meta);

     menu.setItem(10, potion);
     menu.setItem(13, amount);
     menu.setItem(16, rarity);
     menu.setItem(26, back);

     for (int i = 0; i < menu.getSize(); i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }

     player.openInventory(menu);
   }
   public void settings(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 27, ChatColor.RED + "Settings");
     Potion potionItem = new Potion(PotionType.STRENGTH, 1);
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemStack reload = new ItemStack(Material.COMPASS);
     ItemStack food = new ItemStack(Material.BREAD);
     ItemStack potion = potionItem.toItemStack(1);

     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     ItemMeta reload_meta = reload.getItemMeta();
     reload_meta.setDisplayName(ChatColor.GREEN + "Reload");
     ArrayList<String> reload_lore = new ArrayList<>();
     reload_lore.add(ChatColor.DARK_GRAY + "Reloads the config file");
     reload_meta.setLore(reload_lore);
     ItemMeta food_meta = food.getItemMeta();
     food_meta.setDisplayName(ChatColor.YELLOW + "Food Drops");
     ItemMeta potion_meta = potion.getItemMeta();
     potion_meta.setDisplayName(ChatColor.DARK_PURPLE + "Potion Drops");
     food.setItemMeta(food_meta);
     back.setItemMeta(back_meta);
     reload.setItemMeta(reload_meta);
     potion.setItemMeta(potion_meta);

     menu.setItem(10, food);
     menu.setItem(13, potion);
     menu.setItem(26, back);
     menu.setItem(18, reload);
     for (int i = 0; i < menu.getSize(); i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }

     player.openInventory(menu);
   }





   public void weaponRarity(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 27, ChatColor.GREEN + "Weapon Rarity");
     ItemStack common = new ItemStack(Material.LEATHER_CHESTPLATE);
     ItemStack rare = new ItemStack(Material.DIAMOND_CHESTPLATE);
     ItemStack unique = new ItemStack(Material.NETHERITE_CHESTPLATE);
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta common_meta = common.getItemMeta();
     common_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "COMMON");
     ItemMeta rare_meta = rare.getItemMeta();
     rare_meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "RARE");
     ItemMeta unique_meta = unique.getItemMeta();
     unique_meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "UNIQUE");
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     common.setItemMeta(common_meta);
     rare.setItemMeta(rare_meta);
     unique.setItemMeta(unique_meta);
     back.setItemMeta(back_meta);

     menu.setItem(10, common);
     menu.setItem(13, rare);
     menu.setItem(16, unique);
     menu.setItem(26, back);
     for (int i = 0; i < 27; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }



     player.openInventory(menu);
   }
   public void uniqueWeapon(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 45, ChatColor.GOLD + "UNIQUE WEAPONS");
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     back.setItemMeta(back_meta);
     menu.setItem(44, back);

     ItemStack item1 = new ItemStack(Material.NETHERITE_AXE);
     ItemMeta meta1 = item1.getItemMeta();
     meta1.setDisplayName(ChatColor.GOLD + "FireBrand");
     ArrayList<String> lore1 = new ArrayList<>();
     lore1.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Super super super super POWERFUL weapon");
     meta1.setLore(lore1);
     item1.setItemMeta(meta1);
     menu.addItem(new ItemStack[] { item1 });

     ItemStack item2 = new ItemStack(Material.NETHERITE_AXE);
     ItemMeta meta2 = item2.getItemMeta();
     meta2.setDisplayName(ChatColor.GOLD + "StormLander");
     ArrayList<String> lore2 = new ArrayList<>();
     lore2.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns lightning on entity attack");
     meta2.setLore(lore2);
     item2.setItemMeta(meta2);
     menu.addItem(new ItemStack[] { item2 });

     ItemStack item3 = new ItemStack(Material.NETHERITE_AXE);
     ItemMeta meta3 = item3.getItemMeta();
     meta3.setDisplayName(ChatColor.GOLD + "WhirlWind");
     ArrayList<String> lore3 = new ArrayList<>();
     lore3.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Super super super super POWERFUL weapon");
     meta3.setLore(lore3);
     item3.setItemMeta(meta3);
     menu.addItem(new ItemStack[] { item3 });

     ItemStack item4 = new ItemStack(Material.NETHERITE_SWORD);
     ItemMeta meta4 = item4.getItemMeta();
     meta4.setDisplayName(ChatColor.GOLD + "Nameless Blade");
     ArrayList<String> lore4 = new ArrayList<>();
     lore4.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "On attack, it weakens enemy's!");
     meta4.setLore(lore4);
     item4.setItemMeta(meta4);
     menu.addItem(new ItemStack[] { item4 });




     for (int i = 0; i < 44; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }



     player.openInventory(menu);
   }
   public void commonWeapon(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 45, ChatColor.GREEN + "COMMON WEAPONS");
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     back.setItemMeta(back_meta);

     menu.setItem(44, back);

     for (int i = 0; i < 44; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }


     player.openInventory(menu);
   }
   public void rareWeapon(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 45, ChatColor.DARK_PURPLE + "RARE WEAPONS");
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     back.setItemMeta(back_meta);

     menu.setItem(44, back);

     for (int i = 0; i < 44; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }




     player.openInventory(menu);
   }


   public void artifactRarity(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 27, ChatColor.GREEN + "Artifact Rarity");
     ItemStack common = new ItemStack(Material.LEATHER_CHESTPLATE);
     ItemStack rare = new ItemStack(Material.DIAMOND_CHESTPLATE);
     ItemStack unique = new ItemStack(Material.NETHERITE_CHESTPLATE);
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta common_meta = common.getItemMeta();
     common_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "COMMON");
     ItemMeta rare_meta = rare.getItemMeta();
     rare_meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "RARE");
     ItemMeta unique_meta = unique.getItemMeta();
     unique_meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "UNIQUE");
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     common.setItemMeta(common_meta);
     rare.setItemMeta(rare_meta);
     unique.setItemMeta(unique_meta);
     back.setItemMeta(back_meta);

     menu.setItem(10, common);
     menu.setItem(13, rare);
     menu.setItem(16, unique);
     menu.setItem(26, back);
     for (int i = 0; i < 27; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }



     player.openInventory(menu);
   }
   public void commonArtifact(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 45, ChatColor.GREEN + "COMMON ARTIFACTS");
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     back.setItemMeta(back_meta);

     menu.setItem(44, back);

     ItemStack item1 = new ItemStack(Material.PUMPKIN);
     ItemMeta meta1 = item1.getItemMeta();
     meta1.setDisplayName(ChatColor.GOLD + "GolemKit");
     ArrayList<String> lore1 = new ArrayList<>();
     lore1.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawn Iron Golems for 10s!");
     lore1.add(ChatColor.GREEN + "SPECIAL: Has a 30% Chance to set fire nearby enemies when it dies");
     meta1.setLore(lore1);
     item1.setItemMeta(meta1);
     menu.addItem(new ItemStack[] { item1 });

     ItemStack item2 = new ItemStack(Material.DIAMOND_BOOTS);
     ItemMeta meta2 = item2.getItemMeta();
     meta2.setDisplayName(ChatColor.GOLD + "SpeedBoots");
     ArrayList<String> lore2 = new ArrayList<>();
     lore2.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Where these to gain speed!");
     meta2.setLore(lore2);
     item2.setItemMeta(meta2);
     menu.addItem(new ItemStack[] { item2 });


     ItemStack item3 = new ItemStack(Material.FIREWORK_ROCKET);
     ItemMeta meta3 = item3.getItemMeta();
     meta3.setDisplayName(ChatColor.GOLD + "Firework arrows");
     ArrayList<String> lore3 = new ArrayList<>();
     lore3.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Shoots out fireworks!");
     meta3.setLore(lore3);
     item3.setItemMeta(meta3);
     menu.addItem(new ItemStack[] { item3 });

     ItemStack item4 = new ItemStack(Material.POTION);
     ItemMeta meta4 = item4.getItemMeta();
     meta4.setDisplayName(ChatColor.GOLD + "Satchel of elements");
     ArrayList<String> lore4 = new ArrayList<>();
     lore4.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Has a change to lightning or setFire to mobs!");
     meta4.setLore(lore4);
     item4.setItemMeta(meta4);
     menu.addItem(new ItemStack[] { item4 });
     for (int i = 0; i < 44; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }


     player.openInventory(menu);
   }
   public void rareArtifact(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 45, ChatColor.DARK_PURPLE + "RARE ARTIFACTS");
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     back.setItemMeta(back_meta);

     menu.setItem(44, back);

     ItemStack item1 = new ItemStack(Material.FEATHER);
     ItemMeta meta1 = item1.getItemMeta();
     meta1.setDisplayName(ChatColor.GOLD + "LightFeather");
     ArrayList<String> lore1 = new ArrayList<>();
     lore1.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Boosts you up!");
     meta1.setLore(lore1);
     item1.setItemMeta(meta1);
     menu.addItem(new ItemStack[] { item1 });


     ItemStack item2 = new ItemStack(Material.APPLE);
     ItemMeta meta2 = item2.getItemMeta();
     meta2.setDisplayName(ChatColor.GOLD + "Totem of Regeneration");
     ArrayList<String> lore2 = new ArrayList<>();
     lore2.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns a regenerationPad");
     meta2.setLore(lore2);
     item2.setItemMeta(meta2);
     menu.addItem(new ItemStack[] { item2 });


     ItemStack item3 = new ItemStack(Material.END_ROD);
     ItemMeta meta3 = item3.getItemMeta();
     meta3.setDisplayName(ChatColor.GOLD + "Lightning Rod");
     ArrayList<String> lore3 = new ArrayList<>();
     lore3.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns lightning wherever you look!");
     meta3.setLore(lore3);
     item3.setItemMeta(meta3);
     menu.addItem(new ItemStack[] { item3 });


     ItemStack item4 = new ItemStack(Material.FEATHER);
     ItemMeta meta4 = item4.getItemMeta();
     meta4.setDisplayName(ChatColor.GOLD + "WindHorn");
     ArrayList<String> lore4 = new ArrayList<>();
     lore4.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Blows entitys away!");
     meta4.setLore(lore4);
     item4.setItemMeta(meta4);
     menu.addItem(new ItemStack[] { item4 });

     ItemStack item5 = new ItemStack(Material.POTION);
     ItemMeta meta5 = item5.getItemMeta();
     meta5.setDisplayName(ChatColor.GOLD + "Corrupted Seeds");
     ArrayList<String> lore5 = new ArrayList<>();
     lore5.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns a poison cloud!");
     meta5.setLore(lore5);
     item5.setItemMeta(meta5);
     menu.addItem(new ItemStack[] { item5 });

     ItemStack item6 = new ItemStack(Material.STICK);
     ItemMeta meta6 = item6.getItemMeta();
     meta6.setDisplayName(ChatColor.GOLD + "Ice Wand");
     ArrayList<String> lore6 = new ArrayList<>();
     lore6.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Look at a enemy and click! Its now frozen!");
     meta6.setLore(lore6);
     item6.setItemMeta(meta6);
     menu.addItem(new ItemStack[] { item6 });

     ItemStack item7 = new ItemStack(Material.BELL);
     ItemMeta meta7 = item7.getItemMeta();
     meta1.setDisplayName(ChatColor.GOLD + "Kong of weakening");
     ArrayList<String> lore7 = new ArrayList<>();
     lore7.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Weakens nearby enemys!");
     meta7.setLore(lore7);
     item7.setItemMeta(meta7);
     menu.addItem(new ItemStack[] { item7 });

     for (int i = 0; i < 44; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }




     player.openInventory(menu);
   }
   public void uniqueArtifact(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 45, ChatColor.GOLD + "UNIQUE ARTIFACTS");
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     back.setItemMeta(back_meta);
     menu.setItem(44, back);






     for (int i = 0; i < 44; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }



     player.openInventory(menu);
   }


   public void armorRarity(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 27, ChatColor.GREEN + "Armor Rarity");
     ItemStack common = new ItemStack(Material.LEATHER_CHESTPLATE);
     ItemStack rare = new ItemStack(Material.DIAMOND_CHESTPLATE);
     ItemStack unique = new ItemStack(Material.NETHERITE_CHESTPLATE);
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta common_meta = common.getItemMeta();
     common_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "COMMON");
     ItemMeta rare_meta = rare.getItemMeta();
     rare_meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "RARE");
     ItemMeta unique_meta = unique.getItemMeta();
     unique_meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "UNIQUE");
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     common.setItemMeta(common_meta);
     rare.setItemMeta(rare_meta);
     unique.setItemMeta(unique_meta);
     back.setItemMeta(back_meta);

     menu.setItem(10, common);
     menu.setItem(13, rare);
     menu.setItem(16, unique);
     menu.setItem(26, back);
     for (int i = 0; i < 27; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }



     player.openInventory(menu);
   }
   public void commonArmor(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 45, ChatColor.GREEN + "COMMON ARMOR");
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     back.setItemMeta(back_meta);

     menu.setItem(44, back);


     for (int i = 0; i < 44; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }


     player.openInventory(menu);
   }
   public void rareArmor(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 45, ChatColor.DARK_PURPLE + "RARE ARMOR");
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     back.setItemMeta(back_meta);

     menu.setItem(44, back);





     for (int i = 0; i < 44; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }




     player.openInventory(menu);
   }
   public void uniqueArmor(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 45, ChatColor.GOLD + "UNIQUE ARMOR");
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     back.setItemMeta(back_meta);
     menu.setItem(44, back);


     ItemStack item1 = new ItemStack(Material.NETHERITE_CHESTPLATE);
     ItemMeta meta1 = item1.getItemMeta();
     meta1.setDisplayName(ChatColor.GOLD + "Ember Robe");
     ArrayList<String> lore1 = new ArrayList<>();
     lore1.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "When you get near entities they get set on fire!");

     meta1.setLore(lore1);
     item1.setItemMeta(meta1);
     menu.addItem(new ItemStack[] { item1 });

     ItemStack item2 = new ItemStack(Material.NETHERITE_CHESTPLATE);
     ItemMeta meta2 = item2.getItemMeta();
     meta2.setDisplayName(ChatColor.GOLD + "Wither armor");
     ArrayList<String> lore2 = new ArrayList<>();
     lore2.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Shoot wither skulls with a simple click!");
     lore2.add(ChatColor.GREEN + "SPECIAL: " + ChatColor.GREEN + "Immune to wither affect");
     meta2.setLore(lore2);
     item2.setItemMeta(meta2);
     menu.addItem(new ItemStack[] { item2 });



     for (int i = 0; i < 44; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }



     player.openInventory(menu);
   }

   public void bowRarity(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 27, ChatColor.GREEN + "Bow Rarity");
     ItemStack common = new ItemStack(Material.LEATHER_CHESTPLATE);
     ItemStack rare = new ItemStack(Material.DIAMOND_CHESTPLATE);
     ItemStack unique = new ItemStack(Material.NETHERITE_CHESTPLATE);
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta common_meta = common.getItemMeta();
     common_meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "COMMON");
     ItemMeta rare_meta = rare.getItemMeta();
     rare_meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "RARE");
     ItemMeta unique_meta = unique.getItemMeta();
     unique_meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "UNIQUE");
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     common.setItemMeta(common_meta);
     rare.setItemMeta(rare_meta);
     unique.setItemMeta(unique_meta);
     back.setItemMeta(back_meta);

     menu.setItem(10, common);
     menu.setItem(13, rare);
     menu.setItem(16, unique);
     menu.setItem(26, back);
     for (int i = 0; i < 27; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }



     player.openInventory(menu);
   }
   public void commonBows(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 45, ChatColor.GREEN + "COMMON BOWS");
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     back.setItemMeta(back_meta);

     menu.setItem(44, back);


     for (int i = 0; i < 44; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }


     player.openInventory(menu);
   }
   public void rareBows(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 45, ChatColor.DARK_PURPLE + "RARE BOWS");
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     back.setItemMeta(back_meta);

     menu.setItem(44, back);


     ItemStack item1 = new ItemStack(Material.CROSSBOW);
     ItemMeta meta1 = item1.getItemMeta();
     meta1.setDisplayName(ChatColor.GOLD + "Rapid Crossbow");
     ArrayList<String> lore1 = new ArrayList<>();
     lore1.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Shoot like crazy!");
     lore1.add(ChatColor.GOLD + "SPECIAL: " + ChatColor.GREEN + "Does more damage the more health you have!");
     meta1.setLore(lore1);
     item1.setItemMeta(meta1);
     menu.addItem(new ItemStack[] { item1 });


     for (int i = 0; i < 44; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }




     player.openInventory(menu);
   }
   public void uniqueBows(Player player) {
     Inventory menu = Bukkit.createInventory((InventoryHolder)player, 45, ChatColor.GOLD + "UNIQUE BOWS");
     ItemStack back = new ItemStack(Material.BARRIER);
     ItemMeta back_meta = back.getItemMeta();
     back_meta.setDisplayName(ChatColor.RED + "Back");
     back.setItemMeta(back_meta);
     menu.setItem(44, back);



     for (int i = 0; i < 44; i++) {
       if (menu.getItem(i) == null) {
         ItemStack fancy = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
         ItemMeta fancy_meta = fancy.getItemMeta();
         assert fancy_meta != null;
         fancy_meta.removeItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
         fancy_meta.setDisplayName("");
         fancy.setItemMeta(fancy_meta);
         menu.setItem(i, fancy);
       }
     }



     player.openInventory(menu);
   }
 }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\MinecraftDungeons.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */