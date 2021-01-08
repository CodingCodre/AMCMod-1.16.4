package io.github.foonicular.amcmod.core.init;

import io.github.foonicular.amcmod.Main;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

	public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3.0f, 6.0f)
					.sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()));

}
