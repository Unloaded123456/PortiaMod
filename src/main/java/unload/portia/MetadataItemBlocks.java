package unload.portia;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class MetadataItemBlocks extends ItemBlockWithMetadata {
	
	public MetadataItemBlocks(Block block) {
		super(block,block);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int d=stack.getItemDamage();
		if (this.field_150939_a instanceof IBlockMetadata) {
			return ((IBlockMetadata)this.field_150939_a).getUnlocalizedName(d);
		} else {
			return super.getUnlocalizedName(stack);
		}
	}
	
}
