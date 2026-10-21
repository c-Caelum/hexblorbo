package caelum.hexblorbo.hex.arithmetics;

import at.petrak.hexcasting.api.casting.arithmetic.operator.OperatorBasic;
import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaMultiPredicate;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.iota.Iota;
import kotlin.collections.IndexedValue;
import static kotlin.collections.CollectionsKt.withIndex;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

public abstract class OperatorBasicDefaults extends OperatorBasic {
    public OperatorBasicDefaults(int arity, @NotNull IotaMultiPredicate accepts) {
        super(arity, accepts);
    }

    public abstract List<Iota> applyDefaulted(@NotNull Iterator<IndexedValue<Iota>> iterator, @NotNull CastingEnvironment castingEnvironment);

    public Iterable<Iota> apply(Iterable<? extends Iota> iterable, CastingEnvironment env) {
        List<Iota> toReturn = applyDefaulted(withIndex(iterable.iterator()), env);
        return toReturn;
    }
}
