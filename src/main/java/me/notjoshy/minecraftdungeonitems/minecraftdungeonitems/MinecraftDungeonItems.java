/*     */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems;
/*     */ import java.util.ArrayList;
import java.util.List;

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
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.energy.EnergyHandler;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.energy.EnergyListener;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.gui.MenuHandler;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.utils.FoodDrop;
import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.utils.PotionDrop;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.title.Title;
import org.bukkit.*;
/*     */
/*     */
/*     */ import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.InventoryHolder;
/*     */ import org.bukkit.inventory.ItemFlag;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.bukkit.scheduler.BukkitRunnable;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*     */
/*     */ public final class MinecraftDungeonItems extends JavaPlugin {
  public EnergyHandler energy;
  private BukkitAudiences adventure;
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
     getServer().getPluginManager().registerEvents((Listener)new StormLander(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new FireBrand(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new WhirlWind(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new golem_kit(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new LightFeather(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new totem_of_regeneration(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new windhorn(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new lightning_rod(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new corrupted_seeds(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new FireWorkArrow(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new wither_armor(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new SatchelOfElements(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new kong_of_weakening(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new nameless_blade(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new ice_wand(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new rapid_crossbow(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new SpeedBoots(this), this);
     getServer().getPluginManager().registerEvents((Listener)new FoodDrop(this), (Plugin)this);
     getServer().getPluginManager().registerEvents((Listener)new PotionDrop(this), (Plugin)this);
     print("Done!");
     print("Starting Runnables!");
     ember_robe robe = new ember_robe(this);
     SpeedBoots boots = new SpeedBoots(this);
     energy = new EnergyHandler(this);
     robe.start();
     boots.start();
     energy.start();
     print("Starting Metrics!...");
     Metrics metrics = new Metrics(this, 19321);
     displayWelcomeMessage();
     print("Done everything has loading successfully!");
     getServer().getPluginManager().registerEvents((Listener)new EnergyListener(this), (Plugin)this);








   }

   public void displayWelcomeMessage() {
     MinecraftDungeonItems mcd = this;
     (new BukkitRunnable()
     {


       public void run()
       {
         if(mcd.getConfig().getBoolean("first-time")) {
           Player[] players = Bukkit.getOnlinePlayers().toArray(new Player[0]);
           for(int i = 0; i < players.length; i++) {
             Player player = players[i];
             player.sendMessage(ChatColor.DARK_GRAY + "[Minecraft Dungeons] - " + ChatColor.GOLD + "Thank you for installing my plugin! -"
                     +ChatColor.GREEN + "\n You can get exclusive beta participation, and teasers for the new HUGE update coming later this year! Just review on spigot, what you liked/disliked and request to be apart of the new update, happy fighting!");
             player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
           }

           mcd.getConfig().set("first-time", Boolean.valueOf(false));
           mcd.saveConfig();
         }


       }
     }).runTaskLater(this, (20*60)*10);
   }


  @Override
  public void onDisable() {
     if(this.adventure != null) {
       this.adventure.close();
       this.adventure = null;
     }
   }

  public boolean removeEnergy(Player player, float amount) {
     if (player.getGameMode() != GameMode.CREATIVE) {
       BossBar bossbar = energy.getBossbar(player);
       float progress = (float) bossbar.getProgress();
       if (progress <= 0.15) {
         bossbar.setColor(BarColor.RED);
         bossbar.setTitle(ChatColor.RED + "Energy - Low");
         player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, (20) * 15 , 1));



       }
       if ((progress - amount) <= 0) {


         return false;
       } else {
         bossbar.setColor(BarColor.GREEN);
         bossbar.setProgress(progress - (amount));
         if(progress > 0.15) {
           bossbar.setTitle(ChatColor.GREEN + "Energy - " + Math.round(bossbar.getProgress() * 100) + "%");
         }

         return true;
       }

     }
     return true;




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
         fancy_meta.removeItemFlags(ItemFlag.HIDE_ATTRIBUTES);
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

     ItemStack item1 = new ItemStack(Material.GOLDEN_AXE);
     ItemMeta meta1 = item1.getItemMeta();
     meta1.setDisplayName(ChatColor.GOLD + getConfig().getString("weapon-names.fire-brand"));
     ArrayList<String> lore1 = new ArrayList<>();
     lore1.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Makes entities catch on fire");
     meta1.setLore(lore1);
     item1.setItemMeta(meta1);
     menu.addItem(new ItemStack[] { item1 });

     ItemStack item2 = new ItemStack(Material.NETHERITE_AXE);
     ItemMeta meta2 = item2.getItemMeta();
     meta2.setDisplayName(ChatColor.GOLD + getConfig().getString("weapon-names.storm-lander"));
     ArrayList<String> lore2 = new ArrayList<>();
     lore2.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns lightning on entity attack");
     meta2.setLore(lore2);
     item2.setItemMeta(meta2);
     menu.addItem(new ItemStack[] { item2 });

     ItemStack item3 = new ItemStack(Material.NETHERITE_AXE);
     ItemMeta meta3 = item3.getItemMeta();
     meta3.setDisplayName(ChatColor.GOLD + getConfig().getString("weapon-names.whirl-wind"));
     ArrayList<String> lore3 = new ArrayList<>();
     lore3.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Blows entities away when hit.");
     meta3.setLore(lore3);
     item3.setItemMeta(meta3);
     menu.addItem(new ItemStack[] { item3 });

     ItemStack item4 = new ItemStack(Material.NETHERITE_SWORD);
     ItemMeta meta4 = item4.getItemMeta();
     meta4.setDisplayName(ChatColor.GOLD + getConfig().getString("weapon-names.nameless-blade"));
     ArrayList<String> lore4 = new ArrayList<>();
     lore4.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "On attack, it weakens enemies.");
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
     meta1.setDisplayName(ChatColor.GOLD + getConfig().getString("artifact-names.golem-kit"));
     ArrayList<String> lore1 = new ArrayList<>();
     lore1.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawn Iron Golems for 10s!");
     lore1.add(ChatColor.GREEN + "SPECIAL: Has a 30% Chance to set fire nearby enemies when it dies");
     meta1.setLore(lore1);
     item1.setItemMeta(meta1);
     menu.addItem(new ItemStack[] { item1 });

     ItemStack item2 = new ItemStack(Material.DIAMOND_BOOTS);
     ItemMeta meta2 = item2.getItemMeta();
     meta2.setDisplayName(ChatColor.GOLD + getConfig().getString("artifact-names.speed-boots"));
     ArrayList<String> lore2 = new ArrayList<>();
     lore2.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Wear these to gain speed!");
     meta2.setLore(lore2);
     item2.setItemMeta(meta2);
     menu.addItem(new ItemStack[] { item2 });


     ItemStack item3 = new ItemStack(Material.FIREWORK_ROCKET);
     ItemMeta meta3 = item3.getItemMeta();
     meta3.setDisplayName(ChatColor.GOLD + getConfig().getString("artifact-names.fire-work-arrow"));
     ArrayList<String> lore3 = new ArrayList<>();
     lore3.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Shoots out fireworks!");
     meta3.setLore(lore3);
     item3.setItemMeta(meta3);
     menu.addItem(new ItemStack[] { item3 });

     ItemStack item4 = new ItemStack(Material.POTION);
     ItemMeta meta4 = item4.getItemMeta();
     meta4.setDisplayName(ChatColor.GOLD + getConfig().getString("artifact-names.satchel-of-elements"));
     ArrayList<String> lore4 = new ArrayList<>();
     lore4.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Has a chance to spawn lightning or set on fire to mobs!");
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
     meta1.setDisplayName(ChatColor.GOLD + getConfig().getString("artifact-names.light-feather"));
     ArrayList<String> lore1 = new ArrayList<>();
     lore1.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Boosts you in the direction you're looking.");
     meta1.setLore(lore1);
     item1.setItemMeta(meta1);
     menu.addItem(new ItemStack[] { item1 });


     ItemStack item2 = new ItemStack(Material.APPLE);
     ItemMeta meta2 = item2.getItemMeta();
     meta2.setDisplayName(ChatColor.GOLD + getConfig().getString("artifact-names.totem-of-regeneration"));
     ArrayList<String> lore2 = new ArrayList<>();
     lore2.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns a regeneration pad!");
     meta2.setLore(lore2);
     item2.setItemMeta(meta2);
     menu.addItem(new ItemStack[] { item2 });


     ItemStack item3 = new ItemStack(Material.END_ROD);
     ItemMeta meta3 = item3.getItemMeta();
     meta3.setDisplayName(ChatColor.GOLD + getConfig().getString("artifact-names.lightning-rod"));
     ArrayList<String> lore3 = new ArrayList<>();
     lore3.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns lightning wherever you look!");
     meta3.setLore(lore3);
     item3.setItemMeta(meta3);
     menu.addItem(new ItemStack[] { item3 });


     ItemStack item4 = new ItemStack(Material.FEATHER);
     ItemMeta meta4 = item4.getItemMeta();
     meta4.setDisplayName(ChatColor.GOLD + getConfig().getString("artifact-names.wind-horn"));
     ArrayList<String> lore4 = new ArrayList<>();
     lore4.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Blows entities away!");
     meta4.setLore(lore4);
     item4.setItemMeta(meta4);
     menu.addItem(new ItemStack[] { item4 });

     ItemStack item5 = new ItemStack(Material.POTION);
     ItemMeta meta5 = item5.getItemMeta();
     meta5.setDisplayName(ChatColor.GOLD + getConfig().getString("artifact-names.corrupted-seeds"));
     ArrayList<String> lore5 = new ArrayList<>();
     lore5.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawns a poison cloud!");
     meta5.setLore(lore5);
     item5.setItemMeta(meta5);
     menu.addItem(new ItemStack[] { item5 });

     ItemStack item6 = new ItemStack(Material.STICK);
     ItemMeta meta6 = item6.getItemMeta();
     meta6.setDisplayName(ChatColor.GOLD + getConfig().getString("artifact-names.ice-wand"));
     ArrayList<String> lore6 = new ArrayList<>();
     lore6.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Look at a enemy and click! Its now frozen!");
     meta6.setLore(lore6);
     item6.setItemMeta(meta6);
     menu.addItem(new ItemStack[] { item6 });

     ItemStack item7 = new ItemStack(Material.BELL);
     ItemMeta meta7 = item7.getItemMeta();
     meta1.setDisplayName(ChatColor.GOLD + getConfig().getString("artifact-names.kong-of-weakening"));
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
     meta1.setDisplayName(ChatColor.GOLD + getConfig().getString("armor-names.ember-robe"));
     ArrayList<String> lore1 = new ArrayList<>();
     lore1.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "When you get near entities they get set on fire!");

     meta1.setLore(lore1);
     item1.setItemMeta(meta1);
     menu.addItem(new ItemStack[] { item1 });

     ItemStack item2 = new ItemStack(Material.NETHERITE_CHESTPLATE);
     ItemMeta meta2 = item2.getItemMeta();
     meta2.setDisplayName(ChatColor.GOLD + getConfig().getString("armor-names.wither-armor"));
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
     meta1.setDisplayName(ChatColor.GOLD + getConfig().getString("bow-names.rapid-crossbow"));
     ArrayList<String> lore1 = new ArrayList<>();
     lore1.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "There is no delay, unlike a normal bow.");
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