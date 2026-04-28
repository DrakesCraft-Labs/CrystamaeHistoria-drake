package io.github.sefiraat.crystamaehistoria.magic;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;
import java.util.function.Consumer;

public class CastInformation {

    private final UUID caster;
    private final int staveLevel;
    private final Location castLocation;
    private SpellType spellType;
    private Location damageLocation;
    private LivingEntity mainTarget;
    private Block hitBlock;
    private Block targetedBlockOnCast;
    private BlockFace targetedBlockFaceOnCast;
    private Location projectileLocation;
    private int currentTick = 1;
    private Consumer<CastInformation> beforeProjectileHitEvent;
    private Consumer<CastInformation> projectileHitEvent;
    private Consumer<CastInformation> afterProjectileHitEvent;
    private Consumer<CastInformation> projectileHitBlockEvent;
    private Consumer<CastInformation> tickEvent;
    private Consumer<CastInformation> afterTicksEvent;

    @ParametersAreNonnullByDefault
    public CastInformation(Player caster, int staveLevel) {
        this.caster = caster.getUniqueId();
        this.staveLevel = staveLevel;
        this.castLocation = caster.getLocation().clone();
        this.targetedBlockOnCast = caster.getTargetBlockExact(50);
        this.targetedBlockFaceOnCast = caster.getTargetBlockFace(50);
    }

    public Player getCasterAsPlayer() {
        return Bukkit.getPlayer(this.caster);
    }

    public UUID getCaster() {
        return caster;
    }

    public int getStaveLevel() {
        return staveLevel;
    }

    public Location getCastLocation() {
        return castLocation;
    }

    public SpellType getSpellType() {
        return spellType;
    }

    public void setSpellType(SpellType spellType) {
        this.spellType = spellType;
    }

    public Location getDamageLocation() {
        return damageLocation;
    }

    public void setDamageLocation(Location damageLocation) {
        this.damageLocation = damageLocation;
    }

    public LivingEntity getMainTarget() {
        return mainTarget;
    }

    public void setMainTarget(LivingEntity mainTarget) {
        this.mainTarget = mainTarget;
    }

    public Block getHitBlock() {
        return hitBlock;
    }

    public void setHitBlock(Block hitBlock) {
        this.hitBlock = hitBlock;
    }

    public Block getTargetedBlockOnCast() {
        return targetedBlockOnCast;
    }

    public void setTargetedBlockOnCast(Block targetedBlockOnCast) {
        this.targetedBlockOnCast = targetedBlockOnCast;
    }

    public BlockFace getTargetedBlockFaceOnCast() {
        return targetedBlockFaceOnCast;
    }

    public void setTargetedBlockFaceOnCast(BlockFace targetedBlockFaceOnCast) {
        this.targetedBlockFaceOnCast = targetedBlockFaceOnCast;
    }

    public Location getProjectileLocation() {
        return projectileLocation;
    }

    public void setProjectileLocation(Location projectileLocation) {
        this.projectileLocation = projectileLocation;
    }

    public int getCurrentTick() {
        return currentTick;
    }

    public void setCurrentTick(int currentTick) {
        this.currentTick = currentTick;
    }

    public Consumer<CastInformation> getBeforeProjectileHitEvent() {
        return beforeProjectileHitEvent;
    }

    public void setBeforeProjectileHitEvent(Consumer<CastInformation> beforeProjectileHitEvent) {
        this.beforeProjectileHitEvent = beforeProjectileHitEvent;
    }

    public Consumer<CastInformation> getProjectileHitEvent() {
        return projectileHitEvent;
    }

    public void setProjectileHitEvent(Consumer<CastInformation> projectileHitEvent) {
        this.projectileHitEvent = projectileHitEvent;
    }

    public Consumer<CastInformation> getAfterProjectileHitEvent() {
        return afterProjectileHitEvent;
    }

    public void setAfterProjectileHitEvent(Consumer<CastInformation> afterProjectileHitEvent) {
        this.afterProjectileHitEvent = afterProjectileHitEvent;
    }

    public Consumer<CastInformation> getProjectileHitBlockEvent() {
        return projectileHitBlockEvent;
    }

    public void setProjectileHitBlockEvent(Consumer<CastInformation> projectileHitBlockEvent) {
        this.projectileHitBlockEvent = projectileHitBlockEvent;
    }

    public Consumer<CastInformation> getTickEvent() {
        return tickEvent;
    }

    public void setTickEvent(Consumer<CastInformation> tickEvent) {
        this.tickEvent = tickEvent;
    }

    public Consumer<CastInformation> getAfterTicksEvent() {
        return afterTicksEvent;
    }

    public void setAfterTicksEvent(Consumer<CastInformation> afterTicksEvent) {
        this.afterTicksEvent = afterTicksEvent;
    }

    public void runPreAffectEvent() {
        if (beforeProjectileHitEvent != null) {
            beforeProjectileHitEvent.accept(this);
        }
    }

    public void runAffectEvent() {
        if (projectileHitEvent != null) {
            projectileHitEvent.accept(this);
        }
    }

    public void runPostAffectEvent() {
        if (afterProjectileHitEvent != null) {
            afterProjectileHitEvent.accept(this);
        }
    }

    public void runProjectileHitBlockEvent() {
        if (projectileHitBlockEvent != null) {
            projectileHitBlockEvent.accept(this);
        }
    }

    public void runTickEvent() {
        if (tickEvent != null) {
            tickEvent.accept(this);
        }
        this.currentTick++;
    }

    public void runAfterTicksEvent() {
        if (afterTicksEvent != null) {
            afterTicksEvent.accept(this);
        }
    }

}
