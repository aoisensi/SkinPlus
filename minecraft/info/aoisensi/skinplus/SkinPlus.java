package info.aoisensi.skinplus;

import info.aoisensi.skinplus.client.model.ModelPlusBiped;
import info.aoisensi.skinplus.client.renderer.entity.RenderPlusPlayer;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="SkinPlus", name="SkinPlus", version="0.1.1 develop")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class SkinPlus {
	
	@Mod.Instance("SkinPlus")
    public static SkinPlus instance;
	
	public Map<String, ModelPlusBiped> RenderPlusMap = new HashMap<String, ModelPlusBiped>();
	
	@Mod.Init
	public void load(FMLInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new RenderPlusPlayer());
	}
	
}
