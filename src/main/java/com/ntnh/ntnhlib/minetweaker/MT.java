package com.ntnh.ntnhlib.minetweaker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import net.minecraft.nbt.NBTTagCompound;

import com.google.common.io.Resources;
import com.ntnh.ntnhlib.ntnhlib;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;

public class MT {

    static {
        if (Loader.isModLoaded("MineTweaker3")) {
            try {
                String data = Resources
                    .toString(Resources.getResource(ntnhlib.class, "/minetweaker/myscript.zs"), StandardCharsets.UTF_8);
                NBTTagCompound nbtData = new NBTTagCompound();
                nbtData.setString("name", "mymod_recipes.zs");
                nbtData.setString("content", data);
                FMLInterModComms.sendMessage("MineTweaker3", "addMineTweakerScript", nbtData);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
