package com.rubyboat.oaob.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.system.CallbackI;

import java.util.Objects;

public class GoombaBlock extends Block {
    public GoombaBlock(Settings settings) {
        super(settings);
    }
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity.isPlayer())
        {
            PlayerEntity player = (PlayerEntity) entity;
            if (!player.getEquippedStack(EquipmentSlot.FEET).isOf(Items.LEATHER_BOOTS)) {
                entity.damage(DamageSource.GENERIC, 1.0F);
            }
            world.getBlockTickScheduler().schedule(pos, this, 25);
            BlockState air = Blocks.AIR.getDefaultState();
            world.setBlockState(new BlockPos(pos), air);

        }
        super.onSteppedOn(world, pos, state, entity);
    }

}
