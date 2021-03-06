package tombenpotter.sanguimancy.compat.lua.methods;

import tombenpotter.sanguimancy.tile.TileBloodInterface;
import net.minecraft.tileentity.TileEntity;

public class LuaGetOwner extends LuaMethod{
    public LuaGetOwner() {
        super("getOwner");
    }

    @Override
    public Object[] call(TileEntity te, Object[] args) {
        if (te instanceof TileBloodInterface)
        {
            return new String[]{((TileBloodInterface)te).getOwner()};
        }
        return new Object[0];
    }

    @Override
    public String[] getDetails() {
        return new String[0];
    }
}
