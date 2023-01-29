package unload.portia;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import unload.portia.access.*;
import unload.portia.armor.EmeraldArmor;

@Mod(modid = "portia", name = "Portia", version = "0.2")
public class Main {
	public static Block oldCloth;
    public static Block barrier;
    public static Block newConcrete;
    public static Block glazedTerracotta;
    public static Block coloredWood;
    public static Block coloredStone;
    public static Block coloredCobble;
    public static final Item.ToolMaterial emeraldItems = EnumHelper.addToolMaterial("emerald_items", 3, 950, 2.8F, 2.5F, 15);
    public static final ItemArmor.ArmorMaterial emeraldArmor = EnumHelper.addArmorMaterial("emerald_armor", 29, new int[]{3,7,5,3}, 18);
    public static Item chain;
    public static Item ironNugget;
    public static Item emeraldPickaxe;
    public static Item emeraldAxe;
    public static Item emeraldShovel;
    public static Item emeraldHoe;
    public static Item emeraldSword;
    public static Item emeraldHelmet;
    public static Item emeraldChestplate;
    public static Item emeraldLeggings;
    public static Item emeraldBoots;
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
        coloredCobble = new BlockColored(Material.rock).setBlockName("cobbleColored").setBlockTextureName("portia:cobblecolored").setCreativeTab(portiaBlocks);
        GameRegistry.registerBlock(coloredCobble, MetadataItemBlocks.class, "colored_cobblestone");

        chain = new Item().setUnlocalizedName("chain").setTextureName("portia:chain").setCreativeTab(portiaItems);
        GameRegistry.registerItem(chain, "chain");
        ironNugget = new Item().setUnlocalizedName("ironNugget").setTextureName("portia:iron_nugget").setCreativeTab(portiaItems);
        GameRegistry.registerItem(ironNugget, "iron_nugget");
        emeraldPickaxe = new ModPickaxe(emeraldItems).setUnlocalizedName("emeraldPickaxe").setTextureName("portia:emerald_pickaxe").setCreativeTab(portiaItems);
        GameRegistry.registerItem(emeraldPickaxe, "emerald_pickaxe");
        emeraldAxe = new ModAxe(emeraldItems).setUnlocalizedName("emeraldAxe").setTextureName("portia:emerald_axe").setCreativeTab(portiaItems);
        GameRegistry.registerItem(emeraldAxe, "emerald_axe");
        emeraldShovel = new ModSpade(emeraldItems).setUnlocalizedName("emeraldShovel").setTextureName("portia:emerald_shovel").setCreativeTab(portiaItems);
        GameRegistry.registerItem(emeraldShovel, "emerald_shovel");
        emeraldHoe = new ModHoe(emeraldItems).setUnlocalizedName("emeraldHoe").setTextureName("portia:emerald_hoe").setCreativeTab(portiaItems);
        GameRegistry.registerItem(emeraldHoe, "emerald_hoe");
        emeraldSword = new ModSword(emeraldItems).setUnlocalizedName("emeraldSword").setTextureName("portia:emerald_sword").setCreativeTab(portiaItems);
        GameRegistry.registerItem(emeraldSword, "emerald_sword");
        emeraldHelmet = new EmeraldArmor(emeraldArmor, 0, 0).setUnlocalizedName("emeraldHelmet").setTextureName("portia:emerald_helmet").setCreativeTab(portiaItems);
        GameRegistry.registerItem(emeraldHelmet, "emerald_helmet");
        emeraldChestplate = new EmeraldArmor(emeraldArmor, 0, 1).setUnlocalizedName("emeraldChestplate").setTextureName("portia:emerald_chestplate").setCreativeTab(portiaItems);
        GameRegistry.registerItem(emeraldChestplate, "emerald_chestplate");
        emeraldLeggings = new EmeraldArmor(emeraldArmor, 0, 2).setUnlocalizedName("emeraldLeggings").setTextureName("portia:emerald_leggings").setCreativeTab(portiaItems);
        GameRegistry.registerItem(emeraldLeggings, "emerald_leggings");
        emeraldBoots = new EmeraldArmor(emeraldArmor, 0, 3).setUnlocalizedName("emeraldBoots").setTextureName("portia:emerald_boots").setCreativeTab(portiaItems);
        GameRegistry.registerItem(emeraldBoots, "emerald_boots");
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
        GameRegistry.addRecipe(new ItemStack(emeraldPickaxe), new Object[]{"EEE", " S ", " S ", 'E', Items.emerald, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(emeraldAxe), new Object[]{"EE", "ES", " S", 'E', Items.emerald, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(emeraldShovel), new Object[]{"E", "S", "S", 'E', Items.emerald, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(emeraldHoe), new Object[]{"EE", " S", " S", 'E', Items.emerald, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(emeraldSword), new Object[]{"E", "E", "S", 'E', Items.emerald, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(emeraldHelmet), new Object[]{"EEE", "E E", 'E', Items.emerald});
        GameRegistry.addRecipe(new ItemStack(emeraldChestplate), new Object[]{"E E", "EEE", "EEE", 'E', Items.emerald});
        GameRegistry.addRecipe(new ItemStack(emeraldLeggings), new Object[]{"EEE", "E E", "E E", 'E', Items.emerald});
        GameRegistry.addRecipe(new ItemStack(emeraldBoots), new Object[]{"E E", "E E", 'E', Items.emerald});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 0), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 1), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 2), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 2)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 3), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 3)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 4), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 4)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 5), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 5)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 6), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 6)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 7), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 7)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 8), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 8)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 9), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 9)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 10), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 10)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 11), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 11)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 12), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 12)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 13), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 13)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 14), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 14)});
        GameRegistry.addRecipe(new ItemStack(oldCloth, 1, 15), new Object[]{"W", 'W', new ItemStack(Blocks.wool, 1, 15)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 0), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 1), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 2), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 2)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 3), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 3)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 4), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 4)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 5), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 5)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 6), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 6)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 7), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 7)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 8), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 8)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 9), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 9)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 10), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 10)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 11), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 11)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 12), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 12)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 13), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 13)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 14), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 14)});
        GameRegistry.addRecipe(new ItemStack(Blocks.wool, 1, 15), new Object[]{"W", 'W', new ItemStack(oldCloth, 1, 15)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 0), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 15), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 1), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 14), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 2), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 13), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 3), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 12), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 4), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 11), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 5), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 10), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 6), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 9), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 7), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 8), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 8), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 7), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 9), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 6), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 10), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 5), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 11), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 4), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 12), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 3), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 13), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 2), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 14), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 1), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredWood, 1, 15), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 0), 'S', new ItemStack(Blocks.planks)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 0), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 15), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 1), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 14), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 2), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 13), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 3), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 12), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 4), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 11), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 5), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 10), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 6), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 9), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 7), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 8), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 8), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 7), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 9), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 6), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 10), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 5), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 11), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 4), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 12), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 3), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 13), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 2), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 14), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 1), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredCobble, 1, 15), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 0), 'S', new ItemStack(Blocks.cobblestone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 0), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 15), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 1), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 14), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 2), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 13), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 3), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 12), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 4), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 11), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 5), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 10), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 6), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 9), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 7), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 8), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 8), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 7), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 9), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 6), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 10), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 5), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 11), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 4), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 12), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 3), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 13), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 2), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 14), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 1), 'S', new ItemStack(Blocks.stone)});
        GameRegistry.addRecipe(new ItemStack(coloredStone, 1, 15), new Object[]{" D ", "DSD", " D ", 'D', new ItemStack(Items.dye, 1, 0), 'S', new ItemStack(Blocks.stone)});

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
