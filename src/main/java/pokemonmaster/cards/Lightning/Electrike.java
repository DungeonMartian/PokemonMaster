package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Electrike extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Electrike",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int DRAW = 1;


    public Electrike() {
        super(cardInfo,new Manectric(),new Manectric(),CustomTags.LIGHTNING);

        setMagic(DRAW);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillLightning.png","pokemonmaster/character/cardback/bg_skillLightning_p.png");


    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DrawCardAction(magicNumber));
        if (this.upgraded) {
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(new Electrike(),1));
        }


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Electrike();
    }
}

