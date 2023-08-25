package pokemonmaster.Events;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.events.AbstractImageEvent;
import com.megacrit.cardcrawl.localization.EventStrings;
import pokemonmaster.PokemonMasterMod;

public class BirdMan extends AbstractImageEvent {
    public static final String ID = PokemonMasterMod.makeID("BirdMan");
    private static final EventStrings eventStrings = CardCrawlGame.languagePack.getEventString(ID);
    private static final String[] DESCRIPTIONS = eventStrings.DESCRIPTIONS;
    private static final String[] OPTIONS = eventStrings.OPTIONS;
    private static final String INTRO_2_MSG = DESCRIPTIONS[1];
    private static final String LEAVE_MSG = DESCRIPTIONS[2];
    private static final String title = DESCRIPTIONS[0];
    private CurScreen screen = CurScreen.INTRO_1;
    private enum CurScreen {
        INTRO_1, ASK, COMPLETE
    }
    public BirdMan(String title, String body, String imgUrl) {
        super(title, body, imgUrl);
        this.imageEventText.setDialogOption(OPTIONS[0]);
        this.imageEventText.setDialogOption(OPTIONS[1]);
    }


    @Override
    protected void buttonEffect(int i) {

    }
    private void obtainReward(int slot) {

    }
    private void setLeave() {
        this.imageEventText.updateBodyText(LEAVE_MSG);
        this.imageEventText.clearAllDialogs();
        this.imageEventText.setDialogOption(OPTIONS[8]);
        this.screen = CurScreen.COMPLETE;
    }
}
