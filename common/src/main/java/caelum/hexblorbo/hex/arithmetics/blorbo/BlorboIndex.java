package caelum.hexblorbo.hex.arithmetics.blorbo;

import at.petrak.hexcasting.api.casting.arithmetic.operator.Operator;
import at.petrak.hexcasting.api.casting.arithmetic.operator.OperatorBasic;
import at.petrak.hexcasting.api.casting.arithmetic.operator.OperatorBinary;
import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaMultiPredicate;
import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaPredicate;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.eval.OperationResult;
import at.petrak.hexcasting.api.casting.eval.vm.CastingImage;
import at.petrak.hexcasting.api.casting.eval.vm.SpellContinuation;
import at.petrak.hexcasting.api.casting.iota.BooleanIota;
import at.petrak.hexcasting.api.casting.iota.DoubleIota;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.mishaps.Mishap;
import at.petrak.hexcasting.api.casting.mishaps.MishapInvalidIota;
import at.petrak.hexcasting.common.casting.arithmetic.operator.OperatorUtilsKt;
import at.petrak.hexcasting.common.lib.hex.HexIotaTypes;
import caelum.hexblorbo.api.utils.BinarySet;
import caelum.hexblorbo.hex.HexblorboIotas;
import caelum.hexblorbo.hex.arithmetics.OperatorBasicDefaults;
import caelum.hexblorbo.hex.arithmetics.OperatorUtils;
import caelum.hexblorbo.hex.iotas.BlorboIota;
import kotlin.collections.IndexedValue;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;

public class BlorboIndex extends OperatorBasicDefaults {

    public static final BlorboIndex INSTANCE = new BlorboIndex();

    public BlorboIndex() {
        super(2, IotaMultiPredicate.pair(IotaPredicate.ofType(HexblorboIotas.BLORBO_IOTA), IotaPredicate.ofType(HexIotaTypes.DOUBLE.get())));
    }

    @Override
    public List<Iota> applyDefaulted(@NotNull Iterator<IndexedValue<Iota>> iterator, @NotNull CastingEnvironment castingEnvironment) {
        BinarySet blorbo = OperatorUtils.nextBlorbo(iterator, 2);
        int pos = OperatorUtilsKt.nextPositiveIntUnder(iterator, blorbo.getbitSize(), 2);

        return List.of(new DoubleIota(blorbo.get(pos) ? 1 : 0));
    }
}
