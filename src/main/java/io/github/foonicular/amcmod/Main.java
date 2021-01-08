package io.github.foonicular.amcmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.foonicular.amcmod.core.init.BlockInit;
import io.github.foonicular.amcmod.core.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MOD_ID)
public class Main {
    
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "amcmod";

    public Main() {
    	
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	
        bus.addListener(this::setup);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        
        MinecraftForge.EVENT_BUS.register(this);
        
    }

    private void setup(final FMLCommonSetupEvent event) {
    	
    }
    
    public static final ItemGroup TAB = new ItemGroup("amcmodtab") {
        @Override
        public ItemStack createIcon() { return new ItemStack((IItemProvider) ItemInit.RUBY.get()); }
    };
    
}
