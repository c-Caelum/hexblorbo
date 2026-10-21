package caelum.hexblorbo.hex.arithmetics.blorbo;

import at.petrak.hexcasting.api.casting.arithmetic.operator.OperatorBasic;
import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaMultiPredicate;
import static at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaPredicate.ofType;
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

public class BlorboSlice extends OperatorBasicDefaults {

    public static final BlorboSlice INSTANCE = new BlorboSlice();

    public BlorboSlice() {
        super(3, IotaMultiPredicate.triple(ofType(HexblorboIotas.BLORBO_IOTA), ofType(HexIotaTypes.DOUBLE.get()), ofType(HexIotaTypes.DOUBLE.get())));
    }

    public @NotNull List<Iota> applyDefaulted(@NotNull Iterator<IndexedValue<Iota>> iterator, @NotNull CastingEnvironment castingEnvironment) throws Mishap {
        BinarySet set = OperatorUtils.nextBlorbo(iterator, 3);

        int lower = OperatorUtilsKt.nextPositiveIntUnder(iterator, set.getbitSize(), 3);
        int upper = OperatorUtilsKt.nextPositiveIntUnder(iterator, set.getbitSize(), 3);;
        boolean lowerIsBigger = lower > upper;
        BinarySet newSet = set.get(lowerIsBigger ? upper : lower, lowerIsBigger ? lower : upper);
        return List.of(new BlorboIota(newSet));
    }
}
