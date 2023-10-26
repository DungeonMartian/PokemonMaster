package pokemonmaster.cards.StarterRelic.Act1;

import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.actions.watcher.PressEndTurnButtonAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.MonsterStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AngerPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GremlinNob extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GremlinNob",
            2,
            CardType.POWER,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int ANGER = 1;
    private static final MonsterStrings monsterStrings = CardCrawlGame.languagePack.getMonsterStrings("GremlinNob");
    public static final String[] DIALOG = monsterStrings.DIALOG;


    public GremlinNob() {
        super(cardInfo);
        setMagic(ANGER);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        playSfx();
        AbstractDungeon.actionManager.addToBottom(new TalkAction(true, GremlinNob.DIALOG[0], 1.0F, 3.0F));
        addToBot(new ApplyPowerAction(p, p, new AngerPower(p, magicNumber)));
        if (!this.upgraded){
            addToBot(new PressEndTurnButtonAction());
        }

    }
    private void playSfx() {
        int roll = MathUtils.random(2);
        if (roll == 0) {
            AbstractDungeon.actionManager.addToBottom(new SFXAction("VO_GREMLINNOB_1A"));
        } else if (roll == 1) {
            AbstractDungeon.actionManager.addToBottom(new SFXAction("VO_GREMLINNOB_1B"));
        } else {
            AbstractDungeon.actionManager.addToBottom(new SFXAction("VO_GREMLINNOB_1C"));
        }
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new GremlinNob();
    }
}

