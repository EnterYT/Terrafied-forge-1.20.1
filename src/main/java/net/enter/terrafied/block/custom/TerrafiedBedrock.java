package net.enter.terrafied.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class TerrafiedBedrock extends Block {
    public TerrafiedBedrock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public float getDestroyProgress(BlockState pState, Player pPlayer, BlockGetter pLevel, BlockPos pPos) {
        return 100.0F;
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);

        if (pRandom.nextFloat() < 0.6f){
            double x = pPos.getX() + 0.5 + (pRandom.nextDouble() - 0.5);
            double y = pPos.getY() + 2.0 + (pRandom.nextDouble());
            double z = pPos.getZ() + 0.5 + (pRandom.nextDouble() - 0.5);

            pLevel.addParticle(ParticleTypes.MYCELIUM, x, y, z, 0, 0.5, 0);
        }
    }
}
