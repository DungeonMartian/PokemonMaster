package pokemonmaster.cards.Grass;

import com.evacipated.cardcrawl.mod.stslib.actions.common.FetchAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Slimed;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import java.util.function.Predicate;

import static pokemonmaster.CustomTags.*;
import static pokemonmaster.PokemonMasterMod.makeID;

public class NetBall extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "NetBall",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);




    public NetBall() {
        super(cardInfo);
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {


        addToBot(new FetchAction(p.drawPile, card -> (card.hasTag(WATER) || card.hasTag(GRASS)) && card.hasTag(UNEVOLVED), 1, abstractCards -> {
        }));
        if (!upgraded) {
            addToBot(new MakeTempCardInHandAction(new Slimed(), 1));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new NetBall();
    }
}

