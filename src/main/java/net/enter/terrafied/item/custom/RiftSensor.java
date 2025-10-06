package net.enter.terrafied.item.custom;

import net.enter.terrafied.block.ModBlocks;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RiftSensor extends Item {
    public RiftSensor(Properties pProperties){
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            Player player = pContext.getPlayer();
            BlockPos clickedPos = pContext.getClickedPos();

            var chunk = pContext.getLevel().getChunkAt(clickedPos);

            boolean foundOre = false;

            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    for (int y = pContext.getLevel().getMinBuildHeight(); y < pContext.getLevel().getMaxBuildHeight(); y++) {
                        BlockPos checkPos = chunk.getPos().getBlockAt(x, y, z);
                        BlockState state = pContext.getLevel().getBlockState(checkPos);

                        if (isValuableBlock(state)) {
                            foundOre = true;
                            break;
                        }
                    }
                    if (foundOre) break;
                }
                if (foundOre) break;
            }

            if (foundOre) {
                player.sendSystemMessage(Component.literal("Tool pulls down to unknown force underneath in this chunk!"));
            } else {
                player.sendSystemMessage(Component.literal("No response."));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModBlocks.CRACKED_BEDROCK.get());
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.terrafied.rift_sensor"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
