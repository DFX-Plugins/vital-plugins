package dev.vital.quester.quests.pirates_treasure.tasks;

import dev.vital.quester.tasks.DialogTask;
import dev.vital.quester.ScriptTask;
import dev.vital.quester.VitalQuesterConfig;
import net.runelite.api.coords.WorldPoint;

public class GetJob2 implements ScriptTask
{
    private final WorldPoint wydin_point = new WorldPoint(3014, 3204, 0);

    VitalQuesterConfig config;

    public GetJob2(VitalQuesterConfig config)
    {
        this.config = config;
    }

    DialogTask talk_to_wydin = new DialogTask("Wydin", wydin_point, "Can I get a job here?");

    @Override
    public boolean validate()
    {
        return !talk_to_wydin.taskCompleted();
    }

    @Override
    public int execute() {

        return talk_to_wydin.execute();
    }
}