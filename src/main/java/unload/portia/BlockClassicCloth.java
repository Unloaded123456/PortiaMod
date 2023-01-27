package unload.portia;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import unload.portia.IBlockMetadata;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import unload.portia.IBlockMetadata;

public class BlockClassicCloth extends Block implements IBlockMetadata {

	IIcon[] icons = new IIcon[this.names.length];

	public BlockClassicCloth(Material material) {
		super(material);

	}

	@Override
	public void registerBlockIcons(IIconRegister reg) {
		for (int i = 0; i < names.length; i++) {
			this.icons[i] = reg.registerIcon(this.textureName + "_" + names[i]);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return this.icons[meta];
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < this.names.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(int meta) {
		return this.getUnlocalizedName() + "_" +names[meta%names.length];
	}
	
	public static final String[] names = { "red", "orange", "yellow", "chartreuse", "green", "spring_green", "cyan", "capri", "ultramarine", "violet", "purple", "magenta", "rose", "dark_gray", "light_gray", "white" };
}
