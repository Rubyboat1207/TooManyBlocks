package com.rubyboat.oaob.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MarioBlock extends Block {
    public MarioBlock(Settings settings) {
        super(settings);
    }
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity.isLiving())
        {
            LivingEntity livingEntity = (LivingEntity) entity;
            if(livingEntity.isPlayer())
            {
                PlayerEntity player = (PlayerEntity) livingEntity;
                if(player.isCreative())
                {
                    super.onSteppedOn(world, pos, state, entity);

                }
            }
            livingEntity.kill();
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
