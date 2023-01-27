package unload.portia;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockBorder extends Block {
    public BlockBorder(Material material) {
        super(material);
    }
    public int getRenderType() {
        return -1;
    }
    public boolean isOpaqueCube() {
        return false;
    }
    public boolean renderAsNormalBlock() {
        return false;
    }
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        return Item.getItemById(0);
    }
}
