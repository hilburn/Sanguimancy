package tombenpotter.sanguimancy.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import tombenpotter.sanguimancy.entity.EntityChickenMinion;

@SideOnly(Side.CLIENT)
public class RenderChickenMinion extends RenderLiving {
    private static final ResourceLocation chickenTextures = new ResourceLocation("textures/entity/chicken.png");

    public RenderChickenMinion(ModelBase p_i1252_1_, float p_i1252_2_) {
        super(p_i1252_1_, p_i1252_2_);
    }

    public void doRender(EntityChickenMinion p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        super.doRender((EntityLiving) p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(EntityChickenMinion p_110775_1_) {
        return chickenTextures;
    }

    protected float handleRotationFloat(EntityChickenMinion p_77044_1_, float p_77044_2_) {
        float f1 = p_77044_1_.field_70888_h + (p_77044_1_.field_70886_e - p_77044_1_.field_70888_h) * p_77044_2_;
        float f2 = p_77044_1_.field_70884_g + (p_77044_1_.destPos - p_77044_1_.field_70884_g) * p_77044_2_;
        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    public void doRender(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityChickenMinion) p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected float handleRotationFloat(EntityLivingBase p_77044_1_, float p_77044_2_) {
        return this.handleRotationFloat((EntityChickenMinion) p_77044_1_, p_77044_2_);
    }

    public void doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityChickenMinion) p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((EntityChickenMinion) p_110775_1_);
    }

    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
        this.doRender((EntityChickenMinion) p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}