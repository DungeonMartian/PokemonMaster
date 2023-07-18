package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.ChoiceCards.Collect;
import pokemonmaster.cards.ChoiceCards.ElectricBall;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import java.util.ArrayList;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Manectric extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Manectric",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int DRAW = 3;


    public Manectric() {
        super(cardInfo,CustomTags.LIGHTNING);

        setMagic(DRAW);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillLightning.png","pokemonmaster/character/cardback/bg_skillLightning_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCard> ATTACKA = new ArrayList<>();
        ATTACKA.add(new Collect());
        ElectricBall machClaw = new ElectricBall();
        machClaw.calculateCardDamage(m);
        machClaw.applyPowers();
        ATTACKA.add(machClaw);
        addToBot(new ChooseOneAction(ATTACKA));

        if (this.upgraded) {
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(new Electrike(),1));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Manectric();
    }
}

