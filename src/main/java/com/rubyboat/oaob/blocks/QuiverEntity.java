package com.rubyboat.oaob.blocks;

import com.rubyboat.oaob.Main;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class QuiverEntity extends BlockEntity {
    public int ArrowCount = 0;
    public QuiverEntity(BlockPos pos, BlockState state) {
        super(Main.ARROW_BUNDLE_ENTITY, pos, state);
    }
    @Override
    public NbtCompound writeNbt(NbtCompound tag) {
        super.writeNbt(tag);

        // Save the current value of the number to the tag
        tag.putInt("ArrowCount", ArrowCount);

        return tag;
    }
    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        ArrowCount = tag.getInt("ArrowCount");
    }
}
