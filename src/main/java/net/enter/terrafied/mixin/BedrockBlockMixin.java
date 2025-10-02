package net.enter.terrafied.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.world.level.block.Block.class)
public class BedrockBlockMixin {

    @Inject(method = "", at = @At("HEAD"), cancellable = true)
    private void makeBedrockBreakable(BlockState pState, BlockGetter pWorld, BlockPos pPos, CallbackInfoReturnable<Float> pCir){
        if(pState.is(Blocks.BEDROCK)) {
            pCir.setReturnValue(15.0F);
        }
    }
}
