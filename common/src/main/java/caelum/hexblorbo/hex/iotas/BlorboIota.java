package caelum.hexblorbo.hex.iotas;

import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.api.casting.iota.IotaType;
import caelum.hexblorbo.Hexblorbo;
import caelum.hexblorbo.api.utils.BinarySet;
import caelum.hexblorbo.hex.HexblorboIotas;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.security.MessageDigest;
import java.util.function.Supplier;

public class BlorboIota extends Iota {
    private final BinarySet binarySet;
    private boolean isClient = false;
    private final Component displayed;

    public BlorboIota(BinarySet set) {
        super(() -> TYPE);
        binarySet = set;
        String displayedSet = binarySet.toStringStraightBinary(128);
        displayed = Component.literal(displayedSet).withColor(0x48b6c9);
    }

    private BlorboIota(Component displayed) {
        super(() -> TYPE);
        binarySet = null;
        isClient = true;
        this.displayed = displayed;
    }

    public BinarySet getBinarySet() {
        return binarySet;
    }

    @Override
    public boolean isTruthy(@Nullable CastingEnvironment castingEnvironment) {
        return binarySet.getbitSize() != 0 && binarySet.nextSetBit(0) != -1;
    }

    @Override
    protected boolean toleratesOther(Iota iota) {
        return typesMatch(iota, this) && ((BlorboIota)iota).binarySet.equals(binarySet);
    }

    @Override
    public Component display() {
        return displayed;
    }

    @Override
    public int hashCode() {
        return binarySet.hashCode();
    }

    public static final IotaType<BlorboIota> TYPE = new IotaType<BlorboIota>() {
        public static final MapCodec<BlorboIota> CODEC = BinarySet.CODEC.xmap(BlorboIota::new, BlorboIota::getBinarySet).fieldOf("binarySet");
        // haha client. no data for you!!!! noob!!!!
        public static final StreamCodec<RegistryFriendlyByteBuf, BlorboIota> STREAM_CODEC = ComponentSerialization.STREAM_CODEC.map(BlorboIota::new,
                        (BlorboIota b) -> b.displayed);

        @Override
        public MapCodec<BlorboIota> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, BlorboIota> streamCodec() {
            return STREAM_CODEC;
        }

        @Override
        public int color() {
            return 0x48b6c9;
        }
    };
}
