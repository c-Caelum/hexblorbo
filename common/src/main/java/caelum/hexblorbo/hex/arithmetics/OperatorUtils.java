package caelum.hexblorbo.hex.arithmetics;

import at.petrak.hexcasting.api.casting.iota.DoubleIota;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.mishaps.MishapInvalidIota;
import at.petrak.hexcasting.api.casting.mishaps.MishapNotEnoughArgs;
import caelum.hexblorbo.api.utils.BinarySet;
import caelum.hexblorbo.hex.iotas.BlorboIota;
import kotlin.collections.IndexedValue;
import net.minecraft.network.chat.Component;

import java.util.Iterator;

public class OperatorUtils {
    public static BinarySet nextBlorbo(Iterator<IndexedValue<Iota>> iterator, int argc) {
        IndexedValue<Iota> nextIndexed = iterator.next();
        Iota next = nextIndexed.component2();
        int idx = nextIndexed.component1();
        if (!(next instanceof BlorboIota blorboIota)) {
            throw MishapInvalidIota.of(next, idx, "blorbo");
        }
        return blorboIota.getBinarySet();
    }

    public static BinarySet nextBlorboWithSize(Iterator<IndexedValue<Iota>> iterator, int argc, int size) {
        IndexedValue<Iota> nextIndexed = iterator.next();
        Iota next = nextIndexed.component2();
        int idx = nextIndexed.component1();
        if (!(next instanceof BlorboIota blorboIota) || blorboIota.getBinarySet().getbitSize() != size) {
            throw MishapInvalidIota.of(next, idx, "blorbo_with_size", size);
        }
        return blorboIota.getBinarySet();
    }
}
