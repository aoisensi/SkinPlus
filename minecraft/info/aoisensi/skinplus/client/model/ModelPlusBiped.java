package info.aoisensi.skinplus.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPlusBiped extends ModelBiped {
	
    public ModelRenderer plusTest;
	
    public ModelPlusBiped()
    {
        this(0.0F);
    }

    public ModelPlusBiped(float par1)
    {
        this(par1, 0.0F, 64, 32);
    }

    public ModelPlusBiped(float par1, float par2, int par3, int par4)
    {
    	super(par1, par2, par3, par4);
        this.plusTest = new ModelRenderer(this, 0, 0);
        this.plusTest.addBox(-8.0F, -16.0F, -8.0F, 8, 8, 8, par1);
        this.plusTest.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
    }
    
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
    	super.render(par1Entity, par2, par3, par4, par5, par6, par7);
    	this.plusTest.render(par7);
    }
}
