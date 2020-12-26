package io.github.foonicular.amcmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.foonicular.amcmod.core.init.BlockInit;
import io.github.foonicular.amcmod.core.init.ItemInit;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

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
    
    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(Main.TAB);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    }
    
    public static final ItemGroup TAB = new ItemGroup("amcmodtab") {
        @Override
        public ItemStack createIcon() { return new ItemStack((IItemProvider) ItemInit.RUBY.get()); }
    };
    
}
