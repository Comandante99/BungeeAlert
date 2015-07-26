package Event;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Alert extends Command
{
	 public Alert()
	  {
	    super("alert", "Alert.msg", new String[0]);
	  }
	  
	  @SuppressWarnings("deprecation")
	  public void execute(CommandSender sender, String[] args)
	  {
		ProxiedPlayer p = (ProxiedPlayer) sender;
	    if (args.length == 0)
	    {
	      sender.sendMessage(ChatColor.RED + "You must add a message!");
	    }
	    else
	    {
	      StringBuilder builder = new StringBuilder();
	      String[] arrayOfString;
	      int j = (arrayOfString = args).length;
	      for (int i = 0; i < j; i++)
	      {
	        String s = arrayOfString[i];
	        builder.append(ChatColor.translateAlternateColorCodes('&', s));
	        builder.append(" ");
	      }
	      String message = builder.substring(0, builder.length() - 1);
	      
	      Title title = ProxyServer.getInstance().createTitle();
	      
	      TextComponent titleComp = new TextComponent("Announcement");
	      titleComp.setBold(Boolean.valueOf(true));
	      titleComp.setColor(ChatColor.BLUE);
	      p.sendMessage(ChatColor.BLUE + "Announcement>" +ChatColor.AQUA + " " +(message));
	      TextComponent titleSubComp = new TextComponent(message);
	      titleSubComp.setColor(ChatColor.AQUA);
	      
	      title.title(titleComp);
	      title.subTitle(titleSubComp);
	      
	      title.fadeIn(40);
	      title.stay(100);
	      title.fadeOut(40);
	      for (ProxiedPlayer proxplayer : ProxyServer.getInstance().getPlayers()) {
	        proxplayer.sendTitle(title);
	      }
	    }
	  }
}
