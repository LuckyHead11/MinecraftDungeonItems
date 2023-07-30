/*    */ package me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.Artifacts;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import java.util.Random;
/*    */ import me.notjoshy.minecraftdungeonitems.minecraftdungeonitems.MinecraftDungeonItems;
import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Particle;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.IronGolem;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

/*    */
/*    */ public class golem_kit implements Listener {
/*    */   MinecraftDungeonItems plugin;
/*    */   
/*    */   public golem_kit(MinecraftDungeonItems plugin) {
/* 28 */     this.plugin = plugin;
/*    */   }
/*    */
/*    */   @EventHandler
/*    */   public void onInteract(PlayerInteractEvent e) {
/* 33 */     final Random rand = new Random();
/* 34 */     ItemStack item = new ItemStack(Material.PUMPKIN);
/* 35 */     ItemMeta meta = item.getItemMeta();
/* 36 */     meta.setDisplayName(ChatColor.GOLD + plugin.getConfig().getString("artifact-names.golem-kit"));
/* 37 */     ArrayList<String> lore = new ArrayList<>();
/* 38 */     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawn Iron Golems for 10s!");
/* 39 */     lore.add(ChatColor.GREEN + "SPECIAL: Has a 30% Chance to set fire nearby enemies when it dies");
/* 40 */     meta.setLore(lore);
/* 41 */     item.setItemMeta(meta);
/* 42 */     Player player = e.getPlayer();
/* 43 */     if (e.getAction().equals(Action.RIGHT_CLICK_AIR) &&
/* 44 */       Objects.equals(((ItemMeta)Objects.<ItemMeta>requireNonNull(player.getInventory().getItemInMainHand().getItemMeta())).getLore(), item.getItemMeta().getLore())) {
/* 45 */       Location loc = player.getLocation();
/* 46 */       final World world = player.getWorld();
/* 47 */       final IronGolem golem = (IronGolem)world.spawnEntity(loc, EntityType.IRON_GOLEM);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 68 */       BukkitTask bukkitTask = (new BukkitRunnable() { public void run() { world.spawnParticle(Particle.CLOUD, golem.getLocation(), 50, 0.0D, 0.0D, 0.0D); world.playSound(golem.getLocation(), Sound.ENTITY_CHICKEN_EGG, 20.0F, 1.0F); Location golemLocation = golem.getLocation(); int a = rand.nextInt(100); if (a <= 30) for (Entity entity : golem.getNearbyEntities(15.0D, 15.0D, 15.0D)) { if (!entity.getType().equals(EntityType.PLAYER) && !entity.getType().equals(EntityType.IRON_GOLEM)) { int fire = rand.nextInt(200); for (; fire < 20; fire = rand.nextInt(200)); entity.setFireTicks(rand.nextInt(200)); }  }   golem.remove(); } }).runTaskLater((Plugin)this.plugin, 300L);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void onPlace(BlockPlaceEvent e) {
/* 76 */     ItemStack item = new ItemStack(Material.PUMPKIN);
/* 77 */     ItemMeta meta = item.getItemMeta();
/* 78 */     meta.setDisplayName(ChatColor.GOLD + "GolemKit");
/* 79 */     ArrayList<String> lore = new ArrayList<>();
/* 80 */     lore.add(ChatColor.GOLD + "ABILITY: " + ChatColor.GOLD + "Spawn Iron Golems for 10s!");
/* 81 */     lore.add(ChatColor.GREEN + "SPECIAL: Has a 30% Chance to set fire nearby enemies when it dies");
/* 82 */     meta.setLore(lore);
/* 83 */     item.setItemMeta(meta);
/* 84 */     Player player = e.getPlayer();
/* 85 */     if (player.getInventory().getItemInMainHand() != null && 
/* 86 */       e.getPlayer().getInventory().getItemInMainHand().equals(item))
/* 87 */       e.setCancelled(true); 
/*    */   }
/*    */ }


/* Location:              F:\MinecraftDungeonsPlugins - 1.16.5 - 1.20.1.jar!\me\notjoshy\minecraftdungeonitems\Artifacts\golem_kit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */