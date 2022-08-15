package dev.vital.quester.quests.rune_mysteries.tasks;

import dev.vital.quester.tasks.DialogTask;
import dev.vital.quester.ScriptTask;
import dev.vital.quester.VitalQuesterConfig;
import net.runelite.api.coords.WorldPoint;
import net.unethicalite.api.game.Vars;

public class DeliverPackage implements ScriptTask
{
    private final WorldPoint aubury_point = new WorldPoint(3253, 3401, 0);

    VitalQuesterConfig config;

    public DeliverPackage(VitalQuesterConfig config)
    {
        this.config = config;
    }

    @Override
    public boolean validate()
    {
        return Vars.getBit(13725) == 0;
    }

    DialogTask deliver_package = new DialogTask("Aubury", aubury_point, "I've been sent here with a package for you.");

    @Override
    public int execute()
    {
        if(!deliver_package.taskCompleted()) {
            return deliver_package.execute();
        }

        return -1;
    }
}