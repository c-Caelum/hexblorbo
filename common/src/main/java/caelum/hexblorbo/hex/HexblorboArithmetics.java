package caelum.hexblorbo.hex;

import at.petrak.hexcasting.api.casting.ActionRegistryEntry;
import at.petrak.hexcasting.api.casting.arithmetic.Arithmetic;
import at.petrak.hexcasting.api.casting.castables.Action;
import at.petrak.hexcasting.api.casting.math.HexDir;
import at.petrak.hexcasting.api.casting.math.HexPattern;
import at.petrak.hexcasting.common.lib.hex.HexArithmetics;
import caelum.hexblorbo.hex.actions.OpNewBlorbo;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static caelum.hexblorbo.Hexblorbo.modLoc;

public class HexblorboArithmetics {
    private static final HashMap<ResourceLocation, Arithmetic> arithmetics = new HashMap<>();



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