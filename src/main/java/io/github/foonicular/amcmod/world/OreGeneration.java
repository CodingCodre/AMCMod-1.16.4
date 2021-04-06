package io.github.foonicular.amcmod.world;

import io.github.foonicular.amcmod.core.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration {

	public static void generateOverworldOres(final BiomeLoadingEvent e) {
		if (!(e.getCategory().equals(Biome.Category.NETHER) || e.getCategory().equals(Biome.Category.THEEND))) { /* check if ore is in overworld*/
			
			generateOre(e.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockInit.RUBY_ORE.get().getDefaultState(), 4, 4, 64, 26);
		}
	}

	// More efficient generate ore function
	private static void generateOre(BiomeGenerationSettingsBuilder s, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int maxPerChunk) {
		s.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize))
						.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
						.square().func_242731_b(maxPerChunk));
	}

}
