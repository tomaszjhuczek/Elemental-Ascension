package ie.huczek.elemental_ascension.common.util;

import net.minecraft.core.BlockPos;
import org.joml.Vector3d;

public class VectorMathHelper {

    public static double getDistance(BlockPos posA, BlockPos posB) {
        Vector3d a = new Vector3d(posA.getX(), posA.getY(), posA.getZ());
        Vector3d b = new Vector3d(posB.getX(), posB.getY(), posB.getZ());
        return b.distance(a);
    }

    public static BlockPos getRelativePos(BlockPos posA, BlockPos posB) {
        return posA.subtract(posB);
    }

    public static int[] vecToArray(BlockPos pos) {
        int[] numberArray = new int[3];
        numberArray[0] = pos.getX();
        numberArray[1] = pos.getY();
        numberArray[2] = pos.getZ();
        return numberArray;
    }

    public static BlockPos arrayToVec(int[] pos) {
        return new BlockPos(pos[0], pos[1], pos[2]);
    }
}
