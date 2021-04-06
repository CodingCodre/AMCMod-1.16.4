package io.github.foonicular.amcmod.common.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class RubyOre extends OreBlock {

	public RubyOre(Properties properties) {
		super(properties);
	}
	
	@Override
	public void dropXpOnBlockBreak(ServerWorld worldIn, BlockPos pos, int amount) {
		super.dropXpOnBlockBreak(worldIn, pos, 4);
	}

}
