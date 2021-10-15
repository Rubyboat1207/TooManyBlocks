package net.fabricmc.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.*;

public class BlockAdder {
    public static ArrayList<Block> blocks = new ArrayList<>();


    public static void BlockFactory(String Name, FabricBlockSettings BlockSettings, FabricItemSettings ItemSettings)
    {
        final Block CUSTOMBLOCK = new Block(BlockSettings);
        Registry.register(Registry.BLOCK, new Identifier(Main.Modid, Name), CUSTOMBLOCK);
        Registry.register(Registry.ITEM, new Identifier(Main.Modid, Name), new BlockItem(CUSTOMBLOCK, ItemSettings));
    }
    public static void BlockFactory(String Name, Block block, FabricItemSettings ItemSettings)
    {
        final Block CUSTOMBLOCK = block;
        Registry.register(Registry.BLOCK, new Identifier(Main.Modid, Name), CUSTOMBLOCK);
        Registry.register(Registry.ITEM, new Identifier(Main.Modid, Name), new BlockItem(CUSTOMBLOCK, ItemSettings));
    }
}
