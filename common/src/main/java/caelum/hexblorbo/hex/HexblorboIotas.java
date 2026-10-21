package caelum.hexblorbo.hex;

import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.iota.IotaType;
import caelum.hexblorbo.Hexblorbo;
import caelum.hexblorbo.hex.iotas.BlorboIota;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static caelum.hexblorbo.Hexblorbo.modLoc;

public class HexblorboIotas {
    private static final HashMap<ResourceLocation, IotaType<?>> iotatypes = new HashMap<>();

    public static final IotaType<BlorboIota> BLORBO_IOTA = make("blorbo",BlorboIota.TYPE);

    public static void registerIotaTypes(BiConsumer<IotaType<?>, ResourceLocation> eater) {
        Hexblorbo.LOGGER.info("Registering Hexblorbo Iota types.");
        for (Map.Entry<ResourceLocation, IotaType<?>> entry : iotatypes.entrySet()) {
            eater.accept(entry.getValue(),entry.getKey());
        }
    }

    public static <T extends Iota> IotaType<T> make(String name, IotaType<T> type) {;
        ResourceLocation loc = modLoc(name);
        iotatypes.put(loc, type);
        return type;
    }
}
