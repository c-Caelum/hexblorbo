package caelum.hexblorbo.hex;

import at.petrak.hexcasting.api.casting.arithmetic.Arithmetic;
import caelum.hexblorbo.hex.arithmetics.BlorboArithmetic;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static caelum.hexblorbo.Hexblorbo.modLoc;

public class HexblorboArithmetics {
    private static final HashMap<ResourceLocation, Arithmetic> arithmetics = new HashMap<>();

    public static final Arithmetic BLORBO = make("blorbo", BlorboArithmetic.INSTANCE);

    public static void registerArithmetics(BiConsumer<Arithmetic, ResourceLocation> eater) {
        for (Map.Entry<ResourceLocation, Arithmetic> entry : arithmetics.entrySet()) {
            eater.accept(entry.getValue(),entry.getKey());
        }
    }

    public static Arithmetic make(String name, Arithmetic arithmetic) {
        ResourceLocation loc = modLoc(name);
        arithmetics.put(loc, arithmetic);
        return arithmetic;
    }
}