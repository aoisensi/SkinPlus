package info.aoisensi.skinplus.client.model;


import java.util.HashMap;

import org.lwjgl.opengl.GL11;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPlusBiped extends ModelBiped {

	public ModelRenderer plusTest;
	
	public ModelPlusBiped(Document doc)
	{
		this(0.0F, doc);
	}

	public ModelPlusBiped(float par1, Document doc)
	{
		this(par1, 0.0F, 64, 32, doc);
	}

	public ModelPlusBiped(float par1, float par2, int par3, int par4, Document doc)
	{
		super(par1, par2, par3, par4);
		
		HashMap<String, ModelRenderer> parentMap = new HashMap<String, ModelRenderer>() {{
			put("head", bipedHead);
			put("body", bipedBody);
			put("rightarm", bipedRightArm);
			put("leftarm", bipedLeftArm);
			put("rightleg", bipedRightLeg);
			put("leftleg", bipedLeftLeg);
		}};
		
		NodeList parents = doc.getElementsByTagName("model").item(0).getChildNodes();
		for (int i = 0; i < parents.getLength(); i++) {
			Node parent = parents.item(i);
			
			ModelRenderer renderer = parentMap.get(parent.getNodeName());
			
			NodeList children = parent.getChildNodes();
			for(int j = 0; j < children.getLength(); j++) {
				Node child = children.item(j);
				
				if(child.getNodeName() == "box") {
					NamedNodeMap attrs = child.getAttributes();
					ModelRenderer modelRenderer = new ModelRenderer(this,
							Integer.parseInt(attrs.getNamedItem("texx").getNodeValue()),
							Integer.parseInt(attrs.getNamedItem("texy").getNodeValue()));
					
					modelRenderer.addBox(
							Float.parseFloat(attrs.getNamedItem("posx1").getNodeValue()),
							Float.parseFloat(attrs.getNamedItem("posy1").getNodeValue()),
							Float.parseFloat(attrs.getNamedItem("posz1").getNodeValue()),
							Integer.parseInt(attrs.getNamedItem("posx2").getNodeValue()),
							Integer.parseInt(attrs.getNamedItem("posy2").getNodeValue()),
							Integer.parseInt(attrs.getNamedItem("posz2").getNodeValue()));
					
					modelRenderer.setRotationPoint(
							Float.parseFloat(attrs.getNamedItem("rollpx").getNodeValue()),
							Float.parseFloat(attrs.getNamedItem("rollpy").getNodeValue()),
							Float.parseFloat(attrs.getNamedItem("rollpz").getNodeValue()));
					
					modelRenderer.rotateAngleX = Float.parseFloat(attrs.getNamedItem("rollx").getNodeValue());
					modelRenderer.rotateAngleY = Float.parseFloat(attrs.getNamedItem("rolly").getNodeValue());
					modelRenderer.rotateAngleZ = Float.parseFloat(attrs.getNamedItem("rollz").getNodeValue());
					
					renderer.addChild(modelRenderer);
				}
			}
		}
	}
}
