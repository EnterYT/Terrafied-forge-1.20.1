package net.enter.terrafied.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NyxEssenceGlassBottle extends Item {
    public NyxEssenceGlassBottle(Properties pProperties) {
        super(pProperties
                .durability(32)
                .setNoRepair()
        );
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity,
                              int pSlotId, boolean pIsSelected) {
        if (pLevel.isClientSide) return;

        if (pEntity instanceof Player player) {
            if (pLevel.getGameTime() % 20 == 0) {
                pStack.hurtAndBreak(1, player, (p) ->
                        p.broadcastBreakEvent(InteractionHand.MAIN_HAND));

                if (pStack.getDamageValue() >= pStack.getMaxDamage()){
                    player.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1));
                    player.getInventory().removeItem(pStack);
                }
            }
        }
    }
}
