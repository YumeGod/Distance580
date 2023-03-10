package cms.mortalchen.chimera.irc.utils.packets.clientside;


import cms.mortalchen.chimera.irc.utils.packets.IRCPacket;
import cms.mortalchen.chimera.irc.utils.packets.IRCType;

public class ClientChatPacket extends IRCPacket {
    public String s = "";
    public ClientChatPacket(long time,String content){
        super(time,content, IRCType.CHAT);
    }

    @Override
    public String toJson(){
        jsonObject.put("side","client");
        jsonObject.put("time", time);
        jsonObject.put("content", content);
        jsonObject.put("type", type.name());
        return jsonObject.toString();
    }
}
