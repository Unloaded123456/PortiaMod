package unload.portia.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class LapisArmor extends ItemArmor {
    public LapisArmor(ArmorMaterial armorMaterial, int renderIndex, int armorType) {
        super(armorMaterial, renderIndex, armorType);
    }
    @Override
    public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
        if(this.armorType == 2) {
            return "portia:textures/models/armor/lapis_layer_2.png";
        }
        return "portia:textures/models/armor/lapis_layer_1.png";
    }
}
