package net.fabricmc.example.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Quiver extends Block implements BlockEntityProvider {
    public Quiver(Settings settings) {
        super(settings);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.38f, 0f, 0.38f, 0.69f, 6f/8f, 0.69f); //nice
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new QuiverEntity(pos, state);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack PlayerhandItem = player.getStackInHand(Hand.MAIN_HAND);

        BlockEntity blockEntity = world.getBlockEntity(pos);
            QuiverEntity bundleEntity = (QuiverEntity) blockEntity;
            if(PlayerhandItem.getItem() == Items.ARROW)
            {
                if(PlayerhandItem.getCount() < 16)
                {
                    bundleEntity.ArrowCount += 1;
                    player.getStackInHand(Hand.MAIN_HAND).setCount(player.getStackInHand(Hand.MAIN_HAND).getCount() - 1);
                }
                else
                {
                    bundleEntity.ArrowCount += 16;
                    player.getStackInHand(Hand.MAIN_HAND).setCount(player.getStackInHand(Hand.MAIN_HAND).getCount() - 16);
                }
                return ActionResult.SUCCESS;
            }
            else
            {

                if(bundleEntity.ArrowCount > 0) {
                    if(bundleEntity.ArrowCount >= 128)
                    {
                        bundleEntity.ArrowCount -= 64;
                        player.getInventory().insertStack(new ItemStack(Items.ARROW, 64));
                    }else
                    {
                        if (bundleEntity.ArrowCount >= 32) {
                            bundleEntity.ArrowCount -= 16;
                            player.getInventory().insertStack(new ItemStack(Items.ARROW, 16));
                        }
                        else {
                            bundleEntity.ArrowCount -= 1;
                            player.getInventory().insertStack(new ItemStack(Items.ARROW, 1));
                        }
                    }
                }else
                {
                    return ActionResult.PASS;
                }
                return ActionResult.SUCCESS;
            }
    }
}
