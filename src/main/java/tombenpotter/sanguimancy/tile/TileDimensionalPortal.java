package tombenpotter.sanguimancy.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeChunkManager;
import tombenpotter.sanguimancy.Sanguimancy;
import tombenpotter.sanguimancy.util.RandomUtils;

public class TileDimensionalPortal extends TileEntity {

    public String portalID;
    public int masterStoneX;
    public int masterStoneY;
    public int masterStoneZ;
    private ForgeChunkManager.Ticket chunkTicket;

    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        portalID = tag.getString("PortalRitualID");
        masterStoneX = tag.getInteger("masterStoneX");
        masterStoneY = tag.getInteger("masterStoneY");
        masterStoneZ = tag.getInteger("masterStoneZ");
    }

    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setString("PortalRitualID", portalID);
        tag.setInteger("masterStoneX", masterStoneX);
        tag.setInteger("masterStoneY", masterStoneY);
        tag.setInteger("masterStoneZ", masterStoneZ);
    }

    public void requestTicket() {
        chunkTicket = ForgeChunkManager.requestTicket(Sanguimancy.instance, worldObj, ForgeChunkManager.Type.NORMAL);
        chunkTicket.getModData().setInteger("tileX", xCoord);
        chunkTicket.getModData().setInteger("tileY", yCoord);
        chunkTicket.getModData().setInteger("tileZ", zCoord);
        RandomUtils.ChunkloadingUtils.forceChunks(chunkTicket, this);
    }

    public void releaseTicket() {
        RandomUtils.ChunkloadingUtils.unforceChunks(chunkTicket);
    }

    @Override
    public void invalidate() {
        RandomUtils.ChunkloadingUtils.unforceChunks(chunkTicket);
        super.invalidate();
    }
}
