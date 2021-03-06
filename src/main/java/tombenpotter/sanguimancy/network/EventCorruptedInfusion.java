package tombenpotter.sanguimancy.network;

import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;
import tombenpotter.sanguimancy.recipes.RecipeCorruptedInfusion;

public class EventCorruptedInfusion extends Event {

    public final RecipeCorruptedInfusion recipeCorruptedInfusion;

    public EventCorruptedInfusion(RecipeCorruptedInfusion recipe) {
        this.recipeCorruptedInfusion = recipe;
    }

    @Cancelable
    public static class EventPlayerCorruptedInfusion extends EventCorruptedInfusion {

        public final EntityPlayer entityPlayer;

        public EventPlayerCorruptedInfusion(EntityPlayer player, RecipeCorruptedInfusion recipe) {
            super(recipe);
            this.entityPlayer = player;
        }
    }
}
