package cms.mortalchen.chimera.irc.utils.packets.serverside;


import cms.mortalchen.chimera.irc.utils.packets.IRCPacket;
import cms.mortalchen.chimera.irc.utils.packets.IRCType;

public class ServerChatPacket extends IRCPacket {
    public ServerChatPacket(long time, String content){
        super(time,content, IRCType.CHAT);
    }
    @Override
    public String toJson(){
        jsonObject.put("side","server");
        jsonObject.put("time", time);
        jsonObject.put("content", content);
        jsonObject.put("type", type.name());
        return jsonObject.toString();
    }
}
