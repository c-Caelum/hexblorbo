package caelum.hexblorbo.fabric;

import at.petrak.hexcasting.common.lib.hex.HexActions;
import at.petrak.hexcasting.common.lib.hex.HexArithmetics;
import at.petrak.hexcasting.common.lib.hex.HexIotaTypes;
import caelum.hexblorbo.hex.HexblorboActions;
import caelum.hexblorbo.hex.HexblorboArithmetics;
import caelum.hexblorbo.hex.HexblorboIotas;
import net.fabricmc.api.ModInitializer;

import caelum.hexblorbo.Hexblorbo;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class HexblorboFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        bind(HexActions.REGISTRY, HexblorboActions::registerActions);
        bind(HexIotaTypes.REGISTRY, HexblorboIotas::registerIotaTypes);
        bind(HexArithmetics.REGISTRY, HexblorboArithmetics::registerArithmetics);

        // Run our common setup.
        Hexblorbo.init();
    }

    public <T> void bind(Registry<T> registry, Consumer<BiConsumer<T, ResourceLocation>> consumer) {
        consumer.accept((T toRegister, ResourceLocation loc) -> {
            Registry.register(registry, loc, toRegister);
        });
    }
}
