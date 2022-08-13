package dev.vital.quester.quests.x_marks_the_spot.tasks;

import dev.vital.quester.ScriptTask;
import dev.vital.quester.VitalQuesterConfig;
import net.runelite.api.ItemID;
import net.runelite.api.coords.WorldPoint;
import net.unethicalite.api.account.LocalPlayer;
import net.unethicalite.api.items.Inventory;
import net.unethicalite.api.movement.Movement;

public class StepOne implements ScriptTask
{
    private final WorldPoint dig_one_point = new WorldPoint(3230, 3209, 0);

    VitalQuesterConfig config;

    public StepOne(VitalQuesterConfig config)
    {
        this.config = config;
    }

    @Override
    public boolean validate()
    {
        return Inventory.contains(ItemID.TREASURE_SCROLL);
    }

    @Override
    public int execute() {

       if(!LocalPlayer.get().getWorldLocation().equals(dig_one_point)) {
           if(!Movement.isWalking()) {
               Movement.walkTo(dig_one_point);
           }
           return -1;
       }

       Inventory.getFirst(ItemID.SPADE).interact("Dig");

        return -1;
    }
}