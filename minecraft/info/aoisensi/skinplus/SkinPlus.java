package info.aoisensi.skinplus;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import info.aoisensi.skinplus.client.model.ModelPlusBiped;
import info.aoisensi.skinplus.client.renderer.entity.RenderPlusPlayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="SkinPlus", name="SkinPlus", version="0.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class SkinPlus {
	
	@Instance("SkinPlus")
    public static SkinPlus instance;
	
	public static Field fieldMainModel, fieldModelBipedMain;
	
	public Map<String, ModelPlusBiped> RenderPlusMap = new HashMap<String, ModelPlusBiped>();
	
	
	@PreInit
	public void preLoad(FMLInitializationEvent event) {
		try {
			fieldMainModel = RenderLiving.class.getDeclaredField("mainModel");
			fieldMainModel.setAccessible(true);
			fieldModelBipedMain = RenderPlayer.class.getDeclaredField("mainModel");
			fieldModelBipedMain.setAccessible(true);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new RenderPlusPlayer());
	}
	
}
