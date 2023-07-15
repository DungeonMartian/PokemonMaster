package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.unique.ExpertiseAction;
import com.megacrit.cardcrawl.actions.utility.ScryAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class EspeonGX extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "EspeonGX",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 2;
    private static final int UPG_MAGIC= 4;




    public EspeonGX() {
        super(cardInfo);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.PSYCHIC);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.EVOLVED);


    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DiscardAction(p,p,2,false));
        addToBot(new ScryAction(magicNumber));
        addToBot(new ExpertiseAction(p,6));

        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new EspeonGX();
    }
}

