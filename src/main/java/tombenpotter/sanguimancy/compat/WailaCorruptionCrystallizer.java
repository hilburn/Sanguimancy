package tombenpotter.sanguimancy.compat;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import tombenpotter.sanguimancy.blocks.BlockCorruptionCrystallizer;
import tombenpotter.sanguimancy.tile.TileCorruptionCrystallizer;

import java.util.List;

public class WailaCorruptionCrystallizer implements IWailaDataProvider {

    public static void register(IWailaRegistrar registrar) {
        registrar.registerBodyProvider(new WailaCorruptionCrystallizer(), BlockCorruptionCrystallizer.class);
    }

    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        boolean isCrystallizer = accessor.getTileEntity() instanceof TileCorruptionCrystallizer;
        if (isCrystallizer) {
            TileCorruptionCrystallizer tile = (TileCorruptionCrystallizer) accessor.getTileEntity();
            currenttip.add(StatCollector.translateToLocal("compat.waila.multiblock.formed") + ": " + String.valueOf(tile.multiblockFormed));
            currenttip.add(StatCollector.translateToLocal("compat.waila.corruption.stored") + ": " + String.valueOf(tile.corruptionStored));
            currenttip.add(StatCollector.translateToLocal("compat.waila.owner") + ": " + tile.owner);
        }
        return currenttip;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }
}