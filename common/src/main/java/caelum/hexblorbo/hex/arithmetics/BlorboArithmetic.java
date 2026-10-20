package caelum.hexblorbo.hex.arithmetics;

import at.petrak.hexcasting.api.casting.arithmetic.Arithmetic;
import at.petrak.hexcasting.api.casting.arithmetic.operator.Operator;
import at.petrak.hexcasting.api.casting.arithmetic.operator.OperatorBinary;
import at.petrak.hexcasting.api.casting.math.HexPattern;
import at.petrak.hexcasting.api.casting.math.HexSignature;

import java.util.List;

public class BlorboArithmetic implements Arithmetic {
    @Override
    public String arithName() {
        return "hexblorbo:blorbo";
    }

    @Override
    public Iterable<HexPattern> opTypes() {
        return List.of(
                INDEX,
                SLICE,
                APPEND,
                UNAPPEND,
                ADD,
                ABS,
                REV,
                INDEX_OF,
                REMOVE,
                REPLACE,
                CONS,
                UNCONS,
                ADD,
                SUB
        );
    }

    @Override
    public Operator getOperator(HexPattern hexPattern) {
        // why is it doing that
        HexSignature sig = hexPattern.getSignature();
        if (sig == INDEX.getSignature()) {
        }
    }
}
