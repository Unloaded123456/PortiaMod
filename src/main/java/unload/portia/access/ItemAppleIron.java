package unload.portia.access.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import java.util.List;

public class ItemAppleIron extends ItemAppleGold {
    public ItemAppleIron(int p_i45341_1_, float p_i45341_2_, boolean p_i45341_3_) {
        super(p_i45341_1_, p_i45341_2_, p_i45341_3_);
        this.setHasSubtypes(true);
    }
    @SuppressWarnings("unchecked")

    @Override
    public boolean hasEffect(ItemStack itemStack)
    {
        return itemStack.getItemDamage() > 0;
    }
    @Override
    public EnumRarity getRarity(ItemStack itemStack) {
        if(itemStack.getItemDamage() == 0) {
            return EnumRarity.uncommon;
        }
        if(itemStack.getItemDamage() == 1) {
            return EnumRarity.rare;
        }
        return EnumRarity.common;
    }
    @Override
    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        if(!world.isRemote) {
            player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 1800, 0));
        }
        if(itemStack.getItemDamage() == 1) {
            if(!world.isRemote) {
                player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 500, 2));
                player.addPotionEffect(new PotionEffect(Potion.resistance.id, 4500, 0));
            }
        }
        else {
            super.onFoodEaten(itemStack, world, player);
        }
    }
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
    }
}
