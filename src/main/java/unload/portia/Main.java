package unload.portia;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import unload.portia.*;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.block.material.Material;

import cpw.mods.fml.common.registry.GameRegistry;
@Mod(modid = "portia", name = "Portia", version = "0.1.1")
public class Main {
	public static Block oldCloth;
    public static Block barrier;
    public static Block newConcrete;
    public static Block glazedTerracotta;
    public static Block coloredWood;
    public static Block coloredStone;
    public static Item chain;
    public static Item ironNugget;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		oldCloth = new BlockClassicCloth(Material.cloth).setBlockName("cloth").setStepSound(Block.soundTypeCloth).setHardness(0.8F).setBlockTextureName("portia:cloth").setCreativeTab(portiaBlocks);
        GameRegistry.registerBlock(oldCloth, MetadataItemBlocks.class, "cloth");
        barrier = new BlockBorder(Material.rock).setBlockName("barrier").setBlockTextureName("portia:barrier").setHardness(-1.0F).setResistance(3600000F).setCreativeTab(portiaBlocks);
        GameRegistry.registerBlock(barrier, "barrier");
        newConcrete = new BlockColored(Material.rock).setBlockName("concrete").setHardness(1.8F).setResistance(1.8F).setBlockTextureName("portia:concrete").setCreativeTab(portiaBlocks);
        GameRegistry.registerBlock(newConcrete, MetadataItemBlocks.class, "concrete");
        glazedTerracotta = new BlockColored(Material.rock).setBlockName("glazedTerracotta").setBlockTextureName("portia:glazed_terracotta").setCreativeTab(portiaBlocks);
        GameRegistry.registerBlock(glazedTerracotta, MetadataItemBlocks.class, "glazed_stained_clay");
        coloredWood = new BlockColored(Material.wood).setBlockName("woodColored").setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockTextureName("portia:woodcolored").setCreativeTab(portiaBlocks);
        GameRegistry.registerBlock(coloredWood, MetadataItemBlocks.class, "colored_wood");
        coloredStone = new BlockColored(Material.rock).setBlockName("stoneColored").setHardness(1.5F).setResistance(10F).setBlockTextureName("portia:stonecolored").setCreativeTab(portiaBlocks);
        GameRegistry.registerBlock(coloredStone, MetadataItemBlocks.class, "colored_stone");

        chain = new Item().setUnlocalizedName("chain").setTextureName("portia:chain").setCreativeTab(portiaItems);
        GameRegistry.registerItem(chain, "chain");
        ironNugget = new Item().setUnlocalizedName("ironNugget").setTextureName("portia:iron_nugget").setCreativeTab(portiaItems);
        GameRegistry.registerItem(ironNugget, "iron_nugget");
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.addRecipe(new ItemStack(Items.iron_horse_armor), new Object[]{"  I", "IWI", "III", 'I', Items.iron_ingot, 'W', Blocks.wool});
        GameRegistry.addRecipe(new ItemStack(Items.golden_horse_armor), new Object[]{"  I", "IWI", "III", 'I', Items.gold_ingot, 'W', Blocks.wool});
        GameRegistry.addRecipe(new ItemStack(Items.diamond_horse_armor), new Object[]{"  I", "IWI", "III", 'I', Items.diamond, 'W', Blocks.wool});
        GameRegistry.addRecipe(new ItemStack(Items.saddle), new Object[]{"LLL", "LIL", "I I", 'L', Items.leather, 'I', Items.iron_ingot});
        GameRegistry.addRecipe(new ItemStack(Items.chainmail_helmet), new Object[]{"NNN", "N N", 'N', chain});
        GameRegistry.addRecipe(new ItemStack(Items.chainmail_chestplate), new Object[]{"N N", "NNN", "NNN", 'N', chain});
        GameRegistry.addRecipe(new ItemStack(Items.chainmail_leggings), new Object[]{"NNN", "N N", "N N", 'N', chain});
        GameRegistry.addRecipe(new ItemStack(Items.chainmail_boots), new Object[]{"N N", "N N", 'N', chain});

        GameRegistry.addRecipe(new ItemStack(chain), new Object[]{"C", "C", "C", 'C', ironNugget});
        GameRegistry.addRecipe(new ItemStack(ironNugget, 9), new Object[]{"I", 'I', Items.iron_ingot});
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
    public static CreativeTabs portiaBlocks = new CreativeTabs("portiaBlocks") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(oldCloth).getItem();
        }
    };
    public static CreativeTabs portiaItems = new CreativeTabs("portiaItems") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(chain).getItem();
        }
    };

}