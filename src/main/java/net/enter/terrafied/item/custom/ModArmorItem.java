package net.enter.terrafied.item.custom;

import com.google.common.collect.ImmutableMap;
import net.enter.terrafied.item.ModArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial, List<MobEffectInstance>>()
                    .put(ModArmorMaterials.BEDROCK, List.of(
                            new MobEffectInstance(MobEffects.ABSORPTION, 200, 3, false, false, true),
                            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 3, false, false, true)
                    ))
                    .build();

    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!level.isClientSide()) {
            if (hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> effects = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                for (MobEffectInstance effect : effects) {
                    addStatusEffectForMaterial(player, mapArmorMaterial, effect);
                }
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial material, MobEffectInstance effect) {
        player.addEffect(new MobEffectInstance(effect));
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !chestplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        ItemStack bootsStack = player.getInventory().getArmor(0);
        ItemStack leggingsStack = player.getInventory().getArmor(1);
        ItemStack chestplateStack = player.getInventory().getArmor(2);
        ItemStack helmetStack = player.getInventory().getArmor(3);

        if (bootsStack.isEmpty() || leggingsStack.isEmpty() || chestplateStack.isEmpty() || helmetStack.isEmpty()) {
            return false;
        }

        ArmorItem boots = (ArmorItem) bootsStack.getItem();
        ArmorItem leggings = (ArmorItem) leggingsStack.getItem();
        ArmorItem chestplate = (ArmorItem) chestplateStack.getItem();
        ArmorItem helmet = (ArmorItem) helmetStack.getItem();

        return boots.getMaterial() == material &&
                leggings.getMaterial() == material &&
                chestplate.getMaterial() == material &&
                helmet.getMaterial() == material;
    }
}
