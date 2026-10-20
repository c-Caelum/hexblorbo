package caelum.hexblorbo.neoforge;

import at.petrak.hexcasting.common.lib.HexRegistries;
import at.petrak.hexcasting.common.lib.hex.HexArithmetics;
import caelum.hexblorbo.hex.HexblorboActions;
import caelum.hexblorbo.hex.HexblorboArithmetics;
import caelum.hexblorbo.hex.HexblorboIotas;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import caelum.hexblorbo.Hexblorbo;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Mod(Hexblorbo.MOD_ID)
public final class HexblorboNeoforge {
    public HexblorboNeoforge() {

        bind(HexRegistries.ACTION, HexblorboActions::registerActions, NeoForge.EVENT_BUS);
        bind(HexRegistries.IOTA_TYPE, HexblorboIotas::registerIotaTypes, NeoForge.EVENT_BUS);
        bind(HexRegistries.ARITHMETIC, HexblorboArithmetics::registerArithmetics, NeoForge.EVENT_BUS);

        // Run our common setup.
        Hexblorbo.init();
    }

    private <T> void bind(ResourceKey<? extends Registry<T>> registry, Consumer<BiConsumer<T, ResourceLocation>> source, IEventBus bus) {
        bus.addListener((RegisterEvent event) -> {
            event.register(registry, actionRegistryEntryRegisterHelper -> {
                source.accept((t, rl) -> actionRegistryEntryRegisterHelper.register(rl, t));
            });
        });
    }
}
