package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.blocks.GoombaBlock;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String Modid = "oaofb";
	public static final Logger LOGGER = LogManager.getLogger("modid");
	public static final ItemGroup OAOF_GROUP = FabricItemGroupBuilder.build(
			new Identifier(Modid, "general"),
			() -> new ItemStack(Items.GRASS_BLOCK));
	@Override
	public void onInitialize() {
		BlockAdder.BlockFactory("goomba_block", new GoombaBlock(FabricBlockSettings.of(Material.SPONGE)), new FabricItemSettings().maxCount(65).fireproof().group(OAOF_GROUP));
		LOGGER.info("Hello Fabric world!");
	}
}
