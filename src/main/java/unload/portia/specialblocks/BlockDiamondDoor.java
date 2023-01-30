package unload.portia.specialblocks;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import unload.portia.Main;

import java.util.Random;

public class BlockDiamondDoor extends BlockDoor {
    public BlockDiamondDoor(Material material) {
        super(material);
    }
    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return (p_149650_1_ & 8) != 0 ? null : Main.diamondDoorI;
    }
    @Override
    public Item getItem(World world, int x, int y, int z) {
        return Main.diamondDoorI;
    }
}
