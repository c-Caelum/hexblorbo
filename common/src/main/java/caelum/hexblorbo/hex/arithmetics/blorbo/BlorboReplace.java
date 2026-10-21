package caelum.hexblorbo.hex.arithmetics.blorbo;

import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaMultiPredicate;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.mishaps.Mishap;
import at.petrak.hexcasting.common.casting.arithmetic.operator.OperatorUtilsKt;
import at.petrak.hexcasting.common.lib.hex.HexIotaTypes;
import caelum.hexblorbo.api.utils.BinarySet;
import caelum.hexblorbo.hex.HexblorboIotas;
import caelum.hexblorbo.hex.arithmetics.OperatorBasicDefaults;
import caelum.hexblorbo.hex.arithmetics.OperatorUtils;
import caelum.hexblorbo.hex.iotas.BlorboIota;
import kotlin.collections.IndexedValue;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

import static at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaPredicate.ofType;

public class BlorboReplace extends OperatorBasicDefaults {

    public static final BlorboReplace INSTANCE = new BlorboReplace();

    public BlorboReplace() {
        super(3, IotaMultiPredicate.triple(ofType(HexblorboIotas.BLORBO_IOTA), ofType(HexIotaTypes.DOUBLE.get()), ofType(HexIotaTypes.DOUBLE.get())));
    }

    public @NotNull List<Iota> applyDefaulted(@NotNull Iterator<IndexedValue<Iota>> iterator, @NotNull CastingEnvironment castingEnvironment) throws Mishap {
        BinarySet set = OperatorUtils.nextBlorbo(iterator, 3);
        int idx = OperatorUtilsKt.nextPositiveIntUnder(iterator, set.getbitSize(), 3);
        boolean input = OperatorUtilsKt.nextPositiveIntUnder(iterator, 2, 3) == 1;
        BinarySet newSet = (BinarySet) set.clone();
        newSet.set(idx, input);
        return List.of(new BlorboIota(newSet));
    }
}
