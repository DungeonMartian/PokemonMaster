package pokemonmaster.Events;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.AbstractImageEvent;
import com.megacrit.cardcrawl.localization.EventStrings;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndObtainEffect;
import pokemonmaster.PokemonMasterMod;
import pokemonmaster.cards.Water.SuperRod;

public class FisherMan extends AbstractImageEvent {
    public static final String ID = PokemonMasterMod.makeID("FisherMan");

    private static final EventStrings eventStrings = CardCrawlGame.languagePack.getEventString(ID);

    private static final String NAME = eventStrings.NAME;

    private static final String[] DESCRIPTIONS = eventStrings.DESCRIPTIONS;

    private static final String[] OPTIONS = eventStrings.OPTIONS;

    public static final String IMG = PokemonMasterMod.makeEventPath("FisherMan.png");
    private final AbstractCard obtainCard = new SuperRod();
    private int screenNum = 0;

    public FisherMan() {
        super(NAME, DESCRIPTIONS[0], IMG);
        this.imageEventText.updateDialogOption(0, OPTIONS[1]+ " " +this.obtainCard);
        this.imageEventText.setDialogOption(OPTIONS[1]);

    }

    protected void buttonEffect(int i) {
        switch (this.screenNum) {
            case 0:
                switch (i) {
                    case 0:
                        this.imageEventText.updateBodyText(DESCRIPTIONS[1]);
                        this.imageEventText.updateDialogOption(1, OPTIONS[1]+ " " +this.obtainCard);
                        this.imageEventText.clearRemainingOptions();
                        this.screenNum = 1;
                        AbstractDungeon.effectList.add(new ShowCardAndObtainEffect(new SuperRod(), Settings.WIDTH / 2.0F + 350.0F * Settings.xScale, Settings.HEIGHT / 2.0F));
                        break;
                    case 1:
                        this.imageEventText.updateBodyText(DESCRIPTIONS[2]);
                        this.imageEventText.updateDialogOption(0, OPTIONS[1]);
                        this.imageEventText.clearRemainingOptions();
                        this.screenNum = 1;
                        break;
                }
                break;
            case 1:
                switch (i) {
                    case 0:
                        openMap();
                        break;
                }
                break;
        }
    }
}
