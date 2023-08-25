package pokemonmaster.Events;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.events.AbstractImageEvent;
import com.megacrit.cardcrawl.localization.EventStrings;
import pokemonmaster.PokemonMasterMod;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class EeveeEvolve extends AbstractImageEvent {

    //This isn't technically needed but it becomes useful later
    public static final String ID = PokemonMasterMod.makeID("EeveeEvolve");
    private static final EventStrings eventStrings = CardCrawlGame.languagePack.getEventString(ID);
    private static final String[] DESCRIPTIONS = eventStrings.DESCRIPTIONS;
    private static final String[] OPTIONS = eventStrings.OPTIONS;
    private static final String title = DESCRIPTIONS[0];
    public EeveeEvolve() {
        super(ID, title, "img/events/eventpicture.png");
        Random randNum = new Random();
        randNum.setSeed(Settings.seed);
        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < 2) {
            set.add(randNum.nextInt(2) + 1);
        }
        for (int s : set) {
            if (s == 1) {
                this.imageEventText.setDialogOption(OPTIONS[Integer.valueOf(s)]);
            }
        }
        for (int t : set) {
            if (t == 2) {
                this.imageEventText.setDialogOption(OPTIONS[Integer.valueOf(t)]);
            }
        }
        this.imageEventText.setDialogOption(OPTIONS[8]);

    }
    @Override
    protected void buttonEffect(int buttonPressed) {
        //It is best to look at examples of what to do here in the basegame event classes, but essentially when you click on a dialog option the index of the pressed button is passed here as buttonPressed.


    }
}