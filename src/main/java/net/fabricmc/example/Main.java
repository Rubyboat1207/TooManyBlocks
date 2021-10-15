package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.blocks.Quiver;
import net.fabricmc.example.blocks.QuiverEntity;
import net.fabricmc.example.blocks.GoombaBlock;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String Modid = "oaosb";
	public static final Logger LOGGER = LogManager.getLogger("modid");
	public static final ItemGroup OAOB_GROUP = FabricItemGroupBuilder.build(
			new Identifier(Modid, "general"),
			() -> new ItemStack(Items.GRASS_BLOCK));
	public static BlockEntityType<QuiverEntity> ARROW_BUNDLE_ENTITY;
	public static Quiver ARROW_BUNDLE = new Quiver(FabricBlockSettings.of(Material.WOOL));
	@Override
	public void onInitialize() {
		BlockAdder.BlockFactory("quiver", ARROW_BUNDLE, new FabricItemSettings().group(OAOB_GROUP));
		BlockAdder.BlockFactory("goomba_block", new GoombaBlock(FabricBlockSettings.of(Material.SPONGE)), new FabricItemSettings().maxCount(65).fireproof().group(OAOB_GROUP));
		ARROW_BUNDLE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Modid, "quiver"), FabricBlockEntityTypeBuilder.create(QuiverEntity::new, ARROW_BUNDLE).build(null));

	}
}
