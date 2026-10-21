package caelum.hexblorbo.hex.arithmetics;

import at.petrak.hexcasting.api.casting.arithmetic.Arithmetic;
import at.petrak.hexcasting.api.casting.arithmetic.operator.Operator;
import at.petrak.hexcasting.api.casting.arithmetic.operator.OperatorBinary;
import at.petrak.hexcasting.api.casting.math.HexPattern;
import at.petrak.hexcasting.api.casting.math.HexSignature;
import caelum.hexblorbo.hex.arithmetics.blorbo.*;

import java.util.List;

public class BlorboArithmetic implements Arithmetic {

    public static final BlorboArithmetic INSTANCE = new BlorboArithmetic();

    @Override
    public String arithName() {
        return "hexblorbo:blorbo";
    }

    @Override
    public Iterable<HexPattern> opTypes() {
        return List.of(
                INDEX,
                SLICE,
                ADD,
                ABS,
                REV,
                INDEX_OF,
                REPLACE,
                AND,
                OR,
                XOR,
                NOT
        );
    }

    @Override
    public Operator getOperator(HexPattern hexPattern) {
        // why is it doing that
        HexSignature sig = hexPattern.getSignature();
        if (sig == AND.getSignature()) {
            return BlorboAnd.INSTANCE;
        }
        if (sig == OR.getSignature()) {
            return BlorboOr.INSTANCE;
        }
        if (sig == XOR.getSignature()) {
            return BlorboXor.INSTANCE;
        }
        if (sig == NOT.getSignature()) {
            return BlorboNot.INSTANCE;
        }
        if (sig == SLICE.getSignature()) {
            return BlorboSlice.INSTANCE;
        }
        if (sig == INDEX.getSignature()) {
            return BlorboIndex.INSTANCE;
        }
        if (sig == ADD.getSignature()) {
            return BlorboAdd.INSTANCE;
        }
        if (sig == ABS.getSignature()) {
            return BlorboAbs.INSTANCE;
        }
        if (sig == REV.getSignature()) {
            return BlorboRev.INSTANCE;
        }
        if (sig == INDEX_OF.getSignature()) {
            return BlorboIndexOf.INSTANCE;
        }
        if (sig == REPLACE.getSignature()) {
            return BlorboReplace.INSTANCE;
        }
        return null;
    }
}
