package net.minecraft.client;

import my.chimera.util.ClientSetting;

public class ClientBrandRetriever
{
    public static String getClientModName()
    {
        return ClientSetting.fakeForge.getValue() ? "fml,forge" : "vanilla";
    }
}
