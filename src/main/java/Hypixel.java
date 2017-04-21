import me.bluesnapple.commands.Test;
import org.bukkit.plugin.java.JavaPlugin;

public class Hypixel extends JavaPlugin{

    @Override
    public void onEnable(){
        //Shows our enable messsage
        getLogger().info(getDescription().getName() + " was enabled!");

        getCommand("test").setExecutor(new Test());
    }

    @Override
    public void onDisable(){
        //Shows our disable message
        getLogger().info(getDescription().getName() + " was disabled!");
    }

}
