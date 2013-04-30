package info.aoisensi.skinplus.client.renderer.entity;

import info.aoisensi.skinplus.SkinPlus;
import info.aoisensi.skinplus.SkinPlusDownloader;
import info.aoisensi.skinplus.client.model.ModelPlusBiped;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderPlusPlayer extends RenderPlayer
{
	
	private ModelBiped modelBipedMainSub;
	
	public RenderPlusPlayer()
	{
		super();
		this.modelBipedMainSub = (ModelBiped)this.mainModel;
	}
	
	public void changeModelBiped(EntityPlayer par1EntityPlayer)
	{
		String username = par1EntityPlayer.username;
		if(SkinPlus.instance.RenderPlusMap.containsKey(username))
		{
			ModelPlusBiped modelPlusBiped = SkinPlus.instance.RenderPlusMap.get(username);
			if(modelPlusBiped != null) {
				//DLされたらDLするスレッドから辞書に追記する
				this.mainModel = (ModelBiped)modelPlusBiped;
			} else {
				//nullならDL中orDL失敗
				this.mainModel = modelBipedMainSub;
			}
		} else {
			//存在してなかったらとりあえずnullを入れとく
			SkinPlus.instance.RenderPlusMap.put(username, null);
			//んで、DL開始
			SkinPlusDownloader skinPlusDownloader = new SkinPlusDownloader(username);
			skinPlusDownloader.start();
			
			this.mainModel = modelBipedMainSub;
		}
	}
	
	public void renderPlayer(EntityPlayer par1EntityPlayer, double par2, double par4, double par6, float par8, float par9)
	{
		changeModelBiped(par1EntityPlayer);
		super.renderPlayer(par1EntityPlayer, par2, par4, par6, par8, par9);
	}
	
	public void renderFirstPersonArm(EntityPlayer par1EntityPlayer)
	{
		changeModelBiped(par1EntityPlayer);
		super.renderFirstPersonArm(par1EntityPlayer);
	}
}