package me.mcosta.cellularfilter;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CellularFilter extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler(priority = EventPriority.HIGH)
    void onChat(AsyncPlayerChatEvent event) {

        boolean find =  false;

        String msg= event.getMessage().replace(" ", "");

        msg=msg.replaceAll("uno","1");
        msg=msg.replaceAll("due","2");
        msg=msg.replaceAll("tre","3");
        msg=msg.replaceAll("quattro","4");
        msg=msg.replaceAll("cinque","5");
        msg=msg.replaceAll("sei","6");
        msg=msg.replaceAll("sette","7");
        msg=msg.replaceAll("otto","8");
        msg=msg.replaceAll("nome","9");

        Pattern pattern = Pattern.compile("\\d{9}");
        Matcher matcher = pattern.matcher(event.getMessage());

        if (matcher.find() || msg.contains("+39") || msg.contains("33")) find=true;
        if(msg.replaceAll("\\D", "").length() >= 7) find=true;




        if(find){
            getLogger().info(event.getPlayer().getDisplayName() +" ha inviato un numero di telefono in chat : "+ event.getMessage());
            event.getPlayer().sendMessage("Non puoi inviare numeri di telefono in chat!");
            event.setCancelled(true);
        }





    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
