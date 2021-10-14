package net.fabricmc.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.Type;

public class BlockAdder {
    public static void BlockFactory(String Name, FabricBlockSettings BlockSettings, FabricItemSettings ItemSettings)
    {
        final Block CUSTOMBLOCK = new Block(BlockSettings);
        Registry.register(Registry.BLOCK, new Identifier(ExampleMod.Modid, Name), CUSTOMBLOCK);
        Registry.register(Registry.ITEM, new Identifier(ExampleMod.Modid, Name), new BlockItem(CUSTOMBLOCK, ItemSettings));
    }
    public static void BlockFactory(String Name, Block block, FabricItemSettings ItemSettings)
    {
        final Block CUSTOMBLOCK = block;
        Registry.register(Registry.BLOCK, new Identifier(ExampleMod.Modid, Name), CUSTOMBLOCK);
        Registry.register(Registry.ITEM, new Identifier(ExampleMod.Modid, Name), new BlockItem(CUSTOMBLOCK, ItemSettings));
    }
}
