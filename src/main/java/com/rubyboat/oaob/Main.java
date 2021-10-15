package com.rubyboat.oaob;

import com.rubyboat.oaob.blocks.Quiver;
import net.fabricmc.api.ModInitializer;
import com.rubyboat.oaob.blocks.QuiverEntity;
import com.rubyboat.oaob.blocks.GoombaBlock;
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
	public static final ItemGroup SILLY_BLOCKS = FabricItemGroupBuilder.build(
			new Identifier(Modid, "silly_blocks"),
			() -> new ItemStack(Items.BIG_DRIPLEAF));
	public static final ItemGroup SERIOUS_BLOCKS = FabricItemGroupBuilder.build(
			new Identifier(Modid, "serious_blocks"),
			() -> new ItemStack(Items.STONE));
	public static BlockEntityType<QuiverEntity> ARROW_BUNDLE_ENTITY;
	public static Quiver ARROW_BUNDLE = new Quiver(FabricBlockSettings.of(Material.WOOL));
	@Override
	public void onInitialize() {
		BlockAdder.BlockFactory("quiver", ARROW_BUNDLE, new FabricItemSettings().group(SERIOUS_BLOCKS));
		BlockAdder.BlockFactory("goomba_block", new GoombaBlock(FabricBlockSettings.of(Material.SPONGE)), new FabricItemSettings().maxCount(65).fireproof().group(SILLY_BLOCKS));
		ARROW_BUNDLE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Modid, "quiver"), FabricBlockEntityTypeBuilder.create(QuiverEntity::new, ARROW_BUNDLE).build(null));

	}
}
