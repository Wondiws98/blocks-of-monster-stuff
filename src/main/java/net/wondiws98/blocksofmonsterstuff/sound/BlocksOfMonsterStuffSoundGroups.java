package net.wondiws98.blocksofmonsterstuff.sound;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class BlocksOfMonsterStuffSoundGroups {
    public static final BlockSoundGroup ROTTEN_FLESH_GROUP = new BlockSoundGroup(1.0f, 1.0f,
            SoundEvents.ENTITY_ZOMBIE_VILLAGER_STEP, // BREAK
            SoundEvents.ENTITY_ZOMBIE_STEP,          // STEP
            SoundEvents.ENTITY_ZOMBIE_VILLAGER_STEP, // PLACE
            SoundEvents.ENTITY_ZOMBIE_STEP,          // HIT
            SoundEvents.ENTITY_ZOMBIE_STEP           // FALL
    );
    public static final BlockSoundGroup BONE_GROUP = new BlockSoundGroup(1.0f, 0.9f,
            SoundEvents.ENTITY_WITHER_SKELETON_STEP, // BREAK
            SoundEvents.ENTITY_SKELETON_STEP,        // STEP
            SoundEvents.ENTITY_WITHER_SKELETON_STEP, // PLACE
            SoundEvents.ENTITY_SKELETON_HURT,        // HIT
            SoundEvents.ENTITY_SKELETON_STEP         // FALL
    );
    public static final BlockSoundGroup BLAZE_GROUP = new BlockSoundGroup(1.0f, 1.0f,
            SoundEvents.ENTITY_BLAZE_HURT,        // BREAK
            SoundEvents.BLOCK_BASALT_STEP,        // STEP
            SoundEvents.ENTITY_BLAZE_SHOOT,       // PLACE
            SoundEvents.ENTITY_BLAZE_HURT,        // HIT
            SoundEvents.BLOCK_BASALT_FALL         // FALL
    );
}
