package net.enter.terrafied.block.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CrackedBedrock extends Block {
    public CrackedBedrock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);

        if (pRandom.nextFloat() < 0.6f){
            double x = pPos.getX() + 0.5 + (pRandom.nextDouble() - 0.5);
            double y = pPos.getY() + 1.0 + (pRandom.nextDouble() * 2.0);
            double z = pPos.getZ() + 0.5 + (pRandom.nextDouble() - 0.5);

            pLevel.addParticle(ParticleTypes.ASH, x, y - 2, z, 0, 0.5, 0);
            pLevel.addParticle(ParticleTypes.MYCELIUM, x, y, z, 0, 0.5, 0);
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("block.terrafied.cracked_bedrock.desc").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}
