package caelum.hexblorbo.hex.arithmetics.blorbo;

import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaMultiPredicate;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.iota.Iota;
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

public class BlorboAnd extends OperatorBasicDefaults {

    public static final int argc = 2;

    public static final BlorboAnd INSTANCE = new BlorboAnd();

    public BlorboAnd() {
        super(argc, IotaMultiPredicate.pair(ofType(HexblorboIotas.BLORBO_IOTA), ofType(HexblorboIotas.BLORBO_IOTA)));
    }

    @Override
    public List<Iota> applyDefaulted(@NotNull Iterator<IndexedValue<Iota>> iterator, @NotNull CastingEnvironment castingEnvironment) {
        BinarySet set = (BinarySet) OperatorUtils.nextBlorbo(iterator, argc).clone();
        BinarySet input = OperatorUtils.nextBlorboWithSize(iterator, argc, set.getbitSize());
        set.and(input);
        return List.of(new BlorboIota(set));
    }
}
