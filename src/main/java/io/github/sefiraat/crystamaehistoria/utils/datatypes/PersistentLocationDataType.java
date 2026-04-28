package io.github.sefiraat.crystamaehistoria.utils.datatypes;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import java.nio.ByteBuffer;
import java.util.UUID;

public class PersistentLocationDataType implements PersistentDataType<byte[], Location> {

    public static final PersistentLocationDataType TYPE = new PersistentLocationDataType();

    @Override
    @Nonnull
    public Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    @Override
    @Nonnull
    public Class<Location> getComplexType() {
        return Location.class;
    }

    @Override
    @Nonnull
    public byte[] toPrimitive(@Nonnull Location complex, @Nonnull PersistentDataAdapterContext context) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[40]);
        bb.putLong(complex.getWorld().getUID().getMostSignificantBits());
        bb.putLong(complex.getWorld().getUID().getLeastSignificantBits());
        bb.putDouble(complex.getX());
        bb.putDouble(complex.getY());
        bb.putDouble(complex.getZ());
        return bb.array();
    }

    @Override
    @Nonnull
    public Location fromPrimitive(@Nonnull byte[] primitive, @Nonnull PersistentDataAdapterContext context) {
        ByteBuffer bb = ByteBuffer.wrap(primitive);
        UUID worldUUID = new UUID(bb.getLong(), bb.getLong());
        double x = bb.getDouble();
        double y = bb.getDouble();
        double z = bb.getDouble();
        return new Location(Bukkit.getWorld(worldUUID), x, y, z);
    }
}
