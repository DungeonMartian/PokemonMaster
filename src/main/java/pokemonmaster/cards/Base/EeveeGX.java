package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.BetterDrawPileToHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class EeveeGX extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "EeveeGX",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.BASIC,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int EEVEESEEK = 2;
    private static final int EEVEEUP = 1;




    public EeveeGX() {
        super(cardInfo);
        this.exhaust = true;
        tags.add(CustomTags.SPECIALEVOLVE);
        tags.add(CustomTags.EEVEE);
        tags.add(CustomTags.POKEMON);
        setMagic(EEVEESEEK, EEVEEUP);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new BetterDrawPileToHandAction(this.magicNumber,true));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));



            }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new EeveeGX();
    }
}

