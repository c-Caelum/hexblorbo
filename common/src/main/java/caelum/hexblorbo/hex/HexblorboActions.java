package caelum.hexblorbo.hex;

import at.petrak.hexcasting.api.casting.ActionRegistryEntry;
import at.petrak.hexcasting.api.casting.castables.Action;
import at.petrak.hexcasting.api.casting.math.HexDir;
import at.petrak.hexcasting.api.casting.math.HexPattern;
import net.minecraft.resources.ResourceLocation;
import static caelum.hexblorbo.Hexblorbo.modLoc;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import caelum.hexblorbo.hex.actions.*;

public class HexblorboActions {
    private static final HashMap<ResourceLocation, ActionRegistryEntry> actions = new HashMap<>();

    public static final ActionRegistryEntry BLORBO_FROM_DOUBLE_BITS = make("from_double", "wqqqwqqeqq", HexDir.EAST, new OpNewBlorbo());

    public static void registerActions(BiConsumer<ActionRegistryEntry, ResourceLocation> eater) {
        for (Map.Entry<ResourceLocation, ActionRegistryEntry> entry : actions.entrySet()) {
            eater.accept(entry.getValue(),entry.getKey());
        }
    }

    public static ActionRegistryEntry make(String name, String sigs, HexDir dir, Action action) {
        ActionRegistryEntry entry = new ActionRegistryEntry(HexPattern.fromAngleString(sigs, dir), action);
        ResourceLocation loc = modLoc(name);
        actions.put(loc, entry);
        return entry;
    }
}
