package pokemonmaster.cards.Base;

import com.evacipated.cardcrawl.mod.stslib.actions.common.FetchAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import java.util.function.Predicate;

import static pokemonmaster.CustomTags.POKEMON;
import static pokemonmaster.PokemonMasterMod.makeID;

public class UltraBall extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "UltraBall",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DISCARD = 2;
    private static final int DISCARDUP = -1;



    public UltraBall() {
        super(cardInfo);
        this.exhaust = true;
        tags.add(CustomTags.BAIT);
        this.misc = 50;
        setMagic(DISCARD, DISCARDUP);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DiscardAction(p, p, this.magicNumber, false));
        addToBot(new FetchAction(p.drawPile,(Predicate<AbstractCard>) card -> card.hasTag(POKEMON),1, abstractCards -> {



        }));

            }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new UltraBall();
    }
}

