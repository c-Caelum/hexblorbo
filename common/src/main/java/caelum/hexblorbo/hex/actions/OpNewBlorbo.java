package caelum.hexblorbo.hex.actions;

import at.petrak.hexcasting.api.casting.castables.ConstMediaAction;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.mishaps.Mishap;

import static at.petrak.hexcasting.api.casting.OperatorUtils.getDouble;
import static at.petrak.hexcasting.api.casting.OperatorUtils.getInt;

import caelum.hexblorbo.api.utils.BinarySet;
import caelum.hexblorbo.hex.iotas.BlorboIota;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OpNewBlorbo implements ConstMediaAction {
    public static final int argc = 1;

    @Override
    public int getArgc() {
        return 1;
    }

    @Override
    public @NotNull List<Iota> execute(@NotNull List<? extends Iota> list, @NotNull CastingEnvironment castingEnvironment) throws Mishap {
        double a = getInt(list,0, argc);
        long[] longArray = new long[1];
        longArray[0] = Double.doubleToLongBits(a);
        return List.of(new BlorboIota(new BinarySet(longArray, 64)));
    }
}
