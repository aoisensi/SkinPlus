package info.aoisensi.skinplus;

import java.util.HashMap;
import java.util.Map;

import info.aoisensi.skinplus.client.renderer.entity.RenderPlusPlayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="SkinPlus", name="SkinPlus", version="0.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class SkinPlus {
	
	@Instance("SkinPlus")
    public static SkinPlus instance;
	
	@Init
	public void load(FMLInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new RenderPlusPlayer());
	}
	
	public Map<String, RenderPlus> RenderPlusMap = new HashMap<String, RenderPlus>();
}
